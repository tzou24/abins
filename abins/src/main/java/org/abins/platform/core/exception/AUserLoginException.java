package org.abins.platform.core.exception;

/**
 * 功能描述：登录异常
 * 
 * @author  : yaobin 2016-9-28
 * @modify  : yaobin 2016-9-28 <描述修改内容>
 */
public class AUserLoginException extends RuntimeException{

    public AUserLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public AUserLoginException(String message) {
        super(message);
    }

}
