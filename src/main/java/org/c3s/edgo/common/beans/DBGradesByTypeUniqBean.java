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


public class DBGradesByTypeUniqBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"eng_blueprint_id", "engBlueprintId"})
	@DataTarget("eng_blueprint_id")
	@XMLSimple("engBlueprintId")
	private java.lang.Long engBlueprintId;
	
	public java.lang.Long getEngBlueprintId() {
		return engBlueprintId;
	}
	
	public DBGradesByTypeUniqBean setEngBlueprintId(java.lang.Long value) {
		engBlueprintId = value;
		return this;
	}
	
	
	@DataSource({"engeneers", "engeneers"})
	@DataTarget("engeneers")
	@XMLSimple("engeneers")
	private java.lang.String engeneers;
	
	public java.lang.String getEngeneers() {
		return engeneers;
	}
	
	public DBGradesByTypeUniqBean setEngeneers(java.lang.String value) {
		engeneers = value;
		return this;
	}
	
	
	@DataSource({"eng_grade_id", "engGradeId"})
	@DataTarget("eng_grade_id")
	@XMLSimple("engGradeId")
	private java.lang.Long engGradeId;
	
	public java.lang.Long getEngGradeId() {
		return engGradeId;
	}
	
	public DBGradesByTypeUniqBean setEngGradeId(java.lang.Long value) {
		engGradeId = value;
		return this;
	}
	
	
	@DataSource({"eng_blueprint_uniq", "engBlueprintUniq"})
	@DataTarget("eng_blueprint_uniq")
	@XMLSimple("engBlueprintUniq")
	private java.lang.String engBlueprintUniq;
	
	public java.lang.String getEngBlueprintUniq() {
		return engBlueprintUniq;
	}
	
	public DBGradesByTypeUniqBean setEngBlueprintUniq(java.lang.String value) {
		engBlueprintUniq = value;
		return this;
	}
	
	
	@DataSource({"grade", "grade"})
	@DataTarget("grade")
	@XMLSimple("grade")
	private java.lang.Long grade;
	
	public java.lang.Long getGrade() {
		return grade;
	}
	
	public DBGradesByTypeUniqBean setGrade(java.lang.Long value) {
		grade = value;
		return this;
	}
	
	
	@DataSource({"eng_type_id", "engTypeId"})
	@DataTarget("eng_type_id")
	@XMLSimple("engTypeId")
	private java.lang.Long engTypeId;
	
	public java.lang.Long getEngTypeId() {
		return engTypeId;
	}
	
	public DBGradesByTypeUniqBean setEngTypeId(java.lang.Long value) {
		engTypeId = value;
		return this;
	}
	
	
	@DataSource({"localized", "localized"})
	@DataTarget("localized")
	@XMLSimple("localized")
	private java.lang.String localized;
	
	public java.lang.String getLocalized() {
		return localized;
	}
	
	public DBGradesByTypeUniqBean setLocalized(java.lang.String value) {
		localized = value;
		return this;
	}
	
	
	@DataSource({"eng_blueprint_name", "engBlueprintName"})
	@DataTarget("eng_blueprint_name")
	@XMLSimple("engBlueprintName")
	private java.lang.String engBlueprintName;
	
	public java.lang.String getEngBlueprintName() {
		return engBlueprintName;
	}
	
	public DBGradesByTypeUniqBean setEngBlueprintName(java.lang.String value) {
		engBlueprintName = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
		setEngBlueprintId(new java.lang.Long(value.toString()));
		
		setEngGradeId(new java.lang.Long(value.toString()));
		
	}	
	
}