package com.louquanapp.biz;

import com.alibaba.fastjson.JSON;
import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.model.HhmConstants;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.dao.mapper.CustomerAccountMapper;
import com.louquanapp.dao.mapper.CustomerMapper;
import com.louquanapp.dao.mapper.CustomerPointMapper;
import com.louquanapp.dao.mapper.SystemParamMapper;
import com.louquanapp.dao.model.Customer;
import com.louquanapp.dao.model.CustomerAccount;
import com.louquanapp.dao.model.CustomerPoint;
import com.louquanapp.dao.model.SystemParam;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqRegister;
import com.louquanapp.req.ReqRegisterNophone;
import com.louquanapp.service.JedisService;
import com.louquanapp.utils.SessionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Author 胡化敏
 * @Description: 注册业务逻辑处理
 * @Date Create  2019年03月26日16:13:42
 * @Modified By:
 * @Since:
 */
@Service
public class RegisterBiz {
    public final static String INVITE_PHONE = "invitePhone";
    private static final Logger logger = LoggerFactory.getLogger(RegisterBiz.class);
    private final CustomerMapper customerMapper;
    private final ThirdLoginBiz thirdLoginBiz;
    private final CustomerAccountMapper customerAccountMapper;
    private final SystemParamMapper systemParamMapper;
    private final CustomerPointMapper customerPointMapper;
    private final JedisService jedisService;
    @Value("${message_effective_time}")
    private int message_effective_time;
    @Value("${inviteCode}")
    private boolean inviteCode;
    @Value("${off_line}")
    private boolean off_line;

    public RegisterBiz(CustomerMapper customerMapper, ThirdLoginBiz thirdLoginBiz, CustomerAccountMapper customerAccountMapper, SystemParamMapper systemParamMapper, CustomerPointMapper customerPointMapper, JedisService jedisService) {
        this.customerMapper = customerMapper;
        this.thirdLoginBiz = thirdLoginBiz;
        this.customerAccountMapper = customerAccountMapper;
        this.systemParamMapper = systemParamMapper;
        this.customerPointMapper = customerPointMapper;
        this.jedisService = jedisService;
    }

