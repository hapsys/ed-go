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


public class DBRolesForUserBean implements DbBean, Serializable {

	private static final long serialVersionUID = 1L;


	
	@DataSource({"role", "role"})
	@DataTarget("role")
	@XMLSimple("role")
	private java.lang.String role;
	
	public java.lang.String getRole() {
		return role;
	}
	
	public DBRolesForUserBean setRole(java.lang.String value) {
		this.role = value;
		return this;
	}
	
	
	@DataSource({"role_id", "roleId"})
	@DataTarget("role_id")
	@XMLSimple("roleId")
	private java.lang.Long roleId;
	
	public java.lang.Long getRoleId() {
		return roleId;
	}
	
	public DBRolesForUserBean setRoleId(java.lang.Long value) {
		this.roleId = value;
		return this;
	}
	
	
	@DataSource({"role_uuid", "roleUuid"})
	@DataTarget("role_uuid")
	@XMLSimple("roleUuid")
	private java.lang.String roleUuid;
	
	public java.lang.String getRoleUuid() {
		return roleUuid;
	}
	
	public DBRolesForUserBean setRoleUuid(java.lang.String value) {
		this.roleUuid = value;
		return this;
	}
	
	
	@DataSource({"role_description", "roleDescription"})
	@DataTarget("role_description")
	@XMLSimple("roleDescription")
	private java.lang.String roleDescription;
	
	public java.lang.String getRoleDescription() {
		return roleDescription;
	}
	
	public DBRolesForUserBean setRoleDescription(java.lang.String value) {
		this.roleDescription = value;
		return this;
	}
	
	@Override
	public void setAutoincrementField(Object value) {
		
		setRoleId(new java.lang.Long(value.toString()));
		
	}	
	
}