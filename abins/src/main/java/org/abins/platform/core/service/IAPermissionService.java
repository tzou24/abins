package org.abins.platform.core.service;

import java.util.List;
import java.util.Map;

import org.abins.platform.core.entity.APermission;
import org.abins.platform.core.exception.APermissionException;

/**
 * 功能描述：资源权限业务层接口
 * 
 * @author : yaobin 2016-10-10
 * @modify : yaobin 2016-10-10 <描述修改内容>
 */
public interface IAPermissionService extends IBaseService<APermission> {
    
    /**
     * <一句话功能简述> 根据资源权限Id查询该对象
     * 
     * @modefy : yaobin 2016-10-10
     * @param permissionId 资源权限Id
     * @return 资源权限对象
     * @throws APermissionException 资源权限异常
     */
    APermission findById(String permissionId)
        throws APermissionException;
    
    /**
     * <一句话功能简述> 根据条件查询所有资源权限
     * 
     * @modefy : yaobin 2016-10-10
     * @param params 查询参数集合
     * @return 资源权限集合
     * @throws APermissionException 资源权限异常
     */
    List<APermission> queryAll(Map<String, Object> params)
        throws APermissionException;
    
    /**
     * <一句话功能简述> 根据角色查询资源权限
     * 
     * @modefy : yaobin 2016-10-10
     * @param roleId 角色Id
     * @return 资源权限集合
     * @throws APermissionException 资源权限异常
     */
    List<APermission> findByUserRole(String roleId)
        throws APermissionException;
}
