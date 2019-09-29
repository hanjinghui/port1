package com.louquanapp.req;

import javax.validation.constraints.NotBlank;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/8/22 15:26
 * @description:
 */
public class ReqDelVideos extends ReqToken{
    /**
     * 视频id集合
     */
    @NotBlank(message = "视频id集合不能为空！")
    private  String videoIds;

    public String getVideoIds() {
        return videoIds;
    }

    public void setVideoIds(String videoIds) {
        this.videoIds = videoIds;
    }
}
