package com.louquanapp.biz;

import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.louquanapp.dao.mapper.*;
import com.louquanapp.dao.model.Cat;
import com.louquanapp.dao.model.Customer;
import com.louquanapp.dao.model.Shop;
import com.louquanapp.dao.model.VideoCat;
import com.louquanapp.model.TypeJsonResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/11 10:26
 * @description:
 */
@Service
public class CatBiz {

    private final CatMapper catMapper;

    private final ShopMapper shopMapper;

    private final CustomerMapper customerMapper;
    private final VideoCatMapper videoCatMapper;
    private final SystemUserMapper systemUserMapper;

    public CatBiz(CatMapper catMapper, ShopMapper shopMapper, CustomerMapper customerMapper, VideoCatMapper videoCatMapper
        ,SystemUserMapper systemUserMapper) {
        this.catMapper = catMapper;
        this.shopMapper = shopMapper;
        this.customerMapper = customerMapper;
        this.videoCatMapper = videoCatMapper;
        this.systemUserMapper = systemUserMapper;
    }

    /**
     * 根据CatFlag查询分类
     *
     * @return
     */
    public TypeJsonResult<List<VideoCat>> videoCats(String userId) {
        try {
            String custId=systemUserMapper.queryCustIdByUserId(userId);
            TypeJsonResult<List<VideoCat>> basicCats = new TypeJsonResult<>();
            basicCats.setStatusCode(false);
            List<VideoCat> catList=new ArrayList<>();
            if(custId==null){
                catList = videoCatMapper.queyVideoCatByCatType(null);
            }else {
                Customer customer = customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(custId);
                String shopId = customer.getDataPerm();
                if (shopId == null) {
                    basicCats.setMessage("你不是商家请注册或关联商家信息！");
                    return basicCats;
                }
                Shop shop = shopMapper.selectByPrimaryKey(shopId);
                String catId = shop.getCatId();

                Byte catType = 1;
                if (catId.equals(CategoryBiz.CAN_YIN)) {
                    catType = (byte) 1;
                } else {
                    catType = (byte) 2;
                }

                catList = videoCatMapper.queyVideoCatByCatType(catType);
            }
            basicCats.setStatusCode(true);
            basicCats.setType(catList);
            return basicCats;
        } catch (Exception e) {
            String msg = "直播分类";
            msg = String.format("在%s过程中,服务器开小差了", msg);
           if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException(msg + e.getMessage());
            }
        }
    }





}
