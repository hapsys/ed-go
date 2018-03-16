package org.c3s.edgo.common.dao;

import java.math.BigInteger;
import java.sql.SQLException;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBByModuleInfoByUniqBean;
import org.c3s.edgo.common.beans.DBLocationHistoryBean;
import org.c3s.edgo.common.beans.DBModifiersBean;
import org.c3s.edgo.common.beans.DBModuleRecipiesBean;
import org.c3s.edgo.common.beans.DBPilotModulesBean;
import org.c3s.edgo.common.beans.DBPilotShipsBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBRecipiesBean;
import org.c3s.edgo.common.beans.DBShipSlotsBean;
import org.c3s.edgo.common.beans.DBShipsBean;
import org.c3s.edgo.common.beans.DBSlotsBean;
import org.c3s.edgo.common.beans.DBStationHistoryBean;
import org.c3s.edgo.common.beans.DBStoredModulesBean;
import org.c3s.edgo.common.beans.DBSystemsBean;
import org.c3s.edgo.utils.EDUtils;

public class ShipsDAO {
	
	/*
	 * Ships
	 */
	public static DBShipsBean getOrInsertShip(String ship) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		
		ship = ship.toLowerCase();
		
		DBShipsBean bean = DbAccess.shipsAccess.getByUniq(ship);
		
		if (bean == null) {
			bean = new DBShipsBean();
			bean.setShipUniq(ship);
			bean.setIsSpecial(0);
			DbAccess.shipsAccess.insert(bean);
		}
		
