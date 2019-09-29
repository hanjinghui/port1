package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.ChatExtra;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_basic_chat_base
 *
 * @mbg.generated do_not_delete_during_merge Tue Apr 23 16:31:42 CST 2019
 */
public class Chat extends ChatExtra {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_basic_chat_base.CHAT_ID
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    private String chatId;

    /**
     *   我的Id
     *
     * 数据库字段名:dcdg_basic_chat_base.CUST_ID
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    private String custId;

    /**
     *   好友Id
     *
     * 数据库字段名:dcdg_basic_chat_base.FRIEND_ID
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    private String friendId;

    /**
     *   状态[1-正常 2-拉黑 3-申请中]
     *
     * 数据库字段名:dcdg_basic_chat_base.CHAT_STATUS
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    private Byte chatStatus;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_basic_chat_base.ADD_TIME
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    private Date addTime;

    /**
     *   更新时间
     *
     * 数据库字段名:dcdg_basic_chat_base.UPDATE_TIME
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    private Date updateTime;

    /**
     *   好有备注
     *
     * 数据库字段名:dcdg_basic_chat_base.FRIENT_REMARK
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    private String frientRemark;

    /**
     *   电话号码
     *
     * 数据库字段名:dcdg_basic_chat_base.CHAT_PHONE
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    private String chatPhone;

    /**
     *   描述
     *
     * 数据库字段名:dcdg_basic_chat_base.CHAT_DESCRIBE
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    private String chatDescribe;

    /**
     * 数据库字段：主键dcdg_basic_chat_base.CHAT_ID
     *
     * @return  the value of dcdg_basic_chat_base.CHAT_ID
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    public String getChatId() {
        return chatId;
    }

    /**
     * 数据库字段：主键dcdg_basic_chat_base.CHAT_ID
     * @param chatId the value for dcdg_basic_chat_base.CHAT_ID
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    public void setChatId(String chatId) {
        this.chatId = chatId == null ? null : chatId.trim();
    }

    /**
     * 数据库字段：我的Iddcdg_basic_chat_base.CUST_ID
     *
     * @return  the value of dcdg_basic_chat_base.CUST_ID
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：我的Iddcdg_basic_chat_base.CUST_ID
     * @param custId the value for dcdg_basic_chat_base.CUST_ID
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：好友Iddcdg_basic_chat_base.FRIEND_ID
     *
     * @return  the value of dcdg_basic_chat_base.FRIEND_ID
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    public String getFriendId() {
        return friendId;
    }

    /**
     * 数据库字段：好友Iddcdg_basic_chat_base.FRIEND_ID
     * @param friendId the value for dcdg_basic_chat_base.FRIEND_ID
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    public void setFriendId(String friendId) {
        this.friendId = friendId == null ? null : friendId.trim();
    }

    /**
     * 数据库字段：状态[1-正常 2-拉黑 3-申请中]dcdg_basic_chat_base.CHAT_STATUS
     *
     * @return  the value of dcdg_basic_chat_base.CHAT_STATUS
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    public Byte getChatStatus() {
        return chatStatus;
    }

    /**
     * 数据库字段：状态[1-正常 2-拉黑 3-申请中]dcdg_basic_chat_base.CHAT_STATUS
     * @param chatStatus the value for dcdg_basic_chat_base.CHAT_STATUS
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    public void setChatStatus(Byte chatStatus) {
        this.chatStatus = chatStatus;
    }

    /**
     * 数据库字段：添加时间dcdg_basic_chat_base.ADD_TIME
     *
     * @return  the value of dcdg_basic_chat_base.ADD_TIME
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_basic_chat_base.ADD_TIME
     * @param addTime the value for dcdg_basic_chat_base.ADD_TIME
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：更新时间dcdg_basic_chat_base.UPDATE_TIME
     *
     * @return  the value of dcdg_basic_chat_base.UPDATE_TIME
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：更新时间dcdg_basic_chat_base.UPDATE_TIME
     * @param updateTime the value for dcdg_basic_chat_base.UPDATE_TIME
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 数据库字段：好有备注dcdg_basic_chat_base.FRIENT_REMARK
     *
     * @return  the value of dcdg_basic_chat_base.FRIENT_REMARK
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    public String getFrientRemark() {
        return frientRemark;
    }

    /**
     * 数据库字段：好有备注dcdg_basic_chat_base.FRIENT_REMARK
     * @param frientRemark the value for dcdg_basic_chat_base.FRIENT_REMARK
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    public void setFrientRemark(String frientRemark) {
        this.frientRemark = frientRemark == null ? null : frientRemark.trim();
    }

    /**
     * 数据库字段：电话号码dcdg_basic_chat_base.CHAT_PHONE
     *
     * @return  the value of dcdg_basic_chat_base.CHAT_PHONE
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    public String getChatPhone() {
        return chatPhone;
    }

    /**
     * 数据库字段：电话号码dcdg_basic_chat_base.CHAT_PHONE
     * @param chatPhone the value for dcdg_basic_chat_base.CHAT_PHONE
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    public void setChatPhone(String chatPhone) {
        this.chatPhone = chatPhone == null ? null : chatPhone.trim();
    }

    /**
     * 数据库字段：描述dcdg_basic_chat_base.CHAT_DESCRIBE
     *
     * @return  the value of dcdg_basic_chat_base.CHAT_DESCRIBE
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    public String getChatDescribe() {
        return chatDescribe;
    }

    /**
     * 数据库字段：描述dcdg_basic_chat_base.CHAT_DESCRIBE
     * @param chatDescribe the value for dcdg_basic_chat_base.CHAT_DESCRIBE
     *
     * @mbg.generated Tue Apr 23 16:31:42 CST 2019
     */
    public void setChatDescribe(String chatDescribe) {
        this.chatDescribe = chatDescribe == null ? null : chatDescribe.trim();
    }
}