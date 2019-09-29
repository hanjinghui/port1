package com.louquanapp.web.order.api;


import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.Arith;
import com.louquanapp.biz.OrderBiz;
import com.louquanapp.biz.payment.channel.wechatpay.WeChatBuildRequest;
import com.louquanapp.biz.payment.constants.WechatPaymentConfig;
import com.louquanapp.dao.model.Order;
import com.louquanapp.dao.model.OrderPay;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqDoMeishiOrder;
import com.louquanapp.req.ReqDoOrder;
import com.louquanapp.req.ReqPayOrder;
import com.louquanapp.resp.RespOrder;
import com.louquanapp.service.JedisService;
import com.louquanapp.service.TransactionPayService;
import com.louquanapp.service.dto.PaymentNotifyRequest;
import com.louquanapp.service.dto.PaymentNotifyResponse;
import com.louquanapp.service.dto.PaymentRequest;
import com.louquanapp.service.dto.PaymentResponse;
import com.louquanapp.utils.WebServletUtil;
import com.louquanapp.web.customer.api.AuthCustomerApi;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import weixin.popular.bean.paymch.MchPayApp;
import weixin.popular.util.SignatureUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


@RestController
@RequestMapping("/api")
public class PayController {

    private final JedisService jedisService;
    private final OrderBiz orderBiz;
    private final TransactionPayService payService;

    private static final Object lock = new Object();


    private final Logger logger = LoggerFactory.getLogger(PayController.class);

    public PayController(JedisService jedisService, OrderBiz orderBiz, TransactionPayService payService) {
        this.jedisService = jedisService;
        this.orderBiz = orderBiz;
        this.payService = payService;
    }


    @PostMapping("/auth/doOrder")
    public JsonResult doOrder(@RequestBody @Valid ReqDoOrder reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
//        return null;
        return orderBiz.doOrder(reqSource, custId);
    }


    @Autowired
    private WechatPaymentConfig wechatPaymentConfig;
    //    @Autowired
//    AliPaymentConfig aliPaymentConfig;
    @Value("${off_line}")
    private boolean off_line;


    @PostMapping("/auth/execPay")
    public TypeJsonResult<RespOrder> execPay(HttpServletRequest request, @RequestBody @Valid ReqPayOrder reqSource, BindingResult bindingResult) {
        synchronized (lock) {
            TypeJsonResult jsonResult = new TypeJsonResult();
            jsonResult.setStatusCode(false);
            String custId = jedisService.getCustIdByToken(reqSource.getToken());
            if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;


            TypeJsonResult<RespOrder> typeJsonResult = orderBiz.execPay(reqSource, custId);
            if (!typeJsonResult.getStatusCode()) {
                return typeJsonResult;
            }
            Double ordreFee = 0.01;
            PaymentRequest payServiceRequest = new PaymentRequest();
            if (!off_line) {
                ordreFee = typeJsonResult.getType().getEndPayMoney();
                if(null==ordreFee){
                    ordreFee=0d;
                }

            }
            Integer realFen = Double.valueOf(Arith.mul(ordreFee, 100)).intValue();
            String payWayCode = "";
            if (reqSource.getPayType().intValue() == 1) {
                payWayCode = "alipay";
            } else if (reqSource.getPayType().intValue() == 2) {
                payWayCode = "wechat_pay";
            }
            if (realpay(request, jsonResult, typeJsonResult.getType().getOrderNo(), payServiceRequest, realFen, payWayCode, reqSource.getPayType()))
                return jsonResult;

            jsonResult.setStatusCode(true);
            return jsonResult;
        }

    }


