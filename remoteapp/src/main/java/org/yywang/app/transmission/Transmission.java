package org.yywang.app.transmission;

import org.yywang.app.model.ChangeType;
import org.yywang.app.model.MediaType;
import org.yywang.app.model.PeripheralType;

import java.io.InputStream;

/**
 * 传输层
 * <p/>
 * <p>
 * 本接口的定义，主要支持模拟，实际的需要结合业务以及协议规则制定。
 * </p>
 *
 * @author yywang5
 */
public interface Transmission {


    /**
     * 发送普通命令
     *
     * @param text 命令
     */
    void sendCommand(String text);

    /**
     * 发送声音控制命令
     *
     * @param changeType 改变类型
     * @param value      改变值
     */
    void sendVoiceCommand(ChangeType changeType, Integer value);

    /**
     * 发送频道控制指令
     *
     * @param changeType 改变类型
     * @param value      改变值
     */
    void sendChannelCommand(ChangeType changeType, Integer value);

    /**
     * 发送关机命令
     */
    void sendShutdownCommand();

    /**
     * 发送手机画面信息
     *
     * @param inputStream 画面信息
     */
    void sendScreenCommand(InputStream inputStream);

    /**
     * 发送播放本地资源信息
     *
     * @param mediaType 媒体类型
     * @param filePath  媒体信息
     */
    void sendPlayLocalResCommand(MediaType mediaType, String filePath);

    /**
     * 播放在线资源
     *
     * @param mediaType 媒体类型
     * @param url       资源地址
     */
    void sendPlayOnlineCommand(MediaType mediaType, String url);

    /**
     * 发送外设设备模拟
     *
     * @param peripheralType 外设类型
     * @param text           模拟内容
     */
    void sendPeriperalTypeCommand(PeripheralType peripheralType, String text);

    /**
     * 发送广告策略
     *
     * @param text 广告策略
     * @param url  播放地址
     */
    void sendAdStrategyCommand(String text, String url);
}
