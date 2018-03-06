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
public class DBCommodityDeliverAccess extends Access {
	protected DBConnection getConnection() {
		setNames();
		return getCon();
	}
	
	private DataMapper dataMapper = new GeneralDataMapper(new GeneralCastType()); 
	
	protected void setNames() {
		con_name = "edgo";
		tablename = "commodity_deliver";
	}
	
	
	public int insert(DBCommodityDeliverBean bean) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		int res = _insert(bean);
		bean.setAutoincrementField(res);
		return res;
	}

	
	public List<DBCommodityDeliverBean> getTableRecords() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		return getTableRecords(null);
	}
	public List<DBCommodityDeliverBean> getTableRecords(SqlInjectorInterface injector) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<Map<String, Object>> result = _getTableRecords(injector);
		
		List<DBCommodityDeliverBean> ret = null;
		if (result != null) {
			ret = new ArrayList<DBCommodityDeliverBean>();
			for (Map<String, Object> res : result) {
				DBCommodityDeliverBean bean = dataMapper.mapFromRow(res, DBCommodityDeliverBean.class);
				
				ret.add(bean);
			}
		}
		return ret;
	}
	
	
	public DBCommodityDeliverBean getByPrimaryKey(java.math.BigInteger paramMissionId, java.lang.Long paramCommodityId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBCommodityDeliverBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1  AND  mission_id= ?  AND  commodity_id= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByPrimaryKey", sql ,  paramMissionId,  paramCommodityId);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBCommodityDeliverBean.class);
			
		}
		return ret;
	}
	
	public int updateByPrimaryKey(DBCommodityDeliverBean bean, java.math.BigInteger paramMissionId, java.lang.Long paramCommodityId) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		 Map<String, Object> map = dataMapper.mapToRow(bean);
		 Map<String, Object> keys = new HashMap<String, Object>();
		 
		 keys.put("mission_id",  paramMissionId);
		 
		 keys.put("commodity_id",  paramCommodityId);
		 
		return getConnection().updateRow("commodity_deliver", map, keys);
	}
	
	public int deleteByPrimaryKey(java.math.BigInteger paramMissionId, java.lang.Long paramCommodityId) throws SQLException {
		setNames();
		String sql = "DELETE FROM " + tablename + " WHERE  1=1  AND  mission_id= ?  AND  commodity_id= ?  ";
		return getConnection().query(sql, paramMissionId, paramCommodityId);
	}
	
}