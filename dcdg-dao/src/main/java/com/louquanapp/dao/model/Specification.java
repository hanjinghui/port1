package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.SpecificationExtra;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_goods_specification_base
 *
 * @mbg.generated do_not_delete_during_merge Wed Apr 03 08:25:28 CST 2019
 */
public class Specification extends SpecificationExtra {
    /**
     * 主键
     * <p>
     * 数据库字段名:dcdg_goods_specification_base.SPEC_ID
     *
     * @mbg.generated Wed Apr 03 08:25:28 CST 2019
     */
    private String specId;

    /**
     * 规格名称
     * <p>
     * 数据库字段名:dcdg_goods_specification_base.SPEC_NAME
     *
     * @mbg.generated Wed Apr 03 08:25:28 CST 2019
     */
    private String specName;

    /**
     * 规格描述
     * <p>
     * 数据库字段名:dcdg_goods_specification_base.SPEC_DESC
     *
     * @mbg.generated Wed Apr 03 08:25:28 CST 2019
     */
    private String specDesc;

    /**
     * 是否主规格（只有有一个主规格）[0-不是 1-是]
     * <p>
     * 数据库字段名:dcdg_goods_specification_base.IS_MAIN
     *
     * @mbg.generated Wed Apr 03 08:25:28 CST 2019
     */
    private Byte isMain;

    /**
     * 添加时间
     * <p>
     * 数据库字段名:dcdg_goods_specification_base.ADD_TIME
     *
     * @mbg.generated Wed Apr 03 08:25:28 CST 2019
     */
    private Date addTime;

    /**
     * 数据库字段：主键dcdg_goods_specification_base.SPEC_ID
     *
     * @return the value of dcdg_goods_specification_base.SPEC_ID
     * @mbg.generated Wed Apr 03 08:25:28 CST 2019
     */
    public String getSpecId() {
        return specId;
    }

    /**
     * 数据库字段：主键dcdg_goods_specification_base.SPEC_ID
     *
     * @param specId the value for dcdg_goods_specification_base.SPEC_ID
     * @mbg.generated Wed Apr 03 08:25:28 CST 2019
     */
    public void setSpecId(String specId) {
        this.specId = specId == null ? null : specId.trim();
    }

    /**
     * 数据库字段：规格名称dcdg_goods_specification_base.SPEC_NAME
     *
     * @return the value of dcdg_goods_specification_base.SPEC_NAME
     * @mbg.generated Wed Apr 03 08:25:28 CST 2019
     */
    public String getSpecName() {
        return specName;
    }

    /**
     * 数据库字段：规格名称dcdg_goods_specification_base.SPEC_NAME
     *
     * @param specName the value for dcdg_goods_specification_base.SPEC_NAME
     * @mbg.generated Wed Apr 03 08:25:28 CST 2019
     */
    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    /**
     * 数据库字段：规格描述dcdg_goods_specification_base.SPEC_DESC
     *
     * @return the value of dcdg_goods_specification_base.SPEC_DESC
     * @mbg.generated Wed Apr 03 08:25:28 CST 2019
     */
    public String getSpecDesc() {
        return specDesc;
    }

    /**
     * 数据库字段：规格描述dcdg_goods_specification_base.SPEC_DESC
     *
     * @param specDesc the value for dcdg_goods_specification_base.SPEC_DESC
     * @mbg.generated Wed Apr 03 08:25:28 CST 2019
     */
    public void setSpecDesc(String specDesc) {
        this.specDesc = specDesc == null ? null : specDesc.trim();
    }

    /**
     * 数据库字段：是否主规格（只有有一个主规格）[0-不是 1-是]dcdg_goods_specification_base.IS_MAIN
     *
     * @return the value of dcdg_goods_specification_base.IS_MAIN
     * @mbg.generated Wed Apr 03 08:25:28 CST 2019
     */
    public Byte getIsMain() {
        return isMain;
    }

    /**
     * 数据库字段：是否主规格（只有有一个主规格）[0-不是 1-是]dcdg_goods_specification_base.IS_MAIN
     *
     * @param isMain the value for dcdg_goods_specification_base.IS_MAIN
     * @mbg.generated Wed Apr 03 08:25:28 CST 2019
     */
    public void setIsMain(Byte isMain) {
        this.isMain = isMain;
    }

    /**
     * 数据库字段：添加时间dcdg_goods_specification_base.ADD_TIME
     *
     * @return the value of dcdg_goods_specification_base.ADD_TIME
     * @mbg.generated Wed Apr 03 08:25:28 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_goods_specification_base.ADD_TIME
     *
     * @param addTime the value for dcdg_goods_specification_base.ADD_TIME
     * @mbg.generated Wed Apr 03 08:25:28 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}