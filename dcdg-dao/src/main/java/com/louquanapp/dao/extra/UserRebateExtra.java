package com.louquanapp.dao.extra;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/8/21 9:56
 * @description:
 */
public class UserRebateExtra {
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像
     */
    private String headImg;
    /**
     * 用户数量
     */
    private Integer custCount;
    /**
     * 操作方式[0-全部 1至12-1至12月份
     */
    private Byte isTotal;
    /**
     * 返利费用
     */
    private Double rebateCost;
    /**
     * 是否满足数量[1-未满足 2-已满足]
     */
    private Byte isNum;

    public Byte getIsNum() {
        return isNum;
    }

    public void setIsNum(Byte isNum) {
        this.isNum = isNum;
    }

    public Double getRebateCost() {
        return rebateCost;
    }

    public void setRebateCost(Double rebateCost) {
        this.rebateCost = rebateCost;
    }

    public Byte getIsTotal() {
        return isTotal;
    }

    public void setIsTotal(Byte isTotal) {
        this.isTotal = isTotal;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getCustCount() {
        return custCount;
    }

    public void setCustCount(Integer custCount) {
        this.custCount = custCount;
    }
}
