package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.SetUserShipNameBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SetUserShipName extends AbstractJournalEvent<SetUserShipNameBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(SetUserShipName.class);
	
	{
		beanClass = SetUserShipNameBean.class;
	}
	
	protected void processBean(SetUserShipNameBean bean) {
		try {
			/**
			 * Set current pilot for user
			 */
			DBPilotsBean current = getCurrent();
			
			if (current != null) {
			/**
			 * Set current pilot ship
			 */
				if (bean.getShip() != null) {
					ShipsDAO.updateOrInsertCurrentPilotShip(current, bean.getShip().toLowerCase(), bean.getShipID(), bean.getUserShipName(), bean.getUserShipId());
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
	