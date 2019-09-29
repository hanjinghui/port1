package com.louquanapp.biz;

import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.HhmConstants;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.dao.mapper.*;
import com.louquanapp.dao.model.Customer;
import com.louquanapp.dao.model.Shop;
import com.louquanapp.dao.model.SystemUser;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqLogin;
import com.louquanapp.req.ReqUpdateLonginPwd;
import com.louquanapp.service.JedisService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/7/12 17:39
 * @description:
 */
@Service
public class UserBiz {
    /**
     * 直播（餐饮类） id
     */
    public final static String CAN_YIN = "20190425123656yhi1X9by";
    private final JedisService jedisService;
    private final BrandMapper brandMapper;
    private final ShopMapper shopMapper;
    private final SystemUserMapper systemUserMapper;

    public UserBiz(JedisService jedisService, BrandMapper brandMapper, ShopMapper shopMapper, SystemUserMapper systemUserMapper) {
        this.jedisService = jedisService;
        this.brandMapper = brandMapper;
        this.shopMapper = shopMapper;
        this.systemUserMapper = systemUserMapper;
    }

    /**
     * 账号密码登录
     * @param login
     * @return
     */
    public JsonResult loginByNameAndPwd(ReqLogin login) {

        try {
            TypeJsonResult jsonResult=new TypeJsonResult();
            jsonResult.setStatusCode(false);
            //SystemUser
            SystemUser systemUser =systemUserMapper.queryUserByUserAcct(login.getUserAcct());
            if(null==systemUser){
                jsonResult.setMessage("登录账户错误！");
                return jsonResult;
            }

            SystemUser errLoginSystemUser=new SystemUser();
            errLoginSystemUser.setUserId(systemUser.getUserId());

            String userPwd = DigestUtils.md5Hex(login.getUserPwd());
            // 校验密码
            if (systemUser.getUserPwd().equals(userPwd)) {

                errLoginSystemUser.setErrCount((byte)0);
                systemUserMapper.updateErrLoginCount(errLoginSystemUser);
                String token= UUIDUtils.genertateUuid32();
                jedisService.refreshCustToken(systemUser.getUserId(),token);



                String jpushRegId=systemUser.getJpushRegId();
                Shop shop=shopMapper.selectShortByPrimaryKey(jpushRegId);

                systemUser.setAuditStatus(shop.getAuditStatus());
                systemUser.setShopStatus(shop.getShopStatus());
                systemUser.setShopName(shop.getShopName());
                systemUser.setShopLogo(shop.getShopLogo());
                systemUser.setShopId(shop.getShopId());
                systemUser.setToken(token);
                systemUser.setUserPwd(null);//隐藏密码

                jsonResult.setStatusCode(true);
                jsonResult.setType(systemUser);
            }else{

                Byte errCount=systemUser.getErrCount();
                errCount=errCount==null?0:errCount;

                Date currentDate = new Date();// 当前日期
                SimpleDateFormat sft = new SimpleDateFormat("yyyyMMdd");// 日期格式化

                if(errCount>= HhmConstants.MAX_LOGIN_ERR_COUNT){
                    if(sft.format(systemUser.getErrTime()).equals(sft.format(currentDate))){
                        jsonResult.setMessage("您的登录次数已经达到最大次数("+HhmConstants.MAX_LOGIN_ERR_COUNT+"）,请次日再试！");
                    }else{
                        jsonResult.setMessage("第一次登录密码错误！");
                        errLoginSystemUser.setErrCount((byte)(1));
                        systemUserMapper.updateErrLoginCount(errLoginSystemUser);
                    }
                }else{
                    jsonResult.setMessage("第"+(errCount+1)+"次登录密码错误！");
                    errLoginSystemUser.setErrCount((byte)(errCount+1));
                    systemUserMapper.updateErrLoginCount(errLoginSystemUser);
                }

            }
            return jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            } else {
                throw new HuhuaminException("账号密码登录异常" + e.getMessage(), e);
            }

        }
    }


    /**
     * 修改密码
     * @param newPwd
     * @param oldPwd
     * @param userId
     * @return
     */
    public JsonResult updateLoginPwd(String newPwd,String oldPwd, String userId) {

        try {
            JsonResult jsonResult = new JsonResult(false);

            if(newPwd.length()<6){
                jsonResult.setMessage("新密长度不能少于6个");
            }
            if(newPwd.length()>18){
                jsonResult.setMessage("新密长度不能大于18个");
            }
           String pwd= systemUserMapper.queryUserPwdByUserId(userId);
            String pwdMD5 = DigestUtils.md5Hex(oldPwd);

            if(pwd.equals(pwdMD5)){
                int count=systemUserMapper.updateUserPwd(userId,DigestUtils.md5Hex(newPwd));
                if(count==1){
                    jsonResult.setStatusCode(true);
                }else{
                    jsonResult.setMessage("修改密码失败！");
                }
            }else{
                jsonResult.setMessage("原始密码不正确！");
            }
            return jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            } else {
                throw new HuhuaminException("修改密码服务器开小差了");
            }

        }


    }


    /**
     * 根据token信息获取用户信息
     *
     * @return
     */
    public TypeJsonResult<SystemUser> getByToken(String token,String userId) {

        try {
            TypeJsonResult<SystemUser> typeJsonResult = new TypeJsonResult<>();
            typeJsonResult.setStatusCode(false);

           /* String userId = jedisService.getValueByKey(token);
            if (StringUtils.isEmpty(userId)) {
                typeJsonResult.setMessage("token过期，重新登录");
                typeJsonResult.setCode(301);
                return typeJsonResult;
            }*/
           SystemUser systemUser= systemUserMapper.selectByPrimaryKey(userId);
            String jpushRegId=systemUser.getJpushRegId();
            Shop shop=shopMapper.selectShortByPrimaryKey(jpushRegId);

            systemUser.setAuditStatus(shop.getAuditStatus());
            systemUser.setShopStatus(shop.getShopStatus());
            systemUser.setShopName(shop.getShopName());
            systemUser.setShopLogo(shop.getShopLogo());
            systemUser.setShopId(shop.getShopId());
            systemUser.setShopType(shop.getShopType());
            systemUser.setToken(token);
            systemUser.setUserPwd(null);//隐藏密码

            typeJsonResult.setType(systemUser);


            typeJsonResult.setStatusCode(true);
            return typeJsonResult;

        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("根据token的userInfo会员信息" + e.getMessage(), e);
            }

        }


    }

    /**
     * 退出
     * @param token
     * @return
     */
    public JsonResult doLoginOut(String token) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            jedisService.delByKey(jedisService.getValueByKey(token));
            jedisService.delByKey(token);
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            throw new HuhuaminException("退出异常", e);
        }
    }
}
