package com.louquanapp.req;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/6/27 下午4:17
 */


import javax.validation.constraints.NotNull;

/**
 * 修改支付密码
 */
public class ReqUpdatePayPwd extends ReqToken {

    //    @NotBlank(message = "手机号不能为空")
//    @Pattern(regexp = "1[0-9]{10}", message = "手机号格式")
    private String oldPwd;
    private String newPwd;
    /**
     * 1.校验支付密码 2-修改支付密码
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

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }
}
