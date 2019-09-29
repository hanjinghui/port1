package com.louquanapp.biz.payment;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.Arith;
import com.louquanapp.biz.OrderBiz;
import com.louquanapp.biz.payment.abs.BasePayment;
import com.louquanapp.biz.payment.abs.PaymentContext;
import com.louquanapp.biz.payment.abs.Validator;
import com.louquanapp.biz.payment.channel.alipay.AlipayNotify;
import com.louquanapp.biz.payment.constants.AliPaymentConfig;
import com.louquanapp.biz.payment.constants.PayChannelEnum;
import com.louquanapp.biz.payment.context.AliPaymentContext;
import com.louquanapp.service.abs.AbstractRequest;
import com.louquanapp.service.abs.AbstractResponse;
import com.louquanapp.service.abs.PayReturnCodeEnum;
import com.louquanapp.service.dto.PaymentNotifyRequest;
import com.louquanapp.service.dto.PaymentNotifyResponse;
import com.louquanapp.service.dto.PaymentRequest;
import com.louquanapp.service.dto.PaymentResponse;
import com.louquanapp.utils.BizUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
@Service
public class AliPayment extends BasePayment {

    Logger LOG = LoggerFactory.getLogger(AliPayment.class);

    @Resource(name = "aliPaymentValidator")
    private Validator validator;

    @Autowired
    AliPaymentConfig aliPaymentConfig;
    @Autowired
    private OrderBiz orderBiz;

    @Override
    public Validator getValidator() {
        return validator;
    }

    @Override
    public PaymentContext createContext(AbstractRequest request) {
        AliPaymentContext aliPaymentContext = new AliPaymentContext();
        PaymentRequest paymentRequest = (PaymentRequest) request;
        aliPaymentContext.setSubject(paymentRequest.getSubject());
        aliPaymentContext.setOutTradeNo(paymentRequest.getTradeNo());
        aliPaymentContext.setTotalFee(paymentRequest.getTotalFee());
        return aliPaymentContext;
    }

    @Override
    public void prepare(AbstractRequest request, PaymentContext context) throws HuhuaminException {
//        Map<String, String> sParaTemp = new LinkedHashMap<>();
//        AliPaymentContext aliPaymentContext = (AliPaymentContext) context;
//        sParaTemp.put("partner", aliPaymentConfig.getAli_partner());
//        sParaTemp.put("seller_id", aliPaymentConfig.getSeller_id());
//
//        sParaTemp.put("out_trade_no", aliPaymentContext.getOutTradeNo());
//        sParaTemp.put("subject", aliPaymentContext.getSubject().trim());
//        sParaTemp.put("body", aliPaymentContext.getSubject().trim());
//        sParaTemp.put("total_fee", BizUtils.saveTwoPoint(Arith.div(aliPaymentContext.getTotalFee().doubleValue(), 100, 2)));
//        sParaTemp.put("notify_url", aliPaymentConfig.getNotify_url());
//        sParaTemp.put("service", aliPaymentConfig.getAli_service());
//        sParaTemp.put("payment_type", "1");
//        sParaTemp.put("_input_charset", aliPaymentConfig.getInput_charset());
//        sParaTemp.put("it_b_pay", aliPaymentConfig.getIt_b_pay());
//        sParaTemp.put("return_url", aliPaymentConfig.getReturn_url());
//        aliPaymentContext.setsParaTemp(sParaTemp);
        //TODO 保存订单记录

    }


    @Override
    public AbstractResponse generalProcess(AbstractRequest request, PaymentContext context) throws HuhuaminException {


        AliPaymentContext aliPaymentContext = (AliPaymentContext) context;


        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", aliPaymentConfig.getAppId(), aliPaymentConfig.getPrivate_key(), "json", aliPaymentConfig.getInput_charset(), aliPaymentConfig.getPublic_key(), "RSA2");
//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest requestA = new AlipayTradeAppPayRequest();
//SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody("buy" + aliPaymentContext.getOutTradeNo());
        model.setSubject("buy" + aliPaymentContext.getOutTradeNo());
        model.setOutTradeNo(aliPaymentContext.getOutTradeNo());
        model.setTimeoutExpress("30m");
        model.setTotalAmount(BizUtils.saveTwoPoint(Arith.div(aliPaymentContext.getTotalFee().doubleValue(), 100, 2)));
        model.setProductCode("QUICK_MSECURITY_PAY");
        requestA.setBizModel(model);
        requestA.setNotifyUrl(aliPaymentConfig.getNotify_url());
        PaymentResponse response = new PaymentResponse();
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute

            AlipayTradeAppPayResponse responseA = alipayClient.sdkExecute(requestA);

            response.setPayJson(responseA.getBody());
            response.setCode(PayReturnCodeEnum.SUCCESS.getCode());
            response.setMsg(PayReturnCodeEnum.SUCCESS.getMsg());
            System.out.println(responseA.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public void afterProcess(AbstractRequest request, AbstractResponse respond, PaymentContext context) throws HuhuaminException {

    }

    @Override
    public String getPayChannel() {
        return PayChannelEnum.ALI_PAY.getCode();
    }

    @Override
    public AbstractResponse completePayment(AbstractRequest request) throws HuhuaminException {
        PaymentNotifyRequest paymentNotifyRequest = (PaymentNotifyRequest) request;
        Map<String, String> params = new HashMap<>();
        Map requestParams = paymentNotifyRequest.getResultMap();
        PaymentNotifyResponse response = new PaymentNotifyResponse();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }


        if (AlipayNotify.verify(params, aliPaymentConfig)) {//验证成功
            //TODO 判断交易状态
            //TRADE_FINISH(支付完成)、TRADE_SUCCESS(支付成功)、FAIL(支付失败)
            String tradeStatus = params.get("trade_status").toString();
            if ("TRADE_SUCCESS".equalsIgnoreCase(tradeStatus) || "TRADE_SUCCESS".equalsIgnoreCase(tradeStatus)) {
                String outTradeNo = params.get("out_trade_no").toString();
                String serialNo = params.get("trade_no").toString();
                String total_amount = params.get("total_amount").toString();

                JsonResult jsonResult = orderBiz.doOrderPaySuccess(outTradeNo, serialNo, paymentNotifyRequest.getXml(), Double.valueOf(total_amount),null,null,2,7,2);
                if (jsonResult.getStatusCode()) {
                    response.setResult("success");
                } else {
                    response.setResult("fail");

                }
            } else {
                response.setResult("fail");
            }

            //TODO 更新交易表的交易状态
            response.setResult("success");
        } else {
            throw new HuhuaminException("支付宝签名验证失败");
        }
        response.setResult("fail");
        return response;
    }
}
