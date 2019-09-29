package com.louquanapp.req;

import javax.validation.constraints.NotBlank;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/10 15:40
 * @description:
 */
public class ReqAddOrderEvaluate extends ReqToken {
    /**
     * 回复id
     */
    @NotBlank(message = "回复id不能为空！")
    private String  evaluateId;
    /**
     * 回复内容
     */
    @NotBlank(message = "回复内容不能为空！")
    private String replyCon;

    public String getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(String evaluateId) {
        this.evaluateId = evaluateId;
    }

    public String getReplyCon() {
        return replyCon;
    }

    public void setReplyCon(String replyCon) {
        this.replyCon = replyCon;
    }
}
