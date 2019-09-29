package com.louquanapp.web.shop.api;

import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.GoodsBiz;
import com.louquanapp.dao.model.Goods;
import com.louquanapp.model.PageJsonResult;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.*;
import com.louquanapp.resp.GoodsAndDetail;
import com.louquanapp.resp.RespCateGood;
import com.louquanapp.service.JedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/3 08:00
 * @Description: 商品相关服务
 */
@RestController
@RequestMapping("/api/no")
public class GoodsController {
    private final GoodsBiz goodsBiz;
    private final JedisService jedisService;

    public GoodsController(GoodsBiz goodsBiz, JedisService jedisService) {
        this.goodsBiz = goodsBiz;
        this.jedisService = jedisService;
    }

    /**
     * 根据主键获取 默认商品
     *
     * @param id
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("goods/{id}")
    public TypeJsonResult<GoodsAndDetail> goodByGoodId(@PathVariable("id") String id, @RequestBody @Valid ReqGoodsSku reqSource, BindingResult bindingResult) {
        return goodsBiz.getGoodsByIdAndSkuId(id, reqSource);


    }

    @PostMapping("searchGoods")
    public PageJsonResult<Goods> searchGoods(HttpServletRequest request, @RequestBody @Valid ReqSearchGoods reqSource, BindingResult bindingResult) {
        String custId = "";
        if (StringUtils.isNotEmpty(reqSource.getToken())) {
            custId = jedisService.getValueByKey(reqSource.getToken());
        }


        return goodsBiz.searchGoods(reqSource, request, custId, (byte)2);


    }

    @PostMapping("/videoCate/{id}")
    public TypeJsonResult<List<RespCateGood>> searchGoods(@PathVariable("id") String videoId, @RequestBody @Valid ReqComm reqSource, BindingResult bindingResult) {
        return goodsBiz.goodsByVideo(videoId);
    }

    /**
     * 查询商品推荐
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/queryGoodsRec")
    public TypeJsonResult<List<Goods>> queryGoodsRec(@RequestBody @Valid ReqComm reqSource, BindingResult bindingResult) {
        return goodsBiz.queryGoodsRec();
    }

    /**
     *查询热门兑换推荐商品列表
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/queryGoodsIsHotExchange")
    public JsonResult queryGoodsIsHotExchange(@RequestBody @Valid ReqCommPage reqSource, BindingResult bindingResult) {
        return goodsBiz.queryGoodsIsHotExchange(reqSource);
    }
}
