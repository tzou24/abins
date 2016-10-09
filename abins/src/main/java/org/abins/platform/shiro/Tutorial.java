package org.abins.platform.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能描述：shiro 安全框架基础功能测试类
 * 
 * @author  : yaobin 2016-10-9
 * @modify  : yaobin 2016-10-9 <描述修改内容>
 */
public class Tutorial {
    
    private static final transient Logger log = LoggerFactory.getLogger(Tutorial.class);
    
    public static void main(String[] args) {
        log.info("my first apache shiro application");
        //step1  classpath | url | file 
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:config/shiro.ini");
        //step2 解析shiro.ini 返回配置的 SecutiryManager 实例
        SecurityManager securityManager = factory.getInstance();
        //step3
        SecurityUtils.setSecurityManager(securityManager);
        
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute("a", "b");
        System.out.println(session.getAttribute("a"));
        
        if(!currentUser.isAuthenticated()){
         
            UsernamePasswordToken token = new UsernamePasswordToken("tom", "123456");
            
            token.setRememberMe(true);
            /*
             * BadCredentialsException 坏的凭据
                AccountStatusException 用户状态异常它包含如下子类
                AccountExpiredException 账户过期
                LockedException 账户锁定
                DisabledException 账户不可用
                CredentialsExpiredException   证书过期
             */
            
            try {
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
               // UsernameNotFoundException 用户找不到
                // username wasn`t in the system, show them an error message?
            }catch (IncorrectCredentialsException ice) {
                // password didn`t match try again?
            }catch (LockedAccountException lae) {
                // account for that username is locked
            }catch (AuthenticationException ae) {
                // unexpected codition error?
            }
        }
        //print their identifying principal 
        log.info("user [" + currentUser.getPrincipal() + "] logged in successfully");
        //has roles
        if(currentUser.hasRole("")){
            
        }
        //是否有权限在一个确定类型实体上进行操作
        if(currentUser.isPermitted("")){
            
        }
        //注销
        currentUser.logout();
        System.exit(0);
    }
}
