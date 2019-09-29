package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.VideoCat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoCatMapper {
    /**
     * dcdg_video_cat_base 根据主键删除 
     *
     * @mbg.generated Thu May 30 15:20:57 CST 2019
     */
    int deleteByPrimaryKey(String catId);

    /**
     * dcdg_video_cat_base  插入 
     *
     * @mbg.generated Thu May 30 15:20:57 CST 2019
     */
    int insert(VideoCat record);

    /**
     * dcdg_video_cat_base 根据主键查询 
     *
     * @mbg.generated Thu May 30 15:20:57 CST 2019
     */
    VideoCat selectByPrimaryKey(String catId);

    /**
     * dcdg_video_cat_base 查找所有 
     *
     * @mbg.generated Thu May 30 15:20:57 CST 2019
     */
    List<VideoCat> selectAll();

    /**
     * dcdg_video_cat_base 根据主键修改 
     *
     * @mbg.generated Thu May 30 15:20:57 CST 2019
     */
    int updateByPrimaryKey(VideoCat record);

    /**
     * 根据类型查询直播类型列表
     * @param catType
     * @return
     */
    List<VideoCat> queyVideoCatByCatType(@Param("catType") Byte catType);
}