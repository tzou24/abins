package org.abins.platform.core.service.impl;

import org.abins.platform.core.dao.IABaseUserDao;
import org.abins.platform.core.entity.ABaseUser;
import org.abins.platform.core.exception.AUserLoginException;
import org.abins.platform.core.service.IABaseUserService;
import org.abins.platform.utils.MD5Util;
import org.abins.platform.utils.UUIDGenerator;
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
public class ABaseUserServiceImpl implements IABaseUserService {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private IABaseUserDao baseUserDao;
    
    @Override
    public ABaseUser login(String login, String password)
        throws AUserLoginException, Exception {
        ABaseUser baseUser = baseUserDao.login(login, password);
        if (baseUser == null) {
            logger.error("账号或密码错误");
            throw new AUserLoginException("账号或密码错误");
        } else {
            return baseUser;
        }
    }
    
    @Override
    public boolean regUser(ABaseUser baseUser) {
        baseUser.setBaseUserId(UUIDGenerator.generate());
        String md5Password = MD5Util.encryptMD5(baseUser.getLoginPassword());
        baseUser.setLoginPassword(md5Password);
        boolean result = baseUserDao.addBaseUser(baseUser);
        return result;
    }

    @Override
    public int save(ABaseUser t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(ABaseUser t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(ABaseUser t) {
        // TODO Auto-generated method stub
        return 0;
    }
}
