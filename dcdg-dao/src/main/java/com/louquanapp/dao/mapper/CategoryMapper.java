package com.louquanapp.dao.mapper;

import com.louquanapp.dao.config.MapF2F;
import com.louquanapp.dao.model.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryMapper {
    /**
     * dcdg_goods_category_base 根据主键删除
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    int deleteByPrimaryKey(String catId);

    /**
     * dcdg_goods_category_base  插入
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    int insert(Category record);

    /**
     * dcdg_goods_category_base 根据主键查询
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    Category selectByPrimaryKey(String catId);

    /**
     * dcdg_goods_category_base 查找所有
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    List<Category> selectAll();


    /**
     * dcdg_goods_category_base 根据主键修改
     *
     * @mbg.generated Sun Mar 31 21:16:57 CST 2019
     */
    int updateByPrimaryKey(Category record);

    /**
     * 获取 首页为您推荐 分类
     *
     * @return
     */
    List<Category> selectHomeCatRecommend();

    /**
     * 根据父亲获取下属分类
     *
     * @return
     */
    List<Category> selectCatByParentId(@Param("pId") String pId);

    /**
     * 获取热门分类
     *
     * @return
     */
    List<Category> hotCategory();

    String getCatNameByCatId(@Param("catId") String catId);

    @MapF2F
    Map<String, String> selectCatNameByCatIds(@Param("catIds") List<String> catIds);

    List<Category> getCategoryListByPIdForGoods(@Param("pId") String pId,@Param("saleFlag") String saleFlag
    ,@Param("isVideo") String isVideo,@Param("id") String id);


    List<Category> getCateListByIDS(@Param("array") List<String> catIds);
}