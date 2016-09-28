package org.abins.platform.core.entity;

import java.util.Date;

/**
 * 功能描述：基础用户对象(登录用)
 * 
 * @author : yaobin 2016-9-28
 * @modify : yaobin 2016-9-28 <描述修改内容>
 */
public class ABaseUser {
    
    /**
     * baseUserId 主键
     */
    private String baseUserId;
    
    /**
     * loginAccount 登录账号
     */
    private String loginAccount;
    
    /**
     * email 邮箱 可用来登录
     */
    private String email;
    
    /**
     * loginPassword 登录密码
     */
    private String loginPassword;
    
    /**
     * loginTime 最后登录时间
     */
    private Date loginTime;
    
    public String getBaseUserId() {
        return baseUserId;
    }
    
    public void setBaseUserId(String baseUserId) {
        this.baseUserId = baseUserId;
    }
    
    public String getLoginAccount() {
        return loginAccount;
    }
    
    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getLoginPassword() {
        return loginPassword;
    }
    
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
    
    public Date getLoginTime() {
        return loginTime;
    }
    
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
    
}
