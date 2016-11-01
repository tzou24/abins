package org.abins.platform.core.entity;

/**
 * 功能描述：字典数据实体
 * 
 * @author : YaoBin 2016-11-1
 * @modify : YaoBin 2016-11-1 <描述修改内容>
 */
public class ADictType {
    
    /**
     * dictTypeId 主键
     */
    private String dictTypeId;
    
    /**
     * name 名称
     */
    private String name;
    
    /**
     * value 值
     */
    private String value;
    
    /**
     * dictId 字典表主键
     */
    private String dictId;
    
    public String getDictTypeId() {
        return dictTypeId;
    }
    
    public void setDictTypeId(String dictTypeId) {
        this.dictTypeId = dictTypeId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public String getDictId() {
        return dictId;
    }
    
    public void setDictId(String dictId) {
        this.dictId = dictId;
    }
    
}
