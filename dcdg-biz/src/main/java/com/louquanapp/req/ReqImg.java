package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;

/**
 * @Auther: Huhuamin
 * @Date: 2018/11/19 11:45
 * @email:175759041@qq.com
 * @Description: base64图片上传地址
 */
public class ReqImg extends ReqToken {

    @NotEmpty(message = "base64图片内容不能为空")
    private String img64;

    /**
     * 资源来源[1-商品 2-团购商品 3-团购评论 5-商品促销轮播图 6-商品详情]
     */
    @Range(min = 1,max = 6,message = "资源来源范围[1-商品 2-团购商品 3-团购评论 5-商品促销轮播图 6-商品详情]")
    private Byte sourceType;

    public Byte getSourceType() {
        return sourceType;
    }

    public void setSourceType(Byte sourceType) {
        this.sourceType = sourceType;
    }

    public String getImg64() {
        return img64;
    }

    public void setImg64(String img64) {
        this.img64 = img64;
    }
}
