/**
 * 
 */
package org.c3s.edgo.event;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;

import org.c3s.db.jpa.ManagerJPA;
import org.c3s.edgo.common.entity.Event;
import org.c3s.edgo.common.entity.Pilot;
import org.c3s.edgo.common.entity.User;
import org.c3s.utils.JSONUtils;

/**
 * @author admin
 *
 */
public abstract class AbstractJournalEvent<T> implements JournalEvent {

	protected EntityManager em; // = ManagerJPA.get("edgo");
	protected User user;
	protected Class<T> beanClass = null;
	
	public AbstractJournalEvent() {
		
	}
	/* (non-Javadoc)
	 * @see org.c3s.edgo.event.JournalEvent#process(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void process(Event event) {
		em = ManagerJPA.get("edgo", "User+++"+event.getUserId());
		beginTrtansaction();
		user = em.find(User.class, event.getUserId()); 
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
		em.remove(em.contains(event)?event:em.merge(event));
		commitTransaction();
	}

	protected void processBean(T bean) {
		// Do nothing
		throw new RuntimeException();
	}
	
	protected void processMap(Map<String, Object> parameters) {
		// Do nothing
		throw new RuntimeException();
	}
	
	protected Pilot getCurrent() {
		Pilot result = em.createNamedQuery("Pilot.findByUserId", Pilot.class).setParameter("user_id", user.getUserId()).getResultList().stream().filter(p->p.getIsCurrent() != 0).findFirst().orElse(null);
		return result;
	}
	
	protected void beginTrtansaction() {
		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		};
	}
	protected void commitTransaction() {
		if (em.getTransaction().isActive()) {
			em.getTransaction().commit();
		};
	}
}
