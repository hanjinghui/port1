package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.ShopApply;

import java.util.List;

public interface ShopApplyMapper {
    /**
     * dcdg_bussiness_shopapply_base 根据主键删除
     *
     * @mbg.generated Wed Mar 27 17:40:01 CST 2019
     */
    int deleteByPrimaryKey(String applyId);

    /**
     * dcdg_bussiness_shopapply_base  插入
     *
     * @mbg.generated Wed Mar 27 17:40:01 CST 2019
     */
    int insert(ShopApply record);

    /**
     * dcdg_bussiness_shopapply_base 根据主键查询
     *
     * @mbg.generated Wed Mar 27 17:40:01 CST 2019
     */
    ShopApply selectByPrimaryKey(String applyId);

    /**
     * dcdg_bussiness_shopapply_base 查找所有
     *
     * @mbg.generated Wed Mar 27 17:40:01 CST 2019
     */
    List<ShopApply> selectAll();

    /**
     * dcdg_bussiness_shopapply_base 根据主键修改
     *
     * @mbg.generated Wed Mar 27 17:40:01 CST 2019
     */
    int updateByPrimaryKey(ShopApply record);

    Integer selectFlagByCustId(String custId);

    String selectIdByCustId(String custId);

    ShopApply selectAllByCustId(String custId);
    int updateSelectByPrimaryKey(ShopApply record);
}