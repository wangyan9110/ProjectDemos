package org.yywang.app.transmission;

import org.yywang.app.framework.utils.PrintUtils;

import java.io.InputStream;

/**
 * 一些基础的传输层方法
 *
 * @author yywang
 */
public abstract class BaseTransmission {

    /**
     * 本方法模拟发送方法
     *
     * @param text 文本
     */
    protected void mockSend(String text) {
        PrintUtils.println("发送命令:" + text);
    }

    /**
     * 模拟发送方法
     *
     * @param text        文本
     * @param inputStream 输入流
     */
    protected void mockSend(String text, InputStream inputStream) {
        PrintUtils.println("发送命令:" + text);
    }
}
