package com.louquanapp.req;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/7/18 下午3:27
 */
public class ReqDoOrder extends ReqToken {

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
    @NotNull(message = "餐饮标识不能为空")
    private Byte isPromotion;


    private String couponId;


    /**
     * 预计就餐时间
     * <p>
     * 数据库字段名:dcdg_bussiness_order_base.PLAN_EAT_TIME
     *
     * @mbg.generated Wed May 08 15:26:18 CST 2019
     */
    private Date planEatTime;

    public Date getPlanEatTime() {
        return planEatTime;
    }

    public void setPlanEatTime(Date planEatTime) {
        this.planEatTime = planEatTime;
    }

    /**
     * 收货地址编号
     */
    private String shipId;

    /**
     * 购物车编号汇总
     */
    @NotNull(message = "提交的商品不能为空")
    private String selectedCartId;
    /**
     * 备注
     */
    private String remark;


    /**
     * 收货地址编号
     *
     * @return
     */
    public String getShipId() {
        return shipId;
    }

    /**
     * 收货地址编号
     *
     * @param shipId
     */
    public void setShipId(String shipId) {
        this.shipId = shipId;
    }

    /**
     * 购物车编号汇总
     *
     * @return
     */
    public String getSelectedCartId() {
        return selectedCartId;
    }

    /**
     * 购物车编号汇总
     *
     * @param selectedCartId
     */
    public void setSelectedCartId(String selectedCartId) {
        this.selectedCartId = selectedCartId;
    }

    /**
     * 备注
     *
     * @return
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     *
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }


}
