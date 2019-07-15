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
public class DBSystemsAccess extends Access {
	protected DBConnection getConnection() {
		setNames();
		return getCon();
	}
	
	private DataMapper dataMapper = new GeneralDataMapper(new EdGoCast()); 
	
	protected void setNames() {
		con_name = "edgo";
		tablename = "systems";
	}
	
	
	public int insert(DBSystemsBean bean) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		int res = _insert(bean);
		bean.setAutoincrementField(res);
		return res;
	}

	
	public List<DBSystemsBean> getTableRecords() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		return getTableRecords(null);
	}
	public List<DBSystemsBean> getTableRecords(SqlInjectorInterface injector) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<Map<String, Object>> result = _getTableRecords(injector);
		
		List<DBSystemsBean> ret = null;
		if (result != null) {
			ret = new ArrayList<DBSystemsBean>();
			for (Map<String, Object> res : result) {
				DBSystemsBean bean = dataMapper.mapFromRow(res, DBSystemsBean.class);
				
				ret.add(bean);
			}
		}
		return ret;
	}
	
	
	public DBSystemsBean getByUniq(java.lang.String paramNameUniq)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBSystemsBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1  AND  name_uniq= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByUniq", sql ,  paramNameUniq);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBSystemsBean.class);
			
		}
		return ret;
	}
	
	public DBSystemsBean getByPrimaryKey(java.math.BigInteger paramSystemId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBSystemsBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1  AND  system_id= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByPrimaryKey", sql ,  paramSystemId);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBSystemsBean.class);
			
		}
		return ret;
	}
	
	public int updateSystemAddress(java.math.BigInteger paramSystemAdress, java.math.BigInteger paramSystemId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				UPDATE systems SET system_address = ? WHERE system_id = ? LIMIT 1 			";
		}

		
		int ret = getConnection().query(query,  paramSystemAdress,  paramSystemId);
			
		return ret;
	}
	
	public List<DBSystemsInBoxBean> getSystemsInBox(float paramx1, float paramx2, float paramy1, float paramy2, float paramz1, float paramz2) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT s.* 				FROM systems s 				WHERE 1=1 				AND s.x BETWEEN ? AND ? 				AND s.y BETWEEN ? AND ? 				AND s.z BETWEEN ? AND ?				 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getSystemsInBox", query ,  paramx1,  paramx2,  paramy1,  paramy2,  paramz1,  paramz2);
		List<DBSystemsInBoxBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBSystemsInBoxBean>();
				
			for (Map<String, Object> res : result) {
				DBSystemsInBoxBean bean = dataMapper.mapFromRow(res, DBSystemsInBoxBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
	public List<DBSystemsSearchBean> getSystemsSearch(String paramsearch) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT s.system_id, IF(ISNULL(s.name_stations), s.name, s.name_stations) as name 				FROM systems s 				WHERE s.name LIKE ? 				GROUP BY s.system_id 				ORDER BY s.name 				LIMIT 20 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getSystemsSearch", query ,  paramsearch);
		List<DBSystemsSearchBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBSystemsSearchBean>();
				
			for (Map<String, Object> res : result) {
				DBSystemsSearchBean bean = dataMapper.mapFromRow(res, DBSystemsSearchBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
}