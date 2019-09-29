package com.louquanapp.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class ReqPhoneAltPhoneCode extends ReqToken {

    @NotBlank(message = "新手机号不能为空")
    @Pattern(regexp = "1[0-9]{10}", message = "手机号格式")
    private String phone;
    @NotBlank(message = "验证码不能为空")
    private String phoneCode;
    //    @NotBlank(message = "图文验证码不能为空")
//    private String imgCode;
//    @NotBlank(message = "密码不能为空")
    private String loginPwd;


    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

//    public String getImgCode() {
//        return imgCode;
//    }
//
//    public void setImgCode(String imgCode) {
//        this.imgCode = imgCode;
//    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }
}
