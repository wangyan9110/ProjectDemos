package org.yywang.app.framework.event;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题
 */
public class Topic {

    /**
     * 主题名
     */
    private String name;

    /**
     * 是否有效
     */
    private Boolean isEnable;

    /**
     * 主题描述
     */
    private String des;

    /**
     * 主题处理器
     */
    private List<EventHandler> eventHandlers = new ArrayList<EventHandler>();

    public Topic(String name, String des, List<EventHandler> eventHandlers, Boolean isEnable) {
        this.name = name;
        this.des = des;
        this.eventHandlers = eventHandlers;
        this.isEnable = isEnable;
    }

    public Topic(String name, String des, List<EventHandler> eventHandlers) {
        this(name, des, eventHandlers, true);
    }

    public Topic(String name, Boolean isEnable) {
        this(name, name, new ArrayList<EventHandler>(), isEnable);
    }

    public Topic(String name, EventHandler eventHandler){
        this(name, name, new ArrayList<EventHandler>(), true);
        this.eventHandlers.add(eventHandler);
    }

    public Topic(String name) {
        this(name, name, new ArrayList<EventHandler>());
    }

    public void addEventHander(EventHandler eventHandler) {
        eventHandlers.add(eventHandler);
    }

    public void removeEventHander(EventHandler eventHandler) {
        eventHandlers.remove(eventHandler);
    }

    public void clearEventHanders() {
        eventHandlers.clear();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }


    public List<EventHandler> getEventHandlers() {
        return eventHandlers;
    }

    public void setEventHandlers(List<EventHandler> eventHandlers) {
        this.eventHandlers = eventHandlers;
    }
}
