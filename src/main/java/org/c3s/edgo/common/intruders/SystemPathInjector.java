package org.c3s.edgo.common.intruders;

import java.util.List;

import org.c3s.db.injectors.EmptySqlInjector;

public class SystemPathInjector extends EmptySqlInjector {
	
	private String from;
	private String to;
	private int page;
	private int items_per_page;
	private List<Long> values;
	
	
	public SystemPathInjector(int page, int items_per_page, String from, String to, List<Long> pilots) {
		this.from = from;
		this.to = to;
		this.page = page;
		this.items_per_page = items_per_page;
		this.values = pilots;
	}
	
	@Override
	public String getWhereQuery() {
		StringBuffer sb = new StringBuffer();

		sb.append("AND ");
		sb.append("l.pilot_id");
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
		
		if (from != null || to != null) {
			if (from != null) {
				sb.append("AND l.location_time >= '");
				sb.append(from);
				sb.append("'");
			}
			if (to != null) {
				sb.append("AND l.location_time <= '");
				sb.append(to);
				sb.append("'");
			}
		}
		return sb.toString();
	}
	
	@Override
	public String getLimitQuery() {
		StringBuffer sb = new StringBuffer();
		sb.append("LIMIT ");
		sb.append(page * items_per_page);
		sb.append(", ");
		sb.append(items_per_page);
		return sb.toString();
	}
}
