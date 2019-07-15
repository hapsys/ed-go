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
public class DBMissionEffectsAccess extends Access {
	protected DBConnection getConnection() {
		setNames();
		return getCon();
	}
	
	private DataMapper dataMapper = new GeneralDataMapper(new EdGoCast()); 
	
	protected void setNames() {
		con_name = "edgo";
		tablename = "mission_effects";
	}
	
	
	public int insert(DBMissionEffectsBean bean) throws SQLException, IllegalArgumentException, IllegalAccessException {
		setNames();
		int res = _insert(bean);
		bean.setAutoincrementField(res);
		return res;
	}

	
	public List<DBMissionEffectsBean> getTableRecords() throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		return getTableRecords(null);
	}
	public List<DBMissionEffectsBean> getTableRecords(SqlInjectorInterface injector) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		setNames();
		List<Map<String, Object>> result = _getTableRecords(injector);
		
		List<DBMissionEffectsBean> ret = null;
		if (result != null) {
			ret = new ArrayList<DBMissionEffectsBean>();
			for (Map<String, Object> res : result) {
				DBMissionEffectsBean bean = dataMapper.mapFromRow(res, DBMissionEffectsBean.class);
				
				ret.add(bean);
			}
		}
		return ret;
	}
	
	
}