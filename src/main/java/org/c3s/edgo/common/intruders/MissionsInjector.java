package org.c3s.edgo.common.intruders;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class MissionsInjector extends CommonInjector {

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	List<Long> pilots = null;
	String startDate = null;
	String endDate = null;
	List<Long> factions = null;
	List<Long> systems = null;
	
	public MissionsInjector(List<Long> pilots, Date startDate, Date endDate, List<Long> factions, List<Long> systems) {
		this.pilots = pilots;
		this.startDate = startDate == null? null: (dateFormat.format(startDate) + " 00:00:00");
		this.endDate = endDate == null? null: (dateFormat.format(endDate)  + " 23:59:59");
		this.factions = factions;
		this.systems = systems;
	}
	
	@Override
	public String getWhereQuery() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(this.inQuery("m.pilot_id", pilots));
		sb.append(this.inQuery("m.faction_id", factions));
		sb.append(this.inQuery("l.system_id", systems));
		sb.append(this.dateRange("m.complete_date", startDate, endDate));
		
		return sb.toString();
	}
}
