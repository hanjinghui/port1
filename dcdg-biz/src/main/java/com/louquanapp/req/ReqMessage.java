package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * 消息
 */
public class ReqMessage {

    /**
     * 平台token
     */
    @NotBlank(message = "token不能为空")
    private String token;

    @NotBlank(message = "消息内容不能为空")
    private String messageContent;
    /**
     * 消息类型[
     * 1-用户参与拼手气抢红包游戏，游戏结束后，系统通知抢到2元以上红包的用户
     * 2-用户通过玩某一款游戏， 显示第一个完成所有任务的用户
     * 3-用户在商城用积分成功兑换商品扣掉积分之后
     * 4-平台维护升级时候的系统通知
     * 5-新游戏上线，成功添加新游戏到APP之后
     * 6-举行游戏比赛，确定游戏比赛时间的时候
     * 7-抢红包游戏时间确定的时候消息公布
     * ]
     *
     */
    @NotNull(message = "消息类型不能为空")
    @Range(min = 1, max = 7, message = "消息类型范围是1-7")
    private Integer messageType;

    /**
     * 到期时间
     */
    private Date messageLimitTime;


    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public Date getMessageLimitTime() {
        return messageLimitTime;
    }

    public void setMessageLimitTime(Date messageLimitTime) {
        this.messageLimitTime = messageLimitTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
