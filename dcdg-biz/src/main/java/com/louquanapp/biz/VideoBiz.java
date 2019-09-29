package com.louquanapp.biz;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.internal.OSSUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.dao.mapper.*;
import com.louquanapp.dao.model.*;
import com.louquanapp.model.PageJsonResult;
import com.louquanapp.model.ReqForPageInfo;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.*;
import com.louquanapp.utils.BizUtils;
import com.louquanapp.utils.OssFormatUtils;
import com.louquanapp.utils.OssLocalClientUtils;
import com.louquanapp.utils.QiNiuClient;
import com.qiniu.pili.PiliException;
import com.qiniu.pili.Stream;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/23 14:27
 * @Description: 直播/点播业务逻辑
 */
@Service
public class VideoBiz {
    private final VideoMapper videoMapper;
    private final CustomerMapper customerMapper;
    private final CustomerAccountMapper customerAccountMapper;
    private final AttentionMapper attentionMapper;
    private final ShopMapper shopMapper;
    private final VideoCatMapper videoCatMapper;
    private final PullBlackMapper pullBlackMapper;
    private final VideoEvaluateMapper videoEvaluateMapper;
    private final SystemUserMapper systemUserMapper;

    public VideoBiz(VideoMapper videoMapper, CustomerMapper customerMapper, CustomerAccountMapper customerAccountMapper
            , AttentionMapper attentionMapper, ShopMapper shopMapper, VideoCatMapper videoCatMapper, PullBlackMapper pullBlackMapper
            , VideoEvaluateMapper videoEvaluateMapper,SystemUserMapper systemUserMapper) {
        this.videoMapper = videoMapper;
        this.customerMapper = customerMapper;
        this.customerAccountMapper = customerAccountMapper;
        this.attentionMapper = attentionMapper;
        this.shopMapper = shopMapper;
        this.videoCatMapper = videoCatMapper;
        this.pullBlackMapper = pullBlackMapper;
        this.videoEvaluateMapper = videoEvaluateMapper;
        this.systemUserMapper = systemUserMapper;
    }

    public static void create(String keyA) throws PiliException {
        //创建流
        QiNiuClient.getHub().create(keyA);
    }

    public static String getPlayUrl(String keyA) {
        //        //RTMP直播地址
        String url = QiNiuClient.getCli().RTMPPlayURL("pili-live-rtmp.louquanapp.com", QiNiuClient.hubName, keyA);
        return url;

    }

    public static String getPushUrl(String keyA) {
        //        //RTMP直播地址
        String url = QiNiuClient.getCli().RTMPPublishURL("pili-publish.louquanapp.com", QiNiuClient.hubName, keyA, 7200);
        return url;

    }

    public static void disable(String keyA) throws PiliException {
        Stream streamA = QiNiuClient.getHub().get(String.valueOf(keyA));
        streamA.enable();
    }

