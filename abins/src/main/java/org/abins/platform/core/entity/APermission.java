package org.abins.platform.core.entity;

/**
 * 功能描述：资源权限对象
 * 
 * @author : yaobin 2016-10-10
 * @modify : yaobin 2016-10-10 <描述修改内容>
 * @Table : a_permission 
 */
public class APermission {
    
    /**
     * permissionId 主键
     */
    private String permissionId;
    
    /**
     * name 资源名称
     */
    private String name;
    
    /**
     * url 资源地址
     */
    private String url;
    
    /**
     * order 排序值
     */
    private int order;
    
    /**
     * parentId 父级资源ID
     */
    private String parentId;
    
    /**
     * headerHtml 导航HTML
     */
    private String headerHtml;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getHeaderHtml() {
        return headerHtml;
    }

    public void setHeaderHtml(String headerHtml) {
        this.headerHtml = headerHtml;
    }
    
}
