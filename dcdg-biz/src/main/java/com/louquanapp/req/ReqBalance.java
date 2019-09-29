package com.louquanapp.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Auther: zhubaorui
 * @Date: 2019/6/12 07:58
 * @Description:游戏余额
 */
public class ReqBalance {

    /**
     * 平台token
     */
    @NotBlank(message = "token不能为空")
    private String token;

    /**
     * 游戏Id
     */
    @NotBlank(message = "游戏Id不能为空")
    private String gameId;
    /**
     * 游戏名称
     */
    @NotBlank(message = "游戏名称不能为空")
    private String gameName;

    /**
     * 余额
     */
    @NotNull(message = "余额不能为空")
    private Double balance;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
