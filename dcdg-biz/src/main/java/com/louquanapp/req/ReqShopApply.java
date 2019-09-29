package com.louquanapp.req;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/6/27 下午4:17
 */


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


/**
 * 登录
 */
public class ReqShopApply extends ReqToken {

    /**
     * 店铺名称
     * <p>
     * 数据库字段名:dcdg_bussiness_shopapply_base.SHOP_NAME
     *
     * @mbg.generated Wed Mar 27 17:40:01 CST 2019
     */
    @NotBlank(message = "店铺名称不能为空")
    private String shopName;

    /**
     * 联系人
     * <p>
     * 数据库字段名:dcdg_bussiness_shopapply_base.LINK_MAN
     *
     * @mbg.generated Wed Mar 27 17:40:01 CST 2019
     */
    @NotBlank(message = "联系人不能为空")
    private String linkMan;

    /**
     * 手机号
     * <p>
     * 数据库字段名:dcdg_bussiness_shopapply_base.LINK_PHONE
     *
     * @mbg.generated Wed Mar 27 17:40:01 CST 2019
     */
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "1[0-9]{10}", message = "手机号格式")
    private String linkPhone;

    /**
     * 详细地址
     * <p>
     * 数据库字段名:dcdg_bussiness_shopapply_base.LINK_ADDR
     *
     * @mbg.generated Wed Mar 27 17:40:01 CST 2019
     */
    @NotBlank(message = "详细地址不能为空")
    private String linkAddr;


    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getLinkAddr() {
        return linkAddr;
    }

    public void setLinkAddr(String linkAddr) {
        this.linkAddr = linkAddr;
    }
}
