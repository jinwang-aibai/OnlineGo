package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FriendMapper;
import com.ruoyi.system.domain.Friend;
import com.ruoyi.system.service.IFriendService;
import com.ruoyi.common.core.text.Convert;

/**
 * 好友信息Service业务层处理
 * 
 * @author jp
 * @date 2023-04-11
 */
@Service
public class FriendServiceImpl implements IFriendService 
{
    @Autowired
    private FriendMapper friendMapper;

    /**
     * 查询好友信息
     * 
     * @param id 好友信息主键
     * @return 好友信息
     */
    @Override
    public Friend selectFriendById(Long id)
    {
        return friendMapper.selectFriendById(id);
    }

    /**
     * 查询好友信息列表
     * 
     * @param friend 好友信息
     * @return 好友信息
     */
    @Override
    public List<Friend> selectFriendList(Friend friend)
    {
        return friendMapper.selectFriendList(friend);
    }

    /**
     * 新增好友信息
     * 
     * @param friend 好友信息
     * @return 结果
     */
    @Override
    public int insertFriend(Friend friend)
    {
        friend.setCreateTime(DateUtils.getNowDate());
        return friendMapper.insertFriend(friend);
    }

    /**
     * 修改好友信息
     * 
     * @param friend 好友信息
     * @return 结果
     */
    @Override
    public int updateFriend(Friend friend)
    {
        friend.setUpdateTime(DateUtils.getNowDate());
        return friendMapper.updateFriend(friend);
    }

    /**
     * 批量删除好友信息
     * 
     * @param ids 需要删除的好友信息主键
     * @return 结果
     */
    @Override
    public int deleteFriendByIds(String ids)
    {
        return friendMapper.deleteFriendByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除好友信息信息
     * 
     * @param id 好友信息主键
     * @return 结果
     */
    @Override
    public int deleteFriendById(Long id)
    {
        return friendMapper.deleteFriendById(id);
    }
}
