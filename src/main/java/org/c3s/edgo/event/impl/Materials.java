package org.c3s.edgo.event.impl;

import java.sql.SQLException;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBMaterialsBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.MissionsDAO;
import org.c3s.edgo.common.dao.PilotDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.MaterialsBean;
import org.c3s.edgo.event.impl.beans.MaterialsBean.NameCount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Materials extends AbstractJournalEvent<MaterialsBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Materials.class);
	
	{
		beanClass = MaterialsBean.class;
	}
	
	protected void processBean(MaterialsBean bean) {
		try {
			//DBMaterialsBean mat = MissionsDAO.getMaterial(bean.getName(), bean.getCategory());
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				DbAccess.pilotMaterialsAccess.updateMaterialsForDelete(pilot.getPilotId());
				// Raw
				if (bean.getRaw() != null) {
					for(NameCount nc: bean.getRaw()) {
						DBMaterialsBean mat = MissionsDAO.getMaterial(nc.getName(), "Raw");
						PilotDAO.insertUpdateMaterial(pilot.getPilotId(), mat.getMaterialId(), nc.getCount(), true);
					}
				}
				// Manufactured
				if (bean.getManufactured() != null) {
					for(NameCount nc: bean.getManufactured()) {
						DBMaterialsBean mat = MissionsDAO.getMaterial(nc.getName(), "Manufactured");
						PilotDAO.insertUpdateMaterial(pilot.getPilotId(), mat.getMaterialId(), nc.getCount(), true);
					}
				}
				// Manufactured
				if (bean.getEncoded() != null) {
					for(NameCount nc: bean.getEncoded()) {
						DBMaterialsBean mat = MissionsDAO.getMaterial(nc.getName(), "Encoded");
						PilotDAO.insertUpdateMaterial(pilot.getPilotId(), mat.getMaterialId(), nc.getCount(), true);
					}
				}
				DbAccess.pilotMaterialsAccess.deleteMaterialsCanDelete(pilot.getPilotId());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
