package com.louquanapp.dao.model;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_bussiness_customer_point
 *
 * @mbg.generated do_not_delete_during_merge Wed Apr 10 17:27:32 CST 2019
 */
public class CustomerPoint {
    /**
     * 主键
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_point.POINT_ID
     *
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    private String pointId;

    /**
     * 顾客ID
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_point.CUST_ID
     *
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    private String custId;

    /**
     * 获得积分值
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_point.POINT_VALUE
     *
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    private Double pointValue;

    /**
     * 获得类型[1-获得 2-消费]
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_point.GAIN_TYPE
     *
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    private Byte gainType;

    /**
     * 积分描述
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_point.POINT_DESC
     *
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    private String pointDesc;

    /**
     * 获取时间
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_point.ADD_TIME
     *
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    private Date addTime;

    /**
     * 积分类型[1-余额 3-积分]
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_point.POINT_TYPE
     *
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    private Byte pointType;

    /**
     * 资源类型[1-商城订单 2-其他订单 3-邀请注册赠送 4-邀请首次消费赠送 5-游戏赠送]
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_point.SOURCE_TYPE
     *
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    private Byte sourceType;

    /**
     * 资源ID
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_point.SOURCE_ID
     *
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    private String sourceId;

    /**
     * 审核人
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_point.AUDIT_USER
     *
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    private String auditUser;

    /**
     * 审核人名称
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_point.AUDIT_USER_NAME
     *
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    private String auditUserName;

    /**
     * 审核时间
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_point.AUDIT_TIME
     *
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    private Date auditTime;

    /**
     * 审核信息
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_point.REFUSE_REASON
     *
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    private String refuseReason;

    /**
     * 审核状态[1-待审核 2-审核通过 3-审核不通过]
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_point.AUDIT_STATUS
     *
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    private Byte auditStatus;

    /**
     * 数据库字段：主键dcdg_bussiness_customer_point.POINT_ID
     *
     * @return the value of dcdg_bussiness_customer_point.POINT_ID
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public String getPointId() {
        return pointId;
    }

    /**
     * 数据库字段：主键dcdg_bussiness_customer_point.POINT_ID
     *
     * @param pointId the value for dcdg_bussiness_customer_point.POINT_ID
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public void setPointId(String pointId) {
        this.pointId = pointId == null ? null : pointId.trim();
    }

    /**
     * 数据库字段：顾客IDdcdg_bussiness_customer_point.CUST_ID
     *
     * @return the value of dcdg_bussiness_customer_point.CUST_ID
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：顾客IDdcdg_bussiness_customer_point.CUST_ID
     *
     * @param custId the value for dcdg_bussiness_customer_point.CUST_ID
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：获得积分值dcdg_bussiness_customer_point.POINT_VALUE
     *
     * @return the value of dcdg_bussiness_customer_point.POINT_VALUE
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public Double getPointValue() {
        return pointValue;
    }

    /**
     * 数据库字段：获得积分值dcdg_bussiness_customer_point.POINT_VALUE
     *
     * @param pointValue the value for dcdg_bussiness_customer_point.POINT_VALUE
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public void setPointValue(Double pointValue) {
        this.pointValue = pointValue;
    }

    /**
     * 数据库字段：获得类型[1-获得 2-消费]dcdg_bussiness_customer_point.GAIN_TYPE
     *
     * @return the value of dcdg_bussiness_customer_point.GAIN_TYPE
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public Byte getGainType() {
        return gainType;
    }

    /**
     * 数据库字段：获得类型[1-获得 2-消费]dcdg_bussiness_customer_point.GAIN_TYPE
     *
     * @param gainType the value for dcdg_bussiness_customer_point.GAIN_TYPE
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public void setGainType(Byte gainType) {
        this.gainType = gainType;
    }

    /**
     * 数据库字段：积分描述dcdg_bussiness_customer_point.POINT_DESC
     *
     * @return the value of dcdg_bussiness_customer_point.POINT_DESC
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public String getPointDesc() {
        return pointDesc;
    }

    /**
     * 数据库字段：积分描述dcdg_bussiness_customer_point.POINT_DESC
     *
     * @param pointDesc the value for dcdg_bussiness_customer_point.POINT_DESC
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public void setPointDesc(String pointDesc) {
        this.pointDesc = pointDesc == null ? null : pointDesc.trim();
    }

    /**
     * 数据库字段：获取时间dcdg_bussiness_customer_point.ADD_TIME
     *
     * @return the value of dcdg_bussiness_customer_point.ADD_TIME
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：获取时间dcdg_bussiness_customer_point.ADD_TIME
     *
     * @param addTime the value for dcdg_bussiness_customer_point.ADD_TIME
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：积分类型[1-余额 3-积分]dcdg_bussiness_customer_point.POINT_TYPE
     *
     * @return the value of dcdg_bussiness_customer_point.POINT_TYPE
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public Byte getPointType() {
        return pointType;
    }

    /**
     * 数据库字段：积分类型[1-余额 3-积分]dcdg_bussiness_customer_point.POINT_TYPE
     *
     * @param pointType the value for dcdg_bussiness_customer_point.POINT_TYPE
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public void setPointType(Byte pointType) {
        this.pointType = pointType;
    }

    /**
     * 数据库字段：资源类型[1-商城订单 2-其他订单 3-邀请注册赠送 4-邀请首次消费赠送 5-游戏赠送]dcdg_bussiness_customer_point.SOURCE_TYPE
     *
     * @return the value of dcdg_bussiness_customer_point.SOURCE_TYPE
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public Byte getSourceType() {
        return sourceType;
    }

    /**
     * 数据库字段：资源类型[1-商城订单 2-其他订单 3-邀请注册赠送 4-邀请首次消费赠送 5-游戏赠送]dcdg_bussiness_customer_point.SOURCE_TYPE
     *
     * @param sourceType the value for dcdg_bussiness_customer_point.SOURCE_TYPE
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public void setSourceType(Byte sourceType) {
        this.sourceType = sourceType;
    }

    /**
     * 数据库字段：资源IDdcdg_bussiness_customer_point.SOURCE_ID
     *
     * @return the value of dcdg_bussiness_customer_point.SOURCE_ID
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * 数据库字段：资源IDdcdg_bussiness_customer_point.SOURCE_ID
     *
     * @param sourceId the value for dcdg_bussiness_customer_point.SOURCE_ID
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    /**
     * 数据库字段：审核人dcdg_bussiness_customer_point.AUDIT_USER
     *
     * @return the value of dcdg_bussiness_customer_point.AUDIT_USER
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public String getAuditUser() {
        return auditUser;
    }

    /**
     * 数据库字段：审核人dcdg_bussiness_customer_point.AUDIT_USER
     *
     * @param auditUser the value for dcdg_bussiness_customer_point.AUDIT_USER
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser == null ? null : auditUser.trim();
    }

    /**
     * 数据库字段：审核人名称dcdg_bussiness_customer_point.AUDIT_USER_NAME
     *
     * @return the value of dcdg_bussiness_customer_point.AUDIT_USER_NAME
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public String getAuditUserName() {
        return auditUserName;
    }

    /**
     * 数据库字段：审核人名称dcdg_bussiness_customer_point.AUDIT_USER_NAME
     *
     * @param auditUserName the value for dcdg_bussiness_customer_point.AUDIT_USER_NAME
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public void setAuditUserName(String auditUserName) {
        this.auditUserName = auditUserName == null ? null : auditUserName.trim();
    }

    /**
     * 数据库字段：审核时间dcdg_bussiness_customer_point.AUDIT_TIME
     *
     * @return the value of dcdg_bussiness_customer_point.AUDIT_TIME
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 数据库字段：审核时间dcdg_bussiness_customer_point.AUDIT_TIME
     *
     * @param auditTime the value for dcdg_bussiness_customer_point.AUDIT_TIME
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 数据库字段：审核信息dcdg_bussiness_customer_point.REFUSE_REASON
     *
     * @return the value of dcdg_bussiness_customer_point.REFUSE_REASON
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public String getRefuseReason() {
        return refuseReason;
    }

    /**
     * 数据库字段：审核信息dcdg_bussiness_customer_point.REFUSE_REASON
     *
     * @param refuseReason the value for dcdg_bussiness_customer_point.REFUSE_REASON
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason == null ? null : refuseReason.trim();
    }

    /**
     * 数据库字段：审核状态[1-待审核 2-审核通过 3-审核不通过]dcdg_bussiness_customer_point.AUDIT_STATUS
     *
     * @return the value of dcdg_bussiness_customer_point.AUDIT_STATUS
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public Byte getAuditStatus() {
        return auditStatus;
    }

    /**
     * 数据库字段：审核状态[1-待审核 2-审核通过 3-审核不通过]dcdg_bussiness_customer_point.AUDIT_STATUS
     *
     * @param auditStatus the value for dcdg_bussiness_customer_point.AUDIT_STATUS
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     *类型【1-积分 2-余额】
     */
    public Byte pointMold;

    public Byte getPointMold() {
        return pointMold;
    }

    public void setPointMold(Byte pointMold) {
        this.pointMold = pointMold;
    }
}