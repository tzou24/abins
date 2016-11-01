package org.abins.platform.core.service;

import java.util.List;

import org.abins.platform.core.entity.ADict;
import org.abins.platform.core.entity.ADictType;

/**
 * 功能描述：字典服务层接口
 * 
 * @author : YaoBin 2016-11-1
 * @modify : YaoBin 2016-11-1 <描述修改内容>
 */ 
public interface IADictService extends IBaseService<ADict> {
    
    /**
     * <一句话功能简述> 根据字典编码获取所有该字典数据
     * 
     * @modefy : YaoBin 2016-11-1
     * @param code 字典编码
     * @return 
     */
    public List<ADictType> getAllType(String code);
}
