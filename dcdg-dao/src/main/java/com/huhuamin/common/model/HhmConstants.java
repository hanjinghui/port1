package com.huhuamin.common.model;

/**
 * @Author 胡化敏
 * @Description: 常量字符串
 * @Date Create 2017/11/20 11:45
 * @Modified By:
 * @Since:
 */
public interface HhmConstants {
    public static final String STR_PAGE_NUM = "pageNum";
    public static final String STR_PAGE_SIZE = "pageSize";
    /**
     * 验证码常量key validCode
     */
    public static final String VALID_CODE = "validCode";
    /**
     * 服务器时间key  serverTime
     */
    public static final String SERVER_TIME = "serverTime";
    /**
     * 目标号码 targetNumber
     */
    public static final String TARGET_NUMBER = "targetNumber";
    /**
     * 错误持续时间解锁
     */
    public static final Integer LOGIN_ERR_COUNT_REST_TIME = 30;
    /**
     * 错误次数
     */
    public static final Integer MAX_LOGIN_ERR_COUNT = 5;

    /**
     * 图文验证码Key
     */
    public static final String SESSION_SECURITY_CODE = "sessionSecurityCode";

    /**
     * 图文验证码持续时间
     */
    public static final String SESSION_SERVER_TIME = "sessionServerTime";

    public static final Integer SESSION_SECURITY_CODE_INTTERVAL_TIME = 5;


    /**
     * 手机注册验证码前缀
     */
    public static final String PRE_FIX_PHONE_REG = "phone_reg_";

    /**
     * 手机登录验证码前缀
     */
    public static final String PRE_FIX_PHONE_LOGIN = "phone_login_";
    /**
     * 手机忘记验证码前缀
     */
    public static final String PRE_FIX_PHONE_FORGET = "phone_forget_";

    /**
     * 手机注册验证码前缀
     */
    public static final String PRE_FIX_EMAIL_BIND = "email_bind_";
}
