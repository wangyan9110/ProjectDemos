package org.yywang.app.eventhanders;

import org.yywang.app.framework.event.EventArgs;
import org.yywang.app.framework.event.EventHandler;
import org.yywang.app.framework.event.HandlerResult;
import org.yywang.app.framework.utils.CallingLogger;
import org.yywang.app.framework.utils.PrintUtils;
import org.yywang.app.transmission.TransmissionCur;

/**
 * 广告策略事件处理器
 *
 * @author yywang5
 */
public class AdStrategyEventHandler implements EventHandler<EventArgs> {

    @Override
    public void processHandler(EventArgs args, HandlerResult handlerResult) {
        CallingLogger.instance.append("AdStrategyEventHandler.processHandler");
        PrintUtils.println("正在获取广告策略", 6);
        TransmissionCur.Instance.get().sendAdStrategyCommand("播放1分钟广告", "http://ad.iflytek.com/ad.avi");
    }
}
