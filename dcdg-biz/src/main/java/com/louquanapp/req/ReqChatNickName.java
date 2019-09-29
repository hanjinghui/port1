package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/23 19:51
 * @description:
 */
public class ReqChatNickName extends ReqToken{
    /**
     * 群关系主键
     */
    @NotBlank(message = "群关系主键不能为空！")
    private String relationId;

    /**
     * 操作方式[1-显示群成员昵称 2-不显示群成员昵称]
     */
    @NotNull(message = "操作方式不能为空！")
    @Range(min = 1,max = 3,message = "操作方式范围[1-显示群成员昵称 2-不显示群成员昵称 3-用户在群里的昵称]")
    private Byte relationStatus;

    /**
     *  用户在群里的昵称
     */
    private String custNickName;

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public Byte getRelationStatus() {
        return relationStatus;
    }

    public void setRelationStatus(Byte relationStatus) {
        this.relationStatus = relationStatus;
    }

    public String getCustNickName() {
        return custNickName;
    }

    public void setCustNickName(String custNickName) {
        this.custNickName = custNickName;
    }
}
