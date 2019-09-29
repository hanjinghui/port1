package com.louquanapp.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * @Author 胡化敏
 * @Description: 微信登录业务逻辑
 * @Date Create  2019年03月26日15:23:34
 * @Modified By:
 * @Since:
 */
@Service
public class WechatService {
    private static final Logger logger = LoggerFactory.getLogger(WechatService.class);


    @Value("${weixin.open.userInfo}")
    private String userInfoUrl;


    @Autowired
    private RestTemplate restTemplate;


    public String getUserInfoByOpenIdAndToken(String openId, String token) {

        String tempUserInfoUrl = new String(userInfoUrl);
        tempUserInfoUrl = tempUserInfoUrl.replace("ACCESS_TOKEN", token).replace("OPENID", openId);
        String result = restTemplate.getForObject(tempUserInfoUrl, String.class);
        return result;

    }


}