    /**
     * 注册
     *
     * @param reqRegister
     * @param session
     * @return
     */
    @Transactional
    public synchronized TypeJsonResult<Customer> customerRegiser(ReqRegister reqRegister, HttpSession session) {
        try {
            TypeJsonResult typeJsonResult = new TypeJsonResult();
            JsonResult jsonResult = new JsonResult(false);
            logger.info(JSON.toJSONString(reqRegister));


            Object invitePhonePbj = session.getAttribute(INVITE_PHONE);
            if (null != invitePhonePbj) {
                reqRegister.setInviteCode(invitePhonePbj.toString());
            }

            if (StringUtils.isNotEmpty(reqRegister.getInviteCode())) {
                int countInvite = customerMapper.existCustId(reqRegister.getInviteCode());
                if (countInvite <= 0) {

                    typeJsonResult.setStatusCode(false);
                    typeJsonResult.setMessage("邀请码不存在");
                    return typeJsonResult;
                }
//                if (reqRegister.getInviteCode().equals(reqRegister.getPhone())) {
//                    jsonResult.setStatusCode(false);
//                    jsonResult.setMessage("邀请码人不能是自己");
//                    return jsonResult;
//
//                }
            }
            //1-微信 2-qq 3-微博
//            reqRegister.setRegType((byte) 1);
            if (null != reqRegister.getRegType()) {
                if (reqRegister.getRegType().intValue() == 1) {
                    boolean flag = thirdLoginBiz.checkWxByOpenIdAndToken(reqRegister.getOpenId(), reqRegister.getAccessToken());
                    if (!flag) {
                        typeJsonResult.setMessage("绑定微信的token失效，请重新获取");
                        return typeJsonResult;
                    }
                }
                if (reqRegister.getRegType().intValue() == 2) {
                    boolean flag = thirdLoginBiz.checkQqByOpenIdAndToken(reqRegister.getOpenId(), reqRegister.getAccessToken());
                    if (!flag) {
                        typeJsonResult.setMessage("绑定qq的token失效，请重新获取");
                        return typeJsonResult;
                    }
                }
            } else {
                if (null == reqRegister.getRegType()) {
                    if (StringUtils.isBlank(reqRegister.getLoginPwd())) {
                        typeJsonResult.setMessage("密码不能为空");
                        return typeJsonResult;
                    }
                }
            }


            String serverPhone = (String) session.getAttribute(HhmConstants.TARGET_NUMBER);
            //session有没有过期判断
            SessionUtils.handleSesseionValid(jsonResult, session, message_effective_time, off_line);
            if (!jsonResult.getStatusCode()) {
                typeJsonResult.setMessage(jsonResult.getMessage());
                return typeJsonResult;
            }
            //验证码正确性校验
            jsonResult = handlerPhone(jsonResult, serverPhone, reqRegister, session, HhmConstants.PRE_FIX_PHONE_REG);
            if (!jsonResult.getStatusCode()) {
                typeJsonResult.setMessage(jsonResult.getMessage());
                return typeJsonResult;
            }


            // 查询手机号 是否已被注册
            int count = customerMapper.existCustomerByPhone(reqRegister.getPhone());
            if (count > 0) {
                if (null != reqRegister.getRegType()) {
                    Customer customer = customerMapper.getByPhone(reqRegister.getPhone());
                    if (null != customer) {
                        customer.setToken(UUIDUtils.genertateUuid32());
                        jedisService.refreshCustToken(customer.getCustId(), customer.getToken());
                        typeJsonResult.setType(customer);
                    }
                    if (reqRegister.getRegType().intValue() == 1) {
                        if (StringUtils.isNotEmpty(customer.getWechatId())) {
                            typeJsonResult.setMessage("微信绑定过了，不能再绑定");
                            return typeJsonResult;
                        }
                        Customer customerTemp = customerMapper.getByWechatId(reqRegister.getOpenId());
                        if (null != customerTemp) {
                            typeJsonResult.setMessage("微信openId已被被人绑定");
                            return typeJsonResult;
                        } else {
                            Customer customerUpadte = new Customer();
                            customerUpadte.setCustId(customer.getCustId());
                            if (StringUtils.isEmpty(customer.getNickName())) {
                                customerUpadte.setNickName(reqRegister.getOpenData());
                            }
                            customerUpadte.setLoginPwd(reqRegister.getLoginPwd());
                            customerUpadte.setWechatData(reqRegister.getOpenData());
                            customerUpadte.setWechatId(reqRegister.getOpenId());

                            int countUpdate = customerMapper.updateByPrimaryKeySelective(customerUpadte);
                            if (countUpdate == 1) {

                                typeJsonResult.setStatusCode(true);
                            } else {
                                typeJsonResult.setStatusCode(false);
                                typeJsonResult.setMessage("微信绑定失败");
                            }
                            return typeJsonResult;
                        }
                    }
                    if (reqRegister.getRegType().intValue() == 2) {
                        Customer customerTemp = customerMapper.getByQqId(reqRegister.getOpenId());
                        if (StringUtils.isNotEmpty(customer.getQqId())) {
                            typeJsonResult.setStatusCode(false);
                            typeJsonResult.setMessage("QQ绑定过了，不能再绑定");
                            return typeJsonResult;
                        }
                        if (null != customerTemp) {
                            typeJsonResult.setStatusCode(false);
                            typeJsonResult.setMessage("QQopenId已被被人绑定");
                            return typeJsonResult;
                        } else {
                            Customer customerUpadte = new Customer();
                            customerUpadte.setCustId(customer.getCustId());
                            if (StringUtils.isEmpty(customer.getNickName())) {
                                customerUpadte.setNickName(reqRegister.getOpenData());
                            }
                            customerUpadte.setQqJson(reqRegister.getOpenData());
                            customerUpadte.setQqId(reqRegister.getOpenId());
                            int countUpdate = customerMapper.updateByPrimaryKeySelective(customerUpadte);
                            if (countUpdate == 1) {
                                typeJsonResult.setStatusCode(true);
                            } else {
                                typeJsonResult.setStatusCode(false);
                                typeJsonResult.setMessage("qq绑定失败");
                            }
                            return typeJsonResult;

                        }

                    }
                    if (reqRegister.getRegType().intValue() == 3) {
                        Customer customerTemp = customerMapper.getBySinaId(reqRegister.getOpenId());
                        if (StringUtils.isNotEmpty(customer.getSinaId())) {
                            typeJsonResult.setStatusCode(false);
                            typeJsonResult.setMessage("微博绑定过了，不能再绑定");
                            return typeJsonResult;
                        }
                        if (null != customerTemp) {
                            typeJsonResult.setStatusCode(false);
                            typeJsonResult.setMessage("微博openId已被被人绑定");
                            return typeJsonResult;
                        } else {
                            Customer customerUpadte = new Customer();
                            customerUpadte.setCustId(customer.getCustId());
                            if (StringUtils.isEmpty(customer.getNickName())) {
                                customerUpadte.setNickName(reqRegister.getOpenData());
                            }
                            customerUpadte.setSinaJson(reqRegister.getOpenData());
                            customerUpadte.setSinaId(reqRegister.getOpenId());
                            int countUpdate = customerMapper.updateByPrimaryKeySelective(customerUpadte);
                            if (countUpdate == 1) {
                                typeJsonResult.setStatusCode(true);
                            } else {
                                typeJsonResult.setStatusCode(false);
                                typeJsonResult.setMessage("sina绑定失败");
                            }
                            return typeJsonResult;
                        }
                    }
                } else {
                    typeJsonResult.setStatusCode(false);
                    typeJsonResult.setMessage("该账号已被注册");
                    return typeJsonResult;
                }

            }

            // 注册
            Customer customer = new Customer();
            int rgCount = doRegister(reqRegister, customer);
            typeJsonResult.setType(customer);
            if (rgCount == 1) {
                typeJsonResult.setStatusCode(true);
            } else {
                typeJsonResult.setStatusCode(false);
                typeJsonResult.setMessage("注册失败");
            }
            return typeJsonResult;
        } catch (Exception e) {
            throw new HuhuaminException("注册异常", e);
        }
    }




