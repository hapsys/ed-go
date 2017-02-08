package org.c3s.edgo.event.impl;
	
import java.math.BigInteger;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBPilotGameModesBean;
import org.c3s.edgo.common.beans.DBPilotLastInfoBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.LoadGameBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadGame extends AbstractJournalEvent<LoadGameBean> {

	@SuppressWarnings("serial")
	private static Map<String, Long> gameModes = new HashMap<String, Long>() {{
		put("open", 1L);
		put("group", 2L);
		put("solo", 3L);
	}};
	
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = LoadGameBean.class;
	}
	
	protected void processBean(LoadGameBean bean) {

		if (bean.getGameMode() != null) {
			try {
				/**
				 * Set current pilot for user
				 */
				DBPilotsBean current = null;
				
				List<DBPilotsBean> pilots = DbAccess.pilotsAccess.getByUserId(user.getUserId());
				if (pilots != null && pilots.size() > 0) {
					for(DBPilotsBean pilot: pilots) {
						if (pilot.getPilotName().toLowerCase().equals(bean.getCommander().toLowerCase())) {
							pilot.setIsCurrent(1);
							current = pilot;
						} else {
							pilot.setIsCurrent(0);
						}
						DbAccess.pilotsAccess.updateByPrimaryKey(pilot, pilot.getPilotId());
					}
				}
				
				if (current == null) {
					current = new DBPilotsBean();
					current.setUserId(user.getUserId());
					current.setPilotName(bean.getCommander());
					current.setIsCurrent(1);
					current.setIsIgnored(DbAccess.pilotsAccess.getCheckPilotName(bean.getCommander()).getNameOther() == 0L?0:1);
					DbAccess.pilotsAccess.insert(current);
				}
				
				/**
				 * Set current pilot info
				 */
				if (current != null) {
					DBPilotLastInfoBean info = DbAccess.pilotLastInfoAccess.getByPrimaryKey(current.getPilotId());
					boolean isInsert = info == null;
					if (isInsert) {
						info = new DBPilotLastInfoBean(); 
					}
					info.setPilotId(current.getPilotId()).setCredits(BigInteger.valueOf(bean.getCredits()))
					.setLoan(BigInteger.valueOf(bean.getLoan()));
					if (isInsert) {
						DbAccess.pilotLastInfoAccess.insert(info);
					} else {
						DbAccess.pilotLastInfoAccess.updateByPrimaryKey(info, current.getPilotId());
					}
					
					DBPilotGameModesBean mode = new DBPilotGameModesBean();
					mode.setGameGroup(bean.getGroup()).setGameModeId(gameModes.get(bean.getGameMode().toLowerCase())).setPilotId(current.getPilotId()).setModeStart(new Timestamp(bean.getTimestamp().getTime()));
					DbAccess.pilotGameModesAccess.insert(mode);
				}
				
				/**
				 * Set current pilot ship
				 */
				if (bean.getShip() != null) {
					ShipsDAO.updateOrInsertCurrentPilotShip(current, bean.getShip().toLowerCase(), bean.getShipID());
				}
				//
				//System.out.println(bean.getTimestamp());
				//commitTrtansaction();
			} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
	