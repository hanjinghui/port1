package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Auther: zhubaorui
 * @Date: 2019/4/6 07:58
 * @Description:
 */
public class ReqPullVideo  extends ReqToken{

    /**
     * 操作方式
     */
    @NotNull(message = "操作方式不能为空！")
    @Range(min = 1,max = 4,message = "操作方式范围[1-添加视频ID集合 2-删除视频ID集合 3-添加视频用户ID 4-删除视频用户ID]")
    private Byte flay;

    /**
     * 视频ID集合
     */
    private String videoIds;
    /**
     * 视频用户ID集合
     */
    private String custIds;

    public String getCustIds() {
        return custIds;
    }

    public void setCustIds(String custIds) {
        this.custIds = custIds;
    }

    public Byte getFlay() {
        return flay;
    }

    public void setFlay(Byte flay) {
        this.flay = flay;
    }

    public String getVideoIds() {
        return videoIds;
    }

    public void setVideoIds(String videoIds) {
        this.videoIds = videoIds;
    }
}
