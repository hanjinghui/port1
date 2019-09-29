package com.louquanapp.service;



import com.louquanapp.biz.payment.abs.BasePayment;
import com.louquanapp.service.dto.PaymentNotifyRequest;
import com.louquanapp.service.dto.PaymentNotifyResponse;
import com.louquanapp.service.dto.PaymentRequest;
import com.louquanapp.service.dto.PaymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
@Service("payService")
public class TransactionPayServiceImpl implements TransactionPayService {

    private final Logger Log = LoggerFactory.getLogger(TransactionPayServiceImpl.class);


    @Override
    public PaymentResponse execPay(PaymentRequest request) {
        PaymentResponse paymentResponse = new PaymentResponse();
        try {
            paymentResponse = (PaymentResponse) BasePayment.paymentMap.
                    get(request.getPayChannel()).process(request);
            //TODO 发送消息通知，可以通知清结算这边记录交易、或者通知营销平台发放优惠券
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("execPay occur exception:" + e);
            paymentResponse.setCode("700");
            paymentResponse.setMsg(e.getMessage());
        } finally {
            Log.info("execPay return result:" + paymentResponse);
        }
        return paymentResponse;
    }

    /**
     * 支付结果回调
     *
     * @param request
     * @return
     */
    @Override
    public PaymentNotifyResponse paymentResultNotify(PaymentNotifyRequest request) {
        Log.info("paymentResultNotify request:" + request);
        PaymentNotifyResponse response = new PaymentNotifyResponse();
        try {
            response = (PaymentNotifyResponse) BasePayment.paymentMap.
                    get(request.getPayChannel()).completePayment(request);
            //发送消息

        } catch (Exception e) {
            Log.error("paymentResultNotify occur exception:" + e);

            response.setCode("700");
            response.setMsg(e.getMessage());
        } finally {
            Log.info("paymentResultNotify return result:" + response);
        }
        return response;
    }
}
