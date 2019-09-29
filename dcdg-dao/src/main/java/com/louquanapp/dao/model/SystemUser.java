package com.louquanapp.dao.model;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 andji_system_user_base
 *
 * @mbg.generated do_not_delete_during_merge Wed Sep 25 18:44:24 CST 2019
 */
public class SystemUser extends Shop{
    /**
     *   用户编号
     *
     * 数据库字段名:andji_system_user_base.USER_ID
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    private String userId;

    /**
     *   登录账号
     *
     * 数据库字段名:andji_system_user_base.USER_ACCT
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    private String userAcct;

    /**
     *   用户姓名
     *
     * 数据库字段名:andji_system_user_base.USER_NAME
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    private String userName;

    /**
     *   登录密码
     *
     * 数据库字段名:andji_system_user_base.USER_PWD
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    private String userPwd;

    /**
     *   是否有效 [1-有效 2-无效]
     *
     * 数据库字段名:andji_system_user_base.ACTIVE_FLAG
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    private Byte activeFlag;

    /**
     *   默认主题
     *
     * 数据库字段名:andji_system_user_base.DFT_THEME
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    private String dftTheme;

    /**
     *   创建时间
     *
     * 数据库字段名:andji_system_user_base.CREATE_TIME
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    private Date createTime;

    /**
     *   账户类型 [1-后台 2-商家]
     *
     * 数据库字段名:andji_system_user_base.PC_ONLINE_FLAG
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    private Byte pcOnlineFlag;

    /**
     *   登错次数
     *
     * 数据库字段名:andji_system_user_base.ERR_COUNT
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    private Byte errCount;

    /**
     *   登错时间
     *
     * 数据库字段名:andji_system_user_base.ERR_TIME
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    private Date errTime;

    /**
     *   商铺id
     *
     * 数据库字段名:andji_system_user_base.JPUSH_REG_ID
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    private String jpushRegId;

    /**
     *   所在部门
     *
     * 数据库字段名:andji_system_user_base.ORG_NAME
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    private String orgName;

    /**
     *   办公室电话
     *
     * 数据库字段名:andji_system_user_base.ORG_PHONE
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    private String orgPhone;

    /**
     *   头像
     *
     * 数据库字段名:andji_system_user_base.HEAD_IMG
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    private String headImg;

    /**
     *   关联前台用户Id
     *
     * 数据库字段名:andji_system_user_base.CUST_ID
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    private String custId;

    /**
     *   余额
     *
     * 数据库字段名:andji_system_user_base.CONSUME_POINT
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    private Double consumePoint;

    /**
     *   积分
     *
     * 数据库字段名:andji_system_user_base.DEDUCTION_POINT
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    private Double deductionPoint;

    /**
     *   关联级别[1-一级 2-二级 3-三级]
     *
     * 数据库字段名:andji_system_user_base.RELATION_LEVEL
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    private Byte relationLevel;

    /**
     * 数据库字段：用户编号andji_system_user_base.USER_ID
     *
     * @return  the value of andji_system_user_base.USER_ID
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 数据库字段：用户编号andji_system_user_base.USER_ID
     * @param userId the value for andji_system_user_base.USER_ID
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 数据库字段：登录账号andji_system_user_base.USER_ACCT
     *
     * @return  the value of andji_system_user_base.USER_ACCT
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public String getUserAcct() {
        return userAcct;
    }

    /**
     * 数据库字段：登录账号andji_system_user_base.USER_ACCT
     * @param userAcct the value for andji_system_user_base.USER_ACCT
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct == null ? null : userAcct.trim();
    }

    /**
     * 数据库字段：用户姓名andji_system_user_base.USER_NAME
     *
     * @return  the value of andji_system_user_base.USER_NAME
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 数据库字段：用户姓名andji_system_user_base.USER_NAME
     * @param userName the value for andji_system_user_base.USER_NAME
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 数据库字段：登录密码andji_system_user_base.USER_PWD
     *
     * @return  the value of andji_system_user_base.USER_PWD
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * 数据库字段：登录密码andji_system_user_base.USER_PWD
     * @param userPwd the value for andji_system_user_base.USER_PWD
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    /**
     * 数据库字段：是否有效 [1-有效 2-无效]andji_system_user_base.ACTIVE_FLAG
     *
     * @return  the value of andji_system_user_base.ACTIVE_FLAG
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public Byte getActiveFlag() {
        return activeFlag;
    }

    /**
     * 数据库字段：是否有效 [1-有效 2-无效]andji_system_user_base.ACTIVE_FLAG
     * @param activeFlag the value for andji_system_user_base.ACTIVE_FLAG
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public void setActiveFlag(Byte activeFlag) {
        this.activeFlag = activeFlag;
    }

    /**
     * 数据库字段：默认主题andji_system_user_base.DFT_THEME
     *
     * @return  the value of andji_system_user_base.DFT_THEME
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public String getDftTheme() {
        return dftTheme;
    }

    /**
     * 数据库字段：默认主题andji_system_user_base.DFT_THEME
     * @param dftTheme the value for andji_system_user_base.DFT_THEME
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public void setDftTheme(String dftTheme) {
        this.dftTheme = dftTheme == null ? null : dftTheme.trim();
    }

    /**
     * 数据库字段：创建时间andji_system_user_base.CREATE_TIME
     *
     * @return  the value of andji_system_user_base.CREATE_TIME
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 数据库字段：创建时间andji_system_user_base.CREATE_TIME
     * @param createTime the value for andji_system_user_base.CREATE_TIME
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 数据库字段：账户类型 [1-后台 2-商家]andji_system_user_base.PC_ONLINE_FLAG
     *
     * @return  the value of andji_system_user_base.PC_ONLINE_FLAG
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public Byte getPcOnlineFlag() {
        return pcOnlineFlag;
    }

    /**
     * 数据库字段：账户类型 [1-后台 2-商家]andji_system_user_base.PC_ONLINE_FLAG
     * @param pcOnlineFlag the value for andji_system_user_base.PC_ONLINE_FLAG
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public void setPcOnlineFlag(Byte pcOnlineFlag) {
        this.pcOnlineFlag = pcOnlineFlag;
    }

    /**
     * 数据库字段：登错次数andji_system_user_base.ERR_COUNT
     *
     * @return  the value of andji_system_user_base.ERR_COUNT
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public Byte getErrCount() {
        return errCount;
    }

    /**
     * 数据库字段：登错次数andji_system_user_base.ERR_COUNT
     * @param errCount the value for andji_system_user_base.ERR_COUNT
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public void setErrCount(Byte errCount) {
        this.errCount = errCount;
    }

    /**
     * 数据库字段：登错时间andji_system_user_base.ERR_TIME
     *
     * @return  the value of andji_system_user_base.ERR_TIME
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public Date getErrTime() {
        return errTime;
    }

    /**
     * 数据库字段：登错时间andji_system_user_base.ERR_TIME
     * @param errTime the value for andji_system_user_base.ERR_TIME
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public void setErrTime(Date errTime) {
        this.errTime = errTime;
    }

    /**
     * 数据库字段：商铺idandji_system_user_base.JPUSH_REG_ID
     *
     * @return  the value of andji_system_user_base.JPUSH_REG_ID
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public String getJpushRegId() {
        return jpushRegId;
    }

    /**
     * 数据库字段：商铺idandji_system_user_base.JPUSH_REG_ID
     * @param jpushRegId the value for andji_system_user_base.JPUSH_REG_ID
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public void setJpushRegId(String jpushRegId) {
        this.jpushRegId = jpushRegId == null ? null : jpushRegId.trim();
    }

    /**
     * 数据库字段：所在部门andji_system_user_base.ORG_NAME
     *
     * @return  the value of andji_system_user_base.ORG_NAME
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 数据库字段：所在部门andji_system_user_base.ORG_NAME
     * @param orgName the value for andji_system_user_base.ORG_NAME
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    /**
     * 数据库字段：办公室电话andji_system_user_base.ORG_PHONE
     *
     * @return  the value of andji_system_user_base.ORG_PHONE
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public String getOrgPhone() {
        return orgPhone;
    }

    /**
     * 数据库字段：办公室电话andji_system_user_base.ORG_PHONE
     * @param orgPhone the value for andji_system_user_base.ORG_PHONE
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone == null ? null : orgPhone.trim();
    }

    /**
     * 数据库字段：头像andji_system_user_base.HEAD_IMG
     *
     * @return  the value of andji_system_user_base.HEAD_IMG
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public String getHeadImg() {
        return headImg;
    }

    /**
     * 数据库字段：头像andji_system_user_base.HEAD_IMG
     * @param headImg the value for andji_system_user_base.HEAD_IMG
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    /**
     * 数据库字段：关联前台用户Idandji_system_user_base.CUST_ID
     *
     * @return  the value of andji_system_user_base.CUST_ID
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：关联前台用户Idandji_system_user_base.CUST_ID
     * @param custId the value for andji_system_user_base.CUST_ID
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：余额andji_system_user_base.CONSUME_POINT
     *
     * @return  the value of andji_system_user_base.CONSUME_POINT
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public Double getConsumePoint() {
        return consumePoint;
    }

    /**
     * 数据库字段：余额andji_system_user_base.CONSUME_POINT
     * @param consumePoint the value for andji_system_user_base.CONSUME_POINT
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public void setConsumePoint(Double consumePoint) {
        this.consumePoint = consumePoint;
    }

    /**
     * 数据库字段：积分andji_system_user_base.DEDUCTION_POINT
     *
     * @return  the value of andji_system_user_base.DEDUCTION_POINT
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public Double getDeductionPoint() {
        return deductionPoint;
    }

    /**
     * 数据库字段：积分andji_system_user_base.DEDUCTION_POINT
     * @param deductionPoint the value for andji_system_user_base.DEDUCTION_POINT
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public void setDeductionPoint(Double deductionPoint) {
        this.deductionPoint = deductionPoint;
    }

    /**
     * 数据库字段：关联级别[1-一级 2-二级 3-三级]andji_system_user_base.RELATION_LEVEL
     *
     * @return  the value of andji_system_user_base.RELATION_LEVEL
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public Byte getRelationLevel() {
        return relationLevel;
    }

    /**
     * 数据库字段：关联级别[1-一级 2-二级 3-三级]andji_system_user_base.RELATION_LEVEL
     * @param relationLevel the value for andji_system_user_base.RELATION_LEVEL
     *
     * @mbg.generated Wed Sep 25 18:44:24 CST 2019
     */
    public void setRelationLevel(Byte relationLevel) {
        this.relationLevel = relationLevel;
    }
}