package com.louquanapp.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.Arith;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.dao.EvaluateStatics;
import com.louquanapp.dao.mapper.*;
import com.louquanapp.dao.model.*;
import com.louquanapp.model.PageJsonResult;
import com.louquanapp.model.ReqForPageInfo;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.*;
import com.louquanapp.resp.GoodsAndDetail;
import com.louquanapp.resp.GoodsDetailWithImg;
import com.louquanapp.resp.RespCateGood;
import com.louquanapp.service.GoodsDetailService;
import com.louquanapp.service.GoodsImgService;
import com.louquanapp.service.GoodsSkuService;
import com.louquanapp.service.JedisService;
import com.louquanapp.utils.BizUtils;
import jodd.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/3 08:06
 * @Description:
 */
@Service
public class GoodsBiz {
    private final GoodsMapper goodsMapper;
    private final GoodsSkuService goodsSkuService;

    private final GoodsDetailService goodsDetailService;
    private final GoodsImgService goodsImgService;
    private final OrderEvaluateMapper orderEvaluateMapper;
    private final CustomerMapper customerMapper;
    private final JedisService jedisService;
    private final ShopMapper shopMapper;
    private final GoodsAttributeMapper goodsAttributeMapper;
    private final CustomerWordsMapper customerWordsMapper;
    private final SpecificationMapper specificationMapper;
    private final SpecificationOptionMapper specificationOptionMapper;
    private final VideoMapper videoMapper;
    private final CategoryMapper categoryMapper;
    private final GoodsSkuMapper goodsSkuMapper;
    private final GoodsImagesMapper goodsImagesMapper;
    private final SystemUserMapper systemUserMapper;
    private final SystemParamMapper systemParamMapper;
    private final TagsMapper tagsMapper;
    private final GoodsTagsMapper goodsTagsMapper;
    private final AttributeOptionMapper attributeOptionMapper;
    private final AttributeMapper attributeMapper;
    private final GoodsDetailMapper goodsDetailMapper;
    private final CategoryAttributeMapper categoryAttributeMapper;
    private final CategorySpecificationMapper categorySpecificationMapper;


    /**
     * 直播（餐饮类） id
     */
    public final static String CAN_YIN = "20190425123656yhi1X9by";

    public GoodsBiz(GoodsMapper goodsMapper, GoodsSkuService goodsSkuService, GoodsDetailService goodsDetailService
            , GoodsImgService goodsImgService, OrderEvaluateMapper orderEvaluateMapper, CustomerMapper customerMapper
            , JedisService jedisService, ShopMapper shopMapper, GoodsAttributeMapper goodsAttributeMapper
            , CustomerWordsMapper customerWordsMapper, SpecificationMapper specificationMapper
            , SpecificationOptionMapper specificationOptionMapper, VideoMapper videoMapper, CategoryMapper categoryMapper
            , GoodsSkuMapper goodsSkuMapper, GoodsImagesMapper goodsImagesMapper,SystemUserMapper systemUserMapper
            ,SystemParamMapper systemParamMapper,TagsMapper tagsMapper,GoodsTagsMapper goodsTagsMapper
            ,AttributeOptionMapper attributeOptionMapper,AttributeMapper attributeMapper,GoodsDetailMapper goodsDetailMapper
            ,CategoryAttributeMapper categoryAttributeMapper,CategorySpecificationMapper categorySpecificationMapper) {
        this.goodsMapper = goodsMapper;
        this.goodsSkuService = goodsSkuService;
        this.goodsDetailService = goodsDetailService;
        this.goodsImgService = goodsImgService;
        this.orderEvaluateMapper = orderEvaluateMapper;
        this.customerMapper = customerMapper;
        this.jedisService = jedisService;
        this.shopMapper = shopMapper;
        this.goodsAttributeMapper = goodsAttributeMapper;
        this.customerWordsMapper = customerWordsMapper;
        this.specificationMapper = specificationMapper;
        this.specificationOptionMapper = specificationOptionMapper;
        this.videoMapper = videoMapper;
        this.categoryMapper = categoryMapper;
        this.goodsSkuMapper = goodsSkuMapper;
        this.goodsImagesMapper = goodsImagesMapper;
        this.systemUserMapper = systemUserMapper;
        this.systemParamMapper = systemParamMapper;
        this.tagsMapper = tagsMapper;
        this.goodsTagsMapper = goodsTagsMapper;
        this.attributeOptionMapper = attributeOptionMapper;
        this.attributeMapper = attributeMapper;
        this.goodsDetailMapper = goodsDetailMapper;
        this.categoryAttributeMapper = categoryAttributeMapper;
        this.categorySpecificationMapper = categorySpecificationMapper;
    }

    /**
     * 根据主键查商品详情
     *
     * @param goodsId
     * @param reqSource
     * @return
     */
    @Transactional
    public TypeJsonResult<GoodsAndDetail> getGoodsByIdAndSkuId(String goodsId, ReqGoodsSku reqSource) {
        try {
            TypeJsonResult<GoodsAndDetail> typeJsonResult = new TypeJsonResult<>();
            GoodsAndDetail goodsAndDetail = new GoodsAndDetail();

            //获取商品基本信息
            Goods goods = goodsMapper.selectShort(goodsId);
            if (null == goods) {
                typeJsonResult.setMessage("商品不存在");
                return typeJsonResult;
            } else if (goods.getAuditStatus().intValue() != 4 || goods.getPutawayFlag().intValue() != 4) {
                typeJsonResult.setMessage("商品未上架");
                return typeJsonResult;
            }

            //获取滚动的4张图片
            goodsAndDetail.setImgs(goodsImgService.getImgUrlBySourceId(goodsId));
            typeJsonResult.setType(goodsAndDetail);
            String shopArea = shopMapper.selectAreaByPrimaryKey(goods.getShopId());
            goodsAndDetail.setShopArea(shopArea);
            goodsAndDetail.setGoods(goods);
            // 套餐商品 暂未用到
//            if (StringUtils.isNotBlank(goods.getGroupGoods())) {
//                goodsAndDetail.setGoodsList(goodsService.getGoodsNameGoodsImgByGoodsIdIn(Arrays.asList(goods.getGroupGoods().split(","))));
//            }

            String skuId = getSkuId(reqSource);
            String custId = "";
            String custName = "";
            if (StringUtils.isNotEmpty(reqSource.getToken())) {
                custId = jedisService.getValueByKey(reqSource.getToken());
                if (StringUtils.isNotEmpty(custId)) {
                    Customer customer = customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(custId);
                    custName = BizUtils.getCustName(customer);
                }
            }
            //app获取设备，pc 需要ip 此处只获取设备编号
            String ip = reqSource.getDeviceId();

            //设置默认GoodsSku
            GoodsSku selectedGoodSku = new GoodsSku();
            //需要选中的临时变量，回头需要带回
            selectedGoodSku.setSkuId(skuId);
            //根据goodsId返回sku集合，同时选中 默认的sku
            List<GoodsSku> goodsSkus = getGoodsSku(goodsId, selectedGoodSku);

            //这里是收藏/守着足迹  是否收藏    未启用
//            for (GoodsSku temp :
//                    goodsSkus) {
//                if (StringUtils.isEmpty(custId)) {
//                    temp.setCollected(false);
//                } else {
//                    //这里是收藏
//                    long resultCount = footPrintService.getGoodCollectByCustIdAndSourceId(custId, temp.getSkuId());
//                    if (resultCount > 0) {
//                        temp.setCollected(true);
//                    } else {
//                        temp.setCollected(false);
//                    }
//                }
//
//                if (selectedGoodSku.getSkuId().equals(temp.getSkuId())) {
//                    selectedGoodSku.setCollected(temp.getCollected());
//                }
//            }
            //sku集合
            goodsAndDetail.setGoodsSkus(goodsSkus);
            //选中的sku
            goodsAndDetail.setSelectedGoodsSku(selectedGoodSku);

            //SKU类型[DEFAULT_SKU-默认规格 SINGLE_SKU-单层规格 DOUBLE_SKU-双层规格]
            String skuType = goods.getSkuType();
            if ("DEFAULT_SKU".equals(skuType)) {
                //默认的不需要处理
            } else if ("SINGLE_SKU".equals(skuType)) {
                goodsAndDetail.setMainShortSpec(goodsSkuService.getMainShortSpec(goodsSkus, selectedGoodSku, specificationMapper, specificationOptionMapper));
            } else if ("DOUBLE_SKU".equals(skuType)) {
                goodsAndDetail.setMainShortSpec(goodsSkuService.getMainShortSpec(goodsSkus, selectedGoodSku, specificationMapper, specificationOptionMapper));
                goodsAndDetail.setViceShortSpec(goodsSkuService.getViceShortSpec(goodsSkus, selectedGoodSku, specificationMapper, specificationOptionMapper));
            }


            //获取商品详情信息
            List<GoodsDetail> goodsDetails = goodsDetailService.getByGoodsId(goodsId);

            //商品详情带图片
            List<GoodsDetailWithImg> listGoodsDetailImgs = goodsDetailService.convertToDetailWithImg(goodsDetails, goodsImgService);
            goodsAndDetail.setGoodsDetail(listGoodsDetailImgs);

            //足迹sourceId集合
            //List<String> ids = footPrintService.getGoodsFootPrintSourceIdByCustId(custId);
            //足迹对象集合
//            List<Goods> listTempGoods = goodsService.getByGoodsIdIn(ids);
//            List<Goods> footPrints = goodsService.convertToListShortGoods(listTempGoods);
//            goodsAndDetail.setFootPrints(footPrints);

            //浏览量靠前的5个同类的
            //List<Goods> recommend = getTopSkimCount5(goods.getCatPath());
            //goodsAndDetail.setRecommend(recommend);


            //获取滚动的4张图片  未启用 pc 使用
//            goodsAndDetail.setImgs(goodsImgService.getImgUrlBySourceId(goodsId));
//            typeJsonResult.setType(goodsAndDetail);


            //增加浏览量 未启用
            addGoodSkimCount(goodsId);

            //获取分页首页默认评论数据
            List<OrderEvaluate> pageShortEvaluate = orderEvaluateMapper.getOrderEvaluateByGoodsIdOrderByAddTimeDesc(goodsId);
            if (!CollectionUtils.isEmpty(pageShortEvaluate) && pageShortEvaluate.size() > 0)
                goodsAndDetail.setOrderEvaluate(pageShortEvaluate.get(0));

            //获取评论统计数据
            EvaluateStatics evaluateStatics = getEvaluateStatics(goodsId, orderEvaluateMapper);
            goodsAndDetail.setEvaluateStatics(evaluateStatics);

            //获取商品属性
            List<GoodsAttribute> goodsAttributeList = goodsAttributeMapper.getGoodsAttrByGoodsId(goodsId);
            goodsAndDetail.setAttrs(goodsAttributeList);

//            增加足迹 暂未使用
//            addGoodSkim(goodsId, custId, custName, ip, goods.getGoodsName());
            typeJsonResult.setType(goodsAndDetail);
            typeJsonResult.setStatusCode(true);
            return typeJsonResult;

        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            String message = "获取商品";
            message = String.format("在%s过程中,服务器开小差了!", message);
            throw new HuhuaminException(message, e);

        }
    }

