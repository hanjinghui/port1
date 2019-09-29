package com.louquanapp.dao.extra;

import java.util.List;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2019年04月03日18:43:19
 */
public class BuyCartExtra {


    private Double marketPrice;

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double totalMaxPoint;
    private Boolean selected;
    private Boolean collected;
    private String goodsImg;
    private String catName;
    private String goodsName;
    private Double maxPoint;
    private List<String> cartIds;
    private Integer putawayFlag;

    private Integer stockCount;

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    private String skuGoodName;

    public String getSkuGoodName() {
        return skuGoodName;
    }

    public void setSkuGoodName(String skuGoodName) {
        this.skuGoodName = skuGoodName;
    }

    public Integer getPutawayFlag() {
        return putawayFlag;
    }

    public void setPutawayFlag(Integer putawayFlag) {
        this.putawayFlag = putawayFlag;
    }

    private Double putawayPrice;
    private Double totalPutawayPrice;

    public Double getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(Double maxPoint) {
        this.maxPoint = maxPoint;
    }

    public Double getTotalMaxPoint() {
        return totalMaxPoint;
    }

    public void setTotalMaxPoint(Double totalMaxPoint) {
        this.totalMaxPoint = totalMaxPoint;
    }


    public List<String> getCartIds() {
        return cartIds;
    }

    public void setCartIds(List<String> cartIds) {
        this.cartIds = cartIds;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean getCollected() {
        return collected;
    }

    public void setCollected(Boolean collected) {
        this.collected = collected;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getTotalPutawayPrice() {
        return totalPutawayPrice;
    }

    public void setTotalPutawayPrice(Double totalPutawayPrice) {
        this.totalPutawayPrice = totalPutawayPrice;
    }

    public Double getPutawayPrice() {
        return putawayPrice;
    }

    public void setPutawayPrice(Double putawayPrice) {
        this.putawayPrice = putawayPrice;
    }
}
