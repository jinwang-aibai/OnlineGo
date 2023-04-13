package com.ruoyi.web.controller.system;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Room;
import com.ruoyi.system.service.IRoomService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 房间Controller
 * 
 * @author jp
 * @date 2023-04-11
 */
@Controller
@RequestMapping("/system/room")
public class RoomController extends BaseController
{
    private String prefix = "system/room";

    @Autowired
    private IRoomService roomService;
    @Autowired
    private ISysUserService userService;

    @RequiresPermissions("system:room:view")
    @GetMapping()
    public String room()
    {
        return prefix + "/room";
    }

    /**
     * 查询房间列表
     */
    @RequiresPermissions("system:room:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Room room)
    {
        startPage();
        List<Room> list = roomService.selectRoomList(room);
        return getDataTable(list);
    }

    /**
     * 导出房间列表
     */
    @RequiresPermissions("system:room:export")
    @Log(title = "房间", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Room room)
    {
        List<Room> list = roomService.selectRoomList(room);
        ExcelUtil<Room> util = new ExcelUtil<Room>(Room.class);
        return util.exportExcel(list, "房间数据");
    }

    /**
     * 新增房间
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @GetMapping("/weiqi")
    public String weiqi(ModelMap mmap,Long id) {
        mmap.put("id",id);
        return  "weiqi";
    }
    /**
     * 新增保存房间
     */
    @RequiresPermissions("system:room:add")
    @Log(title = "房间", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Room room)
    {
        SysUser sysUser = userService.selectUserById(super.getUserId());
        room.setCreateName(sysUser.getUserName());
        room.setCreatorId(super.getUserId());
        return toAjax(roomService.insertRoom(room));
    }

    /**
     * 修改房间
     */
    @RequiresPermissions("system:room:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Room room = roomService.selectRoomById(id);
        mmap.put("room", room);
        return prefix + "/edit";
    }

    /**
     * 修改保存房间
     */
    @RequiresPermissions("system:room:edit")
    @Log(title = "房间", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Room room)
    {
        return toAjax(roomService.updateRoom(room));
    }

    /**
     * 删除房间
     */
    @RequiresPermissions("system:room:remove")
    @Log(title = "房间", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(roomService.deleteRoomByIds(ids));
    }
}
