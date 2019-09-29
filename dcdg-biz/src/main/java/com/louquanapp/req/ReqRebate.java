package com.louquanapp.req;


import javax.validation.constraints.NotBlank;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/8/23 16:51
 * @description:
 */
public class ReqRebate extends ReqToken {
    /**
     * 当前月
     */
    @NotBlank(message = "月份必须填！")
    private String currentMonth;

    public String getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(String currentMonth) {
        this.currentMonth = currentMonth;
    }
}
