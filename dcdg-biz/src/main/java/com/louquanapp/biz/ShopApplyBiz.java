package com.louquanapp.biz;

import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.dao.mapper.CustomerMapper;
import com.louquanapp.dao.mapper.ShopApplyMapper;
import com.louquanapp.dao.model.ShopApply;
import com.louquanapp.req.ReqShopApply;
import com.louquanapp.service.JedisService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Auther: Huhuamin
 * @Date: 2019/3/27 17:41
 * @Description: 商家入驻申请业务逻辑
 */
@Service
public class ShopApplyBiz {

    private final ShopApplyMapper shopApplyMapper;
    private final CustomerMapper customerMapper;
    private final JedisService jedisService;

    public ShopApplyBiz(ShopApplyMapper shopApplyMapper, CustomerMapper customerMapper, JedisService jedisService) {
        this.shopApplyMapper = shopApplyMapper;
        this.customerMapper = customerMapper;
        this.jedisService = jedisService;
    }

    /**
     * 商家入驻
     *
     * @param reqSource
     * @return
     */
    @Transactional
    public JsonResult saveApply(ReqShopApply reqSource, String custId) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            ShopApply shopApply = new ShopApply();
            BeanUtils.copyProperties(reqSource, shopApply);
            Date now = new Date();
            Integer flag = shopApplyMapper.selectFlagByCustId(custId);
            if (null != flag) {
                if (flag == 1) {
                    jsonResult.setMessage("您已经提交了申请,请耐心等待审核");
                    return jsonResult;
                } else if (flag == 2) {
                    jsonResult.setMessage("您的申请已经通过了,请不要重复申请");
                    return jsonResult;
                } else if (flag == 3) {
                    shopApply.setApplyFlag((byte) 1);
                    shopApply.setCustId(custId);
                    shopApply.setAddTime(now);
                    shopApply.setApplyId(shopApplyMapper.selectIdByCustId(custId));
                    int result = shopApplyMapper.updateByPrimaryKey(shopApply);
                    if (result == 0) {
                        throw new HuhuaminException("商家入驻修改失败");
                    }

                }
            } else {
                shopApply.setApplyFlag((byte) 1);
                shopApply.setCustId(custId);
                shopApply.setAddTime(now);
                shopApply.setApplyId(UUIDUtils.generateUuid22());
                int result = shopApplyMapper.insert(shopApply);
                if (result == 0) {
                    throw new HuhuaminException("商家入驻保存失败");
                }
            }


            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
           if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }

            throw new HuhuaminException("在商家入驻过程中,系统开小差了！！！", e);
        }


    }


}
