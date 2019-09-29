package com.louquanapp.req;

import javax.validation.constraints.NotNull;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/4 07:30
 * @Description:
 */
public class ReqBuyCart extends ReqToken {
    /**
     * empty 是清空 选中的  不传是访问历史选中的  传修改选中的同步到服务器
     */
    private String selectedCartId;
    /**
     * buy 1-立即购买 2-购物车
     */
    private Integer buy;

    public Byte getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(Byte isPromotion) {
        this.isPromotion = isPromotion;
    }

    /**
     * 餐饮[1-是 2-否]
     * <p>
     * 数据库字段名:dcdg_bussiness_order_base.IS_PROMOTION
     *
     * @mbg.generated Thu Apr 25 15:35:08 CST 2019
     */
    @NotNull(message = "餐饮标识不能为空")
    private Byte isPromotion;



    public String getSelectedCartId() {
        return selectedCartId;
    }

    public void setSelectedCartId(String selectedCartId) {
        this.selectedCartId = selectedCartId;
    }

    public Integer getBuy() {
        return buy;
    }

    public void setBuy(Integer buy) {
        this.buy = buy;
    }
}
