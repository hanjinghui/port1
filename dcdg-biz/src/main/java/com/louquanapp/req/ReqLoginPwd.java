package com.louquanapp.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 账号吗密码登录
 */
public class ReqLoginPwd extends ReqComm {
    /**
     * 登录密码
     */
    @NotBlank(message = "密码不能为空")
    private String loginPwd;
    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "1[0-9]{10}", message = "手机号格式")
    private String phone;
    /**
     * pushId
     */
    //    @NotBlank(message = "极光推送标识不能为空")
    private String pushId;
    private Integer force;

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public Integer getForce() {
        return force;
    }

    public void setForce(Integer force) {
        this.force = force;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
