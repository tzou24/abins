package org.abins.platform.core.dao.cache;

import java.util.List;

import org.abins.platform.core.entity.APermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 功能描述：redis键值数据库访问(缓存用)
 * 
 * @author : yaobin 2016-10-10
 * @modify : yaobin 2016-10-10 <描述修改内容>
 */
@SuppressWarnings("all")
public class IRedisDao<T> {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private JedisPool jedisPool;
    
    // 初始化
    public IRedisDao(String ip, int port) {
        jedisPool = new JedisPool(ip, port);
    }
    
    // 获得该序列化的 对象类 的结构
    private RuntimeSchema<List> schema = RuntimeSchema.createFrom(List.class);
    
    /**
     * <一句话功能简述> 根据key获取redis中value
     * 
     * @modefy : yaobin 2016-10-10
     * @param redisKey redis key
     * @return
     */
    public List<T> getRedis(String redisKey) {
        try {
            Jedis jedis = jedisPool.getResource();// 连接池
            try {
                byte[] bytes = jedis.get(redisKey.getBytes());
                if (bytes != null) {
                    List<T> list = (List<T>)schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes, list, schema);
                    return list;
                }
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
    
    /**
     * <一句话功能简述> 新增数据到Redis
     * 
     * @modefy : yaobin 2016-10-10
     * @param redisKey 新增key
     * @param list 数据集合
     * @return
     */
    public String addRedis(String redisKey, List<T> list) {
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                byte[] bytes = ProtostuffIOUtil.toByteArray(list, schema,
                // 缓存器 默认缓存器大小， 特别大会有缓存
                    LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                int timeout = 60 * 60;
                // result = ok
                String result = jedis.setex(redisKey.getBytes(), timeout, bytes);
                return result;
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
    
    /**
     * <一句话功能简述> 根据key删除 redis value
     * 
     * @modefy : yaobin 2016-10-10
     * @param redisKey key
     * @return
     */
    public Long delRedis(String redisKey) {
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                // result success number
                Long result = jedis.del(redisKey);
                return result;
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
