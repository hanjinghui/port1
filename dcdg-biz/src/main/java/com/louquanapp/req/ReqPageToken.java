package com.louquanapp.req;

import javax.validation.constraints.NotNull;

/**
 * @Auther: Huhuamin
 * @Date: 2018/11/15 15:36
 * @email:175759041@qq.com
 * @Description:
 */
public class ReqPageToken extends ReqToken {
    @NotNull
    private Integer pageNum;
    @NotNull
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
