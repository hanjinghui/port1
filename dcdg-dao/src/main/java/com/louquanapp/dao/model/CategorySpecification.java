package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.CategoryExtra;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_goods_category_specification
 *
 * @mbg.generated do_not_delete_during_merge Wed Sep 18 19:58:34 CST 2019
 */
public class CategorySpecification extends CategoryExtra {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_goods_category_specification.CS_ID
     *
     * @mbg.generated Wed Sep 18 19:58:34 CST 2019
     */
    private String csId;

    /**
     *   规格ID
     *
     * 数据库字段名:dcdg_goods_category_specification.SPEC_ID
     *
     * @mbg.generated Wed Sep 18 19:58:34 CST 2019
     */
    private String specId;

    /**
     *   分类ID
     *
     * 数据库字段名:dcdg_goods_category_specification.CAT_ID
     *
     * @mbg.generated Wed Sep 18 19:58:34 CST 2019
     */
    private String catId;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_goods_category_specification.ADD_TIME
     *
     * @mbg.generated Wed Sep 18 19:58:34 CST 2019
     */
    private Date addTime;

    /**
     * 数据库字段：主键dcdg_goods_category_specification.CS_ID
     *
     * @return  the value of dcdg_goods_category_specification.CS_ID
     *
     * @mbg.generated Wed Sep 18 19:58:34 CST 2019
     */
    public String getCsId() {
        return csId;
    }

    /**
     * 数据库字段：主键dcdg_goods_category_specification.CS_ID
     * @param csId the value for dcdg_goods_category_specification.CS_ID
     *
     * @mbg.generated Wed Sep 18 19:58:34 CST 2019
     */
    public void setCsId(String csId) {
        this.csId = csId == null ? null : csId.trim();
    }

    /**
     * 数据库字段：规格IDdcdg_goods_category_specification.SPEC_ID
     *
     * @return  the value of dcdg_goods_category_specification.SPEC_ID
     *
     * @mbg.generated Wed Sep 18 19:58:34 CST 2019
     */
    public String getSpecId() {
        return specId;
    }

    /**
     * 数据库字段：规格IDdcdg_goods_category_specification.SPEC_ID
     * @param specId the value for dcdg_goods_category_specification.SPEC_ID
     *
     * @mbg.generated Wed Sep 18 19:58:34 CST 2019
     */
    public void setSpecId(String specId) {
        this.specId = specId == null ? null : specId.trim();
    }

    /**
     * 数据库字段：分类IDdcdg_goods_category_specification.CAT_ID
     *
     * @return  the value of dcdg_goods_category_specification.CAT_ID
     *
     * @mbg.generated Wed Sep 18 19:58:34 CST 2019
     */
    public String getCatId() {
        return catId;
    }

    /**
     * 数据库字段：分类IDdcdg_goods_category_specification.CAT_ID
     * @param catId the value for dcdg_goods_category_specification.CAT_ID
     *
     * @mbg.generated Wed Sep 18 19:58:34 CST 2019
     */
    public void setCatId(String catId) {
        this.catId = catId == null ? null : catId.trim();
    }

    /**
     * 数据库字段：添加时间dcdg_goods_category_specification.ADD_TIME
     *
     * @return  the value of dcdg_goods_category_specification.ADD_TIME
     *
     * @mbg.generated Wed Sep 18 19:58:34 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_goods_category_specification.ADD_TIME
     * @param addTime the value for dcdg_goods_category_specification.ADD_TIME
     *
     * @mbg.generated Wed Sep 18 19:58:34 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}