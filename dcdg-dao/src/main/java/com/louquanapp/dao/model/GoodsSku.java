package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.SelectedExtra;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_goods_goods_sku
 *
 * @mbg.generated do_not_delete_during_merge Wed Sep 18 11:20:37 CST 2019
 */
public class GoodsSku extends SelectedExtra {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_goods_goods_sku.SKU_ID
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private String skuId;

    /**
     *   商品ID
     *
     * 数据库字段名:dcdg_goods_goods_sku.GOODS_ID
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private String goodsId;

    /**
     *   SKU规则
     *
     * 数据库字段名:dcdg_goods_goods_sku.SKU_RULE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private String skuRule;

    /**
     *   主规格ID
     *
     * 数据库字段名:dcdg_goods_goods_sku.MAIN_SPEC
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private String mainSpec;

    /**
     *   主规格选项ID
     *
     * 数据库字段名:dcdg_goods_goods_sku.MAIN_SPEC_OPT
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private String mainSpecOpt;

    /**
     *   副规格ID
     *
     * 数据库字段名:dcdg_goods_goods_sku.VICE_SPEC
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private String viceSpec;

    /**
     *   副规格选项ID
     *
     * 数据库字段名:dcdg_goods_goods_sku.VICE_SPEC_OPT
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private String viceSpecOpt;

    /**
     *   库存数量
     *
     * 数据库字段名:dcdg_goods_goods_sku.STOCK_COUNT
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private Integer stockCount;

    /**
     *   供货价
     *
     * 数据库字段名:dcdg_goods_goods_sku.SUPPLIER_PRICE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private Double supplierPrice;

    /**
     *   商品市场价
     *
     * 数据库字段名:dcdg_goods_goods_sku.MARKET_PRICE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private Double marketPrice;

    /**
     *   商品上架价格
     *
     * 数据库字段名:dcdg_goods_goods_sku.PUTAWAY_PRICE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private Double putawayPrice;

    /**
     *   最大使用积分
     *
     * 数据库字段名:dcdg_goods_goods_sku.MAX_POINT
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private Double maxPoint;

    /**
     *   商家编码
     *
     * 数据库字段名:dcdg_goods_goods_sku.MERCHANT_CODE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private String merchantCode;

    /**
     *   商品条形码
     *
     * 数据库字段名:dcdg_goods_goods_sku.GOODS_CODE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private String goodsCode;

    /**
     *   商品主图片
     *
     * 数据库字段名:dcdg_goods_goods_sku.GOODS_IMG
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private String goodsImg;

    /**
     *   创建时间
     *
     * 数据库字段名:dcdg_goods_goods_sku.ADD_TIME
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private Date addTime;

    /**
     *   更新时间
     *
     * 数据库字段名:dcdg_goods_goods_sku.UPDATE_TIME
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private Date updateTime;

    /**
     *
     * 数据库字段名:dcdg_goods_goods_sku.SKU_GOODS_NAME
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private String skuGoodsName;

    /**
     *   是否允许积分兑换[1-可以 2-不可以]
     *
     * 数据库字段名:dcdg_goods_goods_sku.IS_POINT
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private Byte isPoint;

    /**
     *   商品类型[1-普通商品 2-特价商品]
     *
     * 数据库字段名:dcdg_goods_goods_sku.GOODS_TYPE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private Byte goodsType;

    /**
     *   标签
     *
     * 数据库字段名:dcdg_goods_goods_sku.LABEL
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    private String label;

    /**
     * 数据库字段：主键dcdg_goods_goods_sku.SKU_ID
     *
     * @return  the value of dcdg_goods_goods_sku.SKU_ID
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public String getSkuId() {
        return skuId;
    }

    /**
     * 数据库字段：主键dcdg_goods_goods_sku.SKU_ID
     * @param skuId the value for dcdg_goods_goods_sku.SKU_ID
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setSkuId(String skuId) {
        this.skuId = skuId == null ? null : skuId.trim();
    }

    /**
     * 数据库字段：商品IDdcdg_goods_goods_sku.GOODS_ID
     *
     * @return  the value of dcdg_goods_goods_sku.GOODS_ID
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 数据库字段：商品IDdcdg_goods_goods_sku.GOODS_ID
     * @param goodsId the value for dcdg_goods_goods_sku.GOODS_ID
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * 数据库字段：SKU规则dcdg_goods_goods_sku.SKU_RULE
     *
     * @return  the value of dcdg_goods_goods_sku.SKU_RULE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public String getSkuRule() {
        return skuRule;
    }

    /**
     * 数据库字段：SKU规则dcdg_goods_goods_sku.SKU_RULE
     * @param skuRule the value for dcdg_goods_goods_sku.SKU_RULE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setSkuRule(String skuRule) {
        this.skuRule = skuRule == null ? null : skuRule.trim();
    }

    /**
     * 数据库字段：主规格IDdcdg_goods_goods_sku.MAIN_SPEC
     *
     * @return  the value of dcdg_goods_goods_sku.MAIN_SPEC
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public String getMainSpec() {
        return mainSpec;
    }

    /**
     * 数据库字段：主规格IDdcdg_goods_goods_sku.MAIN_SPEC
     * @param mainSpec the value for dcdg_goods_goods_sku.MAIN_SPEC
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setMainSpec(String mainSpec) {
        this.mainSpec = mainSpec == null ? null : mainSpec.trim();
    }

    /**
     * 数据库字段：主规格选项IDdcdg_goods_goods_sku.MAIN_SPEC_OPT
     *
     * @return  the value of dcdg_goods_goods_sku.MAIN_SPEC_OPT
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public String getMainSpecOpt() {
        return mainSpecOpt;
    }

    /**
     * 数据库字段：主规格选项IDdcdg_goods_goods_sku.MAIN_SPEC_OPT
     * @param mainSpecOpt the value for dcdg_goods_goods_sku.MAIN_SPEC_OPT
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setMainSpecOpt(String mainSpecOpt) {
        this.mainSpecOpt = mainSpecOpt == null ? null : mainSpecOpt.trim();
    }

    /**
     * 数据库字段：副规格IDdcdg_goods_goods_sku.VICE_SPEC
     *
     * @return  the value of dcdg_goods_goods_sku.VICE_SPEC
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public String getViceSpec() {
        return viceSpec;
    }

    /**
     * 数据库字段：副规格IDdcdg_goods_goods_sku.VICE_SPEC
     * @param viceSpec the value for dcdg_goods_goods_sku.VICE_SPEC
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setViceSpec(String viceSpec) {
        this.viceSpec = viceSpec == null ? null : viceSpec.trim();
    }

    /**
     * 数据库字段：副规格选项IDdcdg_goods_goods_sku.VICE_SPEC_OPT
     *
     * @return  the value of dcdg_goods_goods_sku.VICE_SPEC_OPT
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public String getViceSpecOpt() {
        return viceSpecOpt;
    }

    /**
     * 数据库字段：副规格选项IDdcdg_goods_goods_sku.VICE_SPEC_OPT
     * @param viceSpecOpt the value for dcdg_goods_goods_sku.VICE_SPEC_OPT
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setViceSpecOpt(String viceSpecOpt) {
        this.viceSpecOpt = viceSpecOpt == null ? null : viceSpecOpt.trim();
    }

    /**
     * 数据库字段：库存数量dcdg_goods_goods_sku.STOCK_COUNT
     *
     * @return  the value of dcdg_goods_goods_sku.STOCK_COUNT
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public Integer getStockCount() {
        return stockCount;
    }

    /**
     * 数据库字段：库存数量dcdg_goods_goods_sku.STOCK_COUNT
     * @param stockCount the value for dcdg_goods_goods_sku.STOCK_COUNT
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    /**
     * 数据库字段：供货价dcdg_goods_goods_sku.SUPPLIER_PRICE
     *
     * @return  the value of dcdg_goods_goods_sku.SUPPLIER_PRICE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public Double getSupplierPrice() {
        return supplierPrice;
    }

    /**
     * 数据库字段：供货价dcdg_goods_goods_sku.SUPPLIER_PRICE
     * @param supplierPrice the value for dcdg_goods_goods_sku.SUPPLIER_PRICE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setSupplierPrice(Double supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

    /**
     * 数据库字段：商品市场价dcdg_goods_goods_sku.MARKET_PRICE
     *
     * @return  the value of dcdg_goods_goods_sku.MARKET_PRICE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public Double getMarketPrice() {
        return marketPrice;
    }

    /**
     * 数据库字段：商品市场价dcdg_goods_goods_sku.MARKET_PRICE
     * @param marketPrice the value for dcdg_goods_goods_sku.MARKET_PRICE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * 数据库字段：商品上架价格dcdg_goods_goods_sku.PUTAWAY_PRICE
     *
     * @return  the value of dcdg_goods_goods_sku.PUTAWAY_PRICE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public Double getPutawayPrice() {
        return putawayPrice;
    }

    /**
     * 数据库字段：商品上架价格dcdg_goods_goods_sku.PUTAWAY_PRICE
     * @param putawayPrice the value for dcdg_goods_goods_sku.PUTAWAY_PRICE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setPutawayPrice(Double putawayPrice) {
        this.putawayPrice = putawayPrice;
    }

    /**
     * 数据库字段：最大使用积分dcdg_goods_goods_sku.MAX_POINT
     *
     * @return  the value of dcdg_goods_goods_sku.MAX_POINT
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public Double getMaxPoint() {
        return maxPoint;
    }

    /**
     * 数据库字段：最大使用积分dcdg_goods_goods_sku.MAX_POINT
     * @param maxPoint the value for dcdg_goods_goods_sku.MAX_POINT
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setMaxPoint(Double maxPoint) {
        this.maxPoint = maxPoint;
    }

    /**
     * 数据库字段：商家编码dcdg_goods_goods_sku.MERCHANT_CODE
     *
     * @return  the value of dcdg_goods_goods_sku.MERCHANT_CODE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public String getMerchantCode() {
        return merchantCode;
    }

    /**
     * 数据库字段：商家编码dcdg_goods_goods_sku.MERCHANT_CODE
     * @param merchantCode the value for dcdg_goods_goods_sku.MERCHANT_CODE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode == null ? null : merchantCode.trim();
    }

    /**
     * 数据库字段：商品条形码dcdg_goods_goods_sku.GOODS_CODE
     *
     * @return  the value of dcdg_goods_goods_sku.GOODS_CODE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public String getGoodsCode() {
        return goodsCode;
    }

    /**
     * 数据库字段：商品条形码dcdg_goods_goods_sku.GOODS_CODE
     * @param goodsCode the value for dcdg_goods_goods_sku.GOODS_CODE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    /**
     * 数据库字段：商品主图片dcdg_goods_goods_sku.GOODS_IMG
     *
     * @return  the value of dcdg_goods_goods_sku.GOODS_IMG
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public String getGoodsImg() {
        return goodsImg;
    }

    /**
     * 数据库字段：商品主图片dcdg_goods_goods_sku.GOODS_IMG
     * @param goodsImg the value for dcdg_goods_goods_sku.GOODS_IMG
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    /**
     * 数据库字段：创建时间dcdg_goods_goods_sku.ADD_TIME
     *
     * @return  the value of dcdg_goods_goods_sku.ADD_TIME
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：创建时间dcdg_goods_goods_sku.ADD_TIME
     * @param addTime the value for dcdg_goods_goods_sku.ADD_TIME
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：更新时间dcdg_goods_goods_sku.UPDATE_TIME
     *
     * @return  the value of dcdg_goods_goods_sku.UPDATE_TIME
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：更新时间dcdg_goods_goods_sku.UPDATE_TIME
     * @param updateTime the value for dcdg_goods_goods_sku.UPDATE_TIME
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 数据库字段：dcdg_goods_goods_sku.SKU_GOODS_NAME
     *
     * @return  the value of dcdg_goods_goods_sku.SKU_GOODS_NAME
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public String getSkuGoodsName() {
        return skuGoodsName;
    }

    /**
     * 数据库字段：dcdg_goods_goods_sku.SKU_GOODS_NAME
     * @param skuGoodsName the value for dcdg_goods_goods_sku.SKU_GOODS_NAME
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setSkuGoodsName(String skuGoodsName) {
        this.skuGoodsName = skuGoodsName == null ? null : skuGoodsName.trim();
    }

    /**
     * 数据库字段：是否允许积分兑换[1-可以 2-不可以]dcdg_goods_goods_sku.IS_POINT
     *
     * @return  the value of dcdg_goods_goods_sku.IS_POINT
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public Byte getIsPoint() {
        return isPoint;
    }

    /**
     * 数据库字段：是否允许积分兑换[1-可以 2-不可以]dcdg_goods_goods_sku.IS_POINT
     * @param isPoint the value for dcdg_goods_goods_sku.IS_POINT
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setIsPoint(Byte isPoint) {
        this.isPoint = isPoint;
    }

    /**
     * 数据库字段：商品类型[1-普通商品 2-特价商品]dcdg_goods_goods_sku.GOODS_TYPE
     *
     * @return  the value of dcdg_goods_goods_sku.GOODS_TYPE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public Byte getGoodsType() {
        return goodsType;
    }

    /**
     * 数据库字段：商品类型[1-普通商品 2-特价商品]dcdg_goods_goods_sku.GOODS_TYPE
     * @param goodsType the value for dcdg_goods_goods_sku.GOODS_TYPE
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setGoodsType(Byte goodsType) {
        this.goodsType = goodsType;
    }

    /**
     * 数据库字段：标签dcdg_goods_goods_sku.LABEL
     *
     * @return  the value of dcdg_goods_goods_sku.LABEL
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public String getLabel() {
        return label;
    }

    /**
     * 数据库字段：标签dcdg_goods_goods_sku.LABEL
     * @param label the value for dcdg_goods_goods_sku.LABEL
     *
     * @mbg.generated Wed Sep 18 11:20:37 CST 2019
     */
    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }
}