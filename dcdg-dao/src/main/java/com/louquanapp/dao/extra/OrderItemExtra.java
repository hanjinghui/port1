package com.louquanapp.dao.extra;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/10 10:44
 * @Description:
 */
public class OrderItemExtra {

    private Double marketPrice;

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    private Integer returnStatus;

    public Integer getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(Integer returnStatus) {
        this.returnStatus = returnStatus;
    }

    private String shopName;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * 是否评价了
     */
    private Boolean evaluate;

    public Boolean getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Boolean evaluate) {
        this.evaluate = evaluate;
    }


    /**
     * 是否申请了收货
     */
    private Boolean afterSale;

    public Boolean getAfterSale() {
        return afterSale;
    }

    public void setAfterSale(Boolean afterSale) {
        this.afterSale = afterSale;
    }


    private String goodsDesc;

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }
}
