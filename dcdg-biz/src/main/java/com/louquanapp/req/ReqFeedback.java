package com.louquanapp.req;

import javax.validation.constraints.NotBlank;

/**
 * 胡化敏代码生成器.
 * 数据库表名 bpbasic_feedback_base
 *
 * @mbg.generated do_not_delete_during_merge Mon Aug 06 14:24:36 CST 2018
 */
public class ReqFeedback extends ReqToken {


    /**
     * 反馈内容
     * <p>
     * 数据库字段名:bpbasic_feedback_base.FEEDBACK_CONT
     *
     * @mbg.generated Mon Aug 06 14:24:36 CST 2018
     */
    @NotBlank(message = "反馈内容不能为空")
    private String feedbackCont;

    /**
     * 反馈人电话
     * <p>
     * 数据库字段名:bpbasic_feedback_base.CUST_PHONE
     *
     * @mbg.generated Mon Aug 06 14:24:36 CST 2018
     */
    @NotBlank(message = "反馈人电话不能为空")
    private String custPhone;

    /**
     * 反馈图片（最多3张）
     * <p>
     * 数据库字段名:bpbasic_feedback_base.FEEDBACK_IMG
     *
     * @mbg.generated Mon Aug 06 14:24:36 CST 2018
     */
    private String feedbackImg;


    public String getFeedbackCont() {
        return feedbackCont;
    }

    public void setFeedbackCont(String feedbackCont) {
        this.feedbackCont = feedbackCont;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getFeedbackImg() {
        return feedbackImg;
    }

    public void setFeedbackImg(String feedbackImg) {
        this.feedbackImg = feedbackImg;
    }
}