package org.yywang.app.model;

/**
 * 在线视频
 *
 * @author yywang5
 */
public class OnlineVideo {

    /**
     * 在线视频id
     */
    private String id;

    /**
     * the name
     */
    private String name;

    /**
     * 地址
     */
    private String url;

    /**
     * 格式
     */
    private String format;

    /**
     * 语言
     */
    private String language;

    /**
     * 介绍
     */
    private String introduce;

    public OnlineVideo(String id, String name, String url, String format, String language, String introduce) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.format = format;
        this.language = language;
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return this.name + " " + this.url + " " + this.language + " " + this.introduce;
    }

    public OnlineVideo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
