package com.louquanapp.req;

import javax.validation.constraints.NotBlank;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/25 11:13
 * @description:
 */
public class ReqQuitChatGroup extends ReqToken{
    /**
     * 群id
     */
    @NotBlank(message = "群id不能为空")
    private String groupId;

    /**
     * 成员Id
     */
    private String memberId;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
