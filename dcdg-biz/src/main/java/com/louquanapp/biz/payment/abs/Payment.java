package com.louquanapp.biz.payment.abs;


import com.huhuamin.common.HuhuaminException;

import com.louquanapp.service.abs.AbstractRequest;
import com.louquanapp.service.abs.AbstractResponse;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public interface Payment {

    /**
     * 发起交易执行的过程
     *
     * @param request
     * @return
     * @throws
     */
    AbstractResponse process(AbstractRequest request) throws HuhuaminException;

    /**
     * 完成交易结果的处理
     *
     * @param request
     * @return
     * @throws HuhuaminException
     */
    AbstractResponse completePayment(AbstractRequest request) throws HuhuaminException;
}