    /**
     * 注册(不需要手机号码)
     *
     * @param reqRegister
     * @param session
     * @return
     */
    @Transactional
    public synchronized TypeJsonResult<Customer> customerRegiserNoPhone(ReqRegisterNophone reqRegister, HttpSession session) {
        try {
            TypeJsonResult typeJsonResult = new TypeJsonResult();
            JsonResult jsonResult = new JsonResult(false);
            logger.info(JSON.toJSONString(reqRegister));

            Object invitePhonePbj = session.getAttribute(INVITE_PHONE);
            if (null != invitePhonePbj) {
                reqRegister.setInviteCode(invitePhonePbj.toString());
            }

            if (StringUtils.isNotEmpty(reqRegister.getInviteCode())) {
                int countInvite = customerMapper.existCustId(reqRegister.getInviteCode());
                if (countInvite <= 0) {

                    typeJsonResult.setStatusCode(false);
                    typeJsonResult.setMessage("邀请码不存在");
                    return typeJsonResult;
                }
            }
            //1-微信 2-qq 3-微博
//            reqRegister.setRegType((byte) 1);
            if (null != reqRegister.getRegType()) {
                if (reqRegister.getRegType().intValue() == 1) {
                    boolean flag = thirdLoginBiz.checkWxByOpenIdAndToken(reqRegister.getOpenId(), reqRegister.getAccessToken());
                    if (!flag) {
                        typeJsonResult.setMessage("绑定微信的token失效，请重新获取");
                        return typeJsonResult;
                    }
                }
                if (reqRegister.getRegType().intValue() == 2) {
                    boolean flag = thirdLoginBiz.checkQqByOpenIdAndToken(reqRegister.getOpenId(), reqRegister.getAccessToken());
                    if (!flag) {
                        typeJsonResult.setMessage("绑定qq的token失效，请重新获取");
                        return typeJsonResult;
                    }
                }
            } else {
                if (null == reqRegister.getRegType()) {
                    if (StringUtils.isBlank(reqRegister.getLoginPwd())) {
                        typeJsonResult.setMessage("密码不能为空");
                        return typeJsonResult;
                    }
                }
            }

            // 注册
            Customer customer = new Customer();

            String phone=reqRegister.getPhone();
            if(StringUtils.isBlank(phone)){
                reqRegister.setPhone("");
            }
            ReqRegister register1=new ReqRegister();
            BeanUtils.copyProperties(reqRegister,register1);
            int rgCount = doRegister(register1, customer);
            typeJsonResult.setType(customer);
            if (rgCount == 1) {
                typeJsonResult.setStatusCode(true);
            } else {
                typeJsonResult.setStatusCode(false);
                typeJsonResult.setMessage("注册失败");
            }
            return typeJsonResult;
        } catch (Exception e) {
            throw new HuhuaminException("注册异常", e);
        }
    }


