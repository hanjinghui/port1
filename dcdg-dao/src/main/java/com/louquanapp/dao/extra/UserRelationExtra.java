package com.louquanapp.dao.extra;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/9/24 18:24
 * @description:
 */
public class UserRelationExtra  {
    /**
     * 关联级别[1-一级 2-二级 3-三级]
     */
    private Byte relationLevel;

    public Byte getRelationLevel() {
        return relationLevel;
    }

    public void setRelationLevel(Byte relationLevel) {
        this.relationLevel = relationLevel;
    }
}
