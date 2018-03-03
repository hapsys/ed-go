package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBModifiersBean;
import org.c3s.edgo.common.beans.DBModuleModifiersBean;
import org.c3s.edgo.common.beans.DBModuleRecipiesBean;
import org.c3s.edgo.common.beans.DBModulesBean;
import org.c3s.edgo.common.beans.DBPilotModulesBean;
import org.c3s.edgo.common.beans.DBPilotShipsBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBRecipiesBean;
import org.c3s.edgo.common.beans.DBSlotsBean;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.annotation.DateRangeAnnotation;
import org.c3s.edgo.event.annotation.EventAnnotation;
import org.c3s.edgo.event.impl.beans.Loadout30Bean;
import org.c3s.edgo.event.impl.beans.intl.loadout30.Engineering;
import org.c3s.edgo.event.impl.beans.intl.loadout30.Modification;
import org.c3s.edgo.event.impl.beans.intl.loadout30.Module;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EventAnnotation("Loadout")
@DateRangeAnnotation(start="2018-02-27T15:00:00Z" /* Start Date */)
public class Loadout30 extends AbstractJournalEvent<Loadout30Bean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Loadout30.class);
	
	private List<String> skip =  Arrays.asList(new String[] {"PaintJob", "Decal", "PlanetaryApproachSuite", "Bobble", "WeaponColour", "EngineColour", "ShipKit", "ShipName0",
			"ShipName1", "ShipID0", "ShipID1", "ShipCockpit", "CargoHatch"});
	
	{
		beanClass = Loadout30Bean.class;
	}
	
	protected void processBean(Loadout30Bean bean) {
		try {
			/**
			 * Update pilot module
			 */
			DBPilotsBean current = getCurrent();
			if (current != null) {
				DBPilotShipsBean pilotShip = ShipsDAO.getOrInsertPilotShip(current, bean.getShip().toLowerCase(), bean.getShipID(), null, null, bean.getShipName(), bean.getShipIdent());
				if (bean.getModules() != null) {
					DbAccess.pilotModulesAccess.updateSetDeletedByPilotShipId(pilotShip.getPilotShipId());
					for (Module module: bean.getModules()) {
						if (skip.stream().filter(s -> module.getSlot().toLowerCase().startsWith(s.toLowerCase())).map(s->true).findFirst().orElse(false)) {
							continue;
						} else {
							DBSlotsBean slot = ShipsDAO.getOrInsertSlot(module.getSlot(), null);
							ShipsDAO.insertUpdateShipSlot(pilotShip.getShipId(), slot.getSlotId(), null);
							DBPilotModulesBean pilot_ship_slot = DbAccess.pilotModulesAccess.getByPilotShipIdSlotId(pilotShip.getShipId(), slot.getSlotId());
							DBModulesBean stored_module = DbAccess.modulesAccess.getByUniq(module.getItem());
							
							DBPilotModulesBean resId = null;
							
							if (stored_module != null && pilot_ship_slot != null) {
								if (!stored_module.getModuleId().equals(pilot_ship_slot.getModuleId())) {
									resId = ShipsDAO.insertOrUpdatePilotModule(pilotShip.getPilotShipId(), slot.getSlotId(), stored_module.getModuleId());
								} else {
									resId = pilot_ship_slot;
								}
							} else if (stored_module != null && pilot_ship_slot == null) {
								resId = ShipsDAO.insertOrUpdatePilotModule(pilotShip.getPilotShipId(), slot.getSlotId(), stored_module.getModuleId());
							}
							
							// Engeneers
							if (module.getEngineering() != null && resId != null) {
								Engineering eng = module.getEngineering(); 
								DBRecipiesBean recipie = ShipsDAO.getOrInsertRecipie(eng.getBlueprintName(), null, null);
								
								DBModuleRecipiesBean moduleRecipie = DbAccess.moduleRecipiesAccess.getByPilotModuleIdAndRecipieId(resId.getPilotModuleId(), recipie.getRecipieId());
								
								if (moduleRecipie == null) {
									moduleRecipie = new DBModuleRecipiesBean();
									moduleRecipie.setPilotModuleId(resId.getPilotModuleId()).setRecipieId(recipie.getRecipieId()).setRecipieLevel(eng.getLevel());
									DbAccess.moduleRecipiesAccess.insert(moduleRecipie);
								} else {
									if (!moduleRecipie.getRecipieLevel().equals(eng.getLevel())) {
										moduleRecipie.setRecipieLevel(eng.getLevel());
										DbAccess.moduleRecipiesAccess.updateByPrimaryKey(moduleRecipie, moduleRecipie.getModuleRecipeId());
									}
									// Delete modifiers
									DbAccess.moduleModifiersAccess.deleteByModuleRecipieId(moduleRecipie.getModuleRecipeId());
								}
								
								if (eng.getModifiers() != null) {
									for(Modification modification: eng.getModifiers()) {
										//Modifier modification = companion.ship.modules.get(slotName).WorkInProgress_modifications.get(modifyer);
										String modUniq = modification.getLabel();
										if (modUniq.startsWith("OutfittingFieldType_")) {
											modUniq = modUniq.substring("OutfittingFieldType_".length());
										}
										
										DBModifiersBean modBean = ShipsDAO.getOrInsertModifyer(modUniq, null);
										
										DBModuleModifiersBean modModifyer = new DBModuleModifiersBean();
										
										Float persent = ((modification.getValue() - modification.getOriginalValue()) * 100 / modification.getOriginalValue());
										persent = Math.round(persent * 100f) / 100f;
										persent = (persent < 0.001f)?0f:persent; 
										String  displayValue = (persent > 1000f)?">100%": (persent + "%");
										String dir = (persent > 0)?"˄":"˅"; 
										
										modModifyer
											.setModuleRecipeId(moduleRecipie.getModuleRecipeId())
											.setModifierId(modBean.getModifierId())
											.setLessIsGood(modification.getLessIsGood())
											.setValue(modification.getValue())
											.setOriginalValue(modification.getOriginalValue())
											.setDisplayValue(displayValue)
											.setDirection(dir)
											;
										
										DbAccess.moduleModifiersAccess.insert(modModifyer);
									}
								}
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
	