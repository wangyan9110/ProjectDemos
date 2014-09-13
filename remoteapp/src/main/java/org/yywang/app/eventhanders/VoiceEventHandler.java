package org.yywang.app.eventhanders;

import org.yywang.app.framework.event.EventHandler;
import org.yywang.app.framework.event.HandlerResult;
import org.yywang.app.framework.utils.CallingLogger;
import org.yywang.app.framework.utils.PrintUtils;
import org.yywang.app.model.ChangeType;
import org.yywang.app.transmission.TransmissionCur;

/**
 * 音量
 *
 * @author yywang5
 */
public class VoiceEventHandler implements EventHandler<ChangeEventArgs> {

    @Override
    public void processHandler(ChangeEventArgs args, HandlerResult handlerResult) {
        CallingLogger.instance.append("VoiceEventHandler.processHandler");
        if (ChangeType.Down.equals(args.getChangeType())) {
            PrintUtils.println("减小声音：" + args.getStep());
        } else if (ChangeType.Up.equals(args.getChangeType())) {
            PrintUtils.println("增大声音：" + args.getStep());
        } else if (ChangeType.Jump.equals(args.getChangeType())) {
            PrintUtils.println("设置声音：" + args.getValue());
        }
        TransmissionCur.Instance.get().sendVoiceCommand(args.getChangeType(), args.getStep());
    }
}
