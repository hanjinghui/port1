package com.louquanapp.utils;

import io.rong.RongCloud;
import io.rong.messages.TxtMessage;
import io.rong.methods.group.Group;
import io.rong.methods.message.system.MsgSystem;
import io.rong.models.Result;
import io.rong.models.group.GroupMember;
import io.rong.models.group.GroupModel;
import io.rong.models.group.UserGroup;
import io.rong.models.message.SystemMessage;
import io.rong.models.response.GroupUserQueryResult;
import io.rong.models.response.ResponseResult;

import java.util.List;
import java.util.Map;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/19 16:34
 * @description: 融云推送消息
 */
public class RongcloudUtil {
    /**
     * 此处替换成您的appKey
     */
    private static final String appKey = "mgb7ka1nm4bog";
    /**
     * 此处替换成您的appSecret
     */
    private static final String appSecret = "oiLMIiFgfMcLg";

    /**
     * 自定义api地址
     */
    private static final String api = "http://api.cn.ronghub.com";

    private static final RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
    private static final Group group = rongCloud.group;

    /**
     * 系统推送消息
     *
     * @param targetIds
     * @param txtMessage
     * @return
     */
    public static Boolean sendSystemMessage(String[] targetIds, TxtMessage txtMessage) {
        Boolean flay = false;
        try {

            MsgSystem system = rongCloud.message.system;
            SystemMessage systemMessage = new SystemMessage()
                    .setSenderId("system")
                    .setTargetId(targetIds)
                    .setObjectName(txtMessage.getType())
                    .setContent(txtMessage)
                    .setIsPersisted(0)
                    .setIsCounted(0)
                    .setContentAvailable(0);
            ResponseResult result = system.send(systemMessage);
            if (200 == result.code) {
                flay = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flay;
    }
    public static Boolean  sendPlaninfo (String targetId
            ,String shopLogo,String shopName,String context) {


        String[] targetIds = {targetId};
        String extra="{\"shopLogo\":\""+shopLogo+"\",\"shopName\":\""+shopName+"\",\"context\":\""+context+"\"}";

        TxtMessage txtMessage = new TxtMessage(extra,"");


        Boolean flay = false;
        try {

            MsgSystem system = rongCloud.message.system;
            SystemMessage systemMessage = new SystemMessage()
                    .setSenderId("planinfo")
                    .setTargetId(targetIds)
                    .setObjectName(txtMessage.getType())
                    .setContent(txtMessage)
                    .setIsPersisted(0)
                    .setIsCounted(0)
                    .setContentAvailable(0);
            ResponseResult result = system.send(systemMessage);
            if (200 == result.code) {
                flay = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flay;
    }
    /**
     * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/group/group.html#create
     * <p>
     * 创建群组方法
     */
    public static Boolean addChatGroup(List<String> custIdList, String groupId, String groupName) throws Exception {

        GroupMember[] members = new GroupMember[custIdList.size()];
        for (int i = 0; i < custIdList.size(); i++) {
            members[i] = new GroupMember().setId(custIdList.get(i));
        }

        GroupModel groupModel = new GroupModel()
                .setId(groupId)
                .setMembers(members)
                .setName(groupName);

        Result groupCreateResult = (Result) group.create(groupModel);
        System.out.println("group create result:  " + groupCreateResult.toString());
        if (200 == groupCreateResult.code) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/group/group.html#sync
     * <p>
     * 同步用户所属群组方法
     */
    public static Boolean syncChatGroup(List<Map<String, Object>> chatGroupList, String custId) throws Exception {
        GroupModel[] groups = new GroupModel[chatGroupList.size()];

        for (int i = 0; i < chatGroupList.size(); i++) {
            groups[i] = new GroupModel().setId(chatGroupList.get(i).get("groupId").toString()).setName(chatGroupList.get(i).get("groupName").toString());
        }
        UserGroup user = new UserGroup()
                .setId(custId)
                .setGroups(groups);

        Result syncResult = (Result) group.sync(user);
        System.out.println("group sync:  " + syncResult.toString());
        if (200 == syncResult.code) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/group/group.html#refresh
     * 刷新群组信息方法
     */
    //GroupMember[] members = {new GroupMember().setId("ghJiu7H1"),new GroupMember().setId("ghJiu7H2")};
    public static Boolean refreshChatGroup(String groupId, String groupName) throws Exception {
        GroupModel groupModel = new GroupModel()
                .setId(groupId)
                .setName(groupName);
        Result refreshResult = (Result) group.update(groupModel);
        System.out.println("refresh:  " + refreshResult.toString());

        if (200 == refreshResult.code) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/group/group.html#join
     * <p>
     * 邀请用户加入群组
     */
    public static Boolean inviteChatGroup(List<String> custIdList, String groupId, String groupName) throws Exception {

        GroupMember[] members = new GroupMember[custIdList.size()];
        for (int i = 0; i < custIdList.size(); i++) {
            members[i] = new GroupMember().setId(custIdList.get(i));
        }

        GroupModel groupModel = new GroupModel()
                .setId(groupId)
                .setMembers(members)
                .setName(groupName);
        Result groupInviteResult = (Result) group.invite(groupModel);
        System.out.println("invite:  " + groupInviteResult.toString());
        if (200 == groupInviteResult.code) {
            return true;
        } else {
            return false;
        }

    }


    /**
     * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/group/group.html#join
     * <p>
     * 用户加入指定群组
     */
    public static Boolean joinChatGroup(List<String> custIdList, String groupId, String groupName) throws Exception {

        GroupMember[] members = new GroupMember[custIdList.size()];
        for (int i = 0; i < custIdList.size(); i++) {
            members[i] = new GroupMember().setId(custIdList.get(i));
        }

        GroupModel groupModel = new GroupModel()
                .setId(groupId)
                .setMembers(members)
                .setName(groupName);
        Result groupJoinResult = (Result) group.join(groupModel);
        System.out.println("join:  " + groupJoinResult.toString());
        if (200 == groupJoinResult.code) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/group/group.html#getMembers
     * <p>
     * 查询群成员方法
     */
    public static Boolean getChatGroupMembere(String groupId) throws Exception {

        GroupModel groupModel = new GroupModel().setId(groupId);
        GroupUserQueryResult getMemberesult = group.get(groupModel);
        System.out.println("group getMember:  " + getMemberesult.toString());
        if (200 == getMemberesult.code) {
            return true;
        } else {
            return false;
        }

    }

    /**
     *  * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/group/group.html#quit
     * 退出群组
     * @param custIdList
     * @param groupId
     * @return
     * @throws Exception
     */
    public static Boolean quitChatGroup(List<String> custIdList, String groupId) throws Exception {

        GroupMember[] members = new GroupMember[custIdList.size()];
        for (int i = 0; i < custIdList.size(); i++) {
            members[i] = new GroupMember().setId(custIdList.get(i));
        }
        GroupModel groupModel = new GroupModel()
                .setId(groupId)
                .setMembers(members);
        Result groupQuitResult = (Result) group.quit(groupModel);
        System.out.println("quit:  " + groupQuitResult.toString());
        if (200 == groupQuitResult.code) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/group/group.html#dismiss
     * <p>
     * 解散群组
     */
    public static Boolean dismissChatGroup(String groupId, String custId) throws Exception {

        GroupMember[] members = new GroupMember[]{new GroupMember().setId(custId)};

        GroupModel groupModel = new GroupModel()
                .setId(groupId)
                .setMembers(members);
        Result groupDismissResult = (Result) group.dismiss(groupModel);
        System.out.println("dismiss:  " + groupDismissResult.toString());
        if (200 == groupDismissResult.code) {
            return true;
        } else {
            return false;
        }

    }
}
