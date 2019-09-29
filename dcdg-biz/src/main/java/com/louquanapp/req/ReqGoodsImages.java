package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/8/7 10:42
 * @description:
 */
public class ReqGoodsImages extends ReqTokenPage {
    /**
     * 资源来源
     */
    @NotNull(message = "资源来源不能为空！")
    @Range(min = 1,max = 6,message = "资源来源[1-商品 2-团购商品 3-团购评论 5-商品促销轮播图 6-商品详情]")
    private Byte sourceType;

    public Byte getSourceType() {
        return sourceType;
    }

    public void setSourceType(Byte sourceType) {
        this.sourceType = sourceType;
    }
}
