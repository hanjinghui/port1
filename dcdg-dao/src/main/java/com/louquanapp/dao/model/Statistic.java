package com.louquanapp.dao.model;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_order_statistic_base
 *
 * @mbg.generated do_not_delete_during_merge Fri Apr 26 16:33:41 CST 2019
 */
public class Statistic {
    /**
     *
     * 数据库字段名:dcdg_order_statistic_base.DAY_ID
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    private String dayId;

    /**
     *   统计日期
     *
     * 数据库字段名:dcdg_order_statistic_base.DAY_DATE
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    private Date dayDate;

    /**
     *   当前周
     *
     * 数据库字段名:dcdg_order_statistic_base.DAY_WEEK
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    private Byte dayWeek;

    /**
     *   当前月
     *
     * 数据库字段名:dcdg_order_statistic_base.DAY_MONTH
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    private Byte dayMonth;

    /**
     *   当前年份
     *
     * 数据库字段名:dcdg_order_statistic_base.DAY_YEAR
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    private Integer dayYear;

    /**
     *   日销量
     *
     * 数据库字段名:dcdg_order_statistic_base.DAY_COUNT
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    private Integer dayCount;

    /**
     *   日销售额
     *
     * 数据库字段名:dcdg_order_statistic_base.DAY_MONEY
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    private Double dayMoney;

    /**
     *   日消耗积分
     *
     * 数据库字段名:dcdg_order_statistic_base.DAY_POINT
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    private Double dayPoint;

    /**
     *   日消耗余额
     *
     * 数据库字段名:dcdg_order_statistic_base.DAY_COMSUMER
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    private Double dayComsumer;

    /**
     *   店铺ID
     *
     * 数据库字段名:dcdg_order_statistic_base.SHOP_ID
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    private String shopId;

    /**
     *   店铺名称
     *
     * 数据库字段名:dcdg_order_statistic_base.SHOP_NAME
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    private String shopName;

    /**
     *   餐饮[1-是 2-否]
     *
     * 数据库字段名:dcdg_order_statistic_base.IS_PROMOTION
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    private Byte isPromotion;

    /**
     * 数据库字段：dcdg_order_statistic_base.DAY_ID
     *
     * @return  the value of dcdg_order_statistic_base.DAY_ID
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public String getDayId() {
        return dayId;
    }

    /**
     * 数据库字段：dcdg_order_statistic_base.DAY_ID
     * @param dayId the value for dcdg_order_statistic_base.DAY_ID
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public void setDayId(String dayId) {
        this.dayId = dayId == null ? null : dayId.trim();
    }

    /**
     * 数据库字段：统计日期dcdg_order_statistic_base.DAY_DATE
     *
     * @return  the value of dcdg_order_statistic_base.DAY_DATE
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public Date getDayDate() {
        return dayDate;
    }

    /**
     * 数据库字段：统计日期dcdg_order_statistic_base.DAY_DATE
     * @param dayDate the value for dcdg_order_statistic_base.DAY_DATE
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public void setDayDate(Date dayDate) {
        this.dayDate = dayDate;
    }

    /**
     * 数据库字段：当前周dcdg_order_statistic_base.DAY_WEEK
     *
     * @return  the value of dcdg_order_statistic_base.DAY_WEEK
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public Byte getDayWeek() {
        return dayWeek;
    }

    /**
     * 数据库字段：当前周dcdg_order_statistic_base.DAY_WEEK
     * @param dayWeek the value for dcdg_order_statistic_base.DAY_WEEK
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public void setDayWeek(Byte dayWeek) {
        this.dayWeek = dayWeek;
    }

    /**
     * 数据库字段：当前月dcdg_order_statistic_base.DAY_MONTH
     *
     * @return  the value of dcdg_order_statistic_base.DAY_MONTH
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public Byte getDayMonth() {
        return dayMonth;
    }

    /**
     * 数据库字段：当前月dcdg_order_statistic_base.DAY_MONTH
     * @param dayMonth the value for dcdg_order_statistic_base.DAY_MONTH
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public void setDayMonth(Byte dayMonth) {
        this.dayMonth = dayMonth;
    }

    /**
     * 数据库字段：当前年份dcdg_order_statistic_base.DAY_YEAR
     *
     * @return  the value of dcdg_order_statistic_base.DAY_YEAR
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public Integer getDayYear() {
        return dayYear;
    }

    /**
     * 数据库字段：当前年份dcdg_order_statistic_base.DAY_YEAR
     * @param dayYear the value for dcdg_order_statistic_base.DAY_YEAR
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public void setDayYear(Integer dayYear) {
        this.dayYear = dayYear;
    }

    /**
     * 数据库字段：日销量dcdg_order_statistic_base.DAY_COUNT
     *
     * @return  the value of dcdg_order_statistic_base.DAY_COUNT
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public Integer getDayCount() {
        return dayCount;
    }

    /**
     * 数据库字段：日销量dcdg_order_statistic_base.DAY_COUNT
     * @param dayCount the value for dcdg_order_statistic_base.DAY_COUNT
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public void setDayCount(Integer dayCount) {
        this.dayCount = dayCount;
    }

    /**
     * 数据库字段：日销售额dcdg_order_statistic_base.DAY_MONEY
     *
     * @return  the value of dcdg_order_statistic_base.DAY_MONEY
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public Double getDayMoney() {
        return dayMoney;
    }

    /**
     * 数据库字段：日销售额dcdg_order_statistic_base.DAY_MONEY
     * @param dayMoney the value for dcdg_order_statistic_base.DAY_MONEY
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public void setDayMoney(Double dayMoney) {
        this.dayMoney = dayMoney;
    }

    /**
     * 数据库字段：日消耗积分dcdg_order_statistic_base.DAY_POINT
     *
     * @return  the value of dcdg_order_statistic_base.DAY_POINT
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public Double getDayPoint() {
        return dayPoint;
    }

    /**
     * 数据库字段：日消耗积分dcdg_order_statistic_base.DAY_POINT
     * @param dayPoint the value for dcdg_order_statistic_base.DAY_POINT
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public void setDayPoint(Double dayPoint) {
        this.dayPoint = dayPoint;
    }

    /**
     * 数据库字段：日消耗余额dcdg_order_statistic_base.DAY_COMSUMER
     *
     * @return  the value of dcdg_order_statistic_base.DAY_COMSUMER
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public Double getDayComsumer() {
        return dayComsumer;
    }

    /**
     * 数据库字段：日消耗余额dcdg_order_statistic_base.DAY_COMSUMER
     * @param dayComsumer the value for dcdg_order_statistic_base.DAY_COMSUMER
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public void setDayComsumer(Double dayComsumer) {
        this.dayComsumer = dayComsumer;
    }

    /**
     * 数据库字段：店铺IDdcdg_order_statistic_base.SHOP_ID
     *
     * @return  the value of dcdg_order_statistic_base.SHOP_ID
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * 数据库字段：店铺IDdcdg_order_statistic_base.SHOP_ID
     * @param shopId the value for dcdg_order_statistic_base.SHOP_ID
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    /**
     * 数据库字段：店铺名称dcdg_order_statistic_base.SHOP_NAME
     *
     * @return  the value of dcdg_order_statistic_base.SHOP_NAME
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 数据库字段：店铺名称dcdg_order_statistic_base.SHOP_NAME
     * @param shopName the value for dcdg_order_statistic_base.SHOP_NAME
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 数据库字段：餐饮[1-是 2-否]dcdg_order_statistic_base.IS_PROMOTION
     *
     * @return  the value of dcdg_order_statistic_base.IS_PROMOTION
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public Byte getIsPromotion() {
        return isPromotion;
    }

    /**
     * 数据库字段：餐饮[1-是 2-否]dcdg_order_statistic_base.IS_PROMOTION
     * @param isPromotion the value for dcdg_order_statistic_base.IS_PROMOTION
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    public void setIsPromotion(Byte isPromotion) {
        this.isPromotion = isPromotion;
    }
}