    /**
     * 公共部分，手机验证码验证处理
     *
     * @param serverPhone
     * @param reqRegister
     * @return
     */
    private JsonResult handlerPhone(JsonResult jsonResult, String serverPhone, ReqRegister reqRegister, HttpSession session, String preFix) {
        jsonResult.setStatusCode(false);
        String serverPhoneCode = (String) session.getAttribute(preFix.concat(HhmConstants.VALID_CODE));
        if (StringUtils.isBlank(serverPhoneCode)) {
            jsonResult.setStatusCode(false);
            jsonResult.setMessage("验证码未发送或无效，请重新发送");
            return jsonResult;
        }
        if (!serverPhoneCode.equalsIgnoreCase(reqRegister.getPhoneCode())) {
            jsonResult.setStatusCode(false);
            jsonResult.setMessage("请输入正确的验证码");
            return jsonResult;
        }
        if (!serverPhone.equalsIgnoreCase(reqRegister.getPhone())) {
            jsonResult.setStatusCode(false);
            jsonResult.setMessage("发送与提交手机号不一样");
            return jsonResult;
        }

        jsonResult.setStatusCode(true);
        return jsonResult;

    }


    /**
     * 注册用户
     *
     * @param reqRegister
     * @return
     */
    @Transactional
    public int doRegister(ReqRegister reqRegister, Customer customer) {
        Date now = new Date();
        String custId = UUIDUtils.generateUuid22();

        if(reqRegister.getLoginPwd()!=null){
            String loginPwd = DigestUtils.md5DigestAsHex(reqRegister.getLoginPwd().getBytes());
            customer.setLoginPwd(loginPwd);
        }
        customer.setCustPhone(reqRegister.getPhone());
        if (null == reqRegister.getRegisterSource()) {
            customer.setRegistSource((byte) 1);
        } else {
            customer.setRegistSource(reqRegister.getRegisterSource().byteValue());
        }

        customer.setRegistTime(new Date());
        customer.setCustId(custId);
        customer.setInviteCode(reqRegister.getInviteCode());
        customer.setCustType(1);




        if (null != reqRegister.getRegType()) {
//            customer.setNickName(reqRegister.getOpenData());
            //1-微信 2-qq 3-微博
            if (reqRegister.getRegType().intValue() == 1) {
                customer.setWechatId(reqRegister.getOpenId());
                customer.setWechatData(reqRegister.getOpenData());

                customer.setHeadImg(JSON.parseObject(reqRegister.getOpenData()).get("headimgurl").toString());
                customer.setLoginName(JSON.parseObject(reqRegister.getOpenData()).get("nickname").toString());
                customer.setNickName(JSON.parseObject(reqRegister.getOpenData()).get("nickname").toString());
            }else if (reqRegister.getRegType().intValue() == 2) {
                customer.setQqId(reqRegister.getOpenId());
                customer.setQqJson(reqRegister.getOpenData());

                customer.setHeadImg(JSON.parseObject(reqRegister.getOpenData()).get("figureurl_qq_2").toString());
                customer.setLoginName(JSON.parseObject(reqRegister.getOpenData()).get("nickname").toString());
                customer.setNickName(JSON.parseObject(reqRegister.getOpenData()).get("nickname").toString());
            }else if (reqRegister.getRegType().intValue() == 3) {
                customer.setSinaId(reqRegister.getOpenId());
                customer.setSinaJson(reqRegister.getOpenData());
            }else{
                customer.setLoginName(reqRegister.getPhone());
                customer.setNickName(reqRegister.getPhone());
            }
        }else{
            customer.setLoginName(reqRegister.getPhone());
            customer.setNickName(SessionUtils.phoneEncryption(reqRegister.getPhone()));
        }

        customer.setRegistTime(now);

        customer.setCustSex((byte) 3);
        customer.setConsumePoint(0.00d);//用于现金月
        customer.setCxyPoint(0.00d);//预留
        customer.setDeductionPoint(0.00d);//抵扣
        customer.setFreezeStatus((byte) 4);
        customer.setIsUserAgreement((byte) 1);
        customer.setAuthStatus((byte) 2);
        //邀请人
//        if (StringUtils.isNotEmpty(reqRegister.getInviteCode())) {
//            customer.setInviterCode(reqRegister.getInviteCode());
//        }

        CustomerAccount customerAccountSave = new CustomerAccount();
        customerAccountSave.setAddTime(now);
        customerAccountSave.setUpdateTime(now);
        customerAccountSave.setCustId(custId);
        customerAccountSave.setLoginName(reqRegister.getPhone());
        customerAccountSave.setCashPoint(0.00d);
        customerAccountSave.setConsumeRmb(0.00d);
        customerAccountSave.setCxPoint(0.00d);
        customerAccountSave.setTotalFoucusCount(0);
        customerAccountSave.setSelfBuyCount(0.00d);
        if (StringUtils.isNotEmpty(reqRegister.getInviteCode())) {
            customer.setInviterCode(reqRegister.getInviteCode());

            CustomerAccount customerAccount = customerAccountMapper.selectByPrimaryKey(reqRegister.getInviteCode());
            if (null != customerAccount) {
                //处理邀请关系
                if (StringUtils.isNotEmpty(customerAccount.getInvitePath())) {
                    customerAccountSave.setInvitePath(customerAccount.getInvitePath().concat(",").concat(custId));
                } else {
                    customerAccountSave.setInvitePath(custId);
                }
                customerAccountSave.setTopUserId(customerAccount.getCustId());
            } else {
                customerAccountSave.setInvitePath(custId);
                customerAccountSave.setTopUserId(custId);
            }
        } else {
            customerAccountSave.setInvitePath(custId);
            customerAccountSave.setTopUserId(custId);
        }
        customerAccountSave.setTotalPoint(0.00d);
        customerAccountSave.setCashPoint(0.00d);
        customerAccountSave.setCxPoint(0.00d);
        customerAccountSave.setShopPoint(0.00d);
        customerAccountSave.setConsumeRmb(0.00d);

        customerAccountSave.setSurplusTotalPoint(0.00d);
        customerAccountSave.setSurplusCashPoint(0.00d);
        customerAccountSave.setSurplusCxPoint(0.00d);
        customerAccountSave.setSurplusShopPoint(0.00d);

        customerAccountSave.setYetTotalPoint(0.00d);
        customerAccountSave.setYetCashPoint(0.00d);
        customerAccountSave.setYetCxPoint(0.00d);
        customerAccountSave.setYetShopPoint(0.00d);
        customerAccountSave.setRecoBuyCount(0);
        customerAccountSave.setSelfBuyCount(0.00d);

        int result = customerAccountMapper.insert(customerAccountSave);
        if (result == 0) {
            throw new HuhuaminException("在注册过程中,系统开小差了！！！");
        }
        sendPoint(reqRegister.getInviteCode(), customer, SystemParamBiz.POINT_NUM_REGISTER, SystemParamBiz.CONSUMER_NUM_REGISTER, customerMapper, systemParamMapper, customerPointMapper, customerAccountMapper);

        //customer.setOnlineFlag((byte) 1);
        result = customerMapper.insert(customer);
        if (result > 0) {
            customer.setToken(UUIDUtils.genertateUuid32());
            jedisService.refreshCustToken(customer.getCustId(), customer.getToken());
        }
        return result;
    }

