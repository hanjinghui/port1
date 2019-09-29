package com.louquanapp.req;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 直播请求 2019年04月23日14:26:46
 */
public class ReqVideo extends ReqToken {

    /**
     * 拉流地址
     * <p>
     * 数据库字段名:dcdg_video_video_base.VIDEO_URL
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private String videoUrl;

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    /**
     * 标题
     * <p>
     * 数据库字段名:dcdg_video_video_base.VIDEO_TITLE
     *
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    @NotNull(message = "标题不能为空")
    private String videoTitle;

    /**
     * 分类
     * <p>
     * 数据库字段名:dcdg_video_video_base.CAT_ID
     *
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    @NotNull(message = "分类不能为空")
    private String catId;

    /**
     * 默认图片
     * <p>
     * 数据库字段名:dcdg_video_video_base.VIDEO_IMG
     *
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    private String videoImg;


    /**
     * 预计时长（分钟）
     * <p>
     * 数据库字段名:dcdg_video_video_base.VIDEO_TIME
     *
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    private Integer videoTime;


    /**
     * 开始时间
     * <p>
     * 数据库字段名:dcdg_video_video_base.VIDEO_START_TIME
     *
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
//    @NotNull(message = "开始时间")
    private Date videoStartTime;

    /**
     * 结束时间
     * <p>
     * 数据库字段名:dcdg_video_video_base.VIDEO_END_TIME
     *
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
//    @NotNull(message = "结束时间")
    private Date videoEndTime;

    /**
     * 位置
     * <p>
     * 数据库字段名:dcdg_video_video_base.LOCATION
     *
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    private String location;

    /**
     * 视频介绍
     * <p>
     * 数据库字段名:dcdg_video_video_base.VIDEO_DESC
     *
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    private String videoDesc;

    /**
     * 类型[1-直播 2-点播]
     * <p>
     * 数据库字段名:dcdg_video_video_base.VIDEO_TYPE
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private Byte videoType;


    /**
     * 数据库字段：标题dcdg_video_video_base.VIDEO_TITLE
     *
     * @return the value of dcdg_video_video_base.VIDEO_TITLE
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    public String getVideoTitle() {
        return videoTitle;
    }

    /**
     * 数据库字段：标题dcdg_video_video_base.VIDEO_TITLE
     *
     * @param videoTitle the value for dcdg_video_video_base.VIDEO_TITLE
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle == null ? null : videoTitle.trim();
    }

    /**
     * 数据库字段：分类dcdg_video_video_base.CAT_ID
     *
     * @return the value of dcdg_video_video_base.CAT_ID
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    public String getCatId() {
        return catId;
    }

    /**
     * 数据库字段：分类dcdg_video_video_base.CAT_ID
     *
     * @param catId the value for dcdg_video_video_base.CAT_ID
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    public void setCatId(String catId) {
        this.catId = catId == null ? null : catId.trim();
    }

    /**
     * 数据库字段：默认图片dcdg_video_video_base.VIDEO_IMG
     *
     * @return the value of dcdg_video_video_base.VIDEO_IMG
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    public String getVideoImg() {
        return videoImg;
    }

    /**
     * 数据库字段：默认图片dcdg_video_video_base.VIDEO_IMG
     *
     * @param videoImg the value for dcdg_video_video_base.VIDEO_IMG
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg == null ? null : videoImg.trim();
    }


    /**
     * 数据库字段：预计时长（分钟）dcdg_video_video_base.VIDEO_TIME
     *
     * @return the value of dcdg_video_video_base.VIDEO_TIME
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    public Integer getVideoTime() {
        return videoTime;
    }

    /**
     * 数据库字段：预计时长（分钟）dcdg_video_video_base.VIDEO_TIME
     *
     * @param videoTime the value for dcdg_video_video_base.VIDEO_TIME
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    public void setVideoTime(Integer videoTime) {
        this.videoTime = videoTime;
    }


    /**
     * 数据库字段：开始时间dcdg_video_video_base.VIDEO_START_TIME
     *
     * @return the value of dcdg_video_video_base.VIDEO_START_TIME
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    public Date getVideoStartTime() {
        return videoStartTime;
    }

    /**
     * 数据库字段：开始时间dcdg_video_video_base.VIDEO_START_TIME
     *
     * @param videoStartTime the value for dcdg_video_video_base.VIDEO_START_TIME
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    public void setVideoStartTime(Date videoStartTime) {
        this.videoStartTime = videoStartTime;
    }

    /**
     * 数据库字段：结束时间dcdg_video_video_base.VIDEO_END_TIME
     *
     * @return the value of dcdg_video_video_base.VIDEO_END_TIME
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    public Date getVideoEndTime() {
        return videoEndTime;
    }

    /**
     * 数据库字段：结束时间dcdg_video_video_base.VIDEO_END_TIME
     *
     * @param videoEndTime the value for dcdg_video_video_base.VIDEO_END_TIME
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    public void setVideoEndTime(Date videoEndTime) {
        this.videoEndTime = videoEndTime;
    }

    /**
     * 数据库字段：位置dcdg_video_video_base.LOCATION
     *
     * @return the value of dcdg_video_video_base.LOCATION
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    public String getLocation() {
        return location;
    }

    /**
     * 数据库字段：位置dcdg_video_video_base.LOCATION
     *
     * @param location the value for dcdg_video_video_base.LOCATION
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * 数据库字段：视频介绍dcdg_video_video_base.VIDEO_DESC
     *
     * @return the value of dcdg_video_video_base.VIDEO_DESC
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    public String getVideoDesc() {
        return videoDesc;
    }

    /**
     * 数据库字段：视频介绍dcdg_video_video_base.VIDEO_DESC
     *
     * @param videoDesc the value for dcdg_video_video_base.VIDEO_DESC
     * @mbg.generated Tue Apr 23 14:23:54 CST 2019
     */
    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc == null ? null : videoDesc.trim();
    }

    public Byte getVideoType() {
        return videoType;
    }

    public void setVideoType(Byte videoType) {
        this.videoType = videoType;
    }
}