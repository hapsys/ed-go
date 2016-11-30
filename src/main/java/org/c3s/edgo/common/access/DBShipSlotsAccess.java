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
public class DBShipSlotsAccess extends Access {
	protected DBConnection getConnection() {
		setNames();
		return getCon();
	}
	
	private DataMapper dataMapper = new GeneralDataMapper(new GeneralCastType()); 
	
	protected void setNames() {
		con_name = "edgo";
		tablename = "ship_slots";
	}
	
	
	public int insert(DBShipSlotsBean bean) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		int res = _insert(bean);
		bean.setAutoincrementField(res);
		return res;
	}

	
	public List<DBShipSlotsBean> getTableRecords() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		return getTableRecords(null);
	}
	public List<DBShipSlotsBean> getTableRecords(SqlInjectorInterface injector) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<Map<String, Object>> result = _getTableRecords(injector);
		
		List<DBShipSlotsBean> ret = null;
		if (result != null) {
			ret = new ArrayList<DBShipSlotsBean>();
			for (Map<String, Object> res : result) {
				DBShipSlotsBean bean = dataMapper.mapFromRow(res, DBShipSlotsBean.class);
				
				ret.add(bean);
			}
		}
		return ret;
	}
	
	
	public DBShipSlotsBean getByPrimaryKey(java.lang.Long paramShipId, java.lang.Long paramSlotId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBShipSlotsBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1 AND  ship_id= ? AND  slot_id= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByPrimaryKey", sql ,  paramShipId,  paramSlotId);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBShipSlotsBean.class);
			
		}
		return ret;
	}
	
	public int updateByPrimaryKey(DBShipSlotsBean bean, java.lang.Long paramShipId, java.lang.Long paramSlotId) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		 Map<String, Object> map = dataMapper.mapToRow(bean);
		 Map<String, Object> keys = new HashMap<String, Object>();
		 
		 keys.put("ship_id",  paramShipId);
		 
		 keys.put("slot_id",  paramSlotId);
		 
		return getConnection().updateRow("ship_slots", map, keys);
	}
	
	public int deleteByPrimaryKey(java.lang.Long paramShipId, java.lang.Long paramSlotId) throws SQLException {
		setNames();
		String sql = "DELETE FROM " + tablename + " WHERE  1=1 AND  ship_id= ? AND  slot_id= ?  ";
		return getConnection().query(sql, paramShipId, paramSlotId);
	}
	
}