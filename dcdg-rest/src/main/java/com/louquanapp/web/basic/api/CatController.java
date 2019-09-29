package com.louquanapp.web.basic.api;

import com.louquanapp.biz.CatBiz;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqComm;
import com.louquanapp.req.ReqToken;
import com.louquanapp.req.ReqTokenIf;
import com.louquanapp.service.JedisService;
import com.louquanapp.web.customer.api.AuthCustomerApi;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/11 10:34
 * @description:
 */
@RestController
@RequestMapping("/api")
public class CatController {
    private final CatBiz catBiz;
    private final JedisService jedisService;


    public CatController(CatBiz catBiz, JedisService jedisService) {
        this.catBiz = catBiz;
        this.jedisService = jedisService;
    }

    /**
     * 根据CatFlag查询分类
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/auth/videoCats")
    public TypeJsonResult videoCats(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId=jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return catBiz.videoCats(custId);
    }
}
