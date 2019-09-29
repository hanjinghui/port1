package com.louquanapp.req;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/8 10:50
 * @Description:
 */
public class ReqBanner extends ReqTokenIf {

    /**
     * 1-首页 2-直播 3-游戏 4-商家申请 6-红包
     */
    private Integer bannerPage;

    public Integer getBannerPage() {
        return bannerPage;
    }

    public void setBannerPage(Integer bannerPage) {
        this.bannerPage = bannerPage;
    }
}
