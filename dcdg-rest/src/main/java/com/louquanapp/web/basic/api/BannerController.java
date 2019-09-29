package com.louquanapp.web.basic.api;


import com.louquanapp.biz.BannerBiz;
import com.louquanapp.dao.model.Banner;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqBanner;
import com.louquanapp.req.ReqComm;
import com.louquanapp.service.JedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/no")
public class BannerController {
    private final BannerBiz bannerBiz;
    private final JedisService jedisService;

    public BannerController(BannerBiz bannerBiz, JedisService jedisService) {
        this.bannerBiz = bannerBiz;
        this.jedisService = jedisService;
    }

    /**
     * 首页banner列表
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("banners")
    public TypeJsonResult<List<Banner>> banners(@RequestBody @Valid ReqBanner reqSource, BindingResult bindingResult) {
        String custId = "";
        if (StringUtils.isNotBlank(reqSource.getToken())) {
            custId = jedisService.getValueByKey(reqSource.getToken());
        }

        return bannerBiz.banners(reqSource.getBannerPage(), custId);
    }

    @PostMapping("banner/{id}")
    public TypeJsonResult<Banner> getBannerbyId(@PathVariable("id") String bannerId, @RequestBody @Valid ReqComm reqComm, BindingResult bindingResult) {
        return bannerBiz.getBannerById(bannerId);
    }


    /**
     * 首页注册好友送余额或积分
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/pointOrCast")
    public TypeJsonResult<Banner> pointOrCast(@RequestBody @Valid ReqBanner reqSource, BindingResult bindingResult) {
        String custId = "";
        if (StringUtils.isNotBlank(reqSource.getToken())) {
            custId = jedisService.getValueByKey(reqSource.getToken());
        }

        return bannerBiz.pointOrCast(reqSource.getBannerPage(), custId);
    }

}