		return bean;
	}
	
	public static DBPilotShipsBean getOrInsertPilotShip(DBPilotsBean pilot, String shipUniq, long linkShipId, BigInteger locationId, Long stationId, String shipName, String shipIdent) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBPilotShipsBean pilotShip = null;
		DBShipsBean ship = getOrInsertShip(shipUniq);
		if (ship.getIsSpecial() == null || ship.getIsSpecial() != 1) {
			
			pilotShip = DbAccess.pilotShipsAccess.getByPilotIdAndLinkShipId(pilot.getPilotId(), linkShipId);
			
			/*
			 * if ship link id fail remove prevoius ship
			 */
			if (pilotShip != null && !pilotShip.getShipId().equals(ship.getShipId())) {
				removePilotShip(pilotShip);
				pilotShip = null;
			}
			/*
			 * 
			 */
			if (pilotShip == null) {
				pilotShip = new DBPilotShipsBean();
				pilotShip.setPilotId(pilot.getPilotId());
				pilotShip.setLinkShipId(linkShipId);
				pilotShip.setShipId(ship.getShipId());
				pilotShip.setIsMain(0);
				pilotShip.setPilotShipName(shipName);
				pilotShip.setPilotShipIdent(shipIdent);
				/*
				if (location != null) {
					pilotShip.setSystemId(location.getSystemId());
					pilotShip.setStationId(location.getStationId());
				}
				*/
				pilotShip.setSystemId(locationId);
				pilotShip.setStationId(stationId);
				
				DbAccess.pilotShipsAccess.insert(pilotShip);
			} else if (shipName != null && shipIdent != null && (!shipName.equals(pilotShip.getPilotShipName()) || !shipIdent.equals(pilotShip.getPilotShipIdent()))) {
				pilotShip.setPilotShipName(shipName);
				pilotShip.setPilotShipIdent(shipIdent);
				DbAccess.pilotShipsAccess.updateByPrimaryKey(pilotShip, pilotShip.getPilotShipId());
			}
		}
		return pilotShip;
	}
	
	public static DBPilotShipsBean updateOrInsertCurrentPilotShip(DBPilotsBean pilot, String shipUniq, long linkShipId, String shipName, String shipIdent) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		//DBShipsBean ship = getOrInsertShip(shipUniq);
		Long stationId = null;
		DBLocationHistoryBean location = DbAccess.locationHistoryAccess.getDirectLastLocation(pilot.getPilotId());
		DBStationHistoryBean station = DbAccess.stationHistoryAccess.getDirectLastStation(pilot.getPilotId());
		
		DBPilotShipsBean currentShip = DbAccess.pilotShipsAccess.getCurrentByPilotId(pilot.getPilotId());
		
		if (location != null && station != null) {
			
			if (location.getLocationTime().getTime() <= station.getStationTime().getTime()) {
				stationId = station.getStationId();
			}
			
			DBPilotShipsBean pilotShip = getOrInsertPilotShip(pilot, shipUniq, linkShipId, location.getSystemId(), stationId, shipName, shipIdent); 
			if (pilotShip != null) {
				if (currentShip == null || !currentShip.getLinkShipId().equals(linkShipId)) {
					pilotShip.setIsMain(1);
					if (location != null) {
						pilotShip.setSystemId(location.getSystemId());
						pilotShip.setStationId(stationId);
					}
					DbAccess.pilotShipsAccess.updateByPrimaryKey(pilotShip, pilotShip.getPilotShipId());
					if (currentShip != null) {
						currentShip.setIsMain(0);
						DbAccess.pilotShipsAccess.updateByPrimaryKey(currentShip, currentShip.getPilotShipId());
					}
				}
				currentShip = pilotShip;
			}
		}
		return currentShip;
	}

	public static void removePilotShip(DBPilotShipsBean ship) throws SQLException {
		if (ship != null) {
			DbAccess.pilotModulesAccess.deleteByPilotShipId(ship.getPilotShipId());
			DbAccess.pilotShipsAccess.deleteByPrimaryKey(ship.getPilotShipId());
		}
	}
	
	public static DBSlotsBean getOrInsertSlot(String slotUniq, Long slotTypeId) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBSlotsBean bean = DbAccess.slotsAccess.getByUniq(slotUniq);
		if (bean == null) {
			bean = new DBSlotsBean();
			bean.setSlotUniq(slotUniq);
			bean.setSize(0);
			bean.setSlotTypeId(slotTypeId);
			DbAccess.slotsAccess.insert(bean);
		} else if (slotTypeId != null && (bean.getSlotTypeId() == null || !bean.getSlotTypeId().equals(slotTypeId))) {
			bean.setSlotTypeId(slotTypeId);
			DbAccess.slotsAccess.updateByPrimaryKey(bean, bean.getSlotId());
		}
		return bean;
	}

	
	public static void insertUpdateShipSlot(long shipId, long slotId, Long moduleId) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBShipSlotsBean shipSlot = DbAccess.shipSlotsAccess.getByPrimaryKey(shipId, slotId);
		if (shipSlot ==  null) {
			shipSlot = new DBShipSlotsBean();
			shipSlot.setShipId(shipId);
			shipSlot.setSlotId(slotId);
			shipSlot.setModuleId(moduleId);
			shipSlot.setCanDeleted(0);
			DbAccess.shipSlotsAccess.insert(shipSlot);
		
		} else {
			shipSlot.setCanDeleted(0);
			DbAccess.shipSlotsAccess.updateByPrimaryKey(shipSlot, shipId, slotId);
		}
		
		if (shipSlot.getModuleId() == null && moduleId != null) {
			shipSlot.setModuleId(moduleId);
			DbAccess.shipSlotsAccess.updateByPrimaryKey(shipSlot, shipId, slotId);
		}
	}
	

	
	public static DBByModuleInfoByUniqBean getModuleInfo(String module) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		String uniq = EDUtils.getModuleUniq(module);
		return DbAccess.modulesAccess.getByModuleInfoByUniq(uniq);
	}
	

	/**
	 * Pilot Ship module 
	 * @throws SQLException 
	 * @throws InstantiationException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static DBPilotModulesBean insertOrUpdatePilotModule(long pilotShipId, long slotId, Long moduleId) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBPilotModulesBean bean = DbAccess.pilotModulesAccess.getByPilotShipIdSlotId(pilotShipId, slotId);
		if (moduleId != null && bean == null) {
			bean = new DBPilotModulesBean();
			bean.setModuleId(moduleId);
			bean.setPilotShipId(pilotShipId);
			bean.setSlotId(slotId);
			bean.setCanDeleted(null);
			DbAccess.pilotModulesAccess.insert(bean);
		} else if (moduleId != null && bean != null) {
			bean.setModuleId(moduleId);
			bean.setCanDeleted(null);
			DbAccess.pilotModulesAccess.updateByPrimaryKey(bean, bean.getPilotModuleId());
		} else if (moduleId == null && bean != null) {
			DbAccess.pilotModulesAccess.deleteByPrimaryKey(bean.getPilotModuleId());
			bean = null;
		}
		return bean;
	}
	
	
	public static DBRecipiesBean getOrInsertRecipie(String recipieName, String recipieLocName, String recipieLocDescription) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBRecipiesBean bean = DbAccess.recipiesAccess.getByName(recipieName);
		if (bean == null) {
			bean = new DBRecipiesBean();
			bean.setRecipieName(recipieName);
			bean.setRecipieLocName(recipieLocName);
			bean.setRecipieLocDescription(recipieLocDescription);
			DbAccess.recipiesAccess.insert(bean);
		} else if (bean.getRecipieLocName() ==  null && recipieLocName != null) {
			bean.setRecipieLocName(recipieLocName);
			bean.setRecipieLocDescription(recipieLocDescription);
			DbAccess.recipiesAccess.updateByPrimaryKey(bean, bean.getRecipieId());
		}
		return bean;
	}
	
	public static DBModuleRecipiesBean insertOrUpdateModuleRecipie(Long pilotModuleId, Long recipieId, Integer level) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBModuleRecipiesBean bean = DbAccess.moduleRecipiesAccess.getByPilotModuleIdAndRecipieId(pilotModuleId, recipieId);
		if (bean == null) {
			bean = new DBModuleRecipiesBean();
			bean.setPilotModuleId(pilotModuleId).setRecipieId(recipieId).setRecipieLevel(level);
			DbAccess.moduleRecipiesAccess.insert(bean);
		} else {
			bean.setRecipieLevel(level);
			DbAccess.moduleRecipiesAccess.updateByPrimaryKey(bean, bean.getModuleRecipeId());
		}
		return bean;
	}
	
	public static DBModifiersBean getOrInsertModifyer(String uniq, String name) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBModifiersBean bean = DbAccess.modifiersAccess.getByModifyerUniq(uniq);
		if (bean == null) {
			bean = new DBModifiersBean();
			bean.setModifierUniq(uniq).setModifierName(name);
			DbAccess.modifiersAccess.insert(bean);
		} else if (bean.getModifierName() == null && name != null) {
			bean.setModifierName(name);
			DbAccess.modifiersAccess.updateByPrimaryKey(bean, bean.getModifierId());
		}
		return bean;
	}
	
	/**
	 * 
	 * @param pilot
	 * @param ship
	 * @param linkShipId
	 * @param slot
	 * @param module
	 * @throws SQLException 
	 * @throws InstantiationException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static DBPilotModulesBean updatePilotShipModule(DBPilotsBean pilot, String ship, long linkShipId, String slot, String module) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBPilotModulesBean result = null;
		DBPilotShipsBean pilotShip = getOrInsertPilotShip(pilot, ship.toLowerCase(), linkShipId, null, null, null, null);
		DBByModuleInfoByUniqBean moduleInfo = getModuleInfo(module);
		if (moduleInfo != null) {
			DBSlotsBean slotBean = getOrInsertSlot(slot, moduleInfo.getSlotTypeId());
			insertUpdateShipSlot(pilotShip.getShipId(), slotBean.getSlotId(), null);
			result = insertOrUpdatePilotModule(pilotShip.getPilotShipId(), slotBean.getSlotId(), moduleInfo.getModuleId());
		}
		return result;
	}
	
	public static void swapShipModules(DBPilotsBean pilot, String ship, long linkShipId, String fromSlot, String fromModule, String toSlot, String toModule) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {

		DBPilotShipsBean pilotShip = getOrInsertPilotShip(pilot, ship.toLowerCase(), linkShipId, null, null, null, null);
		DBPilotModulesBean from = DbAccess.pilotModulesAccess.getPilotModuleByPilotShipIdAndModuleUniq(pilotShip.getPilotShipId(), fromSlot);
		DBPilotModulesBean to = DbAccess.pilotModulesAccess.getPilotModuleByPilotShipIdAndModuleUniq(pilotShip.getPilotShipId(), toSlot);
		
		Long fsid = from.getSlotId(); 
		from.setSlotId(to.getSlotId());
		to.setSlotId(fsid);
		if (from.getPilotModuleId() != null) {
			DbAccess.pilotModulesAccess.updateByPrimaryKey(from, from.getPilotModuleId());
		} else {
			updatePilotShipModule(pilot, ship, linkShipId, fromSlot, toModule);
		}
		
		if (to.getPilotModuleId() != null) {
			DbAccess.pilotModulesAccess.updateByPrimaryKey(to, to.getPilotModuleId());
		} else {
			updatePilotShipModule(pilot, ship, linkShipId, toSlot, fromModule);
		}
	}
	
	public static void removePilotShipModule(DBPilotsBean pilot, String ship, long linkShipId, String slot, String module) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBPilotShipsBean pilotShip = getOrInsertPilotShip(pilot, ship.toLowerCase(), linkShipId, null, null, null, null);
		DBByModuleInfoByUniqBean moduleInfo = getModuleInfo(module);
		if (moduleInfo != null) {
			DBSlotsBean slotBean = getOrInsertSlot(slot, moduleInfo.getSlotTypeId());
			insertUpdateShipSlot(pilotShip.getShipId(), slotBean.getSlotId(), null);
			insertOrUpdatePilotModule(pilotShip.getPilotShipId(), slotBean.getSlotId(), null);
		}
	}
	
	public static void updateCurrentShipPosition(DBPilotsBean pilot) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBPilotShipsBean pilotShip = DbAccess.pilotShipsAccess.getCurrentByPilotId(pilot.getPilotId());
		if (pilotShip != null) {
			Long stationId = null;
			DBLocationHistoryBean location = DbAccess.locationHistoryAccess.getDirectLastLocation(pilot.getPilotId());
			DBStationHistoryBean station = DbAccess.stationHistoryAccess.getDirectLastStation(pilot.getPilotId());
			if (location.getLocationTime().getTime() <= station.getStationTime().getTime()) {
				stationId = station.getStationId();
			}
			if (location != null) {
				pilotShip.setSystemId(location.getSystemId());
				pilotShip.setStationId(stationId);
				DbAccess.pilotShipsAccess.updateByPrimaryKey(pilotShip, pilotShip.getPilotShipId());
			}
		}
	}
	
	public static void insertStoredModule(DBPilotsBean pilot, String module, String system, BigInteger marketId, String engeneer, Integer grade) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBByModuleInfoByUniqBean moduleInfo = getModuleInfo(module);
		if (moduleInfo != null) {
			DBSystemsBean systemBean = SystemsDAO.getOrInsertSystem(system, null, null);
			DBStoredModulesBean bean = new DBStoredModulesBean();
			bean.setPilotId(pilot.getPilotId()).setModuleId(moduleInfo.getModuleId()).setSystemId(systemBean.getSystemId()).setMarketId(marketId);
			if (engeneer != null) {
				DBRecipiesBean recipie = getOrInsertRecipie(engeneer, null, null);
				bean.setRecipieId(recipie.getRecipieId()).setRecipieGrade(grade);
			}
			DbAccess.storedModulesAccess.insert(bean);
		}
	}
}
