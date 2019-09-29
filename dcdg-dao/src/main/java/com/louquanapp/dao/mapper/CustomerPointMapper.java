package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.CustomerPoint;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerPointMapper {
    /**
     * dcdg_bussiness_customer_point 根据主键删除
     *
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    int deleteByPrimaryKey(String pointId);

    /**
     * dcdg_bussiness_customer_point  插入
     *
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    int insert(CustomerPoint record);

    /**
     * dcdg_bussiness_customer_point 根据主键查询
     *
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    CustomerPoint selectByPrimaryKey(String pointId);

    /**
     * dcdg_bussiness_customer_point 查找所有
     *
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    List<CustomerPoint> selectAll();

    /**
     * dcdg_bussiness_customer_point 根据主键修改
     *
     * @mbg.generated Wed Apr 10 17:27:32 CST 2019
     */
    int updateByPrimaryKey(CustomerPoint record);

    Double sumInvite(@Param("custId") String custId);


    Double sumInviteForregister(@Param("custId") String custId, @Param("pointMold") Byte pointMold);

    Double dayGamePoint(@Param("custId") String custId);

    /**
     * 当天签到数
     *
     * @param custId
     * @return
     */
    Integer daySignPoint(@Param("custId") String custId);

    /**
     * 本周签到数
     *
     * @param custId
     * @return
     */
    Integer weekSignPoint(@Param("custId") String custId);

    /**
     * 查询用户积分或余额记录
     *
     * @param gainType
     * @param pointType
     * @param custId
     * @return
     */
    List<CustomerPoint> customerPointOrBalance(@Param("gainType") Byte gainType, @Param("pointType") Byte pointType, @Param("custId") String custId);

    Double customerPointOrBalanceCount(@Param("type") Integer type, @Param("custId") String custId);


}