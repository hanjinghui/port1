package com.louquanapp.dao.model;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_goods_goods_video
 *
 * @mbg.generated do_not_delete_during_merge Wed Apr 03 08:11:15 CST 2019
 */
public class GoodsVideo {
    /**
     * 主键
     * <p>
     * 数据库字段名:dcdg_goods_goods_video.VIDEO_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String videoId;

    /**
     * 视频URL
     * <p>
     * 数据库字段名:dcdg_goods_goods_video.VIDEO_URL
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String videoUrl;

    /**
     * 关联ID
     * <p>
     * 数据库字段名:dcdg_goods_goods_video.SOURCE_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String sourceId;

    /**
     * 浏览量
     * <p>
     * 数据库字段名:dcdg_goods_goods_video.SKIM_COUNT
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Integer skimCount;

    /**
     * 点赞量
     * <p>
     * 数据库字段名:dcdg_goods_goods_video.SPOT_COUNT
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Integer spotCount;

    /**
     * 收藏量
     * <p>
     * 数据库字段名:dcdg_goods_goods_video.FAV_COUNT
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Integer favCount;

    /**
     * 添加时间
     * <p>
     * 数据库字段名:dcdg_goods_goods_video.ADD_TIME
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Date addTime;

    /**
     * 添加人
     * <p>
     * 数据库字段名:dcdg_goods_goods_video.ADD_USER
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String addUser;

    /**
     * 添加人名称
     * <p>
     * 数据库字段名:dcdg_goods_goods_video.ADD_USER_NAME
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String addUserName;

    /**
     * 修改时间
     * <p>
     * 数据库字段名:dcdg_goods_goods_video.UPDATE_TIME
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Date updateTime;

    /**
     * 修改人
     * <p>
     * 数据库字段名:dcdg_goods_goods_video.UPDATE_USER
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String updateUser;

    /**
     * 修改人名称
     * <p>
     * 数据库字段名:dcdg_goods_goods_video.UPDATE_USER_NAME
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String updateUserName;

    /**
     * 标题
     * <p>
     * 数据库字段名:dcdg_goods_goods_video.VIDEO_TITLE
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String videoTitle;

    /**
     * 视频说明
     * <p>
     * 数据库字段名:dcdg_goods_goods_video.VIDEO_DESC
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String videoDesc;

    /**
     * 数据库字段：主键dcdg_goods_goods_video.VIDEO_ID
     *
     * @return the value of dcdg_goods_goods_video.VIDEO_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getVideoId() {
        return videoId;
    }

    /**
     * 数据库字段：主键dcdg_goods_goods_video.VIDEO_ID
     *
     * @param videoId the value for dcdg_goods_goods_video.VIDEO_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }

    /**
     * 数据库字段：视频URLdcdg_goods_goods_video.VIDEO_URL
     *
     * @return the value of dcdg_goods_goods_video.VIDEO_URL
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * 数据库字段：视频URLdcdg_goods_goods_video.VIDEO_URL
     *
     * @param videoUrl the value for dcdg_goods_goods_video.VIDEO_URL
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    /**
     * 数据库字段：关联IDdcdg_goods_goods_video.SOURCE_ID
     *
     * @return the value of dcdg_goods_goods_video.SOURCE_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * 数据库字段：关联IDdcdg_goods_goods_video.SOURCE_ID
     *
     * @param sourceId the value for dcdg_goods_goods_video.SOURCE_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    /**
     * 数据库字段：浏览量dcdg_goods_goods_video.SKIM_COUNT
     *
     * @return the value of dcdg_goods_goods_video.SKIM_COUNT
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Integer getSkimCount() {
        return skimCount;
    }

    /**
     * 数据库字段：浏览量dcdg_goods_goods_video.SKIM_COUNT
     *
     * @param skimCount the value for dcdg_goods_goods_video.SKIM_COUNT
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setSkimCount(Integer skimCount) {
        this.skimCount = skimCount;
    }

    /**
     * 数据库字段：点赞量dcdg_goods_goods_video.SPOT_COUNT
     *
     * @return the value of dcdg_goods_goods_video.SPOT_COUNT
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Integer getSpotCount() {
        return spotCount;
    }

    /**
     * 数据库字段：点赞量dcdg_goods_goods_video.SPOT_COUNT
     *
     * @param spotCount the value for dcdg_goods_goods_video.SPOT_COUNT
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setSpotCount(Integer spotCount) {
        this.spotCount = spotCount;
    }

    /**
     * 数据库字段：收藏量dcdg_goods_goods_video.FAV_COUNT
     *
     * @return the value of dcdg_goods_goods_video.FAV_COUNT
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Integer getFavCount() {
        return favCount;
    }

    /**
     * 数据库字段：收藏量dcdg_goods_goods_video.FAV_COUNT
     *
     * @param favCount the value for dcdg_goods_goods_video.FAV_COUNT
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setFavCount(Integer favCount) {
        this.favCount = favCount;
    }

    /**
     * 数据库字段：添加时间dcdg_goods_goods_video.ADD_TIME
     *
     * @return the value of dcdg_goods_goods_video.ADD_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_goods_goods_video.ADD_TIME
     *
     * @param addTime the value for dcdg_goods_goods_video.ADD_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：添加人dcdg_goods_goods_video.ADD_USER
     *
     * @return the value of dcdg_goods_goods_video.ADD_USER
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getAddUser() {
        return addUser;
    }

    /**
     * 数据库字段：添加人dcdg_goods_goods_video.ADD_USER
     *
     * @param addUser the value for dcdg_goods_goods_video.ADD_USER
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setAddUser(String addUser) {
        this.addUser = addUser == null ? null : addUser.trim();
    }

    /**
     * 数据库字段：添加人名称dcdg_goods_goods_video.ADD_USER_NAME
     *
     * @return the value of dcdg_goods_goods_video.ADD_USER_NAME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getAddUserName() {
        return addUserName;
    }

    /**
     * 数据库字段：添加人名称dcdg_goods_goods_video.ADD_USER_NAME
     *
     * @param addUserName the value for dcdg_goods_goods_video.ADD_USER_NAME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName == null ? null : addUserName.trim();
    }

    /**
     * 数据库字段：修改时间dcdg_goods_goods_video.UPDATE_TIME
     *
     * @return the value of dcdg_goods_goods_video.UPDATE_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：修改时间dcdg_goods_goods_video.UPDATE_TIME
     *
     * @param updateTime the value for dcdg_goods_goods_video.UPDATE_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 数据库字段：修改人dcdg_goods_goods_video.UPDATE_USER
     *
     * @return the value of dcdg_goods_goods_video.UPDATE_USER
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 数据库字段：修改人dcdg_goods_goods_video.UPDATE_USER
     *
     * @param updateUser the value for dcdg_goods_goods_video.UPDATE_USER
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * 数据库字段：修改人名称dcdg_goods_goods_video.UPDATE_USER_NAME
     *
     * @return the value of dcdg_goods_goods_video.UPDATE_USER_NAME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getUpdateUserName() {
        return updateUserName;
    }

    /**
     * 数据库字段：修改人名称dcdg_goods_goods_video.UPDATE_USER_NAME
     *
     * @param updateUserName the value for dcdg_goods_goods_video.UPDATE_USER_NAME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    /**
     * 数据库字段：标题dcdg_goods_goods_video.VIDEO_TITLE
     *
     * @return the value of dcdg_goods_goods_video.VIDEO_TITLE
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getVideoTitle() {
        return videoTitle;
    }

    /**
     * 数据库字段：标题dcdg_goods_goods_video.VIDEO_TITLE
     *
     * @param videoTitle the value for dcdg_goods_goods_video.VIDEO_TITLE
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle == null ? null : videoTitle.trim();
    }

    /**
     * 数据库字段：视频说明dcdg_goods_goods_video.VIDEO_DESC
     *
     * @return the value of dcdg_goods_goods_video.VIDEO_DESC
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getVideoDesc() {
        return videoDesc;
    }

    /**
     * 数据库字段：视频说明dcdg_goods_goods_video.VIDEO_DESC
     *
     * @param videoDesc the value for dcdg_goods_goods_video.VIDEO_DESC
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc == null ? null : videoDesc.trim();
    }
}