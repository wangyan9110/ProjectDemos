package org.yywang.app.eventhanders;

import org.yywang.app.framework.event.EventArgs;
import org.yywang.app.framework.event.EventHandler;
import org.yywang.app.framework.event.HandlerResult;
import org.yywang.app.framework.utils.CallingLogger;
import org.yywang.app.framework.utils.PrintUtils;
import org.yywang.app.model.OnlineVideo;

import java.util.ArrayList;
import java.util.List;

/**
 * 浏览在线视频
 *
 * @author yywang5
 */
public class BrowseOnlineMediaEventHandler implements EventHandler<EventArgs> {

    @Override
    public void processHandler(EventArgs args, HandlerResult handlerResult) {
        CallingLogger.instance.append("BrowseOnlineMediaEventHandler.processHandler");
        PrintUtils.println("正在获取视频列表", 6);
        //模拟从服务端获取到的视频
        List<OnlineVideo> onlineVideos = new ArrayList<OnlineVideo>();
        onlineVideos.add(new OnlineVideo("201102020202", "变形金刚4", "http://video.iflytek.com/bianxingjingang.avi", ".avi", "英文", "变形金刚4介绍"));
        onlineVideos.add(new OnlineVideo("201102020203", "夜色行动", "http://video.iflytek.com/yesexingdaong.avi", ".avi", "英文", "夜色行动介绍"));
        onlineVideos.add(new OnlineVideo("201102020204", "死亡拼图", "http://video.iflytek.com/siwangpintu.avi", ".avi", "英文", "死亡拼图介绍"));

        handlerResult.put("videos", onlineVideos);
    }


}
