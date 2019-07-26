package org.c3s.edgo.event.impl;
	
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBLastLocationForPilotBean;
import org.c3s.edgo.common.beans.DBPilotShipsListBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBStationsBean;
import org.c3s.edgo.common.beans.DBSystemsBean;
import org.c3s.edgo.common.dao.LocationDAO;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.common.dao.SystemsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.StoredShipsBean;
import org.c3s.edgo.event.impl.beans.intl.StoredShipsHere;
import org.c3s.edgo.event.impl.beans.intl.StoredShipsRemote;
import org.c3s.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StoredShips extends AbstractJournalEvent<StoredShipsBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(StoredShips.class);
	
	{
		beanClass = StoredShipsBean.class;
	}
	
	protected void processBean(StoredShipsBean bean) {
		
		try {
			/**
			 * Set current pilot ship
			 */
			DBPilotsBean current = getCurrent();
			if (current != null) {
				//DBLastLocationForPilotBean location = DbAccess.locationHistoryAccess.getLastLocationForPilot(current.getPilotId());
				Map<String, DBSystemsBean> systems = new HashMap<String, DBSystemsBean>();
				Map<BigInteger, DBStationsBean> stations = new HashMap<BigInteger, DBStationsBean>();
				
				DBSystemsBean currSystem = SystemsDAO.getOrInsertSystem(bean.getStarSystem(), null, null);
				DBStationsBean currStation =  SystemsDAO.getOrInsertStation(currSystem.getSystemId(), bean.getStationName(), bean.getMarketID(), null, null);

				//DBPilotShipsListBean ship;
				Map<Object, List<DBPilotShipsListBean>> ships = Utils.getArrayGrouped(DbAccess.pilotShipsAccess.getPilotShipsList(current.getPilotId()), "linkShipId");
				
				// Update current station ship location 
				if (bean.getShipsHere() != null) {
					for (StoredShipsHere here: bean.getShipsHere()) {
						Long shipId = Long.valueOf(here.getShipID());
						if (ships.containsKey(shipId)) {
							DBPilotShipsListBean ship = ships.get(shipId).get(0);
							if (!currSystem.getSystemId().equals(ship.getSystemId()) || !currStation.getStationId().equals(ship.getStationId())) {
								DbAccess.pilotShipsAccess.updatePilotShipLocation(currSystem.getSystemId(), currStation.getStationId(), current.getPilotId(), Long.valueOf(here.getShipID()));
							}
						} else {
							ShipsDAO.getOrInsertPilotShip(current, here.getShipType().toLowerCase(), here.getShipID(), currSystem.getSystemId(), currStation.getStationId(), here.getName(), null);
						}
					}
				}
				
				// Update remote ship location
				if (bean.getShipsRemote() != null) {
					for (StoredShipsRemote remote: bean.getShipsRemote()) {
						if (!remote.isInTransit()) {
							Long shipId = Long.valueOf(remote.getShipID());
							if (ships.containsKey(shipId)) {
								DBPilotShipsListBean ship = ships.get(shipId).get(0);
								DBSystemsBean system = systems.get(remote.getStarSystem().toLowerCase());
								if (system == null) {
									system = SystemsDAO.getOrInsertSystem(remote.getStarSystem(), null, null);
									systems.put(remote.getStarSystem().toLowerCase(), system);
								}
								if (!ship.getSystemId().equals(system.getSystemId())) {
									DBStationsBean station = stations.get(remote.getShipMarketID());
									if (station == null) {
										station = DbAccess.stationsAccess.getByMarketId(remote.getShipMarketID());
										if (station != null) {
											stations.put(remote.getShipMarketID(), station);
										}
									}
									DbAccess.pilotShipsAccess.updatePilotShipLocation(system.getSystemId(), station == null? null:station.getStationId(), current.getPilotId(), Long.valueOf(remote.getShipID()));
								}
							} else {
								DBSystemsBean system = SystemsDAO.getOrInsertSystem(remote.getStarSystem(), null, null);
								DBStationsBean station = DbAccess.stationsAccess.getByMarketId(remote.getShipMarketID());
								ShipsDAO.getOrInsertPilotShip(current, remote.getShipType().toLowerCase(), remote.getShipID(), system.getSystemId(), station == null? null:station.getStationId(), remote.getName(), null);
							}
						}
					}
				}
				
				
				//throw new Exception();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		
	}

}
	