package com.louquanapp.web.order.api;

import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.OrderEvaluateBiz;
import com.louquanapp.dao.model.OrderEvaluate;
import com.louquanapp.model.PageJsonResult;
import com.louquanapp.req.*;
import com.louquanapp.service.JedisService;
import com.louquanapp.web.customer.api.AuthCustomerApi;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/10 15:27
 * @description:
 */
@RestController
@RequestMapping("/api")
public class OrderEvaluateController {
    private final OrderEvaluateBiz orderEvaluateBiz;
    private final JedisService jedisService;


    public OrderEvaluateController(OrderEvaluateBiz orderEvaluateBiz, JedisService jedisService) {
        this.orderEvaluateBiz = orderEvaluateBiz;
        this.jedisService = jedisService;
    }


    /**
     * 商品评论列表
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/evaluateList")
    public JsonResult evaluateList(@RequestBody @Valid ReqOrderEvaluate reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return orderEvaluateBiz.evaluateList(reqSource,custId);
    }
    /**
     * 评价详情
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/evaluateDetail/{evaluateId}")
    public JsonResult evaluateDetail(@PathVariable("evaluateId") String evaluateId,@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return orderEvaluateBiz.evaluateDetail(evaluateId,custId);
    }

    /**
     * 回复商品评论
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/replyEvaluate")
    public JsonResult replyEvaluate(@RequestBody @Valid ReqAddOrderEvaluate reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        //String  evaluateId,String userId,String replyCont
        return orderEvaluateBiz.replyEvaluate(reqSource.getEvaluateId(),custId,reqSource.getReplyCon());
    }





    @PostMapping("/auth/orderComment")
    public JsonResult orderComment(@RequestBody @Valid ReqOrderComment reqSource, BindingResult bindingResult) {

        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return orderEvaluateBiz.orderComment(reqSource, custId);
    }

    /**
     * 我的订单评论
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/myEvaluates")
    public JsonResult myEvaluates(@RequestBody @Valid ReqMyEvaluate reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return orderEvaluateBiz.myEvaluates(reqSource, custId);
    }

    /**
     * 查询订单评论
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/evaluate/{id}")
    public JsonResult evaluate(@PathVariable("id") String evaluateId, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return orderEvaluateBiz.evaluate(evaluateId, custId);
    }
}
