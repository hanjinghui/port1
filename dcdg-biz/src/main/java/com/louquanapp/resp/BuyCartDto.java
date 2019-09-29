package com.louquanapp.resp;

import com.louquanapp.dao.model.Coupon;
import com.louquanapp.dao.model.ShipAddress;
import com.louquanapp.dao.model.Shop;

import java.util.List;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/7/16 下午1:50
 */
public class BuyCartDto {
    /**
     * 优惠券
     */
    private List<Coupon> coupons;
    private ShipAddress shipAddress;


    private Double totalMoney;
    private Double totalMaxPoint;
    private Integer totalNum;
    private String catIds;
    private Boolean selectAll;
    private Double postFee;
    private Double payMoney;

    private List<Shop> shopBuyCarts;

    public List<Shop> getShopBuyCarts() {
        return shopBuyCarts;
    }

    public void setShopBuyCarts(List<Shop> shopBuyCarts) {
        this.shopBuyCarts = shopBuyCarts;
    }

    public Double getPostFee() {
        return postFee;
    }

    public void setPostFee(Double postFee) {
        this.postFee = postFee;
    }

    public Boolean getSelectAll() {
        return selectAll;
    }

    public void setSelectAll(Boolean selectAll) {
        this.selectAll = selectAll;
    }


    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public String getCatIds() {
        return catIds;
    }

    public void setCatIds(String catIds) {
        this.catIds = catIds;
    }

    public Double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    public Double getTotalMaxPoint() {
        return totalMaxPoint;
    }

    public void setTotalMaxPoint(Double totalMaxPoint) {
        this.totalMaxPoint = totalMaxPoint;
    }


    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    public ShipAddress getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(ShipAddress shipAddress) {
        this.shipAddress = shipAddress;
    }
}
