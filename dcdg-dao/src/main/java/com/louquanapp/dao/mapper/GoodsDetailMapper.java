package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.GoodsAttribute;
import com.louquanapp.dao.model.GoodsDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDetailMapper {
    /**
     * dcdg_goods_goods_detail 根据主键删除
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int deleteByPrimaryKey(String detailId);

    /**
     * dcdg_goods_goods_detail  插入
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int insert(GoodsDetail record);

    /**
     * dcdg_goods_goods_detail 根据主键查询
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    GoodsDetail selectByPrimaryKey(String detailId);

    /**
     * dcdg_goods_goods_detail 查找所有
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    List<GoodsDetail> selectAll();

    /**
     * dcdg_goods_goods_detail 根据主键修改
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int updateByPrimaryKey(GoodsDetail record);

    List<GoodsDetail> selectByGoodsId(String goodsId);

    int batchInsert(@Param("list") List<GoodsDetail> goodsTags);
    int deleteGoodsDetailByGoodsId(@Param("goodsId") String goodsId);

    List<String> queryDetailIdByGoodsId(@Param("goodsId") String goodsId);

}