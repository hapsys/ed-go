package org.c3s.edgo.common.intruders;

import java.util.List;

import org.c3s.db.injectors.EmptySqlInjector;

public class InInjector extends EmptySqlInjector {

	private String field;
	private List<? extends Object> values;
	
	public InInjector(String field, List<? extends Object> values) {
		this.field = field;
		this.values = values;
	}
	
	
	public String getWhereQuery() {
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
}
