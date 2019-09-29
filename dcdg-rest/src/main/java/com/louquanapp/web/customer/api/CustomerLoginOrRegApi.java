package com.louquanapp.web.customer.api;

import com.alibaba.fastjson.JSON;
import com.huhuamin.common.model.HhmConstants;
import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.CustomerBiz;
import com.louquanapp.biz.RegisterBiz;
import com.louquanapp.biz.ThirdLoginBiz;
import com.louquanapp.dao.model.Customer;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.*;
import com.louquanapp.utils.SendMessageClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @Author 胡化敏
 * @Description: 登录 注册 业务逻辑
 * @Date Create 2019年03月26日15:19:13
 * @Modified By:
 * @Since:
 */
@RestController
@RequestMapping("/api/no")
public class CustomerLoginOrRegApi {
    private final Logger logger = LoggerFactory.getLogger(CustomerLoginOrRegApi.class);
    private final ThirdLoginBiz thirdLoginBiz;
    private final CustomerBiz customerBiz;
    private final RegisterBiz registerBiz;
    @Value("${off_line}")
    private boolean off_line;

    public CustomerLoginOrRegApi(ThirdLoginBiz thirdLoginBiz, CustomerBiz customerBiz, RegisterBiz registerBiz) {
        this.thirdLoginBiz = thirdLoginBiz;
        this.customerBiz = customerBiz;
        this.registerBiz = registerBiz;
    }

    /**
     * 公共登录返回
     *
     * @param type
     * @return
     */
    public static TypeJsonResult<Customer> loginReturn(TypeJsonResult<Customer> type) {
        if (!type.getStatusCode()) {
            return type;
        } else {
            if (null == type.getType()) {
                type.setStatusCode(false);
                type.setCode(300);
                type.setMessage("没有绑定,前往注册");
            }
            return type;
        }
    }

    /**
     * 手机号发送验证码登陆
     */
    @PostMapping("/doLoginPhone")
    public TypeJsonResult<Customer> doLoginPhone(HttpSession session, @RequestBody @Valid ReqLoginPhone reqSource, BindingResult bindingResult) {
        TypeJsonResult<Customer> type = customerBiz.doLoginPhone(reqSource, session);
        if (logger.isDebugEnabled()) {
            logger.debug(JSON.toJSONString(type));
        }
        return type;

    }

    /**
     * 手机号密码登陆
     *
     * @return
     */
    @PostMapping("/doLoginPwd")
    public TypeJsonResult<Customer> doLogin(@RequestBody @Valid ReqLoginPwd reqSource, BindingResult bindingResult) {
        TypeJsonResult<Customer> type = customerBiz.getByPhoneAndPwd(reqSource);
        if (logger.isDebugEnabled()) {
            logger.debug(JSON.toJSONString(type));
        }
        return type;

    }


    /**
     * @return 微信登录
     */
    @PostMapping("/doLoginWx")
    //3-Android 4-iOS
    public TypeJsonResult<Customer> doLoginWx(@RequestBody @Valid ReqWxLogin reqSource, BindingResult bindingResult) {

        TypeJsonResult<Customer> type = new TypeJsonResult<>();
        boolean flag = thirdLoginBiz.checkWxByOpenIdAndToken(reqSource.getOpenId(), reqSource.getAccessToken());
        if (!flag) {
            type.setStatusCode(false);
            return type;
        }
        type = customerBiz.getByWxUserInfo(reqSource.getOpenId(), reqSource.getForce(), reqSource.getPushId());
        if (logger.isDebugEnabled()) {
            logger.debug(JSON.toJSONString(type));
        }
        return loginReturn(type);
    }

    /**
     * app qq登录
     *
     * @return
     */
    @PostMapping("/doLoginQq")
    //3-Android 4-iOS
    public TypeJsonResult<Customer> doLoginQq(@RequestBody @Valid ReqQqLogin reqSource, BindingResult bindingResult) {

        TypeJsonResult<Customer> type = new TypeJsonResult<>();
        boolean flag = thirdLoginBiz.checkQqByOpenIdAndToken(reqSource.getOpenId(), reqSource.getAccessToken());
        if (!flag) {
            type.setStatusCode(false);
            return type;
        }
        type = customerBiz.getByQqUserInfo(reqSource.getOpenId(), reqSource.getPushId());
        if (logger.isDebugEnabled()) {
            logger.debug(JSON.toJSONString(type));
        }
        return loginReturn(type);
    }


