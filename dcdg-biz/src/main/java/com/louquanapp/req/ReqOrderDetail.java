package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/10 10:08
 * @Description:
 */
public class ReqOrderDetail extends ReqToken {


    @NotNull(message = "订单类型不能为空")
    @Range(min = 1, max = 2, message = "订单类型范围是1-2")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    private Integer type;

    private String orderIds;

    public String getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(String orderIds) {
        this.orderIds = orderIds;
    }
}
