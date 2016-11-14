package org.c3s.edgo.transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;

import org.c3s.annotations.Controller;
import org.c3s.db.jpa.ManagerJPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class TransactionController {

	//@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(TransactionController.class);
	
	EntityManager manager = ManagerJPA.get("edgo");
	EntityTransaction transaction = null; 
	
	public void start() {

		//manager.setFlushMode(FlushModeType.AUTO);
		
		transaction = manager.getTransaction();
		
		if (!transaction.isActive()) {
			transaction.begin();
		}
		//logger.debug("Transaction start");
	}
	
	public void commit() {
		
		transaction = manager.getTransaction();
		if (transaction.isActive()) {
			try {
				transaction.commit();
			} catch (Exception e) {
				logger.debug("Transaction rollback", e);
				transaction.rollback();
			}
		}
		//logger.debug("Transaction commit");
	}
}
