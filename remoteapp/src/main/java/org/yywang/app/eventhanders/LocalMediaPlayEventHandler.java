package org.yywang.app.eventhanders;

import org.yywang.app.framework.event.EventHandler;
import org.yywang.app.framework.event.HandlerResult;
import org.yywang.app.framework.utils.CallingLogger;
import org.yywang.app.framework.utils.PrintUtils;
import org.yywang.app.model.MediaType;
import org.yywang.app.transmission.TransmissionCur;

/**
 * 本地播放媒体
 *
 * @author yywang5
 */
public class LocalMediaPlayEventHandler implements EventHandler<MediaPlayEventArgs> {

    @Override
    public void processHandler(MediaPlayEventArgs args, HandlerResult handlerResult) {
        CallingLogger.instance.append("LocalMediaPlayEventHandler.processHandler");
        if (MediaType.audio.equals(args.getMediaType())) {
            PrintUtils.println("选择播放音频：" + args.getFilePath());
            TransmissionCur.Instance.get().sendPlayLocalResCommand(args.getMediaType(), args.getFilePath());
        } else if (MediaType.picture.equals(args.getMediaType())) {
            PrintUtils.println("选择播放图片：" + args.getFilePath());
            TransmissionCur.Instance.get().sendPlayLocalResCommand(args.getMediaType(), args.getFilePath());
        } else if (MediaType.video.equals(args.getMediaType())) {
            PrintUtils.println("选择播放视频：" + args.getFilePath());
            TransmissionCur.Instance.get().sendPlayLocalResCommand(args.getMediaType(), args.getFilePath());
        }
    }
}
