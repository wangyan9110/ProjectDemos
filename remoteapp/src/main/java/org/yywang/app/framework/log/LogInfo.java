package org.yywang.app.framework.log;

import org.yywang.app.framework.log.LogType;
import org.yywang.app.framework.utils.DateUtils;

import java.util.Date;

/**
 * 日志信息
 *
 * @author yywang5
 */
public class LogInfo {

    /**
     * 日志类型
     */
    private LogType logType;

    /**
     * 日志信息
     */
    private String message;

    /**
     * 日期
     */
    private Date date;

    @Override
    public String toString() {
        return DateUtils.format(this.date, "yyyy-MM-dd hh:mm:ss") + " "
                + logType.name() + "  " + message+"\n";
    }

    public LogType getLogType() {
        return logType;
    }

    public void setLogType(LogType logType) {
        this.logType = logType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
