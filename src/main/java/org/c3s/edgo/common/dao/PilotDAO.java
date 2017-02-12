package org.c3s.edgo.common.dao;

import java.sql.SQLException;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBPilotMaterialsBean;

public class PilotDAO {

	public static void insertUpdateMaterial(long pilot_id, long material_id, int count) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBPilotMaterialsBean bean = DbAccess.pilotMaterialsAccess.getByPrimaryKey(pilot_id, material_id);
		if (bean == null) {
			bean = new DBPilotMaterialsBean();
			bean.setPilotId(pilot_id);
			bean.setMaterialId(material_id);
			bean.setQuantity(count);
			DbAccess.pilotMaterialsAccess.insert(bean);
		} else {
			bean.setQuantity(count + bean.getQuantity());
			DbAccess.pilotMaterialsAccess.updateByPrimaryKey(bean, pilot_id, material_id);
		}
	}
	
	
}
