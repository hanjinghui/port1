package com.louquanapp.req;

import javax.validation.constraints.NotBlank;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/8/9 16:32
 * @description:
 */
public class ReqSendGoods extends ReqToken {
    /**
     * 订单号
     */
    @NotBlank(message = "订单号不能为空！")
    private String orderId;

    /**
     * 快递公司
     */
    @NotBlank(message = "快递公司不能为空！")
    private String postCompany;
    /**
     * 快递单号
     */
    @NotBlank(message = "快递单号不能为空！")
    private String postNo;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPostCompany() {
        return postCompany;
    }

    public void setPostCompany(String postCompany) {
        this.postCompany = postCompany;
    }

    public String getPostNo() {
        return postNo;
    }

    public void setPostNo(String postNo) {
        this.postNo = postNo;
    }
}
