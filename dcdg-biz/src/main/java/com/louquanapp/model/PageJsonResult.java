package com.louquanapp.model;

import com.github.pagehelper.PageInfo;
import com.huhuamin.common.model.JsonResult;

/**
 * @Author 胡化敏
 * @Description: 分页json返回 {@link JsonResult}
 * @Date Create 2017/11/20 11:04
 * @Modified By:
 * @Since:
 */
public class PageJsonResult<T> extends JsonResult {
    private PageInfo<T> pageInfo;

    public PageJsonResult() {
        this.setStatusCode(false);

    }

    /**
     * 分页额外的信息
     */
    private Object extra;

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }

    public PageJsonResult(PageInfo<T> pageInfo) {
        setStatusCode(true);
        this.pageInfo = pageInfo;
    }


    public PageInfo<T> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }

}
