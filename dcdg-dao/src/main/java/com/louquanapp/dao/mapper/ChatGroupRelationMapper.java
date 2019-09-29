package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.ChatGroupRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChatGroupRelationMapper {
    /**
     * base_chat_group_relation 根据主键删除 
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    int deleteByPrimaryKey(String relationId);

    /**
     * base_chat_group_relation  插入 
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    int insert(ChatGroupRelation record);

    /**
     * base_chat_group_relation 根据主键查询 
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    ChatGroupRelation selectByPrimaryKey(String relationId);

    /**
     * base_chat_group_relation 查找所有 
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    List<ChatGroupRelation> selectAll();

    /**
     * base_chat_group_relation 根据主键修改 
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    int updateByPrimaryKey(ChatGroupRelation record);

    /**
     * 根据群ID查询聊天好友群关系
     * @param groupId
     * @return
     */
    List<ChatGroupRelation> queryChatGroupRelationByGroupId(@Param("groupId") String groupId);

    /**
     * 根据群ID查询用户id 用户在群里的昵称  状态
     * @param groupId
     * @return
     */
    List<ChatGroupRelation> queryCustIdAndNickNameAndStatusByGroupId(@Param("groupId") String groupId);

    /**
     * 根据custId groupId查询用户id 用户在群里的昵称  状态
     * @param custId
     * @return
     */
    ChatGroupRelation queryCustIdAndNickNameAndStatusByCustId(@Param("custId") String custId, @Param("groupId") String groupId);

    int updateSelectByPrimaryKey(ChatGroupRelation record);

    /**
     * 聊天群多用户添加
     * @param list
     * @return
     */
    int insertList(@Param("list") List<ChatGroupRelation> list);

    /**
     * 聊天群选择联系人列表
     * @param groupId
     * @return
     */
    List<ChatGroupRelation> chatGroupMembers(@Param("groupId") String groupId, @Param("custId") String custId);

    /**
     * 检查聊天群选择联系人的数量
     * @param groupId
     * @param custId
     * @param list
     * @return
     */
    int checkChatGroupMembersNum(@Param("groupId") String groupId, @Param("custId") String custId
            , @Param("list") List<String> list);

    /**
     * 删除用户在聊天群关系中的关系
     */
    int delChatGroupRelationByCustIdAndGroupId(@Param("groupId") String groupId, @Param("custId") String custId);

    /**
     * 删除群成员与群的关系
     */
    int delChatGroupRelationByGroupId(@Param("groupId") String groupId);

    /**
     * 据groupId 查询群员信息
     * @param groupId
     * @return
     */
    List<ChatGroupRelation> queryChatGroupMembersByGroupId(@Param("groupId") String groupId);
}