package com.louquanapp.req;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/10 07:11
 * @Description: 订单里面使用的优惠券
 */
public class ReqCouponOrder {
    private String shopId;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    private String couponId;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }
}
