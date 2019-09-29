package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.VideoPlaninfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoPlaninfoMapper {
    /**
     * dcdg_video_planinfo_base 根据主键删除 
     *
     * @mbg.generated Wed Apr 10 19:28:01 CST 2019
     */
    int deleteByPrimaryKey(String planId);

    /**
     * dcdg_video_planinfo_base  插入 
     *
     * @mbg.generated Wed Apr 10 19:28:01 CST 2019
     */
    int insert(VideoPlaninfo record);

    /**
     * dcdg_video_planinfo_base 根据主键查询 
     *
     * @mbg.generated Wed Apr 10 19:28:01 CST 2019
     */
    VideoPlaninfo selectByPrimaryKey(String planId);

    /**
     * dcdg_video_planinfo_base 查找所有 
     *
     * @mbg.generated Wed Apr 10 19:28:01 CST 2019
     */
    List<VideoPlaninfo> selectAll();

    /**
     * dcdg_video_planinfo_base 根据主键修改 
     *
     * @mbg.generated Wed Apr 10 19:28:01 CST 2019
     */
    int updateByPrimaryKey(VideoPlaninfo record);

    /**
     * 查询直播间预定信息列表
     * @param planStatus
     * @return
     */
    List<VideoPlaninfo> videoPlaninfoList(@Param("planStatus") Byte planStatus,@Param("shopId") String shopId);

    /**
     * 根据planId custId 删除直播间预定信息
     * @param planId
     * @param shopId
     * @return
     */
    int deleteVideoPlaninfoByPlanIdAndcCustId(@Param("planId") String planId,@Param("shopId") String shopId);


    int planinfoUpdateStatus(@Param("planId") String planId,@Param("shopId") String shopId
            ,@Param("planStatus") Byte planStatus, @Param("reply") String reply);

    Byte queryPlaninfoStatus(@Param("planId") String planId,@Param("shopId") String shopId
            ,@Param("planStatus") Byte planStatus);

    VideoPlaninfo queryPlaninfoByPlanId(@Param("planId") String planId,@Param("shopId") String shopId );


    /**
     * 根据条件修改直播间预定信息
     * @param videoPlaninfo
     * @return
     */
    int updateVideoPlaninfo(VideoPlaninfo videoPlaninfo);

    VideoPlaninfo queryPlaninfoByOrderId(@Param("orderId") String orderId,@Param("shopId") String shopId);
    VideoPlaninfo videoPlaninfoDetail(@Param("planId") String planId,@Param("shopId") String shopId);

    int updateOverByOrderId(@Param("orderId") String orderId,@Param("shopId") String shopId);
}