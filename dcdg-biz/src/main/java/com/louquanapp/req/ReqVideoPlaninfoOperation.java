package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/5/10 9:21
 * @description:
 */
public class ReqVideoPlaninfoOperation extends ReqToken{
    /**
     * 操作方式[1-商家确认 2-商家取消 3-结束]
     */
    @NotNull(message = "操作方式不能为空！")
    @Range(min = 1,max = 3,message = "操作方式[1-商家确认 2-商家取消 3-结束]")
    private  Byte planStatus;
    /**
     * 预定id
     */
    @NotBlank(message = "预定id不能为空！")
    private  String planId;
    /**
     * 商家回复
     */
    private String reply;

    public Byte getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(Byte planStatus) {
        this.planStatus = planStatus;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
