package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotNull;


public class ReqImgUrl extends ReqToken {
    /**
     * 图片路径
     */
    private String imgUrl;

    /**
     * 资源来源[1-商品 2-团购商品 3-团购评论 5-商品促销轮播图 6-商品详情]
     */
    @NotNull(message = "资源来源范围不能为空！")
    @Range(min = 1,max = 6,message = "资源来源范围[1-商品 2-团购商品 3-团购评论 5-商品促销轮播图 6-商品详情]")
    private Byte sourceType;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Byte getSourceType() {
        return sourceType;
    }

    public void setSourceType(Byte sourceType) {
        this.sourceType = sourceType;
    }
}
