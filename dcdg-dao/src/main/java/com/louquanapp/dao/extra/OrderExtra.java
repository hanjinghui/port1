package com.louquanapp.dao.extra;

import com.louquanapp.dao.model.OrderItem;
import com.louquanapp.dao.model.OrderOperate;
import com.louquanapp.dao.model.VideoPlaninfo;

import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/10 10:16
 * @Description:
 */
public class OrderExtra {


    /* 下单时间（查询上限）*/
    private java.util.Date beginAddTime;
    /* 下单时间（查询下限）*/
    private java.util.Date endAddTime;


    /**
     * 获取下单时间查询上限
     *
     * @return 下单时间查询上限
     */
    public java.util.Date getBeginAddTime() {
        return beginAddTime;
    }

    /**
     * 设置下单时间查询上限
     *
     * @param beginAddTime 下单时间查询上限
     */
    public void setBeginAddTime(java.util.Date beginAddTime) {
        this.beginAddTime = beginAddTime;
    }

    /**
     * 获取下单时间查询下限
     *
     * @return 下单时间查询下限
     */
    public java.util.Date getEndAddTime() {
        return endAddTime;
    }

    /**
     * 设置下单时间查询下限
     *
     * @param endAddTime 下单时间查询下限
     */
    public void setEndAddTime(java.util.Date endAddTime) {
        this.endAddTime = endAddTime;
    }

    private List<OrderOperate> shortOrderOperates;

    private VideoPlaninfo videoPlaninfo;

    public VideoPlaninfo getVideoPlaninfo() {
        return videoPlaninfo;
    }

    public void setVideoPlaninfo(VideoPlaninfo videoPlaninfo) {
        this.videoPlaninfo = videoPlaninfo;
    }

    public List<OrderOperate> getShortOrderOperates() {
        return shortOrderOperates;
    }

    public void setShortOrderOperates(List<OrderOperate> shortOrderOperates) {
        this.shortOrderOperates = shortOrderOperates;
    }


    /**
     * 订单明细
     */
    private List<OrderItem> orderItemList;

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }


    private String areaPath;
    private String receiveAddr;
    private String receiverName;
    private String linkPhone;
    private String postNo;
    private String postCompany;
    /**
     * 订单数量
     */
    private Integer orderCount;

    private String postJson;
    /**
     * 今日营业额
     */
    private Double dayMoney;
    /**
     * 本周订单数
     */
    private Integer weekOrdersCount;

    /**
     *累计营业额
     */
    private Double totalMoney;
    /**
     * 待发货订单数
     */
    private Integer toSendOrdersCount;

    /**
     * 退款申请订单数
     */
    private Integer refundApplicationOrdersCount;
    /**
     * 商品logo
     */
    private String shopLogo;
    /**
     * 商品名称
     */
    private String shopName;
    /**
     * 商铺类型[1-产品类 2-服务类]
     */
    private Byte shopType;

    /**
     *    售后管理数
     */
    private Integer afterSaleCount;
    /**
     *  预定管理数
     */
    private Integer planinfoCount;

    private Boolean flags;

    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 数据类型[1-已结算值 2-明细]
     */
    private Byte dataType;
    /**
     * 加减状态[1-加 2-减]
     */
    private Byte addOrSub;
    /**
     * 商品规格名称
     */
    private String skuGoodsName;

    public String getSkuGoodsName() {
        return skuGoodsName;
    }

    public void setSkuGoodsName(String skuGoodsName) {
        this.skuGoodsName = skuGoodsName;
    }

    public Byte getAddOrSub() {
        return addOrSub;
    }

    public void setAddOrSub(Byte addOrSub) {
        this.addOrSub = addOrSub;
    }

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品图片
     */
    private String goodsImg;



    private Double num;

    private String time;

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Byte getDataType() {
        return dataType;
    }

    public void setDataType(Byte dataType) {
        this.dataType = dataType;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Boolean getFlags() {
        return flags;
    }

    public void setFlags(Boolean flags) {
        this.flags = flags;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getAfterSaleCount() {
        return afterSaleCount;
    }

    public void setAfterSaleCount(Integer afterSaleCount) {
        this.afterSaleCount = afterSaleCount;
    }

    public Integer getPlaninfoCount() {
        return planinfoCount;
    }

    public void setPlaninfoCount(Integer planinfoCount) {
        this.planinfoCount = planinfoCount;
    }

    public String getShopLogo() {
        return shopLogo;
    }

    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Byte getShopType() {
        return shopType;
    }

    public void setShopType(Byte shopType) {
        this.shopType = shopType;
    }

    public Double getDayMoney() {
        return dayMoney;
    }

    public void setDayMoney(Double dayMoney) {
        this.dayMoney = dayMoney;
    }

    public Integer getWeekOrdersCount() {
        return weekOrdersCount;
    }

    public void setWeekOrdersCount(Integer weekOrdersCount) {
        this.weekOrdersCount = weekOrdersCount;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getToSendOrdersCount() {
        return toSendOrdersCount;
    }

    public void setToSendOrdersCount(Integer toSendOrdersCount) {
        this.toSendOrdersCount = toSendOrdersCount;
    }

    public Integer getRefundApplicationOrdersCount() {
        return refundApplicationOrdersCount;
    }

    public void setRefundApplicationOrdersCount(Integer refundApplicationOrdersCount) {
        this.refundApplicationOrdersCount = refundApplicationOrdersCount;
    }
    public String getPostJson() {
        return postJson;
    }

    public void setPostJson(String postJson) {
        this.postJson = postJson;
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
}
