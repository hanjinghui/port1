package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.CustomerAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerAccountMapper {
    /**
     * dcdg_bussiness_customer_account 根据主键删除
     *
     * @mbg.generated Tue Mar 26 15:08:36 CST 2019
     */
    int deleteByPrimaryKey(String custId);

    /**
     * dcdg_bussiness_customer_account  插入
     *
     * @mbg.generated Tue Mar 26 15:08:36 CST 2019
     */
    int insert(CustomerAccount record);

    /**
     * dcdg_bussiness_customer_account 根据主键查询
     *
     * @mbg.generated Tue Mar 26 15:08:36 CST 2019
     */
    CustomerAccount selectByPrimaryKey(String custId);

    /**
     * dcdg_bussiness_customer_account 查找所有
     *
     * @mbg.generated Tue Mar 26 15:08:36 CST 2019
     */
    List<CustomerAccount> selectAll();

    /**
     * dcdg_bussiness_customer_account 根据主键修改
     *
     * @mbg.generated Tue Mar 26 15:08:36 CST 2019
     */
    int updateByPrimaryKey(CustomerAccount record);


    int updateSelfBuyCountAndSurplusTotalPointAndSurplusShopPointAndSurplusCashPointAndComsumeRbmByUpdateTimeAndCustId(CustomerAccount customerAccount);


    /**
     * 更新积分信息
     *
     * @param inviterCode
     * @param surplusShopPoint
     * @param versionSurplusShopPoint
     * @return
     */
    int updatePlusDeductionPointBydVersionDeductionPointAndCustId(@Param("custId") String inviterCode, @Param("surplusShopPoint") Double surplusShopPoint, @Param("versionSurplusShopPoint") Double versionSurplusShopPoint);

    /**
     * 更新余额信息
     *
     * @param inviterCode
     * @param surplusCashPoint
     * @param versionSurplusCashPoint
     * @return
     */
    int updatePlusConsumePointBydVersionConsumePointAndCustId(@Param("custId") String inviterCode, @Param("surplusCashPoint") Double surplusCashPoint, @Param("versionSurplusCashPoint") Double versionSurplusCashPoint);

    /**
     * 增加粉丝
     *
     * @param custId
     * @return
     */
    int updatePlusTotalFocusCountByCustId(@Param("custId") String custId);

    /**
     * 减少
     *
     * @param custId
     * @return
     */
    int updateMinusTotalFocusCountByCustId(@Param("custId") String custId);

    /**
     * 查询关注量
     *
     * @param custId
     * @return
     */
    int selectFocusCountByPrimaryKey(@Param("custId") String custId);

    int returnComsumeAmt(CustomerAccount record);
     int returnDeductionAmt(CustomerAccount record);

}