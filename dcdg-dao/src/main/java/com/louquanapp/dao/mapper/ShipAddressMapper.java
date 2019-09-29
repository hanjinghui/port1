package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.ShipAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ShipAddressMapper {
    /**
     * dcdg_bussiness_customer_shipaddress 根据主键删除
     *
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    int deleteByPrimaryKey(String shipId);

    /**
     * dcdg_bussiness_customer_shipaddress  插入
     *
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    int insert(ShipAddress record);

    /**
     * dcdg_bussiness_customer_shipaddress 根据主键查询
     *
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    ShipAddress selectByPrimaryKey(String shipId);

    /**
     * dcdg_bussiness_customer_shipaddress 查找所有
     *
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    List<ShipAddress> selectAll();

    /**
     * dcdg_bussiness_customer_shipaddress 根据主键修改
     *
     * @mbg.generated Fri Mar 29 12:56:58 CST 2019
     */
    int updateByPrimaryKey(ShipAddress record);


    /**
     * 将当前地址设置为默认收货地址
     *
     * @param saddrId
     * @return
     */
    int setCurrentUserDefaultAddr(String saddrId);

    /**
     * 将custId所有地址设置非默认收货地址
     *
     * @param custId
     * @return
     */
    int setAllToNotDefaultByCustId(String custId);

    /**
     * 获取用户默认收货地址
     *
     * @param custId
     * @return
     */
    ShipAddress getDefaultByCustId(String custId);

    /**
     * 根据用户主键(防止信息被人恶意获取)和地址主键获取地址
     *
     * @param custId
     * @return
     */
    ShipAddress getAddressByCustIdAndShipId(@Param("custId") String custId, @Param("shipId") String shipId);

    /**
     * 根据用户主键(防止信息被人恶意获取)和地址主键删除地址
     *
     * @param custId
     * @param shipId
     * @return
     */
    int delAddressByCustIdAndShipId(@Param("custId") String custId, @Param("shipId") String shipId);


    int delAddressByCustIdAndShipIds(Map<String, Object> map);


    int updateByPrimaryKeyAndCustIdSelective(ShipAddress shipAddress);

    List<ShipAddress> selectAllByCustId(String custId);
}