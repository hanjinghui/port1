package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Statistic;
import java.util.List;

public interface StatisticMapper {
    /**
     * dcdg_order_statistic_base 根据主键删除 
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    int deleteByPrimaryKey(String dayId);

    /**
     * dcdg_order_statistic_base  插入 
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    int insert(Statistic record);

    /**
     * dcdg_order_statistic_base 根据主键查询 
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    Statistic selectByPrimaryKey(String dayId);

    /**
     * dcdg_order_statistic_base 查找所有 
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    List<Statistic> selectAll();

    /**
     * dcdg_order_statistic_base 根据主键修改 
     *
     * @mbg.generated Fri Apr 26 16:33:41 CST 2019
     */
    int updateByPrimaryKey(Statistic record);
}