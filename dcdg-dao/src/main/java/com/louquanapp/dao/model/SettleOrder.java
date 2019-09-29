package com.louquanapp.dao.model;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_settle_settleorder_base
 *
 * @mbg.generated do_not_delete_during_merge Fri Apr 26 14:41:19 CST 2019
 */
public class SettleOrder {
    /**
     *   标识
     *
     * 数据库字段名:dcdg_settle_settleorder_base.SETTLE_ID
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    private String settleId;

    /**
     *   订单编号
     *
     * 数据库字段名:dcdg_settle_settleorder_base.ORDER_ID
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    private String orderId;

    /**
     *   销量
     *
     * 数据库字段名:dcdg_settle_settleorder_base.GOODS_NUM
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    private Integer goodsNum;

    /**
     *   商家
     *
     * 数据库字段名:dcdg_settle_settleorder_base.SHOP_ID
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    private String shopId;

    /**
     *   商家名称
     *
     * 数据库字段名:dcdg_settle_settleorder_base.SHOP_NAME
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    private String shopName;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_settle_settleorder_base.ADD_TIME
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    private Date addTime;

    /**
     *   最后结算时间
     *
     * 数据库字段名:dcdg_settle_settleorder_base.END_TIME
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    private Date endTime;

    /**
     *   分摊积分
     *
     * 数据库字段名:dcdg_settle_settleorder_base.DEDUCTION_POINT
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    private Double deductionPoint;

    /**
     *   分摊余额
     *
     * 数据库字段名:dcdg_settle_settleorder_base.CONSUME_POINT
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    private Double consumePoint;

    /**
     *   分摊余额
     *
     * 数据库字段名:dcdg_settle_settleorder_base.RMT_AMT
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    private Double rmtAmt;

    /**
     *   结算状态[1-未结算 2-已结算 3-暂停结算]
     *
     * 数据库字段名:dcdg_settle_settleorder_base.SETTLE_STATUS
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    private Byte settleStatus;

    /**
     *   餐饮[1-是 2-否]
     *
     * 数据库字段名:dcdg_settle_settleorder_base.IS_PROMOTION
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    private Byte isPromotion;

    /**
     * 数据库字段：标识dcdg_settle_settleorder_base.SETTLE_ID
     *
     * @return  the value of dcdg_settle_settleorder_base.SETTLE_ID
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public String getSettleId() {
        return settleId;
    }

    /**
     * 数据库字段：标识dcdg_settle_settleorder_base.SETTLE_ID
     * @param settleId the value for dcdg_settle_settleorder_base.SETTLE_ID
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public void setSettleId(String settleId) {
        this.settleId = settleId == null ? null : settleId.trim();
    }

    /**
     * 数据库字段：订单编号dcdg_settle_settleorder_base.ORDER_ID
     *
     * @return  the value of dcdg_settle_settleorder_base.ORDER_ID
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 数据库字段：订单编号dcdg_settle_settleorder_base.ORDER_ID
     * @param orderId the value for dcdg_settle_settleorder_base.ORDER_ID
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 数据库字段：销量dcdg_settle_settleorder_base.GOODS_NUM
     *
     * @return  the value of dcdg_settle_settleorder_base.GOODS_NUM
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public Integer getGoodsNum() {
        return goodsNum;
    }

    /**
     * 数据库字段：销量dcdg_settle_settleorder_base.GOODS_NUM
     * @param goodsNum the value for dcdg_settle_settleorder_base.GOODS_NUM
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * 数据库字段：商家dcdg_settle_settleorder_base.SHOP_ID
     *
     * @return  the value of dcdg_settle_settleorder_base.SHOP_ID
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * 数据库字段：商家dcdg_settle_settleorder_base.SHOP_ID
     * @param shopId the value for dcdg_settle_settleorder_base.SHOP_ID
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    /**
     * 数据库字段：商家名称dcdg_settle_settleorder_base.SHOP_NAME
     *
     * @return  the value of dcdg_settle_settleorder_base.SHOP_NAME
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 数据库字段：商家名称dcdg_settle_settleorder_base.SHOP_NAME
     * @param shopName the value for dcdg_settle_settleorder_base.SHOP_NAME
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 数据库字段：添加时间dcdg_settle_settleorder_base.ADD_TIME
     *
     * @return  the value of dcdg_settle_settleorder_base.ADD_TIME
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_settle_settleorder_base.ADD_TIME
     * @param addTime the value for dcdg_settle_settleorder_base.ADD_TIME
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：最后结算时间dcdg_settle_settleorder_base.END_TIME
     *
     * @return  the value of dcdg_settle_settleorder_base.END_TIME
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 数据库字段：最后结算时间dcdg_settle_settleorder_base.END_TIME
     * @param endTime the value for dcdg_settle_settleorder_base.END_TIME
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 数据库字段：分摊积分dcdg_settle_settleorder_base.DEDUCTION_POINT
     *
     * @return  the value of dcdg_settle_settleorder_base.DEDUCTION_POINT
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public Double getDeductionPoint() {
        return deductionPoint;
    }

    /**
     * 数据库字段：分摊积分dcdg_settle_settleorder_base.DEDUCTION_POINT
     * @param deductionPoint the value for dcdg_settle_settleorder_base.DEDUCTION_POINT
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public void setDeductionPoint(Double deductionPoint) {
        this.deductionPoint = deductionPoint;
    }

    /**
     * 数据库字段：分摊余额dcdg_settle_settleorder_base.CONSUME_POINT
     *
     * @return  the value of dcdg_settle_settleorder_base.CONSUME_POINT
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public Double getConsumePoint() {
        return consumePoint;
    }

    /**
     * 数据库字段：分摊余额dcdg_settle_settleorder_base.CONSUME_POINT
     * @param consumePoint the value for dcdg_settle_settleorder_base.CONSUME_POINT
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public void setConsumePoint(Double consumePoint) {
        this.consumePoint = consumePoint;
    }

    /**
     * 数据库字段：分摊余额dcdg_settle_settleorder_base.RMT_AMT
     *
     * @return  the value of dcdg_settle_settleorder_base.RMT_AMT
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public Double getRmtAmt() {
        return rmtAmt;
    }

    /**
     * 数据库字段：分摊余额dcdg_settle_settleorder_base.RMT_AMT
     * @param rmtAmt the value for dcdg_settle_settleorder_base.RMT_AMT
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public void setRmtAmt(Double rmtAmt) {
        this.rmtAmt = rmtAmt;
    }

    /**
     * 数据库字段：结算状态[1-未结算 2-已结算 3-暂停结算]dcdg_settle_settleorder_base.SETTLE_STATUS
     *
     * @return  the value of dcdg_settle_settleorder_base.SETTLE_STATUS
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public Byte getSettleStatus() {
        return settleStatus;
    }

    /**
     * 数据库字段：结算状态[1-未结算 2-已结算 3-暂停结算]dcdg_settle_settleorder_base.SETTLE_STATUS
     * @param settleStatus the value for dcdg_settle_settleorder_base.SETTLE_STATUS
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public void setSettleStatus(Byte settleStatus) {
        this.settleStatus = settleStatus;
    }

    /**
     * 数据库字段：餐饮[1-是 2-否]dcdg_settle_settleorder_base.IS_PROMOTION
     *
     * @return  the value of dcdg_settle_settleorder_base.IS_PROMOTION
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public Byte getIsPromotion() {
        return isPromotion;
    }

    /**
     * 数据库字段：餐饮[1-是 2-否]dcdg_settle_settleorder_base.IS_PROMOTION
     * @param isPromotion the value for dcdg_settle_settleorder_base.IS_PROMOTION
     *
     * @mbg.generated Fri Apr 26 14:41:19 CST 2019
     */
    public void setIsPromotion(Byte isPromotion) {
        this.isPromotion = isPromotion;
    }
}