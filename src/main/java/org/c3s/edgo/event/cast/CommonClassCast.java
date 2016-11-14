package org.c3s.edgo.event.cast;

import org.c3s.data.cast.GeneralCastType;

public class CommonClassCast extends GeneralCastType {
	
	public Integer castDoubleToInteger(Object value) {
		
		Integer result = null;
		
		if (value != null) {
			result = ((Double)value).intValue();
		}
		
		return result; 
		
	}
	
}
