package com.louquanapp.dao.model;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_basic_banner_base
 *
 * @mbg.generated do_not_delete_during_merge Mon Apr 08 10:50:00 CST 2019
 */
public class Banner {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_basic_banner_base.BANNER_ID
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    private String bannerId;

    /**
     *   标题
     *
     * 数据库字段名:dcdg_basic_banner_base.BANNER_TITLE
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    private String bannerTitle;

    /**
     *   点击量
     *
     * 数据库字段名:dcdg_basic_banner_base.CLICK_COUNT
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    private Integer clickCount;

    /**
     *   排序
     *
     * 数据库字段名:dcdg_basic_banner_base.ORDER_BY
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    private Byte orderBy;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_basic_banner_base.ADD_TIME
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    private Date addTime;

    /**
     *   添加人
     *
     * 数据库字段名:dcdg_basic_banner_base.ADD_USER
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    private String addUser;

    /**
     *   添加人名称
     *
     * 数据库字段名:dcdg_basic_banner_base.ADD_USER_NAME
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    private String addUserName;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_basic_banner_base.UPDATE_TIME
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    private Date updateTime;

    /**
     *   内容
     *
     * 数据库字段名:dcdg_basic_banner_base.BANNER_CONTENT
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    private String bannerContent;

    /**
     *   banner状态[1-启用 2-禁用]
     *
     * 数据库字段名:dcdg_basic_banner_base.BANNER_FLAG
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    private Byte bannerFlag;

    /**
     *   目标[1-商品 2-链接 3-图文]
     *
     * 数据库字段名:dcdg_basic_banner_base.BANNER_TYPE
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    private Byte bannerType;

    /**
     *   banner图
     *
     * 数据库字段名:dcdg_basic_banner_base.IMG_URL
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    private String imgUrl;

    /**
     *   页面类型[1-首页 2-商圈 3-游戏 4-商家申请 5-直播 6-红包]
     *
     * 数据库字段名:dcdg_basic_banner_base.BANNER_PAGE
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    private Byte bannerPage;

    /**
     * 数据库字段：主键dcdg_basic_banner_base.BANNER_ID
     *
     * @return  the value of dcdg_basic_banner_base.BANNER_ID
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public String getBannerId() {
        return bannerId;
    }

    /**
     * 数据库字段：主键dcdg_basic_banner_base.BANNER_ID
     * @param bannerId the value for dcdg_basic_banner_base.BANNER_ID
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public void setBannerId(String bannerId) {
        this.bannerId = bannerId == null ? null : bannerId.trim();
    }

    /**
     * 数据库字段：标题dcdg_basic_banner_base.BANNER_TITLE
     *
     * @return  the value of dcdg_basic_banner_base.BANNER_TITLE
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public String getBannerTitle() {
        return bannerTitle;
    }

    /**
     * 数据库字段：标题dcdg_basic_banner_base.BANNER_TITLE
     * @param bannerTitle the value for dcdg_basic_banner_base.BANNER_TITLE
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public void setBannerTitle(String bannerTitle) {
        this.bannerTitle = bannerTitle == null ? null : bannerTitle.trim();
    }

    /**
     * 数据库字段：点击量dcdg_basic_banner_base.CLICK_COUNT
     *
     * @return  the value of dcdg_basic_banner_base.CLICK_COUNT
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public Integer getClickCount() {
        return clickCount;
    }

    /**
     * 数据库字段：点击量dcdg_basic_banner_base.CLICK_COUNT
     * @param clickCount the value for dcdg_basic_banner_base.CLICK_COUNT
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    /**
     * 数据库字段：排序dcdg_basic_banner_base.ORDER_BY
     *
     * @return  the value of dcdg_basic_banner_base.ORDER_BY
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public Byte getOrderBy() {
        return orderBy;
    }

    /**
     * 数据库字段：排序dcdg_basic_banner_base.ORDER_BY
     * @param orderBy the value for dcdg_basic_banner_base.ORDER_BY
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public void setOrderBy(Byte orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * 数据库字段：添加时间dcdg_basic_banner_base.ADD_TIME
     *
     * @return  the value of dcdg_basic_banner_base.ADD_TIME
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_basic_banner_base.ADD_TIME
     * @param addTime the value for dcdg_basic_banner_base.ADD_TIME
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：添加人dcdg_basic_banner_base.ADD_USER
     *
     * @return  the value of dcdg_basic_banner_base.ADD_USER
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public String getAddUser() {
        return addUser;
    }

    /**
     * 数据库字段：添加人dcdg_basic_banner_base.ADD_USER
     * @param addUser the value for dcdg_basic_banner_base.ADD_USER
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public void setAddUser(String addUser) {
        this.addUser = addUser == null ? null : addUser.trim();
    }

    /**
     * 数据库字段：添加人名称dcdg_basic_banner_base.ADD_USER_NAME
     *
     * @return  the value of dcdg_basic_banner_base.ADD_USER_NAME
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public String getAddUserName() {
        return addUserName;
    }

    /**
     * 数据库字段：添加人名称dcdg_basic_banner_base.ADD_USER_NAME
     * @param addUserName the value for dcdg_basic_banner_base.ADD_USER_NAME
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName == null ? null : addUserName.trim();
    }

    /**
     * 数据库字段：添加时间dcdg_basic_banner_base.UPDATE_TIME
     *
     * @return  the value of dcdg_basic_banner_base.UPDATE_TIME
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：添加时间dcdg_basic_banner_base.UPDATE_TIME
     * @param updateTime the value for dcdg_basic_banner_base.UPDATE_TIME
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 数据库字段：内容dcdg_basic_banner_base.BANNER_CONTENT
     *
     * @return  the value of dcdg_basic_banner_base.BANNER_CONTENT
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public String getBannerContent() {
        return bannerContent;
    }

    /**
     * 数据库字段：内容dcdg_basic_banner_base.BANNER_CONTENT
     * @param bannerContent the value for dcdg_basic_banner_base.BANNER_CONTENT
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public void setBannerContent(String bannerContent) {
        this.bannerContent = bannerContent == null ? null : bannerContent.trim();
    }

    /**
     * 数据库字段：banner状态[1-启用 2-禁用]dcdg_basic_banner_base.BANNER_FLAG
     *
     * @return  the value of dcdg_basic_banner_base.BANNER_FLAG
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public Byte getBannerFlag() {
        return bannerFlag;
    }

    /**
     * 数据库字段：banner状态[1-启用 2-禁用]dcdg_basic_banner_base.BANNER_FLAG
     * @param bannerFlag the value for dcdg_basic_banner_base.BANNER_FLAG
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public void setBannerFlag(Byte bannerFlag) {
        this.bannerFlag = bannerFlag;
    }

    /**
     * 数据库字段：目标[1-商品 2-链接 3-图文]dcdg_basic_banner_base.BANNER_TYPE
     *
     * @return  the value of dcdg_basic_banner_base.BANNER_TYPE
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public Byte getBannerType() {
        return bannerType;
    }

    /**
     * 数据库字段：目标[1-商品 2-链接 3-图文]dcdg_basic_banner_base.BANNER_TYPE
     * @param bannerType the value for dcdg_basic_banner_base.BANNER_TYPE
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public void setBannerType(Byte bannerType) {
        this.bannerType = bannerType;
    }

    /**
     * 数据库字段：banner图dcdg_basic_banner_base.IMG_URL
     *
     * @return  the value of dcdg_basic_banner_base.IMG_URL
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 数据库字段：banner图dcdg_basic_banner_base.IMG_URL
     * @param imgUrl the value for dcdg_basic_banner_base.IMG_URL
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 数据库字段：页面类型[1-首页 2-商圈 3-游戏 4-商家申请 5-直播 6-红包]dcdg_basic_banner_base.BANNER_PAGE
     *
     * @return  the value of dcdg_basic_banner_base.BANNER_PAGE
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public Byte getBannerPage() {
        return bannerPage;
    }

    /**
     * 数据库字段：页面类型[1-首页 2-商圈 3-游戏 4-商家申请 5-直播 6-红包]dcdg_basic_banner_base.BANNER_PAGE
     * @param bannerPage the value for dcdg_basic_banner_base.BANNER_PAGE
     *
     * @mbg.generated Mon Apr 08 10:50:00 CST 2019
     */
    public void setBannerPage(Byte bannerPage) {
        this.bannerPage = bannerPage;
    }

    public String getPointOrCast() {
        return pointOrCast;
    }

    public void setPointOrCast(String pointOrCast) {
        this.pointOrCast = pointOrCast;
    }

    public Byte getPointOrCastType() {
        return pointOrCastType;
    }

    public void setPointOrCastType(Byte pointOrCastType) {
        this.pointOrCastType = pointOrCastType;
    }

    /**
     * 目标是12时有用-积分或现金余额
     */
    private String pointOrCast;
    /**
     * 目标是12时有用-积分或现金余额类型[1-积分 2-现金余额]
     */
    public Byte pointOrCastType;


}