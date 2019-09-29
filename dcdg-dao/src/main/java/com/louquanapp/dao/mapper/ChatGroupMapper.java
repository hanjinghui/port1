package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.ChatGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChatGroupMapper {
    /**
     * base_chat_group_base 根据主键删除 
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    int deleteByPrimaryKey(String groupId);

    /**
     * base_chat_group_base  插入 
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    int insert(ChatGroup record);

    /**
     * base_chat_group_base 根据主键查询 
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    ChatGroup selectByPrimaryKey(String groupId);

    /**
     * base_chat_group_base 查找所有 
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    List<ChatGroup> selectAll();

    /**
     * base_chat_group_base 根据主键修改 
     *
     * @mbg.generated Tue Apr 23 17:06:55 CST 2019
     */
    int updateByPrimaryKey(ChatGroup record);

    /**
     * 聊天好友群名称是否重复
     * @param groupName
     * @param groupMasterId
     * @return
     */
    int existDuplicationName(@Param("groupName") String groupName, @Param("groupMasterId") String groupMasterId);

    /**
     * 查询群名称列表
     * @param custId
     * @return
     */
    List<ChatGroup> queryChatGroupNameBCustId(@Param("custId") String custId);

    /**
     * 根据groupId查询groupName
     * @param groupId
     * @return
     */
    String chatGroupNameByGroupId(@Param("groupId") String groupId);

    /**
     * 群主解散群
     * @param groupId
     * @param groupMasterId
     * @return
     */
    int dismissChatGroup(@Param("groupId") String groupId, @Param("groupMasterId") String groupMasterId);
    /**是否是群主
     *
     */
    int existGroupMaterId(@Param("groupId") String groupId, @Param("groupMasterId") String groupMasterId);

    /**
     * 根据群主id查询群头像 群名称 群公告
     * @param chatGroup
     * @return
     */
    int updateChatGroupByMasterIdAndGroupId(ChatGroup chatGroup);

    /**
     * 查询群Id集合
     * @param custId
     * @return
     */
    List<String> queryChatGroupByCustId(@Param("custId") String custId);

}