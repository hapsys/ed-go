package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.CrewAssignBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrewAssign extends AbstractJournalEvent<CrewAssignBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = CrewAssignBean.class;
	}
	
	protected void processBean(CrewAssignBean bean) {
	}

}
	