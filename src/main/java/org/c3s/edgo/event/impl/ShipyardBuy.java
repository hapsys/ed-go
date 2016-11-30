package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ShipyardBuyBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShipyardBuy extends AbstractJournalEvent<ShipyardBuyBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ShipyardBuy.class);
	
	{
		beanClass = ShipyardBuyBean.class;
	}
	
	protected void processBean(ShipyardBuyBean bean) {
		
		try {
			/**
			 * Set current pilot ship
			 */
			DBPilotsBean current = getCurrent();
			if (current != null) {
				if (bean.getSellOldShip() != null) {
					ShipsDAO.updateOrInsertCurrentPilotShip(current, bean.getSellOldShip().toLowerCase(), bean.getSellShipID());
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		} 
		
	}

}
	