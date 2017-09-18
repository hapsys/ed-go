package org.c3s.edgo.common.intruders;

import java.util.List;

import org.c3s.db.injectors.EmptySqlInjector;
import org.c3s.edgo.common.beans.DBSystemsFactionHistoryBean;

public class SystemFactionHistoryInjector extends EmptySqlInjector {
	
	private List<DBSystemsFactionHistoryBean> list;
	
	public SystemFactionHistoryInjector(List<DBSystemsFactionHistoryBean> list) {
		this.list = list;
	}
	
	@Override
	public String getWhereQuery() {
		StringBuffer sb = new StringBuffer();

		if (list != null && list.size() > 0) {
			sb.append("AND (");
			boolean flag = false;
			for (DBSystemsFactionHistoryBean b: list) {
				if (flag) {
					sb.append("OR ");
				} else {
					flag = true;
				}
				sb.append("sf.system_id = " + b.getSystemId());
				sb.append(" AND sf.faction_id = " + b.getFactionId());
				sb.append(" AND sf.create_date >= '" + b.getCreateDate() + "'");
			}
			sb.append(")");
		}
		return sb.toString();
	}
	
}
