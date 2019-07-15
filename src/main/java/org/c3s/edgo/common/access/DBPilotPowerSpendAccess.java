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
public class DBPilotPowerSpendAccess extends Access {
	protected DBConnection getConnection() {
		setNames();
		return getCon();
	}
	
	private DataMapper dataMapper = new GeneralDataMapper(new EdGoCast()); 
	
	protected void setNames() {
		con_name = "edgo";
		tablename = "pilot_power_spend";
	}
	
	
	public int insert(DBPilotPowerSpendBean bean) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		int res = _insert(bean);
		bean.setAutoincrementField(res);
		return res;
	}

	
	public List<DBPilotPowerSpendBean> getTableRecords() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		return getTableRecords(null);
	}
	public List<DBPilotPowerSpendBean> getTableRecords(SqlInjectorInterface injector) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<Map<String, Object>> result = _getTableRecords(injector);
		
		List<DBPilotPowerSpendBean> ret = null;
		if (result != null) {
			ret = new ArrayList<DBPilotPowerSpendBean>();
			for (Map<String, Object> res : result) {
				DBPilotPowerSpendBean bean = dataMapper.mapFromRow(res, DBPilotPowerSpendBean.class);
				
				ret.add(bean);
			}
		}
		return ret;
	}
	
	
	public DBPilotPowerSpendBean getByPilotIdAndWeek(java.lang.Long paramPilotId, java.sql.Timestamp paramStartWeek)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBPilotPowerSpendBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1  AND  pilot_id= ?  AND  start_week= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByPilotIdAndWeek", sql ,  paramPilotId,  paramStartWeek);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBPilotPowerSpendBean.class);
			
		}
		return ret;
	}
	
	public List<DBPilotPowerSpendBean> getHistoryByPilotId(java.lang.Long paramPilotId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<DBPilotPowerSpendBean> ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1  AND  pilot_id= ?  "+injector.getWhereQuery()+" ";
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
			
			ret = new ArrayList<DBPilotPowerSpendBean>();
			for (Map<String, Object> res : result) {
				DBPilotPowerSpendBean bean = dataMapper.mapFromRow(res, DBPilotPowerSpendBean.class);
				 
				ret.add(bean);
			}
				
		}
		return ret;
	}
	
	public DBPilotPowerSpendBean getByPrimaryKey(java.lang.Long paramPilotPowerSpendId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBPilotPowerSpendBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1  AND  pilot_power_spend_id= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByPrimaryKey", sql ,  paramPilotPowerSpendId);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBPilotPowerSpendBean.class);
			
		}
		return ret;
	}
	
	public int updateByPrimaryKey(DBPilotPowerSpendBean bean, java.lang.Long paramPilotPowerSpendId) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		 Map<String, Object> map = dataMapper.mapToRow(bean);
		 Map<String, Object> keys = new HashMap<String, Object>();
		 
		 keys.put("pilot_power_spend_id",  paramPilotPowerSpendId);
		 
		return getConnection().updateRow("pilot_power_spend", map, keys);
	}
	
	public int deleteByPrimaryKey(java.lang.Long paramPilotPowerSpendId) throws SQLException {
		setNames();
		String sql = "DELETE FROM " + tablename + " WHERE  1=1  AND  pilot_power_spend_id= ?  ";
		return getConnection().query(sql, paramPilotPowerSpendId);
	}
	
	public List<DBPilotPowerSpendBean> getListForPilots(org.c3s.edgo.common.intruders.InInjector paramIntruder) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT t.*, SUM(t.quantity) as quantity_summ 				FROM pilot_power_spend t 				WHERE 1=1 				" + where + " 				GROUP BY t.start_week  				ORDER BY start_week DESC 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getListForPilots", query );
		List<DBPilotPowerSpendBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBPilotPowerSpendBean>();
				
			for (Map<String, Object> res : result) {
				DBPilotPowerSpendBean bean = dataMapper.mapFromRow(res, DBPilotPowerSpendBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
}