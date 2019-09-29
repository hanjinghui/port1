package com.louquanapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author 胡化敏
 * @Description: qq 登录业务逻辑
 * @Date Create  2019年03月26日15:20:23
 * @Modified By:
 * @Since:
 */
@Service
public class QqService {

    @Value("${qq.open.userInfo}")
    private String userInfoUrl;

    @Autowired
    private RestTemplate restTemplate;

    public String getQqTokenCheck(String accessToken, String openId) {
        //https://graph.qq.com/user/get_user_info?access_token=ACCESS_TOKEN&oauth_consumer_key=APP_ID&openid=OPEN_ID;
        String tempUserInfoUrl = new String(userInfoUrl);
        tempUserInfoUrl = tempUserInfoUrl.replace("ACCESS_TOKEN", accessToken).replace("OPEN_ID", openId);
        String result = restTemplate.getForObject(tempUserInfoUrl, String.class);
        return result;


    }
}
