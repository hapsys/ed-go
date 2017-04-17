package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.JoinACrewBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JoinACrew extends AbstractJournalEvent<JoinACrewBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(JoinACrew.class);
	
	{
		beanClass = JoinACrewBean.class;
	}
	
	protected void processBean(JoinACrewBean bean) {
	}

}
	