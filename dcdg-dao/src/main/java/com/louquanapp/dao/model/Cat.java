package com.louquanapp.dao.model;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_video_cat_base
 *
 * @mbg.generated do_not_delete_during_merge Thu Apr 11 10:19:02 CST 2019
 */
public class Cat {
    /**
     *   标识
     *
     * 数据库字段名:dcdg_video_cat_base.CAT_ID
     *
     * @mbg.generated Thu Apr 11 10:19:02 CST 2019
     */
    private String catId;

    /**
     *   类别
     *
     * 数据库字段名:dcdg_video_cat_base.CAT_NAME
     *
     * @mbg.generated Thu Apr 11 10:19:02 CST 2019
     */
    private String catName;

    /**
     *   排序(小靠前)
     *
     * 数据库字段名:dcdg_video_cat_base.SORT_NUM
     *
     * @mbg.generated Thu Apr 11 10:19:02 CST 2019
     */
    private Integer sortNum;

    /**
     *   上架[1-是 2-否]
     *
     * 数据库字段名:dcdg_video_cat_base.CAT_FLAG
     *
     * @mbg.generated Thu Apr 11 10:19:02 CST 2019
     */
    private Byte catFlag;

    /**
     * 数据库字段：标识dcdg_video_cat_base.CAT_ID
     *
     * @return  the value of dcdg_video_cat_base.CAT_ID
     *
     * @mbg.generated Thu Apr 11 10:19:02 CST 2019
     */
    public String getCatId() {
        return catId;
    }

    /**
     * 数据库字段：标识dcdg_video_cat_base.CAT_ID
     * @param catId the value for dcdg_video_cat_base.CAT_ID
     *
     * @mbg.generated Thu Apr 11 10:19:02 CST 2019
     */
    public void setCatId(String catId) {
        this.catId = catId == null ? null : catId.trim();
    }

    /**
     * 数据库字段：类别dcdg_video_cat_base.CAT_NAME
     *
     * @return  the value of dcdg_video_cat_base.CAT_NAME
     *
     * @mbg.generated Thu Apr 11 10:19:02 CST 2019
     */
    public String getCatName() {
        return catName;
    }

    /**
     * 数据库字段：类别dcdg_video_cat_base.CAT_NAME
     * @param catName the value for dcdg_video_cat_base.CAT_NAME
     *
     * @mbg.generated Thu Apr 11 10:19:02 CST 2019
     */
    public void setCatName(String catName) {
        this.catName = catName == null ? null : catName.trim();
    }

    /**
     * 数据库字段：排序(小靠前)dcdg_video_cat_base.SORT_NUM
     *
     * @return  the value of dcdg_video_cat_base.SORT_NUM
     *
     * @mbg.generated Thu Apr 11 10:19:02 CST 2019
     */
    public Integer getSortNum() {
        return sortNum;
    }

    /**
     * 数据库字段：排序(小靠前)dcdg_video_cat_base.SORT_NUM
     * @param sortNum the value for dcdg_video_cat_base.SORT_NUM
     *
     * @mbg.generated Thu Apr 11 10:19:02 CST 2019
     */
    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    /**
     * 数据库字段：上架[1-是 2-否]dcdg_video_cat_base.CAT_FLAG
     *
     * @return  the value of dcdg_video_cat_base.CAT_FLAG
     *
     * @mbg.generated Thu Apr 11 10:19:02 CST 2019
     */
    public Byte getCatFlag() {
        return catFlag;
    }

    /**
     * 数据库字段：上架[1-是 2-否]dcdg_video_cat_base.CAT_FLAG
     * @param catFlag the value for dcdg_video_cat_base.CAT_FLAG
     *
     * @mbg.generated Thu Apr 11 10:19:02 CST 2019
     */
    public void setCatFlag(Byte catFlag) {
        this.catFlag = catFlag;
    }
}