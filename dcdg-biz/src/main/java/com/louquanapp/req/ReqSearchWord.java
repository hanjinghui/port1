package com.louquanapp.req;

/**
 * @Auther: Huhuamin
 * @Date: 2019年03月31日00:21:08
 * @email:175759041@qq.com
 * @Description: 搜素word 包括历史/热搜
 */
public class ReqSearchWord extends ReqComm {

    /**
     * 可登陆 可不登录 登录 会记录我的搜素里面
     */
    private String token;

    /**
     * token 值
     *
     * @return
     */
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
