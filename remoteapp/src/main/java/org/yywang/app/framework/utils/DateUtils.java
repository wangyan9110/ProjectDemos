package org.yywang.app.framework.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yywang5
 */
public class DateUtils {

    /**
     * 格式化日期
     *
     * @param date    日期
     * @param pattern 格式化日期格式
     * @return 日期字符串
     */
    public static String format(Date date, String pattern) {
        if (pattern == null || pattern == "") {
            throw new IllegalArgumentException("parameter pattern is required ");
        }
        if (date == null) {
            throw new IllegalArgumentException("parameter date is required");
        }
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }
}
