package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.BuyCartExtra;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_bussiness_customer_buycart
 *
 * @mbg.generated do_not_delete_during_merge Thu Apr 25 16:20:54 CST 2019
 */
public class BuyCart extends BuyCartExtra {
    /**
     * 主键
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_buycart.CART_ID
     *
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    private String cartId;

    /**
     * 客户ID
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_buycart.CUST_ID
     *
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    private String custId;

    /**
     * 商家ID
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_buycart.SHOP_ID
     *
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    private String shopId;

    /**
     * 商品ID
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_buycart.GOODS_ID
     *
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    private String goodsId;

    /**
     * 商品SKU编码
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_buycart.GOODS_SKU
     *
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    private String goodsSku;

    /**
     * 商品数量
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_buycart.GOODS_NUM
     *
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    private Integer goodsNum;

    /**
     * 添加时间
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_buycart.ADD_TIME
     *
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    private Date addTime;

    /**
     * [1-购物车 2-立即购买]
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_buycart.CART_FLAG
     *
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    private Byte cartFlag;

    /**
     * 餐饮[1-是 2-否]
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_buycart.IS_PROMOTION
     *
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    private Byte isPromotion;

    /**
     * 数据库字段：主键dcdg_bussiness_customer_buycart.CART_ID
     *
     * @return the value of dcdg_bussiness_customer_buycart.CART_ID
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    public String getCartId() {
        return cartId;
    }

    /**
     * 数据库字段：主键dcdg_bussiness_customer_buycart.CART_ID
     *
     * @param cartId the value for dcdg_bussiness_customer_buycart.CART_ID
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    public void setCartId(String cartId) {
        this.cartId = cartId == null ? null : cartId.trim();
    }

    /**
     * 数据库字段：客户IDdcdg_bussiness_customer_buycart.CUST_ID
     *
     * @return the value of dcdg_bussiness_customer_buycart.CUST_ID
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：客户IDdcdg_bussiness_customer_buycart.CUST_ID
     *
     * @param custId the value for dcdg_bussiness_customer_buycart.CUST_ID
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：商家IDdcdg_bussiness_customer_buycart.SHOP_ID
     *
     * @return the value of dcdg_bussiness_customer_buycart.SHOP_ID
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * 数据库字段：商家IDdcdg_bussiness_customer_buycart.SHOP_ID
     *
     * @param shopId the value for dcdg_bussiness_customer_buycart.SHOP_ID
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    /**
     * 数据库字段：商品IDdcdg_bussiness_customer_buycart.GOODS_ID
     *
     * @return the value of dcdg_bussiness_customer_buycart.GOODS_ID
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 数据库字段：商品IDdcdg_bussiness_customer_buycart.GOODS_ID
     *
     * @param goodsId the value for dcdg_bussiness_customer_buycart.GOODS_ID
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * 数据库字段：商品SKU编码dcdg_bussiness_customer_buycart.GOODS_SKU
     *
     * @return the value of dcdg_bussiness_customer_buycart.GOODS_SKU
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    public String getGoodsSku() {
        return goodsSku;
    }

    /**
     * 数据库字段：商品SKU编码dcdg_bussiness_customer_buycart.GOODS_SKU
     *
     * @param goodsSku the value for dcdg_bussiness_customer_buycart.GOODS_SKU
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    public void setGoodsSku(String goodsSku) {
        this.goodsSku = goodsSku == null ? null : goodsSku.trim();
    }

    /**
     * 数据库字段：商品数量dcdg_bussiness_customer_buycart.GOODS_NUM
     *
     * @return the value of dcdg_bussiness_customer_buycart.GOODS_NUM
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    public Integer getGoodsNum() {
        return goodsNum;
    }

    /**
     * 数据库字段：商品数量dcdg_bussiness_customer_buycart.GOODS_NUM
     *
     * @param goodsNum the value for dcdg_bussiness_customer_buycart.GOODS_NUM
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * 数据库字段：添加时间dcdg_bussiness_customer_buycart.ADD_TIME
     *
     * @return the value of dcdg_bussiness_customer_buycart.ADD_TIME
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_bussiness_customer_buycart.ADD_TIME
     *
     * @param addTime the value for dcdg_bussiness_customer_buycart.ADD_TIME
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：[1-购物车 2-立即购买]dcdg_bussiness_customer_buycart.CART_FLAG
     *
     * @return the value of dcdg_bussiness_customer_buycart.CART_FLAG
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    public Byte getCartFlag() {
        return cartFlag;
    }

    /**
     * 数据库字段：[1-购物车 2-立即购买]dcdg_bussiness_customer_buycart.CART_FLAG
     *
     * @param cartFlag the value for dcdg_bussiness_customer_buycart.CART_FLAG
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    public void setCartFlag(Byte cartFlag) {
        this.cartFlag = cartFlag;
    }

    /**
     * 数据库字段：餐饮[1-是 2-否]dcdg_bussiness_customer_buycart.IS_PROMOTION
     *
     * @return the value of dcdg_bussiness_customer_buycart.IS_PROMOTION
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    public Byte getIsPromotion() {
        return isPromotion;
    }

    /**
     * 数据库字段：餐饮[1-是 2-否]dcdg_bussiness_customer_buycart.IS_PROMOTION
     *
     * @param isPromotion the value for dcdg_bussiness_customer_buycart.IS_PROMOTION
     * @mbg.generated Thu Apr 25 16:20:54 CST 2019
     */
    public void setIsPromotion(Byte isPromotion) {
        this.isPromotion = isPromotion;
    }
}