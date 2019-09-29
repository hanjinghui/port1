package com.louquanapp.web.search;

import com.louquanapp.biz.SearchOptBiz;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqComm;
import com.louquanapp.resp.SearchOptDto;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/2 11:56
 * @Description: 搜索相关业务逻辑处理
 */
@RestController
@RequestMapping("/api/no")
public class SearchOptController {
    private final SearchOptBiz searchOptBiz;

    public SearchOptController(SearchOptBiz searchOptBiz) {
        this.searchOptBiz = searchOptBiz;
    }


    /**
     * 获取最后搜索弹框中的数据
     *
     * @param catId
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("searchOpt/{id}")
    public TypeJsonResult<SearchOptDto> selectMinBrandByCatId(@PathVariable("id") String catId, @RequestBody @Valid ReqComm reqSource, BindingResult bindingResult) {
        return searchOptBiz.searchOptByCatId(catId);
    }


}
