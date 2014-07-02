package org.yywang;

import java.io.IOException;
import java.lang.reflect.Type;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

public class StatusSerializer implements ObjectSerializer{

	public void write(JSONSerializer serializer, Object object,
			Object fieldName, Type fieldType) throws IOException {
		SerializeWriter out = serializer.getWriter();
		 if (object == null) {
	            serializer.getWriter().writeNull();
	            return;
	        }
		 out.write(Status.value((Status)object));
	}

}
