package com.louquanapp.web.basic.api;

import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.*;
import com.louquanapp.dao.mapper.*;
import com.louquanapp.dao.model.*;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqComm;
import com.louquanapp.req.ReqCommPage;
import com.louquanapp.resp.RespGoodsHome;
import com.louquanapp.resp.RespHome1;
import com.louquanapp.resp.RespHome2;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/12 14:18
 * @Description:
 */
@RestController
@RequestMapping("/api/no")
public class IndexController {

    private final BannerBiz bannerBiz;
    private final MessageBiz messageBiz;
    private final GoodsBiz goodsBiz;
    private final VideoMapper videoMapper;
    private final GoodsSkuMapper goodsSkuMapper;
    private final CustomerMapper customerMapper;
    private final CustomerAccountMapper customerAccountMapper;
    private final AttentionMapper attentionMapper;
    private final GameMapper gameMapper;
    private final SystemParamMapper systemParamMapper;
    private final AboutUsMapper aboutUsMapper;
    private final ShopMapper shopMapper;

    public IndexController(BannerBiz bannerBiz, MessageBiz messageBiz, GoodsBiz goodsBiz, VideoMapper videoMapper, GoodsSkuMapper goodsSkuMapper, CustomerMapper customerMapper, CustomerAccountMapper customerAccountMapper, AttentionMapper attentionMapper, GameMapper gameMapper, SystemParamMapper systemParamMapper, AboutUsMapper aboutUsMapper, ShopMapper shopMapper) {
        this.bannerBiz = bannerBiz;
        this.messageBiz = messageBiz;
        this.goodsBiz = goodsBiz;
        this.videoMapper = videoMapper;
        this.goodsSkuMapper = goodsSkuMapper;
        this.customerMapper = customerMapper;
        this.customerAccountMapper = customerAccountMapper;
        this.attentionMapper = attentionMapper;
        this.gameMapper = gameMapper;
        this.systemParamMapper = systemParamMapper;
        this.aboutUsMapper = aboutUsMapper;
        this.shopMapper = shopMapper;
    }

    @PostMapping("telPhone")
    public TypeJsonResult<String> telPhone(@RequestBody @Valid ReqComm reqSource, BindingResult bindingResult) {
        TypeJsonResult<String> jsonResult = new TypeJsonResult<>();
        SystemParam systemParam = systemParamMapper.selectByIndex(SystemParamBiz.TEL_PHONE);
        if (null != systemParam) {
            jsonResult.setType(systemParam.getParamValue());
        }
        jsonResult.setStatusCode(true);
        return jsonResult;
    }

    @PostMapping("home1")
    public TypeJsonResult<RespHome1> home1(@RequestBody @Valid ReqComm reqSource, BindingResult bindingResult) {
        TypeJsonResult<RespHome1> jsonResult = new TypeJsonResult<>();
        RespHome1 respHome1 = new RespHome1();
        respHome1.setBannerList(bannerBiz.banners(1, "").getType());

        ReqCommPage reqCommPage=new ReqCommPage();
        BeanUtils.copyProperties(reqSource, reqCommPage);

        respHome1.setMessageList(messageBiz.messagesPage(reqCommPage).getPageInfo().getList());
        List<Video> videoList = videoMapper.videoValidRec((byte)2);

        Shop shop=new Shop();
        for (Video video : videoList
        ) {
            shop=shopMapper.queryShopByCustId(video.getCustId());
            video.setShopLogo(shop.getShopLogo());
            video.setShopName(shop.getShopName());
            VideoBiz.formatCustomerInfo(video, "", customerMapper, customerAccountMapper, attentionMapper);
        }

        List<Game> lst = gameMapper.selectAllRec();
        respHome1.setGames(lst);

        respHome1.setGoodsList(goodsBiz.queryGoodsRec().getType());
        maxPointFormat(respHome1.getGoodsList());

        respHome1.setVideos(videoList);
        jsonResult.setType(respHome1);
        jsonResult.setStatusCode(true);
        return jsonResult;
    }

    @PostMapping("home2")
    public TypeJsonResult<RespHome2> home2(@RequestBody @Valid ReqComm reqSource, BindingResult bindingResult) {
        TypeJsonResult<RespHome2> jsonResult = new TypeJsonResult();
        RespHome2 respHome2 = new RespHome2();

        List<Game> lst = gameMapper.selectAllRec();
        respHome2.setGames(lst);

        respHome2.setGoodsList(goodsBiz.queryGoodsRec().getType());
        maxPointFormat(respHome2.getGoodsList());

        jsonResult.setType(respHome2);
        jsonResult.setStatusCode(true);
        return jsonResult;
    }

    @PostMapping("goodsHome")
    public TypeJsonResult<RespGoodsHome> goodsHome(@RequestBody @Valid ReqComm reqSource, BindingResult bindingResult) {
        TypeJsonResult<RespGoodsHome> jsonResult = new TypeJsonResult();
        RespGoodsHome respGoodsHome = new RespGoodsHome();
        respGoodsHome.setGoodsList(goodsBiz.queryGoodsRec().getType());
        maxPointFormat(respGoodsHome.getGoodsList());
        List<Banner> bannerList = bannerBiz.banners(2, "").getType();
        List<Video> videoList = videoMapper.videoValidRec((byte)2);
        Shop shop=new Shop();
        for (Video video : videoList
        ) {
            shop=shopMapper.queryShopByCustId(video.getCustId());
            video.setShopLogo(shop.getShopLogo());
            video.setShopName(shop.getShopName());
            VideoBiz.formatCustomerInfo(video, "", customerMapper, customerAccountMapper, attentionMapper);
        }
        respGoodsHome.setVideos(videoList);
        respGoodsHome.setBannerList(bannerList);
        jsonResult.setType(respGoodsHome);
        jsonResult.setStatusCode(true);
        return jsonResult;
    }

    /**
     * 关于我们
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("aboutUs")
    public TypeJsonResult<AboutUs> aboutUs(@RequestBody @Valid ReqComm reqSource, BindingResult bindingResult) {
        TypeJsonResult<AboutUs> jsonResult = new TypeJsonResult<>();
        AboutUs abouatUs = new AboutUs();
        abouatUs.setAbout(aboutUsMapper.selectAll().get(0).getAbout());
        jsonResult.setType(abouatUs);
        jsonResult.setStatusCode(true);
        return jsonResult;
    }


    /**
     * 格式化maxpoint
     *
     * @param list
     */
    private void maxPointFormat(List<Goods> list) {

        if (!CollectionUtils.isEmpty(list)) {
            for (Goods tt : list
            ) {
                Double maxMoint = goodsSkuMapper.selectMaxPointByGoodId(tt.getGoodsId());
                maxMoint = maxMoint == null ? 0.00d : maxMoint;
                tt.setMaxPoint(maxMoint);
            }
        }

    }

    /**
     * 版本效果控制
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("appVersionChange")
    public TypeJsonResult<String> appVersionChange(@RequestBody @Valid ReqComm reqSource, BindingResult bindingResult) {
        TypeJsonResult<String> jsonResult = new TypeJsonResult<>();
        SystemParam systemParam = systemParamMapper.selectByIndex("app_version_change");
        if (null != systemParam) {
            jsonResult.setType(systemParam.getParamValue());
        }
        jsonResult.setStatusCode(true);
        return jsonResult;
    }
}
