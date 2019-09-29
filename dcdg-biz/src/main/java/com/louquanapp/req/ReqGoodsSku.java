package com.louquanapp.req;


/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2019年04月03日08:01:47
 */
public class ReqGoodsSku extends ReqComm {

    private String token;
    /**
     * 主规格ID
     * <p>
     * 数据库字段名:DCDG_GOODS_GOODS_SKU.MAIN_SPEC
     *
     * @mbg.generated Fri Jul 13 15:57:46 CST 2018
     */
    private String mainSpec;
    /**
     * 主规格选项ID
     * <p>
     * 数据库字段名:DCDG_GOODS_GOODS_SKU.MAIN_SPEC_OPT
     *
     * @mbg.generated Fri Jul 13 15:57:46 CST 2018
     */
    private String mainSpecOpt;
    /**
     * 副规格ID
     * <p>
     * 数据库字段名:DCDG_GOODS_GOODS_SKU.VICE_SPEC
     *
     * @mbg.generated Fri Jul 13 15:57:46 CST 2018
     */
    private String viceSpec;
    /**
     * 副规格选项ID
     * <p>
     * 数据库字段名:DCDG_GOODS_GOODS_SKU.VICE_SPEC_OPT
     *
     * @mbg.generated Fri Jul 13 15:57:46 CST 2018
     */
    private String viceSpecOpt;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 数据库字段：主规格IDDCDG_GOODS_GOODS_SKU.MAIN_SPEC
     *
     * @return the value of DCDG_GOODS_GOODS_SKU.MAIN_SPEC
     * @mbg.generated Fri Jul 13 15:57:46 CST 2018
     */
    public String getMainSpec() {
        return mainSpec;
    }

    /**
     * 数据库字段：主规格IDDCDG_GOODS_GOODS_SKU.MAIN_SPEC
     *
     * @param mainSpec the value for DCDG_GOODS_GOODS_SKU.MAIN_SPEC
     * @mbg.generated Fri Jul 13 15:57:46 CST 2018
     */
    public void setMainSpec(String mainSpec) {
        this.mainSpec = mainSpec == null ? null : mainSpec.trim();
    }

    /**
     * 数据库字段：主规格选项IDDCDG_GOODS_GOODS_SKU.MAIN_SPEC_OPT
     *
     * @return the value of DCDG_GOODS_GOODS_SKU.MAIN_SPEC_OPT
     * @mbg.generated Fri Jul 13 15:57:46 CST 2018
     */
    public String getMainSpecOpt() {
        return mainSpecOpt;
    }

    /**
     * 数据库字段：主规格选项IDDCDG_GOODS_GOODS_SKU.MAIN_SPEC_OPT
     *
     * @param mainSpecOpt the value for DCDG_GOODS_GOODS_SKU.MAIN_SPEC_OPT
     * @mbg.generated Fri Jul 13 15:57:46 CST 2018
     */
    public void setMainSpecOpt(String mainSpecOpt) {
        this.mainSpecOpt = mainSpecOpt == null ? null : mainSpecOpt.trim();
    }

    /**
     * 数据库字段：副规格IDDCDG_GOODS_GOODS_SKU.VICE_SPEC
     *
     * @return the value of DCDG_GOODS_GOODS_SKU.VICE_SPEC
     * @mbg.generated Fri Jul 13 15:57:46 CST 2018
     */
    public String getViceSpec() {
        return viceSpec;
    }

    /**
     * 数据库字段：副规格IDDCDG_GOODS_GOODS_SKU.VICE_SPEC
     *
     * @param viceSpec the value for DCDG_GOODS_GOODS_SKU.VICE_SPEC
     * @mbg.generated Fri Jul 13 15:57:46 CST 2018
     */
    public void setViceSpec(String viceSpec) {
        this.viceSpec = viceSpec == null ? null : viceSpec.trim();
    }

    /**
     * 数据库字段：副规格选项IDDCDG_GOODS_GOODS_SKU.VICE_SPEC_OPT
     *
     * @return the value of DCDG_GOODS_GOODS_SKU.VICE_SPEC_OPT
     * @mbg.generated Fri Jul 13 15:57:46 CST 2018
     */
    public String getViceSpecOpt() {
        return viceSpecOpt;
    }

    /**
     * 数据库字段：副规格选项IDDCDG_GOODS_GOODS_SKU.VICE_SPEC_OPT
     *
     * @param viceSpecOpt the value for DCDG_GOODS_GOODS_SKU.VICE_SPEC_OPT
     * @mbg.generated Fri Jul 13 15:57:46 CST 2018
     */
    public void setViceSpecOpt(String viceSpecOpt) {
        this.viceSpecOpt = viceSpecOpt == null ? null : viceSpecOpt.trim();
    }
}
