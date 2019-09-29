package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/8/12 16:34
 * @description:
 */
public class ReqGoodsFlay extends ReqToken {
    /**
     * 商品操作方式[1-上架 2-下架 3-删除]
     */
    @NotNull(message = "商品操作方式不能为空！")
    @Range(min = 1,max = 3,message = "商品操作方式范围[1-上架 2-下架 3-删除]")
    private Byte flay;

    /**
     * 商品id
     */
    @NotBlank(message = "商品id")
    private String goodsId;

    public Byte getFlay() {
        return flay;
    }

    public void setFlay(Byte flay) {
        this.flay = flay;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}
