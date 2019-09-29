package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.ShopExtra;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_goods_shop_base
 *
 * @mbg.generated do_not_delete_during_merge Fri Jun 28 17:38:17 CST 2019
 */
public class Shop extends ShopExtra {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_goods_shop_base.SHOP_ID
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String shopId;

    /**
     *   分类编号
     *
     * 数据库字段名:dcdg_goods_shop_base.CAT_ID
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String catId;

    /**
     *   分类路径
     *
     * 数据库字段名:dcdg_goods_shop_base.CAT_PATH
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String catPath;

    /**
     *   店铺名称
     *
     * 数据库字段名:dcdg_goods_shop_base.SHOP_NAME
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String shopName;

    /**
     *   店铺简介
     *
     * 数据库字段名:dcdg_goods_shop_base.SHOP_TITLE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String shopTitle;

    /**
     *   店铺Logo
     *
     * 数据库字段名:dcdg_goods_shop_base.SHOP_LOGO
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String shopLogo;

    /**
     *   店铺公告
     *
     * 数据库字段名:dcdg_goods_shop_base.SHOP_NOTICE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String shopNotice;

    /**
     *   店铺营业时间
     *
     * 数据库字段名:dcdg_goods_shop_base.SHOP_DESC
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String shopDesc;

    /**
     *   店铺商品评分
     *
     * 数据库字段名:dcdg_goods_shop_base.GOODS_SCORE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private Integer goodsScore;

    /**
     *   店铺服务态度评分
     *
     * 数据库字段名:dcdg_goods_shop_base.SERVICE_SCORE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private Integer serviceScore;

    /**
     *   店铺发货速度评分
     *
     * 数据库字段名:dcdg_goods_shop_base.SHIPPER_SCORE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private Integer shipperScore;

    /**
     *   店铺审核状态[2-待审核 3-审核失败 4-审核通过]
     *
     * 数据库字段名:dcdg_goods_shop_base.AUDIT_STATUS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private Byte auditStatus;

    /**
     *   店铺状态[3-禁用 4-可用]
     *
     * 数据库字段名:dcdg_goods_shop_base.SHOP_STATUS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private Byte shopStatus;

    /**
     *   所在区域
     *
     * 数据库字段名:dcdg_goods_shop_base.SHOP_AREA
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String shopArea;

    /**
     *   店铺具体地址
     *
     * 数据库字段名:dcdg_goods_shop_base.SHOP_ADDRESS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String shopAddress;

    /**
     *   审核不通过原因
     *
     * 数据库字段名:dcdg_goods_shop_base.REFUSE_REASON
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String refuseReason;

    /**
     *   审核人
     *
     * 数据库字段名:dcdg_goods_shop_base.AUDIT_USER
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String auditUser;

    /**
     *   认证类型[1-个人认证 2-企业认证 3-委托管理]
     *
     * 数据库字段名:dcdg_goods_shop_base.AUTH_TYPE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private Byte authType;

    /**
     *   店铺联系人
     *
     * 数据库字段名:dcdg_goods_shop_base.LINK_MAN
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String linkMan;

    /**
     *   联系人手机号
     *
     * 数据库字段名:dcdg_goods_shop_base.LINK_PHONE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String linkPhone;

    /**
     *   联系人电话
     *
     * 数据库字段名:dcdg_goods_shop_base.LINK_TEL
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String linkTel;

    /**
     *   联系人微信号
     *
     * 数据库字段名:dcdg_goods_shop_base.LINK_WECHAT
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String linkWechat;

    /**
     *   GRPS地址
     *
     * 数据库字段名:dcdg_goods_shop_base.GRPS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String grps;

    /**
     *   橱窗总数量
     *
     * 数据库字段名:dcdg_goods_shop_base.SHOWCASE_NUM
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private Integer showcaseNum;

    /**
     *   剩余橱窗数量
     *
     * 数据库字段名:dcdg_goods_shop_base.SHOWCASE_SURPLUS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private Integer showcaseSurplus;

    /**
     *   已用橱窗数量
     *
     * 数据库字段名:dcdg_goods_shop_base.SHOWCASE_USED
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private Integer showcaseUsed;

    /**
     *   开户行
     *
     * 数据库字段名:dcdg_goods_shop_base.BANK_NAME
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String bankName;

    /**
     *   开户人姓名
     *
     * 数据库字段名:dcdg_goods_shop_base.BANK_USER_NAME
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String bankUserName;

    /**
     *   关注人数
     *
     * 数据库字段名:dcdg_goods_shop_base.CHILD_COUNT
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private Integer childCount;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_goods_shop_base.ADD_TIME
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private Date addTime;

    /**
     *   修改时间
     *
     * 数据库字段名:dcdg_goods_shop_base.UPDATE_TIME
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private Date updateTime;

    /**
     *   金额
     *
     * 数据库字段名:dcdg_goods_shop_base.AMOUNT
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private Double amount;

    /**
     *   词条
     *
     * 数据库字段名:dcdg_goods_shop_base.ENTRY
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String entry;

    /**
     *   商铺类型[1-产品类 2-服务类]
     *
     * 数据库字段名:dcdg_goods_shop_base.SHOP_TYPE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private Byte shopType;

    /**
     *   前台用户id
     *
     * 数据库字段名:dcdg_goods_shop_base.CUST_ID
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String custId;

    /**
     *   GRPS地址
     *
     * 数据库字段名:dcdg_goods_shop_base.GRPS_ADRESS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String grpsAdress;

    /**
     *   营业执照
     *
     * 数据库字段名:dcdg_goods_shop_base.BUSINESS_LICENSE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String businessLicense;

    /**
     *   法人身份证
     *
     * 数据库字段名:dcdg_goods_shop_base.LEGAL_PERSON_ID_CARD
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String legalPersonIdCard;

    /**
     *   图片集
     *
     * 数据库字段名:dcdg_goods_shop_base.SHOP_IMGS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    private String shopImgs;

    /**
     * 数据库字段：主键dcdg_goods_shop_base.SHOP_ID
     *
     * @return  the value of dcdg_goods_shop_base.SHOP_ID
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * 数据库字段：主键dcdg_goods_shop_base.SHOP_ID
     * @param shopId the value for dcdg_goods_shop_base.SHOP_ID
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    /**
     * 数据库字段：分类编号dcdg_goods_shop_base.CAT_ID
     *
     * @return  the value of dcdg_goods_shop_base.CAT_ID
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getCatId() {
        return catId;
    }

    /**
     * 数据库字段：分类编号dcdg_goods_shop_base.CAT_ID
     * @param catId the value for dcdg_goods_shop_base.CAT_ID
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setCatId(String catId) {
        this.catId = catId == null ? null : catId.trim();
    }

    /**
     * 数据库字段：分类路径dcdg_goods_shop_base.CAT_PATH
     *
     * @return  the value of dcdg_goods_shop_base.CAT_PATH
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getCatPath() {
        return catPath;
    }

    /**
     * 数据库字段：分类路径dcdg_goods_shop_base.CAT_PATH
     * @param catPath the value for dcdg_goods_shop_base.CAT_PATH
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setCatPath(String catPath) {
        this.catPath = catPath == null ? null : catPath.trim();
    }

    /**
     * 数据库字段：店铺名称dcdg_goods_shop_base.SHOP_NAME
     *
     * @return  the value of dcdg_goods_shop_base.SHOP_NAME
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 数据库字段：店铺名称dcdg_goods_shop_base.SHOP_NAME
     * @param shopName the value for dcdg_goods_shop_base.SHOP_NAME
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 数据库字段：店铺简介dcdg_goods_shop_base.SHOP_TITLE
     *
     * @return  the value of dcdg_goods_shop_base.SHOP_TITLE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getShopTitle() {
        return shopTitle;
    }

    /**
     * 数据库字段：店铺简介dcdg_goods_shop_base.SHOP_TITLE
     * @param shopTitle the value for dcdg_goods_shop_base.SHOP_TITLE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setShopTitle(String shopTitle) {
        this.shopTitle = shopTitle == null ? null : shopTitle.trim();
    }

    /**
     * 数据库字段：店铺Logodcdg_goods_shop_base.SHOP_LOGO
     *
     * @return  the value of dcdg_goods_shop_base.SHOP_LOGO
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getShopLogo() {
        return shopLogo;
    }

    /**
     * 数据库字段：店铺Logodcdg_goods_shop_base.SHOP_LOGO
     * @param shopLogo the value for dcdg_goods_shop_base.SHOP_LOGO
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo == null ? null : shopLogo.trim();
    }

    /**
     * 数据库字段：店铺公告dcdg_goods_shop_base.SHOP_NOTICE
     *
     * @return  the value of dcdg_goods_shop_base.SHOP_NOTICE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getShopNotice() {
        return shopNotice;
    }

    /**
     * 数据库字段：店铺公告dcdg_goods_shop_base.SHOP_NOTICE
     * @param shopNotice the value for dcdg_goods_shop_base.SHOP_NOTICE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setShopNotice(String shopNotice) {
        this.shopNotice = shopNotice == null ? null : shopNotice.trim();
    }

    /**
     * 数据库字段：店铺营业时间dcdg_goods_shop_base.SHOP_DESC
     *
     * @return  the value of dcdg_goods_shop_base.SHOP_DESC
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getShopDesc() {
        return shopDesc;
    }

    /**
     * 数据库字段：店铺营业时间dcdg_goods_shop_base.SHOP_DESC
     * @param shopDesc the value for dcdg_goods_shop_base.SHOP_DESC
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc == null ? null : shopDesc.trim();
    }

    /**
     * 数据库字段：店铺商品评分dcdg_goods_shop_base.GOODS_SCORE
     *
     * @return  the value of dcdg_goods_shop_base.GOODS_SCORE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public Integer getGoodsScore() {
        return goodsScore;
    }

    /**
     * 数据库字段：店铺商品评分dcdg_goods_shop_base.GOODS_SCORE
     * @param goodsScore the value for dcdg_goods_shop_base.GOODS_SCORE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setGoodsScore(Integer goodsScore) {
        this.goodsScore = goodsScore;
    }

    /**
     * 数据库字段：店铺服务态度评分dcdg_goods_shop_base.SERVICE_SCORE
     *
     * @return  the value of dcdg_goods_shop_base.SERVICE_SCORE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public Integer getServiceScore() {
        return serviceScore;
    }

    /**
     * 数据库字段：店铺服务态度评分dcdg_goods_shop_base.SERVICE_SCORE
     * @param serviceScore the value for dcdg_goods_shop_base.SERVICE_SCORE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setServiceScore(Integer serviceScore) {
        this.serviceScore = serviceScore;
    }

    /**
     * 数据库字段：店铺发货速度评分dcdg_goods_shop_base.SHIPPER_SCORE
     *
     * @return  the value of dcdg_goods_shop_base.SHIPPER_SCORE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public Integer getShipperScore() {
        return shipperScore;
    }

    /**
     * 数据库字段：店铺发货速度评分dcdg_goods_shop_base.SHIPPER_SCORE
     * @param shipperScore the value for dcdg_goods_shop_base.SHIPPER_SCORE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setShipperScore(Integer shipperScore) {
        this.shipperScore = shipperScore;
    }

    /**
     * 数据库字段：店铺审核状态[2-待审核 3-审核失败 4-审核通过]dcdg_goods_shop_base.AUDIT_STATUS
     *
     * @return  the value of dcdg_goods_shop_base.AUDIT_STATUS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public Byte getAuditStatus() {
        return auditStatus;
    }

    /**
     * 数据库字段：店铺审核状态[2-待审核 3-审核失败 4-审核通过]dcdg_goods_shop_base.AUDIT_STATUS
     * @param auditStatus the value for dcdg_goods_shop_base.AUDIT_STATUS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 数据库字段：店铺状态[3-禁用 4-可用]dcdg_goods_shop_base.SHOP_STATUS
     *
     * @return  the value of dcdg_goods_shop_base.SHOP_STATUS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public Byte getShopStatus() {
        return shopStatus;
    }

    /**
     * 数据库字段：店铺状态[3-禁用 4-可用]dcdg_goods_shop_base.SHOP_STATUS
     * @param shopStatus the value for dcdg_goods_shop_base.SHOP_STATUS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setShopStatus(Byte shopStatus) {
        this.shopStatus = shopStatus;
    }

    /**
     * 数据库字段：所在区域dcdg_goods_shop_base.SHOP_AREA
     *
     * @return  the value of dcdg_goods_shop_base.SHOP_AREA
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getShopArea() {
        return shopArea;
    }

    /**
     * 数据库字段：所在区域dcdg_goods_shop_base.SHOP_AREA
     * @param shopArea the value for dcdg_goods_shop_base.SHOP_AREA
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setShopArea(String shopArea) {
        this.shopArea = shopArea == null ? null : shopArea.trim();
    }

    /**
     * 数据库字段：店铺具体地址dcdg_goods_shop_base.SHOP_ADDRESS
     *
     * @return  the value of dcdg_goods_shop_base.SHOP_ADDRESS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getShopAddress() {
        return shopAddress;
    }

    /**
     * 数据库字段：店铺具体地址dcdg_goods_shop_base.SHOP_ADDRESS
     * @param shopAddress the value for dcdg_goods_shop_base.SHOP_ADDRESS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress == null ? null : shopAddress.trim();
    }

    /**
     * 数据库字段：审核不通过原因dcdg_goods_shop_base.REFUSE_REASON
     *
     * @return  the value of dcdg_goods_shop_base.REFUSE_REASON
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getRefuseReason() {
        return refuseReason;
    }

    /**
     * 数据库字段：审核不通过原因dcdg_goods_shop_base.REFUSE_REASON
     * @param refuseReason the value for dcdg_goods_shop_base.REFUSE_REASON
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason == null ? null : refuseReason.trim();
    }

    /**
     * 数据库字段：审核人dcdg_goods_shop_base.AUDIT_USER
     *
     * @return  the value of dcdg_goods_shop_base.AUDIT_USER
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getAuditUser() {
        return auditUser;
    }

    /**
     * 数据库字段：审核人dcdg_goods_shop_base.AUDIT_USER
     * @param auditUser the value for dcdg_goods_shop_base.AUDIT_USER
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser == null ? null : auditUser.trim();
    }

    /**
     * 数据库字段：认证类型[1-个人认证 2-企业认证 3-委托管理]dcdg_goods_shop_base.AUTH_TYPE
     *
     * @return  the value of dcdg_goods_shop_base.AUTH_TYPE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public Byte getAuthType() {
        return authType;
    }

    /**
     * 数据库字段：认证类型[1-个人认证 2-企业认证 3-委托管理]dcdg_goods_shop_base.AUTH_TYPE
     * @param authType the value for dcdg_goods_shop_base.AUTH_TYPE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setAuthType(Byte authType) {
        this.authType = authType;
    }

    /**
     * 数据库字段：店铺联系人dcdg_goods_shop_base.LINK_MAN
     *
     * @return  the value of dcdg_goods_shop_base.LINK_MAN
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getLinkMan() {
        return linkMan;
    }

    /**
     * 数据库字段：店铺联系人dcdg_goods_shop_base.LINK_MAN
     * @param linkMan the value for dcdg_goods_shop_base.LINK_MAN
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    /**
     * 数据库字段：联系人手机号dcdg_goods_shop_base.LINK_PHONE
     *
     * @return  the value of dcdg_goods_shop_base.LINK_PHONE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getLinkPhone() {
        return linkPhone;
    }

    /**
     * 数据库字段：联系人手机号dcdg_goods_shop_base.LINK_PHONE
     * @param linkPhone the value for dcdg_goods_shop_base.LINK_PHONE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    /**
     * 数据库字段：联系人电话dcdg_goods_shop_base.LINK_TEL
     *
     * @return  the value of dcdg_goods_shop_base.LINK_TEL
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getLinkTel() {
        return linkTel;
    }

    /**
     * 数据库字段：联系人电话dcdg_goods_shop_base.LINK_TEL
     * @param linkTel the value for dcdg_goods_shop_base.LINK_TEL
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel == null ? null : linkTel.trim();
    }

    /**
     * 数据库字段：联系人微信号dcdg_goods_shop_base.LINK_WECHAT
     *
     * @return  the value of dcdg_goods_shop_base.LINK_WECHAT
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getLinkWechat() {
        return linkWechat;
    }

    /**
     * 数据库字段：联系人微信号dcdg_goods_shop_base.LINK_WECHAT
     * @param linkWechat the value for dcdg_goods_shop_base.LINK_WECHAT
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setLinkWechat(String linkWechat) {
        this.linkWechat = linkWechat == null ? null : linkWechat.trim();
    }

    /**
     * 数据库字段：GRPS地址dcdg_goods_shop_base.GRPS
     *
     * @return  the value of dcdg_goods_shop_base.GRPS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getGrps() {
        return grps;
    }

    /**
     * 数据库字段：GRPS地址dcdg_goods_shop_base.GRPS
     * @param grps the value for dcdg_goods_shop_base.GRPS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setGrps(String grps) {
        this.grps = grps == null ? null : grps.trim();
    }

    /**
     * 数据库字段：橱窗总数量dcdg_goods_shop_base.SHOWCASE_NUM
     *
     * @return  the value of dcdg_goods_shop_base.SHOWCASE_NUM
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public Integer getShowcaseNum() {
        return showcaseNum;
    }

    /**
     * 数据库字段：橱窗总数量dcdg_goods_shop_base.SHOWCASE_NUM
     * @param showcaseNum the value for dcdg_goods_shop_base.SHOWCASE_NUM
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setShowcaseNum(Integer showcaseNum) {
        this.showcaseNum = showcaseNum;
    }

    /**
     * 数据库字段：剩余橱窗数量dcdg_goods_shop_base.SHOWCASE_SURPLUS
     *
     * @return  the value of dcdg_goods_shop_base.SHOWCASE_SURPLUS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public Integer getShowcaseSurplus() {
        return showcaseSurplus;
    }

    /**
     * 数据库字段：剩余橱窗数量dcdg_goods_shop_base.SHOWCASE_SURPLUS
     * @param showcaseSurplus the value for dcdg_goods_shop_base.SHOWCASE_SURPLUS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setShowcaseSurplus(Integer showcaseSurplus) {
        this.showcaseSurplus = showcaseSurplus;
    }

    /**
     * 数据库字段：已用橱窗数量dcdg_goods_shop_base.SHOWCASE_USED
     *
     * @return  the value of dcdg_goods_shop_base.SHOWCASE_USED
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public Integer getShowcaseUsed() {
        return showcaseUsed;
    }

    /**
     * 数据库字段：已用橱窗数量dcdg_goods_shop_base.SHOWCASE_USED
     * @param showcaseUsed the value for dcdg_goods_shop_base.SHOWCASE_USED
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setShowcaseUsed(Integer showcaseUsed) {
        this.showcaseUsed = showcaseUsed;
    }

    /**
     * 数据库字段：开户行dcdg_goods_shop_base.BANK_NAME
     *
     * @return  the value of dcdg_goods_shop_base.BANK_NAME
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 数据库字段：开户行dcdg_goods_shop_base.BANK_NAME
     * @param bankName the value for dcdg_goods_shop_base.BANK_NAME
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 数据库字段：开户人姓名dcdg_goods_shop_base.BANK_USER_NAME
     *
     * @return  the value of dcdg_goods_shop_base.BANK_USER_NAME
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getBankUserName() {
        return bankUserName;
    }

    /**
     * 数据库字段：开户人姓名dcdg_goods_shop_base.BANK_USER_NAME
     * @param bankUserName the value for dcdg_goods_shop_base.BANK_USER_NAME
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setBankUserName(String bankUserName) {
        this.bankUserName = bankUserName == null ? null : bankUserName.trim();
    }

    /**
     * 数据库字段：关注人数dcdg_goods_shop_base.CHILD_COUNT
     *
     * @return  the value of dcdg_goods_shop_base.CHILD_COUNT
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public Integer getChildCount() {
        return childCount;
    }

    /**
     * 数据库字段：关注人数dcdg_goods_shop_base.CHILD_COUNT
     * @param childCount the value for dcdg_goods_shop_base.CHILD_COUNT
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    /**
     * 数据库字段：添加时间dcdg_goods_shop_base.ADD_TIME
     *
     * @return  the value of dcdg_goods_shop_base.ADD_TIME
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_goods_shop_base.ADD_TIME
     * @param addTime the value for dcdg_goods_shop_base.ADD_TIME
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：修改时间dcdg_goods_shop_base.UPDATE_TIME
     *
     * @return  the value of dcdg_goods_shop_base.UPDATE_TIME
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：修改时间dcdg_goods_shop_base.UPDATE_TIME
     * @param updateTime the value for dcdg_goods_shop_base.UPDATE_TIME
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 数据库字段：金额dcdg_goods_shop_base.AMOUNT
     *
     * @return  the value of dcdg_goods_shop_base.AMOUNT
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * 数据库字段：金额dcdg_goods_shop_base.AMOUNT
     * @param amount the value for dcdg_goods_shop_base.AMOUNT
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * 数据库字段：词条dcdg_goods_shop_base.ENTRY
     *
     * @return  the value of dcdg_goods_shop_base.ENTRY
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getEntry() {
        return entry;
    }

    /**
     * 数据库字段：词条dcdg_goods_shop_base.ENTRY
     * @param entry the value for dcdg_goods_shop_base.ENTRY
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setEntry(String entry) {
        this.entry = entry == null ? null : entry.trim();
    }

    /**
     * 数据库字段：商铺类型[1-产品类 2-服务类]dcdg_goods_shop_base.SHOP_TYPE
     *
     * @return  the value of dcdg_goods_shop_base.SHOP_TYPE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public Byte getShopType() {
        return shopType;
    }

    /**
     * 数据库字段：商铺类型[1-产品类 2-服务类]dcdg_goods_shop_base.SHOP_TYPE
     * @param shopType the value for dcdg_goods_shop_base.SHOP_TYPE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setShopType(Byte shopType) {
        this.shopType = shopType;
    }

    /**
     * 数据库字段：前台用户iddcdg_goods_shop_base.CUST_ID
     *
     * @return  the value of dcdg_goods_shop_base.CUST_ID
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：前台用户iddcdg_goods_shop_base.CUST_ID
     * @param custId the value for dcdg_goods_shop_base.CUST_ID
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：GRPS地址dcdg_goods_shop_base.GRPS_ADRESS
     *
     * @return  the value of dcdg_goods_shop_base.GRPS_ADRESS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getGrpsAdress() {
        return grpsAdress;
    }

    /**
     * 数据库字段：GRPS地址dcdg_goods_shop_base.GRPS_ADRESS
     * @param grpsAdress the value for dcdg_goods_shop_base.GRPS_ADRESS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setGrpsAdress(String grpsAdress) {
        this.grpsAdress = grpsAdress == null ? null : grpsAdress.trim();
    }

    /**
     * 数据库字段：营业执照dcdg_goods_shop_base.BUSINESS_LICENSE
     *
     * @return  the value of dcdg_goods_shop_base.BUSINESS_LICENSE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getBusinessLicense() {
        return businessLicense;
    }

    /**
     * 数据库字段：营业执照dcdg_goods_shop_base.BUSINESS_LICENSE
     * @param businessLicense the value for dcdg_goods_shop_base.BUSINESS_LICENSE
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    /**
     * 数据库字段：法人身份证dcdg_goods_shop_base.LEGAL_PERSON_ID_CARD
     *
     * @return  the value of dcdg_goods_shop_base.LEGAL_PERSON_ID_CARD
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getLegalPersonIdCard() {
        return legalPersonIdCard;
    }

    /**
     * 数据库字段：法人身份证dcdg_goods_shop_base.LEGAL_PERSON_ID_CARD
     * @param legalPersonIdCard the value for dcdg_goods_shop_base.LEGAL_PERSON_ID_CARD
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setLegalPersonIdCard(String legalPersonIdCard) {
        this.legalPersonIdCard = legalPersonIdCard == null ? null : legalPersonIdCard.trim();
    }

    /**
     * 数据库字段：图片集dcdg_goods_shop_base.SHOP_IMGS
     *
     * @return  the value of dcdg_goods_shop_base.SHOP_IMGS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public String getShopImgs() {
        return shopImgs;
    }

    /**
     * 数据库字段：图片集dcdg_goods_shop_base.SHOP_IMGS
     * @param shopImgs the value for dcdg_goods_shop_base.SHOP_IMGS
     *
     * @mbg.generated Fri Jun 28 17:38:17 CST 2019
     */
    public void setShopImgs(String shopImgs) {
        this.shopImgs = shopImgs == null ? null : shopImgs.trim();
    }
}