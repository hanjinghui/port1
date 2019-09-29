package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/7/9 14:28
 * @description:
 */
public class ReqReceiveCoupon extends ReqTokenPage{

    /**
     * 类型
     */
    @NotNull(message = "类型不能为空!")
    @Range(min = 1, max = 4, message = "类型范围[1-商品优惠 2-店铺优惠 3-全场通用]")
    private  Byte couponType;
    /**
     * 优惠商品Id/门店Id
     */
    private String couponConent;

    public Byte getCouponType() {
        return couponType;
    }

    public void setCouponType(Byte couponType) {
        this.couponType = couponType;
    }

    public String getCouponConent() {
        return couponConent;
    }

    public void setCouponConent(String couponConent) {
        this.couponConent = couponConent;
    }
}
