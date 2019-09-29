package com.louquanapp.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.dao.mapper.*;
import com.louquanapp.dao.model.Order;
import com.louquanapp.dao.model.OrderItem;
import com.louquanapp.dao.model.Shop;
import com.louquanapp.dao.model.VideoPlaninfo;
import com.louquanapp.model.PageJsonResult;
import com.louquanapp.model.ReqForPageInfo;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqVideoPlanList;
import com.louquanapp.req.ReqVideoPlaninfo;
import com.louquanapp.req.ReqVideoPlaninfoOperation;
import com.louquanapp.utils.RongcloudUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/10 19:50
 * @description:
 */
@Service
public class VideoPlaninfoBiz {
    private final VideoPlaninfoMapper videoPlaninfoMapper;
    private final CustomerMapper customerMapper;
    private final ShopMapper shopMapper;
    private final OrderItemMapper orderItemMapper;
    private final OrderMapper orderMapper;
    private final SystemUserMapper systemUserMapper;


    public VideoPlaninfoBiz(VideoPlaninfoMapper videoPlaninfoMapper, CustomerMapper customerMapper, ShopMapper shopMapper
            , OrderItemMapper orderItemMapper, OrderMapper orderMapper,SystemUserMapper systemUserMapper) {
        this.videoPlaninfoMapper = videoPlaninfoMapper;
        this.customerMapper = customerMapper;
        this.shopMapper = shopMapper;
        this.orderItemMapper = orderItemMapper;
        this.orderMapper = orderMapper;
        this.systemUserMapper = systemUserMapper;
    }

    /**
     * 增加直播间预定信息
     *
     * @param reqVideoPlaninfo
     * @param custId
     * @return
     */
    @Transactional
    public JsonResult addVideoPlaninfoBiz(ReqVideoPlaninfo reqVideoPlaninfo, String custId) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            VideoPlaninfo videoPlaninfo = new VideoPlaninfo();

            String shopId = customerMapper.selectShopIdBuyVideoId(reqVideoPlaninfo.getVideoId());
            /*Shop shop=shopMapper.selectByPrimaryKey(shopId);

            String shopDesc=shop.getShopDesc();
            if (StringUtils.isNotBlank(shopDesc)){
                String  beginTimeStr=shopDesc.split("-")[0];
                String  endTimeStr=shopDesc.split("-")[1];

            }*/


            BeanUtils.copyProperties(reqVideoPlaninfo, videoPlaninfo);
            videoPlaninfo.setPlanId(UUIDUtils.genertateUuid32());
            videoPlaninfo.setAddTime(new Date());
            videoPlaninfo.setCustId(custId);
            videoPlaninfo.setPlanStatus((byte) 1);

