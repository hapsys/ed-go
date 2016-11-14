package org.c3s.edgo.event;

import java.util.Map;

public interface JournalEvent {

	public void process(Map<String, Object> parameters);
	
}
