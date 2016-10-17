package org.abins.platform.core.entity;

import java.util.Date;

/**
 * 功能描述：用户角色对象
 * 
 * @author : yaobin 2016-10-10
 * @modify : yaobin 2016-10-10 <描述修改内容>
 */
public class ARole {
    
    /**
     * roleId 主键
     */
    private String roleId;
    
    /**
     * name 角色名称
     */
    private String name;
    
    /**
     * createTime 创建时间
     */
    private Date createTime;
    
    /**
     * creator 创建者
     */
    private String creator;
    
    /**
     * updateTime 更新时间
     */
    private Date updateTime;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
}
