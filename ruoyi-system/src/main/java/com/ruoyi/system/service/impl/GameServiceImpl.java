package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GameMapper;
import com.ruoyi.system.domain.Game;
import com.ruoyi.system.service.IGameService;
import com.ruoyi.common.core.text.Convert;

/**
 * 对局 Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Service
public class GameServiceImpl implements IGameService 
{
    @Autowired
    private GameMapper gameMapper;

    /**
     * 查询对局 
     * 
     * @param id 对局 主键
     * @return 对局 
     */
    @Override
    public Game selectGameById(Long id)
    {
        return gameMapper.selectGameById(id);
    }

    /**
     * 查询对局 列表
     * 
     * @param game 对局 
     * @return 对局 
     */
    @Override
    public List<Game> selectGameList(Game game)
    {
        return gameMapper.selectGameList(game);
    }

    /**
     * 新增对局 
     * 
     * @param game 对局 
     * @return 结果
     */
    @Override
    public int insertGame(Game game)
    {
        game.setCreateTime(DateUtils.getNowDate());
        return gameMapper.insertGame(game);
    }

    /**
     * 修改对局 
     * 
     * @param game 对局 
     * @return 结果
     */
    @Override
    public int updateGame(Game game)
    {
        game.setUpdateTime(DateUtils.getNowDate());
        return gameMapper.updateGame(game);
    }

    /**
     * 批量删除对局 
     * 
     * @param ids 需要删除的对局 主键
     * @return 结果
     */
    @Override
    public int deleteGameByIds(String ids)
    {
        return gameMapper.deleteGameByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除对局 信息
     * 
     * @param id 对局 主键
     * @return 结果
     */
    @Override
    public int deleteGameById(Long id)
    {
        return gameMapper.deleteGameById(id);
    }
}
