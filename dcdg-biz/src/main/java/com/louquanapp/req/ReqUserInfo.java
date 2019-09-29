package com.louquanapp.req;

import java.util.Date;

/**
 * 修改昵称
 */
public class ReqUserInfo extends ReqToken {
    /**
     * 昵称
     */

    private String nickName;

    /**
     * 头像
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.HEAD_IMG
     *
     * @mbg.generated Tue Mar 26 14:27:01 CST 2019
     */
    private String headImg;

    /**
     * 所在区域路径
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.AREA_PATH
     *
     * @mbg.generated Tue Mar 26 14:27:01 CST 2019
     */
    private String areaPath;

    /**
     * 出生日期
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.BIRTH_DATE
     *
     * @mbg.generated Tue Mar 26 14:27:01 CST 2019
     */
    private Date birthDate;

    /**
     * 备注
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.REMARK
     *
     * @mbg.generated Tue Mar 26 14:27:01 CST 2019
     */
    private String remark;

    /**
     * 身份证号
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.ID_CARD
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String idCard;

    /**
     * 身份证正面
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.FRONT_ID_CARD
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String frontIdCard;


    /**
     * 身份证反面
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.END_ID_CARD
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private String endIdCard;

    /**
     * 性别[1-男 2-女 3-未知 4-保密]
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.CUST_SEX
     *
     * @mbg.generated Thu Mar 28 11:18:11 CST 2019
     */
    private Byte custSex;
    /**
     * 真实姓名
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_base.REAL_NAME
     *
     * @mbg.generated Tue Mar 26 14:27:01 CST 2019
     */
    private String realName;

    public Byte getCustSex() {
        return custSex;
    }

    public void setCustSex(Byte custSex) {
        this.custSex = custSex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getAreaPath() {
        return areaPath;
    }

    public void setAreaPath(String areaPath) {
        this.areaPath = areaPath;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getFrontIdCard() {
        return frontIdCard;
    }

    public void setFrontIdCard(String frontIdCard) {
        this.frontIdCard = frontIdCard;
    }

    public String getEndIdCard() {
        return endIdCard;
    }

    public void setEndIdCard(String endIdCard) {
        this.endIdCard = endIdCard;
    }
}
