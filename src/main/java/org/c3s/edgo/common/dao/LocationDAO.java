package org.c3s.edgo.common.dao;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.c3s.edgo.common.entity.LocationHistory;
import org.c3s.edgo.common.entity.StarSystem;
import org.c3s.edgo.common.entity.Station;
import org.c3s.utils.RegexpUtils;
import org.hibernate.CacheMode;
import org.hibernate.ejb.QueryHints;

public class LocationDAO extends GeneralDAO {

	public LocationDAO(EntityManager em) {
		super(em);
	}
	
	public LocationHistory getLastLocation(int pilot_id) {
		LocationHistory result = null;
		
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<LocationHistory> criteriaQuery = criteriaBuilder.createQuery(LocationHistory.class);
		Root<LocationHistory> from = criteriaQuery.from(LocationHistory.class);
		criteriaQuery.select(from);
		criteriaQuery.where(criteriaBuilder.equal(from.get("pilotId"), pilot_id));
		criteriaQuery.orderBy(criteriaBuilder.desc(from.get("locationTime")));
		
		result = getEntityManager().createQuery(criteriaQuery).setHint(QueryHints.HINT_CACHE_MODE, CacheMode.PUT).setMaxResults(1).getResultList().stream().findFirst().orElse(null);
		//result = getEntityManager().createQuery(criteriaQuery).setHint(QueryHints.HINT_CACHEABLE, false).setMaxResults(1).getResultList().stream().findFirst().orElse(null);
		/*
		result = getEntityManager().createNamedQuery("LocationHistory.findLastByPilotId", LocationHistory.class).setParameter("pilot_id", pilot_id).setMaxResults(1).getResultList().stream().findFirst().orElse(null);
		*/
		
		return result;
	}
	
	public void insertLocation(int pilot_id, Date timestamp, String system, Float[] coord, String station) {
		String sysuniq = RegexpUtils.preg_replace("~[^0-9a-z]~isu", system.toLowerCase(), "");
		String stauniq = null;
		
		StarSystem starSystem = getEntityManager().createNamedQuery("StarSystem.findByUniq", StarSystem.class).setParameter("uniq", sysuniq).getResultList().stream().findFirst().orElse(null);
		
		if (starSystem == null) {
			starSystem = new StarSystem();
			starSystem.setName(system);
			if (coord != null && coord.length == 3) {
				starSystem.setX(coord[0]);
				starSystem.setY(coord[1]);
				starSystem.setZ(coord[2]);
			}
			starSystem.setIsPopulated((byte)0);
			starSystem.setNameUniq(sysuniq);
			getEntityManager().persist(starSystem);
		}

		Station stat = null;
		if (station != null) {
			stauniq = RegexpUtils.preg_replace("~[\\s]~isu", station.toLowerCase(), "");
			stat = getEntityManager().createNamedQuery("Station.findByUniq", Station.class).setParameter("uniq", stauniq).getResultList().stream().findFirst().orElse(null);
		}
		
		
		LocationHistory prev = getLastLocation(pilot_id);
		if (prev != null) {
			System.out.println("Prev Station: " + (prev.getStation() == null?"null":prev.getStation().getStationId()));
			System.out.println("Prev System: " + prev.getSystem().getSystemId());
		}
		System.out.println("Station: " + (stat == null?"null":stat.getStationId()));
		System.out.println("System: " + starSystem.getSystemId());
		
		if (prev == null || prev.getSystem().getSystemId() != starSystem.getSystemId() || prev.getStation() != null && stat == null || prev.getStation() == null && stat != null || prev.getStation() != null && stat != null && prev.getStation().getStationId() != stat.getStationId()) {
			LocationHistory history = new LocationHistory();
			history.setPilotId(pilot_id);
			history.setLocationTime(new Timestamp(timestamp.getTime()));
			history.setStation(stat);
			history.setSystem(starSystem);
			getEntityManager().persist(history);
		}
	}
}
