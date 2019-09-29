package com.louquanapp.dao.model;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_about_us_base
 *
 * @mbg.generated do_not_delete_during_merge Mon May 27 16:05:54 CST 2019
 */
public class AboutUs {
    /**
     *   消息ID
     *
     * 数据库字段名:dcdg_about_us_base.ABOUT_ID
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    private String aboutId;

    /**
     *   状态[1-启用 2-禁止]
     *
     * 数据库字段名:dcdg_about_us_base.ABOUT_STATUS
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    private Byte aboutStatus;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_about_us_base.ADD_TIME
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    private Date addTime;

    /**
     *   添加人
     *
     * 数据库字段名:dcdg_about_us_base.ADD_USER
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    private String addUser;

    /**
     *   更新时间
     *
     * 数据库字段名:dcdg_about_us_base.UPDATE_TIME
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    private Date updateTime;

    /**
     *   消息内容
     *
     * 数据库字段名:dcdg_about_us_base.ABOUT
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    private String about;

    /**
     * 数据库字段：消息IDdcdg_about_us_base.ABOUT_ID
     *
     * @return  the value of dcdg_about_us_base.ABOUT_ID
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    public String getAboutId() {
        return aboutId;
    }

    /**
     * 数据库字段：消息IDdcdg_about_us_base.ABOUT_ID
     * @param aboutId the value for dcdg_about_us_base.ABOUT_ID
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    public void setAboutId(String aboutId) {
        this.aboutId = aboutId == null ? null : aboutId.trim();
    }

    /**
     * 数据库字段：状态[1-启用 2-禁止]dcdg_about_us_base.ABOUT_STATUS
     *
     * @return  the value of dcdg_about_us_base.ABOUT_STATUS
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    public Byte getAboutStatus() {
        return aboutStatus;
    }

    /**
     * 数据库字段：状态[1-启用 2-禁止]dcdg_about_us_base.ABOUT_STATUS
     * @param aboutStatus the value for dcdg_about_us_base.ABOUT_STATUS
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    public void setAboutStatus(Byte aboutStatus) {
        this.aboutStatus = aboutStatus;
    }

    /**
     * 数据库字段：添加时间dcdg_about_us_base.ADD_TIME
     *
     * @return  the value of dcdg_about_us_base.ADD_TIME
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_about_us_base.ADD_TIME
     * @param addTime the value for dcdg_about_us_base.ADD_TIME
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：添加人dcdg_about_us_base.ADD_USER
     *
     * @return  the value of dcdg_about_us_base.ADD_USER
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    public String getAddUser() {
        return addUser;
    }

    /**
     * 数据库字段：添加人dcdg_about_us_base.ADD_USER
     * @param addUser the value for dcdg_about_us_base.ADD_USER
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    public void setAddUser(String addUser) {
        this.addUser = addUser == null ? null : addUser.trim();
    }

    /**
     * 数据库字段：更新时间dcdg_about_us_base.UPDATE_TIME
     *
     * @return  the value of dcdg_about_us_base.UPDATE_TIME
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：更新时间dcdg_about_us_base.UPDATE_TIME
     * @param updateTime the value for dcdg_about_us_base.UPDATE_TIME
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 数据库字段：消息内容dcdg_about_us_base.ABOUT
     *
     * @return  the value of dcdg_about_us_base.ABOUT
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    public String getAbout() {
        return about;
    }

    /**
     * 数据库字段：消息内容dcdg_about_us_base.ABOUT
     * @param about the value for dcdg_about_us_base.ABOUT
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    public void setAbout(String about) {
        this.about = about == null ? null : about.trim();
    }
}