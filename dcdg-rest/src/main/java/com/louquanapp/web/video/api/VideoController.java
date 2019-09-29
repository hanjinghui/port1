package com.louquanapp.web.video.api;

import com.github.pagehelper.PageInfo;
import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.VideoBiz;
import com.louquanapp.dao.model.Shop;
import com.louquanapp.dao.model.Video;
import com.louquanapp.model.PageJsonResult;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.*;
import com.louquanapp.service.JedisService;
import com.louquanapp.web.customer.api.AuthCustomerApi;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/23 14:27
 * @Description:
 */
@RestController
@RequestMapping("/api")
public class VideoController {

    private final JedisService jedisService;
    private final VideoBiz videoBiz;

    public VideoController(JedisService jedisService, VideoBiz videoBiz) {
        this.jedisService = jedisService;
        this.videoBiz = videoBiz;
    }

    /**
     * 添加直播
     */
    @PostMapping("/auth/doVideo")
    public JsonResult doVideo(@RequestBody @Valid ReqVideo reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return videoBiz.doVideo(custId, reqSource);
    }

    /**
     * 直播鉴权及返回最新的推推地址
     */
    @PostMapping("/auth/startVideo/{id}")
    public TypeJsonResult<Video> startVideo(@PathVariable("id") String videoId, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        TypeJsonResult<Video> jsonResult = new TypeJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return videoBiz.startVideo(custId, videoId);
    }

    /**
     * 开始直播
     */
    @PostMapping("/auth/planVideo/{id}")
    public TypeJsonResult<Video> planVideo(@PathVariable("id") String videoId, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        TypeJsonResult<Video> jsonResult = new TypeJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return videoBiz.planVideo(custId, videoId);
    }

    /**
     * 结束直播
     */
    @PostMapping("/auth/stopVideo/{id}")
    public TypeJsonResult<Video> stopVideo(@PathVariable("id") String videoId, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        TypeJsonResult<Video> jsonResult = new TypeJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return videoBiz.stopVideo(custId, videoId);
    }


    /**
     * 视频详情
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/video/{id}")
    public TypeJsonResult<Video> video(@PathVariable("id") String id, @RequestBody @Valid ReqTokenIf reqSource, BindingResult bindingResult) {
        String custId = "";
        if (StringUtils.isNotBlank(reqSource.getToken())) {
            custId = jedisService.getValueByKey(reqSource.getToken());
        }
        return videoBiz.videoById(id, custId);
    }

    /**
     * 商家信息
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/shop/{id}")
    public TypeJsonResult<Shop> shop(@PathVariable("id") String id, @RequestBody @Valid ReqTokenIf reqSource, BindingResult bindingResult) {
        String custId = "";
        if (StringUtils.isNotBlank(reqSource.getToken())) {
            custId = jedisService.getValueByKey(reqSource.getToken());
        }
        return videoBiz.shopByViedoId(id, custId);
    }

    /**
     * 我的直播列表
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/myVideoList")
    public PageJsonResult<Video> myVideoList(@RequestBody @Valid ReqTokenPage reqSource, BindingResult bindingResult) {
        PageJsonResult jsonResult = new PageJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return videoBiz.myVideoList(custId, reqSource);
    }

    /**
     * 直播列表
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/videos")
    public PageJsonResult<Video> videos(@RequestBody @Valid ReqVideoCatId reqSource, BindingResult bindingResult) {
        String custId = "";
        if (StringUtils.isNotBlank(reqSource.getToken())) {
            custId = jedisService.getValueByKey(reqSource.getToken());
        }
        if ("x".equals(reqSource.getCatId()) && StringUtils.isEmpty(custId)) {
            PageJsonResult<Video> pageJsonResult = new PageJsonResult<>();
            pageJsonResult.setPageInfo(new PageInfo<>());
            pageJsonResult.setStatusCode(true);
            return pageJsonResult;
        }
        return videoBiz.videos(reqSource, custId);
    }

    /**
     * 短视频列表
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/videoWorks")
    public PageJsonResult<Video> videoWorks(@RequestBody @Valid ReqTokenPage reqSource, BindingResult bindingResult) {
        PageJsonResult jsonResult = new PageJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return videoBiz.videoWorks(reqSource,custId);
    }

    /**
     * 添加或取消视频拉黑
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/doPullBlack")
    public JsonResult doPullBlack(@RequestBody @Valid ReqPullVideo reqSource, BindingResult bindingResult) {
        PageJsonResult jsonResult = new PageJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return videoBiz.doPullBlack(reqSource,custId);
    }

    /**
     * 查询用户拉黑视频列表
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/queryPullVideos")
    public PageJsonResult<Video> queryPullVideos(@RequestBody @Valid ReqTokenPage reqSource, BindingResult bindingResult) {
        PageJsonResult jsonResult = new PageJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return videoBiz.queryPullVideos(reqSource,custId);
    }

    /**
     * 删除视频
     * @param videoId
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/delVideo")
    public JsonResult delVideo(@RequestBody @Valid ReqDelVideos reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return videoBiz.delVideo(custId,reqSource.getVideoIds());
    }




}
