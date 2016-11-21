package org.c3s.edgo.event;

import javax.persistence.EntityManager;

import org.c3s.db.jpa.ManagerJPA;
import org.c3s.edgo.common.dao.EventDAO;
import org.c3s.edgo.common.entity.Event;
import org.c3s.storage.StorageFactory;
import org.c3s.storage.StorageInterface;
import org.c3s.storage.StorageType;

public class EventProcessor implements Runnable {
	
	private long timeout = 600000L;

	StorageInterface storage = StorageFactory.getStorage(StorageType.APPLICATION);
	EntityManager em = ManagerJPA.get("edgo", EventProcessor.class);

	protected boolean processNextEvent() {
		//Event evt = em.createNamedQuery("Event.findUnlocked", Event.class).setMaxResults(1).getResultList().stream().findFirst().orElse(null);
		Event evt = new EventDAO(em).getUnlockEvent();
		
		if (evt != null) {
			EventDispatcher dispatcher = (EventDispatcher) storage.get(evt.getUserId());
			if (dispatcher == null) {
				dispatcher = new EventDispatcher();
				storage.put(new Long(evt.getUserId()), dispatcher, timeout);
			} else {
				storage.updateExpire(new Long(evt.getUserId()), timeout);
			}
			em.getTransaction().begin();
			evt.setIsLocked((byte)1);
			em.merge(evt);
			em.getTransaction().commit();
			
			dispatcher.dispatch(evt);
		}
		
		return evt != null;
	}

	@Override
	public void run() {
		
		while(!stop) {
			
			boolean next = processNextEvent();
			
			try {
				if (next) {
						Thread.sleep(1);
				} else {
					Thread.sleep(1000);
					storage.clearExpired();
				}
			} catch (InterruptedException e) {
				stop = true;
			}
			
		}
		
	}
	
	private boolean stop = false;
	
	public void abort() {
		stop = true;
	}
}
