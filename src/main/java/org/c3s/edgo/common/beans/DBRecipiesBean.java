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


public class DBRecipiesBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"recipie_id", "recipieId"})
	@DataTarget("recipie_id")
	@XMLSimple("recipieId")
	private java.lang.Long recipieId;
	
	public java.lang.Long getRecipieId() {
		return recipieId;
	}
	
	public DBRecipiesBean setRecipieId(java.lang.Long value) {
		recipieId = value;
		return this;
	}
	
	
	@DataSource({"recipie_name", "recipieName"})
	@DataTarget("recipie_name")
	@XMLSimple("recipieName")
	private java.lang.String recipieName;
	
	public java.lang.String getRecipieName() {
		return recipieName;
	}
	
	public DBRecipiesBean setRecipieName(java.lang.String value) {
		recipieName = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
		setRecipieId(new java.lang.Long(value.toString()));
		
	}	
	
}