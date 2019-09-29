package com.louquanapp.req;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/7/18 下午3:27
 */
public class ReqDoMeishiOrder extends ReqToken {


    @NotEmpty(message = "viddeo不能为空")
    private String videoId;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }



    //    /**
//     * 支付类型[1-支付宝 2-微信 3-余额支付 4-纯积分]
//     * <p>
//     * 数据库字段名:english_bussiness_customer_order.PAY_TYPE
//     *
//     * @mbg.generated Tue Oct 16 15:51:03 CST 2018
//     */
//    @NotNull(message = "支付类型不能为空")
//    @Range(min = 1, max = 4, message = "支付类型[1-支付宝 2-微信]")
//    private Byte payType;
//
//
//    public Byte getPayType() {
//        return payType;
//    }
//
//    public void setPayType(Byte payType) {
//        this.payType = payType;
//    }

    /**
     * 商品ID
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.GOODS_ID
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    @NotEmpty(message = "商品id不能为空")
    private String goodsIds;
    /**
     * /**
     * 购买数量
     * <p>
     * 数据库字段名:dcdg_bussiness_order_item.GOODS_NUM
     *
     * @mbg.generated Mon Apr 08 15:18:24 CST 2019
     */
    @NotEmpty(message = "商品数量不能为空")
    private String goodsNum;

    public String getGoodsIds() {
        return goodsIds;
    }

    public void setGoodsIds(String goodsIds) {
        this.goodsIds = goodsIds;
    }


    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }
}
