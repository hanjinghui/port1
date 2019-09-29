package com.louquanapp.biz.payment.validator;



import com.huhuamin.common.HuhuaminException;
import com.louquanapp.biz.payment.abs.BaseValidator;
import com.louquanapp.service.abs.AbstractRequest;
import com.louquanapp.service.dto.PaymentRequest;
import org.springframework.stereotype.Service;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
@Service("wechatPaymentValidator")
public class WechatPaymentValidator extends BaseValidator {

    @Override
    public void validate(AbstractRequest request) {
        if(request==null){
            throw new HuhuaminException("请求参数为空");
        }
        PaymentRequest paymentRequest=(PaymentRequest)request;

    }
}
