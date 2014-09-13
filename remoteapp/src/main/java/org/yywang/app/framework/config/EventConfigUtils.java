package org.yywang.app.framework.config;

import org.codehaus.jackson.map.ObjectMapper;
import org.yywang.app.framework.exception.AppSysException;
import org.yywang.app.framework.utils.CallingLogger;
import org.yywang.app.framework.utils.FileUtils;

import java.io.IOException;

/**
 * 事件配置帮助类
 *
 * @author yywang
 */
public class EventConfigUtils {

    /**
     * 获取事件配置
     *
     * @param fileName 文件
     * @return 事件配置
     */
    public static EventAppConfig get(String fileName) {
        CallingLogger.instance.append("EventAppConfig.get");
        String fileNameStr=fileName;
        if (!fileName.endsWith(".appconfig")) {
            fileNameStr=fileName+".appconfig";
        }
        String fileContext = FileUtils.read(EventConfigUtils.class.getResource("/").getPath()
                + "/eventConfig/" + fileNameStr);
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            return objectMapper.readValue(fileContext,EventAppConfig.class);
        } catch (IOException e) {
            throw new AppSysException(String.format("配置文件解析失败,%s",fileContext),e);
        }
    }

}
