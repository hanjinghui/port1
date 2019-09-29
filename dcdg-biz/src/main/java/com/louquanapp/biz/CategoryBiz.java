package com.louquanapp.biz;

import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.louquanapp.dao.mapper.CategoryMapper;
import com.louquanapp.dao.model.Category;
import com.louquanapp.model.TypeJsonResult;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2019/3/31 21:33
 * @Description: 分类业务逻辑
 */
@Service
public class CategoryBiz {
    /**
     * 直播（餐饮类） id
     */
    public final static String CAN_YIN = "20190425123656yhi1X9by";
    private final CategoryMapper categoryMapper;

    public CategoryBiz(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    /**
     * 获取 首页为您推荐 分类
     *
     * @param reqComm
     * @return
     */
    public TypeJsonResult<List<Category>> selectHomeCatRecommend() {

        try {
            TypeJsonResult<List<Category>> jsonResult = new TypeJsonResult<List<Category>>();
            jsonResult.setStatusCode(false);

            List<Category> list = categoryMapper.selectHomeCatRecommend();
            jsonResult.setType(list);

            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }

            throw new HuhuaminException("在获取首页推荐列表过程中，服务器开小差了!", e);
        }
    }

    /**
     * 获取 热门 分类
     *
     * @param reqComm
     * @return
     */
    public TypeJsonResult<List<Category>> hotCategory() {

        try {
            TypeJsonResult<List<Category>> jsonResult = new TypeJsonResult<List<Category>>();
            jsonResult.setStatusCode(false);
            List<Category> list = categoryMapper.hotCategory();

            for(int i = list.size() - 1; i >= 0; i--){
                if(list.get(i).getCatPath().contains(CAN_YIN)){
                    list.remove(i);
                }
            }


            jsonResult.setType(list);
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }

            throw new HuhuaminException("在获取热门分类列表过程中，服务器开小差了!", e);
        }
    }

    public TypeJsonResult<List<Category>> selectCat() {
        try {
            TypeJsonResult<List<Category>> jsonResult = new TypeJsonResult<List<Category>>();
            jsonResult.setStatusCode(false);

            List<Category> list = categoryMapper.selectHomeCatRecommend();
            jsonResult.setType(list);

            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }

            throw new HuhuaminException("在获取首页推荐列表过程中，服务器开小差了!", e);
        }
    }

    public TypeJsonResult<List<Category>> cats() {
        try {
            TypeJsonResult<List<Category>> jsonResult = new TypeJsonResult<List<Category>>();
            jsonResult.setStatusCode(false);

            List<Category> list = categoryMapper.selectCatByParentId("0");
            for(int i = list.size() - 1; i >= 0; i--){
                List<Category> listT = categoryMapper.selectCatByParentId(list.get(i).getCatId());

                for(int j = listT.size() - 1; j >= 0; j--){
                        if(listT.get(j).getCatPath().contains(CAN_YIN)){
                        listT.remove(j);
                    }
                }

                list.get(i).setChilds(listT);
            }



            //去掉空孩子
            List<Category> list1 = new ArrayList<>();
            list.stream().forEach(t -> {
                if (CollectionUtils.isNotEmpty(t.getChilds())) {
                    list1.add(t);
                }
            });


            jsonResult.setType(list1);
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }

            throw new HuhuaminException("在获取首页分类列表过程中，服务器开小差了!", e);
        }
    }

}
