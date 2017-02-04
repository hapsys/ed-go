package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBByModuleInfoByUniqBean;
import org.c3s.edgo.common.beans.DBPilotShipsBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBSlotsBean;
import org.c3s.edgo.common.beans.DBStationsBean;
import org.c3s.edgo.common.beans.DBSystemsBean;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.common.dao.SystemsDAO;
import org.c3s.edgo.companion.CompanionBean;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.CompanionApiBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompanionApi extends AbstractJournalEvent<CompanionApiBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(CompanionApi.class);
	
	{
		beanClass = CompanionApiBean.class;
	}
	
	protected void processBean(CompanionApiBean companionApiBean) {
		try {
			
			String pilot_name = companionApiBean.getCompanionData().commander.name;
			DBPilotsBean pilot = DbAccess.pilotsAccess.getByUserIdAndName(user.getUserId(), pilot_name);
			if (pilot == null) {
				DbAccess.pilotsAccess.updateNoCurrent(user.getUserId());
				pilot = new DBPilotsBean();
				pilot.setUserId(user.getUserId());
				pilot.setPilotName(pilot_name);
				pilot.setIsCurrent(1);
				pilot.setIsIgnored(0);
				DbAccess.pilotsAccess.insert(pilot);
			}
			
			List<String> skip =  Arrays.asList(new String[] {"PaintJob", "Decal", "PlanetaryApproachSuite", "Bobble", "WeaponColour", "EngineColour", "ShipKit"});
			
			CompanionBean companion = companionApiBean.getCompanionData();
			
			DbAccess.pilotShipsAccess.updateSetDeletedByPilotId(pilot.getPilotId());
			
			
			
			long currentShipId = companion.ship.id;

			for (String strId: companion.ships.keySet()) {
				
				long id = Long.valueOf(strId);

				/**
				 * Update pilot ship
				 */
				DBPilotShipsBean pilotShip = ShipsDAO.getOrInsertPilotShip(pilot, companion.ships.get(strId).name, id, null, null);
				
				pilotShip.setCanDeleted(0);
				if (currentShipId == id) {
					pilotShip.setIsMain(1);
					DBSystemsBean system = SystemsDAO.getOrInsertSystem(companion.lastSystem.name, null);
					DBStationsBean station =  SystemsDAO.getStation(companion.lastSystem.name, system.getSystemId());
					pilotShip.setSystemId(system.getSystemId());
					if (station != null) {
						pilotShip.setStationId(station.getStationId());
					}
				} else {
					pilotShip.setIsMain(0);
					DBSystemsBean system = SystemsDAO.getOrInsertSystem(companion.ships.get(strId).starsystem.name, null);
					DBStationsBean station =  SystemsDAO.getStation(companion.ships.get(strId).station.name, system.getSystemId());
					pilotShip.setSystemId(system.getSystemId());
					if (station != null) {
						pilotShip.setStationId(station.getStationId());
					}
				}
				
				DbAccess.pilotShipsAccess.updateByPrimaryKey(pilotShip, pilotShip.getPilotShipId());
				
				/**
				 * Update modules
				 */
				DbAccess.shipSlotsAccess.updateSetDeletedByShipId(pilotShip.getShipId());
				for (final String cslot : companion.ships.get(strId).modules.keySet()) {
					if (skip.stream().filter(s -> cslot.toLowerCase().startsWith(s.toLowerCase())).map(s->true).findFirst().orElse(false)) {
						continue;
					} else {
						DBSlotsBean slot = ShipsDAO.getOrInsertSlot(cslot, null);
						ShipsDAO.insertUpdateShipSlot(pilotShip.getShipId(), slot.getSlotId(), null);
						if (companion.ships.get(strId).modules.get(cslot).module == null) {
							DbAccess.pilotModulesAccess.deleteByPilotShipIdAndSlotId(pilotShip.getPilotShipId(), slot.getSlotId());
						} else {
							DBByModuleInfoByUniqBean module =  ShipsDAO.getModuleInfo(companion.ships.get(strId).modules.get(cslot).module.name);
							if (module != null) {
								ShipsDAO.insertOrUpdatePilotModule(pilotShip.getPilotShipId(), slot.getSlotId(), module.getModuleId());
							} else {
								logger.info("WTF, module {" + companion.ships.get(strId).modules.get(cslot).module.name + "} not found!");
							}
						}
					}
				}
				DbAccess.shipSlotsAccess.deleteFailSlotsByShipId(pilotShip.getShipId());
			}
			DbAccess.pilotShipsAccess.deleteDeletedByPilotId(pilot.getPilotId());
			//throw new SQLException();
			
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
	