package com.louquanapp.dao.model;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_basic_message_base
 *
 * @mbg.generated do_not_delete_during_merge Tue Jun 04 12:55:44 CST 2019
 */
public class Message {
    /**
     *   消息ID
     *
     * 数据库字段名:dcdg_basic_message_base.MESSAGE_ID
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    private String messageId;

    /**
     *   小图片
     *
     * 数据库字段名:dcdg_basic_message_base.MESSAGE_ICON
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    private String messageIcon;

    /**
     *   消息标题
     *
     * 数据库字段名:dcdg_basic_message_base.MESSAGE_TITLE
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    private String messageTitle;

    /**
     *   消息内容
     *
     * 数据库字段名:dcdg_basic_message_base.MESSAGE_CONTENT
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    private String messageContent;

    /**
     *   状态[1-启用 2-禁止]
     *
     * 数据库字段名:dcdg_basic_message_base.RELEASE_STATUS
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    private Byte releaseStatus;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_basic_message_base.ADD_TIME
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    private Date addTime;

    /**
     *   添加人
     *
     * 数据库字段名:dcdg_basic_message_base.ADD_USER
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    private String addUser;

    /**
     *   添加人名称
     *
     * 数据库字段名:dcdg_basic_message_base.ADD_USER_NAME
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    private String addUserName;

    /**
     *   更新时间
     *
     * 数据库字段名:dcdg_basic_message_base.UPDATE_TIME
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    private Date updateTime;

    /**
     *   消息类型[ 1-用户参与拼手气抢红包游戏，游戏结束后，系统通知抢到2元以上红包的用户 2-用户通过玩某一款游戏， 显示第一个完成所有任务的用户 3-用户在商城用积分成功兑换商品扣掉积分之后 4-平台维护升级时候的系统通知 5-新游戏上线，成功添加新游戏到APP之后 6-举行游戏比赛，确定游戏比赛时间的时候 7-抢红包游戏时间确定的时候消息公布]
     *
     * 数据库字段名:dcdg_basic_message_base.MESSAGE_TYPE
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    private Integer messageType;

    /**
     *   到期时间
     *
     * 数据库字段名:dcdg_basic_message_base.MESSAGE_LIMIT_TIME
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    private Date messageLimitTime;

    /**
     *   顺序
     *
     * 数据库字段名:dcdg_basic_message_base.MESSAGE_ORDER
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    private Integer messageOrder;

    /**
     * 数据库字段：消息IDdcdg_basic_message_base.MESSAGE_ID
     *
     * @return  the value of dcdg_basic_message_base.MESSAGE_ID
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * 数据库字段：消息IDdcdg_basic_message_base.MESSAGE_ID
     * @param messageId the value for dcdg_basic_message_base.MESSAGE_ID
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId == null ? null : messageId.trim();
    }

    /**
     * 数据库字段：小图片dcdg_basic_message_base.MESSAGE_ICON
     *
     * @return  the value of dcdg_basic_message_base.MESSAGE_ICON
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public String getMessageIcon() {
        return messageIcon;
    }

    /**
     * 数据库字段：小图片dcdg_basic_message_base.MESSAGE_ICON
     * @param messageIcon the value for dcdg_basic_message_base.MESSAGE_ICON
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public void setMessageIcon(String messageIcon) {
        this.messageIcon = messageIcon == null ? null : messageIcon.trim();
    }

    /**
     * 数据库字段：消息标题dcdg_basic_message_base.MESSAGE_TITLE
     *
     * @return  the value of dcdg_basic_message_base.MESSAGE_TITLE
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public String getMessageTitle() {
        return messageTitle;
    }

    /**
     * 数据库字段：消息标题dcdg_basic_message_base.MESSAGE_TITLE
     * @param messageTitle the value for dcdg_basic_message_base.MESSAGE_TITLE
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle == null ? null : messageTitle.trim();
    }

    /**
     * 数据库字段：消息内容dcdg_basic_message_base.MESSAGE_CONTENT
     *
     * @return  the value of dcdg_basic_message_base.MESSAGE_CONTENT
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public String getMessageContent() {
        return messageContent;
    }

    /**
     * 数据库字段：消息内容dcdg_basic_message_base.MESSAGE_CONTENT
     * @param messageContent the value for dcdg_basic_message_base.MESSAGE_CONTENT
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }

    /**
     * 数据库字段：状态[1-启用 2-禁止]dcdg_basic_message_base.RELEASE_STATUS
     *
     * @return  the value of dcdg_basic_message_base.RELEASE_STATUS
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public Byte getReleaseStatus() {
        return releaseStatus;
    }

    /**
     * 数据库字段：状态[1-启用 2-禁止]dcdg_basic_message_base.RELEASE_STATUS
     * @param releaseStatus the value for dcdg_basic_message_base.RELEASE_STATUS
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public void setReleaseStatus(Byte releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    /**
     * 数据库字段：添加时间dcdg_basic_message_base.ADD_TIME
     *
     * @return  the value of dcdg_basic_message_base.ADD_TIME
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_basic_message_base.ADD_TIME
     * @param addTime the value for dcdg_basic_message_base.ADD_TIME
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：添加人dcdg_basic_message_base.ADD_USER
     *
     * @return  the value of dcdg_basic_message_base.ADD_USER
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public String getAddUser() {
        return addUser;
    }

    /**
     * 数据库字段：添加人dcdg_basic_message_base.ADD_USER
     * @param addUser the value for dcdg_basic_message_base.ADD_USER
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public void setAddUser(String addUser) {
        this.addUser = addUser == null ? null : addUser.trim();
    }

    /**
     * 数据库字段：添加人名称dcdg_basic_message_base.ADD_USER_NAME
     *
     * @return  the value of dcdg_basic_message_base.ADD_USER_NAME
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public String getAddUserName() {
        return addUserName;
    }

    /**
     * 数据库字段：添加人名称dcdg_basic_message_base.ADD_USER_NAME
     * @param addUserName the value for dcdg_basic_message_base.ADD_USER_NAME
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName == null ? null : addUserName.trim();
    }

    /**
     * 数据库字段：更新时间dcdg_basic_message_base.UPDATE_TIME
     *
     * @return  the value of dcdg_basic_message_base.UPDATE_TIME
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：更新时间dcdg_basic_message_base.UPDATE_TIME
     * @param updateTime the value for dcdg_basic_message_base.UPDATE_TIME
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 数据库字段：消息类型[ 1-用户参与拼手气抢红包游戏，游戏结束后，系统通知抢到2元以上红包的用户 2-用户通过玩某一款游戏， 显示第一个完成所有任务的用户 3-用户在商城用积分成功兑换商品扣掉积分之后 4-平台维护升级时候的系统通知 5-新游戏上线，成功添加新游戏到APP之后 6-举行游戏比赛，确定游戏比赛时间的时候 7-抢红包游戏时间确定的时候消息公布]dcdg_basic_message_base.MESSAGE_TYPE
     *
     * @return  the value of dcdg_basic_message_base.MESSAGE_TYPE
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public Integer getMessageType() {
        return messageType;
    }

    /**
     * 数据库字段：消息类型[ 1-用户参与拼手气抢红包游戏，游戏结束后，系统通知抢到2元以上红包的用户 2-用户通过玩某一款游戏， 显示第一个完成所有任务的用户 3-用户在商城用积分成功兑换商品扣掉积分之后 4-平台维护升级时候的系统通知 5-新游戏上线，成功添加新游戏到APP之后 6-举行游戏比赛，确定游戏比赛时间的时候 7-抢红包游戏时间确定的时候消息公布]dcdg_basic_message_base.MESSAGE_TYPE
     * @param messageType the value for dcdg_basic_message_base.MESSAGE_TYPE
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    /**
     * 数据库字段：到期时间dcdg_basic_message_base.MESSAGE_LIMIT_TIME
     *
     * @return  the value of dcdg_basic_message_base.MESSAGE_LIMIT_TIME
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public Date getMessageLimitTime() {
        return messageLimitTime;
    }

    /**
     * 数据库字段：到期时间dcdg_basic_message_base.MESSAGE_LIMIT_TIME
     * @param messageLimitTime the value for dcdg_basic_message_base.MESSAGE_LIMIT_TIME
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public void setMessageLimitTime(Date messageLimitTime) {
        this.messageLimitTime = messageLimitTime;
    }

    /**
     * 数据库字段：顺序dcdg_basic_message_base.MESSAGE_ORDER
     *
     * @return  the value of dcdg_basic_message_base.MESSAGE_ORDER
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public Integer getMessageOrder() {
        return messageOrder;
    }

    /**
     * 数据库字段：顺序dcdg_basic_message_base.MESSAGE_ORDER
     * @param messageOrder the value for dcdg_basic_message_base.MESSAGE_ORDER
     *
     * @mbg.generated Tue Jun 04 12:55:44 CST 2019
     */
    public void setMessageOrder(Integer messageOrder) {
        this.messageOrder = messageOrder;
    }
}