    /**
     * 增加直播
     *
     * @param custId
     * @param reqSource
     * @return
     */
    @Transactional
    public synchronized JsonResult doVideo(String userId, ReqVideo reqSource) {
        try {
            JsonResult jsonResult = new JsonResult(false);

            String custId=systemUserMapper.queryCustIdByUserId(userId);

            Customer customer = customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(custId);
            if (customer.getCustType().intValue() != 7) {
                jsonResult.setMessage("只有商家才能创建直播间/创建视频");
                return jsonResult;
            }

            Integer max = videoMapper.selectMaxVideoNo();
            if (null == max) {
                max = 3100012;
            }
            max = max + 1;
            Video video = new Video();
            BeanUtils.copyProperties(reqSource, video);
            if (null != reqSource.getVideoType() && reqSource.getVideoType().intValue() == 1) {
                String key = String.valueOf(max);
                create(key);
                String pullUrl = getPlayUrl(key);
                String pushUrl = getPushUrl(key);
                video.setVideoPushUrl(pushUrl);
                video.setVideoUrl(pullUrl);
            }


            video.setAddTime(new Date());
            video.setAddUser(custId);



            video.setVideoNo(max);
            video.setVideoId(UUIDUtils.generateUuid22());
            video.setOnlineCount(0);

            video.setAddUserName(BizUtils.getCustName(customer));


            video.setCustId(custId);
            if (null != reqSource.getVideoType() && reqSource.getVideoType().intValue() == 2) {
                video.setVideoStatus((byte) 2);
                if (StringUtils.isEmpty(reqSource.getVideoUrl())) {
                    jsonResult.setMessage("视频地址不能为空");
                    return jsonResult;
                }
                video.setVideoType((byte) 2);
            } else {
                video.setVideoStatus((byte) 4);
                video.setVideoType((byte) 1);
            }
            video.setIsRec((byte) 2);
            videoMapper.insert(video);
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "创建直播间";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 我的直播列表
     *
     * @param custId
     * @return
     */
    @Transactional
    public PageJsonResult<Video> myVideoList(String userId, ReqTokenPage reqSource) {
        try {

            String custId=systemUserMapper.queryCustIdByUserId(userId);
            PageJsonResult<Video> pageJsonResult = new PageJsonResult<>();
            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqSource.getPageNum(), reqSource.getPageSize());

            List<Video> list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(),"ADD_TIME DESC ,VIDEO_STATUS").doSelectPage(() -> videoMapper.videoByCustId(custId));

            List<String> videoIds=new ArrayList<String>();
            list.forEach(video-> {
                if(video.getVideoType()==1){
                    videoIds.add(video.getVideoId());

                    //直播状态[1-未开始 2-直播中 3-禁播 4-审核中 5-审核不通过 6-直播结束 7-过期]
                    if(System.currentTimeMillis()>video.getVideoEndTime().getTime()&&(
                            1==video.getVideoStatus()
                                    ||4==video.getVideoStatus()
                                    ||5==video.getVideoStatus()
                    )){
                        video.setVideoStatus((byte)7);
                    }

                    if(System.currentTimeMillis()>video.getVideoEndTime().getTime()||System.currentTimeMillis()<video.getVideoStartTime().getTime()){
                        video.setIsAllowVideo(2);
                    }else {
                        video.setIsAllowVideo(1);
                    }
                }

            });
            if(videoIds.size()>0){
                //直播状态[1-未开始 2-直播中 3-禁播 4-审核中 5-审核不通过 6-直播结束 7-过期]
                videoMapper.updateStatusByIds(custId,videoIds);
            }


            PageInfo<Video> pageInfo = new PageInfo<>(list);
            pageJsonResult.setPageInfo(pageInfo);
            pageJsonResult.setStatusCode(true);
            return pageJsonResult;
        } catch (Exception e) {
            String msg = "查询我的直播间列表";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }

    }

