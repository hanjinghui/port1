package com.louquanapp.dao.model;

import com.louquanapp.dao.extra.CategoryListExtra;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_goods_category_base
 *
 * @mbg.generated do_not_delete_during_merge Sun Mar 31 21:16:57 CST 2019
 */
public class Category extends CategoryListExtra {
    /**
     * 主键
     * <p>
     * 数据库字段名:dcdg_goods_category_base.CAT_ID
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    private String catId;

    /**
     * 父级ID
     * <p>
     * 数据库字段名:dcdg_goods_category_base.P_ID
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    private String pId;

    /**
     * 分类层级
     * <p>
     * 数据库字段名:dcdg_goods_category_base.CAT_PATH
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    private String catPath;

    /**
     * 分类名称
     * <p>
     * 数据库字段名:dcdg_goods_category_base.CAT_NAME
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    private String catName;

    /**
     * 分类别名
     * <p>
     * 数据库字段名:dcdg_goods_category_base.CAT_ALIAS
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    private String catAlias;

    /**
     * 文字底色
     * <p>
     * 数据库字段名:dcdg_goods_category_base.CAT_COLOR
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    private String catColor;

    /**
     * 是否热门[3-不是 4-热门]
     * <p>
     * 数据库字段名:dcdg_goods_category_base.IS_HOT
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    private Byte isHot;

    /**
     * 缩略图
     * <p>
     * 数据库字段名:dcdg_goods_category_base.CAT_PIC
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    private String catPic;

    /**
     * 推荐[2-否 1-是]
     * <p>
     * 数据库字段名:dcdg_goods_category_base.IS_RECOMMEND
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    private Byte isRecommend;

    /**
     * 排序
     * <p>
     * 数据库字段名:dcdg_goods_category_base.ORDER_BY
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    private Integer orderBy;

    /**
     * 广告图片
     * <p>
     * 数据库字段名:dcdg_goods_category_base.ADV_PIC
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    private String advPic;

    /**
     * 广告链接
     * <p>
     * 数据库字段名:dcdg_goods_category_base.ADV_URL
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    private String advUrl;

    /**
     * SEO标题
     * <p>
     * 数据库字段名:dcdg_goods_category_base.SEO_TITLE
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    private String seoTitle;

    /**
     * SEO关键词
     * <p>
     * 数据库字段名:dcdg_goods_category_base.SEO_KEYWORDS
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    private String seoKeywords;

    /**
     * SEO描述
     * <p>
     * 数据库字段名:dcdg_goods_category_base.SEO_DESC
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    private String seoDesc;

    /**
     * 添加时间
     * <p>
     * 数据库字段名:dcdg_goods_category_base.ADD_TIME
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    private Date addTime;

    /**
     * 上架标识[1-上架 2-下架]
     * <p>
     * 数据库字段名:dcdg_goods_category_base.SALE_FLAG
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    private Byte saleFlag;

    /**
     * 小图标
     * <p>
     * 数据库字段名:dcdg_goods_category_base.LITTLE_IMG
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    private String littleImg;

    /**
     * 分类描述
     * <p>
     * 数据库字段名:dcdg_goods_category_base.CAT_DESC
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    private String catDesc;

    /**
     * 分类详情
     * <p>
     * 数据库字段名:dcdg_goods_category_base.CAT_DETAIL
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    private String catDetail;

    /**
     * 数据库字段：主键dcdg_goods_category_base.CAT_ID
     *
     * @return the value of dcdg_goods_category_base.CAT_ID
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public String getCatId() {
        return catId;
    }

    /**
     * 数据库字段：主键dcdg_goods_category_base.CAT_ID
     *
     * @param catId the value for dcdg_goods_category_base.CAT_ID
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public void setCatId(String catId) {
        this.catId = catId == null ? null : catId.trim();
    }

    /**
     * 数据库字段：父级IDdcdg_goods_category_base.P_ID
     *
     * @return the value of dcdg_goods_category_base.P_ID
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public String getpId() {
        return pId;
    }

    /**
     * 数据库字段：父级IDdcdg_goods_category_base.P_ID
     *
     * @param pId the value for dcdg_goods_category_base.P_ID
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public void setpId(String pId) {
        this.pId = pId == null ? null : pId.trim();
    }

    /**
     * 数据库字段：分类层级dcdg_goods_category_base.CAT_PATH
     *
     * @return the value of dcdg_goods_category_base.CAT_PATH
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public String getCatPath() {
        return catPath;
    }

    /**
     * 数据库字段：分类层级dcdg_goods_category_base.CAT_PATH
     *
     * @param catPath the value for dcdg_goods_category_base.CAT_PATH
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public void setCatPath(String catPath) {
        this.catPath = catPath == null ? null : catPath.trim();
    }

    /**
     * 数据库字段：分类名称dcdg_goods_category_base.CAT_NAME
     *
     * @return the value of dcdg_goods_category_base.CAT_NAME
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public String getCatName() {
        return catName;
    }

    /**
     * 数据库字段：分类名称dcdg_goods_category_base.CAT_NAME
     *
     * @param catName the value for dcdg_goods_category_base.CAT_NAME
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public void setCatName(String catName) {
        this.catName = catName == null ? null : catName.trim();
    }

    /**
     * 数据库字段：分类别名dcdg_goods_category_base.CAT_ALIAS
     *
     * @return the value of dcdg_goods_category_base.CAT_ALIAS
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public String getCatAlias() {
        return catAlias;
    }

    /**
     * 数据库字段：分类别名dcdg_goods_category_base.CAT_ALIAS
     *
     * @param catAlias the value for dcdg_goods_category_base.CAT_ALIAS
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public void setCatAlias(String catAlias) {
        this.catAlias = catAlias == null ? null : catAlias.trim();
    }

    /**
     * 数据库字段：文字底色dcdg_goods_category_base.CAT_COLOR
     *
     * @return the value of dcdg_goods_category_base.CAT_COLOR
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public String getCatColor() {
        return catColor;
    }

    /**
     * 数据库字段：文字底色dcdg_goods_category_base.CAT_COLOR
     *
     * @param catColor the value for dcdg_goods_category_base.CAT_COLOR
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public void setCatColor(String catColor) {
        this.catColor = catColor == null ? null : catColor.trim();
    }

    /**
     * 数据库字段：是否热门[3-不是 4-热门]dcdg_goods_category_base.IS_HOT
     *
     * @return the value of dcdg_goods_category_base.IS_HOT
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public Byte getIsHot() {
        return isHot;
    }

    /**
     * 数据库字段：是否热门[3-不是 4-热门]dcdg_goods_category_base.IS_HOT
     *
     * @param isHot the value for dcdg_goods_category_base.IS_HOT
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public void setIsHot(Byte isHot) {
        this.isHot = isHot;
    }

    /**
     * 数据库字段：缩略图dcdg_goods_category_base.CAT_PIC
     *
     * @return the value of dcdg_goods_category_base.CAT_PIC
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public String getCatPic() {
        return catPic;
    }

    /**
     * 数据库字段：缩略图dcdg_goods_category_base.CAT_PIC
     *
     * @param catPic the value for dcdg_goods_category_base.CAT_PIC
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public void setCatPic(String catPic) {
        this.catPic = catPic == null ? null : catPic.trim();
    }

    /**
     * 数据库字段：推荐[2-否 1-是]dcdg_goods_category_base.IS_RECOMMEND
     *
     * @return the value of dcdg_goods_category_base.IS_RECOMMEND
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public Byte getIsRecommend() {
        return isRecommend;
    }

    /**
     * 数据库字段：推荐[2-否 1-是]dcdg_goods_category_base.IS_RECOMMEND
     *
     * @param isRecommend the value for dcdg_goods_category_base.IS_RECOMMEND
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public void setIsRecommend(Byte isRecommend) {
        this.isRecommend = isRecommend;
    }

    /**
     * 数据库字段：排序dcdg_goods_category_base.ORDER_BY
     *
     * @return the value of dcdg_goods_category_base.ORDER_BY
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public Integer getOrderBy() {
        return orderBy;
    }

    /**
     * 数据库字段：排序dcdg_goods_category_base.ORDER_BY
     *
     * @param orderBy the value for dcdg_goods_category_base.ORDER_BY
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * 数据库字段：广告图片dcdg_goods_category_base.ADV_PIC
     *
     * @return the value of dcdg_goods_category_base.ADV_PIC
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public String getAdvPic() {
        return advPic;
    }

    /**
     * 数据库字段：广告图片dcdg_goods_category_base.ADV_PIC
     *
     * @param advPic the value for dcdg_goods_category_base.ADV_PIC
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public void setAdvPic(String advPic) {
        this.advPic = advPic == null ? null : advPic.trim();
    }

    /**
     * 数据库字段：广告链接dcdg_goods_category_base.ADV_URL
     *
     * @return the value of dcdg_goods_category_base.ADV_URL
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public String getAdvUrl() {
        return advUrl;
    }

    /**
     * 数据库字段：广告链接dcdg_goods_category_base.ADV_URL
     *
     * @param advUrl the value for dcdg_goods_category_base.ADV_URL
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public void setAdvUrl(String advUrl) {
        this.advUrl = advUrl == null ? null : advUrl.trim();
    }

    /**
     * 数据库字段：SEO标题dcdg_goods_category_base.SEO_TITLE
     *
     * @return the value of dcdg_goods_category_base.SEO_TITLE
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public String getSeoTitle() {
        return seoTitle;
    }

    /**
     * 数据库字段：SEO标题dcdg_goods_category_base.SEO_TITLE
     *
     * @param seoTitle the value for dcdg_goods_category_base.SEO_TITLE
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle == null ? null : seoTitle.trim();
    }

    /**
     * 数据库字段：SEO关键词dcdg_goods_category_base.SEO_KEYWORDS
     *
     * @return the value of dcdg_goods_category_base.SEO_KEYWORDS
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public String getSeoKeywords() {
        return seoKeywords;
    }

    /**
     * 数据库字段：SEO关键词dcdg_goods_category_base.SEO_KEYWORDS
     *
     * @param seoKeywords the value for dcdg_goods_category_base.SEO_KEYWORDS
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords == null ? null : seoKeywords.trim();
    }

    /**
     * 数据库字段：SEO描述dcdg_goods_category_base.SEO_DESC
     *
     * @return the value of dcdg_goods_category_base.SEO_DESC
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public String getSeoDesc() {
        return seoDesc;
    }

    /**
     * 数据库字段：SEO描述dcdg_goods_category_base.SEO_DESC
     *
     * @param seoDesc the value for dcdg_goods_category_base.SEO_DESC
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public void setSeoDesc(String seoDesc) {
        this.seoDesc = seoDesc == null ? null : seoDesc.trim();
    }

    /**
     * 数据库字段：添加时间dcdg_goods_category_base.ADD_TIME
     *
     * @return the value of dcdg_goods_category_base.ADD_TIME
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_goods_category_base.ADD_TIME
     *
     * @param addTime the value for dcdg_goods_category_base.ADD_TIME
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：上架标识[1-上架 2-下架]dcdg_goods_category_base.SALE_FLAG
     *
     * @return the value of dcdg_goods_category_base.SALE_FLAG
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public Byte getSaleFlag() {
        return saleFlag;
    }

    /**
     * 数据库字段：上架标识[1-上架 2-下架]dcdg_goods_category_base.SALE_FLAG
     *
     * @param saleFlag the value for dcdg_goods_category_base.SALE_FLAG
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public void setSaleFlag(Byte saleFlag) {
        this.saleFlag = saleFlag;
    }

    /**
     * 数据库字段：小图标dcdg_goods_category_base.LITTLE_IMG
     *
     * @return the value of dcdg_goods_category_base.LITTLE_IMG
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public String getLittleImg() {
        return littleImg;
    }

    /**
     * 数据库字段：小图标dcdg_goods_category_base.LITTLE_IMG
     *
     * @param littleImg the value for dcdg_goods_category_base.LITTLE_IMG
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public void setLittleImg(String littleImg) {
        this.littleImg = littleImg == null ? null : littleImg.trim();
    }

    /**
     * 数据库字段：分类描述dcdg_goods_category_base.CAT_DESC
     *
     * @return the value of dcdg_goods_category_base.CAT_DESC
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public String getCatDesc() {
        return catDesc;
    }

    /**
     * 数据库字段：分类描述dcdg_goods_category_base.CAT_DESC
     *
     * @param catDesc the value for dcdg_goods_category_base.CAT_DESC
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc == null ? null : catDesc.trim();
    }

    /**
     * 数据库字段：分类详情dcdg_goods_category_base.CAT_DETAIL
     *
     * @return the value of dcdg_goods_category_base.CAT_DETAIL
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public String getCatDetail() {
        return catDetail;
    }

    /**
     * 数据库字段：分类详情dcdg_goods_category_base.CAT_DETAIL
     *
     * @param catDetail the value for dcdg_goods_category_base.CAT_DETAIL
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    public void setCatDetail(String catDetail) {
        this.catDetail = catDetail == null ? null : catDetail.trim();
    }
}