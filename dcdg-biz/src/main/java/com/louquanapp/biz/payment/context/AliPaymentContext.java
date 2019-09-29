package com.louquanapp.biz.payment.context;




import com.louquanapp.biz.payment.abs.PaymentContext;

import java.util.Map;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 * 支付宝支付的上下文信息
 */
public class AliPaymentContext extends PaymentContext {

    Map<String, String> sParaTemp;

    private String subject;//商品名称（必填）


    public Map<String, String> getsParaTemp() {
        return sParaTemp;
    }

    public void setsParaTemp(Map<String, String> sParaTemp) {
        this.sParaTemp = sParaTemp;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
