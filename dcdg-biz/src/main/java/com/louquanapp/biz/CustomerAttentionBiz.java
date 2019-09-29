package com.louquanapp.biz;


import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.dao.mapper.AttentionMapper;
import com.louquanapp.dao.mapper.CustomerAccountMapper;
import com.louquanapp.dao.mapper.GameMapper;
import com.louquanapp.dao.mapper.VideoMapper;
import com.louquanapp.dao.model.Account;
import com.louquanapp.dao.model.Attention;
import com.louquanapp.dao.model.CustomerAccount;
import com.louquanapp.dao.model.Game;
import com.louquanapp.model.TypeJsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 * @Auther: Huhuamin
 * @Date: 2019/4/14 23:19
 * @Description: 车辆收藏
 */
@Service
public class CustomerAttentionBiz {
    private final AttentionMapper attentionMapper;
    private final CustomerAccountMapper customerAccountMapper;
    private final VideoMapper videoMapper;
    private final GameMapper gameMapper;


    public CustomerAttentionBiz(AttentionMapper attentionMapper, CustomerAccountMapper customerAccountMapper, VideoMapper videoMapper, GameMapper gameMapper) {
        this.attentionMapper = attentionMapper;
        this.customerAccountMapper = customerAccountMapper;
        this.videoMapper = videoMapper;
        this.gameMapper = gameMapper;
    }


