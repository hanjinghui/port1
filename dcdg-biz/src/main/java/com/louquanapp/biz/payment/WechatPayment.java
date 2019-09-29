package com.louquanapp.biz.payment;


import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.OrderBiz;
import com.louquanapp.biz.payment.abs.BasePayment;
import com.louquanapp.biz.payment.abs.PaymentContext;
import com.louquanapp.biz.payment.abs.Validator;
import com.louquanapp.biz.payment.channel.wechatpay.WeChatBuildRequest;
import com.louquanapp.biz.payment.commons.HttpClientUtil;
import com.louquanapp.biz.payment.constants.PayChannelEnum;
import com.louquanapp.biz.payment.constants.PaymentConstants;
import com.louquanapp.biz.payment.constants.WechatPaymentConfig;
import com.louquanapp.biz.payment.context.WechatPaymentContext;
import com.louquanapp.dao.model.OrderPay;
import com.louquanapp.service.abs.AbstractRequest;
import com.louquanapp.service.abs.AbstractResponse;
import com.louquanapp.service.abs.PayReturnCodeEnum;
import com.louquanapp.service.dto.PaymentNotifyRequest;
import com.louquanapp.service.dto.PaymentNotifyResponse;
import com.louquanapp.service.dto.PaymentRequest;
import com.louquanapp.service.dto.PaymentResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
@Service
public class WechatPayment extends BasePayment {

    Logger LOG = LoggerFactory.getLogger(WechatPayment.class);

    @Autowired
    WechatPaymentConfig wechatPaymentConfig;

    @Resource(name = "wechatPaymentValidator")
    private Validator validator;
    @Autowired
    private OrderBiz orderBiz;

    @Override
    public Validator getValidator() {
        return validator;
    }

    @Override
    public PaymentContext createContext(AbstractRequest request) {
        WechatPaymentContext wechatPaymentContext = new WechatPaymentContext();
        PaymentRequest paymentRequest = (PaymentRequest) request;
        wechatPaymentContext.setProductId(paymentRequest.getTradeNo());
        wechatPaymentContext.setSpbillCreateIp("47.106.133.97");
        wechatPaymentContext.setTradeType(PaymentConstants.TradeTypeEnum.APP.getType());
        wechatPaymentContext.setTotalFee(paymentRequest.getOrderFee());
        wechatPaymentContext.setOutTradeNo(paymentRequest.getTradeNo());
        wechatPaymentContext.setBody(paymentRequest.getSubject());
        return wechatPaymentContext;
    }

    @Override
    public void prepare(AbstractRequest request, PaymentContext context) throws HuhuaminException {

        WechatPaymentContext wechatPaymentContext = (WechatPaymentContext) context;
        SortedMap<Object, Object> paraMap = new TreeMap<>();
        paraMap.put("body", wechatPaymentContext.getBody() == null ? "" : wechatPaymentContext.getBody());
        paraMap.put("out_trade_no", wechatPaymentContext.getOutTradeNo());
        paraMap.put("total_fee", wechatPaymentContext.getTotalFee().intValue());//单位分
        paraMap.put("spbill_create_ip", wechatPaymentContext.getSpbillCreateIp());
        paraMap.put("appid", wechatPaymentConfig.getWechatAppid());
        paraMap.put("mch_id", wechatPaymentConfig.getWechatMch_id());
        paraMap.put("nonce_str", WeChatBuildRequest.getNonceStr());
        paraMap.put("trade_type", wechatPaymentContext.getTradeType());
        paraMap.put("product_id", wechatPaymentContext.getProductId());
        paraMap.put("device_info", "WEB");
        paraMap.put("notify_url", wechatPaymentConfig.getWechatNotifyurl());// 此路径是微信服务器调用支付结果通知路径
        String sign = WeChatBuildRequest.createSign(paraMap, wechatPaymentConfig.getWechatMchsecret());
        paraMap.put("sign", sign);
        String xml = WeChatBuildRequest.getRequestXml(paraMap);
        wechatPaymentContext.setXml(xml);
        //TODO 保存订单记录, 由于微信是属于预提交请求，需要对当前交易做幂等性，还需要控制二维码的时效
    }


