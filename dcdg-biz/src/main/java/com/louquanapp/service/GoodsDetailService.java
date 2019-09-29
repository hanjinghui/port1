package com.louquanapp.service;

import com.louquanapp.dao.mapper.GoodsDetailMapper;
import com.louquanapp.dao.model.GoodsDetail;
import com.louquanapp.resp.GoodsDetailWithImg;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2019年04月11日21:33:43
 */
@Service
public class GoodsDetailService {
    private final GoodsDetailMapper goodsDetailMapper;

    public GoodsDetailService(GoodsDetailMapper goodsDetailMapper) {
        this.goodsDetailMapper = goodsDetailMapper;
    }


    public List<GoodsDetail> getByGoodsId(String goodsId) {
        return this.goodsDetailMapper.selectByGoodsId(goodsId);
    }

    public List<GoodsDetailWithImg> convertToDetailWithImg(List<GoodsDetail> list, GoodsImgService goodsImgService) {
        if (!CollectionUtils.isEmpty(list)) {
            List<GoodsDetailWithImg> listShort = new ArrayList<>();
            for (GoodsDetail temp : list
            ) {
                GoodsDetailWithImg gTemp = new GoodsDetailWithImg();
                BeanUtils.copyProperties(temp, gTemp);
                List<String> listStr = goodsImgService.getImgUrlBySourceId(temp.getDetailId());
                if (!CollectionUtils.isEmpty(listStr)) {
                    if (list.size() == 0) {
                        gTemp.setImgUrl(listStr.get(0));
                    } else {
                        StringBuffer sb = new StringBuffer();
                        listStr.stream().forEach((temp22) -> {
                            sb.append(temp22).append(",");
                        });
                        String imgUrl = sb.toString();
                        imgUrl = imgUrl.substring(0, imgUrl.length() - 1);
                        gTemp.setImgUrl(imgUrl);

                    }

                }

                listShort.add(gTemp);
            }
            return listShort;

        }
        return new ArrayList<>();
    }
}
