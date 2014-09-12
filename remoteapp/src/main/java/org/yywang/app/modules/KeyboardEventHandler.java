package org.yywang.app.modules;

import org.yywang.app.framework.event.EventHandler;
import org.yywang.app.framework.event.HandlerResult;
import org.yywang.app.framework.utils.PrintUtils;
import org.yywang.app.model.PeripheralType;
import org.yywang.app.transmission.TransmissionCur;

/**
 * 模拟键盘处理器
 *
 * @author yywang5
 */
public class KeyboardEventHandler implements EventHandler<PeripheralEventArgs> {

    @Override
    public void processHandler(PeripheralEventArgs args, HandlerResult handlerResult) {

        if (PeripheralType.keyboard.equals(args.getPeripheralType())) {
            PrintUtils.println("模拟键盘输入：" + args.getText());
            TransmissionCur.Instance.get().sendPeriperalTypeCommand(args.getPeripheralType(), args.getText());
        }

    }
}
