package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/20 20:29
 * @description:
 */
public class ReqUserInfoPage extends ReqTokenPage {
    /**
     * 昵称
     */
    private String nickName;

    /**
     * 朋友custId
     */
    private String friendId;

    /**
     *  好友关系Id
     * @return
     */
    private  String chatId;

    /**
     * 好友备注
     */
    @Pattern(regexp = ".{1,255}", message = "好友备注,范围[1到255字符]")
    private  String frientRemark;

    /**
     * 电话号码
     */
    private  String chatPhone;
    /**
     * 描述
     *
     */
    private  String chatDescribe;
    /**
     * 好友状态[1-正常 2-拉黑]
     */
    @Range(min = 1,max = 2,message = "好友状态范围[1-正常 2-拉黑]")
    private Byte chatStatus;

    public Byte getChatStatus() {
        return chatStatus;
    }

    public void setChatStatus(Byte chatStatus) {
        this.chatStatus = chatStatus;
    }

    public String getChatPhone() {
        return chatPhone;
    }

    public void setChatPhone(String chatPhone) {
        this.chatPhone = chatPhone;
    }

    public String getChatDescribe() {
        return chatDescribe;
    }

    public void setChatDescribe(String chatDescribe) {
        this.chatDescribe = chatDescribe;
    }

    public String getFrientRemark() {
        return frientRemark;
    }

    public void setFrientRemark(String frientRemark) {
        this.frientRemark = frientRemark;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }
}
