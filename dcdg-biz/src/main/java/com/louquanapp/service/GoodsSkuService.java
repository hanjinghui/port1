package com.louquanapp.service;

import com.louquanapp.dao.mapper.GoodsSkuMapper;
import com.louquanapp.dao.mapper.SpecificationMapper;
import com.louquanapp.dao.mapper.SpecificationOptionMapper;
import com.louquanapp.dao.model.GoodsSku;
import com.louquanapp.resp.ShortSpec;
import com.louquanapp.resp.ShortSpecOpt;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2019年04月11日21:30:36
 */
@Service
public class GoodsSkuService {

    private final GoodsSkuMapper goodsSkuMapper;

    public GoodsSkuService(GoodsSkuMapper goodsSkuMapper) {
        this.goodsSkuMapper = goodsSkuMapper;
    }

    /**
     * 根据 商品id 获取 商品Sku
     * <p>
     * 获取默认的选中sku
     *
     * @param goodsId
     * @return
     */
    public List<GoodsSku> getGoodsSkuByGoodsId(String goodsId, GoodsSku shortGoodsSku) {
        List<GoodsSku> tempList = goodsSkuMapper.getGoodsSkuByGoodsId(goodsId);

        boolean changeFlag = false;
        if (null!=shortGoodsSku&&StringUtils.isNotEmpty(shortGoodsSku.getSkuId())) {
            for (GoodsSku temp : tempList
            ) {
                if (shortGoodsSku.getSkuId().equals(temp.getSkuId())) {
                    changeFlag = true;
                    temp.setSelected(true);
                    BeanUtils.copyProperties(temp, shortGoodsSku);
                }
            }
        }

        if (null!=shortGoodsSku&& !changeFlag) {
            GoodsSku selectGoodsSku = null;
            tempList.sort(Comparator.comparing(GoodsSku::getPutawayPrice));
            selectGoodsSku = tempList.get(0);
            selectGoodsSku.setSelected(true);
            BeanUtils.copyProperties(selectGoodsSku, shortGoodsSku);

        }
        return tempList;
    }

    /**
     * @param tempList
     * @param selectedGoodsSku
     * @param specificationService
     * @param specificationOptService
     * @return
     */
    public ShortSpec getMainShortSpec(List<GoodsSku> tempList, GoodsSku selectedGoodsSku, SpecificationMapper specificationMapper, SpecificationOptionMapper specificationOptionMapper) {

        String mainSpecName = specificationMapper.getSpecNameBySpecId(selectedGoodsSku.getMainSpec());
        ShortSpec shortSpec = new ShortSpec();
        shortSpec.setSpecId(selectedGoodsSku.getMainSpec());
        shortSpec.setSpecName(mainSpecName);
        Set<String> optIds = new HashSet<>();
        for (GoodsSku temp : tempList
        ) {
            optIds.add(temp.getMainSpecOpt());
        }
        List<String> ids = new ArrayList<>(optIds);
        if (!CollectionUtils.isEmpty(ids)) {
            Map<String, String> map = specificationOptionMapper.mapSpecOptNameByOptIds(ids);
            List<ShortSpecOpt> listTemp = convertToListShortGoods(map, selectedGoodsSku.getMainSpecOpt());
            shortSpec.setSpecOpts(listTemp);
        }
        return shortSpec;

    }

    /**
     * @param map       数据库实体
     * @param specOptId 规格选项
     * @return 简化后实体
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    private List<ShortSpecOpt> convertToListShortGoods(Map<String, String> map, String specOptId) {

        //获取短商品
        List<ShortSpecOpt> tempList = new ArrayList<>();

        for (String temp : map.keySet()
        ) {
            ShortSpecOpt tempObj = new ShortSpecOpt();
            tempObj.setOptId(temp);
            tempObj.setOptName(map.get(temp));
            if (temp.equals(specOptId)) {
                tempObj.setSelected(true);
            }
            tempList.add(tempObj);
        }


        return tempList;
    }

    /**
     * @param tempList
     * @param selectedGoodsSku
     * @param specificationService
     * @param specificationOptService
     * @return
     */
    public ShortSpec getViceShortSpec(List<GoodsSku> tempList, GoodsSku selectedGoodsSku, SpecificationMapper specificationMapper, SpecificationOptionMapper specificationOptionMapper) {

        String viceSpecName = specificationMapper.getSpecNameBySpecId(selectedGoodsSku.getViceSpec());
        ShortSpec shortSpec = new ShortSpec();
        shortSpec.setSpecId(selectedGoodsSku.getViceSpec());
        shortSpec.setSpecName(viceSpecName);
        Set<String> optIds = new HashSet<>();
        for (GoodsSku temp : tempList
        ) {
            optIds.add(temp.getViceSpecOpt());
        }
        List<String> ids = new ArrayList<>(optIds);
        if (!CollectionUtils.isEmpty(ids)) {
            Map<String, String> map = specificationOptionMapper.mapSpecOptNameByOptIds(ids);
            List<ShortSpecOpt> listTemp = convertToListShortGoods(map, selectedGoodsSku.getViceSpecOpt());
            shortSpec.setSpecOpts(listTemp);
        }
        return shortSpec;

    }

    /**
     * 根据sku信息查询sku
     *
     * @param goodsSkuSearch
     * @return
     */
    public String getSkuIdByReqGoodsSku(GoodsSku goodsSkuSearch) {
        return goodsSkuMapper.getSkuIdByReqGoodsSku(goodsSkuSearch);
    }

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    public GoodsSku getGoodsSKuById(String id) {
        return goodsSkuMapper.selectByPrimaryKey(id);
    }


    public GoodsSku getMinGoodsSkuIdByGoodsId(String goodsId) {
        return goodsSkuMapper.getMinGoodsSkuIdByGoodsId(goodsId);
    }

    public List<String> getGoodsIdsByOptId(List<String> specOptSet) {

        return goodsSkuMapper.getGoodsIdsByOptId(specOptSet);
    }
}
