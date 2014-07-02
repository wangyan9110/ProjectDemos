package org.yywang;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

import com.alibaba.fastjson.serializer.SerializeConfig;

/**
 * fastjson 
 *
 */
public class App {
    public static void main( String[] args ){
    	Test test=new Test();
    	test.setId("123");
    	test.setStatus(Status.Ready);
    	SerializeConfig config=new SerializeConfig();
    	config.put(Status.class, new StatusSerializer());
    	String jsonStr=JSON.toJSONString(test,config);
    	System.out.println(jsonStr);
    	ParserConfig.getGlobalInstance().putDeserializer(Status.class, new StatusDeserializer());
    	Test test1=JSON.parseObject(jsonStr,Test.class);
    	System.out.println(test1.getStatus());
    }
}
