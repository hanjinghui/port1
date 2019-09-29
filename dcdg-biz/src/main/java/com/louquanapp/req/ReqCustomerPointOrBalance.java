package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 *
 */
public class ReqCustomerPointOrBalance extends ReqTokenPage {
    /**
     * 获得类型
     */
    @NotNull(message = "获得类型不能为空")
    @Range(min = 1, max = 3, message = "获得类型范围[1-获得 2-消费 3-全部]")
    private Byte gainType;

    /**
     * 积分类型
     */
    @NotNull(message = "积分类型不能为空")
    @Range(min = 1, max = 3, message = "积分类型范围[1-余额 3-积分 2-全部]")
    private Byte pointType;

    public Byte getGainType() {
        return gainType;
    }

    public void setGainType(Byte gainType) {
        this.gainType = gainType;
    }

    public Byte getPointType() {
        return pointType;
    }

    public void setPointType(Byte pointType) {
        this.pointType = pointType;
    }
}
