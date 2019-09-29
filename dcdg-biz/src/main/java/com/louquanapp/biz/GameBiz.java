package com.louquanapp.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huhuamin.common.HuhuaminException;
import com.louquanapp.dao.mapper.*;
import com.louquanapp.dao.model.Banner;
import com.louquanapp.dao.model.Customer;
import com.louquanapp.dao.model.Game;
import com.louquanapp.dao.model.SystemParam;
import com.louquanapp.model.PageJsonResult;
import com.louquanapp.model.ReqForPageInfo;
import com.louquanapp.req.ReqGameCatId;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/17 15:23
 * @description:
 */
@Service
public class GameBiz {
    private final GameMapper gameMapper;
    private final CustomerPointMapper customerPointMapper;
    private final CustomerMapper customerMapper;
    private final BannerMapper bannerMapper;
    private final SystemParamMapper systemParamMapper;

    public GameBiz(GameMapper gameMapper, CustomerPointMapper customerPointMapper, CustomerMapper customerMapper, BannerMapper bannerMapper, SystemParamMapper systemParamMapper) {
        this.gameMapper = gameMapper;
        this.customerPointMapper = customerPointMapper;
        this.customerMapper = customerMapper;
        this.bannerMapper = bannerMapper;
        this.systemParamMapper = systemParamMapper;
    }

    /**
     * 查询游戏列表
     *
     * @param reqSource
     * @return
     */
    public PageJsonResult<Game> games(ReqGameCatId reqSource, String custId, boolean flag) {
        try {
            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqSource.getPageNum(), reqSource.getPageSize());
            if (flag) {
                Map<String, Object> map = new HashMap<>();
                Integer daySignPoint = customerPointMapper.daySignPoint(custId);
                if (daySignPoint > 0) {
                    map.put("sign", true);
                } else {
                    map.put("sign", false);
                }
                Integer weekSignCount = customerPointMapper.weekSignPoint(custId);
                Customer customer = customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(custId);
                map.put("weekSignCount", weekSignCount);
                map.put("headImg", customer.getHeadImg());
                map.put("nickName", customer.getNickName());
                Double deductionPoint = customerMapper.getDeductionPointByCustId(custId);
                map.put("deductionPoint", deductionPoint);
//            1-首页 2-商圈 3-游戏 4-商家申请 5-直播 6-红包
                List<Banner> banners = bannerMapper.selectAll5(3);
                //系统参数每天递增分数
                SystemParam signPointPer = systemParamMapper.selectByIndex(SystemParamBiz.SIGN_POINT_PER);
                if (null != signPointPer) {
                    map.put("perPoint", signPointPer.getParamValue());
                }

                SystemParam sign_point = systemParamMapper.selectByIndex(SystemParamBiz.SIGN_POINT);
                if (null != signPointPer) {
                    map.put("signPoint", sign_point.getParamValue());
                }
                PageJsonResult<Game> pageJsonResult = new PageJsonResult<Game>();
                map.put("banners", banners);
                pageJsonResult.setExtra(map);
                pageJsonResult.setStatusCode(true);
                return pageJsonResult;
            } else {
                List<Game> list = null;
                list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(), "IS_REC   ASC ,GAME_SEQUENCE DESC").doSelectPage(() -> gameMapper
                        .queryGameList(reqSource.getGameCat()));
                PageInfo<Game> page = new PageInfo<Game>(list);
                PageJsonResult<Game> pageJsonResult = new PageJsonResult<Game>(page);
                pageJsonResult.setStatusCode(true);
                return pageJsonResult;
            }
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            } else {
                throw new HuhuaminException("查询游戏列表" + e.getMessage());
            }
        }
    }

    public PageJsonResult<Game> myGames(ReqGameCatId reqSource, String custId) {
        try {
            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqSource.getPageNum(), reqSource.getPageSize());

            List<Game> list = null;
            list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(), "GAME_SEQUENCE ASC").doSelectPage(() -> gameMapper
                    .queryGameListByCustId(reqSource.getGameCat(), custId));
            PageInfo<Game> page = new PageInfo<>(list);
            PageJsonResult<Game> pageJsonResult = new PageJsonResult<>(page);
            pageJsonResult.setStatusCode(true);
            return pageJsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            } else {
                throw new HuhuaminException("查询游戏列表" + e.getMessage());
            }
        }
    }
}
