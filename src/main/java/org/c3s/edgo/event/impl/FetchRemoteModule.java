package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.FetchRemoteModuleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FetchRemoteModule extends AbstractJournalEvent<FetchRemoteModuleBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(FetchRemoteModule.class);
	
	{
		beanClass = FetchRemoteModuleBean.class;
	}
	
	protected void processBean(FetchRemoteModuleBean bean) {
		try {
			/**
			 * Set current pilot ship
			 */
			DBPilotsBean current = getCurrent();
			if (current != null) {
				ShipsDAO.updateOrInsertCurrentPilotShip(current, bean.getShip().toLowerCase(), bean.getShipId());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		} 
		
	}

}
	