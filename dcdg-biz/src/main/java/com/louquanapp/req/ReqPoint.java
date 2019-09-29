package com.louquanapp.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/6 07:58
 * @Description:游戏积分
 */
public class ReqPoint {

    /**
     * 平台token
     */
    @NotBlank(message = "token不能为空")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @NotBlank(message = "游戏名称不能为空")
    private String gameName;

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    /**
     * 分数
     */
    @NotNull(message = "赠送积分数不能为空")
    private Integer pointNum;

    public Integer getPointNum() {
        return pointNum;
    }

    public void setPointNum(Integer pointNum) {
        this.pointNum = pointNum;
    }

    /**
     * 游戏Id
     */
    @NotBlank(message = "游戏Id不能为空")
    private String gameId;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}
