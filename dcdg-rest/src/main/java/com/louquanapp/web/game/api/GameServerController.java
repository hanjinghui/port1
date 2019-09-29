package com.louquanapp.web.game.api;

import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.*;
import com.louquanapp.dao.mapper.SystemParamMapper;
import com.louquanapp.dao.model.Customer;
import com.louquanapp.dao.model.SystemParam;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqBalance;
import com.louquanapp.req.ReqPoint;
import com.louquanapp.req.ReqToken;
import com.louquanapp.req.ReqTokenGame;
import com.louquanapp.resp.RespChatGroup;
import com.louquanapp.service.JedisService;
import com.louquanapp.utils.WebServletUtil;
import com.louquanapp.web.customer.api.AuthCustomerApi;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


/**
 * @Auther: Huhuamin
 * @Date: 2019/4/18 09:11
 * @Description:
 */
@RestController
@RequestMapping("/api/auth")
public class GameServerController {

    private final GameServerBiz gameServerBiz;
    private final JedisService jedisService;
    private final CustomerBiz customerBiz;
    private final SystemParamMapper systemParamMapper;
    private final ChatBiz chatBiz;
    private final CustomerAttentionBiz carAttentionBiz;


    public GameServerController(GameServerBiz gameServerBiz, JedisService jedisService, CustomerBiz customerBiz, SystemParamMapper systemParamMapper, ChatBiz chatBiz, CustomerAttentionBiz carAttentionBiz) {
        this.gameServerBiz = gameServerBiz;
        this.jedisService = jedisService;
        this.customerBiz = customerBiz;
        this.systemParamMapper = systemParamMapper;
        this.chatBiz = chatBiz;
        this.carAttentionBiz = carAttentionBiz;
    }

    private boolean checkIp(HttpServletRequest request) {
        boolean flag = false;
        SystemParam systemParam = systemParamMapper.selectByIndex(SystemParamBiz.IP);
        if (null != systemParam) {
            String param = systemParam.getParamValue();
            if (StringUtils.isEmpty(param) || "*".equals(param)) {
                flag = true;
            } else {
                if (param.contains(WebServletUtil.getClientIpAddr(request))) {
                    flag = true;
                } else {
                    flag = false;
                }
            }

        } else {
            flag = true;
        }
        return flag;

    }

    /**
     * 增加积分
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("addPoint")
    public JsonResult addPoint(HttpServletRequest request, @Valid ReqPoint reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        if (!checkIp(request)) {
            jsonResult.setMessage("ip未授权");
            return jsonResult;
        }
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return gameServerBiz.addPoint(reqSource, custId, reqSource.getGameName());
    }

    @PostMapping("minusPoint")
    public JsonResult minusPoint(HttpServletRequest request, @Valid ReqPoint reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        if (!checkIp(request)) {
            jsonResult.setMessage("ip未授权");
            return jsonResult;
        }
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return gameServerBiz.minusPoint(reqSource, custId, reqSource.getGameName());
    }

    /**
     * 玩游戏送余额
     * @param request
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/addBalance")
    public JsonResult addBalance(HttpServletRequest request, @RequestBody @Valid ReqBalance reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        if (!checkIp(request)) {
            jsonResult.setMessage("ip未授权");
            return jsonResult;
        }
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return gameServerBiz.addBalance(reqSource, custId);
    }

    /**
     * token获取客户信息
     *
     * @return
     */
    @PostMapping("/tokenUserInfo")
    //3-Android 4-iOS
    public TypeJsonResult<Customer> tokenUserInfo(HttpServletRequest request, @Valid ReqTokenGame reqSource, BindingResult bindingResult) {
        TypeJsonResult<Customer> jsonResult = new TypeJsonResult<>();
        if (!checkIp(request)) {
            jsonResult.setMessage("ip未授权");
            return jsonResult;
        }
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        jsonResult = customerBiz.getByToken(reqSource.getToken());
        return jsonResult;
    }

    /**
     * 查询朋友列表
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/tokenFriends")
    public TypeJsonResult<List<RespChatGroup>> friends(HttpServletRequest request, @Valid ReqTokenGame reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        if (!checkIp(request)) {
            jsonResult.setMessage("ip未授权");
            return jsonResult;
        }
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        ReqToken reqToken = new ReqToken();
        reqToken.setToken(reqSource.getToken());
        return chatBiz.selectFriends(reqToken, custId);
    }


    /**
     * 进入直播间
     */
    @PostMapping("/gameIn/{sourceId}")
    public JsonResult doIn(@PathVariable("sourceId") String sourceId, @Valid ReqTokenGame reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return carAttentionBiz.addAttentionByType(sourceId, custId, 6, null);
    }

    /**
     * 出直播间
     */
    @PostMapping("/gameOut/{sourceId}")
    public JsonResult doOut(@PathVariable("sourceId") String sourceId, @Valid ReqTokenGame reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return carAttentionBiz.delAttentionByType(sourceId, custId, 6);
    }


}
