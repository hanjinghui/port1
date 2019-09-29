package com.louquanapp.dao.extra;

import com.louquanapp.dao.model.BuyCart;
import com.louquanapp.dao.model.OrderItem;

import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/4 10:16
 * @Description:
 */
public class ShopExtra {


    /**
     * 关注主播id
     */
    private String attentionId;

    public String getAttentionId() {
        return attentionId;
    }

    public void setAttentionId(String attentionId) {
        this.attentionId = attentionId;
    }

    private String nickName;
    private String headImg;
    private Integer favCount = 0;
    /**
     * 关注
     */
    private boolean focus = false;


    /**
     * 门店拥有者
     */
    private String custId;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     * 预计就餐时间
     */
    private String planEatTime;

    public String getPlanEatTime() {
        return planEatTime;
    }

    public void setPlanEatTime(String planEatTime) {
        this.planEatTime = planEatTime;
    }

    /**
     * 订单明细
     */
    private List<OrderItem> orderItems;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    /**
     * 购物车
     */
    private List<BuyCart> buyCarts;

    public List<BuyCart> getBuyCarts() {
        return buyCarts;
    }

    public void setBuyCarts(List<BuyCart> buyCarts) {
        this.buyCarts = buyCarts;
    }


    private Integer goodsNum = 0;
    private Double totalFee = 0.00d;//总现金
    private Double totalPoint = 0.00d;//总积分
    private Double maxPostFee = 0.00d;//总有费

    /**
     * token
     */
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public Double getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(Double totalPoint) {
        this.totalPoint = totalPoint;
    }

    public Double getMaxPostFee() {
        return maxPostFee;
    }

    public void setMaxPostFee(Double maxPostFee) {
        this.maxPostFee = maxPostFee;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getFavCount() {
        return favCount;
    }

    public void setFavCount(Integer favCount) {
        this.favCount = favCount;
    }

    public boolean isFocus() {
        return focus;
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
    }
}
