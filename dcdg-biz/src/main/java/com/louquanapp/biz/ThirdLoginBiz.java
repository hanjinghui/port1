package com.louquanapp.biz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.louquanapp.service.QqService;
import com.louquanapp.service.WechatService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/8/7 上午9:09
 * <p>
 * 第三方登录业务逻辑
 */
@Service
public class ThirdLoginBiz {

    private final WechatService wechatService;
    private final QqService qqService;
    @Value("${off_line}")
    private boolean off_line;


    public ThirdLoginBiz(WechatService wechatService, QqService qqService) {
        this.wechatService = wechatService;
        this.qqService = qqService;
    }


    public boolean checkWxByOpenIdAndToken(String openId, String token) {
//        if(off_line)return true;
//        String result = wechatService.getUserInfoByOpenIdAndToken(openId, token);
//        if (StringUtils.isEmpty(result)) {
//            return false;
//        }
//        JSONObject object = JSON.parseObject(result);
//        if (object == null) {
//            return false;
//        }
//        int errcode = object.getIntValue("errcode");
//        if (errcode != 0) {
//            return false;
//        }
        return true;
    }

    public boolean checkQqByOpenIdAndToken(String openId, String accessToken) {
//        if (off_line) return true;
//        String result = qqService.getQqTokenCheck(accessToken, openId);
//        if (StringUtils.isEmpty(result)) {
//            return false;
//        }
//        JSONObject object = JSON.parseObject(result);
//        if (object == null) {
//            return false;
//        }
//        int ret = object.getIntValue("ret");
//        if (ret != 0) {
//            return false;
//        }

        return true;

    }


}
