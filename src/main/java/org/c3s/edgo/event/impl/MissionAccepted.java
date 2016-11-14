package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.MissionAcceptedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MissionAccepted extends AbstractJournalEvent<MissionAcceptedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = MissionAcceptedBean.class;
	}
	
	protected void processBean(MissionAcceptedBean bean) {
	}

}
	