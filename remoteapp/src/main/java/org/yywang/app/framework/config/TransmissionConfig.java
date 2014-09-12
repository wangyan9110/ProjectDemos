package org.yywang.app.framework.config;

import java.util.Map;

/**
 * 传输层配置
 * @author yywang5
 */
public class TransmissionConfig {

    /**
     * 版本
     */
    private String version;

    /**
     * 传输协议
     * key:电视，value:协议类
     */
    private Map<String,String> transmissions;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, String> getTransmissions() {
        return transmissions;
    }

    public void setTransmissions(Map<String, String> transmissions) {
        this.transmissions = transmissions;
    }
}
