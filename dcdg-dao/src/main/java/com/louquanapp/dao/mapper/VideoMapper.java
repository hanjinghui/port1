package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoMapper {
    /**
     * dcdg_video_video_base 根据主键删除
     *
     * @mbg.generated Tue Apr 23 14:44:50 CST 2019
     */
    int deleteByPrimaryKey(String videoId);

    /**
     * dcdg_video_video_base  插入
     *
     * @mbg.generated Tue Apr 23 14:44:50 CST 2019
     */
    int insert(Video record);

    /**
     * dcdg_video_video_base 根据主键查询
     *
     * @mbg.generated Tue Apr 23 14:44:50 CST 2019
     */
    Video selectByPrimaryKey(String videoId);

    /**
     * dcdg_video_video_base 查找所有
     *
     * @mbg.generated Tue Apr 23 14:44:50 CST 2019
     */
    List<Video> selectAll();

    /**
     * dcdg_video_video_base 根据主键修改
     *
     * @mbg.generated Tue Apr 23 14:44:50 CST 2019
     */
    int updateByPrimaryKey(Video record);

    Integer selectMaxVideoNo();

    List<Video> videoByCustId(@Param("custId") String custId);

    int updateCountByPrimaryKey(@Param("onlineCount") int onlineCount, @Param("videoId") String videoId);

    /**
     * catId查询
     *
     * @param catId
     * @return
     */
    List<Video> videoValid(@Param("catId") String catId,@Param("keywords") String keywords,@Param("videoList") List<String> videoList);

    List<Video> videoValidCustIds(@Param("keywords") String keywords,@Param("custIds") List<String> sourceIds,@Param("videoLists") List<String> videoList);

    /**
     * 视频推荐推荐
     * @param videoType
     * @return
     */
    List<Video> videoValidRec(@Param("videoType") Byte videoType);

    String selectCustIdByVideoId(@Param("videoId") String sourceId);

    /**
     * 根据custId id  批量 修改状态为过期
     * @param custId
     * @param videoIds
     * @return
     */
    int updateStatusByIds(@Param("custId") String custId,@Param("list") List<String> videoIds);

    /**
     * 查询我的短视频作品列表
     * @param custId
     * @return
     */
    List<Video> videoWorks(@Param("custId") String custId);
    /**
     * 查询用户拉黑视频列表
     * @param custId
     * @return
     */
    List<Video> queryPullBackByCustId(@Param("custId") String custId);

    /**
     * 根据用户主键集合查询视频id集合
     * @param custIds
     * @return
     */
    List<String> queryVideoIdsByCustId(@Param("custIds") List<String> custIds);

    /**
     * 删除短视频
     * @param custId
     * @param videoIds
     * @return
     */
    int delVideo(@Param("custId") String custId,@Param("videoIds") List<String> videoIds);


    List<String> queryVideoUrlsByVideoIds(@Param("videoIds") List<String> videoIds);

}