package org.c3s.edgo.event;

import java.sql.SQLException;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBEventsBean;
import org.c3s.storage.StorageFactory;
import org.c3s.storage.StorageInterface;
import org.c3s.storage.StorageType;

public class EventProcessor implements Runnable {
	
	private long timeout = 600000L;

	StorageInterface storage = StorageFactory.getStorage(StorageType.APPLICATION);

	protected boolean processNextEvent() throws IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		//Event evt = em.createNamedQuery("Event.findUnlocked", Event.class).setMaxResults(1).getResultList().stream().findFirst().orElse(null);
		DBEventsBean evt = DbAccess.eventsAccess.getUnlockEvent(); 
		
		if (evt != null) {
			EventDispatcher dispatcher = (EventDispatcher) storage.get(evt.getUserId());
			if (dispatcher == null) {
				dispatcher = new EventDispatcher();
				storage.put(new Long(evt.getUserId()), dispatcher, timeout);
			} else {
				storage.updateExpire(new Long(evt.getUserId()), timeout);
			}
			evt.setIsLocked(1);
			DbAccess.eventsAccess.updateByPrimaryKey(evt, evt.getEventId());
			
			dispatcher.dispatch(evt);
		}
		
		return evt != null;
	}

	@Override
	public void run() {
		
		while(!stop) {
			
			boolean next = false;
			
			try {
				next = processNextEvent();
			} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e1) {
				e1.printStackTrace();
				stop = true;
			}
			
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