    /**
     * 前台商户账号注册
     * @param account
     * @param pwd
     * @param custId
     * @param shopId
     */
    @Transactional
    public void doRegisterTest(String account,String pwd,String custId,String shopId) {
        Customer customer=new Customer();
         Date now = new Date();
        customer.setLoginPwd(DigestUtils.md5DigestAsHex(pwd.getBytes()));
        customer.setRegistTime(new Date());
        customer.setCustId(custId);
        customer.setInviteCode(custId);
        customer.setCustType(7); //客户类型[1-普通会员  7-商家 9-合作管理 11-县(区)管理 15-省级代理 16-合伙人]
        customer.setDataPerm(shopId);
        customer.setLoginName(account);
        customer.setNickName(account);
        customer.setCustPhone(account);
        customer.setRegistTime(now);
        customer.setCustSex((byte) 3);
        customer.setConsumePoint(0.00d);//用于现金月
        customer.setCxyPoint(0.00d);//预留
        customer.setDeductionPoint(0.00d);//抵扣
        customer.setFreezeStatus((byte) 4);
        customer.setIsUserAgreement((byte) 1);
        customer.setAuthStatus((byte) 2);
        customer.setOnlineFlag((byte) 1);//是否赠送[1-未赠送 2-已赠送余额 3-已赠送积分]
        // sendPoint(custId, customer, SystemParamBiz.POINT_NUM_REGISTER, SystemParamBiz.CONSUMER_NUM_REGISTER, customerMapper, systemParamMapper, customerPointMapper, customerAccountMapper);
        int  result = customerMapper.insert(customer);
        if (result != 1) {
            throw new HuhuaminException("注册失败！");
        }

        CustomerAccount customerAccountSave = new CustomerAccount();
        customerAccountSave.setAddTime(now);
        customerAccountSave.setUpdateTime(now);
        customerAccountSave.setCustId(custId);
        customerAccountSave.setLoginName(account);
        customerAccountSave.setCashPoint(0.00d);
        customerAccountSave.setConsumeRmb(0.00d);
        customerAccountSave.setCxPoint(0.00d);
        customerAccountSave.setTotalFoucusCount(0);
        customerAccountSave.setSelfBuyCount(0.00d);

        customerAccountSave.setInvitePath(custId);
        customerAccountSave.setTopUserId(custId);

        customerAccountSave.setTotalPoint(0.00d);
        customerAccountSave.setCashPoint(0.00d);
        customerAccountSave.setCxPoint(0.00d);
        customerAccountSave.setShopPoint(0.00d);
        customerAccountSave.setConsumeRmb(0.00d);

        customerAccountSave.setSurplusTotalPoint(0.00d);
        customerAccountSave.setSurplusCashPoint(0.00d);
        customerAccountSave.setSurplusCxPoint(0.00d);
        customerAccountSave.setSurplusShopPoint(0.00d);

        customerAccountSave.setYetTotalPoint(0.00d);
        customerAccountSave.setYetCashPoint(0.00d);
        customerAccountSave.setYetCxPoint(0.00d);
        customerAccountSave.setYetShopPoint(0.00d);
        customerAccountSave.setRecoBuyCount(0);
        customerAccountSave.setSelfBuyCount(0.00d);

        result = customerAccountMapper.insert(customerAccountSave);
        if (result != 1) {
            throw new HuhuaminException("注册账号失败！！！！");
        }

    }

