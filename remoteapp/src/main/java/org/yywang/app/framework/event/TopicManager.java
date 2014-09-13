package org.yywang.app.framework.event;

import org.yywang.app.framework.exception.AppSysException;
import org.yywang.app.framework.utils.CallingLogger;

import java.util.HashMap;
import java.util.Map;

/**
 * 主题管理器
 * @author yywang5
 */
public enum TopicManager {

    Instance;

    private Map<String, Topic> topics = new HashMap<String, Topic>();

    /**
     * @param topic 添加事件
     */
    public void addTopic(Topic topic) {

//        if (topics.containsKey(topic.getName())) {
//            throw new AppSysException(String.format(" %s is exited!", topic.getName()));
//        }
        topics.put(topic.getName(), topic);
    }

    public void removeTopic(String eventName) {
        topics.remove(eventName);
    }

    public void addEventHander(String eventName, EventHandler eventHandler) {
        if (topics.containsKey(eventName)) {
            Topic topic = topics.get(eventName);
            topic.addEventHander(eventHandler);
            topics.put(eventName, topic);
        } else {
            throw new AppSysException(String.format(" %s not exited!", eventName));
        }
    }

    public Topic getTopic(String eventName) {
        return topics.get(eventName);
    }

    public Topic[] getTopics() {
        CallingLogger.instance.append("TopicManager.getTopics");
        return topics.values().toArray(new Topic[topics.size()]);
    }
}
