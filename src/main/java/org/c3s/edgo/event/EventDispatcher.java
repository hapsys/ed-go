package org.c3s.edgo.event;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.c3s.edgo.common.entity.Event;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventDispatcher {

	private static Logger logger = LoggerFactory.getLogger(EventDispatcher.class);
	
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
	public void dispatch(Event evt) {
		Class<? extends JournalEvent> eventClass = events.get(evt.getEventName().toLowerCase());
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
			} catch (InstantiationException | IllegalAccessException e) {
				logger.warn("Create instance fail for class \"{}\"", eventClass.getName(), e);
			}  
			
		} else {
			logger.warn("No class for event \"{}\"", evt.getEventName());
		}
	}
}
