package com.louquanapp.req;


import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/8/26 18:31
 * @description:
 */
public class ReqAddCoupon extends ReqToken {

    /**
     *   主键
     *
     * 数据库字段名:dcdg_basic_coupon_base.COUPON_ID
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    private String couponId;

    /**
     *   优惠券名称
     *
     * 数据库字段名:dcdg_basic_coupon_base.COUPON_NAME
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    @NotBlank(message = "优惠券名称不能为空！")
    private String couponName;

    /**
     *   logo
     *
     * 数据库字段名:dcdg_basic_coupon_base.COUPON_LOGO
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */

    private String couponLogo;

    /**
     *   类型[1-商品优惠 2-店铺优惠]
     *
     * 数据库字段名:dcdg_basic_coupon_base.COUPON_TYPE
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    @NotNull(message = "类型不能为空！")
    @Range(min = 1,max = 2,message = " 类型范围[1-商品优惠 2-店铺优惠]")
    private Byte couponType;

    /**
     *   优惠方式[1-满减 2-折扣]
     *
     * 数据库字段名:dcdg_basic_coupon_base.COUPON_STYLE
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */

    private Byte couponStyle;

    /**
     *   获取方式[1-派送 2-领取]
     *
     * 数据库字段名:dcdg_basic_coupon_base.HAVE_TYPE
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    @NotNull(message = " 获取方式不能为空！")
    @Range(min = 1,max = 2,message = " 获取方式范围[1-派送 2-领取]")
    private Byte haveType;

    /**
     *   限领数量
     *
     * 数据库字段名:dcdg_basic_coupon_base.HAVE_NUM
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    private Byte haveNum;

    /**
     *   发行量
     *
     * 数据库字段名:dcdg_basic_coupon_base.SEND_COUNT
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    private Integer sendCount;

    /**
     *   优惠方式[1-折扣 2-满减]
     *
     * 数据库字段名:dcdg_basic_coupon_base.COUPON_MONEY_TYPE
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */

    private Byte couponMoneyType;

