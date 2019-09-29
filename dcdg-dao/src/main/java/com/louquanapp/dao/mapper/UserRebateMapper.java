package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.UserRebate;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserRebateMapper {
    /**
     * andji_system_user_rebate 根据主键删除 
     *
     * @mbg.generated Mon Aug 19 19:01:13 CST 2019
     */
    int deleteByPrimaryKey(String rebateId);

    /**
     * andji_system_user_rebate  插入 
     *
     * @mbg.generated Mon Aug 19 19:01:13 CST 2019
     */
    int insert(UserRebate record);

    /**
     * andji_system_user_rebate 根据主键查询 
     *
     * @mbg.generated Mon Aug 19 19:01:13 CST 2019
     */
    UserRebate selectByPrimaryKey(String rebateId);

    /**
     * andji_system_user_rebate 查找所有 
     *
     * @mbg.generated Mon Aug 19 19:01:13 CST 2019
     */
    List<UserRebate> selectAll();

    /**
     * andji_system_user_rebate 根据主键修改 
     *
     * @mbg.generated Mon Aug 19 19:01:13 CST 2019
     */
    int updateByPrimaryKey(UserRebate record);

    /**
     * 按月查询推广返利列表
     * @param custId
     * @param beginTime
     * @param endTime
     * @return
     */
    List<UserRebate> queryUserRebateListByAddTime(@Param("userId") String custId,@Param("beginTime") String beginTime
            ,@Param("endTime") String endTime);

    /**
     * 根据userId查询总的推广返利
     * @param userId
     * @return
     */
    UserRebate queryTotalUserRebateByUserId(@Param("userId") String userId,@Param("beginTime") String beginTime
            ,@Param("endTime") String endTime,@Param("isNum") Byte isNum  );

    UserRebate queryTotalUserRebateByUserIdForTotal(@Param("userId") String userId);

    List<UserRebate> queryUserRebateListByAddTimeForTotal(@Param("userId") String custId);

    Date queryEarliestMonthByUserId(@Param("userId") String custId,@Param("isNum") Byte isNum  );

    /**
     * 推广返利用户数量
     * @param custId
     * @return
     */
    int relationUserCount(@Param("userId") String custId);

    /**
     * 按月查询未满足推广返利列表
     * @param custId
     * @param beginTime
     * @param endTime
     * @return
     */
    List<UserRebate> queryUserRebateListIsNum1ByAddTime(@Param("userId") String custId,@Param("beginTime") String beginTime
            ,@Param("endTime") String endTime);

    /**
     * 按月查询已满足推广返利列表
     * @param custId
     * @param beginTime
     * @param endTime
     * @return
     */
    List<UserRebate> queryUserRebateListIsNum2ByAddTime(@Param("userId") String custId,@Param("beginTime") String beginTime
            ,@Param("endTime") String endTime);
}