package com.louquanapp.dao.extra;

import com.louquanapp.dao.model.SpecificationOption;

import java.util.Set;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/9/18 20:19
 * @description:
 */
public class CategoryExtra {

    private String attrName;

    private String inputType;

    private String isMust;

    private String specName;

    private String isMain;

    private Set<SpecificationOption> specificationOptionList;

    public Set<SpecificationOption> getSpecificationOptionList() {
        return specificationOptionList;
    }

    public void setSpecificationOptionList(Set<SpecificationOption> specificationOptionList) {
        this.specificationOptionList = specificationOptionList;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getIsMust() {
        return isMust;
    }

    public void setIsMust(String isMust) {
        this.isMust = isMust;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getIsMain() {
        return isMain;
    }

    public void setIsMain(String isMain) {
        this.isMain = isMain;
    }
}
