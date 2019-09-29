package com.louquanapp.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.dao.EvaluateStatics;
import com.louquanapp.dao.mapper.*;
import com.louquanapp.dao.model.*;
import com.louquanapp.model.PageJsonResult;
import com.louquanapp.model.ReqForPageInfo;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqMyEvaluate;
import com.louquanapp.req.ReqOrderComment;
import com.louquanapp.req.ReqOrderEvaluate;
import com.louquanapp.utils.BizUtils;
import com.louquanapp.utils.RelativeDateFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/10 15:30
 * @description:
 */
@Service
public class OrderEvaluateBiz {
    private final OrderEvaluateMapper orderEvaluateMapper;
    private final CustomerMapper customerMapper;
    private final OrderOperateMapper orderOperateMapper;
    private final OrderItemMapper orderItemMapper;
    private final GoodsMapper goodsMapper;
    private final OrderMapper orderMapper;
    private final SystemUserMapper systemUserMapper;

    public OrderEvaluateBiz(OrderEvaluateMapper orderEvaluateMapper, CustomerMapper customerMapper, OrderOperateMapper orderOperateMapper
            , OrderItemMapper orderItemMapper, GoodsMapper goodsMapper, OrderMapper orderMapper,SystemUserMapper systemUserMapper) {
        this.orderEvaluateMapper = orderEvaluateMapper;
        this.customerMapper = customerMapper;
        this.orderOperateMapper = orderOperateMapper;
        this.orderItemMapper = orderItemMapper;
        this.goodsMapper = goodsMapper;
        this.orderMapper = orderMapper;
        this.systemUserMapper = systemUserMapper;
    }

    /**
     * 商品评论列表
     * @param reqSource
     * @param userId
     * @return
     */
    public PageJsonResult<OrderEvaluate> evaluateList(ReqOrderEvaluate reqSource,String userId) {
        try {
            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqSource.getPageNum(), reqSource.getPageSize());

            String shopId=systemUserMapper.queryShopIdByUserId(userId);
            List<OrderEvaluate>   list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(), "ADD_TIME DESC ").doSelectPage(() -> orderEvaluateMapper
                    .evaluateList(shopId, reqSource.getIsReply()));

