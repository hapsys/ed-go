package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBModulesBean;
import org.c3s.edgo.common.beans.DBPilotModulesBean;
import org.c3s.edgo.common.beans.DBPilotShipsBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBSlotsBean;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.LoadoutBean;
import org.c3s.edgo.event.impl.beans.intl.LoadoutModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Loadout extends AbstractJournalEvent<LoadoutBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Loadout.class);
	
	private List<String> skip =  Arrays.asList(new String[] {"PaintJob", "Decal", "PlanetaryApproachSuite", "Bobble", "WeaponColour", "EngineColour", "ShipKit", "ShipName0",
			"ShipName1", "ShipID0", "ShipID1", "ShipCockpit", "CargoHatch"});
	
	{
		beanClass = LoadoutBean.class;
	}
	
	protected void processBean(LoadoutBean bean) {
		try {
			/**
			 * Update pilot module
			 */
			DBPilotsBean current = getCurrent();
			if (current != null) {
				DBPilotShipsBean pilotShip = ShipsDAO.getOrInsertPilotShip(current, bean.getShip().toLowerCase(), bean.getShipID(), null, null, bean.getShipName(), bean.getShipIdent());
				if (bean.getModules() != null) {
					DbAccess.pilotModulesAccess.updateSetDeletedByPilotShipId(pilotShip.getPilotShipId());
					for (LoadoutModule module: bean.getModules()) {
						if (skip.stream().filter(s -> module.getSlot().toLowerCase().startsWith(s.toLowerCase())).map(s->true).findFirst().orElse(false)) {
							continue;
						} else {
							DBSlotsBean slot = ShipsDAO.getOrInsertSlot(module.getSlot(), null);
							ShipsDAO.insertUpdateShipSlot(pilotShip.getShipId(), slot.getSlotId(), null);
							DBPilotModulesBean pilot_ship_slot = DbAccess.pilotModulesAccess.getByPilotShipIdSlotId(pilotShip.getShipId(), slot.getSlotId());
							DBModulesBean stored_module = DbAccess.modulesAccess.getByUniq(module.getItem());
							if (stored_module != null && pilot_ship_slot != null && !stored_module.getModuleId().equals(pilot_ship_slot.getModuleId())) {
								ShipsDAO.insertOrUpdatePilotModule(pilotShip.getPilotShipId(), slot.getSlotId(), stored_module.getModuleId());
							} else if (stored_module != null && pilot_ship_slot == null) {
								ShipsDAO.insertOrUpdatePilotModule(pilotShip.getPilotShipId(), slot.getSlotId(), stored_module.getModuleId());
							}
						}
					}
					DbAccess.pilotModulesAccess.deleteFailModulesByPilotShipId(pilotShip.getPilotShipId());
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		} 
		
	}

}
	