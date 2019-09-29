package com.louquanapp.resp;

import com.louquanapp.dao.model.Game;
import com.louquanapp.dao.model.Goods;

import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/12 14:18
 * @Description: 首页返回
 */
public class RespHome2 {
    List<Goods> goodsList;

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    private List<Game> games;

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
