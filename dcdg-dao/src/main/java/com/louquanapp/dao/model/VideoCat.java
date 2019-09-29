package com.louquanapp.dao.model;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_video_cat_base
 *
 * @mbg.generated do_not_delete_during_merge Thu May 30 17:29:16 CST 2019
 */
public class VideoCat {
    /**
     *   标识
     *
     * 数据库字段名:dcdg_video_cat_base.CAT_ID
     *
     * @mbg.generated Thu May 30 17:29:16 CST 2019
     */
    private String catId;

    /**
     *   类别
     *
     * 数据库字段名:dcdg_video_cat_base.CAT_NAME
     *
     * @mbg.generated Thu May 30 17:29:16 CST 2019
     */
    private String catName;

    /**
     *   排序(大靠前)
     *
     * 数据库字段名:dcdg_video_cat_base.SORT_NUM
     *
     * @mbg.generated Thu May 30 17:29:16 CST 2019
     */
    private Integer sortNum;

    /**
     *   上架[1-是 2-否]
     *
     * 数据库字段名:dcdg_video_cat_base.CAT_FLAG
     *
     * @mbg.generated Thu May 30 17:29:16 CST 2019
     */
    private Byte catFlag;

    /**
     *   小图标
     *
     * 数据库字段名:dcdg_video_cat_base.CAT_ICONS
     *
     * @mbg.generated Thu May 30 17:29:16 CST 2019
     */
    private String catIcons;

    /**
     *   类型[ 1-餐饮 2-非餐饮]
     *
     * 数据库字段名:dcdg_video_cat_base.CAT_TYPE
     *
     * @mbg.generated Thu May 30 17:29:16 CST 2019
     */
    private Byte catType;

    /**
     * 数据库字段：标识dcdg_video_cat_base.CAT_ID
     *
     * @return  the value of dcdg_video_cat_base.CAT_ID
     *
     * @mbg.generated Thu May 30 17:29:16 CST 2019
     */
    public String getCatId() {
        return catId;
    }

    /**
     * 数据库字段：标识dcdg_video_cat_base.CAT_ID
     * @param catId the value for dcdg_video_cat_base.CAT_ID
     *
     * @mbg.generated Thu May 30 17:29:16 CST 2019
     */
    public void setCatId(String catId) {
        this.catId = catId == null ? null : catId.trim();
    }

    /**
     * 数据库字段：类别dcdg_video_cat_base.CAT_NAME
     *
     * @return  the value of dcdg_video_cat_base.CAT_NAME
     *
     * @mbg.generated Thu May 30 17:29:16 CST 2019
     */
    public String getCatName() {
        return catName;
    }

    /**
     * 数据库字段：类别dcdg_video_cat_base.CAT_NAME
     * @param catName the value for dcdg_video_cat_base.CAT_NAME
     *
     * @mbg.generated Thu May 30 17:29:16 CST 2019
     */
    public void setCatName(String catName) {
        this.catName = catName == null ? null : catName.trim();
    }

    /**
     * 数据库字段：排序(大靠前)dcdg_video_cat_base.SORT_NUM
     *
     * @return  the value of dcdg_video_cat_base.SORT_NUM
     *
     * @mbg.generated Thu May 30 17:29:16 CST 2019
     */
    public Integer getSortNum() {
        return sortNum;
    }

    /**
     * 数据库字段：排序(大靠前)dcdg_video_cat_base.SORT_NUM
     * @param sortNum the value for dcdg_video_cat_base.SORT_NUM
     *
     * @mbg.generated Thu May 30 17:29:16 CST 2019
     */
    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    /**
     * 数据库字段：上架[1-是 2-否]dcdg_video_cat_base.CAT_FLAG
     *
     * @return  the value of dcdg_video_cat_base.CAT_FLAG
     *
     * @mbg.generated Thu May 30 17:29:16 CST 2019
     */
    public Byte getCatFlag() {
        return catFlag;
    }

    /**
     * 数据库字段：上架[1-是 2-否]dcdg_video_cat_base.CAT_FLAG
     * @param catFlag the value for dcdg_video_cat_base.CAT_FLAG
     *
     * @mbg.generated Thu May 30 17:29:16 CST 2019
     */
    public void setCatFlag(Byte catFlag) {
        this.catFlag = catFlag;
    }

    /**
     * 数据库字段：小图标dcdg_video_cat_base.CAT_ICONS
     *
     * @return  the value of dcdg_video_cat_base.CAT_ICONS
     *
     * @mbg.generated Thu May 30 17:29:16 CST 2019
     */
    public String getCatIcons() {
        return catIcons;
    }

    /**
     * 数据库字段：小图标dcdg_video_cat_base.CAT_ICONS
     * @param catIcons the value for dcdg_video_cat_base.CAT_ICONS
     *
     * @mbg.generated Thu May 30 17:29:16 CST 2019
     */
    public void setCatIcons(String catIcons) {
        this.catIcons = catIcons == null ? null : catIcons.trim();
    }

    /**
     * 数据库字段：类型[ 1-餐饮 2-非餐饮]dcdg_video_cat_base.CAT_TYPE
     *
     * @return  the value of dcdg_video_cat_base.CAT_TYPE
     *
     * @mbg.generated Thu May 30 17:29:16 CST 2019
     */
    public Byte getCatType() {
        return catType;
    }

    /**
     * 数据库字段：类型[ 1-餐饮 2-非餐饮]dcdg_video_cat_base.CAT_TYPE
     * @param catType the value for dcdg_video_cat_base.CAT_TYPE
     *
     * @mbg.generated Thu May 30 17:29:16 CST 2019
     */
    public void setCatType(Byte catType) {
        this.catType = catType;
    }
}