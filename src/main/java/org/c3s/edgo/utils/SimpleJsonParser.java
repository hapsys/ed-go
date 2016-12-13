package org.c3s.edgo.utils;

import java.math.BigInteger;
import java.sql.SQLException;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBEventsBean;
import org.c3s.lib.parsers.Callable;
import org.c3s.lib.parsers.StringParser;
import org.c3s.lib.parsers.interceptors.CharInterceptor;
import org.c3s.lib.parsers.interceptors.RegMatchInterceptor;
import org.c3s.utils.RegexpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleJsonParser extends StringParser {
	
	private static Logger logger = LoggerFactory.getLogger(SimpleJsonParser.class);
	
	int openBraces = 0;
	int start = 0;
	int length = 0;
	String json = "";
	String buffer = "";
	
	public SimpleJsonParser() {
		registerHandler(new CharInterceptor("{"), new Callable(this, "onOpen"));
		registerHandler(new CharInterceptor("}"), new Callable(this, "onClose"));
		registerHandler(new RegMatchInterceptor("~[^{}]~is"), new Callable(this, "onChar"));
	}

	@Override
	protected void onStart(Object source) {
		openBraces = 0;
		start = 0;
		length = 0;
		json = "";
		buffer = source.toString();
	}

	@Override
	protected void onStop(Object arg0) {
		// TODO Auto-generated method stub
	}

	/*
	@Override
	public void process(Object source) throws Exception {
		buffer = source.toString();
		this.onStart(buffer);
		for (int index = 0; index < buffer.length(); index++) {
			this.processInterceptors(buffer.charAt(index));
		}
		this.onStop(buffer);
	}
	*/

	protected boolean onOpen(Character _char) {
		//System.out.println("Open brace");
		openBraces++;
		length++;
		return false;
	}
	
	protected boolean onClose(Character _char) {
		//System.out.println("Close brace");
		openBraces--;
		length++;
		if (openBraces == 0) {
			json = buffer.substring(start, start + length);
			buffer = buffer.substring(start + length);
			start = 0;
			length = 0;
			onJson(json);
		}
		return false;
	}
	
	protected boolean onChar(Character _char) {
		if (openBraces == 0) {
			start++;
		} else {
			length++;
		}
		return false;
	}
	
	private long userId = 0;
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getUserId() {
		return userId;
	}
	
	protected void onJson(String json) {
		//System.out.println(json);
		String name = RegexpUtils.preg_replace("~^.+\"event\"\\s*:\\s*\"([^\"]+)\".*$~isu", json, "$1");
		DBEventsBean evt = new DBEventsBean();
		evt.setEventId(BigInteger.valueOf(System.nanoTime()));
		evt.setUserId(getUserId());
		evt.setEventName(name);
		evt.setEventJson(json);
		evt.setIsLocked(0);
		try {
			DbAccess.eventsAccess.insert(evt);
		} catch (IllegalArgumentException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
