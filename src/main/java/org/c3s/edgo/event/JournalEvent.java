package org.c3s.edgo.event;

import org.c3s.edgo.common.entity.Event;

public interface JournalEvent {

	public void process(Event event);
	
}
