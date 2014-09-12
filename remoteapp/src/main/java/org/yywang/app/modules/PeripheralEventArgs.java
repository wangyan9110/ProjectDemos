package org.yywang.app.modules;

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
