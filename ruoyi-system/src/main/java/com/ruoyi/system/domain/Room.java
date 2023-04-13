package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房间对象 room
 * 
 * @author jp
 * @date 2023-04-11
 */
public class Room extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 房间ID */
    private Long id;


    /** 房间名 */
    @Excel(name = "房间名")
    private String roomName;

    /** 创建人id 创建者的sys_user_id */
    @Excel(name = "创建人id 创建者的sys_user_id")
    private Long creatorId;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createName;

    /** 邀请人id */
    @Excel(name = "邀请人id")
    private Long inviteId;

    /** 邀请人 */
    @Excel(name = "邀请人")
    private String inviteName;

    /** 围观人id */
    @Excel(name = "围观人id")
    private Long watchId;

    /** 围观人 */
    @Excel(name = "围观人")
    private String watchName;

    /** 是否有效 0：无效，1：有效 */
    @Excel(name = "是否有效 0：无效，1：有效")
    private Integer validFlag;

    /** 删除标志 1：已删除，0：未删除 */
    private Integer delFlag;

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
    public void setCreatorId(Long creatorId) 
    {
        this.creatorId = creatorId;
    }

    public Long getCreatorId() 
    {
        return creatorId;
    }
    public void setCreateName(String createName) 
    {
        this.createName = createName;
    }

    public String getCreateName() 
    {
        return createName;
    }
    public void setInviteId(Long inviteId) 
    {
        this.inviteId = inviteId;
    }

    public Long getInviteId() 
    {
        return inviteId;
    }
    public void setInviteName(String inviteName) 
    {
        this.inviteName = inviteName;
    }

    public String getInviteName() 
    {
        return inviteName;
    }
    public void setWatchId(Long watchId) 
    {
        this.watchId = watchId;
    }

    public Long getWatchId() 
    {
        return watchId;
    }
    public void setWatchName(String watchName) 
    {
        this.watchName = watchName;
    }

    public String getWatchName() 
    {
        return watchName;
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
    public void setUpdatorId(Long updatorId) 
    {
        this.updatorId = updatorId;
    }

    public Long getUpdatorId() 
    {
        return updatorId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("creatorId", getCreatorId())
            .append("createName", getCreateName())
            .append("inviteId", getInviteId())
            .append("inviteName", getInviteName())
            .append("watchId", getWatchId())
            .append("watchName", getWatchName())
            .append("validFlag", getValidFlag())
            .append("delFlag", getDelFlag())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updatorId", getUpdatorId())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("roomName", getRoomName())
            .toString();
    }
}
