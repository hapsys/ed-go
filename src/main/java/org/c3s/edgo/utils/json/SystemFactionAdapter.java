package org.c3s.edgo.utils.json;

import java.lang.reflect.Type;

import org.c3s.edgo.event.impl.beans.intl.FactionBean;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class SystemFactionAdapter implements JsonDeserializer<FactionBean> {
	 @Override
	 public FactionBean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext jsc) throws JsonParseException {
		 
		 FactionBean result = null;
		 
		 if (json.isJsonObject()) {
			 result = jsc.deserialize(json, typeOfT);
		 } else {
			 result = new FactionBean();
			 result.setName((String) jsc.deserialize(json, String.class));
		 }
		 
		 return result;
	 }
}