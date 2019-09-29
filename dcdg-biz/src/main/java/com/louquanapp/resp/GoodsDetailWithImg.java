package com.louquanapp.resp;

import com.louquanapp.dao.model.GoodsDetail;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/7/9 上午10:58
 */
public class GoodsDetailWithImg extends GoodsDetail {
    /**
     * 图片路径
     * <p>
     * 数据库字段名:CXY_GOODS_GOODS_IMAGES.IMG_URL
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String imgUrl;


    /**
     * 标题（详情类型为0时，不能为空）
     * <p>
     * 数据库字段名:CXY_GOODS_GOODS_DETAIL.DETAIL_TITLE
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String detailTitle;

    /**
     * 图片描述
     * <p>
     * 数据库字段名:CXY_GOODS_GOODS_DETAIL.DETAIL_DESC
     *
     * @mbg.generated 2019年04月11日21:21:09
     */
    private String detailDesc;

    /**
     * 数据库字段：图片路径CXY_GOODS_GOODS_IMAGES.IMG_URL
     *
     * @return the value of CXY_GOODS_GOODS_IMAGES.IMG_URL
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 数据库字段：图片路径CXY_GOODS_GOODS_IMAGES.IMG_URL
     *
     * @param imgUrl the value for CXY_GOODS_GOODS_IMAGES.IMG_URL
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }


    /**
     * 数据库字段：标题（详情类型为0时，不能为空）CXY_GOODS_GOODS_DETAIL.DETAIL_TITLE
     *
     * @return the value of CXY_GOODS_GOODS_DETAIL.DETAIL_TITLE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getDetailTitle() {
        return detailTitle;
    }

    /**
     * 数据库字段：标题（详情类型为0时，不能为空）CXY_GOODS_GOODS_DETAIL.DETAIL_TITLE
     *
     * @param detailTitle the value for CXY_GOODS_GOODS_DETAIL.DETAIL_TITLE
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle == null ? null : detailTitle.trim();
    }

    /**
     * 数据库字段：图片描述CXY_GOODS_GOODS_DETAIL.DETAIL_DESC
     *
     * @return the value of CXY_GOODS_GOODS_DETAIL.DETAIL_DESC
     * @mbg.generated 2019年04月11日21:21:09
     */
    public String getDetailDesc() {
        return detailDesc;
    }

    /**
     * 数据库字段：图片描述CXY_GOODS_GOODS_DETAIL.DETAIL_DESC
     *
     * @param detailDesc the value for CXY_GOODS_GOODS_DETAIL.DETAIL_DESC
     * @mbg.generated 2019年04月11日21:21:09
     */
    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc == null ? null : detailDesc.trim();
    }
}
