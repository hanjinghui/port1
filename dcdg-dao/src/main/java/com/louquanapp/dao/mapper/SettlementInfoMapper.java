package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Order;
import com.louquanapp.dao.model.SettlementInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SettlementInfoMapper {
    /**
     * dcdg_business_settlement_info 根据主键删除 
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    int deleteByPrimaryKey(String settleId);

    /**
     * dcdg_business_settlement_info  插入 
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    int insert(SettlementInfo record);

    /**
     * dcdg_business_settlement_info 根据主键查询 
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    SettlementInfo selectByPrimaryKey(String settleId);

    /**
     * dcdg_business_settlement_info 查找所有 
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    List<SettlementInfo> selectAll();

    /**
     * dcdg_business_settlement_info 根据主键修改 
     *
     * @mbg.generated Fri Aug 30 14:53:33 CST 2019
     */
    int updateByPrimaryKey(SettlementInfo record);

    /**
     * 查询商户结算明细
     * @param shopId
     * @param settleId
     * @return
     */
    SettlementInfo querySettledDetailBySettleIdAndShopId(@Param("shopId")String shopId,@Param("settleId")String settleId);
    /**
     * 结算中或已结算列表
     * @param shopId
     * @param monthBegin
     * @param monthEnd
     * @return
     */
    List<SettlementInfo> walletListBySettleStatus(@Param("shopId") String shopId, @Param("monthBegin") String monthBegin, @Param("monthEnd") String monthEnd);

    Date earliestSettlementMonth(@Param("shopId") String shopId);

}