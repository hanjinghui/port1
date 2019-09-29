package com.louquanapp.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 注册
 */
public class ReqRegisterNophone extends ReqComm {

    //邀请码
    private String inviteCode;
    /**
     * 手机号
     */
    @Pattern(regexp = "1[0-9]{10}", message = "请输入正确的手机号")
    private String phone;
    /**
     * 短信淹
     */
    private String phoneCode;
    /**
     * 密码
     */
    private String loginPwd;
    /**
     * 第三方 openId
     */
    private String openId;
    /**
     * 第三方 辅助数据
     */
    private String openData;
    /**
     * 第三方 accessToken
     */
    private String accessToken;
    /**
     * 1-微信 2-qq 3-微博
     */
    //1-微信 2-qq 3-微博
    private Byte regType;

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }


    //    @NotEmpty(message = "图文验证码不能为空")
//    private String imgCode;
//    private String inviteCode;//邀请码

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getOpenData() {
        return openData;
    }

    public void setOpenData(String openData) {
        this.openData = openData;
    }

    public Byte getRegType() {
        return regType;
    }

    public void setRegType(Byte regType) {
        this.regType = regType;
    }
}