    @PostMapping("/auth/test")
    public TypeJsonResult<RespOrder> test(HttpServletRequest request, @RequestBody @Valid ReqPayOrder reqSource, BindingResult bindingResult) {

           TypeJsonResult jsonResult = new TypeJsonResult();
            jsonResult.setStatusCode(false);
            //"20190620173001k26ILwYo"
           /*  String outTradeNo=reqSource.getOrderIds();
        if((reqSource.getPayType()+"").contains("1")){
            OrderPay orderPay=new OrderPay();
            orderPay.setOrderNo(outTradeNo);
            orderPay.setPayStatus((byte)1);
            orderPay.setBeforeTime(new Date());
            orderPay.setDeductionStockTime(new Date());

            orderBiz.addOrderpay(orderPay);
        }

            if((reqSource.getPayType()+"").contains("2")){
                OrderPay orderPay=new OrderPay();
                orderPay.setOrderNo(outTradeNo);
                orderPay.setPayStatus((byte)2);
                orderPay.setAfterTime(new Date());

                orderBiz.updateOrderpay(orderPay);
            }

            if((reqSource.getPayType()+"").contains("3")){
                orderBiz.addStockCount(outTradeNo);
            }*/

            jsonResult.setStatusCode(true);
            return jsonResult;


    }


    @PostMapping("/auth/execMeishiPay")
    public TypeJsonResult<String> execMeishiPay(HttpServletRequest request, @RequestBody @Valid ReqDoMeishiOrder reqSource, BindingResult bindingResult) {
        synchronized (lock) {
            TypeJsonResult typeJsonResult = new TypeJsonResult();
            typeJsonResult.setStatusCode(false);
            String custId = jedisService.getCustIdByToken(reqSource.getToken());
            if (AuthCustomerApi.tokenDie(typeJsonResult, custId)) return typeJsonResult;


             typeJsonResult = orderBiz.execMeiShiPay(reqSource, custId,reqSource.getToken());
            if (!typeJsonResult.getStatusCode()) {
                return typeJsonResult;
            }

//            Double ordreFee = 0.01;
//            PaymentRequest payServiceRequest = new PaymentRequest();
//            if (!off_line) {
//                ordreFee = typeJsonResult.getType().getOrderFee();
//
//            }
//            Integer realFen = Double.valueOf(Arith.mul(ordreFee, 100)).intValue();
//            String payWayCode = "";
//            if (reqSource.getPayType().intValue() == 1) {
//                payWayCode = "alipay";
//            } else if (reqSource.getPayType().intValue() == 2) {
//                payWayCode = "wechat_pay";
//            }
//            if (realpay(request, jsonResult, typeJsonResult.getType().getOrderNo(), payServiceRequest, realFen, payWayCode, reqSource.getPayType()))
//                return jsonResult;

            typeJsonResult.setStatusCode(true);
            return typeJsonResult;
        }

    }

    private boolean realpay(HttpServletRequest request, TypeJsonResult jsonResult, String orderNo, PaymentRequest payServiceRequest, Integer realFen, String payWayCode, Byte payType) {

        if (StringUtils.isNotEmpty(payWayCode)) {
            payServiceRequest.setPayChannel(payWayCode);
            payServiceRequest.setSpbillCreateIp(WebServletUtil.getClientIpAddr(request));
            payServiceRequest.setSubject("搂圈订单:"+orderNo);

            payServiceRequest.setTotalFee(realFen);
            payServiceRequest.setOrderFee(realFen);
            payServiceRequest.setTradeNo(orderNo);
            payServiceRequest.setUserId(1);//(Integer.parseInt(getUid()));


           //
            Date data=new Date();
        OrderPay orderPay=new OrderPay();
        orderPay.setOrderNo(orderNo);
        orderPay.setPayStatus((byte)1);
        orderPay.setBeforeTime(data);
        orderPay.setDeductionStockTime(data);

        if(orderBiz.addOrderpay(orderPay)){
            PaymentResponse payServiceResponse = payService.execPay(payServiceRequest);

            if (payServiceResponse.getCode().equals("000000")) {
                jsonResult.setStatusCode(true);
                if (payType.intValue() == 2) {
                    MchPayApp mchPayApp = generateMchAppData(payServiceResponse.getPrepayId(), wechatPaymentConfig.getWechatAppid(), wechatPaymentConfig.getWechatMch_id(), wechatPaymentConfig.getWechatMchsecret());
                    jsonResult.setPayJson(mchPayApp);
                } else {
                    jsonResult.setPayJson(payServiceResponse.getPayJson());
                }

            } else {
                jsonResult.setStatusCode(false);
                jsonResult.setMessage(payServiceResponse.getCode() + "->" + payServiceResponse.getMsg());
                return true;
            }
        }else {
            throw new HuhuaminExceptionPlan("库存不足啦！");
        }

        }
        return false;
    }

