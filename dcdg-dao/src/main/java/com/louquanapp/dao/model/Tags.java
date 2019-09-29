package com.louquanapp.dao.model;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_goods_tags_base
 *
 * @mbg.generated do_not_delete_during_merge Tue Sep 17 19:13:12 CST 2019
 */
public class Tags {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_goods_tags_base.TAGS_ID
     *
     * @mbg.generated Tue Sep 17 19:13:12 CST 2019
     */
    private String tagsId;

    /**
     *   标签名称
     *
     * 数据库字段名:dcdg_goods_tags_base.TAGS_NAME
     *
     * @mbg.generated Tue Sep 17 19:13:12 CST 2019
     */
    private String tagsName;

    /**
     *   查询次数
     *
     * 数据库字段名:dcdg_goods_tags_base.SEARCH_COUNT
     *
     * @mbg.generated Tue Sep 17 19:13:12 CST 2019
     */
    private Integer searchCount;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_goods_tags_base.ADD_TIME
     *
     * @mbg.generated Tue Sep 17 19:13:12 CST 2019
     */
    private Date addTime;

    /**
     * 数据库字段：主键dcdg_goods_tags_base.TAGS_ID
     *
     * @return  the value of dcdg_goods_tags_base.TAGS_ID
     *
     * @mbg.generated Tue Sep 17 19:13:12 CST 2019
     */
    public String getTagsId() {
        return tagsId;
    }

    /**
     * 数据库字段：主键dcdg_goods_tags_base.TAGS_ID
     * @param tagsId the value for dcdg_goods_tags_base.TAGS_ID
     *
     * @mbg.generated Tue Sep 17 19:13:12 CST 2019
     */
    public void setTagsId(String tagsId) {
        this.tagsId = tagsId == null ? null : tagsId.trim();
    }

    /**
     * 数据库字段：标签名称dcdg_goods_tags_base.TAGS_NAME
     *
     * @return  the value of dcdg_goods_tags_base.TAGS_NAME
     *
     * @mbg.generated Tue Sep 17 19:13:12 CST 2019
     */
    public String getTagsName() {
        return tagsName;
    }

    /**
     * 数据库字段：标签名称dcdg_goods_tags_base.TAGS_NAME
     * @param tagsName the value for dcdg_goods_tags_base.TAGS_NAME
     *
     * @mbg.generated Tue Sep 17 19:13:12 CST 2019
     */
    public void setTagsName(String tagsName) {
        this.tagsName = tagsName == null ? null : tagsName.trim();
    }

    /**
     * 数据库字段：查询次数dcdg_goods_tags_base.SEARCH_COUNT
     *
     * @return  the value of dcdg_goods_tags_base.SEARCH_COUNT
     *
     * @mbg.generated Tue Sep 17 19:13:12 CST 2019
     */
    public Integer getSearchCount() {
        return searchCount;
    }

    /**
     * 数据库字段：查询次数dcdg_goods_tags_base.SEARCH_COUNT
     * @param searchCount the value for dcdg_goods_tags_base.SEARCH_COUNT
     *
     * @mbg.generated Tue Sep 17 19:13:12 CST 2019
     */
    public void setSearchCount(Integer searchCount) {
        this.searchCount = searchCount;
    }

    /**
     * 数据库字段：添加时间dcdg_goods_tags_base.ADD_TIME
     *
     * @return  the value of dcdg_goods_tags_base.ADD_TIME
     *
     * @mbg.generated Tue Sep 17 19:13:12 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_goods_tags_base.ADD_TIME
     * @param addTime the value for dcdg_goods_tags_base.ADD_TIME
     *
     * @mbg.generated Tue Sep 17 19:13:12 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}