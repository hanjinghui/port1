package com.louquanapp.web.shop.api;

import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.BuyCartBiz;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqAddBuyCart;
import com.louquanapp.req.ReqBuyCart;
import com.louquanapp.req.ReqToken;
import com.louquanapp.req.ReqUpdateGoodsNum;
import com.louquanapp.resp.BuyCartDto;
import com.louquanapp.service.JedisService;
import com.louquanapp.web.customer.api.AuthCustomerApi;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/3 19:07
 * @Description:
 */
@RestController
@RequestMapping("/api/auth")
public class BuyCartController {
    private static final Object lock = new Object();
    private final BuyCartBiz buyCartBiz;
    private final JedisService jedisService;

    public BuyCartController(BuyCartBiz buyCartBiz, JedisService jedisService) {
        this.buyCartBiz = buyCartBiz;
        this.jedisService = jedisService;
    }

    /**
     * 增加到购物车
     *
     * @param skuId sku值
     * @return
     */
    @PostMapping("/addCart/{skuId}")
    public TypeJsonResult<String> addCart(@PathVariable("skuId") String skuId, @RequestBody @Valid ReqAddBuyCart reqSource, BindingResult bindingResult) {
        synchronized (lock) {
            TypeJsonResult jsonResult = new TypeJsonResult(false);
            String custId = jedisService.getCustIdByToken(reqSource.getToken());
            if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
            if (null == reqSource.getGoodsNum() || reqSource.getGoodsNum() == 0) {
                reqSource.setGoodsNum(1);
            }
            return buyCartBiz.buyCart(skuId, custId, reqSource.getGoodsNum(), false, null, reqSource.getIsPromotion());

        }
    }

    /**
     * 直接购买
     *
     * @param skuId sku值
     * @return
     */
    @PostMapping("/buyCart/{skuId}")
    public JsonResult buyCart(@PathVariable("skuId") String skuId, HttpSession httpSession, @RequestBody @Valid ReqAddBuyCart reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        if (null == reqSource.getGoodsNum() || reqSource.getGoodsNum() == 0) {
            reqSource.setGoodsNum(1);
        }
        return buyCartBiz.buyCart(skuId, custId, reqSource.getGoodsNum(), true, reqSource.getToken(), reqSource.getIsPromotion());
    }


    /**
     * 修改购物车数量
     *
     * @param cartId 商品id
     * @return
     */
    @PostMapping("/updateCartNum/{cartId}")
    public JsonResult updateCartNum(@PathVariable("cartId") String cartId, @RequestBody @Valid ReqUpdateGoodsNum reqSource, BindingResult bindingResult) {

        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;

        return buyCartBiz.updateCartNum(cartId, custId, reqSource.getGoodsNum());
    }

    /**
     * 清空购物车
     *
     * @return
     */
    @PostMapping("/clearCart")
    public JsonResult clearCart(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return buyCartBiz.clearCart(custId);
    }

    /**
     * 清空购物车
     *
     * @return
     */
    @PostMapping("/removeCart")
    public JsonResult clearCart(@RequestBody @Valid ReqBuyCart reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        if (StringUtils.isEmpty(reqSource.getSelectedCartId())) {
            jsonResult.setMessage("没有要删除的购物车数据");
            return jsonResult;
        }
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return buyCartBiz.removeCart(custId, reqSource.getSelectedCartId(), (byte)2);
    }

    /**
     * 我的购物车
     *
     * @param session
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/buycarts")
    public TypeJsonResult<BuyCartDto> buycarts(HttpSession session, @RequestBody @Valid ReqBuyCart reqSource, BindingResult bindingResult) {
        return buyAndSettlement( reqSource, false, reqSource.getIsPromotion());
    }


    /**
     * 结算中心
     *
     * @param session
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/settlement")
    public TypeJsonResult<BuyCartDto> settlement(HttpSession session, @RequestBody @Valid ReqBuyCart reqSource, BindingResult bindingResult) {
        return buyAndSettlement(reqSource, true, reqSource.getIsPromotion());
    }

    /**
     * 购物车列表  和 结算 功能处理类
     *
     * @param reqSource
     * @param settlement
     * @param isPro      餐饮 1-是 2-否
     * @return
     */
    private TypeJsonResult<BuyCartDto> buyAndSettlement( ReqBuyCart reqSource, boolean settlement, Byte isPro) {
        TypeJsonResult<BuyCartDto> typeJsonResult = new TypeJsonResult<>();
        String token=reqSource.getToken();

        String custId = jedisService.getCustIdByToken(token);
        if (AuthCustomerApi.tokenDie(typeJsonResult, custId)) return typeJsonResult;
        String selectedCartId = reqSource.getSelectedCartId();

        if ("empty".equals(selectedCartId) && !settlement) {
            //session.setAttribute(BuyCartBiz.SELECTED_CART_ID, "");
            jedisService.setKeyValue(token.concat(BuyCartBiz.SELECTED_CART_ID),"",30);
            selectedCartId = "";
        }
        if (StringUtils.isEmpty(selectedCartId)) {
           // Object selectedCartIdObj = session.getAttribute(BuyCartBiz.SELECTED_CART_ID);
            Object selectedCartIdObj =jedisService.getValueByKey(token.concat(BuyCartBiz.SELECTED_CART_ID));
            if (null != selectedCartIdObj) {
                selectedCartId = selectedCartIdObj.toString();
            }
        }

        if (StringUtils.isNotEmpty(selectedCartId)) {
            //session.setAttribute(BuyCartBiz.SELECTED_CART_ID, selectedCartId);
            jedisService.setKeyValue(token.concat(BuyCartBiz.SELECTED_CART_ID),selectedCartId,30);
            if (selectedCartId.lastIndexOf(",") == selectedCartId.length()) {
                selectedCartId = selectedCartId.substring(0, selectedCartId.length() - 1);
            }
        }

        typeJsonResult = buyCartBiz.getBuyCartList(token,custId, selectedCartId, settlement, reqSource.getBuy(), isPro);
        return typeJsonResult;
    }
}
