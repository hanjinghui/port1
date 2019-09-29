package com.louquanapp.req;

import javax.validation.constraints.NotBlank;

public class ReqWxLogin extends ReqComm {
    @NotBlank(message = "wx的openId参数必填")
    private String openId;
    @NotBlank(message = "wx的accessToken参数必填")
    private String accessToken;
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
}
