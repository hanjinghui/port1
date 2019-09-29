package com.louquanapp.resp;

import com.louquanapp.dao.model.Attribute;
import com.louquanapp.dao.model.Brand;
import com.louquanapp.dao.model.Category;
import com.louquanapp.dao.model.Specification;

import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/3 13:08
 * @Description:
 */
public class SearchOptDto {
    /**
     * 第三级别分类
     */
    List<Category> cats;
    /**
     * 搜索中的品牌
     */
    private List<Brand> brands;
    private List<Specification> specifications;
    /**
     * 自定义属性有下来的
     */
    private List<Attribute> attributes;

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public List<Category> getCats() {
        return cats;
    }

    public void setCats(List<Category> cats) {
        this.cats = cats;
    }

    public List<Specification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<Specification> specifications) {
        this.specifications = specifications;
    }
}
