package com.louquanapp.web.basic.api;

import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.GameBiz;
import com.louquanapp.biz.GameServerBiz;
import com.louquanapp.dao.model.Game;
import com.louquanapp.model.PageJsonResult;
import com.louquanapp.req.ReqGameCatId;
import com.louquanapp.req.ReqPointSign;
import com.louquanapp.service.JedisService;
import com.louquanapp.web.customer.api.AuthCustomerApi;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/17 15:21
 * @description: 游戏
 */
@RestController
@RequestMapping("/api/auth")
public class GameController {

    private final JedisService jedisService;
    private final GameBiz gameBiz;
    private final GameServerBiz gameServerBiz;

    public GameController(JedisService jedisService, GameBiz gameBiz, GameServerBiz gameServerBiz) {
        this.jedisService = jedisService;
        this.gameBiz = gameBiz;
        this.gameServerBiz = gameServerBiz;
    }


    /**
     * 查询游戏列表带签到信息
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/games")
    public PageJsonResult<Game> games(@RequestBody @Valid ReqGameCatId reqSource, BindingResult bindingResult) {
        PageJsonResult<Game> pageJsonResult = new PageJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(pageJsonResult, custId)) return pageJsonResult;
        return gameBiz.games(reqSource, custId, true);
    }


    /**
     * 查询游戏列表带签到信息
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/myGames")
    public PageJsonResult<Game> myGames(@RequestBody @Valid ReqGameCatId reqSource, BindingResult bindingResult) {
        PageJsonResult<Game> pageJsonResult = new PageJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(pageJsonResult, custId)) return pageJsonResult;
        return gameBiz.myGames(reqSource, custId);
    }


    /**
     * 查询游戏列表带签到信息
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/gameList")
    public PageJsonResult<Game> games2(@RequestBody @Valid ReqGameCatId reqSource, BindingResult bindingResult) {
        PageJsonResult<Game> pageJsonResult = new PageJsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(pageJsonResult, custId)) return pageJsonResult;
        return gameBiz.games(reqSource, custId, false);
    }

    @PostMapping("signPoint")
    public JsonResult signPoint(@RequestBody @Valid ReqPointSign reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return gameServerBiz.signPoint(custId);
    }

}
