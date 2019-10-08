package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.SystemUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemUserMapper {
    /**
     * andji_system_user_base 根据主键删除 
     *
     * @mbg.generated Wed Jun 12 17:58:12 CST 2019
     */
    int deleteByPrimaryKey(String userId);

    /**
     * andji_system_user_base  插入 
     *
     * @mbg.generated Wed Jun 12 17:58:12 CST 2019
     */
    int insert(SystemUser record);

    /**
     * andji_system_user_base 根据主键查询 
     *
     * @mbg.generated Wed Jun 12 17:58:12 CST 2019
     */
    SystemUser selectByPrimaryKey(String userId);

    /**
     * andji_system_user_base 查找所有 
     *
     * @mbg.generated Wed Jun 12 17:58:12 CST 2019
     */
    List<SystemUser> selectAll();

    /**
     * andji_system_user_base 根据主键修改 
     *
     * @mbg.generated Wed Jun 12 17:58:12 CST 2019
     */
    int updateByPrimaryKey(SystemUser record);

    /**
     * 根据用户登录账户查询用户信息
     * @param userAcct
     * @return
     */
    SystemUser queryUserByUserAcct(@Param("userAcct")String userAcct);

    /**
     * 更新错误登录信息
     * @param systemUser
     * @return
     */
    int updateErrLoginCount(SystemUser systemUser);

    /**
     * 根据商户id查询对应的前台id
     * @param userId
     * @return
     */
    String queryCustIdByUserId(@Param("userId")String userId);

    /**
     * 根据商户id查询商铺id
     * @param userId
     * @return
     */
    String queryShopIdByUserId(@Param("userId")String userId);


    String queryUserPwdByUserId(@Param("userId")String userId);

    int updateUserPwd(@Param("userId")String userId,@Param("userPwd")String userPwd);

    String queryUserNameByUserId(@Param("userId")String userId);

    com.louquanapp.dao.model.SystemUser queryTotalMoney(@Param("userId")String userId);

    /**
     * 根据商户id查询对应的前台id集合
     * @param userIds
     * @return
     */
    List<String> queryCustIdsByUserIds(@Param("userIds") List<String> userIds);

    /**
     * 根据商户id查询商铺id集合
     * @param userIds
     * @return
     */
    List<String> queryShopIdsByUserIds(@Param("userIds")List<String> userIds);

    String queryRelationLevelByUserId(@Param("userId")String userId);

    int existUserAcct(@Param("userAcct")String userAcct);
    int updateSystemUser(SystemUser record);

    SystemUser queryUserAcctAndShopNameByShopId(@Param("shopId")String shopId);

    String queryUserIdByShopId(@Param("shopId")String shopId);
}