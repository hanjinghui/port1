package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.CategoryAttribute;
import com.louquanapp.dao.model.CategorySpecification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryAttributeMapper {
    /**
     * dcdg_goods_category_attribute 根据主键删除 
     *
     * @mbg.generated Wed Sep 18 19:54:43 CST 2019
     */
    int deleteByPrimaryKey(String caId);

    /**
     * dcdg_goods_category_attribute  插入 
     *
     * @mbg.generated Wed Sep 18 19:54:43 CST 2019
     */
    int insert(CategoryAttribute record);

    /**
     * dcdg_goods_category_attribute 根据主键查询 
     *
     * @mbg.generated Wed Sep 18 19:54:43 CST 2019
     */
    CategoryAttribute selectByPrimaryKey(String caId);

    /**
     * dcdg_goods_category_attribute 查找所有 
     *
     * @mbg.generated Wed Sep 18 19:54:43 CST 2019
     */
    List<CategoryAttribute> selectAll();

    /**
     * dcdg_goods_category_attribute 根据主键修改 
     *
     * @mbg.generated Wed Sep 18 19:54:43 CST 2019
     */
    int updateByPrimaryKey(CategoryAttribute record);

    List<CategoryAttribute> getAttrOptionByCatId(@Param("catId") String catId);
}