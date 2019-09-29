package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/8/16 9:57
 * @description:
 */
public class ReqVideoPlanList  extends ReqTokenPage {
    /**
     * 操作方式[1-待确认 2-待使用 3-已完成 4-全部]
     */
    @NotNull(message = "操作方式不能为空！")
    @Range(min = 1,max = 4,message = "操作方式范围[1-待确认 2-待使用 3-已完成 4-全部]")
    private  Byte planStatus;

    public Byte getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(Byte planStatus) {
        this.planStatus = planStatus;
    }
}
