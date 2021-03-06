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


public class DBFactionInfluenceBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"date", "date"})
	@DataTarget("date")
	@XMLSimple("date")
	private String date;
	
	public String getDate() {
		return date;
	}
	
	public DBFactionInfluenceBean setDate(String value) {
		this.date = value;
		return this;
	}
	
	
	@DataSource({"timestamp", "timestamp"})
	@DataTarget("timestamp")
	@XMLSimple("timestamp")
	private java.util.Date timestamp;
	
	public java.util.Date getTimestamp() {
		return timestamp;
	}
	
	public DBFactionInfluenceBean setTimestamp(java.util.Date value) {
		this.timestamp = value;
		return this;
	}
	
	
	@DataSource({"influence", "influence"})
	@DataTarget("influence")
	@XMLSimple("influence")
	private Float influence;
	
	public Float getInfluence() {
		return influence;
	}
	
	public DBFactionInfluenceBean setInfluence(Float value) {
		this.influence = value;
		return this;
	}
	
	
	@DataSource({"state", "state"})
	@DataTarget("state")
	@XMLSimple("state")
	private String state;
	
	public String getState() {
		return state;
	}
	
	public DBFactionInfluenceBean setState(String value) {
		this.state = value;
		return this;
	}
	
	
	@DataSource({"see_flag", "seeFlag"})
	@DataTarget("see_flag")
	@XMLSimple("seeFlag")
	private Boolean seeFlag;
	
	public Boolean getSeeFlag() {
		return seeFlag;
	}
	
	public DBFactionInfluenceBean setSeeFlag(Boolean value) {
		this.seeFlag = value;
		return this;
	}
	
	
	@DataSource({"inherited", "inherited"})
	@DataTarget("inherited")
	@XMLSimple("inherited")
	private Boolean inherited;
	
	public Boolean getInherited() {
		return inherited;
	}
	
	public DBFactionInfluenceBean setInherited(Boolean value) {
		this.inherited = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
	}	
	
}