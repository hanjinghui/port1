package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/28 15:55
 * @description:
 */
public class ReqAddBlacklist extends ReqToken {
    /**
     * 好友关系id集合
     */
    @NotBlank(message = "好友关系id集合不能为空")
    private  String chatIds;
    /**
     * 好友状态[1-正常 2-拉黑]
     */
    @Range(min = 1,max = 2,message = "好友状态范围[1-正常 2-拉黑]")
    @NotNull(message = "好友状态不能为空！")
    private Byte chatStatus;

    public Byte getChatStatus() {
        return chatStatus;
    }

    public void setChatStatus(Byte chatStatus) {
        this.chatStatus = chatStatus;
    }

    public String getChatIds() {
        return chatIds;
    }

    public void setChatIds(String chatIds) {
        this.chatIds = chatIds;
    }
}
