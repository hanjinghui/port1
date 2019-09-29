package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.GoodsHotWords;

import java.util.List;

public interface GoodsHotWordsMapper {
    /**
     * dcdg_goods_hotwords_base 根据主键删除
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int deleteByPrimaryKey(String wordsId);

    /**
     * dcdg_goods_hotwords_base  插入
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int insert(GoodsHotWords record);

    /**
     * dcdg_goods_hotwords_base 根据主键查询
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    GoodsHotWords selectByPrimaryKey(String wordsId);

    /**
     * dcdg_goods_hotwords_base 查找所有
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    List<GoodsHotWords> selectAll();

    /**
     * dcdg_goods_hotwords_base 根据主键修改
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int updateByPrimaryKey(GoodsHotWords record);
}