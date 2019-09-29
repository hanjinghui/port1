package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.CustomerExtra;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_bussiness_customer_base
 *
 * @mbg.generated do_not_delete_during_merge Thu Mar 28 11:18:11 CST 2019
 */
public class Customer extends CustomerExtra {
    /**
     * 主键
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.CUST_ID
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String custId;

    /**
     * 客户类型[1-普通会员  7-商家 9-合作管理 11-县(区)管理 15-省级代理 16-合伙人]
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.CUST_TYPE
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Integer custType;

    /**
     * 登录账号
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.LOGIN_NAME
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String loginName;

    /**
     * 登录密码
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.LOGIN_PWD
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String loginPwd;

    /**
     * 手机号
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.CUST_PHONE
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String custPhone;

    /**
     * 性别[1-男 2-女 3-未知 4-保密]
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.CUST_SEX
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Byte custSex;

    /**
     * 支付密码
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.PAY_PWD
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String payPwd;

    /**
     * 支付校验方式[1-支付密码 2-短信验证]
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.PAY_CHECK_WAY
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Byte payCheckWay;

    /**
     * 所在区域路径
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.AREA_PATH
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String areaPath;

    /**
     * 邮箱
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.CUST_EMAIL
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String custEmail;

    /**
     * 昵称
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.NICK_NAME
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String nickName;

    /**
     * 真实姓名
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.REAL_NAME
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String realName;

    /**
     * 身份证号
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.ID_CARD
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String idCard;

    /**
     * 身份证正面
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.FRONT_ID_CARD
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String frontIdCard;

    /**
     * 身份证反面
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.END_ID_CARD
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String endIdCard;

    /**
     * 实名认证时间
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.AUTH_TIME
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Date authTime;

    /**
     * 实名认证审核信息
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.AUTH_INFO
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String authInfo;

    /**
     * 实名认证状态[2-待认证 3-认证失败 4-认证成功 5-提交待审核]
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.AUTH_STATUS
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Byte authStatus;

    /**
     * 住址
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.LIVE_ADDRESS
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String liveAddress;

    /**
     * 头像
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.HEAD_IMG
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String headImg;

    /**
     * 冻结状态[3-冻结 4-正常]
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.FREEZE_STATUS
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Byte freezeStatus;

    /**
     * 极光推送ID
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.PUSH_ID
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String pushId;

    /**
     * 邀请人
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.INVITER_CODE
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String inviterCode;

    /**
     * 是否入驻[0-未入驻 1-已入驻]
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.IS_JOIN
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Byte isJoin;

    /**
     * 注册来源[1-微信 2-WAP 3-Android 4-iOS 5-pc]
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.REGIST_SOURCE
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Byte registSource;

    /**
     * 注册时间
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.REGIST_TIME
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Date registTime;

    /**
     * 注册IP
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.REGIST_IP
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String registIp;

    /**
     * 微信ID
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.WECHAT_ID
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String wechatId;

    /**
     * 微信json
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.WECHAT_DATA
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String wechatData;

    /**
     * QQID
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.QQ_ID
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String qqId;

    /**
     * QQjson
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.QQ_JSON
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String qqJson;

    /**
     * 新浪ID
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.SINA_ID
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String sinaId;

    /**
     * 新浪json
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.SINA_JSON
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String sinaJson;

    /**
     * 登错次数
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.ERR_TIMES
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Byte errTimes;

    /**
     * 最后登错时间
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.ERR_TIME
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Date errTime;

    /**
     * 最近一次登录时间
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.LOGIN_TIME
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Date loginTime;

    /**
     * 出生日期
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.BIRTH_DATE
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Date birthDate;

    /**
     * 备注
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.REMARK
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String remark;

    /**
     * 商城Token
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.SHOP_TOKEN
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String shopToken;

    /**
     * Token过期时间
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.TOKEN_LIMIT_TIME
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Date tokenLimitTime;

    /**
     * 是否区域经理[0-非区域经理 1-是区域经理]
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.IS_COUNTRY_MANAGE
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Byte isCountryManage;

    /**
     * 是否赠送[1-未赠送 2-已替上级赠送余额 3-已替上级赠送积分]
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.ONLINE_FLAG
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Byte onlineFlag;

    /**
     * 客户等级
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.CUST_LEVEL
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String custLevel;

    /**
     * 邀请码
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.INVITE_CODE
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String inviteCode;

    /**
     * 数据权限[0-普通权限(根据客户等级规则来) 1-经理权限(所有下线分支)]
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.DATA_PERM
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String dataPerm;

    /**
     * 剩余现金余额
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.CONSUME_POINT
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Double consumePoint;

    /**
     * 其他积分
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.CXY_POINT
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Double cxyPoint;

    /**
     * 商城积分
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.DEDUCTION_POINT
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Double deductionPoint;

    /**
     * 是否同意注册协议[0-否 1-是]
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.IS_USER_AGREEMENT
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Byte isUserAgreement;

    /**
     * 数据库字段：主键dcdg_bussiness_customer_base.CUST_ID
     *
     * @return the value of dcdg_bussiness_customer_base.CUST_ID
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：主键dcdg_bussiness_customer_base.CUST_ID
     *
     * @param custId the value for dcdg_bussiness_customer_base.CUST_ID
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：客户类型[1-普通会员  7-商家 9-合作管理 11-县(区)管理 15-省级代理 16-合伙人]dcdg_bussiness_customer_base.CUST_TYPE
     *
     * @return the value of dcdg_bussiness_customer_base.CUST_TYPE
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public Integer getCustType() {
        return custType;
    }

    /**
     * 数据库字段：客户类型[1-普通会员  7-商家 9-合作管理 11-县(区)管理 15-省级代理 16-合伙人]dcdg_bussiness_customer_base.CUST_TYPE
     *
     * @param custType the value for dcdg_bussiness_customer_base.CUST_TYPE
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setCustType(Integer custType) {
        this.custType = custType;
    }

    /**
     * 数据库字段：登录账号dcdg_bussiness_customer_base.LOGIN_NAME
     *
     * @return the value of dcdg_bussiness_customer_base.LOGIN_NAME
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 数据库字段：登录账号dcdg_bussiness_customer_base.LOGIN_NAME
     *
     * @param loginName the value for dcdg_bussiness_customer_base.LOGIN_NAME
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 数据库字段：登录密码dcdg_bussiness_customer_base.LOGIN_PWD
     *
     * @return the value of dcdg_bussiness_customer_base.LOGIN_PWD
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getLoginPwd() {
        return loginPwd;
    }

    /**
     * 数据库字段：登录密码dcdg_bussiness_customer_base.LOGIN_PWD
     *
     * @param loginPwd the value for dcdg_bussiness_customer_base.LOGIN_PWD
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    /**
     * 数据库字段：手机号dcdg_bussiness_customer_base.CUST_PHONE
     *
     * @return the value of dcdg_bussiness_customer_base.CUST_PHONE
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getCustPhone() {
        return custPhone;
    }

    /**
     * 数据库字段：手机号dcdg_bussiness_customer_base.CUST_PHONE
     *
     * @param custPhone the value for dcdg_bussiness_customer_base.CUST_PHONE
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone == null ? null : custPhone.trim();
    }

    /**
     * 数据库字段：性别[1-男 2-女 3-未知 4-保密]dcdg_bussiness_customer_base.CUST_SEX
     *
     * @return the value of dcdg_bussiness_customer_base.CUST_SEX
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public Byte getCustSex() {
        return custSex;
    }

    /**
     * 数据库字段：性别[1-男 2-女 3-未知 4-保密]dcdg_bussiness_customer_base.CUST_SEX
     *
     * @param custSex the value for dcdg_bussiness_customer_base.CUST_SEX
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setCustSex(Byte custSex) {
        this.custSex = custSex;
    }

    /**
     * 数据库字段：支付密码dcdg_bussiness_customer_base.PAY_PWD
     *
     * @return the value of dcdg_bussiness_customer_base.PAY_PWD
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getPayPwd() {
        return payPwd;
    }

    /**
     * 数据库字段：支付密码dcdg_bussiness_customer_base.PAY_PWD
     *
     * @param payPwd the value for dcdg_bussiness_customer_base.PAY_PWD
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd == null ? null : payPwd.trim();
    }

    /**
     * 数据库字段：支付校验方式[1-支付密码 2-短信验证]dcdg_bussiness_customer_base.PAY_CHECK_WAY
     *
     * @return the value of dcdg_bussiness_customer_base.PAY_CHECK_WAY
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public Byte getPayCheckWay() {
        return payCheckWay;
    }

    /**
     * 数据库字段：支付校验方式[1-支付密码 2-短信验证]dcdg_bussiness_customer_base.PAY_CHECK_WAY
     *
     * @param payCheckWay the value for dcdg_bussiness_customer_base.PAY_CHECK_WAY
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setPayCheckWay(Byte payCheckWay) {
        this.payCheckWay = payCheckWay;
    }

    /**
     * 数据库字段：所在区域路径dcdg_bussiness_customer_base.AREA_PATH
     *
     * @return the value of dcdg_bussiness_customer_base.AREA_PATH
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getAreaPath() {
        return areaPath;
    }

    /**
     * 数据库字段：所在区域路径dcdg_bussiness_customer_base.AREA_PATH
     *
     * @param areaPath the value for dcdg_bussiness_customer_base.AREA_PATH
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setAreaPath(String areaPath) {
        this.areaPath = areaPath == null ? null : areaPath.trim();
    }

    /**
     * 数据库字段：邮箱dcdg_bussiness_customer_base.CUST_EMAIL
     *
     * @return the value of dcdg_bussiness_customer_base.CUST_EMAIL
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getCustEmail() {
        return custEmail;
    }

    /**
     * 数据库字段：邮箱dcdg_bussiness_customer_base.CUST_EMAIL
     *
     * @param custEmail the value for dcdg_bussiness_customer_base.CUST_EMAIL
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail == null ? null : custEmail.trim();
    }

    /**
     * 数据库字段：昵称dcdg_bussiness_customer_base.NICK_NAME
     *
     * @return the value of dcdg_bussiness_customer_base.NICK_NAME
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 数据库字段：昵称dcdg_bussiness_customer_base.NICK_NAME
     *
     * @param nickName the value for dcdg_bussiness_customer_base.NICK_NAME
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 数据库字段：真实姓名dcdg_bussiness_customer_base.REAL_NAME
     *
     * @return the value of dcdg_bussiness_customer_base.REAL_NAME
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 数据库字段：真实姓名dcdg_bussiness_customer_base.REAL_NAME
     *
     * @param realName the value for dcdg_bussiness_customer_base.REAL_NAME
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 数据库字段：身份证号dcdg_bussiness_customer_base.ID_CARD
     *
     * @return the value of dcdg_bussiness_customer_base.ID_CARD
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 数据库字段：身份证号dcdg_bussiness_customer_base.ID_CARD
     *
     * @param idCard the value for dcdg_bussiness_customer_base.ID_CARD
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * 数据库字段：身份证正面dcdg_bussiness_customer_base.FRONT_ID_CARD
     *
     * @return the value of dcdg_bussiness_customer_base.FRONT_ID_CARD
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getFrontIdCard() {
        return frontIdCard;
    }

    /**
     * 数据库字段：身份证正面dcdg_bussiness_customer_base.FRONT_ID_CARD
     *
     * @param frontIdCard the value for dcdg_bussiness_customer_base.FRONT_ID_CARD
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setFrontIdCard(String frontIdCard) {
        this.frontIdCard = frontIdCard == null ? null : frontIdCard.trim();
    }

    /**
     * 数据库字段：身份证反面dcdg_bussiness_customer_base.END_ID_CARD
     *
     * @return the value of dcdg_bussiness_customer_base.END_ID_CARD
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getEndIdCard() {
        return endIdCard;
    }

    /**
     * 数据库字段：身份证反面dcdg_bussiness_customer_base.END_ID_CARD
     *
     * @param endIdCard the value for dcdg_bussiness_customer_base.END_ID_CARD
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setEndIdCard(String endIdCard) {
        this.endIdCard = endIdCard == null ? null : endIdCard.trim();
    }

    /**
     * 数据库字段：实名认证时间dcdg_bussiness_customer_base.AUTH_TIME
     *
     * @return the value of dcdg_bussiness_customer_base.AUTH_TIME
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public Date getAuthTime() {
        return authTime;
    }

    /**
     * 数据库字段：实名认证时间dcdg_bussiness_customer_base.AUTH_TIME
     *
     * @param authTime the value for dcdg_bussiness_customer_base.AUTH_TIME
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setAuthTime(Date authTime) {
        this.authTime = authTime;
    }

    /**
     * 数据库字段：实名认证审核信息dcdg_bussiness_customer_base.AUTH_INFO
     *
     * @return the value of dcdg_bussiness_customer_base.AUTH_INFO
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getAuthInfo() {
        return authInfo;
    }

    /**
     * 数据库字段：实名认证审核信息dcdg_bussiness_customer_base.AUTH_INFO
     *
     * @param authInfo the value for dcdg_bussiness_customer_base.AUTH_INFO
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo == null ? null : authInfo.trim();
    }

    /**
     * 数据库字段：实名认证状态[2-待认证 3-认证失败 4-认证成功 5-提交待审核]dcdg_bussiness_customer_base.AUTH_STATUS
     *
     * @return the value of dcdg_bussiness_customer_base.AUTH_STATUS
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public Byte getAuthStatus() {
        return authStatus;
    }

    /**
     * 数据库字段：实名认证状态[2-待认证 3-认证失败 4-认证成功 5-提交待审核 5-提交待审核]dcdg_bussiness_customer_base.AUTH_STATUS
     *
     * @param authStatus the value for dcdg_bussiness_customer_base.AUTH_STATUS
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setAuthStatus(Byte authStatus) {
        this.authStatus = authStatus;
    }

    /**
     * 数据库字段：住址dcdg_bussiness_customer_base.LIVE_ADDRESS
     *
     * @return the value of dcdg_bussiness_customer_base.LIVE_ADDRESS
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getLiveAddress() {
        return liveAddress;
    }

    /**
     * 数据库字段：住址dcdg_bussiness_customer_base.LIVE_ADDRESS
     *
     * @param liveAddress the value for dcdg_bussiness_customer_base.LIVE_ADDRESS
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress == null ? null : liveAddress.trim();
    }

    /**
     * 数据库字段：头像dcdg_bussiness_customer_base.HEAD_IMG
     *
     * @return the value of dcdg_bussiness_customer_base.HEAD_IMG
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getHeadImg() {
        return headImg;
    }

    /**
     * 数据库字段：头像dcdg_bussiness_customer_base.HEAD_IMG
     *
     * @param headImg the value for dcdg_bussiness_customer_base.HEAD_IMG
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    /**
     * 数据库字段：冻结状态[3-冻结 4-正常]dcdg_bussiness_customer_base.FREEZE_STATUS
     *
     * @return the value of dcdg_bussiness_customer_base.FREEZE_STATUS
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public Byte getFreezeStatus() {
        return freezeStatus;
    }

    /**
     * 数据库字段：冻结状态[3-冻结 4-正常]dcdg_bussiness_customer_base.FREEZE_STATUS
     *
     * @param freezeStatus the value for dcdg_bussiness_customer_base.FREEZE_STATUS
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setFreezeStatus(Byte freezeStatus) {
        this.freezeStatus = freezeStatus;
    }

    /**
     * 数据库字段：极光推送IDdcdg_bussiness_customer_base.PUSH_ID
     *
     * @return the value of dcdg_bussiness_customer_base.PUSH_ID
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getPushId() {
        return pushId;
    }

    /**
     * 数据库字段：极光推送IDdcdg_bussiness_customer_base.PUSH_ID
     *
     * @param pushId the value for dcdg_bussiness_customer_base.PUSH_ID
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setPushId(String pushId) {
        this.pushId = pushId == null ? null : pushId.trim();
    }

    /**
     * 数据库字段：邀请人dcdg_bussiness_customer_base.INVITER_CODE
     *
     * @return the value of dcdg_bussiness_customer_base.INVITER_CODE
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getInviterCode() {
        return inviterCode;
    }

    /**
     * 数据库字段：邀请人dcdg_bussiness_customer_base.INVITER_CODE
     *
     * @param inviterCode the value for dcdg_bussiness_customer_base.INVITER_CODE
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setInviterCode(String inviterCode) {
        this.inviterCode = inviterCode == null ? null : inviterCode.trim();
    }

    /**
     * 数据库字段：是否入驻[0-未入驻 1-已入驻]dcdg_bussiness_customer_base.IS_JOIN
     *
     * @return the value of dcdg_bussiness_customer_base.IS_JOIN
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public Byte getIsJoin() {
        return isJoin;
    }

    /**
     * 数据库字段：是否入驻[0-未入驻 1-已入驻]dcdg_bussiness_customer_base.IS_JOIN
     *
     * @param isJoin the value for dcdg_bussiness_customer_base.IS_JOIN
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setIsJoin(Byte isJoin) {
        this.isJoin = isJoin;
    }

    /**
     * 数据库字段：注册来源[1-微信 2-WAP 3-Android 4-iOS 5-pc]dcdg_bussiness_customer_base.REGIST_SOURCE
     *
     * @return the value of dcdg_bussiness_customer_base.REGIST_SOURCE
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public Byte getRegistSource() {
        return registSource;
    }

    /**
     * 数据库字段：注册来源[1-微信 2-WAP 3-Android 4-iOS 5-pc]dcdg_bussiness_customer_base.REGIST_SOURCE
     *
     * @param registSource the value for dcdg_bussiness_customer_base.REGIST_SOURCE
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setRegistSource(Byte registSource) {
        this.registSource = registSource;
    }

    /**
     * 数据库字段：注册时间dcdg_bussiness_customer_base.REGIST_TIME
     *
     * @return the value of dcdg_bussiness_customer_base.REGIST_TIME
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public Date getRegistTime() {
        return registTime;
    }

    /**
     * 数据库字段：注册时间dcdg_bussiness_customer_base.REGIST_TIME
     *
     * @param registTime the value for dcdg_bussiness_customer_base.REGIST_TIME
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    /**
     * 数据库字段：注册IPdcdg_bussiness_customer_base.REGIST_IP
     *
     * @return the value of dcdg_bussiness_customer_base.REGIST_IP
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getRegistIp() {
        return registIp;
    }

    /**
     * 数据库字段：注册IPdcdg_bussiness_customer_base.REGIST_IP
     *
     * @param registIp the value for dcdg_bussiness_customer_base.REGIST_IP
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setRegistIp(String registIp) {
        this.registIp = registIp == null ? null : registIp.trim();
    }

    /**
     * 数据库字段：微信IDdcdg_bussiness_customer_base.WECHAT_ID
     *
     * @return the value of dcdg_bussiness_customer_base.WECHAT_ID
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getWechatId() {
        return wechatId;
    }

    /**
     * 数据库字段：微信IDdcdg_bussiness_customer_base.WECHAT_ID
     *
     * @param wechatId the value for dcdg_bussiness_customer_base.WECHAT_ID
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setWechatId(String wechatId) {
        this.wechatId = wechatId == null ? null : wechatId.trim();
    }

    /**
     * 数据库字段：微信jsondcdg_bussiness_customer_base.WECHAT_DATA
     *
     * @return the value of dcdg_bussiness_customer_base.WECHAT_DATA
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getWechatData() {
        return wechatData;
    }

    /**
     * 数据库字段：微信jsondcdg_bussiness_customer_base.WECHAT_DATA
     *
     * @param wechatData the value for dcdg_bussiness_customer_base.WECHAT_DATA
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setWechatData(String wechatData) {
        this.wechatData = wechatData == null ? null : wechatData.trim();
    }

    /**
     * 数据库字段：QQIDdcdg_bussiness_customer_base.QQ_ID
     *
     * @return the value of dcdg_bussiness_customer_base.QQ_ID
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getQqId() {
        return qqId;
    }

    /**
     * 数据库字段：QQIDdcdg_bussiness_customer_base.QQ_ID
     *
     * @param qqId the value for dcdg_bussiness_customer_base.QQ_ID
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setQqId(String qqId) {
        this.qqId = qqId == null ? null : qqId.trim();
    }

    /**
     * 数据库字段：QQjsondcdg_bussiness_customer_base.QQ_JSON
     *
     * @return the value of dcdg_bussiness_customer_base.QQ_JSON
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getQqJson() {
        return qqJson;
    }

    /**
     * 数据库字段：QQjsondcdg_bussiness_customer_base.QQ_JSON
     *
     * @param qqJson the value for dcdg_bussiness_customer_base.QQ_JSON
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setQqJson(String qqJson) {
        this.qqJson = qqJson == null ? null : qqJson.trim();
    }

    /**
     * 数据库字段：新浪IDdcdg_bussiness_customer_base.SINA_ID
     *
     * @return the value of dcdg_bussiness_customer_base.SINA_ID
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getSinaId() {
        return sinaId;
    }

    /**
     * 数据库字段：新浪IDdcdg_bussiness_customer_base.SINA_ID
     *
     * @param sinaId the value for dcdg_bussiness_customer_base.SINA_ID
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setSinaId(String sinaId) {
        this.sinaId = sinaId == null ? null : sinaId.trim();
    }

    /**
     * 数据库字段：新浪jsondcdg_bussiness_customer_base.SINA_JSON
     *
     * @return the value of dcdg_bussiness_customer_base.SINA_JSON
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getSinaJson() {
        return sinaJson;
    }

    /**
     * 数据库字段：新浪jsondcdg_bussiness_customer_base.SINA_JSON
     *
     * @param sinaJson the value for dcdg_bussiness_customer_base.SINA_JSON
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setSinaJson(String sinaJson) {
        this.sinaJson = sinaJson == null ? null : sinaJson.trim();
    }

    /**
     * 数据库字段：登错次数dcdg_bussiness_customer_base.ERR_TIMES
     *
     * @return the value of dcdg_bussiness_customer_base.ERR_TIMES
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public Byte getErrTimes() {
        return errTimes;
    }

    /**
     * 数据库字段：登错次数dcdg_bussiness_customer_base.ERR_TIMES
     *
     * @param errTimes the value for dcdg_bussiness_customer_base.ERR_TIMES
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setErrTimes(Byte errTimes) {
        this.errTimes = errTimes;
    }

    /**
     * 数据库字段：最后登错时间dcdg_bussiness_customer_base.ERR_TIME
     *
     * @return the value of dcdg_bussiness_customer_base.ERR_TIME
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public Date getErrTime() {
        return errTime;
    }

    /**
     * 数据库字段：最后登错时间dcdg_bussiness_customer_base.ERR_TIME
     *
     * @param errTime the value for dcdg_bussiness_customer_base.ERR_TIME
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setErrTime(Date errTime) {
        this.errTime = errTime;
    }

    /**
     * 数据库字段：最近一次登录时间dcdg_bussiness_customer_base.LOGIN_TIME
     *
     * @return the value of dcdg_bussiness_customer_base.LOGIN_TIME
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 数据库字段：最近一次登录时间dcdg_bussiness_customer_base.LOGIN_TIME
     *
     * @param loginTime the value for dcdg_bussiness_customer_base.LOGIN_TIME
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 数据库字段：出生日期dcdg_bussiness_customer_base.BIRTH_DATE
     *
     * @return the value of dcdg_bussiness_customer_base.BIRTH_DATE
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * 数据库字段：出生日期dcdg_bussiness_customer_base.BIRTH_DATE
     *
     * @param birthDate the value for dcdg_bussiness_customer_base.BIRTH_DATE
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * 数据库字段：备注dcdg_bussiness_customer_base.REMARK
     *
     * @return the value of dcdg_bussiness_customer_base.REMARK
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 数据库字段：备注dcdg_bussiness_customer_base.REMARK
     *
     * @param remark the value for dcdg_bussiness_customer_base.REMARK
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 数据库字段：商城Tokendcdg_bussiness_customer_base.SHOP_TOKEN
     *
     * @return the value of dcdg_bussiness_customer_base.SHOP_TOKEN
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getShopToken() {
        return shopToken;
    }

    /**
     * 数据库字段：商城Tokendcdg_bussiness_customer_base.SHOP_TOKEN
     *
     * @param shopToken the value for dcdg_bussiness_customer_base.SHOP_TOKEN
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setShopToken(String shopToken) {
        this.shopToken = shopToken == null ? null : shopToken.trim();
    }

    /**
     * 数据库字段：Token过期时间dcdg_bussiness_customer_base.TOKEN_LIMIT_TIME
     *
     * @return the value of dcdg_bussiness_customer_base.TOKEN_LIMIT_TIME
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public Date getTokenLimitTime() {
        return tokenLimitTime;
    }

    /**
     * 数据库字段：Token过期时间dcdg_bussiness_customer_base.TOKEN_LIMIT_TIME
     *
     * @param tokenLimitTime the value for dcdg_bussiness_customer_base.TOKEN_LIMIT_TIME
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setTokenLimitTime(Date tokenLimitTime) {
        this.tokenLimitTime = tokenLimitTime;
    }

    /**
     * 数据库字段：是否区域经理[0-非区域经理 1-是区域经理]dcdg_bussiness_customer_base.IS_COUNTRY_MANAGE
     *
     * @return the value of dcdg_bussiness_customer_base.IS_COUNTRY_MANAGE
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public Byte getIsCountryManage() {
        return isCountryManage;
    }

    /**
     * 数据库字段：是否区域经理[0-非区域经理 1-是区域经理]dcdg_bussiness_customer_base.IS_COUNTRY_MANAGE
     *
     * @param isCountryManage the value for dcdg_bussiness_customer_base.IS_COUNTRY_MANAGE
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setIsCountryManage(Byte isCountryManage) {
        this.isCountryManage = isCountryManage;
    }

    /**
     * 数据库字段：是否赠送[1-未赠送 2-已替上级赠送余额 3-已替上级赠送积分]dcdg_bussiness_customer_base.ONLINE_FLAG
     *
     * @return the value of dcdg_bussiness_customer_base.ONLINE_FLAG
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public Byte getOnlineFlag() {
        return onlineFlag;
    }

    /**
     * 数据库字段：是否赠送[1-未赠送 2-已替上级赠送余额 3-已替上级赠送积分]dcdg_bussiness_customer_base.ONLINE_FLAG
     *
     * @param onlineFlag the value for dcdg_bussiness_customer_base.ONLINE_FLAG
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setOnlineFlag(Byte onlineFlag) {
        this.onlineFlag = onlineFlag;
    }

    /**
     * 数据库字段：客户等级dcdg_bussiness_customer_base.CUST_LEVEL
     *
     * @return the value of dcdg_bussiness_customer_base.CUST_LEVEL
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getCustLevel() {
        return custLevel;
    }

    /**
     * 数据库字段：客户等级dcdg_bussiness_customer_base.CUST_LEVEL
     *
     * @param custLevel the value for dcdg_bussiness_customer_base.CUST_LEVEL
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel == null ? null : custLevel.trim();
    }

    /**
     * 数据库字段：邀请码dcdg_bussiness_customer_base.INVITE_CODE
     *
     * @return the value of dcdg_bussiness_customer_base.INVITE_CODE
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getInviteCode() {
        return inviteCode;
    }

    /**
     * 数据库字段：邀请码dcdg_bussiness_customer_base.INVITE_CODE
     *
     * @param inviteCode the value for dcdg_bussiness_customer_base.INVITE_CODE
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode == null ? null : inviteCode.trim();
    }

    /**
     * 数据库字段：数据权限[0-普通权限(根据客户等级规则来) 1-经理权限(所有下线分支)]dcdg_bussiness_customer_base.DATA_PERM
     *
     * @return the value of dcdg_bussiness_customer_base.DATA_PERM
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public String getDataPerm() {
        return dataPerm;
    }

    /**
     * 数据库字段：数据权限[0-普通权限(根据客户等级规则来) 1-经理权限(所有下线分支)]dcdg_bussiness_customer_base.DATA_PERM
     *
     * @param dataPerm the value for dcdg_bussiness_customer_base.DATA_PERM
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setDataPerm(String dataPerm) {
        this.dataPerm = dataPerm;
    }

    /**
     * 数据库字段：剩余现金余额dcdg_bussiness_customer_base.CONSUME_POINT
     *
     * @return the value of dcdg_bussiness_customer_base.CONSUME_POINT
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public Double getConsumePoint() {
        return consumePoint;
    }

    /**
     * 数据库字段：剩余现金余额dcdg_bussiness_customer_base.CONSUME_POINT
     *
     * @param consumePoint the value for dcdg_bussiness_customer_base.CONSUME_POINT
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setConsumePoint(Double consumePoint) {
        this.consumePoint = consumePoint;
    }

    /**
     * 数据库字段：其他积分dcdg_bussiness_customer_base.CXY_POINT
     *
     * @return the value of dcdg_bussiness_customer_base.CXY_POINT
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public Double getCxyPoint() {
        return cxyPoint;
    }

    /**
     * 数据库字段：其他积分dcdg_bussiness_customer_base.CXY_POINT
     *
     * @param cxyPoint the value for dcdg_bussiness_customer_base.CXY_POINT
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setCxyPoint(Double cxyPoint) {
        this.cxyPoint = cxyPoint;
    }

    /**
     * 数据库字段：商城积分dcdg_bussiness_customer_base.DEDUCTION_POINT
     *
     * @return the value of dcdg_bussiness_customer_base.DEDUCTION_POINT
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public Double getDeductionPoint() {
        return deductionPoint;
    }

    /**
     * 数据库字段：商城积分dcdg_bussiness_customer_base.DEDUCTION_POINT
     *
     * @param deductionPoint the value for dcdg_bussiness_customer_base.DEDUCTION_POINT
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setDeductionPoint(Double deductionPoint) {
        this.deductionPoint = deductionPoint;
    }

    /**
     * 数据库字段：是否同意注册协议[0-否 1-是]dcdg_bussiness_customer_base.IS_USER_AGREEMENT
     *
     * @return the value of dcdg_bussiness_customer_base.IS_USER_AGREEMENT
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public Byte getIsUserAgreement() {
        return isUserAgreement;
    }

    /**
     * 数据库字段：是否同意注册协议[0-否 1-是]dcdg_bussiness_customer_base.IS_USER_AGREEMENT
     *
     * @param isUserAgreement the value for dcdg_bussiness_customer_base.IS_USER_AGREEMENT
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    public void setIsUserAgreement(Byte isUserAgreement) {
        this.isUserAgreement = isUserAgreement;
    }
}