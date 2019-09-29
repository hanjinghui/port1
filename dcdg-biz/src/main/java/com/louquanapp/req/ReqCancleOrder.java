package com.louquanapp.req;

import javax.validation.constraints.NotEmpty;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/25 16:51
 * @Description:
 */
public class ReqCancleOrder extends ReqToken {
    /**
     * 取消原因
     */
    @NotEmpty(message = "取消原因不能为空")
    private String orderProb;

    public String getOrderProb() {
        return orderProb;
    }

    public void setOrderProb(String orderProb) {
        this.orderProb = orderProb;
    }
}
