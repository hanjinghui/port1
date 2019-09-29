package com.louquanapp.dao.extra;

import com.louquanapp.dao.model.Category;

import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/2 09:26
 * @Description:
 */
public class CategoryListExtra {

    private List<Category> childs;

    public List<Category> getChilds() {
        return childs;
    }

    public void setChilds(List<Category> childs) {
        this.childs = childs;
    }
}
