package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Banner;
import com.louquanapp.dao.model.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    /**
     * dcdg_basic_brand_base 根据主键删除
     *
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    int deleteByPrimaryKey(String brandId);

    /**
     * dcdg_basic_brand_base  插入
     *
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    int insert(Brand record);

    /**
     * dcdg_basic_brand_base 根据主键查询
     *
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    Brand selectByPrimaryKey(String brandId);

    /**
     * dcdg_basic_brand_base 查找所有
     *
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    List<Brand> selectAll();

    /**
     * dcdg_basic_brand_base 根据主键修改
     *
     * @mbg.generated Tue Apr 02 11:48:53 CST 2019
     */
    int updateByPrimaryKey(Brand record);

    List<Brand> selectMinBrandByCatId(@Param("catId") String catId);
    /**
     * 查询目标是12是的 积分或余额数据
     * @return
     */
    Banner queryPointOrCast();
}