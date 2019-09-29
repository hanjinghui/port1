package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.BasicVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasicVersionMapper {
    /**
     * andji_basic_version_base 根据主键删除 
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    int deleteByPrimaryKey(String versionId);

    /**
     * andji_basic_version_base  插入 
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    int insert(BasicVersion record);

    /**
     * andji_basic_version_base 根据主键查询 
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    BasicVersion selectByPrimaryKey(String versionId);

    /**
     * andji_basic_version_base 查找所有 
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    List<BasicVersion> selectAll();

    /**
     * andji_basic_version_base 根据主键修改 
     *
     * @mbg.generated Mon Jul 08 18:33:27 CST 2019
     */
    int updateByPrimaryKey(BasicVersion record);

    BasicVersion queryBasicVersionByType(@Param("appType") Integer appType);
}