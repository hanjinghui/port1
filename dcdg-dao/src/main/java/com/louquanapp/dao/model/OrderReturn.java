package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.OrderReturnExtra;
import com.louquanapp.dao.extra.VideoExtra;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_bussiness_order_return
 *
 * @mbg.generated do_not_delete_during_merge Mon Jun 17 14:37:13 CST 2019
 */
public class OrderReturn extends OrderReturnExtra {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_bussiness_order_return.RETURN_ID
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    private String returnId;

    /**
     *   主订单ID
     *
     * 数据库字段名:dcdg_bussiness_order_return.ORDER_ID
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    private String orderId;

    /**
     *   子订单ID
     *
     * 数据库字段名:dcdg_bussiness_order_return.CHILD_ID
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    private String childId;

    /**
     *   商品ID
     *
     * 数据库字段名:dcdg_bussiness_order_return.GOODS_ID
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    private String goodsId;

    /**
     *   卖家ID
     *
     * 数据库字段名:dcdg_bussiness_order_return.SELLER_ID
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    private String sellerId;

    /**
     *   卖家名称
     *
     * 数据库字段名:dcdg_bussiness_order_return.SELLER_NAME
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    private String sellerName;

    /**
     *   会员ID
     *
     * 数据库字段名:dcdg_bussiness_order_return.BUYER_ID
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    private String buyerId;

    /**
     *   会员名称
     *
     * 数据库字段名:dcdg_bussiness_order_return.BUYER_NAME
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    private String buyerName;

    /**
     *   退款说明
     *
     * 数据库字段名:dcdg_bussiness_order_return.REMARK
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    private String remark;

    /**
     *   退货原因
     *
     * 数据库字段名:dcdg_bussiness_order_return.RETURN_CONT
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    private String returnCont;

    /**
     *   退货时间
     *
     * 数据库字段名:dcdg_bussiness_order_return.ADD_TIME
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    private Date addTime;

    /**
     *   商家回复
     *
     * 数据库字段名:dcdg_bussiness_order_return.REPLY_CONT
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    private String replyCont;

    /**
     *   商家回复时间
     *
     * 数据库字段名:dcdg_bussiness_order_return.REPLY_TIME
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    private Date replyTime;

    /**
     *   购买商品的SKU
     *
     * 数据库字段名:dcdg_bussiness_order_return.SKU_VAL
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    private String skuVal;

    /**
     *   退货状态[1-申请中 2-商家已知晓 3-商家同意 4-商家否决]
     *
     * 数据库字段名:dcdg_bussiness_order_return.RETURN_STATUS
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    private Byte returnStatus;

    /**
     *   货物状态[1-待发货 2-待收货 3-已收货]
     *
     * 数据库字段名:dcdg_bussiness_order_return.GOOD_STATUS
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    private Byte goodStatus;

    /**
     *   服务类型[1-仅退款 2-退货退款]
     *
     * 数据库字段名:dcdg_bussiness_order_return.SERVER_STATUS
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    private Byte serverStatus;

    /**
     *   上传凭证
     *
     * 数据库字段名:dcdg_bussiness_order_return.RETURN_IMG
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    private String returnImg;

    /**
     *   餐饮[1-是 2-否]
     *
     * 数据库字段名:dcdg_bussiness_order_return.IS_PROMOTION
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    private Byte isPromotion;

    /**
     *   退款金额
     *
     * 数据库字段名:dcdg_bussiness_order_return.RETURN_MONEY
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    private Double returnMoney;

    /**
     * 数据库字段：主键dcdg_bussiness_order_return.RETURN_ID
     *
     * @return  the value of dcdg_bussiness_order_return.RETURN_ID
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public String getReturnId() {
        return returnId;
    }

    /**
     * 数据库字段：主键dcdg_bussiness_order_return.RETURN_ID
     * @param returnId the value for dcdg_bussiness_order_return.RETURN_ID
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public void setReturnId(String returnId) {
        this.returnId = returnId == null ? null : returnId.trim();
    }

    /**
     * 数据库字段：主订单IDdcdg_bussiness_order_return.ORDER_ID
     *
     * @return  the value of dcdg_bussiness_order_return.ORDER_ID
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 数据库字段：主订单IDdcdg_bussiness_order_return.ORDER_ID
     * @param orderId the value for dcdg_bussiness_order_return.ORDER_ID
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 数据库字段：子订单IDdcdg_bussiness_order_return.CHILD_ID
     *
     * @return  the value of dcdg_bussiness_order_return.CHILD_ID
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public String getChildId() {
        return childId;
    }

    /**
     * 数据库字段：子订单IDdcdg_bussiness_order_return.CHILD_ID
     * @param childId the value for dcdg_bussiness_order_return.CHILD_ID
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public void setChildId(String childId) {
        this.childId = childId == null ? null : childId.trim();
    }

    /**
     * 数据库字段：商品IDdcdg_bussiness_order_return.GOODS_ID
     *
     * @return  the value of dcdg_bussiness_order_return.GOODS_ID
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 数据库字段：商品IDdcdg_bussiness_order_return.GOODS_ID
     * @param goodsId the value for dcdg_bussiness_order_return.GOODS_ID
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * 数据库字段：卖家IDdcdg_bussiness_order_return.SELLER_ID
     *
     * @return  the value of dcdg_bussiness_order_return.SELLER_ID
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * 数据库字段：卖家IDdcdg_bussiness_order_return.SELLER_ID
     * @param sellerId the value for dcdg_bussiness_order_return.SELLER_ID
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    /**
     * 数据库字段：卖家名称dcdg_bussiness_order_return.SELLER_NAME
     *
     * @return  the value of dcdg_bussiness_order_return.SELLER_NAME
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public String getSellerName() {
        return sellerName;
    }

    /**
     * 数据库字段：卖家名称dcdg_bussiness_order_return.SELLER_NAME
     * @param sellerName the value for dcdg_bussiness_order_return.SELLER_NAME
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName == null ? null : sellerName.trim();
    }

    /**
     * 数据库字段：会员IDdcdg_bussiness_order_return.BUYER_ID
     *
     * @return  the value of dcdg_bussiness_order_return.BUYER_ID
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public String getBuyerId() {
        return buyerId;
    }

    /**
     * 数据库字段：会员IDdcdg_bussiness_order_return.BUYER_ID
     * @param buyerId the value for dcdg_bussiness_order_return.BUYER_ID
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId == null ? null : buyerId.trim();
    }

    /**
     * 数据库字段：会员名称dcdg_bussiness_order_return.BUYER_NAME
     *
     * @return  the value of dcdg_bussiness_order_return.BUYER_NAME
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public String getBuyerName() {
        return buyerName;
    }

    /**
     * 数据库字段：会员名称dcdg_bussiness_order_return.BUYER_NAME
     * @param buyerName the value for dcdg_bussiness_order_return.BUYER_NAME
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName == null ? null : buyerName.trim();
    }

    /**
     * 数据库字段：退款说明dcdg_bussiness_order_return.REMARK
     *
     * @return  the value of dcdg_bussiness_order_return.REMARK
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 数据库字段：退款说明dcdg_bussiness_order_return.REMARK
     * @param remark the value for dcdg_bussiness_order_return.REMARK
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 数据库字段：退货原因dcdg_bussiness_order_return.RETURN_CONT
     *
     * @return  the value of dcdg_bussiness_order_return.RETURN_CONT
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public String getReturnCont() {
        return returnCont;
    }

    /**
     * 数据库字段：退货原因dcdg_bussiness_order_return.RETURN_CONT
     * @param returnCont the value for dcdg_bussiness_order_return.RETURN_CONT
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public void setReturnCont(String returnCont) {
        this.returnCont = returnCont == null ? null : returnCont.trim();
    }

    /**
     * 数据库字段：退货时间dcdg_bussiness_order_return.ADD_TIME
     *
     * @return  the value of dcdg_bussiness_order_return.ADD_TIME
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：退货时间dcdg_bussiness_order_return.ADD_TIME
     * @param addTime the value for dcdg_bussiness_order_return.ADD_TIME
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：商家回复dcdg_bussiness_order_return.REPLY_CONT
     *
     * @return  the value of dcdg_bussiness_order_return.REPLY_CONT
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public String getReplyCont() {
        return replyCont;
    }

    /**
     * 数据库字段：商家回复dcdg_bussiness_order_return.REPLY_CONT
     * @param replyCont the value for dcdg_bussiness_order_return.REPLY_CONT
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public void setReplyCont(String replyCont) {
        this.replyCont = replyCont == null ? null : replyCont.trim();
    }

    /**
     * 数据库字段：商家回复时间dcdg_bussiness_order_return.REPLY_TIME
     *
     * @return  the value of dcdg_bussiness_order_return.REPLY_TIME
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public Date getReplyTime() {
        return replyTime;
    }

    /**
     * 数据库字段：商家回复时间dcdg_bussiness_order_return.REPLY_TIME
     * @param replyTime the value for dcdg_bussiness_order_return.REPLY_TIME
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    /**
     * 数据库字段：购买商品的SKUdcdg_bussiness_order_return.SKU_VAL
     *
     * @return  the value of dcdg_bussiness_order_return.SKU_VAL
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public String getSkuVal() {
        return skuVal;
    }

    /**
     * 数据库字段：购买商品的SKUdcdg_bussiness_order_return.SKU_VAL
     * @param skuVal the value for dcdg_bussiness_order_return.SKU_VAL
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public void setSkuVal(String skuVal) {
        this.skuVal = skuVal == null ? null : skuVal.trim();
    }

    /**
     * 数据库字段：退货状态[1-申请中 2-商家已知晓 3-商家同意 4-商家否决]dcdg_bussiness_order_return.RETURN_STATUS
     *
     * @return  the value of dcdg_bussiness_order_return.RETURN_STATUS
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public Byte getReturnStatus() {
        return returnStatus;
    }

    /**
     * 数据库字段：退货状态[1-申请中 2-商家已知晓 3-商家同意 4-商家否决]dcdg_bussiness_order_return.RETURN_STATUS
     * @param returnStatus the value for dcdg_bussiness_order_return.RETURN_STATUS
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public void setReturnStatus(Byte returnStatus) {
        this.returnStatus = returnStatus;
    }

    /**
     * 数据库字段：货物状态[1-待发货 2-待收货 3-已收货]dcdg_bussiness_order_return.GOOD_STATUS
     *
     * @return  the value of dcdg_bussiness_order_return.GOOD_STATUS
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public Byte getGoodStatus() {
        return goodStatus;
    }

    /**
     * 数据库字段：货物状态[1-待发货 2-待收货 3-已收货]dcdg_bussiness_order_return.GOOD_STATUS
     * @param goodStatus the value for dcdg_bussiness_order_return.GOOD_STATUS
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public void setGoodStatus(Byte goodStatus) {
        this.goodStatus = goodStatus;
    }

    /**
     * 数据库字段：服务类型[1-仅退款 2-退货退款]dcdg_bussiness_order_return.SERVER_STATUS
     *
     * @return  the value of dcdg_bussiness_order_return.SERVER_STATUS
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public Byte getServerStatus() {
        return serverStatus;
    }

    /**
     * 数据库字段：服务类型[1-仅退款 2-退货退款]dcdg_bussiness_order_return.SERVER_STATUS
     * @param serverStatus the value for dcdg_bussiness_order_return.SERVER_STATUS
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public void setServerStatus(Byte serverStatus) {
        this.serverStatus = serverStatus;
    }

    /**
     * 数据库字段：上传凭证dcdg_bussiness_order_return.RETURN_IMG
     *
     * @return  the value of dcdg_bussiness_order_return.RETURN_IMG
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public String getReturnImg() {
        return returnImg;
    }

    /**
     * 数据库字段：上传凭证dcdg_bussiness_order_return.RETURN_IMG
     * @param returnImg the value for dcdg_bussiness_order_return.RETURN_IMG
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public void setReturnImg(String returnImg) {
        this.returnImg = returnImg == null ? null : returnImg.trim();
    }

    /**
     * 数据库字段：餐饮[1-是 2-否]dcdg_bussiness_order_return.IS_PROMOTION
     *
     * @return  the value of dcdg_bussiness_order_return.IS_PROMOTION
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public Byte getIsPromotion() {
        return isPromotion;
    }

    /**
     * 数据库字段：餐饮[1-是 2-否]dcdg_bussiness_order_return.IS_PROMOTION
     * @param isPromotion the value for dcdg_bussiness_order_return.IS_PROMOTION
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public void setIsPromotion(Byte isPromotion) {
        this.isPromotion = isPromotion;
    }

    /**
     * 数据库字段：退款金额dcdg_bussiness_order_return.RETURN_MONEY
     *
     * @return  the value of dcdg_bussiness_order_return.RETURN_MONEY
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public Double getReturnMoney() {
        return returnMoney;
    }

    /**
     * 数据库字段：退款金额dcdg_bussiness_order_return.RETURN_MONEY
     * @param returnMoney the value for dcdg_bussiness_order_return.RETURN_MONEY
     *
     * @mbg.generated Mon Jun 17 14:37:13 CST 2019
     */
    public void setReturnMoney(Double returnMoney) {
        this.returnMoney = returnMoney;
    }
}