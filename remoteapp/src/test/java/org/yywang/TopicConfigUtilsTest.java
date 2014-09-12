package org.yywang;

import junit.framework.Assert;
import org.junit.Test;
import org.yywang.app.framework.config.EventAppConfig;
import org.yywang.app.framework.config.EventConfig;
import org.yywang.app.framework.config.EventConfigUtils;

/**
 * 测试类
 * @author yywang5
 */
public class TopicConfigUtilsTest {

    /**
     *
     */
    @Test
    public void testGet(){
      EventAppConfig eventConfig=EventConfigUtils.get("base.appconfig");
       Assert.assertNotNull(eventConfig);
    }
}
