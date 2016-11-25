package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBMaterialsBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.MissionsDAO;
import org.c3s.edgo.common.dao.PilotDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.MaterialDiscardedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaterialDiscarded extends AbstractJournalEvent<MaterialDiscardedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(MaterialDiscarded.class);
	
	{
		beanClass = MaterialDiscardedBean.class;
	}
	
	protected void processBean(MaterialDiscardedBean bean) {
		try {
			DBMaterialsBean mat = MissionsDAO.getMaterial(bean.getName(), bean.getCategory());
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				PilotDAO.insertUpdateMissionMaterial(pilot.getPilotId(), mat.getMaterialId(), -bean.getCount());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
	