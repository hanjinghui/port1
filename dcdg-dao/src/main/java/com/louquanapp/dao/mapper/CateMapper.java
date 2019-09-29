package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Cate;
import java.util.List;

public interface CateMapper {
    /**
     * dcdg_basic_cate_base 根据主键删除 
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    int deleteByPrimaryKey(String cateId);

    /**
     * dcdg_basic_cate_base  插入 
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    int insert(Cate record);

    /**
     * dcdg_basic_cate_base 根据主键查询 
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    Cate selectByPrimaryKey(String cateId);

    /**
     * dcdg_basic_cate_base 查找所有 
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    List<Cate> selectAll();

    /**
     * dcdg_basic_cate_base 根据主键修改 
     *
     * @mbg.generated Wed Apr 17 16:56:51 CST 2019
     */
    int updateByPrimaryKey(Cate record);

    /**
     * 查询美食列表
     * @return
     */
    List<Cate> selectCates();
}