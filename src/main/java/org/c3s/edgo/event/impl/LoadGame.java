package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;
import java.util.List;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBPilotsBean;
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
				current = new DBPilotsBean();
				current.setUserId(user.getUserId());
				current.setPilotName(bean.getCommander());
				current.setIsCurrent(1);
				//em.persist(current);
				DbAccess.pilotsAccess.insert(current);
			}
			
			/**
			 * Set current pilot ship
			 */
			/*
			PilotShip pilotShip = null;
			if (current.getPilotShips() == null || current.getPilotShips().size() == 0) {
				Ship ship = em.createNamedQuery("Ship.findByUniq", Ship.class).setParameter("uniq", bean.getShip()).getResultList().stream().findFirst().orElse(null);
				if (ship == null) {
					ship = new Ship();
					ship.setUniq(bean.getShip());
					em.persist(ship);
				}
				pilotShip = new PilotShip();
				pilotShip.setLinkShipId(bean.getShipID());
				pilotShip.setShip(ship);
				pilotShip.setIsMain((byte)1);
				em.persist(pilotShip);
				current.addPilotShip(pilotShip);
				em.merge(current);
			} else {
				for (PilotShip ps: current.getPilotShips()) {
					if (ps.getLinkShipId() == bean.getShipID()) {
						ps.setIsMain((byte)1);
					} else {
						ps.setIsMain((byte)0);
					}
					em.merge(ps);
				}
			}
			*/
			
			//  
			
			//System.out.println(bean.getTimestamp());
			//commitTrtansaction();
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		} 
	}

}
	