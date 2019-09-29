package com.louquanapp.dao.model;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 andji_basic_version_base
 *
 * @mbg.generated do_not_delete_during_merge Mon Jul 08 18:33:27 CST 2019
 */
public class BasicVersion {
    /**
     *   主键
     *
     * 数据库字段名:andji_basic_version_base.VERSION_ID
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    private String versionId;

    /**
     *   版本号
     *
     * 数据库字段名:andji_basic_version_base.VERSION_NO
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    private String versionNo;

    /**
     *   版本地址
     *
     * 数据库字段名:andji_basic_version_base.VERSION_URL
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    private String versionUrl;

    /**
     *   版本状态[1-最新版本 2-历史版本]
     *
     * 数据库字段名:andji_basic_version_base.VERSION_STATUS
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    private Byte versionStatus;

    /**
     *   添加时间
     *
     * 数据库字段名:andji_basic_version_base.ADD_TIME
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    private Date addTime;

    /**
     *   添加人ID
     *
     * 数据库字段名:andji_basic_version_base.ADD_USER
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    private String addUser;

    /**
     *   添加人名称
     *
     * 数据库字段名:andji_basic_version_base.ADD_USER_NAME
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    private String addUserName;

    /**
     *   app类别[1-android 2-ios]
     *
     * 数据库字段名:andji_basic_version_base.APP_TYPE
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    private Byte appType;

    /**
     *   是否强制更新[1-不需要 2-强制更新]
     *
     * 数据库字段名:andji_basic_version_base.FORCE_UPDATE
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    private Byte forceUpdate;

    /**
     * 数据库字段：主键andji_basic_version_base.VERSION_ID
     *
     * @return  the value of andji_basic_version_base.VERSION_ID
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    public String getVersionId() {
        return versionId;
    }

    /**
     * 数据库字段：主键andji_basic_version_base.VERSION_ID
     * @param versionId the value for andji_basic_version_base.VERSION_ID
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    public void setVersionId(String versionId) {
        this.versionId = versionId == null ? null : versionId.trim();
    }

    /**
     * 数据库字段：版本号andji_basic_version_base.VERSION_NO
     *
     * @return  the value of andji_basic_version_base.VERSION_NO
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    public String getVersionNo() {
        return versionNo;
    }

    /**
     * 数据库字段：版本号andji_basic_version_base.VERSION_NO
     * @param versionNo the value for andji_basic_version_base.VERSION_NO
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo == null ? null : versionNo.trim();
    }

    /**
     * 数据库字段：版本地址andji_basic_version_base.VERSION_URL
     *
     * @return  the value of andji_basic_version_base.VERSION_URL
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    public String getVersionUrl() {
        return versionUrl;
    }

    /**
     * 数据库字段：版本地址andji_basic_version_base.VERSION_URL
     * @param versionUrl the value for andji_basic_version_base.VERSION_URL
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    public void setVersionUrl(String versionUrl) {
        this.versionUrl = versionUrl == null ? null : versionUrl.trim();
    }

    /**
     * 数据库字段：版本状态[1-最新版本 2-历史版本]andji_basic_version_base.VERSION_STATUS
     *
     * @return  the value of andji_basic_version_base.VERSION_STATUS
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    public Byte getVersionStatus() {
        return versionStatus;
    }

    /**
     * 数据库字段：版本状态[1-最新版本 2-历史版本]andji_basic_version_base.VERSION_STATUS
     * @param versionStatus the value for andji_basic_version_base.VERSION_STATUS
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    public void setVersionStatus(Byte versionStatus) {
        this.versionStatus = versionStatus;
    }

    /**
     * 数据库字段：添加时间andji_basic_version_base.ADD_TIME
     *
     * @return  the value of andji_basic_version_base.ADD_TIME
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间andji_basic_version_base.ADD_TIME
     * @param addTime the value for andji_basic_version_base.ADD_TIME
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：添加人IDandji_basic_version_base.ADD_USER
     *
     * @return  the value of andji_basic_version_base.ADD_USER
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    public String getAddUser() {
        return addUser;
    }

    /**
     * 数据库字段：添加人IDandji_basic_version_base.ADD_USER
     * @param addUser the value for andji_basic_version_base.ADD_USER
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    public void setAddUser(String addUser) {
        this.addUser = addUser == null ? null : addUser.trim();
    }

    /**
     * 数据库字段：添加人名称andji_basic_version_base.ADD_USER_NAME
     *
     * @return  the value of andji_basic_version_base.ADD_USER_NAME
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    public String getAddUserName() {
        return addUserName;
    }

    /**
     * 数据库字段：添加人名称andji_basic_version_base.ADD_USER_NAME
     * @param addUserName the value for andji_basic_version_base.ADD_USER_NAME
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName == null ? null : addUserName.trim();
    }

    /**
     * 数据库字段：app类别[1-android 2-ios]andji_basic_version_base.APP_TYPE
     *
     * @return  the value of andji_basic_version_base.APP_TYPE
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    public Byte getAppType() {
        return appType;
    }

    /**
     * 数据库字段：app类别[1-android 2-ios]andji_basic_version_base.APP_TYPE
     * @param appType the value for andji_basic_version_base.APP_TYPE
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    public void setAppType(Byte appType) {
        this.appType = appType;
    }

    /**
     * 数据库字段：是否强制更新[1-不需要 2-强制更新]andji_basic_version_base.FORCE_UPDATE
     *
     * @return  the value of andji_basic_version_base.FORCE_UPDATE
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    public Byte getForceUpdate() {
        return forceUpdate;
    }

    /**
     * 数据库字段：是否强制更新[1-不需要 2-强制更新]andji_basic_version_base.FORCE_UPDATE
     * @param forceUpdate the value for andji_basic_version_base.FORCE_UPDATE
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    public void setForceUpdate(Byte forceUpdate) {
        this.forceUpdate = forceUpdate;
    }
}