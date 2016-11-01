package org.abins.platform.core.dao;

import java.util.List;
import java.util.Map;

import org.abins.platform.core.entity.ADict;
import org.abins.platform.core.entity.ADictType;
import org.apache.ibatis.annotations.Param;

/**
 * 功能描述：系统字典数据库访问接口
 * 
 * @author : YaoBin 2016-11-1
 * @modify : YaoBin 2016-11-1 <描述修改内容>
 */
public interface IADictDao {
    
    /**
     * <一句话功能简述> 添加字典对象
     * 
     * @modefy : YaoBin 2016-11-1
     * @param dict 字典对象
     * @return 添加数量
     */
    public int addDict(ADict dict);
    
    /**
     * <一句话功能简述> 更新字典对象
     * 
     * @modefy : YaoBin 2016-11-1
     * @param dict 字典对象
     * @return 更新数
     */
    public int update(ADict dict);
    
    /**
     * <一句话功能简述> 根据主键删除字典对象
     * 
     * @modefy : YaoBin 2016-11-1
     * @param dictId 字典对象
     * @return 删除数
     */
    public int delete(@Param("dictId") String dictId);
    
    /**
     * <一句话功能简述> 根据字典编码获取所有该字典数据
     * 
     * @modefy : YaoBin 2016-11-1
     * @param code 字典编码
     * @return
     */
    public List<ADictType> getAllType(@Param("code") String code);
    
    /**
     * <一句话功能简述> 根据参数获取字典列表
     * 
     * @modefy : YaoBin 2016-11-1
     * @param params 查询参数Map
     * @return
     */
    public List<ADict> getList(Map<String, Object> params);
    
}
