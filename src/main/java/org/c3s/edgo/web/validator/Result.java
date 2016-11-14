package org.c3s.edgo.web.validator;

import java.util.HashMap;
import java.util.Map;

public class Result {

	protected Map<String, Object> fields = new HashMap<String, Object>();
		
	public Result() {
		put("status", 200);
		put("status_text",  "OK");
	}
	
	public Map<String, Object> get() {
		return fields;
	}
	
	public Result put(String key, Object value) {
		fields.put(key, value);
		return this;
	}

}
