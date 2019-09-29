package com.louquanapp.req;

import javax.validation.constraints.NotEmpty;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/8 17:06
 * @Description: 条件优惠券
 */
public class ReqDoReport extends ReqToken {


    /**
     * 类别
     * <p>
     * 数据库字段名:dcdg_video_report_base.CAT_NAME
     *
     * @mbg.generated Mon May 06 19:02:58 CST 2019
     */
    @NotEmpty(message = "分类名称不能为空")
    private String catName;

    /**
     * 举报内容
     * <p>
     * 数据库字段名:dcdg_video_report_base.REPORT_CONTENT
     *
     * @mbg.generated Mon May 06 19:02:58 CST 2019
     */
    private String reportContent;


    /**
     * 举报视频编号
     * <p>
     * 数据库字段名:dcdg_video_report_base.VIDEO_NO
     *
     * @mbg.generated Mon May 06 19:02:58 CST 2019
     */
    @NotEmpty(message = "视频编号不能为空")
    private String videoId;


    /**
     * 数据库字段：类别dcdg_video_report_base.CAT_NAME
     *
     * @return the value of dcdg_video_report_base.CAT_NAME
     * @mbg.generated Mon May 06 19:02:58 CST 2019
     */
    public String getCatName() {
        return catName;
    }

    /**
     * 数据库字段：类别dcdg_video_report_base.CAT_NAME
     *
     * @param catName the value for dcdg_video_report_base.CAT_NAME
     * @mbg.generated Mon May 06 19:02:58 CST 2019
     */
    public void setCatName(String catName) {
        this.catName = catName == null ? null : catName.trim();
    }

    /**
     * 数据库字段：举报内容dcdg_video_report_base.REPORT_CONTENT
     *
     * @return the value of dcdg_video_report_base.REPORT_CONTENT
     * @mbg.generated Mon May 06 19:02:58 CST 2019
     */
    public String getReportContent() {
        return reportContent;
    }

    /**
     * 数据库字段：举报内容dcdg_video_report_base.REPORT_CONTENT
     *
     * @param reportContent the value for dcdg_video_report_base.REPORT_CONTENT
     * @mbg.generated Mon May 06 19:02:58 CST 2019
     */
    public void setReportContent(String reportContent) {
        this.reportContent = reportContent == null ? null : reportContent.trim();
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
