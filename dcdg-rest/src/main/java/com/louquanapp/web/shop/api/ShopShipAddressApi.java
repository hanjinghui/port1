package com.louquanapp.web.shop.api;

import com.alibaba.fastjson.JSON;
import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.ShipAddressBiz;
import com.louquanapp.dao.model.ShipAddress;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqShipAddress;
import com.louquanapp.req.ReqToken;
import com.louquanapp.service.JedisService;
import com.louquanapp.web.customer.api.AuthCustomerApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2019年03月29日14:03:20
 */
@RestController
@RequestMapping("/api/auth")
public class ShopShipAddressApi {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private final ShipAddressBiz shipAddressBiz;
    private final JedisService jedisService;


    public ShopShipAddressApi(
            ShipAddressBiz shipAddressBiz, JedisService jedisService) {
        this.shipAddressBiz = shipAddressBiz;
        this.jedisService = jedisService;
    }

    /**
     * 增加收货地址
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("addShipAddress")
    public JsonResult addShipAddress(@RequestBody @Valid ReqShipAddress reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) {
            return jsonResult;
        }
        return shipAddressBiz.addShipAddress(reqSource, custId);

    }

    /**
     * 获取当前客户默认收货地址
     *
     * @param
     * @return TypeJsonResult<ShipAddress>
     */
    @PostMapping("/defaultAddress")
    public TypeJsonResult<ShipAddress> defaultAddress(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        TypeJsonResult<ShipAddress> typeJsonResult = new TypeJsonResult<>();
        typeJsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(typeJsonResult, custId)) {
            return typeJsonResult;
        }
        typeJsonResult = shipAddressBiz.getDefaultByCustId(custId);
        if (logger.isDebugEnabled()) {
            logger.debug(JSON.toJSONString(typeJsonResult, true));
        }
        return typeJsonResult;
    }

    /**
     * 获取当前客户所有收货地址
     *
     * @param
     * @return PageJsonResult<CustCoupon>
     */
    @PostMapping("/allAddress")
    public TypeJsonResult<List<ShipAddress>> allAddress(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {

        TypeJsonResult<List<ShipAddress>> typeJsonResult = new TypeJsonResult<>();
        typeJsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(typeJsonResult, custId)) {
            return typeJsonResult;
        }
        typeJsonResult = shipAddressBiz.selectAllByCustId(custId);
        if (logger.isDebugEnabled()) {
            logger.debug(JSON.toJSONString(typeJsonResult, true));
        }
        return typeJsonResult;
    }

    /**
     * 根据主键获取当前客户收货地址
     *
     * @param
     * @return TypeJsonResult<ShipAddress>
     */
    @PostMapping("/getAddress/{id}")
    public TypeJsonResult<ShipAddress> getAddress(@PathVariable("id") String id, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {

        TypeJsonResult<ShipAddress> typeJsonResult = new TypeJsonResult<>();
        typeJsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(typeJsonResult, custId)) {
            return typeJsonResult;
        }

        typeJsonResult = shipAddressBiz.getAddressByCustIdAndShipId(custId, id);
        if (logger.isDebugEnabled()) {
            logger.debug(JSON.toJSONString(typeJsonResult, true));
        }
        return typeJsonResult;
    }

    /**
     * 根据主键删除收货地址
     *
     * @param id
     * @return
     */
    @PostMapping("/delAddress/{id}")
    public JsonResult delAddress(@PathVariable("id") String id, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) {
            return jsonResult;
        }
        jsonResult = shipAddressBiz.delAddressByCustIdAndShipId(custId, id);
        return jsonResult;
    }

//    /**
//     * 根据主键删除收货地址
//     *
//     * @param ids
//     * @return
//     */
//    @PostMapping("/delAddress/{ids}")
//    public JsonResult delAddresss(@PathVariable("ids") String ids,@RequestBody  @Valid ReqToken reqSource, BindingResult bindingResult) {
//        JsonResult jsonResult = new JsonResult(false);
//        String custId = jedisService.getCustIdByToken(reqSource.getToken());
//        if (AuthCustomerApi.tokenDie(jsonResult, custId)) {
//            return jsonResult;
//        }
//        jsonResult = shipAddressBiz.delAddressByCustIdAndShipIds(custId, ids);
//        return jsonResult;
//    }

    /**
     * 设置当前客户地址为默认收货地址
     *
     * @param id
     * @return
     */
    @PostMapping("/defaultAddress/{id}")
    public JsonResult defaultAddress(@PathVariable("id") String id, @RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) {
            return jsonResult;
        }
        jsonResult = shipAddressBiz.setCurrentUserDefaultAddr(custId, id);
        return jsonResult;
    }

}
