package org.yywang.app.transmission;

import org.yywang.app.framework.config.TransmissionConfig;
import org.yywang.app.framework.config.TransmissionConfigUtils;
import org.yywang.app.framework.exception.AppSysException;
import org.yywang.app.framework.exception.AppUnSupportException;

import java.util.Map;

/**
 * 加载传输
 *
 * @author yywang
 */
public class TransmissionLoader {

    /**
     * 加载传输对象
     *
     * @param key key（电视品牌+型号组成的key）
     * @return
     */
    public static Transmission load(String key) {
        TransmissionConfig config = TransmissionConfigUtils.get();
        Map<String, String> transMap = config.getTransmissions();
        String transClassName="";
        try {
             transClassName = transMap.get(key);
            if (transClassName == null||transClassName=="") {
                throw new AppUnSupportException(String.format("该电视类型%s不支持！",key));
            }
            Transmission transmission = (Transmission) Class.forName(transClassName).newInstance();
            return transmission;
        } catch (InstantiationException e) {
            throw new AppSysException(String.format("实例化%s失败",transClassName),e);
        } catch (IllegalAccessException e) {
            throw new AppSysException(String.format("实例化%s失败",transClassName),e);
        } catch (ClassNotFoundException e) {
            throw new AppSysException(String.format("实例化%s失败",transClassName),e);
        }
    }

}
