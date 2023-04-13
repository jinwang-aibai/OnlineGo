package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Step;

/**
 * 步骤Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
public interface StepMapper 
{
    /**
     * 查询步骤
     * 
     * @param id 步骤主键
     * @return 步骤
     */
    public Step selectStepById(Long id);

    /**
     * 查询步骤列表
     * 
     * @param step 步骤
     * @return 步骤集合
     */
    public List<Step> selectStepList(Step step);

    /**
     * 新增步骤
     * 
     * @param step 步骤
     * @return 结果
     */
    public int insertStep(Step step);

    /**
     * 修改步骤
     * 
     * @param step 步骤
     * @return 结果
     */
    public int updateStep(Step step);

    /**
     * 删除步骤
     * 
     * @param id 步骤主键
     * @return 结果
     */
    public int deleteStepById(Long id);

    /**
     * 批量删除步骤
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStepByIds(String[] ids);
}
