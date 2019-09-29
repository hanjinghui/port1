package com.louquanapp.req;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/6/27 下午4:17
 */


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


/**
 * 登录
 */
public class ReqLoginPhone extends ReqComm {

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "1[0-9]{10}", message = "手机号格式")
    private String phone;
    @NotBlank(message = "请填写验证码")
    private String phoneCode;
    //    @NotBlank(message = "极光推送标识不能为空")
    private String pushId;
    /**
     * 图文验证码
     */
//    @NotEmpty(message = "图文验证码不能为空")
    private String imgCode;
    private Integer force;

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImgCode() {
        return imgCode;
    }

    public void setImgCode(String imgCode) {
        this.imgCode = imgCode;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Integer getForce() {
        return force;
    }

    public void setForce(Integer force) {
        this.force = force;
    }
}
