package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Cat;
import java.util.List;

public interface CatMapper {
    /**
     * dcdg_video_cat_base 根据主键删除
     *
     * @mbg.generated Thu Apr 11 10:19:02 CST 2019
     */
    int deleteByPrimaryKey(String catId);

    /**
     * dcdg_video_cat_base  插入
     *
     * @mbg.generated Thu Apr 11 10:19:02 CST 2019
     */
    int insert(Cat record);

    /**
     * dcdg_video_cat_base 根据主键查询
     *
     * @mbg.generated Thu Apr 11 10:19:02 CST 2019
     */
    Cat selectByPrimaryKey(String catId);

    /**
     * dcdg_video_cat_base 查找所有
     *
     * @mbg.generated Thu Apr 11 10:19:02 CST 2019
     */
    List<Cat> selectAll();

    /**
     * dcdg_video_cat_base 根据主键修改
     *
     * @mbg.generated Thu Apr 11 10:19:02 CST 2019
     */
    int updateByPrimaryKey(Cat record);


    List<Cat> videoCats();
}