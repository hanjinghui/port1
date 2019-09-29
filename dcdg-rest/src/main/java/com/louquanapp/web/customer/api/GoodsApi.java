package com.louquanapp.web.customer.api;

import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.CustomerBiz;
import com.louquanapp.biz.GoodsBiz;
import com.louquanapp.biz.UserBiz;
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
 * @Date: 2019/8/12 14:20
 * @description:
 */
@RestController
@RequestMapping("/api")
public class GoodsApi {
    private final Logger logger = LoggerFactory.getLogger(GoodsApi.class);
    private final UserBiz userBiz;
    private final JedisService jedisService;
    private final CustomerBiz customerBiz;
    private final GoodsBiz goodsBiz;

    public GoodsApi(UserBiz userBiz, JedisService jedisService, CustomerBiz customerBiz,GoodsBiz goodsBiz) {
        this.userBiz = userBiz;
        this.jedisService = jedisService;
        this.customerBiz = customerBiz;
        this.goodsBiz = goodsBiz;
    }

    /**
     * 商品列表
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/goodsList")
    public JsonResult goodsList(@RequestBody @Valid ReqGoods reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        JsonResult type = goodsBiz.goodsList(custId,reqSource);
        return type;

    }

    /**
     * 商品列表总数
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/goodsListCount")
    public JsonResult goodsListCount(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        JsonResult type = goodsBiz.goodsListCount(custId);
        return type;

    }

    /**
     * 商品操作（上架，下架，删除）
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/goodsFlay")
    public JsonResult goodsFlay(@RequestBody @Valid ReqGoodsFlay reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        JsonResult type = goodsBiz.goodsFlay(custId,reqSource.getGoodsId(),reqSource.getFlay());
        return type;

    }

    /**
     * 查询商品级联类型
     * @param pId
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/goodsCascadeCatList/{pId}")
    public JsonResult goodsCascadeCatList(@PathVariable("pId") String pId, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return goodsBiz.goodsCascadeCatList(custId,pId);
    }

    /**
     * 增加或修改商品
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/addOrUpdateGoods")
    public JsonResult addGoods(@RequestBody @Valid ReqAddGoods reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return goodsBiz.addOrUpdateGoods(reqSource ,custId);
    }

    /**
     * 增加商品必须参数
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/goodsContent")
    public JsonResult goodsContent(@RequestBody @Valid ReqGoodsContent reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return goodsBiz.goodsContent(reqSource ,custId);
    }

    /**
     * 增加单层规格
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/addSingleKul")
    public JsonResult addSingleKul(@RequestBody @Valid ReqSingleSku reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return goodsBiz.addSingleKul(reqSource ,custId);
    }

    /**
     * 商品详情
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/busioness/goodsDetail/{goodsId}")
    public JsonResult goodsDetail(@PathVariable("goodsId")String goodsId,@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return goodsBiz.goodsDetail(goodsId ,custId);
    }

    /**
     * 修改商品
     * @param reqSource
     * @param bindingResult
     * @return
     */
   /* @PostMapping("/auth/busioness/updateGoods")
    public JsonResult updateGoods(@RequestBody @Valid ReqAddGoods reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (tokenDie(jsonResult, custId)) return jsonResult;
        return goodsBiz.updateGoods(reqSource ,custId);
    }*/









    public static boolean tokenDie(JsonResult jsonResult, String custId) {
        if (StringUtils.isEmpty(custId)) {
            jsonResult.setStatusCode(false);
            jsonResult.setMessage("token过期，重新登录");
            jsonResult.setCode(301);
            return true;
        }
        return false;
    }

}