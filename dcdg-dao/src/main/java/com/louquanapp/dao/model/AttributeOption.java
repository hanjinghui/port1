package com.louquanapp.dao.model;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_goods_attribute_option
 *
 * @mbg.generated do_not_delete_during_merge Wed Apr 03 08:11:15 CST 2019
 */
public class AttributeOption {
    /**
     * 主键
     * <p>
     * 数据库字段名:dcdg_goods_attribute_option.OPT_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String optId;

    /**
     * 属性ID
     * <p>
     * 数据库字段名:dcdg_goods_attribute_option.ATTR_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String attrId;

    /**
     * 选项名称
     * <p>
     * 数据库字段名:dcdg_goods_attribute_option.OPT_NAME
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String optName;

    /**
     * 选项描述
     * <p>
     * 数据库字段名:dcdg_goods_attribute_option.OPT_DESC
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String optDesc;

    /**
     * 添加时间
     * <p>
     * 数据库字段名:dcdg_goods_attribute_option.ADD_TIME
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Date addTime;

    /**
     * 数据库字段：主键dcdg_goods_attribute_option.OPT_ID
     *
     * @return the value of dcdg_goods_attribute_option.OPT_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getOptId() {
        return optId;
    }

    /**
     * 数据库字段：主键dcdg_goods_attribute_option.OPT_ID
     *
     * @param optId the value for dcdg_goods_attribute_option.OPT_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setOptId(String optId) {
        this.optId = optId == null ? null : optId.trim();
    }

    /**
     * 数据库字段：属性IDdcdg_goods_attribute_option.ATTR_ID
     *
     * @return the value of dcdg_goods_attribute_option.ATTR_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getAttrId() {
        return attrId;
    }

    /**
     * 数据库字段：属性IDdcdg_goods_attribute_option.ATTR_ID
     *
     * @param attrId the value for dcdg_goods_attribute_option.ATTR_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setAttrId(String attrId) {
        this.attrId = attrId == null ? null : attrId.trim();
    }

    /**
     * 数据库字段：选项名称dcdg_goods_attribute_option.OPT_NAME
     *
     * @return the value of dcdg_goods_attribute_option.OPT_NAME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getOptName() {
        return optName;
    }

    /**
     * 数据库字段：选项名称dcdg_goods_attribute_option.OPT_NAME
     *
     * @param optName the value for dcdg_goods_attribute_option.OPT_NAME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setOptName(String optName) {
        this.optName = optName == null ? null : optName.trim();
    }

    /**
     * 数据库字段：选项描述dcdg_goods_attribute_option.OPT_DESC
     *
     * @return the value of dcdg_goods_attribute_option.OPT_DESC
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getOptDesc() {
        return optDesc;
    }

    /**
     * 数据库字段：选项描述dcdg_goods_attribute_option.OPT_DESC
     *
     * @param optDesc the value for dcdg_goods_attribute_option.OPT_DESC
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setOptDesc(String optDesc) {
        this.optDesc = optDesc == null ? null : optDesc.trim();
    }

    /**
     * 数据库字段：添加时间dcdg_goods_attribute_option.ADD_TIME
     *
     * @return the value of dcdg_goods_attribute_option.ADD_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_goods_attribute_option.ADD_TIME
     *
     * @param addTime the value for dcdg_goods_attribute_option.ADD_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}