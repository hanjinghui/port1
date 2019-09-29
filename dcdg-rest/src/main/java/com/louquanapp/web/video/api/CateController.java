package com.louquanapp.web.video.api;

import com.louquanapp.biz.CateBiz;
import com.louquanapp.dao.model.Cate;
import com.louquanapp.model.PageJsonResult;
import com.louquanapp.req.ReqCommPage;
import com.louquanapp.service.JedisService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/17 17:06
 * @description:  美食
 */
@RestController
@RequestMapping("/api/no/cate")
public class CateController {

    private  final CateBiz cateBiz;

    public CateController(CateBiz cateBiz) {
        this.cateBiz = cateBiz;
    }

    /**
     * 查询美食列表
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("/cates")
    public PageJsonResult<Cate> queryGameList(@RequestBody @Valid ReqCommPage reqSource, BindingResult bindingResult) {
        return cateBiz.cates(reqSource);
    }
}
