package com.louquanapp.dao.model;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_goods_hotwords_base
 *
 * @mbg.generated do_not_delete_during_merge Wed Apr 03 08:11:15 CST 2019
 */
public class GoodsHotWords {
    /**
     * 主键
     * <p>
     * 数据库字段名:dcdg_goods_hotwords_base.WORDS_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String wordsId;

    /**
     * 热搜词
     * <p>
     * 数据库字段名:dcdg_goods_hotwords_base.WORDS_VAL
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String wordsVal;

    /**
     * 搜索次数
     * <p>
     * 数据库字段名:dcdg_goods_hotwords_base.SEARCH_COUNT
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Integer searchCount;

    /**
     * 添加时间
     * <p>
     * 数据库字段名:dcdg_goods_hotwords_base.ADD_TIME
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Date addTime;

    /**
     * 更新时间
     * <p>
     * 数据库字段名:dcdg_goods_hotwords_base.UPDATE_TIME
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Date updateTime;

    /**
     * 数据库字段：主键dcdg_goods_hotwords_base.WORDS_ID
     *
     * @return the value of dcdg_goods_hotwords_base.WORDS_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getWordsId() {
        return wordsId;
    }

    /**
     * 数据库字段：主键dcdg_goods_hotwords_base.WORDS_ID
     *
     * @param wordsId the value for dcdg_goods_hotwords_base.WORDS_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setWordsId(String wordsId) {
        this.wordsId = wordsId == null ? null : wordsId.trim();
    }

    /**
     * 数据库字段：热搜词dcdg_goods_hotwords_base.WORDS_VAL
     *
     * @return the value of dcdg_goods_hotwords_base.WORDS_VAL
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getWordsVal() {
        return wordsVal;
    }

    /**
     * 数据库字段：热搜词dcdg_goods_hotwords_base.WORDS_VAL
     *
     * @param wordsVal the value for dcdg_goods_hotwords_base.WORDS_VAL
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setWordsVal(String wordsVal) {
        this.wordsVal = wordsVal == null ? null : wordsVal.trim();
    }

    /**
     * 数据库字段：搜索次数dcdg_goods_hotwords_base.SEARCH_COUNT
     *
     * @return the value of dcdg_goods_hotwords_base.SEARCH_COUNT
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Integer getSearchCount() {
        return searchCount;
    }

    /**
     * 数据库字段：搜索次数dcdg_goods_hotwords_base.SEARCH_COUNT
     *
     * @param searchCount the value for dcdg_goods_hotwords_base.SEARCH_COUNT
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setSearchCount(Integer searchCount) {
        this.searchCount = searchCount;
    }

    /**
     * 数据库字段：添加时间dcdg_goods_hotwords_base.ADD_TIME
     *
     * @return the value of dcdg_goods_hotwords_base.ADD_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_goods_hotwords_base.ADD_TIME
     *
     * @param addTime the value for dcdg_goods_hotwords_base.ADD_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：更新时间dcdg_goods_hotwords_base.UPDATE_TIME
     *
     * @return the value of dcdg_goods_hotwords_base.UPDATE_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：更新时间dcdg_goods_hotwords_base.UPDATE_TIME
     *
     * @param updateTime the value for dcdg_goods_hotwords_base.UPDATE_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}