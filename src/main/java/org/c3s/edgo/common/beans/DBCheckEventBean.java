/**
 *  Autogenerated class
 */
package org.c3s.edgo.common.beans;

import java.io.Serializable;
import java.util.*;
import org.c3s.db.beans.DbBean;
import org.c3s.data.annotations.DataSource;
import org.c3s.data.annotations.DataTarget;
import org.c3s.reflection.annotation.*;


public class DBCheckEventBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"events_count", "eventsCount"})
	@DataTarget("events_count")
	@XMLSimple("eventsCount")
	private java.lang.Long eventsCount;
	
	public java.lang.Long getEventsCount() {
		return eventsCount;
	}
	
	public DBCheckEventBean setEventsCount(java.lang.Long value) {
		this.eventsCount = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
	}	
	
}