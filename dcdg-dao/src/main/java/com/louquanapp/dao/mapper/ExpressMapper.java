package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Express;
import java.util.List;

public interface ExpressMapper {
    /**
     * dcdg_basic_express_base 根据主键删除 
     *
     * @mbg.generated Fri Aug 09 15:01:59 CST 2019
     */
    int deleteByPrimaryKey(String expressId);

    /**
     * dcdg_basic_express_base  插入 
     *
     * @mbg.generated Fri Aug 09 15:01:59 CST 2019
     */
    int insert(Express record);

    /**
     * dcdg_basic_express_base 根据主键查询 
     *
     * @mbg.generated Fri Aug 09 15:01:59 CST 2019
     */
    Express selectByPrimaryKey(String expressId);

    /**
     * dcdg_basic_express_base 查找所有 
     *
     * @mbg.generated Fri Aug 09 15:01:59 CST 2019
     */
    List<Express> selectAll();

    /**
     * dcdg_basic_express_base 根据主键修改 
     *
     * @mbg.generated Fri Aug 09 15:01:59 CST 2019
     */
    int updateByPrimaryKey(Express record);

    /**
     * 查询所用启动状态的快递公司名称和id
     * @return
     */
    List<Express> queryExpressCodeAndExpressName();
}