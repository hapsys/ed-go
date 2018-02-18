package org.c3s.edgo.event;

import java.util.Map;

public class EventExecutors {

	private Map<String, Integer> storedEventsNames = null;
	private Map<String, Integer> executeEventsNames = null;
	
	public EventExecutors(Map<String, Integer> storedEventsNames, Map<String, Integer> executeEventsNames) {
		super();
		this.storedEventsNames = storedEventsNames;
		this.executeEventsNames = executeEventsNames;
	}

	public Map<String, Integer> getStoredEventsNames() {
		return storedEventsNames;
	}

	public Map<String, Integer> getExecuteEventsNames() {
		return executeEventsNames;
	}
	
}
