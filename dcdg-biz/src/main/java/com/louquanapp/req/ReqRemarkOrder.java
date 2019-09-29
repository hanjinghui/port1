package com.louquanapp.req;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/10 07:11
 * @Description: 订单里面门店备注
 */
public class ReqRemarkOrder {
    private String shopId;

    private String remark;

    public String getShopId() {
        return shopId;
    }


    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
