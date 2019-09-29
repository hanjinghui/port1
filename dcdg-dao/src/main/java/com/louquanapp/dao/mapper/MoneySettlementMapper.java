package com.louquanapp.dao.mapper;

import com.louquanapp.dao.config.DataSourceConfig;
import com.louquanapp.dao.model.MoneySettlement;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface MoneySettlementMapper {
    /**
     * dcdg_money_settlement_info 根据主键删除 
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    int deleteByPrimaryKey(String moneyId);

    /**
     * dcdg_money_settlement_info  插入 
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    int insert(MoneySettlement record);

    /**
     * dcdg_money_settlement_info 根据主键查询 
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    MoneySettlement selectByPrimaryKey(String moneyId);

    /**
     * dcdg_money_settlement_info 查找所有 
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    List<MoneySettlement> selectAll();

    /**
     * dcdg_money_settlement_info 根据主键修改 
     *
     * @mbg.generated Wed Sep 04 15:43:52 CST 2019
     */
    int updateByPrimaryKey(MoneySettlement record);

    /**
     * 资金结算记录
     * @param userId
     * @param monthBegin
     * @param monthEnd
     * @return
     */
    List<MoneySettlement> walletListBySettleStatus(@Param("userId") String userId, @Param("monthBegin") String monthBegin, @Param("monthEnd") String monthEnd);
    Date earliestSettlementMonth(@Param("userId") String userId);

    MoneySettlement ettlesdDetail(@Param("userId") String userId,@Param("moneyId") String moneyId);

}