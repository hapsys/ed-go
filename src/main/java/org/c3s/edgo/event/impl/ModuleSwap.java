package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ModuleSwapBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleSwap extends AbstractJournalEvent<ModuleSwapBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ModuleSwap.class);
	
	{
		beanClass = ModuleSwapBean.class;
	}
	
	protected void processBean(ModuleSwapBean bean) {
		try {
			/**
			 * Update pilot module
			 */
			DBPilotsBean current = getCurrent();
			if (current != null) {
				ShipsDAO.swapShipModules(current, bean.getShip(), bean.getShipID(), bean.getFromSlot(), bean.getFromItem(), bean.getToSlot(), bean.getToItem());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		} 
	}

}
	