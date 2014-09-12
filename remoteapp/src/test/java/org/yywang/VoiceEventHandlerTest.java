package org.yywang;

import org.junit.Test;
import org.yywang.app.modules.ChangeEventArgs;
import org.yywang.app.model.ChangeType;
import org.yywang.app.framework.event.EventLoader;
import org.yywang.app.framework.event.EventTrigger;
import org.yywang.app.transmission.TransmissionCur;

/**
 * @author yywang5
 */
public class VoiceEventHandlerTest {


    /**
     *
     */
    @Test
    public void testAddVoice() {
        TransmissionCur.Instance.init("haier01");
        EventLoader.load("haier01");
        ChangeEventArgs changeEventArgs = new ChangeEventArgs();
        changeEventArgs.setChangeType(ChangeType.Up);
        EventTrigger.instance.execute("voice", changeEventArgs);
    }
}
