package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 对局 对象 game
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
public class Game extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 自己姓名 */
    @Excel(name = "自己姓名")
    private String myselfName;

    /** 自己id */
    @Excel(name = "自己id")
    private Long myselfId;

    /** 对手姓名 */
    @Excel(name = "对手姓名")
    private String enemyName;

    /** 对手id */
    @Excel(name = "对手id")
    private Long enemyId;

    /** 房间id */
    @Excel(name = "房间id")
    private Long roomId;

    /** 是否有效 0：无效，1：有效 */
    @Excel(name = "是否有效 0：无效，1：有效")
    private Integer validFlag;

    /** 删除标志 1：已删除，0：未删除 */
    private Integer delFlag;

    /** 创建人id 创建者的sys_user_id */
    @Excel(name = "创建人id 创建者的sys_user_id")
    private Long creatorId;

    /** 更新人id 更新者的sys_user_id */
    @Excel(name = "更新人id 更新者的sys_user_id")
    private Long updatorId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMyselfName(String myselfName) 
    {
        this.myselfName = myselfName;
    }

    public String getMyselfName() 
    {
        return myselfName;
    }
    public void setMyselfId(Long myselfId) 
    {
        this.myselfId = myselfId;
    }

    public Long getMyselfId() 
    {
        return myselfId;
    }
    public void setEnemyName(String enemyName) 
    {
        this.enemyName = enemyName;
    }

    public String getEnemyName() 
    {
        return enemyName;
    }
    public void setEnemyId(Long enemyId) 
    {
        this.enemyId = enemyId;
    }

    public Long getEnemyId() 
    {
        return enemyId;
    }
    public void setRoomId(Long roomId) 
    {
        this.roomId = roomId;
    }

    public Long getRoomId() 
    {
        return roomId;
    }
    public void setValidFlag(Integer validFlag) 
    {
        this.validFlag = validFlag;
    }

    public Integer getValidFlag() 
    {
        return validFlag;
    }
    public void setDelFlag(Integer delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() 
    {
        return delFlag;
    }
    public void setCreatorId(Long creatorId) 
    {
        this.creatorId = creatorId;
    }

    public Long getCreatorId() 
    {
        return creatorId;
    }
    public void setUpdatorId(Long updatorId) 
    {
        this.updatorId = updatorId;
    }

    public Long getUpdatorId() 
    {
        return updatorId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("myselfName", getMyselfName())
            .append("myselfId", getMyselfId())
            .append("enemyName", getEnemyName())
            .append("enemyId", getEnemyId())
            .append("roomId", getRoomId())
            .append("validFlag", getValidFlag())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("creatorId", getCreatorId())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updatorId", getUpdatorId())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
