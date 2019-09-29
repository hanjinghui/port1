package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.SettlementInfoExtra;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_money_settlement_info
 *
 * @mbg.generated do_not_delete_during_merge Wed Sep 04 15:43:52 CST 2019
 */
public class MoneySettlement extends SettlementInfoExtra {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_money_settlement_info.MONEY_ID
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    private String moneyId;

    /**
     *   提现消耗值
     *
     * 数据库字段名:dcdg_money_settlement_info.CASH_OUT_CONSUME_VALUE
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    private Double cashOutConsumeValue;

    /**
     *   数值类型[1-积分 2-余额]
     *
     * 数据库字段名:dcdg_money_settlement_info.VALUE_TYPE
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    private Byte valueType;

    /**
     *   提现积分转换余额百分比
     *
     * 数据库字段名:dcdg_money_settlement_info.CASH_OUT_POINT_PERCENTAGE
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    private Double cashOutPointPercentage;

    /**
     *   提现余额转换资金百分比
     *
     * 数据库字段名:dcdg_money_settlement_info.CASH_OUT_BALANCE_PERCENTAGE
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    private Double cashOutBalancePercentage;

    /**
     *   金额
     *
     * 数据库字段名:dcdg_money_settlement_info.MONEY_VALUE
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    private Double moneyValue;

    /**
     *   商户ID
     *
     * 数据库字段名:dcdg_money_settlement_info.USER_ID
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    private String userId;

    /**
     *   商铺ID
     *
     * 数据库字段名:dcdg_money_settlement_info.SHOP_ID
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    private String shopId;

    /**
     *   结算状态[2-申请结算 3-结算中 4-已结算]
     *
     * 数据库字段名:dcdg_money_settlement_info.SETTLEMENT_STATUS
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    private Byte settlementStatus;

    /**
     *   申请结算时间
     *
     * 数据库字段名:dcdg_money_settlement_info.APPLY_SETTLEMENT_TIME
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    private Date applySettlementTime;

    /**
     *   结算中请时间
     *
     * 数据库字段名:dcdg_money_settlement_info.IN_SETTLEMENT_TIME
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    private Date inSettlementTime;

    /**
     *   结算完成时间
     *
     * 数据库字段名:dcdg_money_settlement_info.OUT_SETTLEMENT_TIME
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    private Date outSettlementTime;

    /**
     *   账户id
     *
     * 数据库字段名:dcdg_money_settlement_info.ACCOUNT_ID
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    private String accountId;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_money_settlement_info.ADD_TIME
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    private Date addTime;

    /**
     * 数据库字段：主键dcdg_money_settlement_info.MONEY_ID
     *
     * @return  the value of dcdg_money_settlement_info.MONEY_ID
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public String getMoneyId() {
        return moneyId;
    }

    /**
     * 数据库字段：主键dcdg_money_settlement_info.MONEY_ID
     * @param moneyId the value for dcdg_money_settlement_info.MONEY_ID
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public void setMoneyId(String moneyId) {
        this.moneyId = moneyId == null ? null : moneyId.trim();
    }

    /**
     * 数据库字段：提现消耗值dcdg_money_settlement_info.CASH_OUT_CONSUME_VALUE
     *
     * @return  the value of dcdg_money_settlement_info.CASH_OUT_CONSUME_VALUE
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public Double getCashOutConsumeValue() {
        return cashOutConsumeValue;
    }

    /**
     * 数据库字段：提现消耗值dcdg_money_settlement_info.CASH_OUT_CONSUME_VALUE
     * @param cashOutConsumeValue the value for dcdg_money_settlement_info.CASH_OUT_CONSUME_VALUE
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public void setCashOutConsumeValue(Double cashOutConsumeValue) {
        this.cashOutConsumeValue = cashOutConsumeValue;
    }

    /**
     * 数据库字段：数值类型[1-积分 2-余额]dcdg_money_settlement_info.VALUE_TYPE
     *
     * @return  the value of dcdg_money_settlement_info.VALUE_TYPE
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public Byte getValueType() {
        return valueType;
    }

    /**
     * 数据库字段：数值类型[1-积分 2-余额]dcdg_money_settlement_info.VALUE_TYPE
     * @param valueType the value for dcdg_money_settlement_info.VALUE_TYPE
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public void setValueType(Byte valueType) {
        this.valueType = valueType;
    }

    /**
     * 数据库字段：提现积分转换余额百分比dcdg_money_settlement_info.CASH_OUT_POINT_PERCENTAGE
     *
     * @return  the value of dcdg_money_settlement_info.CASH_OUT_POINT_PERCENTAGE
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public Double getCashOutPointPercentage() {
        return cashOutPointPercentage;
    }

    /**
     * 数据库字段：提现积分转换余额百分比dcdg_money_settlement_info.CASH_OUT_POINT_PERCENTAGE
     * @param cashOutPointPercentage the value for dcdg_money_settlement_info.CASH_OUT_POINT_PERCENTAGE
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public void setCashOutPointPercentage(Double cashOutPointPercentage) {
        this.cashOutPointPercentage = cashOutPointPercentage;
    }

    /**
     * 数据库字段：提现余额转换资金百分比dcdg_money_settlement_info.CASH_OUT_BALANCE_PERCENTAGE
     *
     * @return  the value of dcdg_money_settlement_info.CASH_OUT_BALANCE_PERCENTAGE
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public Double getCashOutBalancePercentage() {
        return cashOutBalancePercentage;
    }

    /**
     * 数据库字段：提现余额转换资金百分比dcdg_money_settlement_info.CASH_OUT_BALANCE_PERCENTAGE
     * @param cashOutBalancePercentage the value for dcdg_money_settlement_info.CASH_OUT_BALANCE_PERCENTAGE
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public void setCashOutBalancePercentage(Double cashOutBalancePercentage) {
        this.cashOutBalancePercentage = cashOutBalancePercentage;
    }

    /**
     * 数据库字段：金额dcdg_money_settlement_info.MONEY_VALUE
     *
     * @return  the value of dcdg_money_settlement_info.MONEY_VALUE
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public Double getMoneyValue() {
        return moneyValue;
    }

    /**
     * 数据库字段：金额dcdg_money_settlement_info.MONEY_VALUE
     * @param moneyValue the value for dcdg_money_settlement_info.MONEY_VALUE
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public void setMoneyValue(Double moneyValue) {
        this.moneyValue = moneyValue;
    }

    /**
     * 数据库字段：商户IDdcdg_money_settlement_info.USER_ID
     *
     * @return  the value of dcdg_money_settlement_info.USER_ID
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 数据库字段：商户IDdcdg_money_settlement_info.USER_ID
     * @param userId the value for dcdg_money_settlement_info.USER_ID
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 数据库字段：商铺IDdcdg_money_settlement_info.SHOP_ID
     *
     * @return  the value of dcdg_money_settlement_info.SHOP_ID
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * 数据库字段：商铺IDdcdg_money_settlement_info.SHOP_ID
     * @param shopId the value for dcdg_money_settlement_info.SHOP_ID
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    /**
     * 数据库字段：结算状态[2-申请结算 3-结算中 4-已结算]dcdg_money_settlement_info.SETTLEMENT_STATUS
     *
     * @return  the value of dcdg_money_settlement_info.SETTLEMENT_STATUS
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public Byte getSettlementStatus() {
        return settlementStatus;
    }

    /**
     * 数据库字段：结算状态[2-申请结算 3-结算中 4-已结算]dcdg_money_settlement_info.SETTLEMENT_STATUS
     * @param settlementStatus the value for dcdg_money_settlement_info.SETTLEMENT_STATUS
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public void setSettlementStatus(Byte settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    /**
     * 数据库字段：申请结算时间dcdg_money_settlement_info.APPLY_SETTLEMENT_TIME
     *
     * @return  the value of dcdg_money_settlement_info.APPLY_SETTLEMENT_TIME
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public Date getApplySettlementTime() {
        return applySettlementTime;
    }

    /**
     * 数据库字段：申请结算时间dcdg_money_settlement_info.APPLY_SETTLEMENT_TIME
     * @param applySettlementTime the value for dcdg_money_settlement_info.APPLY_SETTLEMENT_TIME
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public void setApplySettlementTime(Date applySettlementTime) {
        this.applySettlementTime = applySettlementTime;
    }

    /**
     * 数据库字段：结算中请时间dcdg_money_settlement_info.IN_SETTLEMENT_TIME
     *
     * @return  the value of dcdg_money_settlement_info.IN_SETTLEMENT_TIME
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public Date getInSettlementTime() {
        return inSettlementTime;
    }

    /**
     * 数据库字段：结算中请时间dcdg_money_settlement_info.IN_SETTLEMENT_TIME
     * @param inSettlementTime the value for dcdg_money_settlement_info.IN_SETTLEMENT_TIME
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public void setInSettlementTime(Date inSettlementTime) {
        this.inSettlementTime = inSettlementTime;
    }

    /**
     * 数据库字段：结算完成时间dcdg_money_settlement_info.OUT_SETTLEMENT_TIME
     *
     * @return  the value of dcdg_money_settlement_info.OUT_SETTLEMENT_TIME
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public Date getOutSettlementTime() {
        return outSettlementTime;
    }

    /**
     * 数据库字段：结算完成时间dcdg_money_settlement_info.OUT_SETTLEMENT_TIME
     * @param outSettlementTime the value for dcdg_money_settlement_info.OUT_SETTLEMENT_TIME
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public void setOutSettlementTime(Date outSettlementTime) {
        this.outSettlementTime = outSettlementTime;
    }

    /**
     * 数据库字段：账户iddcdg_money_settlement_info.ACCOUNT_ID
     *
     * @return  the value of dcdg_money_settlement_info.ACCOUNT_ID
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * 数据库字段：账户iddcdg_money_settlement_info.ACCOUNT_ID
     * @param accountId the value for dcdg_money_settlement_info.ACCOUNT_ID
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * 数据库字段：添加时间dcdg_money_settlement_info.ADD_TIME
     *
     * @return  the value of dcdg_money_settlement_info.ADD_TIME
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_money_settlement_info.ADD_TIME
     * @param addTime the value for dcdg_money_settlement_info.ADD_TIME
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}