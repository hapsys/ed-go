package org.c3s.edgo.event;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventDispatcher {

	private static Logger logger = LoggerFactory.getLogger(EventDispatcher.class);
	
	private Map<String, JournalEvent> events = new HashMap<>();
	
	ExecutorService service = Executors.newSingleThreadExecutor();
	
	/**
	 * @param name
	 * @param event
	 */
	public void registerEvent(JournalEvent event, String name) {
		events.put(name.toLowerCase(), event);
		logger.info("Register event \"{}\" class \"{}\"", name, event.getClass().getName());
	}
	
	/**
	 * @param event
	 */
	public void registerEvent(JournalEvent event) {
		String clazz = event.getClass().getName();
		registerEvent(event, clazz.substring(clazz.lastIndexOf('.') + 1));
	}
	
	/**
	 * @param packageName
	 */
	public void registerEventPackage(String packageName) {
		
		Reflections reflections = new Reflections(packageName);
		/*
		Reflections reflections = new Reflections(new ConfigurationBuilder()
			.setUrls(ClasspathHelper.forPackage(packageName))
		    .setScanners(new SubTypesScanner(false))
		    //.filterInputsBy(new FilterBuilder().includePackage(packageName))
		);
		*/		
		
		//Set<Class<? extends JournalEvent>> events = reflections.getSubTypesOf(JournalEvent.class);
		@SuppressWarnings("rawtypes")
		Set<Class<? extends AbstractJournalEvent>> events = reflections.getSubTypesOf(AbstractJournalEvent.class);
		
		for (Class<? extends JournalEvent> clazz: events) {
			try {
				JournalEvent event = clazz.newInstance();
				registerEvent(event);
			} catch (InstantiationException | IllegalAccessException e) {
				logger.error("Error load event class \"{}\"", clazz.getName(), e);
			}
		}
	}
	
	/**
	 * @param parameters
	 */
	public void dispatch(Map<String, Object> parameters) {
		String eventName = (String)parameters.get("event");
		if (eventName != null) {
			dispatch(eventName, parameters);
		} else {
			logger.warn("No event found in \"{}\"", parameters);
		}
	}
	
	/**
	 * @param eventName
	 * @param parameters
	 */
	public void dispatch(String eventName, final Map<String, Object> parameters) {
		final JournalEvent event = events.get(eventName.toLowerCase());
		if (event != null) {
			service.execute(new Runnable() {
				@Override
				public void run() {
					event.process(parameters);
				}
			});
		} else {
			logger.warn("No class for event \"{}\"", eventName);
		}
	}
}
