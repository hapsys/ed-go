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
public class DBLocationHistoryAccess extends Access {
	protected DBConnection getConnection() {
		setNames();
		return getCon();
	}
	
	private DataMapper dataMapper = new GeneralDataMapper(new GeneralCastType()); 
	
	protected void setNames() {
		con_name = "edgo";
		tablename = "location_history";
	}
	
	
	public int insert(DBLocationHistoryBean bean) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		int res = _insert(bean);
		bean.setAutoincrementField(res);
		return res;
	}

	
	public List<DBLocationHistoryBean> getTableRecords() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		return getTableRecords(null);
	}
	public List<DBLocationHistoryBean> getTableRecords(SqlInjectorInterface injector) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<Map<String, Object>> result = _getTableRecords(injector);
		
		List<DBLocationHistoryBean> ret = null;
		if (result != null) {
			ret = new ArrayList<DBLocationHistoryBean>();
			for (Map<String, Object> res : result) {
				DBLocationHistoryBean bean = dataMapper.mapFromRow(res, DBLocationHistoryBean.class);
				
				ret.add(bean);
			}
		}
		return ret;
	}
	
	
	public DBLocationHistoryBean getDirectLastLocation(java.lang.Long paramPilotId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBLocationHistoryBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1 AND  pilot_id= ?  "+injector.getWhereQuery()+" ";
		if (injector.getOrderQuery().length() != 0) {
			sql += injector.getOrderQuery();
		} else { 
			sql += "ORDER BY location_time DESC";
			
		}
		String limit = injector.getLimitQuery();
		if (limit.length() != 0) {
			sql += limit;
		} else {
			sql += " LIMIT 1";
		}
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getDirectLastLocation", sql ,  paramPilotId);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBLocationHistoryBean.class);
			
		}
		return ret;
	}
	
	public DBLocationHistoryBean getLastLocation(java.lang.Long paramPilotId, java.sql.Timestamp paramLocationTime)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBLocationHistoryBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1 AND  pilot_id= ? AND  location_time<= ?  "+injector.getWhereQuery()+" ";
		if (injector.getOrderQuery().length() != 0) {
			sql += injector.getOrderQuery();
		} else { 
			sql += "ORDER BY location_time DESC";
			
		}
		String limit = injector.getLimitQuery();
		if (limit.length() != 0) {
			sql += limit;
		} else {
			sql += " LIMIT 1";
		}
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getLastLocation", sql ,  paramPilotId,  paramLocationTime);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBLocationHistoryBean.class);
			
		}
		return ret;
	}
	
	public DBLocationHistoryBean getByPrimaryKey(java.math.BigInteger paramLocationId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBLocationHistoryBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1 AND  location_id= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByPrimaryKey", sql ,  paramLocationId);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBLocationHistoryBean.class);
			
		}
		return ret;
	}
	
	public DBLastLocationForPilotBean getLastLocationForPilot(long paramPilotId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT l.*, DATE_FORMAT(l.location_time, '%Y-%m-%d %T') as `system_time`, sy.name as system_name, DATE_FORMAT(sh.station_time, '%Y-%m-%d %T') as `station_time`, st.name as station_name, b.body_name  				FROM location_history l 				LEFT JOIN systems sy ON l.system_id = sy.system_id 				LEFT JOIN station_history sh ON sh.location_id = l.location_id 				LEFT JOIN stations st ON sh.station_id = st.station_id 				LEFT JOIN bodies b ON sh.body_id = b.body_id 				WHERE l.pilot_id = ? 				ORDER BY l.location_time DESC, sh.station_time 				LIMIT 1  			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getLastLocationForPilot", query ,  paramPilotId);
		DBLastLocationForPilotBean ret = null;
		if (result != null) {
					ret = new DBLastLocationForPilotBean();
				
					ret = dataMapper.mapFromRow(result.get(0), DBLastLocationForPilotBean.class);
					
		}
			
		return ret;
	}
	
	public DBLocationsPathCountBean getLocationsPathCount(long paramPilotId, org.c3s.db.injectors.EmptySqlInjector paramIntruder) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT count(l.location_id) as count  				FROM location_history l 				WHERE l.pilot_id = ? 				" + where + " 				LIMIT 1 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getLocationsPathCount", query ,  paramPilotId);
		DBLocationsPathCountBean ret = null;
		if (result != null) {
					ret = new DBLocationsPathCountBean();
				
					ret = dataMapper.mapFromRow(result.get(0), DBLocationsPathCountBean.class);
					
		}
			
		return ret;
	}
	
	public DBMaxMinDateLocationHistoryForPilotBean getMaxMinDateLocationHistoryForPilot(org.c3s.db.injectors.EmptySqlInjector paramIntruder) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT p.pilot_id, DATE_FORMAT(MAX(DATE(l.location_time)), '%Y-%m-%d') as max_date, DATE_FORMAT(MIN(DATE(l.location_time)), '%Y-%m-%d') as min_date 				FROM pilots p 				LEFT JOIN location_history l ON l.pilot_id = p.pilot_id  				WHERE 1 = 1 				" + where + " 				GROUP BY p.pilot_id 				LIMIT 1  			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getMaxMinDateLocationHistoryForPilot", query );
		DBMaxMinDateLocationHistoryForPilotBean ret = null;
		if (result != null) {
					ret = new DBMaxMinDateLocationHistoryForPilotBean();
				
					ret = dataMapper.mapFromRow(result.get(0), DBMaxMinDateLocationHistoryForPilotBean.class);
					
		}
			
		return ret;
	}
	
	public List<DBLocationsPathBean> getLocationsPath(long paramPilotId, org.c3s.db.injectors.EmptySqlInjector paramIntruder) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT l.*, sy.name as system_name, sy.x, sy.y, sy.z, DATE_FORMAT(l.location_time, '%Y-%m-%d %T') as `timestamp`, 					CONCAT('[', FORMAT(sy.x, 2), ',', FORMAT(sy.y, 2), ',', FORMAT(sy.z, 2), ']') as position, FORMAT(SQRT(sy.x * sy.x + sy.y * sy.y + sy.z * sy.z), 2) as distance 					, sh.station_id, st.name as station_name, sh.body_id, b.body_name, b.eddb_body_id   				FROM location_history l 				LEFT JOIN systems sy ON l.system_id = sy.system_id 				LEFT JOIN station_history sh ON sh.location_id = l.location_id 				LEFT JOIN stations st ON sh.station_id = st.station_id 				LEFT JOIN bodies b ON sh.body_id = b.body_id 				WHERE 1 = 1 				" + where + " 				ORDER BY l.location_time DESC, sh.station_time DESC 				 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getLocationsPath", query ,  paramPilotId);
		List<DBLocationsPathBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBLocationsPathBean>();
				
			for (Map<String, Object> res : result) {
				DBLocationsPathBean bean = dataMapper.mapFromRow(res, DBLocationsPathBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
	public List<DBSystemPathBean> getSystemPath(long paramPilotId, org.c3s.db.injectors.EmptySqlInjector paramIntruder) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT l.*, sy.name as system_name, sy.x, sy.y, sy.z, DATE_FORMAT(l.location_time, '%Y-%m-%d %T') as `timestamp`, 					CONCAT('[', FORMAT(sy.x, 2), ',', FORMAT(sy.y, 2), ',', FORMAT(sy.z, 2), ']') as position, FORMAT(SQRT(sy.x * sy.x + sy.y * sy.y + sy.z * sy.z), 2) as distance 				FROM location_history l 				LEFT JOIN systems sy ON l.system_id = sy.system_id 				WHERE 1 = 1 				" + where + " 				ORDER BY l.location_time DESC 				 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getSystemPath", query ,  paramPilotId);
		List<DBSystemPathBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBSystemPathBean>();
				
			for (Map<String, Object> res : result) {
				DBSystemPathBean bean = dataMapper.mapFromRow(res, DBSystemPathBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
}