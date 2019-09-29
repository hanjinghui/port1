package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.AttributeOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttributeOptionMapper {
    /**
     * dcdg_goods_attribute_option 根据主键删除
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int deleteByPrimaryKey(String optId);

    /**
     * dcdg_goods_attribute_option  插入
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int insert(AttributeOption record);

    /**
     * dcdg_goods_attribute_option 根据主键查询
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    AttributeOption selectByPrimaryKey(String optId);

    /**
     * dcdg_goods_attribute_option 查找所有
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    List<AttributeOption> selectAll();

    /**
     * dcdg_goods_attribute_option 根据主键修改
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int updateByPrimaryKey(AttributeOption record);


    List<AttributeOption> selectAttrByCatId(@Param("catId") String catId);

    AttributeOption getByAttrId( @Param("catId") String attrId);
}