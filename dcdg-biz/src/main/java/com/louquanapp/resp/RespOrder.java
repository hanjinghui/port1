package com.louquanapp.resp;

import com.louquanapp.dao.model.Order;
import com.louquanapp.dao.model.OrderReturn;
import com.louquanapp.dao.model.VideoPlaninfo;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/10 11:05
 * @Description:
 */
public class RespOrder {

    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    private Order order;
//    private Double totalMoney; //总订单金凤
//    private Double totalMaxPoint; //总积分

    private Double postFee; //邮费
    private Double payMoney; //支付金额
    private Double maxPoint; //商品积分
    private Double remainMoney; //剩余余额
    private Double remainPoint; //剩余积分
    private Double orderMoney; //订单总额
    private Double discountsFee;//抵扣金额

    private Double endPayMoney;

    /**
     * 订餐时间
     */
    private String planEatTime;

    /**
     * 是否允许积分兑换[false-不可以  true-可以] 默认true
     */
    private Boolean isPoint ;

    /***********************结算订单详情************************/
    /**
     * 退货申请信息
     */
    private OrderReturn orderReturn;
    /**
     * 订单退款状态[1-非退款订单 2-退款订单]
     */
    private Byte orderReturnStatus;
    /**
     * 商铺类型[商铺类型[1-产品类 2-服务类]]
     */
    private Byte shopType;



    /***********************结算订单详情************************/

    public OrderReturn getOrderReturn() {
        return orderReturn;
    }

    public void setOrderReturn(OrderReturn orderReturn) {
        this.orderReturn = orderReturn;
    }

    public Byte getOrderReturnStatus() {
        return orderReturnStatus;
    }

    public void setOrderReturnStatus(Byte orderReturnStatus) {
        this.orderReturnStatus = orderReturnStatus;
    }

    public Byte getShopType() {
        return shopType;
    }

    public void setShopType(Byte shopType) {
        this.shopType = shopType;
    }

    /**
     * 是否允许积分兑换[false-不可以  true-可以] 默认true
     */
    public Boolean getPoint() {
        if(isPoint==null){
            return true;
        }
        return isPoint;
    }

    public String getPlanEatTime() {
        return planEatTime;
    }

    public void setPlanEatTime(String planEatTime) {
        this.planEatTime = planEatTime;
    }

    /**
     * 是否允许积分兑换[false-不可以  true-可以] 默认true
     */
    public void setPoint(Boolean point) {
        isPoint = point;
    }

    public Double getEndPayMoney() {
        return endPayMoney;
    }

    public void setEndPayMoney(Double endPayMoney) {
        this.endPayMoney = endPayMoney;
    }

    public Double getDiscountsFee() {
        return discountsFee;
    }

    public void setDiscountsFee(Double discountsFee) {
        this.discountsFee = discountsFee;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Double getRemainMoney() {
        return remainMoney;
    }

    public void setRemainMoney(Double remainMoney) {
        this.remainMoney = remainMoney;
    }

    public Double getRemainPoint() {
        return remainPoint;
    }

    public void setRemainPoint(Double remainPoint) {
        this.remainPoint = remainPoint;
    }

    public Double getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(Double maxPoint) {
        this.maxPoint = maxPoint;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    //    public Double getTotalMoney() {
//        return totalMoney;
//    }
//
//    public void setTotalMoney(Double totalMoney) {
//        this.totalMoney = totalMoney;
//    }
//
//    public Double getTotalMaxPoint() {
//        return totalMaxPoint;
//    }
//
//    public void setTotalMaxPoint(Double totalMaxPoint) {
//        this.totalMaxPoint = totalMaxPoint;
//    }

    public Double getPostFee() {
        return postFee;
    }

    public void setPostFee(Double postFee) {
        this.postFee = postFee;
    }

    public Double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }
}
