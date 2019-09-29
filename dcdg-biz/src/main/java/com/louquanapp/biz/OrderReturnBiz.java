package com.louquanapp.biz;

import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.dao.mapper.*;
import com.louquanapp.dao.model.*;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqOrderReturn;
import com.louquanapp.utils.BizUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/10 9:53
 * @description:
 */
@Service
public class OrderReturnBiz {
    private final CustomerMapper customerMapper;

    private final OrderReturnMapper orderReturnMapper;
    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;
    private final OrderOperateMapper orderOperateMapper;

    public OrderReturnBiz(CustomerMapper customerMapper, OrderReturnMapper orderReturnMapper, OrderMapper orderMapper, OrderItemMapper orderItemMapper, OrderOperateMapper orderOperateMapper) {
        this.customerMapper = customerMapper;
        this.orderReturnMapper = orderReturnMapper;
        this.orderMapper = orderMapper;
        this.orderItemMapper = orderItemMapper;
        this.orderOperateMapper = orderOperateMapper;
    }

    /**
     * 增加订单退货信息
     *
     * @param reqSource
     * @return
     */
    @Transactional
    public synchronized JsonResult addOrderReturn(ReqOrderReturn reqSource, String custId) {
        JsonResult jsonResult = new JsonResult(false);
        try {

            if (StringUtils.isEmpty(reqSource.getReturnId())) {
                OrderReturn orderReturnTemp = orderReturnMapper.selectByChildIdAndBuyerId(reqSource.getChildId(), custId);
                if (null != orderReturnTemp) {
                    jsonResult.setMessage("不要重复提交信息");
                    return jsonResult;
                }
            }


            OrderReturn orderReturn = new OrderReturn();
            String returnImg = reqSource.getReturnImg();


            if (StringUtils.isNotBlank(returnImg)) {
                if (returnImg.split(",").length > 3) {
                    jsonResult.setMessage("上传凭证不能超过三张");
                    return jsonResult;
                }
                orderReturn.setReturnImg(returnImg);
            }


            BeanUtils.copyProperties(reqSource, orderReturn);

            orderReturn.setAddTime(new Date());
            orderReturn.setGoodStatus(reqSource.getGoodStatus());
            orderReturn.setReturnStatus((byte) 1);


            OrderItem orderItem = orderItemMapper.selectByPrimaryKey(reqSource.getChildId());

            if (null == orderItem) {
                jsonResult.setMessage("商品子订单不存在！");
                return jsonResult;
            }


            String goodsId = orderItem.getGoodsId();
            String skuValue = orderItem.getSkuValue();
            String orderId = orderItem.getOrderId();

            Order order = orderMapper.selectOrderStatusShopIdAndShopNameByOrderId(orderId);
            int tmpOrderStatus = order.getOrderStatus();
            if (tmpOrderStatus != 201 && tmpOrderStatus != 401 && tmpOrderStatus != 501 && tmpOrderStatus != 901) {
                jsonResult.setMessage("只有已付款，已发货，已收货的商品,维权退款申请中才能申请售后");
                return jsonResult;
            }

            orderReturn.setOrderId(orderId);
            orderReturn.setGoodsId(goodsId);
            orderReturn.setSkuVal(skuValue);
            orderReturn.setIsPromotion(order.getIsPromotion());


            String shopId = order.getShopId();
            String shopName = order.getShopName();

            orderReturn.setSellerId(shopId);
            orderReturn.setSellerName(shopName);


            Customer customer = customerMapper.selectByPrimaryKey(custId);

            String custName = BizUtils.getCustName(customer);
            orderReturn.setBuyerId(custId);
            orderReturn.setBuyerName(custName);
            orderReturn.setChildId(reqSource.getChildId());

            int count = 0;
            if (StringUtils.isNotBlank(reqSource.getReturnId())) {
                orderReturn.setReturnId(reqSource.getReturnId());
                count = orderReturnMapper.updateByPrimaryKey(orderReturn);
            } else {
                orderReturn.setReturnId(UUIDUtils.generateUuid22());
                count = orderReturnMapper.insert(orderReturn);
            }


            if (count == 1) {
                //订单状态[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货 501-已收货 601-退货申请中 611-退货中 621-已退货 701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]
                //901-维权退款申请中
                int result = orderMapper.updateOrderStatusAndCustIdAndUpdateTime(901, orderItem.getOrderId(), custId, new Date(), order.getOrderStatus());
                if (result == 0) {
                    throw new HuhuaminException("订单状态不正确");
                }


                //订单日志
                OrderOperate orderOperate = new OrderOperate();
                orderOperate.setOptId(UUIDUtils.generateUuid22());
                orderOperate.setOrderId(orderItem.getOrderId());
                orderOperate.setChildId(orderItem.getChildId());


                orderOperate.setOrderStatusBefore(order.getOrderStatus());
                orderOperate.setOrderStatusNow(901);
                orderOperate.setOptRemark("买家退货陈重新申请");
                orderOperate.setOptSource("buyer");
                orderOperate.setUserId(customer.getCustId());
                orderOperate.setUserName(BizUtils.getCustName(customer));
                orderOperate.setAddTime(new Date());
                result = orderOperateMapper.insert(orderOperate);
                if (result == 0) {
                    throw new HuhuaminException("订单日志保存失败");
                }

                jsonResult.setStatusCode(true);
                return jsonResult;
            } else {
                jsonResult.setStatusCode(false);
                jsonResult.setMessage("订单退货失败！");
                return jsonResult;
            }
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException("增加订单退货信息" + e.getMessage(), e);
            }
        }


    }

    /**
     * 根据订单子项查询退货申请
     *
     * @param childId
     * @param custId
     * @return
     */
    public TypeJsonResult<OrderReturn> orderReturn(String childId, String custId) {

        try {
            TypeJsonResult<OrderReturn> typeJsonResult = new TypeJsonResult<>();

            OrderReturn orderReturn = orderReturnMapper.selectByChildIdAndBuyerId(childId, custId);
            typeJsonResult.setType(orderReturn);
            typeJsonResult.setStatusCode(true);
            return typeJsonResult;
        } catch (Exception e) {
            String msg = "根据订单子项查询退货申请";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage(), e);
        }

    }
}
