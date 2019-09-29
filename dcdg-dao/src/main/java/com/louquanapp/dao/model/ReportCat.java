package com.louquanapp.dao.model;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_video_reportcat_base
 *
 * @mbg.generated do_not_delete_during_merge Mon May 06 19:25:09 CST 2019
 */
public class ReportCat {
    /**
     *   标识
     *
     * 数据库字段名:dcdg_video_reportcat_base.CAT_ID
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    private String catId;

    /**
     *   类别
     *
     * 数据库字段名:dcdg_video_reportcat_base.CAT_NAME
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    private String catName;

    /**
     *   排序(大靠前)
     *
     * 数据库字段名:dcdg_video_reportcat_base.SORT_NUM
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    private Integer sortNum;

    /**
     *   上架[1-是 2-否]
     *
     * 数据库字段名:dcdg_video_reportcat_base.CAT_FLAG
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    private Byte catFlag;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_video_reportcat_base.ADD_TIME
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    private Date addTime;

    /**
     * 数据库字段：标识dcdg_video_reportcat_base.CAT_ID
     *
     * @return  the value of dcdg_video_reportcat_base.CAT_ID
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public String getCatId() {
        return catId;
    }

    /**
     * 数据库字段：标识dcdg_video_reportcat_base.CAT_ID
     * @param catId the value for dcdg_video_reportcat_base.CAT_ID
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public void setCatId(String catId) {
        this.catId = catId == null ? null : catId.trim();
    }

    /**
     * 数据库字段：类别dcdg_video_reportcat_base.CAT_NAME
     *
     * @return  the value of dcdg_video_reportcat_base.CAT_NAME
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public String getCatName() {
        return catName;
    }

    /**
     * 数据库字段：类别dcdg_video_reportcat_base.CAT_NAME
     * @param catName the value for dcdg_video_reportcat_base.CAT_NAME
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public void setCatName(String catName) {
        this.catName = catName == null ? null : catName.trim();
    }

    /**
     * 数据库字段：排序(大靠前)dcdg_video_reportcat_base.SORT_NUM
     *
     * @return  the value of dcdg_video_reportcat_base.SORT_NUM
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public Integer getSortNum() {
        return sortNum;
    }

    /**
     * 数据库字段：排序(大靠前)dcdg_video_reportcat_base.SORT_NUM
     * @param sortNum the value for dcdg_video_reportcat_base.SORT_NUM
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    /**
     * 数据库字段：上架[1-是 2-否]dcdg_video_reportcat_base.CAT_FLAG
     *
     * @return  the value of dcdg_video_reportcat_base.CAT_FLAG
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public Byte getCatFlag() {
        return catFlag;
    }

    /**
     * 数据库字段：上架[1-是 2-否]dcdg_video_reportcat_base.CAT_FLAG
     * @param catFlag the value for dcdg_video_reportcat_base.CAT_FLAG
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public void setCatFlag(Byte catFlag) {
        this.catFlag = catFlag;
    }

    /**
     * 数据库字段：添加时间dcdg_video_reportcat_base.ADD_TIME
     *
     * @return  the value of dcdg_video_reportcat_base.ADD_TIME
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_video_reportcat_base.ADD_TIME
     * @param addTime the value for dcdg_video_reportcat_base.ADD_TIME
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}