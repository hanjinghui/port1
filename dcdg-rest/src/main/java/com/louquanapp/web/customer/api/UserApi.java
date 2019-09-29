package com.louquanapp.web.customer.api;

import com.alibaba.fastjson.JSON;
import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.CustomerBiz;
import com.louquanapp.biz.OrderBiz;
import com.louquanapp.biz.UserBiz;
import com.louquanapp.dao.model.SystemUser;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.*;
import com.louquanapp.service.JedisService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/7/12 17:36
 * @description:
 */
@RestController
@RequestMapping("/api")
public class UserApi {
    private final Logger logger = LoggerFactory.getLogger(UserApi.class);
    private final UserBiz userBiz;
    private final JedisService jedisService;
    private final CustomerBiz customerBiz;
    private final OrderBiz orderBiz;

    public UserApi(UserBiz userBiz, JedisService jedisService,CustomerBiz customerBiz,OrderBiz orderBiz) {
        this.userBiz = userBiz;
        this.jedisService = jedisService;
        this.customerBiz = customerBiz;
        this.orderBiz = orderBiz;
    }

    /**
     * 商户登录
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/no/busioness/loginByNameAndPwd")
    public JsonResult loginByNameAndPwd(@RequestBody @Valid ReqLogin reqSource, BindingResult bindingResult) {
        JsonResult type = userBiz.loginByNameAndPwd(reqSource);
        if (logger.isDebugEnabled()) {
            logger.debug(JSON.toJSONString(type));
        }
        return type;

    }

    /**
     * 修改密码
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/updateLoginPwd")
    public JsonResult updateLoginPwd(@RequestBody @Valid ReqUpdateLonginPwd reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        JsonResult type = userBiz.updateLoginPwd(reqSource.getNewPwd(),reqSource.getOldPwd(),custId);
        return type;

    }

    /**
     * token获取客户信息
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/token")
    public TypeJsonResult tokenUserInfo(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        TypeJsonResult<SystemUser> typeJsonResult = userBiz.getByToken(reqSource.getToken(),custId);
        if (logger.isDebugEnabled()) {
            logger.debug(JSON.toJSONString(typeJsonResult));
        }
        return typeJsonResult;
    }



    /**
     * 退出登录
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/doLoginOut")
    public JsonResult doLoginOut(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        return userBiz.doLoginOut(reqSource.getToken());
    }

    /**
     * 商铺详情
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/shopDetail")
    public TypeJsonResult shopDetail(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.shopDetail(custId);
    }

    /**
     * 商铺修改
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/shopUpdate")
    public JsonResult shopUpdate(@RequestBody @Valid ReqLinkUPAccountUpdate reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.shopUpdate(reqSource,custId);
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
     * 订单信息
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/orderInformation")
    public JsonResult orderInformation(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.orderInformation(custId);
    }

    /**
     * 推广返利列表
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/relationList")
    public JsonResult relationList(@RequestBody @Valid ReqRebatePage reqSource, BindingResult bindingResult) {
        /*JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.relationList(reqSource,custId);*/
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.relationList(reqSource,custId);
    }

    /**
     * 推广返利总和
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/totalUserRebate")
    public JsonResult totalUserRebate(@RequestBody @Valid ReqRebate reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.queryTotalUserRebateByUserId(custId,reqSource);
    }

    /**
     * 返利时间列表
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/rebateCurrentMonthList")
    public JsonResult currentMonthList(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.currentMonthList(custId);
    }

    /**
     * 推广返利规则
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/rebateRule")
    public JsonResult rebateRule(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.rebateRule(custId);
    }

    /**
     * 商户端推广客户列表
     * @param reqTokenPage
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/inviteCustList")
    public JsonResult rebateCustList(@RequestBody @Valid ReqTokenPage reqTokenPage, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqTokenPage.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.inviteCustList(reqTokenPage,custId);
    }



    /**
     * 结算推广返利
     * @param reqSource
     * @param bindingResult
     * @return
     */
 /*   @PostMapping("/auth/busioness/settlementRelation/{month}")
    public JsonResult settlementRelation(@PathVariable("month") String month,@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.settlementRelation(month,custId);
    }*/

    /**
     * 用户列表
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/custList")
    public JsonResult custList(@RequestBody @Valid ReqTokenPage reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.custList(reqSource);
    }

    /**
     * 结算记录月份列表
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/settlementMonthList")
    public JsonResult settlementMonthList(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.settlementMonthList(custId);
    }
    /**
     * 结算中或已结算列表
     * @param month
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/walletListBySettleStatus/{month}")
    public JsonResult walletListBySettleStatus(@PathVariable("month") String month,@RequestBody @Valid ReqTokenPage reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.walletListBySettleStatus(custId,reqSource,month);
    }

    /**
     * 钱包列表
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/walletList")
    public JsonResult walletList(@RequestBody @Valid ReqWalletPage reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.walletList(custId,reqSource);
    }

    /**
     * 钱包月份列表
     * @param reqSource
     * @param bindingResult
     * @return
     */
  /*  @PostMapping("/auth/busioness/walletMonthList")
    public JsonResult walletMonthList(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.walletMonthList(custId);
    }*/

    /**
     *商户综合可结算积分和及余额和
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/totalMoney")
    public JsonResult totalMoney(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.totalMoney(custId);
    }

    /**
     * 钱包结算说明
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/walletExplain")
    public JsonResult walletExplain(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.walletExplain(custId);
    }
    /**
     * 结算资金详情
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/ettlesdDetail/{moneyId}")
    public JsonResult ettlesdDetail(@PathVariable("moneyId") String moneyId ,@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.ettlesdDetail(custId,moneyId);
    }

    /**
     * 结算订单详情
     * @param moneyId
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/settlementInfoOrderDetail/{moneyId}")
    public JsonResult settlementInfoOrderDetail(@PathVariable("moneyId") String moneyId ,@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return orderBiz.settlementInfoOrderDetail(custId,moneyId);
    }


    @PostMapping("/auth/busioness/test")
    public JsonResult test(@RequestBody @Valid ReqRebate reqSource, BindingResult bindingResult) {
        return customerBiz.test(reqSource.getCurrentMonth());
    }




    /**
     * 用户所属商铺信息
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/userRelationShopList")
    public JsonResult userRelationShopList(@RequestBody @Valid ReqTokenPage reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.userRelationShopList(reqSource,custId);
    }

    /**
     * 增加子账号
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/addSubAccount")
    public JsonResult addSubAccount(@RequestBody @Valid ReqLinkUPAccountAdd reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return customerBiz.addSubAccount(reqSource,custId);
    }
}
