package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.UpdateTimeExtra;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_bussiness_customer_account
 *
 * @mbg.generated do_not_delete_during_merge Tue Apr 23 21:29:23 CST 2019
 */
public class CustomerAccount extends UpdateTimeExtra {
    /**
     *   主键（客户表主键）
     *
     * 数据库字段名:dcdg_bussiness_customer_account.CUST_ID
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private String custId;

    /**
     *   登录账号
     *
     * 数据库字段名:dcdg_bussiness_customer_account.LOGIN_NAME
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private String loginName;

    /**
     *   消费金额（人民币）
     *
     * 数据库字段名:dcdg_bussiness_customer_account.CONSUME_RMB
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private Double consumeRmb;

    /**
     *   应返总积分
     *
     * 数据库字段名:dcdg_bussiness_customer_account.TOTAL_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private Double totalPoint;

    /**
     *   应返现金积分
     *
     * 数据库字段名:dcdg_bussiness_customer_account.CASH_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private Double cashPoint;

    /**
     *   应返晨香积分
     *
     * 数据库字段名:dcdg_bussiness_customer_account.CX_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private Double cxPoint;

    /**
     *   应返商城积分
     *
     * 数据库字段名:dcdg_bussiness_customer_account.SHOP_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private Double shopPoint;

    /**
     *   剩余总积分
     *
     * 数据库字段名:dcdg_bussiness_customer_account.SURPLUS_TOTAL_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private Double surplusTotalPoint;

    /**
     *   剩余现金积分
     *
     * 数据库字段名:dcdg_bussiness_customer_account.SURPLUS_CASH_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private Double surplusCashPoint;

    /**
     *   剩余晨香积分
     *
     * 数据库字段名:dcdg_bussiness_customer_account.SURPLUS_CX_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private Double surplusCxPoint;

    /**
     *   剩余商城积分
     *
     * 数据库字段名:dcdg_bussiness_customer_account.SURPLUS_SHOP_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private Double surplusShopPoint;

    /**
     *   已返总积分
     *
     * 数据库字段名:dcdg_bussiness_customer_account.YET_TOTAL_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private Double yetTotalPoint;

    /**
     *   已返现金积分
     *
     * 数据库字段名:dcdg_bussiness_customer_account.YET_CASH_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private Double yetCashPoint;

    /**
     *   已返晨香积分
     *
     * 数据库字段名:dcdg_bussiness_customer_account.YET_CX_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private Double yetCxPoint;

    /**
     *   已返商城积分
     *
     * 数据库字段名:dcdg_bussiness_customer_account.YET_SHOP_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private Double yetShopPoint;

    /**
     *   创建时间
     *
     * 数据库字段名:dcdg_bussiness_customer_account.ADD_TIME
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private Date addTime;

    /**
     *   更新时间
     *
     * 数据库字段名:dcdg_bussiness_customer_account.UPDATE_TIME
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private Date updateTime;

    /**
     *   上级邀请人ID
     *
     * 数据库字段名:dcdg_bussiness_customer_account.TOP_USER_ID
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private String topUserId;

    /**
     *   邀请关系
     *
     * 数据库字段名:dcdg_bussiness_customer_account.INVITE_PATH
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private String invitePath;

    /**
     *   顶级管理人ID
     *
     * 数据库字段名:dcdg_bussiness_customer_account.MANAGE_PHONE
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private String managePhone;

    /**
     *   推荐购买数
     *
     * 数据库字段名:dcdg_bussiness_customer_account.RECO_BUY_COUNT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private Integer recoBuyCount;

    /**
     *   收入
     *
     * 数据库字段名:dcdg_bussiness_customer_account.SELF_BUY_COUNT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private Double selfBuyCount;

    /**
     *   关注量
     *
     * 数据库字段名:dcdg_bussiness_customer_account.TOTAL_FOUCUS_COUNT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    private Integer totalFoucusCount;

    /**
     * 数据库字段：主键（客户表主键）dcdg_bussiness_customer_account.CUST_ID
     *
     * @return  the value of dcdg_bussiness_customer_account.CUST_ID
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：主键（客户表主键）dcdg_bussiness_customer_account.CUST_ID
     * @param custId the value for dcdg_bussiness_customer_account.CUST_ID
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：登录账号dcdg_bussiness_customer_account.LOGIN_NAME
     *
     * @return  the value of dcdg_bussiness_customer_account.LOGIN_NAME
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 数据库字段：登录账号dcdg_bussiness_customer_account.LOGIN_NAME
     * @param loginName the value for dcdg_bussiness_customer_account.LOGIN_NAME
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 数据库字段：消费金额（人民币）dcdg_bussiness_customer_account.CONSUME_RMB
     *
     * @return  the value of dcdg_bussiness_customer_account.CONSUME_RMB
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public Double getConsumeRmb() {
        return consumeRmb;
    }

    /**
     * 数据库字段：消费金额（人民币）dcdg_bussiness_customer_account.CONSUME_RMB
     * @param consumeRmb the value for dcdg_bussiness_customer_account.CONSUME_RMB
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setConsumeRmb(Double consumeRmb) {
        this.consumeRmb = consumeRmb;
    }

    /**
     * 数据库字段：应返总积分dcdg_bussiness_customer_account.TOTAL_POINT
     *
     * @return  the value of dcdg_bussiness_customer_account.TOTAL_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public Double getTotalPoint() {
        return totalPoint;
    }

    /**
     * 数据库字段：应返总积分dcdg_bussiness_customer_account.TOTAL_POINT
     * @param totalPoint the value for dcdg_bussiness_customer_account.TOTAL_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setTotalPoint(Double totalPoint) {
        this.totalPoint = totalPoint;
    }

    /**
     * 数据库字段：应返现金积分dcdg_bussiness_customer_account.CASH_POINT
     *
     * @return  the value of dcdg_bussiness_customer_account.CASH_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public Double getCashPoint() {
        return cashPoint;
    }

    /**
     * 数据库字段：应返现金积分dcdg_bussiness_customer_account.CASH_POINT
     * @param cashPoint the value for dcdg_bussiness_customer_account.CASH_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setCashPoint(Double cashPoint) {
        this.cashPoint = cashPoint;
    }

    /**
     * 数据库字段：应返晨香积分dcdg_bussiness_customer_account.CX_POINT
     *
     * @return  the value of dcdg_bussiness_customer_account.CX_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public Double getCxPoint() {
        return cxPoint;
    }

    /**
     * 数据库字段：应返晨香积分dcdg_bussiness_customer_account.CX_POINT
     * @param cxPoint the value for dcdg_bussiness_customer_account.CX_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setCxPoint(Double cxPoint) {
        this.cxPoint = cxPoint;
    }

    /**
     * 数据库字段：应返商城积分dcdg_bussiness_customer_account.SHOP_POINT
     *
     * @return  the value of dcdg_bussiness_customer_account.SHOP_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public Double getShopPoint() {
        return shopPoint;
    }

    /**
     * 数据库字段：应返商城积分dcdg_bussiness_customer_account.SHOP_POINT
     * @param shopPoint the value for dcdg_bussiness_customer_account.SHOP_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setShopPoint(Double shopPoint) {
        this.shopPoint = shopPoint;
    }

    /**
     * 数据库字段：剩余总积分dcdg_bussiness_customer_account.SURPLUS_TOTAL_POINT
     *
     * @return  the value of dcdg_bussiness_customer_account.SURPLUS_TOTAL_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public Double getSurplusTotalPoint() {
        return surplusTotalPoint;
    }

    /**
     * 数据库字段：剩余总积分dcdg_bussiness_customer_account.SURPLUS_TOTAL_POINT
     * @param surplusTotalPoint the value for dcdg_bussiness_customer_account.SURPLUS_TOTAL_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setSurplusTotalPoint(Double surplusTotalPoint) {
        this.surplusTotalPoint = surplusTotalPoint;
    }

    /**
     * 数据库字段：剩余现金积分dcdg_bussiness_customer_account.SURPLUS_CASH_POINT
     *
     * @return  the value of dcdg_bussiness_customer_account.SURPLUS_CASH_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public Double getSurplusCashPoint() {
        return surplusCashPoint;
    }

    /**
     * 数据库字段：剩余现金积分dcdg_bussiness_customer_account.SURPLUS_CASH_POINT
     * @param surplusCashPoint the value for dcdg_bussiness_customer_account.SURPLUS_CASH_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setSurplusCashPoint(Double surplusCashPoint) {
        this.surplusCashPoint = surplusCashPoint;
    }

    /**
     * 数据库字段：剩余晨香积分dcdg_bussiness_customer_account.SURPLUS_CX_POINT
     *
     * @return  the value of dcdg_bussiness_customer_account.SURPLUS_CX_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public Double getSurplusCxPoint() {
        return surplusCxPoint;
    }

    /**
     * 数据库字段：剩余晨香积分dcdg_bussiness_customer_account.SURPLUS_CX_POINT
     * @param surplusCxPoint the value for dcdg_bussiness_customer_account.SURPLUS_CX_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setSurplusCxPoint(Double surplusCxPoint) {
        this.surplusCxPoint = surplusCxPoint;
    }

    /**
     * 数据库字段：剩余商城积分dcdg_bussiness_customer_account.SURPLUS_SHOP_POINT
     *
     * @return  the value of dcdg_bussiness_customer_account.SURPLUS_SHOP_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public Double getSurplusShopPoint() {
        return surplusShopPoint;
    }

    /**
     * 数据库字段：剩余商城积分dcdg_bussiness_customer_account.SURPLUS_SHOP_POINT
     * @param surplusShopPoint the value for dcdg_bussiness_customer_account.SURPLUS_SHOP_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setSurplusShopPoint(Double surplusShopPoint) {
        this.surplusShopPoint = surplusShopPoint;
    }

    /**
     * 数据库字段：已返总积分dcdg_bussiness_customer_account.YET_TOTAL_POINT
     *
     * @return  the value of dcdg_bussiness_customer_account.YET_TOTAL_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public Double getYetTotalPoint() {
        return yetTotalPoint;
    }

    /**
     * 数据库字段：已返总积分dcdg_bussiness_customer_account.YET_TOTAL_POINT
     * @param yetTotalPoint the value for dcdg_bussiness_customer_account.YET_TOTAL_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setYetTotalPoint(Double yetTotalPoint) {
        this.yetTotalPoint = yetTotalPoint;
    }

    /**
     * 数据库字段：已返现金积分dcdg_bussiness_customer_account.YET_CASH_POINT
     *
     * @return  the value of dcdg_bussiness_customer_account.YET_CASH_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public Double getYetCashPoint() {
        return yetCashPoint;
    }

    /**
     * 数据库字段：已返现金积分dcdg_bussiness_customer_account.YET_CASH_POINT
     * @param yetCashPoint the value for dcdg_bussiness_customer_account.YET_CASH_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setYetCashPoint(Double yetCashPoint) {
        this.yetCashPoint = yetCashPoint;
    }

    /**
     * 数据库字段：已返晨香积分dcdg_bussiness_customer_account.YET_CX_POINT
     *
     * @return  the value of dcdg_bussiness_customer_account.YET_CX_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public Double getYetCxPoint() {
        return yetCxPoint;
    }

    /**
     * 数据库字段：已返晨香积分dcdg_bussiness_customer_account.YET_CX_POINT
     * @param yetCxPoint the value for dcdg_bussiness_customer_account.YET_CX_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setYetCxPoint(Double yetCxPoint) {
        this.yetCxPoint = yetCxPoint;
    }

    /**
     * 数据库字段：已返商城积分dcdg_bussiness_customer_account.YET_SHOP_POINT
     *
     * @return  the value of dcdg_bussiness_customer_account.YET_SHOP_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public Double getYetShopPoint() {
        return yetShopPoint;
    }

    /**
     * 数据库字段：已返商城积分dcdg_bussiness_customer_account.YET_SHOP_POINT
     * @param yetShopPoint the value for dcdg_bussiness_customer_account.YET_SHOP_POINT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setYetShopPoint(Double yetShopPoint) {
        this.yetShopPoint = yetShopPoint;
    }

    /**
     * 数据库字段：创建时间dcdg_bussiness_customer_account.ADD_TIME
     *
     * @return  the value of dcdg_bussiness_customer_account.ADD_TIME
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：创建时间dcdg_bussiness_customer_account.ADD_TIME
     * @param addTime the value for dcdg_bussiness_customer_account.ADD_TIME
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：更新时间dcdg_bussiness_customer_account.UPDATE_TIME
     *
     * @return  the value of dcdg_bussiness_customer_account.UPDATE_TIME
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：更新时间dcdg_bussiness_customer_account.UPDATE_TIME
     * @param updateTime the value for dcdg_bussiness_customer_account.UPDATE_TIME
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 数据库字段：上级邀请人IDdcdg_bussiness_customer_account.TOP_USER_ID
     *
     * @return  the value of dcdg_bussiness_customer_account.TOP_USER_ID
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public String getTopUserId() {
        return topUserId;
    }

    /**
     * 数据库字段：上级邀请人IDdcdg_bussiness_customer_account.TOP_USER_ID
     * @param topUserId the value for dcdg_bussiness_customer_account.TOP_USER_ID
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setTopUserId(String topUserId) {
        this.topUserId = topUserId == null ? null : topUserId.trim();
    }

    /**
     * 数据库字段：邀请关系dcdg_bussiness_customer_account.INVITE_PATH
     *
     * @return  the value of dcdg_bussiness_customer_account.INVITE_PATH
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public String getInvitePath() {
        return invitePath;
    }

    /**
     * 数据库字段：邀请关系dcdg_bussiness_customer_account.INVITE_PATH
     * @param invitePath the value for dcdg_bussiness_customer_account.INVITE_PATH
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setInvitePath(String invitePath) {
        this.invitePath = invitePath == null ? null : invitePath.trim();
    }

    /**
     * 数据库字段：顶级管理人IDdcdg_bussiness_customer_account.MANAGE_PHONE
     *
     * @return  the value of dcdg_bussiness_customer_account.MANAGE_PHONE
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public String getManagePhone() {
        return managePhone;
    }

    /**
     * 数据库字段：顶级管理人IDdcdg_bussiness_customer_account.MANAGE_PHONE
     * @param managePhone the value for dcdg_bussiness_customer_account.MANAGE_PHONE
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setManagePhone(String managePhone) {
        this.managePhone = managePhone == null ? null : managePhone.trim();
    }

    /**
     * 数据库字段：推荐购买数dcdg_bussiness_customer_account.RECO_BUY_COUNT
     *
     * @return  the value of dcdg_bussiness_customer_account.RECO_BUY_COUNT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public Integer getRecoBuyCount() {
        return recoBuyCount;
    }

    /**
     * 数据库字段：推荐购买数dcdg_bussiness_customer_account.RECO_BUY_COUNT
     * @param recoBuyCount the value for dcdg_bussiness_customer_account.RECO_BUY_COUNT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setRecoBuyCount(Integer recoBuyCount) {
        this.recoBuyCount = recoBuyCount;
    }

    /**
     * 数据库字段：收入dcdg_bussiness_customer_account.SELF_BUY_COUNT
     *
     * @return  the value of dcdg_bussiness_customer_account.SELF_BUY_COUNT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public Double getSelfBuyCount() {
        return selfBuyCount;
    }

    /**
     * 数据库字段：收入dcdg_bussiness_customer_account.SELF_BUY_COUNT
     * @param selfBuyCount the value for dcdg_bussiness_customer_account.SELF_BUY_COUNT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setSelfBuyCount(Double selfBuyCount) {
        this.selfBuyCount = selfBuyCount;
    }

    /**
     * 数据库字段：关注量dcdg_bussiness_customer_account.TOTAL_FOUCUS_COUNT
     *
     * @return  the value of dcdg_bussiness_customer_account.TOTAL_FOUCUS_COUNT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public Integer getTotalFoucusCount() {
        return totalFoucusCount;
    }

    /**
     * 数据库字段：关注量dcdg_bussiness_customer_account.TOTAL_FOUCUS_COUNT
     * @param totalFoucusCount the value for dcdg_bussiness_customer_account.TOTAL_FOUCUS_COUNT
     *
     * @mbg.generated Tue Apr 23 21:29:23 CST 2019
     */
    public void setTotalFoucusCount(Integer totalFoucusCount) {
        this.totalFoucusCount = totalFoucusCount;
    }
}