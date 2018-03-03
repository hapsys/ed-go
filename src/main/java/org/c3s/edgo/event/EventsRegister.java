package org.c3s.edgo.event;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.c3s.edgo.event.annotation.DateRangeAnnotation;
import org.c3s.edgo.event.annotation.EventAnnotation;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventsRegister {
	
	private static Logger logger = LoggerFactory.getLogger(EventsRegister.class);	

	private static Map<String, Map<EventDateRange, Class<? extends JournalEvent>>> events = new ConcurrentHashMap<String, Map<EventDateRange, Class<? extends JournalEvent>>>();
	
	/**
	 * @param name
	 * @param event
	 */
	public static void registerEvent(Class<? extends JournalEvent> event, String name) {
		String eventName = name.toLowerCase();
		EventAnnotation anno = event.getAnnotation(EventAnnotation.class);
		if (anno != null && anno.value().length() > 0) {
			eventName = anno.value().toLowerCase();
		}
		
		if (!events.containsKey(eventName)) {
			events.put(eventName, new ConcurrentHashMap<>());
		}
		
		DateRangeAnnotation drAnno = event.getAnnotation(DateRangeAnnotation.class);
		EventDateRange eventDateRange = null;
		if (drAnno != null) {
			eventDateRange = new EventDateRange(drAnno.start(), drAnno.end());
		} else {
			eventDateRange = new EventDateRange();
		}
		
		events.get(eventName).put(eventDateRange, event);
		
		logger.info("Register event \"{}\" class \"{}\" period \"{}\"", eventName, name, eventDateRange.toString());
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
	
	public static Class<? extends JournalEvent> getEventClass(String eventName, String eventTime) {
		
		Class<? extends JournalEvent> eventClass = null;
		
		Map<EventDateRange, Class<? extends JournalEvent>> eventRanges = events.get(eventName.toLowerCase()); 
		
		if (eventRanges != null) {
			
			for(EventDateRange range: eventRanges.keySet()) {
				if (range.compareRange(eventTime)) {
					eventClass = eventRanges.get(range);
					break;
				}
			}
			if (eventClass == null) {
				logger.warn("No period found for event \"{}\" time \"{}\"", eventName, eventTime);
			} 
		} else {
			logger.warn("No class found for event \"{}\"", eventName);
		}
		
		return eventClass;
	}
}
