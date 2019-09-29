package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Feedback;

import java.util.List;

public interface FeedbackMapper {
    /**
     * bpbasic_feedback_base 根据主键删除
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    int deleteByPrimaryKey(String feedbackId);

    /**
     * bpbasic_feedback_base  插入
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    int insert(Feedback record);

    /**
     * bpbasic_feedback_base 根据主键查询
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    Feedback selectByPrimaryKey(String feedbackId);

    /**
     * bpbasic_feedback_base 查找所有
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    List<Feedback> selectAll();

    /**
     * bpbasic_feedback_base 根据主键修改
     *
     * @mbg.generated Thu Apr 11 07:58:44 CST 2019
     */
    int updateByPrimaryKey(Feedback record);
}