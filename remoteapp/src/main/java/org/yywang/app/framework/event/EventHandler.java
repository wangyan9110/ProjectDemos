package org.yywang.app.framework.event;

/**
 * 事件处理器
 *
 * @author yywang5
 */
public interface EventHandler<T extends EventArgs> {

    /**
     * 事件处理
     *
     * @param args          参数
     * @param handlerResult 处理结果
     */
    void processHandler(T args, HandlerResult handlerResult);
}
