package org.yywang.app.framework.utils;

import com.alibaba.fastjson.JSON;

/**
 * Json帮助类
 */
public class JsonUtils<T> {

    /**
     * 反序列化
     * @param json josn
     * @return 反序列化
     */
    public static Object parse(String json) {

        return JSON.parse(json);
    }
}
