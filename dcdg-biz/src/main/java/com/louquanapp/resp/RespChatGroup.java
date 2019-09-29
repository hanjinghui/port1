package com.louquanapp.resp;

import com.louquanapp.dao.model.Chat;

import java.util.List;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/23 11:13
 * @description:
 */
public class RespChatGroup {
    /**
     * 字母
     */
    private String initial;

    private List<Chat> list;

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public List<Chat> getList() {
        return list;
    }

    public void setList(List<Chat> list) {
        this.list = list;
    }
}
