package com.louquanapp.dao.model;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_basic_blacklist_base
 *
 * @mbg.generated do_not_delete_during_merge Mon Jun 10 10:54:05 CST 2019
 */
public class Blacklist {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_basic_blacklist_base.ID
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    private String id;

    /**
     *   依据
     *
     * 数据库字段名:dcdg_basic_blacklist_base.BASIS
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    private String basis;

    /**
     *   主要条件
     *
     * 数据库字段名:dcdg_basic_blacklist_base.MINOR_CONDITION
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    private String minorCondition;

    /**
     *   次要条件
     *
     * 数据库字段名:dcdg_basic_blacklist_base.MAIN_CONDITION
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    private String mainCondition;

    /**
     *   黑名单类型[1-多次点击]
     *
     * 数据库字段名:dcdg_basic_blacklist_base.BLACKLIST_TYPE
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    private Byte blacklistType;

    /**
     *   黑名单状态[1-正常 2-禁止]
     *
     * 数据库字段名:dcdg_basic_blacklist_base.BLACKLIST_STATUS
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    private Byte blacklistStatus;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_basic_blacklist_base.ADD_TIME
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    private Date addTime;

    /**
     *   修改时间
     *
     * 数据库字段名:dcdg_basic_blacklist_base.UPDATE_TIME
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    private Date updateTime;

    /**
     *   说明
     *
     * 数据库字段名:dcdg_basic_blacklist_base.BLACK_DESC
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    private String blackDesc;

    /**
     * 数据库字段：主键dcdg_basic_blacklist_base.ID
     *
     * @return  the value of dcdg_basic_blacklist_base.ID
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * 数据库字段：主键dcdg_basic_blacklist_base.ID
     * @param id the value for dcdg_basic_blacklist_base.ID
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 数据库字段：依据dcdg_basic_blacklist_base.BASIS
     *
     * @return  the value of dcdg_basic_blacklist_base.BASIS
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    public String getBasis() {
        return basis;
    }

    /**
     * 数据库字段：依据dcdg_basic_blacklist_base.BASIS
     * @param basis the value for dcdg_basic_blacklist_base.BASIS
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    public void setBasis(String basis) {
        this.basis = basis == null ? null : basis.trim();
    }

    /**
     * 数据库字段：主要条件dcdg_basic_blacklist_base.MINOR_CONDITION
     *
     * @return  the value of dcdg_basic_blacklist_base.MINOR_CONDITION
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    public String getMinorCondition() {
        return minorCondition;
    }

    /**
     * 数据库字段：主要条件dcdg_basic_blacklist_base.MINOR_CONDITION
     * @param minorCondition the value for dcdg_basic_blacklist_base.MINOR_CONDITION
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    public void setMinorCondition(String minorCondition) {
        this.minorCondition = minorCondition == null ? null : minorCondition.trim();
    }

    /**
     * 数据库字段：次要条件dcdg_basic_blacklist_base.MAIN_CONDITION
     *
     * @return  the value of dcdg_basic_blacklist_base.MAIN_CONDITION
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    public String getMainCondition() {
        return mainCondition;
    }

    /**
     * 数据库字段：次要条件dcdg_basic_blacklist_base.MAIN_CONDITION
     * @param mainCondition the value for dcdg_basic_blacklist_base.MAIN_CONDITION
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    public void setMainCondition(String mainCondition) {
        this.mainCondition = mainCondition == null ? null : mainCondition.trim();
    }

    /**
     * 数据库字段：黑名单类型[1-多次点击]dcdg_basic_blacklist_base.BLACKLIST_TYPE
     *
     * @return  the value of dcdg_basic_blacklist_base.BLACKLIST_TYPE
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    public Byte getBlacklistType() {
        return blacklistType;
    }

    /**
     * 数据库字段：黑名单类型[1-多次点击]dcdg_basic_blacklist_base.BLACKLIST_TYPE
     * @param blacklistType the value for dcdg_basic_blacklist_base.BLACKLIST_TYPE
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    public void setBlacklistType(Byte blacklistType) {
        this.blacklistType = blacklistType;
    }

    /**
     * 数据库字段：黑名单状态[1-正常 2-禁止]dcdg_basic_blacklist_base.BLACKLIST_STATUS
     *
     * @return  the value of dcdg_basic_blacklist_base.BLACKLIST_STATUS
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    public Byte getBlacklistStatus() {
        return blacklistStatus;
    }

    /**
     * 数据库字段：黑名单状态[1-正常 2-禁止]dcdg_basic_blacklist_base.BLACKLIST_STATUS
     * @param blacklistStatus the value for dcdg_basic_blacklist_base.BLACKLIST_STATUS
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    public void setBlacklistStatus(Byte blacklistStatus) {
        this.blacklistStatus = blacklistStatus;
    }

    /**
     * 数据库字段：添加时间dcdg_basic_blacklist_base.ADD_TIME
     *
     * @return  the value of dcdg_basic_blacklist_base.ADD_TIME
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_basic_blacklist_base.ADD_TIME
     * @param addTime the value for dcdg_basic_blacklist_base.ADD_TIME
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：修改时间dcdg_basic_blacklist_base.UPDATE_TIME
     *
     * @return  the value of dcdg_basic_blacklist_base.UPDATE_TIME
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：修改时间dcdg_basic_blacklist_base.UPDATE_TIME
     * @param updateTime the value for dcdg_basic_blacklist_base.UPDATE_TIME
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 数据库字段：说明dcdg_basic_blacklist_base.BLACK_DESC
     *
     * @return  the value of dcdg_basic_blacklist_base.BLACK_DESC
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    public String getBlackDesc() {
        return blackDesc;
    }

    /**
     * 数据库字段：说明dcdg_basic_blacklist_base.BLACK_DESC
     * @param blackDesc the value for dcdg_basic_blacklist_base.BLACK_DESC
     *
     * @mbg.generated Mon Jun 10 10:54:05 CST 2019
     */
    public void setBlackDesc(String blackDesc) {
        this.blackDesc = blackDesc == null ? null : blackDesc.trim();
    }
}