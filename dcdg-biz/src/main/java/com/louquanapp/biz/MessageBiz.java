package com.louquanapp.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.dao.mapper.CustomerMapper;
import com.louquanapp.dao.mapper.MessageMapper;
import com.louquanapp.dao.model.Message;
import com.louquanapp.model.PageJsonResult;
import com.louquanapp.model.ReqForPageInfo;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqCommPage;
import com.louquanapp.req.ReqMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/11 10:57
 * @description:
 */
@Service
public class MessageBiz {
    private final MessageMapper messageMapper;
    private final CustomerMapper customerMapper;


    public MessageBiz(MessageMapper messageMapper, CustomerMapper customerMapper) {
        this.messageMapper = messageMapper;
        this.customerMapper = customerMapper;
    }

    /**
     * 根据 RELEASE_STATUS=1 前30条 消息查询
     *
     * @return
     */
    public TypeJsonResult<List<Message>> messages() {
        try {

            TypeJsonResult<List<Message>> basicMessages = new TypeJsonResult<>();

            List<Message> messageList = messageMapper.messages();
            basicMessages.setStatusCode(true);
            basicMessages.setType(messageList);
            return basicMessages;
        } catch (Exception e) {
            String msg = "消息查询";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException(msg + e.getMessage(), e);
            }
        }
    }


    /**
     * 根据 RELEASE_STATUS=1 消息查询--分页
     *
     * @return
     */
    public PageJsonResult<Message> messagesPage(ReqCommPage reqCommPage) {
        try {

            TypeJsonResult<Message> basicMessages = new TypeJsonResult<>();
            ReqForPageInfo reqForPageInfo=new  ReqForPageInfo (reqCommPage.getPageNum(),reqCommPage.getPageSize());
            List<Message> list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(),"ADD_TIME DESC, MESSAGE_ORDER DESC").doSelectPage(() -> messageMapper
                    .messagesPage());

            PageInfo<Message> page = new PageInfo<Message>(list);
            PageJsonResult<Message> pageJsonResult = new PageJsonResult<Message>(page);

            return  pageJsonResult;
        } catch (Exception e) {
            String msg = "消息查询";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                throw new HuhuaminException(msg + e.getMessage(), e);
            }
        }
    }


    /**
     * 添加消息
     * @param reqMessage
     * @param custId
     * @return
     */
    public JsonResult saveMessageSelective(ReqMessage reqMessage, String custId) {
        try {

            JsonResult jsonResult=new JsonResult(false);
            Message message =new Message();

            BeanUtils.copyProperties(reqMessage, message);
            message.setMessageId(UUIDUtils.genertateUuid32());
            message.setReleaseStatus((byte)1);//状态[1-启用 2-禁止]
            message.setAddTime(new Date());
            message.setAddUser(custId);
            message.setAddUserName(customerMapper.getNickNameMapByCustId(custId));
            message.setMessageTitle(message.getMessageContent());
            if(reqMessage.getMessageLimitTime()==null){
                //设置到期时间
                Calendar calendar = Calendar.getInstance();
                calendar.set(2099,7,1);
                message.setMessageLimitTime(calendar.getTime());
            }

            int count=messageMapper.insertSelective(message);
            if(count==1){
                jsonResult.setStatusCode(true);
            }else {
                jsonResult.setStatusCode(false);
                jsonResult.setMessage("添加消息失败");
            }

            return  jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            } else {
                throw new HuhuaminException("查询商品评论信息" + e.getMessage());
            }
        }
    }
}