    /**
     * 获取sku，默认有选中， 如果就0:0 就不显示
     *
     * @param goodsId
     * @param selectedGoodSku
     * @return
     */
    private List<GoodsSku> getGoodsSku(String goodsId, GoodsSku selectedGoodSku) {
        //SKU类型[DEFAULT_SKU-默认规格 SINGLE_SKU-单层规格 DOUBLE_SKU-双层规格]
        //数据库sku
        List<GoodsSku> goodsSkuList = goodsSkuService.getGoodsSkuByGoodsId(goodsId, selectedGoodSku);
        return goodsSkuList;

    }

    /**
     * 增加商品浏览量
     *
     * @param id
     */
    private void addGoodSkimCount(String id) {
        int result = goodsMapper.addGoodSkipCountByGoodsId(id);
        if (result == 0) {
            String message = "更新系统浏览量";
            message = String.format("在%s过程中,服务器开小差了!", message);
            throw new HuhuaminException(message);
        }
    }

    /**
     * 根据商品ID获取统计信息
     *
     * @param goodsId
     * @return
     */
    public static EvaluateStatics getEvaluateStatics(String goodsId, OrderEvaluateMapper orderEvaluateMapper) {
        int count1 = orderEvaluateMapper.countOrderEvaluateByGoodsIdAndEvaluateResult(goodsId, 1);
        int count2 = orderEvaluateMapper.countOrderEvaluateByGoodsIdAndEvaluateResult(goodsId, 2);
        int count3 = orderEvaluateMapper.countOrderEvaluateByGoodsIdAndEvaluateResult(goodsId, 3);
        int count4 = orderEvaluateMapper.countOrderEvaluateByGoodsIdAndEvaluateResult(goodsId, 4);
        double percent1 = 0.0;
        double percent2 = 0.0;
        double percent3 = 0.0;
        double percent4 = 0.0;
        int total = count1 + count2 + count3;


        if (total == 0) {
            count1 = 0;
            percent1 = 100;
        } else {
            percent1 = Arith.div(count1 * 100, total, 2);
            percent2 = Arith.div(count2 * 100, total, 2);
            percent3 = Arith.div(count3 * 100, total, 2);
            percent4 = Arith.div(count4 * 100, total, 2);
        }
        return new EvaluateStatics(count1, count2, count3, count4, percent1, percent2, percent3, percent4);
    }


    public static EvaluateStatics getEvaluateStaticsByCustId(String custId, OrderEvaluateMapper orderEvaluateMapper) {
        int count1 = orderEvaluateMapper.countOrderEvaluateByCustIdAndEvaluateResult(custId, 1);
        int count2 = orderEvaluateMapper.countOrderEvaluateByCustIdAndEvaluateResult(custId, 2);
        int count3 = orderEvaluateMapper.countOrderEvaluateByCustIdAndEvaluateResult(custId, 3);
        int count4 = orderEvaluateMapper.countOrderEvaluateByCustIdAndEvaluateResult(custId, 4);
        double percent1 = 0.0;
        double percent2 = 0.0;
        double percent3 = 0.0;
        double percent4 = 0.0;
        int total = count1 + count2 + count3;


        if (total == 0) {
            count1 = 0;
            percent1 = 100;
        } else {
            percent1 = Arith.div(count1 * 100, total, 2);
            percent2 = Arith.div(count2 * 100, total, 2);
            percent3 = Arith.div(count3 * 100, total, 2);
            percent4 = Arith.div(count4 * 100, total, 2);
        }
        return new EvaluateStatics(count1, count2, count3, count4, percent1, percent2, percent3, percent4);
    }


    /**
     * 根据商品相关属性 获取skuId
     *
     * @param reqGoodsSku
     * @return
     */
    private String getSkuId(ReqGoodsSku reqGoodsSku) {
        //如果2个都是空，那么是首页进来的 或者默认规则
        if (StringUtils.isEmpty(reqGoodsSku.getMainSpec()) && StringUtils.isEmpty(reqGoodsSku.getViceSpec())) {
            return "";
        } else {
            GoodsSku goodsSkuSearch = new GoodsSku();
            BeanUtils.copyProperties(reqGoodsSku, goodsSkuSearch);
            return goodsSkuService.getSkuIdByReqGoodsSku(goodsSkuSearch);
        }

    }