    /**
     * @param inviterCoder        邀请人id，
     * @param customer            出发源customer
     * @param pointTp             积分类型
     * @param comsumerTp          消费烈性
     * @param customerMapper
     * @param systemParamMapper
     * @param customerPointMapper
     * @return
     */
    @Transactional
    public static SystemParam sendPoint(String inviterCoder, Customer customer, String pointTp, String comsumerTp, CustomerMapper customerMapper, SystemParamMapper systemParamMapper, CustomerPointMapper customerPointMapper,CustomerAccountMapper customerAccountMapper) {
        int result = 0;//赠送邀请人积分或者余额
        if (StringUtils.isNotBlank(inviterCoder)) {
            Integer flag = customerMapper.selectFalgByInviterCode(customer.getCustId());
            //数据库字段：是否赠送[1-未赠送 2-已替上级赠送余额 3-已替上级赠送积分]dcdg_bussiness_customer_base.ONLINE_FLAG
            if (null == flag || 1 == flag) {  //赠送积分
                SystemParam systemParamPoint = systemParamMapper.selectByIndex(pointTp);
                CustomerPoint customerPoint = new CustomerPoint();

                if (null != systemParamPoint && !systemParamPoint.getParamValue().trim().equals("0")) {

                    gainType1Init(inviterCoder, "", Double.valueOf(systemParamPoint.getParamValue()), customerPoint);
                    customerPoint.setPointMold((byte) 1);//类型【1-积分 2-余额】
                    //资源类型[1-商城订单 2-其他订单 3-邀请注册赠送 4-邀请首次消费赠送 5-游戏 6-签到积分 7-系统赠送]
                    customerPoint.setSourceType((byte) 3);//[1-余额 3-积分]
                    customerPoint.setPointDesc("邀请好友获得积分" + systemParamPoint.getParamValue());
                    customerPoint.setPointType((byte) 3);//积分类型[1-余额 3-积分]
                    result = customerPointMapper.insert(customerPoint);
                    if (result == 0) {
                        throw new HuhuaminException("邀请好友获得积分记录失败");
                    }

                    Double versionDeductionPoint = customerMapper.getDeductionPointByCustId(inviterCoder);
                    result = customerMapper.updatePlusDeductionPointBydVersionDeductionPointAndCustId(inviterCoder, customerPoint.getPointValue(), versionDeductionPoint);
                    if (result == 0) {
                        throw new HuhuaminException("签到更新主账号1表失败");
                    }

                    result = customerAccountMapper.updatePlusDeductionPointBydVersionDeductionPointAndCustId(inviterCoder, customerPoint.getPointValue(), versionDeductionPoint);
                    if (result == 0) {
                        throw new HuhuaminException("签到更新主账号2表失败");
                    }
                    customer.setOnlineFlag((byte) 3);//[1-未赠送 2-已替上级赠送余额 3-已替上级赠送积分]

                    return systemParamPoint;
                } else {  //赠送余额
                    SystemParam systemParamComsumer = systemParamMapper.selectByIndex(comsumerTp);

                    if (null != systemParamComsumer && !systemParamComsumer.getParamValue().trim().equals("0")) {

                        gainType1InitForConsumePoint(inviterCoder, "", Double.valueOf(systemParamComsumer.getParamValue()), customerPoint);
                        customerPoint.setPointDesc("邀请好友获得余额" + systemParamPoint.getParamValue());
                        customerPoint.setPointType((byte) 1);//积分类型[1-余额 3-积分]
                        result = customerPointMapper.insert(customerPoint);
                        if (result == 0) {
                            throw new HuhuaminException("邀请好友获得余额记录失败");
                        }

                        result =customerMapper.addConsumePoint(inviterCoder,Double.valueOf(systemParamComsumer.getParamValue()));
                        if (result == 0) {
                            throw new HuhuaminException("在注册送余额过程中,系统开小差了！！！");
                        }
                        customer.setOnlineFlag((byte) 2);//[1-未赠送 2-已替上级赠送余额 3-已替上级赠送积分]


                        return systemParamPoint;
                    }

                }
            }

        }
        return null;
    }


