package org.abins.platform.core.service.impl;

import java.util.List;
import java.util.Map;

import org.abins.platform.core.dao.IAPermissionDao;
import org.abins.platform.core.dao.cache.IRedisDao;
import org.abins.platform.core.entity.APermission;
import org.abins.platform.core.exception.APermissionException;
import org.abins.platform.core.service.IAPermissionService;
import org.abins.platform.utils.ProtostuffUtil;
import org.abins.platform.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

/**
 * 功能描述：资源权限业务层
 * 
 * @author : yaobin 2016-10-10
 * @modify : yaobin 2016-10-10 <描述修改内容>
 */
@Service
public class APermissionServiceImpl implements IAPermissionService {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private IAPermissionDao permissionDao;
    //@Autowired
    //private IRedisDao<APermission> redisDao;
    
    private final String REDIS_KEY = "permission_redis_key";
    private Jedis jedis = RedisUtil.getJedis();
    
    @Override
    public int save(APermission permission) {
        int result = permissionDao.addPermission(permission);
        return result;
    }
    
    @Override
    public int update(APermission t) {
        
        return 0;
    }
    
    @Override
    public int delete(APermission permission) {
        int result = permissionDao.deleteById(permission.getPermissionId());
        return result;
    }
    
    @Override
    public APermission findById(String permissionId)
        throws APermissionException {
        byte[] bytes = jedis.get(permissionId.getBytes());
        APermission permission = null;
        if(bytes == null){
            permission = permissionDao.findById(permissionId);
            byte[] serializer = ProtostuffUtil.serializer(permission);
            jedis.set(permission.getPermissionId().getBytes(), serializer);
        }else{
            permission = ProtostuffUtil.deserializer(bytes, APermission.class);
        }
        if(permission == null){
            logger.error("未找到该资源");
            throw new APermissionException("未找到该资源");
        }else{
            return permission;
        }
    }

    @Override
    public List<APermission> queryAll(Map<String, Object> params)
        throws APermissionException {
        Jedis jedis = RedisUtil.getJedis();
        try {
            byte[] bytes = jedis.get(REDIS_KEY.getBytes());
            if(bytes != null){
                APermission permission = ProtostuffUtil.deserializer(bytes, APermission.class);
                return null;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
        //使用缓存
//        List<APermission> redisCache = redisDao.getRedis(REDIS_KEY);
//        if(redisCache != null){
//            // params == null
//            return redisCache;
//        }else{
//            List<APermission> permissions = permissionDao.queryAll(params);
//            redisDao.addRedis(REDIS_KEY, permissions);
//            return permissions;
//        }
    }

    @Override
    public List<APermission> findByUserRole(String roleId)
        throws APermissionException {
        return null;
    }
    
}
