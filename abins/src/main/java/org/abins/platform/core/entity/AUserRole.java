package org.abins.platform.core.entity;

/**
 * 功能描述：用户角色关联对象
 * 
 * @author : yaobin 2016-10-10
 * @modify : yaobin 2016-10-10 <描述修改内容>
 */
public class AUserRole {
    
    /**
     * userRoleId 主键
     */
    private String userRoleId;
    
    /**
     * baseUserId 基础用户ID
     */
    private String baseUserId;
    
    /**
     * roleId 角色ID
     */
    private String roleId;
    
    public String getUserRoleId() {
        return userRoleId;
    }
    
    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }
    
    public String getBaseUserId() {
        return baseUserId;
    }
    
    public void setBaseUserId(String baseUserId) {
        this.baseUserId = baseUserId;
    }
    
    public String getRoleId() {
        return roleId;
    }
    
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    
}