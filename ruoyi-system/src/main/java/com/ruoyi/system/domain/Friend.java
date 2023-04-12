package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 好友信息对象 friend
 * 
 * @author jp
 * @date 2023-04-11
 */
public class Friend extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 添加人userid */
    @Excel(name = "添加人userid")
    private Long adduserId;

    /** 好友userid */
    @Excel(name = "好友userid")
    private Long frienduserId;

    /** 添加状态 0：待同意，1：已同意，2：未同意 */
    @Excel(name = "添加状态 0：待同意，1：已同意，2：未同意")
    private Integer status;

    /** 好友name */
    @Excel(name = "好友name")
    private String friendName;


    /** 添加人name */
    @Excel(name = "添加人name")
    private String addName;

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
    public void setAdduserId(Long adduserId) 
    {
        this.adduserId = adduserId;
    }

    public Long getAdduserId() 
    {
        return adduserId;
    }
    public void setFrienduserId(Long frienduserId) 
    {
        this.frienduserId = frienduserId;
    }

    public Long getFrienduserId() 
    {
        return frienduserId;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
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
    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("adduserId", getAdduserId())
            .append("frienduserId", getFrienduserId())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("creatorId", getCreatorId())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updatorId", getUpdatorId())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("friendName", getFriendName())
            .append("addName", getAddName())
            .toString();
    }
}
