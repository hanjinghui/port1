package com.louquanapp.biz;

import cn.jiguang.common.utils.StringUtils;
import com.google.common.base.Joiner;
import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.Arith;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.dao.mapper.*;
import com.louquanapp.dao.model.*;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.resp.BuyCartDto;
import com.louquanapp.service.JedisService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/3 18:43
 * @Description: 购物车业务逻辑
 */
@Service
public class BuyCartBiz {
    public final static String SELECTED_CART_ID = "CART";
//    private Logger logger = LoggerFactory.getLogger(BuyCartBiz.class);

    private final CategoryMapper categoryMapper;
    private final GoodsSkuMapper goodsSkuMapper;
    private final BuyCartMapper buyCartMapper;
    private final GoodsMapper goodsMapper;
    private final ShopMapper shopMapper;
    private final ShipAddressMapper shipAddressMapper;
    private final CouponMapper couponMapper;
    private final JedisService jedisService;

//    private final FootPrintService footPrintService;


    public BuyCartBiz(CategoryMapper categoryMapper, GoodsSkuMapper goodsSkuMapper, BuyCartMapper buyCartMapper, GoodsMapper goodsMapper, ShopMapper shopMapper, ShipAddressMapper shipAddressMapper, CouponMapper couponMapper, JedisService jedisService) {
        this.categoryMapper = categoryMapper;
        this.goodsSkuMapper = goodsSkuMapper;
        this.buyCartMapper = buyCartMapper;
        this.goodsMapper = goodsMapper;
        this.shopMapper = shopMapper;
        this.shipAddressMapper = shipAddressMapper;
        this.couponMapper = couponMapper;
        this.jedisService = jedisService;
    }

