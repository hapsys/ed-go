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
		//user = em.find(User.class, event.getUserId());
		try {
			user = DbAccess.usersAccess.getByPrimaryKey(event.getUserId());
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e1) {
			new RuntimeException(e1);
		} 
		//System.out.println(beanClass);
		if (this.beanClass != null) {
			try {
				T bean = JSONUtils.fromJSON(event.getEventJson(), this.beanClass);
				/*
				 * TODO remove it!
				 */
				//bean.setTimestamp(new Date(bean.getTimestamp().getTime() + 10 * 3600));
				/*
				 * 
				 */
				this.processBean(bean);
				addEventHistory(bean.getEvent(), bean.getTimestamp());
			} catch (RuntimeException e) {
				logger.error("Error at event: {}", event.getEventName());
				logger.error("Error json: {}", event.getEventJson());
				logger.error("See json pls. \n{}", (Object[])e.getStackTrace());
				//e.printStackTrace();
			}
		} else {
			processMap(JSONUtils.fromJSON(event.getEventJson(), HashMap.class));
		}
		//em.remove(em.contains(event)?event:em.merge(event));
		try {
			DbAccess.eventsAccess.deleteByPrimaryKey(event.getEventId());
		} catch (SQLException e) {
			new RuntimeException(e);
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
	
	private void addEventHistory(String event, Date timestamp) {
		try {
			
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				DBEventsHistoryBean bean = new DBEventsHistoryBean();
				bean.setPilotId(pilot.getPilotId());
				bean.setEventName(event);
				bean.setEventTimestamp(new Timestamp(timestamp.getTime()));
				DbAccess.eventsHistoryAccess.insert(bean);
			}
			
		} catch (IllegalArgumentException | IllegalAccessException | SQLException e) {
			new RuntimeException(e);
		}
	}
	
}
