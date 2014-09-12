package org.yywang.app.framework.config;

import java.util.List;

/**
 * 事件配置
 *
 * @author yywang5
 */
public class EventConfig {

    /**
     * 事件名字
     */
    private String name;

    /**
     * 描述
     */
    private String describe;

    /**
     * 是否可用
     */
    private Boolean enable;

    /**
     * 处理器
     */
    private List<String> handlers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public List<String> getHandlers() {
        return handlers;
    }

    public void setHandlers(List<String> handlers) {
        this.handlers = handlers;
    }
}
