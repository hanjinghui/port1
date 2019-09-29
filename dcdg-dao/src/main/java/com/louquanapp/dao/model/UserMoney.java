package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.UserRebateExtra;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 andji_system_user_money
 *
 * @mbg.generated do_not_delete_during_merge Wed Sep 04 20:37:33 CST 2019
 */
public class UserMoney  extends UserRebateExtra {
    /**
     *   主键
     *
     * 数据库字段名:andji_system_user_money.MONEY_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    private String moneyId;

    /**
     *   商户ID
     *
     * 数据库字段名:andji_system_user_money.USER_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    private String userId;

    /**
     *   商铺ID
     *
     * 数据库字段名:andji_system_user_money.SHOP_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    private String shopId;

    /**
     *   用户ID
     *
     * 数据库字段名:andji_system_user_money.CUST_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    private String custId;

    /**
     *   订单ID
     *
     * 数据库字段名:andji_system_user_money.ORDER_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    private String orderId;

    /**
     *   账户ID
     *
     * 数据库字段名:andji_system_user_money.ACCOUNT_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    private String accountId;

    /**
     *   来源类型[1-订单收货 2-订单退款 3-资金提现 4-消费返利 5-系统赠送]
     *
     * 数据库字段名:andji_system_user_money.SOURCE_TYPE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    private Byte sourceType;

    /**
     *   资金数值
     *
     * 数据库字段名:andji_system_user_money.MONEY_VALUE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    private Double moneyValue;

    /**
     *   资金描述
     *
     * 数据库字段名:andji_system_user_money.MONEY_DESC
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    private String moneyDesc;

    /**
     *   资金加减类型[1-加 2-减]
     *
     * 数据库字段名:andji_system_user_money.ADD_OR_SUB_TYPE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    private Byte addOrSubType;

    /**
     *   登录操作人ID
     *
     * 数据库字段名:andji_system_user_money.LOGIN_USER_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    private String loginUserId;

    /**
     *   登录操作人名称
     *
     * 数据库字段名:andji_system_user_money.LOGIN_USER_NAME
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    private String loginUserName;

    /**
     *   数值类型[1-积分 2-余额]
     *
     * 数据库字段名:andji_system_user_money.VALUE_TYPE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    private Byte valueType;

    /**
     *   添加时间
     *
     * 数据库字段名:andji_system_user_money.ADD_TIME
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    private Date addTime;

    /**
     *   更新时间
     *
     * 数据库字段名:andji_system_user_money.UPDATE_TIME
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    private Date updateTime;

    /**
     *   提现消耗值
     *
     * 数据库字段名:andji_system_user_money.CASH_OUT_CONSUME_VALUE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    private Double cashOutConsumeValue;

    /**
     *   提现积分转换余额百分比
     *
     * 数据库字段名:andji_system_user_money.CASH_OUT_POINT_PERCENTAGE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    private Double cashOutPointPercentage;

    /**
     *   提现余额转换资金百分比
     *
     * 数据库字段名:andji_system_user_money.CASH_OUT_BALANCE_PERCENTAGE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    private Double cashOutBalancePercentage;

    /**
     *   退货id
     *
     * 数据库字段名:andji_system_user_money.RETURN_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    private String returnId;

    /**
     * 数据库字段：主键andji_system_user_money.MONEY_ID
     *
     * @return  the value of andji_system_user_money.MONEY_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public String getMoneyId() {
        return moneyId;
    }

    /**
     * 数据库字段：主键andji_system_user_money.MONEY_ID
     * @param moneyId the value for andji_system_user_money.MONEY_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public void setMoneyId(String moneyId) {
        this.moneyId = moneyId == null ? null : moneyId.trim();
    }

    /**
     * 数据库字段：商户IDandji_system_user_money.USER_ID
     *
     * @return  the value of andji_system_user_money.USER_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 数据库字段：商户IDandji_system_user_money.USER_ID
     * @param userId the value for andji_system_user_money.USER_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 数据库字段：商铺IDandji_system_user_money.SHOP_ID
     *
     * @return  the value of andji_system_user_money.SHOP_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * 数据库字段：商铺IDandji_system_user_money.SHOP_ID
     * @param shopId the value for andji_system_user_money.SHOP_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    /**
     * 数据库字段：用户IDandji_system_user_money.CUST_ID
     *
     * @return  the value of andji_system_user_money.CUST_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：用户IDandji_system_user_money.CUST_ID
     * @param custId the value for andji_system_user_money.CUST_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：订单IDandji_system_user_money.ORDER_ID
     *
     * @return  the value of andji_system_user_money.ORDER_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 数据库字段：订单IDandji_system_user_money.ORDER_ID
     * @param orderId the value for andji_system_user_money.ORDER_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 数据库字段：账户IDandji_system_user_money.ACCOUNT_ID
     *
     * @return  the value of andji_system_user_money.ACCOUNT_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * 数据库字段：账户IDandji_system_user_money.ACCOUNT_ID
     * @param accountId the value for andji_system_user_money.ACCOUNT_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * 数据库字段：来源类型[1-订单收货 2-订单退款 3-资金提现 4-消费返利 5-系统赠送]andji_system_user_money.SOURCE_TYPE
     *
     * @return  the value of andji_system_user_money.SOURCE_TYPE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public Byte getSourceType() {
        return sourceType;
    }

    /**
     * 数据库字段：来源类型[1-订单收货 2-订单退款 3-资金提现 4-消费返利 5-系统赠送]andji_system_user_money.SOURCE_TYPE
     * @param sourceType the value for andji_system_user_money.SOURCE_TYPE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public void setSourceType(Byte sourceType) {
        this.sourceType = sourceType;
    }

    /**
     * 数据库字段：资金数值andji_system_user_money.MONEY_VALUE
     *
     * @return  the value of andji_system_user_money.MONEY_VALUE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public Double getMoneyValue() {
        return moneyValue;
    }

    /**
     * 数据库字段：资金数值andji_system_user_money.MONEY_VALUE
     * @param moneyValue the value for andji_system_user_money.MONEY_VALUE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public void setMoneyValue(Double moneyValue) {
        this.moneyValue = moneyValue;
    }

    /**
     * 数据库字段：资金描述andji_system_user_money.MONEY_DESC
     *
     * @return  the value of andji_system_user_money.MONEY_DESC
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public String getMoneyDesc() {
        return moneyDesc;
    }

    /**
     * 数据库字段：资金描述andji_system_user_money.MONEY_DESC
     * @param moneyDesc the value for andji_system_user_money.MONEY_DESC
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public void setMoneyDesc(String moneyDesc) {
        this.moneyDesc = moneyDesc == null ? null : moneyDesc.trim();
    }

    /**
     * 数据库字段：资金加减类型[1-加 2-减]andji_system_user_money.ADD_OR_SUB_TYPE
     *
     * @return  the value of andji_system_user_money.ADD_OR_SUB_TYPE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public Byte getAddOrSubType() {
        return addOrSubType;
    }

    /**
     * 数据库字段：资金加减类型[1-加 2-减]andji_system_user_money.ADD_OR_SUB_TYPE
     * @param addOrSubType the value for andji_system_user_money.ADD_OR_SUB_TYPE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public void setAddOrSubType(Byte addOrSubType) {
        this.addOrSubType = addOrSubType;
    }

    /**
     * 数据库字段：登录操作人IDandji_system_user_money.LOGIN_USER_ID
     *
     * @return  the value of andji_system_user_money.LOGIN_USER_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public String getLoginUserId() {
        return loginUserId;
    }

    /**
     * 数据库字段：登录操作人IDandji_system_user_money.LOGIN_USER_ID
     * @param loginUserId the value for andji_system_user_money.LOGIN_USER_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId == null ? null : loginUserId.trim();
    }

    /**
     * 数据库字段：登录操作人名称andji_system_user_money.LOGIN_USER_NAME
     *
     * @return  the value of andji_system_user_money.LOGIN_USER_NAME
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public String getLoginUserName() {
        return loginUserName;
    }

    /**
     * 数据库字段：登录操作人名称andji_system_user_money.LOGIN_USER_NAME
     * @param loginUserName the value for andji_system_user_money.LOGIN_USER_NAME
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName == null ? null : loginUserName.trim();
    }

    /**
     * 数据库字段：数值类型[1-积分 2-余额]andji_system_user_money.VALUE_TYPE
     *
     * @return  the value of andji_system_user_money.VALUE_TYPE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public Byte getValueType() {
        return valueType;
    }

    /**
     * 数据库字段：数值类型[1-积分 2-余额]andji_system_user_money.VALUE_TYPE
     * @param valueType the value for andji_system_user_money.VALUE_TYPE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public void setValueType(Byte valueType) {
        this.valueType = valueType;
    }

    /**
     * 数据库字段：添加时间andji_system_user_money.ADD_TIME
     *
     * @return  the value of andji_system_user_money.ADD_TIME
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间andji_system_user_money.ADD_TIME
     * @param addTime the value for andji_system_user_money.ADD_TIME
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：更新时间andji_system_user_money.UPDATE_TIME
     *
     * @return  the value of andji_system_user_money.UPDATE_TIME
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：更新时间andji_system_user_money.UPDATE_TIME
     * @param updateTime the value for andji_system_user_money.UPDATE_TIME
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 数据库字段：提现消耗值andji_system_user_money.CASH_OUT_CONSUME_VALUE
     *
     * @return  the value of andji_system_user_money.CASH_OUT_CONSUME_VALUE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public Double getCashOutConsumeValue() {
        return cashOutConsumeValue;
    }

    /**
     * 数据库字段：提现消耗值andji_system_user_money.CASH_OUT_CONSUME_VALUE
     * @param cashOutConsumeValue the value for andji_system_user_money.CASH_OUT_CONSUME_VALUE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public void setCashOutConsumeValue(Double cashOutConsumeValue) {
        this.cashOutConsumeValue = cashOutConsumeValue;
    }

    /**
     * 数据库字段：提现积分转换余额百分比andji_system_user_money.CASH_OUT_POINT_PERCENTAGE
     *
     * @return  the value of andji_system_user_money.CASH_OUT_POINT_PERCENTAGE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public Double getCashOutPointPercentage() {
        return cashOutPointPercentage;
    }

    /**
     * 数据库字段：提现积分转换余额百分比andji_system_user_money.CASH_OUT_POINT_PERCENTAGE
     * @param cashOutPointPercentage the value for andji_system_user_money.CASH_OUT_POINT_PERCENTAGE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public void setCashOutPointPercentage(Double cashOutPointPercentage) {
        this.cashOutPointPercentage = cashOutPointPercentage;
    }

    /**
     * 数据库字段：提现余额转换资金百分比andji_system_user_money.CASH_OUT_BALANCE_PERCENTAGE
     *
     * @return  the value of andji_system_user_money.CASH_OUT_BALANCE_PERCENTAGE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public Double getCashOutBalancePercentage() {
        return cashOutBalancePercentage;
    }

    /**
     * 数据库字段：提现余额转换资金百分比andji_system_user_money.CASH_OUT_BALANCE_PERCENTAGE
     * @param cashOutBalancePercentage the value for andji_system_user_money.CASH_OUT_BALANCE_PERCENTAGE
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public void setCashOutBalancePercentage(Double cashOutBalancePercentage) {
        this.cashOutBalancePercentage = cashOutBalancePercentage;
    }

    /**
     * 数据库字段：退货idandji_system_user_money.RETURN_ID
     *
     * @return  the value of andji_system_user_money.RETURN_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public String getReturnId() {
        return returnId;
    }

    /**
     * 数据库字段：退货idandji_system_user_money.RETURN_ID
     * @param returnId the value for andji_system_user_money.RETURN_ID
     *
     * @mbg.generated Wed Sep 04 20:37:33 CST 2019
     */
    public void setReturnId(String returnId) {
        this.returnId = returnId == null ? null : returnId.trim();
    }
}