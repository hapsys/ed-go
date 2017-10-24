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


public class DBMissionsDateRangeBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"max_date", "maxDate"})
	@DataTarget("max_date")
	@XMLSimple("maxDate")
	private java.lang.String maxDate;
	
	public java.lang.String getMaxDate() {
		return maxDate;
	}
	
	public DBMissionsDateRangeBean setMaxDate(java.lang.String value) {
		this.maxDate = value;
		return this;
	}
	
	
	@DataSource({"min_date", "minDate"})
	@DataTarget("min_date")
	@XMLSimple("minDate")
	private java.lang.String minDate;
	
	public java.lang.String getMinDate() {
		return minDate;
	}
	
	public DBMissionsDateRangeBean setMinDate(java.lang.String value) {
		this.minDate = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
	}	
	
}