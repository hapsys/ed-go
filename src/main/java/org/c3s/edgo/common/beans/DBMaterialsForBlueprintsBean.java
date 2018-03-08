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


public class DBMaterialsForBlueprintsBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"eng_grade_id", "engGradeId"})
	@DataTarget("eng_grade_id")
	@XMLSimple("engGradeId")
	private java.lang.Long engGradeId;
	
	public java.lang.Long getEngGradeId() {
		return engGradeId;
	}
	
	public DBMaterialsForBlueprintsBean setEngGradeId(java.lang.Long value) {
		this.engGradeId = value;
		return this;
	}
	
	
	@DataSource({"material_uniq", "materialUniq"})
	@DataTarget("material_uniq")
	@XMLSimple("materialUniq")
	private java.lang.String materialUniq;
	
	public java.lang.String getMaterialUniq() {
		return materialUniq;
	}
	
	public DBMaterialsForBlueprintsBean setMaterialUniq(java.lang.String value) {
		this.materialUniq = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
	}	
	
}