package com.louquanapp.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 账号吗密码登录
 */
public class ReqLogin extends ReqComm {
    /**
     * 登录密码
     */
    @NotBlank(message = "密码不能为空")
    private String userPwd;
    /**
     * 登录用户名
     */
    @NotBlank(message = "登录用户名不能为空")
    private String UserAcct;


    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserAcct() {
        return UserAcct;
    }

    public void setUserAcct(String userAcct) {
        UserAcct = userAcct;
    }
}
