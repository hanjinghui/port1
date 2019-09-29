package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.GoodsTags;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsTagsMapper {
    /**
     * dcdg_goods_goods_tags 根据主键删除
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int deleteByPrimaryKey(String gtId);

    /**
     * dcdg_goods_goods_tags  插入
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int insert(GoodsTags record);

    /**
     * dcdg_goods_goods_tags 根据主键查询
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    GoodsTags selectByPrimaryKey(String gtId);

    /**
     * dcdg_goods_goods_tags 查找所有
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    List<GoodsTags> selectAll();

    /**
     * dcdg_goods_goods_tags 根据主键修改
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int updateByPrimaryKey(GoodsTags record);

    int deleteByGoodsId(@Param("goodsId") String goodsId);
    int batchInsert(@Param("list") List<GoodsTags> goodsTags);
}