package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    /**
     * dcdg_goods_goods_base 根据主键删除
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int deleteByPrimaryKey(String goodsId);

    /**
     * dcdg_goods_goods_base  插入
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int insert(Goods record);

    /**
     * dcdg_goods_goods_base 根据主键查询
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    Goods selectByPrimaryKey(String goodsId);

    Goods selectShort(String goodsId);

    /**
     * dcdg_goods_goods_base 查找所有
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    List<Goods> selectAll();

    /**
     * dcdg_goods_goods_base 根据主键修改
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int updateByPrimaryKey(Goods record);


    List<Goods> searchGoods(Goods goods);


    Double maxPostFee(List<String> ids);

    int addGoodSkipCountByGoodsId(String id);

    Goods selectGoodsImgAndCatPathAndGoodsNameAndPutawayFlagByPrimaryKey(String goodsId);

    String selectShopIdById(String goodsId);

    /**
     * 查询商品推荐
     *
     * @return
     */
    List<Goods> queryGoodsRec();

    /**
     * 查询热门兑换推荐商品
     * @return
     */
    List<Goods>  queryGoodsIsHotExchange(Goods goods);

    /**
     * 扣减库存
     * @param goodsId
     * @param goodsNum
     * @return
     */
    int deductionStockCountForGoods(@Param("goodsId") String goodsId,@Param("goodsNum") Integer goodsNum);


    /**
     * 增加库存
     * @param goodsId
     * @param goodsNum
     * @return
     */
    int deductionStockCountForGoodsAdd(@Param("goodsId") String goodsId,@Param("goodsNum") Integer goodsNum);


    List<Goods>  queryGoodsByFlay(@Param("shopId") String shopId,@Param("flay") Byte flay);

    Goods queryGoodsByFlayCount(@Param("shopId") String shopId);


    int updateGoodsPutawayFlag(@Param("shopId") String shopId,@Param("goodsId") String goodsId,@Param("putawayFlag") Byte putawayFlag);

    int updateGoodsDelt(@Param("shopId") String shopId,@Param("goodsId") String goodsId);

}