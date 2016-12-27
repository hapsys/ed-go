package org.c3s.edgo.common.intruders;

import org.c3s.db.injectors.EmptySqlInjector;

public class SystemPathInjector extends EmptySqlInjector {
	
	private String from;
	private String to;
	private int page;
	private int items_per_page;
	
	public SystemPathInjector(int page, int items_per_page, String from, String to) {
		this.from = from;
		this.to = to;
		this.page = page;
		this.items_per_page = items_per_page;
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
