package org.yywang.app.eventhanders;

import org.yywang.app.framework.event.EventArgs;
import org.yywang.app.framework.event.EventHandler;
import org.yywang.app.framework.event.HandlerResult;
import org.yywang.app.framework.utils.CallingLogger;
import org.yywang.app.framework.utils.JsonUtils;
import org.yywang.app.framework.log.Log;

/**
 * 数据收集处理器
 * <p>
 * pre事件处理器
 * </p>
 *
 * @author yywang5
 */
public class DataCollectionEventHandler implements EventHandler<EventArgs> {

    @Override
    public void processHandler(EventArgs args, HandlerResult handlerResult) {
        CallingLogger.instance.append("DataCollectionEventHandler.processHandler");
        Log.instance.info(handlerResult.get("topic") + ":" + JsonUtils.toJson(args));
    }
}
