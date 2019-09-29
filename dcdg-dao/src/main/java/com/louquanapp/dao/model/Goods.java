package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.GoodsExtra;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_goods_goods_base
 *
 * @mbg.generated do_not_delete_during_merge Mon Aug 12 16:23:35 CST 2019
 */
public class Goods  extends GoodsExtra {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_goods_goods_base.GOODS_ID
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private String goodsId;

    /**
     *   商品类别[1-非自营 2-自营]
     *
     * 数据库字段名:dcdg_goods_goods_base.GOODS_TYPE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Byte goodsType;

    /**
     *   商品分类ID
     *
     * 数据库字段名:dcdg_goods_goods_base.CAT_ID
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private String catId;

    /**
     *   分类路径
     *
     * 数据库字段名:dcdg_goods_goods_base.CAT_PATH
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
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
     *   店铺ID
     *
     * 数据库字段名:dcdg_goods_goods_base.SHOP_ID
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private String shopId;

    /**
     *   店铺操作用户ID
     *
     * 数据库字段名:dcdg_goods_goods_base.SUSER_ID
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private String suserId;

    /**
     *   店铺操作用户名
     *
     * 数据库字段名:dcdg_goods_goods_base.SUSER_NAME
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private String suserName;

    /**
     *   商品名称
     *
     * 数据库字段名:dcdg_goods_goods_base.GOODS_NAME
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private String goodsName;

    /**
     *   是否热门[0-否 1-是]
     *
     * 数据库字段名:dcdg_goods_goods_base.IS_HOT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Byte isHot;

    /**
     *   是否新品[0-新品 1-否]
     *
     * 数据库字段名:dcdg_goods_goods_base.IS_NEW
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Byte isNew;

    /**
     *   是否推荐APP[1-推荐 2-不推荐 ]
     *
     * 数据库字段名:dcdg_goods_goods_base.IS_REC
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Byte isRec;

    /**
     *   商品描述
     *
     * 数据库字段名:dcdg_goods_goods_base.GOODS_DESC
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private String goodsDesc;

    /**
     *   库存数量
     *
     * 数据库字段名:dcdg_goods_goods_base.STOCK_COUNT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Integer stockCount;

    /**
     *   商品销售量
     *
     * 数据库字段名:dcdg_goods_goods_base.SALE_COUNT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Integer saleCount;

    /**
     *   商品评分次数
     *
     * 数据库字段名:dcdg_goods_goods_base.RATE_COUNT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Integer rateCount;

    /**
     *   浏览量
     *
     * 数据库字段名:dcdg_goods_goods_base.SKIM_COUNT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Integer skimCount;

    /**
     *   每次累加数量
     *
     * 数据库字段名:dcdg_goods_goods_base.INCREASE_COUNT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Integer increaseCount;

    /**
     *   收藏量
     *
     * 数据库字段名:dcdg_goods_goods_base.FAV_COUNT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Integer favCount;

    /**
     *   最少购买数量
     *
     * 数据库字段名:dcdg_goods_goods_base.MIN_BUY
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Integer minBuy;

    /**
     *   最大购买数量
     *
     * 数据库字段名:dcdg_goods_goods_base.MAX_BUY
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Integer maxBuy;

    /**
     *   消耗积分数
     *
     * 数据库字段名:dcdg_goods_goods_base.MAX_POINT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Double maxPoint;

    /**
     *   商品市场价
     *
     * 数据库字段名:dcdg_goods_goods_base.MARKET_PRICE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Double marketPrice;

    /**
     *   商品上架价格
     *
     * 数据库字段名:dcdg_goods_goods_base.PUTAWAY_PRICE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Double putawayPrice;

    /**
     *   操作类型[3-下架 4-上架]
     *
     * 数据库字段名:dcdg_goods_goods_base.PUTAWAY_FLAG
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Byte putawayFlag;

    /**
     *   SKU类型[DEFAULT_SKU-默认规格 SINGLE_SKU-单层规格 DOUBLE_SKU-双层规格]
     *
     * 数据库字段名:dcdg_goods_goods_base.SKU_TYPE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private String skuType;

    /**
     *   商品主图片
     *
     * 数据库字段名:dcdg_goods_goods_base.GOODS_IMG
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private String goodsImg;

    /**
     *   积分返回方式[0-未设定 1-分期返还 2-立送积分 3-不参与赠送积分]
     *
     * 数据库字段名:dcdg_goods_goods_base.POINT_BACK_TYPE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Byte pointBackType;

    /**
     *   返还积分数量
     *
     * 数据库字段名:dcdg_goods_goods_base.POINT_AMT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Double pointAmt;

    /**
     *   邮费
     *
     * 数据库字段名:dcdg_goods_goods_base.POST_FEE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Double postFee;

    /**
     *   二次邮费
     *
     * 数据库字段名:dcdg_goods_goods_base.POST_SECOND
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Double postSecond;

    /**
     *   安装费
     *
     * 数据库字段名:dcdg_goods_goods_base.INSTALL_FEE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Double installFee;

    /**
     *   创建时间
     *
     * 数据库字段名:dcdg_goods_goods_base.ADD_TIME
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Date addTime;

    /**
     *   更新时间
     *
     * 数据库字段名:dcdg_goods_goods_base.UPDATE_TIME
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Date updateTime;

    /**
     *   商品来源分类
     *
     * 数据库字段名:dcdg_goods_goods_base.SOURCE_TYPE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private String sourceType;

    /**
     *   备注
     *
     * 数据库字段名:dcdg_goods_goods_base.REMARK
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private String remark;

    /**
     *   审核人ID
     *
     * 数据库字段名:dcdg_goods_goods_base.AUDIT_ID
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private String auditId;

    /**
     *   审核人名称
     *
     * 数据库字段名:dcdg_goods_goods_base.AUDIT_NAME
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private String auditName;

    /**
     *   审核状态[2-待审核 3-审核不通过 4-审核通过]
     *
     * 数据库字段名:dcdg_goods_goods_base.AUDIT_STATUS
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Byte auditStatus;

    /**
     *   审核不通过原因
     *
     * 数据库字段名:dcdg_goods_goods_base.REFUSE_REASON
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private String refuseReason;

    /**
     *   审核时间
     *
     * 数据库字段名:dcdg_goods_goods_base.AUDIT_TIME
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Date auditTime;

    /**
     *   餐饮[1-是 2-否]
     *
     * 数据库字段名:dcdg_goods_goods_base.IS_PROMOTION
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Byte isPromotion;

    /**
     *   约会邦三人团购价
     *
     * 数据库字段名:dcdg_goods_goods_base.GROUP_PRICE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Double groupPrice;

    /**
     *   是否可以添加购物车[0-可以 1-不可以]
     *
     * 数据库字段名:dcdg_goods_goods_base.ADD_CART
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Byte addCart;

    /**
     *   允许付款方式[1-现金+消费积分 2-晨香积分+消费积分+现金 3-抵扣积分+消费积分+现金]
     *
     * 数据库字段名:dcdg_goods_goods_base.PAY_TYPE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Byte payType;

    /**
     *   供货价
     *
     * 数据库字段名:dcdg_goods_goods_base.PROVIDE_PRICE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Double providePrice;

    /**
     *   折
     *
     * 数据库字段名:dcdg_goods_goods_base.EARN
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Double earn;

    /**
     *   套餐商品明细
     *
     * 数据库字段名:dcdg_goods_goods_base.GROUP_GOODS
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private String groupGoods;

    /**
     *   是否热门兑换推荐[0-否 1-是]
     *
     * 数据库字段名:dcdg_goods_goods_base.IS_HOT_EXCHANGE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Byte isHotExchange;

    /**
     *   删除标记 [1-正常 2-删除]
     *
     * 数据库字段名:dcdg_goods_goods_base.DELT_FLAG
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    private Byte deltFlag;

    /**
     * 数据库字段：主键dcdg_goods_goods_base.GOODS_ID
     *
     * @return  the value of dcdg_goods_goods_base.GOODS_ID
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 数据库字段：主键dcdg_goods_goods_base.GOODS_ID
     * @param goodsId the value for dcdg_goods_goods_base.GOODS_ID
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * 数据库字段：商品类别[1-非自营 2-自营]dcdg_goods_goods_base.GOODS_TYPE
     *
     * @return  the value of dcdg_goods_goods_base.GOODS_TYPE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Byte getGoodsType() {
        return goodsType;
    }

    /**
     * 数据库字段：商品类别[1-非自营 2-自营]dcdg_goods_goods_base.GOODS_TYPE
     * @param goodsType the value for dcdg_goods_goods_base.GOODS_TYPE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setGoodsType(Byte goodsType) {
        this.goodsType = goodsType;
    }

    /**
     * 数据库字段：商品分类IDdcdg_goods_goods_base.CAT_ID
     *
     * @return  the value of dcdg_goods_goods_base.CAT_ID
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public String getCatId() {
        return catId;
    }

    /**
     * 数据库字段：商品分类IDdcdg_goods_goods_base.CAT_ID
     * @param catId the value for dcdg_goods_goods_base.CAT_ID
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setCatId(String catId) {
        this.catId = catId == null ? null : catId.trim();
    }

    /**
     * 数据库字段：分类路径dcdg_goods_goods_base.CAT_PATH
     *
     * @return  the value of dcdg_goods_goods_base.CAT_PATH
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public String getCatPath() {
        return catPath;
    }

    /**
     * 数据库字段：分类路径dcdg_goods_goods_base.CAT_PATH
     * @param catPath the value for dcdg_goods_goods_base.CAT_PATH
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setCatPath(String catPath) {
        this.catPath = catPath == null ? null : catPath.trim();
    }

    /**
     * 数据库字段：商品品牌IDdcdg_goods_goods_base.BRAND_ID
     *
     * @return  the value of dcdg_goods_goods_base.BRAND_ID
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public String getBrandId() {
        return brandId;
    }

    /**
     * 数据库字段：商品品牌IDdcdg_goods_goods_base.BRAND_ID
     * @param brandId the value for dcdg_goods_goods_base.BRAND_ID
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setBrandId(String brandId) {
        this.brandId = brandId == null ? null : brandId.trim();
    }

    /**
     * 数据库字段：店铺IDdcdg_goods_goods_base.SHOP_ID
     *
     * @return  the value of dcdg_goods_goods_base.SHOP_ID
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * 数据库字段：店铺IDdcdg_goods_goods_base.SHOP_ID
     * @param shopId the value for dcdg_goods_goods_base.SHOP_ID
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    /**
     * 数据库字段：店铺操作用户IDdcdg_goods_goods_base.SUSER_ID
     *
     * @return  the value of dcdg_goods_goods_base.SUSER_ID
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public String getSuserId() {
        return suserId;
    }

    /**
     * 数据库字段：店铺操作用户IDdcdg_goods_goods_base.SUSER_ID
     * @param suserId the value for dcdg_goods_goods_base.SUSER_ID
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setSuserId(String suserId) {
        this.suserId = suserId == null ? null : suserId.trim();
    }

    /**
     * 数据库字段：店铺操作用户名dcdg_goods_goods_base.SUSER_NAME
     *
     * @return  the value of dcdg_goods_goods_base.SUSER_NAME
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public String getSuserName() {
        return suserName;
    }

    /**
     * 数据库字段：店铺操作用户名dcdg_goods_goods_base.SUSER_NAME
     * @param suserName the value for dcdg_goods_goods_base.SUSER_NAME
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setSuserName(String suserName) {
        this.suserName = suserName == null ? null : suserName.trim();
    }

    /**
     * 数据库字段：商品名称dcdg_goods_goods_base.GOODS_NAME
     *
     * @return  the value of dcdg_goods_goods_base.GOODS_NAME
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 数据库字段：商品名称dcdg_goods_goods_base.GOODS_NAME
     * @param goodsName the value for dcdg_goods_goods_base.GOODS_NAME
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * 数据库字段：是否热门[0-否 1-是]dcdg_goods_goods_base.IS_HOT
     *
     * @return  the value of dcdg_goods_goods_base.IS_HOT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Byte getIsHot() {
        return isHot;
    }

    /**
     * 数据库字段：是否热门[0-否 1-是]dcdg_goods_goods_base.IS_HOT
     * @param isHot the value for dcdg_goods_goods_base.IS_HOT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setIsHot(Byte isHot) {
        this.isHot = isHot;
    }

    /**
     * 数据库字段：是否新品[0-新品 1-否]dcdg_goods_goods_base.IS_NEW
     *
     * @return  the value of dcdg_goods_goods_base.IS_NEW
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Byte getIsNew() {
        return isNew;
    }

    /**
     * 数据库字段：是否新品[0-新品 1-否]dcdg_goods_goods_base.IS_NEW
     * @param isNew the value for dcdg_goods_goods_base.IS_NEW
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setIsNew(Byte isNew) {
        this.isNew = isNew;
    }

    /**
     * 数据库字段：是否推荐APP[1-推荐 2-不推荐 ]dcdg_goods_goods_base.IS_REC
     *
     * @return  the value of dcdg_goods_goods_base.IS_REC
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Byte getIsRec() {
        return isRec;
    }

    /**
     * 数据库字段：是否推荐APP[1-推荐 2-不推荐 ]dcdg_goods_goods_base.IS_REC
     * @param isRec the value for dcdg_goods_goods_base.IS_REC
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setIsRec(Byte isRec) {
        this.isRec = isRec;
    }

    /**
     * 数据库字段：商品描述dcdg_goods_goods_base.GOODS_DESC
     *
     * @return  the value of dcdg_goods_goods_base.GOODS_DESC
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public String getGoodsDesc() {
        return goodsDesc;
    }

    /**
     * 数据库字段：商品描述dcdg_goods_goods_base.GOODS_DESC
     * @param goodsDesc the value for dcdg_goods_goods_base.GOODS_DESC
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc == null ? null : goodsDesc.trim();
    }

    /**
     * 数据库字段：库存数量dcdg_goods_goods_base.STOCK_COUNT
     *
     * @return  the value of dcdg_goods_goods_base.STOCK_COUNT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Integer getStockCount() {
        return stockCount;
    }

    /**
     * 数据库字段：库存数量dcdg_goods_goods_base.STOCK_COUNT
     * @param stockCount the value for dcdg_goods_goods_base.STOCK_COUNT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    /**
     * 数据库字段：商品销售量dcdg_goods_goods_base.SALE_COUNT
     *
     * @return  the value of dcdg_goods_goods_base.SALE_COUNT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Integer getSaleCount() {
        return saleCount;
    }

    /**
     * 数据库字段：商品销售量dcdg_goods_goods_base.SALE_COUNT
     * @param saleCount the value for dcdg_goods_goods_base.SALE_COUNT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    /**
     * 数据库字段：商品评分次数dcdg_goods_goods_base.RATE_COUNT
     *
     * @return  the value of dcdg_goods_goods_base.RATE_COUNT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Integer getRateCount() {
        return rateCount;
    }

    /**
     * 数据库字段：商品评分次数dcdg_goods_goods_base.RATE_COUNT
     * @param rateCount the value for dcdg_goods_goods_base.RATE_COUNT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setRateCount(Integer rateCount) {
        this.rateCount = rateCount;
    }

    /**
     * 数据库字段：浏览量dcdg_goods_goods_base.SKIM_COUNT
     *
     * @return  the value of dcdg_goods_goods_base.SKIM_COUNT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Integer getSkimCount() {
        return skimCount;
    }

    /**
     * 数据库字段：浏览量dcdg_goods_goods_base.SKIM_COUNT
     * @param skimCount the value for dcdg_goods_goods_base.SKIM_COUNT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setSkimCount(Integer skimCount) {
        this.skimCount = skimCount;
    }

    /**
     * 数据库字段：每次累加数量dcdg_goods_goods_base.INCREASE_COUNT
     *
     * @return  the value of dcdg_goods_goods_base.INCREASE_COUNT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Integer getIncreaseCount() {
        return increaseCount;
    }

    /**
     * 数据库字段：每次累加数量dcdg_goods_goods_base.INCREASE_COUNT
     * @param increaseCount the value for dcdg_goods_goods_base.INCREASE_COUNT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setIncreaseCount(Integer increaseCount) {
        this.increaseCount = increaseCount;
    }

    /**
     * 数据库字段：收藏量dcdg_goods_goods_base.FAV_COUNT
     *
     * @return  the value of dcdg_goods_goods_base.FAV_COUNT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Integer getFavCount() {
        return favCount;
    }

    /**
     * 数据库字段：收藏量dcdg_goods_goods_base.FAV_COUNT
     * @param favCount the value for dcdg_goods_goods_base.FAV_COUNT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setFavCount(Integer favCount) {
        this.favCount = favCount;
    }

    /**
     * 数据库字段：最少购买数量dcdg_goods_goods_base.MIN_BUY
     *
     * @return  the value of dcdg_goods_goods_base.MIN_BUY
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Integer getMinBuy() {
        return minBuy;
    }

    /**
     * 数据库字段：最少购买数量dcdg_goods_goods_base.MIN_BUY
     * @param minBuy the value for dcdg_goods_goods_base.MIN_BUY
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setMinBuy(Integer minBuy) {
        this.minBuy = minBuy;
    }

    /**
     * 数据库字段：最大购买数量dcdg_goods_goods_base.MAX_BUY
     *
     * @return  the value of dcdg_goods_goods_base.MAX_BUY
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Integer getMaxBuy() {
        return maxBuy;
    }

    /**
     * 数据库字段：最大购买数量dcdg_goods_goods_base.MAX_BUY
     * @param maxBuy the value for dcdg_goods_goods_base.MAX_BUY
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setMaxBuy(Integer maxBuy) {
        this.maxBuy = maxBuy;
    }

    /**
     * 数据库字段：消耗积分数dcdg_goods_goods_base.MAX_POINT
     *
     * @return  the value of dcdg_goods_goods_base.MAX_POINT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Double getMaxPoint() {
        return maxPoint;
    }

    /**
     * 数据库字段：消耗积分数dcdg_goods_goods_base.MAX_POINT
     * @param maxPoint the value for dcdg_goods_goods_base.MAX_POINT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setMaxPoint(Double maxPoint) {
        this.maxPoint = maxPoint;
    }

    /**
     * 数据库字段：商品市场价dcdg_goods_goods_base.MARKET_PRICE
     *
     * @return  the value of dcdg_goods_goods_base.MARKET_PRICE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Double getMarketPrice() {
        return marketPrice;
    }

    /**
     * 数据库字段：商品市场价dcdg_goods_goods_base.MARKET_PRICE
     * @param marketPrice the value for dcdg_goods_goods_base.MARKET_PRICE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * 数据库字段：商品上架价格dcdg_goods_goods_base.PUTAWAY_PRICE
     *
     * @return  the value of dcdg_goods_goods_base.PUTAWAY_PRICE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Double getPutawayPrice() {
        return putawayPrice;
    }

    /**
     * 数据库字段：商品上架价格dcdg_goods_goods_base.PUTAWAY_PRICE
     * @param putawayPrice the value for dcdg_goods_goods_base.PUTAWAY_PRICE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setPutawayPrice(Double putawayPrice) {
        this.putawayPrice = putawayPrice;
    }

    /**
     * 数据库字段：操作类型[3-下架 4-上架]dcdg_goods_goods_base.PUTAWAY_FLAG
     *
     * @return  the value of dcdg_goods_goods_base.PUTAWAY_FLAG
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Byte getPutawayFlag() {
        return putawayFlag;
    }

    /**
     * 数据库字段：操作类型[3-下架 4-上架]dcdg_goods_goods_base.PUTAWAY_FLAG
     * @param putawayFlag the value for dcdg_goods_goods_base.PUTAWAY_FLAG
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setPutawayFlag(Byte putawayFlag) {
        this.putawayFlag = putawayFlag;
    }

    /**
     * 数据库字段：SKU类型[DEFAULT_SKU-默认规格 SINGLE_SKU-单层规格 DOUBLE_SKU-双层规格]dcdg_goods_goods_base.SKU_TYPE
     *
     * @return  the value of dcdg_goods_goods_base.SKU_TYPE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public String getSkuType() {
        return skuType;
    }

    /**
     * 数据库字段：SKU类型[DEFAULT_SKU-默认规格 SINGLE_SKU-单层规格 DOUBLE_SKU-双层规格]dcdg_goods_goods_base.SKU_TYPE
     * @param skuType the value for dcdg_goods_goods_base.SKU_TYPE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setSkuType(String skuType) {
        this.skuType = skuType == null ? null : skuType.trim();
    }

    /**
     * 数据库字段：商品主图片dcdg_goods_goods_base.GOODS_IMG
     *
     * @return  the value of dcdg_goods_goods_base.GOODS_IMG
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public String getGoodsImg() {
        return goodsImg;
    }

    /**
     * 数据库字段：商品主图片dcdg_goods_goods_base.GOODS_IMG
     * @param goodsImg the value for dcdg_goods_goods_base.GOODS_IMG
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    /**
     * 数据库字段：积分返回方式[0-未设定 1-分期返还 2-立送积分 3-不参与赠送积分]dcdg_goods_goods_base.POINT_BACK_TYPE
     *
     * @return  the value of dcdg_goods_goods_base.POINT_BACK_TYPE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Byte getPointBackType() {
        return pointBackType;
    }

    /**
     * 数据库字段：积分返回方式[0-未设定 1-分期返还 2-立送积分 3-不参与赠送积分]dcdg_goods_goods_base.POINT_BACK_TYPE
     * @param pointBackType the value for dcdg_goods_goods_base.POINT_BACK_TYPE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setPointBackType(Byte pointBackType) {
        this.pointBackType = pointBackType;
    }

    /**
     * 数据库字段：返还积分数量dcdg_goods_goods_base.POINT_AMT
     *
     * @return  the value of dcdg_goods_goods_base.POINT_AMT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Double getPointAmt() {
        return pointAmt;
    }

    /**
     * 数据库字段：返还积分数量dcdg_goods_goods_base.POINT_AMT
     * @param pointAmt the value for dcdg_goods_goods_base.POINT_AMT
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setPointAmt(Double pointAmt) {
        this.pointAmt = pointAmt;
    }

    /**
     * 数据库字段：邮费dcdg_goods_goods_base.POST_FEE
     *
     * @return  the value of dcdg_goods_goods_base.POST_FEE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Double getPostFee() {
        return postFee;
    }

    /**
     * 数据库字段：邮费dcdg_goods_goods_base.POST_FEE
     * @param postFee the value for dcdg_goods_goods_base.POST_FEE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setPostFee(Double postFee) {
        this.postFee = postFee;
    }

    /**
     * 数据库字段：二次邮费dcdg_goods_goods_base.POST_SECOND
     *
     * @return  the value of dcdg_goods_goods_base.POST_SECOND
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Double getPostSecond() {
        return postSecond;
    }

    /**
     * 数据库字段：二次邮费dcdg_goods_goods_base.POST_SECOND
     * @param postSecond the value for dcdg_goods_goods_base.POST_SECOND
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setPostSecond(Double postSecond) {
        this.postSecond = postSecond;
    }

    /**
     * 数据库字段：安装费dcdg_goods_goods_base.INSTALL_FEE
     *
     * @return  the value of dcdg_goods_goods_base.INSTALL_FEE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Double getInstallFee() {
        return installFee;
    }

    /**
     * 数据库字段：安装费dcdg_goods_goods_base.INSTALL_FEE
     * @param installFee the value for dcdg_goods_goods_base.INSTALL_FEE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setInstallFee(Double installFee) {
        this.installFee = installFee;
    }

    /**
     * 数据库字段：创建时间dcdg_goods_goods_base.ADD_TIME
     *
     * @return  the value of dcdg_goods_goods_base.ADD_TIME
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：创建时间dcdg_goods_goods_base.ADD_TIME
     * @param addTime the value for dcdg_goods_goods_base.ADD_TIME
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：更新时间dcdg_goods_goods_base.UPDATE_TIME
     *
     * @return  the value of dcdg_goods_goods_base.UPDATE_TIME
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：更新时间dcdg_goods_goods_base.UPDATE_TIME
     * @param updateTime the value for dcdg_goods_goods_base.UPDATE_TIME
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 数据库字段：商品来源分类dcdg_goods_goods_base.SOURCE_TYPE
     *
     * @return  the value of dcdg_goods_goods_base.SOURCE_TYPE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * 数据库字段：商品来源分类dcdg_goods_goods_base.SOURCE_TYPE
     * @param sourceType the value for dcdg_goods_goods_base.SOURCE_TYPE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    /**
     * 数据库字段：备注dcdg_goods_goods_base.REMARK
     *
     * @return  the value of dcdg_goods_goods_base.REMARK
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 数据库字段：备注dcdg_goods_goods_base.REMARK
     * @param remark the value for dcdg_goods_goods_base.REMARK
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 数据库字段：审核人IDdcdg_goods_goods_base.AUDIT_ID
     *
     * @return  the value of dcdg_goods_goods_base.AUDIT_ID
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public String getAuditId() {
        return auditId;
    }

    /**
     * 数据库字段：审核人IDdcdg_goods_goods_base.AUDIT_ID
     * @param auditId the value for dcdg_goods_goods_base.AUDIT_ID
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setAuditId(String auditId) {
        this.auditId = auditId == null ? null : auditId.trim();
    }

    /**
     * 数据库字段：审核人名称dcdg_goods_goods_base.AUDIT_NAME
     *
     * @return  the value of dcdg_goods_goods_base.AUDIT_NAME
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public String getAuditName() {
        return auditName;
    }

    /**
     * 数据库字段：审核人名称dcdg_goods_goods_base.AUDIT_NAME
     * @param auditName the value for dcdg_goods_goods_base.AUDIT_NAME
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setAuditName(String auditName) {
        this.auditName = auditName == null ? null : auditName.trim();
    }

    /**
     * 数据库字段：审核状态[2-待审核 3-审核不通过 4-审核通过]dcdg_goods_goods_base.AUDIT_STATUS
     *
     * @return  the value of dcdg_goods_goods_base.AUDIT_STATUS
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Byte getAuditStatus() {
        return auditStatus;
    }

    /**
     * 数据库字段：审核状态[2-待审核 3-审核不通过 4-审核通过]dcdg_goods_goods_base.AUDIT_STATUS
     * @param auditStatus the value for dcdg_goods_goods_base.AUDIT_STATUS
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 数据库字段：审核不通过原因dcdg_goods_goods_base.REFUSE_REASON
     *
     * @return  the value of dcdg_goods_goods_base.REFUSE_REASON
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public String getRefuseReason() {
        return refuseReason;
    }

    /**
     * 数据库字段：审核不通过原因dcdg_goods_goods_base.REFUSE_REASON
     * @param refuseReason the value for dcdg_goods_goods_base.REFUSE_REASON
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason == null ? null : refuseReason.trim();
    }

    /**
     * 数据库字段：审核时间dcdg_goods_goods_base.AUDIT_TIME
     *
     * @return  the value of dcdg_goods_goods_base.AUDIT_TIME
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 数据库字段：审核时间dcdg_goods_goods_base.AUDIT_TIME
     * @param auditTime the value for dcdg_goods_goods_base.AUDIT_TIME
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 数据库字段：餐饮[1-是 2-否]dcdg_goods_goods_base.IS_PROMOTION
     *
     * @return  the value of dcdg_goods_goods_base.IS_PROMOTION
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Byte getIsPromotion() {
        return isPromotion;
    }

    /**
     * 数据库字段：餐饮[1-是 2-否]dcdg_goods_goods_base.IS_PROMOTION
     * @param isPromotion the value for dcdg_goods_goods_base.IS_PROMOTION
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setIsPromotion(Byte isPromotion) {
        this.isPromotion = isPromotion;
    }

    /**
     * 数据库字段：约会邦三人团购价dcdg_goods_goods_base.GROUP_PRICE
     *
     * @return  the value of dcdg_goods_goods_base.GROUP_PRICE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Double getGroupPrice() {
        return groupPrice;
    }

    /**
     * 数据库字段：约会邦三人团购价dcdg_goods_goods_base.GROUP_PRICE
     * @param groupPrice the value for dcdg_goods_goods_base.GROUP_PRICE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setGroupPrice(Double groupPrice) {
        this.groupPrice = groupPrice;
    }

    /**
     * 数据库字段：是否可以添加购物车[0-可以 1-不可以]dcdg_goods_goods_base.ADD_CART
     *
     * @return  the value of dcdg_goods_goods_base.ADD_CART
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Byte getAddCart() {
        return addCart;
    }

    /**
     * 数据库字段：是否可以添加购物车[0-可以 1-不可以]dcdg_goods_goods_base.ADD_CART
     * @param addCart the value for dcdg_goods_goods_base.ADD_CART
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setAddCart(Byte addCart) {
        this.addCart = addCart;
    }

    /**
     * 数据库字段：允许付款方式[1-现金+消费积分 2-晨香积分+消费积分+现金 3-抵扣积分+消费积分+现金]dcdg_goods_goods_base.PAY_TYPE
     *
     * @return  the value of dcdg_goods_goods_base.PAY_TYPE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Byte getPayType() {
        return payType;
    }

    /**
     * 数据库字段：允许付款方式[1-现金+消费积分 2-晨香积分+消费积分+现金 3-抵扣积分+消费积分+现金]dcdg_goods_goods_base.PAY_TYPE
     * @param payType the value for dcdg_goods_goods_base.PAY_TYPE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    /**
     * 数据库字段：供货价dcdg_goods_goods_base.PROVIDE_PRICE
     *
     * @return  the value of dcdg_goods_goods_base.PROVIDE_PRICE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Double getProvidePrice() {
        return providePrice;
    }

    /**
     * 数据库字段：供货价dcdg_goods_goods_base.PROVIDE_PRICE
     * @param providePrice the value for dcdg_goods_goods_base.PROVIDE_PRICE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setProvidePrice(Double providePrice) {
        this.providePrice = providePrice;
    }

    /**
     * 数据库字段：折dcdg_goods_goods_base.EARN
     *
     * @return  the value of dcdg_goods_goods_base.EARN
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Double getEarn() {
        return earn;
    }

    /**
     * 数据库字段：折dcdg_goods_goods_base.EARN
     * @param earn the value for dcdg_goods_goods_base.EARN
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setEarn(Double earn) {
        this.earn = earn;
    }

    /**
     * 数据库字段：套餐商品明细dcdg_goods_goods_base.GROUP_GOODS
     *
     * @return  the value of dcdg_goods_goods_base.GROUP_GOODS
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public String getGroupGoods() {
        return groupGoods;
    }

    /**
     * 数据库字段：套餐商品明细dcdg_goods_goods_base.GROUP_GOODS
     * @param groupGoods the value for dcdg_goods_goods_base.GROUP_GOODS
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setGroupGoods(String groupGoods) {
        this.groupGoods = groupGoods == null ? null : groupGoods.trim();
    }

    /**
     * 数据库字段：是否热门兑换推荐[0-否 1-是]dcdg_goods_goods_base.IS_HOT_EXCHANGE
     *
     * @return  the value of dcdg_goods_goods_base.IS_HOT_EXCHANGE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Byte getIsHotExchange() {
        return isHotExchange;
    }

    /**
     * 数据库字段：是否热门兑换推荐[0-否 1-是]dcdg_goods_goods_base.IS_HOT_EXCHANGE
     * @param isHotExchange the value for dcdg_goods_goods_base.IS_HOT_EXCHANGE
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setIsHotExchange(Byte isHotExchange) {
        this.isHotExchange = isHotExchange;
    }

    /**
     * 数据库字段：删除标记 [1-正常 2-删除]dcdg_goods_goods_base.DELT_FLAG
     *
     * @return  the value of dcdg_goods_goods_base.DELT_FLAG
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public Byte getDeltFlag() {
        return deltFlag;
    }

    /**
     * 数据库字段：删除标记 [1-正常 2-删除]dcdg_goods_goods_base.DELT_FLAG
     * @param deltFlag the value for dcdg_goods_goods_base.DELT_FLAG
     *
     * @mbg.generated Mon Aug 12 16:23:35 CST 2019
     */
    public void setDeltFlag(Byte deltFlag) {
        this.deltFlag = deltFlag;
    }
}