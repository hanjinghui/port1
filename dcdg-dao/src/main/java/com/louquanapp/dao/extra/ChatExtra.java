package com.louquanapp.dao.extra;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/22 15:45
 * @description:
 */
public class ChatExtra {
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像
     */
    private String headImg;

    /**
     * 首字母
     */
    private String initial;

    /**
     * 地区
     */
    private String areaPath;
    /**
     * 个性签名
     */
    private String remark;
    /**
     * 用户手机
     */
    private  String custPhone;

    /**
     * 聊天好友群数量
     */
    private Integer chatGroupNum;

    public Integer getChatGroupNum() {
        return chatGroupNum;
    }

    public void setChatGroupNum(Integer chatGroupNum) {
        this.chatGroupNum = chatGroupNum;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getAreaPath() {
        return areaPath;
    }

    public void setAreaPath(String areaPath) {
        this.areaPath = areaPath;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}
