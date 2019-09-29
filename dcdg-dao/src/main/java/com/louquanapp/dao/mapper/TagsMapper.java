package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Tags;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagsMapper {
    /**
     * dcdg_goods_tags_base 根据主键删除 
     *
     * @mbg.generated Tue Sep 17 19:13:12 CST 2019
     */
    int deleteByPrimaryKey(String tagsId);

    /**
     * dcdg_goods_tags_base  插入 
     *
     * @mbg.generated Tue Sep 17 19:13:12 CST 2019
     */
    int insert(Tags record);

    /**
     * dcdg_goods_tags_base 根据主键查询 
     *
     * @mbg.generated Tue Sep 17 19:13:12 CST 2019
     */
    Tags selectByPrimaryKey(String tagsId);

    /**
     * dcdg_goods_tags_base 查找所有 
     *
     * @mbg.generated Tue Sep 17 19:13:12 CST 2019
     */
    List<Tags> selectAll();

    /**
     * dcdg_goods_tags_base 根据主键修改 
     *
     * @mbg.generated Tue Sep 17 19:13:12 CST 2019
     */
    int updateByPrimaryKey(Tags record);

    List<Tags> queryTagsByTagsName(@Param("tagsName") String tagsName);

    int batchInsert(@Param("list") List<Tags> list);

}