    /**
     * @param inviterCoder        邀请人id，
     * @param customer            出发源customer
     * @param pointTp             积分类型
     * @param comsumerTp          消费烈性
     * @param customerMapper
     * @param systemParamMapper
     * @param customerPointMapper
     * @return
     */
    public static SystemParam sendPointByPay(String  orderId,String inviterCoder, Customer customer, String pointTp, String comsumerTp, CustomerMapper customerMapper, SystemParamMapper systemParamMapper, CustomerPointMapper customerPointMapper) {
        int result = 0;//赠送邀请人积分或者余额
        if (StringUtils.isNotBlank(inviterCoder)) {
            Integer flag = customerMapper.selectFalgByInviterCode(customer.getCustId());
            //数据库字段：是否赠送[1-未赠送 2-已替上级赠送余额 3-已替上级赠送积分]dcdg_bussiness_customer_base.ONLINE_FLAG
            if (null == flag || 1 == flag) {  //赠送积分
                SystemParam systemParamPoint = systemParamMapper.selectByIndex(pointTp);
                CustomerPoint customerPoint = new CustomerPoint();
                customerPoint.setSourceType((byte) 3);
                if (null != systemParamPoint && !systemParamPoint.getParamValue().trim().equals("0")) {
                    gainType1Init(inviterCoder, "", Double.valueOf(systemParamPoint.getParamValue()), customerPoint);
                    customerPoint.setPointDesc("邀请好友获得积分" + systemParamPoint.getParamValue());
                    customerPoint.setPointType((byte) 3);//积分
                    result = customerPointMapper.insert(customerPoint);
                    if (result == 0) {
                        throw new HuhuaminException("在注册过程中,系统开小差了！！！");
                    }
                    customer.setOnlineFlag((byte) 3);//[1-未赠送 2-已替上级赠送余额 3-已替上级赠送积分]
                    return systemParamPoint;
                } else {//赠送余额
                    SystemParam systemParamComsumer = systemParamMapper.selectByIndex(pointTp);
                    if (null != systemParamComsumer && !systemParamPoint.getParamValue().trim().equals("0")) {
                        gainType1Init(inviterCoder, "", Double.valueOf(systemParamComsumer.getParamValue()), customerPoint);
                        customerPoint.setPointDesc("邀请好友获得余额" + systemParamComsumer.getParamValue());
                        customerPoint.setPointType((byte) 1);//余额
                        result = customerPointMapper.insert(customerPoint);
                        if (result == 0) {
                            throw new HuhuaminException("在注册过程中,系统开小差了！！！");
                        }

                        //  gainType1InitForConsumePoint(inviterCoder, "", Double.valueOf(systemParamComsumer.getParamValue()), customerPoint);

                        customerPoint.setGainType((byte) 2);//消费
                        customerPoint.setCustId(inviterCoder);
                        customerPoint.setSourceId(orderId);
                        customerPoint.setPointId(UUIDUtils.generateUuid22());
                        customerPoint.setPointValue(Double.valueOf(systemParamComsumer.getParamValue()));
                        customerPoint.setAddTime(new Date());
                        customerPoint.setAuditStatus((byte) 2);
                        customerPoint.setAuditTime(customerPoint.getAddTime());
                        customerPoint.setAuditUser("system");
                        customerPoint.setAuditUserName("system");
                        customerPoint.setSourceType((byte) 1);//1-商城订单
                        customerPoint.setPointMold((byte) 2);

                        customerPoint.setPointDesc("邀请好友获得余额" + systemParamPoint.getParamValue());
                        customerPoint.setPointType((byte) 1);//积分类型[1-余额 3-积分]
                        result = customerPointMapper.insert(customerPoint);
                        if (result == 0) {
                            throw new HuhuaminException("邀请好友获得余额记录失败");
                        }

                        customer.setOnlineFlag((byte) 2);//[1-未赠送 2-已替上级赠送余额 3-已替上级赠送积分]
                        return systemParamPoint;
                    }

                }
            }

        }
        return null;
    }