    @Override
    public AbstractResponse generalProcess(AbstractRequest request, PaymentContext context) throws HuhuaminException {
        PaymentResponse response = new PaymentResponse();

        WechatPaymentContext wechatPaymentContext = (WechatPaymentContext) context;

        String xmlStr = HttpClientUtil.httpPost(wechatPaymentConfig.getWechatUnifiedOrder(), wechatPaymentContext.getXml());
        LOG.info("wechatPayment. generalProcess response：" + xmlStr);
        Map<String, String> resultMap = WeChatBuildRequest.doXMLParse(xmlStr);
        if ("SUCCESS".equals(resultMap.get("return_code"))) {
            if ("SUCCESS".equals(resultMap.get("result_code"))) {
                //表示订单处理成功
                response.setPrepayId(resultMap.get("prepay_id"));
                response.setCodeUrl(resultMap.get("mweb_url"));
                response.setCode(PayReturnCodeEnum.SUCCESS.getCode());
                response.setMsg(PayReturnCodeEnum.SUCCESS.getMsg());
            } else {
                String errMsg = resultMap.get("err_code") + ":" + resultMap.get("err_code_des");
                response.setCode(PayReturnCodeEnum.PAYMENT_PROCESSOR_FAILED.getCode());
                response.setMsg(PayReturnCodeEnum.PAYMENT_PROCESSOR_FAILED.getMsg(errMsg));
            }
        } else {
            response.setCode(PayReturnCodeEnum.PAYMENT_PROCESSOR_FAILED.getCode());
            response.setMsg(PayReturnCodeEnum.PAYMENT_PROCESSOR_FAILED.getMsg(resultMap.get("return_msg")));
        }
        return response;
    }

    @Override
    public void afterProcess(AbstractRequest request, AbstractResponse response, PaymentContext context) throws HuhuaminException {

    }

    @Override
    public String getPayChannel() {
        return PayChannelEnum.WECHAT_PAY.getCode();
    }

    @Override
    public AbstractResponse completePayment(AbstractRequest request) throws HuhuaminException {
        PaymentNotifyRequest paymentNotifyRequest = (PaymentNotifyRequest) request;
        PaymentNotifyResponse response = new PaymentNotifyResponse();
        SortedMap<Object, Object> paraMap = new TreeMap<>();
        Map<String, String> resultMap = paymentNotifyRequest.getResultMap();
        for (Iterator iter = resultMap.keySet().iterator(); iter.hasNext(); ) {
            String name = iter.next().toString();
            String value = resultMap.get(name);
            paraMap.put(name, value);
        }
        //组装返回的结果的签名字符串
        String rsSign = resultMap.remove("sign");
        String sign = WeChatBuildRequest.createSign(paraMap, wechatPaymentConfig.getWechatMchsecret());
        if (rsSign.equals(sign)) { //验证签名
            //SUCCESS、FAIL
            String resultCode = resultMap.get("result_code");//返回结果
            if ("SUCCESS".equals(resultCode)) {
                //TODO 更新交易表的交易结果
                String outTradeNo = resultMap.get("out_trade_no");
                String serialNo = resultMap.get("transaction_id");
                String total_amount = resultMap.get("total_fee");

                try {
                    JsonResult jsonResult = orderBiz.doOrderPaySuccess(outTradeNo, serialNo, paymentNotifyRequest.getXml(), Double.valueOf(total_amount), 0.00, 0.00, 2, 4,2);
                    if (jsonResult.getStatusCode()) {
                        response.setResult(WeChatBuildRequest.setXML("SUCCESS", "OK"));

                        OrderPay orderPay=new OrderPay();
                        orderPay.setOrderNo(outTradeNo);
                        orderPay.setPayStatus((byte)2);
                        orderPay.setAfterTime(new Date());

                        orderBiz.updateOrderpay(orderPay);

                    } else {
                        orderBiz.addStockCount(outTradeNo);
                        response.setResult(WeChatBuildRequest.setXML("FAIL", "NO"));
                    }
                } catch (Exception e) {
                    orderBiz.addStockCount(outTradeNo);
                    response.setResult(WeChatBuildRequest.setXML("FAIL", "NO"));
                }
                //response.setResult(WeChatBuildRequest.setXML("SUCCESS", "OK"));
            } else {
                String outTradeNo = resultMap.get("out_trade_no");
                if(StringUtils.isNotBlank(outTradeNo)){
                    orderBiz.addStockCount(outTradeNo);
                }

                //TODO 更新交易表交易结果为失败，交易失败，微信端不需要知道我们的处理结果
                response.setResult(WeChatBuildRequest.setXML("FAIL", "NO"));
            }
        } else {
            String outTradeNo = resultMap.get("out_trade_no");
            if(StringUtils.isNotBlank(outTradeNo)){
                orderBiz.addStockCount(outTradeNo);
            }
            throw new HuhuaminException("微信返回结果签名验证失败");
        }
        return response;
    }
}
