package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 登录情况下，绑定第三方
 */
public class ReqBinOther extends ReqToken {
    /**
     * 1-qq,2-微信，3-微博
     */
    @NotNull(message = "type不能为空")
    @Range(min = 1, max = 3, message = "type的范围是1-3")
    private Integer type;//1-qq,2-微信，3-微博
    /**
     * openId
     */
    @NotBlank(message = "openId不能为空")
    private String openId;
    /**
     * openData
     */
    @NotBlank(message = "openData不能为空")
    private String openData;
    /**
     * 第三方 accessToken
     */
    @NotBlank(message = "accessToken不能为空")
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOpenData() {
        return openData;
    }

    public void setOpenData(String openData) {
        this.openData = openData;
    }
}
