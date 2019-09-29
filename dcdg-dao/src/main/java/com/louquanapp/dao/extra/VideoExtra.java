package com.louquanapp.dao.extra;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/25 10:34
 * @Description:
 */
public class VideoExtra {
    /**
     * 1-餐饮 2-其他
     */
    private Byte type;


    /**
     * 新增粉丝
     */
    private Integer newCust;
    /**
     * 新增关注
     */
    private Integer newFocus;
    /**
     * 分钟
     */
    private Long times;

    /**
     * 关注主播id
     */
    private String attentionId;

    public String getAttentionId() {
        return attentionId;
    }

    public void setAttentionId(String attentionId) {
        this.attentionId = attentionId;
    }


    /**
     * 进入id
     */
    private String inId;

    public String getInId() {
        return inId;
    }

    public void setInId(String inId) {
        this.inId = inId;
    }

    private String nickName;
    private String headImg;
    private Integer favCount = 0;

    /**
     * 点赞量
     */
    private Integer likeCount;
    /**
     * 关注
     */
    private boolean focus = false;

    /**
     * 点赞
     */
    private boolean fav = false;

    /**
     * 小图标
     */
    private String catIcons;

    /**
     * 商品名称
     */
    private String shopName;
    /**
     * 是否过期[0-已过期 1-未过期]
     */
    private String isOverdue;

    public String getIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(String isOverdue) {
        this.isOverdue = isOverdue;
    }

    /**
     * 店铺具体地址
     */
    private String shopAddress;
    /**
     * GRPS地址
     */
    private String grps;

    /**
     * 店铺Logo
     */
    private String shopLogo;


    /**
     * 视频评论量
     */
    private Integer videoEvaluateCount;



    private Boolean flags =true;

    public Boolean getFlags() {
        return flags;
    }

    public void setFlags(Boolean flags) {
        this.flags = flags;
    }

    public Integer getVideoEvaluateCount() {
        return videoEvaluateCount;
    }

    public void setVideoEvaluateCount(Integer videoEvaluateCount) {
        this.videoEvaluateCount = videoEvaluateCount;
    }

    public String getShopLogo() {
        return shopLogo;
    }

    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getGrps() {
        return grps;
    }

    public void setGrps(String grps) {
        this.grps = grps;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getCatIcons() {
        return catIcons;
    }

    public void setCatIcons(String catIcons) {
        this.catIcons = catIcons;
    }

    /**
     * 是否在计划开播时间段里[1-在计划开播时间段里 2-不在计划开播时间段里]
     */
    private Integer isAllowVideo;

    public Integer getIsAllowVideo() {
        return isAllowVideo;
    }

    public void setIsAllowVideo(Integer isAllowVideo) {
        this.isAllowVideo = isAllowVideo;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
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

    public boolean isFocus() {
        return focus;
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
    }

    public Integer getFavCount() {
        return favCount;
    }

    public void setFavCount(Integer favCount) {
        this.favCount = favCount;
    }

    public Integer getNewCust() {
        return newCust;
    }

    public void setNewCust(Integer newCust) {
        this.newCust = newCust;
    }

    public Integer getNewFocus() {
        return newFocus;
    }

    public void setNewFocus(Integer newFocus) {
        this.newFocus = newFocus;
    }

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }
}
