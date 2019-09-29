package com.louquanapp.web.basic.api;

import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.VideoPlaninfoBiz;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.*;
import com.louquanapp.service.JedisService;
import com.louquanapp.web.customer.api.AuthCustomerApi;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/10 19:37
 * @description:
 */
@RestController
@RequestMapping("/api/auth")
public class VideoPlaninfoController {
    private final VideoPlaninfoBiz videoPlaninfoBiz;
    private final JedisService jedisService;

    public VideoPlaninfoController(VideoPlaninfoBiz videoPlaninfoBiz, JedisService jedisService) {
        this.videoPlaninfoBiz = videoPlaninfoBiz;
        this.jedisService = jedisService;
    }


    /**
     * 增加直播间预定信息
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/addVideoPlaninfo")
    public JsonResult addVideoPlaninfo(@RequestBody @Valid ReqVideoPlaninfo reqSource, BindingResult bindingResult) {

        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;

        return videoPlaninfoBiz.addVideoPlaninfoBiz(reqSource,custId);
    }

    /**
     * 直播间预定信息列表
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/videoPlaninfos")// todo  添加商品名称
    public JsonResult videoPlaninfos(@RequestBody @Valid ReqVideoPlanList reqSource, BindingResult bindingResult) {

        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;

        return videoPlaninfoBiz.videoPlaninfos(reqSource,custId);
    }

    /**
     * 删除直播间预定信息
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/delOrUpdatePlanStatusForVideoPlaninfo/{planId}")
    public JsonResult delOrUpdatePlanStatusForVideoPlaninfo(@PathVariable("planId") String planId, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {

        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;

        return videoPlaninfoBiz.delOrUpdatePlanStatusForVideoPlaninfo(planId,custId);
    }

    /**
     * 预定信息的同意，拒绝，核销
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/planinfoUpdateStatus")
    public JsonResult planinfoUpdateStatus(@RequestBody @Valid ReqVideoPlaninfoOperation reqSource, BindingResult bindingResult) {

        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;

        return videoPlaninfoBiz.planinfoUpdateStatus(reqSource,custId);
    }

    /**
     * 直播间预定信息详情
     * @param id
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/videoPlaninfoDatail/{id}")
    public JsonResult videoPlaninfoDatail(@PathVariable("id") String id, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {

        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;

        return videoPlaninfoBiz.videoPlaninfoDatail(id,custId);
    }

    /**
     * 餐饮订单信息订单详情
     * @param id
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/promotionOrderDatail/{id}")
    public JsonResult promotionOrderDatail(@PathVariable("id") String id, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {

        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;

        return videoPlaninfoBiz.promotionOrderDatail(id,custId);
    }

    /*@PostMapping("goods/{id}")
    public TypeJsonResult<GoodsAndDetail> goodByGoodId(@PathVariable("id") String id, @RequestBody @Valid ReqGoodsSku reqSource, BindingResult bindingResult) {
        return goodsBiz.getGoodsByIdAndSkuId(id, reqSource);


    }*/

}
