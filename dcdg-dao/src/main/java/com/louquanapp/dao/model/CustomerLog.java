package com.louquanapp.dao.model;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_customer_log_base
 *
 * @mbg.generated do_not_delete_during_merge Tue Apr 23 16:22:37 CST 2019
 */
public class CustomerLog {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_customer_log_base.LOG_ID
     *
     * @mbg.generated Tue Apr 23 16:22:37 CST 2019
     */
    private String logId;

    /**
     *   客户
     *
     * 数据库字段名:dcdg_customer_log_base.CUST_ID
     *
     * @mbg.generated Tue Apr 23 16:22:37 CST 2019
     */
    private String custId;

    /**
     *   操作时间
     *
     * 数据库字段名:dcdg_customer_log_base.ADD_TIME
     *
     * @mbg.generated Tue Apr 23 16:22:37 CST 2019
     */
    private Date addTime;

    /**
     *   登录方式[1-微信 2-QQ 3-账号密码 4-短信]
     *
     * 数据库字段名:dcdg_customer_log_base.LOG_SOURCE
     *
     * @mbg.generated Tue Apr 23 16:22:37 CST 2019
     */
    private Byte logSource;

    /**
     *   登录成功[1-失败 2-成功]
     *
     * 数据库字段名:dcdg_customer_log_base.LOG_STATUS
     *
     * @mbg.generated Tue Apr 23 16:22:37 CST 2019
     */
    private Byte logStatus;

    /**
     * 数据库字段：主键dcdg_customer_log_base.LOG_ID
     *
     * @return  the value of dcdg_customer_log_base.LOG_ID
     *
     * @mbg.generated Tue Apr 23 16:22:37 CST 2019
     */
    public String getLogId() {
        return logId;
    }

    /**
     * 数据库字段：主键dcdg_customer_log_base.LOG_ID
     * @param logId the value for dcdg_customer_log_base.LOG_ID
     *
     * @mbg.generated Tue Apr 23 16:22:37 CST 2019
     */
    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    /**
     * 数据库字段：客户dcdg_customer_log_base.CUST_ID
     *
     * @return  the value of dcdg_customer_log_base.CUST_ID
     *
     * @mbg.generated Tue Apr 23 16:22:37 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：客户dcdg_customer_log_base.CUST_ID
     * @param custId the value for dcdg_customer_log_base.CUST_ID
     *
     * @mbg.generated Tue Apr 23 16:22:37 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：操作时间dcdg_customer_log_base.ADD_TIME
     *
     * @return  the value of dcdg_customer_log_base.ADD_TIME
     *
     * @mbg.generated Tue Apr 23 16:22:37 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：操作时间dcdg_customer_log_base.ADD_TIME
     * @param addTime the value for dcdg_customer_log_base.ADD_TIME
     *
     * @mbg.generated Tue Apr 23 16:22:37 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：登录方式[1-微信 2-QQ 3-账号密码 4-短信]dcdg_customer_log_base.LOG_SOURCE
     *
     * @return  the value of dcdg_customer_log_base.LOG_SOURCE
     *
     * @mbg.generated Tue Apr 23 16:22:37 CST 2019
     */
    public Byte getLogSource() {
        return logSource;
    }

    /**
     * 数据库字段：登录方式[1-微信 2-QQ 3-账号密码 4-短信]dcdg_customer_log_base.LOG_SOURCE
     * @param logSource the value for dcdg_customer_log_base.LOG_SOURCE
     *
     * @mbg.generated Tue Apr 23 16:22:37 CST 2019
     */
    public void setLogSource(Byte logSource) {
        this.logSource = logSource;
    }

    /**
     * 数据库字段：登录成功[1-失败 2-成功]dcdg_customer_log_base.LOG_STATUS
     *
     * @return  the value of dcdg_customer_log_base.LOG_STATUS
     *
     * @mbg.generated Tue Apr 23 16:22:37 CST 2019
     */
    public Byte getLogStatus() {
        return logStatus;
    }

    /**
     * 数据库字段：登录成功[1-失败 2-成功]dcdg_customer_log_base.LOG_STATUS
     * @param logStatus the value for dcdg_customer_log_base.LOG_STATUS
     *
     * @mbg.generated Tue Apr 23 16:22:37 CST 2019
     */
    public void setLogStatus(Byte logStatus) {
        this.logStatus = logStatus;
    }
}