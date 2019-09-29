package com.louquanapp.req;

import javax.validation.constraints.NotNull;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2019年04月11日21:20:48
 */
public class ReqSearchOrder extends ReqTokenPage {
    //1-全部 2-待付款  3-待发货 4-待收货  5-待评价


    public Byte getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(Byte isPromotion) {
        this.isPromotion = isPromotion;
    }

    /**
     * 餐饮[1-是 2-否]
     * <p>
     * 数据库字段名:dcdg_bussiness_order_base.IS_PROMOTION
     *
     * @mbg.generated Thu Apr 25 15:35:08 CST 2019
     */
//    @NotNull(message = "餐饮标识不能为空")
    private Byte isPromotion;

    private Integer orderStatus;
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;


    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


}
