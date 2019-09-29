package com.louquanapp.req;

import javax.validation.constraints.NotBlank;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/23 17:09
 * @description:
 */
public class ReqChatGroupDatail extends ReqToken{
    /**
     *   群Id
     */
    @NotBlank(message = "群Id不能为空！")
    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
