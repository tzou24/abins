package org.abins.platform.core.service.impl;

import java.util.List;

import org.abins.platform.core.dao.IADictDao;
import org.abins.platform.core.entity.ADict;
import org.abins.platform.core.entity.ADictType;
import org.abins.platform.core.service.IADictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述：字典服务层实现类
 * 
 * @author  : YaoBin 2016-11-1
 * @modify  : YaoBin 2016-11-1 <描述修改内容>
 */
@Service
public class ADictServiceImpl implements IADictService {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private IADictDao dictDao;
    
    @Override
    public int save(ADict dict) {
        return dictDao.addDict(dict);
    }
    
    @Override
    public int update(ADict dict) {
        return dictDao.update(dict);
    }
    
    @Override
    public int delete(ADict dict) {
        return dictDao.delete(dict.getDictId());
    }
    
    @Override
    public List<ADictType> getAllType(String code) {
        List<ADictType> list = dictDao.getAllType(code);
        return list;
    }
    
}
