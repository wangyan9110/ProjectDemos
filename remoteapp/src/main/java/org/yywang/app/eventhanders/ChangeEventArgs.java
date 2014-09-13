package org.yywang.app.eventhanders;

import org.yywang.app.framework.event.EventArgs;
import org.yywang.app.model.ChangeType;

/**
 * 选择控制类事件参数
 *
 * @author yywang5
 */
public class ChangeEventArgs extends EventArgs {

    /**
     * 变化类型
     */
    private ChangeType changeType;

    /**
     * 变化步
     */
    private int step = 1;

    /**
     * 跳转时的值
     */
    private int value = 1;

    public ChangeEventArgs(Object sender, int value, ChangeType changeType) {
        super(sender);
        this.value = value;
        this.changeType = changeType;
    }

    public ChangeEventArgs(Object sender, ChangeType changeType) {
        super(sender);
        this.changeType = changeType;
    }

    public ChangeType getChangeType() {
        return changeType;
    }

    public void setChangeType(ChangeType changeType) {
        this.changeType = changeType;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
