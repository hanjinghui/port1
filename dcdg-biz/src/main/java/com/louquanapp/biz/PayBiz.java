package com.louquanapp.biz;

import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.utils.Arith;
import com.louquanapp.dao.mapper.BuyCartMapper;
import com.louquanapp.dao.mapper.GoodsSkuMapper;
import com.louquanapp.dao.mapper.OrderItemMapper;
import com.louquanapp.dao.mapper.OrderMapper;
import com.louquanapp.dao.model.Customer;
import com.louquanapp.dao.model.GoodsSku;
import com.louquanapp.dao.model.Order;
import com.louquanapp.dao.model.OrderItem;
import com.louquanapp.model.TypeJsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/8 15:16
 * @Description: 支付业务逻辑
 */
@Service
public class PayBiz {
    private final BuyCartMapper buyCartMapper;
    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;
    private final GoodsSkuMapper goodsSkuMapper;


    public PayBiz(BuyCartMapper buyCartMapper, OrderMapper orderMapper, OrderItemMapper orderItemMapper, GoodsSkuMapper goodsSkuMapper) {
        this.buyCartMapper = buyCartMapper;
        this.orderMapper = orderMapper;
        this.orderItemMapper = orderItemMapper;
        this.goodsSkuMapper = goodsSkuMapper;
    }


    /**
     * 支付订单
     *
     * @param orderId
     * @param customer
     * @return
     */
    public synchronized TypeJsonResult<Order> doPay(String orderId, Customer customer, Double deductionPoint, Double consumePoint) {

        Date now = new Date();
        try {
            TypeJsonResult<Order> typeJsonResult = new TypeJsonResult<>();
            typeJsonResult.setStatusCode(false);

            List<Order> list = orderDetailByOrderIdAndCustId(orderId, customer.getCustId());
            if (null == list || list.size() == 0) {

                typeJsonResult.setStatusCode(false);
                typeJsonResult.setMessage("你访问的订单不存在");
                return typeJsonResult;
            }

            if (null != list && list.size() > 1) {
                typeJsonResult.setStatusCode(false);
                typeJsonResult.setMessage("你访问的订单有问题");
                return typeJsonResult;
            }
            Order order = list.get(0);


            List<OrderItem> orderItems = orderItemMapper.getOrderItemByOrderId(orderId);


            if (Arith.compareDoubleSize(customer.getDeductionPoint(), deductionPoint) < 0) {
                typeJsonResult.setStatusCode(false);
                typeJsonResult.setMessage("支付失败，当前可用积分不足" + customer.getDeductionPoint());
                return typeJsonResult;
            }

            if (Arith.compareDoubleSize(customer.getConsumePoint(), consumePoint) < 0) {
                typeJsonResult.setStatusCode(false);
                typeJsonResult.setMessage("支付失败，当前可用余额" + customer.getConsumePoint());
                return typeJsonResult;
            }

            Set<String> skuNos = orderItems.stream().map(OrderItem::getSkuNo).collect(Collectors.toSet());

            //校验客户有没有超过最大积分
            List<GoodsSku> listGoodsSku = goodsSkuMapper.getGoodsIdAndGoodsImgAndSkuGoodsNameAndPutawayPriceMaxPointBySkuIds(new ArrayList<>(skuNos));
            Map<String, GoodsSku> map = new HashMap<>();
            listGoodsSku.stream().forEach((temp) -> {
                map.put(temp.getSkuId(), temp);
            });
            AtomicReference<Double> maxPoint = new AtomicReference<>(0.00d);
            orderItems.stream().forEach((temp) -> {
                if (map.containsKey(temp.getSkuNo())) {
                    GoodsSku skuTemp = map.get(temp.getSkuNo());
                    maxPoint.set(Arith.add(maxPoint.get(), Arith.mul(skuTemp.getMaxPoint(), temp.getGoodsNum())));
                }
            });


            Double consumeAmt = consumePoint == null ? 0 : consumePoint;
            Double cxyAmt = 0.00d;
            Double deductionAmt = deductionPoint == null ? 0 : deductionPoint;

            Double total = Arith.add(deductionAmt, consumeAmt);
            if (Arith.compareDoubleSize(total, order.getOrderFee()) > 0) {
                deductionAmt = Arith.sub(deductionAmt, (Arith.sub(total, order.getOrderFee())));
            }


            if (Arith.compareDoubleSize(deductionAmt, maxPoint.get()) > 0) {
                typeJsonResult.setStatusCode(false);
                typeJsonResult.setMessage("你使用的消费通大于最大使用积分");
                return typeJsonResult;
            }

            if (StringUtils.isEmpty(order.getOrderNo())) {
                order.setOrderNo(orderId);
            } else {
                //order.setOrderNo(UUIDUtils.generateUuid22());
            }

            //TODO 消费积分，和沉香积分的扣除和更新
            int result = payUpdatePayTimeAndPayTypeAndCustIdAndOrderIdAndConsumeAmtAndCxyAmtAndDeductionAmt(orderId, customer.getCustId(), now, (byte) 0, order.getOrderNo(), consumeAmt, cxyAmt, deductionAmt);
            if (result == 0) {
                typeJsonResult.setStatusCode(false);
                typeJsonResult.setMessage("更新订单记录异常");
                return typeJsonResult;
            }

            typeJsonResult.setMessage(order.getOrderNo());


            order.setRmbAmt(Arith.sub(order.getOrderFee(), total));
            typeJsonResult.setType(order);
            typeJsonResult.setStatusCode(true);

            return typeJsonResult;

        } catch (Exception e) {
           if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("支付异常" + e.getMessage(), e);
            }

        }

    }

    private int payUpdatePayTimeAndPayTypeAndCustIdAndOrderIdAndConsumeAmtAndCxyAmtAndDeductionAmt(String orderId, String custId, Date now, byte b, String orderNo, Double consumeAmt, Double cxyAmt, Double deductionAmt) {
        return 0;
    }

    private List<Order> orderDetailByOrderIdAndCustId(String orderId, String custId) {
        return orderMapper.orderDetailByOrderIdAndCustId(custId, orderId);
    }
}
