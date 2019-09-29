package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.CategorySpecification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategorySpecificationMapper {
    /**
     * dcdg_goods_category_specification 根据主键删除 
     *
     * @mbg.generated Wed Sep 18 19:58:34 CST 2019
     */
    int deleteByPrimaryKey(String csId);

    /**
     * dcdg_goods_category_specification  插入 
     *
     * @mbg.generated Wed Sep 18 19:58:34 CST 2019
     */
    int insert(CategorySpecification record);

    /**
     * dcdg_goods_category_specification 根据主键查询 
     *
     * @mbg.generated Wed Sep 18 19:58:34 CST 2019
     */
    CategorySpecification selectByPrimaryKey(String csId);

    /**
     * dcdg_goods_category_specification 查找所有 
     *
     * @mbg.generated Wed Sep 18 19:58:34 CST 2019
     */
    List<CategorySpecification> selectAll();

    /**
     * dcdg_goods_category_specification 根据主键修改 
     *
     * @mbg.generated Wed Sep 18 19:58:34 CST 2019
     */
    int updateByPrimaryKey(CategorySpecification record);

    List<CategorySpecification> getSpecOptionByCatId(@Param("catId") String catId);
}