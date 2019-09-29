package com.louquanapp.dao.model;


import com.louquanapp.dao.extra.OrderItemExtra;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_bussiness_order_item
 *
 * @mbg.generated do_not_delete_during_merge Mon Apr 08 15:18:24 CST 2019
 */
public class OrderItem extends OrderItemExtra {
    /**
     * 主键
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.CHILD_ID
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private String childId;

    /**
     * 主订单ID
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.ORDER_ID
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private String orderId;

    /**
     * 商品ID
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.GOODS_ID
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private String goodsId;

    /**
     * 商品名称
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.GOODS_NAME
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private String goodsName;

    /**
     * 商品图片
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.GOODS_IMG
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private String goodsImg;

    /**
     * SKU编码
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.SKU_NO
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private String skuNo;

    /**
     * SKU编码值
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.SKU_VALUE
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private String skuValue;

    /**
     * 供货价
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.SUPPLY_PRICE
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private Double supplyPrice;

    /**
     * 商品单价
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.PUTAWAY_PRICE
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private Double putawayPrice;

    /**
     * 购买数量
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.GOODS_NUM
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private Integer goodsNum;

    /**
     * 子订单实付金额
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.TOTAL_FEE
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private Double totalFee;

    /**
     * 卖家调整金额
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.ADJUST_FEE
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private Double adjustFee;

    /**
     * 优惠金额
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.DISCOUNTS_FEE
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private Double discountsFee;

    /**
     * 优惠说明
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.DISCOUNTS_DESC
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private String discountsDesc;

    /**
     * 邮费
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.POST_FEE
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private Double postFee;

    /**
     * 安装费用
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.INSTALL_FEE
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private Double installFee;

    /**
     * 分销用户ID
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.DISTRIBUTOR_ID
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private String distributorId;

    /**
     * 创建时间
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.ADD_TIME
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private Date addTime;

    /**
     * 更新时间
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.UPDATE_TIME
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private Date updateTime;

    /**
     * 快递公司
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.POST_COMPANY
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private String postCompany;

    /**
     * 快递编码
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.POST_NO
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private String postNo;

    /**
     * 商品分类路径
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.CAT_PATH
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    private String catPath;

    /**
     * 数据库字段：主键dcdg_bussiness_order_item.CHILD_ID
     *
     * @return the value of dcdg_bussiness_order_item.CHILD_ID
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public String getChildId() {
        return childId;
    }

    /**
     * 数据库字段：主键dcdg_bussiness_order_item.CHILD_ID
     *
     * @param childId the value for dcdg_bussiness_order_item.CHILD_ID
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setChildId(String childId) {
        this.childId = childId == null ? null : childId.trim();
    }

    /**
     * 数据库字段：主订单IDdcdg_bussiness_order_item.ORDER_ID
     *
     * @return the value of dcdg_bussiness_order_item.ORDER_ID
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 数据库字段：主订单IDdcdg_bussiness_order_item.ORDER_ID
     *
     * @param orderId the value for dcdg_bussiness_order_item.ORDER_ID
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 数据库字段：商品IDdcdg_bussiness_order_item.GOODS_ID
     *
     * @return the value of dcdg_bussiness_order_item.GOODS_ID
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 数据库字段：商品IDdcdg_bussiness_order_item.GOODS_ID
     *
     * @param goodsId the value for dcdg_bussiness_order_item.GOODS_ID
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * 数据库字段：商品名称dcdg_bussiness_order_item.GOODS_NAME
     *
     * @return the value of dcdg_bussiness_order_item.GOODS_NAME
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 数据库字段：商品名称dcdg_bussiness_order_item.GOODS_NAME
     *
     * @param goodsName the value for dcdg_bussiness_order_item.GOODS_NAME
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * 数据库字段：商品图片dcdg_bussiness_order_item.GOODS_IMG
     *
     * @return the value of dcdg_bussiness_order_item.GOODS_IMG
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public String getGoodsImg() {
        return goodsImg;
    }

    /**
     * 数据库字段：商品图片dcdg_bussiness_order_item.GOODS_IMG
     *
     * @param goodsImg the value for dcdg_bussiness_order_item.GOODS_IMG
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    /**
     * 数据库字段：SKU编码dcdg_bussiness_order_item.SKU_NO
     *
     * @return the value of dcdg_bussiness_order_item.SKU_NO
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public String getSkuNo() {
        return skuNo;
    }

    /**
     * 数据库字段：SKU编码dcdg_bussiness_order_item.SKU_NO
     *
     * @param skuNo the value for dcdg_bussiness_order_item.SKU_NO
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo == null ? null : skuNo.trim();
    }

    /**
     * 数据库字段：SKU编码值dcdg_bussiness_order_item.SKU_VALUE
     *
     * @return the value of dcdg_bussiness_order_item.SKU_VALUE
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public String getSkuValue() {
        return skuValue;
    }

    /**
     * 数据库字段：SKU编码值dcdg_bussiness_order_item.SKU_VALUE
     *
     * @param skuValue the value for dcdg_bussiness_order_item.SKU_VALUE
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setSkuValue(String skuValue) {
        this.skuValue = skuValue == null ? null : skuValue.trim();
    }

    /**
     * 数据库字段：供货价dcdg_bussiness_order_item.SUPPLY_PRICE
     *
     * @return the value of dcdg_bussiness_order_item.SUPPLY_PRICE
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public Double getSupplyPrice() {
        return supplyPrice;
    }

    /**
     * 数据库字段：供货价dcdg_bussiness_order_item.SUPPLY_PRICE
     *
     * @param supplyPrice the value for dcdg_bussiness_order_item.SUPPLY_PRICE
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setSupplyPrice(Double supplyPrice) {
        this.supplyPrice = supplyPrice;
    }

    /**
     * 数据库字段：商品单价dcdg_bussiness_order_item.PUTAWAY_PRICE
     *
     * @return the value of dcdg_bussiness_order_item.PUTAWAY_PRICE
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public Double getPutawayPrice() {
        return putawayPrice;
    }

    /**
     * 数据库字段：商品单价dcdg_bussiness_order_item.PUTAWAY_PRICE
     *
     * @param putawayPrice the value for dcdg_bussiness_order_item.PUTAWAY_PRICE
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setPutawayPrice(Double putawayPrice) {
        this.putawayPrice = putawayPrice;
    }

    /**
     * 数据库字段：购买数量dcdg_bussiness_order_item.GOODS_NUM
     *
     * @return the value of dcdg_bussiness_order_item.GOODS_NUM
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public Integer getGoodsNum() {
        return goodsNum;
    }

    /**
     * 数据库字段：购买数量dcdg_bussiness_order_item.GOODS_NUM
     *
     * @param goodsNum the value for dcdg_bussiness_order_item.GOODS_NUM
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * 数据库字段：子订单实付金额dcdg_bussiness_order_item.TOTAL_FEE
     *
     * @return the value of dcdg_bussiness_order_item.TOTAL_FEE
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public Double getTotalFee() {
        return totalFee;
    }

    /**
     * 数据库字段：子订单实付金额dcdg_bussiness_order_item.TOTAL_FEE
     *
     * @param totalFee the value for dcdg_bussiness_order_item.TOTAL_FEE
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * 数据库字段：卖家调整金额dcdg_bussiness_order_item.ADJUST_FEE
     *
     * @return the value of dcdg_bussiness_order_item.ADJUST_FEE
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public Double getAdjustFee() {
        return adjustFee;
    }

    /**
     * 数据库字段：卖家调整金额dcdg_bussiness_order_item.ADJUST_FEE
     *
     * @param adjustFee the value for dcdg_bussiness_order_item.ADJUST_FEE
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setAdjustFee(Double adjustFee) {
        this.adjustFee = adjustFee;
    }

    /**
     * 数据库字段：优惠金额dcdg_bussiness_order_item.DISCOUNTS_FEE
     *
     * @return the value of dcdg_bussiness_order_item.DISCOUNTS_FEE
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public Double getDiscountsFee() {
        return discountsFee;
    }

    /**
     * 数据库字段：优惠金额dcdg_bussiness_order_item.DISCOUNTS_FEE
     *
     * @param discountsFee the value for dcdg_bussiness_order_item.DISCOUNTS_FEE
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setDiscountsFee(Double discountsFee) {
        this.discountsFee = discountsFee;
    }

    /**
     * 数据库字段：优惠说明dcdg_bussiness_order_item.DISCOUNTS_DESC
     *
     * @return the value of dcdg_bussiness_order_item.DISCOUNTS_DESC
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public String getDiscountsDesc() {
        return discountsDesc;
    }

    /**
     * 数据库字段：优惠说明dcdg_bussiness_order_item.DISCOUNTS_DESC
     *
     * @param discountsDesc the value for dcdg_bussiness_order_item.DISCOUNTS_DESC
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setDiscountsDesc(String discountsDesc) {
        this.discountsDesc = discountsDesc == null ? null : discountsDesc.trim();
    }

    /**
     * 数据库字段：邮费dcdg_bussiness_order_item.POST_FEE
     *
     * @return the value of dcdg_bussiness_order_item.POST_FEE
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public Double getPostFee() {
        return postFee;
    }

    /**
     * 数据库字段：邮费dcdg_bussiness_order_item.POST_FEE
     *
     * @param postFee the value for dcdg_bussiness_order_item.POST_FEE
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setPostFee(Double postFee) {
        this.postFee = postFee;
    }

    /**
     * 数据库字段：安装费用dcdg_bussiness_order_item.INSTALL_FEE
     *
     * @return the value of dcdg_bussiness_order_item.INSTALL_FEE
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public Double getInstallFee() {
        return installFee;
    }

    /**
     * 数据库字段：安装费用dcdg_bussiness_order_item.INSTALL_FEE
     *
     * @param installFee the value for dcdg_bussiness_order_item.INSTALL_FEE
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setInstallFee(Double installFee) {
        this.installFee = installFee;
    }

    /**
     * 数据库字段：分销用户IDdcdg_bussiness_order_item.DISTRIBUTOR_ID
     *
     * @return the value of dcdg_bussiness_order_item.DISTRIBUTOR_ID
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public String getDistributorId() {
        return distributorId;
    }

    /**
     * 数据库字段：分销用户IDdcdg_bussiness_order_item.DISTRIBUTOR_ID
     *
     * @param distributorId the value for dcdg_bussiness_order_item.DISTRIBUTOR_ID
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setDistributorId(String distributorId) {
        this.distributorId = distributorId == null ? null : distributorId.trim();
    }

    /**
     * 数据库字段：创建时间dcdg_bussiness_order_item.ADD_TIME
     *
     * @return the value of dcdg_bussiness_order_item.ADD_TIME
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：创建时间dcdg_bussiness_order_item.ADD_TIME
     *
     * @param addTime the value for dcdg_bussiness_order_item.ADD_TIME
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：更新时间dcdg_bussiness_order_item.UPDATE_TIME
     *
     * @return the value of dcdg_bussiness_order_item.UPDATE_TIME
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：更新时间dcdg_bussiness_order_item.UPDATE_TIME
     *
     * @param updateTime the value for dcdg_bussiness_order_item.UPDATE_TIME
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 数据库字段：快递公司dcdg_bussiness_order_item.POST_COMPANY
     *
     * @return the value of dcdg_bussiness_order_item.POST_COMPANY
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public String getPostCompany() {
        return postCompany;
    }

    /**
     * 数据库字段：快递公司dcdg_bussiness_order_item.POST_COMPANY
     *
     * @param postCompany the value for dcdg_bussiness_order_item.POST_COMPANY
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setPostCompany(String postCompany) {
        this.postCompany = postCompany == null ? null : postCompany.trim();
    }

    /**
     * 数据库字段：快递编码dcdg_bussiness_order_item.POST_NO
     *
     * @return the value of dcdg_bussiness_order_item.POST_NO
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public String getPostNo() {
        return postNo;
    }

    /**
     * 数据库字段：快递编码dcdg_bussiness_order_item.POST_NO
     *
     * @param postNo the value for dcdg_bussiness_order_item.POST_NO
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setPostNo(String postNo) {
        this.postNo = postNo == null ? null : postNo.trim();
    }

    /**
     * 数据库字段：商品分类路径dcdg_bussiness_order_item.CAT_PATH
     *
     * @return the value of dcdg_bussiness_order_item.CAT_PATH
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public String getCatPath() {
        return catPath;
    }

    /**
     * 数据库字段：商品分类路径dcdg_bussiness_order_item.CAT_PATH
     *
     * @param catPath the value for dcdg_bussiness_order_item.CAT_PATH
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    public void setCatPath(String catPath) {
        this.catPath = catPath == null ? null : catPath.trim();
    }

}