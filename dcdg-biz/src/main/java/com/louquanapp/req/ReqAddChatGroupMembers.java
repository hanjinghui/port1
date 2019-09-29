package com.louquanapp.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/24 16:03
 * @description:  增加聊天群成员
 */
public class ReqAddChatGroupMembers extends ReqToken{
    /**
     * 好友id集合
     */
    @NotBlank(message = "好友Id集合不能为空")
    private String friendIds;
    /**
     * 群id
     */
    @NotBlank(message = "群ID 不能为空！")
    private String groupId;

    public String getFriendIds() {
        return friendIds;
    }

    public void setFriendIds(String friendIds) {
        this.friendIds = friendIds;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
