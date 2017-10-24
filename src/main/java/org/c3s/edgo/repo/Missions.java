/**
 * 
 */
package org.c3s.edgo.repo;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBCommoditiesBean;
import org.c3s.edgo.common.beans.DBMaterialsBean;
import org.c3s.edgo.common.beans.DBMissionsComplitedListByPilotsBean;
import org.c3s.edgo.common.beans.DBMissionsDateRangeBean;
import org.c3s.edgo.common.beans.DBMissionsFactionsListBean;
import org.c3s.edgo.common.beans.DBMissionsSystemsListBean;
import org.c3s.edgo.common.intruders.InInjector;
import org.c3s.edgo.common.intruders.MissionsInjector;

/**
 * @author admin
 *
 */
public class Missions {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");	
	
	private List<Long> pilots = null;
	private Date startDate = null;
	private Date endDate = null;
	private List<Long> factions = null;
	private List<Long> systems = null;

	private List<DBMissionsComplitedListByPilotsBean> missions = null;
	
	private List<DBMissionsFactionsListBean> missions_factions = null;
	private List<DBMissionsSystemsListBean> missions_systems = null;
	
	private List<DBMaterialsBean> materials = null;
	private List<DBCommoditiesBean> commodities = null;
	
	public Missions(List<Long> pilots, String startDate, String endDate, List<Long> factions, List<Long> systems) {
		
		this.pilots = pilots;
		this.factions = factions;
		this.systems = systems;

		
		try {
			this.startDate = startDate == null? null: dateFormat.parse(startDate);
		} catch (ParseException e) {
		}
		try {
			this.endDate = endDate == null? null: dateFormat.parse(endDate);
		} catch (ParseException e) {
		}
	
		if (this.startDate != null && this.endDate != null) {
			if (this.startDate.compareTo(this.endDate) > 0) {
				Date tmp = this.endDate;
				this.endDate = this.startDate;
				this.startDate = tmp;
			}
		}
		
	}
	

	public static DBMissionsDateRangeBean getMinMaxDate(List<Long> pilots) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		
		DBMissionsDateRangeBean minmax = null; 
		
		List<DBMissionsDateRangeBean> list = DbAccess.missionsAccess.getMissionsDateRange(new InInjector("m.pilot_id", pilots));
		
		if (list != null) {
			
			minmax = new DBMissionsDateRangeBean();

			minmax.setMinDate(
				list.stream().min((x,y) -> x.getMinDate().compareTo(y.getMinDate())).get().getMinDate()
			);
			minmax.setMaxDate(
				list.stream().max((x,y) -> x.getMaxDate().compareTo(y.getMaxDate())).get().getMaxDate()
			);
			
		}
		
		return minmax;
	}
	
	
	public List<DBMissionsComplitedListByPilotsBean> getMissions() throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		
		if (missions == null) {
			missions = DbAccess.missionsAccess.getMissionsComplitedListByPilots(new MissionsInjector(pilots, startDate, endDate, factions, systems));
			
			if (missions != null) {
				
				List<Object> mat_in = new ArrayList<>();
				List<Object> com_in = new ArrayList<>();
				
				for (DBMissionsComplitedListByPilotsBean mission: missions) {
					if (mission.getCommodityIdx() != null) {
						String[] cidxs = mission.getCommodityIdx().split(",");
						mission.setCommodityId(new Integer[cidxs.length]);
						int i = 0;
						for (String cid: cidxs) {
							Integer val = new Integer(cid);
							mission.getCommodityId()[i] = val;
							com_in.add(val);
							i++;
						}
					}
					if (mission.getMaterialIdx() != null) {
						String[] cidxs = mission.getMaterialIdx().split(",");
						mission.setMaterialId(new Integer[cidxs.length]);
						int i = 0;
						for (String cid: cidxs) {
							Integer val = new Integer(cid);
							mission.getMaterialId()[i] = val;
							mat_in.add(val);
							i++;
						}
					}
				}
				
				if (com_in.size() > 0) {
					InInjector injectorCom = new InInjector("commodity_id", com_in);
					commodities = DbAccess.commoditiesAccess.getCommoditiesList(injectorCom);
				}
				if (mat_in.size() > 0) {
					InInjector injectorCom = new InInjector("material_id", mat_in);
					materials = DbAccess.materialsAccess.getMaterialsList(injectorCom);
				}
			}
			
		}
		return missions;
	}


	public List<DBMaterialsBean> getMaterials() {
		return materials;
	}


	public List<DBCommoditiesBean> getCommodities() {
		return commodities;
	}


	public List<DBMissionsFactionsListBean> getFactions() throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		
		if (missions_factions == null) {
			missions_factions =  DbAccess.missionsAccess.getMissionsFactionsList(new InInjector("m.pilot_id", pilots));
		}
		
		return missions_factions;
	}
	
	public List<DBMissionsSystemsListBean> getSystems() throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		
		if (missions_systems == null) {
			missions_systems =  DbAccess.missionsAccess.getMissionsSystemsList(new InInjector("m.pilot_id", pilots));
		}
		
		return missions_systems;
	}
}
