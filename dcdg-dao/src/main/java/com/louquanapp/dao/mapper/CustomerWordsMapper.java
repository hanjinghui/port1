package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.CustomerWords;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerWordsMapper {
    /**
     * dcdg_bussiness_customer_words 根据主键删除
     *
     * @mbg.generated Sat Mar 30 23:25:35 CST 2019
     */
    int deleteByPrimaryKey(String custWordsId);

    /**
     * dcdg_bussiness_customer_words  插入
     *
     * @mbg.generated Sat Mar 30 23:25:35 CST 2019
     */
    int insert(CustomerWords record);

    /**
     * dcdg_bussiness_customer_words 根据主键查询
     *
     * @mbg.generated Sat Mar 30 23:25:35 CST 2019
     */
    CustomerWords selectByPrimaryKey(String custWordsId);

    /**
     * dcdg_bussiness_customer_words 查找所有
     *
     * @mbg.generated Sat Mar 30 23:25:35 CST 2019
     */
    List<CustomerWords> selectAll();

    /**
     * dcdg_bussiness_customer_words 根据主键修改
     *
     * @mbg.generated Sat Mar 30 23:25:35 CST 2019
     */
    int updateByPrimaryKey(CustomerWords record);

    /**
     * 查询会员的热搜词
     *
     * @param custId
     * @return
     */
    List<String> selectByCustId(@Param("custId") String custId, @Param("deviceId") String deviceId);


    /**
     * 根据custId删除( 清空我的搜索词)
     */
    int deleteByCustId(@Param("custId") String custId, @Param("deviceId") String deviceId);
}