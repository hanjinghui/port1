package com.louquanapp.biz;

import com.huhuamin.common.HuhuaminException;
import com.louquanapp.dao.mapper.BannerMapper;
import com.louquanapp.dao.mapper.CustomerPointMapper;
import com.louquanapp.dao.mapper.SystemParamMapper;
import com.louquanapp.dao.model.Banner;
import com.louquanapp.dao.model.SystemParam;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.utils.BizUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * @Auther: Huhuamin
 * @Date: 2019/4/1 20:00
 * @Description: banner 处理
 */
@Service
public class BannerBiz {

    private final BannerMapper bannerMapper;
    private final CustomerPointMapper customerPointMapper;
    private final SystemParamMapper systemParamMapper;

    public BannerBiz(BannerMapper bannerMapper, CustomerPointMapper customerPointMapper, SystemParamMapper systemParamMapper) {
        this.bannerMapper = bannerMapper;
        this.customerPointMapper = customerPointMapper;
        this.systemParamMapper = systemParamMapper;
    }

    /**
     * 获取首页banner
     *
     * @return
     */
    public TypeJsonResult<List<Banner>> banners(Integer bannerPage, String custId) {
        try {
            TypeJsonResult<List<Banner>> banners = new TypeJsonResult<>();
            banners.setStatusCode(false);
            List<Banner> bannerList = bannerMapper.selectAll5(bannerPage);
            if (bannerPage != null && bannerPage.intValue() == 6) {
                //
                Double sum = customerPointMapper.sumInvite(custId);
                sum = sum == null ? 0.00d : sum;
                if (!CollectionUtils.isEmpty(bannerList)) {
                    bannerList.get(0).setBannerContent(BizUtils.saveTwoPoint(sum));
                }
            }
            banners.setStatusCode(true);
            banners.setType(bannerList);
            return banners;
        } catch (Exception e) {
            throw new HuhuaminException("查询banner列表系统异常", e);
        }
    }

    /**
     * 首页注册好友送余额或积分
     * @param bannerPage
     * @param custId
     * @return
     */
    public TypeJsonResult<Banner> pointOrCast(Integer bannerPage, String custId) {
        try {
            TypeJsonResult<Banner> jsonResult = new TypeJsonResult<>();
            jsonResult.setStatusCode(false);
            Banner banner = bannerMapper.queryPointOrCastBanner();

                //
                SystemParam systemParamPoint = systemParamMapper.selectByIndex( SystemParamBiz.POINT_NUM_REGISTER);
                Byte type=1;//类型【1-积分 2-余额】
                if (null != systemParamPoint && !systemParamPoint.getParamValue().trim().equals("0")) {
                    type=1;
                }else {
                    type=2;
                }
                Double sum = customerPointMapper.sumInviteForregister(custId,type);
                sum = sum == null ? 0.00d : sum;
                if (null!=banner) {
                    banner.setBannerContent(BizUtils.saveTwoPoint(sum));
                }

            jsonResult.setStatusCode(true);
            jsonResult.setType(banner);
            return jsonResult;
        } catch (Exception e) {
            throw new HuhuaminException("首页注册好友送余额或积分异常", e);
        }
    }


    /**
     * 获取单个banner信息
     *
     * @param bannerId
     * @return
     */
    public TypeJsonResult<Banner> getBannerById(String bannerId) {
        try {
            TypeJsonResult<Banner> banners = new TypeJsonResult<>();
            banners.setStatusCode(false);
            Banner banner = bannerMapper.selectByPrimaryKey(bannerId);
            if (null == banner) {
                banners.setStatusCode(false);
                banners.setMessage("imageId不存在请核实");
                return banners;
            }
            int count = 0;
            count = bannerMapper.updateClickCountByPrimaryKey(bannerId);
            if (count == 0) {
                banners.setStatusCode(false);
                banners.setMessage("更新banner点击量失败");
                return banners;
            }
            banners.setStatusCode(true);
            banners.setType(banner);
            return banners;
        } catch (Exception e) {
            throw new HuhuaminException("查询单个banner系统异常", e);
        }

    }
}
