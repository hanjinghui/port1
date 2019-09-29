package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/6/12 18:03
 * @description:
 */
public class ReqLinkUPAccount extends ReqToken{
    /**
     * 店铺名称
     */
    @NotBlank(message = "店铺名称不能为空")
    private String shopName;
    /**
     * 店铺类型
     */
    @NotNull(message = "店铺类型不能为空")
    @Range(min = 1,max = 2,message = "店铺类型范围[1-产品类 2-服务类]")
    private Byte shopTpe;
    /**
     * 联系人电话
     */
    @NotBlank(message = "联系人电话不能为空")
    @Pattern(regexp = "1[0-9]{10}", message = "联系人手机号格式")
    private String linkPhone;

    /**
     * 店铺联系人
     */
    @NotBlank(message = "店铺联系人不能为空")
    private String linkMan;

    /**
     * 店铺logo
     */
    @NotBlank(message = "店铺logo不能为空")
    private String shopLogo;
    /**
     * 店铺位置
     */
    @NotBlank(message = "店铺位置不能为空")
    private String grps;

    /**
     * 联系人微信号
     */
    @NotBlank(message = "联系人微信号不能为空")
    private String linkWechat;

    /**
     * 所在区域
     */
    @NotBlank(message = "所在区域不能为空")
    private String shopArea;

    /**
     * 详细地址
     */
    @NotBlank(message = "详细地址不能为空")
    private String linkAddr;



    /**
     * 店铺简介
     */
    @NotBlank(message = "店铺简介不能为空")
    private String shopTitle;

    /**
     * 店铺公告
     */
    @NotBlank(message = "店铺公告不能为空")
    private String shopNotice;

    /**
     * 店铺营业时间
     */
    @NotBlank(message = "店铺营业时间不能为空")
    private String shopDesc;

    /**
     * 图片集
     */
    private String shopImgs;

    private String  type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShopImgs() {
        return shopImgs;
    }

    public void setShopImgs(String shopImgs) {
        this.shopImgs = shopImgs;
    }

    public String getShopTitle() {
        return shopTitle;
    }

    public void setShopTitle(String shopTitle) {
        this.shopTitle = shopTitle;
    }

    public String getShopNotice() {
        return shopNotice;
    }

    public void setShopNotice(String shopNotice) {
        this.shopNotice = shopNotice;
    }

    public String getShopDesc() {
        return shopDesc;
    }

    public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Byte getShopTpe() {
        return shopTpe;
    }

    public void setShopTpe(Byte shopTpe) {
        this.shopTpe = shopTpe;
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

    public String getShopLogo() {
        return shopLogo;
    }

    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }

    public String getGrps() {
        return grps;
    }

    public void setGrps(String grps) {
        this.grps = grps;
    }

    public String getLinkWechat() {
        return linkWechat;
    }

    public void setLinkWechat(String linkWechat) {
        this.linkWechat = linkWechat;
    }

    public String getShopArea() {
        return shopArea;
    }

    public void setShopArea(String shopArea) {
        this.shopArea = shopArea;
    }

    public String getLinkAddr() {
        return linkAddr;
    }

    public void setLinkAddr(String linkAddr) {
        this.linkAddr = linkAddr;
    }
}