    /**
     * @param reqSearchGoods
     * @param request
     * @param custId
     * @param isPro          餐饮[1-是 2-否]
     * @return
     */
    public PageJsonResult<Goods> searchGoods(ReqSearchGoods reqSearchGoods, HttpServletRequest request, String custId, Byte isPro) {
        try {
            //如果catId为第三层 直接等值查询
            Goods searchGoods = new Goods();
            Set<String> goodIds = null; //商品搜素集合

            initSearch(reqSearchGoods, searchGoods, goodIds);


//            if (goodsEsList.size() > 0) {
//                Set<String> goodsIdSet = new HashSet<>();
//                for (GoodsEs goodsEs : goodsEsList) {
//                    goodsIdSet.add(goodsEs.getGoodsId());
//                }
//                searchGoods.setGoodsIds(new ArrayList<>(goodsIdSet));
//            } else {
//            if (StringUtils.isNotEmpty(reqSearchGoods.getKeywords()) && reqSearchGoods.getKeywords().length() > 1) {
//                    searchGoods.setGoodsIds(Arrays.asList("huhuamin"));
//                searchGoods.setGoodsIds(null);
//            }
//            }
//            List<String> tokens = new ArrayList<>();
//            if (StringUtils.isNotBlank(reqSearchGoods.getKeywords()) && !"6".equals(request.getParameter("registSource"))) {
//                Analyze analyze = new Analyze.Builder().index("goods").analyzer("ik_max_word").text(reqSearchGoods.getKeywords()).build();
//                JestResult resultAnalyze = JestClientManager.getJestClient().execute(analyze);
//                @SuppressWarnings("deprecation")
//                Map<?, ?> jsonMap = resultAnalyze.getJsonMap();
//                @SuppressWarnings("unchecked")
//                List<Map<String, String>> list = (List<Map<String, String>>) jsonMap.get("tokens");
//                for (Map<String, String> map : list) {
//                    tokens.add(map.get("token"));
//                }


//            }
            if (StringUtils.isNotBlank(reqSearchGoods.getKeywords())) {
                searchGoods.setGoodsNameLike(reqSearchGoods.getKeywords());
            }
            if (!CollectionUtils.isEmpty(goodIds)) {
                searchGoods.setGoodsIds(new ArrayList<>(goodIds));
            } else {
                searchGoods.setGoodsIds(new ArrayList<>());
            }

            if (StringUtils.isNotBlank(reqSearchGoods.getVideoId())) {
                String shopId = customerMapper.selectShopIdBuyVideoId(reqSearchGoods.getVideoId());
                searchGoods.setShopId(shopId);
            }


            ReqForPageInfo reqForPageInfo = new ReqForPageInfo(reqSearchGoods.getPageNum(), reqSearchGoods.getPageSize());

            searchGoods.setIsPromotion(isPro.byteValue());
            List<Goods> list = null;
            list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(), searchGoods.getOrderStr()).doSelectPage(() -> goodsMapper.searchGoods(searchGoods));
            PageInfo<Goods> pageTemp = new PageInfo<>(list);

            list.stream().forEach((goods) -> {
                EvaluateStatics evaluateStatics = getEvaluateStatics(goods.getGoodsId(), orderEvaluateMapper);
                goods.setEvaluateStatics(evaluateStatics);
                GoodsSku goodsSku = goodsSkuService.getMinGoodsSkuIdByGoodsId(goods.getGoodsId());
                goods.setSkuId(goodsSku.getSkuId());
                goods.setMaxPoint(goodsSku.getMaxPoint());
                goods.setPutawayPrice(goods.getPutawayPrice());
                goods.setIsPoint(goodsSku.getIsPoint());
                //所在区域
                goods.setShopArea(shopMapper.selectAreaByPrimaryKey(goods.getShopId()));

            });


            if (StringUtils.isNotEmpty(reqSearchGoods.getKeywords())) {

                List<String> custWords = customerWordsMapper.selectByCustId(custId, reqSearchGoods.getDeviceId());
                if (!custWords.contains(reqSearchGoods.getKeywords())) {
                    Date dt = new Date();
                    CustomerWords customerWords = new CustomerWords();
                    customerWords.setCustId(custId);
                    customerWords.setCustWordsId(UUIDUtils.generateUuid22());
                    customerWords.setWordsVal(reqSearchGoods.getKeywords());
                    customerWords.setDeviceId(reqSearchGoods.getDeviceId());
                    customerWords.setAddTime(dt);
                    customerWords.setUpdateTime(dt);
                    customerWordsMapper.insert(customerWords);
                }


            }

            PageJsonResult<Goods> pageJsonResult = new PageJsonResult(pageTemp);
            return pageJsonResult;

        } catch (Exception e) {
            throw new HuhuaminException("搜索商品异常", e);
        }
    }


    private void initSearch(ReqSearchGoods reqSearchGoods, Goods searchGoods, Set<String> goodsId) throws IOException {
        //模糊查询
        String keywords = reqSearchGoods.getKeywords();

        Byte isPromotion=reqSearchGoods.getIsPromotion();

        if(isPromotion!=null){
            searchGoods.setIsPromotion(isPromotion);
        }


        Set<String> optSet = new HashSet<>();
        //属性里面的goodsId
        if (StringUtils.isNotEmpty(reqSearchGoods.getOptId())) {
            List<String> tt = Arrays.asList(reqSearchGoods.getOptId().split(","));
            optSet = new HashSet(tt);
        }

        if (!CollectionUtils.isEmpty(optSet)) {

            List<String> listGoodsId = goodsAttributeMapper.getGoodsIdsByAttrs(new ArrayList<String>(optSet));
            if (!CollectionUtils.isEmpty(listGoodsId)) {
                if (null == goodsId) {
                    goodsId = new HashSet<>();
                }
                goodsId.addAll(listGoodsId);
            }
        }
        Set<String> specOptSet = new HashSet<>();
        //规格
        if (StringUtils.isNotEmpty(reqSearchGoods.getSpecOptId())) {
            List<String> tt = Arrays.asList(reqSearchGoods.getSpecOptId().split(","));
            specOptSet = new HashSet(tt);
        }
        if (!CollectionUtils.isEmpty(specOptSet)) {

            List<String> listGoodsId = goodsSkuService.getGoodsIdsByOptId(new ArrayList<String>(specOptSet));
            if (!CollectionUtils.isEmpty(listGoodsId)) {
                if (null == goodsId) {
                    goodsId = new HashSet<>();
                }
                goodsId.addAll(listGoodsId);
            }
        }

        Set<String> optSetBrand = new HashSet<>();
        //brands
        if (StringUtils.isNotEmpty(reqSearchGoods.getBrandId())) {
            List<String> tt = Arrays.asList(reqSearchGoods.getBrandId().split(","));
            optSetBrand.addAll(tt);
            if (!CollectionUtils.isEmpty(optSetBrand)) {
                searchGoods.setBrandIds(new ArrayList<String>(optSetBrand));
            } else {
                searchGoods.setBrandIds(new ArrayList<>());
            }
        } else {
            searchGoods.setBrandIds(new ArrayList<>());
        }


        Set<String> optSetCat = new HashSet<>();
        if (StringUtils.isNotBlank(reqSearchGoods.getCatId())) {
            optSetCat.addAll(Arrays.asList(reqSearchGoods.getCatId().split(",")));
            if (!CollectionUtils.isEmpty(optSetCat)) {
                searchGoods.setCatIds(new ArrayList<String>(optSetCat));
            } else {
                searchGoods.setCatIds(new ArrayList<>());
            }
        } else {
            searchGoods.setCatIds(new ArrayList<>());
        }


//        if (StringUtils.isNotEmpty(keywords)) {
//            if (keywords.length() > 1) {
////
////            searchGoods.setGoodsNameLike(keyworkds);
//                JestClient jestClient = JestClientManager.getJestClient();
//
//                SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//                searchSourceBuilder.query(QueryBuilders.queryStringQuery(keywords));
//                searchSourceBuilder.from(0);
//                searchSourceBuilder.size(1000);
//
//
//                Search search = new Search.Builder(searchSourceBuilder.toString()).addIndex("goods").build();
//
//                SearchResult result = jestClient.execute(search);
//                List<SearchResult.Hit<GoodsEs, Void>> hits = result.getHits(GoodsEs.class);
//
//                for (SearchResult.Hit<GoodsEs, Void> hit : hits) {
//                    specs.add(hit.source);
//                    hit.source.setScore(hit.score);
//                }
//            } else {
//                  searchGoods.setGoodsNameLike(keywords);
//            }
//        }


        searchGoods.setGoodsNameLike(keywords);


        String range = reqSearchGoods.getRange();
        if (StringUtils.isNotEmpty(range)) {
            range = range.replace("+", "");
            String[] rangeArr = range.split("-");
            searchGoods.setBeginPutawayPrice(Double.valueOf(rangeArr[0]));
            if (rangeArr.length == 2) {
                searchGoods.setEndPutawayPrice(Double.valueOf(rangeArr[1]));
            }
        }
        StringBuffer orderStr = new StringBuffer();


        if (StringUtils.isNotEmpty(reqSearchGoods.getIsRecSort())) {
            orderStr.append(" IS_REC ".concat(reqSearchGoods.getIsRecSort())).append(",");
        }

        if (StringUtils.isNotEmpty(reqSearchGoods.getUpdateTimeSort())) {
            orderStr.append(" UPDATE_TIME ".concat(reqSearchGoods.getUpdateTimeSort())).append(",");
        }

        if (StringUtils.isNotEmpty(reqSearchGoods.getSaleCountSort())) {
            orderStr.append(" SALE_COUNT ".concat(reqSearchGoods.getSaleCountSort())).append(",");
        }

        if (StringUtils.isNotEmpty(reqSearchGoods.getPutawayPriceSort())) {
            orderStr.append(" PUTAWAY_PRICE ".concat(reqSearchGoods.getPutawayPriceSort())).append(",");
        }


        if (StringUtils.isNotEmpty(reqSearchGoods.getRateCountSort())) {
            orderStr.append(" RATE_COUNT ".concat(reqSearchGoods.getRateCountSort())).append(",");
        }

        if (StringUtils.isNotEmpty(reqSearchGoods.getAddTimeSort())) {
            orderStr.append(" ADD_TIME ".concat(reqSearchGoods.getAddTimeSort())).append(",");
        }


        if (StringUtils.isNotEmpty(reqSearchGoods.getZongheSort())) {
            orderStr.append(" SALE_COUNT ".concat(reqSearchGoods.getZongheSort())).append(",")
                    .append(" PUTAWAY_PRICE ".concat(reqSearchGoods.getZongheSort())).append(",")
                    .append(" RATE_COUNT ".concat(reqSearchGoods.getZongheSort())).append(",")
                    .append(" ADD_TIME ".concat(reqSearchGoods.getZongheSort())).append(",")

            ;
        }

        String orderRealStr = orderStr.toString();
        if (StringUtils.isNotEmpty(orderRealStr)) {
            if (orderStr.indexOf(",") > -1) {
                orderRealStr = orderRealStr.substring(0, orderRealStr.length() - 1);
                searchGoods.setOrderStr(orderRealStr);
            } else {
                searchGoods.setOrderStr(orderRealStr);
            }

        } else {
            orderRealStr = " SKIM_COUNT  DESC ";
            searchGoods.setOrderStr(orderRealStr);
        }

    }


    /**
     * 查询商品推荐
     *
     * @return
     */
    public TypeJsonResult<List<Goods>> queryGoodsRec() {
        try {

            TypeJsonResult<List<Goods>> goodsJson = new TypeJsonResult<>();
            goodsJson.setStatusCode(false);
            List<Goods> goodsList = goodsMapper.queryGoodsRec();

            goodsList.stream().forEach((goods) -> {
                EvaluateStatics evaluateStatics = getEvaluateStatics(goods.getGoodsId(), orderEvaluateMapper);
                goods.setEvaluateStatics(evaluateStatics);
                GoodsSku goodsSku = goodsSkuService.getMinGoodsSkuIdByGoodsId(goods.getGoodsId());
                goods.setSkuId(goodsSku.getSkuId());
                goods.setMaxPoint(goodsSku.getMaxPoint());
                goods.setPutawayPrice(goods.getPutawayPrice());
                goods.setIsPoint(goodsSku.getIsPoint());
                //所在区域
                goods.setShopArea(shopMapper.selectAreaByPrimaryKey(goods.getShopId()));

            });


            goodsJson.setStatusCode(true);
            goodsJson.setType(goodsList);
            return goodsJson;
        } catch (Exception e) {
            throw new HuhuaminException("查询商品推荐系统异常", e);
        }
    }

    /**
     * @param videoId
     * @param isPro   餐饮[1-是 2-否]
     * @return
     */
    public TypeJsonResult<List<RespCateGood>> goodsByVideo(String videoId) {

        try {
            TypeJsonResult<List<RespCateGood>> typeJsonResult = new TypeJsonResult<>();
            Video video = videoMapper.selectByPrimaryKey(videoId);
            String shopId = customerMapper.selectShopIdBuyVideoId(videoId);
            Goods goods = new Goods();
            goods.setIsPromotion((byte) 1);
            goods.setShopId(shopId);

            List<Goods> goodsList = goodsMapper.searchGoods(goods);
//            for (Goods tt : goodsList
//            ) {
//                List<GoodsSku> goodsSkus = getGoodsSku(tt.getGoodsId(), null);
//                tt.setGoodsSkus(goodsSkus);
//            }

            if (!CollectionUtils.isEmpty(goodsList)) {
                Map<String, List<Goods>> mapGoods = goodsList.stream().collect(Collectors.groupingBy(Goods::getCatId));

                Set<String> setsCat = mapGoods.keySet();

                Map<String, String> mapCatIdCatname = categoryMapper.selectCatNameByCatIds(new ArrayList<String>(setsCat));

                List<RespCateGood> list = new ArrayList<>();
                for (String key :
                        setsCat) {
                    String catName = mapCatIdCatname.get(key);
                    RespCateGood respCateGood = new RespCateGood();
                    respCateGood.setCatName(catName);
                    respCateGood.setGoods(mapGoods.get(key));
                    list.add(respCateGood);
                }
                typeJsonResult.setType(list);
            }


            typeJsonResult.setStatusCode(true);
            return typeJsonResult;
        } catch (Exception e) {
            String msg = "获取直播间菜单";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage(), e);
        }


    }

    /**
     * 查询热门兑换推荐商品列表
     * @param reqSource
     * @return
     */
    public PageJsonResult<Goods> queryGoodsIsHotExchange(ReqCommPage reqSource) {
        try {
            ReqForPageInfo reqForPageInfo=new  ReqForPageInfo (reqSource.getPageNum(),reqSource.getPageSize());

            Goods searchGoods = new Goods();
            searchGoods.setIsPromotion((byte)2);

            List<Goods> list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(),"SALE_COUNT desc").doSelectPage(() -> goodsMapper.queryGoodsIsHotExchange(searchGoods));


            for(int i = list.size() - 1; i >= 0; i--){
                EvaluateStatics evaluateStatics = getEvaluateStatics(list.get(i).getGoodsId(), orderEvaluateMapper);
                list.get(i).setEvaluateStatics(evaluateStatics);
                GoodsSku goodsSku = goodsSkuService.getMinGoodsSkuIdByGoodsId(list.get(i).getGoodsId());
                list.get(i).setSkuId(goodsSku.getSkuId());
                list.get(i).setMaxPoint(goodsSku.getMaxPoint());
                list.get(i).setPutawayPrice(list.get(i).getPutawayPrice());
                //所在区域
                list.get(i).setShopArea(shopMapper.selectAreaByPrimaryKey(list.get(i).getShopId()));

            }

            PageInfo<Goods> page = new PageInfo<Goods>(list);
            PageJsonResult<Goods> pageJsonResult = new PageJsonResult<Goods>(page);

            return  pageJsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            } else {
                throw new HuhuaminException("查询热门兑换推荐商品列表 开小差了" + e.getMessage());
            }
        }
    }


    /**
     * 商品列表
     * @param userId
     * @param flay 商品查询状态[1-全部 2-已上架 3-已下架 4-待审核]
     * @return
     */
    public PageJsonResult<Goods> goodsList(String userId, ReqGoods reqSource) {
        try {
            ReqForPageInfo reqForPageInfo=new  ReqForPageInfo (reqSource.getPageNum(),reqSource.getPageSize());
            String shopId=systemUserMapper.queryShopIdByUserId(userId);
            List<Goods> list = PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(),"SALE_COUNT DESC").doSelectPage(() -> goodsMapper.queryGoodsByFlay(shopId,reqSource.getFlay()));
            for(Goods goods:list){
                if(4==reqSource.getFlay()){
                    goods.setPutawayFlag((byte)5);
                }
            }
/*
            for(int i = list.size() - 1; i >= 0; i--){
                EvaluateStatics evaluateStatics = getEvaluateStatics(list.get(i).getGoodsId(), orderEvaluateMapper);
                list.get(i).setEvaluateStatics(evaluateStatics);
                GoodsSku goodsSku = goodsSkuService.getMinGoodsSkuIdByGoodsId(list.get(i).getGoodsId());
                list.get(i).setSkuId(goodsSku.getSkuId());
                list.get(i).setMaxPoint(goodsSku.getMaxPoint());
                list.get(i).setPutawayPrice(list.get(i).getPutawayPrice());
                //所在区域
                list.get(i).setShopArea(shopMapper.selectAreaByPrimaryKey(list.get(i).getShopId()));

            }*/

            PageInfo<Goods> page = new PageInfo<Goods>(list);
            PageJsonResult<Goods> pageJsonResult = new PageJsonResult<Goods>(page);

            return  pageJsonResult;
        } catch (Exception e) {
            String msg = "商品列表";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage());
        }
    }


    /**
     * 商品列表总数
     * @param userId
     * @return
     */
    public TypeJsonResult goodsListCount(String userId) {
        try {
            TypeJsonResult typeJsonResult=new TypeJsonResult();
            String shopId=systemUserMapper.queryShopIdByUserId(userId);
            typeJsonResult.setType( goodsMapper.queryGoodsByFlayCount(shopId));
            typeJsonResult.setStatusCode(true);
            return  typeJsonResult;
        } catch (Exception e) {
            String msg = "商品列表总数";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage());
        }
    }


    /**
     * 商品操作（上架，下架，删除）
     * @param userId
     * @param goodsId
     * @param flay [1-上架 2-下架 3-删除]
     * @return
     */
    @Transactional
    public JsonResult goodsFlay(String userId, String goodsId, Byte flay) {
        try {
            JsonResult jsonResult=new JsonResult();
            String shopId=systemUserMapper.queryShopIdByUserId(userId);
            int count=0;
            if(1==flay){
                count=goodsMapper.updateGoodsPutawayFlag(shopId,goodsId,(byte)4);
                if(count==1){
                    jsonResult.setStatusCode(true);
                }else {
                    jsonResult.setMessage("商品上架失败！");
                }

            }else  if(2==flay){
                count=goodsMapper.updateGoodsPutawayFlag(shopId,goodsId,(byte)3);
                if(count==1){
                    jsonResult.setStatusCode(true);
                }else {
                    jsonResult.setMessage("商品下架失败！");
                }
            }else  if(3==flay){
                count=goodsMapper.updateGoodsDelt(shopId,goodsId);
                if(count==1){
                    jsonResult.setStatusCode(true);
                }else {
                    jsonResult.setMessage("商品删除失败！");
                }
            }

            return  jsonResult;
        } catch (Exception e) {
            String msg = "商品操作（上架，下架，删除）";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage());
        }
    }


    /**
     * 查询商品级联类型
     * @param userId
     * @param pId
     * @return
     */
    public TypeJsonResult goodsCascadeCatList(String userId,String pId) {
        try {
            TypeJsonResult jsonResult=new TypeJsonResult();
            String shopId=systemUserMapper.queryShopIdByUserId(userId);
            int shopType=shopMapper.queryShopTypeByShopId(shopId);
            String isVideo =null;
            String id =null;

            if(shopType==2) {  //商铺类型[1-产品类 2-服务类]
                if("0".equals(pId)) {
                   id="1027"; // 服务类
                }
            }else {
                  isVideo="isVideo";
            }
            List<Category> categoryList = categoryMapper.getCategoryListByPIdForGoods(pId,"1",isVideo, id);
            jsonResult.setType(categoryList);
            jsonResult.setStatusCode(true);
            return  jsonResult;
        } catch (Exception e) {
            String msg = "查询商品级联类型";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage());
        }
    }
        /***************************************************增加商品开始************************************************************************************/
    /**
     * 增加商品必须参数
     * @param reqAddGoods
     * @param userId
     * @return
     */
    @Transactional
    public TypeJsonResult goodsContent(ReqGoodsContent reqAddGoods,String userId) {
        try {
            TypeJsonResult jsonResult=new TypeJsonResult();
            Map map=new HashMap();
            String catId=reqAddGoods.getCatId();
            map.put("catId",catId);
            map.put("brandId",reqAddGoods.getBrandId());
            // 根据catId查询分类路径
            Category category = categoryMapper.selectByPrimaryKey(catId);
            String categoryPath = category.getCatPath();
            map.put("catPath",categoryPath);
            // 将分类路径转化成汉化字符串
            String[] ids = categoryPath.split(",");
            List<Category> cateList = categoryMapper.getCateListByIDS(Arrays.asList(ids));
            String catePathStr = "";
            for (int i = 0; i < cateList.size(); i++) {
                if (i == cateList.size() - 1) {
                    catePathStr += cateList.get(i).getCatName();
                } else {
                    catePathStr += cateList.get(i).getCatName() + " > ";
                }
            }

            map.put("catePathStr", catePathStr);
            // 根据分类，获取分类关联的商品属性
            List<CategoryAttribute> attrList = categoryAttributeMapper.getAttrOptionByCatId(catId);
            map.put("attrList", attrList);
            // 根据分类，获取分类关联的商品规格列表
            List<CategorySpecification> specList = categorySpecificationMapper.getSpecOptionByCatId(catId);
            map.put("specList", specList);
            String priceTransformationMaxPoint=systemParamMapper.selectByIndex("price_transformation_max_point").getParamValue();
            map.put("priceTransformationMaxPoint", priceTransformationMaxPoint);

            jsonResult.setType(map);
            jsonResult.setStatusCode(true);
            return  jsonResult;
        } catch (Exception e) {
            String msg = "增加商品必须参数";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage());
        }
    }


    /**
     * 增加单层规格
     * @param reqSingleSku
     * @param userId
     * @return
     */
    @Transactional
    public TypeJsonResult addSingleKul(ReqSingleSku reqSingleSku,String userId) {
        try {




            TypeJsonResult jsonResult=new TypeJsonResult();

            SpecificationOption specificationOption=new SpecificationOption();
            BeanUtils.copyProperties(reqSingleSku, specificationOption);
            specificationOption.setGoodsCount(0);
            List<SpecificationOption> lst = specificationOptionMapper.listAllByOptNameAndOptId(specificationOption.getOptName(),specificationOption.getOptId());
            if(lst != null && lst.size() > 0) {//已经存在该选项
                specificationOption = lst.get(0);
            } else {
                specificationOption.setAddTime(new Date());
                specificationOption.setOptId(UUIDUtils.generateUuid22());
                int count=specificationOptionMapper.insert(specificationOption);
                if(count!=1){
                    jsonResult.setMessage("增加单层规格失败！");
                    return  jsonResult;
                }
            }

            jsonResult.setType(specificationOption.getOptId());
            jsonResult.setStatusCode(true);
            return  jsonResult;
        } catch (Exception e) {
            String msg = "增加商品必须参数";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage());
        }
    }

    /**
     * 增加或修改商品
     * @param reqAddGoods
     * @param userId
     * @return
     */
    @Transactional
    public JsonResult addOrUpdateGoods(ReqAddGoods reqAddGoods,String userId) {
        Boolean isUpdate=false;
        if(StringUtil.isNotBlank(reqAddGoods.getGoodsId())){
            isUpdate=true;
        }
        try {
            JsonResult jsonResult=new JsonResult();
            String shopId=systemUserMapper.queryShopIdByUserId(userId);
            Goods goods=new Goods();

            if(!(reqAddGoods.getSkuType().equals("DEFAULT_SKU")||reqAddGoods.getSkuType().equals("SINGLE_SKU")|| reqAddGoods.getSkuType().equals("DOUBLE_SKU"))){
                jsonResult.setMessage("sku规格错误！");
                return jsonResult;
            }


            BeanUtils.copyProperties( reqAddGoods,goods);

            String goodsId =UUIDUtils.generateUuid22();
            if(StringUtil.isNotBlank(reqAddGoods.getGoodsId())){
                goodsId =reqAddGoods.getGoodsId();
            }

            goods.setAddTime(new Date());
            goods.setUpdateTime(new Date());
            goods.setGoodsType((byte)1);
            goods.setShopId(shopId);
            String userName=systemUserMapper.queryUserNameByUserId(userId);
            goods.setSuserId(userId);
            goods.setSuserName(userName);
            goods.setGoodsId(goodsId);
            goods.setIsHot((byte)1);
            goods.setIsNew((byte)0);
            goods.setIsRec((byte)2);
            goods.setSaleCount(0);
            goods.setRateCount(0);
            goods.setSkimCount(0);
            goods.setIncreaseCount(1);
            goods.setFavCount(0);

            goods.setStockCount(Integer.parseInt(reqAddGoods.getStockList().split(",")[0]));
            goods.setProvidePrice(Double.valueOf(reqAddGoods.getCostList().split(",")[0]));
            goods.setMarketPrice(Double.valueOf( reqAddGoods.getMarketList().split(",")[0] ));
            goods.setMaxPoint(Double.valueOf(reqAddGoods.getMin_scoreList().split(",")[0]));
            goods.setPutawayPrice(Double.valueOf(reqAddGoods.getEdaoList().split(",")[0] ));

            goods.setPointBackType((byte)0);
            goods.setPointAmt(0D);
            goods.setInstallFee(0D);
            goods.setAuditStatus((byte)2);//审核状态[2-待审核 3-审核不通过 4-审核通过]
            goods.setGroupPrice(0D);
            goods.setAddCart((byte)0);
            goods.setPayType((byte)1);
            goods.setDeltFlag((byte)1);
            goods.setAddCart((byte)0);//是否可以添加购物车[0-可以 1-不可以]
            goods.setPutawayFlag((byte)3);//操作类型[3-下架 4-上架]

            if (null != goods.getPutawayPrice() && null != goods.getProvidePrice()) {
                goods.setEarn(Arith.div(goods.getProvidePrice() * 10, goods.getPutawayPrice(), 2));
            }

            if (goods.getCatPath().contains("20190425123656yhi1X9by")) {
                goods.setIsPromotion((byte)1);
            }else{
                goods.setIsPromotion((byte)2);
            }

            if(isUpdate){
                int count=goodsMapper.updateByPrimaryKey(goods);
                if(count!=1){
                    throw new HuhuaminExceptionPlan("修改商品失败！");
                }
                dealGoodsAttrSkuUpdate(reqAddGoods,goods,userId);
            }else {
                int count=goodsMapper.insert(goods);
                if(count!=1){
                    throw new HuhuaminExceptionPlan("增加商品失败！");
                }
                dealGoodsAttrSku(reqAddGoods,goods,userId);
            }

            jsonResult.setStatusCode(true);
            return  jsonResult;
        } catch (Exception e) {
            String msg = "";
            if(isUpdate){
                msg = "修改商品";
            }else{
                msg = "增加商品";
            }
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage());
        }
    }

    /**
     * 处理表单提交的属性和SKU数据
     *
     * @param map
     *            Map<String, String>
     * @param goodsId
     */
    private void dealGoodsAttrSku(ReqAddGoods reqAddGoods,Goods goods,String userId) {
        String priceTransformationMaxPoint= systemParamMapper.selectByIndex("price_transformation_max_point").getParamValue();

        List<GoodsImages> goodsImagesList = new ArrayList<GoodsImages>();
        String goodsId = goods.getGoodsId();
        int count=0;
        // ======= 处理商品标签 开始
        if (StringUtil.isNotBlank(reqAddGoods.getTagsList())) {
            List<Tags> tagsList = new ArrayList<Tags>();
            List<GoodsTags> goodsTagsList = new ArrayList<GoodsTags>();
            List<String> tagss=Arrays.asList(reqAddGoods.getTagsList().split(","));

            Set<String> tagsSet = new HashSet<>();
            for (String tag: tagss) {
                String tagsId = UUIDUtils.generateUuid22();

                Tags tags = new Tags();
                tags.setTagsName(tag);
                // 先拿tagsName 查询 系统是否已经存在该标签，若存在则直接返回，并不再插入
                List<Tags> tagslistDB = tagsMapper.queryTagsByTagsName(tag);
                if (tagslistDB != null && tagslistDB.size() > 0) {// 数据库存在该标签
                    tags = tagslistDB.get(0);
                } else {
                    tags.setSearchCount(0);
                    tags.setTagsId(tagsId);
                    tags.setAddTime(new Date());
                    tagsList.add(tags);
                }
                GoodsTags goodsTags = new GoodsTags();
                goodsTags.setGoodsId(goodsId);
                goodsTags.setTagsIds(tags.getTagsId());
                goodsTags.setGoodsId(UUIDUtils.generateUuid22());
                goodsTags.setAddTime(new Date());
                goodsTagsList.add(goodsTags);
            }
            if (tagsList != null && tagsList.size() > 0){
                count=tagsMapper.batchInsert(tagsList);
                if(count!=tagsList.size()){
                    throw new HuhuaminExceptionPlan("增加商品标签失败！");
                }
            }

            if (goodsTagsList != null && goodsTagsList.size() > 0) {
                 count=goodsTagsMapper.batchInsert(goodsTagsList);
                if(count!=tagsList.size()){
                    throw new HuhuaminExceptionPlan("增加商品标签关联失败！");
                }
            }

        }
        // ======= 处理商品标签 结束

        // ======= 处理商品属性 开始
        if (StringUtil.isNotBlank(reqAddGoods.getMerattrList())) {
            List<GoodsAttribute> goodsAttributeList = new ArrayList<GoodsAttribute>();
            List<String> merattrList=Arrays.asList(reqAddGoods.getMerattrList().split(","));

            String merattrKey="";
            String merattrValue="";
            for (String merattr : merattrList) {
                /*String value = entry.getValue();
                String key = entry.getKey();*/
               // key = key.substring(key.indexOf("[") + 1, key.indexOf("]"));

                merattrKey=merattr.split(";")[0];
                merattrValue=merattr.split(";")[1];
                GoodsAttribute goodsAttribute = new GoodsAttribute();
                goodsAttribute.setGattrId(UUIDUtils.generateUuid22());
                goodsAttribute.setAddTime(new Date());
                goodsAttribute.setGoodsId(goodsId);
                goodsAttribute.setAttrId(merattrKey);

                Attribute attribute = attributeMapper.selectByPrimaryKey(merattrKey);
                goodsAttribute.setAttrName(attribute.getAttrName());
                // TODO 目前用到 这两个属性
                if (attribute.getInputType().equals("text")) {
                    goodsAttribute.setAttrOptId("");
                    goodsAttribute.setAttrValue(merattrValue);
                } else if (attribute.getInputType().equals("select")) {
                    goodsAttribute.setAttrOptId(merattr);
                    AttributeOption attributeOption = attributeOptionMapper.selectByPrimaryKey(merattrKey);
                    goodsAttribute.setAttrValue(attributeOption.getOptName());
                }
                goodsAttributeList.add(goodsAttribute);
            }
            if (goodsAttributeList != null && goodsAttributeList.size() > 0) {
                    count=goodsAttributeMapper.batchInsert(goodsAttributeList);
                if(count!=goodsAttributeList.size()){
                    throw new HuhuaminExceptionPlan("增加商品属性失败！");
                }
            }

        }
        // ======= 处理商品属性 结束

        // ======= 处理商品SKU 开始

        List<String> stockList=Arrays.asList(reqAddGoods.getStockList().split(","));
        List<String> costList=Arrays.asList(reqAddGoods.getCostList().split(","));
        List<String> marketList=Arrays.asList(reqAddGoods.getMarketList().split(","));
        List<String> edaoList=Arrays.asList(reqAddGoods.getEdaoList().split(","));
        List<String> isPointList=Arrays.asList(reqAddGoods.getIsPointList().split(","));

        List<String> min_scoreList=Arrays.asList(reqAddGoods.getMin_scoreList().split(","));
        List<String> goodsTypeList=Arrays.asList(reqAddGoods.getGoodsTypeList().split(","));


        List<String> skuRuleList = new ArrayList<>();

        if(reqAddGoods.getSkuType().equals("SINGLE_SKU")|| reqAddGoods.getSkuType().equals("DOUBLE_SKU")){
            List<String> optNameList = Arrays.asList(reqAddGoods.getOptNameList().split(","));
            String catId = goods.getCatId();

            String specId = "";
            List<CategorySpecification> specList = categorySpecificationMapper.getSpecOptionByCatId(catId);
            if (CollectionUtils.isEmpty(specList)) {
                specId = "5";
            } else {
                specId = specList.get(0).getSpecId();
            }
            for (String optName : optNameList) {

                SpecificationOption specificationOption = new SpecificationOption();
                specificationOption.setOptName(optName);
                specificationOption.setSpecId(specId);
                specificationOption.setIsSearch((byte) 1);
                specificationOption.setGoodsCount(0);
                List<SpecificationOption> lst = specificationOptionMapper.listAllByOptNameAndOptId(specificationOption.getOptName(), specificationOption.getOptId());
                if (lst != null && lst.size() > 0) {//已经存在该选项
                    specificationOption = lst.get(0);
                } else {
                    specificationOption.setAddTime(new Date());
                    specificationOption.setOptId(UUIDUtils.generateUuid22());
                    count = specificationOptionMapper.insert(specificationOption);
                    if (count != 1) {
                        throw new HuhuaminException("增加单层规格失败！");
                    }
                }

                skuRuleList.add(specId.concat(":").concat(specificationOption.getOptId()));
            }
        }else{
            skuRuleList.add("0:0");
        }


        List<GoodsSku> goodsSkuListAdd = new ArrayList<GoodsSku>();
            for (int i=0;i<stockList.size();i++) {

                String skuGoodsName = goods.getGoodsName();
                GoodsSku goodsSku = new GoodsSku();
                goodsSku.setSkuId(UUIDUtils.generateUuid22());
                goodsSku.setGoodsId(goodsId);
                goodsSku.setSkuRule(skuRuleList.get(i));
                goodsSku.setAddTime(new Date());
                goodsSku.setUpdateTime(new Date());
                String[] fs = skuRuleList.get(i).split(":");

                goodsSku.setMainSpec(fs[0]);
                goodsSku.setMainSpecOpt(fs[1]);
                // 拼接 商品SKU名称
                if(reqAddGoods.getSkuType().equals("SINGLE_SKU")|| reqAddGoods.getSkuType().equals("DOUBLE_SKU")){
                    SpecificationOption sp = specificationOptionMapper.selectByPrimaryKey(fs[1]);
                    if (null != sp && !StringUtil.isEmpty(sp.getOptName())) {
                        skuGoodsName = skuGoodsName + " " + sp.getOptName();
                    }
                }

                goodsSku.setSkuGoodsName(skuGoodsName);
                // 处理规格图片
                // 应胡化敏要求，将商品主图冗余至sku图片里
                goodsSku.setGoodsImg(goods.getGoodsImg());

                goodsSku.setStockCount(Integer.valueOf(stockList.get(i)));
                goodsSku.setSupplierPrice(Double.valueOf(costList.get(i)));
                goodsSku.setMarketPrice(Double.valueOf(marketList.get(i)));
                goodsSku.setPutawayPrice(Double.valueOf(edaoList.get(i)));
                goodsSku.setGoodsType(Byte.valueOf(goodsTypeList.get(i))); // 商品类型[1-其他 2-特价商品]
                goodsSku.setMaxPoint(Double.valueOf(min_scoreList.get(i)));
                goodsSku.setIsPoint(Byte.valueOf(isPointList.get(i)));  // 是否支持积分兑换


                    if(1==Byte.valueOf(isPointList.get(i))) {
                        if (!StringUtil.isEmpty(min_scoreList.get(i))&&!StringUtil.isEmpty(edaoList.get(i))) {

                            if(
                                    Double.valueOf(min_scoreList.get(i))>Arith.mul( Double.valueOf(priceTransformationMaxPoint), Double.valueOf(edaoList.get(i)))
                            ){
                                throw new HuhuaminException("价格(元)积分比例最大".concat(priceTransformationMaxPoint));
                            }
                        }

                    }

                // TODO 商家编码 暂时存放商家的ID
                goodsSku.setMerchantCode(goods.getShopId());
                goodsSkuListAdd.add(goodsSku);


            }

            count=goodsSkuMapper.batchInsert(goodsSkuListAdd);
            if(count!=goodsSkuListAdd.size()){
                throw new HuhuaminExceptionPlan("增加商品规格失败！");
            }

        // ======= 处理商品SKU 结束

        // ======= 处理商品描述 开始
            List<GoodsDetail> goodsDetailList = new ArrayList<GoodsDetail>();

        dealGoodsDesc(reqAddGoods,goodsDetailList,goodsImagesList,goodsId,userId);
            if (goodsDetailList != null && goodsDetailList.size() > 0) {
                count=goodsDetailMapper.batchInsert(goodsDetailList);
                if(count!=goodsDetailList.size()){
                    throw new HuhuaminExceptionPlan("增加商品详情内容失败！");
                }
            }

        // ======= 处理商品图片 开始 goodsImgList
        if (StringUtil.isNotBlank(reqAddGoods.getGoodsImgList())) {
            List<String> goodsImgList=Arrays.asList(reqAddGoods.getGoodsImgList().split(","));
            for (String goodsImgUrl: goodsImgList) {
                GoodsImages goodsImages = new GoodsImages();
                goodsImages.setImgId(UUIDUtils.generateUuid22());
                goodsImages.setSourceId(goodsId);
                goodsImages.setSourceType((byte)1);
                goodsImages.setImgUrl(goodsImgUrl);
                goodsImages.setAddBy(userId);
                goodsImages.setAddTime(new Date());
                goodsImages.setOrderBy(0);
                goodsImagesList.add(goodsImages);
            }
        }
        // ======= 处理商品图片 结束

        if (goodsImagesList != null && goodsImagesList.size() > 0) {
            count=goodsImagesMapper.batchInsert(goodsImagesList);
            if(count!=goodsImagesList.size()){
                throw new HuhuaminExceptionPlan("增加商品详情图片失败！");
            }
        }
    }

    /**
     *
     * @param reqAddGoods
     * @param goodsDetailList
     * @param goodsImagesList
     * @param goodsId
     * @param userId
     * @throws HuhuaminException
     */
    private void dealGoodsDesc(ReqAddGoods reqAddGoods, List<GoodsDetail> goodsDetailList, List<GoodsImages> goodsImagesList,
                             String goodsId ,String userId) throws HuhuaminException {

     int detailType=0;
     for(int i=1;i<=10;i++){
         GoodsDetail goodsDetail = new GoodsDetail();
         // 产品介绍文字
         String detailId =UUIDUtils.generateUuid22();
         goodsDetail.setDetailId(detailId);
         goodsDetail.setGoodsId(goodsId);

         if(i==1){
             detailType=0;
         }else{
             detailType=i;
         }
         goodsDetail.setDetailType((byte)detailType);
         goodsDetail.setAddTime(new Date());


         //产品介绍图片
         List<String> productImgList =new ArrayList<>();
         if(StringUtil.isNotBlank(reqAddGoods.getProductImgList())&&i==5){
             productImgList=Arrays.asList(reqAddGoods.getProductImgList().split(","));
             toGoodsImages(goodsImagesList,productImgList,detailId,userId);
         }
         //套餐产品介绍图片
         List<String> selfImgList =new ArrayList<>();
         if(StringUtil.isNotBlank(reqAddGoods.getSelfImgList())&&i==0){
             selfImgList=Arrays.asList(reqAddGoods.getSelfImgList().split(","));
             toGoodsImages(goodsImagesList,selfImgList,detailId,userId);
         }
         //穿着效果图片
         List<String> wearImgList =new ArrayList<>();
         if(StringUtil.isNotBlank(reqAddGoods.getWearImgList())&&i==2){
             wearImgList=Arrays.asList(reqAddGoods.getWearImgList().split(","));
             toGoodsImages(goodsImagesList,wearImgList,detailId,userId);
         }
         //整体款式图片
         List<String> wholeImgList =new ArrayList<>();
         if(StringUtil.isNotBlank(reqAddGoods.getWholeImgList())&&i==3){
             wholeImgList=Arrays.asList(reqAddGoods.getWholeImgList().split(","));
             toGoodsImages(goodsImagesList,wholeImgList,detailId,userId);
         }

         //细节做工图片
         List<String> detailImgList =new ArrayList<>();
         if(StringUtil.isNotBlank(reqAddGoods.getDetailImgList())&&i==4){
             detailImgList=Arrays.asList(reqAddGoods.getDetailImgList().split(","));
             toGoodsImages(goodsImagesList,detailImgList,detailId,userId);
         }
         //品牌介绍图片
         List<String> brankImgList =new ArrayList<>();
         if(StringUtil.isNotBlank(reqAddGoods.getBrankImgList())&&i==6){
             brankImgList=Arrays.asList(reqAddGoods.getBrankImgList().split(","));
             toGoodsImages(goodsImagesList,brankImgList,detailId,userId);
         }
         //包装展示图片
         List<String> packImgList =new ArrayList<>();
         if(StringUtil.isNotBlank(reqAddGoods.getPackImgList())&&i==7){
             packImgList=Arrays.asList(reqAddGoods.getPackImgList().split(","));
             toGoodsImages(goodsImagesList,packImgList,detailId,userId);
         }
         //服务说明图片
         List<String> serviceImgList =new ArrayList<>();
         if(StringUtil.isNotBlank(reqAddGoods.getServiceImgList())&&i==8){
             serviceImgList=Arrays.asList(reqAddGoods.getServiceImgList().split(","));
             toGoodsImages(goodsImagesList,serviceImgList,detailId,userId);
         }
         //资质证明图片
         List<String> quaImgList =new ArrayList<>();
         if(StringUtil.isNotBlank(reqAddGoods.getQuaImgList())&&i==9){
             quaImgList=Arrays.asList(reqAddGoods.getQuaImgList().split(","));
             toGoodsImages(goodsImagesList,quaImgList,detailId,userId);
         }
         //店铺信息图片
         List<String> shopImgList =new ArrayList<>();
         if(StringUtil.isNotBlank(reqAddGoods.getShopImgList())&&i==10){
             shopImgList=Arrays.asList(reqAddGoods.getShopImgList().split(","));
             toGoodsImages(goodsImagesList,shopImgList,detailId,userId);
         }

         /*
         产品介绍           product  5
         套餐产品介绍       self     0
         穿着效果           wear     2
         整体款式           whole    3
         细节做工           detail   4
         品牌介绍           brank    6
         包装展示           pack     7
         服务说明           service  8
         资质证明           qua      9
         店铺信息           shop     10*/

        if(i==1){
            goodsDetail.setDetailDesc(reqAddGoods.getSelf()==null?"":reqAddGoods.getSelf());
        }else  if(i==2){
            goodsDetail.setDetailDesc(reqAddGoods.getWear()==null?"":reqAddGoods.getWear());
        }else  if(i==3){
            goodsDetail.setDetailDesc(reqAddGoods.getWhole()==null?"":reqAddGoods.getWhole());
        }else  if(i==4){
            goodsDetail.setDetailDesc(reqAddGoods.getDetail()==null?"":reqAddGoods.getDetail());
        }else  if(i==5){
            goodsDetail.setDetailDesc(reqAddGoods.getProduct()==null?"":reqAddGoods.getProduct());
        }else  if(i==6){
            goodsDetail.setDetailDesc(reqAddGoods.getBrank()==null?"":reqAddGoods.getBrank());
        }else  if(i==7){
            goodsDetail.setDetailDesc(reqAddGoods.getPack()==null?"":reqAddGoods.getPack());
        }else  if(i==8){
            goodsDetail.setDetailDesc(reqAddGoods.getService()==null?"":reqAddGoods.getService());
        }else  if(i==9){
            goodsDetail.setDetailDesc(reqAddGoods.getQua()==null?"":reqAddGoods.getQua());
        }else  if(i==10){
            goodsDetail.setDetailDesc(reqAddGoods.getShop()==null?"":reqAddGoods.getShop());

        }
         goodsDetailList.add(goodsDetail);



     }

    }

    /**
     *
     * @param goodsImagesList
     * @param imgList
     * @param detailId
     * @param userId
     */
    public void toGoodsImages (List<GoodsImages> goodsImagesList,List<String> imgList,String detailId,String userId){
        for (String img:imgList) {
            GoodsImages goodsImages = new GoodsImages();
            goodsImages.setImgId(UUIDUtils.generateUuid22());
            goodsImages.setSourceId(detailId);
            goodsImages.setSourceType((byte)6);
            goodsImages.setImgUrl(img);
            goodsImages.setAddBy(userId);
            goodsImages.setAddTime(new Date());
            goodsImages.setOrderBy(0);
            goodsImagesList.add(goodsImages);

        }
    }
