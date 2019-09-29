package com.louquanapp.dao.model;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_goods_goods_images
 *
 * @mbg.generated do_not_delete_during_merge Wed Apr 03 08:11:15 CST 2019
 */
public class GoodsImages {
    /**
     * 主键
     * <p>
     * 数据库字段名:dcdg_goods_goods_images.IMG_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String imgId;

    /**
     * 资源ID
     * <p>
     * 数据库字段名:dcdg_goods_goods_images.SOURCE_ID
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String sourceId;

    /**
     * 资源来源[1-商品 2-团购商品 3-团购评论 5-商品促销轮播图 6-商品详情]
     * <p>
     * 数据库字段名:dcdg_goods_goods_images.SOURCE_TYPE
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Byte sourceType;

    /**
     * 图片路径
     * <p>
     * 数据库字段名:dcdg_goods_goods_images.IMG_URL
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String imgUrl;

    /**
     * 图片大小
     * <p>
     * 数据库字段名:dcdg_goods_goods_images.IMG_SIZE
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Integer imgSize;

    /**
     * 排序
     * <p>
     * 数据库字段名:dcdg_goods_goods_images.ORDER_BY
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Integer orderBy;

    /**
     * 创建人
     * <p>
     * 数据库字段名:dcdg_goods_goods_images.ADD_BY
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String addBy;

    /**
     * 创建时间
     * <p>
     * 数据库字段名:dcdg_goods_goods_images.ADD_TIME
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private Date addTime;

    /**
     * 图片原文件名
     * <p>
     * 数据库字段名:dcdg_goods_goods_images.ORIGINAL_NAME
     *
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    private String originalName;

    /**
     * 数据库字段：主键dcdg_goods_goods_images.IMG_ID
     *
     * @return the value of dcdg_goods_goods_images.IMG_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getImgId() {
        return imgId;
    }

    /**
     * 数据库字段：主键dcdg_goods_goods_images.IMG_ID
     *
     * @param imgId the value for dcdg_goods_goods_images.IMG_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setImgId(String imgId) {
        this.imgId = imgId == null ? null : imgId.trim();
    }

    /**
     * 数据库字段：资源IDdcdg_goods_goods_images.SOURCE_ID
     *
     * @return the value of dcdg_goods_goods_images.SOURCE_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * 数据库字段：资源IDdcdg_goods_goods_images.SOURCE_ID
     *
     * @param sourceId the value for dcdg_goods_goods_images.SOURCE_ID
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    /**
     * 数据库字段：资源来源[1-商品 2-团购商品 3-团购评论 5-商品促销轮播图 6-商品详情]dcdg_goods_goods_images.SOURCE_TYPE
     *
     * @return the value of dcdg_goods_goods_images.SOURCE_TYPE
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Byte getSourceType() {
        return sourceType;
    }

    /**
     * 数据库字段：资源来源[1-商品 2-团购商品 3-团购评论 5-商品促销轮播图 6-商品详情]dcdg_goods_goods_images.SOURCE_TYPE
     *
     * @param sourceType the value for dcdg_goods_goods_images.SOURCE_TYPE
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setSourceType(Byte sourceType) {
        this.sourceType = sourceType;
    }

    /**
     * 数据库字段：图片路径dcdg_goods_goods_images.IMG_URL
     *
     * @return the value of dcdg_goods_goods_images.IMG_URL
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 数据库字段：图片路径dcdg_goods_goods_images.IMG_URL
     *
     * @param imgUrl the value for dcdg_goods_goods_images.IMG_URL
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 数据库字段：图片大小dcdg_goods_goods_images.IMG_SIZE
     *
     * @return the value of dcdg_goods_goods_images.IMG_SIZE
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Integer getImgSize() {
        return imgSize;
    }

    /**
     * 数据库字段：图片大小dcdg_goods_goods_images.IMG_SIZE
     *
     * @param imgSize the value for dcdg_goods_goods_images.IMG_SIZE
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setImgSize(Integer imgSize) {
        this.imgSize = imgSize;
    }

    /**
     * 数据库字段：排序dcdg_goods_goods_images.ORDER_BY
     *
     * @return the value of dcdg_goods_goods_images.ORDER_BY
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Integer getOrderBy() {
        return orderBy;
    }

    /**
     * 数据库字段：排序dcdg_goods_goods_images.ORDER_BY
     *
     * @param orderBy the value for dcdg_goods_goods_images.ORDER_BY
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * 数据库字段：创建人dcdg_goods_goods_images.ADD_BY
     *
     * @return the value of dcdg_goods_goods_images.ADD_BY
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getAddBy() {
        return addBy;
    }

    /**
     * 数据库字段：创建人dcdg_goods_goods_images.ADD_BY
     *
     * @param addBy the value for dcdg_goods_goods_images.ADD_BY
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setAddBy(String addBy) {
        this.addBy = addBy == null ? null : addBy.trim();
    }

    /**
     * 数据库字段：创建时间dcdg_goods_goods_images.ADD_TIME
     *
     * @return the value of dcdg_goods_goods_images.ADD_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：创建时间dcdg_goods_goods_images.ADD_TIME
     *
     * @param addTime the value for dcdg_goods_goods_images.ADD_TIME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：图片原文件名dcdg_goods_goods_images.ORIGINAL_NAME
     *
     * @return the value of dcdg_goods_goods_images.ORIGINAL_NAME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public String getOriginalName() {
        return originalName;
    }

    /**
     * 数据库字段：图片原文件名dcdg_goods_goods_images.ORIGINAL_NAME
     *
     * @param originalName the value for dcdg_goods_goods_images.ORIGINAL_NAME
     * @mbg.generated Wed Apr 03 08:11:15 CST 2019
     */
    public void setOriginalName(String originalName) {
        this.originalName = originalName == null ? null : originalName.trim();
    }
}