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
public class DBFactionsAccess extends Access {
	protected DBConnection getConnection() {
		setNames();
		return getCon();
	}
	
	private DataMapper dataMapper = new GeneralDataMapper(new EdGoCast()); 
	
	protected void setNames() {
		con_name = "edgo";
		tablename = "factions";
	}
	
	
	public int insert(DBFactionsBean bean) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		int res = _insert(bean);
		bean.setAutoincrementField(res);
		return res;
	}

	
	public List<DBFactionsBean> getTableRecords() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		return getTableRecords(null);
	}
	public List<DBFactionsBean> getTableRecords(SqlInjectorInterface injector) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<Map<String, Object>> result = _getTableRecords(injector);
		
		List<DBFactionsBean> ret = null;
		if (result != null) {
			ret = new ArrayList<DBFactionsBean>();
			for (Map<String, Object> res : result) {
				DBFactionsBean bean = dataMapper.mapFromRow(res, DBFactionsBean.class);
				
				ret.add(bean);
			}
		}
		return ret;
	}
	
	
	public List<DBFactionsBean> getFactionInformation() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		return getFactionInformation(null);
	}
	
	public List<DBFactionsBean> getFactionInformation(org.c3s.edgo.common.intruders.InInjector paramIntruder)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<DBFactionsBean> ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		if (paramIntruder != null) {
			injector = paramIntruder;
		}
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1  "+injector.getWhereQuery()+" ";
		if (injector.getOrderQuery().length() != 0) {
			sql += injector.getOrderQuery();
		} else { 
			
		}
		String limit = injector.getLimitQuery();
		if (limit.length() != 0) {
			sql += limit;
		} else {
			
		}
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getFactionInformation", sql );
		if (result != null) {
			
			ret = new ArrayList<DBFactionsBean>();
			for (Map<String, Object> res : result) {
				DBFactionsBean bean = dataMapper.mapFromRow(res, DBFactionsBean.class);
				 
				ret.add(bean);
			}
				
		}
		return ret;
	}
	
	public DBFactionsBean getByUniq(java.lang.String paramUniq)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBFactionsBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1  AND  uniq= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByUniq", sql ,  paramUniq);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBFactionsBean.class);
			
		}
		return ret;
	}
	
	public DBFactionsBean getByPrimaryKey(java.lang.Long paramFactionId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBFactionsBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1  AND  faction_id= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByPrimaryKey", sql ,  paramFactionId);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBFactionsBean.class);
			
		}
		return ret;
	}
	
	public DBFactionDateMinMaxBean getFactionDateMinMax(long paramFactionId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT fc.faction_id, UNIX_TIMESTAMP(MIN(fc.create_date)) as min_date, UNIX_TIMESTAMP(MAX(fc.create_date)) as max_date  				FROM system_factions_history fc 				WHERE fc.faction_id = ?  				GROUP BY fc.faction_id 				LIMIT 1 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getFactionDateMinMax", query ,  paramFactionId);
		DBFactionDateMinMaxBean ret = null;
		if (result != null) {
					ret = new DBFactionDateMinMaxBean();
				
					ret = dataMapper.mapFromRow(result.get(0), DBFactionDateMinMaxBean.class);
					
		}
			
		return ret;
	}
	
	public List<DBFactionsSearchBean> getFactionsSearch(String paramsearch) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT f.faction_id, f.name, UNIX_TIMESTAMP(MIN(fc.create_date)) as min_date, UNIX_TIMESTAMP(MAX(fc.create_date)) as max_date  				FROM factions f, system_factions_history fc 				WHERE f.faction_id=fc.faction_id  				AND f.name LIKE ? 				AND f.faction_id != 75458 				GROUP BY f.faction_id 				ORDER BY f.name 				LIMIT 20 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getFactionsSearch", query ,  paramsearch);
		List<DBFactionsSearchBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBFactionsSearchBean>();
				
			for (Map<String, Object> res : result) {
				DBFactionsSearchBean bean = dataMapper.mapFromRow(res, DBFactionsSearchBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
}