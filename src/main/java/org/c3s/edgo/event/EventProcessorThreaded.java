package org.c3s.edgo.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBEventUsersBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventProcessorThreaded implements Runnable {
	
	private static Logger logger = LoggerFactory.getLogger(EventProcessorThreaded.class);

	private Map<Long, Thread> threads = new ConcurrentHashMap<>(); 
	
	@Override
	public void run() {
		
		boolean started = false;
		
		while(!stop) {
			try {
				
				Set<Long> uidx = threads.keySet();
				
				for(Long userId: uidx) {
					Thread thread = threads.get(userId);
					if (!thread.isAlive()) {
						threads.remove(userId);
						logger.debug("Remove dispatcher for user #" + userId);
					}
				}
				
				List<DBEventUsersBean> users = DbAccess.eventsAccess.getEventUsers();
				
				if (!started && (users != null || threads.size() > 0)) {
					logger.info("Read EVENTS from DB");
					started = true;
				} else if (started && users == null && threads.size() == 0) {
					logger.info("No EVENTS in DB");
					started = false;
				}  
				
				if (users != null) {
					for (DBEventUsersBean user : users) {
						Thread thread = threads.get(user.getUserId());
						if (thread == null) {
							logger.debug("Start dispatcher for user #" + user.getUserId());
							thread = new Thread(new Runnable() {
								@Override
								public void run() {
									new EventDispatcherThreaded(user.getUserId()).dispatch();
								}
							});
							threads.put(user.getUserId(), thread);
							thread.start();
						}
					}
				}
				Thread.sleep(500);
			} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException | InterruptedException e) {
				// TODO Auto-generated catch block
				abort();
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
			
		}
	}
	
	private boolean stop = false;
	
	public void abort() {
		stop = true;
	}
}
