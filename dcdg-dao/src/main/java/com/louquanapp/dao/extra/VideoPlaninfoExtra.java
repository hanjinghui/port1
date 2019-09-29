package com.louquanapp.dao.extra;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/5/10 17:00
 * @description:
 */
public class VideoPlaninfoExtra {
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * 商铺名称
     */
    private  String shopName;
    /**
     * 商铺地址
     */
    private  String shopAddress;
    /**
     * 商铺经纬度
     */
    private  String  grps;
    /**
     * 店铺Logo
     */
    private String shopLogo;


    public String getShopLogo() {
        return shopLogo;
    }

    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getGrps() {
        return grps;
    }

    public void setGrps(String grps) {
        this.grps = grps;
    }
}