    //
    public static MchPayApp generateMchAppData(String prepay_id, String appId, String partnerid, String key) {
        Map<String, String> wx_map = new LinkedHashMap<String, String>();
        wx_map.put("appid", appId);
        wx_map.put("partnerid", partnerid);
        wx_map.put("prepayid", prepay_id);
        wx_map.put("package", "Sign=WXPay");
        wx_map.put("noncestr", UUID.randomUUID().toString().replace("-", ""));
        wx_map.put("timestamp", System.currentTimeMillis() / 1000 + "");
        String sign = SignatureUtil.generateSign(wx_map, key);
        MchPayApp mchPayApp = new MchPayApp();
        mchPayApp.setAppid(appId);
        mchPayApp.setPartnerid(partnerid);
        mchPayApp.setPrepayid(prepay_id);
        mchPayApp.setPackage_(wx_map.get("package"));
        mchPayApp.setNoncestr(wx_map.get("noncestr"));
        mchPayApp.setTimestamp(wx_map.get("timestamp"));
        mchPayApp.setSign(sign);
        return mchPayApp;
    }

    @PostMapping("/test")
    public JsonResult test(HttpSession session) {
        return orderBiz.doOrderPaySuccess("20190416182313AoaJ84rS", "xxx", "<Body><Amount>" + 60.00d + "</Amount></Body>", 60.00d, null, null, 2, 4,2);
    }

