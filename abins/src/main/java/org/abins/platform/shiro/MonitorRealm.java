package org.abins.platform.shiro;

import java.util.HashSet;
import java.util.Set;

import org.abins.platform.core.entity.ABaseUser;
import org.abins.platform.core.exception.AUserLoginException;
import org.abins.platform.core.service.ABaseUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述：shiro 安全框架授权类
 * 
 * @author  : yaobin 2016-10-9
 * @modify  : yaobin 2016-10-9 <描述修改内容>
 */
@Service("monitorRealm")
public class MonitorRealm extends AuthorizingRealm {
    
    /*
     * 
     * @Autowired RoleService roleService;
     * 
     * @Autowired LoginLogService loginLogService;
     */
    // 盐值 混淆密码
    //private final String slat = "341g354grtDSAasd#W$T^GVBGZRFD125";
    
    /**
     * baseUserService 注入业务层 对DAO操作
     * <p>提示：</p>
     * 在web.xml 中需要将扫描service注解排在shiro.xml文件之前，才能成功注入
     */
    @Autowired
    private ABaseUserService baseUserService;
    
    public MonitorRealm() {
        super();
    }
    
    /**
     * 重载方法
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        /* 这里编写授权代码 
         * 当前仅用于测试
         * */
        Set<String> roleNames = new HashSet<String>();
        roleNames.add("admin");
        
        Set<String> permissions = new HashSet<String>();
        permissions.add("/platform/main/toLogin");
        permissions.add("/platform/main/login");
        permissions.add("/platform/main/logout");
        
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(permissions);
        return info;
    }
    
    /**
     * 重载方法 登录时调用 后台验证处理
     * @param authcToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
        throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
        ABaseUser baseUser = null;
        try {
            baseUser = baseUserService.login(token.getUsername(), new String(token.getPassword()));
        } catch (AUserLoginException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        if (baseUser != null) {
            return new SimpleAuthenticationInfo(baseUser.getLoginAccount(), baseUser.getLoginPassword(), getName());
        } else {
            return null;
        }
        
    }
    
    public void clearCachedAuthorizationInfo(String principal) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
        clearCachedAuthorizationInfo(principals);
    }
    
}
