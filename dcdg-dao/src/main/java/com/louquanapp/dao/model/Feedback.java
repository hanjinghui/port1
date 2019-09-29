package com.louquanapp.dao.model;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 bpbasic_feedback_base
 *
 * @mbg.generated do_not_delete_during_merge Thu Apr 11 07:58:44 CST 2019
 */
public class Feedback {
    /**
     *   主键
     *
     * 数据库字段名:bpbasic_feedback_base.FEEDBACK_ID
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    private String feedbackId;

    /**
     *   反馈类型
     *
     * 数据库字段名:bpbasic_feedback_base.FEEDBACK_TYPE
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    private String feedbackType;

    /**
     *   反馈内容
     *
     * 数据库字段名:bpbasic_feedback_base.FEEDBACK_CONT
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    private String feedbackCont;

    /**
     *   反馈人ID
     *
     * 数据库字段名:bpbasic_feedback_base.CUST_ID
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    private String custId;

    /**
     *   反馈人名称(游客则写死游客)
     *
     * 数据库字段名:bpbasic_feedback_base.CUST_NAME
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    private String custName;

    /**
     *   反馈人电话
     *
     * 数据库字段名:bpbasic_feedback_base.CUST_PHONE
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    private String custPhone;

    /**
     *   反馈图片（最多3张）
     *
     * 数据库字段名:bpbasic_feedback_base.FEEDBACK_IMG
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    private String feedbackImg;

    /**
     *   反馈时间
     *
     * 数据库字段名:bpbasic_feedback_base.ADD_TIME
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    private Date addTime;

    /**
     *   反馈回答
     *
     * 数据库字段名:bpbasic_feedback_base.ANSWER_CONT
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    private String answerCont;

    /**
     *   处理人
     *
     * 数据库字段名:bpbasic_feedback_base.DEAL_USER
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    private String dealUser;

    /**
     *   处理人名称
     *
     * 数据库字段名:bpbasic_feedback_base.DEAL_USER_NAME
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    private String dealUserName;

    /**
     *   处理时间
     *
     * 数据库字段名:bpbasic_feedback_base.DEAL_TIME
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    private Date dealTime;

    /**
     *   处理状态[1-待处理 2-已回复 3-已删除]
     *
     * 数据库字段名:bpbasic_feedback_base.DEAL_STATUS
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    private Byte dealStatus;

    /**
     * 数据库字段：主键bpbasic_feedback_base.FEEDBACK_ID
     *
     * @return  the value of bpbasic_feedback_base.FEEDBACK_ID
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public String getFeedbackId() {
        return feedbackId;
    }

    /**
     * 数据库字段：主键bpbasic_feedback_base.FEEDBACK_ID
     * @param feedbackId the value for bpbasic_feedback_base.FEEDBACK_ID
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId == null ? null : feedbackId.trim();
    }

    /**
     * 数据库字段：反馈类型bpbasic_feedback_base.FEEDBACK_TYPE
     *
     * @return  the value of bpbasic_feedback_base.FEEDBACK_TYPE
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public String getFeedbackType() {
        return feedbackType;
    }

    /**
     * 数据库字段：反馈类型bpbasic_feedback_base.FEEDBACK_TYPE
     * @param feedbackType the value for bpbasic_feedback_base.FEEDBACK_TYPE
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public void setFeedbackType(String feedbackType) {
        this.feedbackType = feedbackType == null ? null : feedbackType.trim();
    }

    /**
     * 数据库字段：反馈内容bpbasic_feedback_base.FEEDBACK_CONT
     *
     * @return  the value of bpbasic_feedback_base.FEEDBACK_CONT
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public String getFeedbackCont() {
        return feedbackCont;
    }

    /**
     * 数据库字段：反馈内容bpbasic_feedback_base.FEEDBACK_CONT
     * @param feedbackCont the value for bpbasic_feedback_base.FEEDBACK_CONT
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public void setFeedbackCont(String feedbackCont) {
        this.feedbackCont = feedbackCont == null ? null : feedbackCont.trim();
    }

    /**
     * 数据库字段：反馈人IDbpbasic_feedback_base.CUST_ID
     *
     * @return  the value of bpbasic_feedback_base.CUST_ID
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：反馈人IDbpbasic_feedback_base.CUST_ID
     * @param custId the value for bpbasic_feedback_base.CUST_ID
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：反馈人名称(游客则写死游客)bpbasic_feedback_base.CUST_NAME
     *
     * @return  the value of bpbasic_feedback_base.CUST_NAME
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public String getCustName() {
        return custName;
    }

    /**
     * 数据库字段：反馈人名称(游客则写死游客)bpbasic_feedback_base.CUST_NAME
     * @param custName the value for bpbasic_feedback_base.CUST_NAME
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    /**
     * 数据库字段：反馈人电话bpbasic_feedback_base.CUST_PHONE
     *
     * @return  the value of bpbasic_feedback_base.CUST_PHONE
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public String getCustPhone() {
        return custPhone;
    }

    /**
     * 数据库字段：反馈人电话bpbasic_feedback_base.CUST_PHONE
     * @param custPhone the value for bpbasic_feedback_base.CUST_PHONE
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone == null ? null : custPhone.trim();
    }

    /**
     * 数据库字段：反馈图片（最多3张）bpbasic_feedback_base.FEEDBACK_IMG
     *
     * @return  the value of bpbasic_feedback_base.FEEDBACK_IMG
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public String getFeedbackImg() {
        return feedbackImg;
    }

    /**
     * 数据库字段：反馈图片（最多3张）bpbasic_feedback_base.FEEDBACK_IMG
     * @param feedbackImg the value for bpbasic_feedback_base.FEEDBACK_IMG
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public void setFeedbackImg(String feedbackImg) {
        this.feedbackImg = feedbackImg == null ? null : feedbackImg.trim();
    }

    /**
     * 数据库字段：反馈时间bpbasic_feedback_base.ADD_TIME
     *
     * @return  the value of bpbasic_feedback_base.ADD_TIME
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：反馈时间bpbasic_feedback_base.ADD_TIME
     * @param addTime the value for bpbasic_feedback_base.ADD_TIME
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：反馈回答bpbasic_feedback_base.ANSWER_CONT
     *
     * @return  the value of bpbasic_feedback_base.ANSWER_CONT
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public String getAnswerCont() {
        return answerCont;
    }

    /**
     * 数据库字段：反馈回答bpbasic_feedback_base.ANSWER_CONT
     * @param answerCont the value for bpbasic_feedback_base.ANSWER_CONT
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public void setAnswerCont(String answerCont) {
        this.answerCont = answerCont == null ? null : answerCont.trim();
    }

    /**
     * 数据库字段：处理人bpbasic_feedback_base.DEAL_USER
     *
     * @return  the value of bpbasic_feedback_base.DEAL_USER
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public String getDealUser() {
        return dealUser;
    }

    /**
     * 数据库字段：处理人bpbasic_feedback_base.DEAL_USER
     * @param dealUser the value for bpbasic_feedback_base.DEAL_USER
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public void setDealUser(String dealUser) {
        this.dealUser = dealUser == null ? null : dealUser.trim();
    }

    /**
     * 数据库字段：处理人名称bpbasic_feedback_base.DEAL_USER_NAME
     *
     * @return  the value of bpbasic_feedback_base.DEAL_USER_NAME
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public String getDealUserName() {
        return dealUserName;
    }

    /**
     * 数据库字段：处理人名称bpbasic_feedback_base.DEAL_USER_NAME
     * @param dealUserName the value for bpbasic_feedback_base.DEAL_USER_NAME
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public void setDealUserName(String dealUserName) {
        this.dealUserName = dealUserName == null ? null : dealUserName.trim();
    }

    /**
     * 数据库字段：处理时间bpbasic_feedback_base.DEAL_TIME
     *
     * @return  the value of bpbasic_feedback_base.DEAL_TIME
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public Date getDealTime() {
        return dealTime;
    }

    /**
     * 数据库字段：处理时间bpbasic_feedback_base.DEAL_TIME
     * @param dealTime the value for bpbasic_feedback_base.DEAL_TIME
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    /**
     * 数据库字段：处理状态[1-待处理 2-已回复 3-已删除]bpbasic_feedback_base.DEAL_STATUS
     *
     * @return  the value of bpbasic_feedback_base.DEAL_STATUS
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public Byte getDealStatus() {
        return dealStatus;
    }

    /**
     * 数据库字段：处理状态[1-待处理 2-已回复 3-已删除]bpbasic_feedback_base.DEAL_STATUS
     * @param dealStatus the value for bpbasic_feedback_base.DEAL_STATUS
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    public void setDealStatus(Byte dealStatus) {
        this.dealStatus = dealStatus;
    }
}