package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Chat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChatMapper {
    /**
     * dcdg_basic_chat_base 根据主键删除
     *
     * @mbg.generated Mon Apr 22 14:11:16 CST 2019
     */
    int deleteByPrimaryKey(String chatId);

    /**
     * dcdg_basic_chat_base  插入
     *
     * @mbg.generated Mon Apr 22 14:11:16 CST 2019
     */
    int insert(Chat record);

    /**
     * dcdg_basic_chat_base 根据主键查询
     *
     * @mbg.generated Mon Apr 22 14:11:16 CST 2019
     */
    Chat selectByPrimaryKey(String chatId);

    /**
     * dcdg_basic_chat_base 查找所有
     *
     * @mbg.generated Mon Apr 22 14:11:16 CST 2019
     */
    List<Chat> selectAll();

    /**
     * dcdg_basic_chat_base 根据主键修改
     *
     * @mbg.generated Mon Apr 22 14:11:16 CST 2019
     */
    int updateByPrimaryKey(Chat record);

    int updateChat(Chat record);

    /**
     * 查询新朋友列表
     *
     * @param custId
     * @return
     */
    List<Chat> selectNewFriends(String custId);

    /**
     * 查询朋友列表
     *
     * @param custId
     * @return
     */
    List<Chat> selectFriends(String custId);

    /**
     * 根据 custId friendId  chatStatus=3 查询聊天好友是否已经申请过好友
     *
     * @return
     */
    String queryChatIdChatByCustIdAndFriendIdAndChatStatus(@Param("custId") String custId, @Param("friendId") String friendId);

    /**
     * 修改聊天好友的状态 备注 更新时间
     * @param chat
     * @return
     */
    int updateStatusAndFrientRemarkAndUpdateForChat(Chat chat);
    /**
     * 查询聊天好友详情
     * @return
     */
    Chat datailFriend(@Param("friendId") String friendId, @Param("custId") String custId);

    /**
     * 删除聊天好友用户关系
     */
    int delChatCustId(@Param("chatId") String chatId, @Param("custId") String custId);
    /**
     * 删除聊天好友朋友关系
     */
    int delChatFriendId(@Param("custId") String custId, @Param("friendId") String friendId);

    /**
     * 查询好友关系
     * @param friendId
     * @param custId
     * @return
     */
    Chat queryChatStatus(@Param("custId") String custId, @Param("friendId") String friendId);

    /**
     * 查询好友关系是否存在
     * @param custId
     * @param friendId
     * @return
     */
    int existChatRelation(@Param("custId") String custId, @Param("friendId") String friendId);

    /**
     * 查询黑名单列表
     */
    List<Chat> chatBlacklists(@Param("custId") String custId);

    /**
     * 批量修改聊天好友的状态
     * @param list
     * @param custId
     * @param chatStatus
     * @return
     */
    int  updateChatStatus(@Param("list") List<String> list,@Param("custId") String custId, @Param("chatStatus") Byte chatStatus);
}