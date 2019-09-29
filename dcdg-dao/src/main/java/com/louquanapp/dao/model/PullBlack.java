package com.louquanapp.dao.model;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_video_pull_black
 *
 * @mbg.generated do_not_delete_during_merge Mon Jun 10 14:21:09 CST 2019
 */
public class PullBlack {
    /**
     *
     * 数据库字段名:dcdg_video_pull_black.BACK_ID
     *
     * @mbg.generated Mon Jun 10 14:21:09 CST 2019
     */
    private String backId;

    /**
     *   用户主键
     *
     * 数据库字段名:dcdg_video_pull_black.CUST_ID
     *
     * @mbg.generated Mon Jun 10 14:21:09 CST 2019
     */
    private String custId;

    /**
     *   视频主键
     *
     * 数据库字段名:dcdg_video_pull_black.VIDEO_ID
     *
     * @mbg.generated Mon Jun 10 14:21:09 CST 2019
     */
    private String videoId;

    /**
     *
     * 数据库字段名:dcdg_video_pull_black.ADD_TIME
     *
     * @mbg.generated Mon Jun 10 14:21:09 CST 2019
     */
    private Date addTime;

    /**
     * 数据库字段：dcdg_video_pull_black.BACK_ID
     *
     * @return  the value of dcdg_video_pull_black.BACK_ID
     *
     * @mbg.generated Mon Jun 10 14:21:09 CST 2019
     */
    public String getBackId() {
        return backId;
    }

    /**
     * 数据库字段：dcdg_video_pull_black.BACK_ID
     * @param backId the value for dcdg_video_pull_black.BACK_ID
     *
     * @mbg.generated Mon Jun 10 14:21:09 CST 2019
     */
    public void setBackId(String backId) {
        this.backId = backId == null ? null : backId.trim();
    }

    /**
     * 数据库字段：用户主键dcdg_video_pull_black.CUST_ID
     *
     * @return  the value of dcdg_video_pull_black.CUST_ID
     *
     * @mbg.generated Mon Jun 10 14:21:09 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：用户主键dcdg_video_pull_black.CUST_ID
     * @param custId the value for dcdg_video_pull_black.CUST_ID
     *
     * @mbg.generated Mon Jun 10 14:21:09 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：视频主键dcdg_video_pull_black.VIDEO_ID
     *
     * @return  the value of dcdg_video_pull_black.VIDEO_ID
     *
     * @mbg.generated Mon Jun 10 14:21:09 CST 2019
     */
    public String getVideoId() {
        return videoId;
    }

    /**
     * 数据库字段：视频主键dcdg_video_pull_black.VIDEO_ID
     * @param videoId the value for dcdg_video_pull_black.VIDEO_ID
     *
     * @mbg.generated Mon Jun 10 14:21:09 CST 2019
     */
    public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }

    /**
     * 数据库字段：dcdg_video_pull_black.ADD_TIME
     *
     * @return  the value of dcdg_video_pull_black.ADD_TIME
     *
     * @mbg.generated Mon Jun 10 14:21:09 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：dcdg_video_pull_black.ADD_TIME
     * @param addTime the value for dcdg_video_pull_black.ADD_TIME
     *
     * @mbg.generated Mon Jun 10 14:21:09 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}