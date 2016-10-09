package org.abins.platform.core.dao;

import java.util.UUID;

import javax.annotation.Resource;

import org.abins.platform.core.entity.ABaseUser;
import org.abins.platform.utils.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 基础用户访问数据库测试类
 * 
 * @author  : yaobin 2016-9-28
 * @modify  : yaobin 2016-9-28 
 */
//配置spring 和junit整合，junit启动时加载springIoc容器  sping-test
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ABaseUserDaoTest {
    
   // @Resource
    //private ABaseUserDao baseUserDao;
    
//    @Test
//    public void testLogin()throws Exception{
//        String login = "admin";
//        String email = "admin@163.com";
//        String password = "2190F85C07346F670A09E05C6C499C04";
//        ABaseUser baseUser = baseUserDao.login(login, password);
//        System.out.println(baseUser.getLoginAccount());
//    }
//    
//    @Test
//    public void testAddUser()throws Exception{
//        ABaseUser baseUser = new ABaseUser();
//        baseUser.setBaseUserId(MD5Util.getInstance().getMD5ofStr(UUID.randomUUID().toString()));
//        baseUser.setEmail("tom@163.com");
//        baseUser.setLoginAccount("tom");
//        baseUser.setLoginPassword("123456");
//        baseUserDao.addBaseUser(baseUser);
//    }
}
