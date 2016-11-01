package org.abins.platform.core.entity;

/**
 * 功能描述：字典表
 * 
 * @author  : YaoBin 2016-11-1
 * @modify  : YaoBin 2016-11-1 <描述修改内容>
 */
public class ADict {

    /**
     * dictId 主键
     */
    private String dictId;
    
    /**
     * type 字典类型
     */
    private String type;
    
    /**
     * code 编码
     */
    private String code;

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
}
