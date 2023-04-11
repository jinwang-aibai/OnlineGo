package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Friend;

/**
 * 好友信息Service接口
 * 
 * @author jp
 * @date 2023-04-11
 */
public interface IFriendService 
{
    /**
     * 查询好友信息
     * 
     * @param id 好友信息主键
     * @return 好友信息
     */
    public Friend selectFriendById(Long id);

    /**
     * 查询好友信息列表
     * 
     * @param friend 好友信息
     * @return 好友信息集合
     */
    public List<Friend> selectFriendList(Friend friend);

    /**
     * 新增好友信息
     * 
     * @param friend 好友信息
     * @return 结果
     */
    public int insertFriend(Friend friend);

    /**
     * 修改好友信息
     * 
     * @param friend 好友信息
     * @return 结果
     */
    public int updateFriend(Friend friend);

    /**
     * 批量删除好友信息
     * 
     * @param ids 需要删除的好友信息主键集合
     * @return 结果
     */
    public int deleteFriendByIds(String ids);

    /**
     * 删除好友信息信息
     * 
     * @param id 好友信息主键
     * @return 结果
     */
    public int deleteFriendById(Long id);
}
