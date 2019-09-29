package com.louquanapp.dao.model;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_video_report_base
 *
 * @mbg.generated do_not_delete_during_merge Mon May 06 19:25:09 CST 2019
 */
public class Report {
    /**
     *   标识
     *
     * 数据库字段名:dcdg_video_report_base.REPORT_ID
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    private String reportId;

    /**
     *   类别
     *
     * 数据库字段名:dcdg_video_report_base.CAT_NAME
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    private String catName;

    /**
     *   举报内容
     *
     * 数据库字段名:dcdg_video_report_base.REPORT_CONTENT
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    private String reportContent;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_video_report_base.ADD_TIME
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    private Date addTime;

    /**
     *   举报人
     *
     * 数据库字段名:dcdg_video_report_base.CUST_ID
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    private String custId;

    /**
     *   被举报人
     *
     * 数据库字段名:dcdg_video_report_base.CUSTED_ID
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    private String custedId;

    /**
     *   举报人联系方式
     *
     * 数据库字段名:dcdg_video_report_base.CUST_PHONE
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    private String custPhone;

    /**
     *   举报视频编号
     *
     * 数据库字段名:dcdg_video_report_base.VIDEO_NO
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    private Integer videoNo;

    /**
     *   处理状态[1-待处理 2-已处理]
     *
     * 数据库字段名:dcdg_video_report_base.REPORT_FLAG
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    private Byte reportFlag;

    /**
     *   处理时间
     *
     * 数据库字段名:dcdg_video_report_base.UPDATE_TIME
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    private Date updateTime;

    /**
     * 数据库字段：标识dcdg_video_report_base.REPORT_ID
     *
     * @return  the value of dcdg_video_report_base.REPORT_ID
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public String getReportId() {
        return reportId;
    }

    /**
     * 数据库字段：标识dcdg_video_report_base.REPORT_ID
     * @param reportId the value for dcdg_video_report_base.REPORT_ID
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    /**
     * 数据库字段：类别dcdg_video_report_base.CAT_NAME
     *
     * @return  the value of dcdg_video_report_base.CAT_NAME
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public String getCatName() {
        return catName;
    }

    /**
     * 数据库字段：类别dcdg_video_report_base.CAT_NAME
     * @param catName the value for dcdg_video_report_base.CAT_NAME
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public void setCatName(String catName) {
        this.catName = catName == null ? null : catName.trim();
    }

    /**
     * 数据库字段：举报内容dcdg_video_report_base.REPORT_CONTENT
     *
     * @return  the value of dcdg_video_report_base.REPORT_CONTENT
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public String getReportContent() {
        return reportContent;
    }

    /**
     * 数据库字段：举报内容dcdg_video_report_base.REPORT_CONTENT
     * @param reportContent the value for dcdg_video_report_base.REPORT_CONTENT
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public void setReportContent(String reportContent) {
        this.reportContent = reportContent == null ? null : reportContent.trim();
    }

    /**
     * 数据库字段：添加时间dcdg_video_report_base.ADD_TIME
     *
     * @return  the value of dcdg_video_report_base.ADD_TIME
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_video_report_base.ADD_TIME
     * @param addTime the value for dcdg_video_report_base.ADD_TIME
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：举报人dcdg_video_report_base.CUST_ID
     *
     * @return  the value of dcdg_video_report_base.CUST_ID
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：举报人dcdg_video_report_base.CUST_ID
     * @param custId the value for dcdg_video_report_base.CUST_ID
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：被举报人dcdg_video_report_base.CUSTED_ID
     *
     * @return  the value of dcdg_video_report_base.CUSTED_ID
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public String getCustedId() {
        return custedId;
    }

    /**
     * 数据库字段：被举报人dcdg_video_report_base.CUSTED_ID
     * @param custedId the value for dcdg_video_report_base.CUSTED_ID
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public void setCustedId(String custedId) {
        this.custedId = custedId == null ? null : custedId.trim();
    }

    /**
     * 数据库字段：举报人联系方式dcdg_video_report_base.CUST_PHONE
     *
     * @return  the value of dcdg_video_report_base.CUST_PHONE
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public String getCustPhone() {
        return custPhone;
    }

    /**
     * 数据库字段：举报人联系方式dcdg_video_report_base.CUST_PHONE
     * @param custPhone the value for dcdg_video_report_base.CUST_PHONE
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone == null ? null : custPhone.trim();
    }

    /**
     * 数据库字段：举报视频编号dcdg_video_report_base.VIDEO_NO
     *
     * @return  the value of dcdg_video_report_base.VIDEO_NO
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public Integer getVideoNo() {
        return videoNo;
    }

    /**
     * 数据库字段：举报视频编号dcdg_video_report_base.VIDEO_NO
     * @param videoNo the value for dcdg_video_report_base.VIDEO_NO
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public void setVideoNo(Integer videoNo) {
        this.videoNo = videoNo;
    }

    /**
     * 数据库字段：处理状态[1-待处理 2-已处理]dcdg_video_report_base.REPORT_FLAG
     *
     * @return  the value of dcdg_video_report_base.REPORT_FLAG
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public Byte getReportFlag() {
        return reportFlag;
    }

    /**
     * 数据库字段：处理状态[1-待处理 2-已处理]dcdg_video_report_base.REPORT_FLAG
     * @param reportFlag the value for dcdg_video_report_base.REPORT_FLAG
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public void setReportFlag(Byte reportFlag) {
        this.reportFlag = reportFlag;
    }

    /**
     * 数据库字段：处理时间dcdg_video_report_base.UPDATE_TIME
     *
     * @return  the value of dcdg_video_report_base.UPDATE_TIME
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：处理时间dcdg_video_report_base.UPDATE_TIME
     * @param updateTime the value for dcdg_video_report_base.UPDATE_TIME
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}