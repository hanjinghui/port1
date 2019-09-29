package com.louquanapp.biz;

import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.louquanapp.dao.mapper.*;
import com.louquanapp.dao.model.*;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.resp.SearchOptDto;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/3 13:44
 * @Description: 搜索弹框数据业务逻辑
 */
@Service
public class SearchOptBiz {

    private final BrandMapper brandMapper;
    private final AttributeMapper attributeMapper;
    private final AttributeOptionMapper attributeOptionMapper;
    private final SpecificationOptionMapper specificationOptionMapper;
    private final SpecificationMapper specificationMapper;
    private final CategoryMapper categoryMapper;
    /**
     * 直播（餐饮类） id
     */
    public final static String CAN_YIN = "20190425123656yhi1X9by";


    public SearchOptBiz(BrandMapper brandMapper, AttributeMapper attributeMapper, AttributeOptionMapper attributeOptionMapper, SpecificationOptionMapper specificationOptionMapper, SpecificationMapper specificationMapper, CategoryMapper categoryMapper) {
        this.brandMapper = brandMapper;
        this.attributeMapper = attributeMapper;
        this.attributeOptionMapper = attributeOptionMapper;
        this.specificationOptionMapper = specificationOptionMapper;
        this.specificationMapper = specificationMapper;
        this.categoryMapper = categoryMapper;
    }

    /**
     * 根据cat 弹出搜索选择款内容
     *
     * @param catId
     * @return
     */
    public TypeJsonResult<SearchOptDto> searchOptByCatId(String catId) {
        try {
            TypeJsonResult<SearchOptDto> jsonResult = new TypeJsonResult();

            SearchOptDto searchOptDto = new SearchOptDto();
            //获取分类下的品牌
            List<Brand> brands = brandMapper.selectMinBrandByCatId(catId);
            searchOptDto.setBrands(brands);
            //获取下拉的属性，并且分组
            List<Attribute> attributes = attrOptToAttr(catId);
            searchOptDto.setAttributes(attributes);

            //获取规格，并且分组
            List<Specification> specifications = sepcOptToAttr(catId);
            searchOptDto.setSpecifications(specifications);
            //获取三级分类
            List<Category> categories = categoryMapper.selectCatByParentId(catId);
            for(int i = categories.size() - 1; i >= 0; i--){
                if(categories.get(i).getCatPath().contains(CAN_YIN)){
                    categories.remove(i);
                }
            }


            searchOptDto.setCats(categories);

            jsonResult.setType(searchOptDto);

            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            String msg = "搜索弹框数据";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            throw new HuhuaminException(msg, e);
        }
    }

    private List<Specification> sepcOptToAttr(String catId) {

        List<Specification> specifications = new ArrayList<>();
        List<SpecificationOption> specificationOptions = specificationOptionMapper.selectSpecByCatId(catId);

        Map<String, List<SpecificationOption>> map = mapSpecIdSpecification(specificationOptions);

        if (map.keySet().size() > 0) {

            for (Map.Entry<String, List<SpecificationOption>> temp :
                    map.entrySet()) {
                Specification specification = new Specification();
                specification.setSpecId(temp.getKey());
                specification.setSpecName(specificationMapper.getSpecNameBySpecId(temp.getKey()));
                specification.setSpecOpts(temp.getValue());
                specifications.add(specification);
            }

        }
        specificationOptions.forEach(t -> {
            t.setSpecOptId(t.getOptId());
            t.setOptId(null);
            t.setSpecId(null);
        });
        return specifications;
    }


    /**
     * 根据catId，将attrId  分组返回属性
     *
     * @param catId
     * @return
     */
    private List<Attribute> attrOptToAttr(String catId) {

        List<Attribute> attributes = new ArrayList<>();
        List<AttributeOption> attributeOptionList = attributeOptionMapper.selectAttrByCatId(catId);

        Map<String, List<AttributeOption>> map = mapAttrIdAttributeOption(attributeOptionList);

        if (map.keySet().size() > 0) {

            for (Map.Entry<String, List<AttributeOption>> temp :
                    map.entrySet()) {
                Attribute attribute = new Attribute();
                attribute.setAttrId(temp.getKey());
                attribute.setAttrName(attributeMapper.selectNameByPrimaryKey(temp.getKey()));
                attribute.setAttributeOptions(temp.getValue());
                attributes.add(attribute);
            }

        }
        attributeOptionList.forEach(t -> {
            t.setAttrId(null);
        });
        return attributes;
    }

    /**
     * 根据 attrId 分组
     *
     * @param attributeOptionList
     * @return
     */
    private Map<String, List<AttributeOption>> mapAttrIdAttributeOption(List<AttributeOption> attributeOptionList) {

        if (CollectionUtils.isEmpty(attributeOptionList)) {
            return new HashMap<>();
        } else {
            Map<String, List<AttributeOption>> map = new HashMap<>();

            attributeOptionList.stream().forEach(t -> {
                String attrId = t.getAttrId();
                if (map.containsKey(attrId)) {
                    map.get(attrId).add(t);
                } else {
                    List<AttributeOption> tempAttrs = new ArrayList<>();
                    tempAttrs.add(t);
                    map.put(attrId, tempAttrs);
                }
            });
            return map;
        }

    }

    /**
     * 根据 specId 分组
     *
     * @param attributeOptionList
     * @return
     */
    private Map<String, List<SpecificationOption>> mapSpecIdSpecification(List<SpecificationOption> specificationOptions) {

        if (CollectionUtils.isEmpty(specificationOptions)) {
            return new HashMap<>();
        } else {
            Map<String, List<SpecificationOption>> map = new HashMap<>();

            specificationOptions.stream().forEach(t -> {
                String specId = t.getSpecId();
                if (map.containsKey(specId)) {
                    map.get(specId).add(t);
                } else {
                    List<SpecificationOption> tempAttrs = new ArrayList<>();
                    tempAttrs.add(t);
                    map.put(specId, tempAttrs);
                }
            });
            return map;
        }

    }
}
