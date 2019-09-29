package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.OrderPay;
import java.util.List;

public interface OrderPayMapper {
    /**
     * dcdg_bussiness_order_pay 根据主键删除 
     *
     * @mbg.generated Thu Jun 20 15:58:31 CST 2019
     */
    int deleteByPrimaryKey(String orderNo);

    /**
     * dcdg_bussiness_order_pay  插入 
     *
     * @mbg.generated Thu Jun 20 15:58:31 CST 2019
     */
    int insert(OrderPay record);

    /**
     * dcdg_bussiness_order_pay 根据主键查询 
     *
     * @mbg.generated Thu Jun 20 15:58:31 CST 2019
     */
    OrderPay selectByPrimaryKey(String orderNo);

    /**
     * dcdg_bussiness_order_pay 查找所有 
     *
     * @mbg.generated Thu Jun 20 15:58:31 CST 2019
     */
    List<OrderPay> selectAll();

    /**
     * dcdg_bussiness_order_pay 根据主键修改 
     *
     * @mbg.generated Thu Jun 20 15:58:31 CST 2019
     */
    int updateByPrimaryKey(OrderPay record);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelect(OrderPay record);
}