package com.louquanapp.dao.extra;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/9/2 9:39
 * @description:
 */
public class SettlementInfoExtra {
    /**
     * 账号
     */
    private String accountNumber;
    /**
     * 银行ico
     */
    private String bankIco;
    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 数据类型[1-已结算值 2-明细]
     */
    private Byte dataType;

    /**
     * 加减状态[1-加 2-减]
     */
    private Byte addOrSub;

    public Byte getAddOrSub() {
        return addOrSub;
    }

    public void setAddOrSub(Byte addOrSub) {
        this.addOrSub = addOrSub;
    }

    public Byte getDataType() {
        return dataType;
    }

    public void setDataType(Byte dataType) {
        this.dataType = dataType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankIco() {
        return bankIco;
    }

    public void setBankIco(String bankIco) {
        this.bankIco = bankIco;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
