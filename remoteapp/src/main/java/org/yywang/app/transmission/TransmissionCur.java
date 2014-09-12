package org.yywang.app.transmission;

import org.yywang.app.framework.exception.AppBizExpection;

/**
 * 当前传输协议
 * @author yywang5
 */
public enum TransmissionCur {

    Instance;

    private Transmission transmission;

    /**
     * 初始化
     * @param key 电视品牌+型号组成的key
     */
    public void init(String key){
        transmission=TransmissionLoader.load(key);
    }

    /**
     * 获取当前传输对象
     * @return 当前传输对象
     */
    public Transmission get(){
        if(transmission==null){
            throw new AppBizExpection("请初始化传输协议");
        }
        return transmission;
    }
}
