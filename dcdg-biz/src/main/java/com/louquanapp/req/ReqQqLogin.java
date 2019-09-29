package com.louquanapp.req;

import javax.validation.constraints.NotBlank;

/**
 * qq登录
 */
public class ReqQqLogin extends ReqComm {
    /**
     * openId
     */
    @NotBlank(message = "qq的openId参数必填")
    private String openId;
    /**
     * qq  accessToken
     */
    @NotBlank(message = "qq的accessToken参数必填")
    private String accessToken;
    /**
     * 极光id
     */
//    @NotBlank(message = "极光推送标识不能为空")
    private String pushId;


    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
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
