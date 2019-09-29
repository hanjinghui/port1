package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.GoodsDetail;
import com.louquanapp.dao.model.GoodsImages;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsImagesMapper {
    /**
     * dcdg_goods_goods_images 根据主键删除
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int deleteByPrimaryKey(String imgId);

    /**
     * dcdg_goods_goods_images  插入
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int insert(GoodsImages record);

    /**
     * dcdg_goods_goods_images 根据主键查询
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    GoodsImages selectByPrimaryKey(String imgId);

    /**
     * dcdg_goods_goods_images 查找所有
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    List<GoodsImages> selectAll();

    /**
     * dcdg_goods_goods_images 根据主键修改
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int updateByPrimaryKey(GoodsImages record);

    List<String> getImgUrlBySourceId(String sourceId);

    /**
     * 根据资源来源和创建人查询图片路径
     * @param sourceType
     * @param addBy
     * @return
     */
    List<String> queryImgUrlBysourceTypeAndAddBy(@Param("sourceType") Byte sourceType,@Param("addBy") String addBy);
    int batchInsert(@Param("list") List<GoodsImages> goodsTags);

    int deleteGoodsImagesBySourceId(@Param("sourceIds") List<String> sourceIds );


    List<GoodsImages> listAll(@Param("sourceId") String sourceId,@Param("sourceType") Byte sourceType );

    List<String> queryImgUrls(@Param("sourceId") String sourceId,@Param("sourceType") Byte sourceType );






}