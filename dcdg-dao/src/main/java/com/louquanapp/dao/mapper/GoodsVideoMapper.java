package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.GoodsVideo;

import java.util.List;

public interface GoodsVideoMapper {
    /**
     * dcdg_goods_goods_video 根据主键删除
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int deleteByPrimaryKey(String videoId);

    /**
     * dcdg_goods_goods_video  插入
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int insert(GoodsVideo record);

    /**
     * dcdg_goods_goods_video 根据主键查询
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    GoodsVideo selectByPrimaryKey(String videoId);

    /**
     * dcdg_goods_goods_video 查找所有
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    List<GoodsVideo> selectAll();

    /**
     * dcdg_goods_goods_video 根据主键修改
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int updateByPrimaryKey(GoodsVideo record);
}