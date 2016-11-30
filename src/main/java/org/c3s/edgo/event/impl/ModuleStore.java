package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ModuleStoreBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleStore extends AbstractJournalEvent<ModuleStoreBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ModuleStore.class);
	
	{
		beanClass = ModuleStoreBean.class;
	}
	
	protected void processBean(ModuleStoreBean bean) {
		try {
			/**
			 * Update pilot module
			 */
			DBPilotsBean current = getCurrent();
			if (current != null) {
				ShipsDAO.removePilotShipModule(current, bean.getShip(), bean.getShipID(), bean.getSlot(), bean.getStoredItem());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		} 
	}

}
	