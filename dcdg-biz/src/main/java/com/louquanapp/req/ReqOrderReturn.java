package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/10 9:35
 * @description:
 */
public class ReqOrderReturn extends ReqToken {

    private String returnId;

    public String getReturnId() {
        return returnId;
    }

    public void setReturnId(String returnId) {
        this.returnId = returnId;
    }

    /**
     * 子订单id
     */
    @NotNull(message = "子订单id不能为空！")
    private String childId;
    /**
     * 退货原因
     */
    @NotNull(message = "退货原因不能为空！")
    private String returnCont;
    /**
     * 上传凭证
     */
    private String returnImg;
    /**
     * 服务类型[1-仅退款 2-退货退款]
     */
    @NotNull(message = "服务类型[不能为空！")
    @Range(min = 1, max = 2, message = "服务类型 数据范围1到2！")
    private Byte serverStatus;

    /**
     * 货物状态[1-待发货 2-待收货 3-已收货]
     * <p>
     * 数据库字段名:dcdg_bussiness_order_return.GOOD_STATUS
     *
     * @mbg.generated Wed Apr 10 09:33:56 CST 2019
     */
    @NotNull(message = "货物状态[不能为空！")
    @Range(min = 1, max = 3, message = "货物状态数据范围1到3！")
    private Byte goodStatus;

    /**
     * 退货说明
     */
    private String remark;


    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }

    public String getReturnCont() {
        return returnCont;
    }

    public void setReturnCont(String returnCont) {
        this.returnCont = returnCont;
    }

    public String getReturnImg() {
        return returnImg;
    }

    public void setReturnImg(String returnImg) {
        this.returnImg = returnImg;
    }

    public Byte getServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(Byte serverStatus) {
        this.serverStatus = serverStatus;
    }


    public Byte getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(Byte goodStatus) {
        this.goodStatus = goodStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
