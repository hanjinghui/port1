package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Shop;
import com.louquanapp.dao.model.ShopApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopMapper {
    /**
     * dcdg_goods_shop_base 根据主键删除
     *
     * @mbg.generated Thu Apr 04 10:10:16 CST 2019
     */
    int deleteByPrimaryKey(String shopId);

    /**
     * dcdg_goods_shop_base  插入
     *
     * @mbg.generated Thu Apr 04 10:10:16 CST 2019
     */
    int insert(Shop record);

    /**
     * dcdg_goods_shop_base 根据主键查询
     *
     * @mbg.generated Thu Apr 04 10:10:16 CST 2019
     */
    Shop selectByPrimaryKey(String shopId);

    /**
     * dcdg_goods_shop_base 查找所有
     *
     * @mbg.generated Thu Apr 04 10:10:16 CST 2019
     */
    List<Shop> selectAll();

    /**
     * dcdg_goods_shop_base 根据主键修改
     *
     * @mbg.generated Thu Apr 04 10:10:16 CST 2019
     */
    int updateByPrimaryKey(Shop record);


    String selectAreaByPrimaryKey(String shopId);

    Shop selectShortByPrimaryKey(String shopId);

    /**
     * 查询用户是否已经开通过商户
     * @param custId
     * @return
     */
    Integer existShopByCustId(@Param("custId") String custId);

    Integer existShopByShopName(@Param("shopName") String shopName);

    Shop queryShopByCustId(String custId);

    int updateSelectByPrimaryKey(Shop Shop);

    String queryCatIdByShopId(@Param("shopId") String shopId);


    List<Shop> queryShopListByShopIds(@Param("shopIds") List<String> shopIds);

    int queryShopTypeByShopId(@Param("shopId") String shopId);

    Shop queyShopByShopIdForSubAccount(@Param("shopId") String shopId,@Param("userIds") List<String> userIds);

}