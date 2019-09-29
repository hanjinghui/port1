package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/10 15:40
 * @description:
 */
public class ReqOrderEvaluate extends ReqTokenPage {




    /**
     * 是否回复[1-全部 2-未回复 3-已回复]
     */
    @NotNull(message = "是否回复不能为空！")
    @Range(min = 1, max = 3, message = "是否回复[1-全部 2-未回复 3-已回复]！")
    private Integer isReply;

    public Integer getIsReply() {
        return isReply;
    }

    public void setIsReply(Integer isReply) {
        this.isReply = isReply;
    }
}
