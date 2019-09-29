package com.louquanapp.req;

import javax.validation.constraints.NotNull;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/4 07:16
 * @Description: 更新购物车数量
 */
public class ReqUpdateGoodsNum extends ReqToken {


    @NotNull(message = "购物车数量不能为空")
    private Integer goodsNum;

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }
}
