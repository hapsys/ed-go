package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.c3s.edgo.common.access.DBModuleRecipiesAccess;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBByModuleInfoByUniqBean;
import org.c3s.edgo.common.beans.DBModifiersBean;
import org.c3s.edgo.common.beans.DBModuleModifiersBean;
import org.c3s.edgo.common.beans.DBModuleRecipiesBean;
import org.c3s.edgo.common.beans.DBModulesBean;
import org.c3s.edgo.common.beans.DBPilotModulesBean;
import org.c3s.edgo.common.beans.DBPilotShipsBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBRecipiesBean;
import org.c3s.edgo.common.beans.DBSlotsBean;
import org.c3s.edgo.common.beans.DBStationsBean;
import org.c3s.edgo.common.beans.DBSystemsBean;
import org.c3s.edgo.common.dao.PilotDAO;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.common.dao.SystemsDAO;
import org.c3s.edgo.companion.CompanionBean;
import org.c3s.edgo.companion.Modifier;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.CompanionApiBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.syndication.feed.module.Module;

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
			
			List<String> skip =  Arrays.asList(new String[] {"PaintJob", "Decal", "PlanetaryApproachSuite", "Bobble", "WeaponColour", "EngineColour", "ShipKit", "ShipName0",
					"ShipName1", "ShipID0", "ShipID1", "ShipCockpit", "CargoHatch"});
			
			CompanionBean companion = companionApiBean.getCompanionData();
			
			DbAccess.pilotShipsAccess.updateSetDeletedByPilotId(pilot.getPilotId());
			
			
			
			long currentShipId = companion.ship.id;

			for (String strId: companion.ships.keySet()) {
				
				long id = Long.valueOf(strId);

				/**
				 * Update pilot ship // !!!Wait ship name and ident
				 */
				DBPilotShipsBean pilotShip = ShipsDAO.getOrInsertPilotShip(pilot, companion.ships.get(strId).name, id, null, null, null, null);
				
				pilotShip.setCanDeleted(0);
				if (currentShipId == id) {
					pilotShip.setIsMain(1);
					DBSystemsBean system = SystemsDAO.getOrInsertSystem(companion.lastSystem.name, null, null);
					DBStationsBean station =  SystemsDAO.getStation(companion.lastSystem.name, system.getSystemId());
					pilotShip.setSystemId(system.getSystemId());
					if (station != null) {
						pilotShip.setStationId(station.getStationId());
					}
				} else {
					pilotShip.setIsMain(0);
					DBSystemsBean system = SystemsDAO.getOrInsertSystem(companion.ships.get(strId).starsystem.name, null, null);
					DBStationsBean station =  SystemsDAO.getStation(companion.ships.get(strId).station.name, system.getSystemId());
					pilotShip.setSystemId(system.getSystemId());
					if (station != null) {
						pilotShip.setStationId(station.getStationId());
					}
				}
				
				DbAccess.pilotShipsAccess.updateByPrimaryKey(pilotShip, pilotShip.getPilotShipId());
				
				/**
				 * Update modules (!!!! Cut from companian api) 
				 */
				/*
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
				*/
			}
			DbAccess.pilotShipsAccess.deleteDeletedByPilotId(pilot.getPilotId());
			
			
			// Update current ship  
			DBPilotShipsBean ship = ShipsDAO.getOrInsertPilotShip(pilot, companion.ship.name, companion.ship.id, null, null, null, null);
			DbAccess.pilotModulesAccess.updateSetDeletedByPilotShipId(ship.getPilotShipId());
			
			for (String slotName: companion.ship.modules.keySet()) {
				if (skip.contains(slotName)) {
					continue;
				}
					
				DBModulesBean module = DbAccess.modulesAccess.getByUniq(companion.ship.modules.get(slotName).module.name);
				if (module != null) {
					// Update module
					if (module.getModuleLocName() == null) {
						module.setModuleLocName(companion.ship.modules.get(slotName).module.locName);
						module.setModuleLocDescription(companion.ship.modules.get(slotName).module.locDescription);
						DbAccess.modulesAccess.updateByPrimaryKey(module, module.getModuleId());
					}

					DBSlotsBean slot = ShipsDAO.getOrInsertSlot(slotName, null);
					
					DBPilotModulesBean pilotModule = DbAccess.pilotModulesAccess.getByPilotShipIdSlotId(ship.getPilotShipId(), slot.getSlotId());
					
					if (pilotModule == null) {
						pilotModule = new DBPilotModulesBean();
						pilotModule.setPilotShipId(ship.getPilotShipId()).setSlotId(slot.getSlotId()).setModuleId(module.getModuleId()).setCanDeleted(0);
						DbAccess.pilotModulesAccess.insert(pilotModule);
					}
					
					if (companion.ship.modules.get(slotName).engineer != null) {
						DBRecipiesBean recipie = ShipsDAO.getOrInsertRecipie(companion.ship.modules.get(slotName).engineer.recipeName, 
							companion.ship.modules.get(slotName).engineer.recipeLocName, companion.ship.modules.get(slotName).engineer.recipeLocDescription);
						
						DBModuleRecipiesBean moduleRecipie = DbAccess.moduleRecipiesAccess.getByPilotModuleIdAndRecipieId(pilotModule.getPilotModuleId(), recipie.getRecipieId());
						
						if (moduleRecipie == null) {
							moduleRecipie = new DBModuleRecipiesBean();
							moduleRecipie.setPilotModuleId(pilotModule.getPilotModuleId()).setRecipieId(recipie.getRecipieId()).setRecipieLevel(companion.ship.modules.get(slotName).engineer.recipeLevel);
							DbAccess.moduleRecipiesAccess.insert(moduleRecipie);
						} else {
							if (!companion.ship.modules.get(slotName).engineer.recipeLevel.equals(moduleRecipie.getRecipieLevel())) {
								moduleRecipie.setRecipieLevel(companion.ship.modules.get(slotName).engineer.recipeLevel);
								DbAccess.moduleRecipiesAccess.updateByPrimaryKey(moduleRecipie, moduleRecipie.getModuleRecipeId());
							}
							// Delete modifiers
							DbAccess.moduleModifiersAccess.deleteByModuleRecipieId(moduleRecipie.getModuleRecipeId());
						}
						
						for(String modifyer: companion.ship.modules.get(slotName).WorkInProgress_modifications.keySet()) {
							Modifier modification = companion.ship.modules.get(slotName).WorkInProgress_modifications.get(modifyer);
							String modUniq = modifyer;
							if (modUniq.startsWith("OutfittingFieldType_")) {
								modUniq = modUniq.substring("OutfittingFieldType_".length());
							}
							
							DBModifiersBean modBean = ShipsDAO.getOrInsertModifyer(modUniq, modification.locName);
							
							DBModuleModifiersBean modModifyer = new DBModuleModifiersBean();
							
							modModifyer
								.setModuleRecipeId(moduleRecipie.getModuleRecipeId())
								.setModifierId(modBean.getModifierId())
								.setLessIsGood(modification.LessIsGood?1:0)
								.setValue(modification.value)
								.setDisplayValue(modification.displayValue)
								.setDirection(modification.dir)
								;
							
							DbAccess.moduleModifiersAccess.insert(modModifyer);
						}
						
					} else {
						DbAccess.moduleRecipiesAccess.deleteByPilotModuleId(pilotModule.getPilotModuleId());
					}
					
				}
			}
			
			DbAccess.pilotModulesAccess.deleteFailModulesByPilotShipId(ship.getPilotShipId());
			
			//throw new SQLException();
			
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
	