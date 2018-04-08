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
public class DBEventsAccess extends Access {
	protected DBConnection getConnection() {
		setNames();
		return getCon();
	}
	
	private DataMapper dataMapper = new GeneralDataMapper(new GeneralCastType()); 
	
	protected void setNames() {
		con_name = "edgo";
		tablename = "events";
	}
	
	
	public int insert(DBEventsBean bean) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		int res = _insert(bean);
		bean.setAutoincrementField(res);
		return res;
	}

	
	public List<DBEventsBean> getTableRecords() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		return getTableRecords(null);
	}
	public List<DBEventsBean> getTableRecords(SqlInjectorInterface injector) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<Map<String, Object>> result = _getTableRecords(injector);
		
		List<DBEventsBean> ret = null;
		if (result != null) {
			ret = new ArrayList<DBEventsBean>();
			for (Map<String, Object> res : result) {
				DBEventsBean bean = dataMapper.mapFromRow(res, DBEventsBean.class);
				
				ret.add(bean);
			}
		}
		return ret;
	}
	
	
	public DBEventsBean getByPrimaryKey(java.math.BigInteger paramEventId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBEventsBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1  AND  event_id= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByPrimaryKey", sql ,  paramEventId);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBEventsBean.class);
			
		}
		return ret;
	}
	
	public int updateByPrimaryKey(DBEventsBean bean, java.math.BigInteger paramEventId) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		 Map<String, Object> map = dataMapper.mapToRow(bean);
		 Map<String, Object> keys = new HashMap<String, Object>();
		 
		 keys.put("event_id",  paramEventId);
		 
		return getConnection().updateRow("events", map, keys);
	}
	
	public int deleteByPrimaryKey(java.math.BigInteger paramEventId) throws SQLException {
		setNames();
		String sql = "DELETE FROM " + tablename + " WHERE  1=1  AND  event_id= ?  ";
		return getConnection().query(sql, paramEventId);
	}
	
	public DBEventsBean getUnlockEvent() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT e.*, MD5(e.event_json) as json_md5 				FROM events e 				WHERE e.is_locked = 0 				ORDER BY event_id ASC 				LIMIT 1 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getUnlockEvent", query );
		DBEventsBean ret = null;
		if (result != null) {
					ret = new DBEventsBean();
				
					ret = dataMapper.mapFromRow(result.get(0), DBEventsBean.class);
					
		}
			
		return ret;
	}
	
	public DBQueriedEventsBean getQueriedEvents(long paramUserId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT COUNT(DISTINCT e.event_id) as quered_events 				FROM events e 				WHERE e.user_id = ?  				AND e.is_locked < 3 				LIMIT 1 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getQueriedEvents", query ,  paramUserId);
		DBQueriedEventsBean ret = null;
		if (result != null) {
					ret = new DBQueriedEventsBean();
				
					ret = dataMapper.mapFromRow(result.get(0), DBQueriedEventsBean.class);
					
		}
			
		return ret;
	}
	
	public DBEventsBean getUnlockEventForUserId(long paramUserId, Integer paramState) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT e.*, MD5(e.event_json) as json_md5 				FROM events e 				WHERE e.user_id = ?  				AND e.is_locked = ? 				ORDER BY event_id ASC 				LIMIT 1 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getUnlockEventForUserId", query ,  paramUserId,  paramState);
		DBEventsBean ret = null;
		if (result != null) {
					ret = new DBEventsBean();
				
					ret = dataMapper.mapFromRow(result.get(0), DBEventsBean.class);
					
		}
			
		return ret;
	}
	
	public DBCheckEventBean getCheckEvent(long paramUserId, String paramJsonChek) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT COUNT(e.event_id) as events_count 				FROM events e 				WHERE e.user_id = ?  				AND e.check_hash = ? 				LIMIT 1 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getCheckEvent", query ,  paramUserId,  paramJsonChek);
		DBCheckEventBean ret = null;
		if (result != null) {
					ret = new DBCheckEventBean();
				
					ret = dataMapper.mapFromRow(result.get(0), DBCheckEventBean.class);
					
		}
			
		return ret;
	}
	
	public int updateClearEvents() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				UPDATE events SET is_locked = 0 WHERE event_name NOT IN ('Cargo', 'Loadout', 'Materials') 			";
		}

		
		int ret = getConnection().query(query);
			
		return ret;
	}
	
	public List<DBEventUsersBean> getEventUsers() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT e.user_id 				FROM events e 				WHERE e.is_locked = 0 				GROUP BY e.user_id  			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getEventUsers", query );
		List<DBEventUsersBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBEventUsersBean>();
				
			for (Map<String, Object> res : result) {
				DBEventUsersBean bean = dataMapper.mapFromRow(res, DBEventUsersBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
}