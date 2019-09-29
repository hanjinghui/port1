package com.louquanapp.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.HhmConstants;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.Arith;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.dao.mapper.*;
import com.louquanapp.dao.model.*;
import com.louquanapp.model.PageJsonResult;
import com.louquanapp.model.ReqForPageInfo;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.*;
import com.louquanapp.resp.RespOrder;
import com.louquanapp.resp.RespOrderInformation;
import com.louquanapp.resp.RespRebateCurrentMonth;
import com.louquanapp.service.JedisService;
import com.louquanapp.utils.RelativeDateFormatUtils;
import com.louquanapp.utils.SessionUtils;
import jodd.util.StringUtil;
import net.sf.json.JSONObject;
import org.apache.commons.codec.Decoder;
import org.apache.commons.codec.Encoder;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @Author 胡化敏
 * @Description: 会员业务逻辑处理
 * @Date Create  2019年03月26日15:19:27
 * @Modified By:
 * @Since:
 */
@Service
public class CustomerBiz {
    /**
     * 直播（餐饮类） id
     */
    public final static String CAN_YIN = "20190425123656yhi1X9by";

    private final CustomerMapper customerMapper;
    private final JedisService jedisService;
    private final ThirdLoginBiz thirdLoginBiz;
    private final ShopApplyMapper shopApplyMapper;
    private final CustomerLogMapper customerLogMapper;
    private final BrandMapper brandMapper;
    private final ShopMapper shopMapper;
    private final SystemUserMapper systemUserMapper;
    private final CustomerPointMapper customerPointMapper;
    private final GameMapper gameMapper;
    private final OrderItemMapper orderItemMapper;
    private final GoodsMapper goodsMapper;
    private final OrderMapper orderMapper;
    private final  RegisterBiz registerBiz;
    private final GoodsImagesMapper goodsImagesMapper;
    private final UserRebateMapper userRebateMapper;
    private final SettlementInfoMapper settlementInfoMapper;
    private final UserMoneyMapper userMoneyMapper;
    private final MoneySettlementMapper moneySettlementMapper;
    private final SystemParamMapper systemParamMapper;
    private final UserRelationMapper userRelationMapper;




    @Value("${message_effective_time}")
    private int message_effective_time;
    @Value("${off_line}")
    private boolean off_line;

    public CustomerBiz(CustomerMapper customerMapper, JedisService jedisService, ThirdLoginBiz thirdLoginBiz
            , ShopApplyMapper shopApplyMapper, CustomerLogMapper customerLogMapper, BrandMapper brandMapper
            , ShopMapper shopMapper, SystemUserMapper systemUserMapper, CustomerPointMapper customerPointMapper
            , GameMapper gameMapper, OrderItemMapper orderItemMapper, GoodsMapper goodsMapper, RegisterBiz registerBiz
            ,OrderMapper orderMapper,GoodsImagesMapper goodsImagesMapper,UserRebateMapper userRebateMapper
            ,SettlementInfoMapper settlementInfoMapper,UserMoneyMapper userMoneyMapper,MoneySettlementMapper moneySettlementMapper
            ,SystemParamMapper systemParamMapper,UserRelationMapper userRelationMapper) {
        this.customerMapper = customerMapper;
        this.jedisService = jedisService;
        this.thirdLoginBiz = thirdLoginBiz;
        this.shopApplyMapper = shopApplyMapper;
        this.customerLogMapper = customerLogMapper;
        this.brandMapper = brandMapper;
        this.shopMapper = shopMapper;
        this.systemUserMapper = systemUserMapper;
        this.customerPointMapper = customerPointMapper;
        this.gameMapper = gameMapper;
        this.orderItemMapper = orderItemMapper;
        this.goodsMapper = goodsMapper;
        this.registerBiz = registerBiz;
        this.orderMapper = orderMapper;
        this.goodsImagesMapper = goodsImagesMapper;
        this.userRebateMapper = userRebateMapper;
        this.settlementInfoMapper = settlementInfoMapper;
        this.userMoneyMapper = userMoneyMapper;
        this.moneySettlementMapper = moneySettlementMapper;
        this.systemParamMapper = systemParamMapper;
        this.userRelationMapper = userRelationMapper;
    }

