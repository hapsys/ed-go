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
public class DBImagesAccess extends Access {
	protected DBConnection getConnection() {
		setNames();
		return getCon();
	}
	
	private DataMapper dataMapper = new GeneralDataMapper(new EdGoCast()); 
	
	protected void setNames() {
		con_name = "edgo";
		tablename = "images";
	}
	
	
	public int insert(DBImagesBean bean) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		int res = _insert(bean);
		bean.setAutoincrementField(res);
		return res;
	}

	
	public List<DBImagesBean> getTableRecords() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		return getTableRecords(null);
	}
	public List<DBImagesBean> getTableRecords(SqlInjectorInterface injector) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<Map<String, Object>> result = _getTableRecords(injector);
		
		List<DBImagesBean> ret = null;
		if (result != null) {
			ret = new ArrayList<DBImagesBean>();
			for (Map<String, Object> res : result) {
				DBImagesBean bean = dataMapper.mapFromRow(res, DBImagesBean.class);
				
				ret.add(bean);
			}
		}
		return ret;
	}
	
	
	public List<DBImagesBean> getActiveImages()  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<DBImagesBean> ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1  AND  is_active=1 "+injector.getWhereQuery()+" ";
		if (injector.getOrderQuery().length() != 0) {
			sql += injector.getOrderQuery();
		} else { 
			
		}
		String limit = injector.getLimitQuery();
		if (limit.length() != 0) {
			sql += limit;
		} else {
			
		}
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getActiveImages", sql );
		if (result != null) {
			
			ret = new ArrayList<DBImagesBean>();
			for (Map<String, Object> res : result) {
				DBImagesBean bean = dataMapper.mapFromRow(res, DBImagesBean.class);
				 
				ret.add(bean);
			}
				
		}
		return ret;
	}
	
	public DBImagesBean getByPrimaryKey(java.lang.Long paramImageId)  throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		DBImagesBean ret = null;
		SqlInjectorInterface injector = new EmptySqlInjector();
		
		String sql = "SELECT t.* "+injector.getRecordQuery()+" FROM " + tablename + " as t "+injector.getFromQuery()+" WHERE 1=1  AND  image_id= ?  "+injector.getWhereQuery()+" ";
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
		
		
		
		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getByPrimaryKey", sql ,  paramImageId);
		if (result != null) {
			
			ret = dataMapper.mapFromRow(result.get(0), DBImagesBean.class);
			
		}
		return ret;
	}
	
	public int updateByPrimaryKey(DBImagesBean bean, java.lang.Long paramImageId) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		 Map<String, Object> map = dataMapper.mapToRow(bean);
		 Map<String, Object> keys = new HashMap<String, Object>();
		 
		 keys.put("image_id",  paramImageId);
		 
		return getConnection().updateRow("images", map, keys);
	}
	
	public int updateActivate(Long paramImageId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				UPDATE images SET is_active = 1 WHERE image_id = ? LIMIT 1 			";
		}

		
		int ret = getConnection().query(query,  paramImageId);
			
		return ret;
	}
	
	public int updateDeactivateForUserImage(Long paramImageId, Long paramUserId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				UPDATE images i, pilots p  				SET i.is_active = 0  				WHERE i.image_id = ? 				AND i.pilot_id = p.pilot_id 				AND p.user_id = ? 			";
		}

		
		int ret = getConnection().query(query,  paramImageId,  paramUserId);
			
		return ret;
	}
	
	public List<DBPilotsImagesBean> getPilotsImages(org.c3s.edgo.common.intruders.InInjector paramIntruder) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT i.*, DATE_FORMAT(i.create_time, '%Y-%m-%d %T') AS image_date, s.name as system_name, st.name as station_name, b.body_name 				FROM images i 				LEFT JOIN location_history lh ON lh.location_id = i.location_id 				LEFT JOIN systems s ON s.system_id = lh.system_id 				LEFT JOIN station_history sh ON sh.station_history_id = i.station_history_id 				LEFT JOIN stations st ON st.station_id = sh.station_id 				LEFT JOIN bodies b ON b.body_id = sh.body_id   				WHERE i.is_active = 1 				" + where + " 				ORDER BY i.create_time DESC  			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getPilotsImages", query );
		List<DBPilotsImagesBean> ret = null;
		if (result != null) {
					ret = new ArrayList<DBPilotsImagesBean>();
				
			for (Map<String, Object> res : result) {
				DBPilotsImagesBean bean = dataMapper.mapFromRow(res, DBPilotsImagesBean.class);
														
				ret.add(bean);
			}
					
		}
			
		return ret;
	}
	
}