package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.AttributeExtra;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_goods_attribute_base
 *
 * @mbg.generated do_not_delete_during_merge Wed Apr 03 08:11:15 CST 2019
 */
public class Attribute extends AttributeExtra {
    /**
     * 主键
     * <p>
     * 数据库字段名:dcdg_goods_attribute_base.ATTR_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String attrId;

    /**
     * 属性名称
     * <p>
     * 数据库字段名:dcdg_goods_attribute_base.ATTR_NAME
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String attrName;

    /**
     * 属性描述
     * <p>
     * 数据库字段名:dcdg_goods_attribute_base.ATTR_DESC
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String attrDesc;

    /**
     * 显示类型[text-文本框 select-下拉框 checkbox-多选框 radio-单选框]
     * <p>
     * 数据库字段名:dcdg_goods_attribute_base.INPUT_TYPE
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String inputType;

    /**
     * 字段类型(比如：字符串，整数，日期之类)
     * <p>
     * 数据库字段名:dcdg_goods_attribute_base.VALUE_TYPE
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String valueType;

    /**
     * 是否必填[3-不必填 4-必填]
     * <p>
     * 数据库字段名:dcdg_goods_attribute_base.IS_MUST
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Byte isMust;

    /**
     * 可选数量(多选的时候有效)
     * <p>
     * 数据库字段名:dcdg_goods_attribute_base.OPT_MAX
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Integer optMax;

    /**
     * 显示框的属性名称
     * <p>
     * 数据库字段名:dcdg_goods_attribute_base.INPUT_NAME
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String inputName;

    /**
     * 添加时间
     * <p>
     * 数据库字段名:dcdg_goods_attribute_base.ADD_TIME
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Date addTime;

    /**
     * 数据库字段：主键dcdg_goods_attribute_base.ATTR_ID
     *
     * @return the value of dcdg_goods_attribute_base.ATTR_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getAttrId() {
        return attrId;
    }

    /**
     * 数据库字段：主键dcdg_goods_attribute_base.ATTR_ID
     *
     * @param attrId the value for dcdg_goods_attribute_base.ATTR_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setAttrId(String attrId) {
        this.attrId = attrId == null ? null : attrId.trim();
    }

    /**
     * 数据库字段：属性名称dcdg_goods_attribute_base.ATTR_NAME
     *
     * @return the value of dcdg_goods_attribute_base.ATTR_NAME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getAttrName() {
        return attrName;
    }

    /**
     * 数据库字段：属性名称dcdg_goods_attribute_base.ATTR_NAME
     *
     * @param attrName the value for dcdg_goods_attribute_base.ATTR_NAME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }

    /**
     * 数据库字段：属性描述dcdg_goods_attribute_base.ATTR_DESC
     *
     * @return the value of dcdg_goods_attribute_base.ATTR_DESC
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getAttrDesc() {
        return attrDesc;
    }

    /**
     * 数据库字段：属性描述dcdg_goods_attribute_base.ATTR_DESC
     *
     * @param attrDesc the value for dcdg_goods_attribute_base.ATTR_DESC
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setAttrDesc(String attrDesc) {
        this.attrDesc = attrDesc == null ? null : attrDesc.trim();
    }

    /**
     * 数据库字段：显示类型[text-文本框 select-下拉框 checkbox-多选框 radio-单选框]dcdg_goods_attribute_base.INPUT_TYPE
     *
     * @return the value of dcdg_goods_attribute_base.INPUT_TYPE
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getInputType() {
        return inputType;
    }

    /**
     * 数据库字段：显示类型[text-文本框 select-下拉框 checkbox-多选框 radio-单选框]dcdg_goods_attribute_base.INPUT_TYPE
     *
     * @param inputType the value for dcdg_goods_attribute_base.INPUT_TYPE
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setInputType(String inputType) {
        this.inputType = inputType == null ? null : inputType.trim();
    }

    /**
     * 数据库字段：字段类型(比如：字符串，整数，日期之类)dcdg_goods_attribute_base.VALUE_TYPE
     *
     * @return the value of dcdg_goods_attribute_base.VALUE_TYPE
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getValueType() {
        return valueType;
    }

    /**
     * 数据库字段：字段类型(比如：字符串，整数，日期之类)dcdg_goods_attribute_base.VALUE_TYPE
     *
     * @param valueType the value for dcdg_goods_attribute_base.VALUE_TYPE
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setValueType(String valueType) {
        this.valueType = valueType == null ? null : valueType.trim();
    }

    /**
     * 数据库字段：是否必填[3-不必填 4-必填]dcdg_goods_attribute_base.IS_MUST
     *
     * @return the value of dcdg_goods_attribute_base.IS_MUST
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Byte getIsMust() {
        return isMust;
    }

    /**
     * 数据库字段：是否必填[3-不必填 4-必填]dcdg_goods_attribute_base.IS_MUST
     *
     * @param isMust the value for dcdg_goods_attribute_base.IS_MUST
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setIsMust(Byte isMust) {
        this.isMust = isMust;
    }

    /**
     * 数据库字段：可选数量(多选的时候有效)dcdg_goods_attribute_base.OPT_MAX
     *
     * @return the value of dcdg_goods_attribute_base.OPT_MAX
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Integer getOptMax() {
        return optMax;
    }

    /**
     * 数据库字段：可选数量(多选的时候有效)dcdg_goods_attribute_base.OPT_MAX
     *
     * @param optMax the value for dcdg_goods_attribute_base.OPT_MAX
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setOptMax(Integer optMax) {
        this.optMax = optMax;
    }

    /**
     * 数据库字段：显示框的属性名称dcdg_goods_attribute_base.INPUT_NAME
     *
     * @return the value of dcdg_goods_attribute_base.INPUT_NAME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getInputName() {
        return inputName;
    }

    /**
     * 数据库字段：显示框的属性名称dcdg_goods_attribute_base.INPUT_NAME
     *
     * @param inputName the value for dcdg_goods_attribute_base.INPUT_NAME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setInputName(String inputName) {
        this.inputName = inputName == null ? null : inputName.trim();
    }

    /**
     * 数据库字段：添加时间dcdg_goods_attribute_base.ADD_TIME
     *
     * @return the value of dcdg_goods_attribute_base.ADD_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_goods_attribute_base.ADD_TIME
     *
     * @param addTime the value for dcdg_goods_attribute_base.ADD_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}