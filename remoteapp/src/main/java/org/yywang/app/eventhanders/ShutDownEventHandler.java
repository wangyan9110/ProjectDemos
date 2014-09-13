package org.yywang.app.eventhanders;

import org.yywang.app.framework.event.EventArgs;
import org.yywang.app.framework.event.EventHandler;
import org.yywang.app.framework.event.HandlerResult;
import org.yywang.app.framework.utils.CallingLogger;
import org.yywang.app.framework.utils.PrintUtils;
import org.yywang.app.transmission.TransmissionCur;

/**
 * 关机事件处理器
 *
 * @author yywang5
 */
public class ShutDownEventHandler implements EventHandler<EventArgs> {

    @Override
    public void processHandler(EventArgs args, HandlerResult handlerResult) {
        CallingLogger.instance.append("ShutDownEventHandler.processHandler");
        PrintUtils.println("关机");
        TransmissionCur.Instance.get().sendShutdownCommand();
    }
}
