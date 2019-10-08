package com.louquanapp.req;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/6/12 18:03
 * @description:
 */
public class ReqLinkUPAccountAdd extends ReqToken{

    /**
     * 店铺ID
     */
    private String shopId;


    /**
     * 店铺名称
     */
    @NotBlank(message = "店铺名称不能为空！")
    private String shopName;

    /**
     * 账号名称
     */
    @NotBlank(message = "账号名称不能为空！")
    @Pattern(regexp="^[a-zA-Z][a-zA-Z0-9_]{4,18}$",message="账号名称只能为5到20个字母或数字，且开头只能值字母")
    private String account;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空！")
    @Length(min = 4,max =19 )
    private String pwd;

    /**
     * 联系人电话
     */
    @Pattern(regexp = "1[0-9]{10}", message = "联系人手机号格式")
    private String linkPhone;

    /**
     * 店铺联系人
     */
    private String linkMan;

    /**
     * 店铺地址
     */
    @NotBlank(message = "店铺地址不能为空！")
    private String shopAdress;
    /**
     * 所在区域（省市区）
     */
    @NotBlank(message = "所在区域（省市区）不能为空")
    private String shopArea;


    /**
     * GRPS-经纬度
     */
    @NotBlank(message = "GRPS-经纬度不能为空")
    private String grps;
    /**
     * GRPS-地址
     */
    @NotBlank(message = "GRPS-地址不能为空")
    private String grpsAdress;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getGrpsAdress() {
        return grpsAdress;
    }

    public void setGrpsAdress(String grpsAdress) {
        this.grpsAdress = grpsAdress;
    }

    public String getShopArea() {
        return shopArea;
    }

    public void setShopArea(String shopArea) {
        this.shopArea = shopArea;
    }

    public String getGrps() {
        return grps;
    }

    public void setGrps(String grps) {
        this.grps = grps;
    }

    public String getShopAdress() {
        return shopAdress;
    }

    public void setShopAdress(String shopAdress) {
        this.shopAdress = shopAdress;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }
}