    private static void gainType1Init(String custId, String orderId, Double deMoney, CustomerPoint customerPoint) {
        customerPoint.setGainType((byte) 1);//获取
        customerPoint.setCustId(custId);
        customerPoint.setSourceId(orderId);
        customerPoint.setPointId(UUIDUtils.generateUuid22());
        customerPoint.setPointValue(deMoney);
        customerPoint.setAddTime(new Date());
        customerPoint.setAuditStatus((byte) 2);
        customerPoint.setAuditTime(customerPoint.getAddTime());
        customerPoint.setAuditUser("system");
        customerPoint.setAuditUserName("system");
        customerPoint.setSourceType((byte) 5);


    }

    private static void gainType1InitForConsumePoint(String custId, String orderId, Double deMoney, CustomerPoint customerPoint) {
        customerPoint.setGainType((byte) 1);//获取
        customerPoint.setCustId(custId);
        customerPoint.setSourceId(orderId);
        customerPoint.setPointId(UUIDUtils.generateUuid22());
        customerPoint.setPointValue(deMoney);
        customerPoint.setAddTime(new Date());
        customerPoint.setAuditStatus((byte) 2);
        customerPoint.setAuditTime(customerPoint.getAddTime());
        customerPoint.setAuditUser("system");
        customerPoint.setAuditUserName("system");
        customerPoint.setSourceType((byte) 3);
        customerPoint.setPointMold((byte) 2);


    }
}