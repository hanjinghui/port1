package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.UserRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRelationMapper {
    /**
     * andji_system_user_relation 根据主键删除 
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    int deleteByPrimaryKey(String relationId);

    /**
     * andji_system_user_relation  插入 
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    int insert(UserRelation record);

    /**
     * andji_system_user_relation 根据主键查询 
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    UserRelation selectByPrimaryKey(String relationId);

    /**
     * andji_system_user_relation 查找所有 
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    List<UserRelation> selectAll();

    /**
     * andji_system_user_relation 根据主键修改 
     *
     * @mbg.generated Tue Sep 24 17:31:23 CST 2019
     */
    int updateByPrimaryKey(UserRelation record);

    List<UserRelation> queryUserRelation(@Param("userId") String userId);


    List<UserRelation> queryUserRelationUp(@Param("userId") String userId);
}