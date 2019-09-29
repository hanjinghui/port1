package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Attention;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttentionMapper {
    /**
     * dcdg_customer_attention_base 根据主键删除
     *
     * @mbg.generated Sun Apr 28 09:20:34 CST 2019
     */
    int deleteByPrimaryKey(String attentionId);

    /**
     * dcdg_customer_attention_base  插入
     *
     * @mbg.generated Sun Apr 28 09:20:34 CST 2019
     */
    int insert(Attention record);

    /**
     * dcdg_customer_attention_base 根据主键查询
     *
     * @mbg.generated Sun Apr 28 09:20:34 CST 2019
     */
    Attention selectByPrimaryKey(String attentionId);

    /**
     * dcdg_customer_attention_base 查找所有
     *
     * @mbg.generated Sun Apr 28 09:20:34 CST 2019
     */
    List<Attention> selectAll();

    /**
     * dcdg_customer_attention_base 根据主键修改
     *
     * @mbg.generated Sun Apr 28 09:20:34 CST 2019
     */
    int updateByPrimaryKey(Attention record);

    int countByVideoId(@Param("sourceId") String sourceId, @Param("attentionType") Integer attentionType);

    int existAttentionByCustIdAndAttentionType(@Param("custId") String custId, @Param("sourceId") String sourceId, @Param("attentionType") Integer attentionType);

    /**
     * @param custId
     * @param sourceId
     * @param attentionType 关注类型[1-点赞视频 2-点赞直播 3-商品 4-关注对象会员 5-进入直播间 6-进入有效]
     * @return
     */
    String selectAttentionIdAttentionByCustIdAndAttentionType(@Param("custId") String custId, @Param("sourceId") String sourceId, @Param("attentionType") Integer attentionType);

    List<String> selectSourceIdByCustIdAndAttentionType(@Param("custId") String custId, @Param("attentionType") Integer attentionType);
}