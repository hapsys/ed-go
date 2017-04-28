package org.c3s.edgo.event;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.c3s.edgo.common.beans.DBEventsBean;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventDispatcher {

	private static Logger logger = LoggerFactory.getLogger(EventDispatcher.class);
	
	
	private static Map<String, Integer> storedEventsNames = new HashMap<String, Integer>();
	private static Map<String, Integer> executeEventsNames = new HashMap<String, Integer>();
	
	static {
		storedEventsNames.put("cargo", null);
		storedEventsNames.put("loadout", null);
		storedEventsNames.put("materials", null);
		//
		executeEventsNames.put("loadgame", null);
	}
	
	private Map<String, DBEventsBean> storedEvents = new LinkedHashMap<>(); 
	
	private static Map<String, Class<? extends JournalEvent>> events = new ConcurrentHashMap<String, Class<? extends JournalEvent>>();
	
	ExecutorService service = Executors.newSingleThreadExecutor();
	
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
	
	/**
	 * @param eventName
	 * @param parameters
	 */
	public void dispatch(DBEventsBean evt) {
		
		String eventName = evt.getEventName().toLowerCase();
		
		if (storedEventsNames.containsKey(eventName) && !storedEvents.containsKey(eventName)) {
			storedEvents.put(eventName, evt);
		} else {
			
			/*
			if (!storedEvents.containsKey(eventName)) {
				storedEvents.remove(eventName);
			}
			*/
			
			Class<? extends JournalEvent> eventClass = events.get(eventName);
			if (eventClass != null) {
				
				JournalEvent event;
				try {
					event = eventClass.newInstance();
					service.execute(new Runnable() {
						@Override
						public void run() {
							event.process(evt);
						}
					});
					if (executeEventsNames.containsKey(eventName)) {
						for (String key: storedEvents.keySet()) {
							dispatch(storedEvents.get(key));
						}
						storedEvents.clear();
					}
					
				} catch (InstantiationException | IllegalAccessException e) {
					logger.warn("Create instance fail for class \"{}\"", eventClass.getName(), e);
				}  
				
			} else {
				logger.warn("No class for event \"{}\"", evt.getEventName());
			}
		}
	}
}
