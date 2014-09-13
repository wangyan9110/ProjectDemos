package org.yywang.app.framework.log;

import org.yywang.app.framework.utils.DateUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yywang5
 */
public enum Log {

    instance;

    private List<LogInfo> logInfos = new ArrayList<LogInfo>();

    /**
     * 记录消息
     *
     * @param message 消息
     */
    public void info(String message) {
        log(LogType.info, message);
    }

    /**
     * 记录异常信息
     *
     * @param message 消息
     */
    public void error(String message) {
        log(LogType.error, message);
    }

    /**
     * 记录异常消息
     *
     * @param message 消息
     * @param e       异常
     */
    public void error(String message, Exception e) {
        StringBuffer exStringBuffer = new StringBuffer();
        if (message != null && !message.isEmpty()) {
            exStringBuffer.append(message).append("\n");
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        exStringBuffer.append(stringWriter.getBuffer().toString());
        error(exStringBuffer.toString());
    }

    /**
     * 记录警告信息
     *
     * @param message 消息
     */
    public void warn(String message) {
        log(LogType.warn, message);
    }

    /**
     * 记录日志
     *
     * @param logType 日志类型
     * @param message 消息
     */
    public void log(LogType logType, String message) {
        LogInfo logInfo = new LogInfo();
        logInfo.setDate(new Date());
        logInfo.setLogType(logType);
        logInfo.setMessage(message);
        logInfos.add(logInfo);
        if (logInfos.size() > 3) {
            save();
        }
    }

    /**
     * 刷新写入
     */
    public void flush() {
        save();
    }

    private void save() {
        FileWriter writer = null;
        try {
            writer = new FileWriter(DateUtils.format(new Date(), "yyyy-MM-dd-hh") + ".log", true);
            for (LogInfo loginfo1 : logInfos) {
                writer.write(loginfo1.toString());
            }
            logInfos.clear();
        } catch (IOException e) {
            error("日志记录失败", e);
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                error("日志记录失败", e);
            }
        }
    }
}