    /**
     * 注册
     *
     * @param session
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/doRegister")
    public JsonResult doRegister(HttpSession session, @RequestBody @Valid ReqRegister reqSource, BindingResult bindingResult) {

        //图文验证
//        jsonResult = ImgCodeAction.checkImageCode(session, reqRegister.getImgCode(), jsonResult);
//        if (!jsonResult.getStatusCode()) {
//            return jsonResult;
//        }
        JsonResult jsonResult = registerBiz.customerRegiser(reqSource, session);
        return jsonResult;
    }



    /**
     * 注册(不需要手机号码)
     *
     * @param session
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/doRegisterNoPhone")
    public JsonResult doRegisterNoPhone(HttpSession session, @RequestBody @Valid ReqRegisterNophone reqSource, BindingResult bindingResult) {

        //图文验证
//        jsonResult = ImgCodeAction.checkImageCode(session, reqRegister.getImgCode(), jsonResult);
//        if (!jsonResult.getStatusCode()) {
//            return jsonResult;
//        }




        JsonResult jsonResult = registerBiz.customerRegiserNoPhone(reqSource, session);
        return jsonResult;
    }

    /**
     * 发送短信验证码注册
     *
     * @param session
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/sendRegisterCode")
    public JsonResult sendRegisterCode(HttpSession session, @RequestBody @Valid ReqSendPhoneCode reqSource, BindingResult bindingResult) {

        JsonResult jsonResult = new JsonResult(false);
        //图文验证码校验
//        jsonResult = ImgCodeAction.checkImageCode(session, phone.getImgCode(), jsonResult);
//        if (!jsonResult.getStatusCode()) {
//            return jsonResult;
//        }
        //滑动验证码校验
//        jsonResult = DragImgCodeAction.checkDragImageCode(session, phone.getImgCode(), jsonResult);
//        if (!jsonResult.getStatusCode()) {
//            return jsonResult;
//        }
        String contentTemplate = "SMS_155270122";
        //String contentTemplate = "您的注册验证码为：#{valid_code}，请继续完成注册操作。(本短信仅用于北鼎教育验证，如非本人操作，请忽略)";
        String code = SendMessageClient.sendValidCode(session, reqSource.getPhone(), contentTemplate, HhmConstants.PRE_FIX_PHONE_REG);

        if (off_line) {
            jsonResult.setMessage(code);
        }
        jsonResult.setStatusCode(true);
        return jsonResult;
    }


    /**
     * 发送登录短信验证码
     *
     * @param session
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/sendLoginCode")
    public JsonResult sendLoginCode(HttpSession session, @RequestBody @Valid ReqSendPhoneCode reqSource, BindingResult bindingResult) {
        return sendRegisterCode(session, reqSource, bindingResult);
    }

    /**
     * 发送忘记密码验证码
     */
    @PostMapping("/sendForgetPwdCode")
    public JsonResult sendForgetPwdCode(HttpSession session, @RequestBody @Valid ReqForgetPwdCode reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);

        String contentTemplate = "SMS_155270122";
        String code = SendMessageClient.sendValidCode(session, reqSource.getPhone(), contentTemplate, HhmConstants.PRE_FIX_PHONE_FORGET);
        jsonResult.setStatusCode(true);
        if (off_line) {
            jsonResult.setMessage(code);
        }
        return jsonResult;
    }

    /**
     * 发送修改密码验证码  此项目未使用
     */
    @PostMapping("/sendUpdatePwdCode")
    public JsonResult sendUpdatePwdCode(HttpSession session, @RequestBody @Valid ReqForgetPwdCode reqSource, BindingResult bindingResult) {
        return sendForgetPwdCode(session, reqSource, bindingResult);
    }

    /**
     * 忘记密码 修改
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/updateForgetPwd")
    public JsonResult updateForgetPwd(HttpSession session, @RequestBody @Valid ReqForgetPwd reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = customerBiz.updateForgetPwd(session, reqSource);
        if (logger.isDebugEnabled()) {
            logger.debug(JSON.toJSONString(jsonResult));
        }
        return jsonResult;
    }

    /**
     * 发送修改手机号验证码
     */
    @PostMapping("/sendAltPhoneCode")
    public JsonResult sendAltPhoneCode(HttpSession session, @RequestBody @Valid ReqSendPhoneCode reqSource, BindingResult bindingResult) {
        return sendRegisterCode(session, reqSource, bindingResult);
    }

    /**
     * 发送校验实名认证手机号验证码接口
     */
    @PostMapping("/sendValidNameCode")
    public JsonResult sendValidNameCode(HttpSession session, @RequestBody @Valid ReqSendPhoneCode reqSource, BindingResult bindingResult) {
        return sendRegisterCode(session, reqSource, bindingResult);
    }

    /**
     * 测试
     */
    @PostMapping("/test")
    public JsonResult test(@RequestBody @Valid ReqComm reqSource, BindingResult bindingResult) {
      // customerBiz.test("13744444440",100) ;
        return  null;
    }

}
