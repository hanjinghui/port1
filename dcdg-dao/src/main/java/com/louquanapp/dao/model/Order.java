package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.OrderExtra;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_bussiness_order_base
 *
 * @mbg.generated do_not_delete_during_merge Thu Aug 29 17:04:42 CST 2019
 */
public class Order   extends OrderExtra {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_bussiness_order_base.ORDER_ID
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private String orderId;

    /**
     *   店铺ID
     *
     * 数据库字段名:dcdg_bussiness_order_base.SHOP_ID
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private String shopId;

    /**
     *   店铺名称
     *
     * 数据库字段名:dcdg_bussiness_order_base.SHOP_NAME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private String shopName;

    /**
     *   店铺标题
     *
     * 数据库字段名:dcdg_bussiness_order_base.SHOP_TITLE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private String shopTitle;

    /**
     *   店铺认证类型 [1-个人认证 2-企业认证 3-委托管理]
     *
     * 数据库字段名:dcdg_bussiness_order_base.AUTH_TYPE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Integer authType;

    /**
     *   订单编号
     *
     * 数据库字段名:dcdg_bussiness_order_base.ORDER_NO
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private String orderNo;

    /**
     *   客户ID
     *
     * 数据库字段名:dcdg_bussiness_order_base.CUST_ID
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private String custId;

    /**
     *   客户名称
     *
     * 数据库字段名:dcdg_bussiness_order_base.CUST_NAME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private String custName;

    /**
     *   订单状态[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货 501-已收货 601-退货申请中 611-退货中 621-已退货 701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]
     *
     * 数据库字段名:dcdg_bussiness_order_base.ORDER_STATUS
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Integer orderStatus;

    /**
     *   订单实际金额(订单总金额+邮费-优惠金额)
     *
     * 数据库字段名:dcdg_bussiness_order_base.ORDER_FEE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Double orderFee;

    /**
     *   订单积分金额(订单总积分+邮费-优惠金额)
     *
     * 数据库字段名:dcdg_bussiness_order_base.MAX_POINT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Double maxPoint;

    /**
     *   订单总额
     *
     * 数据库字段名:dcdg_bussiness_order_base.TOTAL_FEE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Double totalFee;

    /**
     *   邮费
     *
     * 数据库字段名:dcdg_bussiness_order_base.POST_FEE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Double postFee;

    /**
     *   安装费用
     *
     * 数据库字段名:dcdg_bussiness_order_base.INSTALL_FEE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Double installFee;

    /**
     *   优惠金额
     *
     * 数据库字段名:dcdg_bussiness_order_base.DISCOUNTS_FEE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Double discountsFee;

    /**
     *   优惠说明
     *
     * 数据库字段名:dcdg_bussiness_order_base.DISCOUNTS_DESC
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private String discountsDesc;

    /**
     *   退款金额
     *
     * 数据库字段名:dcdg_bussiness_order_base.REFUND_FEE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Double refundFee;

    /**
     *   订单内商品数量
     *
     * 数据库字段名:dcdg_bussiness_order_base.GOODS_NUM
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Integer goodsNum;

    /**
     *   现金数额
     *
     * 数据库字段名:dcdg_bussiness_order_base.RMB_AMT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Double rmbAmt;

    /**
     *   消费积分数额
     *
     * 数据库字段名:dcdg_bussiness_order_base.CONSUME_AMT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Double consumeAmt;

    /**
     *   晨香积分数额
     *
     * 数据库字段名:dcdg_bussiness_order_base.CXY_AMT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Double cxyAmt;

    /**
     *   抵扣积分数额
     *
     * 数据库字段名:dcdg_bussiness_order_base.DEDUCTION_AMT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Double deductionAmt;

    /**
     *   支付渠道[0-未付款 1-纯消费积分 2-积分+余额   5-纯余额  3-积分+微信 4-纯微信 6-积分+支付宝 7-纯支付宝]
     *
     * 数据库字段名:dcdg_bussiness_order_base.PAY_TYPE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Byte payType;

    /**
     *   收货信息
     *
     * 数据库字段名:dcdg_bussiness_order_base.POST_INFO
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private String postInfo;

    /**
     *   问题订单标记
     *
     * 数据库字段名:dcdg_bussiness_order_base.ORDER_PROB
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private String orderProb;

    /**
     *   下单设备来源 [1-微信 2-WAP 3-Android 4-iOS 5-pc]
     *
     * 数据库字段名:dcdg_bussiness_order_base.ORDER_SOURCE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Byte orderSource;

    /**
     *   订单备注
     *
     * 数据库字段名:dcdg_bussiness_order_base.ORDER_REMARK
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private String orderRemark;

    /**
     *   是否匿名 [1-匿名 2-非匿名]
     *
     * 数据库字段名:dcdg_bussiness_order_base.ANONY_FLAG
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Byte anonyFlag;

    /**
     *   下单时间
     *
     * 数据库字段名:dcdg_bussiness_order_base.ADD_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Date addTime;

    /**
     *   支付时间
     *
     * 数据库字段名:dcdg_bussiness_order_base.PAY_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Date payTime;

    /**
     *   修改时间
     *
     * 数据库字段名:dcdg_bussiness_order_base.UPDATE_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Date updateTime;

    /**
     *   订单过期时间
     *
     * 数据库字段名:dcdg_bussiness_order_base.OVERDUE_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Date overdueTime;

    /**
     *   发货用户名
     *
     * 数据库字段名:dcdg_bussiness_order_base.SENDER_NAME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private String senderName;

    /**
     *   结算状态 [1-未申请 2-申请中 3-已结算]
     *
     * 数据库字段名:dcdg_bussiness_order_base.CURRENCY_STATUS
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Byte currencyStatus;

    /**
     *   结算申请时间
     *
     * 数据库字段名:dcdg_bussiness_order_base.IN_SETTLEMENT_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Date inSettlementTime;

    /**
     *   已结算时间
     *
     * 数据库字段名:dcdg_bussiness_order_base.OUT_SETTLEMENT_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Date outSettlementTime;

    /**
     *   是否已将上级积分释放 [0-未释放 1-已释放]
     *
     * 数据库字段名:dcdg_bussiness_order_base.RELEASE_FLAG
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Byte releaseFlag;

    /**
     *   赠送积分倍数（缓存系统参数）
     *
     * 数据库字段名:dcdg_bussiness_order_base.POINT_TIMES
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Integer pointTimes;

    /**
     *   应得总积分
     *
     * 数据库字段名:dcdg_bussiness_order_base.DUE_POINT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Double duePoint;

    /**
     *   剩余积分
     *
     * 数据库字段名:dcdg_bussiness_order_base.SURPLUS_POINT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Double surplusPoint;

    /**
     *   赠送积分规则(缓存系统参数)
     *
     * 数据库字段名:dcdg_bussiness_order_base.SEND_RULE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private String sendRule;

    /**
     *   已返金额
     *
     * 数据库字段名:dcdg_bussiness_order_base.RETURN_CASH
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Double returnCash;

    /**
     *   删除标记 [1-正常 2-删除]
     *
     * 数据库字段名:dcdg_bussiness_order_base.DELT_FLAG
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Byte deltFlag;

    /**
     *   充值备注
     *
     * 数据库字段名:dcdg_bussiness_order_base.RECHARGE_INFO
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private String rechargeInfo;

    /**
     *   流水号
     *
     * 数据库字段名:dcdg_bussiness_order_base.OFFLINEPAY_IMG
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private String offlinepayImg;

    /**
     *   订单类型[1-服务类 2-产品类]
     *
     * 数据库字段名:dcdg_bussiness_order_base.IS_PROMOTION
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Byte isPromotion;

    /**
     *   退款金额
     *
     * 数据库字段名:dcdg_bussiness_order_base.OFFLINE_NUM
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private String offlineNum;

    /**
     *   预计就餐时间
     *
     * 数据库字段名:dcdg_bussiness_order_base.PLAN_EAT_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Date planEatTime;

    /**
     *   服务类核销二维码
     *
     * 数据库字段名:dcdg_bussiness_order_base.WRITE_OFF_IMG
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private String writeOffImg;

    /**
     *   发货时间
     *
     * 数据库字段名:dcdg_bussiness_order_base.SEND_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Date sendTime;

    /**
     *   收货时间或服务完成时间
     *
     * 数据库字段名:dcdg_bussiness_order_base.RECEIVING_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Date receivingTime;

    /**
     *   退款结算状态 [1-未申请 2-申请中 3-已结算]
     *
     * 数据库字段名:dcdg_bussiness_order_base.REFUND_SETTLEMENT_STATUS
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Byte refundSettlementStatus;

    /**
     *   退款结算申请时间
     *
     * 数据库字段名:dcdg_bussiness_order_base.IN_REFUND_SETTLEMENT_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Date inRefundSettlementTime;

    /**
     *   退款结算已结算时间
     *
     * 数据库字段名:dcdg_bussiness_order_base.OUT_REFUND_SETTLEMENT_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Date outRefundSettlementTime;

    /**
     *   退款完成时间
     *
     * 数据库字段名:dcdg_bussiness_order_base.OUT_REFUND_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    private Date outRefundTime;

    /**
     * 数据库字段：主键dcdg_bussiness_order_base.ORDER_ID
     *
     * @return  the value of dcdg_bussiness_order_base.ORDER_ID
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 数据库字段：主键dcdg_bussiness_order_base.ORDER_ID
     * @param orderId the value for dcdg_bussiness_order_base.ORDER_ID
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 数据库字段：店铺IDdcdg_bussiness_order_base.SHOP_ID
     *
     * @return  the value of dcdg_bussiness_order_base.SHOP_ID
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * 数据库字段：店铺IDdcdg_bussiness_order_base.SHOP_ID
     * @param shopId the value for dcdg_bussiness_order_base.SHOP_ID
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    /**
     * 数据库字段：店铺名称dcdg_bussiness_order_base.SHOP_NAME
     *
     * @return  the value of dcdg_bussiness_order_base.SHOP_NAME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 数据库字段：店铺名称dcdg_bussiness_order_base.SHOP_NAME
     * @param shopName the value for dcdg_bussiness_order_base.SHOP_NAME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 数据库字段：店铺标题dcdg_bussiness_order_base.SHOP_TITLE
     *
     * @return  the value of dcdg_bussiness_order_base.SHOP_TITLE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public String getShopTitle() {
        return shopTitle;
    }

    /**
     * 数据库字段：店铺标题dcdg_bussiness_order_base.SHOP_TITLE
     * @param shopTitle the value for dcdg_bussiness_order_base.SHOP_TITLE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setShopTitle(String shopTitle) {
        this.shopTitle = shopTitle == null ? null : shopTitle.trim();
    }

    /**
     * 数据库字段：店铺认证类型 [1-个人认证 2-企业认证 3-委托管理]dcdg_bussiness_order_base.AUTH_TYPE
     *
     * @return  the value of dcdg_bussiness_order_base.AUTH_TYPE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Integer getAuthType() {
        return authType;
    }

    /**
     * 数据库字段：店铺认证类型 [1-个人认证 2-企业认证 3-委托管理]dcdg_bussiness_order_base.AUTH_TYPE
     * @param authType the value for dcdg_bussiness_order_base.AUTH_TYPE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setAuthType(Integer authType) {
        this.authType = authType;
    }

    /**
     * 数据库字段：订单编号dcdg_bussiness_order_base.ORDER_NO
     *
     * @return  the value of dcdg_bussiness_order_base.ORDER_NO
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 数据库字段：订单编号dcdg_bussiness_order_base.ORDER_NO
     * @param orderNo the value for dcdg_bussiness_order_base.ORDER_NO
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * 数据库字段：客户IDdcdg_bussiness_order_base.CUST_ID
     *
     * @return  the value of dcdg_bussiness_order_base.CUST_ID
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：客户IDdcdg_bussiness_order_base.CUST_ID
     * @param custId the value for dcdg_bussiness_order_base.CUST_ID
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：客户名称dcdg_bussiness_order_base.CUST_NAME
     *
     * @return  the value of dcdg_bussiness_order_base.CUST_NAME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public String getCustName() {
        return custName;
    }

    /**
     * 数据库字段：客户名称dcdg_bussiness_order_base.CUST_NAME
     * @param custName the value for dcdg_bussiness_order_base.CUST_NAME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    /**
     * 数据库字段：订单状态[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货 501-已收货 601-退货申请中 611-退货中 621-已退货 701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]dcdg_bussiness_order_base.ORDER_STATUS
     *
     * @return  the value of dcdg_bussiness_order_base.ORDER_STATUS
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 数据库字段：订单状态[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货 501-已收货 601-退货申请中 611-退货中 621-已退货 701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]dcdg_bussiness_order_base.ORDER_STATUS
     * @param orderStatus the value for dcdg_bussiness_order_base.ORDER_STATUS
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 数据库字段：订单实际金额(订单总金额+邮费-优惠金额)dcdg_bussiness_order_base.ORDER_FEE
     *
     * @return  the value of dcdg_bussiness_order_base.ORDER_FEE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Double getOrderFee() {
        return orderFee;
    }

    /**
     * 数据库字段：订单实际金额(订单总金额+邮费-优惠金额)dcdg_bussiness_order_base.ORDER_FEE
     * @param orderFee the value for dcdg_bussiness_order_base.ORDER_FEE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setOrderFee(Double orderFee) {
        this.orderFee = orderFee;
    }

    /**
     * 数据库字段：订单积分金额(订单总积分+邮费-优惠金额)dcdg_bussiness_order_base.MAX_POINT
     *
     * @return  the value of dcdg_bussiness_order_base.MAX_POINT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Double getMaxPoint() {
        return maxPoint;
    }

    /**
     * 数据库字段：订单积分金额(订单总积分+邮费-优惠金额)dcdg_bussiness_order_base.MAX_POINT
     * @param maxPoint the value for dcdg_bussiness_order_base.MAX_POINT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setMaxPoint(Double maxPoint) {
        this.maxPoint = maxPoint;
    }

    /**
     * 数据库字段：订单总额dcdg_bussiness_order_base.TOTAL_FEE
     *
     * @return  the value of dcdg_bussiness_order_base.TOTAL_FEE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Double getTotalFee() {
        return totalFee;
    }

    /**
     * 数据库字段：订单总额dcdg_bussiness_order_base.TOTAL_FEE
     * @param totalFee the value for dcdg_bussiness_order_base.TOTAL_FEE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * 数据库字段：邮费dcdg_bussiness_order_base.POST_FEE
     *
     * @return  the value of dcdg_bussiness_order_base.POST_FEE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Double getPostFee() {
        return postFee;
    }

    /**
     * 数据库字段：邮费dcdg_bussiness_order_base.POST_FEE
     * @param postFee the value for dcdg_bussiness_order_base.POST_FEE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setPostFee(Double postFee) {
        this.postFee = postFee;
    }

    /**
     * 数据库字段：安装费用dcdg_bussiness_order_base.INSTALL_FEE
     *
     * @return  the value of dcdg_bussiness_order_base.INSTALL_FEE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Double getInstallFee() {
        return installFee;
    }

    /**
     * 数据库字段：安装费用dcdg_bussiness_order_base.INSTALL_FEE
     * @param installFee the value for dcdg_bussiness_order_base.INSTALL_FEE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setInstallFee(Double installFee) {
        this.installFee = installFee;
    }

    /**
     * 数据库字段：优惠金额dcdg_bussiness_order_base.DISCOUNTS_FEE
     *
     * @return  the value of dcdg_bussiness_order_base.DISCOUNTS_FEE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Double getDiscountsFee() {
        return discountsFee;
    }

    /**
     * 数据库字段：优惠金额dcdg_bussiness_order_base.DISCOUNTS_FEE
     * @param discountsFee the value for dcdg_bussiness_order_base.DISCOUNTS_FEE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setDiscountsFee(Double discountsFee) {
        this.discountsFee = discountsFee;
    }

    /**
     * 数据库字段：优惠说明dcdg_bussiness_order_base.DISCOUNTS_DESC
     *
     * @return  the value of dcdg_bussiness_order_base.DISCOUNTS_DESC
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public String getDiscountsDesc() {
        return discountsDesc;
    }

    /**
     * 数据库字段：优惠说明dcdg_bussiness_order_base.DISCOUNTS_DESC
     * @param discountsDesc the value for dcdg_bussiness_order_base.DISCOUNTS_DESC
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setDiscountsDesc(String discountsDesc) {
        this.discountsDesc = discountsDesc == null ? null : discountsDesc.trim();
    }

    /**
     * 数据库字段：退款金额dcdg_bussiness_order_base.REFUND_FEE
     *
     * @return  the value of dcdg_bussiness_order_base.REFUND_FEE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Double getRefundFee() {
        return refundFee;
    }

    /**
     * 数据库字段：退款金额dcdg_bussiness_order_base.REFUND_FEE
     * @param refundFee the value for dcdg_bussiness_order_base.REFUND_FEE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setRefundFee(Double refundFee) {
        this.refundFee = refundFee;
    }

    /**
     * 数据库字段：订单内商品数量dcdg_bussiness_order_base.GOODS_NUM
     *
     * @return  the value of dcdg_bussiness_order_base.GOODS_NUM
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Integer getGoodsNum() {
        return goodsNum;
    }

    /**
     * 数据库字段：订单内商品数量dcdg_bussiness_order_base.GOODS_NUM
     * @param goodsNum the value for dcdg_bussiness_order_base.GOODS_NUM
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * 数据库字段：现金数额dcdg_bussiness_order_base.RMB_AMT
     *
     * @return  the value of dcdg_bussiness_order_base.RMB_AMT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Double getRmbAmt() {
        return rmbAmt;
    }

    /**
     * 数据库字段：现金数额dcdg_bussiness_order_base.RMB_AMT
     * @param rmbAmt the value for dcdg_bussiness_order_base.RMB_AMT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setRmbAmt(Double rmbAmt) {
        this.rmbAmt = rmbAmt;
    }

    /**
     * 数据库字段：消费积分数额dcdg_bussiness_order_base.CONSUME_AMT
     *
     * @return  the value of dcdg_bussiness_order_base.CONSUME_AMT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Double getConsumeAmt() {
        return consumeAmt;
    }

    /**
     * 数据库字段：消费积分数额dcdg_bussiness_order_base.CONSUME_AMT
     * @param consumeAmt the value for dcdg_bussiness_order_base.CONSUME_AMT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setConsumeAmt(Double consumeAmt) {
        this.consumeAmt = consumeAmt;
    }

    /**
     * 数据库字段：晨香积分数额dcdg_bussiness_order_base.CXY_AMT
     *
     * @return  the value of dcdg_bussiness_order_base.CXY_AMT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Double getCxyAmt() {
        return cxyAmt;
    }

    /**
     * 数据库字段：晨香积分数额dcdg_bussiness_order_base.CXY_AMT
     * @param cxyAmt the value for dcdg_bussiness_order_base.CXY_AMT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setCxyAmt(Double cxyAmt) {
        this.cxyAmt = cxyAmt;
    }

    /**
     * 数据库字段：抵扣积分数额dcdg_bussiness_order_base.DEDUCTION_AMT
     *
     * @return  the value of dcdg_bussiness_order_base.DEDUCTION_AMT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Double getDeductionAmt() {
        return deductionAmt;
    }

    /**
     * 数据库字段：抵扣积分数额dcdg_bussiness_order_base.DEDUCTION_AMT
     * @param deductionAmt the value for dcdg_bussiness_order_base.DEDUCTION_AMT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setDeductionAmt(Double deductionAmt) {
        this.deductionAmt = deductionAmt;
    }

    /**
     * 数据库字段：支付渠道[0-未付款 1-纯消费积分 2-积分+余额   5-纯余额  3-积分+微信 4-纯微信 6-积分+支付宝 7-纯支付宝]dcdg_bussiness_order_base.PAY_TYPE
     *
     * @return  the value of dcdg_bussiness_order_base.PAY_TYPE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Byte getPayType() {
        return payType;
    }

    /**
     * 数据库字段：支付渠道[0-未付款 1-纯消费积分 2-积分+余额   5-纯余额  3-积分+微信 4-纯微信 6-积分+支付宝 7-纯支付宝]dcdg_bussiness_order_base.PAY_TYPE
     * @param payType the value for dcdg_bussiness_order_base.PAY_TYPE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    /**
     * 数据库字段：收货信息dcdg_bussiness_order_base.POST_INFO
     *
     * @return  the value of dcdg_bussiness_order_base.POST_INFO
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public String getPostInfo() {
        return postInfo;
    }

    /**
     * 数据库字段：收货信息dcdg_bussiness_order_base.POST_INFO
     * @param postInfo the value for dcdg_bussiness_order_base.POST_INFO
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setPostInfo(String postInfo) {
        this.postInfo = postInfo == null ? null : postInfo.trim();
    }

    /**
     * 数据库字段：问题订单标记dcdg_bussiness_order_base.ORDER_PROB
     *
     * @return  the value of dcdg_bussiness_order_base.ORDER_PROB
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public String getOrderProb() {
        return orderProb;
    }

    /**
     * 数据库字段：问题订单标记dcdg_bussiness_order_base.ORDER_PROB
     * @param orderProb the value for dcdg_bussiness_order_base.ORDER_PROB
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setOrderProb(String orderProb) {
        this.orderProb = orderProb == null ? null : orderProb.trim();
    }

    /**
     * 数据库字段：下单设备来源 [1-微信 2-WAP 3-Android 4-iOS 5-pc]dcdg_bussiness_order_base.ORDER_SOURCE
     *
     * @return  the value of dcdg_bussiness_order_base.ORDER_SOURCE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Byte getOrderSource() {
        return orderSource;
    }

    /**
     * 数据库字段：下单设备来源 [1-微信 2-WAP 3-Android 4-iOS 5-pc]dcdg_bussiness_order_base.ORDER_SOURCE
     * @param orderSource the value for dcdg_bussiness_order_base.ORDER_SOURCE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setOrderSource(Byte orderSource) {
        this.orderSource = orderSource;
    }

    /**
     * 数据库字段：订单备注dcdg_bussiness_order_base.ORDER_REMARK
     *
     * @return  the value of dcdg_bussiness_order_base.ORDER_REMARK
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public String getOrderRemark() {
        return orderRemark;
    }

    /**
     * 数据库字段：订单备注dcdg_bussiness_order_base.ORDER_REMARK
     * @param orderRemark the value for dcdg_bussiness_order_base.ORDER_REMARK
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark == null ? null : orderRemark.trim();
    }

    /**
     * 数据库字段：是否匿名 [1-匿名 2-非匿名]dcdg_bussiness_order_base.ANONY_FLAG
     *
     * @return  the value of dcdg_bussiness_order_base.ANONY_FLAG
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Byte getAnonyFlag() {
        return anonyFlag;
    }

    /**
     * 数据库字段：是否匿名 [1-匿名 2-非匿名]dcdg_bussiness_order_base.ANONY_FLAG
     * @param anonyFlag the value for dcdg_bussiness_order_base.ANONY_FLAG
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setAnonyFlag(Byte anonyFlag) {
        this.anonyFlag = anonyFlag;
    }

    /**
     * 数据库字段：下单时间dcdg_bussiness_order_base.ADD_TIME
     *
     * @return  the value of dcdg_bussiness_order_base.ADD_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：下单时间dcdg_bussiness_order_base.ADD_TIME
     * @param addTime the value for dcdg_bussiness_order_base.ADD_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：支付时间dcdg_bussiness_order_base.PAY_TIME
     *
     * @return  the value of dcdg_bussiness_order_base.PAY_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 数据库字段：支付时间dcdg_bussiness_order_base.PAY_TIME
     * @param payTime the value for dcdg_bussiness_order_base.PAY_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 数据库字段：修改时间dcdg_bussiness_order_base.UPDATE_TIME
     *
     * @return  the value of dcdg_bussiness_order_base.UPDATE_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：修改时间dcdg_bussiness_order_base.UPDATE_TIME
     * @param updateTime the value for dcdg_bussiness_order_base.UPDATE_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 数据库字段：订单过期时间dcdg_bussiness_order_base.OVERDUE_TIME
     *
     * @return  the value of dcdg_bussiness_order_base.OVERDUE_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Date getOverdueTime() {
        return overdueTime;
    }

    /**
     * 数据库字段：订单过期时间dcdg_bussiness_order_base.OVERDUE_TIME
     * @param overdueTime the value for dcdg_bussiness_order_base.OVERDUE_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setOverdueTime(Date overdueTime) {
        this.overdueTime = overdueTime;
    }

    /**
     * 数据库字段：发货用户名dcdg_bussiness_order_base.SENDER_NAME
     *
     * @return  the value of dcdg_bussiness_order_base.SENDER_NAME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * 数据库字段：发货用户名dcdg_bussiness_order_base.SENDER_NAME
     * @param senderName the value for dcdg_bussiness_order_base.SENDER_NAME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setSenderName(String senderName) {
        this.senderName = senderName == null ? null : senderName.trim();
    }

    /**
     * 数据库字段：结算状态 [1-未申请 2-申请中 3-已结算]dcdg_bussiness_order_base.CURRENCY_STATUS
     *
     * @return  the value of dcdg_bussiness_order_base.CURRENCY_STATUS
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Byte getCurrencyStatus() {
        return currencyStatus;
    }

    /**
     * 数据库字段：结算状态 [1-未申请 2-申请中 3-已结算]dcdg_bussiness_order_base.CURRENCY_STATUS
     * @param currencyStatus the value for dcdg_bussiness_order_base.CURRENCY_STATUS
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setCurrencyStatus(Byte currencyStatus) {
        this.currencyStatus = currencyStatus;
    }

    /**
     * 数据库字段：结算申请时间dcdg_bussiness_order_base.IN_SETTLEMENT_TIME
     *
     * @return  the value of dcdg_bussiness_order_base.IN_SETTLEMENT_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Date getInSettlementTime() {
        return inSettlementTime;
    }

    /**
     * 数据库字段：结算申请时间dcdg_bussiness_order_base.IN_SETTLEMENT_TIME
     * @param inSettlementTime the value for dcdg_bussiness_order_base.IN_SETTLEMENT_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setInSettlementTime(Date inSettlementTime) {
        this.inSettlementTime = inSettlementTime;
    }

    /**
     * 数据库字段：已结算时间dcdg_bussiness_order_base.OUT_SETTLEMENT_TIME
     *
     * @return  the value of dcdg_bussiness_order_base.OUT_SETTLEMENT_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Date getOutSettlementTime() {
        return outSettlementTime;
    }

    /**
     * 数据库字段：已结算时间dcdg_bussiness_order_base.OUT_SETTLEMENT_TIME
     * @param outSettlementTime the value for dcdg_bussiness_order_base.OUT_SETTLEMENT_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setOutSettlementTime(Date outSettlementTime) {
        this.outSettlementTime = outSettlementTime;
    }

    /**
     * 数据库字段：是否已将上级积分释放 [0-未释放 1-已释放]dcdg_bussiness_order_base.RELEASE_FLAG
     *
     * @return  the value of dcdg_bussiness_order_base.RELEASE_FLAG
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Byte getReleaseFlag() {
        return releaseFlag;
    }

    /**
     * 数据库字段：是否已将上级积分释放 [0-未释放 1-已释放]dcdg_bussiness_order_base.RELEASE_FLAG
     * @param releaseFlag the value for dcdg_bussiness_order_base.RELEASE_FLAG
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setReleaseFlag(Byte releaseFlag) {
        this.releaseFlag = releaseFlag;
    }

    /**
     * 数据库字段：赠送积分倍数（缓存系统参数）dcdg_bussiness_order_base.POINT_TIMES
     *
     * @return  the value of dcdg_bussiness_order_base.POINT_TIMES
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Integer getPointTimes() {
        return pointTimes;
    }

    /**
     * 数据库字段：赠送积分倍数（缓存系统参数）dcdg_bussiness_order_base.POINT_TIMES
     * @param pointTimes the value for dcdg_bussiness_order_base.POINT_TIMES
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setPointTimes(Integer pointTimes) {
        this.pointTimes = pointTimes;
    }

    /**
     * 数据库字段：应得总积分dcdg_bussiness_order_base.DUE_POINT
     *
     * @return  the value of dcdg_bussiness_order_base.DUE_POINT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Double getDuePoint() {
        return duePoint;
    }

    /**
     * 数据库字段：应得总积分dcdg_bussiness_order_base.DUE_POINT
     * @param duePoint the value for dcdg_bussiness_order_base.DUE_POINT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setDuePoint(Double duePoint) {
        this.duePoint = duePoint;
    }

    /**
     * 数据库字段：剩余积分dcdg_bussiness_order_base.SURPLUS_POINT
     *
     * @return  the value of dcdg_bussiness_order_base.SURPLUS_POINT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Double getSurplusPoint() {
        return surplusPoint;
    }

    /**
     * 数据库字段：剩余积分dcdg_bussiness_order_base.SURPLUS_POINT
     * @param surplusPoint the value for dcdg_bussiness_order_base.SURPLUS_POINT
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setSurplusPoint(Double surplusPoint) {
        this.surplusPoint = surplusPoint;
    }

    /**
     * 数据库字段：赠送积分规则(缓存系统参数)dcdg_bussiness_order_base.SEND_RULE
     *
     * @return  the value of dcdg_bussiness_order_base.SEND_RULE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public String getSendRule() {
        return sendRule;
    }

    /**
     * 数据库字段：赠送积分规则(缓存系统参数)dcdg_bussiness_order_base.SEND_RULE
     * @param sendRule the value for dcdg_bussiness_order_base.SEND_RULE
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setSendRule(String sendRule) {
        this.sendRule = sendRule == null ? null : sendRule.trim();
    }

    /**
     * 数据库字段：已返金额dcdg_bussiness_order_base.RETURN_CASH
     *
     * @return  the value of dcdg_bussiness_order_base.RETURN_CASH
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Double getReturnCash() {
        return returnCash;
    }

    /**
     * 数据库字段：已返金额dcdg_bussiness_order_base.RETURN_CASH
     * @param returnCash the value for dcdg_bussiness_order_base.RETURN_CASH
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setReturnCash(Double returnCash) {
        this.returnCash = returnCash;
    }

    /**
     * 数据库字段：删除标记 [1-正常 2-删除]dcdg_bussiness_order_base.DELT_FLAG
     *
     * @return  the value of dcdg_bussiness_order_base.DELT_FLAG
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Byte getDeltFlag() {
        return deltFlag;
    }

    /**
     * 数据库字段：删除标记 [1-正常 2-删除]dcdg_bussiness_order_base.DELT_FLAG
     * @param deltFlag the value for dcdg_bussiness_order_base.DELT_FLAG
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setDeltFlag(Byte deltFlag) {
        this.deltFlag = deltFlag;
    }

    /**
     * 数据库字段：充值备注dcdg_bussiness_order_base.RECHARGE_INFO
     *
     * @return  the value of dcdg_bussiness_order_base.RECHARGE_INFO
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public String getRechargeInfo() {
        return rechargeInfo;
    }

    /**
     * 数据库字段：充值备注dcdg_bussiness_order_base.RECHARGE_INFO
     * @param rechargeInfo the value for dcdg_bussiness_order_base.RECHARGE_INFO
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setRechargeInfo(String rechargeInfo) {
        this.rechargeInfo = rechargeInfo == null ? null : rechargeInfo.trim();
    }

    /**
     * 数据库字段：流水号dcdg_bussiness_order_base.OFFLINEPAY_IMG
     *
     * @return  the value of dcdg_bussiness_order_base.OFFLINEPAY_IMG
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public String getOfflinepayImg() {
        return offlinepayImg;
    }

    /**
     * 数据库字段：流水号dcdg_bussiness_order_base.OFFLINEPAY_IMG
     * @param offlinepayImg the value for dcdg_bussiness_order_base.OFFLINEPAY_IMG
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setOfflinepayImg(String offlinepayImg) {
        this.offlinepayImg = offlinepayImg == null ? null : offlinepayImg.trim();
    }

    /**
     * 数据库字段：订单类型[1-服务类 2-产品类]dcdg_bussiness_order_base.IS_PROMOTION
     *
     * @return  the value of dcdg_bussiness_order_base.IS_PROMOTION
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Byte getIsPromotion() {
        return isPromotion;
    }

    /**
     * 数据库字段：订单类型[1-服务类 2-产品类]dcdg_bussiness_order_base.IS_PROMOTION
     * @param isPromotion the value for dcdg_bussiness_order_base.IS_PROMOTION
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setIsPromotion(Byte isPromotion) {
        this.isPromotion = isPromotion;
    }

    /**
     * 数据库字段：退款金额dcdg_bussiness_order_base.OFFLINE_NUM
     *
     * @return  the value of dcdg_bussiness_order_base.OFFLINE_NUM
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public String getOfflineNum() {
        return offlineNum;
    }

    /**
     * 数据库字段：退款金额dcdg_bussiness_order_base.OFFLINE_NUM
     * @param offlineNum the value for dcdg_bussiness_order_base.OFFLINE_NUM
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setOfflineNum(String offlineNum) {
        this.offlineNum = offlineNum == null ? null : offlineNum.trim();
    }

    /**
     * 数据库字段：预计就餐时间dcdg_bussiness_order_base.PLAN_EAT_TIME
     *
     * @return  the value of dcdg_bussiness_order_base.PLAN_EAT_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Date getPlanEatTime() {
        return planEatTime;
    }

    /**
     * 数据库字段：预计就餐时间dcdg_bussiness_order_base.PLAN_EAT_TIME
     * @param planEatTime the value for dcdg_bussiness_order_base.PLAN_EAT_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setPlanEatTime(Date planEatTime) {
        this.planEatTime = planEatTime;
    }

    /**
     * 数据库字段：服务类核销二维码dcdg_bussiness_order_base.WRITE_OFF_IMG
     *
     * @return  the value of dcdg_bussiness_order_base.WRITE_OFF_IMG
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public String getWriteOffImg() {
        return writeOffImg;
    }

    /**
     * 数据库字段：服务类核销二维码dcdg_bussiness_order_base.WRITE_OFF_IMG
     * @param writeOffImg the value for dcdg_bussiness_order_base.WRITE_OFF_IMG
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setWriteOffImg(String writeOffImg) {
        this.writeOffImg = writeOffImg == null ? null : writeOffImg.trim();
    }

    /**
     * 数据库字段：发货时间dcdg_bussiness_order_base.SEND_TIME
     *
     * @return  the value of dcdg_bussiness_order_base.SEND_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 数据库字段：发货时间dcdg_bussiness_order_base.SEND_TIME
     * @param sendTime the value for dcdg_bussiness_order_base.SEND_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 数据库字段：收货时间或服务完成时间dcdg_bussiness_order_base.RECEIVING_TIME
     *
     * @return  the value of dcdg_bussiness_order_base.RECEIVING_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Date getReceivingTime() {
        return receivingTime;
    }

    /**
     * 数据库字段：收货时间或服务完成时间dcdg_bussiness_order_base.RECEIVING_TIME
     * @param receivingTime the value for dcdg_bussiness_order_base.RECEIVING_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setReceivingTime(Date receivingTime) {
        this.receivingTime = receivingTime;
    }

    /**
     * 数据库字段：退款结算状态 [1-未申请 2-申请中 3-已结算]dcdg_bussiness_order_base.REFUND_SETTLEMENT_STATUS
     *
     * @return  the value of dcdg_bussiness_order_base.REFUND_SETTLEMENT_STATUS
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Byte getRefundSettlementStatus() {
        return refundSettlementStatus;
    }

    /**
     * 数据库字段：退款结算状态 [1-未申请 2-申请中 3-已结算]dcdg_bussiness_order_base.REFUND_SETTLEMENT_STATUS
     * @param refundSettlementStatus the value for dcdg_bussiness_order_base.REFUND_SETTLEMENT_STATUS
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setRefundSettlementStatus(Byte refundSettlementStatus) {
        this.refundSettlementStatus = refundSettlementStatus;
    }

    /**
     * 数据库字段：退款结算申请时间dcdg_bussiness_order_base.IN_REFUND_SETTLEMENT_TIME
     *
     * @return  the value of dcdg_bussiness_order_base.IN_REFUND_SETTLEMENT_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Date getInRefundSettlementTime() {
        return inRefundSettlementTime;
    }

    /**
     * 数据库字段：退款结算申请时间dcdg_bussiness_order_base.IN_REFUND_SETTLEMENT_TIME
     * @param inRefundSettlementTime the value for dcdg_bussiness_order_base.IN_REFUND_SETTLEMENT_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setInRefundSettlementTime(Date inRefundSettlementTime) {
        this.inRefundSettlementTime = inRefundSettlementTime;
    }

    /**
     * 数据库字段：退款结算已结算时间dcdg_bussiness_order_base.OUT_REFUND_SETTLEMENT_TIME
     *
     * @return  the value of dcdg_bussiness_order_base.OUT_REFUND_SETTLEMENT_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Date getOutRefundSettlementTime() {
        return outRefundSettlementTime;
    }

    /**
     * 数据库字段：退款结算已结算时间dcdg_bussiness_order_base.OUT_REFUND_SETTLEMENT_TIME
     * @param outRefundSettlementTime the value for dcdg_bussiness_order_base.OUT_REFUND_SETTLEMENT_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setOutRefundSettlementTime(Date outRefundSettlementTime) {
        this.outRefundSettlementTime = outRefundSettlementTime;
    }

    /**
     * 数据库字段：退款完成时间dcdg_bussiness_order_base.OUT_REFUND_TIME
     *
     * @return  the value of dcdg_bussiness_order_base.OUT_REFUND_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public Date getOutRefundTime() {
        return outRefundTime;
    }

    /**
     * 数据库字段：退款完成时间dcdg_bussiness_order_base.OUT_REFUND_TIME
     * @param outRefundTime the value for dcdg_bussiness_order_base.OUT_REFUND_TIME
     *
     * @mbg.generated Thu Aug 29 17:04:42 CST 2019
     */
    public void setOutRefundTime(Date outRefundTime) {
        this.outRefundTime = outRefundTime;
    }
}