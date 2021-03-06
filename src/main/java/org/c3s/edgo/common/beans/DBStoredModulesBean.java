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


public class DBStoredModulesBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"stored_module_id", "storedModuleId"})
	@DataTarget("stored_module_id")
	@XMLSimple("storedModuleId")
	private java.lang.Long storedModuleId;
	
	public java.lang.Long getStoredModuleId() {
		return storedModuleId;
	}
	
	public DBStoredModulesBean setStoredModuleId(java.lang.Long value) {
		this.storedModuleId = value;
		return this;
	}
	
	
	@DataSource({"module_id", "moduleId"})
	@DataTarget("module_id")
	@XMLSimple("moduleId")
	private java.lang.Long moduleId;
	
	public java.lang.Long getModuleId() {
		return moduleId;
	}
	
	public DBStoredModulesBean setModuleId(java.lang.Long value) {
		this.moduleId = value;
		return this;
	}
	
	
	@DataSource({"recipie_grade", "recipieGrade"})
	@DataTarget("recipie_grade")
	@XMLSimple("recipieGrade")
	private java.lang.Integer recipieGrade;
	
	public java.lang.Integer getRecipieGrade() {
		return recipieGrade;
	}
	
	public DBStoredModulesBean setRecipieGrade(java.lang.Integer value) {
		this.recipieGrade = value;
		return this;
	}
	
	
	@DataSource({"system_id", "systemId"})
	@DataTarget("system_id")
	@XMLSimple("systemId")
	private java.math.BigInteger systemId;
	
	public java.math.BigInteger getSystemId() {
		return systemId;
	}
	
	public DBStoredModulesBean setSystemId(java.math.BigInteger value) {
		this.systemId = value;
		return this;
	}
	
	
	@DataSource({"market_id", "marketId"})
	@DataTarget("market_id")
	@XMLSimple("marketId")
	private java.math.BigInteger marketId;
	
	public java.math.BigInteger getMarketId() {
		return marketId;
	}
	
	public DBStoredModulesBean setMarketId(java.math.BigInteger value) {
		this.marketId = value;
		return this;
	}
	
	
	@DataSource({"recipie_id", "recipieId"})
	@DataTarget("recipie_id")
	@XMLSimple("recipieId")
	private java.lang.Long recipieId;
	
	public java.lang.Long getRecipieId() {
		return recipieId;
	}
	
	public DBStoredModulesBean setRecipieId(java.lang.Long value) {
		this.recipieId = value;
		return this;
	}
	
	
	@DataSource({"pilot_id", "pilotId"})
	@DataTarget("pilot_id")
	@XMLSimple("pilotId")
	private java.lang.Long pilotId;
	
	public java.lang.Long getPilotId() {
		return pilotId;
	}
	
	public DBStoredModulesBean setPilotId(java.lang.Long value) {
		this.pilotId = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
		setStoredModuleId(new java.lang.Long(value.toString()));
		
	}	
	
}