package com.louquanapp.dao.model;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 dcdg_basic_game_base
 *
 * @mbg.generated do_not_delete_during_merge Tue May 07 19:54:41 CST 2019
 */
public class Game {
    /**
     *   主键
     *
     * 数据库字段名:dcdg_basic_game_base.GAME_ID
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    private String gameId;

    /**
     *   游戏名称
     *
     * 数据库字段名:dcdg_basic_game_base.GAME_NAME
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    private String gameName;

    /**
     *   游戏主图
     *
     * 数据库字段名:dcdg_basic_game_base.GAME_IMG
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    private String gameImg;

    /**
     *   游戏链接
     *
     * 数据库字段名:dcdg_basic_game_base.GAME_URL
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    private String gameUrl;

    /**
     *   在线人数 
     *
     * 数据库字段名:dcdg_basic_game_base.GAME_PEOPLE_NUM
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    private Integer gamePeopleNum;

    /**
     *   排序
     *
     * 数据库字段名:dcdg_basic_game_base.GAME_SEQUENCE
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    private Integer gameSequence;

    /**
     *   状态[1-已发布 2-未发布]
     *
     * 数据库字段名:dcdg_basic_game_base.GAME_STATUS
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    private Byte gameStatus;

    /**
     *   添加时间
     *
     * 数据库字段名:dcdg_basic_game_base.ADD_TIME
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    private Date addTime;

    /**
     *   更新时间
     *
     * 数据库字段名:dcdg_basic_game_base.UPDATE_TIME
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    private Date updateTime;

    /**
     *   游戏分类[1-热门]
     *
     * 数据库字段名:dcdg_basic_game_base.GAME_CAT
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    private Byte gameCat;

    /**
     *   推荐[1-是 2-否]
     *
     * 数据库字段名:dcdg_basic_game_base.IS_REC
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    private Byte isRec;

    /**
     *   推荐图
     *
     * 数据库字段名:dcdg_basic_game_base.REC_IMG
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    private String recImg;

    /**
     * 数据库字段：主键dcdg_basic_game_base.GAME_ID
     *
     * @return  the value of dcdg_basic_game_base.GAME_ID
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public String getGameId() {
        return gameId;
    }

    /**
     * 数据库字段：主键dcdg_basic_game_base.GAME_ID
     * @param gameId the value for dcdg_basic_game_base.GAME_ID
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public void setGameId(String gameId) {
        this.gameId = gameId == null ? null : gameId.trim();
    }

    /**
     * 数据库字段：游戏名称dcdg_basic_game_base.GAME_NAME
     *
     * @return  the value of dcdg_basic_game_base.GAME_NAME
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * 数据库字段：游戏名称dcdg_basic_game_base.GAME_NAME
     * @param gameName the value for dcdg_basic_game_base.GAME_NAME
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public void setGameName(String gameName) {
        this.gameName = gameName == null ? null : gameName.trim();
    }

    /**
     * 数据库字段：游戏主图dcdg_basic_game_base.GAME_IMG
     *
     * @return  the value of dcdg_basic_game_base.GAME_IMG
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public String getGameImg() {
        return gameImg;
    }

    /**
     * 数据库字段：游戏主图dcdg_basic_game_base.GAME_IMG
     * @param gameImg the value for dcdg_basic_game_base.GAME_IMG
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public void setGameImg(String gameImg) {
        this.gameImg = gameImg == null ? null : gameImg.trim();
    }

    /**
     * 数据库字段：游戏链接dcdg_basic_game_base.GAME_URL
     *
     * @return  the value of dcdg_basic_game_base.GAME_URL
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public String getGameUrl() {
        return gameUrl;
    }

    /**
     * 数据库字段：游戏链接dcdg_basic_game_base.GAME_URL
     * @param gameUrl the value for dcdg_basic_game_base.GAME_URL
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public void setGameUrl(String gameUrl) {
        this.gameUrl = gameUrl == null ? null : gameUrl.trim();
    }

    /**
     * 数据库字段：在线人数 dcdg_basic_game_base.GAME_PEOPLE_NUM
     *
     * @return  the value of dcdg_basic_game_base.GAME_PEOPLE_NUM
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public Integer getGamePeopleNum() {
        return gamePeopleNum;
    }

    /**
     * 数据库字段：在线人数 dcdg_basic_game_base.GAME_PEOPLE_NUM
     * @param gamePeopleNum the value for dcdg_basic_game_base.GAME_PEOPLE_NUM
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public void setGamePeopleNum(Integer gamePeopleNum) {
        this.gamePeopleNum = gamePeopleNum;
    }

    /**
     * 数据库字段：排序dcdg_basic_game_base.GAME_SEQUENCE
     *
     * @return  the value of dcdg_basic_game_base.GAME_SEQUENCE
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public Integer getGameSequence() {
        return gameSequence;
    }

    /**
     * 数据库字段：排序dcdg_basic_game_base.GAME_SEQUENCE
     * @param gameSequence the value for dcdg_basic_game_base.GAME_SEQUENCE
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public void setGameSequence(Integer gameSequence) {
        this.gameSequence = gameSequence;
    }

    /**
     * 数据库字段：状态[1-已发布 2-未发布]dcdg_basic_game_base.GAME_STATUS
     *
     * @return  the value of dcdg_basic_game_base.GAME_STATUS
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public Byte getGameStatus() {
        return gameStatus;
    }

    /**
     * 数据库字段：状态[1-已发布 2-未发布]dcdg_basic_game_base.GAME_STATUS
     * @param gameStatus the value for dcdg_basic_game_base.GAME_STATUS
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public void setGameStatus(Byte gameStatus) {
        this.gameStatus = gameStatus;
    }

    /**
     * 数据库字段：添加时间dcdg_basic_game_base.ADD_TIME
     *
     * @return  the value of dcdg_basic_game_base.ADD_TIME
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间dcdg_basic_game_base.ADD_TIME
     * @param addTime the value for dcdg_basic_game_base.ADD_TIME
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：更新时间dcdg_basic_game_base.UPDATE_TIME
     *
     * @return  the value of dcdg_basic_game_base.UPDATE_TIME
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据库字段：更新时间dcdg_basic_game_base.UPDATE_TIME
     * @param updateTime the value for dcdg_basic_game_base.UPDATE_TIME
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 数据库字段：游戏分类[1-热门]dcdg_basic_game_base.GAME_CAT
     *
     * @return  the value of dcdg_basic_game_base.GAME_CAT
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public Byte getGameCat() {
        return gameCat;
    }

    /**
     * 数据库字段：游戏分类[1-热门]dcdg_basic_game_base.GAME_CAT
     * @param gameCat the value for dcdg_basic_game_base.GAME_CAT
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public void setGameCat(Byte gameCat) {
        this.gameCat = gameCat;
    }

    /**
     * 数据库字段：推荐[1-是 2-否]dcdg_basic_game_base.IS_REC
     *
     * @return  the value of dcdg_basic_game_base.IS_REC
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public Byte getIsRec() {
        return isRec;
    }

    /**
     * 数据库字段：推荐[1-是 2-否]dcdg_basic_game_base.IS_REC
     * @param isRec the value for dcdg_basic_game_base.IS_REC
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public void setIsRec(Byte isRec) {
        this.isRec = isRec;
    }

    /**
     * 数据库字段：推荐图dcdg_basic_game_base.REC_IMG
     *
     * @return  the value of dcdg_basic_game_base.REC_IMG
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public String getRecImg() {
        return recImg;
    }

    /**
     * 数据库字段：推荐图dcdg_basic_game_base.REC_IMG
     * @param recImg the value for dcdg_basic_game_base.REC_IMG
     *
     * @mbg.generated Tue May 07 19:54:41 CST 2019
     */
    public void setRecImg(String recImg) {
        this.recImg = recImg == null ? null : recImg.trim();
    }
}