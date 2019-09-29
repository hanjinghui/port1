package com.louquanapp.dao.model;
import com.louquanapp.dao.extra.CustomerCouponExtra;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_bussiness_customer_coupon
 *
 * @mbg.generated do_not_delete_during_merge Tue Jul 09 14:44:52 CST 2019
 */
public class CustomerCoupon extends CustomerCouponExtra {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_bussiness_customer_coupon.CUST_COUPON_ID
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    private String custCouponId;

    /**
     *   卡卷编号
     *
     * 数据库字段名:dcdg_bussiness_customer_coupon.COUPON_ID
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    private String couponId;

    /**
     *   接收用户
     *
     * 数据库字段名:dcdg_bussiness_customer_coupon.CUST_ID
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    private String custId;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_bussiness_customer_coupon.ADD_TIME
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    private Date addTime;

    /**
     *   更新时间
     *
     * 数据库字段名:dcdg_bussiness_customer_coupon.UPDATE_TIME
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    private Date updateTime;

    /**
     *   使用[1-已用 2-未用 3-过期]
     *
     * 数据库字段名:dcdg_bussiness_customer_coupon.IS_USE
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    private Byte isUse;

    /**
     *   使用时间
     *
     * 数据库字段名:dcdg_bussiness_customer_coupon.USER_TIME
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    private Date userTime;

    /**
     *   优惠劵二维码
     *
     * 数据库字段名:dcdg_bussiness_customer_coupon.COUPON_IMG
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    private String couponImg;

    /**
     *   获得者的Id
     *
     * 数据库字段名:dcdg_bussiness_customer_coupon.GAIN_ID
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    private String gainId;

    /**
     * 数据库字段：主键dcdg_bussiness_customer_coupon.CUST_COUPON_ID
     *
     * @return  the value of dcdg_bussiness_customer_coupon.CUST_COUPON_ID
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    public String getCustCouponId() {
        return custCouponId;
    }

    /**
     * 数据库字段：主键dcdg_bussiness_customer_coupon.CUST_COUPON_ID
     * @param custCouponId the value for dcdg_bussiness_customer_coupon.CUST_COUPON_ID
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    public void setCustCouponId(String custCouponId) {
        this.custCouponId = custCouponId == null ? null : custCouponId.trim();
    }

    /**
     * 数据库字段：卡卷编号dcdg_bussiness_customer_coupon.COUPON_ID
     *
     * @return  the value of dcdg_bussiness_customer_coupon.COUPON_ID
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    public String getCouponId() {
        return couponId;
    }

    /**
     * 数据库字段：卡卷编号dcdg_bussiness_customer_coupon.COUPON_ID
     * @param couponId the value for dcdg_bussiness_customer_coupon.COUPON_ID
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    /**
     * 数据库字段：接收用户dcdg_bussiness_customer_coupon.CUST_ID
     *
     * @return  the value of dcdg_bussiness_customer_coupon.CUST_ID
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：接收用户dcdg_bussiness_customer_coupon.CUST_ID
     * @param custId the value for dcdg_bussiness_customer_coupon.CUST_ID
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：添加时间dcdg_bussiness_customer_coupon.ADD_TIME
     *
     * @return  the value of dcdg_bussiness_customer_coupon.ADD_TIME
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_bussiness_customer_coupon.ADD_TIME
     * @param addTime the value for dcdg_bussiness_customer_coupon.ADD_TIME
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：更新时间dcdg_bussiness_customer_coupon.UPDATE_TIME
     *
     * @return  the value of dcdg_bussiness_customer_coupon.UPDATE_TIME
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：更新时间dcdg_bussiness_customer_coupon.UPDATE_TIME
     * @param updateTime the value for dcdg_bussiness_customer_coupon.UPDATE_TIME
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 数据库字段：使用[1-已用 2-未用 3-过期]dcdg_bussiness_customer_coupon.IS_USE
     *
     * @return  the value of dcdg_bussiness_customer_coupon.IS_USE
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    public Byte getIsUse() {
        return isUse;
    }

    /**
     * 数据库字段：使用[1-已用 2-未用 3-过期]dcdg_bussiness_customer_coupon.IS_USE
     * @param isUse the value for dcdg_bussiness_customer_coupon.IS_USE
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    public void setIsUse(Byte isUse) {
        this.isUse = isUse;
    }

    /**
     * 数据库字段：使用时间dcdg_bussiness_customer_coupon.USER_TIME
     *
     * @return  the value of dcdg_bussiness_customer_coupon.USER_TIME
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    public Date getUserTime() {
        return userTime;
    }

    /**
     * 数据库字段：使用时间dcdg_bussiness_customer_coupon.USER_TIME
     * @param userTime the value for dcdg_bussiness_customer_coupon.USER_TIME
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    public void setUserTime(Date userTime) {
        this.userTime = userTime;
    }

    /**
     * 数据库字段：优惠劵二维码dcdg_bussiness_customer_coupon.COUPON_IMG
     *
     * @return  the value of dcdg_bussiness_customer_coupon.COUPON_IMG
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    public String getCouponImg() {
        return couponImg;
    }

    /**
     * 数据库字段：优惠劵二维码dcdg_bussiness_customer_coupon.COUPON_IMG
     * @param couponImg the value for dcdg_bussiness_customer_coupon.COUPON_IMG
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    public void setCouponImg(String couponImg) {
        this.couponImg = couponImg == null ? null : couponImg.trim();
    }

    /**
     * 数据库字段：获得者的Iddcdg_bussiness_customer_coupon.GAIN_ID
     *
     * @return  the value of dcdg_bussiness_customer_coupon.GAIN_ID
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    public String getGainId() {
        return gainId;
    }

    /**
     * 数据库字段：获得者的Iddcdg_bussiness_customer_coupon.GAIN_ID
     * @param gainId the value for dcdg_bussiness_customer_coupon.GAIN_ID
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    public void setGainId(String gainId) {
        this.gainId = gainId == null ? null : gainId.trim();
    }
}