package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Order;
import com.louquanapp.dao.model.UserMoney;
import com.louquanapp.dao.model.UserRebate;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserMoneyMapper {
    /**
     * andji_system_user_money 根据主键删除 
     *
     * @mbg.generated Wed Sep 04 15:43:13 CST 2019
     */
    int deleteByPrimaryKey(String moneyId);

    /**
     * andji_system_user_money  插入 
     *
     * @mbg.generated Wed Sep 04 15:43:13 CST 2019
     */
    int insert(UserMoney record);

    /**
     * andji_system_user_money 根据主键查询 
     *
     * @mbg.generated Wed Sep 04 15:43:13 CST 2019
     */
    UserMoney selectByPrimaryKey(String moneyId);

    /**
     * andji_system_user_money 查找所有 
     *
     * @mbg.generated Wed Sep 04 15:43:13 CST 2019
     */
    List<UserMoney> selectAll();

    /**
     * andji_system_user_money 根据主键修改 
     *
     * @mbg.generated Wed Sep 04 15:43:13 CST 2019
     */
    int updateByPrimaryKey(UserMoney record);


    /**
     * 钱包列表
     * @param userId
     * @param valueType
     * @param addOrSubType
     * @return
     */
    List<UserMoney> walletList(@Param("userId") String userId, @Param("valueType") Byte valueType, @Param("addOrSubType") Byte addOrSubType);


    /**
     * 按月查询推广返利列表
     * @param custId
     * @param beginTime
     * @param endTime
     * @return
     */
    List<UserMoney> queryUserRebateListByAddTime(@Param("userId") String custId, @Param("beginTime") String beginTime
            , @Param("endTime") String endTime);

    Date queryEarliestMonthByUserId(@Param("userId") String custId);
    UserMoney queryTotalUserRebateByUserId(@Param("userId") String userId,@Param("beginTime") String beginTime
            ,@Param("endTime") String endTime);


    String queryMoneyIdBySourceType(@Param("userId") String userId);
}