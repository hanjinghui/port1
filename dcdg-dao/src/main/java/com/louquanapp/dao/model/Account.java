package com.louquanapp.dao.model;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_customer_account_base
 *
 * @mbg.generated do_not_delete_during_merge Fri Aug 30 17:07:05 CST 2019
 */
public class Account {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_customer_account_base.ACCOUNT_ID
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    private String accountId;

    /**
     *   用户id
     *
     * 数据库字段名:dcdg_customer_account_base.CUST_ID
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    private String custId;

    /**
     *   账号
     *
     * 数据库字段名:dcdg_customer_account_base.ACCOUNT_NUMBER
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    private String accountNumber;

    /**
     *    账户类型[1-银行卡 2-微信 3-支付宝]
     *
     * 数据库字段名:dcdg_customer_account_base.ACCOUNT_TYPE
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    private Byte accountType;

    /**
     *   银行类型ID
     *
     * 数据库字段名:dcdg_customer_account_base.BANK_TYPE_ID
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    private String bankTypeId;

    /**
     *   绑定状态[1-未绑定 2-已绑定]
     *
     * 数据库字段名:dcdg_customer_account_base.BINDING_STATUS
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    private Byte bindingStatus;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_customer_account_base.ADD_TIME
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    private Date addTime;

    /**
     * 数据库字段：主键dcdg_customer_account_base.ACCOUNT_ID
     *
     * @return  the value of dcdg_customer_account_base.ACCOUNT_ID
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * 数据库字段：主键dcdg_customer_account_base.ACCOUNT_ID
     * @param accountId the value for dcdg_customer_account_base.ACCOUNT_ID
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * 数据库字段：用户iddcdg_customer_account_base.CUST_ID
     *
     * @return  the value of dcdg_customer_account_base.CUST_ID
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：用户iddcdg_customer_account_base.CUST_ID
     * @param custId the value for dcdg_customer_account_base.CUST_ID
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：账号dcdg_customer_account_base.ACCOUNT_NUMBER
     *
     * @return  the value of dcdg_customer_account_base.ACCOUNT_NUMBER
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * 数据库字段：账号dcdg_customer_account_base.ACCOUNT_NUMBER
     * @param accountNumber the value for dcdg_customer_account_base.ACCOUNT_NUMBER
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber == null ? null : accountNumber.trim();
    }

    /**
     * 数据库字段： 账户类型[1-银行卡 2-微信 3-支付宝]dcdg_customer_account_base.ACCOUNT_TYPE
     *
     * @return  the value of dcdg_customer_account_base.ACCOUNT_TYPE
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    public Byte getAccountType() {
        return accountType;
    }

    /**
     * 数据库字段： 账户类型[1-银行卡 2-微信 3-支付宝]dcdg_customer_account_base.ACCOUNT_TYPE
     * @param accountType the value for dcdg_customer_account_base.ACCOUNT_TYPE
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    public void setAccountType(Byte accountType) {
        this.accountType = accountType;
    }

    /**
     * 数据库字段：银行类型IDdcdg_customer_account_base.BANK_TYPE_ID
     *
     * @return  the value of dcdg_customer_account_base.BANK_TYPE_ID
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    public String getBankTypeId() {
        return bankTypeId;
    }

    /**
     * 数据库字段：银行类型IDdcdg_customer_account_base.BANK_TYPE_ID
     * @param bankTypeId the value for dcdg_customer_account_base.BANK_TYPE_ID
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    public void setBankTypeId(String bankTypeId) {
        this.bankTypeId = bankTypeId == null ? null : bankTypeId.trim();
    }

    /**
     * 数据库字段：绑定状态[1-未绑定 2-已绑定]dcdg_customer_account_base.BINDING_STATUS
     *
     * @return  the value of dcdg_customer_account_base.BINDING_STATUS
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    public Byte getBindingStatus() {
        return bindingStatus;
    }

    /**
     * 数据库字段：绑定状态[1-未绑定 2-已绑定]dcdg_customer_account_base.BINDING_STATUS
     * @param bindingStatus the value for dcdg_customer_account_base.BINDING_STATUS
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    public void setBindingStatus(Byte bindingStatus) {
        this.bindingStatus = bindingStatus;
    }

    /**
     * 数据库字段：添加时间dcdg_customer_account_base.ADD_TIME
     *
     * @return  the value of dcdg_customer_account_base.ADD_TIME
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_customer_account_base.ADD_TIME
     * @param addTime the value for dcdg_customer_account_base.ADD_TIME
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}