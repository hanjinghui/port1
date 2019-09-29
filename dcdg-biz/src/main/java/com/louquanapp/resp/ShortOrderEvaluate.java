package com.louquanapp.resp;

import java.util.Date;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/7/10 下午6:06
 */
public class ShortOrderEvaluate {


    /**
     * 评价内容
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_EVALUATE.EVALUATE_CONT
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String evaluateCont;

    /**
     * 是否匿名（订单为匿名，此处也为匿名）[1-匿名 0-非匿名]
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_EVALUATE.IS_ANONY
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Byte isAnony;

    /**
     * 评价结果[1-好评 2-中评 3-差评]
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_EVALUATE.EVALUATE_RESULT
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Byte evaluateResult;
    private String evaluateScoreStr;
    /**
     * 评分（1-5分）
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_EVALUATE.EVALUATE_SCORE
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Integer evaluateScore;
    /**
     * 会员名称
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_EVALUATE.BUYER_NAME
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String buyerName;
    /**
     * 会员ID
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_EVALUATE.BUYER_ID
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String buyerId;
    private String headImg;
    /**
     * 评价时间
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_EVALUATE.ADD_TIME
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Date addTime;
    private String addTimeStr;

    public String getEvaluateScoreStr() {
        return evaluateScoreStr;
    }

    public void setEvaluateScoreStr(String evaluateScoreStr) {
        this.evaluateScoreStr = evaluateScoreStr;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getAddTimeStr() {
        return addTimeStr;
    }

    public void setAddTimeStr(String addTimeStr) {
        this.addTimeStr = addTimeStr;
    }

    /**
     * 数据库字段：是否匿名（订单为匿名，此处也为匿名）[1-匿名 0-非匿名]CXY_BUSSINESS_ORDER_EVALUATE.IS_ANONY
     *
     * @return the value of CXY_BUSSINESS_ORDER_EVALUATE.IS_ANONY
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Byte getIsAnony() {
        return isAnony;
    }

    /**
     * 数据库字段：是否匿名（订单为匿名，此处也为匿名）[1-匿名 0-非匿名]CXY_BUSSINESS_ORDER_EVALUATE.IS_ANONY
     *
     * @param isAnony the value for CXY_BUSSINESS_ORDER_EVALUATE.IS_ANONY
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setIsAnony(Byte isAnony) {
        this.isAnony = isAnony;
    }

    /**
     * 数据库字段：评价结果[1-好评 2-中评 3-差评]CXY_BUSSINESS_ORDER_EVALUATE.EVALUATE_RESULT
     *
     * @return the value of CXY_BUSSINESS_ORDER_EVALUATE.EVALUATE_RESULT
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Byte getEvaluateResult() {
        return evaluateResult;
    }

    /**
     * 数据库字段：评价结果[1-好评 2-中评 3-差评]CXY_BUSSINESS_ORDER_EVALUATE.EVALUATE_RESULT
     *
     * @param evaluateResult the value for CXY_BUSSINESS_ORDER_EVALUATE.EVALUATE_RESULT
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setEvaluateResult(Byte evaluateResult) {
        this.evaluateResult = evaluateResult;
    }

    /**
     * 数据库字段：评分（1-5分）CXY_BUSSINESS_ORDER_EVALUATE.EVALUATE_SCORE
     *
     * @return the value of CXY_BUSSINESS_ORDER_EVALUATE.EVALUATE_SCORE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Integer getEvaluateScore() {
        return evaluateScore;
    }

    /**
     * 数据库字段：评分（1-5分）CXY_BUSSINESS_ORDER_EVALUATE.EVALUATE_SCORE
     *
     * @param evaluateScore the value for CXY_BUSSINESS_ORDER_EVALUATE.EVALUATE_SCORE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setEvaluateScore(Integer evaluateScore) {
        this.evaluateScore = evaluateScore;
    }


    /**
     * 数据库字段：会员名称CXY_BUSSINESS_ORDER_EVALUATE.BUYER_NAME
     *
     * @return the value of CXY_BUSSINESS_ORDER_EVALUATE.BUYER_NAME
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getBuyerName() {
        return buyerName;
    }

    /**
     * 数据库字段：会员名称CXY_BUSSINESS_ORDER_EVALUATE.BUYER_NAME
     *
     * @param buyerName the value for CXY_BUSSINESS_ORDER_EVALUATE.BUYER_NAME
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName == null ? null : buyerName.trim();
    }


    /**
     * 数据库字段：评价时间CXY_BUSSINESS_ORDER_EVALUATE.ADD_TIME
     *
     * @return the value of CXY_BUSSINESS_ORDER_EVALUATE.ADD_TIME
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：评价时间CXY_BUSSINESS_ORDER_EVALUATE.ADD_TIME
     *
     * @param addTime the value for CXY_BUSSINESS_ORDER_EVALUATE.ADD_TIME
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }


    /**
     * 数据库字段：会员IDCXY_BUSSINESS_ORDER_EVALUATE.BUYER_ID
     *
     * @return the value of CXY_BUSSINESS_ORDER_EVALUATE.BUYER_ID
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getBuyerId() {
        return buyerId;
    }

    /**
     * 数据库字段：会员IDCXY_BUSSINESS_ORDER_EVALUATE.BUYER_ID
     *
     * @param buyerId the value for CXY_BUSSINESS_ORDER_EVALUATE.BUYER_ID
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId == null ? null : buyerId.trim();
    }

    /**
     * 数据库字段：评价内容CXY_BUSSINESS_ORDER_EVALUATE.EVALUATE_CONT
     *
     * @return the value of CXY_BUSSINESS_ORDER_EVALUATE.EVALUATE_CONT
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getEvaluateCont() {
        return evaluateCont;
    }

    /**
     * 数据库字段：评价内容CXY_BUSSINESS_ORDER_EVALUATE.EVALUATE_CONT
     *
     * @param evaluateCont the value for CXY_BUSSINESS_ORDER_EVALUATE.EVALUATE_CONT
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setEvaluateCont(String evaluateCont) {
        this.evaluateCont = evaluateCont == null ? null : evaluateCont.trim();
    }

}
