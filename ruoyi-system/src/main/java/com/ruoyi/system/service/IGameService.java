package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Game;

/**
 * 对局 Service接口
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
public interface IGameService 
{
    /**
     * 查询对局 
     * 
     * @param id 对局 主键
     * @return 对局 
     */
    public Game selectGameById(Long id);

    /**
     * 查询对局 列表
     * 
     * @param game 对局 
     * @return 对局 集合
     */
    public List<Game> selectGameList(Game game);

    /**
     * 新增对局 
     * 
     * @param game 对局 
     * @return 结果
     */
    public int insertGame(Game game);

    /**
     * 修改对局 
     * 
     * @param game 对局 
     * @return 结果
     */
    public int updateGame(Game game);

    /**
     * 批量删除对局 
     * 
     * @param ids 需要删除的对局 主键集合
     * @return 结果
     */
    public int deleteGameByIds(String ids);

    /**
     * 删除对局 信息
     * 
     * @param id 对局 主键
     * @return 结果
     */
    public int deleteGameById(Long id);
}
