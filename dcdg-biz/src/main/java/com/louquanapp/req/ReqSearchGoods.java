package com.louquanapp.req;

import java.util.Set;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @description 商品搜索
 * @date 2018/7/4 下午3:10
 */
public class ReqSearchGoods extends ReqCommPage {
    /**
     * 商品搜素集合
     */
    private Set<String> goodIds;

    private String videoId;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    /**
     * 门店
     */
    private String shopId;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 分类id
     */
    private String catId;
    /**
     * 品牌
     */
    private String brandId;
    /**
     * 属性值
     */
    private String optId;
    /**
     * 规格值
     */
    private String specOptId;


    /**
     * 关键字
     */
    private String keywords;
    /**
     * 价格范围
     */
    private String range;

    /**
     * 排序销量
     */
    private String saleCountSort;
    /**
     * 排序价格
     */
    private String putawayPriceSort;
    /**
     * 排序字段评论数
     */
    private String rateCountSort;
    /**
     * 排序字段综合时间
     */
    private String zongheSort;
    /**
     * 排序字段是否推荐APP[1-推荐 2-不推荐 ]
     */
    private String isRecSort;

    /**
     * 排序字段是更新时间
     */
    private String updateTimeSort;

    public String getUpdateTimeSort() {
        return updateTimeSort;
    }

    public void setUpdateTimeSort(String updateTimeSort) {
        this.updateTimeSort = updateTimeSort;
    }

    public String getIsRecSort() {
        return isRecSort;
    }

    public void setIsRecSort(String isRecSort) {
        this.isRecSort = isRecSort;
    }

    /**
     * 排序字段综合时间
     */
    private String addTimeSort;

    public Byte getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(Byte isPromotion) {
        this.isPromotion = isPromotion;
    }

    /**
     * 餐饮[1-是 2-否]
     */
    private Byte isPromotion;


    public String getAddTimeSort() {
        return addTimeSort;
    }

    public void setAddTimeSort(String addTimeSort) {
        this.addTimeSort = addTimeSort;
    }

    /**
     * 分类id
     *
     * @return
     */
    public String getCatId() {
        return catId;
    }

    /**
     * 分类id
     *
     * @param catId
     */
    public void setCatId(String catId) {
        this.catId = catId;
    }

    /**
     * 关键字
     *
     * @return
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * 关键字
     *
     * @param keywords
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * 价格范围
     *
     * @return
     */
    public String getRange() {
        return range;
    }

    /**
     * 价格范围
     *
     * @param range
     */
    public void setRange(String range) {
        this.range = range;
    }

    public String getSaleCountSort() {
        return saleCountSort;
    }

    public void setSaleCountSort(String saleCountSort) {
        this.saleCountSort = saleCountSort;
    }

    public String getPutawayPriceSort() {
        return putawayPriceSort;
    }

    public void setPutawayPriceSort(String putawayPriceSort) {
        this.putawayPriceSort = putawayPriceSort;
    }

    public String getRateCountSort() {
        return rateCountSort;
    }

    public void setRateCountSort(String rateCountSort) {
        this.rateCountSort = rateCountSort;
    }

    public String getZongheSort() {
        return zongheSort;
    }

    public void setZongheSort(String zongheSort) {
        this.zongheSort = zongheSort;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getOptId() {
        return optId;
    }

    public void setOptId(String optId) {
        this.optId = optId;
    }

    public String getSpecOptId() {
        return specOptId;
    }

    public void setSpecOptId(String specOptId) {
        this.specOptId = specOptId;
    }

    public Set<String> getGoodIds() {
        return goodIds;
    }

    public void setGoodIds(Set<String> goodIds) {
        this.goodIds = goodIds;
    }

}
