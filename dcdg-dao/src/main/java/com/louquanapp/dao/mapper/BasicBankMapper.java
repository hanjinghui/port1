package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.BasicBank;
import java.util.List;

public interface BasicBankMapper {
    /**
     * dcdg_basic_bank_base 根据主键删除 
     *
     * @mbg.generated Fri Aug 30 14:54:06 CST 2019
     */
    int deleteByPrimaryKey(String bankId);

    /**
     * dcdg_basic_bank_base  插入 
     *
     * @mbg.generated Fri Aug 30 14:54:06 CST 2019
     */
    int insert(BasicBank record);

    /**
     * dcdg_basic_bank_base 根据主键查询 
     *
     * @mbg.generated Fri Aug 30 14:54:06 CST 2019
     */
    BasicBank selectByPrimaryKey(String bankId);

    /**
     * dcdg_basic_bank_base 查找所有 
     *
     * @mbg.generated Fri Aug 30 14:54:06 CST 2019
     */
    List<BasicBank> selectAll();

    /**
     * dcdg_basic_bank_base 根据主键修改 
     *
     * @mbg.generated Fri Aug 30 14:54:06 CST 2019
     */
    int updateByPrimaryKey(BasicBank record);
}