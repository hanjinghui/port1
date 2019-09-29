package com.louquanapp.resp;

import com.louquanapp.dao.model.OrderItem;
import com.louquanapp.dao.model.OrderOperate;
import com.louquanapp.dao.model.ShipAddress;

import java.util.Date;
import java.util.List;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2019年04月03日07:56:55
 */
public class ShortOrder {
    private boolean offLine;
    private String offlinePayImg;
    private String areaPath;
    private String receiveAddr;
    private String receiverName;
    private String linkPhone;
    private String postNo;
    private String postCompany;
    private Date payTime;
    private Double maxPoint;
    /**
     * 收货信息
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_BASE.POST_INFO
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String postInfo;
    /**
     * 订单明细
     */
    private List<OrderItem> orderItemList;
    private List<OrderOperate> shortOrderOperates;
    private ShipAddress shipAddress;
    /**
     * 主键
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_BASE.ORDER_ID
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String orderId;
    /**
     * 店铺ID
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_BASE.SHOP_ID
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String shopId;
    /**
     * 店铺名称
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_BASE.SHOP_NAME
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String shopName;
    /**
     * 订单编号
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_BASE.ORDER_NO
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String orderNo;
    /**
     * 订单实际金额(订单总金额+邮费-优惠金额)
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_BASE.ORDER_FEE
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Double orderFee;
    /**
     * 订单总额
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_BASE.TOTAL_FEE
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Double totalFee;
    /**
     * 邮费
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_BASE.POST_FEE
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Double postFee;
    /**
     * 安装费用
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_BASE.INSTALL_FEE
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Double installFee;
    /**
     * 订单状态[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货 501-已收货 601-退货申请中 611-退货中 621-已退货 701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_BASE.ORDER_STATUS
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Integer orderStatus;
    /**
     * 优惠金额
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_BASE.DISCOUNTS_FEE
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Double discountsFee;
    /**
     * 现金数额
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_BASE.RMB_AMT
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Double rmbAmt;
    /**
     * 消费积分数额
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_BASE.CONSUME_AMT
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Double consumeAmt;
    /**
     * 冗余消费积分
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_BASE.CXY_AMT
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Double cxyAmt;
    /**
     * 消费积分
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_BASE.DEDUCTION_AMT
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Double deductionAmt;
    /**
     * 订单内商品数量
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_BASE.GOODS_NUM
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Integer goodsNum;
    /**
     * 下单时间
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_BASE.ADD_TIME
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Date addTime;
    /**
     * 订单过期时间
     * <p>
     * 数据库字段名:CXY_BUSSINESS_ORDER_BASE.OVERDUE_TIME
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private Date overdueTime;

    public boolean isOffLine() {
        return offLine;
    }

    public void setOffLine(boolean offLine) {
        this.offLine = offLine;
    }

    public String getOfflinePayImg() {
        return offlinePayImg;
    }

    public void setOfflinePayImg(String offlinePayImg) {
        this.offlinePayImg = offlinePayImg;
    }

    public Double getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(Double maxPoint) {
        this.maxPoint = maxPoint;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPostNo() {
        return postNo;
    }

    public void setPostNo(String postNo) {
        this.postNo = postNo;
    }

    public String getPostCompany() {
        return postCompany;
    }

    public void setPostCompany(String postCompany) {
        this.postCompany = postCompany;
    }

    public String getPostInfo() {
        return postInfo;
    }

    public void setPostInfo(String postInfo) {
        this.postInfo = postInfo;
    }

    public String getAreaPath() {
        return areaPath;
    }

    public void setAreaPath(String areaPath) {
        this.areaPath = areaPath;
    }

    public String getReceiveAddr() {
        return receiveAddr;
    }

    public void setReceiveAddr(String receiveAddr) {
        this.receiveAddr = receiveAddr;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public List<OrderOperate> getShortOrderOperates() {
        return shortOrderOperates;
    }

    public void setShortOrderOperates(List<OrderOperate> shortOrderOperates) {
        this.shortOrderOperates = shortOrderOperates;
    }

    public ShipAddress getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(ShipAddress shipAddress) {
        this.shipAddress = shipAddress;
    }

    /**
     * 数据库字段：主键CXY_BUSSINESS_ORDER_BASE.ORDER_ID
     *
     * @return the value of CXY_BUSSINESS_ORDER_BASE.ORDER_ID
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 数据库字段：主键CXY_BUSSINESS_ORDER_BASE.ORDER_ID
     *
     * @param orderId the value for CXY_BUSSINESS_ORDER_BASE.ORDER_ID
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 数据库字段：店铺IDCXY_BUSSINESS_ORDER_BASE.SHOP_ID
     *
     * @return the value of CXY_BUSSINESS_ORDER_BASE.SHOP_ID
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * 数据库字段：店铺IDCXY_BUSSINESS_ORDER_BASE.SHOP_ID
     *
     * @param shopId the value for CXY_BUSSINESS_ORDER_BASE.SHOP_ID
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    /**
     * 数据库字段：店铺名称CXY_BUSSINESS_ORDER_BASE.SHOP_NAME
     *
     * @return the value of CXY_BUSSINESS_ORDER_BASE.SHOP_NAME
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 数据库字段：店铺名称CXY_BUSSINESS_ORDER_BASE.SHOP_NAME
     *
     * @param shopName the value for CXY_BUSSINESS_ORDER_BASE.SHOP_NAME
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 数据库字段：订单编号CXY_BUSSINESS_ORDER_BASE.ORDER_NO
     *
     * @return the value of CXY_BUSSINESS_ORDER_BASE.ORDER_NO
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 数据库字段：订单编号CXY_BUSSINESS_ORDER_BASE.ORDER_NO
     *
     * @param orderNo the value for CXY_BUSSINESS_ORDER_BASE.ORDER_NO
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * 数据库字段：订单状态[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货 501-已收货 601-退货申请中 611-退货中 621-已退货 701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]CXY_BUSSINESS_ORDER_BASE.ORDER_STATUS
     *
     * @return the value of CXY_BUSSINESS_ORDER_BASE.ORDER_STATUS
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 数据库字段：订单状态[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货 501-已收货 601-退货申请中 611-退货中 621-已退货 701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]CXY_BUSSINESS_ORDER_BASE.ORDER_STATUS
     *
     * @param orderStatus the value for CXY_BUSSINESS_ORDER_BASE.ORDER_STATUS
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 数据库字段：订单实际金额(订单总金额+邮费-优惠金额)CXY_BUSSINESS_ORDER_BASE.ORDER_FEE
     *
     * @return the value of CXY_BUSSINESS_ORDER_BASE.ORDER_FEE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Double getOrderFee() {
        return orderFee;
    }

    /**
     * 数据库字段：订单实际金额(订单总金额+邮费-优惠金额)CXY_BUSSINESS_ORDER_BASE.ORDER_FEE
     *
     * @param orderFee the value for CXY_BUSSINESS_ORDER_BASE.ORDER_FEE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setOrderFee(Double orderFee) {
        this.orderFee = orderFee;
    }

    /**
     * 数据库字段：订单总额CXY_BUSSINESS_ORDER_BASE.TOTAL_FEE
     *
     * @return the value of CXY_BUSSINESS_ORDER_BASE.TOTAL_FEE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Double getTotalFee() {
        return totalFee;
    }

    /**
     * 数据库字段：订单总额CXY_BUSSINESS_ORDER_BASE.TOTAL_FEE
     *
     * @param totalFee the value for CXY_BUSSINESS_ORDER_BASE.TOTAL_FEE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * 数据库字段：邮费CXY_BUSSINESS_ORDER_BASE.POST_FEE
     *
     * @return the value of CXY_BUSSINESS_ORDER_BASE.POST_FEE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Double getPostFee() {
        return postFee;
    }

    /**
     * 数据库字段：邮费CXY_BUSSINESS_ORDER_BASE.POST_FEE
     *
     * @param postFee the value for CXY_BUSSINESS_ORDER_BASE.POST_FEE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setPostFee(Double postFee) {
        this.postFee = postFee;
    }

    /**
     * 数据库字段：安装费用CXY_BUSSINESS_ORDER_BASE.INSTALL_FEE
     *
     * @return the value of CXY_BUSSINESS_ORDER_BASE.INSTALL_FEE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Double getInstallFee() {
        return installFee;
    }

    /**
     * 数据库字段：安装费用CXY_BUSSINESS_ORDER_BASE.INSTALL_FEE
     *
     * @param installFee the value for CXY_BUSSINESS_ORDER_BASE.INSTALL_FEE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setInstallFee(Double installFee) {
        this.installFee = installFee;
    }

    /**
     * 数据库字段：优惠金额CXY_BUSSINESS_ORDER_BASE.DISCOUNTS_FEE
     *
     * @return the value of CXY_BUSSINESS_ORDER_BASE.DISCOUNTS_FEE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Double getDiscountsFee() {
        return discountsFee;
    }

    /**
     * 数据库字段：优惠金额CXY_BUSSINESS_ORDER_BASE.DISCOUNTS_FEE
     *
     * @param discountsFee the value for CXY_BUSSINESS_ORDER_BASE.DISCOUNTS_FEE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setDiscountsFee(Double discountsFee) {
        this.discountsFee = discountsFee;
    }

    /**
     * 数据库字段：订单内商品数量CXY_BUSSINESS_ORDER_BASE.GOODS_NUM
     *
     * @return the value of CXY_BUSSINESS_ORDER_BASE.GOODS_NUM
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Integer getGoodsNum() {
        return goodsNum;
    }

    /**
     * 数据库字段：订单内商品数量CXY_BUSSINESS_ORDER_BASE.GOODS_NUM
     *
     * @param goodsNum the value for CXY_BUSSINESS_ORDER_BASE.GOODS_NUM
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * 数据库字段：下单时间CXY_BUSSINESS_ORDER_BASE.ADD_TIME
     *
     * @return the value of CXY_BUSSINESS_ORDER_BASE.ADD_TIME
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：下单时间CXY_BUSSINESS_ORDER_BASE.ADD_TIME
     *
     * @param addTime the value for CXY_BUSSINESS_ORDER_BASE.ADD_TIME
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：订单过期时间CXY_BUSSINESS_ORDER_BASE.OVERDUE_TIME
     *
     * @return the value of CXY_BUSSINESS_ORDER_BASE.OVERDUE_TIME
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Date getOverdueTime() {
        return overdueTime;
    }

    /**
     * 数据库字段：订单过期时间CXY_BUSSINESS_ORDER_BASE.OVERDUE_TIME
     *
     * @param overdueTime the value for CXY_BUSSINESS_ORDER_BASE.OVERDUE_TIME
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setOverdueTime(Date overdueTime) {
        this.overdueTime = overdueTime;
    }

    /**
     * 数据库字段：现金数额CXY_BUSSINESS_ORDER_BASE.RMB_AMT
     *
     * @return the value of CXY_BUSSINESS_ORDER_BASE.RMB_AMT
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Double getRmbAmt() {
        return rmbAmt;
    }

    /**
     * 数据库字段：现金数额CXY_BUSSINESS_ORDER_BASE.RMB_AMT
     *
     * @param rmbAmt the value for CXY_BUSSINESS_ORDER_BASE.RMB_AMT
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setRmbAmt(Double rmbAmt) {
        this.rmbAmt = rmbAmt;
    }

    /**
     * 数据库字段：消费积分数额CXY_BUSSINESS_ORDER_BASE.CONSUME_AMT
     *
     * @return the value of CXY_BUSSINESS_ORDER_BASE.CONSUME_AMT
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Double getConsumeAmt() {
        return consumeAmt;
    }

    /**
     * 数据库字段：消费积分数额CXY_BUSSINESS_ORDER_BASE.CONSUME_AMT
     *
     * @param consumeAmt the value for CXY_BUSSINESS_ORDER_BASE.CONSUME_AMT
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setConsumeAmt(Double consumeAmt) {
        this.consumeAmt = consumeAmt;
    }

    /**
     * 数据库字段：冗余消费积分CXY_BUSSINESS_ORDER_BASE.CXY_AMT
     *
     * @return the value of CXY_BUSSINESS_ORDER_BASE.CXY_AMT
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Double getCxyAmt() {
        return cxyAmt;
    }

    /**
     * 数据库字段：冗余消费积分CXY_BUSSINESS_ORDER_BASE.CXY_AMT
     *
     * @param cxyAmt the value for CXY_BUSSINESS_ORDER_BASE.CXY_AMT
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setCxyAmt(Double cxyAmt) {
        this.cxyAmt = cxyAmt;
    }

    /**
     * 数据库字段：消费积分CXY_BUSSINESS_ORDER_BASE.DEDUCTION_AMT
     *
     * @return the value of CXY_BUSSINESS_ORDER_BASE.DEDUCTION_AMT
     * @mbg.generated 2019年04月11日21:21:09
     */
    public Double getDeductionAmt() {
        return deductionAmt;
    }

    /**
     * 数据库字段：消费积分CXY_BUSSINESS_ORDER_BASE.DEDUCTION_AMT
     *
     * @param deductionAmt the value for CXY_BUSSINESS_ORDER_BASE.DEDUCTION_AMT
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setDeductionAmt(Double deductionAmt) {
        this.deductionAmt = deductionAmt;
    }


}
