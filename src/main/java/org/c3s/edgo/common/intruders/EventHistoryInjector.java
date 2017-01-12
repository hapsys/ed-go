package org.c3s.edgo.common.intruders;

import java.util.List;

import org.c3s.db.injectors.EmptySqlInjector;

public class EventHistoryInjector extends EmptySqlInjector {
	
	private String from;
	private String to;
	private List<Long> values;
	
	public EventHistoryInjector(String from, String to, List<Long> pilots) {
		this.from = from;
		this.to = to;
		values = pilots;
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
		
		sb.append("AND ");
		sb.append("e.pilot_id");
		sb.append(" IN (");
		boolean flag = false;
		for(Object val: values) {
			if (flag) {
				sb.append(", ");
			}
			
			if (val instanceof String) {
				sb.append("\"");
				sb.append(val.toString());
				sb.append("\"");
			} else {
				sb.append(val.toString());
			}
			
			flag = true;
		}
		sb.append(") ");
		
		return sb.toString();
	}
}
