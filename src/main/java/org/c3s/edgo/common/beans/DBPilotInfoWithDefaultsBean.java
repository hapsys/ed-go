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


public class DBPilotInfoWithDefaultsBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"def_level", "defLevel"})
	@DataTarget("def_level")
	@XMLSimple("defLevel")
	private java.lang.Long defLevel;
	
	public java.lang.Long getDefLevel() {
		return defLevel;
	}
	
	public DBPilotInfoWithDefaultsBean setDefLevel(java.lang.Long value) {
		this.defLevel = value;
		return this;
	}
	
	
	@DataSource({"level", "level"})
	@DataTarget("level")
	@XMLSimple("level")
	private java.lang.Long level;
	
	public java.lang.Long getLevel() {
		return level;
	}
	
	public DBPilotInfoWithDefaultsBean setLevel(java.lang.Long value) {
		this.level = value;
		return this;
	}
	
	
	@DataSource({"info_id", "infoId"})
	@DataTarget("info_id")
	@XMLSimple("infoId")
	private java.lang.Long infoId;
	
	public java.lang.Long getInfoId() {
		return infoId;
	}
	
	public DBPilotInfoWithDefaultsBean setInfoId(java.lang.Long value) {
		this.infoId = value;
		return this;
	}
	
	
	@DataSource({"info_uniq", "infoUniq"})
	@DataTarget("info_uniq")
	@XMLSimple("infoUniq")
	private java.lang.String infoUniq;
	
	public java.lang.String getInfoUniq() {
		return infoUniq;
	}
	
	public DBPilotInfoWithDefaultsBean setInfoUniq(java.lang.String value) {
		this.infoUniq = value;
		return this;
	}
	
	
	@DataSource({"sort", "sort"})
	@DataTarget("sort")
	@XMLSimple("sort")
	private java.lang.Long sort;
	
	public java.lang.Long getSort() {
		return sort;
	}
	
	public DBPilotInfoWithDefaultsBean setSort(java.lang.Long value) {
		this.sort = value;
		return this;
	}
	
	
	@DataSource({"info_link", "infoLink"})
	@DataTarget("info_link")
	@XMLSimple("infoLink")
	private java.lang.String infoLink;
	
	public java.lang.String getInfoLink() {
		return infoLink;
	}
	
	public DBPilotInfoWithDefaultsBean setInfoLink(java.lang.String value) {
		this.infoLink = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
		setInfoId(new java.lang.Long(value.toString()));
		
	}	
	
}