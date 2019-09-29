package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.GoodsDetailExtra;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_goods_goods_detail
 *
 * @mbg.generated do_not_delete_during_merge Wed Apr 03 08:11:15 CST 2019
 */
public class GoodsDetail extends GoodsDetailExtra {
    /**
     * 主键
     * <p>
     * 数据库字段名:dcdg_goods_goods_detail.DETAIL_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String detailId;

    /**
     * 商品ID
     * <p>
     * 数据库字段名:dcdg_goods_goods_detail.GOODS_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String goodsId;

    /**
     * 详情类型[1-尺码说明 2-穿着效果 3-整体款式 4-细节做工 5-产品介绍 6-品牌介绍 7-包装展示 8-服务说明 9-资质证明 10-店铺信息 0-自定义模块]
     * <p>
     * 数据库字段名:dcdg_goods_goods_detail.DETAIL_TYPE
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Byte detailType;

    /**
     * 标题（详情类型为0时，不能为空）
     * <p>
     * 数据库字段名:dcdg_goods_goods_detail.DETAIL_TITLE
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String detailTitle;

    /**
     * 规格图片
     * <p>
     * 数据库字段名:dcdg_goods_goods_detail.DETAIL_PIC
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String detailPic;

    /**
     * 创建时间
     * <p>
     * 数据库字段名:dcdg_goods_goods_detail.ADD_TIME
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Date addTime;

    /**
     * 图片描述
     * <p>
     * 数据库字段名:dcdg_goods_goods_detail.DETAIL_DESC
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String detailDesc;

    /**
     * 数据库字段：主键dcdg_goods_goods_detail.DETAIL_ID
     *
     * @return the value of dcdg_goods_goods_detail.DETAIL_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getDetailId() {
        return detailId;
    }

    /**
     * 数据库字段：主键dcdg_goods_goods_detail.DETAIL_ID
     *
     * @param detailId the value for dcdg_goods_goods_detail.DETAIL_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setDetailId(String detailId) {
        this.detailId = detailId == null ? null : detailId.trim();
    }

    /**
     * 数据库字段：商品IDdcdg_goods_goods_detail.GOODS_ID
     *
     * @return the value of dcdg_goods_goods_detail.GOODS_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 数据库字段：商品IDdcdg_goods_goods_detail.GOODS_ID
     *
     * @param goodsId the value for dcdg_goods_goods_detail.GOODS_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * 数据库字段：详情类型[1-尺码说明 2-穿着效果 3-整体款式 4-细节做工 5-产品介绍 6-品牌介绍 7-包装展示 8-服务说明 9-资质证明 10-店铺信息 0-自定义模块]dcdg_goods_goods_detail.DETAIL_TYPE
     *
     * @return the value of dcdg_goods_goods_detail.DETAIL_TYPE
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Byte getDetailType() {
        return detailType;
    }

    /**
     * 数据库字段：详情类型[1-尺码说明 2-穿着效果 3-整体款式 4-细节做工 5-产品介绍 6-品牌介绍 7-包装展示 8-服务说明 9-资质证明 10-店铺信息 0-自定义模块]dcdg_goods_goods_detail.DETAIL_TYPE
     *
     * @param detailType the value for dcdg_goods_goods_detail.DETAIL_TYPE
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setDetailType(Byte detailType) {
        this.detailType = detailType;
    }

    /**
     * 数据库字段：标题（详情类型为0时，不能为空）dcdg_goods_goods_detail.DETAIL_TITLE
     *
     * @return the value of dcdg_goods_goods_detail.DETAIL_TITLE
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getDetailTitle() {
        return detailTitle;
    }

    /**
     * 数据库字段：标题（详情类型为0时，不能为空）dcdg_goods_goods_detail.DETAIL_TITLE
     *
     * @param detailTitle the value for dcdg_goods_goods_detail.DETAIL_TITLE
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle == null ? null : detailTitle.trim();
    }

    /**
     * 数据库字段：规格图片dcdg_goods_goods_detail.DETAIL_PIC
     *
     * @return the value of dcdg_goods_goods_detail.DETAIL_PIC
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getDetailPic() {
        return detailPic;
    }

    /**
     * 数据库字段：规格图片dcdg_goods_goods_detail.DETAIL_PIC
     *
     * @param detailPic the value for dcdg_goods_goods_detail.DETAIL_PIC
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setDetailPic(String detailPic) {
        this.detailPic = detailPic == null ? null : detailPic.trim();
    }

    /**
     * 数据库字段：创建时间dcdg_goods_goods_detail.ADD_TIME
     *
     * @return the value of dcdg_goods_goods_detail.ADD_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：创建时间dcdg_goods_goods_detail.ADD_TIME
     *
     * @param addTime the value for dcdg_goods_goods_detail.ADD_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：图片描述dcdg_goods_goods_detail.DETAIL_DESC
     *
     * @return the value of dcdg_goods_goods_detail.DETAIL_DESC
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getDetailDesc() {
        return detailDesc;
    }

    /**
     * 数据库字段：图片描述dcdg_goods_goods_detail.DETAIL_DESC
     *
     * @param detailDesc the value for dcdg_goods_goods_detail.DETAIL_DESC
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc == null ? null : detailDesc.trim();
    }
}