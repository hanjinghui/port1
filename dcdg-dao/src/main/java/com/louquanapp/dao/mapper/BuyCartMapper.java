package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.BuyCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuyCartMapper {
    /**
     * dcdg_bussiness_customer_buycart 根据主键删除
     *
     * @mbg.generated Wed Apr 03 18:46:21 CST 2019
     */
    int deleteByPrimaryKey(String cartId);

    /**
     * dcdg_bussiness_customer_buycart  插入
     *
     * @mbg.generated Wed Apr 03 18:46:21 CST 2019
     */
    int insert(BuyCart record);

    /**
     * dcdg_bussiness_customer_buycart 根据主键查询
     *
     * @mbg.generated Wed Apr 03 18:46:21 CST 2019
     */
    BuyCart selectByPrimaryKey(String cartId);

    /**
     * dcdg_bussiness_customer_buycart 查找所有
     *
     * @mbg.generated Wed Apr 03 18:46:21 CST 2019
     */
    List<BuyCart> selectAll();

    /**
     * dcdg_bussiness_customer_buycart 根据主键修改
     *
     * @mbg.generated Wed Apr 03 18:46:21 CST 2019
     */
    int updateByPrimaryKey(BuyCart record);


    /**
     * 更新购物车数量
     *
     * @param cartId
     * @param custId
     * @param curGoodsNum
     * @param goodsNum    历史的乐观锁更新
     * @return
     */
    int updateCartNumByCartIdAndCustId(@Param("cartId") String cartId, @Param("custId") String custId, @Param("curGoodsNum") Integer curGoodsNum, @Param("goodsNum") Integer goodsNum);

    /**
     * 减少购物车数量
     *
     * @param cartId
     * @param custId
     * @return
     */
    int updateCartNumMinusByCartIdCustId(@Param("cartId") String cartId, @Param("custId") String custId, @Param("goodsNum") Integer goodsNum);

    /**
     * 批量删除 购物车
     *
     * @param arrSelected
     * @param custId
     * @return
     */
    int removeCartByCartIdsAndCustId(@Param("cartIds") List<String> arrSelected, @Param("custId") String custId, @Param("isPromotion") Byte isPromotion);


    /**
     * 删除单个购物车信息
     *
     * @param cartId
     * @param custId
     * @return
     */
    int removeCartByCartIdAndCustId(@Param("cartId") String cartId, @Param("custId") String custId, @Param("isPromotion") Byte isPromotion);

    /**
     * 增加到购物车 是否存在判断
     *
     * @param goodsSku
     * @param custId
     * @return
     */
    BuyCart getCartByGoodsIdAndGoodsSkuAndCustId(@Param("goodsSku") String goodsSku, @Param("custId") String custId, @Param("isPromotion") Byte isPromotion);


    int clearCartByCustId(String custId);

    /**
     * 购物车中的
     *
     * @param custId
     * @return
     */
    List<BuyCart> cartListByCustId(@Param("cartIds")List<String> arrSelected,@Param("custId") String custId, @Param("isPromotion") Byte isPromotion);

    /**
     * 直接购买中的
     *
     * @param custId
     * @return
     */
    List<BuyCart> cartListByCustIdBuy( @Param("cartIds") List<String> arrSelected,@Param("custId") String custId, @Param("isPromotion") Byte isPromotion);

    int countCartByCustId(String custId);

    /**
     * 我的购物车列表
     *
     * @param custId
     * @param arrSelected
     * @param isPromotion
     * @return
     */
    List<BuyCart> cartListByCustIdAndCartIds(@Param("custId") String custId, @Param("cartIds") List<String> arrSelected, @Param("isPromotion") Byte isPromotion);


}