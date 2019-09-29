package com.louquanapp.req;

import javax.validation.constraints.NotNull;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/4 07:30
 * @Description:
 */
public class ReqAddBuyCart extends ReqToken {



    /**
     * 餐饮[1-是 2-否]
     * <p>
     * 数据库字段名:dcdg_bussiness_order_base.IS_PROMOTION
     *
     * @mbg.generated Thu Apr 25 15:35:08 CST 2019
     */
    @NotNull(message = "餐饮标识不能为空")
    private Byte isPromotion;



    private Integer goodsNum;

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Byte getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(Byte isPromotion) {
        this.isPromotion = isPromotion;
    }
}
