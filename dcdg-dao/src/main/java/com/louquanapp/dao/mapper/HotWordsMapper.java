package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.HotWords;

import java.util.List;

public interface HotWordsMapper {
    /**
     * dcdg_basic_hotwords_base 根据主键删除
     *
     * @mbg.generated Sat Mar 30 23:16:59 CST 2019
     */
    int deleteByPrimaryKey(String wordsId);

    /**
     * dcdg_basic_hotwords_base  插入
     *
     * @mbg.generated Sat Mar 30 23:16:59 CST 2019
     */
    int insert(HotWords record);

    /**
     * dcdg_basic_hotwords_base 根据主键查询
     *
     * @mbg.generated Sat Mar 30 23:16:59 CST 2019
     */
    HotWords selectByPrimaryKey(String wordsId);

    /**
     * dcdg_basic_hotwords_base 查找所有
     *
     * @mbg.generated Sat Mar 30 23:16:59 CST 2019
     */
    List<HotWords> selectAll();

    /**
     * dcdg_basic_hotwords_base 根据主键修改
     *
     * @mbg.generated Sat Mar 30 23:16:59 CST 2019
     */
    int updateByPrimaryKey(HotWords record);

    /**
     * 查询有效的热搜词
     *
     * @return
     */
    List<String> selectAllWordsVal();
}