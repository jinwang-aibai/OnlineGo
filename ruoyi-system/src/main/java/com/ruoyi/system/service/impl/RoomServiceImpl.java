package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RoomMapper;
import com.ruoyi.system.domain.Room;
import com.ruoyi.system.service.IRoomService;
import com.ruoyi.common.core.text.Convert;

/**
 * 房间Service业务层处理
 * 
 * @author jp
 * @date 2023-04-11
 */
@Service
public class RoomServiceImpl implements IRoomService 
{
    @Autowired
    private RoomMapper roomMapper;

    /**
     * 查询房间
     * 
     * @param id 房间主键
     * @return 房间
     */
    @Override
    public Room selectRoomById(Long id)
    {
        return roomMapper.selectRoomById(id);
    }

    /**
     * 查询房间列表
     * 
     * @param room 房间
     * @return 房间
     */
    @Override
    public List<Room> selectRoomList(Room room)
    {
        return roomMapper.selectRoomList(room);
    }

    /**
     * 新增房间
     * 
     * @param room 房间
     * @return 结果
     */
    @Override
    public int insertRoom(Room room)
    {
        room.setCreateTime(DateUtils.getNowDate());
        return roomMapper.insertRoom(room);
    }

    /**
     * 修改房间
     * 
     * @param room 房间
     * @return 结果
     */
    @Override
    public int updateRoom(Room room)
    {
        room.setUpdateTime(DateUtils.getNowDate());
        return roomMapper.updateRoom(room);
    }

    /**
     * 批量删除房间
     * 
     * @param ids 需要删除的房间主键
     * @return 结果
     */
    @Override
    public int deleteRoomByIds(String ids)
    {
        return roomMapper.deleteRoomByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除房间信息
     * 
     * @param id 房间主键
     * @return 结果
     */
    @Override
    public int deleteRoomById(Long id)
    {
        return roomMapper.deleteRoomById(id);
    }
}
