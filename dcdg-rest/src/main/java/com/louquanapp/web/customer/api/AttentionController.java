package com.louquanapp.web.customer.api;


import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.CustomerAttentionBiz;
import com.louquanapp.req.ReqFavCountType;
import com.louquanapp.req.ReqToken;
import com.louquanapp.service.JedisService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/14 23:15
 * @Description:
 */
@RestController
@RequestMapping("/api/auth")
public class AttentionController {

    private final CustomerAttentionBiz carAttentionBiz;

    private final JedisService jedisService;

    public AttentionController(CustomerAttentionBiz carAttentionBiz, JedisService jedisService) {
        this.carAttentionBiz = carAttentionBiz;
        this.jedisService = jedisService;
    }


    /**
     * 点赞
     */
    @PostMapping("/doFav/{sourceId}")
    public JsonResult doFav(@PathVariable("sourceId") String sourceId, @RequestBody @Valid ReqFavCountType reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        Integer type=reqSource.getType()==null?2:reqSource.getType();
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return carAttentionBiz.addAttentionByType(sourceId, custId, type, null);
    }

    /**
     * 关注主播
     */
    @PostMapping("/doAttention/{sourceId}")
    public JsonResult addAttentionByType(@PathVariable("sourceId") String sourceId, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return carAttentionBiz.addAttentionByType(sourceId, custId, 4, null);
    }

    /**
     * 取消关注主播
     */
    @PostMapping("/doAttention/{sourceId}/{attentionId}")
    public JsonResult altdAttentionByType(@PathVariable("sourceId") String sourceId, @PathVariable("attentionId") String attentionId, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return carAttentionBiz.addAttentionByType(sourceId, custId, 4, attentionId);
    }


    /**
     * 进入直播间
     */
    @PostMapping("/doIn/{sourceId}")
    public JsonResult doIn(@PathVariable("sourceId") String sourceId, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return carAttentionBiz.addAttentionByType(sourceId, custId, 5, null);
    }

    /**
     * app进入游戏
     */
    @PostMapping("/appGameIn/{sourceId}")
    public JsonResult appGameIn(@PathVariable("sourceId") String sourceId, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return carAttentionBiz.addAttentionByType(sourceId, custId, 7, null);
    }


    /**
     * 出直播间
     */
    @PostMapping("/doOut/{sourceId}")
    public JsonResult doOut(@PathVariable("sourceId") String sourceId, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return carAttentionBiz.delAttentionByType(sourceId, custId, 5);
    }


}
