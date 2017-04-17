package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.CrewLaunchFighterBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrewLaunchFighter extends AbstractJournalEvent<CrewLaunchFighterBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(CrewLaunchFighter.class);
	
	{
		beanClass = CrewLaunchFighterBean.class;
	}
	
	protected void processBean(CrewLaunchFighterBean bean) {
	}

}
	