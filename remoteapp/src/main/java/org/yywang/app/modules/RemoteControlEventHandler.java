package org.yywang.app.modules;

import org.yywang.app.framework.event.EventHandler;
import org.yywang.app.framework.event.HandlerResult;
import org.yywang.app.framework.utils.PrintUtils;
import org.yywang.app.model.PeripheralType;
import org.yywang.app.transmission.TransmissionCur;

/**
 * 遥控器处理器
 *
 * @author yywang5
 */
public class RemoteControlEventHandler implements EventHandler<PeripheralEventArgs> {

    @Override
    public void processHandler(PeripheralEventArgs args, HandlerResult handlerResult) {

        if (PeripheralType.remoteControl.equals(args.getPeripheralType())) {
            PrintUtils.println("模拟遥控器输入：" + args.getText());
            TransmissionCur.Instance.get().sendPeriperalTypeCommand(args.getPeripheralType(), args.getText());
        }
    }
}
