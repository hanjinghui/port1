package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.ChatExtra;
import com.louquanapp.dao.extra.ChatGroupExtra;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 base_chat_group_base
 *
 * @mbg.generated do_not_delete_during_merge Wed Apr 24 15:37:35 CST 2019
 */
public class ChatGroup extends ChatGroupExtra {
    /**
     *   主键
     *
     * 数据库字段名:base_chat_group_base.GROUP_ID
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    private String groupId;

    /**
     *   群名称状态[1-未命名 2-已命名]
     *
     * 数据库字段名:base_chat_group_base.GROUP_NAME_STATUS
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    private Byte groupNameStatus;

    /**
     *   群名称
     *
     * 数据库字段名:base_chat_group_base.GROUP_NAME
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    private String groupName;

    /**
     *   群头像
     *
     * 数据库字段名:base_chat_group_base.GROUP_HEAD_IMG
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    private String groupHeadImg;

    /**
     *   群备注
     *
     * 数据库字段名:base_chat_group_base.REMARK
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    private String remark;

    /**
     *   群主id
     *
     * 数据库字段名:base_chat_group_base.GROUP_MASTER_ID
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    private String groupMasterId;

    /**
     *   状态[1-存在 2-解散]
     *
     * 数据库字段名:base_chat_group_base.GROUP_STATUS
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    private Byte groupStatus;

    /**
     *   添加时间
     *
     * 数据库字段名:base_chat_group_base.ADD_TIME
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    private Date addTime;

    /**
     *   更新时间
     *
     * 数据库字段名:base_chat_group_base.UPDATE_TIME
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    private Date updateTime;

    /**
     * 数据库字段：主键base_chat_group_base.GROUP_ID
     *
     * @return  the value of base_chat_group_base.GROUP_ID
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * 数据库字段：主键base_chat_group_base.GROUP_ID
     * @param groupId the value for base_chat_group_base.GROUP_ID
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    /**
     * 数据库字段：群名称状态[1-未命名 2-已命名]base_chat_group_base.GROUP_NAME_STATUS
     *
     * @return  the value of base_chat_group_base.GROUP_NAME_STATUS
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    public Byte getGroupNameStatus() {
        return groupNameStatus;
    }

    /**
     * 数据库字段：群名称状态[1-未命名 2-已命名]base_chat_group_base.GROUP_NAME_STATUS
     * @param groupNameStatus the value for base_chat_group_base.GROUP_NAME_STATUS
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    public void setGroupNameStatus(Byte groupNameStatus) {
        this.groupNameStatus = groupNameStatus;
    }

    /**
     * 数据库字段：群名称base_chat_group_base.GROUP_NAME
     *
     * @return  the value of base_chat_group_base.GROUP_NAME
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 数据库字段：群名称base_chat_group_base.GROUP_NAME
     * @param groupName the value for base_chat_group_base.GROUP_NAME
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * 数据库字段：群头像base_chat_group_base.GROUP_HEAD_IMG
     *
     * @return  the value of base_chat_group_base.GROUP_HEAD_IMG
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    public String getGroupHeadImg() {
        return groupHeadImg;
    }

    /**
     * 数据库字段：群头像base_chat_group_base.GROUP_HEAD_IMG
     * @param groupHeadImg the value for base_chat_group_base.GROUP_HEAD_IMG
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    public void setGroupHeadImg(String groupHeadImg) {
        this.groupHeadImg = groupHeadImg == null ? null : groupHeadImg.trim();
    }

    /**
     * 数据库字段：群备注base_chat_group_base.REMARK
     *
     * @return  the value of base_chat_group_base.REMARK
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 数据库字段：群备注base_chat_group_base.REMARK
     * @param remark the value for base_chat_group_base.REMARK
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 数据库字段：群主idbase_chat_group_base.GROUP_MASTER_ID
     *
     * @return  the value of base_chat_group_base.GROUP_MASTER_ID
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    public String getGroupMasterId() {
        return groupMasterId;
    }

    /**
     * 数据库字段：群主idbase_chat_group_base.GROUP_MASTER_ID
     * @param groupMasterId the value for base_chat_group_base.GROUP_MASTER_ID
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    public void setGroupMasterId(String groupMasterId) {
        this.groupMasterId = groupMasterId == null ? null : groupMasterId.trim();
    }

    /**
     * 数据库字段：状态[1-存在 2-解散]base_chat_group_base.GROUP_STATUS
     *
     * @return  the value of base_chat_group_base.GROUP_STATUS
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    public Byte getGroupStatus() {
        return groupStatus;
    }

    /**
     * 数据库字段：状态[1-存在 2-解散]base_chat_group_base.GROUP_STATUS
     * @param groupStatus the value for base_chat_group_base.GROUP_STATUS
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    public void setGroupStatus(Byte groupStatus) {
        this.groupStatus = groupStatus;
    }

    /**
     * 数据库字段：添加时间base_chat_group_base.ADD_TIME
     *
     * @return  the value of base_chat_group_base.ADD_TIME
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间base_chat_group_base.ADD_TIME
     * @param addTime the value for base_chat_group_base.ADD_TIME
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：更新时间base_chat_group_base.UPDATE_TIME
     *
     * @return  the value of base_chat_group_base.UPDATE_TIME
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：更新时间base_chat_group_base.UPDATE_TIME
     * @param updateTime the value for base_chat_group_base.UPDATE_TIME
     *
     * @mbg.generated Wed Apr 24 15:37:35 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}