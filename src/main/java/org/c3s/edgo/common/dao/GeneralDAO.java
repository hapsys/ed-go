package org.c3s.edgo.common.dao;

import javax.persistence.EntityManager;

import org.c3s.db.jpa.ManagerJPA;

public abstract class GeneralDAO {

	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = ManagerJPA.get("edgo", this.getClass());
		}
		return entityManager;
	}
	
	public GeneralDAO() {
	}
	
	public GeneralDAO(EntityManager em) {
		entityManager = em;
	}
	
}
