package org.c3s.edgo.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.c3s.edgo.common.entity.Event;

public class EventDAO extends GeneralDAO {

	public EventDAO(EntityManager em) {
		super(em);
	}
	
	public Event getUnlockEvent() {
		Event result = null;
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Event> criteriaQuery = criteriaBuilder.createQuery(Event.class);
		Root<Event> from = criteriaQuery.from(Event.class);
		criteriaQuery.select(from);
		criteriaQuery.where(criteriaBuilder.equal(from.get("isLocked"), 0));
		criteriaQuery.orderBy(criteriaBuilder.asc(from.get("eventId")));
		
		result = getEntityManager().createQuery(criteriaQuery).setMaxResults(1).getResultList().stream().findFirst().orElse(null);
		
		return result;
	}
}
