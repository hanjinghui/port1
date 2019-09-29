package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.ReportCat;
import java.util.List;

public interface ReportCatMapper {
    /**
     * dcdg_video_reportcat_base 根据主键删除 
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    int deleteByPrimaryKey(String catId);

    /**
     * dcdg_video_reportcat_base  插入 
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    int insert(ReportCat record);

    /**
     * dcdg_video_reportcat_base 根据主键查询 
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    ReportCat selectByPrimaryKey(String catId);

    /**
     * dcdg_video_reportcat_base 查找所有 
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    List<ReportCat> selectAll();

    /**
     * dcdg_video_reportcat_base 根据主键修改 
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    int updateByPrimaryKey(ReportCat record);
}