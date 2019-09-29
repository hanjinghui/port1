package com.louquanapp.req;


import org.hibernate.validator.constraints.Range;

public class ReqFavCountType extends ReqToken {
    /**
     * 点赞类型[1-短视频 2-直播] 默认2
     */
    @Range(message = "点赞类型范围[1-短视频 2-直播]",min = 1,max = 2)
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
