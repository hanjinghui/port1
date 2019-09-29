package com.louquanapp.web.basic.api;

import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.ChatBiz;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.*;
import com.louquanapp.resp.RespChatGroup;
import com.louquanapp.service.JedisService;
import com.louquanapp.web.customer.api.AuthCustomerApi;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/20 21:05
 * @description:
 */
@RestController
@RequestMapping("/api/auth/chat")
public class ChatController {
    private final JedisService jedisService;
    private final ChatBiz chatBiz;

    public ChatController(JedisService jedisService, ChatBiz chatBiz) {
        this.jedisService = jedisService;
        this.chatBiz = chatBiz;
    }

    /**
     * 同意邀请聊天好友
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/agreementChatFriends")
    public JsonResult agreementChatFriends(@RequestBody @Valid ReqUserInfoPage reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return chatBiz.agreementChatFriends(reqSource, custId);
    }

    /**
     * 邀请聊天好友
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/inviteChatFriends")
    public JsonResult inviteChatFriends(@RequestBody @Valid ReqUserInfoPage reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;

        return chatBiz.inviteChatFriends(reqSource, custId);
    }

    /**
     * 查询新朋友列表
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/newFriends")
    public JsonResult newFriends(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;

        return chatBiz.selectNewFriends(custId);
    }

    /**
     * 查询朋友列表
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/friends")
    public TypeJsonResult<List<RespChatGroup>> friends(@RequestBody @Valid ReqTokenPage reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return chatBiz.selectFriends(reqSource, custId);
    }



    /**
     * 查询聊天好友详情
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/datailFriend")
    public JsonResult datailFriends(@RequestBody @Valid ReqUserInfoPage reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String friendId=reqSource.getFriendId();
        if(StringUtils.isBlank(friendId)){
            jsonResult.setMessage("朋友id 不能为空！");
            return jsonResult;
        }
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return chatBiz.datailFriend(friendId,custId);
    }
    /**
     * 设置备注
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/updateFrientRemark")
    public JsonResult updateFrientRemark(@RequestBody @Valid ReqUserInfoPage reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatusCode(false);
        String chatId=reqSource.getChatId();
        if(StringUtils.isBlank(chatId)){
            jsonResult.setMessage("chatId 不能为空！");
            return jsonResult;
        }
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;

        return chatBiz.updateChat(chatId,custId,reqSource,null);
    }

    /**
     * 加入黑名单  回复正常
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/addBlacklist")
    public JsonResult addBlacklist(@RequestBody @Valid ReqAddBlacklist reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        //(String chatId,String custId,String frientRemark,Byte chatStatus)
        return chatBiz.updateChat(reqSource.getChatIds(),custId,null,reqSource.getChatStatus());
    }

    /**
     * 查询我的黑名单列表
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/chatBlacklists")
    public JsonResult chatBlacklists(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return chatBiz.chatBlacklists(custId);
    }

    /**
     * 删除好友
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/delFriends")
    public JsonResult delFriends(@RequestBody @Valid ReqUserInfoPage reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String chatId=reqSource.getChatId();
        if(StringUtils.isBlank(chatId)){
            jsonResult.setMessage("chatId 不能为空！");
            return jsonResult;
        }
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return chatBiz.delFriends(chatId,custId);
    }


    /**
     *  发起群
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/addChatGrop")
    public JsonResult addChatGrop(@RequestBody @Valid ReqAddChatGroup reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return chatBiz.addChatGrop(reqSource,custId);
    }

    /**
     *  聊天好友群详情
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/chatGroup")
    public JsonResult chatGroup(@RequestBody @Valid ReqChatGroupDatail reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return chatBiz.chatGroup(reqSource,custId);
    }


    /**
     *  是否显示群昵称或修改用户在群里的昵称
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/isShowNickName")
    public JsonResult isShowNickName(@RequestBody @Valid ReqChatNickName reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return chatBiz.isShowNickName(reqSource,custId);
    }


    /**
     * 聊天群列表
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/chatGroups")
    public JsonResult chatGroups(@RequestBody @Valid ReqToken reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return chatBiz.chatGroups(custId);
    }


    /**
     * 聊天群--添加选择联系人
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/chatGroupAddMembers")
    public JsonResult chatGroupAddMembers(@RequestBody @Valid ReqAddChatGroupMembers reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return chatBiz.chatGroupAddMembers(reqSource,custId);
    }

    /**
     * 聊天群--选择联系人列表
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/chatGroupMembers")
    public JsonResult chatGroupMembers(@RequestBody @Valid ReqChatGroupDatail reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return chatBiz.chatGroupMembers(reqSource,custId);
    }

    /**
     * 聊天群--群主踢人或成员退群
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/quitChactGroup")
    public JsonResult quitChactGroup(@RequestBody @Valid ReqQuitChatGroup reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return chatBiz.quitChactGroup(reqSource,custId);
    }

    /**
     * 聊天群--群主解散群
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/dismissChatGroup")
    public JsonResult dismissChatGroup(@RequestBody @Valid ReqQuitChatGroup reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return chatBiz.dismissChatGroup(reqSource,custId);
    }

    /**
     * 聊天群--(群主群主权限）群头像 群名称 群公告
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/updateChatGroupByMasterId")
    public JsonResult updateChatGroupByMasterId(@RequestBody @Valid ReqChatGroupUpdateByMaster reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return chatBiz.updateChatGroupByMasterId(reqSource,custId);
    }

    /**
     * 聊天群--群成员列表
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/chatGroupMembersByGroupId")
    public JsonResult chatGroupByGroupId(@RequestBody @Valid ReqChatGroupDatail reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return chatBiz.chatGroupMembersByGroupId(reqSource,custId);
    }

    /**
     * 查询好友关系是否存在
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/existChatRelation")
    public JsonResult existChatRelation(@RequestBody @Valid ReqChatFriend reqSource, BindingResult bindingResult) {
        TypeJsonResult jsonResult = new TypeJsonResult();
        jsonResult.setStatusCode(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return chatBiz.existChatRelation(custId,reqSource.getFriendId());
    }



}
