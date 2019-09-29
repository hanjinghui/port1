package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Coupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponMapper {
    /**
     * dcdg_basic_coupon_base 根据主键删除 
     *
     * @mbg.generated Mon Apr 08 07:26:35 CST 2019
     */
    int deleteByPrimaryKey(String couponId);

    /**
     * dcdg_basic_coupon_base  插入 
     *
     * @mbg.generated Mon Apr 08 07:26:35 CST 2019
     */
    int insert(Coupon record);

    /**
     * dcdg_basic_coupon_base 根据主键查询 
     *
     * @mbg.generated Mon Apr 08 07:26:35 CST 2019
     */
    Coupon selectByPrimaryKey(String couponId);

    /**
     * dcdg_basic_coupon_base 查找所有 
     *
     * @mbg.generated Mon Apr 08 07:26:35 CST 2019
     */
    List<Coupon> selectAll();

    /**
     * dcdg_basic_coupon_base 根据主键修改 
     *
     * @mbg.generated Mon Apr 08 07:26:35 CST 2019
     */
    int updateByPrimaryKey(Coupon record);

    List<Coupon> couponsByCustId(@Param("custId") String custId,@Param("couponWay") Byte couponWay);

    int updateCustomerCouponByCouponIdAndCustId(@Param("couponId") String couponId,@Param("custId") String custId);

    int userCoupon(@Param("couponId") String couponId,@Param("gainId") String gainId);

    /**
     * 领取类优惠卷列表
     * @param couponType 类型[1-商品优惠 2-店铺优惠 3-全场通用]
     * @param couponConent 优惠商品Id/门店Id
     * @return
     */
    List<Coupon> couponsReceive(@Param("couponType") Byte couponType,@Param("couponConent") String couponConent
            ,@Param("couponId")String couponId,@Param("custId")String custId);
//    List<Coupon> couponsByCustIdAndContent(String custId, String couponConent);


    List<Coupon> couponList(@Param("addUser") String addUser,@Param("type") Byte type);


}