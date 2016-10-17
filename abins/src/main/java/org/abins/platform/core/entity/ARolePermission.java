package org.abins.platform.core.entity;

/**
 * 功能描述：角色资源管理对象
 * 
 * @author : yaobin 2016-10-10
 * @modify : yaobin 2016-10-10 <描述修改内容>
 */
public class ARolePermission {
    
    /**
     * rolePermissionId 主键
     */
    private String rolePermissionId;
    
    /**
     * permissionId 资源ID
     */
    private String permissionId;
    
    /**
     * roleId 角色ID
     */
    private String roleId;
    
    public String getRolePermissionId() {
        return rolePermissionId;
    }
    
    public void setRolePermissionId(String rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }
    
    public String getPermissionId() {
        return permissionId;
    }
    
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
    
    public String getRoleId() {
        return roleId;
    }
    
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    
}
