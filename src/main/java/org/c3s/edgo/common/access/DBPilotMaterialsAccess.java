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


import org.c3s.edgo.common.beans.*;


@SuppressWarnings("unused")
public class DBPilotMaterialsAccess extends Access {
	protected DBConnection getConnection() {
		setNames();
		return getCon();
	}
	
	private DataMapper dataMapper = new GeneralDataMapper(new GeneralCastType()); 
	
	protected void setNames() {
		con_name = "edgo";
		tablename = "pilot_materials";
	}
	
	
	public int insert(DBPilotMaterialsBean bean) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		int res = _insert(bean);
		bean.setAutoincrementField(res);
		return res;
	}

	
	public List<DBPilotMaterialsBean> getTableRecords() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		return getTableRecords(null);
	}
	public List<DBPilotMaterialsBean> getTableRecords(SqlInjectorInterface injector) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<Map<String, Object>> result = _getTableRecords(injector);
		
		List<DBPilotMaterialsBean> ret = null;
		if (result != null) {
			ret = new ArrayList<DBPilotMaterialsBean>();
			for (Map<String, Object> res : result) {
				DBPilotMaterialsBean bean = dataMapper.mapFromRow(res, DBPilotMaterialsBean.class);
				
				ret.add(bean);
			}
		}
		return ret;
	}
	
	
	public DBPilotMaterialsBean getByPrimaryKey(java.lang.Long paramPilotId, java.lang.Long paramMaterialId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBPilotMaterialsBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1  AND  pilot_id= ?  AND  material_id= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByPrimaryKey", sql ,  paramPilotId,  paramMaterialId);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBPilotMaterialsBean.class);
			
		}
		return ret;
	}
	
	public int updateByPrimaryKey(DBPilotMaterialsBean bean, java.lang.Long paramPilotId, java.lang.Long paramMaterialId) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		 Map<String, Object> map = dataMapper.mapToRow(bean);
		 Map<String, Object> keys = new HashMap<String, Object>();
		 
		 keys.put("pilot_id",  paramPilotId);
		 
		 keys.put("material_id",  paramMaterialId);
		 
		return getConnection().updateRow("pilot_materials", map, keys);
	}
	
	public int deleteByPrimaryKey(java.lang.Long paramPilotId, java.lang.Long paramMaterialId) throws SQLException {
		setNames();
		String sql = "DELETE FROM " + tablename + " WHERE  1=1  AND  pilot_id= ?  AND  material_id= ?  ";
		return getConnection().query(sql, paramPilotId, paramMaterialId);
	}
	
	public int updateMaterialsForDelete(long paramPilotId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				UPDATE pilot_materials SET can_delete = 1 WHERE pilot_id = ? 			";
		}

		
		int ret = getConnection().query(query,  paramPilotId);
			
		return ret;
	}
	
	public List<DBPilotMaterialsListBean> getPilotMaterialsList(long paramPilotId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT m.*, mc.*, IF(ISNULL(pm.quantity), 0, pm.quantity) as quantity, 				'' as localized, UNIX_TIMESTAMP() - IF(ISNULL(pm.update_time),0,UNIX_TIMESTAMP(pm.update_time)) as update_time, COUNT(DISTINCT bm.eng_grade_id) as used 				FROM material_category mc, materials m 				LEFT JOIN pilot_materials pm ON pm.pilot_id = ? AND pm.material_id = m.material_id 				LEFT JOIN eng_blueprint_materials bm ON bm.material_id = m.material_id  				WHERE m.matherial_category_id = mc.material_category_id 				GROUP BY m.material_id    			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getPilotMaterialsList", query ,  paramPilotId);
		List<DBPilotMaterialsListBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBPilotMaterialsListBean>();
				
			for (Map<String, Object> res : result) {
				DBPilotMaterialsListBean bean = dataMapper.mapFromRow(res, DBPilotMaterialsListBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
	public int deleteMaterialsCanDelete(long paramPilotId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				DELETE FROM pilot_materials WHERE pilot_id = ? AND can_delete = 1 			";
		}

		
		int ret = getConnection().query(query,  paramPilotId);
			
		return ret;
	}
	
	public List<DBPilotMaterialsListWithLocaleBean> getPilotMaterialsListWithLocale(long paramPilotId, String paramLangId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT m.*, mc.*, IF(ISNULL(pm.quantity), 0, pm.quantity) as quantity, 				ml.material_name as localized, UNIX_TIMESTAMP() - IF(ISNULL(pm.update_time),0,UNIX_TIMESTAMP(pm.update_time)) as update_time, COUNT(DISTINCT bm.eng_grade_id) as used 				FROM material_category mc, materials m 				LEFT JOIN pilot_materials pm ON pm.pilot_id = ? AND pm.material_id = m.material_id 				LEFT JOIN eng_blueprint_materials bm ON bm.material_id = m.material_id 				LEFT JOIN languages l ON l.lang_uniq = ? 				LEFT JOIN material_langs ml ON ml.lang_id = l.lang_id AND ml.material_id = m.material_id      				WHERE m.matherial_category_id = mc.material_category_id 				GROUP BY m.material_id    			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getPilotMaterialsListWithLocale", query ,  paramPilotId,  paramLangId);
		List<DBPilotMaterialsListWithLocaleBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBPilotMaterialsListWithLocaleBean>();
				
			for (Map<String, Object> res : result) {
				DBPilotMaterialsListWithLocaleBean bean = dataMapper.mapFromRow(res, DBPilotMaterialsListWithLocaleBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
}