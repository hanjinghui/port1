package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Attribute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttributeMapper {
    /**
     * dcdg_goods_attribute_base 根据主键删除
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int deleteByPrimaryKey(String attrId);

    /**
     * dcdg_goods_attribute_base  插入
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int insert(Attribute record);

    /**
     * dcdg_goods_attribute_base 根据主键查询
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    Attribute selectByPrimaryKey(String attrId);

    /**
     * dcdg_goods_attribute_base 查找所有
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    List<Attribute> selectAll();

    /**
     * dcdg_goods_attribute_base 根据主键修改
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    int updateByPrimaryKey(Attribute record);

    /**
     * 根据主键获取名字
     *
     * @param attrId
     * @return
     */
    String selectNameByPrimaryKey(@Param("attrId") String attrId);
}