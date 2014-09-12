package org.yywang.app.modules;

import org.yywang.app.framework.event.EventHandler;
import org.yywang.app.framework.event.HandlerResult;
import org.yywang.app.framework.utils.PrintUtils;
import org.yywang.app.transmission.TransmissionCur;

/**
 * 关机事件处理器
 *
 * @author yywang5
 */
public class ShutDownEventHandler implements EventHandler<ShutDownEventArgs> {

    @Override
    public void processHandler(ShutDownEventArgs args, HandlerResult handlerResult) {
        PrintUtils.println("关机");
        TransmissionCur.Instance.get().sendShutdownCommand();
    }
}
