package com.louquanapp.dao.model;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_basic_bank_base
 *
 * @mbg.generated do_not_delete_during_merge Fri Aug 30 14:54:06 CST 2019
 */
public class BasicBank {
    /**
     *   银行id
     *
     * 数据库字段名:dcdg_basic_bank_base.BANK_ID
     *
     * @mbg.generated Fri Aug 30 14:54:06 CST 2019
     */
    private String bankId;

    /**
     *   银行ico
     *
     * 数据库字段名:dcdg_basic_bank_base.BANK_ICO
     *
     * @mbg.generated Fri Aug 30 14:54:06 CST 2019
     */
    private String bankIco;

    /**
     *   银行名称
     *
     * 数据库字段名:dcdg_basic_bank_base.BANK_NAME
     *
     * @mbg.generated Fri Aug 30 14:54:06 CST 2019
     */
    private String bankName;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_basic_bank_base.ADD_TIME
     *
     * @mbg.generated Fri Aug 30 14:54:06 CST 2019
     */
    private Date addTime;

    /**
     * 数据库字段：银行iddcdg_basic_bank_base.BANK_ID
     *
     * @return  the value of dcdg_basic_bank_base.BANK_ID
     *
     * @mbg.generated Fri Aug 30 14:54:06 CST 2019
     */
    public String getBankId() {
        return bankId;
    }

    /**
     * 数据库字段：银行iddcdg_basic_bank_base.BANK_ID
     * @param bankId the value for dcdg_basic_bank_base.BANK_ID
     *
     * @mbg.generated Fri Aug 30 14:54:06 CST 2019
     */
    public void setBankId(String bankId) {
        this.bankId = bankId == null ? null : bankId.trim();
    }

    /**
     * 数据库字段：银行icodcdg_basic_bank_base.BANK_ICO
     *
     * @return  the value of dcdg_basic_bank_base.BANK_ICO
     *
     * @mbg.generated Fri Aug 30 14:54:06 CST 2019
     */
    public String getBankIco() {
        return bankIco;
    }

    /**
     * 数据库字段：银行icodcdg_basic_bank_base.BANK_ICO
     * @param bankIco the value for dcdg_basic_bank_base.BANK_ICO
     *
     * @mbg.generated Fri Aug 30 14:54:06 CST 2019
     */
    public void setBankIco(String bankIco) {
        this.bankIco = bankIco == null ? null : bankIco.trim();
    }

    /**
     * 数据库字段：银行名称dcdg_basic_bank_base.BANK_NAME
     *
     * @return  the value of dcdg_basic_bank_base.BANK_NAME
     *
     * @mbg.generated Fri Aug 30 14:54:06 CST 2019
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 数据库字段：银行名称dcdg_basic_bank_base.BANK_NAME
     * @param bankName the value for dcdg_basic_bank_base.BANK_NAME
     *
     * @mbg.generated Fri Aug 30 14:54:06 CST 2019
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 数据库字段：添加时间dcdg_basic_bank_base.ADD_TIME
     *
     * @return  the value of dcdg_basic_bank_base.ADD_TIME
     *
     * @mbg.generated Fri Aug 30 14:54:06 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_basic_bank_base.ADD_TIME
     * @param addTime the value for dcdg_basic_bank_base.ADD_TIME
     *
     * @mbg.generated Fri Aug 30 14:54:06 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}