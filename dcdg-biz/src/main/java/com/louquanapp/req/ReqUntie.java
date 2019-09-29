package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @Author 胡化敏
 * @Description: 解除绑定微信
 * @Date Create  2019年03月26日15:47:25
 * @Modified By:
 * @Since:
 */
public class ReqUntie extends ReqToken {

    @NotNull(message = "type不能为空")
    @Range(min = 1, max = 3, message = "type的范围是1-3")
    private Integer type;//1-qq,2-微信，3-微博

    private String openId;//1-qqId,2-微信Id，3-微博Id

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
}
