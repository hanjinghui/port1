package com.louquanapp.dao.model;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_bussiness_customer_words
 *
 * @mbg.generated do_not_delete_during_merge Sun Mar 31 09:15:52 CST 2019
 */
public class CustomerWords {
    /**
     * 主键
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_words.CUST_WORDS_ID
     *
     * @mbg.generated Sun Mar 31 09:15:52 CST 2019
     */
    private String custWordsId;

    /**
     * 客户
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_words.CUST_ID
     *
     * @mbg.generated Sun Mar 31 09:15:52 CST 2019
     */
    private String custId;

    /**
     * 设备编号
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_words.DEVICE_ID
     *
     * @mbg.generated Sun Mar 31 09:15:52 CST 2019
     */
    private String deviceId;

    /**
     * 热搜词内容
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_words.WORDS_VAL
     *
     * @mbg.generated Sun Mar 31 09:15:52 CST 2019
     */
    private String wordsVal;

    /**
     * 添加时间
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_words.ADD_TIME
     *
     * @mbg.generated Sun Mar 31 09:15:52 CST 2019
     */
    private Date addTime;

    /**
     * 更新时间
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_words.UPDATE_TIME
     *
     * @mbg.generated Sun Mar 31 09:15:52 CST 2019
     */
    private Date updateTime;

    /**
     * 数据库字段：主键dcdg_bussiness_customer_words.CUST_WORDS_ID
     *
     * @return the value of dcdg_bussiness_customer_words.CUST_WORDS_ID
     * @mbg.generated Sun Mar 31 09:15:52 CST 2019
     */
    public String getCustWordsId() {
        return custWordsId;
    }

    /**
     * 数据库字段：主键dcdg_bussiness_customer_words.CUST_WORDS_ID
     *
     * @param custWordsId the value for dcdg_bussiness_customer_words.CUST_WORDS_ID
     * @mbg.generated Sun Mar 31 09:15:52 CST 2019
     */
    public void setCustWordsId(String custWordsId) {
        this.custWordsId = custWordsId == null ? null : custWordsId.trim();
    }

    /**
     * 数据库字段：客户dcdg_bussiness_customer_words.CUST_ID
     *
     * @return the value of dcdg_bussiness_customer_words.CUST_ID
     * @mbg.generated Sun Mar 31 09:15:52 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：客户dcdg_bussiness_customer_words.CUST_ID
     *
     * @param custId the value for dcdg_bussiness_customer_words.CUST_ID
     * @mbg.generated Sun Mar 31 09:15:52 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：设备编号dcdg_bussiness_customer_words.DEVICE_ID
     *
     * @return the value of dcdg_bussiness_customer_words.DEVICE_ID
     * @mbg.generated Sun Mar 31 09:15:52 CST 2019
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * 数据库字段：设备编号dcdg_bussiness_customer_words.DEVICE_ID
     *
     * @param deviceId the value for dcdg_bussiness_customer_words.DEVICE_ID
     * @mbg.generated Sun Mar 31 09:15:52 CST 2019
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    /**
     * 数据库字段：热搜词内容dcdg_bussiness_customer_words.WORDS_VAL
     *
     * @return the value of dcdg_bussiness_customer_words.WORDS_VAL
     * @mbg.generated Sun Mar 31 09:15:52 CST 2019
     */
    public String getWordsVal() {
        return wordsVal;
    }

    /**
     * 数据库字段：热搜词内容dcdg_bussiness_customer_words.WORDS_VAL
     *
     * @param wordsVal the value for dcdg_bussiness_customer_words.WORDS_VAL
     * @mbg.generated Sun Mar 31 09:15:52 CST 2019
     */
    public void setWordsVal(String wordsVal) {
        this.wordsVal = wordsVal == null ? null : wordsVal.trim();
    }

    /**
     * 数据库字段：添加时间dcdg_bussiness_customer_words.ADD_TIME
     *
     * @return the value of dcdg_bussiness_customer_words.ADD_TIME
     * @mbg.generated Sun Mar 31 09:15:52 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_bussiness_customer_words.ADD_TIME
     *
     * @param addTime the value for dcdg_bussiness_customer_words.ADD_TIME
     * @mbg.generated Sun Mar 31 09:15:52 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：更新时间dcdg_bussiness_customer_words.UPDATE_TIME
     *
     * @return the value of dcdg_bussiness_customer_words.UPDATE_TIME
     * @mbg.generated Sun Mar 31 09:15:52 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：更新时间dcdg_bussiness_customer_words.UPDATE_TIME
     *
     * @param updateTime the value for dcdg_bussiness_customer_words.UPDATE_TIME
     * @mbg.generated Sun Mar 31 09:15:52 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}