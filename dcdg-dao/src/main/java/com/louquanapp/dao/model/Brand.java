package com.louquanapp.dao.model;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_basic_brand_base
 *
 * @mbg.generated do_not_delete_during_merge Tue Apr 02 11:48:53 CST 2019
 */
public class Brand {
    /**
     * 主键
     * <p>
     * 数据库字段名:dcdg_basic_brand_base.BRAND_ID
     *
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    private String brandId;

    /**
     * 品牌名称
     * <p>
     * 数据库字段名:dcdg_basic_brand_base.BRAND_NAME
     *
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    private String brandName;

    /**
     * 品牌描述
     * <p>
     * 数据库字段名:dcdg_basic_brand_base.BRAND_DESC
     *
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    private String brandDesc;

    /**
     * 品牌Logo
     * <p>
     * 数据库字段名:dcdg_basic_brand_base.BRAND_LOGO
     *
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    private String brandLogo;

    /**
     * 添加时间
     * <p>
     * 数据库字段名:dcdg_basic_brand_base.ADD_TIME
     *
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    private Date addTime;

    /**
     * 首字母
     * <p>
     * 数据库字段名:dcdg_basic_brand_base.FIRST_PINYIN
     *
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    private String firstPinyin;

    /**
     * 排序
     * <p>
     * 数据库字段名:dcdg_basic_brand_base.ORDER_BY
     *
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    private Integer orderBy;

    /**
     * 数据库字段：主键dcdg_basic_brand_base.BRAND_ID
     *
     * @return the value of dcdg_basic_brand_base.BRAND_ID
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    public String getBrandId() {
        return brandId;
    }

    /**
     * 数据库字段：主键dcdg_basic_brand_base.BRAND_ID
     *
     * @param brandId the value for dcdg_basic_brand_base.BRAND_ID
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    public void setBrandId(String brandId) {
        this.brandId = brandId == null ? null : brandId.trim();
    }

    /**
     * 数据库字段：品牌名称dcdg_basic_brand_base.BRAND_NAME
     *
     * @return the value of dcdg_basic_brand_base.BRAND_NAME
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 数据库字段：品牌名称dcdg_basic_brand_base.BRAND_NAME
     *
     * @param brandName the value for dcdg_basic_brand_base.BRAND_NAME
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    /**
     * 数据库字段：品牌描述dcdg_basic_brand_base.BRAND_DESC
     *
     * @return the value of dcdg_basic_brand_base.BRAND_DESC
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    public String getBrandDesc() {
        return brandDesc;
    }

    /**
     * 数据库字段：品牌描述dcdg_basic_brand_base.BRAND_DESC
     *
     * @param brandDesc the value for dcdg_basic_brand_base.BRAND_DESC
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc == null ? null : brandDesc.trim();
    }

    /**
     * 数据库字段：品牌Logodcdg_basic_brand_base.BRAND_LOGO
     *
     * @return the value of dcdg_basic_brand_base.BRAND_LOGO
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    public String getBrandLogo() {
        return brandLogo;
    }

    /**
     * 数据库字段：品牌Logodcdg_basic_brand_base.BRAND_LOGO
     *
     * @param brandLogo the value for dcdg_basic_brand_base.BRAND_LOGO
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo == null ? null : brandLogo.trim();
    }

    /**
     * 数据库字段：添加时间dcdg_basic_brand_base.ADD_TIME
     *
     * @return the value of dcdg_basic_brand_base.ADD_TIME
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_basic_brand_base.ADD_TIME
     *
     * @param addTime the value for dcdg_basic_brand_base.ADD_TIME
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：首字母dcdg_basic_brand_base.FIRST_PINYIN
     *
     * @return the value of dcdg_basic_brand_base.FIRST_PINYIN
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    public String getFirstPinyin() {
        return firstPinyin;
    }

    /**
     * 数据库字段：首字母dcdg_basic_brand_base.FIRST_PINYIN
     *
     * @param firstPinyin the value for dcdg_basic_brand_base.FIRST_PINYIN
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    public void setFirstPinyin(String firstPinyin) {
        this.firstPinyin = firstPinyin == null ? null : firstPinyin.trim();
    }

    /**
     * 数据库字段：排序dcdg_basic_brand_base.ORDER_BY
     *
     * @return the value of dcdg_basic_brand_base.ORDER_BY
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    public Integer getOrderBy() {
        return orderBy;
    }

    /**
     * 数据库字段：排序dcdg_basic_brand_base.ORDER_BY
     *
     * @param orderBy the value for dcdg_basic_brand_base.ORDER_BY
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }
}