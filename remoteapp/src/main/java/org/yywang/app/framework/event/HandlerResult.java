package org.yywang.app.framework.event;

import org.yywang.app.framework.exception.AppSysException;

import java.util.HashMap;

/**
 * 处理返回结果
 */
public class HandlerResult extends HashMap<String, Object> {

    @Override
    public Object put(String key, Object value) {
        if (this.containsKey(key)) {
            throw new AppSysException("key is exited!");
        }
        return super.put(key, value);
    }
}