package com.louquanapp.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huhuamin.common.HuhuaminException;
import com.louquanapp.dao.mapper.CateMapper;
import com.louquanapp.dao.model.Cate;
import com.louquanapp.dao.model.Game;
import com.louquanapp.model.PageJsonResult;
import com.louquanapp.model.ReqForPageInfo;
import com.louquanapp.req.ReqCommPage;
import com.louquanapp.req.ReqTokenPage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/17 17:10
 * @description:
 */
@Service
public class CateBiz {
    private  final CateMapper cateMapper;

    public CateBiz(CateMapper cateMapper) {
        this.cateMapper = cateMapper;
    }


    /**
     *  查询游戏列表
     * @param reqSource
     * @return
     */
    public PageJsonResult<Cate> cates(ReqCommPage reqSource) {
        try {
            ReqForPageInfo reqForPageInfo=new  ReqForPageInfo (reqSource.getPageNum(),reqSource.getPageSize());

            List<Cate> list =  PageHelper.startPage(reqForPageInfo.getPageNum(), reqForPageInfo.getPageSize(),"ADD_TIME DESC").doSelectPage(()
                    -> cateMapper.selectCates());
            PageInfo<Cate> page = new PageInfo<Cate>(list);
            PageJsonResult<Cate> pageJsonResult = new PageJsonResult<Cate>(page);

            return  pageJsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminException(e.getMessage());
            } else {
                throw new HuhuaminException("查询游戏列表" + e.getMessage());
            }
        }
    }
}
