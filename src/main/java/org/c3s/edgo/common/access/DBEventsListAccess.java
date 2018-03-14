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
public class DBEventsListAccess extends Access {
	protected DBConnection getConnection() {
		setNames();
		return getCon();
	}
	
	private DataMapper dataMapper = new GeneralDataMapper(new GeneralCastType()); 
	
	protected void setNames() {
		con_name = "edgo";
		tablename = "events_list";
	}
	
	
	public int insert(DBEventsListBean bean) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		int res = _insert(bean);
		bean.setAutoincrementField(res);
		return res;
	}

	
	public List<DBEventsListBean> getTableRecords() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		return getTableRecords(null);
	}
	public List<DBEventsListBean> getTableRecords(SqlInjectorInterface injector) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<Map<String, Object>> result = _getTableRecords(injector);
		
		List<DBEventsListBean> ret = null;
		if (result != null) {
			ret = new ArrayList<DBEventsListBean>();
			for (Map<String, Object> res : result) {
				DBEventsListBean bean = dataMapper.mapFromRow(res, DBEventsListBean.class);
				
				ret.add(bean);
			}
		}
		return ret;
	}
	
	
	public DBFullEventsListBean getFullEventsList() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
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
			query = " 				SELECT GROUP_CONCAT(el.event_uniq ORDER BY el.event_uniq) AS list 				FROM events_list el 				GROUP BY el.grouped 				LIMIT 1				 			";
		}

		
		List<Map<String, Object>> result = getConnection().fetchRows(tablename + ".getFullEventsList", query );
		DBFullEventsListBean ret = null;
		if (result != null) {
					ret = new DBFullEventsListBean();
				
					ret = dataMapper.mapFromRow(result.get(0), DBFullEventsListBean.class);
					
		}
			
		return ret;
	}
	
}