package org.c3s.edgo.event;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.c3s.edgo.common.beans.DBEventsBean;
import org.c3s.utils.RegexpUtils;
import org.c3s.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventMd5Transform {
	
	private static Logger logger = LoggerFactory.getLogger(EventMd5Transform.class);
	
	private static Map<String, String> suffix = new ConcurrentHashMap<>();
	
	static {
		suffix.put("Screenshot", "~,Src=.*$~");
	}

	public static void eventTransformMD5(DBEventsBean event) {
		if (suffix.containsKey(event.getEventName())) {
			String md5 = event.getJsonMd5(); 
			String content = RegexpUtils.preg_replace(suffix.get(event.getEventName()), event.getEventJson(), "}");
			event.setJsonMd5(Utils.MD5(content));
			logger.debug("Tranform MD5 for event \"{}\": old value {}, new value {} ", event.getEventName(), md5, event.getJsonMd5());
		}
	}
}
