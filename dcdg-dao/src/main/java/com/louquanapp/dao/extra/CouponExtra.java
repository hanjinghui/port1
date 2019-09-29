package com.louquanapp.dao.extra;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/7 19:12
 * @Description:
 */
public class CouponExtra {

    /**
     * 使用[1-已用 2-未用 3-过期]
     */
    private Integer isUse;

    /**
     * 优惠劵二维码
     */
    private String couponImg;
    /**
     * 商铺名称
     */
    private String shopName;
    /**
     * 商铺logo
     */
    private String shopLogo;

    /**
     * 领取量
     */
    private Integer receiveCount;
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


    private String custIds;

    public String getCustIds() {
        return custIds;
    }

    public void setCustIds(String custIds) {
        this.custIds = custIds;
    }

    public Integer getReceiveCount() {
        return receiveCount;
    }

    public void setReceiveCount(Integer receiveCount) {
        this.receiveCount = receiveCount;
    }

    public Integer getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(Integer usedCount) {
        this.usedCount = usedCount;
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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopLogo() {
        return shopLogo;
    }

    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }

    public String getCouponImg() {
        return couponImg;
    }

    public void setCouponImg(String couponImg) {
        this.couponImg = couponImg;
    }

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }
}
