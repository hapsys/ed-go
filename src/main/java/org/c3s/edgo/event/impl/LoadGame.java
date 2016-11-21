package org.c3s.edgo.event.impl;
	
import java.util.List;

import org.c3s.edgo.common.entity.Pilot;
import org.c3s.edgo.common.entity.PilotShip;
import org.c3s.edgo.common.entity.Ship;
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

		//beginTrtansaction();
		/**
		 * Set current pilot for user
		 */
		Pilot current = null;
		List<Pilot> pilots = em.createNamedQuery("Pilot.findByUserId", Pilot.class).setParameter("user_id", user.getUserId()).getResultList();
		if (pilots != null && pilots.size() > 0) {
			for(Pilot pilot: pilots) {
				if (pilot.getPilotName().toLowerCase().equals(bean.getCommander().toLowerCase())) {
					pilot.setIsCurrent((byte)1);
					current = pilot;
				} else {
					pilot.setIsCurrent((byte)0);
				}
				em.merge(pilot);
			}
		}
		
		if (current == null) {
			current = new Pilot();
			current.setUserId(user.getUserId());
			current.setPilotName(bean.getCommander());
			current.setIsCurrent((byte)1);
			em.persist(current);
		}
		
		/**
		 * Set current pilot ship
		 */
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
		
		
		//  
		
		//System.out.println(bean.getTimestamp());
		//commitTrtansaction();
	}

}
	