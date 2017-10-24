package org.c3s.edgo.common.intruders;

import java.util.List;

import org.c3s.db.injectors.EmptySqlInjector;

public class CommonInjector extends EmptySqlInjector {

	protected String inQuery(String field, List<? extends Object> values) {
		StringBuffer result = new StringBuffer();
		if (values != null && values.size() > 0) {
			result.append("AND ");
			result.append(field);
			result.append(" IN (");
			boolean flag = false;
			for(Object val: values) {
				if (flag) {
					result.append(", ");
				}
				
				if (val instanceof String) {
					result.append("\"");
					result.append(val.toString());
					result.append("\"");
				} else {
					result.append(val.toString());
				}
				
				flag = true;
			}
			result.append(") ");
		}
		return result.toString();
	}

	protected String dateRange(String field, String startDate, String endDate) {
		StringBuffer result = new StringBuffer();
		if (startDate != null || endDate != null) {
			if (startDate != null) {
				result.append("AND ");
				result.append(field);
				result.append(" >= \"");
				result.append(startDate);
				result.append("\" ");
			}
			if (endDate != null) {
				result.append("AND ");
				result.append(field);
				result.append(" <= \"");
				result.append(endDate);
				result.append("\" ");
			}
		}
		
		return result.toString();
	}
}