            for(OrderEvaluate orderEvaluate:list){
                orderEvaluate.setGoodsImgList(orderItemMapper.getGoodsImgByOrderId(orderEvaluate.getOrderId()));
            }
            PageInfo<OrderEvaluate> page = new PageInfo<>(list);
            PageJsonResult<OrderEvaluate> pageJsonResult = new PageJsonResult<>(page);
            //pageJsonResult.setExtra(evaluateStatics);
            return pageJsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            String msg = "查询商品评论";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            throw new HuhuaminException(msg + e.getMessage(), e);

        }
    }
    /**
     * 商品评论详情
     *
     * @param reqSource
     * @param custId
     * @return
     */
    public TypeJsonResult evaluateDetail(String  evaluateId,String userId) {
        try {

            TypeJsonResult jsonResult=new TypeJsonResult();
            String shopId=systemUserMapper.queryShopIdByUserId(userId);
            OrderEvaluate orderEvaluate=orderEvaluateMapper.evaluateDetail(shopId,evaluateId);

            //Order order=orderMapper.selectOrderStatusShopIdAndShopNameByOrderId(orderEvaluate.getOrderId());
            OrderItem orderItem= orderItemMapper.selectByPrimaryKey(orderEvaluate.getChildId());
            if(null!=orderItem){
                orderEvaluate.setGoodsImg(orderItem.getGoodsImg());
                orderEvaluate.setGoodsName(orderItem.getGoodsName());
                orderEvaluate.setSkuValue(orderItem.getSkuValue());
                orderEvaluate.setPutawayPrice(orderItem.getPutawayPrice());
            }
            jsonResult.setType(orderEvaluate);
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            String msg = "商品评论详情";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            throw new HuhuaminException(msg + e.getMessage(), e);

        }
    }

    /**
     * 回复商品评论
     * @param evaluateId
     * @param userId
     * @param replyCont
     * @return
     */
    public JsonResult replyEvaluate(String  evaluateId,String userId,String replyCont) {
        try {
            JsonResult jsonResult=new JsonResult();
            String shopId=systemUserMapper.queryShopIdByUserId(userId);
            int  count=orderEvaluateMapper.replyEvaluate(shopId,evaluateId,replyCont);
            if(count==1){
                jsonResult.setStatusCode(true);
            }else{
                jsonResult.setMessage("回复商品评论失败！");
            }

            return jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            String msg = "回复商品评论";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            throw new HuhuaminException(msg + e.getMessage(), e);

        }
    }

    /**
     * 查询我的评价评论信息
     *
     * @param reqSource
     * @param custId
     * @return
     */
    public TypeJsonResult<OrderEvaluate> evaluate(String childId, String custId) {
        try {
            TypeJsonResult<OrderEvaluate> typeJsonResult = new TypeJsonResult<>();
            OrderEvaluate orderEvaluate = orderEvaluateMapper.selectByChildIdAndBuyerId(childId, custId);

            EvaluateStatics evaluateStatics = GoodsBiz.getEvaluateStaticsByCustId(custId, orderEvaluateMapper);
            typeJsonResult.setType(orderEvaluate);
            typeJsonResult.setStatusCode(true);
            return typeJsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            String msg = "查询单个我的评论";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            throw new HuhuaminException(msg + e.getMessage(), e);
        }
    }


    /**
     * @param list 数据库实体
     */
    public void formatCustNnameAndEvaluateResult(List<OrderEvaluate> list, CustomerMapper customerMapper) {

        List<String> buyIds = new ArrayList<>();
        for (OrderEvaluate temp : list
        ) {
            buyIds.add(temp.getBuyerId());
        }
        //获取用户头像
        if (!CollectionUtils.isEmpty(buyIds)) {
            List<Customer> customers = customerMapper.getHeadImgMapByCustIdIn(buyIds);

            Map<String, Customer> mapCustIdHeadImg = convertToMap(customers);
            for (OrderEvaluate temp : list
            ) {
                temp.setAddTimeStr(RelativeDateFormatUtils.format(temp.getAddTime()));
                Customer customer = mapCustIdHeadImg.get(temp.getBuyerId());
                if (null != customer) {
                    temp.setHeadImg(customer.getHeadImg());
                    String name = BizUtils.getCustName(customer);
                    String showName = name.substring(0, 5);
                    showName = showName.concat("****").concat(name.substring(name.length() - 2, name.length() - 1));
                    temp.setBuyerName(showName);
                }

                if (temp.getEvaluateResult().intValue() == 1) {
                    temp.setEvaluateScoreStr("好评");
                } else if (temp.getEvaluateResult().intValue() == 2) {
                    temp.setEvaluateScoreStr("中评");
                } else if (temp.getEvaluateResult().intValue() == 2) {
                    temp.setEvaluateScoreStr("差评");
                }
            }

        }

    }

    /**
     * 转成 map
     *
     * @param customers
     * @return
     */
    private Map<String, Customer> convertToMap(List<Customer> customers) {
        Map<String, Customer> map = new HashMap<>();
        if (CollectionUtils.isEmpty(customers)) {
            return map;
        } else {
            customers.forEach(t -> {
                String id = t.getCustId();
                map.put(id, t);
            });
            return map;
        }
    }


    /**
     * 评论订单子项
     *
     * @param reqSource
     * @param custId
     * @return
     */
    @Transactional
    public synchronized JsonResult orderComment(ReqOrderComment reqSource, String custId) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            Date now = new Date();
            //处理评价图片
            String ossImgs = reqSource.getEvaluateImg();
            if (StringUtils.isNotEmpty(ossImgs)) {
                String[] ss = ossImgs.split(",");
                if (ss.length > 3) {
                    jsonResult.setMessage("最多只能上传3张图片");
                    return jsonResult;
                }
            }
            //评价表
            OrderItem orderItem = orderItemMapper.selectByPrimaryKey(reqSource.getChildId());
            if (null == orderItem) {
                jsonResult.setMessage("查不到子订单");
                return jsonResult;
            }

