package com.louquanapp.biz.payment.abs;


import com.louquanapp.service.abs.AbstractRequest;

/**
 * 数据验证接口类
 */
public interface Validator {

    void validate(AbstractRequest request);
}
