package org.yywang.app.framework.utils;

import org.yywang.app.framework.exception.AppSysException;

/**
 * 打印信息用于模拟输出以及打印
 *
 * @author yywang
 */
public class PrintUtils {

    /**
     * 打印文本
     *
     * @param text 文本
     */
    public static void println(String text) {
        System.out.println("=====>" + text);
    }

    /**
     * 打印文本
     *
     * @param text      文本
     * @param waitCount 等待数
     */
    public static void println(String text, int waitCount) {
        println(text);
        for (int index = 0; index < waitCount; index++) {
            try {
                System.out.print(" .");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new AppSysException("线程出异常", e);
            }
        }

    }
}
