package com.louquanapp.req;

import javax.validation.constraints.NotEmpty;

/**
 * @Auther: Huhuamin
 * @Date: 2019/5/14 15:46
 * @Description:
 */
public class ReqImgWithCode extends ReqToken {

    @NotEmpty(message = "生成的内容不能为空")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
