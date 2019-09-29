package com.louquanapp.dao.extra;

import com.louquanapp.dao.model.Shop;

/**
 * @Auther: Huhuamin
 * @Date: 2019/3/26 15:29
 * @Description:
 */
public class CustomerExtra extends UpdateTimeExtra {

    private Shop shop;
    //登录成功返回给客户端的令牌7200秒有效，客户操作会刷新为7200
    private String token;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    /**
     * 登录成功返回给客户端的令牌7200秒有效，客户操作会刷新为7200
     *
     * @return
     */
    public String getToken() {
        return token;
    }

    /**
     * 登录成功返回给客户端的令牌7200秒有效，客户操作会刷新为7200
     *
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }


    private Double versionDeductionPoint;
    private Double versionConsumePoint;


    private Boolean flag;

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Double getVersionConsumePoint() {
        return versionConsumePoint;
    }

    public void setVersionConsumePoint(Double versionConsumePoint) {
        this.versionConsumePoint = versionConsumePoint;
    }

    public Double getVersionDeductionPoint() {
        return versionDeductionPoint;
    }

    public void setVersionDeductionPoint(Double versionDeductionPoint) {
        this.versionDeductionPoint = versionDeductionPoint;
    }
}

