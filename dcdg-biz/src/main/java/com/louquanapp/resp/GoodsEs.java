package com.louquanapp.resp;

public class GoodsEs {

    private String goodsId;
    private String goodsName;
    private Double score;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public GoodsEs(String goodsId, String goodsName) {
        super();
        this.goodsId = goodsId;
        this.goodsName = goodsName;
    }

    public GoodsEs() {

    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
