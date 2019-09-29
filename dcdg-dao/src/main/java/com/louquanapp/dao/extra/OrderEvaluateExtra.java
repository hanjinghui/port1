package com.louquanapp.dao.extra;

import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/3 09:19
 * @Description:
 */
public class OrderEvaluateExtra extends AddTimeStr {

    private String headImg;
    /**
     * 评价结果[1-好评 2-中评 3-差评]
     */
    private String evaluateScoreStr;

    /**
     * 商品图片
     */
    private  String goodsImg;
    /**
     * 商品名称
     */
    private  String goodsName;
    /**
     * SKU_VALUE
     */
    private  String skuValue;
    /**
     * 商品单价
     */
    private  Double putawayPrice;

    private List<String> goodsImgList;

    private  String nickName;

    public String getNickName() {
        return nickName;
    }


    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<String> getGoodsImgList() {
        return goodsImgList;
    }

    public void setGoodsImgList(List<String> goodsImgList) {
        this.goodsImgList = goodsImgList;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSkuValue() {
        return skuValue;
    }

    public void setSkuValue(String skuValue) {
        this.skuValue = skuValue;
    }

    public Double getPutawayPrice() {
        return putawayPrice;
    }

    public void setPutawayPrice(Double putawayPrice) {
        this.putawayPrice = putawayPrice;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getEvaluateScoreStr() {
        return evaluateScoreStr;
    }

    public void setEvaluateScoreStr(String evaluateScoreStr) {
        this.evaluateScoreStr = evaluateScoreStr;
    }
}
