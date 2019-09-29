package com.louquanapp.resp;

import java.util.List;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2019年04月11日21:21:09
 */
public class ShortSpec {

    /**
     * 主键
     * <p>
     * 数据库字段名:dcdg_goods_specification_baase.SPEC_ID
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String specId;

    /**
     * 规格名称
     * <p>
     * 数据库字段名:dcdg_goods_specification_baase.SPEC_NAME
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String specName;

    private List<ShortSpecOpt> specOpts;


    public List<ShortSpecOpt> getSpecOpts() {
        return specOpts;
    }

    public void setSpecOpts(List<ShortSpecOpt> specOpts) {
        this.specOpts = specOpts;
    }

    /**
     * 数据库字段：主键dcdg_goods_specification_baase.SPEC_ID
     *
     * @return the value of dcdg_goods_specification_baase.SPEC_ID
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getSpecId() {
        return specId;
    }

    /**
     * 数据库字段：主键dcdg_goods_specification_baase.SPEC_ID
     *
     * @param specId the value for dcdg_goods_specification_baase.SPEC_ID
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setSpecId(String specId) {
        this.specId = specId == null ? null : specId.trim();
    }

    /**
     * 数据库字段：规格名称dcdg_goods_specification_baase.SPEC_NAME
     *
     * @return the value of dcdg_goods_specification_baase.SPEC_NAME
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getSpecName() {
        return specName;
    }

    /**
     * 数据库字段：规格名称dcdg_goods_specification_baase.SPEC_NAME
     *
     * @param specName the value for dcdg_goods_specification_baase.SPEC_NAME
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }
}
