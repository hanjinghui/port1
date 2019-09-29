package com.louquanapp.dao.model;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_basic_express_base
 *
 * @mbg.generated do_not_delete_during_merge Fri Aug 09 15:01:59 CST 2019
 */
public class Express {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_basic_express_base.EXPRESS_ID
     *
     * @mbg.generated Fri Aug 09 15:01:59 CST 2019
     */
    private String expressId;

    /**
     *   快递公司名称
     *
     * 数据库字段名:dcdg_basic_express_base.EXPRESS_NAME
     *
     * @mbg.generated Fri Aug 09 15:01:59 CST 2019
     */
    private String expressName;

    /**
     *   快递公司编码
     *
     * 数据库字段名:dcdg_basic_express_base.EXPRESS_CODE
     *
     * @mbg.generated Fri Aug 09 15:01:59 CST 2019
     */
    private String expressCode;

    /**
     *   状态[1-启动 2-禁用]
     *
     * 数据库字段名:dcdg_basic_express_base.EXTRESS_STATUS
     *
     * @mbg.generated Fri Aug 09 15:01:59 CST 2019
     */
    private Byte extressStatus;

    /**
     * 数据库字段：主键dcdg_basic_express_base.EXPRESS_ID
     *
     * @return  the value of dcdg_basic_express_base.EXPRESS_ID
     *
     * @mbg.generated Fri Aug 09 15:01:59 CST 2019
     */
    public String getExpressId() {
        return expressId;
    }

    /**
     * 数据库字段：主键dcdg_basic_express_base.EXPRESS_ID
     * @param expressId the value for dcdg_basic_express_base.EXPRESS_ID
     *
     * @mbg.generated Fri Aug 09 15:01:59 CST 2019
     */
    public void setExpressId(String expressId) {
        this.expressId = expressId == null ? null : expressId.trim();
    }

    /**
     * 数据库字段：快递公司名称dcdg_basic_express_base.EXPRESS_NAME
     *
     * @return  the value of dcdg_basic_express_base.EXPRESS_NAME
     *
     * @mbg.generated Fri Aug 09 15:01:59 CST 2019
     */
    public String getExpressName() {
        return expressName;
    }

    /**
     * 数据库字段：快递公司名称dcdg_basic_express_base.EXPRESS_NAME
     * @param expressName the value for dcdg_basic_express_base.EXPRESS_NAME
     *
     * @mbg.generated Fri Aug 09 15:01:59 CST 2019
     */
    public void setExpressName(String expressName) {
        this.expressName = expressName == null ? null : expressName.trim();
    }

    /**
     * 数据库字段：快递公司编码dcdg_basic_express_base.EXPRESS_CODE
     *
     * @return  the value of dcdg_basic_express_base.EXPRESS_CODE
     *
     * @mbg.generated Fri Aug 09 15:01:59 CST 2019
     */
    public String getExpressCode() {
        return expressCode;
    }

    /**
     * 数据库字段：快递公司编码dcdg_basic_express_base.EXPRESS_CODE
     * @param expressCode the value for dcdg_basic_express_base.EXPRESS_CODE
     *
     * @mbg.generated Fri Aug 09 15:01:59 CST 2019
     */
    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode == null ? null : expressCode.trim();
    }

    /**
     * 数据库字段：状态[1-启动 2-禁用]dcdg_basic_express_base.EXTRESS_STATUS
     *
     * @return  the value of dcdg_basic_express_base.EXTRESS_STATUS
     *
     * @mbg.generated Fri Aug 09 15:01:59 CST 2019
     */
    public Byte getExtressStatus() {
        return extressStatus;
    }

    /**
     * 数据库字段：状态[1-启动 2-禁用]dcdg_basic_express_base.EXTRESS_STATUS
     * @param extressStatus the value for dcdg_basic_express_base.EXTRESS_STATUS
     *
     * @mbg.generated Fri Aug 09 15:01:59 CST 2019
     */
    public void setExtressStatus(Byte extressStatus) {
        this.extressStatus = extressStatus;
    }
}