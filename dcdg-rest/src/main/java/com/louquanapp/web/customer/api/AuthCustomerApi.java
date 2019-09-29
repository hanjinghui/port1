package com.louquanapp.web.customer.api;

import com.alibaba.fastjson.JSON;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.biz.CustomerBiz;
import com.louquanapp.dao.model.Customer;
import com.louquanapp.dao.model.GoodsImages;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.*;
import com.louquanapp.service.JedisService;
import com.louquanapp.utils.OssFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

/**
 * @Author 胡化敏
 * @Description: 会员登录接口控制器
 * @Date Create  2019年03月26日15:19:27
 * @Modified By:
 * @Since:
 */
@RestController
@RequestMapping("/api/auth")
public class AuthCustomerApi {
    private final Logger logger = LoggerFactory.getLogger(AuthCustomerApi.class);

    private final CustomerBiz customerBiz;
    private final JedisService jedisService;


    public AuthCustomerApi(CustomerBiz customerBiz, JedisService jedisService) {
        this.customerBiz = customerBiz;
        this.jedisService = jedisService;
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
     * token获取客户信息
     *
     * @return
     */
    @PostMapping("/token")
    //3-Android 4-iOS
    public TypeJsonResult<Customer> tokenUserInfo(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) {
            TypeJsonResult<Customer> typeJsonResult = new TypeJsonResult<>();
            typeJsonResult.setStatusCode(false);
            typeJsonResult.setCode(jsonResult.getCode());
            typeJsonResult.setMessage(jsonResult.getMessage());
            return typeJsonResult;
        }
        TypeJsonResult<Customer> typeJsonResult = customerBiz.getByToken(reqSource.getToken());
        if (logger.isDebugEnabled()) {
            logger.debug(JSON.toJSONString(typeJsonResult));
        }


        return typeJsonResult;
    }


