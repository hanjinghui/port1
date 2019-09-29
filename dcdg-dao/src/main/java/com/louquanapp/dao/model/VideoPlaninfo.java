package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.VideoExtra;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_video_planinfo_base
 *
 * @mbg.generated do_not_delete_during_merge Fri Aug 16 10:30:46 CST 2019
 */
public class VideoPlaninfo   extends VideoExtra {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_video_planinfo_base.PLAN_ID
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    private String planId;

    /**
     *   预定人数
     *
     * 数据库字段名:dcdg_video_planinfo_base.PLAN_NUM
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    private Byte planNum;

    /**
     *   时间段
     *
     * 数据库字段名:dcdg_video_planinfo_base.PLAN_DATE
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    private String planDate;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_video_planinfo_base.ADD_TIME
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    private Date addTime;

    /**
     *   添加人
     *
     * 数据库字段名:dcdg_video_planinfo_base.CUST_ID
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    private String custId;

    /**
     *   添加名称
     *
     * 数据库字段名:dcdg_video_planinfo_base.CUST_NAME
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    private String custName;

    /**
     *   手机号
     *
     * 数据库字段名:dcdg_video_planinfo_base.CUST_PHONE
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    private String custPhone;

    /**
     *   商家ID
     *
     * 数据库字段名:dcdg_video_planinfo_base.SHOP_ID
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    private String shopId;

    /**
     *   直播间ID
     *
     * 数据库字段名:dcdg_video_planinfo_base.VIDEO_ID
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    private String videoId;

    /**
     *   状态[1-待确认 2-预定成功 3-预订失败 4-用户取消  5-结束]
     *
     * 数据库字段名:dcdg_video_planinfo_base.PLAN_STATUS
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    private Byte planStatus;

    /**
     *   备注
     *
     * 数据库字段名:dcdg_video_planinfo_base.REMARKS
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    private String remarks;

    /**
     *   子订单id
     *
     * 数据库字段名:dcdg_video_planinfo_base.CHILD_ID
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    private String childId;

    /**
     *   订单id
     *
     * 数据库字段名:dcdg_video_planinfo_base.ORDER_ID
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    private String orderId;

    /**
     *   二维码
     *
     * 数据库字段名:dcdg_video_planinfo_base.PLAN_IMG
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    private String planImg;

    /**
     *   是否显示[1-是 2-否]
     *
     * 数据库字段名:dcdg_video_planinfo_base.IS_DEL
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    private Byte isDel;

    /**
     *   商家回复
     *
     * 数据库字段名:dcdg_video_planinfo_base.REPLY
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    private String reply;

    /**
     * 数据库字段：主键dcdg_video_planinfo_base.PLAN_ID
     *
     * @return  the value of dcdg_video_planinfo_base.PLAN_ID
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public String getPlanId() {
        return planId;
    }

    /**
     * 数据库字段：主键dcdg_video_planinfo_base.PLAN_ID
     * @param planId the value for dcdg_video_planinfo_base.PLAN_ID
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    /**
     * 数据库字段：预定人数dcdg_video_planinfo_base.PLAN_NUM
     *
     * @return  the value of dcdg_video_planinfo_base.PLAN_NUM
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public Byte getPlanNum() {
        return planNum;
    }

    /**
     * 数据库字段：预定人数dcdg_video_planinfo_base.PLAN_NUM
     * @param planNum the value for dcdg_video_planinfo_base.PLAN_NUM
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public void setPlanNum(Byte planNum) {
        this.planNum = planNum;
    }

    /**
     * 数据库字段：时间段dcdg_video_planinfo_base.PLAN_DATE
     *
     * @return  the value of dcdg_video_planinfo_base.PLAN_DATE
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public String getPlanDate() {
        return planDate;
    }

    /**
     * 数据库字段：时间段dcdg_video_planinfo_base.PLAN_DATE
     * @param planDate the value for dcdg_video_planinfo_base.PLAN_DATE
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public void setPlanDate(String planDate) {
        this.planDate = planDate == null ? null : planDate.trim();
    }

    /**
     * 数据库字段：添加时间dcdg_video_planinfo_base.ADD_TIME
     *
     * @return  the value of dcdg_video_planinfo_base.ADD_TIME
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_video_planinfo_base.ADD_TIME
     * @param addTime the value for dcdg_video_planinfo_base.ADD_TIME
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：添加人dcdg_video_planinfo_base.CUST_ID
     *
     * @return  the value of dcdg_video_planinfo_base.CUST_ID
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：添加人dcdg_video_planinfo_base.CUST_ID
     * @param custId the value for dcdg_video_planinfo_base.CUST_ID
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：添加名称dcdg_video_planinfo_base.CUST_NAME
     *
     * @return  the value of dcdg_video_planinfo_base.CUST_NAME
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public String getCustName() {
        return custName;
    }

    /**
     * 数据库字段：添加名称dcdg_video_planinfo_base.CUST_NAME
     * @param custName the value for dcdg_video_planinfo_base.CUST_NAME
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    /**
     * 数据库字段：手机号dcdg_video_planinfo_base.CUST_PHONE
     *
     * @return  the value of dcdg_video_planinfo_base.CUST_PHONE
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public String getCustPhone() {
        return custPhone;
    }

    /**
     * 数据库字段：手机号dcdg_video_planinfo_base.CUST_PHONE
     * @param custPhone the value for dcdg_video_planinfo_base.CUST_PHONE
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone == null ? null : custPhone.trim();
    }

    /**
     * 数据库字段：商家IDdcdg_video_planinfo_base.SHOP_ID
     *
     * @return  the value of dcdg_video_planinfo_base.SHOP_ID
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * 数据库字段：商家IDdcdg_video_planinfo_base.SHOP_ID
     * @param shopId the value for dcdg_video_planinfo_base.SHOP_ID
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    /**
     * 数据库字段：直播间IDdcdg_video_planinfo_base.VIDEO_ID
     *
     * @return  the value of dcdg_video_planinfo_base.VIDEO_ID
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public String getVideoId() {
        return videoId;
    }

    /**
     * 数据库字段：直播间IDdcdg_video_planinfo_base.VIDEO_ID
     * @param videoId the value for dcdg_video_planinfo_base.VIDEO_ID
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }

    /**
     * 数据库字段：状态[1-待确认 2-预定成功 3-预订失败 4-用户取消  5-结束]dcdg_video_planinfo_base.PLAN_STATUS
     *
     * @return  the value of dcdg_video_planinfo_base.PLAN_STATUS
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public Byte getPlanStatus() {
        return planStatus;
    }

    /**
     * 数据库字段：状态[1-待确认 2-预定成功 3-预订失败 4-用户取消  5-结束]dcdg_video_planinfo_base.PLAN_STATUS
     * @param planStatus the value for dcdg_video_planinfo_base.PLAN_STATUS
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public void setPlanStatus(Byte planStatus) {
        this.planStatus = planStatus;
    }

    /**
     * 数据库字段：备注dcdg_video_planinfo_base.REMARKS
     *
     * @return  the value of dcdg_video_planinfo_base.REMARKS
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 数据库字段：备注dcdg_video_planinfo_base.REMARKS
     * @param remarks the value for dcdg_video_planinfo_base.REMARKS
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 数据库字段：子订单iddcdg_video_planinfo_base.CHILD_ID
     *
     * @return  the value of dcdg_video_planinfo_base.CHILD_ID
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public String getChildId() {
        return childId;
    }

    /**
     * 数据库字段：子订单iddcdg_video_planinfo_base.CHILD_ID
     * @param childId the value for dcdg_video_planinfo_base.CHILD_ID
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public void setChildId(String childId) {
        this.childId = childId == null ? null : childId.trim();
    }

    /**
     * 数据库字段：订单iddcdg_video_planinfo_base.ORDER_ID
     *
     * @return  the value of dcdg_video_planinfo_base.ORDER_ID
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 数据库字段：订单iddcdg_video_planinfo_base.ORDER_ID
     * @param orderId the value for dcdg_video_planinfo_base.ORDER_ID
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 数据库字段：二维码dcdg_video_planinfo_base.PLAN_IMG
     *
     * @return  the value of dcdg_video_planinfo_base.PLAN_IMG
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public String getPlanImg() {
        return planImg;
    }

    /**
     * 数据库字段：二维码dcdg_video_planinfo_base.PLAN_IMG
     * @param planImg the value for dcdg_video_planinfo_base.PLAN_IMG
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public void setPlanImg(String planImg) {
        this.planImg = planImg == null ? null : planImg.trim();
    }

    /**
     * 数据库字段：是否显示[1-是 2-否]dcdg_video_planinfo_base.IS_DEL
     *
     * @return  the value of dcdg_video_planinfo_base.IS_DEL
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public Byte getIsDel() {
        return isDel;
    }

    /**
     * 数据库字段：是否显示[1-是 2-否]dcdg_video_planinfo_base.IS_DEL
     * @param isDel the value for dcdg_video_planinfo_base.IS_DEL
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    /**
     * 数据库字段：商家回复dcdg_video_planinfo_base.REPLY
     *
     * @return  the value of dcdg_video_planinfo_base.REPLY
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public String getReply() {
        return reply;
    }

    /**
     * 数据库字段：商家回复dcdg_video_planinfo_base.REPLY
     * @param reply the value for dcdg_video_planinfo_base.REPLY
     *
     * @mbg.generated Fri Aug 16 10:30:46 CST 2019
     */
    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
    }
}