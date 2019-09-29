package com.louquanapp.dao.model;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_bussiness_order_pay
 *
 * @mbg.generated do_not_delete_during_merge Fri Jun 21 09:56:25 CST 2019
 */
public class OrderPay {
    /**
     *   主键（订单号）
     *
     * 数据库字段名:dcdg_bussiness_order_pay.ORDER_NO
     *
     * @mbg.generated Fri Jun 21 09:56:25 CST 2019
     */
    private String orderNo;

    /**
     *   支付状态[1-支付前 2-支付后]
     *
     * 数据库字段名:dcdg_bussiness_order_pay.PAY_STATUS
     *
     * @mbg.generated Fri Jun 21 09:56:25 CST 2019
     */
    private Byte payStatus;

    /**
     *   支付前时间
     *
     * 数据库字段名:dcdg_bussiness_order_pay.BEFORE_TIME
     *
     * @mbg.generated Fri Jun 21 09:56:25 CST 2019
     */
    private Date beforeTime;

    /**
     *   支付后时间
     *
     * 数据库字段名:dcdg_bussiness_order_pay.AFTER_TIME
     *
     * @mbg.generated Fri Jun 21 09:56:25 CST 2019
     */
    private Date afterTime;

    /**
     *   库存扣减时间
     *
     * 数据库字段名:dcdg_bussiness_order_pay.DEDUCTION_STOCK_TIME
     *
     * @mbg.generated Fri Jun 21 09:56:25 CST 2019
     */
    private Date deductionStockTime;

    /**
     *   库存恢复时间
     *
     * 数据库字段名:dcdg_bussiness_order_pay.ADD_STOCK_TIME
     *
     * @mbg.generated Fri Jun 21 09:56:25 CST 2019
     */
    private Date addStockTime;

    /**
     * 数据库字段：主键（订单号）dcdg_bussiness_order_pay.ORDER_NO
     *
     * @return  the value of dcdg_bussiness_order_pay.ORDER_NO
     *
     * @mbg.generated Fri Jun 21 09:56:25 CST 2019
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 数据库字段：主键（订单号）dcdg_bussiness_order_pay.ORDER_NO
     * @param orderNo the value for dcdg_bussiness_order_pay.ORDER_NO
     *
     * @mbg.generated Fri Jun 21 09:56:25 CST 2019
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * 数据库字段：支付状态[1-支付前 2-支付后]dcdg_bussiness_order_pay.PAY_STATUS
     *
     * @return  the value of dcdg_bussiness_order_pay.PAY_STATUS
     *
     * @mbg.generated Fri Jun 21 09:56:25 CST 2019
     */
    public Byte getPayStatus() {
        return payStatus;
    }

    /**
     * 数据库字段：支付状态[1-支付前 2-支付后]dcdg_bussiness_order_pay.PAY_STATUS
     * @param payStatus the value for dcdg_bussiness_order_pay.PAY_STATUS
     *
     * @mbg.generated Fri Jun 21 09:56:25 CST 2019
     */
    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * 数据库字段：支付前时间dcdg_bussiness_order_pay.BEFORE_TIME
     *
     * @return  the value of dcdg_bussiness_order_pay.BEFORE_TIME
     *
     * @mbg.generated Fri Jun 21 09:56:25 CST 2019
     */
    public Date getBeforeTime() {
        return beforeTime;
    }

    /**
     * 数据库字段：支付前时间dcdg_bussiness_order_pay.BEFORE_TIME
     * @param beforeTime the value for dcdg_bussiness_order_pay.BEFORE_TIME
     *
     * @mbg.generated Fri Jun 21 09:56:25 CST 2019
     */
    public void setBeforeTime(Date beforeTime) {
        this.beforeTime = beforeTime;
    }

    /**
     * 数据库字段：支付后时间dcdg_bussiness_order_pay.AFTER_TIME
     *
     * @return  the value of dcdg_bussiness_order_pay.AFTER_TIME
     *
     * @mbg.generated Fri Jun 21 09:56:25 CST 2019
     */
    public Date getAfterTime() {
        return afterTime;
    }

    /**
     * 数据库字段：支付后时间dcdg_bussiness_order_pay.AFTER_TIME
     * @param afterTime the value for dcdg_bussiness_order_pay.AFTER_TIME
     *
     * @mbg.generated Fri Jun 21 09:56:25 CST 2019
     */
    public void setAfterTime(Date afterTime) {
        this.afterTime = afterTime;
    }

    /**
     * 数据库字段：库存扣减时间dcdg_bussiness_order_pay.DEDUCTION_STOCK_TIME
     *
     * @return  the value of dcdg_bussiness_order_pay.DEDUCTION_STOCK_TIME
     *
     * @mbg.generated Fri Jun 21 09:56:25 CST 2019
     */
    public Date getDeductionStockTime() {
        return deductionStockTime;
    }

    /**
     * 数据库字段：库存扣减时间dcdg_bussiness_order_pay.DEDUCTION_STOCK_TIME
     * @param deductionStockTime the value for dcdg_bussiness_order_pay.DEDUCTION_STOCK_TIME
     *
     * @mbg.generated Fri Jun 21 09:56:25 CST 2019
     */
    public void setDeductionStockTime(Date deductionStockTime) {
        this.deductionStockTime = deductionStockTime;
    }

    /**
     * 数据库字段：库存恢复时间dcdg_bussiness_order_pay.ADD_STOCK_TIME
     *
     * @return  the value of dcdg_bussiness_order_pay.ADD_STOCK_TIME
     *
     * @mbg.generated Fri Jun 21 09:56:25 CST 2019
     */
    public Date getAddStockTime() {
        return addStockTime;
    }

    /**
     * 数据库字段：库存恢复时间dcdg_bussiness_order_pay.ADD_STOCK_TIME
     * @param addStockTime the value for dcdg_bussiness_order_pay.ADD_STOCK_TIME
     *
     * @mbg.generated Fri Jun 21 09:56:25 CST 2019
     */
    public void setAddStockTime(Date addStockTime) {
        this.addStockTime = addStockTime;
    }
}