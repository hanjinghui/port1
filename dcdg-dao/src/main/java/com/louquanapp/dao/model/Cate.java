package com.louquanapp.dao.model;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_basic_cate_base
 *
 * @mbg.generated do_not_delete_during_merge Wed Apr 17 16:56:51 CST 2019
 */
public class Cate {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_basic_cate_base.CATE_ID
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    private String cateId;

    /**
     *   美食类型[1-经典推荐 2-新品上市 3-套餐推荐]
     *
     * 数据库字段名:dcdg_basic_cate_base.CATE_TYPE
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    private Byte cateType;

    /**
     *   美食名称
     *
     * 数据库字段名:dcdg_basic_cate_base.CATE_NAME
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    private String cateName;

    /**
     *   美食图片
     *
     * 数据库字段名:dcdg_basic_cate_base.CATE_IMG
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    private String cateImg;

    /**
     *   价格
     *
     * 数据库字段名:dcdg_basic_cate_base.CATE_PRICE
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    private Double catePrice;

    /**
     *   月售
     *
     * 数据库字段名:dcdg_basic_cate_base.CATE_MONTH_NUM
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    private Integer cateMonthNum;

    /**
     *   商家
     *
     * 数据库字段名:dcdg_basic_cate_base.SHOP_ID
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    private String shopId;

    /**
     *   状态[1-已发布 2-未发布]
     *
     * 数据库字段名:dcdg_basic_cate_base.CATE_STATUS
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    private Byte cateStatus;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_basic_cate_base.ADD_TIME
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    private Date addTime;

    /**
     *   更新时间
     *
     * 数据库字段名:dcdg_basic_cate_base.UPDATE_TIME
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    private Date updateTime;

    /**
     * 数据库字段：主键dcdg_basic_cate_base.CATE_ID
     *
     * @return  the value of dcdg_basic_cate_base.CATE_ID
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    public String getCateId() {
        return cateId;
    }

    /**
     * 数据库字段：主键dcdg_basic_cate_base.CATE_ID
     * @param cateId the value for dcdg_basic_cate_base.CATE_ID
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    public void setCateId(String cateId) {
        this.cateId = cateId == null ? null : cateId.trim();
    }

    /**
     * 数据库字段：美食类型[1-经典推荐 2-新品上市 3-套餐推荐]dcdg_basic_cate_base.CATE_TYPE
     *
     * @return  the value of dcdg_basic_cate_base.CATE_TYPE
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    public Byte getCateType() {
        return cateType;
    }

    /**
     * 数据库字段：美食类型[1-经典推荐 2-新品上市 3-套餐推荐]dcdg_basic_cate_base.CATE_TYPE
     * @param cateType the value for dcdg_basic_cate_base.CATE_TYPE
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    public void setCateType(Byte cateType) {
        this.cateType = cateType;
    }

    /**
     * 数据库字段：美食名称dcdg_basic_cate_base.CATE_NAME
     *
     * @return  the value of dcdg_basic_cate_base.CATE_NAME
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    public String getCateName() {
        return cateName;
    }

    /**
     * 数据库字段：美食名称dcdg_basic_cate_base.CATE_NAME
     * @param cateName the value for dcdg_basic_cate_base.CATE_NAME
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    public void setCateName(String cateName) {
        this.cateName = cateName == null ? null : cateName.trim();
    }

    /**
     * 数据库字段：美食图片dcdg_basic_cate_base.CATE_IMG
     *
     * @return  the value of dcdg_basic_cate_base.CATE_IMG
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    public String getCateImg() {
        return cateImg;
    }

    /**
     * 数据库字段：美食图片dcdg_basic_cate_base.CATE_IMG
     * @param cateImg the value for dcdg_basic_cate_base.CATE_IMG
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    public void setCateImg(String cateImg) {
        this.cateImg = cateImg == null ? null : cateImg.trim();
    }

    /**
     * 数据库字段：价格dcdg_basic_cate_base.CATE_PRICE
     *
     * @return  the value of dcdg_basic_cate_base.CATE_PRICE
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    public Double getCatePrice() {
        return catePrice;
    }

    /**
     * 数据库字段：价格dcdg_basic_cate_base.CATE_PRICE
     * @param catePrice the value for dcdg_basic_cate_base.CATE_PRICE
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    public void setCatePrice(Double catePrice) {
        this.catePrice = catePrice;
    }

    /**
     * 数据库字段：月售dcdg_basic_cate_base.CATE_MONTH_NUM
     *
     * @return  the value of dcdg_basic_cate_base.CATE_MONTH_NUM
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    public Integer getCateMonthNum() {
        return cateMonthNum;
    }

    /**
     * 数据库字段：月售dcdg_basic_cate_base.CATE_MONTH_NUM
     * @param cateMonthNum the value for dcdg_basic_cate_base.CATE_MONTH_NUM
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    public void setCateMonthNum(Integer cateMonthNum) {
        this.cateMonthNum = cateMonthNum;
    }

    /**
     * 数据库字段：商家dcdg_basic_cate_base.SHOP_ID
     *
     * @return  the value of dcdg_basic_cate_base.SHOP_ID
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * 数据库字段：商家dcdg_basic_cate_base.SHOP_ID
     * @param shopId the value for dcdg_basic_cate_base.SHOP_ID
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    /**
     * 数据库字段：状态[1-已发布 2-未发布]dcdg_basic_cate_base.CATE_STATUS
     *
     * @return  the value of dcdg_basic_cate_base.CATE_STATUS
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    public Byte getCateStatus() {
        return cateStatus;
    }

    /**
     * 数据库字段：状态[1-已发布 2-未发布]dcdg_basic_cate_base.CATE_STATUS
     * @param cateStatus the value for dcdg_basic_cate_base.CATE_STATUS
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    public void setCateStatus(Byte cateStatus) {
        this.cateStatus = cateStatus;
    }

    /**
     * 数据库字段：添加时间dcdg_basic_cate_base.ADD_TIME
     *
     * @return  the value of dcdg_basic_cate_base.ADD_TIME
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_basic_cate_base.ADD_TIME
     * @param addTime the value for dcdg_basic_cate_base.ADD_TIME
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：更新时间dcdg_basic_cate_base.UPDATE_TIME
     *
     * @return  the value of dcdg_basic_cate_base.UPDATE_TIME
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：更新时间dcdg_basic_cate_base.UPDATE_TIME
     * @param updateTime the value for dcdg_basic_cate_base.UPDATE_TIME
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}