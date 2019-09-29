package com.louquanapp.req;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/8 17:06
 * @Description: 条件优惠券
 */
public class ReqCoupon extends ReqToken {

    /**
     * 获取有效的优惠券
     */
    private String couponConent;

    public String getCouponConent() {
        return couponConent;
    }

    public void setCouponConent(String couponConent) {
        this.couponConent = couponConent;
    }
}