    /**
     * 将车辆假如到收藏
     *
     * @param sourceId
     * @param custId
     * @param attentionType 关注类型[1-点赞视频 2-点赞直播 3-商品 4-关注对象会员 5-进入直播间 6-进入有效]   或点赞类型[1-点赞视频 2-点赞直播]
     * @param attentionId   取消收藏时候使用
     * @return
     */
    @Transactional
    public synchronized TypeJsonResult<String> addAttentionByType(String sourceId, String custId, Integer attentionType, String attentionId) {

        try {
            TypeJsonResult<String> typeJsonResult = new TypeJsonResult();
            if (StringUtils.isEmpty(sourceId)) {
                typeJsonResult.setMessage("视频不能为空");
                return typeJsonResult;
            }
            String custIdVideo = videoMapper.selectCustIdByVideoId(sourceId);
            int count = 0;
            if (attentionType == 4) {
                count = attentionMapper.existAttentionByCustIdAndAttentionType(custId, custIdVideo, attentionType);
                if(count>0&&StringUtils.isEmpty(sourceId)){//关注
                    typeJsonResult.setMessage("不要重复关注");
                    return typeJsonResult;
                }
            } else {
                count = attentionMapper.existAttentionByCustIdAndAttentionType(custId, sourceId, attentionType);
            }

            if (count == 0) {
                attentionId = UUIDUtils.generateUuid22();
                Attention carAttention = new Attention();
                carAttention.setAddTime(new Date());
                carAttention.setAttentionId(attentionId);
                carAttention.setAttentionType(attentionType.byteValue());
                carAttention.setCustId(custId);
                if (attentionType == 4) {
                    carAttention.setSourceId(custIdVideo);
                } else {
                    carAttention.setSourceId(sourceId);
                }

                int result = attentionMapper.insert(carAttention);
                if (result == 0) {
                    // 短视频，直播 添加点赞
                    if(attentionType == 1||attentionType==2) { //-点赞视频 2-点赞直播
                        throw new HuhuaminException("点赞失败");
                    } else {
                        throw new HuhuaminException("关注主播失败");
                    }

                }
                customerAccountMapper.updatePlusTotalFocusCountByCustId(custIdVideo);
            } else {
                if (StringUtils.isNotBlank(attentionId)) {
                    int result = attentionMapper.deleteByPrimaryKey(attentionId);
                    customerAccountMapper.updateMinusTotalFocusCountByCustId(custIdVideo);
                    if (result == 0) {
                        throw new HuhuaminException("取消关注主播失败");
                    }
                } else {
                    if (attentionType == 5||attentionType==6) {//重复进入可以，不更新
                        typeJsonResult.setStatusCode(true);
                        return typeJsonResult;
                    }
                    if(attentionType == 1||attentionType==2){ //-点赞视频 2-点赞直播
                        if(count==0){
                            Attention carAttention = new Attention();
                            carAttention.setAttentionId(UUIDUtils.generateUuid22());
                            carAttention.setCustId(custId);
                            carAttention.setSourceId(sourceId);
                            carAttention.setAttentionType(attentionType.byteValue());
                            carAttention.setAddTime(new Date());
                            if(1==attentionMapper.insert(carAttention)){
                                typeJsonResult.setStatusCode(true);
                                return typeJsonResult;
                            }else{
                                throw new HuhuaminException("点赞失败");
                            }
                        }else{
                            // 重复点赞
                            typeJsonResult.setStatusCode(true);
                            return typeJsonResult;
                        }

                    }

                    typeJsonResult.setMessage("已经，不要重复重收藏");
                    return typeJsonResult;
                }

            }
            if (attentionType == 6) {
                Game game = gameMapper.selectByPrimaryKey(sourceId);
                if (null != game) {
                    int num = game.getGamePeopleNum() == null ? 0 : game.getGamePeopleNum();
                    game.setGamePeopleNum(num + 1);
                    gameMapper.updateByPrimaryKey(game);
                }
            }
            typeJsonResult.setType(attentionId);
            typeJsonResult.setStatusCode(true);
            return typeJsonResult;
        } catch (Exception e) {
            String msg = "关注";
            if (StringUtils.isNotBlank(attentionId)) {
                msg = "取消关注";
            }
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage(), e);
        }
    }


    /**
     * 视频评论点赞
     * @param sourceId
     * @param custId
     * @param type[1-增加点赞 2-取消点赞]
     * @return
     */
    @Transactional
    public  TypeJsonResult<String> addVideoAttentionByType(String sourceId, String custId,Integer type) {

        try {
            TypeJsonResult<String> typeJsonResult = new TypeJsonResult();
            String attentionId="" ;
            int count = 0;
            if (type==1) {
                count = attentionMapper.existAttentionByCustIdAndAttentionType(custId, sourceId, 7);
                if(count>0){//视频评论点赞
                    typeJsonResult.setMessage("不要重复点赞");
                    return typeJsonResult;
                }

                attentionId = UUIDUtils.generateUuid22();
                Attention carAttention = new Attention();
                carAttention.setAddTime(new Date());
                carAttention.setAttentionId(attentionId);
                carAttention.setAttentionType((byte)7);
                carAttention.setCustId(custId);
                carAttention.setSourceId(sourceId);

                int result = attentionMapper.insert(carAttention);
                if (result == 0) {
                    throw new HuhuaminException("点赞失败");
                }

            }else {
                 attentionId=attentionMapper.selectAttentionIdAttentionByCustIdAndAttentionType(custId,sourceId,7);
                if(StringUtils.isBlank(attentionId)){
                    throw new HuhuaminException("点赞已经取消了，无需再次取消");
                }
                 count=attentionMapper.deleteByPrimaryKey(attentionId);
                if (count == 0) {
                    throw new HuhuaminException("取消点赞失败");
                }

            }
            typeJsonResult.setType(attentionId);
            typeJsonResult.setStatusCode(true);
            return typeJsonResult;
        } catch (Exception e) {
            String msg = "视频评论点赞";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage(), e);
        }
    }

    public JsonResult delAttentionByType(String sourceId, String custId, int attentionType) {

        try {
            JsonResult jsonResult = new JsonResult(false);
            String attentionId = attentionMapper.selectAttentionIdAttentionByCustIdAndAttentionType(custId, sourceId, attentionType);
            if (StringUtils.isNotBlank(attentionId)) {
                attentionMapper.deleteByPrimaryKey(attentionId);
                if (attentionType == 6) {
                    Game game = gameMapper.selectByPrimaryKey(sourceId);
                    if (null != game) {
                        int num = game.getGamePeopleNum() == null ? 0 : game.getGamePeopleNum();
                        if (num > 0) {
                            game.setGamePeopleNum(num - 1);
                            gameMapper.updateByPrimaryKey(game);
                        }

                    }
                }
            }

            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }


    }
}
