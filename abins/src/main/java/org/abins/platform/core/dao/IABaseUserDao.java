package org.abins.platform.core.dao;

import java.util.List;
import java.util.Map;

import org.abins.platform.core.entity.ABaseUser;
import org.apache.ibatis.annotations.Param;

/**
 * 功能描述：基础用户数据库访问接口
 * 
 * @author : yaobin 2016-9-28
 * @modify : yaobin 2016-9-28 <描述修改内容>
 */
public interface IABaseUserDao {
    
    /**
     * <一句话功能简述> 注册新用户
     * 
     * @modefy : yaobin 2016-9-28
     * @param baseUser
     * @return true-成功；false-失败
     */
    public boolean addBaseUser(ABaseUser baseUser);
    
    /**
     * <一句话功能简述> 根据ID查询基础用户对象
     * 
     * @modefy : yaobin 2016-9-28
     * @param baseUserId 用户ID
     * @return 基础用户对象
     */
    public ABaseUser queryById(String baseUserId);
    
    /**
     * <一句话功能简述> 查询用户列表(分页)
     * 
     * @modefy : yaobin 2016-9-28
     * @param params
     * @param offet
     * @param limit
     * @return
     */
    public List<ABaseUser> queryAll(Map<String, Object> params, @Param("offet") int offet, @Param("limit") int limit);
    
    /**
     * <一句话功能简述> 用户登录
     * 
     * @modefy : yaobin 2016-9-28
     * @param login 登录账号或邮箱
     * @param password 密码
     * @return 登录成功对象
     */
    public ABaseUser login(@Param("login") String login, @Param("password") String password);
}
