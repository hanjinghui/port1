package com.louquanapp.dao.mapper;

import com.louquanapp.dao.config.MapF2F;
import com.louquanapp.dao.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderMapper {
    /**
     * dcdg_bussiness_order_base 根据主键删除
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * dcdg_bussiness_order_base  插入
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int insert(Order record);

    /**
     * dcdg_bussiness_order_base 根据主键查询
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    Order selectByPrimaryKey(String orderId);

    /**
     * dcdg_bussiness_order_base 查找所有
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    List<Order> selectAll();

    /**
     * dcdg_bussiness_order_base 根据主键修改
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int updateByPrimaryKey(Order record);

    List<Order> orderDetailByOrderIdAndCustId(@Param("custId") String custId, @Param("orderId") String orderId);

    List<Order> orderDetailByOrderIdsAndShopId(@Param("shopId") String shopId, @Param("orderIds") List<String> orderIds);


//    Integer selectOrderStatusByOrderId(String orderId);

    Order selectByPrimaryKeyLock(String orderId);


    /**
     * 根据订单号获取所以订单id
     *
     * @param orderNo
     * @return
     */
    List<String> getOrderIdsByOrderNo(String orderNo);

    /**
     * 支付成功更新金额和状态   订单支付成功 独享
     *
     * @param orderStatus 状态
     * @param rmbAmt      现金
     * @param orderId     订单id
     * @param now         时间
     * @param consumeAmt  余额
     * @param payType     [0-未付款 1-纯消费积分 2-积分+余额   5-纯余额  3-积分+微信 4-纯微信 6-积分+支付宝 7-纯支付宝] (后台完成是 1 2 5)
     * @return
     */

    int updateOrderStatusAndRmbAmtAndUpdateTimeAndConsumeAmt(@Param("orderStatus") int orderStatus, @Param("rmbAmt") Double rmbAmt, @Param("orderId") String orderId, @Param("updateTime") Date now, @Param("consumeAmt") Double consumeAmt, @Param("deductionAmt") Double deductionAmt, @Param("payType") Integer payType, @Param("serialNo") String serialNo);


    /**
     * 订单状态修改 乐观更新
     *
     * @param orderStatus
     * @param orderId
     * @param custId
     * @param updateTime
     * @param oriOrderStatus
     * @return
     */
    int updateOrderStatusAndCustIdAndUpdateTime(@Param("orderStatus") int orderStatus, @Param("orderId") String orderId, @Param("custId") String custId, @Param("updateTime") Date updateTime, @Param("oriOrderStatus") int oriOrderStatus);

    int updateDeductionAmtByOrderNo(@Param("deductionAmt") Double deductionAmt, @Param("orderNo") String orderNo);


    List<Order> getOrderByCustIdAndAddTime(@Param("beginAddTime") Date beginAddTime, @Param("endAddTime") Date endAddTime, @Param("orderStatus") List<Integer> orderStatus, @Param("shopId") String shopId, @Param("isPromotion") Byte isPromotion);

    @MapF2F
    Map<Integer, Integer> getOrderStausByCustId(String custId);

    /**
     * 订单状态修改为删除
     * @param orderId
     * @param shopId
     * @return
     */
    int delOrderById(@Param("orderId") String orderId, @Param("shopId") String shopId);

    /**
     * 根据订单id获取 店铺名称 店铺id 店铺状态
     *
     * @param orderId
     * @return
     */
    Order selectOrderStatusShopIdAndShopNameByOrderId(String orderId);

    /**
     * 获取能收到的orderId
     *
     * @param custId
     * @return
     */
    @MapF2F
    Map<String, String> getSelledByCustId(@Param("custId") String custId, @Param("isPromotion") Byte isPromotion);

    /**
     * 取消订单
     *
     * @param orderId
     * @param orderProb
     * @return
     */
    int cancleOrderById(@Param("orderId") String orderId, @Param("orderProb") String orderProb, @Param("updateTime") Date updateTime, @Param("returnMoney") Double returnMoney);

    /**
     * 根据用户id 订单id 查询订单信息
     * @param custId
     * @param orderId
     * @return
     */
    Order queryOrderByOrderId(@Param("custId") String custId, @Param("orderId") String orderId);

    /**
     * 订单信息
     * @param dayTimeBegin
     * @param dayTimeEnd
     * @param weekTimeBegin
     * @param weekTimeEnd
     * @return
     */
    Order  orderInformation(@Param("shopId") String shopId,@Param("dayTimeBegin") String dayTimeBegin
            , @Param("dayTimeEnd") String dayTimeEnd,@Param("weekTimeBegin") String weekTimeBegin, @Param("weekTimeEnd") String weekTimeEnd);


    /**
     *修改订单地址
     * @param orderId
     * @param postInfo
     * @return
     */
    int updateAdress(@Param("orderId") String orderId,@Param("postInfo") String postInfo);

    /**
     * 根据订单id查询订单地址
     * @param orderId
     * @return
     */
    String queryOrderPostInfoByOrderId(@Param("orderId") String orderId);

    /**
     * 修改订单状态为发货
     * @param orderId
     * @return
     */
    int updateStatusForSendGoods(@Param("orderId") String orderId,@Param("senderName") String senderName);

    /**
     * 修改订单状态为服务完成
     * @param orderId
     * @return
     */
    int updateStatusForserviceCompletion(@Param("orderId") String orderId);

    int agreeAfterSale(@Param("orderId") String orderId,@Param("orderStatus") Integer orderStatus);

    int completeAfterSale(@Param("orderId") String orderId);

    /**
     * 钱包列表
     * @param shopId
     * @param screen
     * @param moneyTypeList
     * @param monthBegin
     * @param monthEnd
     * @return
     */
    List<Order> walletList(@Param("shopId") String shopId,@Param("screen") Byte screen,@Param("moneyType") Byte moneyType
            ,@Param("moneyTypeList") List<Byte> moneyTypeList,@Param("monthBegin") String monthBegin,@Param("monthEnd") String monthEnd);




    /**
     * 商户最早可结算时间
     * @param shopId
     * @return
     */
    Date earliestwalletMonth(@Param("shopId") String shopId);

    /**
     * 可结算积分总和，余额总和
     * @param shopId
     * @return
     */
    Order totalMoney501(@Param("shopId") String shopId);
    /**
     *可退款结算积分总和，余额总和
     * @param shopId
     * @return
     */
    Order totalMoney911(@Param("shopId") String shopId);

    /**
     * 根据orderId shopId 查询结算订单详情
     * @param shopId
     * @param orderId
     * @return
     */
    Order querySettlementInfoOrderDetailByOrderIdAndShopId(@Param("shopId") String shopId,@Param("orderId") String orderId);



    List<Order> salesStatistics(@Param("myType") Integer myType,@Param("shopId") String shopId
            ,@Param("beginTime") String beginTime,@Param("endTime") String endTime);

    List<Order> SalesVolumeStatistics(@Param("myType") Integer myType,@Param("shopId") String shopId
            ,@Param("beginTime") String beginTime,@Param("endTime") String endTime);

    List<Order> customerVolumeStatistics(@Param("myType") Integer myType,@Param("shopId") String shopId
            ,@Param("beginTime") String beginTime,@Param("endTime") String endTime);


}