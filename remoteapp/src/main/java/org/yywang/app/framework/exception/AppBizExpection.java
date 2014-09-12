package org.yywang.app.framework.exception;

/**
 * app业务异常类
 * @author yywang
 */
public class AppBizExpection  extends RuntimeException{

    /**
     *  业务异常构造器
     * @param message 消息
     */
    public AppBizExpection(String message) {
        super(message);
    }

    /**
     * 业务异常构造器
     * @param message 消息
     * @param cause 异常对象
     */
    public AppBizExpection(String message, Throwable cause) {
        super(message, cause);
    }
}
