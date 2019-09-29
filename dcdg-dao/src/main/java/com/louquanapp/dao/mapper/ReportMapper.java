package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Report;
import java.util.List;

public interface ReportMapper {
    /**
     * dcdg_video_report_base 根据主键删除 
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    int deleteByPrimaryKey(String reportId);

    /**
     * dcdg_video_report_base  插入 
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    int insert(Report record);

    /**
     * dcdg_video_report_base 根据主键查询 
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    Report selectByPrimaryKey(String reportId);

    /**
     * dcdg_video_report_base 查找所有 
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    List<Report> selectAll();

    /**
     * dcdg_video_report_base 根据主键修改 
     *
     * @mbg.generated Mon May 06 19:25:09 CST 2019
     */
    int updateByPrimaryKey(Report record);
}