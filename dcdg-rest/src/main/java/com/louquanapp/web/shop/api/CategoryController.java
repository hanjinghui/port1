package com.louquanapp.web.shop.api;

import com.louquanapp.biz.CategoryBiz;
import com.louquanapp.dao.model.Category;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqComm;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2019/3/31 21:41
 * @Description:
 */
@RestController
@RequestMapping("/api")
public class CategoryController {
    private final CategoryBiz categoryBiz;

    public CategoryController(CategoryBiz categoryBiz) {
        this.categoryBiz = categoryBiz;
    }


    @PostMapping("/no/homeCategory")
    public TypeJsonResult<List<Category>> selectHomeCatRecommend(@RequestBody @Valid ReqComm reqSource, BindingResult bindingResult) {
        return categoryBiz.selectHomeCatRecommend();
    }

    @PostMapping("/no/hotCategory")
    public TypeJsonResult<List<Category>> hotCat(@RequestBody @Valid ReqComm reqSource, BindingResult bindingResult) {
        return categoryBiz.hotCategory();
    }


    @PostMapping("/no/cats")
    public TypeJsonResult<List<Category>> cats(@RequestBody @Valid ReqComm reqSource, BindingResult bindingResult) {
        return categoryBiz.cats();
    }
}
