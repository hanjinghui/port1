package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.VideoExtra;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_video_video_base
 *
 * @mbg.generated do_not_delete_during_merge Wed May 15 13:07:07 CST 2019
 */
public class Video extends VideoExtra {
    /**
     * 标识
     * <p>
     * 数据库字段名:dcdg_video_video_base.VIDEO_ID
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private String videoId;

    /**
     * 标题
     * <p>
     * 数据库字段名:dcdg_video_video_base.VIDEO_TITLE
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private String videoTitle;

    /**
     * 分类
     * <p>
     * 数据库字段名:dcdg_video_video_base.CAT_ID
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private String catId;

    /**
     * 默认图片
     * <p>
     * 数据库字段名:dcdg_video_video_base.VIDEO_IMG
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private String videoImg;

    /**
     * 拉流地址
     * <p>
     * 数据库字段名:dcdg_video_video_base.VIDEO_URL
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private String videoUrl;

    /**
     * 推流地址
     * <p>
     * 数据库字段名:dcdg_video_video_base.VIDEO_PUSH_URL
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private String videoPushUrl;

    /**
     * 预计时长（分钟）
     * <p>
     * 数据库字段名:dcdg_video_video_base.VIDEO_TIME
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private Integer videoTime;

    /**
     * 在线人数
     * <p>
     * 数据库字段名:dcdg_video_video_base.ONLINE_COUNT
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private Integer onlineCount;

    /**
     * 添加时间
     * <p>
     * 数据库字段名:dcdg_video_video_base.ADD_TIME
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private Date addTime;

    /**
     * 添加人
     * <p>
     * 数据库字段名:dcdg_video_video_base.ADD_USER
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private String addUser;

    /**
     * 添加人名称
     * <p>
     * 数据库字段名:dcdg_video_video_base.ADD_USER_NAME
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private String addUserName;

    /**
     * 直播状态[1-未开始 2-直播中 3-禁播 4-审核中 5-审核不通过 6-直播结束]
     * <p>
     * 数据库字段名:dcdg_video_video_base.VIDEO_STATUS
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private Byte videoStatus;

    /**
     * 房间号唯一
     * <p>
     * 数据库字段名:dcdg_video_video_base.VIDEO_NO
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private Integer videoNo;

    /**
     * 用户/商家
     * <p>
     * 数据库字段名:dcdg_video_video_base.CUST_ID
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private String custId;

    /**
     * 开始时间
     * <p>
     * 数据库字段名:dcdg_video_video_base.VIDEO_START_TIME
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private Date videoStartTime;

    /**
     * 结束时间
     * <p>
     * 数据库字段名:dcdg_video_video_base.VIDEO_END_TIME
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private Date videoEndTime;

    /**
     * 开播时间
     * <p>
     * 数据库字段名:dcdg_video_video_base.REAL_START_TIME
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private Date realStartTime;

    /**
     * 结播时间
     * <p>
     * 数据库字段名:dcdg_video_video_base.REAL_END_TIME
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private Date realEndTime;

    /**
     * 位置
     * <p>
     * 数据库字段名:dcdg_video_video_base.LOCATION
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private String location;

    /**
     * 推荐[1-是 2-否]
     * <p>
     * 数据库字段名:dcdg_video_video_base.IS_REC
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private Byte isRec;

    /**
     * 类型[1-直播 2-点播]
     * <p>
     * 数据库字段名:dcdg_video_video_base.VIDEO_TYPE
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private Byte videoType;

    /**
     * 视频介绍
     * <p>
     * 数据库字段名:dcdg_video_video_base.VIDEO_DESC
     *
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    private String videoDesc;

    /**
     * 数据库字段：标识dcdg_video_video_base.VIDEO_ID
     *
     * @return the value of dcdg_video_video_base.VIDEO_ID
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public String getVideoId() {
        return videoId;
    }

    /**
     * 数据库字段：标识dcdg_video_video_base.VIDEO_ID
     *
     * @param videoId the value for dcdg_video_video_base.VIDEO_ID
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }

    /**
     * 数据库字段：标题dcdg_video_video_base.VIDEO_TITLE
     *
     * @return the value of dcdg_video_video_base.VIDEO_TITLE
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public String getVideoTitle() {
        return videoTitle;
    }

    /**
     * 数据库字段：标题dcdg_video_video_base.VIDEO_TITLE
     *
     * @param videoTitle the value for dcdg_video_video_base.VIDEO_TITLE
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle == null ? null : videoTitle.trim();
    }

    /**
     * 数据库字段：分类dcdg_video_video_base.CAT_ID
     *
     * @return the value of dcdg_video_video_base.CAT_ID
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public String getCatId() {
        return catId;
    }

    /**
     * 数据库字段：分类dcdg_video_video_base.CAT_ID
     *
     * @param catId the value for dcdg_video_video_base.CAT_ID
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setCatId(String catId) {
        this.catId = catId == null ? null : catId.trim();
    }

    /**
     * 数据库字段：默认图片dcdg_video_video_base.VIDEO_IMG
     *
     * @return the value of dcdg_video_video_base.VIDEO_IMG
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public String getVideoImg() {
        return videoImg;
    }

    /**
     * 数据库字段：默认图片dcdg_video_video_base.VIDEO_IMG
     *
     * @param videoImg the value for dcdg_video_video_base.VIDEO_IMG
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg == null ? null : videoImg.trim();
    }

    /**
     * 数据库字段：拉流地址dcdg_video_video_base.VIDEO_URL
     *
     * @return the value of dcdg_video_video_base.VIDEO_URL
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * 数据库字段：拉流地址dcdg_video_video_base.VIDEO_URL
     *
     * @param videoUrl the value for dcdg_video_video_base.VIDEO_URL
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    /**
     * 数据库字段：推流地址dcdg_video_video_base.VIDEO_PUSH_URL
     *
     * @return the value of dcdg_video_video_base.VIDEO_PUSH_URL
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public String getVideoPushUrl() {
        return videoPushUrl;
    }

    /**
     * 数据库字段：推流地址dcdg_video_video_base.VIDEO_PUSH_URL
     *
     * @param videoPushUrl the value for dcdg_video_video_base.VIDEO_PUSH_URL
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setVideoPushUrl(String videoPushUrl) {
        this.videoPushUrl = videoPushUrl == null ? null : videoPushUrl.trim();
    }

    /**
     * 数据库字段：预计时长（分钟）dcdg_video_video_base.VIDEO_TIME
     *
     * @return the value of dcdg_video_video_base.VIDEO_TIME
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public Integer getVideoTime() {
        return videoTime;
    }

    /**
     * 数据库字段：预计时长（分钟）dcdg_video_video_base.VIDEO_TIME
     *
     * @param videoTime the value for dcdg_video_video_base.VIDEO_TIME
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setVideoTime(Integer videoTime) {
        this.videoTime = videoTime;
    }

    /**
     * 数据库字段：在线人数dcdg_video_video_base.ONLINE_COUNT
     *
     * @return the value of dcdg_video_video_base.ONLINE_COUNT
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public Integer getOnlineCount() {
        return onlineCount;
    }

    /**
     * 数据库字段：在线人数dcdg_video_video_base.ONLINE_COUNT
     *
     * @param onlineCount the value for dcdg_video_video_base.ONLINE_COUNT
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setOnlineCount(Integer onlineCount) {
        this.onlineCount = onlineCount;
    }

    /**
     * 数据库字段：添加时间dcdg_video_video_base.ADD_TIME
     *
     * @return the value of dcdg_video_video_base.ADD_TIME
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_video_video_base.ADD_TIME
     *
     * @param addTime the value for dcdg_video_video_base.ADD_TIME
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：添加人dcdg_video_video_base.ADD_USER
     *
     * @return the value of dcdg_video_video_base.ADD_USER
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public String getAddUser() {
        return addUser;
    }

    /**
     * 数据库字段：添加人dcdg_video_video_base.ADD_USER
     *
     * @param addUser the value for dcdg_video_video_base.ADD_USER
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setAddUser(String addUser) {
        this.addUser = addUser == null ? null : addUser.trim();
    }

    /**
     * 数据库字段：添加人名称dcdg_video_video_base.ADD_USER_NAME
     *
     * @return the value of dcdg_video_video_base.ADD_USER_NAME
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public String getAddUserName() {
        return addUserName;
    }

    /**
     * 数据库字段：添加人名称dcdg_video_video_base.ADD_USER_NAME
     *
     * @param addUserName the value for dcdg_video_video_base.ADD_USER_NAME
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName == null ? null : addUserName.trim();
    }

    /**
     * 数据库字段：直播状态[1-未开始 2-直播中 3-禁播 4-审核中 5-审核不通过 6-直播结束]dcdg_video_video_base.VIDEO_STATUS
     *
     * @return the value of dcdg_video_video_base.VIDEO_STATUS
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public Byte getVideoStatus() {
        return videoStatus;
    }

    /**
     * 数据库字段：直播状态[1-未开始 2-直播中 3-禁播 4-审核中 5-审核不通过 6-直播结束]dcdg_video_video_base.VIDEO_STATUS
     *
     * @param videoStatus the value for dcdg_video_video_base.VIDEO_STATUS
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setVideoStatus(Byte videoStatus) {
        this.videoStatus = videoStatus;
    }

    /**
     * 数据库字段：房间号唯一dcdg_video_video_base.VIDEO_NO
     *
     * @return the value of dcdg_video_video_base.VIDEO_NO
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public Integer getVideoNo() {
        return videoNo;
    }

    /**
     * 数据库字段：房间号唯一dcdg_video_video_base.VIDEO_NO
     *
     * @param videoNo the value for dcdg_video_video_base.VIDEO_NO
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setVideoNo(Integer videoNo) {
        this.videoNo = videoNo;
    }

    /**
     * 数据库字段：用户/商家dcdg_video_video_base.CUST_ID
     *
     * @return the value of dcdg_video_video_base.CUST_ID
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：用户/商家dcdg_video_video_base.CUST_ID
     *
     * @param custId the value for dcdg_video_video_base.CUST_ID
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：开始时间dcdg_video_video_base.VIDEO_START_TIME
     *
     * @return the value of dcdg_video_video_base.VIDEO_START_TIME
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public Date getVideoStartTime() {
        return videoStartTime;
    }

    /**
     * 数据库字段：开始时间dcdg_video_video_base.VIDEO_START_TIME
     *
     * @param videoStartTime the value for dcdg_video_video_base.VIDEO_START_TIME
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setVideoStartTime(Date videoStartTime) {
        this.videoStartTime = videoStartTime;
    }

    /**
     * 数据库字段：结束时间dcdg_video_video_base.VIDEO_END_TIME
     *
     * @return the value of dcdg_video_video_base.VIDEO_END_TIME
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public Date getVideoEndTime() {
        return videoEndTime;
    }

    /**
     * 数据库字段：结束时间dcdg_video_video_base.VIDEO_END_TIME
     *
     * @param videoEndTime the value for dcdg_video_video_base.VIDEO_END_TIME
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setVideoEndTime(Date videoEndTime) {
        this.videoEndTime = videoEndTime;
    }

    /**
     * 数据库字段：开播时间dcdg_video_video_base.REAL_START_TIME
     *
     * @return the value of dcdg_video_video_base.REAL_START_TIME
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public Date getRealStartTime() {
        return realStartTime;
    }

    /**
     * 数据库字段：开播时间dcdg_video_video_base.REAL_START_TIME
     *
     * @param realStartTime the value for dcdg_video_video_base.REAL_START_TIME
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setRealStartTime(Date realStartTime) {
        this.realStartTime = realStartTime;
    }

    /**
     * 数据库字段：结播时间dcdg_video_video_base.REAL_END_TIME
     *
     * @return the value of dcdg_video_video_base.REAL_END_TIME
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public Date getRealEndTime() {
        return realEndTime;
    }

    /**
     * 数据库字段：结播时间dcdg_video_video_base.REAL_END_TIME
     *
     * @param realEndTime the value for dcdg_video_video_base.REAL_END_TIME
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setRealEndTime(Date realEndTime) {
        this.realEndTime = realEndTime;
    }

    /**
     * 数据库字段：位置dcdg_video_video_base.LOCATION
     *
     * @return the value of dcdg_video_video_base.LOCATION
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public String getLocation() {
        return location;
    }

    /**
     * 数据库字段：位置dcdg_video_video_base.LOCATION
     *
     * @param location the value for dcdg_video_video_base.LOCATION
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * 数据库字段：推荐[1-是 2-否]dcdg_video_video_base.IS_REC
     *
     * @return the value of dcdg_video_video_base.IS_REC
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public Byte getIsRec() {
        return isRec;
    }

    /**
     * 数据库字段：推荐[1-是 2-否]dcdg_video_video_base.IS_REC
     *
     * @param isRec the value for dcdg_video_video_base.IS_REC
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setIsRec(Byte isRec) {
        this.isRec = isRec;
    }

    /**
     * 数据库字段：类型[1-直播 2-点播]dcdg_video_video_base.VIDEO_TYPE
     *
     * @return the value of dcdg_video_video_base.VIDEO_TYPE
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public Byte getVideoType() {
        return videoType;
    }

    /**
     * 数据库字段：类型[1-直播 2-点播]dcdg_video_video_base.VIDEO_TYPE
     *
     * @param videoType the value for dcdg_video_video_base.VIDEO_TYPE
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setVideoType(Byte videoType) {
        this.videoType = videoType;
    }

    /**
     * 数据库字段：视频介绍dcdg_video_video_base.VIDEO_DESC
     *
     * @return the value of dcdg_video_video_base.VIDEO_DESC
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public String getVideoDesc() {
        return videoDesc;
    }

    /**
     * 数据库字段：视频介绍dcdg_video_video_base.VIDEO_DESC
     *
     * @param videoDesc the value for dcdg_video_video_base.VIDEO_DESC
     * @mbg.generated Wed May 15 13:07:07 CST 2019
     */
    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc == null ? null : videoDesc.trim();
    }
}