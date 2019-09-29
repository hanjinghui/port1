package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.ChatGroupExtra;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 base_chat_group_relation
 *
 * @mbg.generated do_not_delete_during_merge Tue Apr 23 17:06:55 CST 2019
 */
public class ChatGroupRelation extends ChatGroupExtra {
    /**
     *   主键
     *
     * 数据库字段名:base_chat_group_relation.RELATION_ID
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    private String relationId;

    /**
     *   群id
     *
     * 数据库字段名:base_chat_group_relation.GROUP_ID
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    private String groupId;

    /**
     *   用户id
     *
     * 数据库字段名:base_chat_group_relation.CUST_ID
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    private String custId;

    /**
     *   用户在群里的昵称
     *
     * 数据库字段名:base_chat_group_relation.CUST_GROUP_NICK_NAME
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    private String custGroupNickName;

    /**
     *    状态[1-显示群成员昵称 2-不显示群成员昵称  ]
     *
     * 数据库字段名:base_chat_group_relation.RELATION_STATUS
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    private Byte relationStatus;

    /**
     *   添加时间
     *
     * 数据库字段名:base_chat_group_relation.ADD_TIME
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    private Date addTime;

    /**
     *   更新时间
     *
     * 数据库字段名:base_chat_group_relation.UPDATE_TIME
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    private Date updateTime;

    /**
     * 数据库字段：主键base_chat_group_relation.RELATION_ID
     *
     * @return  the value of base_chat_group_relation.RELATION_ID
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    public String getRelationId() {
        return relationId;
    }

    /**
     * 数据库字段：主键base_chat_group_relation.RELATION_ID
     * @param relationId the value for base_chat_group_relation.RELATION_ID
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    public void setRelationId(String relationId) {
        this.relationId = relationId == null ? null : relationId.trim();
    }

    /**
     * 数据库字段：群idbase_chat_group_relation.GROUP_ID
     *
     * @return  the value of base_chat_group_relation.GROUP_ID
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * 数据库字段：群idbase_chat_group_relation.GROUP_ID
     * @param groupId the value for base_chat_group_relation.GROUP_ID
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    /**
     * 数据库字段：用户idbase_chat_group_relation.CUST_ID
     *
     * @return  the value of base_chat_group_relation.CUST_ID
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：用户idbase_chat_group_relation.CUST_ID
     * @param custId the value for base_chat_group_relation.CUST_ID
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：用户在群里的昵称base_chat_group_relation.CUST_GROUP_NICK_NAME
     *
     * @return  the value of base_chat_group_relation.CUST_GROUP_NICK_NAME
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    public String getCustGroupNickName() {
        return custGroupNickName;
    }

    /**
     * 数据库字段：用户在群里的昵称base_chat_group_relation.CUST_GROUP_NICK_NAME
     * @param custGroupNickName the value for base_chat_group_relation.CUST_GROUP_NICK_NAME
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    public void setCustGroupNickName(String custGroupNickName) {
        this.custGroupNickName = custGroupNickName == null ? null : custGroupNickName.trim();
    }

    /**
     * 数据库字段： 状态[1-显示群成员昵称 2-不显示群成员昵称  ]base_chat_group_relation.RELATION_STATUS
     *
     * @return  the value of base_chat_group_relation.RELATION_STATUS
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    public Byte getRelationStatus() {
        return relationStatus;
    }

    /**
     * 数据库字段： 状态[1-显示群成员昵称 2-不显示群成员昵称  ]base_chat_group_relation.RELATION_STATUS
     * @param relationStatus the value for base_chat_group_relation.RELATION_STATUS
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    public void setRelationStatus(Byte relationStatus) {
        this.relationStatus = relationStatus;
    }

    /**
     * 数据库字段：添加时间base_chat_group_relation.ADD_TIME
     *
     * @return  the value of base_chat_group_relation.ADD_TIME
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间base_chat_group_relation.ADD_TIME
     * @param addTime the value for base_chat_group_relation.ADD_TIME
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：更新时间base_chat_group_relation.UPDATE_TIME
     *
     * @return  the value of base_chat_group_relation.UPDATE_TIME
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：更新时间base_chat_group_relation.UPDATE_TIME
     * @param updateTime the value for base_chat_group_relation.UPDATE_TIME
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}