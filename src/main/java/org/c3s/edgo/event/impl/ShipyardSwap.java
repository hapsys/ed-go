package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ShipyardSwapBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShipyardSwap extends AbstractJournalEvent<ShipyardSwapBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ShipyardSwap.class);
	
	{
		beanClass = ShipyardSwapBean.class;
	}
	
	protected void processBean(ShipyardSwapBean bean) {
		try {
			/**
			 * Set current pilot ship
			 */
			DBPilotsBean current = getCurrent();
			if (current != null) {
				if (bean.getSellOldShip() != null) {
					//ShipsDAO.removePilotShip(ShipsDAO.updateOrInsertCurrentPilotShip(current, bean.getSellOldShip().toLowerCase(), bean.getSellShipID()));
					ShipsDAO.removePilotShip(ShipsDAO.getOrInsertPilotShip(current, bean.getSellOldShip().toLowerCase(), bean.getSellShipID(), null, null));
				}
				ShipsDAO.updateOrInsertCurrentPilotShip(current, bean.getShipType().toLowerCase(), bean.getShipID());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		} 
	}

}
	