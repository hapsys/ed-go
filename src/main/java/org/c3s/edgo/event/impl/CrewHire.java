package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.CrewHireBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrewHire extends AbstractJournalEvent<CrewHireBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = CrewHireBean.class;
	}
	
	protected void processBean(CrewHireBean bean) {
	}

}
	