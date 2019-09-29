package com.louquanapp.resp;

import com.louquanapp.dao.EvaluateStatics;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/7/2 下午3:55
 */
public class ShortGoods {
    /**
     * 商品描述
     * <p>
     * 数据库字段名:CXY_GOODS_GOODS_BASE.GOODS_DESC
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String goodsDesc;
    private String skuId;
    /**
     * SKU类型[DEFAULT_SKU-默认规格 SINGLE_SKU-单层规格 DOUBLE_SKU-双层规格]
     * <p>
     * 数据库字段名:CXY_GOODS_GOODS_BASE.SKU_TYPE
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String skuType;
    /**
     * 浏览量
     * <p>
     * 数据库字段名:CXY_GOODS_GOODS_BASE.SKIM_COUNT
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Integer skimCount;
    /**
     * 主键
     * <p>
     * 数据库字段名:CXY_GOODS_GOODS_BASE.GOODS_ID
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String goodsId;
    /**
     * 商品名称
     * <p>
     * 数据库字段名:CXY_GOODS_GOODS_BASE.GOODS_NAME
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String goodsName;
    /**
     * 商品市场价
     * <p>
     * 数据库字段名:CXY_GOODS_GOODS_BASE.MARKET_PRICE
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Double marketPrice;
    /**
     * 商品上架价格
     * <p>
     * 数据库字段名:CXY_GOODS_GOODS_BASE.PUTAWAY_PRICE
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Double putawayPrice;
    /**
     * 最高使用积分
     * <p>
     * 数据库字段名:CXY_GOODS_GOODS_BASE.MAX_POINT
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Double maxPoint;
    /**
     * 是否热门[0-否 1-是]
     * <p>
     * 数据库字段名:CXY_GOODS_GOODS_BASE.IS_HOT
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Byte isHot;
    /**
     * 是否新品[0-新品 1-否]
     * <p>
     * 数据库字段名:CXY_GOODS_GOODS_BASE.IS_NEW
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Byte isNew;
    /**
     * 推荐[2-否 1-是]0-不推荐 1-推荐]
     * <p>
     * 数据库字段名:CXY_GOODS_GOODS_BASE.IS_REC
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Byte isRec;
    /**
     * 评论统计
     */
    private EvaluateStatics evaluateStatics;
    /**
     * 商品主图片
     * <p>
     * 数据库字段名:CXY_GOODS_GOODS_BASE.GOODS_IMG
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String goodsImg;

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    /**
     * 数据库字段：主键CXY_GOODS_GOODS_BASE.GOODS_ID
     *
     * @return the value of CXY_GOODS_GOODS_BASE.GOODS_ID
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 数据库字段：主键CXY_GOODS_GOODS_BASE.GOODS_ID
     *
     * @param goodsId the value for CXY_GOODS_GOODS_BASE.GOODS_ID
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * 数据库字段：商品名称CXY_GOODS_GOODS_BASE.GOODS_NAME
     *
     * @return the value of CXY_GOODS_GOODS_BASE.GOODS_NAME
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 数据库字段：商品名称CXY_GOODS_GOODS_BASE.GOODS_NAME
     *
     * @param goodsName the value for CXY_GOODS_GOODS_BASE.GOODS_NAME
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }


    /**
     * 数据库字段：是否热门[0-否 1-是]CXY_GOODS_GOODS_BASE.IS_HOT
     *
     * @return the value of CXY_GOODS_GOODS_BASE.IS_HOT
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Byte getIsHot() {
        return isHot;
    }

    /**
     * 数据库字段：是否热门[0-否 1-是]CXY_GOODS_GOODS_BASE.IS_HOT
     *
     * @param isHot the value for CXY_GOODS_GOODS_BASE.IS_HOT
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setIsHot(Byte isHot) {
        this.isHot = isHot;
    }

    /**
     * 数据库字段：是否新品[0-新品 1-否]CXY_GOODS_GOODS_BASE.IS_NEW
     *
     * @return the value of CXY_GOODS_GOODS_BASE.IS_NEW
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Byte getIsNew() {
        return isNew;
    }

    /**
     * 数据库字段：是否新品[0-新品 1-否]CXY_GOODS_GOODS_BASE.IS_NEW
     *
     * @param isNew the value for CXY_GOODS_GOODS_BASE.IS_NEW
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setIsNew(Byte isNew) {
        this.isNew = isNew;
    }

    /**
     * 数据库字段：推荐[2-否 1-是]0-不推荐 1-推荐]CXY_GOODS_GOODS_BASE.IS_REC
     *
     * @return the value of CXY_GOODS_GOODS_BASE.IS_REC
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Byte getIsRec() {
        return isRec;
    }

    /**
     * 数据库字段：推荐[2-否 1-是]0-不推荐 1-推荐]CXY_GOODS_GOODS_BASE.IS_REC
     *
     * @param isRec the value for CXY_GOODS_GOODS_BASE.IS_REC
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setIsRec(Byte isRec) {
        this.isRec = isRec;
    }


    /**
     * 数据库字段：最高使用积分CXY_GOODS_GOODS_BASE.MAX_POINT
     *
     * @return the value of CXY_GOODS_GOODS_BASE.MAX_POINT
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Double getMaxPoint() {
        return maxPoint;
    }

    /**
     * 数据库字段：最高使用积分CXY_GOODS_GOODS_BASE.MAX_POINT
     *
     * @param maxPoint the value for CXY_GOODS_GOODS_BASE.MAX_POINT
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setMaxPoint(Double maxPoint) {
        this.maxPoint = maxPoint;
    }

    /**
     * 数据库字段：商品市场价CXY_GOODS_GOODS_BASE.MARKET_PRICE
     *
     * @return the value of CXY_GOODS_GOODS_BASE.MARKET_PRICE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Double getMarketPrice() {
        return marketPrice;
    }

    /**
     * 数据库字段：商品市场价CXY_GOODS_GOODS_BASE.MARKET_PRICE
     *
     * @param marketPrice the value for CXY_GOODS_GOODS_BASE.MARKET_PRICE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * 数据库字段：商品上架价格CXY_GOODS_GOODS_BASE.PUTAWAY_PRICE
     *
     * @return the value of CXY_GOODS_GOODS_BASE.PUTAWAY_PRICE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Double getPutawayPrice() {
        return putawayPrice;
    }

    /**
     * 数据库字段：商品上架价格CXY_GOODS_GOODS_BASE.PUTAWAY_PRICE
     *
     * @param putawayPrice the value for CXY_GOODS_GOODS_BASE.PUTAWAY_PRICE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setPutawayPrice(Double putawayPrice) {
        this.putawayPrice = putawayPrice;
    }


    /**
     * 数据库字段：商品主图片CXY_GOODS_GOODS_BASE.GOODS_IMG
     *
     * @return the value of CXY_GOODS_GOODS_BASE.GOODS_IMG
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getGoodsImg() {
        return goodsImg;
    }

    /**
     * 数据库字段：商品主图片CXY_GOODS_GOODS_BASE.GOODS_IMG
     *
     * @param goodsImg the value for CXY_GOODS_GOODS_BASE.GOODS_IMG
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }


    /**
     * 数据库字段：浏览量CXY_GOODS_GOODS_BASE.SKIM_COUNT
     *
     * @return the value of CXY_GOODS_GOODS_BASE.SKIM_COUNT
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Integer getSkimCount() {
        return skimCount;
    }

    /**
     * 数据库字段：浏览量CXY_GOODS_GOODS_BASE.SKIM_COUNT
     *
     * @param skimCount the value for CXY_GOODS_GOODS_BASE.SKIM_COUNT
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setSkimCount(Integer skimCount) {
        this.skimCount = skimCount;
    }


    /**
     * 数据库字段：SKU类型[DEFAULT_SKU-默认规格 SINGLE_SKU-单层规格 DOUBLE_SKU-双层规格]CXY_GOODS_GOODS_BASE.SKU_TYPE
     *
     * @return the value of CXY_GOODS_GOODS_BASE.SKU_TYPE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getSkuType() {
        return skuType;
    }

    /**
     * 数据库字段：SKU类型[DEFAULT_SKU-默认规格 SINGLE_SKU-单层规格 DOUBLE_SKU-双层规格]CXY_GOODS_GOODS_BASE.SKU_TYPE
     *
     * @param skuType the value for CXY_GOODS_GOODS_BASE.SKU_TYPE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setSkuType(String skuType) {
        this.skuType = skuType == null ? null : skuType.trim();
    }

    public EvaluateStatics getEvaluateStatics() {
        return evaluateStatics;
    }

    public void setEvaluateStatics(EvaluateStatics evaluateStatics) {
        this.evaluateStatics = evaluateStatics;
    }
}
