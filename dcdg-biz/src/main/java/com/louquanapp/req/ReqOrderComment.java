package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2019年04月09日19:02:07
 */
public class ReqOrderComment extends ReqToken {
    /**
     * 主键 存在时候为修改
     */
    private String evaluateId;

    public String getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(String evaluateId) {
        this.evaluateId = evaluateId;
    }

    @NotEmpty(message = "订单子项Id不能为空")
    private String childId;

    /**
     * 是否匿名（订单为匿名，此处也为匿名）[1-匿名 0-非匿名]
     * <p>
     * 数据库字段名:dcdg_bussiness_order_evaluate.IS_ANONY
     *
     * @mbg.generated Thu Apr 11 19:07:16 CST 2019
     */
    @NotNull(message = "是否匿名")
    @Range(min = 0, max = 1, message = "是否匿名0-1")
    private Byte isAnony;


    /**
     * 描述相符平分(0-5分)
     * <p>
     * 数据库字段名:dcdg_bussiness_order_evaluate.DESC_SCORE
     *
     * @mbg.generated Thu Apr 11 19:07:16 CST 2019
     */
    @Range(min = 0, max = 5, message = "描述相符分数范围0-5")
    private Integer descScore;

//    @NotNull(message = "请评价商品")
//    private Byte evaluateResult;

    @NotNull(message = "请评价卖家服务态度")
    @Range(min = 0, max = 5, message = "卖家服务态度分数范围0-5")
    private Integer evaluateScore;
    @NotEmpty(message = "评价内容不能为空")
    private String evaluateCont;
    @Range(min = 0, max = 5, message = "卖家发货速度范围0-5")
    @NotNull(message = "请评价卖家发货速度")
    private Integer deliverScore;

    private String evaluateImg;

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }

//    public Byte getIsAnony() {
//        return isAnony;
//    }
//
//    public void setIsAnony(Byte isAnony) {
//        this.isAnony = isAnony;
//    }

//    public Byte getEvaluateResult() {
//        return evaluateResult;
//    }
//
//    public void setEvaluateResult(Byte evaluateResult) {
//        this.evaluateResult = evaluateResult;
//    }

    public Integer getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(Integer evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public String getEvaluateCont() {
        return evaluateCont;
    }

    public void setEvaluateCont(String evaluateCont) {
        this.evaluateCont = evaluateCont;
    }

    public Integer getDeliverScore() {
        return deliverScore;
    }

    public void setDeliverScore(Integer deliverScore) {
        this.deliverScore = deliverScore;
    }

    public String getEvaluateImg() {
        return evaluateImg;
    }

    public void setEvaluateImg(String evaluateImg) {
        this.evaluateImg = evaluateImg;
    }

    public Byte getIsAnony() {
        return isAnony;
    }

    public void setIsAnony(Byte isAnony) {
        this.isAnony = isAnony;
    }

    public Integer getDescScore() {
        return descScore;
    }

    public void setDescScore(Integer descScore) {
        this.descScore = descScore;
    }
}
