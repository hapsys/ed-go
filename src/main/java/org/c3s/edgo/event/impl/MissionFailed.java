package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.MissionFailedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MissionFailed extends AbstractJournalEvent<MissionFailedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = MissionFailedBean.class;
	}
	
	protected void processBean(MissionFailedBean bean) {
	}

}
	