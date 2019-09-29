package com.louquanapp.req;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/25 19:52
 * @Description:
 */
public class ReqVideoCatId extends ReqCommPageIf {

    private String keywords;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    private String catId;

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }
}
