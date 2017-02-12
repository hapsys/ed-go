package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBMaterialsBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.PilotDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.EngineerCraftBean;
import org.c3s.edgo.utils.EDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EngineerCraft extends AbstractJournalEvent<EngineerCraftBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(EngineerCraft.class);
	
	{
		beanClass = EngineerCraftBean.class;
	}
	
	protected void processBean(EngineerCraftBean bean) {
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				
				for(String name: bean.getIngredients().keySet()) {
					String uniq = EDUtils.cutFull(name);
					DBMaterialsBean mat = DbAccess.materialsAccess.getByUniq(uniq);
					if (mat != null) {
						PilotDAO.insertUpdateMaterial(pilot.getPilotId(), mat.getMaterialId(), -bean.getIngredients().get(name));
					}
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
	