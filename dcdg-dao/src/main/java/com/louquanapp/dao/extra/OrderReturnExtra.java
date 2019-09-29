package com.louquanapp.dao.extra;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/8/14 11:42
 * @description:
 */
public class OrderReturnExtra {
    /**
     * 支付渠道[0-未付款 1-纯消费积分 2-积分+余额   5-纯余额  3-积分+微信 4-纯微信 6-积分+支付宝 7-纯支付宝]
     */
    private Byte payType;
    /**
     * 订单状态[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货 501-已收货 601-退货申请中
     * 611-退货中 621-已退货 701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]
     */
    private Integer orderStatus;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品图片
     */
    private String goodsImg;
    /**
     * 购买数量
     */
    private Integer goodsNum;
    /**
     * 子订单实付金额
     */
    private Double totalFee;
    /**
     * 规格名称
     */
    private String skuGoodsName;
    /**
     * 商品单价
     */
    private String putawayPrice;

    public String getPutawayPrice() {
        return putawayPrice;
    }

    public void setPutawayPrice(String putawayPrice) {
        this.putawayPrice = putawayPrice;
    }

    public String getSkuGoodsName() {
        return skuGoodsName;
    }

    public void setSkuGoodsName(String skuGoodsName) {
        this.skuGoodsName = skuGoodsName;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }
}
