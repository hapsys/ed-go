package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ModuleBuyBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleBuy extends AbstractJournalEvent<ModuleBuyBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ModuleBuy.class);
	
	{
		beanClass = ModuleBuyBean.class;
	}
	
	protected void processBean(ModuleBuyBean bean) {
		try {
			/**
			 * Update pilot module
			 */
			DBPilotsBean current = getCurrent();
			if (current != null) {
				ShipsDAO.updatePilotShipModule(current, bean.getShip(), bean.getShipID(), bean.getSlot(), bean.getBuyItem());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		} 
	}

}
	