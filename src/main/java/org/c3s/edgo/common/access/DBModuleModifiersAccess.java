/**
 *  Autogenerated class
 */
package org.c3s.edgo.common.access;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.c3s.db.access.Access;
import org.c3s.db.*;
import org.c3s.db.beans.*;
import org.c3s.db.injectors.SqlInjectorInterface;
import org.c3s.db.injectors.EmptySqlInjector;
import org.c3s.data.mapers.*;
import org.c3s.data.cast.*;
import org.c3s.edgo.utils.cast.EdGoCast;


import org.c3s.edgo.common.beans.*;


@SuppressWarnings("unused")
public class DBModuleModifiersAccess extends Access {
	protected DBConnection getConnection() {
		setNames();
		return getCon();
	}
	
	private DataMapper dataMapper = new GeneralDataMapper(new EdGoCast()); 
	
	protected void setNames() {
		con_name = "edgo";
		tablename = "module_modifiers";
	}
	
	
	public int insert(DBModuleModifiersBean bean) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		int res = _insert(bean);
		bean.setAutoincrementField(res);
		return res;
	}

	
	public List<DBModuleModifiersBean> getTableRecords() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		return getTableRecords(null);
	}
	public List<DBModuleModifiersBean> getTableRecords(SqlInjectorInterface injector) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<Map<String, Object>> result = _getTableRecords(injector);
		
		List<DBModuleModifiersBean> ret = null;
		if (result != null) {
			ret = new ArrayList<DBModuleModifiersBean>();
			for (Map<String, Object> res : result) {
				DBModuleModifiersBean bean = dataMapper.mapFromRow(res, DBModuleModifiersBean.class);
				
				ret.add(bean);
			}
		}
		return ret;
	}
	
	
	public DBModuleModifiersBean getByPrimaryKey(java.lang.Long paramModuleRecipeId, java.lang.Long paramModifierId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBModuleModifiersBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1  AND  module_recipe_id= ?  AND  modifier_id= ?  "+injector.getWhereQuery()+" ";
		if (injector.getOrderQuery().length() != 0) {
			sql += injector.getOrderQuery();
		} else { 
			
		}
		String limit = injector.getLimitQuery();
		if (limit.length() != 0) {
			sql += limit;
		} else {
			sql += " LIMIT 1";
		}
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByPrimaryKey", sql ,  paramModuleRecipeId,  paramModifierId);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBModuleModifiersBean.class);
			
		}
		return ret;
	}
	
	public int updateByPrimaryKey(DBModuleModifiersBean bean, java.lang.Long paramModuleRecipeId, java.lang.Long paramModifierId) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		 Map<String, Object> map = dataMapper.mapToRow(bean);
		 Map<String, Object> keys = new HashMap<String, Object>();
		 
		 keys.put("module_recipe_id",  paramModuleRecipeId);
		 
		 keys.put("modifier_id",  paramModifierId);
		 
		return getConnection().updateRow("module_modifiers", map, keys);
	}
	
	public int deleteByModuleRecipieId(java.lang.Long paramModuleRecipeId) throws SQLException {
		setNames();
		String sql = "DELETE FROM " + tablename + " WHERE  1=1  AND  module_recipe_id= ?  ";
		return getConnection().query(sql, paramModuleRecipeId);
	}
	
	public int deleteByPrimaryKey(java.lang.Long paramModuleRecipeId, java.lang.Long paramModifierId) throws SQLException {
		setNames();
		String sql = "DELETE FROM " + tablename + " WHERE  1=1  AND  module_recipe_id= ?  AND  modifier_id= ?  ";
		return getConnection().query(sql, paramModuleRecipeId, paramModifierId);
	}
	
	public List<DBModifyersByPilotModuleIdBean> getModifyersByPilotModuleId(org.c3s.db.injectors.EmptySqlInjector paramIntruder) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		if (paramIntruder != null) {
			injector = paramIntruder;
		}
		
		
		String query = injector.getFullQuery();
		if (query == null) {
			String record = injector.getRecordQuery();
			String from = injector.getFromQuery();
			String join = injector.getJoinQuery();
			String where = injector.getWhereQuery();
			String order = injector.getOrderQuery();
			String limit = injector.getLimitQuery();
			query = " 				SELECT mm.*, m.* 				FROM module_modifiers mm, modifiers m 				WHERE 1=1 				" + where + " 				AND m.modifier_id = mm.modifier_id 				ORDER BY mm.module_recipe_id, m.modifier_uniq 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getModifyersByPilotModuleId", query );
		List<DBModifyersByPilotModuleIdBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBModifyersByPilotModuleIdBean>();
				
			for (Map<String, Object> res : result) {
				DBModifyersByPilotModuleIdBean bean = dataMapper.mapFromRow(res, DBModifyersByPilotModuleIdBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
}