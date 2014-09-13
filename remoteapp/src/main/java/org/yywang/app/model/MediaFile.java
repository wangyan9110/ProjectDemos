package org.yywang.app.model;

import org.yywang.app.framework.utils.DateUtils;

import java.util.Date;

/**
 * 媒体文件
 *
 * @author yywang5
 */
public class MediaFile {

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 媒体类型
     */
    private MediaType mediaType;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 最后一次更新时间
     */
    private Date updatedTime;

    public MediaFile() {

    }

    public MediaFile(String fileName, MediaType mediaType, String filePath) {
        this.fileName = fileName;
        this.mediaType = mediaType;
        this.filePath = filePath;
        this.updatedTime = new Date();
    }

    @Override
    public String toString() {
        return this.fileName + "  " + this.filePath + " " + DateUtils.format(this.updatedTime, "yyyy-MM-dd hh:mm");
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
