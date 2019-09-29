package com.louquanapp.biz;

import com.alibaba.fastjson.JSON;
import com.github.binarywang.wxpay.bean.request.WxPayRefundRequest;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.Arith;
import com.huhuamin.common.utils.DateUtils;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.dao.mapper.*;
import com.louquanapp.dao.mapper.UserMoneyMapper;
import com.louquanapp.dao.model.*;
import com.louquanapp.model.PageJsonResult;
import com.louquanapp.model.ReqForPageInfo;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.*;
import com.louquanapp.resp.RespOrder;
import com.louquanapp.service.JedisService;
import com.louquanapp.utils.BizUtils;
import com.louquanapp.utils.DatesUtil;
import com.louquanapp.utils.HttpUtils;
import jodd.util.StringUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/8 15:27
 * @Description: 订单业务逻辑
 */
@Service
public class OrderBiz {
    private final BuyCartMapper buyCartMapper;
    private final GoodsSkuMapper goodsSkuMapper;
    private final GoodsMapper goodsMapper;
    private final ShipAddressMapper shipAddressMapper;
    private final ShopMapper shopMapper;
    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;
    private final OrderOperateMapper orderOperateMapper;
    private final CustomerMapper customerMapper;
    private final OrderEvaluateMapper orderEvaluateMapper;
    private final CouponMapper couponMapper;
    private final CustomerPointMapper customerPointMapper;
    private final CustomerAccountMapper customerAccountMapper;
    private final JedisService jedisService;
    private final OrderReturnMapper orderReturnMapper;
    private final SystemParamMapper systemParamMapper;
    private final SettleOrderMapper settleOrderMapper;
    private final BuyCartBiz buyCartBiz;
    private final OrderPayMapper orderPayMapper;
    private final SystemUserMapper systemUserMapper;
    private final ExpressMapper expressMapper;
    private final VideoPlaninfoMapper videoPlaninfoMapper;
    private final UserMoneyMapper userMoneyMapper;



    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    @Value("${WECHAT_APPID}")
    private String appId;

    @Value("${WECHAT_MCH_ID}")
    private String mchId;
    @Value("${WECHAT_NOTIFY_REFUND_COUPON_URL}")
    private String notifyUrl;
    private final WxPayService wxPayService;


    public OrderBiz(BuyCartMapper buyCartMapper, GoodsSkuMapper goodsSkuMapper, GoodsMapper goodsMapper, ShipAddressMapper shipAddressMapper
            , ShopMapper shopMapper, OrderMapper orderMapper, OrderItemMapper orderItemMapper, OrderOperateMapper orderOperateMapper
            , CustomerMapper customerMapper, OrderEvaluateMapper orderEvaluateMapper, CouponMapper couponMapper, CustomerPointMapper customerPointMapper
            , CustomerAccountMapper customerAccountMapper, JedisService jedisService, OrderReturnMapper orderReturnMapper
            , SystemParamMapper systemParamMapper, SettleOrderMapper settleOrderMapper, BuyCartBiz buyCartBiz, OrderPayMapper orderPayMapper
            , WxPayService wxPayService,SystemUserMapper systemUserMapper,ExpressMapper expressMapper,VideoPlaninfoMapper videoPlaninfoMapper
            ,UserMoneyMapper userMoneyMapper) {
        this.buyCartMapper = buyCartMapper;
        this.goodsSkuMapper = goodsSkuMapper;
        this.goodsMapper = goodsMapper;
        this.shipAddressMapper = shipAddressMapper;
        this.shopMapper = shopMapper;
        this.orderMapper = orderMapper;
        this.orderItemMapper = orderItemMapper;
        this.orderOperateMapper = orderOperateMapper;
        this.customerMapper = customerMapper;
        this.orderEvaluateMapper = orderEvaluateMapper;
        this.couponMapper = couponMapper;
        this.customerPointMapper = customerPointMapper;
        this.customerAccountMapper = customerAccountMapper;
        this.jedisService = jedisService;
        this.orderReturnMapper = orderReturnMapper;
        this.systemParamMapper = systemParamMapper;
        this.settleOrderMapper = settleOrderMapper;
        this.buyCartBiz = buyCartBiz;
        this.orderPayMapper = orderPayMapper;
        this.wxPayService = wxPayService;
        this.systemUserMapper = systemUserMapper;
        this.expressMapper = expressMapper;
        this.videoPlaninfoMapper = videoPlaninfoMapper;
        this.userMoneyMapper = userMoneyMapper;
    }

    /**
     * 提交订单 0 未付款
     *
     * @param reqDoOrder
     * @return
     */
    @Transactional
    public synchronized TypeJsonResult<Map<String, String>> doOrder(ReqDoOrder reqDoOrder, String custId) {
        try {
            TypeJsonResult<Map<String, String>> jsonResult = new TypeJsonResult();

            if (reqDoOrder.getIsPromotion().intValue() == 2 && StringUtils.isEmpty(reqDoOrder.getShipId())) {
                jsonResult.setMessage("收货地址不能为空");
                return jsonResult;
            }

           /* if (reqDoOrder.getIsPromotion().intValue() == 1 && null == reqDoOrder.getPlanEatTime()) {
                jsonResult.setMessage("预计就餐时间不能为空");
                return jsonResult;
            }*/


            //门店优惠券备注
            List<ReqCouponOrder> reqCouponOrders = null;
            if (StringUtils.isNotEmpty(reqDoOrder.getCouponId())) {
                reqCouponOrders = JSON.parseArray(reqDoOrder.getCouponId(), ReqCouponOrder.class);
            }
            //门店备注
            List<ReqRemarkOrder> reqRemarkOrders = null;
            if (StringUtils.isNotEmpty(reqDoOrder.getRemark())) {
                reqRemarkOrders = JSON.parseArray(reqDoOrder.getRemark(), ReqRemarkOrder.class);
            }


            String cartIds = reqDoOrder.getSelectedCartId();
            List<String> arrSelected = Arrays.asList(cartIds.split(","));
            //购物车转订单业务
            Customer customer = customerMapper.selectByPrimaryKey(custId);

            Map<String, String> shopIdorderId = orderCommit(arrSelected, reqDoOrder, custId, BizUtils.getCustName(customer), reqCouponOrders, reqRemarkOrders);
            //jsonResult.setMessage(String.valueOf(buyCartService.countCartByCustId(custId)));
            jsonResult.setStatusCode(true);
            jsonResult.setType(shopIdorderId);
            return jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("下单" + e.getMessage(), e);
            }
        }
    }

    /**
     * 增加主订单信息
     *
     * @return
     */
    private Map<String, String> orderCommit(List<String> arrSelected, ReqDoOrder reqDoOrder, String custId, String custName, List<ReqCouponOrder> reqCouponOrders, List<ReqRemarkOrder> reqRemarkOrders) {


        // couponType 类型[1-商品优惠 2-店铺优惠 3-全场通用]

        Set<String> goodIds = new HashSet<>();


        List<BuyCart> buycarts = buyCartMapper.cartListByCustIdAndCartIds(custId, new ArrayList<String>(arrSelected), reqDoOrder.getIsPromotion());
        if (CollectionUtils.isEmpty(buycarts)) {
            throw new HuhuaminException("购物车数据不存在");
        }

        List<Shop> shops = BuyCartBiz.convertToMap(buycarts, shopMapper, goodsSkuMapper, goodsMapper);
        Map<String, String> shopIdOrderId = new HashMap<>();
        StringBuffer orderIds = new StringBuffer();

        shops.forEach(t -> {
            t.getBuyCarts().forEach(temp -> {
                goodIds.add(temp.getGoodsId());
            });
            //最大邮费
            Double maxPostFee = 0.00d;
            if (!org.apache.commons.collections.CollectionUtils.isEmpty(goodIds)) {
                maxPostFee = goodsMapper.maxPostFee(new ArrayList<>(goodIds));
              if(maxPostFee==null){
                  throw new HuhuaminException("商品已下架");
              }
            }


            ShipAddress shipAddress = shipAddressMapper.getAddressByCustIdAndShipId(custId, reqDoOrder.getShipId());

            //构建需要保存的订单主表
            // 优惠券 start


            ReqCouponOrder reqCouponOrder = null;
            if (!CollectionUtils.isEmpty(reqCouponOrders)) {
                reqCouponOrder = reqCouponOrders.stream().filter(temp -> temp.getShopId().equals(t.getShopId())).findAny().orElse(null);
            }
            Coupon couponResult = null;
            if (null != reqCouponOrder) {//店铺和通用卷直接用

                Coupon coupon = couponMapper.selectByPrimaryKey(reqCouponOrder.getCouponId());
                int result = couponMapper.updateCustomerCouponByCouponIdAndCustId(coupon.getCouponId(), custId);
                if (result == 0) {
                    throw new HuhuaminException(coupon.getCouponName().concat("优惠卷状态不正确"));
                }

                if (coupon.getCouponType().intValue() == 3 || (coupon.getCouponType().intValue() == 2 && coupon.getCouponConent().trim().equals(reqCouponOrder.getShopId()))) {
                    couponResult = coupon;

                } else if (coupon.getCouponType().intValue() == 1) {
                    BuyCart tp = t.getBuyCarts().stream().filter(temp -> temp.getGoodsId().equals(coupon.getCouponConent())).findAny().orElse(null);
                    if (tp != null) {
                        couponResult = coupon;
                    }
                }
                if (null == couponResult) {
                    throw new HuhuaminException(coupon.getCouponName().concat("使用非法"));
                }
            }
            Double discountsFee = 0.00d;
            String discountsDesc = "暂无";
            Double installFee = 0.00d;

            if (null != couponResult) {
                if (Arith.compareDoubleSize(t.getTotalFee(), couponResult.getMinMoney()) >= 0) {
                    if (Arith.compareDoubleSize(couponResult.getCouponMoney(), 1) < 0) {
                        discountsFee = Arith.mul(t.getTotalFee(), (1 - couponResult.getCouponMoney()));
                    } else {
                        discountsFee = couponResult.getCouponMoney();
                    }
                    discountsDesc = "使用" + couponResult.getCouponName() + ",优惠" + discountsFee + ",优惠券编号:" + couponResult.getCouponId();

                }


            }

            // 优惠券 end


            Double rechargePhone = 0.00d;
            Double rechargeOil = 0.00d;
            String orderNo = UUIDUtils.generateUuid20();
            ReqRemarkOrder reqRemarkOrder = null;
            String remark = "";
            if (!CollectionUtils.isEmpty(reqRemarkOrders)) {
                reqRemarkOrder = reqRemarkOrders.stream().filter(temp -> temp.getShopId().equals(t.getShopId())).findAny().orElse(null);
            }
            if (null != reqRemarkOrder) {
                remark = reqRemarkOrder.getRemark();
            }

            Order order = initDoOrder(orderNo, reqDoOrder, t, shipAddress, t.getTotalFee(), maxPostFee, t.getGoodsNum(), custId, custName, discountsFee, discountsDesc, installFee, t.getTotalPoint(), remark);
            //构建需要保存的订单子项
            List<OrderItem> orderItems = initOrderItemByDoOrder(buycarts, shipAddress, order);


//            if (!CollectionUtils.isEmpty(reqRemarkOrders)) {
//                reqRemarkOrder = reqRemarkOrders.stream().filter(temp -> temp.getShopId().equals(t.getShopId())).findAny().orElse(null);
//                if (null != reqCouponOrder) {
//                    order.setOrderRemark(reqRemarkOrder.getRemark());
//                }
//            }


            int result = 0;
            result = orderMapper.insert(order);
            if (result == 0) {
                throw new HuhuaminException("增加主单子项系统异常");
            }

            result = orderItemMapper.batchInsert(orderItems);
            if (result == 0) {
                throw new HuhuaminException("增加订单子项系统异常");
            }

            //构建需要保存的订单日志
            List<OrderOperate> orderOperates = initOrderOperate(orderItems, custId, custName, order.getAddTime());
            result = orderOperateMapper.batchInsert(orderOperates);
            if (result == 0) {
                throw new HuhuaminException("增加订单操作日志统异常");
            }

            //删除购物车
            List<String> listTempids = t.getBuyCarts().stream().map(BuyCart::getCartId).collect(Collectors.toList());

            //删除购物车
            result = buyCartMapper.removeCartByCartIdsAndCustId(listTempids, custId, reqDoOrder.getIsPromotion());
            if (result == 0) {
                throw new HuhuaminException("删除选中的购物车系统异常");
            }
            shopIdOrderId.put(t.getShopId(), order.getOrderId());
            shopIdOrderId.put("orderNo", orderNo);
            orderIds.append(order.getOrderId()).append(",");

        });
        String result = orderIds.toString();
        if (result.length() > 0) {
            result = result.substring(0, result.length() - 1);
        }
        shopIdOrderId.put("orderIds", result);
        return shopIdOrderId;


    }


    /**
     * 提交订单初始化数据
     *
     * @param orderItems
     * @param custId
     * @param custName
     * @return
     */
    private List<OrderOperate> initOrderOperate(List<OrderItem> orderItems, String custId, String custName, Date now) {
        List<OrderOperate> listTemp = new ArrayList<>();


        for (OrderItem temp : orderItems
        ) {

            OrderOperate orderOperate = new OrderOperate();
            orderOperate.setOptId(temp.getChildId());
            orderOperate.setOrderId(temp.getOrderId());
            orderOperate.setChildId(temp.getChildId());
            orderOperate.setOrderStatusBefore(101);
            orderOperate.setOrderStatusNow(101);
            orderOperate.setOptRemark(custName.concat("下单"));
            orderOperate.setOptSource("buyer");
            orderOperate.setUserId(custId);
            orderOperate.setUserName(custName);
            orderOperate.setAddTime(now);
            listTemp.add(orderOperate);
        }
        return listTemp;
    }

    @Transactional
    public synchronized TypeJsonResult<String> execMeiShiPay(ReqDoMeishiOrder reqSource, String custId, String token) {
        try {
            TypeJsonResult<String> typeJsonResult = new TypeJsonResult<>();
            StringBuffer sb = new StringBuffer();
            String goodsIds = reqSource.getGoodsIds();
            List<String> lst = Arrays.asList(goodsIds.split(","));
            List<String> goodsNum = Arrays.asList(reqSource.getGoodsNum().split(","));
            int i = 0;
            for (String goodsId : lst
            ) {
                String skuId = goodsSkuMapper.getDefaultSkuIdByGoodsId(goodsId);
                TypeJsonResult<String> str = buyCartBiz.buyCart(skuId, custId, Integer.valueOf(goodsNum.get(i)), true, token, (byte) 1);
                if (!str.getStatusCode()) {
                    throw new HuhuaminException(str.getMessage());
                }
                sb.append(str.getType()).append(",");
                i++;
            }
            String selectCarId = sb.toString();

            selectCarId = selectCarId.substring(0, selectCarId.length() - 1);
            typeJsonResult.setType(selectCarId);
            typeJsonResult.setStatusCode(true);
            return typeJsonResult;


        } catch (Exception e) {
            String msg = "在美食下单";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage(), e);
        }

    }
