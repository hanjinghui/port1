package com.louquanapp.dao.model;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_customer_attention_base
 *
 * @mbg.generated do_not_delete_during_merge Sun Apr 28 09:20:34 CST 2019
 */
public class Attention {
    /**
     * 主键
     * <p>
     * 数据库字段名:dcdg_customer_attention_base.ATTENTION_ID
     *
     * @mbg.generated Sun Apr 28 09:20:34 CST 2019
     */
    private String attentionId;

    /**
     * 会员ID
     * <p>
     * 数据库字段名:dcdg_customer_attention_base.CUST_ID
     *
     * @mbg.generated Sun Apr 28 09:20:34 CST 2019
     */
    private String custId;

    /**
     * 资源ID
     * <p>
     * 数据库字段名:dcdg_customer_attention_base.SOURCE_ID
     *
     * @mbg.generated Sun Apr 28 09:20:34 CST 2019
     */
    private String sourceId;

    /**
     * 关注类型[1-点赞视频 2-点赞直播 3-商品 4-关注对象会员 5-进入直播间 6-进入有效]
     * <p>
     * 数据库字段名:dcdg_customer_attention_base.ATTENTION_TYPE
     *
     * @mbg.generated Sun Apr 28 09:20:34 CST 2019
     */
    private Byte attentionType;

    /**
     * 添加时间
     * <p>
     * 数据库字段名:dcdg_customer_attention_base.ADD_TIME
     *
     * @mbg.generated Sun Apr 28 09:20:34 CST 2019
     */
    private Date addTime;

    /**
     * 数据库字段：主键dcdg_customer_attention_base.ATTENTION_ID
     *
     * @return the value of dcdg_customer_attention_base.ATTENTION_ID
     * @mbg.generated Sun Apr 28 09:20:34 CST 2019
     */
    public String getAttentionId() {
        return attentionId;
    }

    /**
     * 数据库字段：主键dcdg_customer_attention_base.ATTENTION_ID
     *
     * @param attentionId the value for dcdg_customer_attention_base.ATTENTION_ID
     * @mbg.generated Sun Apr 28 09:20:34 CST 2019
     */
    public void setAttentionId(String attentionId) {
        this.attentionId = attentionId == null ? null : attentionId.trim();
    }

    /**
     * 数据库字段：会员IDdcdg_customer_attention_base.CUST_ID
     *
     * @return the value of dcdg_customer_attention_base.CUST_ID
     * @mbg.generated Sun Apr 28 09:20:34 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：会员IDdcdg_customer_attention_base.CUST_ID
     *
     * @param custId the value for dcdg_customer_attention_base.CUST_ID
     * @mbg.generated Sun Apr 28 09:20:34 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：资源IDdcdg_customer_attention_base.SOURCE_ID
     *
     * @return the value of dcdg_customer_attention_base.SOURCE_ID
     * @mbg.generated Sun Apr 28 09:20:34 CST 2019
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * 数据库字段：资源IDdcdg_customer_attention_base.SOURCE_ID
     *
     * @param sourceId the value for dcdg_customer_attention_base.SOURCE_ID
     * @mbg.generated Sun Apr 28 09:20:34 CST 2019
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    /**
     * 数据库字段：关注类型[1-点赞视频 2-点赞直播 3-商品 4-关注对象会员 5-进入直播间 6-进入游戏 7-我玩过游戏]dcdg_customer_attention_base.ATTENTION_TYPE
     *
     * @return the value of dcdg_customer_attention_base.ATTENTION_TYPE
     * @mbg.generated Sun Apr 28 09:20:34 CST 2019
     */
    public Byte getAttentionType() {
        return attentionType;
    }

    /**
     * 数据库字段：关注类型[1-点赞视频 2-点赞直播 3-商品 4-关注对象会员 5-进入直播间 6-进入游戏 7-我玩过游戏]dcdg_customer_attention_base.ATTENTION_TYPE
     *
     * @param attentionType the value for dcdg_customer_attention_base.ATTENTION_TYPE
     * @mbg.generated Sun Apr 28 09:20:34 CST 2019
     */
    public void setAttentionType(Byte attentionType) {
        this.attentionType = attentionType;
    }

    /**
     * 数据库字段：添加时间dcdg_customer_attention_base.ADD_TIME
     *
     * @return the value of dcdg_customer_attention_base.ADD_TIME
     * @mbg.generated Sun Apr 28 09:20:34 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_customer_attention_base.ADD_TIME
     *
     * @param addTime the value for dcdg_customer_attention_base.ADD_TIME
     * @mbg.generated Sun Apr 28 09:20:34 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}