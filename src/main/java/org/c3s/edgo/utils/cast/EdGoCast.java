package org.c3s.edgo.utils.cast;

import org.c3s.data.cast.GeneralCastType;

public class EdGoCast extends GeneralCastType {
	
	public Long castIntegerToLong(Object object) {
		return new Long((Integer)object);
	}

}
