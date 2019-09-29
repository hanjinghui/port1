package com.louquanapp.dao.mapper;

import com.louquanapp.dao.config.MapF2F;
import com.louquanapp.dao.model.SpecificationOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SpecificationOptionMapper {
    /**
     * dcdg_goods_specification_option 根据主键删除
     *
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    int deleteByPrimaryKey(String optId);

    /**
     * dcdg_goods_specification_option  插入
     *
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    int insert(SpecificationOption record);

    /**
     * dcdg_goods_specification_option 根据主键查询
     *
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    SpecificationOption selectByPrimaryKey(String optId);

    /**
     * dcdg_goods_specification_option 查找所有
     *
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    List<SpecificationOption> selectAll();

    /**
     * dcdg_goods_specification_option 根据主键修改
     *
     * @mbg.generated Wed Apr 03 08:28:03 CST 2019
     */
    int updateByPrimaryKey(SpecificationOption record);

    String getSpecOptNameByOptId(String id);

    @MapF2F
    Map<String, String> mapSpecOptNameByOptIds(List<String> ids);

    List<SpecificationOption> selectSpecByCatId(@Param("catId") String catId);

    SpecificationOption getBySpecId(@Param("specId") String specId);

    List<SpecificationOption> listAllByOptNameAndOptId(@Param("optName") String optName,@Param("optId") String optId);

    List<SpecificationOption> listAll(@Param("optIds") List<String> optIds);
}