package com.louquanapp.req;

import javax.validation.constraints.NotBlank;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/6 07:58
 * @Description:
 */
public class ReqVideoWorksPage extends ReqTokenPage {
    /**
     * 用户主键
     */
    @NotBlank(message = "用户主键不能为空")
    private String custId;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
}
