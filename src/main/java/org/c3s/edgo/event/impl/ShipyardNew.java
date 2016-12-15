package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ShipyardNewBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShipyardNew extends AbstractJournalEvent<ShipyardNewBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ShipyardNew.class);
	
	{
		beanClass = ShipyardNewBean.class;
	}
	
	protected void processBean(ShipyardNewBean bean) {
		try {
			/**
			 * Set current pilot ship
			 */
			DBPilotsBean current = getCurrent();
			if (current != null) {
				//System.out.println(bean.getShipType());
				//System.out.println(bean.getNewShipID());
				ShipsDAO.updateOrInsertCurrentPilotShip(current, bean.getShipType().toLowerCase(), bean.getNewShipID());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		} 
	}

}
	