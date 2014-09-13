package org.yywang.app.client;

import org.yywang.app.eventhanders.ChangeEventArgs;
import org.yywang.app.eventhanders.MediaPlayEventArgs;
import org.yywang.app.eventhanders.PeripheralEventArgs;
import org.yywang.app.framework.event.EventArgs;
import org.yywang.app.framework.event.EventTrigger;
import org.yywang.app.framework.event.HandlerResult;
import org.yywang.app.framework.utils.CallingLogger;
import org.yywang.app.framework.utils.PrintUtils;
import org.yywang.app.model.*;
import org.yywang.app.modules.TelevisionManager;

import java.util.List;

/**
 * App入口
 *
 * @author yywang
 */
public class App {

    /**
     * App入口
     *
     * @param args 选择
     */
    public static void main(String[] args) {
        PrintUtils.println("开始扫描电视", 3);
        TelevisionManager televisionManager = new TelevisionManager();
        if ("scan".equals(args[0])) {
            CallingLogger.instance.start();
            List<Television> televisions = televisionManager.scanTvs();
            for (Television television : televisions) {
                PrintUtils.println(television.toString());
            }
            CallingLogger.instance.print();
        }
        PrintUtils.println("开始选择电视", 3);
        CallingLogger.instance.start();
        televisionManager.choiceTv(args[1]);
        CallingLogger.instance.print();
        if (args.length <= 2 || "voice".equals(args[2])) {
            if (args.length <= 2 || "up".equals(args[3])) {
                CallingLogger.instance.start();
                PrintUtils.println("增大音量");
                EventTrigger.instance.execute("voiceCtr", new ChangeEventArgs("client", ChangeType.Up));
                CallingLogger.instance.print();
            }
            if (args.length <= 2 || "down".equals(args[3])) {
                CallingLogger.instance.start();
                PrintUtils.println("减小音量");
                EventTrigger.instance.execute("voiceCtr", new ChangeEventArgs("client", ChangeType.Down));
                CallingLogger.instance.print();
            }
            if (args.length <= 2 || "jump".equals(args[3])) {
                PrintUtils.println("开始音量控制", 3);
                CallingLogger.instance.start();
                PrintUtils.println("设置音量");
                EventTrigger.instance.execute("voiceCtr", new ChangeEventArgs("client", Integer.parseInt(args.length <= 2 ? "10" : args[4]), ChangeType.Jump));
                CallingLogger.instance.print();
            }
        }
        if (args.length <= 2 || "channel".equals(args[2])) {
            if (args.length <= 2 || "up".equals(args[3])) {
                CallingLogger.instance.start();
                PrintUtils.println("增大频道");
                EventTrigger.instance.execute("channelCtr", new ChangeEventArgs("client", ChangeType.Up));
                CallingLogger.instance.print();
            }
            if (args.length <= 2 || "down".equals(args[3])) {
                CallingLogger.instance.start();
                PrintUtils.println("减小频道");
                EventTrigger.instance.execute("channelCtr", new ChangeEventArgs("client", ChangeType.Down));
                CallingLogger.instance.print();
            }
            if (args.length <= 2 || "jump".equals(args[3])) {
                PrintUtils.println("开始频道控制", 3);
                CallingLogger.instance.start();
                PrintUtils.println("设置频道");
                EventTrigger.instance.execute("channelCtr", new ChangeEventArgs("client", Integer.parseInt(args.length <= 2 ? "10" : args[4]), ChangeType.Jump));
                CallingLogger.instance.print();
            }
        }

        if (args.length <= 2 || "mouse".equals(args[2])) {
            PrintUtils.println("模拟鼠标", 3);
            CallingLogger.instance.start();
            PrintUtils.println("模拟鼠标");
            EventTrigger.instance.execute("mouseCtr", new PeripheralEventArgs("client", args.length <= 2 ? "单击" : args[3], PeripheralType.mouse));
            CallingLogger.instance.print();
        }

        if (args.length <= 2 || "keyboard".equals(args[2])) {
            PrintUtils.println("模拟键盘", 3);
            CallingLogger.instance.start();
            EventTrigger.instance.execute("keyboardCtr", new PeripheralEventArgs("client", args.length <= 2 ? "K" : args[3], PeripheralType.mouse));
            CallingLogger.instance.print();
        }

        if (args.length <= 2 || "remotectr".equals(args[2])) {
            PrintUtils.println("模拟遥控器", 3);
            CallingLogger.instance.start();
            EventTrigger.instance.execute("remoteControlCtr", new PeripheralEventArgs("client", args.length <= 2 ? "8" : args[3], PeripheralType.mouse));
            CallingLogger.instance.print();
        }

        if (args.length <= 2 || "shutDownCtr".equals(args[2])) {
            PrintUtils.println("关机", 3);
            CallingLogger.instance.start();
            EventTrigger.instance.execute("shutDownCtr", new EventArgs("client"));
            CallingLogger.instance.print();
        }

        if (args.length <= 2 || "browseLocalMedia".equals(args[2])) {
            PrintUtils.println("浏览本地文件", 3);
            CallingLogger.instance.start();
            HandlerResult hr = EventTrigger.instance.execute("browseLocalMediaCtr", new EventArgs("client"));
            List<MediaFile> mediaFiles = (List<MediaFile>) hr.get("mediaFiles");
            for (MediaFile mediaFile : mediaFiles) {
                PrintUtils.println(mediaFile.toString());
            }
            CallingLogger.instance.print();
        }

        if (args.length <= 2 || "localMediaPlay".equals(args[2])) {
            PrintUtils.println("播放本地媒体文件", 3);
            if (args.length <= 2 || "video".equals(args[3])) {
                CallingLogger.instance.start();
                EventTrigger.instance.execute("localMediaPlayCtr", new MediaPlayEventArgs("client", MediaType.video, "/user/video/敢死队3.avi"));
                CallingLogger.instance.print();
            }
            if (args.length <= 2 || "audio".equals(args[3])) {
                CallingLogger.instance.start();
                EventTrigger.instance.execute("localMediaPlayCtr", new MediaPlayEventArgs("client", MediaType.audio, "/usr/music/朋友.mp3"));
                CallingLogger.instance.print();
            }
            if (args.length <= 2 || "picture".equals(args[3])) {
                CallingLogger.instance.start();
                EventTrigger.instance.execute("localMediaPlayCtr", new MediaPlayEventArgs("client", MediaType.picture, "/user/picture/美图2.jpg"));
                CallingLogger.instance.print();
            }
        }

        if (args.length <= 2 || "browseOnlineMedia".equals(args[3])) {
            PrintUtils.println("浏览在线视频", 3);
            CallingLogger.instance.start();
            HandlerResult hr = EventTrigger.instance.execute("browseOnlineMediaCtr", new EventArgs("client"));
            List<OnlineVideo> onlineVideos = (List<OnlineVideo>) hr.get("videos");
            for (OnlineVideo onlineVideo : onlineVideos) {
                PrintUtils.println(onlineVideo.toString());
            }
            CallingLogger.instance.print();
        }

        if (args.length <= 2 || "onlineVideoPlay".equals(args[3])) {
            PrintUtils.println("在线视频播放", 3);
            CallingLogger.instance.start();
            EventTrigger.instance.execute("onlineVideoPlayCtr",
                    new MediaPlayEventArgs("client", MediaType.picture, "http://video.iflytek.com/bianxingjingang.avi", "变形金刚4"));
            CallingLogger.instance.print();
        }

        if (args.length <= 2 || "yuyin".equals(args[3])) {
            PrintUtils.println("开启语音控制", 3);
            PrintUtils.println("正在倾听您的指令", 6);
            PrintUtils.println("正在识别(假设您说音量增大)", 3);
            EventTrigger.instance.execute("voiceCtr", new ChangeEventArgs("yuyin", ChangeType.Up));
            PrintUtils.println("正在识别(假设您说想看安徽卫视，频道10)", 3);
            EventTrigger.instance.execute("channelCtr", new ChangeEventArgs("yuyin", 10, ChangeType.Jump));
            PrintUtils.println("正在识别(假设您说播放变形金刚)", 3);
            EventTrigger.instance.execute("onlineVideoPlayCtr",
                    new MediaPlayEventArgs("yunyin", MediaType.picture, "http://video.iflytek.com/bianxingjingang.avi", "变形金刚4"));
        }

    }

}
