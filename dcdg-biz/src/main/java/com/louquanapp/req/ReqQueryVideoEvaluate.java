package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/10 15:40
 * @description:
 */
public class ReqQueryVideoEvaluate extends ReqTokenPage {
    /**
     * 操作方式[1-查询一二级评论 2-查询二级评论]
     */
    @NotNull(message = "操作方式不能为空！")
    @Range(min = 1, max = 2, message = "操作方式[1-查询一二级评论 2-查询二级评论]")
    private Byte type;

    /**
     * 评论Id
     */
    private String evaluateId;
    /**
     * 视频Id
     */
    private String videoId;

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(String evaluateId) {
        this.evaluateId = evaluateId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
