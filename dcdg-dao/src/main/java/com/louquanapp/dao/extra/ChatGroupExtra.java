package com.louquanapp.dao.extra;

import com.louquanapp.dao.model.ChatGroupRelation;

import java.util.List;
import java.util.Map;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/23 18:25
 * @description:
 */
public class ChatGroupExtra {
    /**
     * 群成员头像,id集合
     */
    private List<Map<String,Object>> custHeadImgsAndCustIds;
    /**
     * 群成员id集合
     */
    private List<String> custIds;

    /**
     * 用户id
     */
    private String custId;
    /**
     * 用户在群里的昵称
     */
    private String custGroupNickName;
    /**
     * 状态[1-显示群成员昵称 2-不显示群成员昵称  ]
     */
    private Byte relationStatus;
    /**
     * 用户群关系id
     */
    private String relationId;

    /**
     * 首字母
     */
    private String initial;
    /**
     * 用户头像
     */
    private String  headImg;
    /**
     * 昵称
     */
    private String nickName;

    /**
     * 好友id
     */
    private String friendId;
    /**
     * 是不是群主[1-群主 2不是群主]
     */
    private Integer isChatGroupMaster;
    /**
     * 群主昵称
     */
    private String chatGroupMasterName;

    public String getChatGroupMasterName() {
        return chatGroupMasterName;
    }

    public void setChatGroupMasterName(String chatGroupMasterName) {
        this.chatGroupMasterName = chatGroupMasterName;
    }

    private  List<ChatGroupRelation> list;

    public List<ChatGroupRelation> getList() {
        return list;
    }

    public void setList(List<ChatGroupRelation> list) {
        this.list = list;
    }

    public Integer getIsChatGroupMaster() {
        return isChatGroupMaster;
    }

    public void setIsChatGroupMaster(Integer isChatGroupMaster) {
        this.isChatGroupMaster = isChatGroupMaster;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
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

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public List<String> getCustIds() {
        return custIds;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public void setCustIds(List<String> custIds) {
        this.custIds = custIds;
    }

    public String getCustGroupNickName() {
        return custGroupNickName;
    }

    public void setCustGroupNickName(String custGroupNickName) {
        this.custGroupNickName = custGroupNickName;
    }

    public Byte getRelationStatus() {
        return relationStatus;
    }

    public void setRelationStatus(Byte relationStatus) {
        this.relationStatus = relationStatus;
    }

    public List<Map<String, Object>> getCustHeadImgsAndCustIds() {
        return custHeadImgsAndCustIds;
    }

    public void setCustHeadImgsAndCustIds(List<Map<String, Object>> custHeadImgsAndCustIds) {
        this.custHeadImgsAndCustIds = custHeadImgsAndCustIds;
    }
}
