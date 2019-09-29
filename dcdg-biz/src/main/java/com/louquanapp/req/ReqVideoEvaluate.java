package com.louquanapp.req;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ReqVideoEvaluate extends ReqToken {
    /**
     * 父节点主键   增加二级评论时需要
     */
    private String parentId;

    @NotNull(message = "评论内容")
    @Size(min = 1, max = 100, message = "评论内容字符范围[1-100]")
    private String evaluateCont;

    /**
     * 视频id
     */
    private String videoId;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getEvaluateCont() {
        return evaluateCont;
    }

    public void setEvaluateCont(String evaluateCont) {
        this.evaluateCont = evaluateCont;
    }
}