    /**
     * 根据用户获取购物车数量
     *
     * @param custId
     * @return
     */
    public TypeJsonResult<Integer> countCartByCustId(String custId) {
        try {
            //购物车物品种类
            int buyCount = buyCartMapper.countCartByCustId(custId);
            TypeJsonResult<Integer> typeJsonResult = new TypeJsonResult(buyCount);
            return typeJsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("单个移除购物车" + e.getMessage(), e);
            }
        }
    }
    public String  checkData( List<BuyCart> list,Integer buy){
        StringBuffer cartIds=new StringBuffer("");
        for (BuyCart temp : list
        ) {

            Goods goods = goodsMapper.selectGoodsImgAndCatPathAndGoodsNameAndPutawayFlagByPrimaryKey(temp.getGoodsId());


            if(1==buy&&(4!=goods.getAuditStatus()||3==goods.getPutawayFlag())){
                throw new HuhuaminException("商品已经下架");
            }
            if(2==buy&&(4!=goods.getAuditStatus()||3==goods.getPutawayFlag())){
                buyCartMapper.deleteByPrimaryKey(temp.getCartId());
            }else if(2==buy){
                if(StringUtils.isNotEmpty(cartIds.toString())){
                    cartIds.append(",").append(temp.getCartId());
                }else{
                    cartIds.append(temp.getCartId());
                }
            }
        }
        return cartIds.toString();
    }

    /**
     * 根据custId获取购物车列表
     *
     * @param custId
     * @param selectedCartId
     * @param settlement
     * @param buy            buy 1-立即购买 2-购物车
     * @param isPro
     * @return
     */
    public TypeJsonResult<BuyCartDto> getBuyCartList(String token,String custId, String selectedCartId, boolean settlement, Integer buy, Byte isPro) {
        try {
            List<String> arrSelected = new ArrayList<>();
            if (StringUtils.isNotEmpty(selectedCartId)) {
                arrSelected = Arrays.asList(selectedCartId.split(","));
            }

            Set<String> shopIds = new HashSet<>();
            Set<String> goodsIds = new HashSet<>();
            TypeJsonResult<BuyCartDto> cartDtoTypeJsonResult = new TypeJsonResult<>();
            BuyCartDto buyCartDto = new BuyCartDto();
            List<BuyCart> list = null;
            if (null != buy && buy == 1) {
                list = buyCartMapper.cartListByCustIdBuy(arrSelected, custId, isPro);
            } else {//1-立即购买 2-购物车
                list = buyCartMapper.cartListByCustId(arrSelected, custId, isPro);
                buy=2;
            }
            selectedCartId=checkData(list,buy);
            if(2==buy){
                if (StringUtils.isNotEmpty(selectedCartId)) {
                    arrSelected = Arrays.asList(selectedCartId.split(","));
                }
                list = buyCartMapper.cartListByCustId(arrSelected, custId, isPro);
                //jedisService.setKeyValue(token.concat(BuyCartBiz.SELECTED_CART_ID),selectedCartId,30);

            }



            Integer totalNum = 0;
            Double totalMoney = 0.00d;
            Double totalMaxPoint = 0.00d;
//            Set<String> catIdSet = new HashSet<>();
            Set<String> goodIds = new HashSet<>();
            List<Coupon> coupons = null;
            for (BuyCart temp : list
            ) {
                goodsIds.add(temp.getGoodsId());
                Goods goods = goodsMapper.selectGoodsImgAndCatPathAndGoodsNameAndPutawayFlagByPrimaryKey(temp.getGoodsId());
                String skuId = temp.getGoodsSku();
                //若果sku里面有图片 从sku里面去
                GoodsSku goodsSku = goodsSkuMapper.selectGoodsImgAndSkuGoodsNameAndPutawayPriceAndGoodsNumByPrimaryKey(skuId);
                if (null != goodsSku) {
                    if (StringUtils.isNotEmpty(goodsSku.getGoodsImg())) {
                        temp.setGoodsImg(goodsSku.getGoodsImg());
                    }

                    temp.setPutawayFlag(goods.getPutawayFlag().intValue());
                    temp.setStockCount(goodsSku.getStockCount());
                    temp.setGoodsName(goods.getGoodsName());
                    temp.setSkuGoodName(goodsSku.getSkuGoodsName().replace(goods.getGoodsName(), ""));
                    //当前小计的总价
                    Double tempPutAwayPirce = Arith.mul(goodsSku.getPutawayPrice(), temp.getGoodsNum());
                    Double tempMaxPoint = Arith.mul(goodsSku.getMaxPoint(), temp.getGoodsNum());
                    temp.setTotalPutawayPrice(tempPutAwayPirce);
                    temp.setMaxPoint(goodsSku.getMaxPoint());
                    temp.setPutawayPrice(goodsSku.getPutawayPrice());
                    temp.setMarketPrice(goodsSku.getMarketPrice());

                    if (arrSelected.contains(temp.getCartId())) {
                        //选中的汇总总价
                        temp.setSelected(true);
                        totalMoney = Arith.add(totalMoney, tempPutAwayPirce);
                        totalMaxPoint = Arith.add(totalMaxPoint, tempMaxPoint);
                        totalNum += temp.getGoodsNum();
                        goodIds.add(temp.getGoodsId());
                    } else {
                        temp.setSelected(false);
                    }
                }
                //如果默认规格的 没有图片去主账号找

                if (StringUtils.isEmpty(temp.getGoodsImg())) {
                    temp.setGoodsImg(goods.getGoodsImg());
                }
                if (null != goods) {
                    String catPath = goods.getCatPath();
                    String catId = catPath.split(",")[1];
//                    catIdSet.add(catId);
                    String catName = categoryMapper.getCatNameByCatId(catId);
                    temp.setCatName(catName);
                }


                //收藏业务逻辑 未使用

//                long resultCount = footPrintService.getGoodCollectByCustIdAndSourceId(custId, temp.getGoodsSku());
//                if (resultCount > 0) {
//                    temp.setCollected(true);
//                } else {
//                    temp.setCollected(false);
//                }
            }
            if (arrSelected.size() == list.size()) {
                buyCartDto.setSelectAll(true);
            }
            //最大邮费
            Double maxPostFee = 0.00d;
            if (!CollectionUtils.isEmpty(goodIds)) {
                maxPostFee = goodsMapper.maxPostFee(new ArrayList<>(goodIds));
            }

            buyCartDto.setPostFee(maxPostFee);
//            buyCartDto.setCatIds(catIdSet.toString());

            buyCartDto.setTotalMoney(totalMoney);
            buyCartDto.setTotalNum(totalNum);
            buyCartDto.setTotalMaxPoint(totalMaxPoint);

            cartDtoTypeJsonResult.setType(buyCartDto);


            if (settlement) {
                List<BuyCart> selectListtemp = new ArrayList<>();
                for (BuyCart temp :
                        list) {
                    if (temp.getSelected()) {
                        selectListtemp.add(temp);
                    }

                }
                buyCartDto.setPayMoney(Arith.add(buyCartDto.getTotalMoney(), buyCartDto.getPostFee()));
                ShipAddress address = shipAddressMapper.getDefaultByCustId(custId);
                buyCartDto.setShipAddress(address);

                coupons = couponMapper.couponsByCustId(custId,(byte)1);
                buyCartDto.setCoupons(coupons);
                List<Shop> shops = convertToMap(selectListtemp, shopMapper, goodsSkuMapper, goodsMapper);
                shops.forEach(shop -> {
                    shopIds.add(shop.getShopId());
                    shop.setTotalFee(shop.getTotalFee()+shop.getMaxPostFee());
                });
                buyCartDto.setShopBuyCarts(shops);
            } else {
                List<Shop> shops = convertToMap(list, shopMapper, goodsSkuMapper, goodsMapper);
                buyCartDto.setPostFee(0.00d);

                shops.forEach(shop -> {
                    buyCartDto.setPostFee(Arith.add(shop.getMaxPostFee(), buyCartDto.getPostFee()));
                    shop.setTotalFee(shop.getTotalFee()+shop.getMaxPostFee());
                });

                buyCartDto.setShopBuyCarts(shops);
            }

            if (!CollectionUtils.isEmpty(coupons)) {
                List<Coupon> listFilter = new ArrayList<>();
                for (Coupon tt : coupons
                ) {
                    if (tt.getCouponConent().equals("") || shopIds.contains(tt.getCouponConent()) || goodIds.contains(tt.getCouponConent())) {
                        listFilter.add(tt);
                    }
                }
                buyCartDto.setCoupons(listFilter);
            }


            cartDtoTypeJsonResult.setStatusCode(true);
            return cartDtoTypeJsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("获取购物车列表" + e.getMessage(), e);
            }
        }


    }

    public static List<Shop> convertToMap(List<BuyCart> list, ShopMapper shopMapper, GoodsSkuMapper goodsSkuMapper, GoodsMapper goodsMapper) {
        List<Shop> shops = new ArrayList<>();
        Map<String, List<BuyCart>> shopIdBuyCarts = new HashMap<>();

        if (CollectionUtils.isNotEmpty(list)) {
            list.stream().forEach(t -> {
                String shopId = t.getShopId();
                if (shopIdBuyCarts.containsKey(shopId)) {
                    shopIdBuyCarts.get(shopId).add(t);
                } else {
                    List<BuyCart> tList = new ArrayList<>();
                    tList.add(t);
                    shopIdBuyCarts.put(shopId, tList);
                }
            });
        }

        for (Map.Entry<String, List<BuyCart>> temp : shopIdBuyCarts.entrySet()) {
            Shop shop = shopMapper.selectByPrimaryKey(temp.getKey());
            shop.setBuyCarts(temp.getValue());
            shops.add(shop);
            shop.setTotalFee(0.00d);
            shop.setMaxPostFee(0.00d);
            shop.setTotalPoint(0.00d);
            shop.setGoodsNum(0);
            Set<String> goodIds = new HashSet<>();
            shop.getBuyCarts().forEach(t -> {
                goodIds.add(t.getGoodsId());
                String skuId = t.getGoodsSku();
                GoodsSku goodsSku = goodsSkuMapper.selectByPrimaryKey(t.getGoodsSku());
                Double tempPutAwayPrice = Arith.mul(goodsSku.getPutawayPrice(), t.getGoodsNum());
                Double tempTotalPoint = Arith.mul(goodsSku.getMaxPoint(), t.getGoodsNum());
                t.setTotalMaxPoint(tempTotalPoint);
                t.setTotalPutawayPrice(tempPutAwayPrice);
                shop.setTotalFee(Arith.add(shop.getTotalFee(), tempPutAwayPrice));
                shop.setTotalPoint(Arith.add(shop.getTotalPoint(), tempTotalPoint));
                shop.setGoodsNum(shop.getGoodsNum() + t.getGoodsNum());


            });
            Double maxPostFee = 0.00d;
            if (!org.springframework.util.CollectionUtils.isEmpty(goodIds)) {
                maxPostFee = goodsMapper.maxPostFee(new ArrayList<>(goodIds));
                shop.setMaxPostFee(maxPostFee);
                //赠送积分类型查询
            }
        }


        return shops;


    }


    /**
     * 增加到购物车
     *
     * @param goodsId
     * @param goodsSku
     * @param custId
     * @param goodsNum
     * @param shopId
     * @param isBuy
     * @return
     */
    private BuyCart addCartData(String goodsId, String goodsSku, String custId, Integer goodsNum, String uuid, String shopId, boolean isBuy, Byte isPro) {
        BuyCart addCart = new BuyCart();
        addCart.setGoodsId(goodsId);
        addCart.setGoodsSku(goodsSku);
        addCart.setCustId(custId);
        addCart.setIsPromotion(isPro.byteValue());

        addCart.setShopId(shopId);
        addCart.setAddTime(new Date());
        addCart.setGoodsNum(goodsNum);
        addCart.setCartId(uuid);
        if (isBuy) {
            addCart.setCartFlag((byte) 2);
        } else {
            addCart.setCartFlag((byte) 1);
        }
        return addCart;
    }

    /**
     * 之后购买 和 添加到购物车
     *
     * @param skuId
     * @param custId
     * @param goodsNum
     * @param isBuy    true 直接购买 false 只加入到购物车
     * @param session
     * @return
     */
    public synchronized TypeJsonResult<String> buyCart(String skuId, String custId, Integer goodsNum, boolean isBuy, String token, Byte isPro) {

        try {
            TypeJsonResult<String> jsonResult = new TypeJsonResult();

            int count = 0;
            //库存数
            GoodsSku goodsSku = goodsSkuMapper.getGoodsNumIdGoodsIdBySkuId(skuId);
            if (null == goodsSku) {
                jsonResult.setMessage("商品不存在");
                return jsonResult;
            }
            int goodsNumDb = goodsSku.getStockCount();
            String buyCartId = "";
            BuyCart buyCartTemp = null;
            if (StringUtils.isNotEmpty(skuId)) {
                buyCartTemp = buyCartMapper.getCartByGoodsIdAndGoodsSkuAndCustId(skuId, custId, isPro);
            }
            //先的查询有没有增加过 非直接购买
            if (!isBuy && null != buyCartTemp) {
                if (null != buyCartTemp && StringUtils.isNotEmpty(buyCartTemp.getCartId())) {
                    buyCartId = buyCartTemp.getCartId();
                    //检查库存
                    int updateNum = buyCartTemp.getGoodsNum() + goodsNum;
                    if (goodsNumDb < updateNum) {
                        jsonResult.setMessage("库存数不够" + "您的购物车中已经有了" + buyCartTemp.getGoodsNum() + "个此商品");
                        return jsonResult;
                    }
                    //乐观更新

                    count = buyCartMapper.updateCartNumByCartIdAndCustId(buyCartTemp.getCartId(), custId, updateNum, buyCartTemp.getGoodsNum());
                    buyCartId = buyCartTemp.getCartId();
                    if (count == 0) {
                        jsonResult.setMessage("更新购物车异常");
                        return jsonResult;
                    }
                }

            } else {
                //检查库存
                if (goodsNumDb < goodsNum) {
                    jsonResult.setMessage("库存数不够");
                    return jsonResult;
                }
                buyCartId = UUIDUtils.generateUuid22();
                String shopId = goodsMapper.selectShopIdById(goodsSku.getGoodsId());
                count = buyCartMapper.insert(addCartData(goodsSku.getGoodsId(), skuId, custId, goodsNum, buyCartId, shopId, isBuy, isPro));
                if (count == 0) {
                    jsonResult.setMessage("添加购物车失败");
                    return jsonResult;
                }

            }
            if (isBuy) {
                //session.setAttribute(SELECTED_CART_ID, buyCartId.concat(","));
                jedisService.setKeyValue(token.concat(SELECTED_CART_ID),buyCartId.concat(","),30);
            }

            jsonResult.setType(buyCartId);

            jsonResult.setStatusCode(true);

            return jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("单个移除购物车" + e.getMessage(), e);
            }

        }

    }


    /**
     * 清空购物车
     *
     * @param custId
     * @return
     */
    public JsonResult clearCart(String custId) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            buyCartMapper.clearCartByCustId(custId);
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("清空购物车" + e.getMessage(), e);
            }

        }

    }


    /**
     * 已有的，增加一个数量
     *
     * @param cartId cartId
     * @param custId 客户id
     * @return
     */
    public JsonResult updateCartNumPlus1(String cartId, String custId) {

        try {

            JsonResult jsonResult = new JsonResult(false);
            //现在购物车数量
            BuyCart buyCartTemp = buyCartMapper.selectByPrimaryKey(cartId);
            //库存数
            int goodsNumDb = goodsSkuMapper.getGoodsNumBySkuId(buyCartTemp.getGoodsSku());

            //检查库存
            if (goodsNumDb < buyCartTemp.getGoodsNum() + 1) {
                jsonResult.setMessage("库存数不够");
                return jsonResult;
            }
            int count = buyCartMapper.updateCartNumByCartIdAndCustId(cartId, custId, 1, goodsNumDb);
            if (count == 0) {
                jsonResult.setMessage("移除购物车失败");
                return jsonResult;
            }
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("增加一个购物车数量" + e.getMessage(), e);
            }

        }
    }

    /**
     * 减少一个数量（调用端需要校验库存数可够）
     *
     * @param cartId cartId
     * @param custId 客户id
     * @return
     */
    public JsonResult updateCartNumMinus(String cartId, String custId) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            //现在购物车数量
            BuyCart buyCartTemp = buyCartMapper.selectByPrimaryKey(cartId);
            //原始购物车数量 乐观更新
            int goodsNumDb = buyCartTemp.getGoodsNum();
            if (goodsNumDb == 1) {
                jsonResult.setMessage("已经是最少能，不能在减少了");
                return jsonResult;
            }

            int count = buyCartMapper.updateCartNumMinusByCartIdCustId(cartId, custId, goodsNumDb);
            if (count == 0) {
                jsonResult.setMessage("减少购物车数量失败");
                return jsonResult;
            }
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("减少一个购物车数量" + e.getMessage(), e);
            }

        }
    }

    /**
     * 直接更新购物车数量
     *
     * @param cartId
     * @param custId
     * @param goodsNum
     * @return
     */
    public JsonResult updateCartNum(String cartId, String custId, Integer goodsNum) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            //现在购物车数量
            BuyCart buyCartTemp = buyCartMapper.selectByPrimaryKey(cartId);
            if (null == buyCartTemp) {
                jsonResult.setMessage("购物车不存在");
                return jsonResult;
            }
            //库存数
            int goodsNumDb = goodsSkuMapper.getGoodsNumBySkuId(buyCartTemp.getGoodsSku());

            //检查库存
            if (goodsNumDb < goodsNum) {
                jsonResult.setMessage("库存数不够");
                return jsonResult;
            }
            int count = buyCartMapper.updateCartNumByCartIdAndCustId(cartId, custId, goodsNum, buyCartTemp.getGoodsNum());
            if (count == 0) {
                jsonResult.setMessage("修改购物车数量失败");
                return jsonResult;
            }
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("修改购物车数量" + e.getMessage(), e);
            }

        }
    }


    /**
     * 单个活多个移除购物车
     *
     * @param cartId cartId 逗号分隔
     * @param custId 客户id
     * @return
     */
    public JsonResult removeCart(String custId, String cartId, Byte isPro) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            List<String> arrSelected = new ArrayList<>();
            arrSelected = Arrays.asList(cartId.split(","));

            int count = 0;
            if (arrSelected.size() == 1) {
                count = buyCartMapper.removeCartByCartIdAndCustId(cartId, custId, isPro);
            } else {
                count = buyCartMapper.removeCartByCartIdsAndCustId(arrSelected, custId, isPro);
            }
            if (count == 0) {
                jsonResult.setMessage("移除购物车失败");
                return jsonResult;
            }
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("单个移除购物车" + e.getMessage(), e);
            }
        }
    }
}
