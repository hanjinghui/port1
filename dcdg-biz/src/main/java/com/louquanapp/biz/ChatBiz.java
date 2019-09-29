package com.louquanapp.biz;

import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.dao.mapper.ChatGroupMapper;
import com.louquanapp.dao.mapper.ChatGroupRelationMapper;
import com.louquanapp.dao.mapper.ChatMapper;
import com.louquanapp.dao.mapper.CustomerMapper;
import com.louquanapp.dao.model.Chat;
import com.louquanapp.dao.model.ChatGroup;
import com.louquanapp.dao.model.ChatGroupRelation;
import com.louquanapp.dao.model.Customer;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.*;
import com.louquanapp.resp.RespChatGroup;
import com.louquanapp.utils.KTestpinyinUtils;
import com.louquanapp.utils.RongcloudUtil;
import io.rong.messages.TxtMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/21 9:44
 * @description:
 */
@Service
public class ChatBiz {
    private final ChatMapper chatMapper;
    private final CustomerMapper customerMapper;
    private final ChatGroupMapper chatGroupMapper;
    private final ChatGroupRelationMapper chatGroupRelationMapper;



    public ChatBiz(ChatMapper chatMapper, CustomerMapper customerMapper, ChatGroupMapper chatGroupMapper, ChatGroupRelationMapper chatGroupRelationMapper) {
        this.chatMapper = chatMapper;
        this.customerMapper = customerMapper;
        this.chatGroupMapper = chatGroupMapper;
        this.chatGroupRelationMapper = chatGroupRelationMapper;
    }

