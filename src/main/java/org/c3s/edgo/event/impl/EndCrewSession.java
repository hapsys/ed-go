package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.EndCrewSessionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndCrewSession extends AbstractJournalEvent<EndCrewSessionBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(EndCrewSession.class);
	
	{
		beanClass = EndCrewSessionBean.class;
	}
	
	protected void processBean(EndCrewSessionBean bean) {
	}

}
	