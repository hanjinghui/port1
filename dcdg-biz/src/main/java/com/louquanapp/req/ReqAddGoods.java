package com.louquanapp.req;


import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/9/17 17:14
 * @description:
 */
public class ReqAddGoods extends ReqToken {



    /**
     * 库存
     */
    @NotBlank(message = "库存不能为空")
     private String stockList;
    /**
     * 供货价格
     */
    @NotBlank(message = "供货价格不能为空")
    private String costList;
    /**
     * 市场价格
     */
    @NotBlank(message = "市场价格不能为空")
    private String marketList;
    /**
     * 消耗积分数
     */
    @NotBlank(message = "消耗积分数不能为空")
    private String min_scoreList;
    /**
     * 搂圈价格
     */
    @NotBlank(message = "搂圈价格不能为空")
    private String edaoList;
    /**
     * 是否允许积分兑换[1-可以 2-不可以]
     */
    @NotBlank(message = "是否允许积分兑换不能为空")
    private String isPointList;
    /**
     * 商品类型[1-普通商品 2-特价商品]
     */
    @NotBlank(message = "商品类型不能为空")
    private String goodsTypeList;


    /**
     * SKU规则
     */

    private String skuRuleList;



    private String optNameList;




    /**
     * 商品属性
     */
    private String merattrList;

    /**
     * 商品标签
     */
    private String tagsList;







    /**产品介绍
     *
     */
    private String product;
    /**套餐产品介绍
     *
      */
    private String self;
    /**穿着效果
     *
      */
    private String wear;
    /**整体款式
     *
      */
    private String whole;
    /**细节做工
     *
      */
    private String detail;
    /**品牌介绍
     *
      */
    private String brank;
    /**包装展示
     *
      */
    private String  pack;
    /**服务说明
     *
      */
    private String service;
    /** 资质证明
     *
     */
    private String  qua;
    /** 店铺信息
     *
    */
    private String  shop;


    /**
    * 产品介绍图片
     */

    private String productImgList;
    /**套餐产品介绍图片
     *
     */

    private String selfImgList;
     /**
     * 穿着效果图片
      * */
     private String wearImgList;
     /**
     * 整体款式图片
      */
     private String wholeImgList;
     /**
     * 细节做工图片
      * */
     private String detailImgList;
     /**
     * 品牌介绍图片
      * */
     private String brankImgList;
     /**
     * 包装展示图片
      * */
     private String packImgList;
    /** 服务说明图片
     *
     */
    private String serviceImgList;
     /**
     *  资质证明图片
      *  */
     private String quaImgList;
     /**
     * 店铺信息图片
      * */
     private String shopImgList;


    /**
     *   SKU类型[DEFAULT_SKU-默认规格 SINGLE_SKU-单层规格 DOUBLE_SKU-双层规格]
     */
    @NotBlank(message = "SKU类型不能为空！")
    private String skuType;

    /**
     *   商品分类ID
     *
     * 数据库字段名:dcdg_goods_goods_base.CAT_ID
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    @NotBlank(message = "商品分类ID不能为空")
    private String catId;

    /**
     *   分类路径
     *
     * 数据库字段名:dcdg_goods_goods_base.CAT_PATH
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    @NotBlank(message = "分类路径不能为空")
    private String catPath;

    /**
     *   商品品牌ID
     *
     * 数据库字段名:dcdg_goods_goods_base.BRAND_ID
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private String brandId;

    /**
     * 商品id(修改是必填)
     */
    private String goodsId;

    /**
     * 单规格商品skuId(修改是必填)
     */
    private String skuId;

    /**
     *   商品名称
     *
     * 数据库字段名:dcdg_goods_goods_base.GOODS_NAME
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    @NotBlank(message = "商品名称不能为空")
    private String goodsName;

    /**
     *   商品描述
     *
     * 数据库字段名:dcdg_goods_goods_base.GOODS_DESC
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    @NotBlank(message = "商品描述不能为空")
    private String goodsDesc;


    @NotNull(message = "总库存数量不能空")
    private Integer stockCount;

    /**
     *   最少购买数量
     *
     * 数据库字段名:dcdg_goods_goods_base.MIN_BUY
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    @NotNull(message = "最少购买数量不能为空！")
    private Integer minBuy;

    /**
     *   最大购买数量
     *
     * 数据库字段名:dcdg_goods_goods_base.MAX_BUY
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    @NotNull(message = "最大购买数量不能为空！")
    private Integer maxBuy;

    /**
     *   商品主图片
     *
     * 数据库字段名:dcdg_goods_goods_base.GOODS_IMG
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    @NotBlank(message = "商品主图片不能为空")
    private String goodsImg;
    /**
     * 图片集
     */
    @NotBlank(message = "图片集不能为空")
    private String goodsImgList;



