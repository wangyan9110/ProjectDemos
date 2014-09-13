package org.yywang.app.transmission;

import org.yywang.app.framework.exception.AppUnSupportException;
import org.yywang.app.framework.utils.CallingLogger;
import org.yywang.app.framework.utils.PrintUtils;
import org.yywang.app.model.ChangeType;
import org.yywang.app.model.MediaType;
import org.yywang.app.model.PeripheralType;

import java.io.InputStream;

/**
 * 海尔电视传输协议实现
 *
 * @author yywang5
 */
public class HaierTransmission extends BaseTransmission implements Transmission {

    @Override
    public void sendCommand(String text) {
        PrintUtils.println("Info:" + text);
    }

    @Override
    public void sendVoiceCommand(ChangeType changeType, Integer value) {
        CallingLogger.instance.append("HaierTransmission.sendVoiceCommand");
        if (ChangeType.Down.equals(changeType)) {
            mockSend("V-" + value);
        } else if (ChangeType.Up.equals(changeType)) {
            mockSend("V+" + value);
        } else if (ChangeType.Jump.equals(changeType)) {
            mockSend("V set:" + value);
        } else {
            throw new AppUnSupportException("unsupported the command!");
        }
    }

    @Override
    public void sendChannelCommand(ChangeType changeType, Integer value) {
        CallingLogger.instance.append("HaierTransmission.sendChannelCommand");
        if (ChangeType.Down.equals(changeType)) {
            mockSend("C-" + value);
        } else if (ChangeType.Up.equals(changeType)) {
            mockSend("C+" + value);
        } else if (ChangeType.Jump.equals(changeType)) {
            mockSend("C set:" + value);
        } else {
            throw new AppUnSupportException("unsupported the command!");
        }
    }

    @Override
    public void sendShutdownCommand() {
        CallingLogger.instance.append("HaierTransmission.sendShutdownCommand");
        mockSend("shutdown");
    }

    @Override
    public void sendScreenCommand(InputStream inputStream) {
        CallingLogger.instance.append("HaierTransmission.sendScreenCommand");
        mockSend("send screen", inputStream);
    }

    @Override
    public void sendPlayLocalResCommand(MediaType mediaType, String text) {
        CallingLogger.instance.append("HaierTransmission.sendPlayLocalResCommand");
        if (MediaType.audio.equals(mediaType)) {
            mockSend("pl:audio " + text);
        } else if (MediaType.picture.equals(mediaType)) {
            mockSend("pl:picture " + text);
        } else if (MediaType.video.equals(mediaType)) {
            mockSend("pl:video " + text);
        } else {
            throw new AppUnSupportException("unsupported the command!");
        }
    }

    @Override
    public void sendPlayOnlineCommand(MediaType mediaType, String url) {
        CallingLogger.instance.append("HaierTransmission.sendPlayOnlineCommand");
        if (MediaType.audio.equals(mediaType)) {
            mockSend("pol:audio " + url);
        } else if (MediaType.picture.equals(mediaType)) {
            mockSend("pol:picture " + url);
        } else if (MediaType.video.equals(mediaType)) {
            mockSend("pol:video " + url);
        } else {
            throw new AppUnSupportException("unsupported the command!");
        }
    }

    @Override
    public void sendPeriperalTypeCommand(PeripheralType peripheralType, String text) {
        CallingLogger.instance.append("HaierTransmission.sendPeriperalTypeCommand");
        if (PeripheralType.keyboard.equals(peripheralType)) {
            mockSend("keyboard:" + text);
        } else if (PeripheralType.mouse.equals(peripheralType)) {
            mockSend("mouse:" + text);
        } else if (PeripheralType.remoteControl.equals(peripheralType)) {
            mockSend("rc:" + text);
        } else {
            throw new AppUnSupportException("unsupported the command!");
        }
    }

    @Override
    public void sendAdStrategyCommand(String text, String url) {
        CallingLogger.instance.append("HaierTransmission.sendAdStrategyCommand");
        mockSend("ad:" + text + " 加载地址：" + url);
    }
}
