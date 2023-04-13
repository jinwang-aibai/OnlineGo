package com.ruoyi.web.controller.system;

import java.util.List;
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
import com.ruoyi.system.domain.Game;
import com.ruoyi.system.service.IGameService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 对局 Controller
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Controller
@RequestMapping("/system/game")
public class GameController extends BaseController
{
    private String prefix = "system/game";

    @Autowired
    private IGameService gameService;

    @RequiresPermissions("system:game:view")
    @GetMapping()
    public String game()
    {
        return prefix + "/game";
    }

    /**
     * 查询对局 列表
     */
    @RequiresPermissions("system:game:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Game game)
    {
        startPage();
        List<Game> list = gameService.selectGameList(game);
        return getDataTable(list);
    }

    /**
     * 导出对局 列表
     */
    @RequiresPermissions("system:game:export")
    @Log(title = "对局 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Game game)
    {
        List<Game> list = gameService.selectGameList(game);
        ExcelUtil<Game> util = new ExcelUtil<Game>(Game.class);
        return util.exportExcel(list, "对局 数据");
    }

    /**
     * 新增对局 
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存对局 
     */
    @RequiresPermissions("system:game:add")
    @Log(title = "对局 ", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Game game)
    {
        return toAjax(gameService.insertGame(game));
    }

    /**
     * 修改对局 
     */
    @RequiresPermissions("system:game:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Game game = gameService.selectGameById(id);
        mmap.put("game", game);
        return prefix + "/edit";
    }

    /**
     * 修改保存对局 
     */
    @RequiresPermissions("system:game:edit")
    @Log(title = "对局 ", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Game game)
    {
        return toAjax(gameService.updateGame(game));
    }

    /**
     * 删除对局 
     */
    @RequiresPermissions("system:game:remove")
    @Log(title = "对局 ", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gameService.deleteGameByIds(ids));
    }
}
