package org.yywang.app.framework.utils;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.yywang.app.framework.exception.AppSysException;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Json帮助类
 */
public class JsonUtils {

    /**
     * 反序列化
     *
     * @param json josn
     * @return 反序列化
     */
    public static Object parse(String json, Class<?> cls) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, cls);
        } catch (IOException e) {
            throw new AppSysException(String.format("解析失败,%s", json), e);
        }
    }

    /**
     * 序列化为json
     *
     * @param obj 对象
     * @return 字符串
     */
    public static String toJson(Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            StringWriter writer = new StringWriter();
            JsonGenerator gen = null;
            gen = new JsonFactory().createJsonGenerator(writer);
            mapper.writeValue(gen, obj);
            gen.close();
            String json = writer.toString();
            writer.close();
            return json;
        } catch (IOException e) {
            throw new AppSysException("json序列化失败", e);
        }

    }
}
