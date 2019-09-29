package com.louquanapp.web.basic.api;

import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.MessageBiz;
import com.louquanapp.dao.model.Message;
import com.louquanapp.model.PageJsonResult;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqComm;
import com.louquanapp.req.ReqCommPage;
import com.louquanapp.req.ReqMessage;
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
 * @Date: 2019/4/11 11:04
 * @description:
 */
@RestController
@RequestMapping("/api/no")
public class MessageController {
    private final MessageBiz messageBiz;
    private final JedisService jedisService;

    public MessageController(MessageBiz messageBiz, JedisService jedisService) {
        this.messageBiz = messageBiz;
        this.jedisService = jedisService;
    }

    /**
     * 消息标题查询
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/messages")
    public TypeJsonResult message(@RequestBody @Valid ReqComm reqSource, BindingResult bindingResult) {
        return messageBiz.messages();
    }

    /**
     * 消息标题查询--分页
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/messagesPage")
    public PageJsonResult<Message> messagesPage(@RequestBody @Valid ReqCommPage reqSource, BindingResult bindingResult) {
        return messageBiz.messagesPage(reqSource);
    }

    /**
     * 添加消息
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/saveMessageSelective")
    public JsonResult saveMessageSelective(@RequestBody @Valid ReqMessage reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return messageBiz.saveMessageSelective(reqSource,custId);
    }
}
