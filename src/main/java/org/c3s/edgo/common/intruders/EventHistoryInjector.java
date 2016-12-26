package org.c3s.edgo.common.intruders;

import org.c3s.db.injectors.EmptySqlInjector;

public class EventHistoryInjector extends EmptySqlInjector {
	
	private String from;
	private String to;
	
	public EventHistoryInjector(String from, String to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	public String getWhereQuery() {
		StringBuffer sb = new StringBuffer();
		if (from != null && to != null) {
			if (from != null) {
				sb.append("AND e.event_timestamp >= '");
				sb.append(from);
				sb.append("'");
			}
			if (to != null) {
				sb.append("AND e.event_timestamp <= '");
				sb.append(to);
				sb.append("'");
			}
		}
		return sb.toString();
	}
}
