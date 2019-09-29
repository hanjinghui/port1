package com.louquanapp.utils;

import com.qiniu.pili.Client;
import com.qiniu.pili.Config;
import com.qiniu.pili.Hub;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/23 14:36
 * @Description:
 */
public class QiNiuClient {
    private static final String accessKey = "HalH2Qj8Z2ykTZfFnUbAByDcyMPE1qWlzWIuHHlf";
    private static final String secretKey = "QCrfBcApznjtZeFm7zq7hsEph85h3iP9p9GRbkX5";
    public static final String hubName = "louquan";
    private static Client cli = null;
    private static Hub hub = null;


    static {
        Config.APIHost = "pili.qiniuapi.com";
        //初始化client
        cli = new Client(accessKey, secretKey);
        hub = cli.newHub(hubName);
    }

    public static Hub getHub() {
        return hub;
    }
    public  static Client getCli(){
        return  cli;
    }

}
