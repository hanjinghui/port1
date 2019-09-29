package com.louquanapp.dao.extra;

import java.util.Date;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/8/23 10:45
 * @description:
 */
public class CustomerCouponExtra {


    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 已使用
     */
    private Integer usedCount;
    /**
     * 未使用
     */
    private Integer notUsedCount;
    /**
     * 已过期
     */
    private Integer expiredCount;


    /**
     * 优惠劵使用方式[1-线上 2-线下]
     */
    private Byte  couponWay;
    /**
     * 优惠券名称
     */
    private String   couponName;
    /**
     * 用户头像
     */
    private String  headImg;
    /**
     * 用户昵称
     */
    private String  nickName;

    /**
     * 优惠商品/门店/体验券
     */
    private String  couponConent;
    /**
     * 类型[1-商品优惠 2-店铺优惠 3-全场通用  4-体验券]
     */
    private Byte  couponType;


    /**
     * 商铺logo
     */
    private String shopLogo;
    /**
     * 商铺名称
     */
    private String shopName;
    /**
     * 有效结束日期
     */
    private Date dieTime;

    private String couponLogo;

    public String getCouponLogo() {
        return couponLogo;
    }

    public void setCouponLogo(String couponLogo) {
        this.couponLogo = couponLogo;
    }

    public Date getDieTime() {
        return dieTime;
    }

    public void setDieTime(Date dieTime) {
        this.dieTime = dieTime;
    }

    public String getShopLogo() {
        return shopLogo;
    }

    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getCouponConent() {
        return couponConent;
    }

    public void setCouponConent(String couponConent) {
        this.couponConent = couponConent;
    }

    public Byte getCouponType() {
        return couponType;
    }

    public void setCouponType(Byte couponType) {
        this.couponType = couponType;
    }

    public Byte getCouponWay() {
        return couponWay;
    }

    public void setCouponWay(Byte couponWay) {
        this.couponWay = couponWay;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getNotUsedCount() {
        return notUsedCount;
    }

    public void setNotUsedCount(Integer notUsedCount) {
        this.notUsedCount = notUsedCount;
    }

    public Integer getExpiredCount() {
        return expiredCount;
    }

    public void setExpiredCount(Integer expiredCount) {
        this.expiredCount = expiredCount;
    }

    public Integer getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(Integer usedCount) {
        this.usedCount = usedCount;
    }
}
