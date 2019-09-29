package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.OrderEvaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface OrderEvaluateMapper {
    /**
     * dcdg_bussiness_order_evaluate 根据主键删除
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int deleteByPrimaryKey(String evaluateId);

    /**
     * dcdg_bussiness_order_evaluate  插入
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int insert(OrderEvaluate record);

    /**
     * dcdg_bussiness_order_evaluate 根据主键查询
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    OrderEvaluate selectByPrimaryKey(String evaluateId);

    /**
     * dcdg_bussiness_order_evaluate 查找所有
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    List<OrderEvaluate> selectAll();

    /**
     * dcdg_bussiness_order_evaluate 根据主键修改
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int updateByPrimaryKey(OrderEvaluate record);


    int countOrderEvaluateByGoodsIdAndEvaluateResult(@Param("goodsId") String goodsId, @Param("evaluateResult") int evaluateResult);

    int countOrderEvaluateByCustIdAndEvaluateResult(@Param("buyerId") String buyerId, @Param("evaluateResult")int evaluateResult);

    List<OrderEvaluate> listOrderEvaluateByGoodsIdAndEvaluateResult(@Param("goodsId") String goodsId, @Param("evaluateResult") Integer evaluateResult);

    List<String> childIds(@Param("list") Set<String> childIds, @Param("sellerId") String sellerId);

    int selectCountByOrderId(String orderId);

    List<OrderEvaluate> getOrderEvaluateByGoodsIdOrderByAddTimeDesc(String goodsId);

    /**
     * 根据订单子项获取评论
     *
     * @param childId
     * @return
     */
    OrderEvaluate selectByChildIdAndBuyerId(@Param("childId") String childId, @Param("buyerId") String custId);

    /**
     * 查询我的订单评论
     *
     * @param custId
     * @param evaluateResult
     * @return
     */
    List<OrderEvaluate> myListOrderEvaluateByGoodsIdAndEvaluateResult(@Param("custId") String custId, @Param("evaluateResult") Integer evaluateResult);

    List<OrderEvaluate> evaluateList(@Param("shopId") String shopId, @Param("isReply") Integer isReply);

    OrderEvaluate evaluateDetail(@Param("shopId") String shopId,@Param("evaluateId") String evaluateId);

    int replyEvaluate(@Param("shopId") String shopId,@Param("evaluateId") String evaluateId,@Param("replyCont") String replyCont);
}