package org.c3s.edgo.event;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBEventUsersBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.openhft.affinity.AffinityStrategies;
import net.openhft.affinity.AffinityThreadFactory;

public class EventProcessorThreaded implements Runnable {
	
	private static Logger logger = LoggerFactory.getLogger(EventProcessorThreaded.class);

	//private Map<Long, Thread> threads = new ConcurrentHashMap<>();
	private Map<Long, Future<Integer>> futures = new HashMap<>(); 
	
	@Override
	public void run() {
		
		boolean started = false;
		//ExecutorService executorService = Executors.newCachedThreadPool(new AffinityThreadFactory("bg", AffinityStrategies.ANY));
		ExecutorService executorService = Executors.newFixedThreadPool(100, new AffinityThreadFactory("bg", AffinityStrategies.ANY));
		
		while(!stop) {
			try {
				
				//Set<Long> uidx = threads.keySet();
				Set<Long> uidx = futures.keySet();
				
				for(Long userId: uidx) {
					Future<Integer> future = futures.get(userId);
					if (future.isDone()) {
						futures.remove(userId);
						logger.debug("Remove dispatcher for user #" + userId);
					}
					/*
					if (!thread.isAlive()) {
						threads.remove(userId);
						logger.debug("Remove dispatcher for user #" + userId);
					}
					*/
				}
				
				List<DBEventUsersBean> users = DbAccess.eventsAccess.getEventUsers();
				
				if (!started && (users != null || futures.size() > 0)) {
					logger.info("Read EVENTS from DB");
					started = true;
				} else if (started && users == null && futures.size() == 0) {
					logger.info("No EVENTS in DB");
					started = false;
				}  
				
				if (users != null) {
					for (DBEventUsersBean user : users) {
						//Thread thread = threads.get(user.getUserId());
						Future<Integer> future = futures.get(user.getUserId());
						if (future == null) {
							logger.debug("Start dispatcher for user #" + user.getUserId());
							/*
							thread = new Thread(new Runnable() {
								@Override
								public void run() {
									new EventDispatcherThreaded(user.getUserId()).dispatch();
								}
							});
							threads.put(user.getUserId(), thread);
							thread.start();
							*/
							Callable<Integer> thread = new Callable<Integer>() {
								@Override
								public Integer call() throws Exception {
									new EventDispatcherThreaded(user.getUserId()).dispatch();
									return 1;
								}
								
							};
							futures.put(user.getUserId(), executorService.submit(thread));
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
			executorService.shutdown();
			logger.info("Shutdown Event Processor");
		}
	}
	
	private boolean stop = false;
	
	public void abort() {
		stop = true;
	}
}
