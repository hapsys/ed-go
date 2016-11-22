package org.c3s.edgo.event;

import org.c3s.edgo.common.beans.DBEventsBean;

public interface JournalEvent {

	public void process(DBEventsBean event);
	
}
