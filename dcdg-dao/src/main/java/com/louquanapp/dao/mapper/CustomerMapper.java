package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CustomerMapper {
    /**
     * dcdg_bussiness_customer_base 根据主键删除
     *
     * @mbg.generated Tue Mar 26 14:27:01 CST 2019
     */
    int deleteByPrimaryKey(String custId);

    /**
     * dcdg_bussiness_customer_base  插入
     *
     * @mbg.generated Tue Mar 26 14:27:01 CST 2019
     */
    int insert(Customer record);

    /**
     * dcdg_bussiness_customer_base 根据主键查询
     *
     * @mbg.generated Tue Mar 26 14:27:01 CST 2019
     */
    Customer selectByPrimaryKey(String custId);

    /**
     * dcdg_bussiness_customer_base 查找所有
     *
     * @mbg.generated Tue Mar 26 14:27:01 CST 2019
     */
    List<Customer> selectAll();

    /**
     * dcdg_bussiness_customer_base 根据主键修改
     *
     * @mbg.generated Tue Mar 26 14:27:01 CST 2019
     */
    int updateByPrimaryKey(Customer record);


    Customer getByWechatId(String toString);

    Customer getByQqId(String openId);

    Customer getBySinaId(String openId);

    int updateByPrimaryKeySelective(Customer temp);



    Customer getByPhone(String phone);

    /**
     * 手机号是否存在
     *
     * @param custPhone
     * @return
     */
    int existCustomerByPhone(String custPhone);

    int existCustId(String custId);

    /**
     * 解绑账号是否存在
     *
     * @return
     */
    int selectCountByOpenIdAndType(Map<String, Object> map);

//    String getPushIdByCustId(String custId);
//
//    String selectNameByPrimaryKey(String custId);

    /**
     * 根据id 查询手机号,昵称，登录密码
     *
     * @param custId
     * @return
     */
    Customer selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(String custId);


    List<Customer> getHeadImgMapByCustIdIn(List<String> buyIds);

//    int doPaySuccessCurCustomerUpdate(Customer customer, int i, Double deductionAmt, Double consumeAmt, Double rmbAmt);

    int updateDeductionPointAndConsumePointByCustIdAndVersionDeductionPoint(Customer customerUpate);

    String getHeadImgMapByCustId(String custId);

    Integer selectFalgByInviterCode(@Param("custId") String inviteCode);

    /**
     * 获取商城积分
     *
     * @param inviterCode
     * @return
     */
    Double getDeductionPointByCustId(@Param("custId") String inviterCode);

    /**
     * 获取余额
     *
     * @param inviterCode
     * @return
     */
    Double getConsumePointByCustId(@Param("custId") String inviterCode);

    /**
     * 更新商城积分
     *
     * @param custId
     * @param deductionPoint
     * @param versionDeductionPoint
     * @return
     */
    int updatePlusDeductionPointBydVersionDeductionPointAndCustId(@Param("custId") String custId, @Param("deductionPoint") Double deductionPoint, @Param("versionDeductionPoint") Double versionDeductionPoint);

    /**
     * 更新余额
     *
     * @param custId
     * @param deductionPoint
     * @param versionConsumePPoint
     * @return
     */
    int updatePlusConsumePointBydVersionConsumePointAndCustId(@Param("custId") String custId, @Param("consumePoint") Double deductionPoint, @Param("versionConsumePoint") Double versionConsumePPoint);


    /**
     * 模糊查询用户昵称
     */
    List<Customer> selectNicks(@Param("nickName") String nickName, @Param("custId") String custId);


    /**
     * 根据custId查询昵称
     *
     * @param custId
     * @return
     */
    String getNickNameMapByCustId(String custId);

    /**
     * 根据视频id获取店铺id
     *
     * @param videoId
     * @return
     */
    String selectShopIdBuyVideoId(@Param("videoId") String videoId);
    /**
     * 查询第一次登录时间
     * @param custId
     * @return
     */
    Map queryLoginFirstTime(@Param("custId") String custId);

    /**
     * 增加第一次登录时间
     * @param custId
     * @param loginFirstTime
     * @return
     */
    int addLoginFirstTime(@Param("custId") String custId,@Param("loginFirstTime") Date loginFirstTime);

    /**
     * 增加剩余现金余额
     * @param custId
     * @param consumePoint
     * @return
     */
    int addConsumePoint(@Param("custId") String custId,@Param("consumePoint") Double consumePoint);

    int returnComsumeAmt(Customer customer);
    int returnDeductionAmt(Customer customer);

    List<String> listAllCustId();

    List<Customer> custList();

    List<Customer> inviteCustList(@Param("inviteCode") String inviteCode);

    int inviteCustCount(@Param("inviteCode") String inviteCode);

}