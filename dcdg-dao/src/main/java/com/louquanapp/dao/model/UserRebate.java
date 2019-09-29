package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.UserRebateExtra;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 andji_system_user_rebate
 *
 * @mbg.generated do_not_delete_during_merge Wed Sep 11 20:55:44 CST 2019
 */
public class UserRebate extends UserRebateExtra {
    /**
     *   主键
     *
     * 数据库字段名:andji_system_user_rebate.REBATE_ID
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    private String rebateId;

    /**
     *   用户id
     *
     * 数据库字段名:andji_system_user_rebate.USER_ID
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    private String userId;

    /**
     *   前台用户id
     *
     * 数据库字段名:andji_system_user_rebate.CUST_ID
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    private String custId;

    /**
     *   状态[1-有效 2-无效]
     *
     * 数据库字段名:andji_system_user_rebate.POINT_STATUS
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    private Byte pointStatus;

    /**
     *   是否核销 [1-未核销 2-已核销]
     *
     * 数据库字段名:andji_system_user_rebate.IS_WRITE_OFF
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    private Byte isWriteOff;

    /**
     *   金额
     *
     * 数据库字段名:andji_system_user_rebate.MONEY
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    private Double money;

    /**
     *   添加时间
     *
     * 数据库字段名:andji_system_user_rebate.ADD_TIME
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    private Date addTime;

    /**
     *   支付渠道[4-纯微信 5-纯余额]
     *
     * 数据库字段名:andji_system_user_rebate.PAY_TYPE
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    private Byte payType;

    /**
     *   订单id
     *
     * 数据库字段名:andji_system_user_rebate.ORDER_ID
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    private String orderId;

    /**
     *   是否满足数量[1-未满足 2-已满足]
     *
     * 数据库字段名:andji_system_user_rebate.IS_NUM
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    private Byte isNum;

    /**
     * 数据库字段：主键andji_system_user_rebate.REBATE_ID
     *
     * @return  the value of andji_system_user_rebate.REBATE_ID
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    public String getRebateId() {
        return rebateId;
    }

    /**
     * 数据库字段：主键andji_system_user_rebate.REBATE_ID
     * @param rebateId the value for andji_system_user_rebate.REBATE_ID
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    public void setRebateId(String rebateId) {
        this.rebateId = rebateId == null ? null : rebateId.trim();
    }

    /**
     * 数据库字段：用户idandji_system_user_rebate.USER_ID
     *
     * @return  the value of andji_system_user_rebate.USER_ID
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 数据库字段：用户idandji_system_user_rebate.USER_ID
     * @param userId the value for andji_system_user_rebate.USER_ID
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 数据库字段：前台用户idandji_system_user_rebate.CUST_ID
     *
     * @return  the value of andji_system_user_rebate.CUST_ID
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：前台用户idandji_system_user_rebate.CUST_ID
     * @param custId the value for andji_system_user_rebate.CUST_ID
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：状态[1-有效 2-无效]andji_system_user_rebate.POINT_STATUS
     *
     * @return  the value of andji_system_user_rebate.POINT_STATUS
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    public Byte getPointStatus() {
        return pointStatus;
    }

    /**
     * 数据库字段：状态[1-有效 2-无效]andji_system_user_rebate.POINT_STATUS
     * @param pointStatus the value for andji_system_user_rebate.POINT_STATUS
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    public void setPointStatus(Byte pointStatus) {
        this.pointStatus = pointStatus;
    }

    /**
     * 数据库字段：是否核销 [1-未核销 2-已核销]andji_system_user_rebate.IS_WRITE_OFF
     *
     * @return  the value of andji_system_user_rebate.IS_WRITE_OFF
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    public Byte getIsWriteOff() {
        return isWriteOff;
    }

    /**
     * 数据库字段：是否核销 [1-未核销 2-已核销]andji_system_user_rebate.IS_WRITE_OFF
     * @param isWriteOff the value for andji_system_user_rebate.IS_WRITE_OFF
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    public void setIsWriteOff(Byte isWriteOff) {
        this.isWriteOff = isWriteOff;
    }

    /**
     * 数据库字段：金额andji_system_user_rebate.MONEY
     *
     * @return  the value of andji_system_user_rebate.MONEY
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    public Double getMoney() {
        return money;
    }

    /**
     * 数据库字段：金额andji_system_user_rebate.MONEY
     * @param money the value for andji_system_user_rebate.MONEY
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * 数据库字段：添加时间andji_system_user_rebate.ADD_TIME
     *
     * @return  the value of andji_system_user_rebate.ADD_TIME
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间andji_system_user_rebate.ADD_TIME
     * @param addTime the value for andji_system_user_rebate.ADD_TIME
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：支付渠道[4-纯微信 5-纯余额]andji_system_user_rebate.PAY_TYPE
     *
     * @return  the value of andji_system_user_rebate.PAY_TYPE
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    public Byte getPayType() {
        return payType;
    }

    /**
     * 数据库字段：支付渠道[4-纯微信 5-纯余额]andji_system_user_rebate.PAY_TYPE
     * @param payType the value for andji_system_user_rebate.PAY_TYPE
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    /**
     * 数据库字段：订单idandji_system_user_rebate.ORDER_ID
     *
     * @return  the value of andji_system_user_rebate.ORDER_ID
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 数据库字段：订单idandji_system_user_rebate.ORDER_ID
     * @param orderId the value for andji_system_user_rebate.ORDER_ID
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 数据库字段：是否满足数量[1-未满足 2-已满足]andji_system_user_rebate.IS_NUM
     *
     * @return  the value of andji_system_user_rebate.IS_NUM
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    public Byte getIsNum() {
        return isNum;
    }

    /**
     * 数据库字段：是否满足数量[1-未满足 2-已满足]andji_system_user_rebate.IS_NUM
     * @param isNum the value for andji_system_user_rebate.IS_NUM
     *
     * @mbg.generated Wed Sep 11 20:55:44 CST 2019
     */
    public void setIsNum(Byte isNum) {
        this.isNum = isNum;
    }
}