            videoPlaninfo.setShopId(shopId);
            int count = videoPlaninfoMapper.insert(videoPlaninfo);
            if (count == 1) {
                jsonResult.setStatusCode(true);
                return jsonResult;
            } else {
                jsonResult.setMessage("增加直播间信息 失败了！");
                return jsonResult;
            }
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                String msg = "增加直播间信息";
                msg = String.format("在%s过程中,服务器开小差了", msg);
                throw new HuhuaminException(e.getMessage());
            } else {
                throw new HuhuaminException("" + e.getMessage());
            }
        }
    }

    /**
     * 查询直播间预定信息列表
     * @param reqVideoPlaninfoPage
     * @param custId
     * @return
     */
    public PageJsonResult<VideoPlaninfo> videoPlaninfos(ReqVideoPlanList reqVideoPlaninfoPage, String userId) {
        try {
            ReqForPageInfo reqForPageInfo=new  ReqForPageInfo (reqVideoPlaninfoPage.getPageNum(),reqVideoPlaninfoPage.getPageSize());


            String shopId=systemUserMapper.queryShopIdByUserId(userId);
            List<VideoPlaninfo> list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(),"ADD_TIME DESC").doSelectPage(() -> videoPlaninfoMapper
                    .videoPlaninfoList(reqVideoPlaninfoPage.getPlanStatus(),shopId));
            SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date now=new Date();
            for(VideoPlaninfo videoPlaninfo:list){
                if(sf.parse(videoPlaninfo.getPlanDate()).before(now)){
                    videoPlaninfo.setIsOverdue("0");
                }else{
                    videoPlaninfo.setIsOverdue("1");
                }
            }

            PageInfo<VideoPlaninfo> page = new PageInfo<VideoPlaninfo>(list);
            PageJsonResult<VideoPlaninfo> pageJsonResult = new PageJsonResult<VideoPlaninfo>(page);

            return  pageJsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            } else {
                throw new HuhuaminException("查询直播间预定信息列表" + e.getMessage());
            }
        }
    }

    /**
     * 删除直播间预定信息
     * @param planId
     * @param userId
     * @return
     */
    public JsonResult delOrUpdatePlanStatusForVideoPlaninfo(String  planId, String userId) {
        try {
            JsonResult jsonResult = new JsonResult(false);

           String shopId= systemUserMapper.queryShopIdByUserId(userId);

            int count= videoPlaninfoMapper.deleteVideoPlaninfoByPlanIdAndcCustId(planId,shopId);
            if (count == 1) {
                jsonResult.setStatusCode(true);
                return jsonResult;
            } else {
                jsonResult.setMessage("删除直播间预定信息 失败了！");
                return jsonResult;
            }

        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                String msg = "删除直播间预定信息";
                msg = String.format("在%s过程中,服务器开小差了", msg);
                throw new HuhuaminException(e.getMessage());
            } else {
                throw new HuhuaminException("" + e.getMessage());
            }
        }
    }


    /**
     * 预定信息的同意，拒绝，核销
     * @param reqVideoPlaninfoOperation
     * @param userId
     * @return
     */
    public JsonResult planinfoUpdateStatus(ReqVideoPlaninfoOperation reqVideoPlaninfoOperation, String userId) {
        try {
            JsonResult jsonResult = new JsonResult(false);

            String shopId= systemUserMapper.queryShopIdByUserId(userId);


            // 操作方式[1-商家确认 2-商家取消 3-结束]
            int count= 0;
            VideoPlaninfo videoPlaninfo=videoPlaninfoMapper.queryPlaninfoByPlanId(reqVideoPlaninfoOperation.getPlanId(),shopId);
            if(null==videoPlaninfo){
                jsonResult.setMessage("其他商铺信息，无权处理！");
                return jsonResult;
            }

            Shop shop=shopMapper.selectShortByPrimaryKey(shopId);
            if(1==reqVideoPlaninfoOperation.getPlanStatus()&&1==videoPlaninfo.getPlanStatus()){
                count= videoPlaninfoMapper.planinfoUpdateStatus(reqVideoPlaninfoOperation.getPlanId(),shopId
                        ,reqVideoPlaninfoOperation.getPlanStatus(),null);
                if (count != 1) {
                    jsonResult.setMessage("预定信息的同意操作失败了！");
                    return jsonResult;
                }
                RongcloudUtil.sendPlaninfo(videoPlaninfo.getCustId(),shop.getShopLogo(),shop.getShopName(),"预定成功");


            }else if(2==reqVideoPlaninfoOperation.getPlanStatus()&&1==videoPlaninfo.getPlanStatus()){
                if(StringUtils.isBlank(reqVideoPlaninfoOperation.getReply())){
                    jsonResult.setMessage("预定信息的拒绝操必须填写回复！");
                    return jsonResult;
                }
                RongcloudUtil.sendPlaninfo(videoPlaninfo.getCustId(),shop.getShopLogo(),shop.getShopName(),"预定失败");
                count= videoPlaninfoMapper.planinfoUpdateStatus(reqVideoPlaninfoOperation.getPlanId(),shopId
                        ,reqVideoPlaninfoOperation.getPlanStatus(),reqVideoPlaninfoOperation.getReply());
                if (count != 1) {
                    jsonResult.setMessage("预定信息的拒绝操作失败了！");
                    return jsonResult;
                }
            }else if(3==reqVideoPlaninfoOperation.getPlanStatus()&&2==videoPlaninfo.getPlanStatus()){
                count= videoPlaninfoMapper.planinfoUpdateStatus(reqVideoPlaninfoOperation.getPlanId(),shopId
                        ,reqVideoPlaninfoOperation.getPlanStatus(),null);
                if (count != 1) {
                    jsonResult.setMessage("预定信息的核销作失败了！");
                    return jsonResult;
                }
            }else {
                jsonResult.setMessage("预定信息状态不对！");
                return jsonResult;
            }
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                String msg = "预定信息的同意，拒绝，核销";
                msg = String.format("在%s过程中,服务器开小差了", msg);
                throw new HuhuaminException(e.getMessage());
            } else {
                throw new HuhuaminException("" + e.getMessage());
            }
        }
    }
    /**
     * 直播间预定信息详情
     * @param planId
     * @param custId
     * @return
     */
    public TypeJsonResult<VideoPlaninfo> videoPlaninfoDatail(String  planId, String userId) {
        try {
            TypeJsonResult<VideoPlaninfo> jsonResult = new TypeJsonResult();
            jsonResult.setStatusCode(false);
            String shopId= systemUserMapper.queryShopIdByUserId(userId);
            VideoPlaninfo  videoPlaninfo=videoPlaninfoMapper .videoPlaninfoDetail(planId,shopId);
            if(null==videoPlaninfo){
                jsonResult.setMessage("其他商铺信息，无权处理！");
                return jsonResult;
            }

            SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
             if(sf.parse(videoPlaninfo.getPlanDate()).before(new Date())){
                    videoPlaninfo.setIsOverdue("0");
             }else{
                    videoPlaninfo.setIsOverdue("1");
             }



            jsonResult.setStatusCode(true);
            jsonResult.setType(videoPlaninfo);
            return jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                String msg = "直播间预定信息详情";
                msg = String.format("在%s过程中,服务器开小差了", msg);
                throw new HuhuaminException(e.getMessage());
            } else {
                throw new HuhuaminException("" + e.getMessage());
            }
        }
    }


    /**
     * 餐饮订单信息订单详情
     * @param planId
     * @param custId
     * @return
     */
    public TypeJsonResult<Shop> promotionOrderDatail(String  orderId, String custId) {
        try {
            TypeJsonResult<Shop> jsonResult = new TypeJsonResult(false);

           List<OrderItem> orderItems= orderItemMapper.getOrderItemByOrderId(orderId);

           Order order=orderMapper.queryOrderByOrderId(custId,orderId);

            Shop shop=shopMapper.selectShortByPrimaryKey(order.getShopId());

            SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            if(null!=order.getPlanEatTime()){
                shop.setPlanEatTime(sf.format(order.getPlanEatTime()));
            }

            shop.setOrderItems(orderItems);

            jsonResult.setStatusCode(true);
            jsonResult.setType(shop);
            return jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                String msg = "餐饮订单信息订单详情";
                msg = String.format("在%s过程中,服务器开小差了", msg);
                throw new HuhuaminException(e.getMessage());
            } else {
                throw new HuhuaminException("" + e.getMessage());
            }
        }
    }


}
