package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.SettleOrder;
import java.util.List;

public interface SettleOrderMapper {
    /**
     * dcdg_settle_settleorder_base 根据主键删除 
     *
     * @mbg.generated Thu Apr 25 09:28:21 CST 2019
     */
    int deleteByPrimaryKey(String settleId);

    /**
     * dcdg_settle_settleorder_base  插入 
     *
     * @mbg.generated Thu Apr 25 09:28:21 CST 2019
     */
    int insert(SettleOrder record);

    /**
     * dcdg_settle_settleorder_base 根据主键查询 
     *
     * @mbg.generated Thu Apr 25 09:28:21 CST 2019
     */
    SettleOrder selectByPrimaryKey(String settleId);

    /**
     * dcdg_settle_settleorder_base 查找所有 
     *
     * @mbg.generated Thu Apr 25 09:28:21 CST 2019
     */
    List<SettleOrder> selectAll();

    /**
     * dcdg_settle_settleorder_base 根据主键修改 
     *
     * @mbg.generated Thu Apr 25 09:28:21 CST 2019
     */
    int updateByPrimaryKey(SettleOrder record);
}