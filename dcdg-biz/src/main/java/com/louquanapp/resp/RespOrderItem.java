package com.louquanapp.resp;

import com.louquanapp.dao.model.OrderItem;

import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/15 16:49
 * @Description:
 */
public class RespOrderItem {

    private String shopName;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    private List<OrderItem> orderItemList;

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
