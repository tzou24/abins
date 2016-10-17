package org.abins.platform.core.service;

/**
 * 功能描述：业务基础接口
 * 
 * @author : yaobin 2016-10-10
 * @modify : yaobin 2016-10-10 <描述修改内容>
 */
public interface IBaseService<T> {
    
    /**
     * <一句话功能简述> 保存实体对象
     * 
     * @modefy : yaobin 2016-10-10
     * @param t
     * @return
     */
    public int save(T t);
    
    /**
     * <一句话功能简述> 修改实体对象
     * 
     * @modefy : yaobin 2016-10-10
     * @param t 实体对象
     * @return
     * @throws
     */
    public int update(T t);
    
    /**
     * <一句话功能简述> 删除实体对象
     * 
     * @modefy : yaobin 2016-10-10
     * @param t
     * @return
     * @throws
     */
    public int delete(T t);
}
