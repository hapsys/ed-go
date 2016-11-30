package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ModuleSellBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleSell extends AbstractJournalEvent<ModuleSellBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ModuleSell.class);
	
	{
		beanClass = ModuleSellBean.class;
	}
	
	protected void processBean(ModuleSellBean bean) {
		try {
			/**
			 * Update pilot module
			 */
			DBPilotsBean current = getCurrent();
			if (current != null) {
				ShipsDAO.removePilotShipModule(current, bean.getShip(), bean.getShipID(), bean.getSlot(), bean.getSellItem());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		} 
	}

}
	