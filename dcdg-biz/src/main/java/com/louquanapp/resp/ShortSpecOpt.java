package com.louquanapp.resp;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/7/13 下午6:36
 */
public class ShortSpecOpt {
    /**
     * 主键
     * <p>
     * 数据库字段名:CXY_GOODS_SPECIFICATION_OPTION.OPT_ID
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String optId;


    /**
     * 选项名称
     * <p>
     * 数据库字段名:CXY_GOODS_SPECIFICATION_OPTION.OPT_NAME
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String optName;
    private Boolean selected;

    /**
     * 数据库字段：主键CXY_GOODS_SPECIFICATION_OPTION.OPT_ID
     *
     * @return the value of CXY_GOODS_SPECIFICATION_OPTION.OPT_ID
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getOptId() {
        return optId;
    }

    /**
     * 数据库字段：主键CXY_GOODS_SPECIFICATION_OPTION.OPT_ID
     *
     * @param optId the value for CXY_GOODS_SPECIFICATION_OPTION.OPT_ID
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setOptId(String optId) {
        this.optId = optId == null ? null : optId.trim();
    }

    /**
     * 数据库字段：选项名称CXY_GOODS_SPECIFICATION_OPTION.OPT_NAME
     *
     * @return the value of CXY_GOODS_SPECIFICATION_OPTION.OPT_NAME
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getOptName() {
        return optName;
    }

    /**
     * 数据库字段：选项名称CXY_GOODS_SPECIFICATION_OPTION.OPT_NAME
     *
     * @param optName the value for CXY_GOODS_SPECIFICATION_OPTION.OPT_NAME
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setOptName(String optName) {
        this.optName = optName == null ? null : optName.trim();
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