    //
//
    @RequestMapping("/no/pay/wechatPayNotify")
    public void weChatPayNotify(HttpServletRequest request, HttpServletResponse response) {
        logger.info("begin - weChatPayNotify method");
        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();// 从request中取得输入流
            String xml = "";
            PaymentNotifyRequest paymentNotifyRequest = new PaymentNotifyRequest();
            Map<String, String> wechatResultMap = buildWxParam(inputStream, paymentNotifyRequest);//从输入流中获取微信回调结果

            paymentNotifyRequest.setPayChannel("wechat_pay");
            paymentNotifyRequest.setResultMap(wechatResultMap);

            PaymentNotifyResponse notifyResponse = payService.paymentResultNotify(paymentNotifyRequest);
            //告诉服务端消息处理的结果，避免不断的进行结果通知
            response.setContentType("text/xml");
            response.getWriter().print(notifyResponse.getResult());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //
//    @RequestMapping("/no/pay/alipayNotify")
//    public void aliPayNotify(HttpServletRequest request, HttpServletResponse response) {
//        logger.info("begin - aliPayNotify method");
//        try {
//            Map<String, String> alipayRequestParams = WebServletUtil.requestToMap(request);
//            logger.info("Alipay Json " + JSON.toJSONString(alipayRequestParams));
//            String json = JSON.toJSONString(alipayRequestParams);
////                    "{\"gmt_create\":\"2018-12-04 12:11:14\",\"charset\":\"UTF-8\",\"seller_email\":\"1256419449@qq.com\",\"subject\":\">专四高阶级课程测试3\",\"sign\":\"QkRw6z6hAVh2rNOHAEayBWt3K0bCQmub2aSDiicbrO7MfnCMx1FbKsBTfn9EuYZ/59GJstfbm4HAZuFwzuKcKlQmJnHfMl5V6gmsdgogVrFCTr5N9YefCHbSkX+g7Se7LuqmmYkS9o6xN7Axtj3+1tMiLwHgX7V6k+eiXgY+WZMIYNxtxN8JMIhlZL+CBMo+JIwknmrEdLEpus/I0GO2Of+iXU1PRGaql+CZIscCbQcUdu45mOoqoxYAONVo9S63kSXW+Kvk/6YDignAeJyaT5VmtqHaW81+j1L4fvil0cTVz76Djd4Q9Y2objXdHSq3x6iV3C+C5pefFHRAlOuJNA==\",\"body\":\"专四高阶级课程测>试3\",\"buyer_id\":\"2088402418370863\",\"invoice_amount\":\"0.01\",\"notify_id\":\"2018120400222121114070861033214092\",\"fund_bill_list\":\"[{\\\"amount\\\":\\\"0.01\\\",\\\"fundChannel\\\":\\\"PCREDIT\\\"}]\",\"notify_type\":\"trade_status_sync\",\"trade_status\":\"TRADE_SUCCESS\",\"receipt_amount\":\"0.01\",\"app_id\":\"2018110161929791\",\"buyer_pay_amount\":\"0.01\",\"sign_type\":\"RSA2\",\"seller_id\":\"2088902941740071\",\"gmt_payment\":\"2018-12-04 12:11:14\",\"notify_time\":\"2018-12-04 12:11:14\",\"version\":\"1.0\",\"out_trade_no\":\"20181204121111gNY1ho88\",\"total_amount\":\"0.01\",\"trade_no\":\"2018120422001470861011759135\",\"auth_app_id\":\"2018110161929791\",\"buyer_logon_id\":\"fef***@126.com\",\"point_amount\":\"0.00\"}\n";
//            alipayRequestParams = JSON.parseObject(json, Map.class);
//
//            boolean signVerified = true;
//            signVerified = AlipaySignature.rsaCheckV2(alipayRequestParams, aliPaymentConfig.getPublic_key2(), aliPaymentConfig.getInput_charset(), alipayRequestParams.get("sign_type"));
//            alipayRequestParams = JSON.parseObject(json, Map.class);
//
//            logger.info("signVerified 1 " + signVerified);
//            signVerified = AlipaySignature.rsaCheckV2(alipayRequestParams, aliPaymentConfig.getPublic_key(), aliPaymentConfig.getInput_charset(), alipayRequestParams.get("sign_type"));
//            logger.info("signVerified 2 " + signVerified);
//            signVerified = true;
//            //PaymentNotifyResponse notifyResponse = payService.paymentResultNotify(paymentNotifyRequest);
//            //告诉服务端消息处理的结果，避免不断的进行结果通知，此处就是使用的最大化重试的异步通知实现交易结果数据的一致性
//            if (signVerified) {
//                // TODO 验签成功后
//                //TODO 判断交易状态
//                //TRADE_FINISH(支付完成)、TRADE_SUCCESS(支付成功)、FAIL(支付失败)
//                String tradeStatus = alipayRequestParams.get("trade_status").toString();
//                if ("TRADE_SUCCESS".equalsIgnoreCase(tradeStatus) || "TRADE_SUCCESS".equalsIgnoreCase(tradeStatus)) {
//                    String outTradeNo = alipayRequestParams.get("out_trade_no").toString();
//                    String serialNo = alipayRequestParams.get("trade_no").toString();
//                    String total_amount = alipayRequestParams.get("total_amount").toString();
//                    Order custOrder = custOrderBiz.selectOrderStatusByOrderNo(outTradeNo);
//                    if (custOrder.getOrderStatus().intValue() == 101) {
//                        int result = custOrderBiz.updatePaySuccessByOrderNo(outTradeNo, serialNo, Double.valueOf(total_amount), custOrder);
//                        if (result == 1) {
//                            response.getWriter().print("success");
//                        } else {
//
//                            response.getWriter().print("fail");
//                        }
//                    }
//                } else {
//                    response.getWriter().print("fail");
//                }
//
//                //TODO 更新交易表的交易状态
//
//                //按照支付结果异步通知中的描述，对支付结果中的业务内容进行1\2\3\4二次校验，校验成功后在response中返回success，校验失败返回failure
//                response.getWriter().print("success");
//            } else {
//                // TODO 验签失败则记录异常日志，并在response中返回failure.
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
    private Map<String, String> buildWxParam(InputStream inputStream, PaymentNotifyRequest paymentNotifyRequest) throws IOException {
        // 从输入流读取返回内容
        InputStreamReader inputStreamReader = null;
        inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = null;
        StringBuffer buffer = new StringBuffer();
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
        }
        // 释放资源
        bufferedReader.close();
        inputStreamReader.close();
        String notify_lines = buffer.toString();
        paymentNotifyRequest.setXml(notify_lines);
        logger.info("微信支付回调返回值：" + notify_lines);
        Map<String, String> paramsMapFromXML = WeChatBuildRequest.doXMLParse(notify_lines);
        return paramsMapFromXML;
    }


}
