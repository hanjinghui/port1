package com.louquanapp.web.order.api;

import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.CustomerAttentionBiz;
import com.louquanapp.biz.VideoEvaluateBiz;
import com.louquanapp.req.*;
import com.louquanapp.service.JedisService;
import com.louquanapp.web.customer.api.AuthCustomerApi;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/7/3 15:27
 * @description:
 */
@RestController
@RequestMapping("/api")
public class VideoEvaluateController {
    private final VideoEvaluateBiz videoEvaluateBiz;
    private final JedisService jedisService;
    private final CustomerAttentionBiz customerAttentionBiz;


    public VideoEvaluateController(VideoEvaluateBiz videoEvaluateBiz, JedisService jedisService, CustomerAttentionBiz customerAttentionBiz) {
        this.videoEvaluateBiz = videoEvaluateBiz;
        this.jedisService = jedisService;
        this.customerAttentionBiz = customerAttentionBiz;
    }

    /**
     * 视频评论列表
     *
     * @param reqQueryVideoEvaluate
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/videoEvaluates")
    public JsonResult videoEvaluates(@RequestBody @Valid ReqQueryVideoEvaluate reqQueryVideoEvaluate, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqQueryVideoEvaluate.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return videoEvaluateBiz.videoEvaluates(reqQueryVideoEvaluate,custId);
    }

    /**
     * 增加视频评论
     * @param reqVideoEvaluate
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/addVideoEvaluate")
    public JsonResult addVideoEvaluate(@RequestBody @Valid ReqVideoEvaluate reqVideoEvaluate, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqVideoEvaluate.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return videoEvaluateBiz.addVideoEvaluate(reqVideoEvaluate, custId);
    }

    /**
     * 增加视频评论点赞量
     * @param id
     * @param reqToken
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/addVideoEvaluateLikeCount/{id}")
    public JsonResult addVideoEvaluateLikeCount(@PathVariable("id") String id,@RequestBody @Valid ReqToken reqToken, BindingResult bindingResult) {

        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqToken.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return customerAttentionBiz.addVideoAttentionByType(id, custId,1);

    }

    /**
     * 取消视频评论点赞量
     * @param id
     * @param reqToken
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/cancelVideoEvaluateLikeCount/{id}")
    public JsonResult cancelVideoEvaluateLikeCount(@PathVariable("id") String id,@RequestBody @Valid ReqToken reqToken, BindingResult bindingResult) {

        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqToken.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return customerAttentionBiz.addVideoAttentionByType(id, custId,2);

    }



}
