package org.yywang.app.eventhanders;

import org.yywang.app.framework.event.EventHandler;
import org.yywang.app.framework.event.HandlerResult;
import org.yywang.app.framework.utils.CallingLogger;
import org.yywang.app.framework.utils.PrintUtils;
import org.yywang.app.model.ChangeType;
import org.yywang.app.transmission.TransmissionCur;

/**
 * 频道
 *
 * @author yywang5
 */
public class ChannelEventHandler implements EventHandler<ChangeEventArgs> {

    @Override
    public void processHandler(ChangeEventArgs args, HandlerResult handlerResult) {
        CallingLogger.instance.append("ChannelEventHandler.processHandler");
        if (ChangeType.Down.equals(args.getChangeType())) {
            PrintUtils.println("增加频道：" + args.getStep());
        } else if (ChangeType.Up.equals(args.getChangeType())) {
            PrintUtils.println("减小频道：" + args.getStep());
        } else if (ChangeType.Jump.equals(args.getChangeType())) {
            PrintUtils.println("设置频道：" + args.getValue());
        }
        TransmissionCur.Instance.get().sendChannelCommand(args.getChangeType(), args.getStep());
    }
}
