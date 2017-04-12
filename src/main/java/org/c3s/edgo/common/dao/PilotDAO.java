package org.c3s.edgo.common.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBPilotMaterialsBean;

public class PilotDAO {

	public static void insertUpdateMaterial(long pilot_id, long material_id, int count) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		insertUpdateMaterial(pilot_id, material_id, count, false);
	}
	
	public static void insertUpdateMaterial(long pilot_id, long material_id, int count, boolean isAbsolute) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBPilotMaterialsBean bean = DbAccess.pilotMaterialsAccess.getByPrimaryKey(pilot_id, material_id);
		if (bean == null) {
			bean = new DBPilotMaterialsBean();
			bean.setPilotId(pilot_id);
			bean.setMaterialId(material_id);
			bean.setQuantity(count);
			bean.setCanDelete(0);
			bean.setUpdateTime(new Timestamp(new Date().getTime()));
			DbAccess.pilotMaterialsAccess.insert(bean);
		} else {
			if (!isAbsolute || bean.getQuantity().intValue() != count) {
				bean.setUpdateTime(new Timestamp(new Date().getTime()));
			}
			if (!isAbsolute) {
				bean.setQuantity(count + bean.getQuantity());
			} else {
				bean.setQuantity(count);
			}
			bean.setCanDelete(0);
			DbAccess.pilotMaterialsAccess.updateByPrimaryKey(bean, pilot_id, material_id);
		}
	}
	
	
}
