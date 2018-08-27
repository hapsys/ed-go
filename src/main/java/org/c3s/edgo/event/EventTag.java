/**
 * 
 */
package org.c3s.edgo.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 *
 */
public class EventTag {

	private static final Map<String, String[]> tag2events = new HashMap<>();
	static {
		tag2events.put("user-info", new String[] {"Location", "Docked", "FSDJump", "Liftoff", "SupercruiseEntry", "SupercruiseExit", "Touchdown", "Undocked"});
	}
	private static final Map<String, String[]> events2tags = new HashMap<>(); 
	static {
		Map<String, List<String>> events = new HashMap<>(); 
		for (String tag: tag2events.keySet()) {
			for (String event: tag2events.get(tag)) {
				event = event.toLowerCase();
				if (!events.containsKey(event)) {
					events.put(event, new ArrayList<>());
				}
				events.get(event).add(tag);
			}
		}
		for (String event: events.keySet()) {
			events2tags.put(event, events.get(event).stream().toArray(String[]::new));
		}
	}
	
	
	public static String[] getTags(String eventname) {
		return events2tags.get(eventname.toLowerCase());
	}
}
