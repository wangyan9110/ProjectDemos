package org.yywang.app.framework.exception;

/**
 * 不支持
 * @author yywang5
 */
public class AppUnSupportException extends AppBizExpection{

    /**
     *  业务异常构造器
     * @param message 消息
     */
    public AppUnSupportException(String message) {
        super(message);
    }

    /**
     * 业务异常构造器
     * @param message 消息
     * @param cause 异常对象
     */
    public AppUnSupportException(String message, Throwable cause) {
        super(message, cause);
    }

}
