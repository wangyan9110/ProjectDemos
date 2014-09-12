package org.yywang.app.framework.event;

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
