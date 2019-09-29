package com.louquanapp.resp;


import com.louquanapp.dao.EvaluateStatics;
import com.louquanapp.dao.model.Goods;
import com.louquanapp.dao.model.GoodsAttribute;
import com.louquanapp.dao.model.GoodsSku;
import com.louquanapp.dao.model.OrderEvaluate;

import java.util.List;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2019年04月03日07:39:26
 */
public class GoodsAndDetail {

    private List<Goods> goodsList;
    //评论统计
    private EvaluateStatics evaluateStatics;
    //商品属性
    private Goods goods;
    //详情列表
    private List<GoodsDetailWithImg> goodsDetail;
    //图片列表
    private List<String> imgs;
    //足迹
    private List<ShortGoods> footPrints;
    //推荐
    private List<ShortGoods> recommend;
    //商品属性
    private List<GoodsAttribute> attrs;
    //订单评论分页
    private OrderEvaluate orderEvaluate;
    //商品sku
    private List<GoodsSku> goodsSkus;
    //选中的goodsSKu
    private GoodsSku selectedGoodsSku;
    private ShortSpec mainShortSpec;
    private ShortSpec viceShortSpec;
    private Integer buyCartCount;
    private String shopArea;
    private String shopName;

    public String getShopArea() {
        return shopArea;
    }

    public void setShopArea(String shopArea) {
        this.shopArea = shopArea;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public Integer getBuyCartCount() {
        return buyCartCount;
    }

    public void setBuyCartCount(Integer buyCartCount) {
        this.buyCartCount = buyCartCount;
    }

    public ShortSpec getMainShortSpec() {
        return mainShortSpec;
    }

    public void setMainShortSpec(ShortSpec mainShortSpec) {
        this.mainShortSpec = mainShortSpec;
    }

    public ShortSpec getViceShortSpec() {
        return viceShortSpec;
    }

    public void setViceShortSpec(ShortSpec viceShortSpec) {
        this.viceShortSpec = viceShortSpec;
    }

    public List<GoodsSku> getGoodsSkus() {
        return goodsSkus;
    }

    public void setGoodsSkus(List<GoodsSku> goodsSkus) {
        this.goodsSkus = goodsSkus;
    }

    public GoodsSku getSelectedGoodsSku() {
        return selectedGoodsSku;
    }

    public void setSelectedGoodsSku(GoodsSku selectedGoodsSku) {
        this.selectedGoodsSku = selectedGoodsSku;
    }


    public List<ShortGoods> getRecommend() {
        return recommend;
    }

    public void setRecommend(List<ShortGoods> recommend) {
        this.recommend = recommend;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<GoodsDetailWithImg> getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(List<GoodsDetailWithImg> goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    public List<ShortGoods> getFootPrints() {
        return footPrints;
    }

    public void setFootPrints(List<ShortGoods> footPrints) {
        this.footPrints = footPrints;
    }

    public EvaluateStatics getEvaluateStatics() {
        return evaluateStatics;
    }

    public void setEvaluateStatics(EvaluateStatics evaluateStatics) {
        this.evaluateStatics = evaluateStatics;
    }

    public List<GoodsAttribute> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<GoodsAttribute> attrs) {
        this.attrs = attrs;
    }

    public OrderEvaluate getOrderEvaluate() {
        return orderEvaluate;
    }

    public void setOrderEvaluate(OrderEvaluate orderEvaluate) {
        this.orderEvaluate = orderEvaluate;
    }
}
