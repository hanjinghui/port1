package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.AboutUs;
import java.util.List;

public interface AboutUsMapper {
    /**
     * dcdg_about_us_base 根据主键删除 
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    int deleteByPrimaryKey(String aboutId);

    /**
     * dcdg_about_us_base  插入 
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    int insert(AboutUs record);

    /**
     * dcdg_about_us_base 根据主键查询 
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    AboutUs selectByPrimaryKey(String aboutId);

    /**
     * dcdg_about_us_base 查找所有 
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    List<AboutUs> selectAll();

    /**
     * dcdg_about_us_base 根据主键修改 
     *
     * @mbg.generated Mon May 27 16:05:54 CST 2019
     */
    int updateByPrimaryKey(AboutUs record);
}