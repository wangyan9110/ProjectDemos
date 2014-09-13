package org.yywang.app.eventhanders;

import org.yywang.app.framework.event.EventHandler;
import org.yywang.app.framework.event.HandlerResult;
import org.yywang.app.framework.utils.CallingLogger;
import org.yywang.app.framework.utils.PrintUtils;
import org.yywang.app.model.PeripheralType;
import org.yywang.app.transmission.TransmissionCur;

/**
 * 模拟鼠标事件处理器
 *
 * @author yywang5
 */
public class MouseEventHandler implements EventHandler<PeripheralEventArgs> {

    @Override
    public void processHandler(PeripheralEventArgs args, HandlerResult handlerResult) {
        CallingLogger.instance.append("MouseEventHandler.processHandler");
        if (PeripheralType.mouse.equals(args.getPeripheralType())) {
            PrintUtils.println("模拟鼠标输入：" + args.getText());
            TransmissionCur.Instance.get().sendPeriperalTypeCommand(args.getPeripheralType(), args.getText());
        }
    }
}
