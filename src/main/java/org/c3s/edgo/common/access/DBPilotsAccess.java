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
public class DBPilotsAccess extends Access {
	protected DBConnection getConnection() {
		setNames();
		return getCon();
	}
	
	private DataMapper dataMapper = new GeneralDataMapper(new GeneralCastType()); 
	
	protected void setNames() {
		con_name = "edgo";
		tablename = "pilots";
	}
	
	
	public int insert(DBPilotsBean bean) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		int res = _insert(bean);
		bean.setAutoincrementField(res);
		return res;
	}

	
	public List<DBPilotsBean> getTableRecords() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		return getTableRecords(null);
	}
	public List<DBPilotsBean> getTableRecords(SqlInjectorInterface injector) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<Map<String, Object>> result = _getTableRecords(injector);
		
		List<DBPilotsBean> ret = null;
		if (result != null) {
			ret = new ArrayList<DBPilotsBean>();
			for (Map<String, Object> res : result) {
				DBPilotsBean bean = dataMapper.mapFromRow(res, DBPilotsBean.class);
				
				ret.add(bean);
			}
		}
		return ret;
	}
	
	
	public List<DBPilotsBean> getByUserIdNoIgnored(java.lang.Long paramUserId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<DBPilotsBean> ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1 AND  user_id= ? AND  is_ignored<>1 "+injector.getWhereQuery()+" ";
		if (injector.getOrderQuery().length() != 0) {
			sql += injector.getOrderQuery();
		} else { 
			
		}
		String limit = injector.getLimitQuery();
		if (limit.length() != 0) {
			sql += limit;
		} else {
			
		}
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByUserIdNoIgnored", sql ,  paramUserId);
		if (result != null) {
			
			ret = new ArrayList<DBPilotsBean>();
			for (Map<String, Object> res : result) {
				DBPilotsBean bean = dataMapper.mapFromRow(res, DBPilotsBean.class);
				 
				ret.add(bean);
			}
				
		}
		return ret;
	}
	
	public List<DBPilotsBean> getByUserId(java.lang.Long paramUserId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<DBPilotsBean> ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1 AND  user_id= ?  "+injector.getWhereQuery()+" ";
		if (injector.getOrderQuery().length() != 0) {
			sql += injector.getOrderQuery();
		} else { 
			
		}
		String limit = injector.getLimitQuery();
		if (limit.length() != 0) {
			sql += limit;
		} else {
			
		}
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByUserId", sql ,  paramUserId);
		if (result != null) {
			
			ret = new ArrayList<DBPilotsBean>();
			for (Map<String, Object> res : result) {
				DBPilotsBean bean = dataMapper.mapFromRow(res, DBPilotsBean.class);
				 
				ret.add(bean);
			}
				
		}
		return ret;
	}
	
	public List<DBPilotsBean> getLinkedPilots(java.lang.Long paramParentPilotId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<DBPilotsBean> ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1 AND  parent_pilot_id= ?  "+injector.getWhereQuery()+" ";
		if (injector.getOrderQuery().length() != 0) {
			sql += injector.getOrderQuery();
		} else { 
			
		}
		String limit = injector.getLimitQuery();
		if (limit.length() != 0) {
			sql += limit;
		} else {
			
		}
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getLinkedPilots", sql ,  paramParentPilotId);
		if (result != null) {
			
			ret = new ArrayList<DBPilotsBean>();
			for (Map<String, Object> res : result) {
				DBPilotsBean bean = dataMapper.mapFromRow(res, DBPilotsBean.class);
				 
				ret.add(bean);
			}
				
		}
		return ret;
	}
	
	public DBPilotsBean getByUserIdAndName(java.lang.Long paramUserId, java.lang.String paramPilotName)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBPilotsBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1 AND  user_id= ? AND  pilot_name= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByUserIdAndName", sql ,  paramUserId,  paramPilotName);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBPilotsBean.class);
			
		}
		return ret;
	}
	
	public DBPilotsBean getByPrimaryKey(java.lang.Long paramPilotId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBPilotsBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1 AND  pilot_id= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByPrimaryKey", sql ,  paramPilotId);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBPilotsBean.class);
			
		}
		return ret;
	}
	
	public DBPilotsBean getByName(java.lang.String paramPilotName)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBPilotsBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1 AND  pilot_name= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByName", sql ,  paramPilotName);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBPilotsBean.class);
			
		}
		return ret;
	}
	
	public DBPilotsBean getCurrentByUserId(java.lang.Long paramUserId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBPilotsBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1 AND  user_id= ? AND  is_current=1 "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getCurrentByUserId", sql ,  paramUserId);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBPilotsBean.class);
			
		}
		return ret;
	}
	
	public int updateByPrimaryKey(DBPilotsBean bean, java.lang.Long paramPilotId) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		 Map<String, Object> map = dataMapper.mapToRow(bean);
		 Map<String, Object> keys = new HashMap<String, Object>();
		 
		 keys.put("pilot_id",  paramPilotId);
		 
		return getConnection().updateRow("pilots", map, keys);
	}
	
	public List<DBPilotsBean> getMenuPilotsByUserId(long paramUserId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT p.* 				FROM pilots p 				WHERE p.user_id = ? 				AND p.is_ignored != 1 				AND ISNULL(p.parent_pilot_id) 				ORDER BY p.pilot_name 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getMenuPilotsByUserId", query ,  paramUserId);
		List<DBPilotsBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBPilotsBean>();
				
			for (Map<String, Object> res : result) {
				DBPilotsBean bean = dataMapper.mapFromRow(res, DBPilotsBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
	public int updateNoCurrent(long paramUserId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				UPDATE pilots SET is_current = 0 WHERE user_id = ? 			";
		}

		
		int ret = getConnection().query(query,  paramUserId);
			
		return ret;
	}
	
	public List<DBSearchPilotsBean> getSearchPilots(Long paramUserId, String paramSearchString) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT p.*, GROUP_CONCAT(DISTINCT pp.pilot_name SEPARATOR ', ') as linked_pilots, 				GROUP_CONCAT(DISTINCT CONCAT(i.info_uniq, '|||', i.info_link, '|||', CAST(IF(ISNULL(ip.level), IF(ISNULL(ui.level), i.def_level, ui.level), ip.level) AS UNSIGNED INTEGER)) SEPARATOR '///') as levels, 				SUM(DISTINCT rs.relation) as source_relation, SUM(DISTINCT rt.relation) as target_relation 				FROM (info i, pilots pj) 				LEFT JOIN pilots p ON pj.parent_pilot_id = p.pilot_id OR ISNULL(pj.parent_pilot_id) AND p.pilot_id = pj.pilot_id 				LEFT JOIN pilots pp ON pp.parent_pilot_id = p.pilot_id 				LEFT JOIN pilots_info ip ON ip.pilot_id = p.pilot_id AND ip.info_id = i.info_id 				LEFT JOIN users_info ui ON ui.user_id = p.user_id AND ui.info_id = i.info_id 				LEFT JOIN pilots jp ON jp.user_id = ? 				LEFT JOIN pilot_relations rs ON jp.pilot_id = rs.source_pilot_id AND (p.pilot_id = rs.target_pilot_id OR pp.pilot_id = rs.target_pilot_id) 				LEFT JOIN pilot_relations rt ON jp.pilot_id = rt.target_pilot_id AND (p.pilot_id = rt.source_pilot_id OR pp.pilot_id = rt.source_pilot_id) 				WHERE pj.is_ignored = 0 				AND pj.pilot_name LIKE ? 				GROUP BY p.pilot_id 				ORDER BY p.pilot_name 				" + limit + " 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getSearchPilots", query ,  paramUserId,  paramSearchString);
		List<DBSearchPilotsBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBSearchPilotsBean>();
				
			for (Map<String, Object> res : result) {
				DBSearchPilotsBean bean = dataMapper.mapFromRow(res, DBSearchPilotsBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
	public List<DBPilotsLinkedInfoBean> getPilotsLinkedInfo(long paramUserId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT p.*, COUNT(pl.pilot_id) as name_other 				FROM pilots p 				LEFT JOIN pilots pl ON LOWER(p.pilot_name) = LOWER(pl.pilot_name) AND p.pilot_id != pl.pilot_id AND (pl.is_ignored = 0 OR ISNULL(pl.parent_pilot_id)) 				WHERE p.user_id = ? 				GROUP BY p.pilot_id 				ORDER BY p.is_ignored, p.pilot_name 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getPilotsLinkedInfo", query ,  paramUserId);
		List<DBPilotsLinkedInfoBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBPilotsLinkedInfoBean>();
				
			for (Map<String, Object> res : result) {
				DBPilotsLinkedInfoBean bean = dataMapper.mapFromRow(res, DBPilotsLinkedInfoBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
	public DBCheckPilotNameBean getCheckPilotName(String paramPilotName) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT COUNT(p.pilot_id) as name_other 				FROM pilots p 				WHERE LOWER(p.pilot_name) = LOWER(?) 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getCheckPilotName", query ,  paramPilotName);
		DBCheckPilotNameBean ret = null;
		if (result != null) {
					ret = new DBCheckPilotNameBean();
				
					ret = dataMapper.mapFromRow(result.get(0), DBCheckPilotNameBean.class);
					
		}
			
		return ret;
	}
	
}