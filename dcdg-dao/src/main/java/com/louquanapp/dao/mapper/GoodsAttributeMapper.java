package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.GoodsAttribute;
import com.louquanapp.dao.model.GoodsTags;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface GoodsAttributeMapper {
    /**
     * dcdg_goods_goods_attribute 根据主键删除
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int deleteByPrimaryKey(String gattrId);

    /**
     * dcdg_goods_goods_attribute  插入
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int insert(GoodsAttribute record);

    /**
     * dcdg_goods_goods_attribute 根据主键查询
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    GoodsAttribute selectByPrimaryKey(String gattrId);

    /**
     * dcdg_goods_goods_attribute 查找所有
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    List<GoodsAttribute> selectAll();

    /**
     * dcdg_goods_goods_attribute 根据主键修改
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int updateByPrimaryKey(GoodsAttribute record);

    List<GoodsAttribute> getGoodsAttrByGoodsId(String goodsId);

    List<String> getGoodsIdsByAttrs(List<String> asList);


    int deleteByGoodsId(@Param("goodsId") String goodsId);
    int batchInsert(@Param("list") List<GoodsAttribute> goodsTags);


}