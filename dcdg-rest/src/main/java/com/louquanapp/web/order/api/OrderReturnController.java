package com.louquanapp.web.order.api;

import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.OrderReturnBiz;
import com.louquanapp.dao.model.OrderReturn;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqOrderReturn;
import com.louquanapp.req.ReqToken;
import com.louquanapp.service.JedisService;
import com.louquanapp.web.customer.api.AuthCustomerApi;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/10 10:06
 * @description:
 */
@RestController
@RequestMapping("/api/auth")
public class OrderReturnController {
    private final JedisService jedisService;
    private final OrderReturnBiz orderReturnBiz;


    public OrderReturnController(JedisService jedisService, OrderReturnBiz orderReturnBiz) {
        this.jedisService = jedisService;
        this.orderReturnBiz = orderReturnBiz;
    }

    /**
     * 增加订单退货信息
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/addOrderReturn")
    public JsonResult addOrderReturn(@RequestBody @Valid ReqOrderReturn reqSource, BindingResult bindingResult) {

        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;

        return orderReturnBiz.addOrderReturn(reqSource, custId);
    }

    /**
     * @param childId
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/orderReturn/{id}")
    public TypeJsonResult<OrderReturn> orderReturn(@PathVariable("id") String childId, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {

        TypeJsonResult<OrderReturn> jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return orderReturnBiz.orderReturn(childId, custId);
    }


}
