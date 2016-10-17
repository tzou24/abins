package org.abins.platform.core.exception;

/**
 * 功能描述：资源权限异常类
 * 
 * @author  : yaobin 2016-10-10
 * @modify  : yaobin 2016-10-10 <描述修改内容>
 */
@SuppressWarnings("serial")
public class APermissionException extends RuntimeException {
    
    public APermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public APermissionException(String message) {
        super(message);
    }
}
