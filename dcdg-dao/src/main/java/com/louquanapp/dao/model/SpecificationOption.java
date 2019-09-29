package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.SpecificationOptionExtra;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_goods_specification_option
 *
 * @mbg.generated do_not_delete_during_merge Wed Apr 03 08:28:03 CST 2019
 */
public class SpecificationOption extends SpecificationOptionExtra {
    /**
     * 主键
     * <p>
     * 数据库字段名:dcdg_goods_specification_option.OPT_ID
     *
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    private String optId;

    /**
     * 规格ID
     * <p>
     * 数据库字段名:dcdg_goods_specification_option.SPEC_ID
     *
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    private String specId;

    /**
     * 选项名称
     * <p>
     * 数据库字段名:dcdg_goods_specification_option.OPT_NAME
     *
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    private String optName;

    /**
     * 选项描述
     * <p>
     * 数据库字段名:dcdg_goods_specification_option.OPT_DESC
     *
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    private String optDesc;

    /**
     * 其他选项值
     * <p>
     * 数据库字段名:dcdg_goods_specification_option.OTHER_VAL
     *
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    private String otherVal;

    /**
     * 是否搜索[0-否 1-是]
     * <p>
     * 数据库字段名:dcdg_goods_specification_option.IS_SEARCH
     *
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    private Byte isSearch;

    /**
     * 关联商品数
     * <p>
     * 数据库字段名:dcdg_goods_specification_option.GOODS_COUNT
     *
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    private Integer goodsCount;

    /**
     * 添加时间
     * <p>
     * 数据库字段名:dcdg_goods_specification_option.ADD_TIME
     *
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    private Date addTime;

    /**
     * 数据库字段：主键dcdg_goods_specification_option.OPT_ID
     *
     * @return the value of dcdg_goods_specification_option.OPT_ID
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    public String getOptId() {
        return optId;
    }

    /**
     * 数据库字段：主键dcdg_goods_specification_option.OPT_ID
     *
     * @param optId the value for dcdg_goods_specification_option.OPT_ID
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    public void setOptId(String optId) {
        this.optId = optId == null ? null : optId.trim();
    }

    /**
     * 数据库字段：规格IDdcdg_goods_specification_option.SPEC_ID
     *
     * @return the value of dcdg_goods_specification_option.SPEC_ID
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    public String getSpecId() {
        return specId;
    }

    /**
     * 数据库字段：规格IDdcdg_goods_specification_option.SPEC_ID
     *
     * @param specId the value for dcdg_goods_specification_option.SPEC_ID
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    public void setSpecId(String specId) {
        this.specId = specId == null ? null : specId.trim();
    }

    /**
     * 数据库字段：选项名称dcdg_goods_specification_option.OPT_NAME
     *
     * @return the value of dcdg_goods_specification_option.OPT_NAME
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    public String getOptName() {
        return optName;
    }

    /**
     * 数据库字段：选项名称dcdg_goods_specification_option.OPT_NAME
     *
     * @param optName the value for dcdg_goods_specification_option.OPT_NAME
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    public void setOptName(String optName) {
        this.optName = optName == null ? null : optName.trim();
    }

    /**
     * 数据库字段：选项描述dcdg_goods_specification_option.OPT_DESC
     *
     * @return the value of dcdg_goods_specification_option.OPT_DESC
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    public String getOptDesc() {
        return optDesc;
    }

    /**
     * 数据库字段：选项描述dcdg_goods_specification_option.OPT_DESC
     *
     * @param optDesc the value for dcdg_goods_specification_option.OPT_DESC
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    public void setOptDesc(String optDesc) {
        this.optDesc = optDesc == null ? null : optDesc.trim();
    }

    /**
     * 数据库字段：其他选项值dcdg_goods_specification_option.OTHER_VAL
     *
     * @return the value of dcdg_goods_specification_option.OTHER_VAL
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    public String getOtherVal() {
        return otherVal;
    }

    /**
     * 数据库字段：其他选项值dcdg_goods_specification_option.OTHER_VAL
     *
     * @param otherVal the value for dcdg_goods_specification_option.OTHER_VAL
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    public void setOtherVal(String otherVal) {
        this.otherVal = otherVal == null ? null : otherVal.trim();
    }

    /**
     * 数据库字段：是否搜索[0-否 1-是]dcdg_goods_specification_option.IS_SEARCH
     *
     * @return the value of dcdg_goods_specification_option.IS_SEARCH
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    public Byte getIsSearch() {
        return isSearch;
    }

    /**
     * 数据库字段：是否搜索[0-否 1-是]dcdg_goods_specification_option.IS_SEARCH
     *
     * @param isSearch the value for dcdg_goods_specification_option.IS_SEARCH
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    public void setIsSearch(Byte isSearch) {
        this.isSearch = isSearch;
    }

    /**
     * 数据库字段：关联商品数dcdg_goods_specification_option.GOODS_COUNT
     *
     * @return the value of dcdg_goods_specification_option.GOODS_COUNT
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    public Integer getGoodsCount() {
        return goodsCount;
    }

    /**
     * 数据库字段：关联商品数dcdg_goods_specification_option.GOODS_COUNT
     *
     * @param goodsCount the value for dcdg_goods_specification_option.GOODS_COUNT
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    /**
     * 数据库字段：添加时间dcdg_goods_specification_option.ADD_TIME
     *
     * @return the value of dcdg_goods_specification_option.ADD_TIME
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_goods_specification_option.ADD_TIME
     *
     * @param addTime the value for dcdg_goods_specification_option.ADD_TIME
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}