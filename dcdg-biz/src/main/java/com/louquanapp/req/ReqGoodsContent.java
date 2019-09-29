package com.louquanapp.req;

import javax.validation.constraints.NotBlank;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/9/18 19:15
 * @description:
 */
public class ReqGoodsContent extends ReqToken {
    /**
     * 分类id
     */
    @NotBlank(message = "分类id不能为空！")
     private String catId;
    /**
     * 品牌id
     */
     private String brandId;

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }
}
