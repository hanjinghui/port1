package com.louquanapp.dao.extra;


import com.louquanapp.dao.model.AttributeOption;

import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/3 13:33
 * @Description:
 */
public class AttributeExtra {
    /**
     * 属性下的值
     */
    private List<AttributeOption> attributeOptions;

    public List<AttributeOption> getAttributeOptions() {
        return attributeOptions;
    }

    public void setAttributeOptions(List<AttributeOption> attributeOptions) {
        this.attributeOptions = attributeOptions;
    }
}
