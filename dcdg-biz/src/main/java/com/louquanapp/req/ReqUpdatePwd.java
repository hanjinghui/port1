package com.louquanapp.req;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/6/27 下午4:17
 */


/**
 * 修改密码
 */
public class ReqUpdatePwd extends ReqToken {

    //    @NotBlank(message = "手机号不能为空")
//    @Pattern(regexp = "1[0-9]{10}", message = "手机号格式")
    private String phone;
    private String phoneCode;
    private String oldPwd;
    private String newPwd;
    /**
     * 1.校验验证码 2.修改密码验证码  0修改密码+旧密码
     */
    private int step;
    /**
     * 图文验证码
     */
//    @NotEmpty(message = "图文验证码不能为空")
    private String imgCode;

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
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

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }
}
