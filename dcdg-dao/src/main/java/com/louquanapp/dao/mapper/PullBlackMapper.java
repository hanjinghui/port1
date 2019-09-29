package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.PullBlack;
import com.louquanapp.dao.model.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PullBlackMapper {
    /**
     * dcdg_video_pull_black 根据主键删除 
     *
     * @mbg.generated Mon Jun 10 14:21:09 CST 2019
     */
    int deleteByPrimaryKey(String backId);

    /**
     * dcdg_video_pull_black  插入 
     *
     * @mbg.generated Mon Jun 10 14:21:09 CST 2019
     */
    int insert(PullBlack record);

    /**
     * dcdg_video_pull_black 根据主键查询 
     *
     * @mbg.generated Mon Jun 10 14:21:09 CST 2019
     */
    PullBlack selectByPrimaryKey(String backId);

    /**
     * dcdg_video_pull_black 查找所有 
     *
     * @mbg.generated Mon Jun 10 14:21:09 CST 2019
     */
    List<PullBlack> selectAll();

    /**
     * dcdg_video_pull_black 根据主键修改 
     *
     * @mbg.generated Mon Jun 10 14:21:09 CST 2019
     */
    int updateByPrimaryKey(PullBlack record);

    /**
     * 根据用户主键查询视频主键
     * @param custId
     * @return
     */
    List<String> selectBackByCustId(@Param("custId") String custId);
    /**
     * 根据用户主键批量查询视频主键
     * @param custIds
     * @return
     */
    List<String> selectBackByCustIds(@Param("custIds") List<String> custIds);

    /**
     * 批量添加
     * @param pullBlacks
     * @return
     */
    int insertByBatch(@Param("pullBlacks") List<PullBlack> pullBlacks);

    /**
     * 批量删除
     * @param custId
     * @param videoIds
     * @return
     */
    int deleteByBatch(@Param("custId") String custId,@Param("videoIds") List<String> videoIds);




}