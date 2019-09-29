package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.VideoEvaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoEvaluateMapper {
    /**
     * dcdg_video_evaluate_base 根据主键删除 
     *
     * @mbg.generated Wed Jul 03 09:31:58 CST 2019
     */
    int deleteByPrimaryKey(String evaluateId);

    /**
     * dcdg_video_evaluate_base  插入 
     *
     * @mbg.generated Wed Jul 03 09:31:58 CST 2019
     */
    int insert(VideoEvaluate record);

    /**
     * dcdg_video_evaluate_base 根据主键查询 
     *
     * @mbg.generated Wed Jul 03 09:31:58 CST 2019
     */
    VideoEvaluate selectByPrimaryKey(String evaluateId);

    /**
     * dcdg_video_evaluate_base 查找所有 
     *
     * @mbg.generated Wed Jul 03 09:31:58 CST 2019
     */
    List<VideoEvaluate> selectAll();

    /**
     * dcdg_video_evaluate_base 根据主键修改 
     *
     * @mbg.generated Wed Jul 03 09:31:58 CST 2019
     */
    int updateByPrimaryKey(VideoEvaluate record);

    /**
     * 查询视频评论
     * @param type
     * @param evaluateId
     * @param videoId
     * @return
     */
    List<VideoEvaluate> videoEvaluates(@Param("type") Byte type,@Param("evaluateId") String evaluateId,@Param("videoId") String videoId);
    /**
     * 查询视频评论数量
     * @param type
     * @param evaluateId
     * @param videoId
     * @return
     */
    int videoEvaluateCount (@Param("type") Byte type,@Param("evaluateId") String evaluateId,@Param("videoId") String videoId);
}