package com.louquanapp.dao.model;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_bussiness_order_operate
 *
 * @mbg.generated do_not_delete_during_merge Wed Apr 03 08:11:15 CST 2019
 */
public class OrderOperate {
    /**
     * 标识
     * <p>
     * 数据库字段名:dcdg_bussiness_order_operate.OPT_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String optId;

    /**
     * 主订单ID
     * <p>
     * 数据库字段名:dcdg_bussiness_order_operate.ORDER_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String orderId;

    /**
     * 子订单ID
     * <p>
     * 数据库字段名:dcdg_bussiness_order_operate.CHILD_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String childId;

    /**
     * 操作前订单状态[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货 501-已收货 601-退货申请中 611-退货中 621-已退货 701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]
     * <p>
     * 数据库字段名:dcdg_bussiness_order_operate.ORDER_STATUS_BEFORE
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Integer orderStatusBefore;

    /**
     * 操作后订单状态[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货 501-已收货 601-退货申请中 611-退货中 621-已退货 701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]
     * <p>
     * 数据库字段名:dcdg_bussiness_order_operate.ORDER_STATUS_NOW
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Integer orderStatusNow;

    /**
     * 操作备注信息
     * <p>
     * 数据库字段名:dcdg_bussiness_order_operate.OPT_REMARK
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String optRemark;

    /**
     * 操作来源[buyer-买家 seller-卖家 official-官方]
     * <p>
     * 数据库字段名:dcdg_bussiness_order_operate.OPT_SOURCE
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String optSource;

    /**
     * 操作人ID（客户ID）
     * <p>
     * 数据库字段名:dcdg_bussiness_order_operate.USER_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String userId;

    /**
     * 操作人名称（客户名称）
     * <p>
     * 数据库字段名:dcdg_bussiness_order_operate.USER_NAME
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String userName;

    /**
     * 操作人子账号ID
     * <p>
     * 数据库字段名:dcdg_bussiness_order_operate.SUB_USER_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String subUserId;

    /**
     * 操作人子账号名称
     * <p>
     * 数据库字段名:dcdg_bussiness_order_operate.SUB_USER_NAME
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String subUserName;

    /**
     * 创建时间
     * <p>
     * 数据库字段名:dcdg_bussiness_order_operate.ADD_TIME
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Date addTime;

    /**
     * 数据库字段：标识dcdg_bussiness_order_operate.OPT_ID
     *
     * @return the value of dcdg_bussiness_order_operate.OPT_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getOptId() {
        return optId;
    }

    /**
     * 数据库字段：标识dcdg_bussiness_order_operate.OPT_ID
     *
     * @param optId the value for dcdg_bussiness_order_operate.OPT_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setOptId(String optId) {
        this.optId = optId == null ? null : optId.trim();
    }

    /**
     * 数据库字段：主订单IDdcdg_bussiness_order_operate.ORDER_ID
     *
     * @return the value of dcdg_bussiness_order_operate.ORDER_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 数据库字段：主订单IDdcdg_bussiness_order_operate.ORDER_ID
     *
     * @param orderId the value for dcdg_bussiness_order_operate.ORDER_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 数据库字段：子订单IDdcdg_bussiness_order_operate.CHILD_ID
     *
     * @return the value of dcdg_bussiness_order_operate.CHILD_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getChildId() {
        return childId;
    }

    /**
     * 数据库字段：子订单IDdcdg_bussiness_order_operate.CHILD_ID
     *
     * @param childId the value for dcdg_bussiness_order_operate.CHILD_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setChildId(String childId) {
        this.childId = childId == null ? null : childId.trim();
    }

    /**
     * 数据库字段：操作前订单状态[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货 501-已收货 601-退货申请中 611-退货中 621-已退货 701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]dcdg_bussiness_order_operate.ORDER_STATUS_BEFORE
     *
     * @return the value of dcdg_bussiness_order_operate.ORDER_STATUS_BEFORE
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Integer getOrderStatusBefore() {
        return orderStatusBefore;
    }

    /**
     * 数据库字段：操作前订单状态[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货 501-已收货 601-退货申请中 611-退货中 621-已退货 701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]dcdg_bussiness_order_operate.ORDER_STATUS_BEFORE
     *
     * @param orderStatusBefore the value for dcdg_bussiness_order_operate.ORDER_STATUS_BEFORE
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setOrderStatusBefore(Integer orderStatusBefore) {
        this.orderStatusBefore = orderStatusBefore;
    }

    /**
     * 数据库字段：操作后订单状态[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货 501-已收货 601-退货申请中 611-退货中 621-已退货 701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]dcdg_bussiness_order_operate.ORDER_STATUS_NOW
     *
     * @return the value of dcdg_bussiness_order_operate.ORDER_STATUS_NOW
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Integer getOrderStatusNow() {
        return orderStatusNow;
    }

    /**
     * 数据库字段：操作后订单状态[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货 501-已收货 601-退货申请中 611-退货中 621-已退货 701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]dcdg_bussiness_order_operate.ORDER_STATUS_NOW
     *
     * @param orderStatusNow the value for dcdg_bussiness_order_operate.ORDER_STATUS_NOW
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setOrderStatusNow(Integer orderStatusNow) {
        this.orderStatusNow = orderStatusNow;
    }

    /**
     * 数据库字段：操作备注信息dcdg_bussiness_order_operate.OPT_REMARK
     *
     * @return the value of dcdg_bussiness_order_operate.OPT_REMARK
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getOptRemark() {
        return optRemark;
    }

    /**
     * 数据库字段：操作备注信息dcdg_bussiness_order_operate.OPT_REMARK
     *
     * @param optRemark the value for dcdg_bussiness_order_operate.OPT_REMARK
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setOptRemark(String optRemark) {
        this.optRemark = optRemark == null ? null : optRemark.trim();
    }

    /**
     * 数据库字段：操作来源[buyer-买家 seller-卖家 official-官方]dcdg_bussiness_order_operate.OPT_SOURCE
     *
     * @return the value of dcdg_bussiness_order_operate.OPT_SOURCE
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getOptSource() {
        return optSource;
    }

    /**
     * 数据库字段：操作来源[buyer-买家 seller-卖家 official-官方]dcdg_bussiness_order_operate.OPT_SOURCE
     *
     * @param optSource the value for dcdg_bussiness_order_operate.OPT_SOURCE
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setOptSource(String optSource) {
        this.optSource = optSource == null ? null : optSource.trim();
    }

    /**
     * 数据库字段：操作人ID（客户ID）dcdg_bussiness_order_operate.USER_ID
     *
     * @return the value of dcdg_bussiness_order_operate.USER_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 数据库字段：操作人ID（客户ID）dcdg_bussiness_order_operate.USER_ID
     *
     * @param userId the value for dcdg_bussiness_order_operate.USER_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 数据库字段：操作人名称（客户名称）dcdg_bussiness_order_operate.USER_NAME
     *
     * @return the value of dcdg_bussiness_order_operate.USER_NAME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 数据库字段：操作人名称（客户名称）dcdg_bussiness_order_operate.USER_NAME
     *
     * @param userName the value for dcdg_bussiness_order_operate.USER_NAME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 数据库字段：操作人子账号IDdcdg_bussiness_order_operate.SUB_USER_ID
     *
     * @return the value of dcdg_bussiness_order_operate.SUB_USER_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getSubUserId() {
        return subUserId;
    }

    /**
     * 数据库字段：操作人子账号IDdcdg_bussiness_order_operate.SUB_USER_ID
     *
     * @param subUserId the value for dcdg_bussiness_order_operate.SUB_USER_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setSubUserId(String subUserId) {
        this.subUserId = subUserId == null ? null : subUserId.trim();
    }

    /**
     * 数据库字段：操作人子账号名称dcdg_bussiness_order_operate.SUB_USER_NAME
     *
     * @return the value of dcdg_bussiness_order_operate.SUB_USER_NAME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getSubUserName() {
        return subUserName;
    }

    /**
     * 数据库字段：操作人子账号名称dcdg_bussiness_order_operate.SUB_USER_NAME
     *
     * @param subUserName the value for dcdg_bussiness_order_operate.SUB_USER_NAME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setSubUserName(String subUserName) {
        this.subUserName = subUserName == null ? null : subUserName.trim();
    }

    /**
     * 数据库字段：创建时间dcdg_bussiness_order_operate.ADD_TIME
     *
     * @return the value of dcdg_bussiness_order_operate.ADD_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：创建时间dcdg_bussiness_order_operate.ADD_TIME
     *
     * @param addTime the value for dcdg_bussiness_order_operate.ADD_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}