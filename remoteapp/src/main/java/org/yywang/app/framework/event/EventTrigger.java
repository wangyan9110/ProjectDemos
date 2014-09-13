package org.yywang.app.framework.event;

import org.yywang.app.framework.utils.CallingLogger;

/**
 * 事件触发器
 *
 * @author yywang5
 */
public enum EventTrigger {

    instance;

    /**
     * 执行
     *
     * @param topicName 主题名字
     * @param eventArgs 事件参数
     * @return 处理结果
     */
    public HandlerResult execute(String topicName, EventArgs eventArgs) {
        CallingLogger.instance.append("EventTrigger.execute");

        Topic preTopic = TopicManager.Instance.getTopic("pre");
        HandlerResult preHr = new HandlerResult();
        preHr.put("topic", topicName);
        for (EventHandler eventHandler : preTopic.getEventHandlers()) {
            eventHandler.processHandler(eventArgs, preHr);
        }
        HandlerResult result = new HandlerResult();
        for (Topic topic : TopicManager.Instance.getTopics()) {
            if (topic.getName().equals(topicName)) {
                for (EventHandler eventHandler : topic.getEventHandlers()) {

                    eventHandler.processHandler(eventArgs, result);
                }
                break;
            }
        }
        return result;
    }
}
