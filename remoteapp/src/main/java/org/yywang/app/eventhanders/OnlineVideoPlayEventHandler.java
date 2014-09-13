package org.yywang.app.eventhanders;

import org.yywang.app.framework.event.EventHandler;
import org.yywang.app.framework.event.HandlerResult;
import org.yywang.app.framework.utils.CallingLogger;
import org.yywang.app.framework.utils.PrintUtils;
import org.yywang.app.model.MediaType;
import org.yywang.app.transmission.TransmissionCur;

/**
 * @author yywang5
 */
public class OnlineVideoPlayEventHandler implements EventHandler<MediaPlayEventArgs> {

    @Override
    public void processHandler(MediaPlayEventArgs args, HandlerResult handlerResult) {
        CallingLogger.instance.append("OnlineVideoPlayEventHandler.processHandler");
        PrintUtils.println("在线播放视频：" + args.getName() + " 地址：" + args.getFilePath());
        TransmissionCur.Instance.get().sendPlayOnlineCommand(MediaType.video, args.getFilePath());
    }
}
