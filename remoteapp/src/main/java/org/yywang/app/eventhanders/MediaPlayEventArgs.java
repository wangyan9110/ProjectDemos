package org.yywang.app.eventhanders;

import org.yywang.app.framework.event.EventArgs;
import org.yywang.app.model.MediaType;

/**
 * @author yywang5
 */
public class MediaPlayEventArgs extends EventArgs {

    /**
     * 媒体类型
     */
    private MediaType mediaType;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 名字
     */
    private String name;

    public MediaPlayEventArgs(Object sender, MediaType mediaType, String filePath) {
        super(sender);
        this.mediaType = mediaType;
        this.filePath = filePath;
    }

    public MediaPlayEventArgs(Object sender, MediaType mediaType, String filePath, String name) {
        super(sender);
        this.mediaType = mediaType;
        this.filePath = filePath;
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
