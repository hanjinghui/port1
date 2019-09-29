package com.louquanapp.req;

import javax.validation.constraints.NotBlank;

/**
 * @Author 胡化敏
 * @Description: 设置支付密码表单
 * @Date Create  2019年03月29日07:47:12
 * @Modified By:
 * @Since:
 */
public class ReqSetPayPassword extends ReqToken {

    @NotBlank(message = "支付密码不能为空")
    private String payPwd;

    public String getPayPwd() {
        return payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd;
    }
}