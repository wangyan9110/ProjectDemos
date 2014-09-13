package org.yywang.app.eventhanders;

import org.yywang.app.framework.event.EventArgs;
import org.yywang.app.framework.event.EventHandler;
import org.yywang.app.framework.event.HandlerResult;
import org.yywang.app.framework.utils.PrintUtils;
import org.yywang.app.model.MediaFile;
import org.yywang.app.model.MediaType;

import java.util.ArrayList;
import java.util.List;

/**
 * 浏览本地文件
 *
 * @author yywang
 */
public class BrowseLocalMediaEventHandler implements EventHandler<EventArgs> {

    @Override
    public void processHandler(EventArgs args, HandlerResult handlerResult) {
        PrintUtils.println("正在读取本地媒体文件..");
        List<MediaFile> mediaFiles = new ArrayList<MediaFile>();
        mediaFiles.add(new MediaFile("朋友.mp3", MediaType.audio, "/usr/music/朋友.mp3"));
        mediaFiles.add(new MediaFile("小苹果.mp3", MediaType.audio, "/usr/music/小苹果.mp3"));
        mediaFiles.add(new MediaFile("变形金刚4.avi", MediaType.video, "/user/video/变形金刚4.avi"));
        mediaFiles.add(new MediaFile("敢死队3.avi", MediaType.video, "/user/video/敢死队3.avi"));
        mediaFiles.add(new MediaFile("美图1.jpg", MediaType.picture, "/user/picture/美图1.jpg"));
        mediaFiles.add(new MediaFile("美图2.jpg", MediaType.picture, "/user/picture/美图2.jpg"));
        handlerResult.put("mediaFiles", mediaFiles);
    }
}
