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
public class DBPilotKillMeritsAccess extends Access {
	protected DBConnection getConnection() {
		setNames();
		return getCon();
	}
	
	private DataMapper dataMapper = new GeneralDataMapper(new GeneralCastType()); 
	
	protected void setNames() {
		con_name = "edgo";
		tablename = "pilot_kill_merits";
	}
	
	
	public int insert(DBPilotKillMeritsBean bean) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		int res = _insert(bean);
		bean.setAutoincrementField(res);
		return res;
	}

	
	public List<DBPilotKillMeritsBean> getTableRecords() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		return getTableRecords(null);
	}
	public List<DBPilotKillMeritsBean> getTableRecords(SqlInjectorInterface injector) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<Map<String, Object>> result = _getTableRecords(injector);
		
		List<DBPilotKillMeritsBean> ret = null;
		if (result != null) {
			ret = new ArrayList<DBPilotKillMeritsBean>();
			for (Map<String, Object> res : result) {
				DBPilotKillMeritsBean bean = dataMapper.mapFromRow(res, DBPilotKillMeritsBean.class);
				
				ret.add(bean);
			}
		}
		return ret;
	}
	
	
	public DBPilotKillMeritsBean getNotConfirmedByPilotIdAndSystemIdAndWeek(java.lang.Long paramPilotId, java.math.BigInteger paramSystemId, java.sql.Timestamp paramStartWeek)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBPilotKillMeritsBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1 AND  pilot_id= ? AND  system_id= ? AND  start_week= ? AND  is_confirmed=0 "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getNotConfirmedByPilotIdAndSystemIdAndWeek", sql ,  paramPilotId,  paramSystemId,  paramStartWeek);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBPilotKillMeritsBean.class);
			
		}
		return ret;
	}
	
	public DBPilotKillMeritsBean getConfirmedByPilotIdAndSystemIdAndWeek(java.lang.Long paramPilotId, java.math.BigInteger paramSystemId, java.sql.Timestamp paramStartWeek)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBPilotKillMeritsBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1 AND  pilot_id= ? AND  system_id= ? AND  start_week= ? AND  is_confirmed=1 "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getConfirmedByPilotIdAndSystemIdAndWeek", sql ,  paramPilotId,  paramSystemId,  paramStartWeek);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBPilotKillMeritsBean.class);
			
		}
		return ret;
	}
	
	public List<DBPilotKillMeritsBean> getHistoryByPilotId(java.lang.Long paramPilotId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<DBPilotKillMeritsBean> ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1 AND  pilot_id= ? AND  is_confirmed=1 "+injector.getWhereQuery()+" ";
		if (injector.getOrderQuery().length() != 0) {
			sql += injector.getOrderQuery();
		} else { 
			sql += "ORDER BY start_week DESC";
			
		}
		String limit = injector.getLimitQuery();
		if (limit.length() != 0) {
			sql += limit;
		} else {
			
		}
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getHistoryByPilotId", sql ,  paramPilotId);
		if (result != null) {
			
			ret = new ArrayList<DBPilotKillMeritsBean>();
			for (Map<String, Object> res : result) {
				DBPilotKillMeritsBean bean = dataMapper.mapFromRow(res, DBPilotKillMeritsBean.class);
				 
				ret.add(bean);
			}
				
		}
		return ret;
	}
	
	public DBPilotKillMeritsBean getByPrimaryKey(java.lang.Long paramPilotKillMeritsId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBPilotKillMeritsBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1 AND  pilot_kill_merits_id= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByPrimaryKey", sql ,  paramPilotKillMeritsId);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBPilotKillMeritsBean.class);
			
		}
		return ret;
	}
	
	public int updateByPrimaryKey(DBPilotKillMeritsBean bean, java.lang.Long paramPilotKillMeritsId) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		 Map<String, Object> map = dataMapper.mapToRow(bean);
		 Map<String, Object> keys = new HashMap<String, Object>();
		 
		 keys.put("pilot_kill_merits_id",  paramPilotKillMeritsId);
		 
		return getConnection().updateRow("pilot_kill_merits", map, keys);
	}
	
	public int deleteByPrimaryKey(java.lang.Long paramPilotKillMeritsId) throws SQLException {
		setNames();
		String sql = "DELETE FROM " + tablename + " WHERE  1=1 AND  pilot_kill_merits_id= ?  ";
		return getConnection().query(sql, paramPilotKillMeritsId);
	}
	
	public List<DBPilotKillMeritsBean> getListForPilots(org.c3s.edgo.common.intruders.InInjector paramIntruder) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT t.*, s.name as system_name 				FROM pilot_kill_merits t, systems s 				WHERE 1=1 				" + where + " 				AND t.is_confirmed = 1 				AND t.system_id = s.system_id 				ORDER BY start_week DESC 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getListForPilots", query );
		List<DBPilotKillMeritsBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBPilotKillMeritsBean>();
				
			for (Map<String, Object> res : result) {
				DBPilotKillMeritsBean bean = dataMapper.mapFromRow(res, DBPilotKillMeritsBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
	public int updateNulledByPilotIdAndTime(Long paramPilotPowerId, long paramPilotId, java.sql.Timestamp paramTimestamp) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				UPDATE pilot_kill_merits p  				SET p.pilot_power_id = ?  				WHERE p.pilot_id = ? 				AND p.start_week = ? 				LIMIT 2  			";
		}

		
		int ret = getConnection().query(query,  paramPilotPowerId,  paramPilotId,  paramTimestamp);
			
		return ret;
	}
	
}