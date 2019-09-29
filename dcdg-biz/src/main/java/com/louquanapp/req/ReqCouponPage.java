package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/8/23 10:02
 * @description:
 */
public class ReqCouponPage extends ReqTokenPage {

    /**
     *操作方式[1-全部 2-使用中 3-已过期]
     */
    @NotNull(message = "操作方式不能为空!")
    @Range(min = 1,max = 3,message = "操作方式范围[1-全部 2-使用中 3-已过期]")
    private Byte type;

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}
