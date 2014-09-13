package org.yywang.app.framework.event;

/**
 * 基础的event
 */
public class EventArgs{

    /**
     * 发送者
     */
    private Object sender;

    public EventArgs(Object sender) {
        this.sender = sender;
    }

    public EventArgs() {
    }

    public Object getSender() {
        return sender;
    }

    public void setSender(Object sender) {
        this.sender = sender;
    }
}
