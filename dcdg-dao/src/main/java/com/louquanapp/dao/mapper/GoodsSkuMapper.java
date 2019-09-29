package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.GoodsSku;
import com.louquanapp.dao.model.GoodsTags;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsSkuMapper {
    /**
     * dcdg_goods_goods_sku 根据主键删除
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int deleteByPrimaryKey(String skuId);

    /**
     * dcdg_goods_goods_sku  插入
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int insert(GoodsSku record);

    /**
     * dcdg_goods_goods_sku 根据主键查询
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    GoodsSku selectByPrimaryKey(String skuId);

    /**
     * dcdg_goods_goods_sku 查找所有
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    List<GoodsSku> selectAll();

    /**
     * dcdg_goods_goods_sku 根据主键修改
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int updateByPrimaryKey(GoodsSku record);

    List<GoodsSku> getGoodsSkuByGoodsId(String goodsId);

    GoodsSku getMinGoodsSkuIdByGoodsId(String goodsId);

    String getSkuIdByReqGoodsSku(GoodsSku goodsSkuSearch);

    int getGoodsNumBySkuId(@Param("skuId") String skuId);

    GoodsSku getGoodsNumIdGoodsIdBySkuId(@Param("skuId") String skuId);

    List<GoodsSku> getGoodsIdAndGoodsImgAndSkuGoodsNameAndPutawayPriceMaxPointBySkuIds(List<String> ids);

//    /**
//     * 乐观更新sku 库存
//     *
//     * @param skuId
//     * @param stockCount
//     * @param goodsNum
//     * @return
//     */
    int updateStockCountBySkuIdAndGoodsNum(@Param("skuId") String skuId, @Param("goodsNum") Integer goodsNum);
    int updateStockCountBySkuIdAndGoodsNumAdd(@Param("skuId") String skuId, @Param("goodsNum") Integer goodsNum);


    GoodsSku selectGoodsImgAndSkuGoodsNameAndPutawayPriceAndGoodsNumByPrimaryKey(String skuId);

    //int minusStockCountByGoodsId(@Param("goodsNum") Integer goodsNum, @Param("goodsId") String goodsId, @Param("oriStockCount") int oriStockCount);

    List<String> getGoodsIdsByOptId(List<String> specOptSet);

    Double selectMaxPointPrimaryKey(@Param("skuId") String skuNo);
    Double selectMarketPricePrimaryKey(@Param("skuId") String skuNo);

    /**
     * 商品的最小积分
     *
     * @param goodsId
     * @return
     */
    Double selectMaxPointByGoodId(@Param("goodsId") String goodsId);

    GoodsSku getGoodsSkuShortByGoodsId(@Param("goodsId") String goodsId);

    String  getDefaultSkuIdByGoodsId(@Param("goodsId") String goodsId);

    /**
     * 查询是否允许积分购买
     * @param skuNo
     * @return
     */
    int isPointBySkuNo(@Param("skuNo") String skuNo);

    /**
     * 批量查询是否允许积分购买
     * @param skuNos
     * @return
     */
    int isPointBySkuNos(@Param("skuNos") List<String> skuNos);

    /**
     * 查询商品sku 是否允许积分兑换的状态
     * @param goodsId
     * @return
     */
    List<Byte> isPointByGoodsId(@Param("goodsId") String goodsId);



    int batchInsert(@Param("list") List<GoodsSku> goodsSkus);

    int updateGoodsSku(GoodsSku goodsSku);


}