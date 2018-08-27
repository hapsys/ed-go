/**
 * 
 */
package org.c3s.edgo.event;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBEventsBean;
import org.c3s.edgo.common.beans.DBEventsHistoryBean;
import org.c3s.edgo.common.beans.DBPilotGameModesBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBUsersBean;
import org.c3s.utils.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author admin
 *
 */
public abstract class AbstractJournalEvent<T extends AbstractEventBean> implements JournalEvent {
	
	@SuppressWarnings("serial")
	private static Map<String, Integer> notClosedEvents = new HashMap<String, Integer>() {{
		put("CompanionApi", null);
		put("LoadGame", null);
		put("Cargo", null);
		put("Loadout", null);
		put("Materials", null);
	}};

	//protected static Map<Long, >
	
	//@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(AbstractJournalEvent.class);
	
	protected DBUsersBean user;
	protected Class<T> beanClass = null;
	
	public AbstractJournalEvent() {
		
	}
	/* (non-Javadoc)
	 * @see org.c3s.edgo.event.JournalEvent#process(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void process(DBEventsBean event) {
		
		try {
			user = DbAccess.usersAccess.getByPrimaryKey(event.getUserId());
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e1) {
			new RuntimeException(e1);
		} 
		//System.out.println(beanClass);
		if (this.beanClass != null) {
			try {
				String json = event.getEventJson();
				if ("CompanionApi".equals(event.getEventName())) {
					json = json.replaceAll("\\[\\]", "{}");
				}
				T bean = JSONUtils.fromJSON(json, this.beanClass);
				
				/**
				 * + Update game mode 
				 */
				DBPilotsBean pilot = getCurrent();
				if (pilot != null && !notClosedEvents.containsKey(bean.getEvent())  /* !"LoadGame".equals(bean.getEvent()) && !"CompanionApi".equals(bean.getEvent()) */) {
					DBPilotGameModesBean lastMode = DbAccess.pilotGameModesAccess.getLastByPilotId(pilot.getPilotId());
					if (lastMode != null) {
						if (lastMode.getModeEnd() == null || lastMode.getModeEnd().compareTo(bean.getTimestamp()) < 0) {
							lastMode.setModeEnd(new Timestamp(bean.getTimestamp().getTime()));
							DbAccess.pilotGameModesAccess.updateByPrimaryKey(lastMode, lastMode.getPilotGameModeId());
						}
					}
				}
				/**
				 * - Update game mode 
				 */
				if (DbAccess.eventsHistoryAccess.getByUserIdTimestampAndHash(event.getUserId(), new Timestamp(bean.getTimestamp().getTime()), event.getJsonMd5()) == null) {
					this.processBean(bean);
					/*
					 * +Add AMPQ event
					 */
					String[] bind = EventTag.getTags(event.getEventName());
					if (bind != null) {
						DispatcherAMQP.getInstance().fireEvent(bind, getCurrent().getPilotName());
					}
					/*
					 * -Add AMPQ event
					 */
					if ("CompanionApi".equals(event.getEventName())) {
						addEventHistory(event, new Date());
					} else {
						addEventHistory(event, bean.getTimestamp());
					}
				}
				DbAccess.eventsAccess.deleteByPrimaryKey(event.getEventId());
			} catch (RuntimeException | IllegalAccessException | InstantiationException | SQLException e) {
				logger.error("Error at event: {}", event.getEventName());
				logger.error("Error json: {}", event.getEventJson());
				//logger.error("See json pls. \n{}", (Object[])e.getStackTrace());
				logger.error("{}", e.getMessage(), e);
				// update Evnt Error Info
				event.setIsLocked(99);
				try {
					DbAccess.eventsAccess.updateByPrimaryKey(event, event.getEventId());
				} catch (IllegalArgumentException | IllegalAccessException | SQLException e1) {
					logger.error("{}", e1.getMessage(), e1);
				}
			}
		} else {
			processMap(JSONUtils.fromJSON(event.getEventJson(), HashMap.class));
		}
	}

	protected void processBean(T bean) {
		// Do nothing
		throw new RuntimeException();
	}
	
	protected void processMap(Map<String, Object> parameters) {
		// Do nothing
		throw new RuntimeException();
	}
	
	private DBPilotsBean currentPilot = null; 

	protected void setCurrent(DBPilotsBean currentPilot) {
		this.currentPilot = currentPilot;
	}
	
	protected DBPilotsBean getCurrent() {
		try {
			if (currentPilot == null) {
				currentPilot = DbAccess.pilotsAccess.getCurrentByUserId(user.getUserId());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			new RuntimeException(e);
		}
		return currentPilot;
	}
	
	private void addEventHistory(DBEventsBean event, Date timestamp) {
		try {
			
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				DBEventsHistoryBean bean = new DBEventsHistoryBean();
				bean.setPilotId(pilot.getPilotId());
				bean.setUserId(event.getUserId());
				bean.setEventName(event.getEventName());
				bean.setEventTimestamp(new Timestamp(timestamp.getTime()));
				bean.setEventHash(event.getJsonMd5());
				DbAccess.eventsHistoryAccess.insert(bean);
			}
			
		} catch (IllegalArgumentException | IllegalAccessException | SQLException e) {
			new RuntimeException(e);
		}
	}
	
}
