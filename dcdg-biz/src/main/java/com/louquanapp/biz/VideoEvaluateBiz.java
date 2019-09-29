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
import com.louquanapp.req.*;
import com.louquanapp.utils.BizUtils;
import com.louquanapp.utils.RelativeDateFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/10 15:30
 * @description:
 */
@Service
public class VideoEvaluateBiz {
    private final CustomerMapper customerMapper;
    private final AttentionMapper attentionMapper;
    private final VideoEvaluateMapper videoEvaluateMapper;
    private final SystemUserMapper systemUserMapper;
    private final ShopMapper shopMapper;

    public VideoEvaluateBiz(CustomerMapper customerMapper, AttentionMapper attentionMapper, VideoEvaluateMapper videoEvaluateMapper
                ,SystemUserMapper systemUserMapper,ShopMapper shopMapper) {
        this.customerMapper = customerMapper;
        this.attentionMapper = attentionMapper;
        this.videoEvaluateMapper = videoEvaluateMapper;
        this.systemUserMapper = systemUserMapper;
        this.shopMapper = shopMapper;
    }

    /**
     * 增加视频评论
     * @param reqVideoEvaluate
     * @param custId
     * @return
     */
    @Transactional
    public  TypeJsonResult addVideoEvaluate(ReqVideoEvaluate reqVideoEvaluate, String userId) {
        try {
            String custId= systemUserMapper.queryCustIdByUserId(userId);
            TypeJsonResult jsonResult = new TypeJsonResult(false);
            VideoEvaluate videoEvaluate=new VideoEvaluate();
            if(StringUtils.isNotBlank(reqVideoEvaluate.getParentId())){
                videoEvaluate.setParentId(reqVideoEvaluate.getParentId());
            }else{
                if(StringUtils.isBlank(reqVideoEvaluate.getVideoId())){
                    jsonResult.setMessage("视频Id不能为空！");
                    return jsonResult;
                }
                videoEvaluate.setVideoId(reqVideoEvaluate.getVideoId());
            }
            String evaluateId=UUIDUtils.genertateUuid32();
            videoEvaluate.setEvaluateId(evaluateId);
            videoEvaluate.setEvaluateCont(reqVideoEvaluate.getEvaluateCont());
            videoEvaluate.setAddTime(new Date());
            videoEvaluate.setCustId(custId);
            int count=videoEvaluateMapper.insert(videoEvaluate);
            if(count==1){
                jsonResult.setType(evaluateId);
                jsonResult.setStatusCode(true);
            }else{
                jsonResult.setMessage("增加视频评论失败！");
            }
            return jsonResult;
        } catch (Exception e) {
            String msg = "增加视频评论";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage(), e);
        }

    }
    /**
     * 查询视频评论信息
     *
     * @param reqSource
     * @param custId
     * @return
     */
    public PageJsonResult<VideoEvaluate> videoEvaluates(ReqQueryVideoEvaluate reqSource,String userId) {
        try {
            String custId= systemUserMapper.queryCustIdByUserId(userId);
            String shopId=systemUserMapper.queryShopIdByUserId(userId);
            Shop shop=shopMapper.selectShortByPrimaryKey(shopId);

            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqSource.getPageNum(), reqSource.getPageSize());
            Customer customer=null;
            List<VideoEvaluate> list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(), "ADD_TIME DESC ").doSelectPage(() -> videoEvaluateMapper
                    .videoEvaluates(reqSource.getType(),reqSource.getEvaluateId(),reqSource.getVideoId()));
            if(reqSource.getType()==1){
                transformationDate(list,custId,1,reqForPageInfo,shop);
            }else{
                transformationDate(list,custId,2,null,shop);
            }
            PageInfo<VideoEvaluate> page = new PageInfo<>(list);

            PageJsonResult<VideoEvaluate> pageJsonResult = new PageJsonResult<>(page);
            return pageJsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            String msg = "查询视频评论信息";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            throw new HuhuaminException(msg + e.getMessage(), e);

        }
    }


    public  void transformationDate( List<VideoEvaluate> list ,String custId,Integer type,ReqForPageInfo reqForPageInfo,Shop shop) {
        Customer customer=null;
        List<VideoEvaluate> listSecond  =new ArrayList<>();
        for(VideoEvaluate videoEvaluate:list){
            if(type==1){
                listSecond=PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(), "ADD_TIME DESC ").doSelectPage(() -> videoEvaluateMapper
                        .videoEvaluates((byte)2,videoEvaluate.getEvaluateId(),null));
                videoEvaluate.setVideoEvaluates(listSecond);
                videoEvaluate.setSecondCount(listSecond.size());
                transformationDate(listSecond,custId,2,null,shop);
            }
            videoEvaluate.setLikeCont(attentionMapper.countByVideoId(videoEvaluate.getEvaluateId(), 7));
            if(StringUtils.isNotBlank(custId)){
                if(attentionMapper.existAttentionByCustIdAndAttentionType(custId,videoEvaluate.getEvaluateId(),7)>0){
                    videoEvaluate.setFlay(1);
                }else{
                    videoEvaluate.setFlay(2);
                }
            }
            videoEvaluate.setAddTimeStr(transformationTime(videoEvaluate.getAddTime()));
            customer= customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(videoEvaluate.getCustId());
            if(null!=customer){
                if(custId.equals(customer.getCustId())){
                    videoEvaluate.setHeadImg(shop.getShopLogo());
                    videoEvaluate.setNickname(shop.getShopName());
                    videoEvaluate.setIsOwn((byte)2);
                }else {
                    videoEvaluate.setHeadImg(customer.getHeadImg());
                    videoEvaluate.setNickname(customer.getNickName());
                    videoEvaluate.setIsOwn((byte)1);
                }

            }else{
                videoEvaluate.setIsOwn((byte)1);
            }

        }
    }

    public static String transformationTime( Date oldTime ) {
        String result="";

        Long oldTimeLong= oldTime.getTime();
        Long newTimeLong=System.currentTimeMillis();

        Long time=newTimeLong-oldTimeLong;

        if(time<1000*60){
            System.out.println("刚刚发布");
        }else if(time<1000*60*60){
            Long count=time/(1000*60);
            result=(count+"").concat("分钟前");
        }else if(time<1000*60*60*24){
            Long count=time/(1000*60*60);
            result=(count+"").concat("小时前");
        }else {
            Long count=time/(1000*60*60*24);
            result=(count+"").concat("天前");
        }

        return  result;
    }

}

