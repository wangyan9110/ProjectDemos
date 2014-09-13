package org.yywang.app.eventhanders;

import org.yywang.app.framework.event.EventArgs;
import org.yywang.app.model.PeripheralType;

/**
 * 外设事件
 *
 * @author yywang5
 */
public class PeripheralEventArgs extends EventArgs {

    /**
     * 模拟外设输入
     */
    private String text;

    /**
     * 外设类型
     */
    private PeripheralType peripheralType;

    public PeripheralEventArgs(Object sender, String text, PeripheralType peripheralType) {
        super(sender);
        this.text = text;
        this.peripheralType = peripheralType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public PeripheralType getPeripheralType() {
        return peripheralType;
    }

    public void setPeripheralType(PeripheralType peripheralType) {
        this.peripheralType = peripheralType;
    }
}
