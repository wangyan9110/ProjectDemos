package org.yywang.app.framework.config;

import java.util.List;

/**
 * 事件配置类
 * @author yywang5
 */
public class EventAppConfig {

    /**
     * 版本号
     */
    private String version;

    /**
     * 组合模块
     */
    private List<String> modules;

    /**
     * 事件配置
     */
    private List<EventConfig> events;

    public List<String> getModules() {
        return modules;
    }

    public void setModules(List<String> modules) {
        this.modules = modules;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<EventConfig> getEvents() {
        return events;
    }

    public void setEvents(List<EventConfig> events) {
        this.events = events;
    }
}
