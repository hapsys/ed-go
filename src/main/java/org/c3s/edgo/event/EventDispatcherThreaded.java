package org.c3s.edgo.event;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBEventsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventDispatcherThreaded {

	private static Logger logger = LoggerFactory.getLogger(EventDispatcherThreaded.class);
	
	
	private static Map<String, Integer> storedEventsNames = new HashMap<String, Integer>();
	private static Map<String, Integer> executeEventsNames = new HashMap<String, Integer>();
	
	private static Map<EventDateRange, EventExecutors> executors = new HashMap<EventDateRange, EventExecutors>();
	
	static {
		storedEventsNames.put("cargo", null);
		storedEventsNames.put("loadout", null);
		storedEventsNames.put("materials", null);
		//
		executeEventsNames.put("loadgame", null);
		executeEventsNames.put("docked", null);
		//
		executors.put(new EventDateRange("2018-02-27T15:00:00Z" /* End Date */), new EventExecutors(storedEventsNames, executeEventsNames));
	}
	
	Long userId = 0L;
	
	public EventDispatcherThreaded(Long userId) {
		this.userId = userId;
	}
	
	/**
	 * @param eventName
	 * @param parameters
	 */
	public void dispatch() {
		
		DBEventsBean event;
		try {
			while ((event = DbAccess.eventsAccess.getUnlockEventForUserId(userId, 0)) != null) {
				String eventName = event.getEventName().toLowerCase();
				//String eventTime = RegexpUtils.preg_replace("~\"timestamp\"=\"[^]^$~isu", input, by) event.getEventJson();
				String eventTime = event.getEventJson().substring(15, 35);
				
				
				EventExecutors current = null;
				
				for (EventDateRange extDate: executors.keySet()) {
					if (extDate.compareRange(eventTime)) {
						current = executors.get(extDate);
						break;
					}
				}
				
				if (current == null) {
					event.setIsLocked(1);
					DbAccess.eventsAccess.updateByPrimaryKey(event, event.getEventId());
					processEvent(event);
				} else {
					if (current.getStoredEventsNames().containsKey(eventName)) {
						event.setIsLocked(2);
						DbAccess.eventsAccess.updateByPrimaryKey(event, event.getEventId());
					} else {
						event.setIsLocked(1);
						DbAccess.eventsAccess.updateByPrimaryKey(event, event.getEventId());
						processEvent(event);
						if (current.getExecuteEventsNames().containsKey(eventName)) {
							DBEventsBean stored;
							while ((stored = DbAccess.eventsAccess.getUnlockEventForUserId(userId, 2)) != null) {
								stored.setIsLocked(1);
								DbAccess.eventsAccess.updateByPrimaryKey(stored, stored.getEventId());
								processEvent(stored);
							}
						}
					}
				}
				
				Thread.sleep(1);
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void processEvent(DBEventsBean evt) {
		EventMd5Transform.eventTransformMD5(evt);
		//String eventName = evt.getEventName().toLowerCase();
		String eventTime = evt.getEventJson().substring(15, 35);
		
		Class<? extends JournalEvent> eventClass = EventsRegister.getEventClass(evt.getEventName(), eventTime);
		
		if (eventClass != null) {
			JournalEvent event = null;
			try {
				event = eventClass.newInstance();
				event.process(evt);
			} catch (InstantiationException | IllegalAccessException e) {
				logger.warn("Create instance fail for class \"{}\"", eventClass.getName(), e);
			}
		} else {
			logger.warn("No class found for event \"{}\"", evt.getEventName());
		}
		
	}
}
