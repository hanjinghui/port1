package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.CustomerLog;
import java.util.List;

public interface CustomerLogMapper {
    /**
     * dcdg_customer_log_base 根据主键删除 
     *
     * @mbg.generated Tue Apr 23 16:22:37 CST 2019
     */
    int deleteByPrimaryKey(String logId);

    /**
     * dcdg_customer_log_base  插入 
     *
     * @mbg.generated Tue Apr 23 16:22:37 CST 2019
     */
    int insert(CustomerLog record);

    /**
     * dcdg_customer_log_base 根据主键查询 
     *
     * @mbg.generated Tue Apr 23 16:22:37 CST 2019
     */
    CustomerLog selectByPrimaryKey(String logId);

    /**
     * dcdg_customer_log_base 查找所有 
     *
     * @mbg.generated Tue Apr 23 16:22:37 CST 2019
     */
    List<CustomerLog> selectAll();

    /**
     * dcdg_customer_log_base 根据主键修改 
     *
     * @mbg.generated Tue Apr 23 16:22:37 CST 2019
     */
    int updateByPrimaryKey(CustomerLog record);
}