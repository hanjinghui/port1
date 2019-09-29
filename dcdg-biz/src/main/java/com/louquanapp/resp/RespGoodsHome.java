package com.louquanapp.resp;

import com.louquanapp.dao.model.Banner;
import com.louquanapp.dao.model.Goods;
import com.louquanapp.dao.model.Video;

import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2019/5/7 11:44
 * @Description:
 */
public class RespGoodsHome {

    /**
     * 推荐直播
     */
    List<Banner> bannerList;
    /**
     * 推荐商品
     */
    List<Goods> goodsList;

    /**
     * 推荐直播
     */
    private List<Video> videos;

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public List<Banner> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<Banner> bannerList) {
        this.bannerList = bannerList;
    }


    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