    /**
     * 同意聊天好友
     *
     * @param reqUserInfo
     * @param custId
     * @return
     */
    @Transactional
    public JsonResult agreementChatFriends(ReqUserInfoPage reqUserInfo, String custId) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            String chatId = reqUserInfo.getChatId();
            if (null == chatId) {
                jsonResult.setStatusCode(false);
                jsonResult.setMessage("好友关系Id不能为空！");
                return jsonResult;
            } else {
                Chat chat = chatMapper.selectByPrimaryKey(chatId);
                if (null == chat) {
                    jsonResult.setStatusCode(false);
                    jsonResult.setMessage("好友邀请关系不存在！");
                    return jsonResult;
                }
                // 测试

                if (!chat.getFriendId().equals(custId) || chat.getChatStatus() != 3) {
                    jsonResult.setStatusCode(false);
                    jsonResult.setMessage("不是好友申请状态，不能同意添加好友！");
                    return jsonResult;
                }

                Customer customer = customerMapper.selectByPrimaryKey(custId);
                String nickName = customer.getNickName();
                String headImg = customer.getHeadImg();

                String[] targetIds = {chat.getCustId()};
                String extra = "";
                if (null != customer.getHeadImg()) {
                    extra = custId.concat(",").concat(nickName).concat(",").concat(headImg);
                } else {
                    extra = custId.concat(",").concat(nickName);
                }
                TxtMessage txtMessage = new TxtMessage(nickName.concat("同意加您为好友"), extra);
                Boolean flay = RongcloudUtil.sendSystemMessage(targetIds, txtMessage);
                if (flay) {
                    Chat updateChat = new Chat();
                    updateChat.setChatId(chatId);
                    updateChat.setChatStatus((byte) 1);//状态[1-正常 2-拉黑 3-申请中]

                    int countUpdate = chatMapper.updateChat(updateChat);
                    if (countUpdate == 0) {
                        jsonResult.setStatusCode(false);
                        jsonResult.setMessage("同意聊天好友修改失败！");
                        return jsonResult;
                    }

                    Chat newChat=chatMapper.queryChatStatus(chat.getFriendId(),chat.getCustId());
                    if(null==newChat){
                        Chat chatFriend = new Chat();
                        chatFriend.setChatId(UUIDUtils.generateUuid22());
                        chatFriend.setCustId(chat.getFriendId());
                        chatFriend.setFriendId(chat.getCustId());
                        chatFriend.setChatStatus((byte) 1);//状态[1-正常 2-拉黑 3-申请中]
                        chatFriend.setAddTime(new Date());
                        //Customer chatFriendCustomer = customerMapper.selectByPrimaryKey(chat.getFriendId());
                        chatFriend.setFrientRemark("");
                        chatFriend.setChatPhone(customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(chat.getCustId()).getCustPhone());
                        chatFriend.setChatDescribe("");

                        int count = chatMapper.insert(chatFriend);
                        if (count == 1) {
                            jsonResult.setStatusCode(true);
                            return jsonResult;
                        } else {
                            throw new HuhuaminException("同意聊天好友失败！");
                        }
                    }else {
                        Chat updateChatStatus = new Chat();
                        updateChatStatus.setChatId(newChat.getChatId());
                        updateChatStatus.setChatStatus((byte) 1);//状态[1-正常 2-拉黑 3-申请中]

                        int updateChatStatusCount = chatMapper.updateChat(updateChatStatus);
                        if (updateChatStatusCount == 0) {

                            throw new HuhuaminException("同意聊天好友修改朋友关系失败！");
                        }else {
                            jsonResult.setStatusCode(true);
                            return jsonResult;
                        }
                    }
                } else {
                    jsonResult.setStatusCode(false);
                    jsonResult.setMessage("邀请好友失败！");
                    return jsonResult;
                }
            }
        } catch (Exception e) {
            String msg = "同意聊天好友";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }


    /**
     * 邀请聊天好友
     *
     * @param reqUserInfo
     * @param custId
     * @return
     */
    public JsonResult inviteChatFriends(ReqUserInfoPage reqUserInfo, String custId) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            String friendId = reqUserInfo.getFriendId();

            if (null == friendId) {
                jsonResult.setStatusCode(false);
                jsonResult.setMessage("friendId不能为空！");
                return jsonResult;
            } else {
                if (0 == customerMapper.existCustId(friendId)) {
                    jsonResult.setStatusCode(false);
                    jsonResult.setMessage("好友不存在！");
                    return jsonResult;
                }
                Chat custIdAndFriendId= chatMapper.queryChatStatus(custId,friendId);
                Chat friendIdAndCustId= chatMapper.queryChatStatus(friendId,custId);
                Customer customer = customerMapper.selectByPrimaryKey(custId);
                String nickName = customer.getNickName();
                if(null!=custIdAndFriendId||null!=custIdAndFriendId){
                    Byte  custIdChatStatus=custIdAndFriendId.getChatStatus();
                    if(3==custIdChatStatus){
                        String chatId=custIdAndFriendId.getChatId();
                        String[] targetIds = {friendId};
                        String extra = "";
                        if (null != customer.getHeadImg()) {
                            extra = chatId.concat(",").concat(nickName).concat(",").concat(customer.getHeadImg());
                        } else {
                            extra = chatId.concat(",").concat(nickName);
                        }
                        TxtMessage txtMessage = new TxtMessage(nickName.concat("邀请您加入好友"), extra);
                        Boolean flay = RongcloudUtil.sendSystemMessage(targetIds, txtMessage);
                        if (flay) {
                            Chat updateTimeChat = new Chat();
                            updateTimeChat.setChatId(custIdAndFriendId.getChatId());
                            updateTimeChat.setUpdateTime(new Date());
                            int updateTimeCount = chatMapper.updateChat(updateTimeChat);
                            if (updateTimeCount == 1) {
                                /*已经操作成功，因为是重复请求好友，所有向前台发送 '你已经邀请过好友，无需再次邀请！' */
                                jsonResult.setStatusCode(false);
                                jsonResult.setMessage("你已经邀请过好友，无需再次邀请！");
                                return jsonResult;
                            } else {
                                jsonResult.setStatusCode(false);
                                jsonResult.setMessage("添加好友失败！");
                                return jsonResult;
                            }
                        }else {
                            jsonResult.setStatusCode(false);
                            jsonResult.setMessage("添加好友第三方通知失败！");
                            return jsonResult;
                        }

                    }

                    Byte  friendIdChatStatus=friendIdAndCustId.getChatStatus();

                    if(2==custIdChatStatus){
                        jsonResult.setStatusCode(false);
                        jsonResult.setMessage("你已经将对方加入黑名单中！");
                        return jsonResult;
                    }

                    if(friendIdChatStatus!=null&&2==friendIdChatStatus){
                        jsonResult.setStatusCode(false);
                        jsonResult.setMessage("对方将你加入黑名单中！");
                        return jsonResult;
                    }
                    jsonResult.setStatusCode(false);
                    jsonResult.setMessage("再次邀请好友失败！");
                    return jsonResult;
                }

                String chatId = UUIDUtils.generateUuid22();


                String[] targetIds = {friendId};
                String extra = "";
                if (null != customer.getHeadImg()) {
                    extra = chatId.concat(",").concat(nickName).concat(",").concat(customer.getHeadImg());
                } else {
                    extra = chatId.concat(",").concat(nickName);
                }
                TxtMessage txtMessage = new TxtMessage(nickName.concat("邀请您加入好友"), extra);
                Boolean flay = RongcloudUtil.sendSystemMessage(targetIds, txtMessage);
                if (flay) {
                    String updateTimeChatId = chatMapper.queryChatIdChatByCustIdAndFriendIdAndChatStatus(custId, friendId);
                    if (StringUtils.isNotBlank(updateTimeChatId)) {
                        Chat updateTimeChat = new Chat();
                        updateTimeChat.setChatId(updateTimeChatId);
                        updateTimeChat.setUpdateTime(new Date());
                        int updateTimeCount = chatMapper.updateChat(updateTimeChat);
                        if (updateTimeCount == 1) {
                            jsonResult.setStatusCode(true);
                            return jsonResult;
                        } else {
                            jsonResult.setStatusCode(false);
                            jsonResult.setMessage("添加好友失败！");
                            return jsonResult;
                        }
                    } else {
                        Chat chat = new Chat();
                        chat.setChatId(chatId);
                        chat.setCustId(custId);
                        chat.setFriendId(friendId);
                        chat.setChatStatus((byte) 3);//状态[1-正常 2-拉黑 3-申请中]
                        chat.setAddTime(new Date());

                        chat.setFrientRemark("");
                        chat.setChatPhone(customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(friendId).getCustPhone());
                        chat.setChatDescribe("");


                        int count = chatMapper.insert(chat);
                        if (count == 1) {
                            jsonResult.setStatusCode(true);
                            return jsonResult;
                        } else {
                            jsonResult.setStatusCode(false);
                            jsonResult.setMessage("添加好友失败！");
                            return jsonResult;
                        }
                    }
                } else {
                    jsonResult.setStatusCode(false);
                    jsonResult.setMessage("邀请好友失败！");
                    return jsonResult;
                }
            }

        } catch (Exception e) {
            String msg = "邀请聊天好友";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }


    /**
     * 查询新朋友列表
     *
     * @param custId
     * @return
     */
    public TypeJsonResult<List<Chat>> selectNewFriends(String custId) {
        try {

            TypeJsonResult<List<Chat>> chats = new TypeJsonResult<>();
            chats.setStatusCode(false);
            List<Chat> chatList = chatMapper.selectNewFriends(custId);
            chats.setStatusCode(true);
            chats.setType(chatList);
            return chats;
        } catch (Exception e) {
            String msg = "查询新朋友列表";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
//            throw new HuhuaminException("查询新朋友列表", e);
        }
    }


    /**
     * 查询朋友列表
     * @param reqSource
     * @param custId
     * @return
     */
    public TypeJsonResult<List<RespChatGroup>> selectFriends(ReqToken reqSource, String custId) {
        try {
            TypeJsonResult<List<RespChatGroup>> chats = new TypeJsonResult<>();
            chats.setStatusCode(false);
            List<Chat> list = chatMapper.selectFriends(custId);
            for (Chat chat : list) {
                if (StringUtils.isNotBlank(chat.getNickName())) {
                    chat.setInitial(KTestpinyinUtils.getPYIndexStr(chat.getNickName().substring(0, 1), true).toUpperCase());
                }
            }
            Map<String, List<Chat>> mapStream = new HashMap<>();
            list.stream().forEach(t -> {
                t.setFrientRemark(chatMapper.queryChatStatus(custId,t.getFriendId()).getFrientRemark());

                String initial = t.getInitial();
                if (mapStream.containsKey(initial)) {
                    mapStream.get(initial).add(t);
                } else {
                    List<Chat> tlist = new ArrayList<Chat>();
                    tlist.add(t);
                    mapStream.put(initial, tlist);
                }
            });
            List<RespChatGroup> listStream = new ArrayList();
            for (Map.Entry<String, List<Chat>> temp : mapStream.entrySet()) {
                RespChatGroup chatGroup = new RespChatGroup();
                String initial = temp.getKey();
                chatGroup.setInitial(initial);
                chatGroup.setList(temp.getValue());
                listStream.add(chatGroup);
            }
            chats.setStatusCode(true);
            chats.setType(listStream);
            return chats;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            } else {
                throw new HuhuaminException("查询商品评论信息" + e.getMessage());
            }
        }
    }


    /**
     * 查询聊天好友详情
     *
     * @param custId
     * @return
     */
    public TypeJsonResult<Chat> datailFriend(String friendId, String custId) {
        try {

            TypeJsonResult<Chat> jsonResult = new TypeJsonResult<>();
            jsonResult.setStatusCode(false);
            Chat chat = chatMapper.datailFriend(friendId, custId);
            int chatGroupNum=0;
            List<String> custIdGroupIds=chatGroupMapper.queryChatGroupByCustId(custId);
            List<String> friendIdGroupIds=chatGroupMapper.queryChatGroupByCustId(friendId);

            custIdGroupIds.retainAll(friendIdGroupIds);
            chat.setChatGroupNum(custIdGroupIds.size());
            if (null == chat) {
                jsonResult.setMessage("查询聊天好友详情失败！");
                return jsonResult;
            }
            jsonResult.setStatusCode(true);
            jsonResult.setType(chat);
            return jsonResult;
        } catch (Exception e) {
            throw new HuhuaminException("查询聊天好友详情", e);
        }
    }


    /**
     * 聊天好友  设置备注   加入黑名单
     *
     * @param reqSource
     * @param custId
     * @return
     */
    public JsonResult updateChat(String chatId, String custId, ReqUserInfoPage reqSource, Byte chatStatus) {
        try {

            JsonResult jsonResult = new JsonResult();
            jsonResult.setStatusCode(false);

            if (null == chatStatus) {
                if (null == reqSource.getFrientRemark()) {
                    jsonResult.setMessage("备注不能为空！");
                    return jsonResult;
                }
                Chat chat = new Chat();
                chat.setChatId(chatId);
                //chat.setCustId(custId);
                chat.setFrientRemark(reqSource.getFrientRemark());
                chat.setChatPhone(reqSource.getChatPhone());
                chat.setChatDescribe(reqSource.getChatDescribe());

                int count = chatMapper.updateStatusAndFrientRemarkAndUpdateForChat(chat);
                if (1 == count) {
                    jsonResult.setStatusCode(true);
                    return jsonResult;
                } else {
                    jsonResult.setMessage("修改聊天好友失败！");
                    return jsonResult;
                }
            } else {
                List<String> chatIdList=Arrays.asList(chatId.split(","));

                int count=chatMapper.updateChatStatus(chatIdList,custId,chatStatus);
                if(chatIdList.size()==count){
                    jsonResult.setStatusCode(true);
                    return jsonResult;
                } else {
                    jsonResult.setMessage("修改聊天好友失败！");
                    return jsonResult;
                }

            }

        } catch (Exception e) {
            throw new HuhuaminException("修改聊天好友", e);
        }
    }


    /**
     * 查询黑名单列表
     * @param custId
     * @return
     */
    public TypeJsonResult<List<RespChatGroup>> chatBlacklists(String custId) {
        try {

            TypeJsonResult<List<RespChatGroup>> jsonResult = new TypeJsonResult();
            jsonResult.setStatusCode(false);

            List<Chat> list = chatMapper.chatBlacklists(custId);
            conversionChatData(jsonResult,list);
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            throw new HuhuaminException("修改聊天好友", e);
        }
    }
    /**
     * 删除聊天好友
     * @param chatId
     * @param custId
     * @return
     */
    @Transactional
    public JsonResult delFriends(String chatId, String custId) {
        try {

            JsonResult jsonResult = new JsonResult();
            jsonResult.setStatusCode(false);
            Chat chat=chatMapper.selectByPrimaryKey(chatId);

            int count = chatMapper.delChatFriendId( chat.getCustId(), chat.getFriendId());
            if (1 == count) {
                count=chatMapper.delChatFriendId(chat.getFriendId(), chat.getCustId());
                if (count==1){
                    jsonResult.setStatusCode(true);
                    return jsonResult;
                }else{
                    throw new HuhuaminException("删除聊天好友--删除聊天好友朋友关系失败！");
                }

            } else {
                jsonResult.setMessage("删除聊天好友失败！");
                return jsonResult;
            }
        } catch (Exception e) {
            String msg = "删除聊天好友";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }


    /**
     * 发起群
     *
     * @param reqSource
     * @param custId
     * @return
     */
    @Transactional
    public TypeJsonResult<ChatGroup> addChatGrop(ReqAddChatGroup reqSource, String custId) {
        try {

            TypeJsonResult<ChatGroup> jsonResult = new TypeJsonResult();
            jsonResult.setStatusCode(false);

            List<String> custidList = Arrays.asList(reqSource.getCustIds().concat(",").concat(custId).split(","));
           /* if(!custidList.contains(chatCustomerServerCustId)){
                custidList.add(chatCustomerServerCustId);
            }*/
            String chatGroupId = UUIDUtils.generateUuid22();

            Customer customer = customerMapper.selectByPrimaryKey(custId);

            StringBuffer nickNames = new StringBuffer();

            //custidList insertList
            List<ChatGroupRelation> list = new ArrayList<>();
            custidList.stream().forEach(temp -> {
                String nickName = customerMapper.getNickNameMapByCustId(temp);
                ChatGroupRelation chatGroupRelation = new ChatGroupRelation();
                chatGroupRelation.setRelationId(UUIDUtils.generateUuid22());
                chatGroupRelation.setGroupId(chatGroupId);
                chatGroupRelation.setCustId(temp);
                chatGroupRelation.setRelationStatus((byte) 1);// 状态[1-显示群成员昵称 2-不显示群成员昵称  ]
                chatGroupRelation.setAddTime(new Date());
                chatGroupRelation.setCustGroupNickName(nickName);
                list.add(chatGroupRelation);
                nickNames.append(nickName).append("，");
            });

            int count = chatGroupRelationMapper.insertList(list);

            if (custidList.size() == count) {
                String groupHeadImg = customer.getHeadImg();
                String nickNamesNew = nickNames.substring(0, nickNames.length() - 1);
                if (nickNamesNew.length() > 60) {
                    nickNamesNew = nickNames.substring(0, 60);
                }

                ChatGroup chatGroup = new ChatGroup();
                chatGroup.setGroupId(chatGroupId);
                chatGroup.setGroupName(nickNamesNew);
                chatGroup.setAddTime(new Date());
                chatGroup.setGroupHeadImg(groupHeadImg);
                chatGroup.setGroupMasterId(custId);
                chatGroup.setGroupStatus((byte) 1);//状态[1-存在 2-解散]
                chatGroup.setGroupNameStatus((byte) 1);//群名称状态[1-未命名 2-已命名]

                count = chatGroupMapper.insert(chatGroup);
                if (1 == count) {
                            //custidList.remove(chatCustomerServerCustId);
                    if (RongcloudUtil.addChatGroup(custidList, chatGroupId, nickNamesNew)) {
                        jsonResult.setStatusCode(true);

                        ChatGroup chatGroupResult = new ChatGroup();
                        chatGroupResult.setGroupId(chatGroupId);
                        chatGroupResult.setGroupName(nickNamesNew);
                        chatGroupResult.setGroupHeadImg(groupHeadImg);

                        jsonResult.setType(chatGroupResult);
                        return jsonResult;
                    } else {
                        throw new HuhuaminException("第三方创建聊天好友群失败");
                    }
                } else {
                    jsonResult.setMessage("发起群失败！");
                    return jsonResult;
                }

            } else {
                throw new HuhuaminException("聊天好友群关联失败");
            }
        } catch (Exception e) {
            String msg = "发起群";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }

            throw new HuhuaminException("发起群", e);
        }
    }

    /**
     * 聊天好友群详情
     *
     * @param chatId
     * @param custId
     * @return
     */
    public TypeJsonResult<ChatGroup> chatGroup(ReqChatGroupDatail reqChatGroupDatail, String custId) {
        try {

            TypeJsonResult jsonResult = new TypeJsonResult();
            jsonResult.setStatusCode(false);
            String groupId = reqChatGroupDatail.getGroupId();
            ChatGroup chatGroup = chatGroupMapper.selectByPrimaryKey(groupId);

            List<ChatGroupRelation> chatGroupRelations = chatGroupRelationMapper.queryCustIdAndNickNameAndStatusByGroupId(groupId);
            List<Map<String,Object>> custHeadImgsAndCustIds = new ArrayList<>();
            List<String> custIds = new ArrayList<>();

            chatGroupRelations.stream().forEach(temp -> {
                Map<String,Object> map=new HashMap<>();
                map.put("custId", temp.getCustId());
                map.put("headImg",customerMapper.getHeadImgMapByCustId(temp.getCustId()));
                custHeadImgsAndCustIds.add(map);

                custIds.add(temp.getCustId());
            });
            chatGroup.setCustHeadImgsAndCustIds(custHeadImgsAndCustIds);

            ChatGroupRelation chatGroupRelation = chatGroupRelationMapper.queryCustIdAndNickNameAndStatusByCustId(custId,groupId);
            chatGroup.setCustGroupNickName(chatGroupRelation.getCustGroupNickName());
            chatGroup.setRelationStatus(chatGroupRelation.getRelationStatus());
            chatGroup.setCustId(chatGroupRelation.getCustId());
            chatGroup.setRelationId(chatGroupRelation.getRelationId());
            chatGroup.setChatGroupMasterName(customerMapper.getNickNameMapByCustId(chatGroup.getGroupMasterId()));

            //是不是群主[1-群主 2不是群主]
            if(chatGroup.getGroupMasterId().equals(custId)){
                chatGroup.setIsChatGroupMaster(1);
            }else {
                chatGroup.setIsChatGroupMaster(2);
            }
            jsonResult.setStatusCode(true);
            jsonResult.setType(chatGroup);
            return jsonResult;
        } catch (Exception e) {
            throw new HuhuaminException("聊天好友群详情", e);
        }
    }

    /**
     * 是否显示群昵称或修改用户在群里的昵称
     *
     * @param reqSource
     * @param custId
     * @return
     */
    public JsonResult isShowNickName(ReqChatNickName reqChatNickName, String custId) {
        try {

            JsonResult jsonResult = new JsonResult();
            jsonResult.setStatusCode(false);

            Byte relationStatus = reqChatNickName.getRelationStatus();
            String custNickName = reqChatNickName.getCustNickName();

            ChatGroupRelation chatGroupRelation = new ChatGroupRelation();
            chatGroupRelation.setRelationId(reqChatNickName.getRelationId());
            chatGroupRelation.setCustId(custId);

            if (3 == relationStatus) {
                if (StringUtils.isBlank(custNickName)) {
                    jsonResult.setMessage("用户在群里的昵称不能为空！");
                    return jsonResult;
                } else {
                    chatGroupRelation.setCustGroupNickName(custNickName);
                }
            } else {
                chatGroupRelation.setRelationStatus(relationStatus);
            }
            int count = chatGroupRelationMapper.updateSelectByPrimaryKey(chatGroupRelation);
            if (1 == count) {
                jsonResult.setStatusCode(true);
                return jsonResult;
            } else {
                jsonResult.setMessage("是否显示群昵称或修改用户在群里的昵称 失败！");
                return jsonResult;
            }
        } catch (Exception e) {
            throw new HuhuaminException("是否显示群昵称或修改用户在群里的昵称", e);
        }
    }


    /**
     * 聊天群列表
     *
     * @param bannerPage
     * @return
     */
    public TypeJsonResult<List<ChatGroup>> chatGroups(String custId) {
        try {

            TypeJsonResult<List<ChatGroup>> chatGroupList = new TypeJsonResult<>();
            chatGroupList.setStatusCode(false);
            List<ChatGroup> bannerList = (List<ChatGroup>) chatGroupMapper.queryChatGroupNameBCustId(custId);
            chatGroupList.setStatusCode(true);
            chatGroupList.setType(bannerList);
            return chatGroupList;
        } catch (Exception e) {
            throw new HuhuaminException("聊天群列表异常", e);
        }
    }


    /**
     * 聊天群--添加选择联系人
     *
     * @param reqSource
     * @param custId
     * @return
     */
    public  @Transactional TypeJsonResult chatGroupAddMembers(ReqAddChatGroupMembers reqSource, String custId) {
        try {
            TypeJsonResult jsonResult = new TypeJsonResult();
            jsonResult.setStatusCode(false);

            List<String> friendIdsList = Arrays.asList(reqSource.getFriendIds().split(","));
            String chatGroupId = reqSource.getGroupId();
            int checkChatGroupMembersNum=  chatGroupRelationMapper.checkChatGroupMembersNum(chatGroupId,custId,friendIdsList);
            if(friendIdsList.size()!=checkChatGroupMembersNum){
                jsonResult.setMessage("您添加的聊天成员，不是您的好友");
                return jsonResult;
            }
            String chatGroupName=chatGroupMapper.chatGroupNameByGroupId(chatGroupId);

            List<ChatGroupRelation> list = new ArrayList<>();
            friendIdsList.stream().forEach(temp -> {
                ChatGroupRelation chatGroupRelation = new ChatGroupRelation();
                chatGroupRelation.setRelationId(UUIDUtils.generateUuid22());
                chatGroupRelation.setGroupId(chatGroupId);
                chatGroupRelation.setCustId(temp);
                chatGroupRelation.setRelationStatus((byte) 1);// 状态[1-显示群成员昵称 2-不显示群成员昵称  ]
                chatGroupRelation.setAddTime(new Date());
                chatGroupRelation.setCustGroupNickName(customerMapper.getNickNameMapByCustId(temp));
                list.add(chatGroupRelation);
            });
            int count = chatGroupRelationMapper.insertList(list);

            if (friendIdsList.size() == count) {
                if (RongcloudUtil.joinChatGroup(friendIdsList, chatGroupId,chatGroupName)) {
                    jsonResult.setStatusCode(true);
                    return jsonResult;
                }else {
                    throw  new HuhuaminException("第三方添加选择联系人失败");
                }
            } else {
                throw  new HuhuaminException("聊天群--添加选择联系人失败");
            }
        } catch (Exception e) {
            String msg = "聊天群--添加选择联系人";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }


    /**
     * 聊天群--选择联系人列表
     *
     * @param reqSource
     * @param custId
     * @return
     */
    public   TypeJsonResult<List<ChatGroupRelation>> chatGroupMembers(ReqChatGroupDatail reqSource, String custId) {
        try {
            TypeJsonResult<List<ChatGroupRelation>> jsonResult = new TypeJsonResult();
            jsonResult.setStatusCode(false);

            String chatGroupId = reqSource.getGroupId();
            List<ChatGroupRelation> chatGroupRelations = chatGroupRelationMapper.chatGroupMembers(chatGroupId,custId);

            for (ChatGroupRelation chatGroupRelation : chatGroupRelations) {
                if (StringUtils.isNotBlank(chatGroupRelation.getNickName())) {
                    chatGroupRelation.setInitial(KTestpinyinUtils.getPYIndexStr(chatGroupRelation.getNickName().substring(0, 1), true).toUpperCase());
                }
            }

            Map<String, List<ChatGroupRelation>> mapStream = new HashMap<>();
            chatGroupRelations.stream().forEach(t -> {
                String initial = t.getInitial();
                if (mapStream.containsKey(initial)) {
                    mapStream.get(initial).add(t);
                } else {
                    List<ChatGroupRelation> tlist = new ArrayList<ChatGroupRelation>();
                    tlist.add(t);
                    mapStream.put(initial, tlist);
                }
            });

            List<ChatGroupRelation> listStream = new ArrayList();
            for (Map.Entry<String, List<ChatGroupRelation>> temp : mapStream.entrySet()) {
                ChatGroupRelation chatGroupRelation = new ChatGroupRelation();
                String initial = temp.getKey();
                chatGroupRelation.setInitial(initial);
                chatGroupRelation.setList(temp.getValue());
                listStream.add(chatGroupRelation);
            }

            jsonResult.setType(listStream);
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            throw new HuhuaminException("聊天群--添加选择联系人", e);
        }
    }


    /**
     * 聊天群--群主踢人或成员退群
     *
     * @param reqSource
     * @param custId
     * @return
     */
    @Transactional
    public JsonResult quitChactGroup(ReqQuitChatGroup reqQuitChatGroup, String custId) {
        try {

            JsonResult jsonResult = new JsonResult();
            jsonResult.setStatusCode(false);

            String groupId=reqQuitChatGroup.getGroupId();
            String menberId=reqQuitChatGroup.getMemberId();

            int existGroupMaterIdNum=chatGroupMapper.existGroupMaterId(groupId,custId);
            if(existGroupMaterIdNum==0){//不是群主
                if(StringUtils.isNotBlank(menberId)) {
                    jsonResult.setMessage("您不是群主不能剔除其他成员");
                    return jsonResult;
                }
            }else {//是群主
                if(custId.equals(menberId)){
                    jsonResult.setMessage("您是群主不能退群只能解散群！");
                    return jsonResult;
                }
                if(StringUtils.isBlank(menberId)){
                    jsonResult.setMessage("群主踢人必须传递用户id！");
                    return jsonResult;
                }
            }

            if(StringUtils.isBlank(menberId)){
                menberId=custId;
            }
            ChatGroupRelation chatGroupRelation=chatGroupRelationMapper.queryCustIdAndNickNameAndStatusByCustId(menberId,groupId);
            if(null==chatGroupRelation){
                jsonResult.setMessage("群成员不存在！");
                return jsonResult;
            }
            int count=chatGroupRelationMapper.delChatGroupRelationByCustIdAndGroupId(groupId, menberId);
            if(1==count){
                List<String> memenberIds=new ArrayList<>();
                memenberIds.add(menberId);
                if(RongcloudUtil.quitChatGroup(memenberIds,groupId)){
                    jsonResult.setStatusCode(true);
                    return jsonResult;
                }else {
                    throw new HuhuaminException("聊天群--群主踢人或成员退群第三方操作失败！");
                }

            }else {
                jsonResult.setMessage("聊天群--群主踢人或成员退群失败！");
                return jsonResult;
            }
        } catch (Exception e) {
            String msg = "聊天群--群主踢人或成员退群！";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }


    /**
     * 聊天群--群主解散群
     * @param reqQuitChatGroup
     * @param custId
     * @return
     */
    @Transactional
    public JsonResult dismissChatGroup(ReqQuitChatGroup reqQuitChatGroup, String custId) {
        try {

            JsonResult jsonResult = new JsonResult();
            jsonResult.setStatusCode(false);

            String groupId=reqQuitChatGroup.getGroupId();
            int count=chatGroupMapper.dismissChatGroup(groupId,custId);
            if(1==count){
                if(RongcloudUtil.dismissChatGroup(groupId,custId)){
                    if(chatGroupRelationMapper.delChatGroupRelationByGroupId(groupId)>0){
                        jsonResult.setStatusCode(true);
                        return jsonResult;
                    }else {
                        throw new HuhuaminException("聊天群--群主解散群删除关系失败！");
                    }
                }else {
                    throw new HuhuaminException("聊天群--群主解散群第三方操作失败！");
                }
            }else {
                jsonResult.setMessage("聊天群--群主解散群失败");
                return jsonResult;
            }
        } catch (Exception e) {
            String msg = "聊天群--群主踢人或成员退群！";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }


    /**
     * 聊天群--(群主群主权限）群头像 群名称 群公告
     * @param reqQuitChatGroup
     * @param custId
     * @return
     */
    @Transactional
    public JsonResult updateChatGroupByMasterId(ReqChatGroupUpdateByMaster reqChatGroupUpdateByMaster, String custId) {
        try {
            JsonResult jsonResult = new JsonResult();
            jsonResult.setStatusCode(false);

            String groupName=reqChatGroupUpdateByMaster.getGroupName();
            String groupHeadImg=reqChatGroupUpdateByMaster.getGroupHeadImg();
            String remark=reqChatGroupUpdateByMaster.getRemark();
            if(StringUtils.isBlank(groupName)&&StringUtils.isBlank(groupHeadImg)&&StringUtils.isBlank(remark)){
                jsonResult.setMessage("群名称，群头像，群公告必须有一个不为空！");
                return jsonResult;
            }
            String groupId=reqChatGroupUpdateByMaster.getGroupId();
            int count=chatGroupMapper.existGroupMaterId(groupId,custId);
            if(count==1){
                ChatGroup chatGroup =new ChatGroup();
                chatGroup.setGroupName(groupName);
                chatGroup.setGroupHeadImg(groupHeadImg);
                chatGroup.setRemark(remark);
                chatGroup.setGroupId(groupId);
                chatGroup.setGroupMasterId(custId);

                count=chatGroupMapper.updateChatGroupByMasterIdAndGroupId(chatGroup);
                if (count==1){
                    if(StringUtils.isNotBlank(groupName)){
                        if(RongcloudUtil.refreshChatGroup(groupId,groupName)){
                            jsonResult.setStatusCode(true);
                            return jsonResult;
                        }else {
                            throw new HuhuaminException("聊天群--(群主群主权限）群头像 群名称 群公告 第三方操作失败！");
                        }
                    }else {
                        jsonResult.setStatusCode(true);
                        return jsonResult;
                    }
                }else {
                    jsonResult.setMessage("聊天群--(群主群主权限）群头像 群名称 群公告 失败！");
                    return jsonResult;
                }
            }else {
                jsonResult.setMessage("您不是群主，没有该权限！");
                return jsonResult;
            }

        } catch (Exception e) {
            String msg = "聊天群--群主踢人或成员退群！";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }


    /**
     * 聊天群--群成员列表
     * @param reqSource
     * @param custId
     * @return
     */
    public   TypeJsonResult<List<ChatGroupRelation>> chatGroupMembersByGroupId(ReqChatGroupDatail reqSource, String custId) {
        try {
            TypeJsonResult<List<ChatGroupRelation>> jsonResult = new TypeJsonResult();
            jsonResult.setStatusCode(false);

            String chatGroupId = reqSource.getGroupId();
            List<ChatGroupRelation> chatGroupRelations = chatGroupRelationMapper.queryChatGroupMembersByGroupId(chatGroupId);

            for (ChatGroupRelation chatGroupRelation : chatGroupRelations) {
                if (StringUtils.isNotBlank(chatGroupRelation.getNickName())) {
                    chatGroupRelation.setInitial(KTestpinyinUtils.getPYIndexStr(chatGroupRelation.getNickName().substring(0, 1), true).toUpperCase());
                }
            }

            Map<String, List<ChatGroupRelation>> mapStream = new HashMap<>();
            chatGroupRelations.stream().forEach(t -> {
                String initial = t.getInitial();
                if (mapStream.containsKey(initial)) {
                    mapStream.get(initial).add(t);
                } else {
                    List<ChatGroupRelation> tlist = new ArrayList<ChatGroupRelation>();
                    tlist.add(t);
                    mapStream.put(initial, tlist);
                }
            });

            List<ChatGroupRelation> listStream = new ArrayList();
            for (Map.Entry<String, List<ChatGroupRelation>> temp : mapStream.entrySet()) {
                ChatGroupRelation chatGroupRelation = new ChatGroupRelation();
                String initial = temp.getKey();
                chatGroupRelation.setInitial(initial);
                chatGroupRelation.setList(temp.getValue());
                listStream.add(chatGroupRelation);
            }

            jsonResult.setType(listStream);
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            throw new HuhuaminException("聊天群--添加选择联系人", e);
        }
    }


    /**
     * 查询好友关系是否存在
     * @param custId
     * @param friendId
     * @return
     */
    public JsonResult existChatRelation(String custId, String friendId) {
        try {

            JsonResult  jsonResult=new JsonResult(false);
            if(1==chatMapper.existChatRelation(custId,friendId)){
                jsonResult.setStatusCode(true);
            }else {
                jsonResult.setMessage("好友关系不存！");
            }
            return  jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            } else {
                throw new HuhuaminException("查询好友关系是否存在" + e.getMessage());
            }
        }
    }


    /**
     * 整理好友列表数据
     * @param jsonResult
     * @param list
     * @return
     */
    public TypeJsonResult<List<RespChatGroup>> conversionChatData(TypeJsonResult<List<RespChatGroup>> jsonResult  ,List<Chat> list ) {

            for (Chat chat : list) {
                if (StringUtils.isNotBlank(chat.getNickName())) {
                    chat.setInitial(KTestpinyinUtils.getPYIndexStr(chat.getNickName().substring(0, 1), true).toUpperCase());
                }
            }
            Map<String, List<Chat>> mapStream = new HashMap<>();
            list.stream().forEach(t -> {
                String initial = t.getInitial();
                if (mapStream.containsKey(initial)) {
                    mapStream.get(initial).add(t);
                } else {
                    List<Chat> tlist = new ArrayList<Chat>();
                    tlist.add(t);
                    mapStream.put(initial, tlist);
                }
            });
            List<RespChatGroup> listStream = new ArrayList();
            for (Map.Entry<String, List<Chat>> temp : mapStream.entrySet()) {
                RespChatGroup chatGroup = new RespChatGroup();
                String initial = temp.getKey();
                chatGroup.setInitial(initial);
                chatGroup.setList(temp.getValue());
                listStream.add(chatGroup);
            }
            jsonResult.setType(listStream);
            return jsonResult;

    }

}
