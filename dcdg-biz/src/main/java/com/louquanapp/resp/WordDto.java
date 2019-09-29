package com.louquanapp.resp;


import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2019年03月31日00:25:53
 * @email:175759041@qq.com
 * @Description: 热搜词和我的搜索
 */
public class WordDto {
    /**
     * 热搜词
     */
    private List<String> hotwords;
    /**
     * 我的搜素
     */
    private List<String> custWords;

    public List<String> getHotwords() {
        return hotwords;
    }

    public void setHotwords(List<String> hotwords) {
        this.hotwords = hotwords;
    }

    public List<String> getCustWords() {
        return custWords;
    }

    public void setCustWords(List<String> custWords) {
        this.custWords = custWords;
    }
}
