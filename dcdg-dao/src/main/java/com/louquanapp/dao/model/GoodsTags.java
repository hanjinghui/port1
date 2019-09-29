package com.louquanapp.dao.model;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_goods_goods_tags
 *
 * @mbg.generated do_not_delete_during_merge Wed Apr 03 08:11:15 CST 2019
 */
public class GoodsTags {
    /**
     * 主键
     * <p>
     * 数据库字段名:dcdg_goods_goods_tags.GT_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String gtId;

    /**
     * 商品ID
     * <p>
     * 数据库字段名:dcdg_goods_goods_tags.GOODS_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String goodsId;

    /**
     * 标签ID
     * <p>
     * 数据库字段名:dcdg_goods_goods_tags.TAGS_IDS
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String tagsIds;

    /**
     * 添加时间
     * <p>
     * 数据库字段名:dcdg_goods_goods_tags.ADD_TIME
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Date addTime;

    /**
     * 数据库字段：主键dcdg_goods_goods_tags.GT_ID
     *
     * @return the value of dcdg_goods_goods_tags.GT_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getGtId() {
        return gtId;
    }

    /**
     * 数据库字段：主键dcdg_goods_goods_tags.GT_ID
     *
     * @param gtId the value for dcdg_goods_goods_tags.GT_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setGtId(String gtId) {
        this.gtId = gtId == null ? null : gtId.trim();
    }

    /**
     * 数据库字段：商品IDdcdg_goods_goods_tags.GOODS_ID
     *
     * @return the value of dcdg_goods_goods_tags.GOODS_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 数据库字段：商品IDdcdg_goods_goods_tags.GOODS_ID
     *
     * @param goodsId the value for dcdg_goods_goods_tags.GOODS_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * 数据库字段：标签IDdcdg_goods_goods_tags.TAGS_IDS
     *
     * @return the value of dcdg_goods_goods_tags.TAGS_IDS
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getTagsIds() {
        return tagsIds;
    }

    /**
     * 数据库字段：标签IDdcdg_goods_goods_tags.TAGS_IDS
     *
     * @param tagsIds the value for dcdg_goods_goods_tags.TAGS_IDS
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setTagsIds(String tagsIds) {
        this.tagsIds = tagsIds == null ? null : tagsIds.trim();
    }

    /**
     * 数据库字段：添加时间dcdg_goods_goods_tags.ADD_TIME
     *
     * @return the value of dcdg_goods_goods_tags.ADD_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_goods_goods_tags.ADD_TIME
     *
     * @param addTime the value for dcdg_goods_goods_tags.ADD_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}