    /**
     * 微信登录
     *
     * @param openId
     * @param force
     * @param pushId
     * @return
     */
    public TypeJsonResult<Customer> getByWxUserInfo(String openId, Integer force, String pushId) {

        try {
            TypeJsonResult<Customer> typeJsonResult = new TypeJsonResult<>();
            typeJsonResult.setStatusCode(false);
            Customer customer = customerMapper.getByWechatId(openId);
            if (null == customer) {
                typeJsonResult.setStatusCode(false);
                typeJsonResult.setCode(300);
                typeJsonResult.setMessage("第三方登录，需要去绑定页面");
                return typeJsonResult;
            }


            if (null != customer) {
                if (freezeStatusCheck(typeJsonResult, customer)) return typeJsonResult;
                refreshToken(pushId, customer);
            }
            typeJsonResult.setType(customer);
            this.logLogin(customer.getCustId(), 1, 2);
            typeJsonResult.setStatusCode(true);
            return typeJsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("根据微信返回的userInfo会员信息" + e.getMessage(), e);
            }
        }
    }

    /**
     * 第一次登录时操作
     * @param custId

    @Transactional
    private void doLoginFirstTime(String custId){
        Date date=customerMapper.queryLoginFirstTime(custId);
        if(date==null){
           int count= customerMapper.addLoginFirstTime(custId, new Date());
           if(count==1){
               Banner banner= brandMapper.queryPointOrCast();
               if(banner !=null){
                   //目标是12时有用-积分或现金余额类型[1-积分 2-现金余额]
                   Byte pointOrCastType=banner.getPointOrCastType();
                   if(pointOrCastType ==1){

                   }else if(pointOrCastType ==2){
                       if(customerMapper.addConsumePoint(custId,Double.valueOf(banner.getPointOrCast()))!=1){
                           throw new HuhuaminException("根据qq返回的userInfo会员信息" + e.getMessage(), e);
                       }

                   }


               }



           }
        }
    }
     */
    /**
     * 判断和刷新token
     *
     * @param pushId
     * @param customer
     * @return
     */
    private void refreshToken(String pushId, Customer customer) {
        customer.setToken(UUIDUtils.genertateUuid32());
        updatePushId(pushId, customer);
        jedisService.refreshCustToken(customer.getCustId(), customer.getToken());
    }

    /**
     * 权限已被冻结
     *
     * @param typeJsonResult
     * @param customer
     * @return
     */
    private boolean freezeStatusCheck(TypeJsonResult<Customer> typeJsonResult, Customer customer) {
        if (customer.getFreezeStatus().intValue() == 3) {
            // 未查询到账号
            typeJsonResult.setStatusCode(false);
            typeJsonResult.setCode(304);
            typeJsonResult.setMessage("无使用权限，注:您的使用权限已被冻结，请联系客服");
            return true;
        }
        return false;
    }

    /**
     * qq 登录
     *
     * @param openId
     * @param pushId
     * @return
     */
    public TypeJsonResult<Customer> getByQqUserInfo(String openId, String pushId) {

        try {
            TypeJsonResult<Customer> typeJsonResult = new TypeJsonResult<>();
            typeJsonResult.setStatusCode(false);
            Customer customer = customerMapper.getByQqId(openId);
            if (null == customer) {
                typeJsonResult.setStatusCode(false);
                typeJsonResult.setCode(300);
                typeJsonResult.setMessage("第三方登录，需要去绑定页面");
                return typeJsonResult;
            }
            if (null != customer) {
                if (freezeStatusCheck(typeJsonResult, customer)) return typeJsonResult;
                refreshToken(pushId, customer);
            }
            typeJsonResult.setType(customer);
            this.logLogin(customer.getCustId(), 1, 2);
            typeJsonResult.setStatusCode(true);
            return typeJsonResult;

        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("根据qq返回的userInfo会员信息" + e.getMessage(), e);
            }

        }


    }


    /**
     * 更新 push id（极光）
     *
     * @param pushId
     * @param customer
     */
    private void updatePushId(String pushId, Customer customer) {
        if (StringUtils.isNotBlank(pushId)) {
            Customer param = new Customer();
            param.setCustId(customer.getCustId());
            param.setPushId(pushId);
            customerMapper.updateByPrimaryKeySelective(param);

        }
    }


    /**
     * 账号密码登录
     *
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
                throw new HuhuaminExceptionPlan("登录账户错误！");
            }

            SystemUser errLoginSystemUser=new SystemUser();
            errLoginSystemUser.setUserId(systemUser.getUserId());

            String userPwd = DigestUtils.md5Hex(login.getUserPwd());
            // 校验密码
            if (systemUser.getUserPwd().equals(userPwd)) {

                errLoginSystemUser.setErrCount((byte)0);
                systemUserMapper.updateErrLoginCount(errLoginSystemUser);
                String token=UUIDUtils.genertateUuid32();
                jedisService.refreshCustToken(systemUser.getUserId(),token);

                jsonResult.setStatusCode(true);
                jsonResult.setType(token);
            }else{

                Byte errCount=systemUser.getErrCount();

                Date currentDate = new Date();// 当前日期
                SimpleDateFormat sft = new SimpleDateFormat("yyyyMMdd");// 日期格式化

                if(errCount> HhmConstants.MAX_LOGIN_ERR_COUNT){
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
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("账号密码登录异常" + e.getMessage(), e);
            }

        }
    }


    /**
     * 账号密码登录
     *
     * @param login
     * @return
     */
    public TypeJsonResult<Customer> getByPhoneAndPwd(ReqLoginPwd login) {
        try {
            TypeJsonResult<Customer> typeJsonResult = new TypeJsonResult<>();
            typeJsonResult.setStatusCode(false);
            Customer customer = customerMapper.getByPhone(login.getPhone());
            if(customer==null){
                typeJsonResult.setStatusCode(false);
                typeJsonResult.setMessage("手机号码不存在！");
                return typeJsonResult;
            };
            if(StringUtils.isBlank( customer.getLoginPwd())){
                typeJsonResult.setStatusCode(false);
                typeJsonResult.setMessage("登录密码错误！");
                return typeJsonResult;
            };

            // 未查询到账号
            if (customer == null) {
                typeJsonResult.setMessage("账号密码不正确");
                return typeJsonResult;
            } else {
                int loginErrCount = customer.getErrTimes() == null ? 0 :
                        customer.getErrTimes().intValue();
                // 账号已锁定
                if (loginErrCount > 0) {
                    if (loginErrCount >= HhmConstants.MAX_LOGIN_ERR_COUNT) {
                        typeJsonResult.setMessage("密码多次错误，是不是\"忘记密码\"了");
                        this.logLogin(customer.getCustId(), 1, 1);
                        return typeJsonResult;
                    }


//                    Date lastLoginErrTime = customer.getErrTime();
//                    if (lastLoginErrTime != null) {
//                        double minSpace = DateUtils.getMinSpace(lastLoginErrTime, new
//                                Date());
//                        if (Arith.compareDoubleSize(minSpace,
//                                HhmConstants.LOGIN_ERR_COUNT_REST_TIME) > 0) {
//                            // 超过指定时间，解除锁定
//                            Customer temp = new Customer();
//                            temp.setCustId(customer.getCustId());
//                            temp.setErrTime(new Date());
//                            temp.setErrTimes((byte) 0);
//
//                            customerMapper.updateByPrimaryKeySelective(temp);
//                            loginErrCount = 0;
//                        } else if (loginErrCount >= HhmConstants.MAX_LOGIN_ERR_COUNT) {
//                            typeJsonResult.setMessage("密码多次错误，是不是“忘记密码了");
//                            this.logLogin(customer.getCustId(), 1, 1);
//                            return typeJsonResult;
//                        }
//                    } else {
//
//
//                        typeJsonResult.setMessage("登录失败次数过多，账号" + String.format("%d",
//                                HhmConstants.LOGIN_ERR_COUNT_REST_TIME) + "分钟内被锁定");
//                        this.logLogin(customer.getCustId(), 1, 1);
//                        return typeJsonResult;
//                    }
                }
                //分钟内被锁定

                Customer param = null;
                String userPwd = DigestUtils.md5Hex(login.getLoginPwd());
                // 校验密码
                if (!customer.getLoginPwd().equals(userPwd)) {
                    param = new Customer();

                    param.setErrTimes((byte) (loginErrCount + 1));
                    param.setErrTime(new Date());
                    param.setCustId(customer.getCustId());
                    if (StringUtils.isNotBlank(login.getPushId())) {
                        param.setPushId(login.getPushId());
                    }
                    customerMapper.updateByPrimaryKeySelective(param);
                    // 登录密码输错三次后显示输入验证码
//                    if (loginErrCount + 1 > 2) {
//
//                    }
                    typeJsonResult.setMessage("用户名和密码不匹配");
                    return typeJsonResult;
                } else {
                    param = new Customer();
                    param.setCustId(customer.getCustId());
                    param.setLoginTime(new Date());
                    if (StringUtils.isNotBlank(login.getPushId())) {
                        param.setPushId(login.getPushId());
                    }
                    param.setErrTimes((byte) 0);

                    customerMapper.updateByPrimaryKeySelective(param);
                }
                // 登录成功
                // 重置登错次数和时间
                param = new Customer();
                param.setCustId(customer.getCustId());


                if (null != customer) {
                    if (freezeStatusCheck(typeJsonResult, customer)) return typeJsonResult;
                    customer.setToken(UUIDUtils.genertateUuid32());
                    jedisService.refreshCustToken(customer.getCustId(), customer.getToken());
                }
                this.logLogin(customer.getCustId(), 1, 2);
                typeJsonResult.setType(customer);
                typeJsonResult.setStatusCode(true);
                return typeJsonResult;


            }
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("根据用户名密码会员信息" + e.getMessage(), e);
            }

        }
    }

    /**
     * 根据token信息获取用户信息
     *
     * @return
     */
    public TypeJsonResult<Customer> getByToken(String token) {

        try {
            TypeJsonResult<Customer> typeJsonResult = new TypeJsonResult<>();
            typeJsonResult.setStatusCode(false);

            String custId = jedisService.getValueByKey(token);
            if (StringUtils.isEmpty(custId)) {
                typeJsonResult.setMessage("token过期，重新登录");
                typeJsonResult.setCode(301);
                return typeJsonResult;
            }
            Customer customer = customerMapper.selectByPrimaryKey(custId);

            if (freezeStatusCheck(typeJsonResult, customer)) return typeJsonResult;
            customer.setShop(shopMapper.queryShopByCustId(custId));
            typeJsonResult.setType(customer);


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
     * 根据条件更新用户信息
     *
     * @param customer
     * @return
     */
    public JsonResult updateCustomer(Customer customer) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            int count = customerMapper.updateByPrimaryKeySelective(customer);
            if (count == 0) {
                jsonResult.setMessage("修改失败");
                return jsonResult;
            }
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            throw new HuhuaminException("修改客户信息异常", e);
        }

    }

    /**
     * 手机号 验证码 登录
     *
     * @param login
     * @param session
     * @return
     */
    public TypeJsonResult<Customer> doLoginPhone(ReqLoginPhone login, HttpSession session) {
        try {
            TypeJsonResult<Customer> typeJsonResult = new TypeJsonResult<>();
            typeJsonResult.setStatusCode(false);
            JsonResult jsonResult = handlerPhone(login.getPhone(), login.getPhoneCode(), session);
            if (jsonResult.getStatusCode()) {
                Customer customer = customerMapper.getByPhone(login.getPhone());
                if (customer == null) {
                    typeJsonResult.setMessage("账号不存在");
                    return typeJsonResult;
                } else {
                    if (freezeStatusCheck(typeJsonResult, customer)) return typeJsonResult;
                    if (null != customer) {
                        customer.setToken(UUIDUtils.genertateUuid32());
                        //refreshCustToken(customer.getToken(), customer.getCustId());
                        jedisService.refreshCustToken(customer.getCustId(), customer.getToken());
                        if (StringUtils.isNotBlank(login.getPushId())) {
                            Customer param = new Customer();
                            param.setCustId(customer.getCustId());
                            param.setPushId(login.getPushId());
                            customerMapper.updateByPrimaryKeySelective(param);
                        }
                    }

                    typeJsonResult.setType(customer);
                    this.logLogin(customer.getCustId(), 4, 2);
                    typeJsonResult.setStatusCode(true);
                    return typeJsonResult;
                }
            } else {
                typeJsonResult.setMessage(jsonResult.getMessage());
                return typeJsonResult;
            }

        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("根据用户名密码会员信息" + e.getMessage(), e);
            }

        }
    }


    /**
     * 忘记密码更新密码
     *
     * @param session
     * @param reqForgetPwd
     * @return
     */
    public JsonResult updateForgetPwd(HttpSession session, ReqForgetPwd reqForgetPwd) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            jsonResult = handlerForgetPwdPhone(reqForgetPwd.getPhone(), reqForgetPwd.getPhoneCode(), session);
            if (jsonResult.getStatusCode()) {
                Customer customer = customerMapper.getByPhone(reqForgetPwd.getPhone());
                if (null != customer) {
                    Customer customerBean = new Customer();
                    String pwd = DigestUtils.md5Hex(reqForgetPwd.getNewPwd());
                    customerBean.setLoginPwd(pwd);
                    customerBean.setCustId(customer.getCustId());
                    int count = customerMapper.updateByPrimaryKeySelective(customerBean);
                    if (count == 0) {
                        jsonResult.setStatusCode(false);
                        jsonResult.setMessage("忘记密码修改失败");
                        return jsonResult;
                    }
                } else {
                    jsonResult.setStatusCode(false);
                    jsonResult.setMessage("该用户不存在");
                    return jsonResult;
                }

                jsonResult.setStatusCode(true);
                return jsonResult;
            } else {
                return jsonResult;
            }

        } catch (Exception e) {
            throw new HuhuaminException("忘记密码修改异常", e);
        }

    }

    /**
     * 修改密码
     *
     * @param session
     * @param custId
     * @param reqSource
     * @return
     */
    public JsonResult updatePwd(HttpSession session, String custId, ReqUpdatePwd reqSource) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            Customer customer = null;
            if (reqSource.getStep() == 1) {//1 需要验证下验证码 进行下一步
                jsonResult = handlerForgetPwdPhone(reqSource.getPhone(), reqSource.getPhoneCode(), session);
                return jsonResult;
            } else if (reqSource.getStep() == 2) {//直接传2 验证码和新密码 （验证码校验）
                jsonResult = handlerForgetPwdPhone(reqSource.getPhone(), reqSource.getPhoneCode(), session);
                if (!jsonResult.getStatusCode()) {
                    return jsonResult;
                }
                customer = customerMapper.selectByPrimaryKey(custId);
            } else if (reqSource.getStep() == 0) {//原始密码和新密码，不需要验证码（本系统使用这个）
                customer = customerMapper.selectByPrimaryKey(custId);
                String oldPwd = org.springframework.util.DigestUtils.md5DigestAsHex(reqSource.getOldPwd().getBytes());
                if (!customer.getLoginPwd().equalsIgnoreCase(oldPwd)) {
                    jsonResult.setMessage("旧密码不正确");
                    return jsonResult;
                }
            }
            // 空 直接修改密码


            Customer customerBean = new Customer();
            String pwd = DigestUtils.md5Hex(reqSource.getNewPwd());
            customerBean.setLoginPwd(pwd);
            customerBean.setCustId(custId);
            int count = customerMapper.updateByPrimaryKeySelective(customerBean);
            if (count == 0) {
                jsonResult.setStatusCode(false);
                jsonResult.setMessage("修改密码失败");
                return jsonResult;
            }
            jedisService.delByKey(reqSource.getToken());
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            throw new HuhuaminException("修改密码异常", e);
        }

    }


    /**
     * 修改手机号
     *
     * @param oldPhone
     * @param newPhone
     * @return
     */
    public JsonResult checkNewPhone(String oldPhone, String newPhone) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            if (oldPhone.equals(newPhone)) {
                jsonResult.setMessage("该手机号与原手机号一样，不可修改");
                return jsonResult;
            } else {
                int existCustomerByPhone = customerMapper.existCustomerByPhone(newPhone);
                if (existCustomerByPhone > 0) {
                    jsonResult.setMessage("该手机号已存在，不可修改");
                    return jsonResult;
                }
            }
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            throw new HuhuaminException("修改手机号信息异常", e);
        }

    }

    /**
     * 验证码校验 session 处理
     *
     * @param phone
     * @param phoneCode
     * @param session
     * @return
     */
    public JsonResult handlerPhone(String phone, String phoneCode, HttpSession session) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            String serverPhone = (String) session.getAttribute(HhmConstants.TARGET_NUMBER);
            //session有没有过期判断
            SessionUtils.handleSesseionValid(jsonResult, session, message_effective_time, off_line);
            if (!jsonResult.getStatusCode()) {
                return jsonResult;
            }

            String serverPhoneCode = (String) session.getAttribute(HhmConstants.PRE_FIX_PHONE_REG.concat(HhmConstants.VALID_CODE));
            if (StringUtils.isBlank(serverPhoneCode)) {
                jsonResult.setStatusCode(false);
                jsonResult.setMessage("验证码未发送或无效，请重新发送");
                return jsonResult;
            }
            if (!serverPhoneCode.equalsIgnoreCase(phoneCode)) {
                jsonResult.setStatusCode(false);
                jsonResult.setMessage("请输入正确的验证码");
                return jsonResult;
            }
            if (!serverPhone.equalsIgnoreCase(phone)) {
                jsonResult.setStatusCode(false);
                jsonResult.setMessage("发送与提交手机号不一样");
                return jsonResult;
            }

            return jsonResult;
        } catch (Exception e) {
            throw new HuhuaminException("登录异常", e);
        }
    }

    /**
     * 忘记密码 手机号 session 验证码 校验
     *
     * @param phone
     * @param phoneCode
     * @param session
     * @return
     */
    public JsonResult handlerForgetPwdPhone(String phone, String phoneCode, HttpSession session) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            String serverPhone = (String) session.getAttribute(HhmConstants.TARGET_NUMBER);
            //session有没有过期判断
            SessionUtils.handleSesseionValid(jsonResult, session, message_effective_time, off_line);
            if (!jsonResult.getStatusCode()) {
                return jsonResult;
            }

            String serverPhoneCode = (String) session.getAttribute(HhmConstants.PRE_FIX_PHONE_FORGET.concat(HhmConstants.VALID_CODE));
            if (StringUtils.isBlank(serverPhoneCode)) {
                jsonResult.setStatusCode(false);
                jsonResult.setMessage("验证码未发送或无效，请重新发送");
                return jsonResult;
            }
            if (!serverPhoneCode.equalsIgnoreCase(phoneCode)) {
                jsonResult.setStatusCode(false);
                jsonResult.setMessage("请输入正确的验证码");
                return jsonResult;
            }
            if (!serverPhone.equalsIgnoreCase(phone)) {
                jsonResult.setStatusCode(false);
                jsonResult.setMessage("发送与提交手机号不一样");
                return jsonResult;
            }

            return jsonResult;
        } catch (Exception e) {
            throw new HuhuaminException("登录异常", e);
        }
    }

    /**
     * 登录中 绑定了
     *
     * @param custId
     * @param reqBinOther
     * @return
     */
    public JsonResult binOtherOpenId(String custId, ReqBinOther reqBinOther) {
        try {
            JsonResult jsonResult = new JsonResult(false);

            Customer customer = new Customer();
            boolean flag = false;
            switch (reqBinOther.getType()) {
                case 2://微信
                    Customer customerExistWx = customerMapper.getByWechatId(reqBinOther.getOpenId());
                    if (null != customerExistWx && !customerExistWx.getCustId().equalsIgnoreCase(custId)) {
                        jsonResult.setMessage("微信绑定失败，openId 已经被别人绑定");
                        return jsonResult;
                    }
                    flag = thirdLoginBiz.checkQqByOpenIdAndToken(reqBinOther.getOpenId(), reqBinOther.getAccessToken());
                    if (flag) {
                        customer.setQqId(reqBinOther.getOpenId());
                        customer.setQqJson(reqBinOther.getOpenData());
                    } else {
                        jsonResult.setMessage("微信您绑定失败");
                        return jsonResult;
                    }
                    break;
                case 1:
                    Customer customerExistQq = customerMapper.getByQqId(reqBinOther.getOpenId());
                    if (null != customerExistQq && !customerExistQq.getCustId().equalsIgnoreCase(custId)) {
                        jsonResult.setMessage("qq绑定失败，openId 已经被别人绑定");
                        return jsonResult;
                    }
                    flag = thirdLoginBiz.checkWxByOpenIdAndToken(reqBinOther.getOpenId(), reqBinOther.getAccessToken());
                    if (flag) {
                        customer.setWechatId(reqBinOther.getOpenId());
                        customer.setWechatData(reqBinOther.getOpenData());
                    } else {
                        jsonResult.setMessage("微信绑定失败");
                        return jsonResult;
                    }
                    break;

            }
            customer.setCustId(custId);
            int count = customerMapper.updateByPrimaryKeySelective(customer);
            if (count == 0) {
                jsonResult.setMessage("绑定失败");
                return jsonResult;
            }
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            throw new HuhuaminException("绑定异常", e);
        }

    }

    /**
     * 解绑微信
     *
     * @param custId
     * @param reqUntie
     * @return
     */
    public JsonResult untieOtherOpenId(String custId, ReqUntie reqUntie) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            Map<String, Object> map = new HashMap<>();
            map.put("custId", custId);
            map.put("type", reqUntie.getType());
            map.put("otherId", reqUntie.getOpenId());
            int result = customerMapper.selectCountByOpenIdAndType(map);
            if (result > 0) {
                Customer customer = new Customer();
                switch (reqUntie.getType()) {
                    case 1:
                        customer.setQqId("");
                        customer.setQqJson("");
                        break;
                    case 2:
                        customer.setWechatId("");
                        customer.setWechatData("");
                        break;
                    case 3:
                        customer.setSinaId("");
                        customer.setSinaJson("");
                        break;
                }
                customer.setCustId(custId);
                int count = customerMapper.updateByPrimaryKeySelective(customer);
                if (count == 0) {
                    jsonResult.setMessage("解绑失败");
                    return jsonResult;
                }
            } else {
                jsonResult.setMessage("openId不正确，无法解绑");
                return jsonResult;
            }
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            throw new HuhuaminException("解绑异常", e);
        }

    }

    /**
     * 登出
     *
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
            throw new HuhuaminException("登出异常", e);
        }
    }

    /**
     * 手机号是否存在
     *
     * @param phone
     * @return
     */
    public int existCustPone(String phone) {
        return customerMapper.existCustomerByPhone(phone);
    }


    @Transactional
    public JsonResult doPhoneAlt(ReqPhoneAltPhoneCode reqSource, String custId, HttpSession session) {
        try {
            JsonResult jsonResult = handlerPhone(reqSource.getPhone(), reqSource.getPhoneCode(), session);
            int count = customerMapper.existCustomerByPhone(reqSource.getPhone());
            if (count == 1) {
                jsonResult.setStatusCode(false);
                jsonResult.setMessage("手机号已经被人使用");
                return jsonResult;
            }

            if (jsonResult.getStatusCode()) {
                Customer customerTemp = customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(custId);
                if (customerTemp.getCustPhone().equalsIgnoreCase(reqSource.getPhone())) {
                    jsonResult.setStatusCode(false);
                    jsonResult.setMessage("新手机号不能与当前手机号一样");
                    return jsonResult;
                }
//                String pwd = customerTemp.getLoginPwd();
//                String pwdOr = org.apache.commons.codec.digest.DigestUtils.md5Hex(reqSource.getLoginPwd());
//                if (!pwd.equalsIgnoreCase(pwdOr)) {
//                    jsonResult.setMessage("登录密码错误");
//                    return jsonResult;
//                }


                Customer customer = new Customer();
                customer.setCustId(custId);
                customer.setCustPhone(reqSource.getPhone());
                customerMapper.updateByPrimaryKeySelective(customer);
                //int reuslt = customerAccountService.updateLoginNameByCustId(custId, reqSource.getPhone());
                jsonResult.setStatusCode(true);
                return jsonResult;
            } else {
                return jsonResult;
            }
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }

            throw new HuhuaminException(" ", e);
        }
    }

    /**
     * 设置支付密码
     *
     * @param reqSource
     * @param custId
     * @param session
     * @return
     */
    public JsonResult setPayPassword(ReqSetPayPassword reqSource, String custId, HttpSession session) {

        try {
            JsonResult jsonResult = new JsonResult(false);
            Customer customer = customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(custId);
            if (StringUtils.isNotEmpty(customer.getPayPwd())) {
                jsonResult.setMessage("支付密码已经设置过");
                return jsonResult;
            }
            Customer customerUpdate = new Customer();
            customerUpdate.setCustId(custId);
            String userPwd = DigestUtils.md5Hex(reqSource.getPayPwd());
            customerUpdate.setPayPwd(userPwd);

            customerMapper.updateByPrimaryKeySelective(customerUpdate);
            jsonResult.setStatusCode(true);
            return jsonResult;

        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }

            throw new HuhuaminException("在设置支付密码过程中,服务器开了个小差！", e);
        }

    }


    /**
     * 修改支付密码
     *
     * @param session
     * @param custId
     * @param reqSource
     * @return
     */
    public JsonResult updatePayPwd(HttpSession session, String custId, ReqUpdatePayPwd reqSource) {
        try {
            //1.校验支付密码 2-修改支付密码
            JsonResult jsonResult = new JsonResult(false);
            Customer customer = customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(custId);
            if (StringUtils.isEmpty(customer.getPayPwd())) {
                jsonResult.setMessage("支付密码未设置,请先设置");
                return jsonResult;
            }


            if (reqSource.getStep() == 1) {//1 需要验证下支付密码
                String oldPwd = org.springframework.util.DigestUtils.md5DigestAsHex(reqSource.getOldPwd().getBytes());
                if (!oldPwd.equalsIgnoreCase(customer.getPayPwd())) {
                    jsonResult.setMessage("原来支付密码不正确");
                    return jsonResult;
                }
                jsonResult.setStatusCode(true);
                return jsonResult;
            } else if (reqSource.getStep() == 2) {//原始密码和新密码
                if (StringUtils.isEmpty(reqSource.getNewPwd())) {
                    jsonResult.setMessage("新支付密码不能为空");
                    return jsonResult;
                }
                String oldPwd = org.springframework.util.DigestUtils.md5DigestAsHex(reqSource.getOldPwd().getBytes());
                if (!customer.getPayPwd().equalsIgnoreCase(oldPwd)) {
                    jsonResult.setMessage("原来支付密码不正确");
                    return jsonResult;
                }
            }
            // 空 直接修改密码

            Customer customerBean = new Customer();
            String pwd = DigestUtils.md5Hex(reqSource.getNewPwd());
            customerBean.setPayPwd(pwd);
            customerBean.setCustId(custId);
            int count = customerMapper.updateByPrimaryKeySelective(customerBean);
            if (count == 0) {
                jsonResult.setStatusCode(false);
                jsonResult.setMessage("修改密码支付失败");
                return jsonResult;
            }
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            throw new HuhuaminException("在修改密码支付密码过程中,系统开小差了", e);
        }

    }

    public JsonResult updateValidPayPwd(HttpSession session, String custId, ReqValidUpdatePayPwd reqSource) {

        try {
            //1.校验支付密码 2-修改支付密码


            JsonResult jsonResult = handlerPhone(reqSource.getPhone(), reqSource.getPhoneCode(), session);
            if (jsonResult.getStatusCode()) {


                Customer customer = customerMapper.selectByPrimaryKey(custId);
                if (StringUtils.isEmpty(customer.getPayPwd())) {
                    jsonResult.setMessage("支付密码未设置,请先设置");
                    return jsonResult;
                }
                if (customer.getAuthStatus() != 4) {
                    jsonResult.setMessage("你没有有效的实名认证信息");
                    return jsonResult;
                }

                if (reqSource.getStep() == 1) {//1 需要验证下支付密码
                    if (!(customer.getIdCard().equals(reqSource.getIdCard()) && customer.getRealName().equals(reqSource.getRealName()))) {
                        jsonResult.setMessage("身份验证失败");
                        return jsonResult;
                    }
                    jsonResult.setStatusCode(true);
                    return jsonResult;
                } else if (reqSource.getStep() == 2) {//原始密码和验证身份信息
                    if (StringUtils.isEmpty(reqSource.getNewPwd())) {
                        jsonResult.setMessage("新支付密码不能为空");
                        return jsonResult;
                    }
                    if (!(customer.getIdCard().equals(reqSource.getIdCard()) && customer.getRealName().equals(reqSource.getRealName()))) {
                        jsonResult.setMessage("身份验证失败");
                        return jsonResult;
                    }
                }
                // 空 直接修改密码
                Customer customerBean = new Customer();
                String pwd = DigestUtils.md5Hex(reqSource.getNewPwd());
                customerBean.setPayPwd(pwd);
                customerBean.setCustId(custId);
                int count = customerMapper.updateByPrimaryKeySelective(customerBean);
                if (count == 0) {
                    jsonResult.setStatusCode(false);
                    jsonResult.setMessage("修改密码支付失败");
                    return jsonResult;
                }

                jsonResult.setStatusCode(true);
            }
            return jsonResult;
        } catch (Exception e) {
            String msg = "修改密码支付";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }


    }

    /**
     * 模糊查询用昵称列表
     *
     * @param nickName
     * @return
     */
    public PageJsonResult<Customer> nickNames(ReqUserInfoPage reqSource, String custId) {
        try {
            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqSource.getPageNum(), reqSource.getPageSize());

            List<Customer> list = null;

            list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize()).doSelectPage(() -> customerMapper
                    .selectNicks(reqSource.getNickName(), custId));

            PageInfo<Customer> page = new PageInfo<>(list);
            PageJsonResult<Customer> pageJsonResult = new PageJsonResult<>(page);

            return pageJsonResult;
        } catch (Exception e) {
            String msg = "昵称模糊查询";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);


        }
    }


    /**
     * 登录日志
     *
     * @param custId
     * @param type   登录方式[1-微信 2-QQ 3-账号密码 4-短信]
     * @param status 登录成功[1-失败 2-成功]
     */
    private void logLogin(String custId, Integer type, Integer status) {
        try {
            CustomerLog customerLog = new CustomerLog();
            customerLog.setCustId(custId);
            customerLog.setAddTime(new Date());
            customerLog.setLogId(UUIDUtils.generateUuid22());
            customerLog.setLogSource(type.byteValue());
            customerLog.setLogStatus(status.byteValue());
            customerLogMapper.insert(customerLog);
        } catch (Exception e) {

        }


    }

    /**
     * 增加子账号
     * @param reqLinkUPAccountAdd
     * @param userId
     * @return
     */
    @Transactional
    public JsonResult addSubAccount(ReqLinkUPAccountAdd reqLinkUPAccountAdd,String userId) {
        try {

            JsonResult jsonResult=new JsonResult(false);

            String relationLevel=systemUserMapper.queryRelationLevelByUserId(userId);
            String account=reqLinkUPAccountAdd.getAccount();
            String pwd=reqLinkUPAccountAdd.getPwd();

            if(StringUtils.isBlank(relationLevel)){
                throw new HuhuaminException("商铺级别错误！");
            }
            if(!(relationLevel.equals("1")||relationLevel.equals("2"))){
                throw new HuhuaminException("商铺级别不够！");
            }
            if(systemUserMapper.existUserAcct(account)>0){
                throw new HuhuaminException("账号名称已经存在！");
            }

            if(shopMapper.existShopByShopName(reqLinkUPAccountAdd.getShopName())>0){
                throw new HuhuaminException("店铺名称已经存在！");
            }

                String shopId=UUIDUtils.generateUuid22();
                String custId=UUIDUtils.genertateUuid32();


                registerBiz.doRegisterTest(account,pwd, custId,shopId);

                ReqLinkUPAccountUpdate r=new ReqLinkUPAccountUpdate();

                Shop shop=shopMapper.selectShortByPrimaryKey(systemUserMapper.queryShopIdByUserId(userId));
                String linkPhone= StringUtils.isNotBlank(reqLinkUPAccountAdd.getLinkPhone())?reqLinkUPAccountAdd.getLinkPhone():"无";
                String linkMan=StringUtils.isNotBlank(reqLinkUPAccountAdd.getLinkMan())?reqLinkUPAccountAdd.getLinkMan():"无";


                r.setShopName(reqLinkUPAccountAdd.getShopName());
                r.setShopTpe(shop.getShopType());// 商铺类型[1-产品类 2-服务类]
                r.setLinkPhone(linkPhone);
                r.setLinkMan(linkMan);
                r.setShopLogo(shop.getShopLogo());
                r.setGrps(reqLinkUPAccountAdd.getGrps());
                r.setLinkWechat("linkWechat");
                r.setShopArea(reqLinkUPAccountAdd.getShopArea());
                r.setLinkAddr(reqLinkUPAccountAdd.getShopAdress());
                r.setShopTitle(shop.getShopTitle());
                r.setShopNotice("shopNotice");
                r.setShopDesc(shop.getShopDesc());
                r.setGrpsAdress(reqLinkUPAccountAdd.getGrpsAdress());
                r.setBusinessLicense("businessLicense");
                r.setLegalPersonIdCard("legalPersonIdCard");
                linkUPAccountUpdate(r, custId,relationLevel,userId,shopId,account,pwd);
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "增加子账号";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }

    }

    /**
     * 联通前后台商铺相关信息--增加
     * @param reqLinkUPAccount
     * @param custId
     * @param relationLevel
     * @param priUser
     * @param shopId
     * @param account
     * @param pwd
     * @return
     */
    @Transactional
    public JsonResult linkUPAccountUpdate(ReqLinkUPAccountUpdate reqLinkUPAccount, String custId,String relationLevel
            ,String priUser,String shopId,String account,String pwd) {
        try {
            JsonResult jsonResult=new JsonResult(false);


                if(StringUtils.isBlank(reqLinkUPAccount.getShopName())){
                    throw new HuhuaminExceptionPlan("店铺名称不能为空！");
                }
                if(StringUtils.isBlank(reqLinkUPAccount.getShopTitle())) {
                    throw new HuhuaminExceptionPlan("店铺简介不能为空");
                }
                if(StringUtils.isBlank(reqLinkUPAccount.getShopLogo())) {
                    throw new HuhuaminExceptionPlan("店铺logo不能为空");
                }
                if(StringUtils.isBlank(reqLinkUPAccount.getShopNotice())) {
                    throw new HuhuaminExceptionPlan("店铺公告不能为空！");
                }
                if(StringUtils.isBlank(reqLinkUPAccount.getShopDesc())) {
                    throw new HuhuaminExceptionPlan("店铺营业时间不能为空！");
                }
                if(StringUtils.isBlank(reqLinkUPAccount.getShopArea())) {
                    throw new HuhuaminExceptionPlan("所在区域不能为空！");
                }
                if(StringUtils.isBlank(reqLinkUPAccount.getLinkAddr())) {
                    throw new HuhuaminExceptionPlan("详细地址不能为空！");
                }
                if(StringUtils.isBlank(reqLinkUPAccount.getLinkMan())) {
                    throw new HuhuaminExceptionPlan("店铺联系人不能为空！");
                }
                if(StringUtils.isBlank(reqLinkUPAccount.getLinkPhone())) {
                    throw new HuhuaminExceptionPlan("联系人电话不能为空！");
                }
                if(StringUtils.isBlank(reqLinkUPAccount.getLinkWechat())) {
                    throw new HuhuaminExceptionPlan("联系人微信号不能为空！");
                }
                if(StringUtils.isBlank(reqLinkUPAccount.getGrps())) {
                    throw new HuhuaminExceptionPlan("店铺位置不能为空！");
                }
                if(StringUtils.isBlank(reqLinkUPAccount.getBusinessLicense())) {
                    throw new HuhuaminExceptionPlan("营业执照不能为空！");
                }
                if(StringUtils.isBlank(reqLinkUPAccount.getLegalPersonIdCard())) {
                    throw new HuhuaminExceptionPlan("法人身份证不能为空！");
                }
                //if(StringUtils.isBlank(reqLinkUPAccount.getShopImgs())) {
                //    throw new HuhuaminExceptionPlan("图片集不能为空！");
                // }
                if(null==reqLinkUPAccount.getShopTpe()) {
                    throw new HuhuaminExceptionPlan("店铺类型不能为空！");
                }


                    /****************************商家入驻表开始*****************************/
                    int count=0;
                    ShopApply shopApply=new ShopApply();
                    BeanUtils.copyProperties(reqLinkUPAccount, shopApply);
                    shopApply.setApplyId(UUIDUtils.generateUuid22());
                    shopApply.setCustId(custId);
                    shopApply.setApplyFlag((byte)1);//状态[1-待审核 2-驳回 3-审核通过]
                    shopApply.setAddTime(new Date());


                    count= shopApplyMapper.insert(shopApply);
                    if(count!=1){
                        throw new HuhuaminExceptionPlan("商家入驻信息添加失败！");
                    }

                    /****************************商家入驻表结束*****************************/
                    /****************************商铺管理表开始*****************************/

                    Shop shop=new Shop();
                    shop.setShopId(shopId);
                    //商铺类型[1-产品类 2-服务类]
                    if(reqLinkUPAccount.getShopTpe()==1){
                        shop.setCatId("1028");//服装类   这是随便给的值
                    }else if(reqLinkUPAccount.getShopTpe()==2){
                        shop.setCatId(CAN_YIN);
                    }
                    shop.setGrpsAdress(reqLinkUPAccount.getGrpsAdress());
                    shop.setShopName(reqLinkUPAccount.getShopName());
                    shop.setShopTitle(reqLinkUPAccount.getShopTitle());
                    shop.setShopLogo(reqLinkUPAccount.getShopLogo());
                    shop.setShopNotice(reqLinkUPAccount.getShopNotice());
                    shop.setShopDesc(reqLinkUPAccount.getShopDesc());
                    shop.setAuditStatus((byte)2);//店铺审核状态[2-待审核 3-审核失败 4-审核通过]
                    shop.setShopStatus((byte)4);//店铺状态[3-禁用 4-可用]
                    shop.setShopArea(reqLinkUPAccount.getShopArea());
                    shop.setShopAddress(reqLinkUPAccount.getLinkAddr());
                    shop.setAuthType((byte)2);//认证类型[1-个人认证 2-企业认证 3-委托管理]
                    shop.setLinkMan(reqLinkUPAccount.getLinkMan());
                    shop.setLinkPhone(reqLinkUPAccount.getLinkPhone());
                    shop.setLinkWechat(reqLinkUPAccount.getLinkWechat());
                    shop.setGrps(reqLinkUPAccount.getGrps());
                    shop.setAddTime(new Date());
                    shop.setShopImgs(reqLinkUPAccount.getShopImgs());
                    shop.setShopType(reqLinkUPAccount.getShopTpe());
                    shop.setCustId(custId);
                    shop.setGoodsScore(0);
                    shop.setServiceScore(0);
                    shop.setShipperScore(0);
                    shop.setUpdateTime(new Date());
                    shop.setBusinessLicense(reqLinkUPAccount.getBusinessLicense());
                    shop.setLegalPersonIdCard(reqLinkUPAccount.getLegalPersonIdCard());

                    count=shopMapper.insert(shop);
                    if(count!=1){
                        throw new HuhuaminExceptionPlan("店铺信息添加失败！");
                    }

                    /****************************商铺管理表结束*****************************/
                    /****************************后台用户表开始*****************************/
                    SystemUser systemUser = new SystemUser();
                    systemUser.setUserId(custId);//uniUserAcct
                    systemUser.setUserAcct(account);
                    systemUser.setUserName(account);
                    systemUser.setUserPwd(org.springframework.util.DigestUtils.md5DigestAsHex(pwd.getBytes()));
                    systemUser.setActiveFlag((byte) 1);//是否有效 [1-有效 2-无效]
                    systemUser.setCreateTime(new Date());
                    systemUser.setPcOnlineFlag((byte) 2);//账户类型 [1-后台 2-商家]
                    systemUser.setJpushRegId(shopId);
                    systemUser.setDeductionPoint(0D);
                    systemUser.setConsumePoint(0D);
                    Integer relationLevelInt=Integer.parseInt(relationLevel)+1;
                    systemUser.setRelationLevel(  Byte.valueOf(relationLevelInt+""));
                    count=systemUserMapper.insert(systemUser);
                    if (count != 1) {
                        throw new HuhuaminExceptionPlan("后台用户表信息添加失败！");
                    }
                    /****************************后台用户表结束*****************************/

                    /***********************************用户关联账号开始**********************************************/
                    //用户关联账号
                    UserRelation userRelation=new UserRelation();
                    userRelation.setRelationId(UUIDUtils.genertateUuid32());
                    userRelation.setPriUserId(priUser);
                    userRelation.setSecUserId(custId);
                    userRelation.setUserRelationStatus((byte)1);
                    userRelation.setAccountRelationStatus((byte)1);
                    userRelation.setAddTime(new Date());

                    count=userRelationMapper.insert(userRelation);
                    if (count != 1) {
                        throw new HuhuaminExceptionPlan("用户关联账号添加失败！");
                    }
                    /********************************用户关联账号结束*************************************************/
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "联通前后台商铺相关信息--增加";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);


        }
    }


    /**
     * 查询用户积分或余额记录
     * @param reqTokenPage
     * @param type[1-余额 3-积分]
     * @param custId
     * @return
     */
    public PageJsonResult<CustomerPoint> customerPointOrBalance(ReqCustomerPointOrBalance reqTokenPage, String custId) {
        try {
            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqTokenPage.getPageNum(), reqTokenPage.getPageSize());

            List<CustomerPoint> list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(),"ADD_TIME DESC").doSelectPage(() -> customerPointMapper.customerPointOrBalance(reqTokenPage.getGainType(),reqTokenPage.getPointType(),custId));
           // Game game=new Game();
            list.stream().forEach((temp) -> {
                if(1==temp.getSourceType()){ //订单
                    if(CollectionUtils.isEmpty(orderItemMapper.getOrderItemByOrderId(temp.getSourceId()))){
                        temp.setPointDesc("兑换商品");
                    }else {
                        temp.setPointDesc("兑换—".concat(goodsMapper.selectShort( orderItemMapper.getOrderItemByOrderId(temp.getSourceId()).get(0).getGoodsId()).getGoodsName()));
                    }


                }else if(5==temp.getSourceType()){//游戏
                    Game   game=gameMapper.selectByPrimaryKey(temp.getSourceId());
                    if(null==game){
                        temp.setPointDesc("玩游戏");
                    }else{
                        temp.setPointDesc("玩游戏—".concat(gameMapper.selectByPrimaryKey(temp.getSourceId()).getGameName()));
                    }

                }else if(3==temp.getSourceType()){   //资源类型[1-商城订单 2-其他订单 3-邀请注册赠送 4-邀请首次消费赠送 5-游戏 6-签到积分 7-系统赠送]
                    temp.setPointDesc("邀请注册赠送");
                }else if(4==temp.getSourceType()){   //资源类型[1-商城订单 2-其他订单 3-邀请注册赠送 4-邀请首次消费赠送 5-游戏 6-签到积分 7-系统赠送]
                    temp.setPointDesc("邀请首次消费赠送");
                }else if(6==temp.getSourceType()){   //资源类型[1-商城订单 2-其他订单 3-邀请注册赠送 4-邀请首次消费赠送 5-游戏 6-签到积分 7-系统赠送]
                    temp.setPointDesc("签到积分");
                }else if(7==temp.getSourceType()){   //资源类型[1-商城订单 2-其他订单 3-邀请注册赠送 4-邀请首次消费赠送 5-游戏 6-签到积分 7-系统赠送]
                    temp.setPointDesc("系统赠送");
                }


            });

            PageInfo<CustomerPoint> page = new PageInfo<>(list);
            PageJsonResult<CustomerPoint> pageJsonResult = new PageJsonResult<>(page);

            return pageJsonResult;
        } catch (Exception e) {
            String msg = "查询用户积分或余额记录";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);


        }
    }

    /**
     * 查询用户总积分或总余额
     * @param type【1-总积分 2-总余额】
     * @param custId
     * @return
     */
    public TypeJsonResult customerPointOrBalanceCount(Integer type, String custId) {
        try {
            TypeJsonResult jsonResult=new TypeJsonResult(false);
            Double count=customerPointMapper.customerPointOrBalanceCount(type,custId);

            jsonResult.setStatusCode(true);
            jsonResult.setType(count);
            return jsonResult;
        } catch (Exception e) {
            String msg = "查询用户总积分或总余额";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);


        }
    }


    /**
     * 商铺详情
     * @param userId
     * @return
     */
    public TypeJsonResult shopDetail(String userId) {
        try {
            TypeJsonResult jsonResult=new TypeJsonResult(false);
            SystemUser systemUser= systemUserMapper.selectByPrimaryKey(userId);
            String jpushRegId=systemUser.getJpushRegId();
            Shop shop=shopMapper.selectByPrimaryKey(jpushRegId);
            jsonResult.setStatusCode(true);
            jsonResult.setType(shop);
            return jsonResult;
        } catch (Exception e) {
            String msg = "商铺详情";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);


        }
    }


    /**
     * 修改商铺
     * @param reqLinkUPAccount
     * @param custId
     * @return
     */
    @Transactional
    public JsonResult shopUpdate(ReqLinkUPAccountUpdate reqLinkUPAccount, String userId) {
        try {
            JsonResult jsonResult=new JsonResult(false);
            SystemUser systemUser= systemUserMapper.selectByPrimaryKey(userId);
            String jpushRegId=systemUser.getJpushRegId();

            String custId=shopMapper.selectShortByPrimaryKey(jpushRegId).getCustId();
            reqLinkUPAccount.setShopId(jpushRegId);
                Shop shop=new Shop();
                shop.setShopId(reqLinkUPAccount.getShopId());
                if(null!=reqLinkUPAccount.getShopTpe()){//店铺类型范围[1-开通直播  2-不开通直播]
                    if(reqLinkUPAccount.getShopTpe()==1){
                        shop.setCatId(CAN_YIN);
                    }else if(reqLinkUPAccount.getShopTpe()==2){
                        shop.setCatId("1028");//服装类   这是随便给的值
                    }else {
                        reqLinkUPAccount.setShopTpe(null);
                    }
                }
                if(StringUtils.isNotBlank(reqLinkUPAccount.getGrpsAdress())){
                    shop.setGrpsAdress(reqLinkUPAccount.getGrpsAdress());
                }

                if(StringUtils.isNotBlank(reqLinkUPAccount.getShopName())){
                    shop.setShopName(reqLinkUPAccount.getShopName());
                }
                if(StringUtils.isNotBlank(reqLinkUPAccount.getShopTitle())) {
                    shop.setShopTitle(reqLinkUPAccount.getShopTitle());
                }
                if(StringUtils.isNotBlank(reqLinkUPAccount.getShopLogo())) {
                    shop.setShopLogo(reqLinkUPAccount.getShopLogo());
                }
                if(StringUtils.isNotBlank(reqLinkUPAccount.getShopNotice())) {
                    shop.setShopNotice(reqLinkUPAccount.getShopNotice());
                }
                if(StringUtils.isNotBlank(reqLinkUPAccount.getShopDesc())) {
                    shop.setShopDesc(reqLinkUPAccount.getShopDesc());
                }

                shop.setAuditStatus((byte)2);//店铺审核状态[2-待审核 3-审核失败 4-审核通过]
                shop.setShopStatus((byte)4);//店铺状态[3-禁用 4-可用]
                if(StringUtils.isNotBlank(reqLinkUPAccount.getShopArea())) {
                    shop.setShopArea(reqLinkUPAccount.getShopArea());
                }
                if(StringUtils.isNotBlank(reqLinkUPAccount.getLinkAddr())) {
                    shop.setShopAddress(reqLinkUPAccount.getLinkAddr());
                }


                shop.setAuthType((byte)1);//认证类型[1-个人认证 2-企业认证 3-委托管理]
                if(StringUtils.isNotBlank(reqLinkUPAccount.getLinkMan())) {
                    shop.setLinkMan(reqLinkUPAccount.getLinkMan());
                }
                if(StringUtils.isNotBlank(reqLinkUPAccount.getLinkPhone())) {
                    shop.setLinkPhone(reqLinkUPAccount.getLinkPhone());
                }
                if(StringUtils.isNotBlank(reqLinkUPAccount.getLinkWechat())) {
                    shop.setLinkWechat(reqLinkUPAccount.getLinkWechat());
                }
                if(StringUtils.isNotBlank(reqLinkUPAccount.getGrps())) {
                    shop.setGrps(reqLinkUPAccount.getGrps());
                }

                //shop.setAddTime(new Date());
                if(StringUtils.isNotBlank(reqLinkUPAccount.getShopImgs())) {
                    shop.setShopImgs(reqLinkUPAccount.getShopImgs());
                }
                if(null!=reqLinkUPAccount.getShopTpe()) {
                    shop.setShopType(reqLinkUPAccount.getShopTpe());
                }

                if(null!=reqLinkUPAccount.getBusinessLicense()) {
                    shop.setBusinessLicense(reqLinkUPAccount.getBusinessLicense());
                }
                if(null!=reqLinkUPAccount.getLegalPersonIdCard()) {
                    shop.setLegalPersonIdCard(reqLinkUPAccount.getLegalPersonIdCard());
                }

                // shop.setCustId(custId);
               /* shop.setGoodsScore(0);
                shop.setServiceScore(0);
                shop.setShipperScore(0);*/
                shop.setUpdateTime(new Date());


                int count=shopMapper.updateSelectByPrimaryKey(shop);
                if(count!=1){
                    throw new HuhuaminExceptionPlan("修改店铺信息添加失败！");
                }

                String applyId=shopApplyMapper.selectAllByCustId(custId).getApplyId();
                if(StringUtils.isNotBlank(applyId)){
                    ShopApply shopApply=new ShopApply();

                    shopApply.setApplyId(applyId);
                    if(StringUtils.isNotBlank(reqLinkUPAccount.getShopName())){
                        shopApply.setShopName(reqLinkUPAccount.getShopName());
                    }
                    if(StringUtils.isNotBlank(reqLinkUPAccount.getLinkMan())){
                        shopApply.setLinkMan(reqLinkUPAccount.getLinkMan());
                    }
                    if(StringUtils.isNotBlank(reqLinkUPAccount.getLinkPhone())){
                        shopApply.setLinkPhone(reqLinkUPAccount.getLinkPhone());
                    }
                    if(StringUtils.isNotBlank(reqLinkUPAccount.getLinkAddr())){
                        shopApply.setLinkAddr(reqLinkUPAccount.getLinkAddr());
                    }
                    shopApply.setCustId(custId);
                    shopApply.setApplyFlag((byte)1);//状态[1-待审核 2-驳回 3-审核通过]

                    count= shopApplyMapper.updateSelectByPrimaryKey(shopApply);
                    if(count!=1){
                        throw new HuhuaminExceptionPlan("修改店入驻信息失败！");
                    }
                }

                jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "修改商铺";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 订单信息
     * @param userId
     * @return
     */
    public TypeJsonResult orderInformation(String userId) {
        try {
            TypeJsonResult jsonResult = new TypeJsonResult(false);

            String shopId = systemUserMapper.queryShopIdByUserId(userId);


            Calendar cal = Calendar.getInstance();
            cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
            cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);


            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            String nowStr = sf.format(new Date());

            SimpleDateFormat weekSf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String dayTimeBegin = nowStr.concat(" 00:00:00");
            String dayTimeEnd = nowStr.concat(" 23:59:59");

            String weekTimeBegin = weekSf.format(cal.getTime());
            String weekTimeEnd = dayTimeEnd;


            Order order = orderMapper.orderInformation(shopId, dayTimeBegin, dayTimeEnd, weekTimeBegin, weekTimeEnd);

            Shop shop=shopMapper.selectShortByPrimaryKey(shopId);
            order.setShopName(shop.getShopName());
            order.setShopLogo(shop.getShopLogo());
            order.setShopType(shop.getShopType());
            jsonResult.setStatusCode(true);
            jsonResult.setType(order);
            return jsonResult;
        } catch (Exception e) {
            String msg = "订单信息";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);


        }
    }

    /**
     * 根据资源来源和创建人查询图片路径
     * @param userId
     * @return
     */
    public PageJsonResult queryImgUrlBysourceTypeAndAddBy(ReqGoodsImages reqGoodsImages,String userId) {
        try {
            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqGoodsImages.getPageNum(), reqGoodsImages.getPageSize());

            List<String> list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize()).doSelectPage(()
                    -> goodsImagesMapper.queryImgUrlBysourceTypeAndAddBy(reqGoodsImages.getSourceType(),userId));
            PageInfo<String> page = new PageInfo<>(list);
            PageJsonResult<String> pageJsonResult = new PageJsonResult<>(page);
            return pageJsonResult;
        } catch (Exception e) {
            String msg = "根据资源来源和创建人查询图片路径";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 增加商品图片
     * @param sourceType
     * @param userId
     * @param imgUrl
     * @return
     */
    public JsonResult addImgUrl(GoodsImages goodsImages) {
        try {
            JsonResult jsonResult=new JsonResult();
            goodsImagesMapper.insert(goodsImages);
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "增加商品图片";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }
    public static boolean tokenDie(JsonResult jsonResult, String custId) {
        if (StringUtils.isEmpty(custId)) {
            jsonResult.setStatusCode(false);
            jsonResult.setMessage("token过期，重新登录");
            jsonResult.setCode(301);
            return true;
        }
        return false;
    }


    /**
     * 推广返利列表
     * @param reqTokenPage
     * @param userId
     * @return
     */
    public PageJsonResult relationList(ReqRebatePage reqTokenPage,String userId) {
        try {
            List<String> list = new ArrayList<>();
            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqTokenPage.getPageNum(), reqTokenPage.getPageSize());
            String addTime = reqTokenPage.getCurrentMonth();
          //  if(StringUtils.isNotBlank(addTime)){

                Base64.Decoder decoder = Base64.getDecoder();
                String timeStr=new String(decoder.decode(addTime), "UTF-8");

                String beginTime=timeStr.split(",")[0];
                String endTime=timeStr.split(",")[1];
               int relationUserCount= userRebateMapper.relationUserCount(userId);
                SystemParam systemParamPoint = systemParamMapper.selectByIndex( SystemParamBiz.RELATION_USER_COUNT);
                if(relationUserCount<Integer.parseInt(systemParamPoint.getParamValue())){
                   list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize()).doSelectPage(()
                           -> userRebateMapper.queryUserRebateListIsNum1ByAddTime(userId,beginTime,endTime));
               }else{
                   list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize()).doSelectPage(()
                           -> userRebateMapper.queryUserRebateListIsNum2ByAddTime(userId,beginTime,endTime));
               }

          /*  }else {
                list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize()).doSelectPage(()
                        -> userRebateMapper.queryUserRebateListByAddTimeForTotal(userId));
            }*/
            PageInfo<String> page = new PageInfo<>(list);
            PageJsonResult<String> pageJsonResult = new PageJsonResult<>(page);
            return pageJsonResult;
        } catch (Exception e) {
            String msg = "推广返利列表";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /***************************查询用户所属用户Id或所属商铺id***************************************/

    private void toUserRelation(List<UserRelation> userRelationResult,String userId){
        List<UserRelation>  userRelations=userRelationMapper.queryUserRelation(userId);
        for(UserRelation userRelation:userRelations){
            userRelationResult.add(userRelation);
            toUserRelation(userRelationResult,userRelation.getSecUserId());

        }
    }

    public List<UserRelation>  queryUserRelation(String userId){
        List<UserRelation> userRelationResult=new ArrayList<>();

        List<UserRelation> userRelations=userRelationMapper.queryUserRelation(userId);
        for(UserRelation userRelation:userRelations){
            userRelationResult.add(userRelation);
            toUserRelation(userRelationResult,userRelation.getSecUserId());
        }

        return userRelationResult;
    }

    public List<String>  queryUserRelationUserIds(String userId){
        List<String> userIds=new ArrayList<>();
        List<UserRelation> userRelationResult=queryUserRelation(userId);

        for(UserRelation userRelation:userRelationResult){
            userIds.add(userRelation.getSecUserId());
        }
        return userIds;
    }

    public List<String>  queryUserRelationShopIds(String userId){
        List<String> userIds=queryUserRelationUserIds(userId);
        if(CollectionUtils.isEmpty(userIds)){
            return new ArrayList<String>();
        }else{
            return systemUserMapper.queryShopIdsByUserIds(userIds);
        }


    }
/***************************查询用户所属用户Id或所属商铺id***************************************/


    /***************************查询用户级别***************************************/


    public int  queryUserRelationRelationLevel(String userId){
        int relationLevel=0;

        List<UserRelation> userRelationsDown=userRelationMapper.queryUserRelation(userId);

        List<UserRelation>  userRelationUp=userRelationMapper.queryUserRelationUp(userId);

        if(!CollectionUtils.isEmpty(userRelationsDown)&&!CollectionUtils.isEmpty(userRelationUp)){
            relationLevel=2;
        }
        if(CollectionUtils.isEmpty(userRelationsDown)&&!CollectionUtils.isEmpty(userRelationUp)){
            relationLevel=3;
        }
        if(!CollectionUtils.isEmpty(userRelationsDown)&&CollectionUtils.isEmpty(userRelationUp)){
            relationLevel=1;
        }

        return relationLevel;
    }

    public  TypeJsonResult test(String userId){
        TypeJsonResult typeJsonResult=new TypeJsonResult();
        typeJsonResult.setType(queryUserRelationShopIds(userId));
        return typeJsonResult;
    }
  /***************************查询用户级别***************************************/

    /**
     * 根据userId查询总的推广返利
     * @param userId
     * @return
     */
    public TypeJsonResult queryTotalUserRebateByUserId(String userId,ReqRebate reqSource) {
        try {

            TypeJsonResult typeJsonResult=new TypeJsonResult();
            UserRebate userRebate=new UserRebate();
           // if(StringUtils.isNotBlank(reqSource.getCurrentMonth())){
                Base64.Decoder decoder = Base64.getDecoder();
                String timeStr=new String(decoder.decode(reqSource.getCurrentMonth()), "UTF-8");

                String beginTime=timeStr.split(",")[0];
                String endTime=timeStr.split(",")[1];



           /* }else{
                userRebate= userRebateMapper.queryTotalUserRebateByUserIdForTotal(userId);
                //操作方式[0-全部 1至12-1至12月份
                userRebate.setIsTotal((byte)0);
            }*/
            int relationUserCount= userRebateMapper.relationUserCount(userId);


            SystemParam systemParamPoint = systemParamMapper.selectByIndex( SystemParamBiz.RELATION_USER_COUNT);
            //是否满足数量[1-未满足 2-已满足]
            if(relationUserCount<Integer.parseInt(systemParamPoint.getParamValue())){
                userRebate= userRebateMapper.queryTotalUserRebateByUserId(userId,beginTime,endTime,(byte)1);
                userRebate.setIsNum((byte)1);
            }else{
                userRebate= userRebateMapper.queryTotalUserRebateByUserId(userId,beginTime,endTime,(byte)2);
                userRebate.setIsNum((byte)2);
            }

            //是否核销 [1-未核销 2-已核销
            if(userRebate.getIsWriteOff()==0 && userRebate.getCustCount()>0){
                userRebate.setIsWriteOff((byte)2);
            }else {
                userRebate.setIsWriteOff((byte)1);
            }
            //操作方式[0-全部 1至12-1至12月份
            userRebate.setIsTotal( Byte.parseByte(beginTime.split("-")[1]));

            userRebate.setRebateCost(1D);
            typeJsonResult.setStatusCode(true);
            typeJsonResult.setType(userRebate);
            return typeJsonResult;
        } catch (Exception e) {
            String msg = "根据userId查询总的推广返利";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 当前月列表
     * @param userId
     * @return
     */
    public TypeJsonResult currentMonthList(String userId) {
        try {
            TypeJsonResult typeJsonResult=new TypeJsonResult();
            Date earliestMonth= null;
            int relationUserCount= userRebateMapper.relationUserCount(userId);
            //是否满足数量[1-未满足 2-已满足]
            SystemParam systemParamPoint = systemParamMapper.selectByIndex( SystemParamBiz.RELATION_USER_COUNT);
            if(relationUserCount<Integer.parseInt(systemParamPoint.getParamValue())){
                 earliestMonth= userRebateMapper.queryEarliestMonthByUserId(userId,(byte)1);
            }else{
                earliestMonth= userRebateMapper.queryEarliestMonthByUserId(userId,(byte)2);
            }
            if(null==earliestMonth){
                /*typeJsonResult.setStatusCode(true);
                typeJsonResult.setType(new ArrayList<>());
                return typeJsonResult;*/
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH,-1);
                earliestMonth=calendar.getTime();
            }
            Calendar bef = Calendar.getInstance();
            Calendar aft = Calendar.getInstance();
            bef.setTime(earliestMonth);
            int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
            int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;

            int diffMonth=Math.abs(month + result)+1;
            System.out.println(diffMonth);

            if(diffMonth>6){
                diffMonth = 6;
            }
            SimpleDateFormat sf= new SimpleDateFormat("yyyy-MM-01 00:00:00");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
            SimpleDateFormat sfMonth= new SimpleDateFormat("yyyy-MM");
            List<RespRebateCurrentMonth> list=new ArrayList<>();
            for(int i=0;i<diffMonth;i++){
                if(i!=0){
                    Calendar firstTime = Calendar.getInstance();
                    int crrentMonth=firstTime.get(Calendar.MONTH);
                    firstTime.set(Calendar.MONTH,crrentMonth-i );
                    String firstday = sf.format(firstTime.getTime());

                    // 获取前月的最后一天
                    Calendar cale = firstTime;
                    cale.add(Calendar.MONTH, 1);
                    cale.set(Calendar.DAY_OF_MONTH, 0);
                    String lastday = format.format(cale.getTime());

                    RespRebateCurrentMonth respRebateCurrentMonth=new RespRebateCurrentMonth();
                    Base64.Encoder encoder = Base64.getEncoder();
                    String encodedText = encoder.encodeToString((firstday.concat(",").concat(lastday)).getBytes("utf-8"));
                    respRebateCurrentMonth.setId(encodedText);
                    respRebateCurrentMonth.setText(sfMonth.format(firstTime.getTime()));
                    list.add(respRebateCurrentMonth);
                }
            }
            typeJsonResult.setStatusCode(true);
            typeJsonResult.setType(list);
            return typeJsonResult;
        } catch (Exception e) {
            String msg = "当前月列表";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 推广返利规则
     * @param userId
     * @return
     */
    public TypeJsonResult rebateRule(String userId) {
        try {
            TypeJsonResult jsonResult=new TypeJsonResult();
            Map map=new HashMap();
            map.put("num",systemParamMapper.selectByIndex( SystemParamBiz.RELATION_USER_COUNT).getParamValue());

            jsonResult.setType(map);
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "推广返利规则";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 商户端推广客户列表
     * @param reqTokenPage
     * @param userId
     * @return
     */
    public PageJsonResult inviteCustList(ReqTokenPage reqTokenPage,String userId) {
        try {
            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqTokenPage.getPageNum(), reqTokenPage.getPageSize());

            List<Customer> list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(),"REGIST_TIME DESC").doSelectPage(()
                    -> customerMapper.inviteCustList(userId));
            PageInfo<Customer> page = new PageInfo<>(list);
            PageJsonResult<Customer> pageJsonResult = new PageJsonResult<>(page);
            //pageJsonResult.setExtra(customerMapper.inviteCustCount(userId));

            return pageJsonResult;
        } catch (Exception e) {
            String msg = "商户端推广客户列表";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 用户列表
     * @param reqTokenPage
     * @return
     */
    public PageJsonResult custList(ReqTokenPage reqTokenPage) {
        try {
            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqTokenPage.getPageNum(), reqTokenPage.getPageSize());

            List<Customer> list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize()).doSelectPage(()
                        -> customerMapper.custList());
            for (Customer customer:list){
                customer.setFlag(false);
            }
            PageInfo<Customer> page = new PageInfo<>(list);
            PageJsonResult<Customer> pageJsonResult = new PageJsonResult<>(page);
            return pageJsonResult;
        } catch (Exception e) {
            String msg = "用户列表";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 钱包列表
     * @param userId
     * @param reqTokenPage
     * @return
     */
    public PageJsonResult walletList(String userId,ReqWalletPage reqTokenPage) {
        try {
            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqTokenPage.getPageNum(), reqTokenPage.getPageSize());

            String shopId= systemUserMapper.queryShopIdByUserId(userId);
            List<Order> list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(),"ADD_TIME DESC").doSelectPage(()
                    -> userMoneyMapper.walletList(userId,reqTokenPage.getValueType(),reqTokenPage.getAddOrSubType()));

            PageInfo<Order> page = new PageInfo<>(list);
            PageJsonResult<Order> pageJsonResult = new PageJsonResult<>(page);
            return pageJsonResult;
        } catch (Exception e) {
            String msg = "钱包列表";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 结算中或已结算列表
     * @param userId
     * @param reqTokenPage
     * @param month
     * @return
     */
    public PageJsonResult walletListBySettleStatus(String userId,ReqTokenPage reqTokenPage,String month) {
        try {
            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqTokenPage.getPageNum(), reqTokenPage.getPageSize());

            List<MoneySettlement> list =new ArrayList<>();

            if(StringUtils.isNotBlank(month)&&!"moth".equals(month)) {
                Base64.Decoder decoder = Base64.getDecoder();
                String timeStr = new String(decoder.decode(month), "UTF-8");
                String beginTime = timeStr.split(",")[0];
                String endTime = timeStr.split(",")[1];
                list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(),"OUT_SETTLEMENT_TIME DESC").doSelectPage(()
                        -> moneySettlementMapper.walletListBySettleStatus(userId,beginTime,endTime));
            }else{
                list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize()).doSelectPage(()
                        -> moneySettlementMapper.walletListBySettleStatus(userId ,null,null));

            }

            PageInfo<MoneySettlement> page = new PageInfo<>(list);
            PageJsonResult<MoneySettlement> pageJsonResult = new PageJsonResult<>(page);
            return pageJsonResult;
        } catch (Exception e) {
            String msg = "结算中或已结算列表";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 结算记录月份列表
     * @param userId
     * @return
     */
    public TypeJsonResult settlementMonthList(String userId) {
        try {
            TypeJsonResult typeJsonResult=new TypeJsonResult();
            String shopId= systemUserMapper.queryShopIdByUserId(userId);

            Date earliestwalletMonth= moneySettlementMapper.earliestSettlementMonth(userId);
            if(null==earliestwalletMonth){
                typeJsonResult.setStatusCode(true);
                typeJsonResult.setType(new ArrayList<>());
                return typeJsonResult;
            }
            Calendar bef = Calendar.getInstance();
            Calendar aft = Calendar.getInstance();
            bef.setTime(earliestwalletMonth);
            int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
            int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;

            int diffMonth=Math.abs(month + result)+1;

            SimpleDateFormat sf= new SimpleDateFormat("yyyy-MM-01 00:00:00");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
            SimpleDateFormat sfMonth= new SimpleDateFormat("yyyy-MM");
            List<RespRebateCurrentMonth> list=new ArrayList<>();
            for(int i=0;i<diffMonth;i++){
                // if(i!=0){  剔除当月
                Calendar firstTime = Calendar.getInstance();
                int crrentMonth=firstTime.get(Calendar.MONTH);
                firstTime.set(Calendar.MONTH,crrentMonth-i );
                String firstday = sf.format(firstTime.getTime());

                // 获取前月的最后一天
                Calendar cale = firstTime;
                cale.add(Calendar.MONTH, 1);
                cale.set(Calendar.DAY_OF_MONTH, 0);
                String lastday = format.format(cale.getTime());

                RespRebateCurrentMonth respRebateCurrentMonth=new RespRebateCurrentMonth();
                Base64.Encoder encoder = Base64.getEncoder();
                String encodedText = encoder.encodeToString((firstday.concat(",").concat(lastday)).getBytes("utf-8"));
                respRebateCurrentMonth.setId(encodedText);
                respRebateCurrentMonth.setText(sfMonth.format(firstTime.getTime()));
                list.add(respRebateCurrentMonth);

            }
            typeJsonResult.setStatusCode(true);
            typeJsonResult.setType(list);
            return typeJsonResult;
        } catch (Exception e) {
            String msg = "结算记录月份列表";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }



        /**
         * 钱包月份列表
         * @param userId
         * @return
         */
       /* public TypeJsonResult walletMonthList(String userId) {
            try {
                TypeJsonResult typeJsonResult=new TypeJsonResult();
               String shopId= systemUserMapper.queryShopIdByUserId(userId);

                Date earliestwalletMonth= orderMapper.earliestwalletMonth(shopId);
                if(null==earliestwalletMonth){
                    typeJsonResult.setStatusCode(true);
                    typeJsonResult.setType(new ArrayList<>());
                    return typeJsonResult;
                }
                Calendar bef = Calendar.getInstance();
                Calendar aft = Calendar.getInstance();
                bef.setTime(earliestwalletMonth);
                int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
                int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;

                int diffMonth=Math.abs(month + result)+1;

                SimpleDateFormat sf= new SimpleDateFormat("yyyy-MM-01 00:00:00");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
                SimpleDateFormat sfMonth= new SimpleDateFormat("yyyy-MM");
                List<RespRebateCurrentMonth> list=new ArrayList<>();
                for(int i=0;i<diffMonth;i++){
                    // if(i!=0){  剔除当月
                        Calendar firstTime = Calendar.getInstance();
                        int crrentMonth=firstTime.get(Calendar.MONTH);
                        firstTime.set(Calendar.MONTH,crrentMonth-i );
                        String firstday = sf.format(firstTime.getTime());

                        // 获取前月的最后一天
                        Calendar cale = firstTime;
                        cale.add(Calendar.MONTH, 1);
                        cale.set(Calendar.DAY_OF_MONTH, 0);
                        String lastday = format.format(cale.getTime());

                        RespRebateCurrentMonth respRebateCurrentMonth=new RespRebateCurrentMonth();
                        Base64.Encoder encoder = Base64.getEncoder();
                        String encodedText = encoder.encodeToString((firstday.concat(",").concat(lastday)).getBytes("utf-8"));
                        respRebateCurrentMonth.setId(encodedText);
                        respRebateCurrentMonth.setText(sfMonth.format(firstTime.getTime()));
                        list.add(respRebateCurrentMonth);

                }
                typeJsonResult.setStatusCode(true);
                typeJsonResult.setType(list);
                return typeJsonResult;
            } catch (Exception e) {
                String msg = "钱包月份列表";
                msg = String.format("在%s过程中,服务器开小差了", msg);
                if (e instanceof HuhuaminException) {
                    throw new HuhuaminExceptionPlan(e.getMessage());
                }
                throw new HuhuaminException(msg, e);
            }
        }*/

    /**
     * 商户综合可结算积分和及余额和
     * @param userId
     * @return
     */
    public TypeJsonResult totalMoney(String userId) {
        try {
            TypeJsonResult typeJsonResult=new TypeJsonResult();
            SystemUser systemUser=systemUserMapper.queryTotalMoney(userId);
            typeJsonResult.setStatusCode(true);
            typeJsonResult.setType(systemUser);
            return typeJsonResult;
        } catch (Exception e) {
            String msg = "商户综合可结算积分和及余额和";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 钱包结算说明
     * @param userId
     * @return
     */
    public TypeJsonResult walletExplain(String userId) {
        try {
            TypeJsonResult typeJsonResult=new TypeJsonResult();
            Map<String,String> map=new HashMap<>();
            map.put("orderFee","收取1%手续费");
            map.put("maxPoint","100积分=1元，收取1%手续费");
            //JSONObject jsonObject = JSONObject.fromObject(map);
            typeJsonResult.setStatusCode(true);
            typeJsonResult.setType(map);
            return typeJsonResult;
        } catch (Exception e) {
            String msg = "钱包结算说明";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 结算资金详情
     * @param userId
     * @param settleId
     * @return
     */
    public TypeJsonResult ettlesdDetail(String userId,String moneyId) {
        try {
            TypeJsonResult typeJsonResult=new TypeJsonResult();
            MoneySettlement moneySettlement=moneySettlementMapper.ettlesdDetail(userId,moneyId);
            typeJsonResult.setStatusCode(true);
            typeJsonResult.setType(moneySettlement);
            return typeJsonResult;
        } catch (Exception e) {
            String msg = "结算资金详情";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     *  结算订单详情（错误）
     * @param userId
     * @param orderId
     * @return
     */
    public TypeJsonResult settlementInfoOrderDetail(String userId,String moneyId) {
        try {
            TypeJsonResult typeJsonResult=new TypeJsonResult();
            String shopId=systemUserMapper.queryShopIdByUserId(userId);
            Order order=orderMapper.querySettlementInfoOrderDetailByOrderIdAndShopId(shopId,moneyId);
            if(1==order.getRefundSettlementStatus()&&4==order.getCurrencyStatus() ){
                order.setAddOrSub((byte)2);
            }else  {
                order.setAddOrSub((byte)1);
            }
            if(StringUtils.isNotBlank(order.getGoodsName())&&StringUtils.isNotBlank(order.getSkuGoodsName())){
                if(!order.getGoodsName().equals(order.getSkuGoodsName())){
                    order.setSkuGoodsName( order.getSkuGoodsName().replace(order.getGoodsName(), ""));
                }else{
                    order.setSkuGoodsName("无");
                }
            }

            if(StringUtils.isBlank(order.getSkuGoodsName())){
                order.setSkuGoodsName("无");
            }

            typeJsonResult.setStatusCode(true);
            typeJsonResult.setType(order);
            return typeJsonResult;
        } catch (Exception e) {
            String msg = "结算订单详情";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }


    /**
     * 用户所属商铺信息
     * @param reqTokenPage
     * @return
     */
    public PageJsonResult userRelationShopList(ReqTokenPage reqTokenPage,String userId) {
        try {
            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqTokenPage.getPageNum(), reqTokenPage.getPageSize());
            List<String> shopIds= queryUserRelationShopIds(userId);

            List<Shop> list=new ArrayList<>();

            if(org.apache.commons.collections.CollectionUtils.isNotEmpty(shopIds)){
                list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize()).doSelectPage(()
                        -> shopMapper.queryShopListByShopIds(shopIds));
            }

            for(Shop shop:list){
                StringBuffer address=new StringBuffer("");
                String [] addressArr={};
                addressArr=shop.getShopArea().split("-");
                if(addressArr.length==3){
                    address.append(addressArr[1]);
                    address.append(addressArr[2]);
                }
                if(shop.getShopAddress().contains(address)){
                    shop.setShopAddress(shop.getShopAddress());
                }else{
                    address.append(shop.getShopAddress());
                    shop.setShopAddress(address.toString());
                }
            }

            PageInfo<Shop> page = new PageInfo<>(list);
            PageJsonResult<Shop> pageJsonResult = new PageJsonResult<>(page);
            return pageJsonResult;
        } catch (Exception e) {
            String msg = "用户所属商铺信息";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

}