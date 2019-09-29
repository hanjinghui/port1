package com.louquanapp.req;

import javax.validation.constraints.NotBlank;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/8/8 9:48
 * @description:
 */
public class ReqUpdateLonginPwd extends ReqToken {
    /**
     * 旧密码
     */
    @NotBlank(message = "旧密码不能为空")
    private String oldPwd;

    /**
     * 新密码
     */
    @NotBlank(message = "新密码不能为空")
    private String newPwd;

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}