//            OrderEvaluate orderEvaluate = orderEvaluateMapper.selectByChildIdAndBuyerId(reqSource.getChildId(), custId);
//            if (null != orderEvaluate) {
//
//            }

            Order order = orderMapper.selectOrderStatusShopIdAndShopNameByOrderId(orderItem.getOrderId());
            int tmpOrderStatus = order.getOrderStatus().intValue();
            // 只有已付款，已发货，已收货的商品才能评价
            if (tmpOrderStatus != 201 && tmpOrderStatus != 401 && tmpOrderStatus != 501) {
                jsonResult.setMessage("只有已付款，已发货，已收货的商品才能评价");
                return jsonResult;
            }
            //订单状态[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货 501-已收货 601-退货申请中 611-退货中 621-已退货 701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]

            OrderEvaluate orderEvaluate = new OrderEvaluate();

            orderEvaluate.setChildId(orderItem.getChildId());
            orderEvaluate.setOrderId(orderItem.getOrderId());
            orderEvaluate.setGoodsId(orderItem.getGoodsId());
            orderEvaluate.setIsAnony((byte) 0);

            orderEvaluate.setEvaluateScore(reqSource.getEvaluateScore());
            //好评中评转换
            if (orderEvaluate.getEvaluateScore().intValue() == 0) {
                orderEvaluate.setEvaluateResult((byte) 3);

            } else if (orderEvaluate.getEvaluateScore().intValue() > 0 && orderEvaluate.getEvaluateScore().intValue() > 3) {
                orderEvaluate.setEvaluateResult((byte) 2);
            } else {
                orderEvaluate.setEvaluateResult((byte) 1);
            }
            Customer customer = customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(custId);
            orderEvaluate.setBuyerId(custId);
            orderEvaluate.setBuyerName(BizUtils.getCustName(customer));
            orderEvaluate.setEvaluateCont(reqSource.getEvaluateCont());

            String goodsId = orderItem.getGoodsId();
            //卖家信息
            orderEvaluate.setSellerId(order.getShopId());
            orderEvaluate.setSellerName(order.getShopName());
            orderEvaluate.setAddTime(now);
            orderEvaluate.setSkuVal(orderItem.getSkuValue());
            orderEvaluate.setEvaluateImg(ossImgs);
            orderEvaluate.setDeliverScore(reqSource.getDeliverScore());
            //保存评价信息
            int result = 0;
            if (StringUtils.isNotBlank(reqSource.getEvaluateId())) {
                orderEvaluate.setEvaluateId(reqSource.getEvaluateId());
                result = orderEvaluateMapper.updateByPrimaryKey(orderEvaluate);
            } else {
                orderEvaluate.setEvaluateId(UUIDUtils.generateUuid22());
                result = orderEvaluateMapper.insert(orderEvaluate);
            }

            if (result == 0) {
                jsonResult.setMessage("插入评价数据错误");
                return jsonResult;
            }

            //订单日志
            OrderOperate orderOperate = new OrderOperate();
            orderOperate.setOptId(UUIDUtils.generateUuid22());
            orderOperate.setOrderId(orderItem.getOrderId());
            orderOperate.setChildId(orderItem.getChildId());


            orderOperate.setOrderStatusBefore(order.getOrderStatus());
            orderOperate.setOrderStatusNow(701);
            if (StringUtils.isNotBlank(reqSource.getEvaluateId())) {
                orderOperate.setOptRemark("买家评价重新提交");
            } else {
                orderOperate.setOptRemark("买家评价");
            }

            orderOperate.setOptSource("buyer");
            orderOperate.setUserId(customer.getCustId());
            orderOperate.setUserName(customer.getRealName());
            orderOperate.setAddTime(new Date());
            result = orderOperateMapper.insert(orderOperate);
            if (result == 0) {
                throw new HuhuaminException("订单日志保存失败");
            }

            //订单子表修改状态
            int orderItemCount = orderItemMapper.getCountByOrderId(orderItem.getOrderId());
            int evaluateCount = orderEvaluateMapper.selectCountByOrderId(orderItem.getOrderId());
            if (orderItemCount == evaluateCount) {
                //701 已评价
                //订单状态[101-未付款 201-已付款 301-退款申请中 311-退款成功 401-已发货 501-已收货 601-退货申请中 611-退货中 621-已退货 701-已评价 801-已追加评论 901-维权退款申请中 911-维权退款成功 80-订单取消]
                result = orderMapper.updateOrderStatusAndCustIdAndUpdateTime(701, orderItem.getOrderId(), custId, now, order.getOrderStatus());
            }

            jsonResult.setStatusCode(true);
            return jsonResult;


        } catch (Exception e) {
            String msg = "评论商品";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage(), e);
        }

    }

    /**
     * 我的订单评论
     *
     * @param reqSource
     * @param custId
     * @return
     */
    public PageJsonResult<OrderEvaluate> myEvaluates(ReqMyEvaluate reqSource, String custId) {
        try {
            String headImg = customerMapper.getHeadImgMapByCustId(custId);

            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqSource.getPageNum(), reqSource.getPageSize());

            List<OrderEvaluate> list = null;
            /*评价结果[0-全部  1-有图 ]*/
            list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize()).doSelectPage(() -> orderEvaluateMapper
                    .myListOrderEvaluateByGoodsIdAndEvaluateResult(custId, reqSource.getEvaluateResult()));

            for (OrderEvaluate temp : list
            ) {
                temp.setHeadImg(headImg);
            }
            PageInfo<OrderEvaluate> page = new PageInfo<>(list);

            PageJsonResult<OrderEvaluate> pageJsonResult = new PageJsonResult<>(page);

            pageJsonResult.setExtra(GoodsBiz.getEvaluateStaticsByCustId(custId, orderEvaluateMapper));
            return pageJsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException("我的订单评论" + e.getMessage(), e);

        }
    }


}
