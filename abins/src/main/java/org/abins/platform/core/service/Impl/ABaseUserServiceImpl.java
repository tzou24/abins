package org.abins.platform.core.service.Impl;

import org.abins.platform.core.dao.ABaseUserDao;
import org.abins.platform.core.entity.ABaseUser;
import org.abins.platform.core.exception.AUserLoginException;
import org.abins.platform.core.service.ABaseUserService;
import org.abins.platform.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述：基础用户服务层实现类
 * 
 * @author : yaobin 2016-9-28
 * @modify : yaobin 2016-9-28 <描述修改内容>
 */
@Service
public class ABaseUserServiceImpl implements ABaseUserService {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private ABaseUserDao baseUserDao;
    
    @Override
    public ABaseUser login(String login, String password)
        throws AUserLoginException {
        String md5Password = MD5Util.getInstance().getMD5ofStr(password);
        ABaseUser baseUser = baseUserDao.login(login, md5Password);
        if (baseUser == null) {
            logger.error("account or email error");
            throw new AUserLoginException("account or email error");
        } else {
            return baseUser;
        }
    }
    
    @Override
    public boolean register(ABaseUser baseUser) {
        String md5Password = MD5Util.getInstance().getMD5ofStr(baseUser.getLoginPassword());
        baseUser.setLoginPassword(md5Password);
        boolean result = baseUserDao.addBaseUser(baseUser);
        return result;
    }
    
}
