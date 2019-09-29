package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Specification;

import java.util.List;

public interface SpecificationMapper {
    /**
     * dcdg_goods_specification_base 根据主键删除
     *
     * @mbg.generated Wed Apr 03 08:25:28 CST 2019
     */
    int deleteByPrimaryKey(String specId);

    /**
     * dcdg_goods_specification_base  插入
     *
     * @mbg.generated Wed Apr 03 08:25:28 CST 2019
     */
    int insert(Specification record);

    /**
     * dcdg_goods_specification_base 根据主键查询
     *
     * @mbg.generated Wed Apr 03 08:25:28 CST 2019
     */
    Specification selectByPrimaryKey(String specId);

    /**
     * dcdg_goods_specification_base 查找所有
     *
     * @mbg.generated Wed Apr 03 08:25:28 CST 2019
     */
    List<Specification> selectAll();

    /**
     * dcdg_goods_specification_base 根据主键修改
     *
     * @mbg.generated Wed Apr 03 08:25:28 CST 2019
     */
    int updateByPrimaryKey(Specification record);

    String getSpecNameBySpecId(String specId);
}