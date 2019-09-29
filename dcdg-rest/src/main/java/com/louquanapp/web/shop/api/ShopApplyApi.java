package com.louquanapp.web.shop.api;

import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.ShopApplyBiz;
import com.louquanapp.req.ReqShopApply;
import com.louquanapp.service.JedisService;
import com.louquanapp.web.customer.api.AuthCustomerApi;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Auther: Huhuamin
 * @Date: 2019/3/27 17:40
 * @Description: 商家入驻
 */
@RestController
@RequestMapping("/api/auth")
public class ShopApplyApi {
    private final JedisService jedisService;
    private final ShopApplyBiz shopApplyBiz;

    public ShopApplyApi(JedisService jedisService, ShopApplyBiz shopApplyBiz) {
        this.jedisService = jedisService;
        this.shopApplyBiz = shopApplyBiz;
    }


    /**
     * token获取客户信息
     *
     * @return
     */
    @PostMapping("/shopApply")
    //3-Android 4-iOS
    public JsonResult shopApply(@RequestBody @Valid ReqShopApply reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) {
            return jsonResult;
        }

        return shopApplyBiz.saveApply(reqSource, custId);
    }
}