    /**
     * 直播间列表
     *
     * @param reqSource
     * @return
     */
    public PageJsonResult<Video> videos(ReqVideoCatId reqSource, String custId) {
        try {
            List<String> foucsIds = null;
            PageJsonResult<Video> pageJsonResult = new PageJsonResult<>();
            if (StringUtils.isNotEmpty(custId) && "x".equals(reqSource.getCatId())) {
                foucsIds = attentionMapper.selectSourceIdByCustIdAndAttentionType(custId, 4);
                if (CollectionUtils.isEmpty(foucsIds)) {
                    pageJsonResult.setStatusCode(true);
                    pageJsonResult.setPageInfo(new PageInfo<>());
                    return pageJsonResult;
                }
            }
            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqSource.getPageNum(), reqSource.getPageSize());
            List<Video> list = null;

            if (!"x".equals(reqSource.getCatId())) {
                List<String> videoList= pullBlackMapper.selectBackByCustId(custId);
                list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(), "rand() ASC").doSelectPage(() -> videoMapper.videoValid(reqSource.getCatId(), reqSource.getKeywords(),videoList));
            } else {
                List<String> finalFoucsIds = foucsIds;
                List<String> videoLists= pullBlackMapper.selectBackByCustIds(finalFoucsIds);
                list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(), "rand() ASC ").doSelectPage(() -> videoMapper.videoValidCustIds(reqSource.getKeywords(), finalFoucsIds,videoLists));
            }
            Shop shop=null;
            for (Video v :
                    list) {
                shop=shopMapper.queryShopByCustId(v.getCustId());
                if(shop!=null){
                    v.setShopName(shop.getShopName());
                    v.setShopLogo(shop.getShopLogo());
                }
                Customer customer = formatCustomerInfo(v, custId, customerMapper, customerAccountMapper, attentionMapper);
            }
            PageInfo<Video> pageInfo = new PageInfo<>(list);
            pageJsonResult.setPageInfo(pageInfo);
            pageJsonResult.setStatusCode(true);
            return pageJsonResult;
        } catch (Exception e) {
            String msg = "查询直播间列表";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * @param video
     * @param custId
     * @param customerMapper
     * @param customerAccountMapper
     * @param attentionMapper
     * @return
     */
    public static Customer formatCustomerInfo(Video video, String custId, CustomerMapper customerMapper, CustomerAccountMapper customerAccountMapper, AttentionMapper attentionMapper) {
        Customer customer = customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(video.getCustId());
        video.setHeadImg(customer.getHeadImg());
        video.setNickName(customer.getNickName());
        Integer favCount = customerAccountMapper.selectFocusCountByPrimaryKey(video.getCustId());
        if (StringUtils.isNotBlank(custId)) {
            String attentionId = attentionMapper.selectAttentionIdAttentionByCustIdAndAttentionType(custId, video.getCustId(), 4);
            if (!StringUtils.isEmpty(attentionId)) {
                video.setAttentionId(attentionId);
                video.setFocus(true);
            }

        }
        // 点赞量
       int  count = attentionMapper.countByVideoId(video.getVideoId(), video.getVideoType()==1?2:1);
        video.setLikeCount(count);
        video.setFavCount(favCount);
        return customer;
    }

    /**
     * 店铺信息及商家信息
     *
     * @param shop
     * @param custId
     * @param customerMapper
     * @param customerAccountMapper
     * @param attentionMapper
     * @return
     */
    public static Customer formatCustomerInfo(Shop shop, String custId, CustomerMapper customerMapper, CustomerAccountMapper customerAccountMapper, AttentionMapper attentionMapper) {
        Customer customer = customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(shop.getCustId());
        shop.setHeadImg(customer.getHeadImg());
        shop.setNickName(customer.getNickName());
        if (StringUtils.isNotBlank(custId)) {
            String attentionId = attentionMapper.selectAttentionIdAttentionByCustIdAndAttentionType(custId, shop.getCustId(), 4);
            if (!StringUtils.isEmpty(attentionId)) {
                shop.setAttentionId(attentionId);
                shop.setFocus(true);
            }
        }
        Integer favCount = customerAccountMapper.selectFocusCountByPrimaryKey(shop.getCustId());
        shop.setFavCount(favCount);
        return customer;
    }


    /**
     * 商家信息
     *
     * @param id
     * @return
     */
    public TypeJsonResult<Shop> shopByViedoId(String id, String custId) {
        try {
            TypeJsonResult<Shop> typeJsonResult = new TypeJsonResult<>();
            String shopId = customerMapper.selectShopIdBuyVideoId(id);
            String custIdVideo = videoMapper.selectCustIdByVideoId(id);

            Shop shop = shopMapper.selectShortByPrimaryKey(shopId);

            shop.setCustId(custIdVideo);
            String catPath = shop.getCatPath();
            formatCustomerInfo(shop, custId, customerMapper, customerAccountMapper, attentionMapper);
            typeJsonResult.setType(shop);
            typeJsonResult.setStatusCode(true);
            return typeJsonResult;
        } catch (Exception e) {
            String msg = "查看直播";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage(), e);
        }
    }


    /**
     * 视频详情
     *
     * @param id
     * @return
     */
    public TypeJsonResult<Video> videoById(String id, String userId) {
        try {
            TypeJsonResult<Video> typeJsonResult = new TypeJsonResult<>();

            String custId=systemUserMapper.queryCustIdByUserId(userId);

            Video video = videoMapper.selectByPrimaryKey(id);
            if(video.getVideoType()==1){
                if(System.currentTimeMillis()>video.getVideoEndTime().getTime()||System.currentTimeMillis()<video.getVideoStartTime().getTime()){
                    video.setIsAllowVideo(2);
                }else {
                    video.setIsAllowVideo(1);
                }
            }
            List<VideoEvaluate> list=videoEvaluateMapper.videoEvaluates((byte)1, null, id);
            int videoEvaluateCount=list.size();
            for(VideoEvaluate videoEvaluate:list){
                videoEvaluateCount+=videoEvaluateMapper.videoEvaluateCount((byte)2, videoEvaluate.getEvaluateId(), null);
            }
            video.setVideoEvaluateCount(videoEvaluateCount);

            String shopId = customerMapper.selectShopIdBuyVideoId(id);
            Shop shop = shopMapper.selectByPrimaryKey(shopId);
            String catId = shop.getCatId();
            if (catId.equals(CategoryBiz.CAN_YIN)) {
                video.setType((byte) 1);
            } else {
                video.setType((byte) 2);
            }

            String catPath = shop.getCatPath();

            video.setShopName(shop.getShopName());
            video.setShopLogo(shop.getShopLogo());
            video.setShopAddress(shop.getShopAddress());
            video.setGrps(shop.getGrps());
            formatCustomerInfo(video, custId, customerMapper, customerAccountMapper, attentionMapper);
            int m = 50;
            int n = 100;
            int temp = m + (int) (Math.random() * (n + 1 - m)); //生成从m到n的随机整数[m,n]
            if (video.getVideoStatus().intValue() == 1 || video.getVideoStatus().intValue() == 2) {
//                //直播中的视频伪造数据
//                if (video.getOnlineCount() < 1) {
//                    video.setOnlineCount(temp + video.getOnlineCount());
//                } else {
                    video.setOnlineCount(1 + video.getOnlineCount());
//                }

            }
            video.setOnlineCount(video.getOnlineCount() + 1);
            //videoMapper.updateCountByPrimaryKey(video.getOnlineCount() + 1, video.getVideoId());

            video.setNewCust(attentionMapper.countByVideoId(id, 4));
            video.setNewFocus(attentionMapper.countByVideoId(id, 2));
            if (video.getVideoStatus().intValue() == 6) {
                video.setTimes((video.getRealEndTime().getTime() - video.getRealStartTime().getTime()) / (1000 * 60));
            }

            if (video.getVideoStatus().intValue() == 3&&video.getRealEndTime()!=null) {
                video.setTimes((video.getRealEndTime().getTime() - video.getRealStartTime().getTime()) / (1000 * 60));
            }
            if (StringUtils.isNotBlank(custId)) {
                int count = attentionMapper.existAttentionByCustIdAndAttentionType(custId, id, 4);
                if (count > 0) {
                    video.setFocus(true);
                }
                String attentionId="";
                if(video.getVideoType()==1){ // 直播
                     attentionId = attentionMapper.selectAttentionIdAttentionByCustIdAndAttentionType(custId, id, 2);
                }else{
                    attentionId = attentionMapper.selectAttentionIdAttentionByCustIdAndAttentionType(custId, id, 1);
                }
                if (StringUtils.isNotBlank(attentionId)) {
                    video.setFav(true);
                }
            }
          //  VideoCat cat=videoCatMapper.selectByPrimaryKey(video.getCatId());
            video.setCatIcons(videoCatMapper.selectByPrimaryKey(video.getCatId()).getCatIcons());

            typeJsonResult.setType(video);
            typeJsonResult.setStatusCode(true);
            return typeJsonResult;
        } catch (Exception e) {
            String msg = "视频详情";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage(), e);
        }
    }


    /**
     * 增加直播
     *
     * @param custId
     * @param videoId
     * @return
     */
    @Transactional
    public synchronized TypeJsonResult<Video> startVideo(String userId, String videoId) {
        try {
            TypeJsonResult<Video> typeJsonResult = new TypeJsonResult<Video>();
            String custId=systemUserMapper.queryCustIdByUserId(userId);

            Customer customer = customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(custId);
            if (customer.getCustType().intValue() != 7) {
                typeJsonResult.setMessage("只有商家才能创建直播间");
                return typeJsonResult;
            }
            Video video = videoMapper.selectByPrimaryKey(videoId);
            video.setShopLogo(shopMapper.queryShopByCustId(custId).getShopLogo());


            if (check(custId, typeJsonResult, video)) return typeJsonResult;

            String url = getPushUrl(String.valueOf(video.getVideoNo()));
            video.setVideoPushUrl(url);
            videoMapper.updateByPrimaryKey(video);
            typeJsonResult.setType(video);
            typeJsonResult.setStatusCode(true);
            return typeJsonResult;
        } catch (Exception e) {
            String msg = "开播直播间";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    public TypeJsonResult<Video> planVideo(String userId, String videoId) {
        try {
            TypeJsonResult<Video> typeJsonResult = new TypeJsonResult<Video>();
            String custId=systemUserMapper.queryCustIdByUserId(userId);
            Customer customer = customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(custId);
            if (customer.getCustType().intValue() != 7) {
                typeJsonResult.setMessage("只有商家才能创建直播间");
                return typeJsonResult;
            }
            Video video = videoMapper.selectByPrimaryKey(videoId);
            video.setShopLogo(shopMapper.queryShopByCustId(custId).getShopLogo());


            if (check(custId, typeJsonResult, video)) return typeJsonResult;

            String url = getPushUrl(String.valueOf(video.getVideoNo()));
            video.setVideoPushUrl(url);
            video.setVideoStatus((byte) 2);
            video.setRealStartTime(new Date());
            videoMapper.updateByPrimaryKey(video);
            typeJsonResult.setType(video);
            typeJsonResult.setStatusCode(true);
            return typeJsonResult;
        } catch (Exception e) {
            String msg = "开播直播间";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    private boolean check(String custId, TypeJsonResult<Video> typeJsonResult, Video video) {
        if (video == null) {
            typeJsonResult.setMessage("你访问的直播间不存在");
            return true;
        }
        if (video.getVideoStatus().intValue() == 3) {
            typeJsonResult.setMessage("已禁播");
            return true;
        }
        if (video.getVideoStatus().intValue() == 4) {
            typeJsonResult.setMessage("直播在审核中");
            return true;
        }
        if (video.getVideoStatus().intValue() == 5) {
            typeJsonResult.setMessage("直播审核中不通过");
            return true;
        }
        if (video.getVideoStatus().intValue() == 6) {
            typeJsonResult.setMessage("直播已结束");
            return true;
        }
        if (!video.getCustId().equals(custId)) {
            typeJsonResult.setMessage("不是你的直播间");
            return true;
        }
        return false;
    }


    public TypeJsonResult<Video> stopVideo(String userId, String videoId) {
        try {
            String custId=systemUserMapper.queryCustIdByUserId(userId);
            TypeJsonResult<Video> jsonResult = new TypeJsonResult();
            Video video = videoMapper.selectByPrimaryKey(videoId);
            if (!video.getCustId().equals(custId)) {
                jsonResult.setMessage("不是你的直播间");
                return jsonResult;
            }
            video.setVideoStatus((byte) 6);
            video.setRealEndTime(new Date());
            Customer customer = customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(custId);
            video.setHeadImg(customer.getHeadImg());
            video.setNewCust(attentionMapper.countByVideoId(videoId, 4));
            video.setNewFocus(attentionMapper.countByVideoId(videoId, 2));
            video.setTimes((video.getRealEndTime().getTime() - video.getRealStartTime().getTime()) / (1000 * 60));
            videoMapper.updateByPrimaryKey(video);
            disable(String.valueOf(video.getVideoNo()));
            jsonResult.setType(video);
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "结束直播";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }


    }

    /**
     * 查询我的短视频作品列表
     * @param reqSource
     * @param custId
     * @return
     */
    public PageJsonResult<Video> videoWorks(ReqTokenPage reqSource, String userId) {
        try {
            List<String> foucsIds = null;
            PageJsonResult<Video> pageJsonResult = new PageJsonResult<>();
            String custId=systemUserMapper.queryCustIdByUserId(userId);

            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqSource.getPageNum(), reqSource.getPageSize());
            List<Video> list = list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(), "ADD_TIME DESC ").doSelectPage(() -> videoMapper.videoWorks(custId));
            /*for(Video video:list){
                video.setFlags(true);
            }*/
            PageInfo<Video> pageInfo = new PageInfo<>(list);
            pageJsonResult.setPageInfo(pageInfo);
            pageJsonResult.setStatusCode(true);
            return pageJsonResult;
        } catch (Exception e) {
            String msg = "查询我的短视频作品列表";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 添加或取消视频拉黑
     * @param reqPullVideo
     * @param custId
     * @return
     */
    @Transactional
    public  JsonResult doPullBlack(ReqPullVideo reqPullVideo,String custId) {
        try {
            JsonResult jsonResult = new TypeJsonResult();
            jsonResult.setStatusCode(false);
            List<String> videoIds=new ArrayList();
            //1-添加视频ID集合 2-删除视频ID集合 3-添加视频用户ID 4-删除视频用户ID

            if(1==reqPullVideo.getFlay()||2==reqPullVideo.getFlay()){
                String videoIdsMy=reqPullVideo.getVideoIds();
                if(StringUtils.isNotBlank(videoIdsMy)){
                    videoIds=Arrays.asList(videoIdsMy.split(","));
                }else {
                    throw new HuhuaminExceptionPlan("视频id集合不能为空！");
                }

            }else  if(3==reqPullVideo.getFlay()||4==reqPullVideo.getFlay()){
                String custIds=reqPullVideo.getCustIds();
                if (StringUtils.isNotBlank(custIds)){
                    videoIds=videoMapper.queryVideoIdsByCustId(Arrays.asList(custIds.split(",")));
                }else {
                    throw new HuhuaminExceptionPlan("用户id集合不能为空！");
                }

            }

            if(1==reqPullVideo.getFlay()||3==reqPullVideo.getFlay()){
                List<PullBlack> pullBlacks=new ArrayList<>();


                for(String videoId:videoIds){
                    PullBlack pullBlack=new PullBlack();
                    pullBlack.setAddTime(new Date());
                    pullBlack.setBackId(UUIDUtils.generateUuid22());
                    pullBlack.setCustId(custId);
                    pullBlack.setVideoId(videoId);
                    pullBlacks.add(pullBlack);
                }

                if(pullBlacks.size()==pullBlackMapper.insertByBatch(pullBlacks)){
                    jsonResult.setStatusCode(true);
                    return jsonResult;
                }else{
                    throw new HuhuaminExceptionPlan("视频拉黑失败！");
                }
            }else if(2==reqPullVideo.getFlay()||4==reqPullVideo.getFlay()){
                if(videoIds.size()==pullBlackMapper.deleteByBatch(custId, videoIds)){
                    jsonResult.setStatusCode(true);
                    return jsonResult;
                }else{
                    throw new HuhuaminExceptionPlan("取消视频拉黑失败！");
                }
            }
            jsonResult.setMessage("添加或取消视频拉黑失败！");
            return jsonResult;
        } catch (Exception e) {
            String msg = "添加或取消视频拉黑";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 查询用户拉黑视频列表
     * @param reqTokenPage
     * @param custId
     * @return
     */
    public PageJsonResult<Video> queryPullVideos(ReqTokenPage reqTokenPage,String custId) {
        try {
            ReqForPageInfo reqForPageInfo=new  ReqForPageInfo (reqTokenPage.getPageNum(),reqTokenPage.getPageSize());

            List<Video> list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(),"ADD_TIME DESC ").doSelectPage(() -> videoMapper
                        .queryPullBackByCustId(custId));
            PageInfo<Video> page = new PageInfo<Video>(list);
            PageJsonResult<Video> pageJsonResult = new PageJsonResult<Video>(page);
            return  pageJsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            } else {
                throw new HuhuaminException("查询用户拉黑视频列表" + e.getMessage());
            }
        }
    }

    /**
     * 删除视频
     * @param userId
     * @return
     */
    @Transactional
    public JsonResult delVideo(String userId,String videoIds) {
        try {
            JsonResult jsonResult=new JsonResult(false);
            String custId=systemUserMapper.queryCustIdByUserId(userId);
            List<String> videoIdList=Arrays.asList(videoIds.split(","));

            //oss 删除
            List<String> videoUrlList = videoMapper.queryVideoUrlsByVideoIds(videoIdList);

            for(String videoId:videoUrlList){
                OssLocalClientUtils.deleteFile("louquan",videoId);
            }
            int count=videoMapper.delVideo(custId,videoIdList);
            if(count==videoIdList.size()){
                jsonResult.setStatusCode(true);

            }else {
                throw new HuhuaminExceptionPlan("删除视频失败！");
            }
            return  jsonResult;
        } catch (Exception e) {
            String msg = "删除视频";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

}