/***************************************************增加商品结束************************************************************************************/

/***************************************************修改商品开始************************************************************************************/
    /**
     * 修改商品
     * @param reqAddGoods
     * @param userId
     * @return
     */
    /*@Transactional
    public JsonResult updateGoods(ReqAddGoods reqAddGoods,String userId) {
        try {
            JsonResult jsonResult=new JsonResult();
            if(!(reqAddGoods.getSkuType().equals("DEFAULT_SKU")||reqAddGoods.getSkuType().equals("SINGLE_SKU"))){
                jsonResult.setMessage("sku规格错误！");
                return jsonResult;
            }

            String shopId=systemUserMapper.queryShopIdByUserId(userId);
            Goods goods=new Goods();

            BeanUtils.copyProperties( reqAddGoods,goods);

            String goodsId =goods.getGoodsId();
            goods.setAddTime(new Date());
            goods.setUpdateTime(new Date());
            goods.setGoodsType((byte)1);
            goods.setShopId(shopId);
            String userName=systemUserMapper.queryUserNameByUserId(userId);
            goods.setSuserId(userId);
            goods.setSuserName(userName);
            goods.setGoodsId(goodsId);
            goods.setIsHot((byte)1);
            goods.setIsNew((byte)0);
            goods.setIsRec((byte)2);
            goods.setSaleCount(0);
            goods.setRateCount(0);
            goods.setSkimCount(0);
            goods.setIncreaseCount(1);
            goods.setFavCount(0);

            goods.setStockCount(Integer.parseInt(reqAddGoods.getStockList().split(",")[0]));
            goods.setProvidePrice(Double.valueOf(reqAddGoods.getCostList().split(",")[0]));
            goods.setMarketPrice(Double.valueOf( reqAddGoods.getMarketList().split(",")[0] ));
            goods.setMaxPoint(Double.valueOf(reqAddGoods.getMin_scoreList().split(",")[0]));
            goods.setPutawayPrice(Double.valueOf(reqAddGoods.getEdaoList().split(",")[0] ));

            goods.setPointBackType((byte)0);
            goods.setPointAmt(0D);
            goods.setInstallFee(0D);
            goods.setAuditStatus((byte)2);//审核状态[2-待审核 3-审核不通过 4-审核通过]
            goods.setGroupPrice(0D);
            goods.setAddCart((byte)0);
            goods.setPayType((byte)1);
            goods.setDeltFlag((byte)1);
            goods.setAddCart((byte)0);//是否可以添加购物车[0-可以 1-不可以]
            goods.setPutawayFlag((byte)3);//操作类型[3-下架 4-上架]

            if (null != goods.getPutawayPrice() && null != goods.getProvidePrice()) {
                goods.setEarn(Arith.div(goods.getProvidePrice() * 10, goods.getPutawayPrice(), 2));
            }

            if (goods.getCatPath().contains("20190425123656yhi1X9by")) {
                goods.setIsPromotion((byte)1);
            }else{
                goods.setIsPromotion((byte)2);
            }

            int count=goodsMapper.updateByPrimaryKey(goods);
            if(count!=1){
                throw new HuhuaminExceptionPlan("修改商品失败！");
            }
            dealGoodsAttrSkuUpdate(reqAddGoods,goods,userId);
            jsonResult.setStatusCode(true);
            return  jsonResult;
        } catch (Exception e) {
            String msg = "修改商品";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage());
        }
    }*/

    private void dealGoodsAttrSkuUpdate(ReqAddGoods reqAddGoods,Goods goods,String userId) {
        String priceTransformationMaxPoint= systemParamMapper.selectByIndex("price_transformation_max_point").getParamValue();


        String goodsId = goods.getGoodsId();
        int count=0;
        // ======= 处理商品标签 开始
        // ======= 处理商品标签 结束

        // ======= 处理商品属性 开始
        // ======= 处理商品属性 结束

        // ======= 处理商品SKU 开始

        List<String> stockList=Arrays.asList(reqAddGoods.getStockList().split(","));
        List<String> costList=Arrays.asList(reqAddGoods.getCostList().split(","));
        List<String> marketList=Arrays.asList(reqAddGoods.getMarketList().split(","));
        List<String> edaoList=Arrays.asList(reqAddGoods.getEdaoList().split(","));
        List<String> isPointList=Arrays.asList(reqAddGoods.getIsPointList().split(","));

        List<String> min_scoreList=Arrays.asList(reqAddGoods.getMin_scoreList().split(","));
        List<String> goodsTypeList=Arrays.asList(reqAddGoods.getGoodsTypeList().split(","));


        List<GoodsSku> addGoodsSkus = new ArrayList<GoodsSku>();
        List<GoodsSku> updateGoodsSkus = new ArrayList<GoodsSku>();

        if(reqAddGoods.getSkuType().equals("DEFAULT_SKU")|| reqAddGoods.getSkuType().equals("DOUBLE_SKU")){  //SKU类型[DEFAULT_SKU-默认规格 SINGLE_SKU-单层规格 DOUBLE_SKU-双层规格]
            if(StringUtil.isBlank(reqAddGoods.getSkuId())){
                throw new HuhuaminException("规格id不能为空");
            }
            String skuGoodsName = goods.getGoodsName();
            GoodsSku goodsSku = new GoodsSku();
            goodsSku.setSkuId(reqAddGoods.getSkuId());
            goodsSku.setUpdateTime(new Date());

            goodsSku.setSkuGoodsName(skuGoodsName );

            goodsSku.setStockCount(Integer.valueOf(stockList.get(0)));
            goodsSku.setSupplierPrice(Double.valueOf(costList.get(0)));
            goodsSku.setMarketPrice(Double.valueOf(marketList.get(0)));
            goodsSku.setPutawayPrice(Double.valueOf(edaoList.get(0)));
            goodsSku.setGoodsType(Byte.valueOf(goodsTypeList.get(0))); // 商品类型[1-其他 2-特价商品]
            goodsSku.setMaxPoint(Double.valueOf(min_scoreList.get(0)));
            goodsSku.setIsPoint(Byte.valueOf(isPointList.get(0)));  // 是否支持积分兑换


            if(1==Byte.valueOf(isPointList.get(0))) {
                if (!StringUtil.isEmpty(min_scoreList.get(0))&&!StringUtil.isEmpty(edaoList.get(0))) {
                    if(
                            Double.valueOf(min_scoreList.get(0))>Arith.mul( Double.valueOf(priceTransformationMaxPoint), Double.valueOf(edaoList.get(0)))
                    ){
                        throw new HuhuaminException("价格(元)积分比例最大".concat(priceTransformationMaxPoint));
                    }
                }
            }
            // TODO 商家编码 暂时存放商家的ID
            // goodsSku.setMerchantCode(goods.getShopId());

            updateGoodsSkus.add(goodsSku);
        }else{
            // 单规格
            List<String> optNameList=new ArrayList<>();
            if(StringUtil.isNotBlank(reqAddGoods.getOptNameList())){
                optNameList=Arrays.asList(reqAddGoods.getOptNameList().split(","));
            }else{
                throw new HuhuaminException("规格名称不能为空");
            }

            String catId = goods.getCatId();
            /*  List<String> skuRuleList=new ArrayList<>();*/
            String specId="";
            List<CategorySpecification> specList = categorySpecificationMapper.getSpecOptionByCatId(catId);
            if (CollectionUtils.isEmpty(specList)) {
                specId="5";
            } else {
                specId=specList.get(0).getSpecId();
            }


            for (int i=0;i<stockList.size();i++) {

                String [] optNameArry=optNameList.get(i).split(":");
                if(optNameArry[0].equals("0")){
                    SpecificationOption specificationOption = new SpecificationOption();
                    specificationOption.setOptName(optNameArry[1]);
                    specificationOption.setSpecId(specId);
                    specificationOption.setIsSearch((byte) 1);
                    specificationOption.setGoodsCount(0);
                    List<SpecificationOption> lst = specificationOptionMapper.listAllByOptNameAndOptId(specificationOption.getOptName(), specificationOption.getOptId());
                    if (lst != null && lst.size() > 0) {//已经存在该选项
                        specificationOption = lst.get(0);
                    } else {
                        specificationOption.setAddTime(new Date());
                        specificationOption.setOptId(UUIDUtils.generateUuid22());
                        count = specificationOptionMapper.insert(specificationOption);
                        if (count != 1) {
                            throw new HuhuaminException("增加单层规格失败！");
                        }
                    }
                    /* skuRuleList.add(specId.concat(":").concat(specificationOption.getOptId()));*/


                    String skuGoodsName = goods.getGoodsName();
                    GoodsSku goodsSku = new GoodsSku();
                    goodsSku.setSkuId(UUIDUtils.generateUuid22());
                    goodsSku.setGoodsId(goodsId);
                    goodsSku.setSkuRule(specId.concat(":").concat(specificationOption.getOptId()));
                    goodsSku.setAddTime(new Date());
                    goodsSku.setUpdateTime(new Date());


                    goodsSku.setMainSpec(specId);
                    goodsSku.setMainSpecOpt(specificationOption.getOptId());
                    // 拼接 商品SKU名称
                    SpecificationOption sp = specificationOptionMapper.selectByPrimaryKey(specificationOption.getOptId());
                    if (null != sp && !StringUtil.isEmpty(sp.getOptName())) {
                        skuGoodsName = skuGoodsName + " " + sp.getOptName();
                    }
                    goodsSku.setSkuGoodsName(skuGoodsName);
                    // 处理规格图片
                    // 应胡化敏要求，将商品主图冗余至sku图片里
                    goodsSku.setGoodsImg(goods.getGoodsImg());

                    goodsSku.setStockCount(Integer.valueOf(stockList.get(i)));
                    goodsSku.setSupplierPrice(Double.valueOf(costList.get(i)));
                    goodsSku.setMarketPrice(Double.valueOf(marketList.get(i)));
                    goodsSku.setPutawayPrice(Double.valueOf(edaoList.get(i)));
                    goodsSku.setGoodsType(Byte.valueOf(goodsTypeList.get(i))); // 商品类型[1-其他 2-特价商品]
                    goodsSku.setMaxPoint(Double.valueOf(min_scoreList.get(i)));
                    goodsSku.setIsPoint(Byte.valueOf(isPointList.get(i)));  // 是否支持积分兑换


                    if(1==Byte.valueOf(isPointList.get(i))) {
                        if (!StringUtil.isEmpty(min_scoreList.get(i))&&!StringUtil.isEmpty(edaoList.get(i))) {
                            if(
                                    Double.valueOf(min_scoreList.get(i))>Arith.mul( Double.valueOf(priceTransformationMaxPoint), Double.valueOf(edaoList.get(i)))
                            ){
                                throw new HuhuaminException("价格(元)积分比例最大".concat(priceTransformationMaxPoint));
                            }
                        }
                    }
                    // TODO 商家编码 暂时存放商家的ID
                    goodsSku.setMerchantCode(goods.getShopId());

                    addGoodsSkus.add(goodsSku);
                }else{

                    String skuGoodsName = goods.getGoodsName();
                    GoodsSku goodsSku = new GoodsSku();
                    goodsSku.setSkuId(optNameArry[0]);
                    goodsSku.setUpdateTime(new Date());


                    goodsSku.setSkuGoodsName(skuGoodsName + " " + optNameArry[1]);

                    goodsSku.setStockCount(Integer.valueOf(stockList.get(i)));
                    goodsSku.setSupplierPrice(Double.valueOf(costList.get(i)));
                    goodsSku.setMarketPrice(Double.valueOf(marketList.get(i)));
                    goodsSku.setPutawayPrice(Double.valueOf(edaoList.get(i)));
                    goodsSku.setGoodsType(Byte.valueOf(goodsTypeList.get(i))); // 商品类型[1-其他 2-特价商品]
                    goodsSku.setMaxPoint(Double.valueOf(min_scoreList.get(i)));
                    goodsSku.setIsPoint(Byte.valueOf(isPointList.get(i)));  // 是否支持积分兑换

                    if(1==Byte.valueOf(isPointList.get(i))) {
                        if (!StringUtil.isEmpty(min_scoreList.get(i))&&!StringUtil.isEmpty(edaoList.get(i))) {
                            if(
                                    Double.valueOf(min_scoreList.get(i))>Arith.mul( Double.valueOf(priceTransformationMaxPoint), Double.valueOf(edaoList.get(i)))
                            ){
                                throw new HuhuaminException("价格(元)积分比例最大".concat(priceTransformationMaxPoint));
                            }
                        }
                    }

                    updateGoodsSkus.add(goodsSku);
                }

            }
        }
        if(!CollectionUtils.isEmpty(updateGoodsSkus)){
            for(GoodsSku goodsSku:updateGoodsSkus){
                count=goodsSkuMapper.updateGoodsSku(goodsSku);
                if(count!=1){
                    throw new HuhuaminExceptionPlan("修改商品规格失败！");
                }
            }
        }

        if(!CollectionUtils.isEmpty(addGoodsSkus)){
            count=goodsSkuMapper.batchInsert(addGoodsSkus);
            if(count!=addGoodsSkus.size()){
                throw new HuhuaminExceptionPlan("增加商品规格失败！");
            }
        }


        // ======= 处理商品SKU 结束

        // ======= 处理商品描述 开始
        List<GoodsDetail> goodsDetailList = new ArrayList<GoodsDetail>();
        List<GoodsImages> goodsImagesList = new ArrayList<GoodsImages>();
        List<String> detailIdList =goodsDetailMapper.queryDetailIdByGoodsId(goodsId);
        dealGoodsDesc(reqAddGoods,goodsDetailList,goodsImagesList,goodsId,userId);
        if (goodsDetailList != null && goodsDetailList.size() > 0) {
            goodsDetailMapper.deleteGoodsDetailByGoodsId(goodsId);
            count=goodsDetailMapper.batchInsert(goodsDetailList);
            if(count!=goodsDetailList.size()){
                throw new HuhuaminExceptionPlan("增加商品详情内容失败！");
            }
        }

        // ======= 处理商品图片 开始 goodsImgList
        if (StringUtil.isNotBlank(reqAddGoods.getGoodsImgList())) {
            List<String> goodsImgList=Arrays.asList(reqAddGoods.getGoodsImgList().split(","));
            for (String goodsImgUrl: goodsImgList) {
                GoodsImages goodsImages = new GoodsImages();
                goodsImages.setImgId(UUIDUtils.generateUuid22());
                goodsImages.setSourceId(goodsId);
                goodsImages.setSourceType((byte)1);
                goodsImages.setImgUrl(goodsImgUrl);
                goodsImages.setAddBy(userId);
                goodsImages.setAddTime(new Date());
                goodsImages.setOrderBy(0);
                goodsImagesList.add(goodsImages);
            }
        }
        // ======= 处理商品图片 结束
              detailIdList.add(goodsId);
        goodsImagesMapper.deleteGoodsImagesBySourceId(detailIdList);
        if (goodsImagesList != null && goodsImagesList.size() > 0) {
            count=goodsImagesMapper.batchInsert(goodsImagesList);
            if(count!=goodsImagesList.size()){
                throw new HuhuaminExceptionPlan("增加商品详情图片失败！");
            }
        }
    }

