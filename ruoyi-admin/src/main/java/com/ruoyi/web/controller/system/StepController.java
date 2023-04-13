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
import com.ruoyi.system.domain.Step;
import com.ruoyi.system.service.IStepService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 步骤Controller
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Controller
@RequestMapping("/system/step")
public class StepController extends BaseController
{
    private String prefix = "system/step";

    @Autowired
    private IStepService stepService;

    @RequiresPermissions("system:step:view")
    @GetMapping()
    public String step()
    {
        return prefix + "/step";
    }

    /**
     * 查询步骤列表
     */
    @RequiresPermissions("system:step:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Step step)
    {
        startPage();
        List<Step> list = stepService.selectStepList(step);
        return getDataTable(list);
    }

    /**
     * 导出步骤列表
     */
    @RequiresPermissions("system:step:export")
    @Log(title = "步骤", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Step step)
    {
        List<Step> list = stepService.selectStepList(step);
        ExcelUtil<Step> util = new ExcelUtil<Step>(Step.class);
        return util.exportExcel(list, "步骤数据");
    }

    /**
     * 新增步骤
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存步骤
     */
    @RequiresPermissions("system:step:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Step step)
    {
        return toAjax(stepService.insertStep(step));
    }

    /**
     * 修改步骤
     */
    @RequiresPermissions("system:step:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Step step = stepService.selectStepById(id);
        mmap.put("step", step);
        return prefix + "/edit";
    }

    /**
     * 修改保存步骤
     */
    @RequiresPermissions("system:step:edit")
    @Log(title = "步骤", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Step step)
    {
        return toAjax(stepService.updateStep(step));
    }

    /**
     * 删除步骤
     */
    @RequiresPermissions("system:step:remove")
    @Log(title = "步骤", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(stepService.deleteStepByIds(ids));
    }
}
