package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Blacklist;
import org.apache.ibatis.annotations.Param;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface BlacklistMapper {
    /**
     * dcdg_basic_blacklist_base 根据主键删除 
     *
     * @mbg.generated Wed Jun 05 11:57:27 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * dcdg_basic_blacklist_base  插入 
     *
     * @mbg.generated Wed Jun 05 11:57:27 CST 2019
     */
    int insert(Blacklist record);

    /**
     * dcdg_basic_blacklist_base 根据主键查询 
     *
     * @mbg.generated Wed Jun 05 11:57:27 CST 2019
     */
    Blacklist selectByPrimaryKey(String id);

    /**
     * dcdg_basic_blacklist_base 查找所有 
     *
     * @mbg.generated Wed Jun 05 11:57:27 CST 2019
     */
    List<Blacklist> selectAll();

    /**
     * dcdg_basic_blacklist_base 根据主键修改 
     *
     * @mbg.generated Wed Jun 05 11:57:27 CST 2019
     */
    int updateByPrimaryKey(Blacklist record);

    /**
     * 获取黑名单
     * @param blacklistType
     */
    Blacklist getBlacklistByBlacklistType(@Param("blacklistType")Byte blacklistType);

    List<String> queryBlacklist();
}