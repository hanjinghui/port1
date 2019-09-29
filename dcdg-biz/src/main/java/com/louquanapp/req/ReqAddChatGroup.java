package com.louquanapp.req;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/23 17:09
 * @description:
 */
public class ReqAddChatGroup extends ReqToken{
    /**
     *   群名称
     */
    @Pattern(regexp = ".{1,60}", message = "群名称,范围[1到60字符]")
    private String groupName;

    /**
     * 群成员id集合（不包括群主即发起者）
     */
    @NotBlank(message = "群成员id集合不能为空！")
    private String custIds;

    public String getCustIds() {
        return custIds;
    }

    public void setCustIds(String custIds) {
        this.custIds = custIds;
    }


    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
