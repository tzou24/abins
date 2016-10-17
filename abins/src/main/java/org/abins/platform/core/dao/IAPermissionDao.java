package org.abins.platform.core.dao;

import java.util.List;
import java.util.Map;

import org.abins.platform.core.entity.APermission;
import org.apache.ibatis.annotations.Param;

/**
 * 功能描述：资源权限数据库访问接口
 * 
 * @author : yaobin 2016-10-10
 * @modify : yaobin 2016-10-10 <描述修改内容>
 */
public interface IAPermissionDao {
    
    /**
     * <一句话功能简述> 添加资源权限
     * 
     * @modefy : yaobin 2016-10-10
     * @param permission 资源权限对象
     * @return true-添加成功, false-添加失败
     */
    public int addPermission(APermission permission);
    
    /**
     * <一句话功能简述> 根据ID获取资源权限
     * 
     * @modefy : yaobin 2016-10-10
     * @param permissionId 资源权限对象Id
     * @return 资源权限对象
     */
    public APermission findById(@Param("permissionId") String permissionId);
    
    /**
     * <一句话功能简述> 查询所有资源权限对象
     * 
     * @modefy : yaobin 2016-10-10
     * @param params 查询参数
     * @return 资源权限对象集合
     */
    public List<APermission> queryAll(Map<String, Object> params);
    
    /**
     * <一句话功能简述> 根据单个角色获取资源权限列表
     * 
     * @modefy : yaobin 2016-10-10
     * @param roleId 角色Id
     * @return 资源权限对象
     */
    public List<APermission> findByUserRole(@Param("roleId") String roleId);
    
    /**
     * <一句话功能简述> 删除资源权限对象
     * 
     * @modefy : yaobin 2016-10-10
     * @param permissionId 资源权限对象Id
     * @return 影响行数
     */
    public int deleteById(@Param("permissionId") String permissionId);
    
}
