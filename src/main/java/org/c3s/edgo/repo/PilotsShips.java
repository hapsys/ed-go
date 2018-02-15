package org.c3s.edgo.repo;

import java.sql.SQLException;
import java.util.List;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBPilotModulesListBean;
import org.c3s.edgo.common.beans.DBPilotShipsListBean;

public class PilotsShips {

	private Long pilot = null;
	private List<Long> modules = null;
	
	public PilotsShips(Long pilot, List<Long> modules) {
		this.pilot = pilot;
		this.modules = modules;
	}
	

	public List<DBPilotShipsListBean> getShips() throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		return DbAccess.pilotShipsAccess.getPilotShipsList(pilot);
	}
	
	public List<DBPilotShipsListBean> getShips(double x, double y, double z) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		
		List<DBPilotShipsListBean> ships = getShips();
		if (ships != null) {
			for (DBPilotShipsListBean ship: ships) {
				Double distance = Math.sqrt(Math.pow(x - ship.getX(), 2) + Math.pow(y - ship.getY(), 2) + Math.pow(z - ship.getZ(), 2));
				ship.setDistance(distance);
			}
		}
		return ships;
	}
	
	
	public List<DBPilotModulesListBean> getModules() throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		return DbAccess.pilotModulesAccess.getPilotModulesList(pilot);
	}
	
}
