package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/8/12 14:25
 * @description:
 */
public class ReqGoods extends ReqTokenPage{

    /**
     * 商品查询状态[1-全部 2-已上架 3-已下架 4-待审核]
     */
    @NotNull(message = "商品查询状态不能为空！")
    @Range(min = 1,max = 4,message = "商品查询状态范围[1-全部 2-已上架 3-已下架 4-待审核]")
    private Byte flay;

    public Byte getFlay() {
        return flay;
    }

    public void setFlay(Byte flay) {
        this.flay = flay;
    }
}
