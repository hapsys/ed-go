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
public class DBPilotShipsAccess extends Access {
	protected DBConnection getConnection() {
		setNames();
		return getCon();
	}
	
	private DataMapper dataMapper = new GeneralDataMapper(new EdGoCast()); 
	
	protected void setNames() {
		con_name = "edgo";
		tablename = "pilot_ships";
	}
	
	
	public int insert(DBPilotShipsBean bean) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		int res = _insert(bean);
		bean.setAutoincrementField(res);
		return res;
	}

	
	public List<DBPilotShipsBean> getTableRecords() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		return getTableRecords(null);
	}
	public List<DBPilotShipsBean> getTableRecords(SqlInjectorInterface injector) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<Map<String, Object>> result = _getTableRecords(injector);
		
		List<DBPilotShipsBean> ret = null;
		if (result != null) {
			ret = new ArrayList<DBPilotShipsBean>();
			for (Map<String, Object> res : result) {
				DBPilotShipsBean bean = dataMapper.mapFromRow(res, DBPilotShipsBean.class);
				
				ret.add(bean);
			}
		}
		return ret;
	}
	
	
	public List<DBPilotShipsBean> getByPilotId(java.lang.Long paramPilotId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<DBPilotShipsBean> ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1  AND  pilot_id= ?  "+injector.getWhereQuery()+" ";
		if (injector.getOrderQuery().length() != 0) {
			sql += injector.getOrderQuery();
		} else { 
			
		}
		String limit = injector.getLimitQuery();
		if (limit.length() != 0) {
			sql += limit;
		} else {
			
		}
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByPilotId", sql ,  paramPilotId);
		if (result != null) {
			
			ret = new ArrayList<DBPilotShipsBean>();
			for (Map<String, Object> res : result) {
				DBPilotShipsBean bean = dataMapper.mapFromRow(res, DBPilotShipsBean.class);
				 
				ret.add(bean);
			}
				
		}
		return ret;
	}
	
	public DBPilotShipsBean getCurrentByPilotId(java.lang.Long paramPilotId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBPilotShipsBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1  AND  pilot_id= ?  AND  is_main=1 "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getCurrentByPilotId", sql ,  paramPilotId);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBPilotShipsBean.class);
			
		}
		return ret;
	}
	
	public DBPilotShipsBean getByPrimaryKey(java.lang.Long paramPilotShipId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBPilotShipsBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1  AND  pilot_ship_id= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByPrimaryKey", sql ,  paramPilotShipId);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBPilotShipsBean.class);
			
		}
		return ret;
	}
	
	public DBPilotShipsBean getByPilotIdAndLinkShipId(java.lang.Long paramPilotId, java.lang.Long paramLinkShipId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBPilotShipsBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1  AND  pilot_id= ?  AND  link_ship_id= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByPilotIdAndLinkShipId", sql ,  paramPilotId,  paramLinkShipId);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBPilotShipsBean.class);
			
		}
		return ret;
	}
	
	public int updateByPrimaryKey(DBPilotShipsBean bean, java.lang.Long paramPilotShipId) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		 Map<String, Object> map = dataMapper.mapToRow(bean);
		 Map<String, Object> keys = new HashMap<String, Object>();
		 
		 keys.put("pilot_ship_id",  paramPilotShipId);
		 
		return getConnection().updateRow("pilot_ships", map, keys);
	}
	
	public int deleteByPrimaryKey(java.lang.Long paramPilotShipId) throws SQLException {
		setNames();
		String sql = "DELETE FROM " + tablename + " WHERE  1=1  AND  pilot_ship_id= ?  ";
		return getConnection().query(sql, paramPilotShipId);
	}
	
	public List<DBPilotShipsListBean> getPilotShipsList(long paramPilotId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT ps.*, sh.*, s.name as system_name, st.name as station_name, s.x, s.y, s.z 				FROM ships sh, pilot_ships ps 				LEFT JOIN systems s ON ps.system_id = s.system_id 				LEFT JOIN stations st ON ps.station_id = st.station_id 				WHERE ps.pilot_id = ? 				AND ps.ship_id = sh.ship_id 				AND sh.is_special = 0 				ORDER BY ps.is_main DESC, sh.ship_name 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getPilotShipsList", query ,  paramPilotId);
		List<DBPilotShipsListBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBPilotShipsListBean>();
				
			for (Map<String, Object> res : result) {
				DBPilotShipsListBean bean = dataMapper.mapFromRow(res, DBPilotShipsListBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
	public DBPilotShipsBean getByPilotIdAndLinkShipIdWithLocation(long paramPilotId, long paramLinkShiptId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT ps.*, ss.name as system_name, st.name as station_name 				FROM pilot_ships ps 				LEFT JOIN systems ss ON ss.system_id = ps.system_id 				LEFT JOIN stations st ON st.station_id = ps.station_id 				WHERE ps.pilot_id = ? 				AND ps.link_ship_id = ? 				LIMIT 1  			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByPilotIdAndLinkShipIdWithLocation", query ,  paramPilotId,  paramLinkShiptId);
		DBPilotShipsBean ret = null;
		if (result != null) {
					ret = new DBPilotShipsBean();
				
					ret = dataMapper.mapFromRow(result.get(0), DBPilotShipsBean.class);
					
		}
			
		return ret;
	}
	
	public int deleteDeletedByPilotId(long paramPilotId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				DELETE ps 				FROM pilot_ships ps 				WHERE ps.pilot_id = ? 				AND ps.can_deleted = 1 			";
		}

		
		int ret = getConnection().query(query,  paramPilotId);
			
		return ret;
	}
	
	public int updatePilotShipLocation(java.math.BigInteger paramSystemId, Long paramStationId, Long paramPilotId, Long paramLinkShipId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				UPDATE pilot_ships SET system_id = ?, station_id = ? WHERE pilot_id = ? AND link_ship_id = ? LIMIT 1 			";
		}

		
		int ret = getConnection().query(query,  paramSystemId,  paramStationId,  paramPilotId,  paramLinkShipId);
			
		return ret;
	}
	
	public int updateSetDeletedByPilotId(long paramPilotId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				UPDATE pilot_ships SET can_deleted = 1 WHERE pilot_id = ?  			";
		}

		
		int ret = getConnection().query(query,  paramPilotId);
			
		return ret;
	}
	
}