//
//        try {
//            TypeJsonResult<String> typeJsonResult = new TypeJsonResult<>();

//    public TypeJsonResult<String> execMeiShiPay(ReqDoMeishiOrder reqSource, String custId) {
//
//        try {
//            TypeJsonResult<String> typeJsonResult = new TypeJsonResult<>();
//
//            String custName = BizUtils.getCustName(customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(custId));
//            String goodsIds = reqSource.getGoodsIds();
//            List<String> lst = Arrays.asList(goodsIds.split(","));
//            List<String> goodsNum = Arrays.asList(reqSource.getGoodsNum().split(","));
//            List<OrderItem> orderItems = new ArrayList<>();
//            String orderId = UUIDUtils.generateUuid22();
//            Date now = new Date();
//            int i = 0;
//            Integer goodsNumTotal = 0;
//            Double orderFee = 0.00d;
//            for (String goodsId : lst
//            ) {
//                GoodsSku goodsSku = goodsSkuMapper.getGoodsSkuShortByGoodsId(goodsId);
//                OrderItem orderItem = new OrderItem();
//                orderItem.setChildId(UUIDUtils.generateUuid22());
//                orderItem.setOrderId(orderId);
//                orderItem.setAddTime(now);
//                orderItem.setGoodsId(goodsId);
//                Goods goods = goodsMapper.selectShort(goodsId);
//                if (null != goodsSku) {
//                    orderItem.setSupplyPrice(goodsSku.getSupplierPrice());
//                    if (StringUtils.isNotEmpty(goodsSku.getGoodsImg())) {
//                        orderItem.setGoodsImg(goodsSku.getGoodsImg());
//                    }
//                    orderItem.setSkuValue(goodsSku.getSkuRule());
//                    if (StringUtils.isNotEmpty(goodsSku.getSkuRule()) && "0:0".equals(goodsSku.getSkuRule())) {
//                        orderItem.setSkuValue("无规格");
//                    } else {
//                        orderItem.setSkuValue(goodsSku.getSkuGoodsName().replace(goods.getGoodsName(), ""));
//                    }
//
//                    orderItem.setGoodsName(goodsSku.getSkuGoodsName());
//                    orderItem.setPutawayPrice(goodsSku.getPutawayPrice());
//                }
//                orderItem.setCatPath(goods.getCatPath());
//
//
//                orderItem.setSkuNo(goodsSku.getSkuId());
//                orderItem.setSupplyPrice(goodsSku.getSupplierPrice());
//                orderItem.setGoodsNum(Integer.valueOf(goodsNum.get(i)));
//                i++;
//                orderItem.setTotalFee(Arith.mul(orderItem.getGoodsNum(), orderItem.getPutawayPrice()));
//                orderItem.setAddTime(now);
//                orderItem.setUpdateTime(now);
//                orderItems.add(orderItem);
//                goodsNumTotal = goodsNumTotal + orderItem.getGoodsNum();
//
//                orderFee = Arith.add(orderFee, Arith.mul(orderItem.getGoodsNum(), orderItem.getPutawayPrice()));
//
//            }
//            String shopId = customerMapper.selectShopIdBuyVideoId(reqSource.getVideoId());
//            Order order = initDoOrder(orderId, shopId, custId, custName, goodsNumTotal, orderFee, reqSource.getRegisterSource());
//
//
//            int result = orderItemMapper.batchInsert(orderItems);
//            if (result == 0) {
//                throw new HuhuaminException("增加订单子项系统异常");
//            }
//
//            result = orderMapper.insert(order);
//            if (result == 0) {
//                throw new HuhuaminException("增加主单子项系统异常");
//            }
//
//            //构建需要保存的订单日志
//            List<OrderOperate> orderOperates = initOrderOperate(orderItems, custId, custName, order.getAddTime());
//            result = orderOperateMapper.batchInsert(orderOperates);
//            if (result == 0) {
//                throw new HuhuaminException("增加订单操作日志统异常");
//            }
//
//            typeJsonResult.setType(order.getOrderId());
//            typeJsonResult.setStatusCode(true);
//            return typeJsonResult;
//        } catch (Exception e) {
//            String msg = "";
//            msg = String.format("在%s过程中,服务器开小差了", msg);
//            if (e instanceof HuhuaminException) {
//                throw new HuhuaminExceptionPlan(e.getMessage());
//            }
//            throw new HuhuaminException(msg + e.getMessage(), e);
//        }
//
//
//    }

    /**
     * @param orderNo
     * @param shopId
     * @param custId
     * @param custName
     * @param goodsNum
     * @param orderFee
     * @param registerSource
     * @return
     */
    private Order initDoOrder(String orderNo, String shopId, String custId, String custName, Integer goodsNum, Double orderFee, Byte registerSource) {
        Date now = new Date();
        Order order = new Order();
        Shop shop = shopMapper.selectByPrimaryKey(shopId);

        order.setOrderId(orderNo);
        order.setShopId(shopId);
        order.setShopName(shop.getShopName());
        order.setShopTitle(shop.getShopTitle());
        order.setAuthType(shop.getAuthType().intValue());
        order.setCustId(custId);
        order.setCustName(custName);
        order.setOrderNo(orderNo);
        order.setOrderStatus(101);
        order.setRmbAmt(0.00d);
        order.setConsumeAmt(0.00d);
        order.setIsPromotion((byte) 1);

//        order.setIsPromotion();

        order.setGoodsNum(goodsNum);
        order.setPayType((byte) 0);
        order.setPostInfo("上门吃饭");
        order.setOrderSource(registerSource);
        order.setAnonyFlag((byte) 2);
        order.setAddTime(now);
        order.setDiscountsDesc("");
        order.setDiscountsFee(0.00d);
        order.setInstallFee(0.00d);
        order.setCurrencyStatus((byte) 1);
        order.setReleaseFlag((byte) 0);
        order.setPointTimes(1);
        order.setDeltFlag((byte) 1);

        //可使用抵扣积分
        order.setDeductionAmt(0.00);

        order.setSendRule("default");

        order.setMaxPoint(0.00d);
        order.setOrderFee(orderFee);
        order.setTotalFee(orderFee);
//
        order.setPostFee(0.00d);


        order.setUpdateTime(now);
        //订单有效时间1小时
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);

        cal.add(Calendar.HOUR_OF_DAY, 3);
        order.setOverdueTime(cal.getTime());
        return order;
    }


    private List<OrderItem> initOrderItemByDoOrder(List<BuyCart> buycart, ShipAddress shipAddress, Order order) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (BuyCart temp : buycart
        ) {
            OrderItem orderItem = new OrderItem();
            orderItem.setChildId(UUIDUtils.generateUuid22());
            orderItem.setOrderId(order.getOrderId());
            orderItem.setAddTime(order.getAddTime());
            orderItem.setGoodsId(temp.getGoodsId());
            //如果默认规格的 没有图片去主账号找
            String skuId = temp.getGoodsSku();
            //若果sku里面有图片 从sku里面去
            GoodsSku goodsSku = goodsSkuMapper.selectByPrimaryKey(skuId);
            Goods goods = goodsMapper.selectShort(goodsSku.getGoodsId());
            if (null != goodsSku) {
                orderItem.setSupplyPrice(goodsSku.getSupplierPrice());
                if (StringUtils.isNotEmpty(goodsSku.getGoodsImg())) {
                    orderItem.setGoodsImg(goodsSku.getGoodsImg());
                }
                orderItem.setSkuValue(goodsSku.getSkuRule());
                if (StringUtils.isNotEmpty(goodsSku.getSkuRule()) && "0:0".equals(goodsSku.getSkuRule())) {
                    orderItem.setSkuValue("无规格");
                } else {
                    orderItem.setSkuValue(goodsSku.getSkuGoodsName().replace(goods.getGoodsName(), ""));
                }

                orderItem.setGoodsName(goodsSku.getSkuGoodsName());
                orderItem.setPutawayPrice(goodsSku.getPutawayPrice());
            }

            orderItem.setCatPath(goods.getCatPath());
            //如果默认规格的 没有图片去主账号找
            if (StringUtils.isEmpty(temp.getGoodsImg()) || null == goodsSku) {
                orderItem.setGoodsImg(goods.getGoodsImg());
                orderItem.setGoodsName(goods.getGoodsName());
            }
            orderItem.setSkuNo(skuId);
            orderItem.setGoodsNum(temp.getGoodsNum());
            orderItem.setTotalFee(Arith.mul(orderItem.getGoodsNum(), orderItem.getPutawayPrice()));
            orderItem.setAddTime(order.getAddTime());
            orderItem.setUpdateTime(order.getUpdateTime());
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    /**
     * 初始化要保存的订单
     *
     * @param isPro         餐饮[1-是 2-否]
     * @param reqDoOrder
     * @param shop
     * @param shipAddress
     * @param totalFee
     * @param postFee
     * @param goodsNum
     * @param custId
     * @param custName
     * @param discountsFee
     * @param discountsDesc
     * @param installFee
     * @return
     */
    private Order initDoOrder(String orderNo, ReqDoOrder reqDoOrder, Shop shop, ShipAddress shipAddress, Double totalFee, Double postFee, Integer goodsNum, String custId, String custName, Double discountsFee, String discountsDesc, Double installFee, Double maxPoint, String remark) {
        Date now = new Date();
        Order order = new Order();
        order.setOrderRemark(remark);

        order.setOrderId(UUIDUtils.generateUuid22());
        order.setShopId(shop.getShopId());
        order.setShopName(shop.getShopName());
        order.setShopTitle(shop.getShopName());
        order.setAuthType(shop.getAuthType().intValue());
        order.setCustId(custId);
        order.setCustName(custName);
        order.setOrderNo(orderNo);
        order.setOrderStatus(101);
        order.setRmbAmt(0.00d);
        order.setConsumeAmt(0.00d);
        order.setIsPromotion((reqDoOrder.getIsPromotion().byteValue()));

//        order.setIsPromotion();

        order.setGoodsNum(goodsNum);
        order.setPayType((byte) 0);
        if (reqDoOrder.getIsPromotion().intValue() == 1) {
            order.setPostInfo("自取");
            //order.setPlanEatTime(reqDoOrder.getPlanEatTime());
        } else {

            order.setPostInfo(shipAddress.getAreaPath().concat("|").concat(shipAddress.getReceiveAddr()).concat("|").concat(shipAddress.getReceiverName()).concat("|").concat(shipAddress.getLinkPhone()));
        }


        order.setOrderSource(reqDoOrder.getRegisterSource());
        order.setAnonyFlag((byte) 2);
        order.setAddTime(now);
        order.setDiscountsDesc(discountsDesc);
        order.setDiscountsFee(discountsFee);
        order.setInstallFee(installFee);
        order.setCurrencyStatus((byte) 1);
        order.setReleaseFlag((byte) 0);
        order.setPointTimes(1);
        order.setDeltFlag((byte) 1);
        order.setOrderSource(reqDoOrder.getRegisterSource());
        //可使用抵扣积分
        order.setDeductionAmt(0.00);

        order.setSendRule("default");

        //优惠后的金额
        Double orderFee = Arith.sub(Arith.add(totalFee, postFee), discountsFee);
        maxPoint = maxPoint == null ? 0.00d : maxPoint;
//        Double maxOrder = Arith.sub(Arith.add(maxPoint, postFee), discountsFee);
        order.setMaxPoint(maxPoint);
        order.setOrderFee(orderFee);
        order.setTotalFee(totalFee);
        order.setPostFee(postFee);
        order.setUpdateTime(now);
        //订单有效时间1小时
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        //TODO 过期之后释放优惠券
        cal.add(Calendar.HOUR_OF_DAY, 3);
        order.setOverdueTime(cal.getTime());
        return order;
    }


    public Order selectOrderStatusByOrderNo(String orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }


    private Boolean convertToOrderItem(List<Order> list) {

        Set<String> orderIds = new HashSet<>();
        List<String> skus = new ArrayList<>();
        //如果是1个直接付值
        for (Order temp :
                list) {
            if (list.size() == 1) {
                List<OrderItem> lstShortOrderItem = orderItemMapper.getOrderItemByOrderId(temp.getOrderId());
                for (OrderItem orderItem : lstShortOrderItem
                ) {
//                    Double maxPointTemp = goodsSkuMapper.selectMaxPointPrimaryKey(orderItem.getSkuNo());
                    Double tt = goodsSkuMapper.selectMarketPricePrimaryKey(orderItem.getSkuNo());
                    orderItem.setMarketPrice(tt);
                    skus.add(orderItem.getSkuNo());
                    orderItem.setGoodsDesc( goodsMapper.selectGoodsImgAndCatPathAndGoodsNameAndPutawayFlagByPrimaryKey(orderItem.getGoodsId()).getGoodsDesc());
                }
                temp.setOrderItemList(lstShortOrderItem);
            } else {
                orderIds.add(temp.getOrderId());
            }
            temp.setShopType( shopMapper.selectShortByPrimaryKey(temp.getShopId()).getShopType());

        }
//        //一次请求数据库
        Map<String, List<OrderItem>> map = new HashMap<>();


        if (!CollectionUtils.isEmpty(orderIds) && orderIds.size() > 1) {
            //查询所有订单
            List<OrderItem> lstShortOrderItem = orderItemMapper.getOrderItemByOrderIds(new ArrayList<String>(orderIds));
            for (OrderItem shortOrderItem : lstShortOrderItem
            ) {
                skus.add(shortOrderItem.getSkuNo());
                if (map.containsKey(shortOrderItem.getOrderId())) {
                    map.get(shortOrderItem.getOrderId()).add(shortOrderItem);
                } else {
                    List<OrderItem> listTemp = new ArrayList();
                    listTemp.add(shortOrderItem);
                    map.put(shortOrderItem.getOrderId(), listTemp);
                }
                shortOrderItem.setGoodsDesc( goodsMapper.selectGoodsImgAndCatPathAndGoodsNameAndPutawayFlagByPrimaryKey(shortOrderItem.getGoodsId()).getGoodsDesc());
            }
            for (Order temp :
                    list) {
                temp.setOrderItemList(map.get(temp.getOrderId()));
            }
        }
        if (skus.size() == 1) {
            if (goodsSkuMapper.isPointBySkuNos(skus) == 1) {
                return false;
            }
        } else if (skus.size() > 1) {
            if (goodsSkuMapper.isPointBySkuNos(skus) > 0) {
                //throw new HuhuaminException("操作异常！");
            }
        }
        return true;


    }


    @Transactional
    public TypeJsonResult<RespOrder> settlementInfoOrderDetail(String userId,String moneyId) {
        UserMoney userMoney=userMoneyMapper.selectByPrimaryKey(moneyId);
        TypeJsonResult<RespOrder> jsonResult= orderDetail(userMoney.getOrderId(), userId, 2);

        if(StringUtils.isNotBlank(userMoney.getReturnId())){
            jsonResult.getType().setOrderReturnStatus((byte)2);
            OrderReturn orderReturn=orderReturnMapper.selectByPrimaryKey(userMoney.getReturnId());
            jsonResult.getType().setOrderReturn(orderReturn);

            List<OrderItem> orderItems =jsonResult.getType().getOrder().getOrderItemList();
            OrderItem orderI=new OrderItem();
            for(OrderItem orderItem:orderItems){
                if(orderItem.getChildId().equals(orderReturn.getChildId())){
                    orderI=orderItem;
                    break;
                }
            }
            orderItems.clear();
            orderItems.add(orderI);
            jsonResult.getType().getOrder().setOrderItemList(orderItems);

        }else {
            jsonResult.getType().setOrderReturnStatus((byte)1);
        }
        String shopId=systemUserMapper.queryShopIdByUserId(userId);
        Shop shop=shopMapper.selectShortByPrimaryKey(shopId);
        jsonResult.getType().setShopType(shop.getShopType());



       /* *//**
         * 退货申请信息
         *//*
        private OrderReturn orderReturn;
        *//**
         * 订单退款状态[1-非退款订单 1-退款订单]
         *//*
        private Byte orderReturnStatus;
        *//**
         * 商铺类型[商铺类型[1-产品类 2-服务类]]
         *//*
        private Byte shopType;*/



        return  jsonResult;
    }
    /**
     * 单个 订单
     *
     * @param orderId
     * @param custId
     * @param type    1-支付 2-查看
     * @return
     */
    @Transactional
    public TypeJsonResult<RespOrder> orderDetail(String orderId, String userId, Integer type) {
        try {
            boolean toPay = (null != type && 1 == type) ? true : false;
            TypeJsonResult<RespOrder> typeJsonResult = new TypeJsonResult<>();
            RespOrder respOrder = new RespOrder();

            String shopId=systemUserMapper.queryShopIdByUserId(userId);
            Set<String> setOrderIds = new HashSet<>();
            setOrderIds.addAll(Arrays.asList(orderId.split(",")));
            List<Order> list = orderMapper.orderDetailByOrderIdsAndShopId(shopId, new ArrayList<String>(setOrderIds));
            if (null == list || list.size() == 0) {
                typeJsonResult.setType(null);
                typeJsonResult.setStatusCode(false);
                typeJsonResult.setMessage("你访问的订单不存在");
                return typeJsonResult;
            }
            Order order = list.stream().findFirst().orElse(null);
            if (StringUtils.isEmpty(respOrder.getOrderNo())) {
                if (null != order) {
                    respOrder.setOrderNo(order.getOrderNo());
                }

            }
            // 是否允许积分兑换
            Boolean isPoint = true;
            if (!toPay) {
                isPoint = convertToOrderItem(list);
                list.forEach(t -> {
                    if (t.getOrderStatus().intValue() != 101 && type == 1) {
                        throw new HuhuaminException(t.getOrderId().concat("订单状态[" + t.getOrderStatus() + "]不正确"));
                    }
                    t.setNickName(customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(t.getCustId()).getNickName());
                    ////查询订单操作记录
                    List<OrderOperate> listTempOrderOperate = orderOperateMapper.getListByOrderIdAndDefaultStatus(orderId);
                    List<OrderOperate> orderOperateList = new ArrayList();
                    //101,201,401,501
                    if (StringUtils.isNotEmpty(t.getPostInfo()) && t.getIsPromotion() == 2) {
                        String[] arrayStr = t.getPostInfo().split("\\|");
                        t.setAreaPath(arrayStr[0]);
                        t.setReceiveAddr(arrayStr[1]);
                        t.setReceiverName(arrayStr[2]);
                        t.setLinkPhone(arrayStr[3]);
                    }
                    Set<String> childIds = new HashSet<>();
                    Set<String> skuNos = new HashSet<>();
                    String postNo = "";
                    String postCompany = "";
                    for (OrderItem temp22 :
                            t.getOrderItemList()) {
                        if (StringUtils.isNotEmpty(temp22.getPostNo())) {
                            postNo = temp22.getPostNo();
                        }
                        if (StringUtils.isNotEmpty(temp22.getPostNo())) {
                            postCompany = temp22.getPostCompany();
                        }
                        childIds.add(temp22.getChildId());
                        skuNos.add(temp22.getSkuNo());
                    }

                    t.setPostCompany(postCompany);
                    t.setPostNo(postNo);


                    if (StringUtils.isNotBlank(postCompany) && StringUtils.isNotBlank(postNo)) {
                        String json = jedisService.getValueByKey(postNo);
                        if (StringUtils.isNotBlank(json)) {
                            t.setPostJson(json);
                        } else {
                            String result = getExpressInfo(postNo, postCompany.toLowerCase());
                            //1小时过期
                            jedisService.setKeyValue(postNo, result, 3600);
                            t.setPostJson(result);
                        }
                    }


                    CountDownLatch countDownLatch = new CountDownLatch(2);

                    AtomicReference<Double> maxPoint = new AtomicReference<>(0.00d);
                    CompletableFuture.runAsync(() -> {//第二个线程 计算最大使用积分
                        List<String> listChildIdsEvaluate = orderEvaluateMapper.childIds(childIds, shopId);

                        List<String> listChildIdsReturn = orderReturnMapper.childIds(childIds, shopId);
                        for (OrderItem temp :
                                t.getOrderItemList()) {
                            if (listChildIdsEvaluate.size() > 0) {
                                temp.setEvaluate(true);
                            } else {
                                temp.setEvaluate(false);
                            }
                            if (listChildIdsReturn.size() > 0) {
                                temp.setAfterSale(true);
                            } else {
                                temp.setAfterSale(false);
                            }

                        }
                        countDownLatch.countDown();

                    }).runAsync(() -> {//第三个线程 查询和计算操作记录
                        try {
                            Map<Integer, OrderOperate> map = null;
                            map = convertMapShortOrderOperateKeyOrderStatusNow(listTempOrderOperate);
                            if (map.containsKey(101)) {
                                orderOperateList.add(map.get(101));
                            }
                            if (map.containsKey(201)) {
                                orderOperateList.add(map.get(201));
                            } else {
                                OrderOperate shortOrderOperate = new OrderOperate();
                                shortOrderOperate.setOrderStatusNow(201);
                                orderOperateList.add(shortOrderOperate);
                            }

                            if (map.containsKey(401)) {
                                orderOperateList.add(map.get(401));
                            } else {
                                OrderOperate shortOrderOperate = new OrderOperate();
                                shortOrderOperate.setOrderStatusNow(401);
                                orderOperateList.add(shortOrderOperate);
                            }

                            if (map.containsKey(501)) {
                                orderOperateList.add(map.get(501));
                            } else {
                                OrderOperate shortOrderOperate = new OrderOperate();
                                shortOrderOperate.setOrderStatusNow(501);
                                orderOperateList.add(shortOrderOperate);
                            }
                            t.setShortOrderOperates(orderOperateList);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        countDownLatch.countDown();

                    });
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                });
            } else {
                isPoint = convertToOrderItem(list);
            }
            respOrder.setPoint(isPoint);
            typeJsonResult.setType(respOrder);
            typeJsonResult.setStatusCode(true);
            if (!CollectionUtils.isEmpty(list)) {
                if (list.size() == 1) {
                    respOrder.setOrder(list.get(0));

                   if(1==list.get(0).getIsPromotion()){
                       VideoPlaninfo videoPlaninfo=videoPlaninfoMapper.queryPlaninfoByOrderId(list.get(0).getOrderId(),shopId);
                       if(null!=videoPlaninfo){
                           list.get(0).setVideoPlaninfo(videoPlaninfo);
                       }

                   }
                }
            }
            return typeJsonResult;

        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("查询单个订单" + e.getMessage(), e);
            }
        }
    }

    private Map<Integer, OrderOperate> convertMapShortOrderOperateKeyOrderStatusNow(List<OrderOperate> listTempOrderOperate) {
        Map<Integer, OrderOperate> map = new HashMap<>();
        for (OrderOperate temp :
                listTempOrderOperate) {
            map.put(temp.getOrderStatusNow(), temp);
        }
        return map;
    }

    /**
     * 调用支付
     *
     * @param reqSource
     * @param custId
     * @return
     */
    @Transactional
    public synchronized TypeJsonResult execPay(ReqPayOrder reqSource, String custId) {
        Integer payType = null;

        TypeJsonResult<RespOrder> typeJsonResult = new TypeJsonResult<>();
        typeJsonResult.setStatusCode(false);
        //本地使用的抵扣积分
        Double deductionPoint = reqSource.getDeductionPoint() == null ? 0.00d : reqSource.getDeductionPoint();

        if (reqSource.getPayType().intValue() == 3) {
            Customer customer = customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(custId);
            if (StringUtils.isEmpty(customer.getPayPwd())) {
                typeJsonResult.setMessage("支付密码未设置");
                return typeJsonResult;
            } else {
                String userPwd = DigestUtils.md5Hex(reqSource.getPayPwd());
                if (!customer.getPayPwd().equals(userPwd)) {
                    typeJsonResult.setMessage("支付密码不正确");
                    return typeJsonResult;
                }
            }

        }


        typeJsonResult = orderDetail(reqSource.getOrderIds(), custId, 1);
        if (!typeJsonResult.getStatusCode()) {
            return typeJsonResult;
        }
        try {
            typeJsonResult.setStatusCode(false);
            RespOrder respOrder = typeJsonResult.getType();
            //判断使用的积分是否大于用户积分
            if (null != respOrder && Arith.compareDoubleSize(deductionPoint, respOrder.getRemainPoint()) > 0) {
                typeJsonResult.setMessage("当前剩余积分[" + respOrder.getRemainPoint() + "]本次支付本次积分[" + reqSource.getDeductionPoint() + "],积分不足");
                return typeJsonResult;
            }


            //最后支付的积分
            Double deductionAmt = 0.00d;
            //最后支付的现金
            Double consumeAmt = 0.00d;
            Double endPayMoney = 0.00;
            String orderNo = typeJsonResult.getType().getOrderNo();
            //支付余额=总积分-使用积分
            Double endRemainMoney = 0.00d;
            double needPoint = Arith.add(respOrder.getMaxPoint(), respOrder.getPostFee());
            if (Arith.compareDoubleSize(reqSource.getDeductionPoint() == null ? 0.00d : reqSource.getDeductionPoint(), 0.00) > 0) {
                endRemainMoney = Arith.sub(respOrder.getMaxPoint(), deductionPoint);
            } else {
                endRemainMoney = respOrder.getPayMoney();
            }

            //积分够支付
            if (reqSource.getPayType().intValue() == 4) {
                //支付渠道 [0-未付款 1-纯消费积分
                payType = 1;
                if (Arith.compareDoubleSize(endRemainMoney, 0.00) > 0) {
                    typeJsonResult.setMessage("当前剩余积分[" + respOrder.getRemainPoint() + "]本次支付本次积分[" + respOrder.getMaxPoint() + "],邮费消耗积分[" + endRemainMoney + "],合计积分[" + needPoint + "],积分不足");
                    return typeJsonResult;
                }
                deductionAmt = respOrder.getMaxPoint();
            }

            //积分不够 +余额
            //余额支付
            if (reqSource.getPayType().intValue() == 3) {
                //2-积分+余额  5-纯余额]dcdg_bussiness_order_base.PAY_TYPE
                if (Arith.compareDoubleSize(endRemainMoney, respOrder.getRemainMoney()) > 0) {
                    typeJsonResult.setMessage("余额[" + respOrder.getRemainMoney() + "]不够支付本次支付[" + endRemainMoney + "]");
                    return typeJsonResult;
                }
                //余额够 不用积分 用的是订单总额 用积分 是总积分-使用积分
                consumeAmt = endRemainMoney;
                deductionAmt = deductionPoint;
                if (Arith.compareDoubleSize(deductionAmt, 0.00) > 0) {
                    payType = 2;
                } else {
                    payType = 5;
                }
                //TODO直接改订单状态，及增加订单日志
            }
            //剩余支付金额
            endPayMoney = endRemainMoney;
            if (reqSource.getPayType().intValue() == 4 || reqSource.getPayType().intValue() == 3 || Arith.compareDoubleSize(endPayMoney, 0.00d) <= 0) {
                if (Arith.compareDoubleSize(endPayMoney, 0.00d) > 0) {
                    endPayMoney = Arith.sub(endPayMoney, consumeAmt);
                }
                JsonResult jsonResult = doOrderPaySuccess(orderNo, orderNo, orderNo, endPayMoney, consumeAmt, deductionAmt, 1, payType,1);


                if (!jsonResult.getStatusCode()) {
                    typeJsonResult.setMessage(jsonResult.getMessage());
                    return typeJsonResult;
                }
            }
            if (reqSource.getPayType().intValue() == 1 || reqSource.getPayType().intValue() == 2) {
                //积分大于0 余额支付
                int reuslt = orderMapper.updateDeductionAmtByOrderNo(deductionAmt, orderNo);
                if (reuslt == 0) {
                    typeJsonResult.setMessage("更新消费的积分失败");
                    return typeJsonResult;
                }
                respOrder.setEndPayMoney(endPayMoney);
            }

            typeJsonResult.setStatusCode(true);
            return typeJsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException || e instanceof HuhuaminExceptionPlan) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException("执行支付异常", e);
        }
    }

    /**
     * @param orderNo      订单号
     * @param serialNo     序列号
     * @param xml          xml/json数据
     * @param endPayMoney  支付现金 支付宝或者微信
     * @param consumeAmt   支付余额
     * @param deductionAmt 支付积分
     * @param type         1-直接支付 2-回调支付
     * @param payType      [0-未付款 1-纯消费积分 2-积分+余额   5-纯余额  3-积分+微信 4-纯微信 6-积分+支付宝 7-纯支付宝] (后台完成是 1 2 5)
     * @param deductionType   1-需要扣减 2-不需要扣减
     * @return
     */
    @Transactional
    public synchronized JsonResult doOrderPaySuccess(String orderNo, String serialNo, String xml, Double endPayMoney, Double consumeAmt, Double deductionAmt, Integer type, Integer payType,Integer deductionType) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            Date now = new Date();
            //锁查询为了安全啊 ，同一个订单锁，主键行锁
