package com.louquanapp.req;

import javax.validation.constraints.NotBlank;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/8/7 18:06
 * @description:
 */
public class ReqOrderAdress extends ReqToken {
    /**
     * 订单Id
     */
    @NotBlank(message = "订单Id不能为空！")
    private String orderId;
    /**
     * 收货人姓名
     */
    @NotBlank(message = "收货人姓名不能为空！")
  private String receiverName;
    /**
     * 区域路径深度(省市区)
     */
    @NotBlank(message = "省市区不能为空！")
  private String areaPath;
    /**
     * 收货地址
     */
    @NotBlank(message = "收货地址详情不能为空！")
  private String receiveAddr;
    /**
     * 联系电话
     */
    @NotBlank(message = "联系电话不能为空！")
  private String linkPhone;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getAreaPath() {
        return areaPath;
    }

    public void setAreaPath(String areaPath) {
        this.areaPath = areaPath;
    }

    public String getReceiveAddr() {
        return receiveAddr;
    }

    public void setReceiveAddr(String receiveAddr) {
        this.receiveAddr = receiveAddr;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }
}
