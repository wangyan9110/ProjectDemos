package org.yywang.app.framework.config;

import org.codehaus.jackson.map.ObjectMapper;
import org.yywang.app.framework.exception.AppSysException;
import org.yywang.app.framework.utils.CallingLogger;
import org.yywang.app.framework.utils.FileUtils;
import org.yywang.app.framework.utils.JsonUtils;

import java.io.IOException;

/**
 * 传输层工具类
 * @author yywang5
 */
public class TransmissionConfigUtils {

    /**
     * 获取协议配置
     * @return 协议配置
     */
    public static TransmissionConfig get(){
        CallingLogger.instance.append("TransmissionConfigUtils.get");
        String fileContext = FileUtils.read(TransmissionConfigUtils.class.getResource("/").getPath() + "transmission.appconfig");
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            return objectMapper.readValue(fileContext,TransmissionConfig.class);
        } catch (IOException e) {
            throw new AppSysException(String.format("配置文件解析失败,%s",fileContext),e);
        }
    }
}
