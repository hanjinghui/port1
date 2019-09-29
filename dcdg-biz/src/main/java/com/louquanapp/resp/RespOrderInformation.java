package com.louquanapp.resp;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/8/6 10:38
 * @description:
 */
public class RespOrderInformation {
    /**
     * 今日营业额
     */
    private Double dayMoney;
    /**
     * 本周订单数
     */
    private Integer weekOrdersCount;

    /**
     *累计营业额
     */
    private Double totalMoney;
    /**
     * 待发货订单数
     */
    private Integer toSendOrdersCount;

    /**
     * 退款申请订单数
     */
    private Integer refundApplicationOrdersCount;

    public Double getDayMoney() {
        return dayMoney;
    }

    public void setDayMoney(Double dayMoney) {
        this.dayMoney = dayMoney;
    }

    public Integer getWeekOrdersCount() {
        return weekOrdersCount;
    }

    public void setWeekOrdersCount(Integer weekOrdersCount) {
        this.weekOrdersCount = weekOrdersCount;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getToSendOrdersCount() {
        return toSendOrdersCount;
    }

    public void setToSendOrdersCount(Integer toSendOrdersCount) {
        this.toSendOrdersCount = toSendOrdersCount;
    }

    public Integer getRefundApplicationOrdersCount() {
        return refundApplicationOrdersCount;
    }

    public void setRefundApplicationOrdersCount(Integer refundApplicationOrdersCount) {
        this.refundApplicationOrdersCount = refundApplicationOrdersCount;
    }
}
