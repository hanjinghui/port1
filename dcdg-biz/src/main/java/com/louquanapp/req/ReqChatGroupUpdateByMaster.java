package com.louquanapp.req;

import javax.validation.constraints.NotBlank;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/25 16:15
 * @description:
 */
public class ReqChatGroupUpdateByMaster extends ReqToken{
    /**
     * 群id
     */
    @NotBlank(message = "群id不能为空")
    private String groupId;

    /**
     * 群名称
     */
    private String groupName;
    /**
     * 群头像
     */
    private String groupHeadImg;
    /**
     * 群备注
     */
    private String remark;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupHeadImg() {
        return groupHeadImg;
    }

    public void setGroupHeadImg(String groupHeadImg) {
        this.groupHeadImg = groupHeadImg;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
