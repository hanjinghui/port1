package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerMapper {
    /**
     * dcdg_basic_banner_base 根据主键删除
     *
     * @mbg.generated Mon Apr 01 23:47:28 CST 2019
     */
    int deleteByPrimaryKey(String bannerId);

    /**
     * dcdg_basic_banner_base  插入
     *
     * @mbg.generated Mon Apr 01 23:47:28 CST 2019
     */
    int insert(Banner record);

    /**
     * dcdg_basic_banner_base 根据主键查询
     *
     * @mbg.generated Mon Apr 01 23:47:28 CST 2019
     */
    Banner selectByPrimaryKey(String bannerId);

    /**
     * dcdg_basic_banner_base 查找所有
     *
     * @mbg.generated Mon Apr 01 23:47:28 CST 2019
     */
    List<Banner> selectAll();

    /**
     * dcdg_basic_banner_base 根据主键修改
     *
     * @mbg.generated Mon Apr 01 23:47:28 CST 2019
     */
    int updateByPrimaryKey(Banner record);

    /**
     * 前5个有效的banner
     *
     * @return
     */
    List<Banner> selectAll5(@Param("bannerPage") Integer bannerPage);

    /**
     * 更新点击次数
     *
     * @param bannerId
     * @return
     */
    int updateClickCountByPrimaryKey(String bannerId);

    /**
     * 首页注册好友送余额或积分
     * @return
     */
    Banner queryPointOrCastBanner();

}