/***************************************************修改商品结束************************************************************************************/

/***************************************************商品详情开始************************************************************************************/
    /**
     * 商品详情
     * @param reqAddGoods
     * @param userId
     * @return
     */
    @Transactional
    public TypeJsonResult goodsDetail(String id,String userId) {
        try {
            TypeJsonResult jsonResult=new TypeJsonResult();
            Map map=new HashMap();
            String priceTransformationMaxPoint= systemParamMapper.selectByIndex("price_transformation_max_point").getParamValue();
            map.put("priceTransformationMaxPoint", priceTransformationMaxPoint);

            map.put("shopType",  shopMapper.selectShortByPrimaryKey(systemUserMapper.queryShopIdByUserId(userId)).getShopType());


            Goods goods = goodsMapper.selectByPrimaryKey(id);
            map.put("goods", goods);
            String[] ids = goods.getCatPath().split(",");
            List<Category> cateList = categoryMapper.getCateListByIDS(Arrays.asList(ids));
            String catePathStr = "";
            for (int i = 0; i < cateList.size(); i++) {
                if (i == cateList.size() - 1) {
                    catePathStr += cateList.get(i).getCatName();
                } else {
                    catePathStr += cateList.get(i).getCatName() + " > ";
                }
            }
            map.put("catePathStr", catePathStr);
            // 根据分类，获取分类关联的商品属性
            List<CategoryAttribute> attrList = categoryAttributeMapper.getAttrOptionByCatId(goods.getCatId());
            map.put("attrList", attrList);
            // 查询与商品关联的商品标签
            /*List<GoodsTags> goodsTagsList = goodsTagsMapper.getGoodsTagDetail(id);
            map.put("goodsTagsList", goodsTagsList);*/
            // 查询商品图片集
            GoodsImages goodsImages = new GoodsImages();
            /*goodsImages.setSourceId(id);
            goodsImages.setSourceType((byte)1);*/
            List<GoodsImages> goodsImgList = goodsImagesMapper.listAll(id,(byte)1);
            map.put("goodsImgList", goodsImgList);
            // 取商品的SKU编码
            /*GoodsSku goodsSku = new GoodsSku();
            goodsSku.setGoodsId(id);*/
            List<GoodsSku> goodsSkuList = goodsSkuMapper.getGoodsSkuByGoodsId(id);
            map.put("goodsSkuList", goodsSkuList);
            Set<String> specOptionId = new HashSet<String>();
            for (GoodsSku goodsSku2 : goodsSkuList) {
                if (!StringUtil.isEmpty(goodsSku2.getMainSpecOpt())) {
                    specOptionId.add(goodsSku2.getMainSpecOpt());
                }
                if (!StringUtil.isEmpty(goodsSku2.getViceSpecOpt())) {
                    specOptionId.add(goodsSku2.getViceSpecOpt());
                }
            }

            List<SpecificationOption> specOptionList = new ArrayList<SpecificationOption>();
            if(specOptionId.isEmpty()) {
                specOptionList=specificationOptionMapper.listAll(new ArrayList<>(specOptionId));
            }
            List<GoodsDetail> goodsDetailList = goodsDetailMapper.selectByGoodsId(id);
            List<GoodsDetail> productDetailList = new ArrayList<GoodsDetail>();
            List<GoodsDetail> wholeDetailList = new ArrayList<GoodsDetail>();
            List<GoodsDetail> wearDetailList = new ArrayList<GoodsDetail>();
            List<GoodsDetail> detailtDetailList = new ArrayList<GoodsDetail>();
            List<GoodsDetail> brankDetailList = new ArrayList<GoodsDetail>();
            List<GoodsDetail> packDetailList = new ArrayList<GoodsDetail>();
            List<GoodsDetail> serviceDetailList = new ArrayList<GoodsDetail>();
            List<GoodsDetail> quaDetailList = new ArrayList<GoodsDetail>();
            List<GoodsDetail> shopDetailList = new ArrayList<GoodsDetail>();
            List<GoodsDetail> selfList = new ArrayList<GoodsDetail>();
            // [1-尺码说明 2-穿着效果 3-整体款式 4-细节做工 5-产品介绍 6-品牌介绍 7-包装展示 8-服务说明 9-资质证明
            // 10-店铺信息 0-自定义模块]
            for (GoodsDetail goodsDetail2 : goodsDetailList) {
                if ((int) goodsDetail2.getDetailType() == 2) {
                    wearDetailList.add(goodsDetail2);
                    goodsDetail2.setImgList(goodsImagesMapper.queryImgUrls(goodsDetail2.getDetailId(),(byte)6));

                }else if ((int) goodsDetail2.getDetailType() == 3){
                    wholeDetailList.add(goodsDetail2);
                   goodsDetail2.setImgList(goodsImagesMapper.queryImgUrls(goodsDetail2.getDetailId(),(byte)6));
                }else if ((int) goodsDetail2.getDetailType() == 4){
                    detailtDetailList.add(goodsDetail2);
                goodsDetail2.setImgList(goodsImagesMapper.queryImgUrls(goodsDetail2.getDetailId(),(byte)6));
                }else if ((int) goodsDetail2.getDetailType() == 5){
                    productDetailList.add(goodsDetail2);
                goodsDetail2.setImgList(goodsImagesMapper.queryImgUrls(goodsDetail2.getDetailId(),(byte)6));
                }else if ((int) goodsDetail2.getDetailType() == 6){
                    brankDetailList.add(goodsDetail2);
                goodsDetail2.setImgList(goodsImagesMapper.queryImgUrls(goodsDetail2.getDetailId(),(byte)6));
                }else if ((int) goodsDetail2.getDetailType() == 7){
                    packDetailList.add(goodsDetail2);
                goodsDetail2.setImgList(goodsImagesMapper.queryImgUrls(goodsDetail2.getDetailId(),(byte)6));
                }else if ((int) goodsDetail2.getDetailType() == 8){
                    serviceDetailList.add(goodsDetail2);
                goodsDetail2.setImgList(goodsImagesMapper.queryImgUrls(goodsDetail2.getDetailId(),(byte)6));
                }else if ((int) goodsDetail2.getDetailType() == 9){
                    quaDetailList.add(goodsDetail2);
                goodsDetail2.setImgList(goodsImagesMapper.queryImgUrls(goodsDetail2.getDetailId(),(byte)6));
                }else if ((int) goodsDetail2.getDetailType() == 10){
                    shopDetailList.add(goodsDetail2);
                goodsDetail2.setImgList(goodsImagesMapper.queryImgUrls(goodsDetail2.getDetailId(),(byte)6));
                }else if ((int) goodsDetail2.getDetailType() == 0) {
                    selfList.add(goodsDetail2);
                    goodsDetail2.setImgList(goodsImagesMapper.queryImgUrls(goodsDetail2.getDetailId(), (byte) 6));
                }
            }
            map.put("wearDetailList", wearDetailList);
            map.put("wholeDetailList", wholeDetailList);
            map.put("detailtDetailList", detailtDetailList);
            map.put("productDetailList", productDetailList);
            map.put("brankDetailList", brankDetailList);
            map.put("packDetailList", packDetailList);
            map.put("serviceDetailList", serviceDetailList);
            map.put("quaDetailList", quaDetailList);
            map.put("shopDetailList", shopDetailList);
            map.put("selfList", selfList);

            jsonResult.setType(map);
            jsonResult.setStatusCode(true);
            return  jsonResult;
        } catch (Exception e) {
            String msg = "商品详情";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage());
        }
    }
/***************************************************商品详情结束************************************************************************************/
}
