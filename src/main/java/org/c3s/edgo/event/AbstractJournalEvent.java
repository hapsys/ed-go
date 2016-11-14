/**
 * 
 */
package org.c3s.edgo.event;

import java.util.Map;

import org.c3s.data.mapers.DataMapper;
import org.c3s.data.mapers.GeneralClassMapInfo;
import org.c3s.data.mapers.GeneralDataMapper;
import org.c3s.edgo.event.cast.CommonClassCast;

/**
 * @author admin
 *
 */
public abstract class AbstractJournalEvent<T> implements JournalEvent {

	protected DataMapper mapper = new GeneralDataMapper(new CommonClassCast(), GeneralClassMapInfo.class); 
	
	protected Class<T> beanClass = null;
	//private 
	/* (non-Javadoc)
	 * @see org.c3s.edgo.event.JournalEvent#process(java.util.Map)
	 */
	@Override
	public void process(Map<String, Object> parameters) {
		System.out.println(beanClass);
		if (this.beanClass != null) {
			try {
				T bean = this.beanClass.newInstance();
				mapper.mapFromRow(parameters, bean);
				this.processBean(bean);
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			processMap(parameters);
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
	
}
