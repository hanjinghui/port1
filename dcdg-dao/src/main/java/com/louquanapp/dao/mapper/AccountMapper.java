package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Account;
import java.util.List;

public interface AccountMapper {
    /**
     * dcdg_customer_account_base 根据主键删除 
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    int deleteByPrimaryKey(String accountId);

    /**
     * dcdg_customer_account_base  插入 
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    int insert(Account record);

    /**
     * dcdg_customer_account_base 根据主键查询 
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    Account selectByPrimaryKey(String accountId);

    /**
     * dcdg_customer_account_base 查找所有 
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    List<Account> selectAll();

    /**
     * dcdg_customer_account_base 根据主键修改 
     *
     * @mbg.generated Fri Aug 30 17:07:05 CST 2019
     */
    int updateByPrimaryKey(Account record);
}