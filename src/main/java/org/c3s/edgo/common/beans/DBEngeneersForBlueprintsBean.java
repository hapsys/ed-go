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


public class DBEngeneersForBlueprintsBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"engeneers", "engeneers"})
	@DataTarget("engeneers")
	@XMLSimple("engeneers")
	private java.lang.String engeneers;
	
	public java.lang.String getEngeneers() {
		return engeneers;
	}
	
	public DBEngeneersForBlueprintsBean setEngeneers(java.lang.String value) {
		this.engeneers = value;
		return this;
	}
	
	
	@DataSource({"eng_grade_id", "engGradeId"})
	@DataTarget("eng_grade_id")
	@XMLSimple("engGradeId")
	private java.lang.Long engGradeId;
	
	public java.lang.Long getEngGradeId() {
		return engGradeId;
	}
	
	public DBEngeneersForBlueprintsBean setEngGradeId(java.lang.Long value) {
		this.engGradeId = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
	}	
	
}