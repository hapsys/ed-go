package org.c3s.edgo.event;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBEventsBean;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventDispatcherThreaded {

	private static Logger logger = LoggerFactory.getLogger(EventDispatcherThreaded.class);
	
	
	private static Map<String, Integer> storedEventsNames = new HashMap<String, Integer>();
	private static Map<String, Integer> executeEventsNames = new HashMap<String, Integer>();
	
	static {
		storedEventsNames.put("cargo", null);
		storedEventsNames.put("loadout", null);
		storedEventsNames.put("materials", null);
		//
		executeEventsNames.put("loadgame", null);
		executeEventsNames.put("docked", null);
	}
	
	private static Map<String, Class<? extends JournalEvent>> events = new ConcurrentHashMap<String, Class<? extends JournalEvent>>();
	
	/**
	 * @param name
	 * @param event
	 */
	public static void registerEvent(Class<? extends JournalEvent> event, String name) {
		events.put(name.toLowerCase(), event);
		logger.info("Register event \"{}\" class \"{}\"", name, event.getName());
	}
	
	/**
	 * @param event
	 */
	public static void registerEvent(Class<? extends JournalEvent> event) {
		String clazz = event.getName();
		registerEvent(event, clazz.substring(clazz.lastIndexOf('.') + 1));
	}
	
	/**
	 * @param packageName
	 */
	public static void registerEventPackage(String packageName) {
		
		Reflections reflections = new Reflections(packageName);
		@SuppressWarnings("rawtypes")
		Set<Class<? extends AbstractJournalEvent>> events = reflections.getSubTypesOf(AbstractJournalEvent.class);
		
		for (Class<? extends JournalEvent> clazz: events) {
			registerEvent(clazz);
		}
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
				//System.out.println(eventName);
				if (storedEventsNames.containsKey(eventName)) {
					event.setIsLocked(2);
					DbAccess.eventsAccess.updateByPrimaryKey(event, event.getEventId());
				} else {
					event.setIsLocked(1);
					DbAccess.eventsAccess.updateByPrimaryKey(event, event.getEventId());
					processEvent(event);
					if (executeEventsNames.containsKey(eventName)) {
						DBEventsBean stored;
						while ((stored = DbAccess.eventsAccess.getUnlockEventForUserId(userId, 2)) != null) {
							stored.setIsLocked(1);
							DbAccess.eventsAccess.updateByPrimaryKey(stored, stored.getEventId());
							processEvent(stored);
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
		String eventName = evt.getEventName().toLowerCase();
		Class<? extends JournalEvent> eventClass = events.get(eventName);
		if (eventClass != null) {
				JournalEvent event;
			try {
				event = eventClass.newInstance();
				event.process(evt);
			} catch (InstantiationException | IllegalAccessException e) {
				logger.warn("Create instance fail for class \"{}\"", eventClass.getName(), e);
			}  
			
		} else {
			logger.warn("No class for event \"{}\"", evt.getEventName());
		}
		
	}
}
