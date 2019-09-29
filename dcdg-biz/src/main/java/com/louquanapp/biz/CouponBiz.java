package com.louquanapp.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.dao.mapper.*;
import com.louquanapp.dao.model.Coupon;
import com.louquanapp.dao.model.Customer;
import com.louquanapp.dao.model.CustomerCoupon;
import com.louquanapp.dao.model.Shop;
import com.louquanapp.model.PageJsonResult;
import com.louquanapp.model.ReqForPageInfo;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqAddCoupon;
import com.louquanapp.req.ReqCouponPage;
import com.louquanapp.req.ReqReceiveCoupon;
import com.louquanapp.req.ReqTokenPage;
import com.louquanapp.utils.ImageAndQRcode;
import com.louquanapp.utils.OssLocalClientUtils;
import jodd.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/7 19:02
 * @Description:优惠券业务逻辑
 */
@Service
public class CouponBiz {
    private final CouponMapper couponMapper;
    private final ShopMapper shopMapper;
    private final GoodsMapper goodsMapper;
    private final CustomerCouponMapper customerCouponMapper;
    private final SystemUserMapper systemUserMapper;
    private final CustomerMapper customerMapper;

    public CouponBiz(CouponMapper couponMapper, ShopMapper shopMapper, GoodsMapper goodsMapper, CustomerCouponMapper customerCouponMapper
        ,SystemUserMapper systemUserMapper,CustomerMapper customerMapper) {
        this.couponMapper = couponMapper;
        this.shopMapper = shopMapper;
        this.goodsMapper = goodsMapper;
        this.customerCouponMapper = customerCouponMapper;
        this.systemUserMapper = systemUserMapper;
        this.customerMapper = customerMapper;
    }

