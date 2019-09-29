package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2019年03月29日12:51:23
 */
public class ReqShipAddress extends ReqToken {


    /**
     * 标识
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.SHIP_ID
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String shipId;

    /**
     * 收货人姓名
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.RECEIVER_NAME
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    @NotBlank(message = "收货人姓名不能为空")
    private String receiverName;

    /**
     * 区域路径深度
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.AREA_PATH
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    @NotBlank(message = "省市区不能为空")
    private String areaPath;

    /**
     * 收货地址
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.RECEIVE_ADDR
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    @NotBlank(message = "详细地址不能为空")
    private String receiveAddr;

    /**
     * 联系电话
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.LINK_PHONE
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "1[0-9]{10}", message = "手机号格式")
    private String linkPhone;

    /**
     * 固定电话
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.FIXED_PHONE
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String fixedPhone;

    /**
     * 邮箱
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.EMAIL
     *
     * @mbg.generated 2019年04月11日21:21:09
     */

    @Email(message = "邮箱格式不正确")
    private String email;

    /**
     * 邮编
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.POST_CODE
     *
     * @mbg.generated 2019年04月11日21:21:09
     */

    private String postCode;

    /**
     * 是否默认标记[1-默认 2-非默认]
     * <p>
     * 数据库字段名:dcdg_bussiness_customer_shipaddress.DEFAULT_FLAG
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    @Range(min = 1, max = 2, message = "defaultFlag范围是1-2")
    private Byte defaultFlag;


    /**
     * 数据库字段：收货人姓名dcdg_bussiness_customer_shipaddress.RECEIVER_NAME
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.RECEIVER_NAME
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * 数据库字段：收货人姓名dcdg_bussiness_customer_shipaddress.RECEIVER_NAME
     *
     * @param receiverName the value for dcdg_bussiness_customer_shipaddress.RECEIVER_NAME
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    /**
     * 数据库字段：区域路径深度dcdg_bussiness_customer_shipaddress.AREA_PATH
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.AREA_PATH
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getAreaPath() {
        return areaPath;
    }

    /**
     * 数据库字段：区域路径深度dcdg_bussiness_customer_shipaddress.AREA_PATH
     *
     * @param areaPath the value for dcdg_bussiness_customer_shipaddress.AREA_PATH
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setAreaPath(String areaPath) {
        this.areaPath = areaPath == null ? null : areaPath.trim();
    }

    /**
     * 数据库字段：收货地址dcdg_bussiness_customer_shipaddress.RECEIVE_ADDR
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.RECEIVE_ADDR
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getReceiveAddr() {
        return receiveAddr;
    }

    /**
     * 数据库字段：收货地址dcdg_bussiness_customer_shipaddress.RECEIVE_ADDR
     *
     * @param receiveAddr the value for dcdg_bussiness_customer_shipaddress.RECEIVE_ADDR
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setReceiveAddr(String receiveAddr) {
        this.receiveAddr = receiveAddr == null ? null : receiveAddr.trim();
    }

    /**
     * 数据库字段：联系电话dcdg_bussiness_customer_shipaddress.LINK_PHONE
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.LINK_PHONE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getLinkPhone() {
        return linkPhone;
    }

    /**
     * 数据库字段：联系电话dcdg_bussiness_customer_shipaddress.LINK_PHONE
     *
     * @param linkPhone the value for dcdg_bussiness_customer_shipaddress.LINK_PHONE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    /**
     * 数据库字段：固定电话dcdg_bussiness_customer_shipaddress.FIXED_PHONE
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.FIXED_PHONE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getFixedPhone() {
        return fixedPhone;
    }

    /**
     * 数据库字段：固定电话dcdg_bussiness_customer_shipaddress.FIXED_PHONE
     *
     * @param fixedPhone the value for dcdg_bussiness_customer_shipaddress.FIXED_PHONE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setFixedPhone(String fixedPhone) {
        this.fixedPhone = fixedPhone == null ? null : fixedPhone.trim();
    }

    /**
     * 数据库字段：邮箱dcdg_bussiness_customer_shipaddress.EMAIL
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.EMAIL
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getEmail() {
        return email;
    }

    /**
     * 数据库字段：邮箱dcdg_bussiness_customer_shipaddress.EMAIL
     *
     * @param email the value for dcdg_bussiness_customer_shipaddress.EMAIL
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 数据库字段：邮编dcdg_bussiness_customer_shipaddress.POST_CODE
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.POST_CODE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 数据库字段：邮编dcdg_bussiness_customer_shipaddress.POST_CODE
     *
     * @param postCode the value for dcdg_bussiness_customer_shipaddress.POST_CODE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    /**
     * 数据库字段：是否默认标记[1-默认 2-非默认]dcdg_bussiness_customer_shipaddress.DEFAULT_FLAG
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.DEFAULT_FLAG
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Byte getDefaultFlag() {
        return defaultFlag;
    }

    /**
     * 数据库字段：是否默认标记[1-默认 2-非默认]dcdg_bussiness_customer_shipaddress.DEFAULT_FLAG
     *
     * @param defaultFlag the value for dcdg_bussiness_customer_shipaddress.DEFAULT_FLAG
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setDefaultFlag(Byte defaultFlag) {
        this.defaultFlag = defaultFlag;
    }


    /**
     * 数据库字段：标识dcdg_bussiness_customer_shipaddress.SHIP_ID
     *
     * @return the value of dcdg_bussiness_customer_shipaddress.SHIP_ID
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getShipId() {
        return shipId;
    }

    /**
     * 数据库字段：标识dcdg_bussiness_customer_shipaddress.SHIP_ID
     *
     * @param shipId the value for dcdg_bussiness_customer_shipaddress.SHIP_ID
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setShipId(String shipId) {
        this.shipId = shipId == null ? null : shipId.trim();
    }

}
