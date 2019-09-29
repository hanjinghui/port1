package com.louquanapp.dao.extra;

import com.louquanapp.dao.model.VideoEvaluate;

import java.util.List;

public class VideoEvaluateExtra {

    /**
     * 二级评论
     */
    private List<VideoEvaluate> videoEvaluates;
    /**
     * 时间
     */
   private String addTimeStr;
    /**
     * 点赞量
     */
   private Integer likeCont;
    /**
     * 用户是否点赞[1-点赞过 2-未点赞]
     */
   private  Integer flay;

    /**
     * 二级评论数量
     */
    private Integer secondCount;
    /**
     * 用户id
     */
    private String custId;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 用户头像
     */
    private String headImg;

    /**
     * 是否是商户[1-不是 2-是]
     */
    private Byte isOwn;

    public Byte getIsOwn() {
        return isOwn;
    }

    public void setIsOwn(Byte isOwn) {
        this.isOwn = isOwn;
    }

    public Integer getSecondCount() {
        return secondCount;
    }

    public void setSecondCount(Integer secondCount) {
        this.secondCount = secondCount;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getLikeCont() {
        return likeCont;
    }

    public void setLikeCont(Integer likeCont) {
        this.likeCont = likeCont;
    }

    public Integer getFlay() {
        return flay;
    }

    public void setFlay(Integer flay) {
        this.flay = flay;
    }

    public List<VideoEvaluate> getVideoEvaluates() {
        return videoEvaluates;
    }

    public void setVideoEvaluates(List<VideoEvaluate> videoEvaluates) {
        this.videoEvaluates = videoEvaluates;
    }

    public String getAddTimeStr() {
        return addTimeStr;
    }

    public void setAddTimeStr(String addTimeStr) {
        this.addTimeStr = addTimeStr;
    }
}
