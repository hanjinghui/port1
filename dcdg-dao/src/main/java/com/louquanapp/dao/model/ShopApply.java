package com.louquanapp.dao.model;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_bussiness_shopapply_base
 *
 * @mbg.generated do_not_delete_during_merge Thu Mar 28 22:02:54 CST 2019
 */
public class ShopApply {
    /**
     * 主键
     * <p>
     * 数据库字段名:dcdg_bussiness_shopapply_base.APPLY_ID
     *
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    private String applyId;

    /**
     * 店铺名称
     * <p>
     * 数据库字段名:dcdg_bussiness_shopapply_base.SHOP_NAME
     *
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    private String shopName;

    /**
     * 联系人
     * <p>
     * 数据库字段名:dcdg_bussiness_shopapply_base.LINK_MAN
     *
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    private String linkMan;

    /**
     * 手机号
     * <p>
     * 数据库字段名:dcdg_bussiness_shopapply_base.LINK_PHONE
     *
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    private String linkPhone;

    /**
     * 详细地址
     * <p>
     * 数据库字段名:dcdg_bussiness_shopapply_base.LINK_ADDR
     *
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    private String linkAddr;

    /**
     * 会员
     * <p>
     * 数据库字段名:dcdg_bussiness_shopapply_base.CUST_ID
     *
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    private String custId;

    /**
     * 状态[1-提交待接单 2-不接单 3-商家接单]
     * <p>
     * 数据库字段名:dcdg_bussiness_shopapply_base.APPLY_FLAG
     *
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    private Byte applyFlag;

    /**
     * 申请时间
     * <p>
     * 数据库字段名:dcdg_bussiness_shopapply_base.ADD_TIME
     *
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    private Date addTime;

    /**
     * 数据库字段：主键dcdg_bussiness_shopapply_base.APPLY_ID
     *
     * @return the value of dcdg_bussiness_shopapply_base.APPLY_ID
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    public String getApplyId() {
        return applyId;
    }

    /**
     * 数据库字段：主键dcdg_bussiness_shopapply_base.APPLY_ID
     *
     * @param applyId the value for dcdg_bussiness_shopapply_base.APPLY_ID
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    /**
     * 数据库字段：店铺名称dcdg_bussiness_shopapply_base.SHOP_NAME
     *
     * @return the value of dcdg_bussiness_shopapply_base.SHOP_NAME
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 数据库字段：店铺名称dcdg_bussiness_shopapply_base.SHOP_NAME
     *
     * @param shopName the value for dcdg_bussiness_shopapply_base.SHOP_NAME
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 数据库字段：联系人dcdg_bussiness_shopapply_base.LINK_MAN
     *
     * @return the value of dcdg_bussiness_shopapply_base.LINK_MAN
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    public String getLinkMan() {
        return linkMan;
    }

    /**
     * 数据库字段：联系人dcdg_bussiness_shopapply_base.LINK_MAN
     *
     * @param linkMan the value for dcdg_bussiness_shopapply_base.LINK_MAN
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    /**
     * 数据库字段：手机号dcdg_bussiness_shopapply_base.LINK_PHONE
     *
     * @return the value of dcdg_bussiness_shopapply_base.LINK_PHONE
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    public String getLinkPhone() {
        return linkPhone;
    }

    /**
     * 数据库字段：手机号dcdg_bussiness_shopapply_base.LINK_PHONE
     *
     * @param linkPhone the value for dcdg_bussiness_shopapply_base.LINK_PHONE
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    /**
     * 数据库字段：详细地址dcdg_bussiness_shopapply_base.LINK_ADDR
     *
     * @return the value of dcdg_bussiness_shopapply_base.LINK_ADDR
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    public String getLinkAddr() {
        return linkAddr;
    }

    /**
     * 数据库字段：详细地址dcdg_bussiness_shopapply_base.LINK_ADDR
     *
     * @param linkAddr the value for dcdg_bussiness_shopapply_base.LINK_ADDR
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    public void setLinkAddr(String linkAddr) {
        this.linkAddr = linkAddr == null ? null : linkAddr.trim();
    }

    /**
     * 数据库字段：会员dcdg_bussiness_shopapply_base.CUST_ID
     *
     * @return the value of dcdg_bussiness_shopapply_base.CUST_ID
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：会员dcdg_bussiness_shopapply_base.CUST_ID
     *
     * @param custId the value for dcdg_bussiness_shopapply_base.CUST_ID
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：状态[1-提交待接单 2-不接单 3-商家接单]dcdg_bussiness_shopapply_base.APPLY_FLAG
     *
     * @return the value of dcdg_bussiness_shopapply_base.APPLY_FLAG
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    public Byte getApplyFlag() {
        return applyFlag;
    }

    /**
     * 数据库字段：状态[1-提交待接单 2-不接单 3-商家接单]dcdg_bussiness_shopapply_base.APPLY_FLAG
     *
     * @param applyFlag the value for dcdg_bussiness_shopapply_base.APPLY_FLAG
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    public void setApplyFlag(Byte applyFlag) {
        this.applyFlag = applyFlag;
    }

    /**
     * 数据库字段：申请时间dcdg_bussiness_shopapply_base.ADD_TIME
     *
     * @return the value of dcdg_bussiness_shopapply_base.ADD_TIME
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：申请时间dcdg_bussiness_shopapply_base.ADD_TIME
     *
     * @param addTime the value for dcdg_bussiness_shopapply_base.ADD_TIME
     * @mbg.generated Thu Mar 28 22:02:54 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}