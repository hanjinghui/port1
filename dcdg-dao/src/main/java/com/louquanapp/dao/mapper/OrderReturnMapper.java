package com.louquanapp.dao.mapper;

import com.louquanapp.dao.config.MapF2F;
import com.louquanapp.dao.model.OrderReturn;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface OrderReturnMapper {
    /**
     * dcdg_bussiness_order_return 根据主键删除
     *
     * @mbg.generated Wed Apr 10 09:33:56 CST 2019
     */
    int deleteByPrimaryKey(String returnId);

    /**
     * dcdg_bussiness_order_return  插入
     *
     * @mbg.generated Wed Apr 10 09:33:56 CST 2019
     */
    int insert(OrderReturn record);

    /**
     * dcdg_bussiness_order_return 根据主键查询
     *
     * @mbg.generated Wed Apr 10 09:33:56 CST 2019
     */
    OrderReturn selectByPrimaryKey(String returnId);

    /**
     * dcdg_bussiness_order_return 查找所有
     *
     * @mbg.generated Wed Apr 10 09:33:56 CST 2019
     */
    List<OrderReturn> selectAll();

    /**
     * dcdg_bussiness_order_return 根据主键修改
     *
     * @mbg.generated Wed Apr 10 09:33:56 CST 2019
     */
    int updateByPrimaryKey(OrderReturn record);
    @MapF2F
    Map<String,Integer> childIdOrderStatus(@Param("buyerId") String custID);

    List<String> childIds(@Param("list") Set<String> childIds, @Param("sellerId") String sellerId);

    OrderReturn selectByChildIdAndBuyerId(@Param("childId") String childId, @Param("buyerId") String custId);

    List<OrderReturn> afterSaleList(@Param("sellerId") String sellerId);

    OrderReturn afterSaleDetail(@Param("sellerId") String sellerId,@Param("returnId") String returnId);

    int deniedAfterSale(@Param("sellerId") String sellerId,@Param("returnId") String returnId,@Param("replyCont") String replyCont);

    int agreeAfterSale(@Param("returnId") String returnId);

}