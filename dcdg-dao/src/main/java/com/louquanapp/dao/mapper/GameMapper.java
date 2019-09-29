package com.louquanapp.dao.mapper;

import com.louquanapp.dao.model.Game;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GameMapper {
    /**
     * dcdg_basic_game_base 根据主键删除 
     *
     * @mbg.generated Wed Apr 17 15:19:34 CST 2019
     */
    int deleteByPrimaryKey(String gameId);

    /**
     * dcdg_basic_game_base  插入 
     *
     * @mbg.generated Wed Apr 17 15:19:34 CST 2019
     */
    int insert(Game record);

    /**
     * dcdg_basic_game_base 根据主键查询 
     *
     * @mbg.generated Wed Apr 17 15:19:34 CST 2019
     */
    Game selectByPrimaryKey(String gameId);

    /**
     * dcdg_basic_game_base 查找所有 
     *
     * @mbg.generated Wed Apr 17 15:19:34 CST 2019
     */
    List<Game> selectAll();

    /**
     * dcdg_basic_game_base 根据主键修改 
     *
     * @mbg.generated Wed Apr 17 15:19:34 CST 2019
     */
    int updateByPrimaryKey(Game record);

    /**
     * 查询游戏列表
     * @return
     */
    List<Game> queryGameList(@Param("catId") String catId);

    List<Game> queryGameListByCustId(@Param("catId") String catId,@Param("custId") String custId);

    List<Game> selectAllRec();
}