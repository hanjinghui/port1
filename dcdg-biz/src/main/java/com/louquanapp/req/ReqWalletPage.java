package com.louquanapp.req;


import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotNull;


/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/8/29 17:09
 * @description:
 */
public class ReqWalletPage extends ReqTokenPage {

    /**
     * 金额类型[1-积分 2-余额 3-全部]
     */
    @NotNull(message = "金额类型不能为空！")
    @Range(min = 1,max = 3,message = "金额类型范围金额类型[1-积分 2-余额 3-全部]")
    private Byte valueType;

    /**
     * 筛选条件
     */
    @NotNull(message = "筛选条件不能为空！")
    @Range(min = 1,max = 3,message = "筛选条件范围金额类型[1-增加 2-扣除 3-全部]")
    private Byte addOrSubType;

    public Byte getValueType() {
        return valueType;
    }

    public void setValueType(Byte valueType) {
        this.valueType = valueType;
    }

    public Byte getAddOrSubType() {
        return addOrSubType;
    }

    public void setAddOrSubType(Byte addOrSubType) {
        this.addOrSubType = addOrSubType;
    }
}
