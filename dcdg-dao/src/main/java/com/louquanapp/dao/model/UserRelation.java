package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.UserRelationExtra;
import org.apache.tools.ant.taskdefs.optional.extension.ExtraAttribute;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 andji_system_user_relation
 *
 * @mbg.generated do_not_delete_during_merge Tue Sep 24 17:31:23 CST 2019
 */
public class UserRelation extends UserRelationExtra {
    /**
     *   主键
     *
     * 数据库字段名:andji_system_user_relation.RELATION_ID
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    private String relationId;

    /**
     *   主账号ID
     *
     * 数据库字段名:andji_system_user_relation.PRI_USER_ID
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    private String priUserId;

    /**
     *   子账号ID
     *
     * 数据库字段名:andji_system_user_relation.SEC_USER_ID
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    private String secUserId;

    /**
     *   用户关联状态[1-已关联 2-未关联 ]
     *
     * 数据库字段名:andji_system_user_relation.USER_RELATION_STATUS
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    private Byte userRelationStatus;

    /**
     *   账户关联状态[1-关联自己账户 2-关联他人账户]
     *
     * 数据库字段名:andji_system_user_relation.ACCOUNT_RELATION_STATUS
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    private Byte accountRelationStatus;

    /**
     *   添加时间
     *
     * 数据库字段名:andji_system_user_relation.ADD_TIME
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    private Date addTime;

    /**
     *   更新时间
     *
     * 数据库字段名:andji_system_user_relation.UPDATE_TIME
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    private Date updateTime;

    /**
     * 数据库字段：主键andji_system_user_relation.RELATION_ID
     *
     * @return  the value of andji_system_user_relation.RELATION_ID
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    public String getRelationId() {
        return relationId;
    }

    /**
     * 数据库字段：主键andji_system_user_relation.RELATION_ID
     * @param relationId the value for andji_system_user_relation.RELATION_ID
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    public void setRelationId(String relationId) {
        this.relationId = relationId == null ? null : relationId.trim();
    }

    /**
     * 数据库字段：主账号IDandji_system_user_relation.PRI_USER_ID
     *
     * @return  the value of andji_system_user_relation.PRI_USER_ID
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    public String getPriUserId() {
        return priUserId;
    }

    /**
     * 数据库字段：主账号IDandji_system_user_relation.PRI_USER_ID
     * @param priUserId the value for andji_system_user_relation.PRI_USER_ID
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    public void setPriUserId(String priUserId) {
        this.priUserId = priUserId == null ? null : priUserId.trim();
    }

    /**
     * 数据库字段：子账号IDandji_system_user_relation.SEC_USER_ID
     *
     * @return  the value of andji_system_user_relation.SEC_USER_ID
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    public String getSecUserId() {
        return secUserId;
    }

    /**
     * 数据库字段：子账号IDandji_system_user_relation.SEC_USER_ID
     * @param secUserId the value for andji_system_user_relation.SEC_USER_ID
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    public void setSecUserId(String secUserId) {
        this.secUserId = secUserId == null ? null : secUserId.trim();
    }

    /**
     * 数据库字段：用户关联状态[1-已关联 2-未关联 ]andji_system_user_relation.USER_RELATION_STATUS
     *
     * @return  the value of andji_system_user_relation.USER_RELATION_STATUS
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    public Byte getUserRelationStatus() {
        return userRelationStatus;
    }

    /**
     * 数据库字段：用户关联状态[1-已关联 2-未关联 ]andji_system_user_relation.USER_RELATION_STATUS
     * @param userRelationStatus the value for andji_system_user_relation.USER_RELATION_STATUS
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    public void setUserRelationStatus(Byte userRelationStatus) {
        this.userRelationStatus = userRelationStatus;
    }

    /**
     * 数据库字段：账户关联状态[1-关联自己账户 2-关联他人账户]andji_system_user_relation.ACCOUNT_RELATION_STATUS
     *
     * @return  the value of andji_system_user_relation.ACCOUNT_RELATION_STATUS
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    public Byte getAccountRelationStatus() {
        return accountRelationStatus;
    }

    /**
     * 数据库字段：账户关联状态[1-关联自己账户 2-关联他人账户]andji_system_user_relation.ACCOUNT_RELATION_STATUS
     * @param accountRelationStatus the value for andji_system_user_relation.ACCOUNT_RELATION_STATUS
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    public void setAccountRelationStatus(Byte accountRelationStatus) {
        this.accountRelationStatus = accountRelationStatus;
    }

    /**
     * 数据库字段：添加时间andji_system_user_relation.ADD_TIME
     *
     * @return  the value of andji_system_user_relation.ADD_TIME
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间andji_system_user_relation.ADD_TIME
     * @param addTime the value for andji_system_user_relation.ADD_TIME
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：更新时间andji_system_user_relation.UPDATE_TIME
     *
     * @return  the value of andji_system_user_relation.UPDATE_TIME
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：更新时间andji_system_user_relation.UPDATE_TIME
     * @param updateTime the value for andji_system_user_relation.UPDATE_TIME
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}