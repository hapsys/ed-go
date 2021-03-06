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


public class DBAtmClassesBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"atm_class_uniq", "atmClassUniq"})
	@DataTarget("atm_class_uniq")
	@XMLSimple("atmClassUniq")
	private java.lang.String atmClassUniq;
	
	public java.lang.String getAtmClassUniq() {
		return atmClassUniq;
	}
	
	public DBAtmClassesBean setAtmClassUniq(java.lang.String value) {
		this.atmClassUniq = value;
		return this;
	}
	
	
	@DataSource({"atm_class_id", "atmClassId"})
	@DataTarget("atm_class_id")
	@XMLSimple("atmClassId")
	private java.lang.Long atmClassId;
	
	public java.lang.Long getAtmClassId() {
		return atmClassId;
	}
	
	public DBAtmClassesBean setAtmClassId(java.lang.Long value) {
		this.atmClassId = value;
		return this;
	}
	
	
	@DataSource({"atm_class_name", "atmClassName"})
	@DataTarget("atm_class_name")
	@XMLSimple("atmClassName")
	private java.lang.String atmClassName;
	
	public java.lang.String getAtmClassName() {
		return atmClassName;
	}
	
	public DBAtmClassesBean setAtmClassName(java.lang.String value) {
		this.atmClassName = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
		setAtmClassId(new java.lang.Long(value.toString()));
		
	}	
	
}