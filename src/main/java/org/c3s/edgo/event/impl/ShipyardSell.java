package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ShipyardSellBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShipyardSell extends AbstractJournalEvent<ShipyardSellBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ShipyardSell.class);
	
	{
		beanClass = ShipyardSellBean.class;
	}
	
	protected void processBean(ShipyardSellBean bean) {
		try {
			/**
			 * Set current pilot ship
			 */
			DBPilotsBean current = getCurrent();
			if (current != null) {
				//ShipsDAO.removePilotShip(ShipsDAO.updateOrInsertCurrentPilotShip(current, bean.getShipType().toLowerCase(), bean.getSellShipID()));
				ShipsDAO.removePilotShip(ShipsDAO.getOrInsertPilotShip(current, bean.getShipType().toLowerCase(), bean.getSellShipID(), null, null, null, null));
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		} 
	}

}
	