    /**
     *   用户[1-所有 2-个人]
     *
     * 数据库字段名:dcdg_basic_coupon_base.SEND_TYPE
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    private Byte sendType;

    /**
     *   优惠金额/折扣
     *
     * 数据库字段名:dcdg_basic_coupon_base.COUPON_MONEY
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    @NotNull(message = "优惠金额/折扣不能为空！")
    private Double couponMoney;

    /**
     *   最低消费
     *
     * 数据库字段名:dcdg_basic_coupon_base.MIN_MONEY
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    @NotNull(message = "最低消费不能为空！")
    private Double minMoney;

    /**
     *   优惠商品/门店
     *
     * 数据库字段名:dcdg_basic_coupon_base.COUPON_CONENT
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    private String couponConent;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_basic_coupon_base.ADD_TIME
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    private Date addTime;

    /**
     *   添加ID
     *
     * 数据库字段名:dcdg_basic_coupon_base.ADD_USER
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    private String addUser;

    /**
     *   添加人
     *
     * 数据库字段名:dcdg_basic_coupon_base.ADD_USER_NAME
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    private String addUserName;

    /**
     *   有效开始日期
     *
     * 数据库字段名:dcdg_basic_coupon_base.START_TIME
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    private Date startTime;

    /**
     *   有效结束日期
     *
     * 数据库字段名:dcdg_basic_coupon_base.DIE_TIME
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    private Date dieTime;

    /**
     *   优惠劵使用方式[1-线上 2-线下]
     *
     * 数据库字段名:dcdg_basic_coupon_base.COUPON_WAY
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    @NotNull(message = " 优惠劵使用方式不能为空！")
    @Range(min = 1,max = 2,message = " 优惠方式范围[1-线上 2-线下]")
    private Byte couponWay;

    /**
     *   使用说明
     *
     * 数据库字段名:dcdg_basic_coupon_base.EXPLAIN
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    @NotBlank(message = "使用说明不能为空！")
    private String explain;

    /**
     * 数据库字段：主键dcdg_basic_coupon_base.COUPON_ID
     *
     * @return  the value of dcdg_basic_coupon_base.COUPON_ID
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public String getCouponId() {
        return couponId;
    }

    /**
     * 数据库字段：主键dcdg_basic_coupon_base.COUPON_ID
     * @param couponId the value for dcdg_basic_coupon_base.COUPON_ID
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    /**
     * 数据库字段：优惠券名称dcdg_basic_coupon_base.COUPON_NAME
     *
     * @return  the value of dcdg_basic_coupon_base.COUPON_NAME
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public String getCouponName() {
        return couponName;
    }

    /**
     * 数据库字段：优惠券名称dcdg_basic_coupon_base.COUPON_NAME
     * @param couponName the value for dcdg_basic_coupon_base.COUPON_NAME
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public void setCouponName(String couponName) {
        this.couponName = couponName == null ? null : couponName.trim();
    }

    /**
     * 数据库字段：logodcdg_basic_coupon_base.COUPON_LOGO
     *
     * @return  the value of dcdg_basic_coupon_base.COUPON_LOGO
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public String getCouponLogo() {
        return couponLogo;
    }

    /**
     * 数据库字段：logodcdg_basic_coupon_base.COUPON_LOGO
     * @param couponLogo the value for dcdg_basic_coupon_base.COUPON_LOGO
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public void setCouponLogo(String couponLogo) {
        this.couponLogo = couponLogo == null ? null : couponLogo.trim();
    }

    /**
     * 数据库字段：类型[1-商品优惠 2-店铺优惠 3-全场通用]dcdg_basic_coupon_base.COUPON_TYPE
     *
     * @return  the value of dcdg_basic_coupon_base.COUPON_TYPE
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public Byte getCouponType() {
        return couponType;
    }

    /**
     * 数据库字段：类型[1-商品优惠 2-店铺优惠 3-全场通用]dcdg_basic_coupon_base.COUPON_TYPE
     * @param couponType the value for dcdg_basic_coupon_base.COUPON_TYPE
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public void setCouponType(Byte couponType) {
        this.couponType = couponType;
    }

    /**
     * 数据库字段：优惠方式[1-满减 2-折扣]dcdg_basic_coupon_base.COUPON_STYLE
     *
     * @return  the value of dcdg_basic_coupon_base.COUPON_STYLE
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public Byte getCouponStyle() {
        return couponStyle;
    }

    /**
     * 数据库字段：优惠方式[1-满减 2-折扣]dcdg_basic_coupon_base.COUPON_STYLE
     * @param couponStyle the value for dcdg_basic_coupon_base.COUPON_STYLE
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public void setCouponStyle(Byte couponStyle) {
        this.couponStyle = couponStyle;
    }

    /**
     * 数据库字段：获取方式[1-派送 2-领取]dcdg_basic_coupon_base.HAVE_TYPE
     *
     * @return  the value of dcdg_basic_coupon_base.HAVE_TYPE
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public Byte getHaveType() {
        return haveType;
    }

    /**
     * 数据库字段：获取方式[1-派送 2-领取]dcdg_basic_coupon_base.HAVE_TYPE
     * @param haveType the value for dcdg_basic_coupon_base.HAVE_TYPE
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public void setHaveType(Byte haveType) {
        this.haveType = haveType;
    }

    /**
     * 数据库字段：限领数量dcdg_basic_coupon_base.HAVE_NUM
     *
     * @return  the value of dcdg_basic_coupon_base.HAVE_NUM
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public Byte getHaveNum() {
        return haveNum;
    }

    /**
     * 数据库字段：限领数量dcdg_basic_coupon_base.HAVE_NUM
     * @param haveNum the value for dcdg_basic_coupon_base.HAVE_NUM
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public void setHaveNum(Byte haveNum) {
        this.haveNum = haveNum;
    }

    /**
     * 数据库字段：发行量dcdg_basic_coupon_base.SEND_COUNT
     *
     * @return  the value of dcdg_basic_coupon_base.SEND_COUNT
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public Integer getSendCount() {
        return sendCount;
    }

    /**
     * 数据库字段：发行量dcdg_basic_coupon_base.SEND_COUNT
     * @param sendCount the value for dcdg_basic_coupon_base.SEND_COUNT
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public void setSendCount(Integer sendCount) {
        this.sendCount = sendCount;
    }

    /**
     * 数据库字段：优惠方式[1-折扣 2-满减]dcdg_basic_coupon_base.COUPON_MONEY_TYPE
     *
     * @return  the value of dcdg_basic_coupon_base.COUPON_MONEY_TYPE
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public Byte getCouponMoneyType() {
        return couponMoneyType;
    }

    /**
     * 数据库字段：优惠方式[1-折扣 2-满减]dcdg_basic_coupon_base.COUPON_MONEY_TYPE
     * @param couponMoneyType the value for dcdg_basic_coupon_base.COUPON_MONEY_TYPE
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public void setCouponMoneyType(Byte couponMoneyType) {
        this.couponMoneyType = couponMoneyType;
    }

    /**
     * 数据库字段：用户[1-所有 2-个人]dcdg_basic_coupon_base.SEND_TYPE
     *
     * @return  the value of dcdg_basic_coupon_base.SEND_TYPE
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public Byte getSendType() {
        return sendType;
    }

    /**
     * 数据库字段：用户[1-所有 2-个人]dcdg_basic_coupon_base.SEND_TYPE
     * @param sendType the value for dcdg_basic_coupon_base.SEND_TYPE
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public void setSendType(Byte sendType) {
        this.sendType = sendType;
    }

    /**
     * 数据库字段：优惠金额/折扣dcdg_basic_coupon_base.COUPON_MONEY
     *
     * @return  the value of dcdg_basic_coupon_base.COUPON_MONEY
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public Double getCouponMoney() {
        return couponMoney;
    }

    /**
     * 数据库字段：优惠金额/折扣dcdg_basic_coupon_base.COUPON_MONEY
     * @param couponMoney the value for dcdg_basic_coupon_base.COUPON_MONEY
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public void setCouponMoney(Double couponMoney) {
        this.couponMoney = couponMoney;
    }

    /**
     * 数据库字段：最低消费dcdg_basic_coupon_base.MIN_MONEY
     *
     * @return  the value of dcdg_basic_coupon_base.MIN_MONEY
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public Double getMinMoney() {
        return minMoney;
    }

    /**
     * 数据库字段：最低消费dcdg_basic_coupon_base.MIN_MONEY
     * @param minMoney the value for dcdg_basic_coupon_base.MIN_MONEY
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public void setMinMoney(Double minMoney) {
        this.minMoney = minMoney;
    }

    /**
     * 数据库字段：优惠商品/门店dcdg_basic_coupon_base.COUPON_CONENT
     *
     * @return  the value of dcdg_basic_coupon_base.COUPON_CONENT
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public String getCouponConent() {
        return couponConent;
    }

    /**
     * 数据库字段：优惠商品/门店dcdg_basic_coupon_base.COUPON_CONENT
     * @param couponConent the value for dcdg_basic_coupon_base.COUPON_CONENT
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public void setCouponConent(String couponConent) {
        this.couponConent = couponConent == null ? null : couponConent.trim();
    }

    /**
     * 数据库字段：添加时间dcdg_basic_coupon_base.ADD_TIME
     *
     * @return  the value of dcdg_basic_coupon_base.ADD_TIME
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_basic_coupon_base.ADD_TIME
     * @param addTime the value for dcdg_basic_coupon_base.ADD_TIME
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：添加IDdcdg_basic_coupon_base.ADD_USER
     *
     * @return  the value of dcdg_basic_coupon_base.ADD_USER
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public String getAddUser() {
        return addUser;
    }

    /**
     * 数据库字段：添加IDdcdg_basic_coupon_base.ADD_USER
     * @param addUser the value for dcdg_basic_coupon_base.ADD_USER
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public void setAddUser(String addUser) {
        this.addUser = addUser == null ? null : addUser.trim();
    }

    /**
     * 数据库字段：添加人dcdg_basic_coupon_base.ADD_USER_NAME
     *
     * @return  the value of dcdg_basic_coupon_base.ADD_USER_NAME
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public String getAddUserName() {
        return addUserName;
    }

    /**
     * 数据库字段：添加人dcdg_basic_coupon_base.ADD_USER_NAME
     * @param addUserName the value for dcdg_basic_coupon_base.ADD_USER_NAME
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName == null ? null : addUserName.trim();
    }

    /**
     * 数据库字段：有效开始日期dcdg_basic_coupon_base.START_TIME
     *
     * @return  the value of dcdg_basic_coupon_base.START_TIME
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 数据库字段：有效开始日期dcdg_basic_coupon_base.START_TIME
     * @param startTime the value for dcdg_basic_coupon_base.START_TIME
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 数据库字段：有效结束日期dcdg_basic_coupon_base.DIE_TIME
     *
     * @return  the value of dcdg_basic_coupon_base.DIE_TIME
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public Date getDieTime() {
        return dieTime;
    }

    /**
     * 数据库字段：有效结束日期dcdg_basic_coupon_base.DIE_TIME
     * @param dieTime the value for dcdg_basic_coupon_base.DIE_TIME
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public void setDieTime(Date dieTime) {
        this.dieTime = dieTime;
    }

    /**
     * 数据库字段：优惠劵使用方式[1-线上 2-线下]dcdg_basic_coupon_base.COUPON_WAY
     *
     * @return  the value of dcdg_basic_coupon_base.COUPON_WAY
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public Byte getCouponWay() {
        return couponWay;
    }

    /**
     * 数据库字段：优惠劵使用方式[1-线上 2-线下]dcdg_basic_coupon_base.COUPON_WAY
     * @param couponWay the value for dcdg_basic_coupon_base.COUPON_WAY
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public void setCouponWay(Byte couponWay) {
        this.couponWay = couponWay;
    }

    /**
     * 数据库字段：使用说明dcdg_basic_coupon_base.EXPLAIN
     *
     * @return  the value of dcdg_basic_coupon_base.EXPLAIN
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public String getExplain() {
        return explain;
    }

    /**
     * 数据库字段：使用说明dcdg_basic_coupon_base.EXPLAIN
     * @param explain the value for dcdg_basic_coupon_base.EXPLAIN
     *
     * @mbg.generated Fri Jun 28 16:50:36 CST 2019
     */
    public void setExplain(String explain) {
        this.explain = explain == null ? null : explain.trim();
    }

    private String custIds;

    public String getCustIds() {
        return custIds;
    }

    public void setCustIds(String custIds) {
        this.custIds = custIds;
    }
}
