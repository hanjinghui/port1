package com.louquanapp.web.order.api;

import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.OrderBiz;
import com.louquanapp.dao.model.Order;
import com.louquanapp.dao.model.OrderItem;
import com.louquanapp.model.PageJsonResult;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.*;
import com.louquanapp.service.JedisService;
import com.louquanapp.web.customer.api.AuthCustomerApi;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/9 18:57
 * @Description:
 */
@RestController
@RequestMapping("/api/auth")
public class OrderController {

    private final JedisService jedisService;
    private final OrderBiz orderBiz;

    public OrderController(JedisService jedisService, OrderBiz orderBiz) {
        this.jedisService = jedisService;
        this.orderBiz = orderBiz;
    }


    /**
     * 订单详情
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("orderDetail")
    public TypeJsonResult orderDetail(@RequestBody @Valid ReqOrderDetail reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());

        return orderBiz.orderDetail(reqSource.getOrderIds(), custId, reqSource.getType());
    }

    /**
     * 我的订单分页
     *
     * @param reqSource
     * @param request
     * @return
     */
    @PostMapping("orders")
    public PageJsonResult<Order> orders(@RequestBody @Valid ReqSearchOrder reqSource, HttpServletRequest request) {

        PageJsonResult jsonResult = new PageJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;

        return orderBiz.orders(reqSource, custId);
    }


    /**
     * 我的订单分页
     *
     * @param reqSource
     * @param request
     * @return
     */
    @PostMapping("orderItem")
    public PageJsonResult<OrderItem> orderItem(@RequestBody @Valid ReqSearchOrder reqSource, HttpServletRequest request) {
        PageJsonResult pageJsonResult = new PageJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(pageJsonResult, custId)) return pageJsonResult;
        return orderBiz.orderItems(reqSource, custId);
    }

    /**
     * 订单统计
     *
     * @param reqSource
     * @param request
     * @return
     */
    @PostMapping("orderStatic")
    public TypeJsonResult<Map<String, Integer>> orderStatic(@RequestBody @Valid ReqOrderStatic reqSource, HttpServletRequest request) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return orderBiz.getOrderStausByCustId(custId, reqSource.getIsPromotion());
    }

    /**
     * 确认收货
     *
     * @param orderId
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("doOrderConfirm/{id}")
    public JsonResult doOrderConfirm(@PathVariable("id") String orderId, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return orderBiz.doOrderConfirm(orderId, custId);
    }

    /**
     * 确认收货
     *
     * @param orderId
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("orderPostInfo/{id}")
    public JsonResult orderPostInfo(@PathVariable("id") String orderId, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return orderBiz.orderPostInfo(orderId, custId);
    }

    /**
     * 删除订单
     *
     * @param orderId
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/delOderById/{id}")
    public JsonResult delOderById(@PathVariable("id") String orderId, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return orderBiz.delOrderById(orderId, custId);
    }

    /**
     * 取消订单
     *
     * @param orderId
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/cancleOderById/{id}")
    public JsonResult cancelOderById(@PathVariable("id") String orderId, @RequestBody @Valid ReqCancleOrder reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return orderBiz.cancleOrderById(orderId, custId, reqSource.getOrderProb());
    }

    /**
     * 修改订单收货地址
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/updateAdress")
    public JsonResult updateAdress(@RequestBody @Valid ReqOrderAdress reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return orderBiz.updateAdress(reqSource);
    }

    /**
     * 查询快递公司信息
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/expressCompanyInfo")
    public JsonResult expressCompanyInfo(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return orderBiz.expressCompanyInfo();
    }

    /***
     * 发货
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/sendGoods")
    public JsonResult sendGoods(@RequestBody @Valid ReqSendGoods reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return orderBiz.sendGoods(custId,reqSource.getOrderId(),reqSource.getPostCompany(), reqSource.getPostNo());
    }


    /**
     * 服务完成（餐饮）
     * @param orderId
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/serviceCompletion/{orderId}")
    public JsonResult serviceCompletion(@PathVariable("orderId") String orderId,@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return orderBiz.serviceCompletion(custId,orderId);
    }

    /**
     * 销售额统计
     * @param type
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/salesStatistics/{type}")
    public JsonResult salesStatistics(@PathVariable("type") String type,@RequestBody @Valid ReqShopId reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return orderBiz.salesStatistics(custId,type,reqSource.getShopId());
    }

    /**
     * 销售量统计
     * @param type
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/SalesVolumeStatistics/{type}")
    public JsonResult SalesVolumeStatistics(@PathVariable("type") String type,@RequestBody @Valid ReqShopId reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return orderBiz.SalesVolumeStatistics(custId,type,reqSource.getShopId());
    }

    /**
     * 客户量统计
     * @param type
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/customerVolumeStatistics/{type}")
    public JsonResult customerVolumeStatistics(@PathVariable("type") String type,@RequestBody @Valid ReqShopId reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return orderBiz.customerVolumeStatistics(custId,type,reqSource.getShopId());
    }

}
