package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/9 08:25
 * @Description:
 */
public class ReqPayOrder extends ReqToken {

    /**
     * 支付类型[1-支付宝 2-微信 3-余额支付 4-纯积分]
     * <p>
     * 数据库字段名:english_bussiness_customer_order.PAY_TYPE
     *
     * @mbg.generated Tue Oct 16 15:51:03 CST 2018
     */
    @NotNull(message = "支付类型不能为空")
    @Range(min = 1, max = 4, message = "支付类型[1-支付宝 2-微信]")
    private Byte payType;

    @NotEmpty(message = "订单号不能为空")
    private String orderIds;
    /**
     * 抵扣积分
     */
    private Double deductionPoint;



    private String payPwd;

    public String getPayPwd() {
        return payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd;
    }

    public Double getDeductionPoint() {
        return deductionPoint;
    }

    public void setDeductionPoint(Double deductionPoint) {
        this.deductionPoint = deductionPoint;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public String getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(String orderIds) {
        this.orderIds = orderIds;
    }
}