    /**
     * token获取客户信息
     *
     * @return
     */
    @PostMapping("/doLoginOut")
    //3-Android 4-iOS
    public JsonResult doLoginOut(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {

        return customerBiz.doLoginOut(reqSource.getToken());

    }

    /**
     * 修改昵称
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/updateUserInfo")
    public JsonResult updateUserInfo(@RequestBody @Valid ReqUserInfo reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        //必须有一个修改项
        if (
                StringUtils.isEmpty(reqSource.getNickName())
                        && StringUtils.isEmpty(reqSource.getRealName())
                        && StringUtils.isEmpty(reqSource.getHeadImg())
                        && null == reqSource.getBirthDate()
                        && StringUtils.isEmpty(reqSource.getAreaPath())
                        && StringUtils.isEmpty(reqSource.getRemark())
                        && StringUtils.isEmpty(reqSource.getIdCard())
                        && StringUtils.isEmpty(reqSource.getFrontIdCard())
                        && StringUtils.isEmpty(reqSource.getEndIdCard())
                        && null == reqSource.getCustSex()

        ) {
            jsonResult.setMessage("你没有提交修改内容");
            return jsonResult;
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(reqSource, customer);
        if (StringUtils.isNotEmpty(reqSource.getIdCard())
                || StringUtils.isNotEmpty(reqSource.getRealName())
                || StringUtils.isNotEmpty(reqSource.getFrontIdCard())
                || StringUtils.isNotEmpty(reqSource.getEndIdCard())) {
            if (StringUtils.isEmpty(reqSource.getIdCard())
                    || StringUtils.isEmpty(reqSource.getFrontIdCard())
                    || StringUtils.isEmpty(reqSource.getEndIdCard())
                    || StringUtils.isEmpty(reqSource.getRealName())
                    || null == reqSource.getCustSex()
            ) {
                jsonResult.setMessage("实名认证信息不完成;姓名,性别,证件号码,身份证正反面必须都填写");
                return jsonResult;
            }
            customer.setAuthTime(new Date());
            customer.setAuthStatus((byte) 5);

        }
        customer.setCustId(custId);

        jsonResult = customerBiz.updateCustomer(customer);
        if (logger.isDebugEnabled()) {
            logger.debug(JSON.toJSONString(jsonResult));
        }
        return jsonResult;
    }

    /**
     * 修改密码
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/updatePwd")
    public JsonResult updatePwd(HttpSession session, @RequestBody @Valid ReqUpdatePwd reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        reqSource.setStep(0);
        jsonResult = customerBiz.updatePwd(session, custId, reqSource);
        if (logger.isDebugEnabled()) {
            logger.debug(JSON.toJSONString(jsonResult));
        }
        return jsonResult;
    }


    /**F
     * 图片上传
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/upImg")
    public TypeJsonResult<String> upImg(@RequestBody @Valid ReqImg reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        String fileName = "";
        try {
            fileName = OssFormatUtils.singleImageOss(reqSource.getImg64());
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setMessage("上传头像到oss失败");
            return jsonResult;
        }
        if(null!=reqSource.getSourceType()){
            GoodsImages goodsImages=new GoodsImages();
            goodsImages.setImgId(UUIDUtils.generateUuid22());
            goodsImages.setSourceType(reqSource.getSourceType());
            goodsImages.setImgUrl("/" + fileName);
            goodsImages.setAddBy(custId);
            goodsImages.setAddTime(new Date());
            customerBiz.addImgUrl(goodsImages);
           jsonResult.setStatusCode(true);
            return jsonResult;
        }

        jsonResult.setType("/" + fileName);
        jsonResult.setStatusCode(true);
        if (logger.isDebugEnabled()) {
            logger.debug(JSON.toJSONString(jsonResult));
        }
        return jsonResult;
    }

    /**
     * 保存图片路径
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/saveImgUrl")
    public TypeJsonResult<String> saveImgUrl(@RequestBody @Valid ReqImgUrl reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
            GoodsImages goodsImages=new GoodsImages();
            goodsImages.setImgId(UUIDUtils.generateUuid22());
            goodsImages.setSourceType(reqSource.getSourceType());
            goodsImages.setImgUrl("/" + reqSource.getImgUrl());
            goodsImages.setAddBy(custId);
            goodsImages.setAddTime(new Date());
            customerBiz.addImgUrl(goodsImages);
            jsonResult.setStatusCode(true);
            return jsonResult;
    }

    /**
     * 图片列表
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/queryImgUrlBysourceTypeAndAddBy")
    public JsonResult queryImgUrlBysourceTypeAndAddBy(@RequestBody @Valid ReqGoodsImages reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.queryImgUrlBysourceTypeAndAddBy(reqSource, custId);
    }


    /**
     * 解绑第三方账号
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/untieOtherOpenId")
    public JsonResult untieOtherOpenId(@RequestBody @Valid ReqUntie reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        jsonResult = customerBiz.untieOtherOpenId(custId, reqSource);
        if (logger.isDebugEnabled()) {
            logger.debug(JSON.toJSONString(jsonResult));
        }
        return jsonResult;
    }

    /**
     * 绑定第三方账号
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/binOtherOpenId")
    public JsonResult binOtherOpenId(@RequestBody @Valid ReqBinOther reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        jsonResult = customerBiz.binOtherOpenId(custId, reqSource);
        if (logger.isDebugEnabled()) {
            logger.debug(JSON.toJSONString(jsonResult));
        }
        return jsonResult;
    }


    /**
     * 修改手机号
     *
     * @param session
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/doPhoneAlt")
    public JsonResult doPhoneAlt(HttpSession session, @RequestBody @Valid ReqPhoneAltPhoneCode reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        jsonResult = customerBiz.doPhoneAlt(reqSource, custId, session);
        return jsonResult;
    }


    /**
     * 修改手机号
     *
     * @param session
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/setPayPassword")
    public JsonResult setPayPassword(HttpSession session, @RequestBody @Valid ReqSetPayPassword reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        jsonResult = customerBiz.setPayPassword(reqSource, custId, session);
        return jsonResult;
    }

    /**
     * 修改支付密码
     *
     * @param session
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/updatePayPwd")
    public JsonResult updatePayPwd(HttpSession session, @RequestBody @Valid ReqUpdatePayPwd reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        jsonResult = customerBiz.updatePayPwd(session, custId, reqSource);
        return jsonResult;
    }

    /**
     * 身份认证方式修改支付密码
     *
     * @param session
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/validUpdatePayPwd")
    public JsonResult validUpdatePayPwd(HttpSession session, @RequestBody @Valid ReqValidUpdatePayPwd reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        jsonResult = customerBiz.updateValidPayPwd(session, custId, reqSource);
        return jsonResult;
    }


    /**
     *
     * 模糊查询用昵称列表
     * @param reqSource
     * @param bindingResult
     * @return
     * */
    @PostMapping("/nickNames")
    public JsonResult nickNames(@RequestBody @Valid ReqUserInfoPage reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.nickNames(reqSource,custId);
    }

    /**
     * 联通前后台商铺相关信息--增加和修改
     * @param reqSource
     * @param bindingResult
     * @return
     */
/*    @PostMapping("/linkUPAccount")
    public JsonResult linkUPAccount(@RequestBody @Valid ReqLinkUPAccountUpdate reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        jsonResult = customerBiz.linkUPAccountUpdate(reqSource, custId);
        return jsonResult;
    }*/
    /**
     * 查询用户积分或余额记录
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/customerPointOrBalance")
    public JsonResult customerPointOrBalance( @RequestBody @Valid ReqCustomerPointOrBalance reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        jsonResult = customerBiz.customerPointOrBalance(reqSource, custId);
        return jsonResult;
    }
    /**
     * 查询用户总积分或总余额
     * type[1-总余额 3-总积分]
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/customerPointOrBalanceCount/{type}")
    public TypeJsonResult customerPointOrBalanceCount( @PathVariable("type") Integer type,@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
       jsonResult = customerBiz.customerPointOrBalanceCount(type, custId);
        return jsonResult;
    }
}
