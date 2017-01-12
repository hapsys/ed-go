package org.c3s.edgo.common.intruders;

import java.util.List;

import org.c3s.db.injectors.EmptySqlInjector;

public class EventHistoryPilotsInjector extends EmptySqlInjector {

	private List<? extends Object> values;
	
	public EventHistoryPilotsInjector(List<? extends Object> values) {
		this.values = values;
	}
	
	
	public String getWhereQuery() {
		StringBuffer result = new StringBuffer();
		if (values != null && values.size() > 0) {
			result.append("AND (");
			boolean flag = false;
			for(Object val: values) {
				if (flag) {
					result.append("OR ");
				}
				
				result.append("(h.pilot_id = ");
				appendValue(result, val);
				result.append(" AND h.events_history_id = (SELECT h1.events_history_id FROM events_history h1 WHERE h1.pilot_id = ");
				appendValue(result, val);
				result.append(" ORDER BY h1.event_timestamp DESC LIMIT 1)) ");
				flag = true;
			}
			result.append(") ");
		}
		return result.toString();
	}
	
	private void appendValue(StringBuffer sb, Object val) {
		if (val instanceof String) {
			sb.append("\"");
			sb.append(val.toString());
			sb.append("\"");
		} else {
			sb.append(val.toString());
		}
	}
}
