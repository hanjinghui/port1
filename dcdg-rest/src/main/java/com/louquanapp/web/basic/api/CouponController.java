package com.louquanapp.web.basic.api;

import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.CouponBiz;
import com.louquanapp.biz.CustomerBiz;
import com.louquanapp.biz.SystemParamBiz;
import com.louquanapp.dao.mapper.SystemParamMapper;
import com.louquanapp.dao.model.Coupon;
import com.louquanapp.dao.model.SystemParam;
import com.louquanapp.model.PageJsonResult;
import com.louquanapp.req.*;
import com.louquanapp.service.JedisService;
import com.louquanapp.utils.WebServletUtil;
import com.louquanapp.web.customer.api.AuthCustomerApi;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/7 19:01
 * @Description:
 */
@RestController
@RequestMapping("/api/auth")
public class CouponController {


    private final CouponBiz couponBiz;
    private final JedisService jedisService;
    private final SystemParamMapper systemParamMapper;

    public CouponController(CouponBiz couponBiz, JedisService jedisService, SystemParamMapper systemParamMapper) {
        this.couponBiz = couponBiz;
        this.jedisService = jedisService;
        this.systemParamMapper = systemParamMapper;
    }

    /**
     * 领取类优惠卷列表
     * @param request
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/couponsReceive")
    public JsonResult couponsReceive(HttpServletRequest request, @RequestBody @Valid ReqReceiveCoupon reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        if (!checkIp(request)) {
            jsonResult.setMessage("ip未授权");
            return jsonResult;
        }
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return couponBiz.couponsReceive(custId, reqSource);
    }

    /**
     * 获取领取类优惠卷
     * @param request
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/getcouponReceive/{couponId}")
    public JsonResult getcouponReceive(HttpServletRequest request, @PathVariable("couponId") String couponId, @RequestBody @Valid ReqTokenGame reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        if (!checkIp(request)) {
            jsonResult.setMessage("ip未授权");
            return jsonResult;
        }
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return couponBiz.getcouponReceive(custId, couponId);
    }



    /**
     * 获取我的优惠券
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/coupons")
    public PageJsonResult<Coupon> messages(@RequestBody @Valid ReqTokenPage reqSource, BindingResult bindingResult) {
        PageJsonResult<Coupon> pageJsonResult = new PageJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(pageJsonResult, custId)) return pageJsonResult;
        return couponBiz.couponsByCustIdAndType(custId, reqSource);
    }

    /**
     * 线下使用优惠券
     * @param couponId
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/userCoupon/{couponId}")
    public JsonResult userCoupon(@PathVariable("couponId") String couponId, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult pageJsonResult = new JsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(pageJsonResult, custId)) return pageJsonResult;
        return couponBiz.userCoupon(custId, couponId);
    }

//    /**
//     * 获取我的消息
//     *
//     * @param reqSource
//     * @param bindingResult
//     * @return
//     */
//    @PostMapping("/coupons")
//    public TypeJsonResult<List<Coupon>> messages(@RequestBody @Valid ReqCoupon reqSource, BindingResult bindingResult) {
//        TypeJsonResult<List<Coupon>> pageJsonResult = new TypeJsonResult();
//        String custId = jedisService.getCustIdByToken(reqSource.getToken());
//        if (AuthCustomerApi.tokenDie(pageJsonResult, custId)) return pageJsonResult;
//        return couponBiz.messagesByCustIdAndContent(custId, reqSource.getCouponConent());
//    }


    /**
     * 优惠劵列表
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/couponList")
    public JsonResult couponList(@RequestBody @Valid ReqCouponPage reqSource, BindingResult bindingResult) {
        JsonResult pageJsonResult = new JsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(pageJsonResult, custId)) return pageJsonResult;
        return couponBiz.couponList(custId, reqSource);
    }

    /**
     * 增加优惠券
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/addCoupon")
    public JsonResult addCoupon(@RequestBody @Valid ReqAddCoupon reqSource, BindingResult bindingResult) {
        JsonResult pageJsonResult = new JsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(pageJsonResult, custId)) return pageJsonResult;
        return couponBiz.addCoupon(custId, reqSource);
    }


    /**
     * 核销优惠劵列表
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/writeOffCouponList")
    public JsonResult writeOffCouponList(@RequestBody @Valid ReqTokenPage reqSource, BindingResult bindingResult) {
        JsonResult pageJsonResult = new JsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(pageJsonResult, custId)) return pageJsonResult;
        return couponBiz.writeOffCouponList(custId, reqSource);
    }

    /**
     * 核销优惠劵
     * @param custCouponId
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/writeOffCoupon/{custCouponId}")
    public JsonResult writeOffCoupon(@PathVariable("custCouponId") String custCouponId,@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult pageJsonResult = new JsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(pageJsonResult, custId)) return pageJsonResult;
        return couponBiz.writeOffCoupon(custId, custCouponId);
    }

    /**
     * 优惠劵详情
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/couponDetail/{custCouponId}")
    public JsonResult couponDetail(@PathVariable("custCouponId") String custCouponId,@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult pageJsonResult = new JsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(pageJsonResult, custId)) return pageJsonResult;
        return couponBiz.couponDetail(custId,custCouponId);
    }










    private boolean checkIp(HttpServletRequest request) {
        boolean flag = false;
        SystemParam systemParam = systemParamMapper.selectByIndex(SystemParamBiz.IP);
        if (null != systemParam) {
            String param = systemParam.getParamValue();
            if (StringUtils.isEmpty(param) || "*".equals(param)) {
                flag = true;
            } else {
                if (param.contains(WebServletUtil.getClientIpAddr(request))) {
                    flag = true;
                } else {
                    flag = false;
                }
            }

        } else {
            flag = true;
        }
        return flag;

    }
}
