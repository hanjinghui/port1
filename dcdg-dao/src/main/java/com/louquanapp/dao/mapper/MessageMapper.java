package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Message;

import java.util.List;

public interface MessageMapper {
    /**
     * dcdg_basic_message_base 根据主键删除
     *
     * @mbg.generated Thu Apr 11 10:55:56 CST 2019
     */
    int deleteByPrimaryKey(String messageId);

    /**
     * dcdg_basic_message_base  插入
     *
     * @mbg.generated Thu Apr 11 10:55:56 CST 2019
     */
    int insert(Message record);

    /**
     * dcdg_basic_message_base 根据主键查询
     *
     * @mbg.generated Thu Apr 11 10:55:56 CST 2019
     */
    Message selectByPrimaryKey(String messageId);

    /**
     * dcdg_basic_message_base 查找所有
     *
     * @mbg.generated Thu Apr 11 10:55:56 CST 2019
     */
    List<Message> selectAll();

    /**
     * dcdg_basic_message_base 根据主键修改
     *
     * @mbg.generated Thu Apr 11 10:55:56 CST 2019
     */
    int updateByPrimaryKey(Message record);

    /**
     *查询通知信息
     */
    List<Message> messages();
    /**
     * 查询通知信息--分页
     */
    List<Message> messagesPage();

    /**
     * 添加消息
     * @param message
     * @return
     */
    int insertSelective(Message message);
}