package com.louquanapp.req;

import javax.validation.constraints.NotBlank;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/26 17:02
 * @description:
 */
public class ReqChatFriend extends ReqToken {
    /**
     * 好友Id
     */
    @NotBlank(message = "好友id不能为空！")
    private String friendId;

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }
}
