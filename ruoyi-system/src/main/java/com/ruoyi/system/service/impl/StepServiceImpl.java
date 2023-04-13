package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StepMapper;
import com.ruoyi.system.domain.Step;
import com.ruoyi.system.service.IStepService;
import com.ruoyi.common.core.text.Convert;

/**
 * 步骤Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Service
public class StepServiceImpl implements IStepService 
{
    @Autowired
    private StepMapper stepMapper;

    /**
     * 查询步骤
     * 
     * @param id 步骤主键
     * @return 步骤
     */
    @Override
    public Step selectStepById(Long id)
    {
        return stepMapper.selectStepById(id);
    }

    /**
     * 查询步骤列表
     * 
     * @param step 步骤
     * @return 步骤
     */
    @Override
    public List<Step> selectStepList(Step step)
    {
        return stepMapper.selectStepList(step);
    }

    /**
     * 新增步骤
     * 
     * @param step 步骤
     * @return 结果
     */
    @Override
    public int insertStep(Step step)
    {
        step.setCreateTime(DateUtils.getNowDate());
        return stepMapper.insertStep(step);
    }

    /**
     * 修改步骤
     * 
     * @param step 步骤
     * @return 结果
     */
    @Override
    public int updateStep(Step step)
    {
        step.setUpdateTime(DateUtils.getNowDate());
        return stepMapper.updateStep(step);
    }

    /**
     * 批量删除步骤
     * 
     * @param ids 需要删除的步骤主键
     * @return 结果
     */
    @Override
    public int deleteStepByIds(String ids)
    {
        return stepMapper.deleteStepByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除步骤信息
     * 
     * @param id 步骤主键
     * @return 结果
     */
    @Override
    public int deleteStepById(Long id)
    {
        return stepMapper.deleteStepById(id);
    }
}
