/**
 * 
 */
package org.c3s.edgo.event;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBEventsBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBUsersBean;
import org.c3s.utils.JSONUtils;

/**
 * @author admin
 *
 */
public abstract class AbstractJournalEvent<T> implements JournalEvent {

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
				this.processBean(bean);
			} catch (RuntimeException e) {
				System.out.println(event.getEventName());
				System.out.println(event.getEventJson());
				e.printStackTrace();
				//throw e;
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
	
	protected DBPilotsBean getCurrent() {
		DBPilotsBean result = null;
		try {
			result = DbAccess.pilotsAccess.getCurrentByUserId(user.getUserId());
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			new RuntimeException(e);
		}
		return result;
	}
	
}
