package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.OrderEvaluateExtra;
import com.louquanapp.dao.extra.OrderExtra;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_bussiness_order_evaluate
 *
 * @mbg.generated do_not_delete_during_merge Thu Sep 26 15:57:53 CST 2019
 */
public class OrderEvaluate extends OrderEvaluateExtra {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.EVALUATE_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private String evaluateId;

    /**
     *   主订单ID
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.ORDER_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private String orderId;

    /**
     *   子订单ID
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.CHILD_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private String childId;

    /**
     *   商品ID
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.GOODS_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private String goodsId;

    /**
     *   是否匿名（订单为匿名，此处也为匿名）[1-匿名 0-非匿名]
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.IS_ANONY
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private Byte isAnony;

    /**
     *   评价结果[1-好评 2-中评 3-差评]
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.EVALUATE_RESULT
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private Byte evaluateResult;

    /**
     *   服务态度评分（0-5分）
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.EVALUATE_SCORE
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private Integer evaluateScore;

    /**
     *   发货速度评分（0-5分）
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.DELIVER_SCORE
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private Integer deliverScore;

    /**
     *   描述相符平分(0-5分)
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.DESC_SCORE
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private Integer descScore;

    /**
     *   卖家ID
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.SELLER_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private String sellerId;

    /**
     *   卖家名称
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.SELLER_NAME
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private String sellerName;

    /**
     *   会员ID
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.BUYER_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private String buyerId;

    /**
     *   会员名称
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.BUYER_NAME
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private String buyerName;

    /**
     *   评价内容
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.EVALUATE_CONT
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private String evaluateCont;

    /**
     *   评价时间
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.ADD_TIME
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private Date addTime;

    /**
     *   评价回复
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.REPLY_CONT
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private String replyCont;

    /**
     *   评价回复时间
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.REPLY_TIME
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private Date replyTime;

    /**
     *   追加评价内容
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.EVALUATE_APPEND
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private String evaluateAppend;

    /**
     *   追加评价时间
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.APPEND_TIME
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private Date appendTime;

    /**
     *   购买商品的SKU
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.SKU_VAL
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private String skuVal;

    /**
     *   评价图片(限3张图)
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.EVALUATE_IMG
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private String evaluateImg;

    /**
     *   预定ID
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.PLAN_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private String planId;

    /**
     *   评价类型[1-服务类 2-产品类]
     *
     * 数据库字段名:dcdg_bussiness_order_evaluate.EVALUATE_TYPE
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    private Byte evaluateType;

    /**
     * 数据库字段：主键dcdg_bussiness_order_evaluate.EVALUATE_ID
     *
     * @return  the value of dcdg_bussiness_order_evaluate.EVALUATE_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public String getEvaluateId() {
        return evaluateId;
    }

    /**
     * 数据库字段：主键dcdg_bussiness_order_evaluate.EVALUATE_ID
     * @param evaluateId the value for dcdg_bussiness_order_evaluate.EVALUATE_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setEvaluateId(String evaluateId) {
        this.evaluateId = evaluateId == null ? null : evaluateId.trim();
    }

    /**
     * 数据库字段：主订单IDdcdg_bussiness_order_evaluate.ORDER_ID
     *
     * @return  the value of dcdg_bussiness_order_evaluate.ORDER_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 数据库字段：主订单IDdcdg_bussiness_order_evaluate.ORDER_ID
     * @param orderId the value for dcdg_bussiness_order_evaluate.ORDER_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 数据库字段：子订单IDdcdg_bussiness_order_evaluate.CHILD_ID
     *
     * @return  the value of dcdg_bussiness_order_evaluate.CHILD_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public String getChildId() {
        return childId;
    }

    /**
     * 数据库字段：子订单IDdcdg_bussiness_order_evaluate.CHILD_ID
     * @param childId the value for dcdg_bussiness_order_evaluate.CHILD_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setChildId(String childId) {
        this.childId = childId == null ? null : childId.trim();
    }

    /**
     * 数据库字段：商品IDdcdg_bussiness_order_evaluate.GOODS_ID
     *
     * @return  the value of dcdg_bussiness_order_evaluate.GOODS_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 数据库字段：商品IDdcdg_bussiness_order_evaluate.GOODS_ID
     * @param goodsId the value for dcdg_bussiness_order_evaluate.GOODS_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * 数据库字段：是否匿名（订单为匿名，此处也为匿名）[1-匿名 0-非匿名]dcdg_bussiness_order_evaluate.IS_ANONY
     *
     * @return  the value of dcdg_bussiness_order_evaluate.IS_ANONY
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public Byte getIsAnony() {
        return isAnony;
    }

    /**
     * 数据库字段：是否匿名（订单为匿名，此处也为匿名）[1-匿名 0-非匿名]dcdg_bussiness_order_evaluate.IS_ANONY
     * @param isAnony the value for dcdg_bussiness_order_evaluate.IS_ANONY
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setIsAnony(Byte isAnony) {
        this.isAnony = isAnony;
    }

    /**
     * 数据库字段：评价结果[1-好评 2-中评 3-差评]dcdg_bussiness_order_evaluate.EVALUATE_RESULT
     *
     * @return  the value of dcdg_bussiness_order_evaluate.EVALUATE_RESULT
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public Byte getEvaluateResult() {
        return evaluateResult;
    }

    /**
     * 数据库字段：评价结果[1-好评 2-中评 3-差评]dcdg_bussiness_order_evaluate.EVALUATE_RESULT
     * @param evaluateResult the value for dcdg_bussiness_order_evaluate.EVALUATE_RESULT
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setEvaluateResult(Byte evaluateResult) {
        this.evaluateResult = evaluateResult;
    }

    /**
     * 数据库字段：服务态度评分（0-5分）dcdg_bussiness_order_evaluate.EVALUATE_SCORE
     *
     * @return  the value of dcdg_bussiness_order_evaluate.EVALUATE_SCORE
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public Integer getEvaluateScore() {
        return evaluateScore;
    }

    /**
     * 数据库字段：服务态度评分（0-5分）dcdg_bussiness_order_evaluate.EVALUATE_SCORE
     * @param evaluateScore the value for dcdg_bussiness_order_evaluate.EVALUATE_SCORE
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setEvaluateScore(Integer evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    /**
     * 数据库字段：发货速度评分（0-5分）dcdg_bussiness_order_evaluate.DELIVER_SCORE
     *
     * @return  the value of dcdg_bussiness_order_evaluate.DELIVER_SCORE
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public Integer getDeliverScore() {
        return deliverScore;
    }

    /**
     * 数据库字段：发货速度评分（0-5分）dcdg_bussiness_order_evaluate.DELIVER_SCORE
     * @param deliverScore the value for dcdg_bussiness_order_evaluate.DELIVER_SCORE
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setDeliverScore(Integer deliverScore) {
        this.deliverScore = deliverScore;
    }

    /**
     * 数据库字段：描述相符平分(0-5分)dcdg_bussiness_order_evaluate.DESC_SCORE
     *
     * @return  the value of dcdg_bussiness_order_evaluate.DESC_SCORE
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public Integer getDescScore() {
        return descScore;
    }

    /**
     * 数据库字段：描述相符平分(0-5分)dcdg_bussiness_order_evaluate.DESC_SCORE
     * @param descScore the value for dcdg_bussiness_order_evaluate.DESC_SCORE
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setDescScore(Integer descScore) {
        this.descScore = descScore;
    }

    /**
     * 数据库字段：卖家IDdcdg_bussiness_order_evaluate.SELLER_ID
     *
     * @return  the value of dcdg_bussiness_order_evaluate.SELLER_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * 数据库字段：卖家IDdcdg_bussiness_order_evaluate.SELLER_ID
     * @param sellerId the value for dcdg_bussiness_order_evaluate.SELLER_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    /**
     * 数据库字段：卖家名称dcdg_bussiness_order_evaluate.SELLER_NAME
     *
     * @return  the value of dcdg_bussiness_order_evaluate.SELLER_NAME
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public String getSellerName() {
        return sellerName;
    }

    /**
     * 数据库字段：卖家名称dcdg_bussiness_order_evaluate.SELLER_NAME
     * @param sellerName the value for dcdg_bussiness_order_evaluate.SELLER_NAME
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName == null ? null : sellerName.trim();
    }

    /**
     * 数据库字段：会员IDdcdg_bussiness_order_evaluate.BUYER_ID
     *
     * @return  the value of dcdg_bussiness_order_evaluate.BUYER_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public String getBuyerId() {
        return buyerId;
    }

    /**
     * 数据库字段：会员IDdcdg_bussiness_order_evaluate.BUYER_ID
     * @param buyerId the value for dcdg_bussiness_order_evaluate.BUYER_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId == null ? null : buyerId.trim();
    }

    /**
     * 数据库字段：会员名称dcdg_bussiness_order_evaluate.BUYER_NAME
     *
     * @return  the value of dcdg_bussiness_order_evaluate.BUYER_NAME
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public String getBuyerName() {
        return buyerName;
    }

    /**
     * 数据库字段：会员名称dcdg_bussiness_order_evaluate.BUYER_NAME
     * @param buyerName the value for dcdg_bussiness_order_evaluate.BUYER_NAME
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName == null ? null : buyerName.trim();
    }

    /**
     * 数据库字段：评价内容dcdg_bussiness_order_evaluate.EVALUATE_CONT
     *
     * @return  the value of dcdg_bussiness_order_evaluate.EVALUATE_CONT
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public String getEvaluateCont() {
        return evaluateCont;
    }

    /**
     * 数据库字段：评价内容dcdg_bussiness_order_evaluate.EVALUATE_CONT
     * @param evaluateCont the value for dcdg_bussiness_order_evaluate.EVALUATE_CONT
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setEvaluateCont(String evaluateCont) {
        this.evaluateCont = evaluateCont == null ? null : evaluateCont.trim();
    }

    /**
     * 数据库字段：评价时间dcdg_bussiness_order_evaluate.ADD_TIME
     *
     * @return  the value of dcdg_bussiness_order_evaluate.ADD_TIME
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：评价时间dcdg_bussiness_order_evaluate.ADD_TIME
     * @param addTime the value for dcdg_bussiness_order_evaluate.ADD_TIME
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：评价回复dcdg_bussiness_order_evaluate.REPLY_CONT
     *
     * @return  the value of dcdg_bussiness_order_evaluate.REPLY_CONT
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public String getReplyCont() {
        return replyCont;
    }

    /**
     * 数据库字段：评价回复dcdg_bussiness_order_evaluate.REPLY_CONT
     * @param replyCont the value for dcdg_bussiness_order_evaluate.REPLY_CONT
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setReplyCont(String replyCont) {
        this.replyCont = replyCont == null ? null : replyCont.trim();
    }

    /**
     * 数据库字段：评价回复时间dcdg_bussiness_order_evaluate.REPLY_TIME
     *
     * @return  the value of dcdg_bussiness_order_evaluate.REPLY_TIME
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public Date getReplyTime() {
        return replyTime;
    }

    /**
     * 数据库字段：评价回复时间dcdg_bussiness_order_evaluate.REPLY_TIME
     * @param replyTime the value for dcdg_bussiness_order_evaluate.REPLY_TIME
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    /**
     * 数据库字段：追加评价内容dcdg_bussiness_order_evaluate.EVALUATE_APPEND
     *
     * @return  the value of dcdg_bussiness_order_evaluate.EVALUATE_APPEND
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public String getEvaluateAppend() {
        return evaluateAppend;
    }

    /**
     * 数据库字段：追加评价内容dcdg_bussiness_order_evaluate.EVALUATE_APPEND
     * @param evaluateAppend the value for dcdg_bussiness_order_evaluate.EVALUATE_APPEND
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setEvaluateAppend(String evaluateAppend) {
        this.evaluateAppend = evaluateAppend == null ? null : evaluateAppend.trim();
    }

    /**
     * 数据库字段：追加评价时间dcdg_bussiness_order_evaluate.APPEND_TIME
     *
     * @return  the value of dcdg_bussiness_order_evaluate.APPEND_TIME
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public Date getAppendTime() {
        return appendTime;
    }

    /**
     * 数据库字段：追加评价时间dcdg_bussiness_order_evaluate.APPEND_TIME
     * @param appendTime the value for dcdg_bussiness_order_evaluate.APPEND_TIME
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setAppendTime(Date appendTime) {
        this.appendTime = appendTime;
    }

    /**
     * 数据库字段：购买商品的SKUdcdg_bussiness_order_evaluate.SKU_VAL
     *
     * @return  the value of dcdg_bussiness_order_evaluate.SKU_VAL
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public String getSkuVal() {
        return skuVal;
    }

    /**
     * 数据库字段：购买商品的SKUdcdg_bussiness_order_evaluate.SKU_VAL
     * @param skuVal the value for dcdg_bussiness_order_evaluate.SKU_VAL
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setSkuVal(String skuVal) {
        this.skuVal = skuVal == null ? null : skuVal.trim();
    }

    /**
     * 数据库字段：评价图片(限3张图)dcdg_bussiness_order_evaluate.EVALUATE_IMG
     *
     * @return  the value of dcdg_bussiness_order_evaluate.EVALUATE_IMG
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public String getEvaluateImg() {
        return evaluateImg;
    }

    /**
     * 数据库字段：评价图片(限3张图)dcdg_bussiness_order_evaluate.EVALUATE_IMG
     * @param evaluateImg the value for dcdg_bussiness_order_evaluate.EVALUATE_IMG
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setEvaluateImg(String evaluateImg) {
        this.evaluateImg = evaluateImg == null ? null : evaluateImg.trim();
    }

    /**
     * 数据库字段：预定IDdcdg_bussiness_order_evaluate.PLAN_ID
     *
     * @return  the value of dcdg_bussiness_order_evaluate.PLAN_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public String getPlanId() {
        return planId;
    }

    /**
     * 数据库字段：预定IDdcdg_bussiness_order_evaluate.PLAN_ID
     * @param planId the value for dcdg_bussiness_order_evaluate.PLAN_ID
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    /**
     * 数据库字段：评价类型[1-服务类 2-产品类]dcdg_bussiness_order_evaluate.EVALUATE_TYPE
     *
     * @return  the value of dcdg_bussiness_order_evaluate.EVALUATE_TYPE
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public Byte getEvaluateType() {
        return evaluateType;
    }

    /**
     * 数据库字段：评价类型[1-服务类 2-产品类]dcdg_bussiness_order_evaluate.EVALUATE_TYPE
     * @param evaluateType the value for dcdg_bussiness_order_evaluate.EVALUATE_TYPE
     *
     * @mbg.generated Thu Sep 26 15:57:53 CST 2019
     */
    public void setEvaluateType(Byte evaluateType) {
        this.evaluateType = evaluateType;
    }
}