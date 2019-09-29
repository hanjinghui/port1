package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.OrderOperate;

import java.util.List;

public interface OrderOperateMapper {
    /**
     * dcdg_bussiness_order_operate 根据主键删除
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int deleteByPrimaryKey(String optId);

    /**
     * dcdg_bussiness_order_operate  插入
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int insert(OrderOperate record);

    /**
     * dcdg_bussiness_order_operate 根据主键查询
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    OrderOperate selectByPrimaryKey(String optId);

    /**
     * dcdg_bussiness_order_operate 查找所有
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    List<OrderOperate> selectAll();

    /**
     * dcdg_bussiness_order_operate 根据主键修改
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int updateByPrimaryKey(OrderOperate record);

    int batchInsert(List<OrderOperate> orderOperates);

    List<OrderOperate> getListByOrderIdAndDefaultStatus(String orderId);
}