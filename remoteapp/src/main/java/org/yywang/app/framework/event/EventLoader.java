package org.yywang.app.framework.event;

import org.yywang.app.framework.config.EventAppConfig;
import org.yywang.app.framework.config.EventConfig;
import org.yywang.app.framework.config.EventConfigUtils;
import org.yywang.app.framework.exception.AppSysException;

import java.util.ArrayList;
import java.util.List;

/**
 * 事件加载器
 *
 * @author yywang5
 */
public class EventLoader {

    /**
     * 加载事件
     * @author yywang5
     */
    public static void load(String fileName) {
        EventAppConfig eventAppConfig = EventConfigUtils.get(fileName);
        if (eventAppConfig.getModules() != null && !eventAppConfig.getModules().isEmpty()) {
            List<String> appConfigNames = eventAppConfig.getModules();
            for (String appConfigName : appConfigNames) {
                    load(appConfigName);
            }
        }
        List<EventConfig> eventConfigs = eventAppConfig.getEvents();
        for (EventConfig eventConfig : eventConfigs) {
            List<String> handlers = eventConfig.getHandlers();
            List<EventHandler> eventHandlers = new ArrayList<EventHandler>();
            for (String handler : handlers) {
                try {
                    eventHandlers.add((EventHandler) Class.forName(handler).newInstance());
                } catch (InstantiationException e) {
                    throw new AppSysException(String.format("实例化%s失败", handler));
                } catch (IllegalAccessException e) {
                    throw new AppSysException(String.format("实例化%s失败", handler));
                } catch (ClassNotFoundException e) {
                    throw new AppSysException(String.format("实例化%s失败", handler));
                }
            }
            Topic topic = new Topic(eventConfig.getName(), eventConfig.getDescribe(), eventHandlers, eventConfig.getEnable());
            TopicManager.Instance.addTopic(topic);
        }
    }
}
