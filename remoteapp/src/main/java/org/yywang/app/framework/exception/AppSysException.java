package org.yywang.app.framework.exception;

/**
 * app系统异常类
 * @author yywang
 */
public class AppSysException extends RuntimeException{

    /**
     * 系统异常构造器
     * @param message 消息
     */
    public AppSysException(String message) {
        super(message);
    }

    /**
     * 系统异常构造器
     * @param message 消息
     * @param cause 异常对象
     */
    public AppSysException(String message, Throwable cause) {
        super(message, cause);
    }
}
