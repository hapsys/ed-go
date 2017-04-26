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
public class DBBountyTypesAccess extends Access {
	protected DBConnection getConnection() {
		setNames();
		return getCon();
	}
	
	private DataMapper dataMapper = new GeneralDataMapper(new GeneralCastType()); 
	
	protected void setNames() {
		con_name = "edgo";
		tablename = "bounty_types";
	}
	
	
	public int insert(DBBountyTypesBean bean) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		int res = _insert(bean);
		bean.setAutoincrementField(res);
		return res;
	}

	
	public List<DBBountyTypesBean> getTableRecords() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		return getTableRecords(null);
	}
	public List<DBBountyTypesBean> getTableRecords(SqlInjectorInterface injector) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<Map<String, Object>> result = _getTableRecords(injector);
		
		List<DBBountyTypesBean> ret = null;
		if (result != null) {
			ret = new ArrayList<DBBountyTypesBean>();
			for (Map<String, Object> res : result) {
				DBBountyTypesBean bean = dataMapper.mapFromRow(res, DBBountyTypesBean.class);
				
				ret.add(bean);
			}
		}
		return ret;
	}
	
	
	public DBBountyTypesBean getByUniq(java.lang.String paramBountyTypeUniq)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBBountyTypesBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1 AND  bounty_type_uniq= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByUniq", sql ,  paramBountyTypeUniq);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBBountyTypesBean.class);
			
		}
		return ret;
	}
	
	public DBBountyTypesBean getByPrimaryKey(java.lang.Long paramBountyTypeId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBBountyTypesBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1 AND  bounty_type_id= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByPrimaryKey", sql ,  paramBountyTypeId);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBBountyTypesBean.class);
			
		}
		return ret;
	}
	
	public int updateByPrimaryKey(DBBountyTypesBean bean, java.lang.Long paramBountyTypeId) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		 Map<String, Object> map = dataMapper.mapToRow(bean);
		 Map<String, Object> keys = new HashMap<String, Object>();
		 
		 keys.put("bounty_type_id",  paramBountyTypeId);
		 
		return getConnection().updateRow("bounty_types", map, keys);
	}
	
	public int deleteByPrimaryKey(java.lang.Long paramBountyTypeId) throws SQLException {
		setNames();
		String sql = "DELETE FROM " + tablename + " WHERE  1=1 AND  bounty_type_id= ?  ";
		return getConnection().query(sql, paramBountyTypeId);
	}
	
}