//            Order order = orderService.getOrderByOrderIdLock(orderId);
            List<String> orderIds = orderMapper.getOrderIdsByOrderNo(orderNo);
            if (CollectionUtils.isEmpty(orderIds)) {
                jsonResult.setMessage(orderNo + "订单没查到");
                return jsonResult;
            }



            //支付渠道 [0-未付款 1-纯消费积分 2-积分+余额 3-积分+现金 4-纯现金]dcdg_bussiness_order_base.PAY_TYPE

            Map<String, Order> mapOrder = new HashMap<>();
            AtomicBoolean hashSend = new AtomicBoolean(false);

            AtomicReference<Double> totalPoint1 = new AtomicReference<>(0.00d);
            AtomicReference<Double> totalOrder1 = new AtomicReference<>(0.00d);
            orderIds.forEach(orderId -> {
                Order order = orderMapper.selectByPrimaryKeyLock(orderId);
                mapOrder.put(orderId, order);
                //订单积分金额
                Double totalPointTemp = order.getMaxPoint();
                //订单现金金额
                Double totalOrderTemp = order.getOrderFee();
                totalOrderTemp = totalOrderTemp == null ? 0.00d : totalOrderTemp;
                totalPoint1.set(Arith.add(totalPoint1.get(), totalPointTemp));
                totalPointTemp = totalPointTemp == null ? 0.00d : totalPointTemp;
                totalOrder1.set(Arith.add(totalOrder1.get(), totalOrderTemp));
            });


            orderIds.forEach(orderId -> {
                Order order = mapOrder.get(orderId);
                if (order.getOrderStatus().intValue() == 101) {
                    order.setOrderId(orderId);
                    List<OrderItem> ordersItem = orderItemMapper.getOrderItemByOrderId(orderId);

                    for(OrderItem  item :ordersItem){
                        Goods goods = goodsMapper.selectGoodsImgAndCatPathAndGoodsNameAndPutawayFlagByPrimaryKey(item.getGoodsId());
                        if(goods==null){
                            throw new HuhuaminException("商品已下架");
                        }
                        if(goods.getPutawayFlag()==3){
                            throw new HuhuaminException("商品已下架");
                        }
                    }



                    Double tempConsumeAmt = 0.00;
                    Double temPDeductionAmt = 0.00d;
                    if (type == 2) {
                        tempConsumeAmt = order.getConsumeAmt() == null ? 0.00d : order.getConsumeAmt();
                        temPDeductionAmt = order.getDeductionAmt() == null ? 0.00d : order.getDeductionAmt();
                    } else {
                        tempConsumeAmt = consumeAmt;
                        temPDeductionAmt = deductionAmt;
                    }

                    if (payType != 4 & payType != 7) { // 4是微信 7是支付宝
                        order.setPayType(payType.byteValue());

                    } else {
                        if (payType == 4) {  //微信是4使用积分转之分加微信  3-积分+微信 4-纯微信
                            if (Arith.compareDoubleSize(temPDeductionAmt, 0.00d) > 0) {
                                order.setPayType((byte) 3);
                            } else {
                                order.setPayType((byte) 4);
                            }
                        } else if (payType == 7) { //支付宝 支付7 使用积分转之分加微信   6-积分+支付宝 7-纯支付宝
                            if (Arith.compareDoubleSize(temPDeductionAmt, 0.00d) > 0) {
                                order.setPayType((byte) 6);
                            } else {
                                order.setPayType((byte) 7);
                            }
                        }
                    }


                    int result = 0;
                    if (!hashSend.get()) {
                        //抵扣积分
                        Customer customer = customerMapper.selectByPrimaryKey(order.getCustId());
                        if (Arith.compareDoubleSize(temPDeductionAmt, 0.00d) > 0) {
//                          //减掉使用的抵扣积分
                            CustomerPoint customerPoint = initOrderUseGoodPointCustomerPoint(order.getCustId(), orderId, now, temPDeductionAmt, endPayMoney, false);
                            result = customerPointMapper.insert(customerPoint);
                            if (result == 0) {
                                throw new HuhuaminException("使用消费积分付款积分系统异常");
                            }
                        }
                        if (Arith.compareDoubleSize(tempConsumeAmt, 0.00d) > 0) {
                            //减掉使用的消费通抵扣积分
                            CustomerPoint customerPoint = initOrderUseGoodPointCustomerPoint(order.getCustId(), orderId, now, tempConsumeAmt, endPayMoney, true);
                            result = customerPointMapper.insert(customerPoint);
                            if (result == 0) {
                                throw new HuhuaminException("使用余额付款积分系统异常");
                            }
                        }
                        CustomerAccount customerAccount = customerAccountMapper.selectByPrimaryKey(customer.getCustId());

                        int onlineFlag = 1;//数据库字段：是否赠送[1-未赠送 2-已替上级赠送余额 3-已替上级赠送积分]dcdg_bussiness_customer_base.ONLINE_FLAG
                        //赠送邀请人
                        if (StringUtils.isNotBlank(customer.getInviterCode())) {
                            //赠送邀请人积分
                            SystemParam systemParam = RegisterBiz.sendPointByPay(orderId, customer.getInviterCode(), customer, SystemParamBiz.POINT_NUM_BUYER, SystemParamBiz.CONSUMER_NUM_BUYER, customerMapper, systemParamMapper, customerPointMapper);
                            if (null != systemParam) {
                                //邀请人账号表和客户表更新 start
                                if (SystemParamBiz.POINT_NUM_BUYER.equals(systemParam.getParamIndex().trim())) {
                                    if (!"0".equals(systemParam.getParamValue().trim())) {
                                        Double versionDeductionPoint = customerMapper.getDeductionPointByCustId(customer.getInviterCode());
                                        Double deductionPoint = Double.valueOf(systemParam.getParamValue());
                                        result = customerMapper.updatePlusDeductionPointBydVersionDeductionPointAndCustId(customer.getInviterCode(), deductionPoint, versionDeductionPoint);
                                        if (result == 0) {
                                            throw new HuhuaminException("更新邀请人积分系统异常");
                                        }
                                        result = customerAccountMapper.updatePlusDeductionPointBydVersionDeductionPointAndCustId(customer.getInviterCode(), deductionPoint, versionDeductionPoint);
                                        if (result == 0) {
                                            throw new HuhuaminException("更新邀请人余额系统异常");
                                        }
                                        onlineFlag = 3;
                                    }

                                } else if (SystemParamBiz.CONSUMER_NUM_BUYER.equals(systemParam.getParamIndex().trim())) {

                                    if (!"0".equals(systemParam.getParamValue().trim())) {
                                        Double versionConsumePoint = customerMapper.getConsumePointByCustId(customer.getInviterCode());
                                        Double comsumenPoint = Double.valueOf(systemParam.getParamValue());//多个不需要+，sql里面用+
                                        result = customerMapper.updatePlusConsumePointBydVersionConsumePointAndCustId(customer.getInviterCode(), comsumenPoint, versionConsumePoint);
                                        if (result == 0) {
                                            throw new HuhuaminException("更新邀请人积分系统异常");
                                        }
                                        result = customerAccountMapper.updatePlusConsumePointBydVersionConsumePointAndCustId(customer.getInviterCode(), comsumenPoint, versionConsumePoint);
                                        if (result == 0) {
                                            throw new HuhuaminException("更新邀请人余额系统异常");
                                        }

                                    }
                                    onlineFlag = 2;

                                }
                            }
                        }

                        //账号表和客户表更新 start
                        doPaySuccessCurCustomerAccountUpdate(order.getCustId(), customerAccount, now, temPDeductionAmt, endPayMoney, tempConsumeAmt);
                        doPaySuccessCurCustomerUpdate(customer, temPDeductionAmt, tempConsumeAmt, endPayMoney, onlineFlag);


                        //账号表和客户表更新 end
                        hashSend.set(true);

                    }


                    //构建需要保存的订单日志
                    List<OrderOperate> orderOperates = initPayOrderOperate(ordersItem, order.getCustId(), order.getCustName(), xml, now);

                    result = orderOperateMapper.batchInsert(orderOperates);
                    if (result == 0) {
                        throw new HuhuaminException("增加订单子项系统异常");
                    }


                    Double tempConsumeAmt2 = Arith.mul(order.getOrderFee(), Arith.div(consumeAmt, totalOrder1.get()));
                    Double tempRmt = Arith.mul(order.getOrderFee(), Arith.div(endPayMoney, totalOrder1.get()));
                    Double tempDe = 0d;
                    if (deductionAmt != 0d) {
                        //tempDe = Arith.add(order.getMaxPoint(), Arith.div(deductionAmt, totalPoint1.get()));
                        tempDe = deductionAmt;
                    }


                    //更新使用的现金或者 余额
                    result = orderMapper.updateOrderStatusAndRmbAmtAndUpdateTimeAndConsumeAmt(201, tempRmt, orderId, now, tempConsumeAmt2, tempDe, payType, serialNo);
                    if (result == 0) {
                        throw new HuhuaminException("修改订单号" + order.getOrderNo() + "订单状态系统异常");
                    }
                    // 商品是否下架

                    // 支付成功之后 扣减库存   List<OrderItem> ordersItem = orderItemMapper.getOrderItemByOrderId(orderId);
                    if(deductionType==1){
                        for (OrderItem orderItem : ordersItem) {
                            int count = goodsSkuMapper.updateStockCountBySkuIdAndGoodsNum(orderItem.getSkuNo(), orderItem.getGoodsNum());
                            if (count == 1) {
                                if (goodsMapper.deductionStockCountForGoods(orderItem.getGoodsId(), orderItem.getGoodsNum()) != 1) {
                                    throw new HuhuaminException( "库存不足");
                                }
                            } else {
                                throw new HuhuaminException("库存不足！");
                            }
                        }
                    }



//                    try {
//                        String custName = BizUtils.getCustName(customer);
//
//                        String contentTemplate2 = customer.getCustPhone() + custName + "下单成功，请注意查看及发货";
//                        sendPhone.sendValidCode(session, "19946698755", contentTemplate2, HhmConstants.PRE_FIX_PHONE_REG);
//                    } catch (Exception e) {
//
//                    }
                } else {
                    throw new HuhuaminException("修改订单号" + order.getOrderNo() + "订单状态状态不正确");
                }
            });

            orderIds.forEach(orderId -> {
                Order order = mapOrder.get(orderId);
                SettleOrder settleOrder = new SettleOrder();
                settleOrder.setOrderId(orderId);
                settleOrder.setAddTime(now);
                if (consumeAmt == 0) {
                    settleOrder.setConsumePoint(0d);
                } else {
                    settleOrder.setConsumePoint(Arith.mul(order.getOrderFee(), Arith.div(consumeAmt, totalOrder1.get())));
                }


                if (endPayMoney == 0d) {
                    settleOrder.setRmtAmt(0d);
                } else {
                    settleOrder.setRmtAmt(Arith.mul(order.getOrderFee(), Arith.div(endPayMoney, totalOrder1.get())));
                }
                if (deductionAmt == 0d) {
                    settleOrder.setDeductionPoint(0d);
                } else {
                    settleOrder.setDeductionPoint(Arith.mul(order.getMaxPoint(), Arith.div(deductionAmt, totalPoint1.get())));
                }


                settleOrder.setSettleStatus((byte) 1);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(now);
                calendar.add(Calendar.DAY_OF_MONTH, 15);
                settleOrder.setEndTime(calendar.getTime());
                settleOrder.setSettleId(UUIDUtils.generateUuid22());
                settleOrder.setShopId(order.getShopId());
                settleOrder.setShopName(order.getShopName());
                settleOrder.setIsPromotion(order.getIsPromotion());
                settleOrder.setGoodsNum(order.getGoodsNum());
                settleOrderMapper.insert(settleOrder);
                //增加结算记录
            });
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("支付订单" + e.getMessage(), e);
            }

        }
    }

    /**
     * 客户表修改积分信息
     *
     * @param customer       客户
     * @param deductionPoint 使用的积分
     * @param consumePoint   使用的余额
     * @param rmt            使用的现金
     */
    public int doPaySuccessCurCustomerUpdate(Customer customer, Double deductionPoint, Double consumePoint, Double rmt, Integer onlineFlag) {
        deductionPoint = deductionPoint == null ? 0.00d : deductionPoint;
        consumePoint = consumePoint == null ? 0.00d : consumePoint;
        Customer customerUpate = new Customer();
        customerUpate.setConsumePoint(customer.getConsumePoint());

        customerUpate.setConsumePoint(Arith.sub(customer.getConsumePoint() == null ? 0.00d : customer.getConsumePoint(), consumePoint));
        customerUpate.setCustId(customer.getCustId());
        //乐观锁条件
        customerUpate.setVersionDeductionPoint(customer.getDeductionPoint() == null ? 0.00d : customer.getDeductionPoint());
        customerUpate.setDeductionPoint(Arith.sub(customer.getDeductionPoint() == null ? 0.00d : customer.getDeductionPoint(), deductionPoint));
        customerUpate.setOnlineFlag(onlineFlag.byteValue());
        return customerMapper.updateDeductionPointAndConsumePointByCustIdAndVersionDeductionPoint(customerUpate);
    }


    /**
     * 支付成功的时候，送完分修改账号的信息
     *
     * @param custId
     * @param originCustomerAccount
     * @param now
     * @param minusDeductionPoint
     * @param rmbAmt
     * @param consumePoint
     */
    public void doPaySuccessCurCustomerAccountUpdate(String custId, CustomerAccount originCustomerAccount, Date now, Double minusDeductionPoint, Double rmbAmt, Double consumePoint) {
        minusDeductionPoint = minusDeductionPoint == null ? 0.00d : minusDeductionPoint;
        rmbAmt = rmbAmt == null ? 0.00d : rmbAmt;
        consumePoint = consumePoint == null ? 0.00d : consumePoint;
        Double oriRmbAmt = originCustomerAccount.getConsumeRmb() == null ? 0.00d : originCustomerAccount.getConsumeRmb();
        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setUpdateTime(now);
        customerAccount.setCustId(custId);
        //更新总积分
        customerAccount.setSurplusTotalPoint(Arith.sub(Arith.sub(originCustomerAccount.getSurplusTotalPoint(), minusDeductionPoint), consumePoint));
        //更新自己购买的数量


        //更细自己的积分
        customerAccount.setSurplusShopPoint(Arith.sub(originCustomerAccount.getSurplusShopPoint(), minusDeductionPoint));

        //更新自己的余额
        customerAccount.setSurplusCashPoint(Arith.sub(originCustomerAccount.getSurplusCashPoint(), consumePoint));
        //更新自己累计消费今个
        customerAccount.setConsumeRmb(Arith.add(oriRmbAmt, rmbAmt));
        //乐观锁
        customerAccount.setVersionUpdateTime(originCustomerAccount.getUpdateTime());
        int result = customerAccountMapper.updateSelfBuyCountAndSurplusTotalPointAndSurplusShopPointAndSurplusCashPointAndComsumeRbmByUpdateTimeAndCustId(customerAccount);
        if (result == 0) {
            throw new HuhuaminException("积分更新账号表系统异常");
        }

    }

    /**
     * 提交订单初始化数据
     *
     * @param orderItems
     * @param custId
     * @param custName
     * @return
     */
    public List<OrderOperate> initPayOrderOperate(List<OrderItem> orderItems, String custId, String custName, String xml, Date now) {
        List<OrderOperate> listTemp = new ArrayList<>();
        for (OrderItem temp : orderItems
        ) {
            OrderOperate orderOperate = new OrderOperate();
            orderOperate.setOptId(UUIDUtils.generateUuid22());
            orderOperate.setOrderId(temp.getOrderId());
            orderOperate.setChildId(temp.getChildId());
            orderOperate.setOrderStatusBefore(101);
            orderOperate.setOrderStatusNow(201);
            orderOperate.setOptRemark(custName.concat("买单支付回调--->").concat(xml));
            orderOperate.setOptSource("buyer");
            orderOperate.setUserId(custId);
            orderOperate.setUserName(custName);
            orderOperate.setAddTime(now);


            listTemp.add(orderOperate);
        }
        return listTemp;
    }

    /**
     * 初始化下使用积分
     *
     * @param custId
     * @param orderId
     * @param now
     * @param value
     * @param amt
     * @param yu_e    true 余额 false  积分
     * @return
     */
    public CustomerPoint initOrderUseGoodPointCustomerPoint(String custId, String orderId, Date now, Double value, Double amt, boolean yu_e) {
        CustomerPoint customerPoint = new CustomerPoint();
        gainType2Init(custId, orderId, value, customerPoint);


        if (yu_e) {
            customerPoint.setPointDesc("订单号:" + orderId + ",支付成功,实际支付余额" + amt + ",使用抵扣积分" + value);
            customerPoint.setPointType((byte) 1);//余额
        } else {
            customerPoint.setPointDesc("订单号:" + orderId + ",支付成功,实际支付现金" + amt + ",使用抵扣积分" + value);
            customerPoint.setPointType((byte) 3);//积分
        }

        customerPoint.setSourceType((byte) 1);//商品
        defaultThrough(customerPoint, now);
        return customerPoint;
    }

    private void gainType1Init(String custId, String orderId, Double deMoney, CustomerPoint customerPoint) {
        customerPoint.setGainType((byte) 1);//获取

        customerPoint.setCustId(custId);
        customerPoint.setSourceId(orderId);
        customerPoint.setPointId(UUIDUtils.generateUuid22());
        customerPoint.setPointValue(deMoney);
    }

    private void gainType2Init(String custId, String orderId, Double deMoney, CustomerPoint customerPoint) {
        customerPoint.setGainType((byte) 2);//消费

        customerPoint.setCustId(custId);
        customerPoint.setSourceId(orderId);
        customerPoint.setPointId(UUIDUtils.generateUuid22());
        customerPoint.setPointValue(deMoney);
    }

    /**
     * 审核通过
     *
     * @param customerPoint
     * @param now
     */
    private void defaultThrough(CustomerPoint customerPoint, Date now) {
        customerPoint.setAddTime(now);
        customerPoint.setAuditStatus((byte) 2);
        customerPoint.setAuditUser("system");
        customerPoint.setAuditUserName("system");
        customerPoint.setAuditTime(now);
    }


    public static String getAmount(String xml) {
        String startFlag = "<Amount>";
        int s_index = xml.indexOf(startFlag);
        int e_index = xml.indexOf("</Amount>");
        String amount = null;
        if (s_index > 0) {
            amount = xml.substring(s_index + startFlag.length(), e_index);
        }
        return amount;
    }


    /**
     * @param list 数据库实体
     * @return 简化后实体
     */
    public List<Order> orderWithOrderItem(List<Order> list,String shopId) {

        Set<String> orderIds = new HashSet<>();
        //如果是1个直接付值
        String postInfo="";
        for (Order temp :
                list) {
            if (list.size() == 1) {
                List<OrderItem> lstShortOrderItem = orderItemMapper.getOrderItemByOrderId(temp.getOrderId());
                temp.setOrderItemList(lstShortOrderItem);
            } else {
                orderIds.add(temp.getOrderId());
            }
            /*private String receiveAddr;
            private String receiverName;
            private String linkPhone;*/
            //陕西省西安市雁塔区|高科广场|空空|18710781196
             postInfo=temp.getPostInfo();
            if(StringUtils.isNotBlank(postInfo)){
                String postInfoArr []=postInfo.split("\\|");
                if(postInfoArr.length==4){
                    temp.setReceiveAddr(postInfoArr[0].concat(postInfoArr[1]));
                    temp.setReceiverName(postInfoArr[2]);
                    temp.setLinkPhone(postInfoArr[3]);
                }
            }
            temp.setFlags(true);
            temp.setShopType(shopMapper.selectShortByPrimaryKey(shopId).getShopType());
        }
//        //一次请求数据库
        Map<String, List<OrderItem>> map = new HashMap<>();
        if (!CollectionUtils.isEmpty(orderIds) && orderIds.size() > 1) {
            //查询所有订单
            List<OrderItem> lstShortOrderItem = orderItemMapper.getOrderItemByOrderIds(new ArrayList<String>(orderIds));
            for (OrderItem shortOrderItem : lstShortOrderItem
            ) {
                if (map.containsKey(shortOrderItem.getOrderId())) {
                    map.get(shortOrderItem.getOrderId()).add(shortOrderItem);
//                    map.put(shortOrderItem.getOrderId(), listTemp);
                } else {
                    List<OrderItem> listTemp = new ArrayList<>();
                    listTemp.add(shortOrderItem);
                    map.put(shortOrderItem.getOrderId(), listTemp);
                }
            }
            for (Order temp :
                    list) {
                temp.setOrderItemList(map.get(temp.getOrderId()));
                temp.setOrderCount(temp.getOrderItemList().size());
            }
        }
        return list;
    }

    private List<Order> getOrderByCustIdAndAddTime(ReqSearchOrder reqSearchOrder, String shopId, Byte isPro) {
        Order order = new Order();
        order.setShopId(shopId);
        BeanUtils.copyProperties(reqSearchOrder, order);
        //1-全部 2-待付款  3-待发货 4-待收货  5-待评价
        //[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货 501-已收货 601-退货申请中 611-退货中 621-已退货 701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]CXY_BUSSINESS_ORDER_BASE.ORDER_STATUS
        List<Integer> orderStatuList=new ArrayList<>();
        if (reqSearchOrder.getOrderStatus() == 1) {
            order.setOrderStatus(null);
            orderStatuList.add(101);
            orderStatuList.add(201);
            orderStatuList.add(401);
            orderStatuList.add(501);
        } else if (reqSearchOrder.getOrderStatus() == 2) {
            order.setOrderStatus(101);
            orderStatuList.add(101);
        } else if (reqSearchOrder.getOrderStatus() == 3) {
            order.setOrderStatus(201);
            orderStatuList.add(201);
        } else if (reqSearchOrder.getOrderStatus() == 4) {
            order.setOrderStatus(401);
            orderStatuList.add(401);
        } else if (reqSearchOrder.getOrderStatus() == 5) {
            order.setOrderStatus(501);
            orderStatuList.add(501);
        }
        if (!org.springframework.util.StringUtils.isEmpty(reqSearchOrder.getStartTime())) {
            order.setBeginAddTime(DateUtils.strToDate(reqSearchOrder.getStartTime(), "yyyy-MM-dd"));
        }

        if (!org.springframework.util.StringUtils.isEmpty(reqSearchOrder.getEndTime())) {
            order.setEndAddTime(DateUtils.strToDate(reqSearchOrder.getEndTime(), "yyyy-MM-dd"));
        }

        return orderMapper.getOrderByCustIdAndAddTime(order.getBeginAddTime(), order.getEndAddTime(), orderStatuList, shopId, isPro);

    }

    /**
     * 获取状态统计
     *
     * @param custId
     * @param isPro  餐饮[1-是 2-否]
     * @return
     */
    public TypeJsonResult<Map<String, Integer>> getOrderStausByCustId(String custId, Byte isPro) {

        try {
            TypeJsonResult typeJsonResult = new TypeJsonResult();
            Map<Integer, Integer> map = orderMapper.getOrderStausByCustId(custId);
            //101-待付款 201-待发货 401-待收货 501-待评价 601-维权/售后
            if (!map.containsKey(101)) {
                map.put(101, 0);
            }
            if (!map.containsKey(201)) {
                map.put(201, 0);
            }
            if (!map.containsKey(401)) {
                map.put(401, 0);
            }
            if (!map.containsKey(501)) {
                map.put(501, 0);
            }

            if (!map.containsKey(601)) {
                map.put(601, 0);
            }

            if (map.containsKey(611)) {
                map.put(601, map.get(601) + map.get(611));
            }
            if (map.containsKey(901)) {
                map.put(601, map.get(601) + map.get(901));
            }
            if (map.containsKey(911)) {
                map.put(601, map.get(601) + map.get(911));
            }


            //601-退货申请中 611-退货中 621-已退货 901-维权退款申请中 911-维权退款成功

            //[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货 501-已收货 601-退货申请中 611-退货中 621-已退货 701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]
            Map<String, Integer> mapStr = new HashMap<>();
            for (Integer tt : map.keySet()
            ) {
                mapStr.put("c" + tt, map.get(tt));
            }

            typeJsonResult.setType(mapStr);
            typeJsonResult.setStatusCode(true);
            return typeJsonResult;
        } catch (Exception e) {

            String msg = "订单统计";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);

        }
    }

    /**
     * 确认收货
     *
     * @param orderId
     * @param custId
     * @return
     */
    @Transactional
    public JsonResult doOrderConfirm(String orderId, String custId) {

        try {
            JsonResult jsonResult = new JsonResult(false);
            Date now = new Date();
            Order order = orderMapper.selectByPrimaryKey(orderId);
            if (order.getOrderStatus().intValue() == 201 || order.getOrderStatus().intValue() == 401) {
                List<OrderItem> ordersItem = orderItemMapper.getOrderItemByOrderId(orderId);
                //构建需要保存的订单日志
                List<OrderOperate> orderOperates = initConfirmOrderOperate(ordersItem, order.getCustId(), order.getCustName(), now, order.getOrderStatus().intValue());

                int result = orderOperateMapper.batchInsert(orderOperates);
                if (result == 0) {
                    throw new HuhuaminException("确认收货增加订单子项系统异常");
                }
                result = orderMapper.updateOrderStatusAndCustIdAndUpdateTime(501, orderId, custId, now, order.getOrderStatus());
                if (result == 0) {
                    throw new HuhuaminException("确认收货增加订单子项系统异常");
                }
                jsonResult.setMessage(order.getOrderNo());
                jsonResult.setStatusCode(true);
                return jsonResult;
            } else {
                jsonResult.setMessage("只有已付款的才可以确认收款");
                jsonResult.setStatusCode(false);
                return jsonResult;
            }


        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("确认收货" + e.getMessage(), e);
            }

        }

    }

    /**
     * 确认收货数据初始化
     *
     * @param orderItems
     * @param custId
     * @param custName
     * @param now
     * @param oriStatus
     * @return
     */
    public List<OrderOperate> initConfirmOrderOperate(List<OrderItem> orderItems, String custId, String custName, Date now, Integer oriStatus) {

        List<OrderOperate> listTemp = new ArrayList<>();
        for (OrderItem temp : orderItems
        ) {
            OrderOperate orderOperate = new OrderOperate();
            orderOperate.setOptId(UUIDUtils.generateUuid22());
            orderOperate.setOrderId(temp.getOrderId());
            orderOperate.setChildId(temp.getChildId());
            orderOperate.setOrderStatusBefore(oriStatus);
            orderOperate.setOrderStatusNow(501);
            orderOperate.setOptRemark(custName.concat("确认收款"));
            orderOperate.setOptSource("buyer");
            orderOperate.setUserId(custId);
            orderOperate.setUserName(custName);
            orderOperate.setAddTime(now);
            listTemp.add(orderOperate);
        }
        return listTemp;
    }

    /**
     * 查询物流信息
     *
     * @param orderId
     * @param custId
     * @return
     */
    public TypeJsonResult<String> orderPostInfo(String orderId, String custId) {
        try {
            TypeJsonResult<String> typeJsonResult = new TypeJsonResult<>();
            List<Order> list = orderMapper.orderDetailByOrderIdsAndShopId(custId, Arrays.asList(orderId));
            if (null == list || list.size() == 0) {
                typeJsonResult.setType(null);
                typeJsonResult.setStatusCode(false);
                typeJsonResult.setMessage("你访问的订单不存在");
                return typeJsonResult;
            }
            Order order = list.stream().findFirst().orElse(null);
            if (null != order) {
                List<OrderItem> lstShortOrderItem = orderItemMapper.getOrderItemByOrderId(order.getOrderId());
                String postNo = "";
                String postCompany = "";
                for (OrderItem temp22 :
                        lstShortOrderItem) {
                    if (StringUtils.isNotEmpty(temp22.getPostNo())) {
                        postNo = temp22.getPostNo();
                    }
                    if (StringUtils.isNotEmpty(temp22.getPostNo())) {
                        postCompany = temp22.getPostCompany();
                    }
                }
                order.setPostCompany(postCompany);
                order.setPostNo(postNo);
                if (StringUtils.isNotBlank(postCompany) && StringUtils.isNotBlank(postNo)) {
                    String json = jedisService.getValueByKey(postNo);
                    if (StringUtils.isNotBlank(json)) {
                        order.setPostJson(json);
                    } else {
                        String result = getExpressInfo(postNo, postCompany.toLowerCase());
                        //1小时过期
                        jedisService.setKeyValue(postNo, result, 3600);
                        order.setPostJson(result);
                    }
                }
            }
            typeJsonResult.setStatusCode(true);
            typeJsonResult.setType(order.getPostJson());
            return typeJsonResult;

        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("查询物流信息", e);
            }

        }
    }

    public static String getExpressInfo(String no, String type) {

        String host = "https://wuliu.market.alicloudapi.com";
        String path = "/kdi";
        String method = "GET";
        System.out.println("请先替换成自己的AppCode");
        String appcode = "6bbf047c6a194377a2984421d15d0887";  // !!!替换填写自己的AppCode 在买家中心查看
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode); //格式为:Authorization:APPCODE 83359fd73fe11248385f570e3c139xxx
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("no", no);// !!! 请求参数
        querys.put("type", type);// !!! 请求参数
        try {
            HttpResponse response = HttpUtils.doGet(host, path, headers, querys);
            //System.out.println(response.toString()); //输出头部
            return EntityUtils.toString(response.getEntity()); //输出json
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 根据id删除订单
     *
     * @param orderId
     * @param custId
     * @return
     */
    public JsonResult delOrderById(String orderId, String userId) {

        try {
            JsonResult jsonResult = new JsonResult(false);

            String shopId=systemUserMapper.queryShopIdByUserId(userId);
            int count = orderMapper.delOrderById(orderId, shopId);
            if (count == 1) {
                jsonResult.setStatusCode(true);
                return jsonResult;
            } else {
                jsonResult.setMessage("删除订单失败！");
                jsonResult.setStatusCode(false);
                return jsonResult;
            }
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("根据id删除订单" + e.getMessage(), e);
            }

        }

    }

    /**
     * 根据id删除订单
     *
     * @param orderId
     * @param custId
     * @return
     */
    public JsonResult cancleOrderById(String orderId, String custId, String orderProb) {

        try {
            JsonResult jsonResult = new JsonResult(false);
            Date now = new Date();
            Order order = orderMapper.selectByPrimaryKey(orderId);
            if (null == order || !order.getCustId().equals(custId)) {
                jsonResult.setMessage("你取消的订单不存在");
                return jsonResult;
            }
            Double returnMoney = 0.00d;
            if (order.getOrderStatus().intValue() == 201) {
                if (order.getIsPromotion().intValue() == 1) {
                    /*Date dateEate = order.getPlanEatTime();
                    long min = (dateEate.getTime() - new Date().getTime()) / (1000 * 60);
                    if (min >= 30) {
                        returnMoney = order.getOrderFee();
                    } else if (min < 30 && min >= 10) {
                        returnMoney = Arith.mul(order.getOrderFee(), 0.7);
                    }*/

                    if(order.getPayType()==4){
                        returnMoney = order.getOrderFee();

                        if (Arith.compareDoubleSize(returnMoney, 0.00d) > 0) {
                            WxPayRefundRequest request = new WxPayRefundRequest();
                            request.setOutRefundNo(order.getOrderNo());
                            request.setTransactionId(order.getOfflinepayImg());//借用作为流水号
                            request.setRefundFee(Double.valueOf(Arith.mul(order.getOrderFee(), 100)).intValue());

                            request.setTotalFee(Double.valueOf(Arith.mul(order.getOrderFee(), 100)).intValue());
                            WxPayRefundResult wx = wxPayService.refund(request);
                            if (wx.getResultCode().equals("SUCCESS")) {
                            } else {
                                throw new HuhuaminException("退款系统异常");
                            }

                        }
                    }else  if(order.getPayType()==5){
                        CustomerPoint customerPoint=new CustomerPoint();


                        customerPoint.setGainType((byte) 1);//获取
                        customerPoint.setCustId(custId);
                        customerPoint.setSourceId(orderId);
                        customerPoint.setPointId(UUIDUtils.generateUuid22());
                        customerPoint.setPointValue(order.getTotalFee());
                        customerPoint.setAddTime(new Date());
                        customerPoint.setAuditStatus((byte) 2);
                        customerPoint.setAuditTime(customerPoint.getAddTime());
                        customerPoint.setAuditUser("system");
                        customerPoint.setAuditUserName("system");
                        customerPoint.setSourceType((byte) 1);
                        customerPoint.setPointMold((byte) 2);
                        customerPoint.setPointDesc("服务类订单退余额，orderId:" + orderId);
                        customerPoint.setPointType((byte) 1);//积分类型[1-余额 3-积分]
                        int result = customerPointMapper.insert(customerPoint);
                        if (result == 0) {
                            throw new HuhuaminException("商品退余额记录失败");
                        }

                        result =customerMapper.addConsumePoint(custId,order.getTotalFee());
                        if (result == 0) {
                            throw new HuhuaminException("在商品退余额过程中,系统开小差了！！！");
                        }

                    }


                }


            }


            int count = orderMapper.cancleOrderById(orderId, orderProb, new Date(), returnMoney);

            if (count == 1) {
                jsonResult.setStatusCode(true);
                return jsonResult;
            } else {
                jsonResult.setMessage("取消订单失败！");
                jsonResult.setStatusCode(false);
                return jsonResult;
            }
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("根据id删除订单" + e.getMessage(), e);
            }

        }

    }

    /**
     * 分页查询 订单
     *
     * @param reqSearchOrder
     * @param request
     * @param custId
     * @return
     */
    public PageJsonResult<Order> orders(ReqSearchOrder reqSource, String
            userId) {
        try {
            String shopId = systemUserMapper.queryShopIdByUserId(userId);

            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqSource.getPageNum(), reqSource.getPageSize());
            List<Order> list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(), " ADD_TIME DESC ").doSelectPage(() -> getOrderByCustIdAndAddTime(reqSource, shopId, reqSource.getIsPromotion()));

            PageInfo<Order> pageTemp = new PageInfo<>(list);
            PageJsonResult<Order> pageJsonResult = new PageJsonResult<>(pageTemp);
            orderWithOrderItem(list,shopId);
            return pageJsonResult;

        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("分页查询订单" + e.getMessage(), e);
            }
        }
    }

    /**
     * 订单子项
     *
     * @param reqSource
     * @param custId
     * @return
     */
    public PageJsonResult<OrderItem> orderItems(ReqSearchOrder reqSource, String custId) {
        try {

            Map<String, String> resultMap = orderMapper.getSelledByCustId(custId, reqSource.getIsPromotion());
            if (CollectionUtils.isEmpty(resultMap.keySet())) {
                PageJsonResult<OrderItem> tt
                        = new PageJsonResult<>(new PageInfo<>());
                tt.setStatusCode(true);
                return new PageJsonResult<>(new PageInfo<>());
            }
            Map<String, Integer> childIdOrderStatus = orderReturnMapper.childIdOrderStatus(custId);
            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqSource.getPageNum(), reqSource.getPageSize());
            List<OrderItem> orderItems = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(), " ADD_TIME DESC ").doSelectPage(() -> orderItemMapper.getOrderItemByOrderIdsSh(new ArrayList<>(resultMap.keySet())));
            for (OrderItem t : orderItems
            ) {
                t.setShopName(resultMap.get(t.getOrderId()));
                t.setReturnStatus(childIdOrderStatus.get(t.getChildId()));

            }
            PageInfo<OrderItem> pageTemp = new PageInfo<>(orderItems);
            PageJsonResult<OrderItem> pageJsonResult = new PageJsonResult<>(pageTemp);
            pageJsonResult.setStatusCode(true);
            return pageJsonResult;
        } catch (Exception e) {
            String msg = "售后订单咨询列表";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 增加订单现金支付记录
     * @param orderPay
     * @return
     */
    @Transactional
    public Boolean addOrderpay(OrderPay orderPay){

        try{
            OrderPay deductionOrderPay=orderPayMapper.selectByPrimaryKey(orderPay.getOrderNo());
            if(null==deductionOrderPay||null==deductionOrderPay.getDeductionStockTime()){
                List<String> orderIds = orderMapper.getOrderIdsByOrderNo(orderPay.getOrderNo());

                orderIds.forEach(orderId -> {
                    List<OrderItem> ordersItem = orderItemMapper.getOrderItemByOrderId(orderId);
                    for (OrderItem orderItem : ordersItem) {
                        int count = goodsSkuMapper.updateStockCountBySkuIdAndGoodsNum(orderItem.getSkuNo(), orderItem.getGoodsNum());
                        if (count == 1) {
                            if (goodsMapper.deductionStockCountForGoods(orderItem.getGoodsId(), orderItem.getGoodsNum()) != 1) {
                                throw new HuhuaminException("库存不足");
                            }
                        } else {
                            throw new HuhuaminException("库存不足！");
                        }
                    }
                });

                int count= orderPayMapper.insert(orderPay);
                if(count==1){
                    return true;
                }else{
                    return false;
                }
            }else{
                return true;
            }
        } catch (Exception e) {
            String msg = "订单现金支付记录";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }
    /**
     * 修改订单现金支付记录
     * @param orderPay
     * @return
     */
    @Transactional
    public Boolean updateOrderpay(OrderPay orderPay){

        try{
            int count= orderPayMapper.updateByPrimaryKeySelect(orderPay);

            if(count==1){
                return true;
            }else{
                return false;
            }


        } catch (Exception e) {
            String msg = "修改订单现金支付记录";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 订单失败收回库存
     * @param orderPay
     * @return
     */
    @Transactional
    public void addStockCount(String orderNo){

        try {
            OrderPay orderPay=orderPayMapper.selectByPrimaryKey(orderNo);
            if(null==orderPay.getAddStockTime()){
                List<String> orderIds = orderMapper.getOrderIdsByOrderNo(orderNo);

                orderIds.forEach(orderId -> {
                    List<OrderItem> ordersItem = orderItemMapper.getOrderItemByOrderId(orderId);
                    for (OrderItem orderItem : ordersItem) {
                        int count = goodsSkuMapper.updateStockCountBySkuIdAndGoodsNumAdd(orderItem.getSkuNo(), orderItem.getGoodsNum());
                        if (count == 1) {
                            if (goodsMapper.deductionStockCountForGoodsAdd(orderItem.getGoodsId(), orderItem.getGoodsNum()) != 1) {
                                throw new HuhuaminException(orderNo + "修改订单现金支付记录库存异常");
                            }else{
                                OrderPay updateOrderPay=new OrderPay();
                                updateOrderPay.setOrderNo(orderNo);
                                updateOrderPay.setAddStockTime(new Date());
                                count= orderPayMapper.updateByPrimaryKeySelect(updateOrderPay);

                                if(count!=1){
                                    throw new HuhuaminException(orderNo + "库存恢复时间记录异常！");
                                }
                            }
                        } else {
                            throw new HuhuaminException(orderNo + "修改订单现金支付记录库存异常！");
                        }
                    }


                });
            }



        } catch (Exception e) {
            String msg = "订单失败收回库存";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 修改订单地址
     * @param reqOrderAdress
     * @return
     */
    @Transactional
    public JsonResult updateAdress(ReqOrderAdress reqOrderAdress){

        try{
            JsonResult jsonResult=new JsonResult();

            StringBuffer postInfo=new StringBuffer("");
            postInfo.append(reqOrderAdress.getAreaPath()).append("|").append(reqOrderAdress.getReceiveAddr()).append("|")
                    .append(reqOrderAdress.getReceiverName()).append("|").append(reqOrderAdress.getLinkPhone());

            int count= orderMapper.updateAdress(reqOrderAdress.getOrderId(),postInfo.toString());
            if(count==1){
                jsonResult.setStatusCode(true);
            }
        return jsonResult;
        } catch (Exception e) {
            String msg = "修改订单地址";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 查询快递公司信息
     * @return
     */
    public TypeJsonResult expressCompanyInfo(){

        try{
            TypeJsonResult jsonResult=new TypeJsonResult();
            jsonResult.setType(expressMapper.queryExpressCodeAndExpressName());
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "查询快递公司信息";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }


    /**
     * 发货
     * @param orderId
     * @param postCompany
     * @param postNo
     * @return
     */
    @Transactional
    public JsonResult sendGoods(String userId,String orderId,String postCompany, String postNo){
        try{
            JsonResult jsonResult=new JsonResult();

/*            `ORDER_STATUS` int(4) NOT NULL DEFAULT '101' COMMENT '订单状态[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货
                            501-已收货 601-退货申请中 611-退货中 621-已退货
                            701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]',*/
            if(201==orderMapper.selectOrderStatusShopIdAndShopNameByOrderId(orderId).getOrderStatus()){
                /* 修改订单状态 */
                String userName=systemUserMapper.queryUserNameByUserId(userId);
                int count=orderMapper.updateStatusForSendGoods(orderId,userName);
                if(1!=count){
                    throw new HuhuaminException("修改主订单信息失败！");
                }
                /* 修改订单子表，添加订单操作表 */
                List<OrderItem> orderItems = orderItemMapper.getOrderItemByOrderId(orderId);
                for( OrderItem item:orderItems){
                    count=orderItemMapper.updateItemForSendGoods(item.getChildId(),orderId,item.getPostCompany(),item.getPostNo());
                    if(1!=count){
                        throw new HuhuaminException("修改子订单信息失败！"+item.getChildId());
                    }
                    /* 添加订单操作表 */
                    OrderOperate orderOperate = new OrderOperate();
                    orderOperate.setOrderId(orderId);
                    orderOperate.setChildId(item.getChildId());
                    orderOperate.setOrderStatusBefore(201);
                    orderOperate.setOrderStatusNow(401);
                    orderOperate.setOptRemark("商户端发货");
                    orderOperate.setOptSource("seller");
                    orderOperate.setUserId(userId);
                    orderOperate.setUserName(userName);
                    orderOperate.setAddTime(new Date());
                    orderOperate.setOptId(UUIDUtils.generateUuid22());
                    count=orderOperateMapper.insert(orderOperate);
                    if(1!=count){
                        throw new HuhuaminException("商城订单操作记录表失败！");
                    }
                }
                jsonResult.setStatusCode(true);
            }else {
                jsonResult.setMessage("订单状态不正确！");
            }
            return jsonResult;
        } catch (Exception e) {
            String msg = "发货";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }


    /**
     * 服务完成（餐饮）
     * @param userId
     * @param orderId
     * @return
     */
    @Transactional
    public JsonResult serviceCompletion(String userId,String orderId){
        try{
            JsonResult jsonResult=new JsonResult();


            String shopId= systemUserMapper.queryShopIdByUserId(userId);

/*            `ORDER_STATUS` int(4) NOT NULL DEFAULT '101' COMMENT '订单状态[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货
                            501-已收货 601-退货申请中 611-退货中 621-已退货
                            701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]',*/
            Order order= orderMapper.selectOrderStatusShopIdAndShopNameByOrderId(orderId);

            if(!order.getShopId().equals(shopId)){
                throw new HuhuaminException("你无权操作该订单！");
            }


            if(201==order.getOrderStatus()&&1==order.getIsPromotion()){
                /* 修改订单状态 */
                int count=orderMapper.updateStatusForserviceCompletion(orderId);
                if(1!=count){
                    throw new HuhuaminException("修改主订单信息失败！");
                }
                /* 修改订单子表，添加订单操作表 */
                String userName=systemUserMapper.queryUserNameByUserId(userId);
                List<OrderItem> orderItems = orderItemMapper.getOrderItemByOrderId(orderId);
                for( OrderItem item:orderItems){
                    /* 添加订单操作表 */
                    OrderOperate orderOperate = new OrderOperate();
                    orderOperate.setOrderId(orderId);
                    orderOperate.setChildId(item.getChildId());
                    orderOperate.setOrderStatusBefore(201);
                    orderOperate.setOrderStatusNow(501);
                    orderOperate.setOptRemark("服务完成");
                    orderOperate.setOptSource("seller");
                    orderOperate.setUserName(userName);
                    orderOperate.setAddTime(new Date());
                    orderOperate.setAddTime(new Date());
                    orderOperate.setOptId(UUIDUtils.generateUuid22());
                    count=orderOperateMapper.insert(orderOperate);

                    if(1!=count){
                        throw new HuhuaminException("商城订单操作记录表失败！");
                    }
                }

                VideoPlaninfo videoPlaninfo=videoPlaninfoMapper.queryPlaninfoByOrderId(orderId,shopId);
                if(null != videoPlaninfo){
                    count =videoPlaninfoMapper.updateOverByOrderId(orderId,shopId);
                    if(1!=count){
                        throw new HuhuaminException("商城订单操作记录表失败！");
                    }
                }
                jsonResult.setStatusCode(true);
            }else {
                jsonResult.setMessage("订单状态不正确！");
            }
            return jsonResult;
        } catch (Exception e) {
            String msg = "服务完成（餐饮）";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 售后列表
     * @param userId
     * @param reqTokenPage
     * @return
     */
    public PageJsonResult afterSaleList(String userId,ReqTokenPage reqTokenPage){
        try{
            String shopId= systemUserMapper.queryShopIdByUserId(userId);
/*            `ORDER_STATUS` int(4) NOT NULL DEFAULT '101' COMMENT '订单状态[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货
                            501-已收货 601-退货申请中 611-退货中 621-已退货
                            701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]',*/
            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqTokenPage.getPageNum(), reqTokenPage.getPageSize());
            List<OrderReturn> list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(), " ADD_TIME DESC ").doSelectPage(() -> orderReturnMapper.afterSaleList(shopId));

            PageInfo<OrderReturn> pageTemp = new PageInfo<>(list);
            PageJsonResult<OrderReturn> pageJsonResult = new PageJsonResult<>(pageTemp);

            return pageJsonResult;
        } catch (Exception e) {
            String msg = "售后列表";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }
    /**
     * 售后详情
     * @param userId
     * @param reqTokenPage
     * @return
     */
    public TypeJsonResult afterSaleDetail(String userId,String returnId){
        try{
            String shopId= systemUserMapper.queryShopIdByUserId(userId);
            TypeJsonResult typeJsonResult=new TypeJsonResult();
            OrderReturn orderReturn = orderReturnMapper.afterSaleDetail(shopId,returnId);
            typeJsonResult.setType(orderReturn);
            typeJsonResult.setStatusCode(true);
            return typeJsonResult;
        } catch (Exception e) {
            String msg = "售后详情";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }


    /**
     * 拒绝售后服务
     * @param userId
     * @param replyCont
     * @param returnId
     * @return
     */
    public JsonResult deniedAfterSale(String userId,String returnId , String replyCont){
        try{
            String shopId= systemUserMapper.queryShopIdByUserId(userId);
            JsonResult jsonResult=new JsonResult();
            int count = orderReturnMapper.deniedAfterSale(shopId,returnId,replyCont);
            if(count==1){
                jsonResult.setStatusCode(true);
            }else {
                jsonResult.setMessage("拒绝售后服务失败！");
            }

            return jsonResult;
        } catch (Exception e) {
            String msg = "拒绝售后服务";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 同意售后服务
     * @param userId
     * @param replyCont
     * @param returnId
     * @return
     */
    @Transactional
    public JsonResult agreeAfterSale(String userId,String returnId){
        try{
            String shopId= systemUserMapper.queryShopIdByUserId(userId);
            JsonResult jsonResult=new JsonResult();
            OrderReturn orderReturn=orderReturnMapper.selectByPrimaryKey(returnId);
            Byte serverStatus = orderReturn.getServerStatus();
            String orderId=orderReturn.getOrderId();
            int count = orderReturnMapper.agreeAfterSale(returnId);
            if(count !=1){
                throw new HuhuaminException("退款退款或仅退款信息更新失败！");
            }
            //服务类型[1-仅退款 2-退货退款]
            if(1==serverStatus){
                doRefund( userId, returnId);
            }
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "同意售后服务";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     *
     * @param custId
     * @param addTime
     * @param auditStatus
     * @param userId
     * @param userName
     * @param gainType
     * @param orderId
     * @param pointType
     * @param totalFee
     * @return
     */
    public static CustomerPoint initCustomerPoint(String custId,Date addTime,Byte auditStatus,String userId
            ,String userName,Byte gainType,String orderId,Byte pointType,Double totalFee,String childId){

        CustomerPoint customerPoint = new CustomerPoint();
        customerPoint.setPointId(UUIDUtils.generateUuid22());
        customerPoint.setCustId(custId);
        customerPoint.setPointValue(totalFee);
        customerPoint.setGainType(gainType);
        customerPoint.setPointDesc("订单号:" + orderId +";子订单号："+childId+ (pointType==1?",退余额":",退积分"));
        customerPoint.setAddTime(addTime);
        customerPoint.setPointType(pointType);
        customerPoint.setSourceType((byte)1);
        customerPoint.setSourceId(childId);
        customerPoint.setAuditStatus(auditStatus);
        customerPoint.setAuditTime(addTime);
        customerPoint.setAuditUser(userId);
        customerPoint.setAuditUserName(userName);

        return customerPoint;
    }

    /**
     * 退款退余额退积分
     * @param userId
     * @param returnId
     * @return
     */

     public JsonResult doRefund(String userId,String returnId){
            try{
                String shopId= systemUserMapper.queryShopIdByUserId(userId);
                JsonResult jsonResult=new JsonResult();
                OrderReturn orderReturn=orderReturnMapper.selectByPrimaryKey(returnId);
                Byte serverStatus = orderReturn.getServerStatus();
                String orderId=orderReturn.getOrderId();

                String userName=systemUserMapper.queryUserNameByUserId(userId);
                Order order=orderMapper.selectByPrimaryKey(orderId);
                //退款依据
                OrderItem orderItem=orderItemMapper.selectByPrimaryKey(orderReturn.getChildId());
                Double refundFee=orderItem.getTotalFee();
                String childId=orderItem.getChildId();
                int count = 0;
                /* 修改订单状态 */   //911-维权退款成功
                count = orderMapper.completeAfterSale(orderId);
                if(count !=1){
                    throw new HuhuaminException("退款-订单信息更新失败！");
                }
                //微信退款
                if (( order.getOrderStatus() == 901 || order.getOrderStatus() == 621) && 4 == order.getPayType()&&null != order.getOrderFee()
                        && Arith.compareDoubleSize(order.getOrderFee(), 0.00d) > 0) {
                    // 余额支付金额

                    Goods goods= goodsMapper.selectShort(orderReturn.getGoodsId());

                    /* 修改订单子表，添加订单操作表 */
                    List<OrderItem> orderItemList = orderItemMapper.getOrderItemByOrderId(orderId);
                    for (OrderItem item : orderItemList) {
                        /* 添加订单操作表 */
                        OrderOperate orderOperate = new OrderOperate();
                        orderOperate.setOptId(UUIDUtils.generateUuid22());
                        orderOperate.setOrderId(orderId);
                        orderOperate.setChildId(orderReturn.getChildId());
                        orderOperate.setOrderStatusBefore(901);
                        orderOperate.setOrderStatusNow(911);
                        orderOperate.setOptRemark("微信退款："+refundFee);
                        orderOperate.setOptSource("business");
                        orderOperate.setUserId(userId);
                        orderOperate.setUserName(userName);
                        orderOperate.setAddTime(new Date());
                        count =orderOperateMapper.insert(orderOperate);
                        if(count !=1){
                            throw new HuhuaminException("微信退款添加记录失败！");
                        }
                    }
                    //	org.apache.commons.lang3.StringUtils.remove(str, remove)
                    /*微信退款*/
                    WxPayRefundRequest request = new WxPayRefundRequest();
                    request.setOutRefundNo(order.getOrderNo());
                    request.setTransactionId(order.getOfflinepayImg());//借用作为流水号
                    request.setRefundFee(Double.valueOf(Arith.mul(refundFee, 100)).intValue());

                    request.setTotalFee(Double.valueOf(Arith.mul(refundFee, 100)).intValue());
                    WxPayRefundResult wx = wxPayService.refund(request);
                    if (wx.getResultCode().equals("SUCCESS")) {
                    } else {
                        throw new HuhuaminException("退款系统异常");
                    }
                    System.out.println(wx.getResultCode());
                }

                Date now=new Date();
                /*微信退款*/
                // `PAY_TYPE` tinyint(4) NOT NULL DEFAULT '0' COMMENT '支付渠道[0-未付款 1-纯消费积分 2-积分+余额   5-纯余额  3-积分+微信 4-纯微信 6-积分+支付宝 7-纯支付宝]',
                /*退余额*/
                if (null != order.getConsumeAmt() && Arith.compareDoubleSize(order.getConsumeAmt(), 0.00d) > 0 && 5 == order.getPayType()) {
                    // 余额支付金额
                    CustomerAccount customerAccount = new CustomerAccount();
                    customerAccount.setCustId(order.getCustId());
                    customerAccount.setSurplusCashPoint(refundFee);
                    customerAccount.setSurplusTotalPoint(refundFee);
                    count=customerAccountMapper.returnComsumeAmt(customerAccount);
                    if(count !=1){
                        throw new HuhuaminException("退余额-客户账号表信息更新失败！");
                    }
                    Customer customer = new Customer();
                    customer.setCustId(order.getCustId());
                    customer.setConsumePoint(refundFee);
                   count= customerMapper.returnComsumeAmt(customer);
                    if(count !=1){
                        throw new HuhuaminException("退余额-客户更新失败！");
                    }
                    count =customerPointMapper.insert(initCustomerPoint(orderReturn.getBuyerId(),now,(byte)2
                            , userId,userName, (byte)1, orderId, (byte)1, refundFee,childId));
                    if(count !=1){
                        throw new HuhuaminException("退余额-积分记录信息更新失败！");
                    }

                }
                /*退余额*/
                /*退积分*/
                if (null != order.getDeductionAmt() && Arith.compareDoubleSize(order.getDeductionAmt(), 0.00d) > 0 && 1 == order.getPayType()) {
                    // 消费积分
                    CustomerAccount customerAccount = new CustomerAccount();
                    customerAccount.setCustId(order.getCustId());
                    customerAccount.setSurplusShopPoint(refundFee);
                    customerAccount.setSurplusTotalPoint(refundFee);

                    count=customerAccountMapper.returnDeductionAmt(customerAccount);
                    if(count !=1){
                        throw new HuhuaminException("退积分-客户账号表信息更新失败！");
                    }
                    Customer customer = new Customer();
                    customer.setCustId(order.getCustId());
                    customer.setDeductionPoint(refundFee);

                    count=customerMapper.returnDeductionAmt(customer);
                    if(count !=1){
                        throw new HuhuaminException("退积分-客户表信息更新失败！");
                    }
                    count = customerPointMapper.insert(initCustomerPoint(orderReturn.getBuyerId(),now,(byte)2
                            , userId,userName, (byte)1, orderId, (byte)3, refundFee,childId));
                    if(count !=1){
                        throw new HuhuaminException("退积分-积分记录信息更新失败！");
                    }
                }
                /*退积分*/
                jsonResult.setStatusCode(true);
                return jsonResult;

            } catch (Exception e) {
                String msg = "退款退余额退积分";
                msg = String.format("在%s过程中,服务器开小差了", msg);
                if (e instanceof HuhuaminException) {
                    throw new HuhuaminException(e.getMessage());
                }
                throw new HuhuaminException(msg, e);
            }
    }

    /**
     * 完成退货退款
     * @param userId
     * @param returnId
     * @param replyCont
     * @return
     */
    @Transactional
    public JsonResult completeAfterSale(String userId,String returnId ){
        try{
            /*`ORDER_STATUS` int(4) NOT NULL DEFAULT '101' COMMENT '订单状态[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货
            501-已收货 601-退货申请中 611-退货中 621-已退货
            701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]',*/
            JsonResult jsonResult=new JsonResult();
            doRefund( userId, returnId);

            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "完成退货退款";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     *  销售额统计
     * @param userId
     * @param type
     * @return
     */
    @Transactional
    public TypeJsonResult salesStatistics(String userId,String type,String shopId){
        try{
            TypeJsonResult jsonResult=new TypeJsonResult();
            if(StringUtil.isEmpty(shopId)){
                shopId= systemUserMapper.queryShopIdByUserId(userId);
            }
            String beginTime="";
            String endTime="";

            String myType=type;
            SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if("1".equals(type)){  //周
                beginTime= sf.format(DatesUtil.getBeginDayOfWeek());
                endTime = sf.format(DatesUtil.getEndDayOfWeek());
            }else if("2".equals(type)){  //月
                type="1";
                beginTime= sf.format(DatesUtil.getBeginDayOfMonth());
                endTime = sf.format(DatesUtil.getEndDayOfMonth());
            }else if("3".equals(type)){  //年
                Calendar cal = Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                beginTime= year+"-01-01 00:00:00";
                endTime = year+"-12-31 23:59:59";
            }
            List<Order> orders=orderMapper.salesStatistics(Integer.valueOf(type),shopId,beginTime, endTime);

            jsonResult.setType(statistics(orders, myType, type, endTime));
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "销售额统计";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }


    /**
     *销售量统计
     * @param userId
     * @param type
     * @return
     */
    @Transactional
    public TypeJsonResult SalesVolumeStatistics(String userId,String type,String shopId){
        try{
            TypeJsonResult jsonResult=new TypeJsonResult();
            if(StringUtil.isEmpty(shopId)){
                shopId= systemUserMapper.queryShopIdByUserId(userId);
            }

            String beginTime="";
            String endTime="";
            String myType=type;
            SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if("1".equals(type)){  //周
                beginTime= sf.format(DatesUtil.getBeginDayOfWeek());
                endTime = sf.format(DatesUtil.getEndDayOfWeek());
            }else if("2".equals(type)){  //月
                type="1";
                beginTime= sf.format(DatesUtil.getBeginDayOfMonth());
                endTime = sf.format(DatesUtil.getEndDayOfMonth());
            }else if("3".equals(type)){  //年
                Calendar cal = Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                beginTime= year+"-01-01 00:00:00";
                endTime = year+"-12-31 23:59:59";
            }
            List<Order> orders=orderMapper.SalesVolumeStatistics(Integer.valueOf(type),shopId,beginTime, endTime);

            jsonResult.setType(statistics(orders, myType, type, endTime));
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "销售量统计";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 客户量统计
     * @param userId
     * @param type
     * @return
     */
    @Transactional
    public TypeJsonResult customerVolumeStatistics(String userId,String type,String shopId){
        try{
            TypeJsonResult jsonResult=new TypeJsonResult();
            if(StringUtil.isEmpty(shopId)){
                shopId= systemUserMapper.queryShopIdByUserId(userId);
            }
            String beginTime="";
            String endTime="";
            String myType=type;
            SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if("1".equals(type)){  //周
                beginTime= sf.format(DatesUtil.getBeginDayOfWeek());
                endTime = sf.format(DatesUtil.getEndDayOfWeek());
            }else if("2".equals(type)){  //月
                type="1";
                beginTime= sf.format(DatesUtil.getBeginDayOfMonth());
                endTime = sf.format(DatesUtil.getEndDayOfMonth());
            }else if("3".equals(type)){  //年
                Calendar cal = Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                beginTime= year+"-01-01 00:00:00";
                endTime = year+"-12-31 23:59:59";
            }
            List<Order> orders=orderMapper.customerVolumeStatistics(Integer.valueOf(type),shopId,beginTime, endTime);
            jsonResult.setType(statistics(orders, myType, type, endTime));
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "客户量统计";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }


    public List<Order> statistics(List<Order> orders,String myType,String type,String endTime){
        SimpleDateFormat sff=new SimpleDateFormat("MM月dd号");
        Long timeBig=0L;
        for(Order order:orders){
            if(timeBig<order.getAddTime().getTime()){
                timeBig=order.getAddTime().getTime();
            }

            if("1".equals(type)){
                order.setTime( sff.format(order.getAddTime()));
            }else  if("3".equals(type)){
                order.setTime((Integer.parseInt(order.getTime())+"").concat("月"));
            }
        }

        SimpleDateFormat monthSf=new SimpleDateFormat("MM");
        String month=endTime.split("-")[1];

        SimpleDateFormat daySf=new SimpleDateFormat("dd");
        Integer start=Integer.parseInt(daySf.format(timeBig));

        Integer end=Integer.parseInt(endTime.split("-")[2].split(" ")[0]);
        if("1".equals(myType)){

            int k=1;
            for(int i=start;i<end;i++){
                Order order=new Order();
                order.setNum(0D);
                order.setTime(month.concat("月").concat((start+k)+"号"));
                orders.add(order);
                k++;
            }

        }else if("2".equals(myType)){
            List<Order> list=new ArrayList<>();
            for(int i=1;i<=end;i++){
                Order order=new Order();
                order.setNum(0D);
                if(i<10){
                    order.setTime(month.concat("月0".concat(i+"号")));
                }else {
                    order.setTime(month.concat("月".concat(i+"号")));
                }

                list.add(order);
            }
            for(int i=0;i<orders.size();i++){
                for(Order order:list){
                    if(order.getTime().equals(orders.get(i).getTime())){
                        order.setNum(orders.get(i).getNum());
                    }
                }


            }
            orders=list;
        }else if("3".equals(myType)){
            List<Order> list=new ArrayList<>();
            for(int i=1;i<13;i++){
                Order order=new Order();
                order.setNum(0D);
                order.setTime((i+"").concat("月"));
                list.add(order);
            }
            for(int i=0;i<orders.size();i++){
                for(Order order:list){
                    if(order.getTime().equals(orders.get(i).getTime())){
                        order.setNum(orders.get(i).getNum());
                    }
                }


            }
            orders=list;
        }

        return orders;

    }

}