    /**
     *   邮费
     *
     * 数据库字段名:dcdg_goods_goods_base.POST_FEE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    @NotNull(message = "邮费不能为空！")
    private Double postFee;

    /**
     *   二次邮费
     *
     * 数据库字段名:dcdg_goods_goods_base.POST_SECOND
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    @NotNull(message = "二次邮费不能为空！")
    private Double postSecond;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsImgList() {
        return goodsImgList;
    }

    public void setGoodsImgList(String goodsImgList) {
        this.goodsImgList = goodsImgList;
    }

    public String getGoodsTypeList() {
        return goodsTypeList;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public void setGoodsTypeList(String goodsTypeList) {
        this.goodsTypeList = goodsTypeList;
    }

    public String getSkuRuleList() {
        return skuRuleList;
    }

    public void setSkuRuleList(String skuRuleList) {
        this.skuRuleList = skuRuleList;
    }

    public String getIsPointList() {
        return isPointList;
    }

    public void setIsPointList(String isPointList) {
        this.isPointList = isPointList;
    }

    public String getMerattrList() {
        return merattrList;
    }

    public void setMerattrList(String merattrList) {
        this.merattrList = merattrList;
    }

   public String getTagsList() {
        return tagsList;
    }

    public void setTagsList(String tagsList) {
        this.tagsList = tagsList;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getWear() {
        return wear;
    }

    public void setWear(String wear) {
        this.wear = wear;
    }

    public String getWhole() {
        return whole;
    }

    public void setWhole(String whole) {
        this.whole = whole;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getBrank() {
        return brank;
    }

    public void setBrank(String brank) {
        this.brank = brank;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getOptNameList() {
        return optNameList;
    }

    public void setOptNameList(String optNameList) {
        this.optNameList = optNameList;
    }

    public String getQua() {
        return qua;
    }

    public void setQua(String qua) {
        this.qua = qua;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getProductImgList() {
        return productImgList;
    }

    public void setProductImgList(String productImgList) {
        this.productImgList = productImgList;
    }

    public String getSelfImgList() {
        return selfImgList;
    }

    public void setSelfImgList(String selfImgList) {
        this.selfImgList = selfImgList;
    }

    public String getWearImgList() {
        return wearImgList;
    }

    public void setWearImgList(String wearImgList) {
        this.wearImgList = wearImgList;
    }

    public String getWholeImgList() {
        return wholeImgList;
    }

    public void setWholeImgList(String wholeImgList) {
        this.wholeImgList = wholeImgList;
    }

    public String getDetailImgList() {
        return detailImgList;
    }

    public void setDetailImgList(String detailImgList) {
        this.detailImgList = detailImgList;
    }

    public String getBrankImgList() {
        return brankImgList;
    }

    public void setBrankImgList(String brankImgList) {
        this.brankImgList = brankImgList;
    }

    public String getPackImgList() {
        return packImgList;
    }

    public void setPackImgList(String packImgList) {
        this.packImgList = packImgList;
    }

    public String getServiceImgList() {
        return serviceImgList;
    }

    public void setServiceImgList(String serviceImgList) {
        this.serviceImgList = serviceImgList;
    }

    public String getQuaImgList() {
        return quaImgList;
    }

    public void setQuaImgList(String quaImgList) {
        this.quaImgList = quaImgList;
    }

    public String getShopImgList() {
        return shopImgList;
    }

    public void setShopImgList(String shopImgList) {
        this.shopImgList = shopImgList;
    }

    public String getStockList() {
        return stockList;
    }

    public void setStockList(String stockList) {
        this.stockList = stockList;
    }

    public String getCostList() {
        return costList;
    }

    public void setCostList(String costList) {
        this.costList = costList;
    }

    public String getMarketList() {
        return marketList;
    }

    public void setMarketList(String marketList) {
        this.marketList = marketList;
    }

    public String getMin_scoreList() {
        return min_scoreList;
    }

    public void setMin_scoreList(String min_scoreList) {
        this.min_scoreList = min_scoreList;
    }

    public String getEdaoList() {
        return edaoList;
    }

    public void setEdaoList(String edaoList) {
        this.edaoList = edaoList;
    }

    public String getSkuType() {
        return skuType;
    }

    public void setSkuType(String skuType) {
        this.skuType = skuType;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getCatPath() {
        return catPath;
    }

    public void setCatPath(String catPath) {
        this.catPath = catPath;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Integer getMinBuy() {
        return minBuy;
    }

    public void setMinBuy(Integer minBuy) {
        this.minBuy = minBuy;
    }

    public Integer getMaxBuy() {
        return maxBuy;
    }

    public void setMaxBuy(Integer maxBuy) {
        this.maxBuy = maxBuy;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Double getPostFee() {
        return postFee;
    }

    public void setPostFee(Double postFee) {
        this.postFee = postFee;
    }

    public Double getPostSecond() {
        return postSecond;
    }

    public void setPostSecond(Double postSecond) {
        this.postSecond = postSecond;
    }
}
