package com.louquanapp.resp;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/25 17:48
 * @Description:
 */

import com.louquanapp.dao.model.Goods;

import java.util.List;

/**
 * 餐饮商品
 */
public class RespCateGood {

    private String catName;

    private List<Goods> goods;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }
}
