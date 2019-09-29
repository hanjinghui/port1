package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper {
    /**
     * dcdg_bussiness_order_item 根据主键删除
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int deleteByPrimaryKey(String childId);

    /**
     * dcdg_bussiness_order_item  插入
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int insert(OrderItem record);

    /**
     * dcdg_bussiness_order_item 根据主键查询
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    OrderItem selectByPrimaryKey(String childId);

    /**
     * dcdg_bussiness_order_item 查找所有
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    List<OrderItem> selectAll();

    /**
     * dcdg_bussiness_order_item 根据主键修改
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int updateByPrimaryKey(OrderItem record);

    List<OrderItem> getOrderItemByOrderId(String orderId);

    int batchInsert(List<OrderItem> orderItems);

    int getCountByOrderId(String orderId);

    /**
     * 根据订单ids 过去订单子项
     * @param strings
     * @return
     */
    List<OrderItem> getOrderItemByOrderIds(List<String> strings);

    /**
     * s售后里面的
     * @param strings
     * @return
     */
    List<OrderItem> getOrderItemByOrderIdsSh(List<String> strings);

    /**
     *
     * @param orderId
     * @param postCompany
     * @param postNo
     * @return
     */
    int updateItemForSendGoods(@Param("childId") String childId,@Param("orderId") String orderId
            ,@Param("postCompany") String postCompany,@Param("postNo") String postNo);

    List<String> getGoodsImgByOrderId(@Param("orderId") String orderId);

}