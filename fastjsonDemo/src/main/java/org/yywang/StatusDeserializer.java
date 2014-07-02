package org.yywang;

import java.lang.reflect.Type;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

public class StatusDeserializer implements ObjectDeserializer {

	public <T> T deserialze(DefaultJSONParser parser, Type type,
			Object fieldName) {
		JSONLexer lexer = parser.getLexer();
		int value = lexer.intValue();
		return (T) Status.create(value);
	}

	public int getFastMatchToken() {
		// TODO Auto-generated method stub
		return 0;
	}
}
