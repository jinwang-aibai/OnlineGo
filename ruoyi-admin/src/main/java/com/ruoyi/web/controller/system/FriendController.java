package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Friend;
import com.ruoyi.system.service.IFriendService;
import com.ruoyi.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 好友信息Controller
 *
 * @author jp
 * @date 2023-04-11
 */
@Controller
@RequestMapping("/system/friend")
public class FriendController extends BaseController
{
    private String prefix = "system/friend";

    @Autowired
    private IFriendService friendService;
    @Autowired
    private ISysUserService userService;

    @RequiresPermissions("system:friend:view")
    @GetMapping()
    public String friend(ModelMap mmap)
    {

        mmap.put("userId", super.getUserId());
        return prefix + "/friend";
    }

    /**
     * 查询好友信息列表
     */
    @RequiresPermissions("system:friend:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Friend friend)
    {
        startPage();
        friend.setFrienduserId(super.getUserId());
        friend.setAdduserId(super.getUserId());
        List<Friend> list = friendService.selectFriendList(friend);
//        friend.setFrienduserId(null);
//        List<Friend> list2 = friendService.selectFriendList(friend);
//        List<Friend> list3 =new ArrayList<>();
//        for (Friend friendList:
//             list) {
//            list3.add(friendList);
//        }
//        for (Friend friendList:
//                list2) {
//            list3.add(friendList);
//        }

        return getDataTable(list);
    }

    /**
     * 导出好友信息列表
     */
    @RequiresPermissions("system:friend:export")
    @Log(title = "好友信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Friend friend)
    {
        List<Friend> list = friendService.selectFriendList(friend);
        ExcelUtil<Friend> util = new ExcelUtil<Friend>(Friend.class);
        return util.exportExcel(list, "好友信息数据");
    }

    /**
     * 新增好友信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存好友信息
     */
    @RequiresPermissions("system:friend:add")
    @Log(title = "好友信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Friend friend)
    {
        SysUser friendInfo = userService.selectUserByUserName(friend.getFriendName());
        SysUser myInfo = userService.selectUserById(super.getUserId());
        if (friendInfo == null){
            return error("该用户名不存在");
        }

        friend.setAddName(myInfo.getUserName());
        friend.setAdduserId(super.getUserId());
        friend.setFrienduserId(friendInfo.getUserId());
        return toAjax(friendService.insertFriend(friend));
    }

    /**
     * 修改好友信息
     */
    @RequiresPermissions("system:friend:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Friend friend = friendService.selectFriendById(id);
        mmap.put("friend", friend);
        return prefix + "/edit";
    }

    /**
     * 修改保存好友信息
     */
    @RequiresPermissions("system:friend:edit")
    @Log(title = "好友信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Friend friend)
    {
        return toAjax(friendService.updateFriend(friend));
    }

    /**
     * 删除好友信息
     */
    @RequiresPermissions("system:friend:remove")
    @Log(title = "好友信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(friendService.deleteFriendByIds(ids));
    }
}
