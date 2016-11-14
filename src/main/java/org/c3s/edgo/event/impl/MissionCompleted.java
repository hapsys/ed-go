package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.MissionCompletedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MissionCompleted extends AbstractJournalEvent<MissionCompletedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = MissionCompletedBean.class;
	}
	
	protected void processBean(MissionCompletedBean bean) {
	}

}
	