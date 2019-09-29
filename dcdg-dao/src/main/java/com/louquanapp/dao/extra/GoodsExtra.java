package com.louquanapp.dao.extra;

import com.louquanapp.dao.EvaluateStatics;
import com.louquanapp.dao.model.GoodsSku;

import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/9 11:29
 * @Description:
 */
public class GoodsExtra {

    List<GoodsSku> goodsSkus;

    public List<GoodsSku> getGoodsSkus() {
        return goodsSkus;
    }

    public void setGoodsSkus(List<GoodsSku> goodsSkus) {
        this.goodsSkus = goodsSkus;
    }

    /**
     * 默认商品规格
     */
    private String skuId;
    private List<String> goodsIds;
    /**
     * 是否允许积分兑换[1-可以 2-不可以]
     */
    private Byte isPoint;

    private Double beginPutawayPrice;
    private Double endPutawayPrice;
    private String catPathLike;
    private String goodsNameLike;
    private String orderStr;

    private List<String> brandIds;

    public List<String> getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(List<String> brandIds) {
        this.brandIds = brandIds;
    }

    private List<String> catIds;

    public List<String> getCatIds() {
        return catIds;
    }

    public void setCatIds(List<String> catIds) {
        this.catIds = catIds;
    }

    /**
     * 所在区域
     */
    private String shopArea;

    public String getShopArea() {
        return shopArea;
    }

    public void setShopArea(String shopArea) {
        this.shopArea = shopArea;
    }

    /**
     * 评论统计
     */
    private EvaluateStatics evaluateStatics;


    /**
     * 已上架数量
     */
    private Integer putOnShelfCount;
    /**
     * 已下架数量
     */
    private Integer putOutShelCount;
    /**
     * 待审核
     */
    private Integer toBeAuditedCount;


    private Boolean flag=false;

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getPutOnShelfCount() {
        return putOnShelfCount;
    }

    public void setPutOnShelfCount(Integer putOnShelfCount) {
        this.putOnShelfCount = putOnShelfCount;
    }

    public Integer getPutOutShelCount() {
        return putOutShelCount;
    }

    public void setPutOutShelCount(Integer putOutShelCount) {
        this.putOutShelCount = putOutShelCount;
    }

    public Integer getToBeAuditedCount() {
        return toBeAuditedCount;
    }

    public void setToBeAuditedCount(Integer toBeAuditedCount) {
        this.toBeAuditedCount = toBeAuditedCount;
    }

    public List<String> getGoodsIds() {
        return goodsIds;
    }

    public void setGoodsIds(List<String> goodsIds) {
        this.goodsIds = goodsIds;
    }

    public Double getBeginPutawayPrice() {
        return beginPutawayPrice;
    }

    public void setBeginPutawayPrice(Double beginPutawayPrice) {
        this.beginPutawayPrice = beginPutawayPrice;
    }

    public Double getEndPutawayPrice() {
        return endPutawayPrice;
    }

    public void setEndPutawayPrice(Double endPutawayPrice) {
        this.endPutawayPrice = endPutawayPrice;
    }

    public String getCatPathLike() {
        return catPathLike;
    }

    public void setCatPathLike(String catPathLike) {
        this.catPathLike = catPathLike;
    }

    public String getGoodsNameLike() {
        return goodsNameLike;
    }

    public void setGoodsNameLike(String goodsNameLike) {
        this.goodsNameLike = goodsNameLike;
    }

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

    public EvaluateStatics getEvaluateStatics() {
        return evaluateStatics;
    }

    public void setEvaluateStatics(EvaluateStatics evaluateStatics) {
        this.evaluateStatics = evaluateStatics;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Byte getIsPoint() {
        return isPoint;
    }

    public void setIsPoint(Byte isPoint) {
        this.isPoint = isPoint;
    }
}
