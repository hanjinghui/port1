package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.CustomerCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerCouponMapper {
    /**
     * dcdg_bussiness_customer_coupon 根据主键删除 
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    int deleteByPrimaryKey(String custCouponId);

    /**
     * dcdg_bussiness_customer_coupon  插入 
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    int insert(CustomerCoupon record);

    /**
     * dcdg_bussiness_customer_coupon 根据主键查询 
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    CustomerCoupon selectByPrimaryKey(String custCouponId);

    /**
     * dcdg_bussiness_customer_coupon 查找所有 
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    List<CustomerCoupon> selectAll();

    /**
     * dcdg_bussiness_customer_coupon 根据主键修改 
     *
     * @mbg.generated Tue Jul 09 14:44:52 CST 2019
     */
    int updateByPrimaryKey(CustomerCoupon record);

    int existCustomerCoupon(@Param("couponId")String couponId,@Param("custId")String custId);

    CustomerCoupon queryCouponCountByCouponId(@Param("couponId")String couponId);

    List<CustomerCoupon> writeOffCouponList(@Param("gainId")String custId);

    int writeOffCoupon(@Param("gainId")String gainId,@Param("custCouponId")String custCouponId);

    CustomerCoupon couponDetail(@Param("custCouponId")String custCouponId);
}