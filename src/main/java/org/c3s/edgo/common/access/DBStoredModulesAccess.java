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
public class DBStoredModulesAccess extends Access {
	protected DBConnection getConnection() {
		setNames();
		return getCon();
	}
	
	private DataMapper dataMapper = new GeneralDataMapper(new EdGoCast()); 
	
	protected void setNames() {
		con_name = "edgo";
		tablename = "stored_modules";
	}
	
	
	public int insert(DBStoredModulesBean bean) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		int res = _insert(bean);
		bean.setAutoincrementField(res);
		return res;
	}

	
	public List<DBStoredModulesBean> getTableRecords() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		return getTableRecords(null);
	}
	public List<DBStoredModulesBean> getTableRecords(SqlInjectorInterface injector) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<Map<String, Object>> result = _getTableRecords(injector);
		
		List<DBStoredModulesBean> ret = null;
		if (result != null) {
			ret = new ArrayList<DBStoredModulesBean>();
			for (Map<String, Object> res : result) {
				DBStoredModulesBean bean = dataMapper.mapFromRow(res, DBStoredModulesBean.class);
				
				ret.add(bean);
			}
		}
		return ret;
	}
	
	
	public DBStoredModulesBean getByPrimaryKey(java.lang.Long paramStoredModuleId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBStoredModulesBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1  AND  stored_module_id= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByPrimaryKey", sql ,  paramStoredModuleId);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBStoredModulesBean.class);
			
		}
		return ret;
	}
	
	public int deleteByPrimaryKey(java.lang.Long paramStoredModuleId) throws SQLException {
		setNames();
		String sql = "DELETE FROM " + tablename + " WHERE  1=1  AND  stored_module_id= ?  ";
		return getConnection().query(sql, paramStoredModuleId);
	}
	
	public List<DBStoredModulesListBean> getStoredModulesList(long paramPilotId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		
		String query = injector.getFullQuery();
		if (query == null) {
			String record = injector.getRecordQuery();
			String from = injector.getFromQuery();
			String join = injector.getJoinQuery();
			String where = injector.getWhereQuery();
			String order = injector.getOrderQuery();
			String limit = injector.getLimitQuery();
			query = " 				SELECT sm.*, LOWER(m.module_uniq) AS module_uniq, LOWER(s.name) AS system_name, LOWER(r.recipie_name) AS recipie_name, CONCAT(LOWER(s.name), sm.market_id, LOWER(m.module_uniq)) AS str_hash  				FROM modules m, systems s, stored_modules sm 				LEFT JOIN recipies r ON r.recipie_id = sm.recipie_id 				WHERE sm.pilot_id = ? 				AND m.module_id = sm.module_id 				AND s.system_id = sm.system_id 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getStoredModulesList", query ,  paramPilotId);
		List<DBStoredModulesListBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBStoredModulesListBean>();
				
			for (Map<String, Object> res : result) {
				DBStoredModulesListBean bean = dataMapper.mapFromRow(res, DBStoredModulesListBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
	public List<DBPilotStoredModulesListBean> getPilotStoredModulesList(long paramPilotId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		
		String query = injector.getFullQuery();
		if (query == null) {
			String record = injector.getRecordQuery();
			String from = injector.getFromQuery();
			String join = injector.getJoinQuery();
			String where = injector.getWhereQuery();
			String order = injector.getOrderQuery();
			String limit = injector.getLimitQuery();
			query = " 				SELECT IF(ISNULL(m.module_name), mg.module_group_name, m.module_name) as common_module_name, m.module_class, m.module_rating, m.module_weapon_mode, 				GROUP_CONCAT(DISTINCT CONCAT(s.name, IF(ISNULL(st.name), '', ' / '), IF(ISNULL(st.name), '', st.name)) SEPARATOR ', ') as module_place, COUNT(sm.stored_module_id) AS module_count,  				IF(ISNULL(r.recipie_loc_name), r.recipie_name, r.recipie_loc_name) as recipie_name , sm.recipie_grade 				FROM modules m, module_groups mg, systems s, stored_modules sm 				LEFT JOIN stations st ON st.market_id = sm.market_id  				LEFT JOIN recipies r ON r.recipie_id = sm.recipie_id 				WHERE sm.pilot_id = ? 				AND s.system_id = sm.system_id 				AND sm.module_id = m.module_id 				AND m.module_group_id != 50 				AND m.module_group_id = mg.module_group_id 				GROUP BY common_module_name, m.module_class, m.module_rating, m.module_weapon_mode, sm.recipie_id, sm.recipie_grade 				ORDER BY common_module_name, m.module_class DESC, m.module_rating ASC				 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getPilotStoredModulesList", query ,  paramPilotId);
		List<DBPilotStoredModulesListBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBPilotStoredModulesListBean>();
				
			for (Map<String, Object> res : result) {
				DBPilotStoredModulesListBean bean = dataMapper.mapFromRow(res, DBPilotStoredModulesListBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
}