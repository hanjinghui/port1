package com.louquanapp.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/10 19:39
 * @description: 直播间
 */
public class ReqVideoPlaninfo extends ReqToken {

    /**
     * 预定人数
     */
    @NotNull(message = "预定人数不能为空！")
    private Byte planNum;
    /**
     * 时间段
     */
    @NotBlank(message = "时间段不能为空！")
    private String planDate;
    /**
     * 添加名称(联系人)
     */
    @NotBlank(message = "联系人不能为空！")
    private String custName;
    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空！")
    @Pattern(regexp = "1[0-9]{10}", message = "手机号格式不正确")
    private String custPhone;

    /**
     * 直播间id
     */
    @NotBlank(message = "直播间id不能为空！")
    private String videoId;
    /**
     * 备注
     */
    @Size(min = 0, max = 30,message = "备注字数范围[0-30]")
    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Byte getPlanNum() {
        return planNum;
    }

    public void setPlanNum(Byte planNum) {
        this.planNum = planNum;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }


    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
