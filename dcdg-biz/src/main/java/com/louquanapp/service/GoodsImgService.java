package com.louquanapp.service;

import com.louquanapp.dao.mapper.GoodsImagesMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2019年04月11日21:30:42
 */
@Service
public class GoodsImgService {

    private final GoodsImagesMapper goodsImagesMapper;

    public GoodsImgService(GoodsImagesMapper goodsImagesMapper) {
        this.goodsImagesMapper = goodsImagesMapper;
    }


    public List<String> getImgUrlBySourceId(String sourceId) {
        return goodsImagesMapper.getImgUrlBySourceId(sourceId);
    }


}
