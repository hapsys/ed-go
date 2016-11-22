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
	
	
	public DBEventsBean getUnlockEvent()  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBEventsBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1 AND  is_locked=0 "+injector.getWhereQuery()+" ";
		if (injector.getOrderQuery().length() != 0) {
			sql += injector.getOrderQuery();
		} else { 
			sql += "ORDER BY event_id ASC";
			
		}
		sql += injector.getLimitQuery();
		List<Map<String, Object>> result = getConnection().fetchRows("getUnlockEvent", sql );
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBEventsBean.class);
			
		}
		return ret;
	}
	
	public DBEventsBean getByPrimaryKey(java.math.BigInteger paramEventId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBEventsBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1 AND  event_id= ?  "+injector.getWhereQuery()+" ";
		if (injector.getOrderQuery().length() != 0) {
			sql += injector.getOrderQuery();
		} else { 
			
		}
		sql += injector.getLimitQuery();
		List<Map<String, Object>> result = getConnection().fetchRows("getByPrimaryKey", sql ,  paramEventId);
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
		String sql = "DELETE FROM " + tablename + " WHERE  1=1 AND  event_id= ?  ";
		return getConnection().query(sql, paramEventId);
	}
	
}