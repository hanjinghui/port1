package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.VideoEvaluateExtra;
import com.louquanapp.dao.extra.VideoExtra;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_video_evaluate_base
 *
 * @mbg.generated do_not_delete_during_merge Wed Jul 03 11:23:20 CST 2019
 */
public class VideoEvaluate extends VideoEvaluateExtra {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_video_evaluate_base.EVALUATE_ID
     *
     * @mbg.generated Wed Jul 03 11:23:20 CST 2019
     */
    private String evaluateId;

    /**
     *   父节点主键
     *
     * 数据库字段名:dcdg_video_evaluate_base.PARENT_ID
     *
     * @mbg.generated Wed Jul 03 11:23:20 CST 2019
     */
    private String parentId;

    /**
     *   视频id
     *
     * 数据库字段名:dcdg_video_evaluate_base.VIDEO_ID
     *
     * @mbg.generated Wed Jul 03 11:23:20 CST 2019
     */
    private String videoId;

    /**
     *   评论内容
     *
     * 数据库字段名:dcdg_video_evaluate_base.EVALUATE_CONT
     *
     * @mbg.generated Wed Jul 03 11:23:20 CST 2019
     */
    private String evaluateCont;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_video_evaluate_base.ADD_TIME
     *
     * @mbg.generated Wed Jul 03 11:23:20 CST 2019
     */
    private Date addTime;

    /**
     *   用户id
     *
     * 数据库字段名:dcdg_video_evaluate_base.CUST_ID
     *
     * @mbg.generated Wed Jul 03 11:23:20 CST 2019
     */
    private String custId;

    /**
     * 数据库字段：主键dcdg_video_evaluate_base.EVALUATE_ID
     *
     * @return  the value of dcdg_video_evaluate_base.EVALUATE_ID
     *
     * @mbg.generated Wed Jul 03 11:23:20 CST 2019
     */
    public String getEvaluateId() {
        return evaluateId;
    }

    /**
     * 数据库字段：主键dcdg_video_evaluate_base.EVALUATE_ID
     * @param evaluateId the value for dcdg_video_evaluate_base.EVALUATE_ID
     *
     * @mbg.generated Wed Jul 03 11:23:20 CST 2019
     */
    public void setEvaluateId(String evaluateId) {
        this.evaluateId = evaluateId == null ? null : evaluateId.trim();
    }

    /**
     * 数据库字段：父节点主键dcdg_video_evaluate_base.PARENT_ID
     *
     * @return  the value of dcdg_video_evaluate_base.PARENT_ID
     *
     * @mbg.generated Wed Jul 03 11:23:20 CST 2019
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 数据库字段：父节点主键dcdg_video_evaluate_base.PARENT_ID
     * @param parentId the value for dcdg_video_evaluate_base.PARENT_ID
     *
     * @mbg.generated Wed Jul 03 11:23:20 CST 2019
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 数据库字段：视频iddcdg_video_evaluate_base.VIDEO_ID
     *
     * @return  the value of dcdg_video_evaluate_base.VIDEO_ID
     *
     * @mbg.generated Wed Jul 03 11:23:20 CST 2019
     */
    public String getVideoId() {
        return videoId;
    }

    /**
     * 数据库字段：视频iddcdg_video_evaluate_base.VIDEO_ID
     * @param videoId the value for dcdg_video_evaluate_base.VIDEO_ID
     *
     * @mbg.generated Wed Jul 03 11:23:20 CST 2019
     */
    public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }

    /**
     * 数据库字段：评论内容dcdg_video_evaluate_base.EVALUATE_CONT
     *
     * @return  the value of dcdg_video_evaluate_base.EVALUATE_CONT
     *
     * @mbg.generated Wed Jul 03 11:23:20 CST 2019
     */
    public String getEvaluateCont() {
        return evaluateCont;
    }

    /**
     * 数据库字段：评论内容dcdg_video_evaluate_base.EVALUATE_CONT
     * @param evaluateCont the value for dcdg_video_evaluate_base.EVALUATE_CONT
     *
     * @mbg.generated Wed Jul 03 11:23:20 CST 2019
     */
    public void setEvaluateCont(String evaluateCont) {
        this.evaluateCont = evaluateCont == null ? null : evaluateCont.trim();
    }

    /**
     * 数据库字段：添加时间dcdg_video_evaluate_base.ADD_TIME
     *
     * @return  the value of dcdg_video_evaluate_base.ADD_TIME
     *
     * @mbg.generated Wed Jul 03 11:23:20 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_video_evaluate_base.ADD_TIME
     * @param addTime the value for dcdg_video_evaluate_base.ADD_TIME
     *
     * @mbg.generated Wed Jul 03 11:23:20 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：用户iddcdg_video_evaluate_base.CUST_ID
     *
     * @return  the value of dcdg_video_evaluate_base.CUST_ID
     *
     * @mbg.generated Wed Jul 03 11:23:20 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：用户iddcdg_video_evaluate_base.CUST_ID
     * @param custId the value for dcdg_video_evaluate_base.CUST_ID
     *
     * @mbg.generated Wed Jul 03 11:23:20 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }
}