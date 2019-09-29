package com.louquanapp.dao.model;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_bussiness_customer_shipaddress
 *
 * @mbg.generated do_not_delete_during_merge Fri Mar 29 12:56:58 CST 2019
 */
public class ShipAddress {
    /**
     * 标识
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.SHIP_ID
     *
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    private String shipId;

    /**
     * 客户ID
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.CUST_ID
     *
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    private String custId;

    /**
     * 收货人姓名
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.RECEIVER_NAME
     *
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    private String receiverName;

    /**
     * 区域路径深度
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.AREA_PATH
     *
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    private String areaPath;

    /**
     * 收货地址
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.RECEIVE_ADDR
     *
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    private String receiveAddr;

    /**
     * 联系电话
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.LINK_PHONE
     *
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    private String linkPhone;

    /**
     * 固定电话
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.FIXED_PHONE
     *
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    private String fixedPhone;

    /**
     * 邮箱
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.EMAIL
     *
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    private String email;

    /**
     * 邮编
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.POST_CODE
     *
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    private String postCode;

    /**
     * 是否默认标记[1-默认 2-非默认]
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.DEFAULT_FLAG
     *
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */

    private Byte defaultFlag;

    /**
     * 添加时间
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.ADD_TIME
     *
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    private Date addTime;

    /**
     * 修改时间
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.UPDATE_TIME
     *
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    private Date updateTime;

    /**
     * 数据库字段：标识dcdg_bussiness_customer_shipaddress.SHIP_ID
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.SHIP_ID
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public String getShipId() {
        return shipId;
    }

    /**
     * 数据库字段：标识dcdg_bussiness_customer_shipaddress.SHIP_ID
     *
     * @param shipId the value for dcdg_bussiness_customer_shipaddress.SHIP_ID
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public void setShipId(String shipId) {
        this.shipId = shipId == null ? null : shipId.trim();
    }

    /**
     * 数据库字段：客户IDdcdg_bussiness_customer_shipaddress.CUST_ID
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.CUST_ID
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：客户IDdcdg_bussiness_customer_shipaddress.CUST_ID
     *
     * @param custId the value for dcdg_bussiness_customer_shipaddress.CUST_ID
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：收货人姓名dcdg_bussiness_customer_shipaddress.RECEIVER_NAME
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.RECEIVER_NAME
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * 数据库字段：收货人姓名dcdg_bussiness_customer_shipaddress.RECEIVER_NAME
     *
     * @param receiverName the value for dcdg_bussiness_customer_shipaddress.RECEIVER_NAME
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    /**
     * 数据库字段：区域路径深度dcdg_bussiness_customer_shipaddress.AREA_PATH
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.AREA_PATH
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public String getAreaPath() {
        return areaPath;
    }

    /**
     * 数据库字段：区域路径深度dcdg_bussiness_customer_shipaddress.AREA_PATH
     *
     * @param areaPath the value for dcdg_bussiness_customer_shipaddress.AREA_PATH
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public void setAreaPath(String areaPath) {
        this.areaPath = areaPath == null ? null : areaPath.trim();
    }

    /**
     * 数据库字段：收货地址dcdg_bussiness_customer_shipaddress.RECEIVE_ADDR
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.RECEIVE_ADDR
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public String getReceiveAddr() {
        return receiveAddr;
    }

    /**
     * 数据库字段：收货地址dcdg_bussiness_customer_shipaddress.RECEIVE_ADDR
     *
     * @param receiveAddr the value for dcdg_bussiness_customer_shipaddress.RECEIVE_ADDR
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public void setReceiveAddr(String receiveAddr) {
        this.receiveAddr = receiveAddr == null ? null : receiveAddr.trim();
    }

    /**
     * 数据库字段：联系电话dcdg_bussiness_customer_shipaddress.LINK_PHONE
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.LINK_PHONE
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public String getLinkPhone() {
        return linkPhone;
    }

    /**
     * 数据库字段：联系电话dcdg_bussiness_customer_shipaddress.LINK_PHONE
     *
     * @param linkPhone the value for dcdg_bussiness_customer_shipaddress.LINK_PHONE
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    /**
     * 数据库字段：固定电话dcdg_bussiness_customer_shipaddress.FIXED_PHONE
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.FIXED_PHONE
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public String getFixedPhone() {
        return fixedPhone;
    }

    /**
     * 数据库字段：固定电话dcdg_bussiness_customer_shipaddress.FIXED_PHONE
     *
     * @param fixedPhone the value for dcdg_bussiness_customer_shipaddress.FIXED_PHONE
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public void setFixedPhone(String fixedPhone) {
        this.fixedPhone = fixedPhone == null ? null : fixedPhone.trim();
    }

    /**
     * 数据库字段：邮箱dcdg_bussiness_customer_shipaddress.EMAIL
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.EMAIL
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public String getEmail() {
        return email;
    }

    /**
     * 数据库字段：邮箱dcdg_bussiness_customer_shipaddress.EMAIL
     *
     * @param email the value for dcdg_bussiness_customer_shipaddress.EMAIL
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 数据库字段：邮编dcdg_bussiness_customer_shipaddress.POST_CODE
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.POST_CODE
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 数据库字段：邮编dcdg_bussiness_customer_shipaddress.POST_CODE
     *
     * @param postCode the value for dcdg_bussiness_customer_shipaddress.POST_CODE
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    /**
     * 数据库字段：是否默认标记[1-默认 2-非默认]dcdg_bussiness_customer_shipaddress.DEFAULT_FLAG
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.DEFAULT_FLAG
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public Byte getDefaultFlag() {
        return defaultFlag;
    }

    /**
     * 数据库字段：是否默认标记[1-默认 2-非默认]dcdg_bussiness_customer_shipaddress.DEFAULT_FLAG
     *
     * @param defaultFlag the value for dcdg_bussiness_customer_shipaddress.DEFAULT_FLAG
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public void setDefaultFlag(Byte defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    /**
     * 数据库字段：添加时间dcdg_bussiness_customer_shipaddress.ADD_TIME
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.ADD_TIME
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_bussiness_customer_shipaddress.ADD_TIME
     *
     * @param addTime the value for dcdg_bussiness_customer_shipaddress.ADD_TIME
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：修改时间dcdg_bussiness_customer_shipaddress.UPDATE_TIME
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.UPDATE_TIME
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：修改时间dcdg_bussiness_customer_shipaddress.UPDATE_TIME
     *
     * @param updateTime the value for dcdg_bussiness_customer_shipaddress.UPDATE_TIME
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}