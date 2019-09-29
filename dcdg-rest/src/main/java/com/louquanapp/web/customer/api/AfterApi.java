package com.louquanapp.web.customer.api;

import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.CustomerBiz;
import com.louquanapp.biz.GoodsBiz;
import com.louquanapp.biz.OrderBiz;
import com.louquanapp.biz.UserBiz;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqDeniedAfterSale;
import com.louquanapp.req.ReqToken;
import com.louquanapp.req.ReqTokenPage;
import com.louquanapp.service.JedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/8/13 15:12
 * @description:
 */
@RestController
@RequestMapping("/api")
public class AfterApi {
    private final Logger logger = LoggerFactory.getLogger(AfterApi.class);
    private final UserBiz userBiz;
    private final JedisService jedisService;
    private final CustomerBiz customerBiz;
    private final GoodsBiz goodsBiz;
    private final OrderBiz orderBiz;

    public AfterApi(UserBiz userBiz, JedisService jedisService, CustomerBiz customerBiz,GoodsBiz goodsBiz,OrderBiz orderBiz) {
        this.userBiz = userBiz;
        this.jedisService = jedisService;
        this.customerBiz = customerBiz;
        this.goodsBiz = goodsBiz;
        this.orderBiz = orderBiz;
    }

    /**
     * 售后列表
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/afterSaleList")
    public JsonResult afterSaleList(@RequestBody @Valid ReqTokenPage reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (CustomerBiz.tokenDie(jsonResult, custId)) return jsonResult;
        return  orderBiz.afterSaleList(custId,reqSource);
    }

    /**
     * 售后详情
     * @param returnId
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/afterSaleDetail/{returnId}")
    public JsonResult afterSaleDetail(@PathVariable("returnId") String returnId, @RequestBody @Valid ReqTokenPage reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (CustomerBiz.tokenDie(jsonResult, custId)) return jsonResult;
        return  orderBiz.afterSaleDetail(custId,returnId);
    }

    /**
     * 拒绝售后服务
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/deniedAfterSale")
    public JsonResult deniedAfterSale(@RequestBody @Valid ReqDeniedAfterSale reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (CustomerBiz.tokenDie(jsonResult, custId)) return jsonResult;
        return  orderBiz.deniedAfterSale(custId,reqSource.getReturnId(),reqSource.getReplyCont());
    }

    /**
     * 同意售后服务
     * @param returnId
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/agreeAfterSale/{returnId}")
    public JsonResult agreeAfterSale(@PathVariable("returnId") String returnId, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (CustomerBiz.tokenDie(jsonResult, custId)) return jsonResult;
        return  orderBiz.agreeAfterSale(custId,returnId);
    }

    /**
     * 完成退货退款
     * @param returnId
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/completeAfterSale/{returnId}")
    public JsonResult completeAfterSale(@PathVariable("returnId") String returnId, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (CustomerBiz.tokenDie(jsonResult, custId)) return jsonResult;
        return  orderBiz.completeAfterSale(custId,returnId);
    }





}
