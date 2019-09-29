package com.louquanapp.req;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/6/27 下午4:17
 */


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 认证之后修改密码
 */
public class ReqValidUpdatePayPwd extends ReqToken {


    /**
     * 身份证号
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.ID_CARD
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    @NotBlank(message = "身份证号不能为空")
    private String idCard;

    /**
     * 真实姓名
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.REAL_NAME
     *
     * @mbg.generated Tue Mar 26 14:27:01 CST 2019
     */
    @NotBlank(message = "真实姓名不能为空")
    private String realName;

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "1[0-9]{10}", message = "手机号格式")
    private String phone;

    @NotBlank(message = "请填写验证码")
    private String phoneCode;

    private String newPwd;

    /**
     * 1.校验身份证信息 2-修改支付密码
     */
    @NotNull(message = "step 不能为空 ")
    private Integer step;


    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }


    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
