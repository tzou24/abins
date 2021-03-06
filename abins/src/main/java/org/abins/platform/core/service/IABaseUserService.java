package org.abins.platform.core.service;

import org.abins.platform.core.entity.ABaseUser;
import org.abins.platform.core.exception.AUserLoginException;

/**
 * 功能描述：基础用户业务层接口
 * 
 * @author : yaobin 2016-9-28
 * @modify : yaobin 2016-9-28 <描述修改内容>
 */
public interface IABaseUserService extends IBaseService<ABaseUser> {
    
    /**
     * <一句话功能简述> 用户登录
     * 
     * @modefy : yaobin 2016-9-28
     * @param login 登录账号或邮箱
     * @param password 未加密密码
     * @return 该用户对象
     * @throws AUserLoginException
     */
    public ABaseUser login(String login, String password)
        throws AUserLoginException, Exception;
    
    /**
     * <一句话功能简述> 用户注册
     * 
     * @modefy : yaobin 2016-9-28
     * @param baseUser 用户对象
     * @return true-成功；false-失败
     */
    public boolean regUser(ABaseUser baseUser);
}