    /**
     * 领取类优惠卷列表
     * @param custId
     * @param reqSource
     * @return
     */
    public PageJsonResult<Coupon> couponsReceive(String custId, ReqReceiveCoupon reqSource) {
        try {
            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqSource.getPageNum(), reqSource.getPageSize());
            List<Coupon> list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(), "ADD_TIME DESC ").doSelectPage(() ->
                    couponMapper.couponsReceive(reqSource.getCouponType(),reqSource.getCouponConent(),null,null));
            PageInfo<Coupon> page = new PageInfo<>(list);
            PageJsonResult<Coupon> pageJsonResult = new PageJsonResult<>(page);
            return pageJsonResult;
        } catch (Exception e) {
            String msg = "领取类优惠卷列表";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException(msg + e.getMessage(), e);
            }

        }
    }


    /**
     * 获取领取类优惠卷
     * @param custId
     * @param couponId
     * @return
     */
    @Transactional
    public JsonResult getcouponReceive(String custId, String couponId) {
        try {
            JsonResult jsonResult=new JsonResult();

            Coupon coupon= couponMapper.selectByPrimaryKey(couponId);
            if(null==coupon){
                throw new HuhuaminException("优惠劵不存在！");
            }

            if(coupon.getHaveNum()<=customerCouponMapper.existCustomerCoupon(couponId,custId)){
                throw new HuhuaminException("你已经领取过了！");
            }


            List<Coupon>  coupons=couponMapper.couponsReceive(coupon.getCouponType(),coupon.getCouponConent(),null,null);
            if(CollectionUtils.isEmpty(coupons)){
                throw new HuhuaminException("优惠劵已经没有了！");
            }

            CustomerCoupon customerCoupon=new CustomerCoupon();

            customerCoupon.setCustCouponId(UUIDUtils.generateUuid22());
            customerCoupon.setCouponId(couponId);
            customerCoupon.setCustId(custId);
            customerCoupon.setAddTime(new Date());
            customerCoupon.setIsUse((byte)2);

            customerCoupon.setCouponImg(getCouponImg("{\"liveVideoId\":\""+couponId+"\",\"type\":2}"));
            customerCouponMapper.insert(customerCoupon);
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "获取领取类优惠卷";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException(msg + e.getMessage(), e);
            }

        }
    }

    public static String getCouponImg(String text){
        String couponImg="";
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        String t = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String outPath = String.valueOf(new Date().getTime()) + ".png";
        //1000 1500
        //isBackground 是否融入背景[1-有背景 2-没有背景]

        ImageAndQRcode.zxingCodeCreateImage(2,text, 412, 412, path + "bg.jpg", path + outPath, "169", "461");


        couponImg = OssLocalClientUtils.convertPathToOssObject(path + outPath);
        ImageAndQRcode.removeTempFile(path + outPath);


        return couponImg;
    }

    /**
     * @param custId
     * @param reqSource
     * @return
     */
    public PageJsonResult<Coupon> couponsByCustIdAndType(String userId, ReqTokenPage reqSource) {
        try {
            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqSource.getPageNum(), reqSource.getPageSize());
            String custId=systemUserMapper.queryCustIdByUserId(userId);
            List<Coupon> list = null;
            list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(), "DIE_TIME ASC ").doSelectPage(() -> couponMapper.couponsByCustId(custId,null));
            Shop shop=new Shop();
            for(Coupon coupon:list){
                //类型[1-商品优惠 2-店铺优惠 3-全场通用]

                if(coupon.getCouponType()==1){
                    shop=shopMapper.selectShortByPrimaryKey(goodsMapper.selectShort(coupon.getCouponConent()).getShopId());
                    coupon.setShopLogo(shop.getShopLogo());
                    coupon.setShopName(shop.getShopName());
                }else if(coupon.getCouponType()==2){
                    shop=shopMapper.selectShortByPrimaryKey(coupon.getCouponConent());
                    coupon.setShopLogo(shop.getShopLogo());
                    coupon.setShopName(shop.getShopName());
                }
            }

            PageInfo<Coupon> page = new PageInfo<>(list);
            PageJsonResult<Coupon> pageJsonResult = new PageJsonResult<>(page);
            return pageJsonResult;
        } catch (Exception e) {
            String msg = "客户优惠券分页";
            msg = String.format("在%s过程中,服务器开小差了", msg);
           if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException(msg + e.getMessage(), e);
            }

        }
    }


    /**
     * 线下使用优惠券
     * @param custId
     * @param couponId
     * @return
     */
    public JsonResult userCoupon(String custId, String couponId) {
        try {
            JsonResult jsonResult=new JsonResult(false);



            Coupon coupon=couponMapper.selectByPrimaryKey(couponId);
            if(coupon==null){
                jsonResult.setMessage("优惠券不存在！");
                return jsonResult;
            }
            Shop shop=shopMapper.queryShopByCustId(custId);
            if(shop==null){
                jsonResult.setMessage("你不是商家不能使用该优惠卷！");
                return jsonResult;
            }

            //类型[1-商品优惠 2-店铺优惠 3-全场通用]
            Byte couponType=coupon.getCouponType();
            if(couponType==1){
               String shopId= goodsMapper.selectShort(coupon.getCouponConent()).getShopId();
               if(!shop.getShopId().equals(shopId)){
                   jsonResult.setMessage("该优惠卷不能在本店使用！");
                   return jsonResult;
               }

            }else if(couponType==2){
                if(!coupon.getCouponConent().equals(shop.getShopId())){
                    jsonResult.setMessage("该优惠卷不能在本店使用！");
                    return jsonResult;
                }

            }

            if(coupon.getCouponWay()==1){
                jsonResult.setMessage("线上优惠券不可以使用！");
                return jsonResult;
            }

            int count=couponMapper.userCoupon(couponId,custId);
            if(count==1){
                jsonResult.setStatusCode(true);
            }else {
                jsonResult.setMessage("线下使用优惠券失败！");
            }
            return jsonResult;
        } catch (Exception e) {
            String msg = "线下使用优惠券";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException(msg + e.getMessage(), e);
            }

        }
    }


    /**
     * 优惠劵列表
     * @param userId
     * @param reqSource
     * @return
     */

    public PageJsonResult<Coupon> couponList(String userId, ReqCouponPage reqSource) {
        try {
            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqSource.getPageNum(), reqSource.getPageSize());
            String shopId=systemUserMapper.queryShopIdByUserId(userId);
            List<Coupon> list =  PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(), "ADD_TIME ASC ").doSelectPage(() ->
                    couponMapper.couponList(userId,reqSource.getType()));
            Shop shop=new Shop();
            CustomerCoupon customerCoupon = new CustomerCoupon();
            for(Coupon coupon:list){
                //类型[1-商品优惠 2-店铺优惠 3-全场通用]
                shop=shopMapper.selectShortByPrimaryKey(shopId);
                coupon.setShopLogo(shop.getShopLogo());
                coupon.setShopName(shop.getShopName());

                customerCoupon = customerCouponMapper.queryCouponCountByCouponId(coupon.getCouponId());
                // `HAVE_TYPE` tinyint(3) NOT NULL COMMENT '获取方式[1-派送 2-领取]'
                if(coupon.getHaveType()==1){
                    coupon.setUsedCount(customerCoupon.getUsedCount());
                    coupon.setNotUsedCount(customerCoupon.getNotUsedCount());
                    coupon.setExpiredCount(customerCoupon.getExpiredCount());
                }else if(coupon.getHaveType()==2){
                    coupon.setUsedCount(customerCoupon.getUsedCount());
                    coupon.setNotUsedCount(customerCoupon.getNotUsedCount());
                    coupon.setExpiredCount(customerCoupon.getExpiredCount());
                    coupon.setReceiveCount(customerCoupon.getUsedCount()+customerCoupon.getNotUsedCount()+customerCoupon.getExpiredCount());
                }
               if(coupon.getDieTime().before(new Date())){
                   coupon.setIsUse(3);
               }else {
                   coupon.setIsUse(2);
               }


            }
            PageInfo<Coupon> page = new PageInfo<>(list);
            PageJsonResult<Coupon> pageJsonResult = new PageJsonResult<>(page);
            return pageJsonResult;
        } catch (Exception e) {
            String msg = "优惠劵列表";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException(msg + e.getMessage(), e);
            }
        }
    }

    /**
     * 增加优惠券
     * @param userId
     * @param coupon
     * @return
     */
    @Transactional
    public JsonResult addCoupon(String userId, ReqAddCoupon coupon) {
        try {
           JsonResult jsonResult=new JsonResult();

           //获取方式[1-派送 2-领取]
           if(2==coupon.getHaveType()){
               if(coupon.getSendCount()<1){
                   throw new HuhuaminExceptionPlan("领取类优惠券必须有发行量！");
               }
               if(coupon.getHaveNum()<1){
                   throw new HuhuaminExceptionPlan("领取类优惠券限领数量不能为空！！");
               }

           }else {
               coupon.setHaveNum((byte)1);
           }
            Date now=new Date();
           if(coupon.getDieTime().before(now)){
               throw new HuhuaminExceptionPlan("有效结束日期不能小于当前时间！！");
           }

            if(coupon.getDieTime().before(coupon.getStartTime())){
                throw new HuhuaminExceptionPlan("有效结束日期不能小于有效开始日期！！");
            }
            String couponConent=coupon.getCouponConent();
            Byte couponType=coupon.getCouponType();
            // 类型[1-商品优惠 2-店铺优惠 3-全场通用  4-体验券]
            //优惠劵使用方式[1-线上 2-线下]
            if(coupon.getCouponWay()==2){
                if(couponType!=2){
                    throw new HuhuaminExceptionPlan("线下优惠券必须是店铺类优惠劵！");
                }
            }
            if(couponType==1) {
                if(StringUtils.isNotBlank(couponConent)) {
                    List<String> couponConent1List= Arrays.asList(couponConent.split(","));
                    String couponConent1Set=new HashSet<String>(couponConent1List).toString().replaceAll(" ", "");
                    couponConent1Set=couponConent1Set.substring(1, couponConent1Set.length()-1);
                    coupon.setCouponConent(couponConent1Set);
                }else {
                    throw new HuhuaminExceptionPlan("商品必须选择！");
                }

            }else if(couponType==2) {

                if(2==coupon.getCouponType()){
                    coupon.setCouponConent(systemUserMapper.queryShopIdByUserId(userId));
                }

            }else if(couponType==4) {  // 类型[1-商品优惠 2-店铺优惠 3-全场通用 4-体验券]
                if(1==coupon.getCouponWay()) {  //优惠劵使用方式[1-线上 2-线下]
                    throw new HuhuaminExceptionPlan("体验券必须线下方式");
                };
                if(coupon.getMinMoney() !=0) {  //最低消费
                    throw new HuhuaminExceptionPlan("体验券最低消费必须是0");
                };
                coupon.setCouponConent("");
            }

            coupon.setAddUserName(systemUserMapper.queryUserNameByUserId(userId));
            coupon.setAddUser(userId);
            //用户[1-所有 2-个人]
            //coupon.setSendType((byte)2);
            Shop shop=shopMapper.selectShortByPrimaryKey(systemUserMapper.queryShopIdByUserId(userId));
            coupon.setCouponLogo(shop.getShopLogo());
            //优惠方式[1-满减 2-折扣]
            if(coupon.getCouponMoney()<1){
                coupon.setCouponStyle((byte)2);
                coupon.setCouponMoneyType((byte)2);

            }else {
                coupon.setCouponStyle((byte)1);
                coupon.setCouponMoneyType((byte)1);
            }
            String couponId=UUIDUtils.generateUuid22();
            int count =0;
            if (coupon.getHaveType().intValue() == 1) {
                List<String> custIds = new ArrayList<>();
                if (coupon.getSendType() == 1) {
                    List<Customer> customers = customerMapper.custList();
                   for(Customer customer:customers){
                       custIds.add(customer.getCustId());
                   }
                } else {
                    custIds = Arrays.asList(coupon.getCustIds().split(","));
                }
               // customerCouponService.batchInsert(couponId, new HashSet<>(custIds));

                List<CustomerCoupon> list = new ArrayList<>();
                // 批量插入数据
                for (String custId : custIds) {
                    if (!StringUtil.isEmpty(custId)) {
                        String custCouponId=UUIDUtils.generateUuid22();
                        CustomerCoupon customerCoupon = new CustomerCoupon();
                        customerCoupon.setCustCouponId(custCouponId);
                        customerCoupon.setCustId(custId);
                        customerCoupon.setCouponId(couponId);
                        //'使用[1-已用 2-未用 3-过期]
                        customerCoupon.setIsUse((byte)2);

                        String planImg=""+
                                "{"+
                                "\"internal\": \"LQapp\","+
                                "\"data\": {"+
                                " \"type\": \"4\","+
                                " \"id\": \""+custCouponId+"\""+
                                "}"+
                                " }";
                        System.out.println(planImg);
                        customerCoupon.setCouponImg(getPlanImg(planImg));
                        customerCoupon.setAddTime(now);
                        count=customerCouponMapper.insert(customerCoupon);
                        if(1!=count){
                            throw new HuhuaminExceptionPlan("用户优惠卷添加失败！");
                        }
                    }
                }
                coupon.setSendCount(custIds.size());
            }else  if (coupon.getHaveType().intValue() == 2) {
                coupon.setSendType(null);
            }
            coupon.setCouponId(couponId);
            coupon.setAddTime(now);
            Coupon c=new Coupon();
            BeanUtils.copyProperties(coupon,c);
            c.setAddUserName(systemUserMapper.queryUserNameByUserId(userId));
            c.setAddUser(userId);
            count=couponMapper.insert(c);
            if(1!=count){
                throw new HuhuaminExceptionPlan("用户优惠卷添加失败！");
            }
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "增加优惠券";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException(msg + e.getMessage(), e);
            }
        }
    }

    public static String getPlanImg(String text){
        String couponImg="";
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        String t = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String outPath = String.valueOf(new Date().getTime()) + ".png";
        //1000 1500
        //isBackground 是否融入背景[1-有背景 2-没有背景]

        ImageAndQRcode.zxingCodeCreateImage(2,text, 412, 412, path + "bg.jpg", path + outPath, "169", "461");


        couponImg = OssLocalClientUtils.convertPathToOssObject(path + outPath);
        ImageAndQRcode.removeTempFile(path + outPath);


        return couponImg;
    }


    /**
     * 核销优惠劵列表
     * @param userId
     * @param reqSource
     * @return
     */
    public PageJsonResult<CustomerCoupon> writeOffCouponList(String userId, ReqTokenPage reqSource) {
        try {
            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqSource.getPageNum(), reqSource.getPageSize());
            String custId=systemUserMapper.queryCustIdByUserId(userId);
            List<CustomerCoupon> list =  PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(), "USER_TIME DESC ").doSelectPage(() ->
                    customerCouponMapper.writeOffCouponList(custId));
            PageInfo<CustomerCoupon> page = new PageInfo<>(list);
            PageJsonResult<CustomerCoupon> pageJsonResult = new PageJsonResult<>(page);
            return pageJsonResult;
        } catch (Exception e) {
            String msg = "核销优惠劵列表";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException(msg + e.getMessage(), e);
            }
        }
    }

    /**
     * 核销优惠劵
     * @param userId
     * @param custCouponId
     * @return
     */
    public JsonResult writeOffCoupon(String userId, String  custCouponId) {
        try {
            JsonResult jsonResult=new JsonResult();
            String custId=systemUserMapper.queryCustIdByUserId(userId);
            String shopId=systemUserMapper.queryShopIdByUserId(userId);

            CustomerCoupon customerCoupon= customerCouponMapper.couponDetail(custCouponId);
            if(null==customerCoupon){
                throw new HuhuaminExceptionPlan("该优惠卷不能线下核销！");
            }
            //类型[1-商品优惠 2-店铺优惠 3-全场通用 4-体验券]
            if(!customerCoupon.getCouponConent().contains(shopId)){
                throw new HuhuaminExceptionPlan("该优惠卷不是您商铺的，不能使用！");
            }

            int count= customerCouponMapper.writeOffCoupon(custId,custCouponId);
            if(1!=count){
                throw new HuhuaminExceptionPlan("核销优惠劵失败！");
            }
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "核销优惠劵";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException(msg + e.getMessage(), e);
            }
        }
    }
    /**
     * 优惠劵详情
     * @param userId
     * @param custCouponId
     * @return
     */
    public TypeJsonResult couponDetail(String userId,String  custCouponId) {
        try {
            TypeJsonResult jsonResult=new TypeJsonResult();
            CustomerCoupon customerCoupon= customerCouponMapper.couponDetail(custCouponId);
            if(null==customerCoupon){
                jsonResult.setStatusCode(false);
                jsonResult.setMessage("该优惠卷不能线下核销或已经使用过了！");
                return jsonResult;
                //throw new HuhuaminExceptionPlan("该优惠卷不能线下核销或已经使用过了！");
            }
            //类型[1-商品优惠 2-店铺优惠 3-全场通用 4-体验券]
            String couponConent=customerCoupon.getCouponConent();
            String shopId=systemUserMapper.queryShopIdByUserId(userId);
            if(!couponConent.contains(shopId)){
                //throw new HuhuaminExceptionPlan("该优惠卷不是您商铺的，不能使用！");
                jsonResult.setStatusCode(false);
                jsonResult.setMessage("该优惠卷不是您商铺的，不能使用！");
                return jsonResult;
            }
            Shop shop=new Shop();
            String shopLogo="";
            String shopName="";
            String couponConentArry []=couponConent.split(",");
            for(int i=0;i<couponConentArry.length;i++){
                shop=shopMapper.selectShortByPrimaryKey(shopId);
                shopLogo=customerCoupon.getShopLogo();
                if(StringUtils.isBlank(shopLogo)){
                    customerCoupon.setShopLogo(shop.getShopLogo());
                }else{
                    customerCoupon.setShopLogo(shopLogo+","+shop.getShopLogo());
                }
                shopName=customerCoupon.getShopName();
                if(StringUtils.isBlank(shopName)){
                    customerCoupon.setShopName(shop.getShopName());
                }else{
                    customerCoupon.setShopName(shopName+","+shop.getShopName());
                }
            }
            jsonResult.setType(customerCoupon);
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "优惠劵详情";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException(msg + e.getMessage(), e);
            }
        }
    }

}
