package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.SystemParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemParamMapper {
    /**
     * andji_system_param_base 根据主键删除
     *
     * @mbg.generated Tue Apr 16 13:14:50 CST 2019
     */
    int deleteByPrimaryKey(String paramId);

    /**
     * andji_system_param_base  插入
     *
     * @mbg.generated Tue Apr 16 13:14:50 CST 2019
     */
    int insert(SystemParam record);

    /**
     * andji_system_param_base 根据主键查询
     *
     * @mbg.generated Tue Apr 16 13:14:50 CST 2019
     */
    SystemParam selectByPrimaryKey(String paramId);

    /**
     * andji_system_param_base 查找所有
     *
     * @mbg.generated Tue Apr 16 13:14:50 CST 2019
     */
    List<SystemParam> selectAll();

    /**
     * andji_system_param_base 根据主键修改
     *
     * @mbg.generated Tue Apr 16 13:14:50 CST 2019
     */
    int updateByPrimaryKey(SystemParam record);

    /**
     * 根据索引查询
     *
     * @param index
     * @return
     */
    SystemParam selectByIndex(@Param("paramIndex") String index);
}