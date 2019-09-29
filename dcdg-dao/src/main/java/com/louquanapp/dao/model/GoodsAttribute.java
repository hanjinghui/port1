package com.louquanapp.dao.model;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_goods_goods_attribute
 *
 * @mbg.generated do_not_delete_during_merge Wed Apr 03 08:11:15 CST 2019
 */
public class GoodsAttribute {
    /**
     * 主键
     * <p>
     * 数据库字段名:dcdg_goods_goods_attribute.GATTR_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String gattrId;

    /**
     * 商品ID
     * <p>
     * 数据库字段名:dcdg_goods_goods_attribute.GOODS_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String goodsId;

    /**
     * 属性ID
     * <p>
     * 数据库字段名:dcdg_goods_goods_attribute.ATTR_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String attrId;

    /**
     * 属性选项ID
     * <p>
     * 数据库字段名:dcdg_goods_goods_attribute.ATTR_OPT_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String attrOptId;

    /**
     * 属性或属性选项名称
     * <p>
     * 数据库字段名:dcdg_goods_goods_attribute.ATTR_NAME
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String attrName;

    /**
     * 属性或属性选项值
     * <p>
     * 数据库字段名:dcdg_goods_goods_attribute.ATTR_VALUE
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String attrValue;

    /**
     * 创建时间
     * <p>
     * 数据库字段名:dcdg_goods_goods_attribute.ADD_TIME
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Date addTime;

    /**
     * 数据库字段：主键dcdg_goods_goods_attribute.GATTR_ID
     *
     * @return the value of dcdg_goods_goods_attribute.GATTR_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getGattrId() {
        return gattrId;
    }

    /**
     * 数据库字段：主键dcdg_goods_goods_attribute.GATTR_ID
     *
     * @param gattrId the value for dcdg_goods_goods_attribute.GATTR_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setGattrId(String gattrId) {
        this.gattrId = gattrId == null ? null : gattrId.trim();
    }

    /**
     * 数据库字段：商品IDdcdg_goods_goods_attribute.GOODS_ID
     *
     * @return the value of dcdg_goods_goods_attribute.GOODS_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 数据库字段：商品IDdcdg_goods_goods_attribute.GOODS_ID
     *
     * @param goodsId the value for dcdg_goods_goods_attribute.GOODS_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * 数据库字段：属性IDdcdg_goods_goods_attribute.ATTR_ID
     *
     * @return the value of dcdg_goods_goods_attribute.ATTR_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getAttrId() {
        return attrId;
    }

    /**
     * 数据库字段：属性IDdcdg_goods_goods_attribute.ATTR_ID
     *
     * @param attrId the value for dcdg_goods_goods_attribute.ATTR_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setAttrId(String attrId) {
        this.attrId = attrId == null ? null : attrId.trim();
    }

    /**
     * 数据库字段：属性选项IDdcdg_goods_goods_attribute.ATTR_OPT_ID
     *
     * @return the value of dcdg_goods_goods_attribute.ATTR_OPT_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getAttrOptId() {
        return attrOptId;
    }

    /**
     * 数据库字段：属性选项IDdcdg_goods_goods_attribute.ATTR_OPT_ID
     *
     * @param attrOptId the value for dcdg_goods_goods_attribute.ATTR_OPT_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setAttrOptId(String attrOptId) {
        this.attrOptId = attrOptId == null ? null : attrOptId.trim();
    }

    /**
     * 数据库字段：属性或属性选项名称dcdg_goods_goods_attribute.ATTR_NAME
     *
     * @return the value of dcdg_goods_goods_attribute.ATTR_NAME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getAttrName() {
        return attrName;
    }

    /**
     * 数据库字段：属性或属性选项名称dcdg_goods_goods_attribute.ATTR_NAME
     *
     * @param attrName the value for dcdg_goods_goods_attribute.ATTR_NAME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }

    /**
     * 数据库字段：属性或属性选项值dcdg_goods_goods_attribute.ATTR_VALUE
     *
     * @return the value of dcdg_goods_goods_attribute.ATTR_VALUE
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getAttrValue() {
        return attrValue;
    }

    /**
     * 数据库字段：属性或属性选项值dcdg_goods_goods_attribute.ATTR_VALUE
     *
     * @param attrValue the value for dcdg_goods_goods_attribute.ATTR_VALUE
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue == null ? null : attrValue.trim();
    }

    /**
     * 数据库字段：创建时间dcdg_goods_goods_attribute.ADD_TIME
     *
     * @return the value of dcdg_goods_goods_attribute.ADD_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：创建时间dcdg_goods_goods_attribute.ADD_TIME
     *
     * @param addTime the value for dcdg_goods_goods_attribute.ADD_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}