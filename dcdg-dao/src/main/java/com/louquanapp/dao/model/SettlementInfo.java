package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.SettlementInfoExtra;
import com.louquanapp.dao.extra.VideoExtra;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_business_settlement_info
 *
 * @mbg.generated do_not_delete_during_merge Fri Aug 30 14:53:33 CST 2019
 */
public class SettlementInfo extends SettlementInfoExtra {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_business_settlement_info.SETTLE_ID
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    private String settleId;

    /**
     *   金额
     *
     * 数据库字段名:dcdg_business_settlement_info.MONEY
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    private Double money;

    /**
     *   金额类型[1-积分 2-余额]
     *
     * 数据库字段名:dcdg_business_settlement_info.MONEY_TYPE
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    private Byte moneyType;

    /**
     *   商家id
     *
     * 数据库字段名:dcdg_business_settlement_info.SHOP_ID
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    private String shopId;

    /**
     *   结算类型[1-收货结算 2-退款结算]
     *
     * 数据库字段名:dcdg_business_settlement_info.SETTLEMENT_TYPE
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    private Byte settlementType;

    /**
     *   结算状态[2-结算中 3-已结算]
     *
     * 数据库字段名:dcdg_business_settlement_info.SETTLEMENT_STATUS
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    private Byte settlementStatus;

    /**
     *   商家名称
     *
     * 数据库字段名:dcdg_business_settlement_info.SHOP_NAME
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    private String shopName;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_business_settlement_info.ADD_TIME
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    private Date addTime;

    /**
     *   结算申请时间
     *
     * 数据库字段名:dcdg_business_settlement_info.IN_SETTLEMENT_TIME
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    private Date inSettlementTime;

    /**
     *   结算完成时间
     *
     * 数据库字段名:dcdg_business_settlement_info.OUT_SETTLEMENT_TIME
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    private Date outSettlementTime;

    /**
     *   银行卡id
     *
     * 数据库字段名:dcdg_business_settlement_info.BANK_CARD_ID
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    private String bankCardId;

    /**
     *   订单集合
     *
     * 数据库字段名:dcdg_business_settlement_info.ALL_ORDER_ID
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    private String allOrderId;

    /**
     * 数据库字段：主键dcdg_business_settlement_info.SETTLE_ID
     *
     * @return  the value of dcdg_business_settlement_info.SETTLE_ID
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public String getSettleId() {
        return settleId;
    }

    /**
     * 数据库字段：主键dcdg_business_settlement_info.SETTLE_ID
     * @param settleId the value for dcdg_business_settlement_info.SETTLE_ID
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public void setSettleId(String settleId) {
        this.settleId = settleId == null ? null : settleId.trim();
    }

    /**
     * 数据库字段：金额dcdg_business_settlement_info.MONEY
     *
     * @return  the value of dcdg_business_settlement_info.MONEY
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public Double getMoney() {
        return money;
    }

    /**
     * 数据库字段：金额dcdg_business_settlement_info.MONEY
     * @param money the value for dcdg_business_settlement_info.MONEY
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * 数据库字段：金额类型[1-积分 2-余额]dcdg_business_settlement_info.MONEY_TYPE
     *
     * @return  the value of dcdg_business_settlement_info.MONEY_TYPE
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public Byte getMoneyType() {
        return moneyType;
    }

    /**
     * 数据库字段：金额类型[1-积分 2-余额]dcdg_business_settlement_info.MONEY_TYPE
     * @param moneyType the value for dcdg_business_settlement_info.MONEY_TYPE
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public void setMoneyType(Byte moneyType) {
        this.moneyType = moneyType;
    }

    /**
     * 数据库字段：商家iddcdg_business_settlement_info.SHOP_ID
     *
     * @return  the value of dcdg_business_settlement_info.SHOP_ID
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * 数据库字段：商家iddcdg_business_settlement_info.SHOP_ID
     * @param shopId the value for dcdg_business_settlement_info.SHOP_ID
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    /**
     * 数据库字段：结算类型[1-收货结算 2-退款结算]dcdg_business_settlement_info.SETTLEMENT_TYPE
     *
     * @return  the value of dcdg_business_settlement_info.SETTLEMENT_TYPE
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public Byte getSettlementType() {
        return settlementType;
    }

    /**
     * 数据库字段：结算类型[1-收货结算 2-退款结算]dcdg_business_settlement_info.SETTLEMENT_TYPE
     * @param settlementType the value for dcdg_business_settlement_info.SETTLEMENT_TYPE
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public void setSettlementType(Byte settlementType) {
        this.settlementType = settlementType;
    }

    /**
     * 数据库字段：结算状态[2-结算中 3-已结算]dcdg_business_settlement_info.SETTLEMENT_STATUS
     *
     * @return  the value of dcdg_business_settlement_info.SETTLEMENT_STATUS
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public Byte getSettlementStatus() {
        return settlementStatus;
    }

    /**
     * 数据库字段：结算状态[2-结算中 3-已结算]dcdg_business_settlement_info.SETTLEMENT_STATUS
     * @param settlementStatus the value for dcdg_business_settlement_info.SETTLEMENT_STATUS
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public void setSettlementStatus(Byte settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    /**
     * 数据库字段：商家名称dcdg_business_settlement_info.SHOP_NAME
     *
     * @return  the value of dcdg_business_settlement_info.SHOP_NAME
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 数据库字段：商家名称dcdg_business_settlement_info.SHOP_NAME
     * @param shopName the value for dcdg_business_settlement_info.SHOP_NAME
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 数据库字段：添加时间dcdg_business_settlement_info.ADD_TIME
     *
     * @return  the value of dcdg_business_settlement_info.ADD_TIME
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_business_settlement_info.ADD_TIME
     * @param addTime the value for dcdg_business_settlement_info.ADD_TIME
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：结算申请时间dcdg_business_settlement_info.IN_SETTLEMENT_TIME
     *
     * @return  the value of dcdg_business_settlement_info.IN_SETTLEMENT_TIME
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public Date getInSettlementTime() {
        return inSettlementTime;
    }

    /**
     * 数据库字段：结算申请时间dcdg_business_settlement_info.IN_SETTLEMENT_TIME
     * @param inSettlementTime the value for dcdg_business_settlement_info.IN_SETTLEMENT_TIME
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public void setInSettlementTime(Date inSettlementTime) {
        this.inSettlementTime = inSettlementTime;
    }

    /**
     * 数据库字段：结算完成时间dcdg_business_settlement_info.OUT_SETTLEMENT_TIME
     *
     * @return  the value of dcdg_business_settlement_info.OUT_SETTLEMENT_TIME
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public Date getOutSettlementTime() {
        return outSettlementTime;
    }

    /**
     * 数据库字段：结算完成时间dcdg_business_settlement_info.OUT_SETTLEMENT_TIME
     * @param outSettlementTime the value for dcdg_business_settlement_info.OUT_SETTLEMENT_TIME
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public void setOutSettlementTime(Date outSettlementTime) {
        this.outSettlementTime = outSettlementTime;
    }

    /**
     * 数据库字段：银行卡iddcdg_business_settlement_info.BANK_CARD_ID
     *
     * @return  the value of dcdg_business_settlement_info.BANK_CARD_ID
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public String getBankCardId() {
        return bankCardId;
    }

    /**
     * 数据库字段：银行卡iddcdg_business_settlement_info.BANK_CARD_ID
     * @param bankCardId the value for dcdg_business_settlement_info.BANK_CARD_ID
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public void setBankCardId(String bankCardId) {
        this.bankCardId = bankCardId == null ? null : bankCardId.trim();
    }

    /**
     * 数据库字段：订单集合dcdg_business_settlement_info.ALL_ORDER_ID
     *
     * @return  the value of dcdg_business_settlement_info.ALL_ORDER_ID
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public String getAllOrderId() {
        return allOrderId;
    }

    /**
     * 数据库字段：订单集合dcdg_business_settlement_info.ALL_ORDER_ID
     * @param allOrderId the value for dcdg_business_settlement_info.ALL_ORDER_ID
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    public void setAllOrderId(String allOrderId) {
        this.allOrderId = allOrderId == null ? null : allOrderId.trim();
    }
}