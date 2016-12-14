package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;
import java.util.List;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.LoadGameBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadGame extends AbstractJournalEvent<LoadGameBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = LoadGameBean.class;
	}
	
	protected void processBean(LoadGameBean bean) {

		try {
			//beginTrtansaction();
			/**
			 * Set current pilot for user
			 */
			DBPilotsBean current = null;
			List<DBPilotsBean> pilots = DbAccess.pilotsAccess.getByUserId(user.getUserId());
					//em.createNamedQuery("Pilot.findByUserId", Pilot.class).setParameter("user_id", user.getUserId()).getResultList();
			if (pilots != null && pilots.size() > 0) {
				for(DBPilotsBean pilot: pilots) {
					if (pilot.getPilotName().toLowerCase().equals(bean.getCommander().toLowerCase())) {
						pilot.setIsCurrent(1);
						current = pilot;
					} else {
						pilot.setIsCurrent(0);
					}
					//em.merge(pilot);
					DbAccess.pilotsAccess.updateByPrimaryKey(pilot, pilot.getPilotId());
				}
			}
			
			if (current == null) {
				if (bean.getIsNew().equals("true") || pilots == null) {
					current = new DBPilotsBean();
					current.setUserId(user.getUserId());
					current.setPilotName(bean.getCommander());
					current.setIsCurrent(1);
					//em.persist(current);
					DbAccess.pilotsAccess.insert(current);
				} else {
					current = DbAccess.pilotsAccess.getCurrentByUserId(user.getUserId());
					current.setPilotName(bean.getCommander());
					DbAccess.pilotsAccess.updateByPrimaryKey(current, current.getPilotId());
				}
			}
			
			/**
			 * Set current pilot ship
			 */
			ShipsDAO.updateOrInsertCurrentPilotShip(current, bean.getShip().toLowerCase(), bean.getShipID());
			//
			//System.out.println(bean.getTimestamp());
			//commitTrtansaction();
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		} 
	}

}
	