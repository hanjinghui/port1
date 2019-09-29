package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.CategoryExtra;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_goods_category_attribute
 *
 * @mbg.generated do_not_delete_during_merge Wed Sep 18 19:54:43 CST 2019
 */
public class CategoryAttribute extends CategoryExtra {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_goods_category_attribute.CA_ID
     *
     * @mbg.generated Wed Sep 18 19:54:43 CST 2019
     */
    private String caId;

    /**
     *   属性ID
     *
     * 数据库字段名:dcdg_goods_category_attribute.ATTR_ID
     *
     * @mbg.generated Wed Sep 18 19:54:43 CST 2019
     */
    private String attrId;

    /**
     *   分类ID
     *
     * 数据库字段名:dcdg_goods_category_attribute.CAT_ID
     *
     * @mbg.generated Wed Sep 18 19:54:43 CST 2019
     */
    private String catId;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_goods_category_attribute.ADD_TIME
     *
     * @mbg.generated Wed Sep 18 19:54:43 CST 2019
     */
    private Date addTime;

    /**
     * 数据库字段：主键dcdg_goods_category_attribute.CA_ID
     *
     * @return  the value of dcdg_goods_category_attribute.CA_ID
     *
     * @mbg.generated Wed Sep 18 19:54:43 CST 2019
     */
    public String getCaId() {
        return caId;
    }

    /**
     * 数据库字段：主键dcdg_goods_category_attribute.CA_ID
     * @param caId the value for dcdg_goods_category_attribute.CA_ID
     *
     * @mbg.generated Wed Sep 18 19:54:43 CST 2019
     */
    public void setCaId(String caId) {
        this.caId = caId == null ? null : caId.trim();
    }

    /**
     * 数据库字段：属性IDdcdg_goods_category_attribute.ATTR_ID
     *
     * @return  the value of dcdg_goods_category_attribute.ATTR_ID
     *
     * @mbg.generated Wed Sep 18 19:54:43 CST 2019
     */
    public String getAttrId() {
        return attrId;
    }

    /**
     * 数据库字段：属性IDdcdg_goods_category_attribute.ATTR_ID
     * @param attrId the value for dcdg_goods_category_attribute.ATTR_ID
     *
     * @mbg.generated Wed Sep 18 19:54:43 CST 2019
     */
    public void setAttrId(String attrId) {
        this.attrId = attrId == null ? null : attrId.trim();
    }

    /**
     * 数据库字段：分类IDdcdg_goods_category_attribute.CAT_ID
     *
     * @return  the value of dcdg_goods_category_attribute.CAT_ID
     *
     * @mbg.generated Wed Sep 18 19:54:43 CST 2019
     */
    public String getCatId() {
        return catId;
    }

    /**
     * 数据库字段：分类IDdcdg_goods_category_attribute.CAT_ID
     * @param catId the value for dcdg_goods_category_attribute.CAT_ID
     *
     * @mbg.generated Wed Sep 18 19:54:43 CST 2019
     */
    public void setCatId(String catId) {
        this.catId = catId == null ? null : catId.trim();
    }

    /**
     * 数据库字段：添加时间dcdg_goods_category_attribute.ADD_TIME
     *
     * @return  the value of dcdg_goods_category_attribute.ADD_TIME
     *
     * @mbg.generated Wed Sep 18 19:54:43 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_goods_category_attribute.ADD_TIME
     * @param addTime the value for dcdg_goods_category_attribute.ADD_TIME
     *
     * @mbg.generated Wed Sep 18 19:54:43 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}